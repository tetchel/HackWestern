package ca.etchells.tim.hackathon;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.parse.Parse;
import com.parse.ParseUser;

public class MainActivity extends FragmentActivity {

    private static final String VALUE = "OFX6gh6w8IuOrcZSJNCgrY7S05LlOGd0gDudwl6p";
    private static final String KEY =   "kugjKitmknJ9cMEHX8PAgVf4LNJxKkDzYpLSEXvn";

    private boolean showAdd = false;
    private Menu menuRef;

    ActionBar.Tab   home, tasks, people, calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();

                home = actionBar.newTab().setText(R.string.home);
                tasks = actionBar.newTab().setText(R.string.tasks);
                people = actionBar.newTab().setText(R.string.people);
                calendar = actionBar.newTab().setText(R.string.calendar);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, KEY, VALUE );

        if (ParseUser.getCurrentUser() == null) {

            Intent intent = new Intent(MainActivity.this,
                    LoginSignupActivity.class);
            startActivity(intent);
            ParseUser.logOut();
        }


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
    public boolean onCreateOptionsMenu(Menu menu) {
      //  menuRef = menu;
      //  if(showAdd) {
            getMenuInflater().inflate(R.menu.menu, menu);
      //  }
        Log.d("mainActivity", "Oncreating options menu");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_add_task:
                Log.d("MainActivity", "Add a new task");
//                return true;
//            case R.id.action_settings:
//                return true;

//            default:
//                return false;
        //}
        return super.onOptionsItemSelected(item);
    }

    public class TabListener implements ActionBar.TabListener {
        Fragment fragment;

        public TabListener(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

            if(tab == people || tab == tasks){
              //  showAdd = true;
                Log.d("mainActivity", "Tab equals people or tasks");
            }
//            else {
//                showAdd = false;
//            }
         //   onCreateOptionsMenu(menuRef);
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
