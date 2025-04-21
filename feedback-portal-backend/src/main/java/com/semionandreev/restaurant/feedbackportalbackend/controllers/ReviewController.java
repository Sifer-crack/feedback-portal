package com.semionandreev.restaurant.feedbackportalbackend.controllers;

import com.semionandreev.restaurant.feedbackportalbackend.request.ReviewRequest;
import com.semionandreev.restaurant.feedbackportalbackend.response.ReviewResponse;
import com.semionandreev.restaurant.feedbackportalbackend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/feedback-portal")
@RequiredArgsConstructor
public class ReviewController{
	private final ReviewService reviewService;
	
	@PostMapping("/review")
	public ResponseEntity<ReviewResponse> review(@RequestBody ReviewRequest reviewRequest){
		return ResponseEntity.ok(reviewService.review(reviewRequest));
	}
}
