package ca.etchells.tim.hackathon;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

public class TasksFragment extends Fragment {

    //should this REALLY be static
    private static LinkedHashMap<String, Date> data = new LinkedHashMap<>();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tasks_fragment, container, false);
        setHasOptionsMenu(true);

        ListView taskListView = (ListView) rootView.findViewById(R.id.tasksListView);

        taskListView.setAdapter(new ListAdapter(getActivity()));

        return rootView;
    }

    public static void addTask(String description, Date date) {
        data.put(description, date);
    }

    public static SimpleDateFormat getDateFormat() {
        return sdf;
    }

    private class ListAdapter extends BaseAdapter {

//        private LinkedHashMap<String, Date> taskMap;
        private LayoutInflater inflater = null;

        public ListAdapter(Context context) {
            try {
                data.put("Win Hack Western ", sdf.parse("29/03/2015 10:30"));
            }
            catch(ParseException pe) { }

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if(v == null)
                v = inflater.inflate(R.layout.single_task, null);

            final TextView text = (TextView) v.findViewById(R.id.taskTV);
            final TextView date = (TextView) v.findViewById(R.id.taskDateTV);
            final Button button = (Button) v.findViewById(R.id.doneButton);

            ArrayList<String> keys = new ArrayList<>(data.keySet());
            final String key = keys.get(position);

            text.setText(key);
            date.setText(sdf.format(data.get(key)));

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ViewGroup layout = (ViewGroup) button.getParent();
                    if (layout != null) {
                        layout.removeView(button);
                        layout.removeView(text);
                        layout.removeView(date);
                        data.remove(key);
                    }
                }
            });
            return v;
        }
    }
}