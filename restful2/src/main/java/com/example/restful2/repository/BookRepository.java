package com.example.restful2.repository;

import com.example.restful2.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> { //엔티티 명 , 그엔티티 Pk
    //JpaRepository 에서 제공해주는 CRUD 메소드
    //insert- save

}
