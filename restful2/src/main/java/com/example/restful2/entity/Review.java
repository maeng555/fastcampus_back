package com.example.restful2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cost;
    private String content;
    @Temporal(TemporalType.DATE)
    private Date createdAt = new Date();
    //customer관 1대 n 관계
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id",nullable = false)
    private Customer customer;

    //리뷰 n : book 1
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id",nullable = false) // 외래키
    private Book book; //pk


}
