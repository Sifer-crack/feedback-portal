package com.semionandreev.restaurant.feedbackportalbackend.service;

import com.semionandreev.restaurant.feedbackportalbackend.model.Feedback;
import com.semionandreev.restaurant.feedbackportalbackend.model.User;
import com.semionandreev.restaurant.feedbackportalbackend.repository.FeedbackRepository;
import com.semionandreev.restaurant.feedbackportalbackend.repository.UserRepository;
import com.semionandreev.restaurant.feedbackportalbackend.request.ReviewRequest;
import com.semionandreev.restaurant.feedbackportalbackend.response.ReviewResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
@RequiredArgsConstructor
public class ReviewService{
	private final UserRepository userRepository;
	private final FeedbackRepository feedbackRepository;
	
	@Transactional
	public ReviewResponse review(ReviewRequest request) {
		// 1. Check if the user already exists by email
		User user = userRepository.findByEmail(request.getEmail())
				.orElseGet(() -> {
					// 2. If user doesn't exist, create and save them
					User newUser = User.builder()
							.fName(request.getFName())
							.lName(request.getLName())
							.email(request.getEmail())
							.build();
					return userRepository.save(newUser);
				});
		
		// 3. Create and save the feedback
		Feedback feedback = Feedback.builder()
				.user(user)
				.text(request.getText())
				.build();
		feedbackRepository.save(feedback);
		
		// 4. Return response
		return ReviewResponse.builder()
				.message("Thank you for your feedback!")
				.email(user.getEmail())
				.build();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public static class ReviewAlreadySubmittedException extends RuntimeException {
		public ReviewAlreadySubmittedException(String message) {
			super(message);
		}
	}
	
}



