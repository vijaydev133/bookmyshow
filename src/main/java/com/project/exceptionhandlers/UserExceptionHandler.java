package com.project.exceptionhandlers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.exceptions.MovieNotFound;
import com.project.exceptions.NoUserFoundException;
import com.project.exceptions.SeatNotAvailable;
import com.project.exceptions.ShowNotFound;
import com.project.exceptions.TheaterNotFound;
import com.project.errors.Error;
@RestControllerAdvice
public class UserExceptionHandler {

	
	
	@ExceptionHandler(SeatNotAvailable.class)
	public ResponseEntity<Error> handleSeatNotAvailable(SeatNotAvailable e){
		
		Error error = Error.builder()
				.date(LocalDateTime.now())
				.message(e.getMessage())
				.errorCode("500")
				.build();
		
		return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<Error> handleNoUserFoundException(NoUserFoundException e){
		
		Error error = Error.builder()
				.date(LocalDateTime.now())
				.message(e.getMessage())
				.errorCode("500")
				.build();
		
		return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ShowNotFound.class)
	public ResponseEntity<Error> handleShowNotFound(ShowNotFound e){
		
		Error error = Error.builder()
				.date(LocalDateTime.now())
				.message(e.getMessage())
				.errorCode("500")
				.build();
		
		return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MovieNotFound.class)
	public ResponseEntity<Error> handleMovieNotFound(MovieNotFound e){
		
		Error error = Error.builder()
				.date(LocalDateTime.now())
				.message(e.getMessage())
				.errorCode("500")
				.build();
		
		return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TheaterNotFound.class)
	public ResponseEntity<Error> handleTheaterNotFound(TheaterNotFound e){
		
		Error error = Error.builder()
				.date(LocalDateTime.now())
				.message(e.getMessage())
				.errorCode("500")
				.build();
		
		return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> handleException(Exception e){
		
		Error error = Error.builder()
				.date(LocalDateTime.now())
				.message(e.getMessage())
				.errorCode("500")
				.build();
		
		return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
	}
	
}
