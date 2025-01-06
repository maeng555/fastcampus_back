package com.fastcampus.springstarter.service;

import com.fastcampus.springstarter.entity.Book;
import com.fastcampus.springstarter.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor 생성자 주입방법 밑에다 private final BookRepository bookRepository
// public BookService(BookRepository bookRepository){ this.bookRepository=bookRepository} 이거는 어노테이션 안사용할때
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }// ex) select * from book where id =3 optional은 잇으면 들어가고 없으면 null

    public List<Book> getAll() {
        return bookRepository.findAll(); //select * from book
    }

    public void delete(Book book) {
        bookRepository.delete(book); // delete from book where id =3
    }

    public Book save(Book book) { //insert or update
        // 새 책의 경우 createdAt을 설정
        if (book.getId() == null) { // book이 없을때
            book.setCreatedAt(LocalDateTime.now());
        }

        // 책 저장
        return bookRepository.save(book);
    }


}
