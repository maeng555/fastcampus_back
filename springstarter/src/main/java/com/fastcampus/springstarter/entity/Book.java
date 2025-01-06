package com.fastcampus.springstarter.entity;

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
        @Id //primary key
        @GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가
        private Long id;

        private String subject;
        private int price;
        private String author;
        private int page;

        @Column(updatable = false) // 생성 후 수정 불가
        private LocalDateTime createdAt;

        @PrePersist
        public void prePersist() {
            this.createdAt = LocalDateTime.now(); // 엔티티 저장 전 현재 시간 설정
        }
        @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
        //키가아닌 오브젝트를 연결 private Book book 인부분
        //cascade - 연결되어있는 리뷰도 삭제  2번책을 지우면 2번책의리뷰도 지워진다
        private List<Review> reviews; //책하나에 여러개의 리뷰기때매 리스트타입을 가지고있어야한다


    }

