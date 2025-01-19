package com.example.restful2.service;

import com.example.restful2.entity.Customer;
import com.example.restful2.repository.CustomerRepository;
import lombok.CustomLog;
import org.hibernate.Hibernate;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    //회원 등록
    @Transactional
    public Customer register(Customer customer){
        return customerRepository.save(customer);
    }
    //회원 목록 가져오기 (+ 리뷰 List<Review> , + 장바구니 List<cart>
    //즉 목록만 가져오고싶은데 리뷰장바구니만 빼고 가져오기싶으면 즉시로딩 말고 로딩을 나중에 lazy 지연로딩
    //entity 모델 가서 fetch =FetchType.lazy
    @Transactional(readOnly = true)
    public List<Customer> getAllCustomer(){
       // return customerRepository.findAll();

        //List<Customer> customers = customerRepository.findAll();
        //customers.forEach(customer -> Hibernate.initialize(customer.getReviews()));
        //return customers; //레이지 이니셜라이즈 엔셉션  오류 해결 이건 세션을 닫앗을때 디폴트는 항상열려잇긴함

        //jpql로 엑셉션 해결 할대는
        return customerRepository.findAllWithReviews();
        // 즉 레이지는 원래 지연로딩이기에 이걸 세션이끊기면 못가져옴 세션이끊겨도 사용할수있게 미리로드하는 방법임 = open-in-view =false 일때

    }
    //특정 회원 한명의 정보가져오기
    @Transactional(readOnly = true)
    public Optional<Customer> getById(Long id){//Pk
        return customerRepository.findById(id);

    }
    //특정 회원 한명 수정하기
    @Transactional
    public void cusUpdate(Long id,Customer customer){
        Optional<Customer> optional = customerRepository.findById(id);
        Customer dbCustomer;
        if (optional.isPresent()){
            dbCustomer = optional.get();
        }else {
            throw new IllegalArgumentException("errors");
        }
        dbCustomer.setUsername(customer.getUsername());
        dbCustomer.setAge(customer.getAge());
        customerRepository.save(dbCustomer);

    }
    //특정 회원 삭제
    @Transactional
    public void cusDelete(Long id){
        customerRepository.deleteById(id);
    }
    //회원의 아이디와 패스워드가 일치하는 회원을 가져오기
    @Transactional(readOnly = true)
    public Customer login(String username, String password){
        Optional<Customer> optional = customerRepository.findByUsernameAndPassword(username,password);
        Customer customer;
        if (optional.isPresent()){
            customer = optional.get();
        }else {
            throw new IllegalArgumentException("error");
        }
        return customer;
    }
    @Transactional(readOnly = true)
    public List<Customer> getAge(int age){
       // return customerRepository.findByAgeGreaterThanEqual(age);
        return customerRepository.ageGreaterThanEqual(age);
    }


}
