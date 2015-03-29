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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.people_fragment, container, false);
        setHasOptionsMenu(true);

        ArrayList<String> data = new ArrayList<>();
        data.add("Tim Etchells");
        data.add("Rohit Das");
        data.add("Spencer Roebotham");

        HashMap<String, List<String>> childData = new HashMap<>();
        ArrayList<String> data1 = new ArrayList<>();
        data1.add("1231231234");
        data1.add("tim@email.com");
        childData.put("Tim Etchells", data1);
        ArrayList<String> data2 = new ArrayList<>();
        data2.add("3213213213");
        data2.add("Rohit@email.com");
        childData.put("Rohit Das", data2);
        ArrayList<String> data3 = new ArrayList<>();
        data3.add("1111111111");
        data3.add("spencer@canadapost.box");
        childData.put("Spencer Roebotham", data3);

        ExpandableListView elv = (ExpandableListView) rootView.findViewById
                (R.id.expandablePeopleListView);

        elv.setAdapter(new ExpandableListAdapter(rootView.getContext(), data, childData));

        return rootView;
    }

}