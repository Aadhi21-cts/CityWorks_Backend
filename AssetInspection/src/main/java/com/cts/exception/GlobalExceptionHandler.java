package com.cts.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.api.ApiResponse;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {



	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, Object>> handleRuntime(RuntimeException ex) {

		Map<String, Object> response = new HashMap<>();
		response.put("timestamp", LocalDateTime.now());
		response.put("status", HttpStatus.BAD_REQUEST.value());
		response.put("error", "BAD_REQUEST");
		response.put("message", ex.getMessage());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	// 👇 ADD THIS TO YOUR EXISTING GlobalExceptionHandler.java 👇
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleResourceNotFound(ResourceNotFoundException ex) {

		Map<String, Object> response = new HashMap<>();
		response.put("timestamp", java.time.LocalDateTime.now());
		response.put("status", HttpStatus.NOT_FOUND.value());
		response.put("error", "NOT_FOUND");
		response.put("message", ex.getMessage());

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, Object>> handleConstraintVoilation(ConstraintViolationException ex) {

		Map<String, Object> response = new HashMap<>();
		response.put("timestamp", java.time.LocalDateTime.now());
		response.put("status", HttpStatus.BAD_REQUEST.value());
		response.put("error", "INVALID_OPERATION");
		response.put("message", ex.getMessage());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(
	        MethodArgumentNotValidException ex) {

	    Map<String, String> fieldErrors = new HashMap<>();

	    ex.getBindingResult().getFieldErrors().forEach(error -> {
	        fieldErrors.put(error.getField(), error.getDefaultMessage());
	    });

	    Map<String, Object> response = new HashMap<>();
	    response.put("timestamp", LocalDateTime.now());
	    response.put("status", HttpStatus.BAD_REQUEST.value());
	    response.put("error", "VALIDATION_FAILED");
	    response.put("message", fieldErrors);   

	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse<Map<String,String>>> handleAccessDenied(AccessDeniedException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ApiResponse.<Map<String,String>>builder()
                		.status("Access Denied")
                		.message("Access denied: you do not have permission to perform this action")
                		.build());
    }
}