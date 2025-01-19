package com.example.restful2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int type;
    private String path;

    //이미지 n : book 1
    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false,referencedColumnName = "id")
    private Book book;
}
