package ca.etchells.tim.hackathon;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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
        data.add("Tim");

        HashMap<String, List<String>> childData = new HashMap<>();
        ArrayList<String> data1 = new ArrayList<String>();
        data1.add("1231231234, tim@email.com");
        childData.put("Etchells", data1);

        ExpandableListView elv = (ExpandableListView) rootView.findViewById
                (R.id.expandablePeopleListView);

        elv.setAdapter(new ExpandableListAdapter(rootView.getContext(), data, childData));

        return rootView;
    }

}