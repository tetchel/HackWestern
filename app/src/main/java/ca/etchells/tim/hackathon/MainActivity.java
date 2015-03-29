package ca.etchells.tim.hackathon;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.parse.Parse;

public class MainActivity extends FragmentActivity {

    private static final String VALUE = "OFX6gh6w8IuOrcZSJNCgrY7S05LlOGd0gDudwl6p";
    private static final String KEY =   "kugjKitmknJ9cMEHX8PAgVf4LNJxKkDzYpLSEXvn";
    private PeopleFragment pfrg;

    private ActionBar.Tab   home, tasks, people, calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);

        pfrg = new PeopleFragment();
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();

        home = actionBar.newTab().setText(R.string.home);
        tasks = actionBar.newTab().setText(R.string.tasks);
        people = actionBar.newTab().setText(R.string.people);
        calendar = actionBar.newTab().setText(R.string.calendar);

        Parse.enableLocalDatastore(getApplicationContext());
        Parse.initialize(getApplicationContext(), KEY, VALUE );

        //causes double login bug
//        if (ParseUser.getCurrentUser() == null) {
//
//            Intent intent = new Intent(MainActivity.this,
//                    LoginScreenActivity.class);
//            startActivity(intent);
//            ParseUser.logOut();
//        }

//        actionBar.setDisplayShowHomeEnabled(false);
//        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setTitle(R.string.app_name);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


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
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        Log.d("mainActivity", "Oncreating options menu");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("tag", "onOptionsItemsSelected");
        switch (item.getItemId()) {
            case R.id.action_add:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Add a task");
                builder.setMessage("What do you want to do?");
                builder.setPositiveButton("Add a Reminder", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Add a Contact", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, AddPersonActivity.class);
                        startActivity(intent);
                    }
                });

                builder.create().show();
                return true;
            case R.id.action_settings:
                //open settings?
                return true;
            default:
                return false;
        }
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
