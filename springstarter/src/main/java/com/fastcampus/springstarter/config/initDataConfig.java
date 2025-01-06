package com.fastcampus.springstarter.config;

import com.fastcampus.springstarter.entity.Book;
import com.fastcampus.springstarter.entity.Review;
import com.fastcampus.springstarter.service.BookService;
import com.fastcampus.springstarter.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class initDataConfig implements CommandLineRunner {

    @Autowired
    private BookService bookService;
    @Autowired
    private ReviewService reviewService;

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

            //임의로 리뷰 3개를 작성
            Review review01 = new Review();
            review01.setCotent("자세하고 쉽게 되어있어요 ");
            review01.setRating(4);
            review01.setCreateAt(LocalDateTime.now());
            review01.setBook(book1); //book1 reivew
            reviewService.save(review01);

            Review review02 = new Review();
            review02.setCotent("그림으로 이해하기 쉽게 설명해줘요  ");
            review02.setRating(5);
            review02.setCreateAt(LocalDateTime.now());
            review02.setBook(book2); //book2 reivew
            reviewService.save(review02);

            Review review03 = new Review();
            review03.setCotent("나쁘지않아요 ");
            review03.setRating(5);
            review03.setCreateAt(LocalDateTime.now());
            review03.setBook(book2);
            reviewService.save(review03);
        }

    }
}
