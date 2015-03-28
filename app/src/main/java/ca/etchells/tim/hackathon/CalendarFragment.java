package ca.etchells.tim.hackathon;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.example.tim.hackathon.R;

public class CalendarFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.calendar_fragment, container, false);

        CalendarView calendarView = (CalendarView) rootView.findViewById(R.id.calendarView);

        return rootView;
    }
}