package com.fastcampus.springstarter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review { //create table review ~sql
    @Id//pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//자동생성 어노테이션
    private Long id; //리뷰 일련번호 1.2.3.4 자동증가 pk

    private String content; //리뷰 내용
    private int rating; //평점
    private LocalDateTime createdAt; //작성일자

    @ManyToOne
    //fk를 만들어줘야한다
    @JoinColumn(name = "book_id",referencedColumnName = "id",nullable = false)
    private Book book; // (Book : id (pk) book.id


}
