package com.example.taskslist;

import java.util.Date;

import android.R.color;

public class UrgentTask extends Task {
	
	public UrgentTask(Date date, String text) {
		super(date, text);
	}
	
	public int getBackgroundColor() {
		
		return color.holo_red_light;	
	}
	
	public String getDescription() {
		return ("Urgent: " + description);
	}

}
