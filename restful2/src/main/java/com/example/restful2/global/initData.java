package com.example.restful2.global;

import com.example.restful2.entity.Book;
import com.example.restful2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.w3c.dom.ls.LSOutput;

@Profile("!prod") // dev or test
@Configuration
public class initData {
    //빈은 사용자가 new키워들 ㄹ사용안해도 객체생성
    @Autowired
    public BookRepository bookRepository;
    @Bean
    public ApplicationRunner initNotProd(){
        return args ->{
            if(bookRepository.count()>0){
                return; //count 는 개수말함 데베안에잇는 데이터
            }
            Book book1 = Book.builder()
                    .title("dfd")
                    .build();
            bookRepository.save(book1);
        };

    }
}
