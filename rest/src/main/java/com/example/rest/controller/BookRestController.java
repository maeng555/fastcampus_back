package com.example.rest.controller;

import com.example.rest.entity.Book;
import com.example.rest.entity.BookImage;
import com.example.rest.entity.BookPayloadDTO;
import com.example.rest.entity.BookViewDTO;
import com.example.rest.service.BookImageService;
import com.example.rest.service.BookService;
import com.example.rest.util.ImageUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.coyote.Response;
import org.apache.tomcat.util.http.parser.HttpHeaderParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;




@RestController
@RequestMapping("/api")
@Tag(name = "Book Controller", description = "책을 관리하는 컨트롤러")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookImageService bookImageService;

    @Value("${upload.path}")
    private String uploadPath;

    // 책 추가
    @PostMapping(value = "books", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "400", description = "Please add valid name and description")
    @ApiResponse(responseCode = "200", description = "Book added")
    @Operation(summary = "Add a Book")
    public ResponseEntity<BookViewDTO> addBook(@Valid @RequestBody BookPayloadDTO bookPayloadDTO) {
        try {
            Book book = new Book();
            book.setSubject(bookPayloadDTO.getSubject());
            book.setPrice(bookPayloadDTO.getPrice());
            book.setAuthor(bookPayloadDTO.getAuthor());
            book.setPage(bookPayloadDTO.getPage());
            bookService.save(book);

            BookViewDTO bookViewDTO = new BookViewDTO(book.getId(), book.getSubject(), book.getPrice(),
                    book.getPage(), book.getAuthor(), book.getCreatedAt());
            return ResponseEntity.ok(bookViewDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // 책 목록 조회
    @GetMapping(value = "/books", produces = "application/json")
    @ApiResponse(responseCode = "200", description = "List of books")
    @Operation(summary = "List book API")
    public List<BookViewDTO> books() {
        List<BookViewDTO> books = new ArrayList<>();
        for (Book book : bookService.findAll()) {
            books.add(new BookViewDTO(book.getId(), book.getSubject(), book.getPrice(), book.getAuthor(),
                    book.getPage(), book.getCreatedAt()));
        }
        return books;
    }

    // 책 상세 조회
    @GetMapping(value = "/books/{id}", produces = "application/json")
    @ApiResponse(responseCode = "200", description = "해당 책만 출력")
    @Operation(summary = "Book id API")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Book> optionalBook = bookService.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            BookViewDTO bookViewDTO = new BookViewDTO(book.getId(), book.getSubject(), book.getPrice(),
                    book.getAuthor(), book.getPage(), book.getCreatedAt());
            return ResponseEntity.ok(bookViewDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // 책 업데이트
    @PutMapping(value = "/books/{id}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "400", description = "Please add valid name and description")
    @ApiResponse(responseCode = "204", description = "Book updated")
    @Operation(summary = "Update a Book")
    public ResponseEntity<?> updateBook(@Valid @RequestBody BookPayloadDTO bookPayloadDTO, @PathVariable Long id) {
        Optional<Book> optionalBook = bookService.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setSubject(bookPayloadDTO.getSubject());
            book.setPrice(bookPayloadDTO.getPrice());
            book.setAuthor(bookPayloadDTO.getAuthor());
            book.setPage(bookPayloadDTO.getPage());
            book = bookService.save(book);

            BookViewDTO bookViewDTO = new BookViewDTO(book.getId(), book.getSubject(), book.getPrice(),
                    book.getAuthor(), book.getPage(), book.getCreatedAt());
            return ResponseEntity.ok(bookViewDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // 책 삭제
    @DeleteMapping(value = "/books/{id}", produces = "application/json")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        Optional<Book> optionalBook = bookService.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            bookService.delete(book);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(null); // 202
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // 파일 업로드 API
    @PostMapping(value = "/{book_id}/{type}/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<?> imagesUpload(@RequestPart(required = true) MultipartFile[] files,
                                          @PathVariable Long book_id, @PathVariable int type) {

        Optional<Book> optionalBook = bookService.findById(book_id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            List<String> successImageNames = new ArrayList<>();
            List<String> errorImageNames = new ArrayList<>();
            Arrays.asList(files).forEach(file -> {
                String contentType = file.getContentType();
                // JPEG, PNG 등만 허용
                if (contentType != null && (contentType.equals("image/png") || contentType.equals("image/jpeg") || contentType.equals("image/jpg"))) {
                    try {
                        String fileName = file.getOriginalFilename();
                        String generatedString = RandomStringUtils.random(10, true, true);
                        String newImageName = (type == 1 ? "thumb" : "") + generatedString + fileName;
                        String absoluteFileLocation = ImageUtil.makePath(uploadPath, newImageName, book_id);
                        Path path = Paths.get(absoluteFileLocation);

                        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                        // 데이터베이스에 이미지 정보 저장
                        BookImage bookImage = new BookImage();
                        bookImage.setOriginalFileName(fileName);
                        bookImage.setFileName(newImageName);
                        bookImage.setBook(book);
                        bookImage.setType(type);
                        bookImageService.save(bookImage);
                        if(type==1){
                            BufferedImage thumbnail =ImageUtil.getThumbnail(file,300);
                            String thumbnail_location =ImageUtil.makePath(uploadPath,newImageName,book_id);
                            ImageIO.write(thumbnail,file.getContentType().split("/")[1],new File(thumbnail_location));

                        }

                        successImageNames.add(fileName);
                    } catch (Exception e) {
                        e.printStackTrace();
                        errorImageNames.add(file.getOriginalFilename());
                    }
                } else {
                    // 이미지 파일이 아닌 경우 오류 처리
                    errorImageNames.add(file.getOriginalFilename());
                }
            });

            // 결과 반환
            Map<String, List<String>> result = new HashMap<>();
            result.put("success", successImageNames);
            result.put("error", errorImageNames);

            return ResponseEntity.ok(Collections.singletonList(result));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book not found");
        }

    }
    //이미지 뷰어만들기
    @GetMapping("/{image_id}/imageSrc")
    public ResponseEntity<byte[]> getImage(@PathVariable("image_id") Long image_id) throws IOException {
        Optional<BookImage> optionalBook= bookImageService.findById(image_id);
        byte[] imageBytes;
        if(optionalBook.isPresent()){
            BookImage bookImage = optionalBook.get();
            Path imagePath = ImageUtil.getFileAsResource (uploadPath, bookImage.getBook().getId(), bookImage.getFileName());
            imageBytes = Files.readAllBytes (imagePath);
        }else{
            return ResponseEntity.status (HttpStatus.BAD_REQUEST ).body(null);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG ); // Set appropriate content type based on image format->수정
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK );
    }

}