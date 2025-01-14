package com.example.rest.controller;

import com.example.rest.entity.Book;
import com.example.rest.entity.BookPayloadDTO;
import com.example.rest.entity.BookViewDTO;
import com.example.rest.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.coyote.Response;
import org.apache.tomcat.util.http.parser.HttpHeaderParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Tag(name = "Book Controller", description = "책을관리하는컨트롤러 ")


public class BookRestController {
    //rest->get - http:/localhost:8081/api/test
    @Autowired
    public BookService bookService;
    @PostMapping(value = "books",consumes = "application/json",produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "400", description = "Please add valid name a description")
    @ApiResponse(responseCode = "200", description = "Book added")
    @Operation(summary="Add an Book")
    public ResponseEntity<BookViewDTO> addBook(@Valid @RequestBody BookPayloadDTO bookPayloadDTO)
    { //Valid 유효성 검사 리퀘스트ㅏ디 json타입으로 받아온다
        try{
            Book book = new Book();
            book.setSubject(bookPayloadDTO.getSubject());
            book.setPrice(bookPayloadDTO.getPrice());
            book.setAuthor(bookPayloadDTO.getAuthor());
            book.setPage(bookPayloadDTO.getPage());
            bookService.save(book);

            BookViewDTO bookViewDTO =new BookViewDTO(book.getId(),book.getSubject(), book.getPrice(),
                    book.getPage(),book.getAuthor(),book.getCreatedAt());
                return ResponseEntity.ok(bookViewDTO);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);


        }


    }
    //전체 목록 보여주기
    //produce는 가독성상 생략도가능  응답타입을 말함
    @GetMapping(value = "/books",produces = "application/json")
    @ApiResponse(responseCode = "200", description = "List of books")
    @Operation(summary="List book API")
    public List<BookViewDTO> books(){
        List<BookViewDTO> books = new ArrayList<>();
        for(Book book : bookService.findAll()){
            books.add(new BookViewDTO(book.getId(),book.getSubject(),book.getPrice(),book.getAuthor(),
                    book.getPage(),book.getCreatedAt()));
        }
        return books;
    }
    //특정 목록 조회
    @GetMapping(value = "/books/{id}",produces = "application/json")
    @ApiResponse(responseCode = "200", description = "해당 책만 출력 ")
    @Operation(summary="book id API")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Book> optionalBook = bookService.findById(id); // optional 잇으면 굿 없으면 null
        Book book;
        if(optionalBook.isPresent()){
            book = optionalBook.get();
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        BookViewDTO bookViewDTO = new BookViewDTO(book.getId(),book.getSubject(),book.getPrice(),book.getAuthor(),
                book.getPage(),book.getCreatedAt());
        return ResponseEntity.ok(bookViewDTO);
    }
    @PutMapping(value = "/books/{id}",consumes = "application/json",produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED )
    @ApiResponse(responseCode = "400", description = "Please add valid name a description")
    @ApiResponse(responseCode = "204", description = "Book update")
    @Operation(summary = "Update an Book")
    public ResponseEntity<?> update_book(@Valid @RequestBody BookPayloadDTO bookPayloadDTO, @PathVariable Long id){
        Optional<Book> optionalBook =bookService.findById(id);
        Book book;
        if(optionalBook.isPresent()){
            book = optionalBook.get();
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }
        book.setSubject(bookPayloadDTO.getSubject()); // 제목
        book.setPrice(bookPayloadDTO.getPrice()); // 가격
        book.setAuthor(bookPayloadDTO.getAuthor()); // 저자
        book.setPage(bookPayloadDTO.getPage()); //page
        book=bookService.save(book);
        BookViewDTO bookViewDTO=new BookViewDTO(book.getId(), book.getSubject(), book.getPrice(), book.getAuthor(),
                book.getPage(), book.getCreatedAt());
        return ResponseEntity.ok (bookViewDTO);
    }
    @DeleteMapping(value = "/books/{id}",produces = "application/json")
    public ResponseEntity<?> delet_book(@PathVariable Long id){
        Optional<Book> optionalBook = bookService.findById(id);
        Book book;
        if(optionalBook.isPresent()){
            book = optionalBook.get();
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        bookService.delete(book);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null); //202
    }
    //파일 업로드 rest api
    @Value("${upload.path}")
    private String uploadPath;
    @PostMapping(value = "/{book_id}/{type}/upload/",consumes = {"multipart/form-data"}) //파일을 받아올땐 json아니고 저형식으로 넘어온다
    public ResponseEntity<?> images_upload(@RequestPart(required = true) MultipartFile[] files,
            //part는 파일을받아올때 리ㄱ콰이어는 필수
            @PathVariable Long book_id,@PathVariable Long type){
            Optional<Book> optionalBook =bookService.findById(book_id); //책정보가 있는지 확인
            Book book;
            if(optionalBook.isPresent()){
                book= optionalBook.get();
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            //multifile[] 에서 하나씩가져와 작업을 해야한다 .
        int length=10;
        boolean useLetters =true;
        boolean useNumbers=true;
        Arrays.asList(files).stream().forEach(file->{
            String contentType = file.getContentType(); //jpa,png,jpeg 이런정보를 가져온다
            if(contentType.equals("image/png")||contentType.equals("image/jpeg")||
            contentType.equals("image/jpg")){
            try{
                String fileName = file.getOriginalFilename();
                String generatedString = RandomStringUtils.random(length,useLetters,useNumbers);
                String new_image_name = generatedString+fileName;
                if(type==1){
                    new_image_name="thumb" + generatedString+fileName;
                }
            }catch (Exception e){

            }
            }
        });   //stream 가져온 파일을 변형 시킨다

            return null;
    }



}
