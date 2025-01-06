package com.fastcampus.springstarter.controller;


import com.fastcampus.springstarter.entity.Book;
import com.fastcampus.springstarter.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Controller
    public class BookController { // new HomeController()

        @Autowired
        private BookService bookService;

        @GetMapping("/")
        public String home(Model model) {
            List<Book> books = bookService.getAll();
            model.addAttribute("books",books);//객체바인딩
            return "home";
        }
        @GetMapping("/detail/{id}")
        public String getDetails(@PathVariable Long id,Model model){
            Optional<Book> bookOptional= bookService.getById(id);
            if(bookOptional.isPresent()){
                Book book = bookOptional.get();
                model.addAttribute("book",book);
                return "detail"; // detail view detail.html  ${book.~~}
            }else{
                return "redirect:/";
            }

        }
    }
