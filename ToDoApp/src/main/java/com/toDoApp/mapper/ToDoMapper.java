package com.toDoApp.mapper;

import com.toDoApp.dto.ToDoItemDto;
import com.toDoApp.entity.ToDoItem;

public class ToDoMapper {
	
	public static ToDoItem mapToToDoItem(ToDoItem toDoItem,ToDoItemDto toDoItemDto) {
		toDoItem.setTaskTitle(toDoItemDto.getTaskTitle());
		toDoItem.setDescription(toDoItemDto.getDescription());
		return toDoItem;
	}
	public static ToDoItemDto mapToToDoItemDto(ToDoItem toDoItem,ToDoItemDto toDoItemDto) {
		toDoItemDto.setTaskTitle(toDoItem.getTaskTitle());
		toDoItemDto.setDescription(toDoItem.getDescription());
		return toDoItemDto;
	}

}
