package com.fastcampus.springstarter.config;

import com.fastcampus.springstarter.entity.Book;
import com.fastcampus.springstarter.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class initDataConfig implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        List<Book> books = bookService.getAll();

        if (books.size() == 0) {
            Book book1 = new Book();
            book1.setSubject("자바");
            book1.setPrice(30000);
            book1.setAuthor("김길동");
            book1.setPage(600);
            bookService.save(book1);

            Book book2 = new Book();
            book2.setSubject("파이썬");
            book2.setPrice(37000);
            book2.setAuthor("나길동");
            book2.setPage(800);
            bookService.save(book2);
        }
    }
}
