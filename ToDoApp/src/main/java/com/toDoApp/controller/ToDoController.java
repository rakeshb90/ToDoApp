package com.toDoApp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.toDoApp.constants.ToDoContants;
import com.toDoApp.dto.ResponseDto;
import com.toDoApp.dto.ToDoItemDto;
import com.toDoApp.entity.ToDoItem;
import com.toDoApp.service.ToDoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@RestController
@RequestMapping("/api")
@Validated
@Tag(
		name="ToDo API",
		description="Daily used to do API"
		)
public class ToDoController {
	ToDoService toDoService;
	
	
	public ToDoController(ToDoService toDoService) {
		super();
		this.toDoService = toDoService;
	}
	
	// Greeting or Start og REST API 
	@GetMapping("/")
	public ResponseEntity<String> greeting(){
		return new ResponseEntity<>(" Welcome to my ToDoApp! ",HttpStatus.OK);
	}
	
	// REST API for create Resource 
	 @Operation(
			   summary="Create ToDo item REST API",
			   description="Create ToDo item for daily update REST API"
			   )
	   @ApiResponse(
			   responseCode=ToDoContants.STATUS_201,
	           description=ToDoContants.MSG_201
			   )
	@PostMapping("/todo")
	public ResponseEntity<ResponseDto> addTodo(@Valid @RequestBody ToDoItemDto toDoItemDto ){
		boolean isSaved = toDoService.saveToDo(toDoItemDto);
		if(!isSaved) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseDto(""+HttpStatus.BAD_REQUEST,ToDoContants.MSG_400));
		}
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDto(ToDoContants.STATUS_201,ToDoContants.MSG_201));
	}
	
	// REST API for fetching all resources
	 @Operation(
			   summary="Fetch ToDo items REST API",
			   description="Fetch all ToDo item from Database REST API"
			   )
	   @ApiResponse(
			   responseCode=ToDoContants.STATUS_200,
	           description=ToDoContants.MSG_200
			   )
	@GetMapping("/todo")
	public ResponseEntity<List<ToDoItem>> getAllToDo(){
		List<ToDoItem> toDoItemList= toDoService.getAllToDo();
		if(toDoItemList == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(toDoItemList);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(toDoItemList);
	}
	
	// REST API for fetching single record based on title
	 @Operation(
			   summary="Fetch ToDo item REST API",
			   description="Fetch single ToDo item from database based on title REST API"
			   )
	   @ApiResponse(
			   responseCode=ToDoContants.STATUS_200,
	           description=ToDoContants.MSG_200
			   )
	@GetMapping("/todo/{title}")
	public ResponseEntity<ToDoItem> getToDoByTitle(@Size(min=3,max=50,message="Title of task must be more than 3 and less than 50 characters" )
	@PathVariable("title")String toDoTitle){
		 
		ToDoItem toDoItem= toDoService.getToDoByTitle(toDoTitle);
		
		if(toDoItem == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(toDoItem);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(toDoItem);
	}
	
	// REST API for update resource 
	 @Operation(
			   summary="Update ToDo item REST API",
			   description="Update ToDo item based on given parameter REST API"
			   )
	   @ApiResponse(
			   responseCode=ToDoContants.STATUS_200,
	           description=ToDoContants.MSG_200
			   )
		@PutMapping("/todo")
		public ResponseEntity<ToDoItemDto> updateTodo(@Valid @RequestBody ToDoItemDto toDoItemDto ){
			
		    ToDoItemDto ToDoItemDto=toDoService.updateToDo(toDoItemDto);
			
			return ResponseEntity.status(HttpStatus.OK).body(ToDoItemDto);
		}
		
		// REST API for deleting resource
	 @Operation(
			   summary="Delete ToDo item REST API",
			   description="Delete ToDo item from database REST API"
			   )
	   @ApiResponse(
			   responseCode=ToDoContants.STATUS_200,
	           description=ToDoContants.MSG_200
			   )
		@DeleteMapping("/todo")
		public ResponseEntity<ResponseDto> updateTodo(@NotEmpty(message="Id of task should not be null or empty")
		    @RequestParam Long id){
			boolean isDeleted = toDoService.deleteToDo(id);
			if(!isDeleted) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(ToDoContants.STATUS_500,ToDoContants.MSG_500));
			}
				
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(ToDoContants.STATUS_200,ToDoContants.MSG_200));
		}
	

}
