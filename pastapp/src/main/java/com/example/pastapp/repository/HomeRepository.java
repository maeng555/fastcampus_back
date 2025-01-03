package com.example.pastapp.repository;

import com.example.pastapp.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface HomeRepository extends JpaRepository<Member,Long> {
}
