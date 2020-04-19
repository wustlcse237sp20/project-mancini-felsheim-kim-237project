package studentOrganizer;

public class Task {
	
	String taskDescription;
	boolean completed;
	boolean urgent;
	
	public Task(String taskDescription) {
		this.taskDescription = taskDescription;
		this.completed = false;
		this.urgent = false;
	}
	
	public Task(String taskDescription, boolean urgent) {
		this.taskDescription = taskDescription;
		this.completed = false;
		this.urgent = urgent;
	}
	
	public Task markUrgent() {
		this.urgent = true;
		return this;
	}
	
	public Task markNotUrgent() {
		this.urgent = false;
		return this;
	}
	
	public Task markCompleted() {
		this.completed = true;
		return this;
	}
	
	public Task markNotCompleted() {
		this.completed = false;
		return this;
	}
	
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	public String getTaskDescription() {
		return this.taskDescription;
	}
	
	public boolean isUrgent() {
		return this.urgent;
	}
	
	public boolean isCompleted() {
		return this.completed;
	}

}
