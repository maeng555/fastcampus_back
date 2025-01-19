package com.example.restful2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @Temporal(TemporalType.DATE)
    private Date cartDate = new Date();

    //장바구니 n : book 1
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id",nullable = false)
    private Book book;
    //장바구니 n : custormer 1
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id",nullable = false)
    private Customer customer;
}
