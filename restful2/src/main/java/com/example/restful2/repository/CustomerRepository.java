package com.example.restful2.repository;

import com.example.restful2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> { //엔티티 명 , 그엔티티 Pk
    //JpaRepository 에서 제공해주는 CRUD 메소드
    // save - finall - findbyid 등등

    //직접 sql문 메소드만들기
    public Optional<Customer> findByUsernameAndPassword(String username, String password);

    public List<Customer> findByAgeGreaterThanEqual(int age);
}
