package com.webapi.tasktracker.service; 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapi.tasktracker.model.TaskModel;
import com.webapi.tasktracker.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	TaskRepository repository;
	
	public  TaskModel save(TaskModel task) {
		TaskModel t = repository.save(task);
		return t;
	}
	
	public List<TaskModel> findAll(){
		return repository.findAll();
	}
	
	public TaskModel findById(long id) {
		TaskModel task = repository.findById(id).get();
		return task;
	}

	public TaskModel update(TaskModel task, long id) {
		TaskModel t = new TaskModel();
		try {
		t = repository.findById(id).get();
		t.setDescription(task.getDescription());
		t.setPriority(task.getPriority());
		t.setStatus(task.isStatus());
		t.setTargetDate(task.getTargetDate());
		t = repository.save(t);
		}
		catch(NoSuchElementException e) {
			t.setDescription(task.getDescription());
			t.setPriority(task.getPriority());
			t.setStatus(task.isStatus());
			t.setTargetDate(task.getTargetDate());
			t = repository.save(t);
		}
		return t;
	}

	public TaskModel deleteTask(long id) {
		TaskModel task = repository.getOne(id);
		repository.deleteById(id);
		return task;
	}
	
	
}
	
	/*private static List<TaskModel> tasks = new ArrayList<>();
	private static long idCounter = 0;
	
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
*/