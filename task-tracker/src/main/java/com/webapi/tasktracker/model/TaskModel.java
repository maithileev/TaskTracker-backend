package com.webapi.tasktracker.model;

import java.util.Date;

public class TaskModel {

	private long id;
	private String username;
	private String description;
	private Date targetDate;
	private boolean status;
	private String priority;
	
	public TaskModel(long id, String username, String description, Date targetDate, boolean status, String priority) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.status = status;
		this.priority = priority;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskModel other = (TaskModel) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "TaskModel [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", status=" + status + ", priority=" + priority + "]";
	}

	
	
	
}
