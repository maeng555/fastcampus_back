package com.example.restful2.entity;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String username;
    private String password;
    private String customerName;
    private int age;
    private String rating;
    private String occupation;

    @Column(columnDefinition = "int default 0")
    private int reserves; //적립금

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Review> reviews;
    //고객 1 : 장바구니 n
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Cart> carts;
}
