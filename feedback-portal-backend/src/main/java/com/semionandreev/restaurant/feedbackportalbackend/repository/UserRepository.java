package com.semionandreev.restaurant.feedbackportalbackend.repository;

import com.semionandreev.restaurant.feedbackportalbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	Optional<User> findByEmail(String email);
}
