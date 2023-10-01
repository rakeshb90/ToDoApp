package com.toDoApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toDoApp.dto.ToDoItemDto;
import com.toDoApp.entity.ToDoItem;
import com.toDoApp.exception.ResourceNotFoundException;
import com.toDoApp.exception.ToDoItemAllreadyExistException;
import com.toDoApp.mapper.ToDoMapper;
import com.toDoApp.repository.ToDoRepository;
@Service
public class ToDoServiceImpl  implements ToDoService{
	@Autowired
	ToDoRepository toDoRepository;

	@Override
	public boolean saveToDo(ToDoItemDto toDoItemDto) {
		
		ToDoItem toDoItem = ToDoMapper.mapToToDoItem(new ToDoItem(), toDoItemDto);
		Optional<ToDoItem> existedToDoItem = toDoRepository.findByTaskTitle(toDoItem.getTaskTitle());
		if(existedToDoItem.isPresent())
			existedToDoItem.orElseThrow(()->new ToDoItemAllreadyExistException("ToDoItem allready exist having task title :"+toDoItem.getTaskTitle()));
		toDoRepository.save(toDoItem);
		
		return true;
		
	}

	@Override
	public ToDoItemDto updateToDo(ToDoItemDto toDoItemDto) {
		// TODO Auto-generated method stub
		ToDoItem toDoItem = ToDoMapper.mapToToDoItem(new ToDoItem(), toDoItemDto);
		Optional<ToDoItem> existedToDoItem = toDoRepository.findById(toDoItem.getId());
		if(!existedToDoItem.isPresent())
			existedToDoItem.orElseThrow(()-> new ResourceNotFoundException("ToDoItem","ItemId",""+toDoItem.getId()));
		toDoRepository.save(toDoItem);
		
		
		return toDoItemDto;
	}

	@Override
	public List<ToDoItem> getAllToDo() {
		
		return toDoRepository.findAll();
	}

	@Override
	public ToDoItem getToDoByTitle(String title) {
		// TODO Auto-generated method stub
		ToDoItem toDoItem=toDoRepository.findByTaskTitle(title).orElseThrow(
				()-> new ResourceNotFoundException("ToDoItem","TaskTitle",title));
		return toDoItem;
	}

	@Override
	public boolean deleteToDo(Long id) {
		// TODO Auto-generated method stub
		ToDoItem toDoItem=toDoRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("ToDoItem","Id",""+id));
		toDoRepository.delete(toDoItem);
		return true;
	}

}
