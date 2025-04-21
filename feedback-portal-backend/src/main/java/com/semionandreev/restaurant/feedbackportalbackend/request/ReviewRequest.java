package com.semionandreev.restaurant.feedbackportalbackend.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest{
	@JsonProperty("fName")
	private String fName;
	@JsonProperty("lName")
	private String lName;
	private String email;
	private String text;
}
