package com.project.errors;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Error {

	private LocalDateTime date;
	
	private String message;
	
	private String errorCode;
}
