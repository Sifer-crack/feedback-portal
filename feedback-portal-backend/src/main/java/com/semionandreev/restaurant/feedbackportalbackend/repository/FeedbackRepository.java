package com.semionandreev.restaurant.feedbackportalbackend.repository;

import com.semionandreev.restaurant.feedbackportalbackend.model.Feedback;
import com.semionandreev.restaurant.feedbackportalbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	boolean existsByUser(User user);
}