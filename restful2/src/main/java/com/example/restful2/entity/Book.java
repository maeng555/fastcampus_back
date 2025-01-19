package com.example.restful2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",nullable = false,unique = true,length = 45)//length default 255
    private String title;
    private int price;
    private String author;
    private int page;

    //책 1 : 리뷰 n
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Review> reviews;
    //책 1 : 이미지 n
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<BookImage> bookImages;
    //책1 : 장바구니 n
    @OneToMany(mappedBy = "book",cascade =CascadeType.ALL)
    private List<Cart> carts;
}
