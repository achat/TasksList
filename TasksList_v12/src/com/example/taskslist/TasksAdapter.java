package com.example.taskslist;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TasksAdapter extends BaseAdapter {

	private Model model;

	public TasksAdapter() {
		model = Model.getInstance();
	}
	
	public boolean addTask(Task task) {
		return model.addTask(task);
	}
	
	@Override
	public int getCount() {
		return model.getSize();
	}

	@Override
	public Object getItem(int index) {
		return model.getItem(index);
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	@Override
	public View getView(int index, View view, ViewGroup parent) {
		
		//LayoutInflater: Instantiates a layout XML file into its corresponding View objects
		if(view == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			
			view = inflater.inflate(R.layout.tasks_list_item, parent, false);
			
		}
		
		populateView(index, view);
			
		return view;
	}

	private void populateView(int index, View view) {
		Task task = model.getItem(index);
		
		TextView descriptionTextView = (TextView)view.findViewById(R.id.description_view);
		
		String textToShow = task.convertToTitleCase();
		
		descriptionTextView.setText(textToShow);
		
		TextView dateTextView = (TextView)view.findViewById(R.id.date_view);
		
		dateTextView.setText(task.getDateText());
		
		int color = task.getBackgroundColor();
		
		descriptionTextView.setBackgroundResource(color);
		dateTextView.setBackgroundResource(color);
	}
}
