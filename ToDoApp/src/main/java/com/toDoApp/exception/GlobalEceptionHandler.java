package com.toDoApp.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.toDoApp.dto.ErrorResponseDto;
@ControllerAdvice
public class GlobalEceptionHandler extends ResponseEntityExceptionHandler{
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatusCode status, WebRequest webRequest) {
		
		Map<String,String> vaildationErrorMap = new HashMap<>();
		List<ObjectError> validationErrorList = exception.getBindingResult().getAllErrors();
		
		validationErrorList.forEach((error)->{
		    String errorField =((FieldError) error).getField(); 
			String errorMessage = error.getDefaultMessage();
			vaildationErrorMap.put(errorField,errorMessage);
		});
	
		return new ResponseEntity<>(vaildationErrorMap,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception,WebRequest req){
		ErrorResponseDto errorResponseDto = new ErrorResponseDto(req.getDescription(false),""+HttpStatus.INTERNAL_SERVER_ERROR,"INTERNAL_SERVER_ERROR",exception.getMessage());
		
		return new ResponseEntity(errorResponseDto,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest req){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(req.getDescription(false),""+HttpStatus.INTERNAL_SERVER_ERROR,"INTERNAL_SERVER_ERROR",exception.getMessage());
		
		return new ResponseEntity(errorResponseDto,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ToDoItemAllreadyExistException.class)
	public ResponseEntity<ErrorResponseDto> handleToDoItemAllreadyExistException(ToDoItemAllreadyExistException exception,WebRequest req){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(req.getDescription(false),""+HttpStatus.INTERNAL_SERVER_ERROR,"INTERNAL_SERVER_ERROR",exception.getMessage());
		
		return new ResponseEntity(errorResponseDto,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
