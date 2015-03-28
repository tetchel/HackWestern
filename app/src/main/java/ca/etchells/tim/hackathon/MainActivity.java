package ca.etchells.tim.hackathon;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
//        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setTitle("Empower");
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);




        ActionBar.Tab   home = actionBar.newTab().setText("Home"),
                        tasks = actionBar.newTab().setText("Tasks"),
                        people = actionBar.newTab().setText("People"),
                        calendar = actionBar.newTab().setText("Calendar");

        home.setTabListener(new TabListener(new HomeFragment()));
        people.setTabListener(new TabListener(new PeopleFragment()));
        tasks.setTabListener(new TabListener(new TasksFragment()));
        calendar.setTabListener(new TabListener(new CalendarFragment()));

        actionBar.addTab(home);
        actionBar.addTab(people);
        actionBar.addTab(tasks);
        actionBar.addTab(calendar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }

    public class TabListener implements ActionBar.TabListener {
        Fragment fragment;

        public TabListener(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.replace(R.id.fragment_container, fragment);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(fragment);
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        }
    }
}
