package com.example.taskslist;

import java.util.Iterator;
import java.util.TreeSet;

public class Model {

	private static Model instance = null;
	
	private TreeSet<Task> tasks;
	
	public static Model getInstance() {
		
		if(instance == null)
			instance = new Model();
		
		return instance;
		
	}
	
	private Model() {
		tasks = new TreeSet<Task>();
	}
	
	public int getSize() {
		return tasks.size();
	}
	
	/*Replaced with the method below since TreeSets do not support the get(index) method
	public Task getItem(int index) {
		return tasks.get(index);
	}
	*/
	
	public Task getItem(int index) {
		
		Iterator<Task> iter = tasks.iterator();
		int i = 0;
		Task current = null;
		while(iter.hasNext() && i <= index) {
			current = iter.next();
			i++;
		}
		
		return current;
	}
	
	public boolean addTask(Task task) {
		return tasks.add(task);
	}
	

}
