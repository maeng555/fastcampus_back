package com.fastcampus.springstarter.repository;

import com.fastcampus.springstarter.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
    //w직접 메서드를 만듨 수 있다.
    //먼저 기본적으로 제공해주는 jpa 메서드 이용

}
