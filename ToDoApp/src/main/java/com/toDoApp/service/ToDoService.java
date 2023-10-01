package com.toDoApp.service;

import java.util.List;

import com.toDoApp.dto.ToDoItemDto;
import com.toDoApp.entity.ToDoItem;

public interface ToDoService {
	public boolean saveToDo(ToDoItemDto toDoItemDto);
	public ToDoItemDto updateToDo(ToDoItemDto toDoItemDto);
	public List<ToDoItem> getAllToDo();
	public ToDoItem getToDoByTitle(String title);
	public boolean deleteToDo(Long id);
}
