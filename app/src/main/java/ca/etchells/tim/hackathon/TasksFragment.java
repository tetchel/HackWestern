package ca.etchells.tim.hackathon;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TasksFragment extends Fragment {

    private final String TAG = "TasksFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tasks_fragment, container, false);
        setHasOptionsMenu(true);

        ListView taskListView = (ListView) rootView.findViewById(R.id.tasksListView);

        ArrayList<String> data = new ArrayList<>();
        data.add("Hello my name is Tim");
        data.add("Goodbye");

        taskListView.setAdapter(new ListAdapter(getActivity(), data));

        return rootView;
    }

    private class ListAdapter extends BaseAdapter {

        private ArrayList<String> taskList;
        private LayoutInflater inflater = null;

        public ListAdapter(Context context, ArrayList<String> data) {
            this.taskList = data;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return taskList.size();
        }

        @Override
        public Object getItem(int position) {
            return taskList.get(position);
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
            TextView text = (TextView) v.findViewById(R.id.taskTextView);
            text.setText(taskList.get(position));
            return v;
        }
    }
}