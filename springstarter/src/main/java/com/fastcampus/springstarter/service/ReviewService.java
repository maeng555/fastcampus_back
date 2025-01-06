package com.fastcampus.springstarter.service;

import com.fastcampus.springstarter.entity.Review;
import com.fastcampus.springstarter.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {
    @Autowired
    public ReviewRepository reviewRepository;

    public Review save(Review review){
        return reviewRepository.save(review);

    }
    @Transactional  //안정적으로 삭제
    public void deleteReviewById(Long review_id){
        reviewRepository.deleteById(review_id); //delete sql
    }
}
