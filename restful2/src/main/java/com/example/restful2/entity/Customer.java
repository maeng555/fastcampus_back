package com.example.restful2.entity;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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

    @Column(nullable = false,unique = true) //유니크 중복 안됨
    private String username;
    private String password;
    private String customerName;
    private int age;
    private String rating;
    private String occupation;
    private LocalDateTime createDate;

    private LocalDateTime modifiyDate;

    @Column(columnDefinition = "int default 0")
    private int reserves; //적립금

    //여기서 lazy 말고 eager로 바꿔야하는데 되는이유 osvi 때문이 - 웹요청에 동안 세션을 열어두는 구성
    //세션을 정 끊고싶으면 open-in-view: false 이걸 yml spring 에 적용한다
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY) //ㅈ지연로딩
    private List<Review> reviews; // 지연로딩이면 이걸 가져올때 List<Review> reviews=cus.getReviews()
    //고객 1 : 장바구니 n
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Cart> carts;
}
