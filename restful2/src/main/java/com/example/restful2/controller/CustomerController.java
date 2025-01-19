package com.example.restful2.controller;

import com.example.restful2.entity.Customer;
import com.example.restful2.service.BookService;
import com.example.restful2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/register")
    public String register(){
        Customer c =new Customer();
        c.setUsername("bitco");
        c.setPassword("12345");
        c.setCustomerName("park male");
        c.setAge(50);
        c.setRating("vip");
        c.setOccupation("개발자");
        Customer cus =customerService.register(c);
        return "redirect:/";
    }

    @GetMapping("/lists")
    public String lists(Model model){
        List<Customer> customerList = customerService.getAllCustomer();
        model.addAttribute("customerList",customerList);
        return "lists";
    }
    @GetMapping("/detail/{id}")
    public String getDetail(@PathVariable Long id) throws IllegalAccessException {
        Optional<Customer> optional = customerService.getById(id);
        Customer customer;
        if(optional.isPresent()){
            customer=optional.get();

        }else{
            throw new IllegalAccessException("error");
        }
        return "detail";
    }
}
