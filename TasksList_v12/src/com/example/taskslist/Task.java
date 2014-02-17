package com.example.taskslist;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Task implements Serializable, Comparable {
	
	private Date date;
	protected String description;
	
	public abstract int getBackgroundColor();
	public abstract String getDescription();
	
	public Task(Date aDate, String text) {
		date = aDate;
		description = text;
	}
	
	public int compareTo(Object other) {
		Task otherTask = (Task)other;
		return this.date.compareTo(otherTask.date);
	}
	
	public String getText() {
		return description;
	}

	public Date getDate() {
		return date;
	}
	
	public String getDateText() {

		String fDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		return fDate;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	public String convertToTitleCase() {
		//Title Case (all first letters capitalized)
		String originalText = getDescription();
		String trimmedText = originalText.trim();
		final String DELIMITERS = " ,"; //cause the following character to be capitalized
		
		StringBuilder sb = new StringBuilder();
		boolean capitalizeNext = true;
		
		for(char c: trimmedText.toCharArray()) {
			if(capitalizeNext) 
				c = Character.toUpperCase(c);
			else
				c = Character.toLowerCase(c);
			sb.append(c);
			//String.indexOf() returns the index within the Delimiters
			//of the first occurrence of the specified character
			//-1 if the character is not space or comma
			//i.e. as long as no space or comma is encountered
			//capitalizeNext = false;
			capitalizeNext = (DELIMITERS.indexOf(c) >= 0);
		}
		
		String textToShow = sb.toString();
		return textToShow;
	}
}
