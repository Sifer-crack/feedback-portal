package com.semionandreev.restaurant.feedbackportalbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@Entity
@Table(name="users")

@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "fname", nullable = false)
	private String fName;
	
	@Getter
	@Setter
	@Column(name = "lname", nullable = false)
	private String lName;
	
	@Getter
	@Setter
	@Column(name = "email", nullable = false, unique = true)
	private String email;
}

