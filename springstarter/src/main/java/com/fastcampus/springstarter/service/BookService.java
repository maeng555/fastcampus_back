package com.fastcampus.springstarter.service;

import com.fastcampus.springstarter.entity.Book;
import com.fastcampus.springstarter.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor 생성자 주입방법 밑에다 private final BookRepository bookRepository
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }

    public Book save(Book book) {
        // 새 책의 경우 createdAt을 설정
        if (book.getId() == null) {
            book.setCreatedAt(LocalDateTime.now());
        }

        // 책 저장
        return bookRepository.save(book);
    }
}
