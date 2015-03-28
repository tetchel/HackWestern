package ca.etchells.tim.hackathon;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;
import com.example.tim.hackathon.R;

public class CalendarFragment extends Activity {
    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_fragment);
        calendar = (CalendarView) findViewById(R.id.calendarView1);
        calendar.setOnDateChangeListener(new OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        "Selected date is :\n\n" + dayOfMonth + "-" + month
                                + "-" + year, Toast.LENGTH_LONG).show();
            }
        });
    }

}