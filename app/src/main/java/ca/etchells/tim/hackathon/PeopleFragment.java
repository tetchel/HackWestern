package ca.etchells.tim.hackathon;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PeopleFragment extends Fragment {

    private static ArrayList<String> data;
    private static HashMap<String, List<String>> childData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.people_fragment, container, false);
        setHasOptionsMenu(true);

        data = new ArrayList<>();
        childData = new HashMap<>();

        //examples
        data.add("Tim Etchells");
        data.add("Rohit Das");
        ArrayList<String> child = new ArrayList<>(), child2 = new ArrayList<>();
        child.add("416 123 1234");
        child2.add("416 321 4321");
        child2.add("Rohit@email.com");
        childData.put("Tim Etchells", child);
        childData.put("Rohit Das", child2);

        ExpandableListView elv = (ExpandableListView) rootView.findViewById
                (R.id.expandablePeopleListView);

        elv.setAdapter(new ExpandableListAdapter(rootView.getContext(), data, childData));

        return rootView;
    }

    public static void addPerson(String name, String number, String email) {
        data.add(name);
        ArrayList<String> child = new ArrayList<>();
        child.add(number);
        child.add(email);
        childData.put(name, child);
    }
}