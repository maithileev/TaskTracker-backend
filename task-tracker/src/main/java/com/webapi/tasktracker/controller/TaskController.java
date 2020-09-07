package com.webapi.tasktracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapi.tasktracker.model.TaskModel;
import com.webapi.tasktracker.service.TaskService;

@RestController
@CrossOrigin(origins = "*")
public class TaskController {
	@Autowired
	private TaskService service;

	@GetMapping("/users/{username}/tasks")
	public List<TaskModel> getAllTasks(@PathVariable String username){
		return service.findAll();
	}
	
	@GetMapping("/users/{username}/tasks/{id}")
	public TaskModel getTask(@PathVariable String username, @PathVariable long id){
		return service.findById(id);
	}
	
	
	 @DeleteMapping("/users/{username}/tasks/{id}") 
	 public ResponseEntity<Void> deleteTask(@PathVariable String username, @PathVariable long id){ 
		 TaskModel task =service.deleteTask(id); 
		 if(task != null) {
			 return ResponseEntity.noContent().build();
		}
	    return ResponseEntity.notFound().build();
	 }
	
	
	@PutMapping("/users/{username}/tasks/{id}") 
	public ResponseEntity<TaskModel> updateTask(
			@PathVariable String username, 
			@PathVariable long id, @RequestBody TaskModel task){
		
		
		TaskModel updatedTask = service.update(task,id);
		return new ResponseEntity<TaskModel>(task,HttpStatus.OK);
	}
}
