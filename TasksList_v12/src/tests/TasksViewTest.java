package tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.widget.ListView;
import android.widget.TextView;

import com.example.taskslist.NormalTask;
import com.example.taskslist.Task;
import com.example.taskslist.TasksView;

public class TasksViewTest extends android.test.ActivityUnitTestCase<TasksView> {

	private TasksView activity;
	private ListView listView;
	
	public TasksViewTest() {
		super(TasksView.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = null;

		try {
			date = sdf.parse("2014/05/21");
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Task newTask = new NormalTask(date, "SampleTask");
		
		Intent intent = new Intent(getInstrumentation().getTargetContext(), TasksView.class);
		intent.putExtra("Task", newTask);
	    startActivity(intent, null, null);
	    activity = getActivity();
	    listView = activity.getListView();
	}
	
	public void testGetView() {
		
		Task task = (Task)listView.getItemAtPosition(0);
		
		assertEquals("Normal: SampleTask", task.getDescription());
		
		assertEquals("2014-05-21", task.getDateText());
		
		
	}


}
