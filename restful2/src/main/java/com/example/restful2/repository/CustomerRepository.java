package com.example.restful2.repository;

import com.example.restful2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    //jpql
    @Query("select c from Customer c where c.age>=:a")
    public List<Customer> ageGreaterThanEqual(@Param("a") int age);
    @Query("select c from Customer c where c.username=:username and c.password=:password")
    public Optional<Customer> UsernameAndPassword(String username, String password);

    //native query 찐데베에이슨ㄴ걸 쓴다
    //@Query(value = "select * from customer where age>=?1",nativeQuery = true)
    //public List<Customer> ageGreaterThanEqual(int age);

    //두번째 레이지이니셜라이증엑셉션 해결 jpql
    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.reviews")
    public List<Customer> findAllWithReviews();

    //세번째 엔티티 그래프(Entity Graph)를 사용하여 필요한 연관 관계를 명시적으로 로딩으로 레이지해결
    //@EntityGraph(attributePaths = {"reviews"})
    //@Query("SELECT c FROM Customer c")
    //List<Customer> findAllWithReviews();

    //N+1 쿼리문제를 해결하는방법 (lazyinitlizexpection 해결)
    //1. 조인으로 쿼리 가져오기, 2엔티티그래프
    //데이터 로드 방법에 주의하지 않으면 각 고객에 대한 리뷰를 검색할 때 N+1 쿼리 문제가 발생할 수 있습니다.
    //이 문제는 특히 고객 수가 많고 관련 리뷰가 많은 경우 성능에 큰 영향을 미칠 수 있습니다. 이를 방지하려면 특
    //정 사용 사례에 따라 가져오기 조인, 엔터티 그래프 또는 일괄 가져오기를 사용하는 것이 가장 좋습니다.
}

