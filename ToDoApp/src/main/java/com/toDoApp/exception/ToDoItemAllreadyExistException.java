package com.toDoApp.exception;

public class ToDoItemAllreadyExistException extends RuntimeException{
	
	public ToDoItemAllreadyExistException(String message){
		super(message);
	}

}
