package com.example.taskslist;

import java.util.Date;

import android.R.color;

public class NormalTask extends Task {
	
	public NormalTask(Date date, String text) {
		super(date, text);
	}
	
	public int getBackgroundColor() {
		
		return color.holo_blue_bright;
		
	}
	
	public String getDescription() {
		return ("Normal: " + description);
	}

}

