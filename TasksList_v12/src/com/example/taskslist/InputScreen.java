package com.example.taskslist;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class InputScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_screen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.input_screen, menu);
		return true;
	}
	
	public void sendMessage(View view) {
		
		RadioButton radioNormal = (RadioButton) findViewById(R.id.normalRadio);
		RadioButton radioUrgent = (RadioButton) findViewById(R.id.urgentRadio);
		EditText dateEditText = (EditText) findViewById(R.id.dateEditText);
		
		String dateText = dateEditText.getText().toString();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date theDate = null;

		try {
			theDate = sdf.parse(dateText);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EditText descriptionEditText = (EditText) findViewById(R.id.descriptionEditText);
		
		String descriptionText = descriptionEditText.getText().toString();
		
		Task newTask = null;
				
		if(radioNormal.isChecked()) {
			newTask = new NormalTask(theDate, descriptionText);
		}
		else
			newTask = new UrgentTask(theDate, descriptionText);
		
		Intent intent = new Intent(this, TasksView.class);
		intent.putExtra("Task", newTask);
		startActivity(intent);
		
	}


}
