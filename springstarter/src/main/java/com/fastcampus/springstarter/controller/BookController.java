package com.fastcampus.springstarter.controller;


import com.fastcampus.springstarter.entity.Book;
import com.fastcampus.springstarter.entity.Review;
import com.fastcampus.springstarter.service.BookService;
import com.fastcampus.springstarter.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Controller
    public class BookController { // new HomeController()

        @Autowired
        private BookService bookService;
        @Autowired
        private ReviewService reviewService;

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
                Book book = bookOptional.get(); //리뷰정보도 가지고잇다
                model.addAttribute("book",book);

                // 평균 평점을 계산하여 모델에 추가
                double averageRating = book.getReviews().stream()
                        .mapToInt(Review::getRating)
                        .average()
                        .orElse(0.0);
                String formattedAverageRating = String.format ("%.1f", averageRating);
                model.addAttribute("averageRating", formattedAverageRating);


                return "detail"; // detail view detail.html  ${book.~~}
            }else{
                return "redirect:/";
            }

        }
        @PostMapping("/register")
        public String reviewRegister(@RequestParam("book_id")Long book_id, Review review){
            Book book=bookService.getById(book_id).orElseThrow(()->new IllegalArgumentException("Invaild book id"+book_id));
            review.setBook(book);
            review.setCreatedAt(LocalDateTime.now());
            reviewService.save(review);
            return "redirect:/detail/"+book.getId();
        }
        @PostMapping("/deleteReview")
        public String deleteReview(Long review_id,Long book_id){
            reviewService.deleteReviewById(review_id);//삭제성공
            return "redirect:/detail/"+book_id;

        }
    }
