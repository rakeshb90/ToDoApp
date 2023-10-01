package com.toDoApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toDoApp.entity.ToDoItem;

public interface ToDoRepository extends JpaRepository<ToDoItem,Long> {
    Optional<ToDoItem> findByTaskTitle(String taskTitle);
}
