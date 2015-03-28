package ca.etchells.tim.hackathon;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

import com.example.tim.hackathon.R;

public class CalendarFragment extends Fragment {
    CalendarView calendar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.calendar_fragment, container, false);

        calendar = (CalendarView) root.findViewById(R.id.calendarView1);
        calendar.setOnDateChangeListener(new OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getActivity(),
                        "Selected date is :\n\n" + dayOfMonth + "-" + month
                                + "-" + year, Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}