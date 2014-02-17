package com.example.taskslist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class TasksView extends Activity {
	
	TasksAdapter tasksAdapter;
	
	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tasks_view);
		
		listView = (ListView) findViewById(R.id.tasks_ListView);
		
		tasksAdapter = new TasksAdapter();
		listView.setAdapter(tasksAdapter);
		
		//---Get Intent -----
		Intent i = getIntent();
		Task task = (Task)i.getSerializableExtra("Task");
		tasksAdapter.addTask(task);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tasks_view, menu);
		return true;
	}

	public ListView getListView() {
		return listView;
	}
}
