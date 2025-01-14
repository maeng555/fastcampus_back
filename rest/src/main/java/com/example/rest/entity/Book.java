package com.example.rest.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String subject;
    private int price;
    private String author;
    private int page;
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL )//cascade 일관성있게 삭제하면 다삭제
    private List<BookImage> bookImages; //table컬럼을 만들면 안된다
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now ();
    }
}
