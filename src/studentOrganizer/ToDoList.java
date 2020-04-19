package studentOrganizer;

import java.util.ArrayList;
import java.util.Iterator;

public class ToDoList {
	
	ArrayList<Task> toDoList;
	
	public ToDoList() {
		this.toDoList = new ArrayList<Task>();
	}
	
	public int size() {
		return toDoList.size();
	}
	
	public void addTask(Task newTask) {
		this.toDoList.add(newTask);
	}
	
	public void removeTask(int taskPosition) {
		this.toDoList.remove(taskPosition);
	}
	
	public Task getTask(int taskPosition) {
		return this.toDoList.get(taskPosition);
	}
	
	public void markTaskCompleted(int taskPosition) {
		Task task = this.toDoList.get(taskPosition);
		this.toDoList.set(taskPosition, task.markCompleted());
	}
	
	public void markTaskNotCompleted(int taskPosition) {
		Task task = this.toDoList.get(taskPosition);
		this.toDoList.set(taskPosition, task.markNotCompleted());
	}
	
	public void markTaskUrgent(int taskPosition) {
		Task task = this.toDoList.get(taskPosition);
		this.toDoList.set(taskPosition, task.markUrgent());
	}
	
	public void markTaskNotUrgent(int taskPosition) {
		Task task = this.toDoList.get(taskPosition);
		this.toDoList.set(taskPosition, task.markNotUrgent());
	}
	
	public void removeAllCompletedTasks() {
		Iterator<Task> iterator = this.toDoList.iterator();
		while (iterator.hasNext()) {
			Task task = iterator.next();
			if (task.isCompleted()) {
				iterator.remove();
			}
		}
	}
	
	public void markAllTasksAsCompleted() {
		for (Task task: this.toDoList) {
			if (!task.isCompleted()) {
				int taskPosition = this.toDoList.indexOf(task);
				this.toDoList.set(taskPosition, task.markCompleted());
			}
		}
	}
	
	public void sortAllTasks() {
		ArrayList<Task> sortedTasks = new ArrayList<Task>();
		sortedTasks.addAll(this.findUrgentNotCompleted());
		sortedTasks.addAll(this.findNotUrgentNotCompleted());
		sortedTasks.addAll(this.findUrgentCompleted());
		sortedTasks.addAll(this.findNotUrgentCompleted());
		this.toDoList.clear();
		this.toDoList.addAll(sortedTasks);
	}
	
	private ArrayList<Task> findUrgentNotCompleted() {
		ArrayList<Task> urgentNotCompleted = new ArrayList<Task>();
		for (Task task: this.toDoList) {
			if (task.isUrgent() && !task.isCompleted()) {
				urgentNotCompleted.add(task);
			}
		}
		return urgentNotCompleted;
	}
	
	private ArrayList<Task> findNotUrgentNotCompleted() {
		ArrayList<Task> notUrgentNotCompleted = new ArrayList<Task>();
		for (Task task: this.toDoList) {
			if (!task.isUrgent() && !task.isCompleted()) {
				notUrgentNotCompleted.add(task);
			}
		}
		return notUrgentNotCompleted;
	}
	
	private ArrayList<Task> findUrgentCompleted() {
		ArrayList<Task> urgentCompleted = new ArrayList<Task>();
		for (Task task: this.toDoList) {
			if (task.isUrgent() && task.isCompleted()) {
				urgentCompleted.add(task);
			}
		}
		return urgentCompleted;
	}
	
	private ArrayList<Task> findNotUrgentCompleted() {
		ArrayList<Task> notUrgentCompleted = new ArrayList<Task>();
		for (Task task: this.toDoList) {
			if (!task.isUrgent() && task.isCompleted()) {
				notUrgentCompleted.add(task);
			}
		}
		return notUrgentCompleted;
	}
	
	
	

}
