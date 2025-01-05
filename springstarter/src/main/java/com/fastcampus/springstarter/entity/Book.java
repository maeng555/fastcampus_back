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
    }

