package com.webapi.tasktracker.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.webapi.tasktracker.model.TaskModel;

@Service
public class TaskService {

	private static List<TaskModel> tasks = new ArrayList<>();
	private static int idCounter = 0;
	
	static {
		tasks.add(new TaskModel(++idCounter, "Maithilee", "Learn to Dance", new Date(), false, "Low"));
		tasks.add(new TaskModel(++idCounter, "Maithilee", "Learn to Draw", new Date(), false, "High"));
		tasks.add(new TaskModel(++idCounter, "Maithilee", "temp", new Date(), false, "High"));
	}
	
	
	public List<TaskModel> findAll(){
		return tasks;
	}
	
	public TaskModel deleteById(long id) {
		TaskModel task = findById(id);
		
		if(task == null) 
			return null;
		if(tasks.remove(task)) {
			return task;
		}
		return null;
	}

	public  TaskModel save(TaskModel task) {
		if(task.getId() == -1) {
			task.setId(++idCounter);
			tasks.add(task);
		}
		else {
			deleteById(task.getId());
			tasks.add(task);
		}
		return task;
	}
	public TaskModel findById(long id) {
		for(TaskModel task : tasks) {
			if(task.getId() == id) {
				return task;
			}
		}
		return null;
	}
}
