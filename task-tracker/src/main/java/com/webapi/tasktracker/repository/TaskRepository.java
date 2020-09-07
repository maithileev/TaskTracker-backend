package com.webapi.tasktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapi.tasktracker.model.TaskModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {

}
