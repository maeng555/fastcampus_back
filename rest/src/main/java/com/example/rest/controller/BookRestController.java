package com.example.rest.controller;

import com.example.rest.entity.Book;
import com.example.rest.entity.BookPayloadDTO;
import com.example.rest.entity.BookViewDTO;
import com.example.rest.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.tomcat.util.http.parser.HttpHeaderParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



}
