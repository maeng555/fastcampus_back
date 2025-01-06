package com.fastcampus.springstarter.service;

import com.fastcampus.springstarter.entity.Review;
import com.fastcampus.springstarter.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    public ReviewRepository reviewRepository;

    public Review save(Review review){
        return reviewRepository.save(review);

    }
}
