package com.toDoApp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Schema(
		name="ToDo Item",
	    description="Daily to do item"
	)
public class ToDoItemDto {
	@Schema(
			name="Title",
		    description="Title of task of to do item",example="Go to Gym"
		)
	@NotEmpty(message="Title of task should not be null or empty")
	@Size(min=3,max=50,message="Title of task must be more than 3 and less than 50 characters")
    private String taskTitle;
	@Schema(
		    description="Discription of task of to do item",example="Go to Gym at 7 AM"
		)
	
	@NotEmpty(message="Description of task should not be null or empty")
	@Size(min=5,message="Title of task must be more than 5 characters")
	private String description;

	public ToDoItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
