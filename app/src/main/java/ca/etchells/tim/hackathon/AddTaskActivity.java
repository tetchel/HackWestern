package ca.etchells.tim.hackathon;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTaskActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);

        String taskDate = ((EditText) findViewById(R.id.tskDate)).getText().toString();
        String taskDescrip = ((EditText) findViewById(R.id.tskDescrip)).getText().toString();

        SimpleDateFormat sdf = TasksFragment.getDateFormat();
        Date d = null;
        try {
            d = sdf.parse(taskDate);
        }
        catch(ParseException pe) {
            Toast.makeText(this, "Date must be dd/mm/yyyy hh:mm", Toast.LENGTH_LONG).show();
        }

        TasksFragment.addTask(taskDescrip, d);

    }
}
