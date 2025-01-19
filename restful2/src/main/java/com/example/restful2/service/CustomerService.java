package com.example.restful2.service;

import com.example.restful2.entity.Customer;
import com.example.restful2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    //회원 등록
    public Customer register(Customer customer){
        return customerRepository.save(customer);
    }
    //회원 목록 가져오기 (+ 리뷰 List<Review> , + 장바구니 List<cart>
    //즉 목록만 가져오고싶은데 리뷰장바구니만 빼고 가져오기싶으면 즉시로딩 말고 로딩을 나중에 lazy 지연로딩
    //entity 모델 가서 fetch =FetchType.lazy
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }
    //특정 회원 한명의 정보가져오기
    public Optional<Customer> getById(Long id){//Pk
        return customerRepository.findById(id);

    }
}
