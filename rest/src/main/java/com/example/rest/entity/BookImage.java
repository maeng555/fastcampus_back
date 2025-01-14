package com.example.rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int type;
    private String originalFileName;
    private String fileName;

    // 책 1 이미지 n
    @ManyToOne
    //Fk 만들기
    @JoinColumn(name = "book_id",referencedColumnName = "id",nullable = false) //레퍼런스 명시
    private Book book; //pk
}
