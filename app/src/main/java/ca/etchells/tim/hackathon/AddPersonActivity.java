package ca.etchells.tim.hackathon;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddPersonActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_person_activity);

    }

    public void onAcceptClick(View view) {

        String firstName = null, lastName = null, number = null, email = null;

        while((firstName == null || lastName == null || number == null || email == null)) {

            firstName = ((EditText) findViewById(R.id.perFirstNameEt)).getText().toString();
            lastName = ((EditText) findViewById(R.id.perLastNameEt)).getText().toString();
            number = ((EditText) findViewById(R.id.perPhoneNum)).getText().toString();
            email = ((EditText) findViewById(R.id.perEmail)).getText().toString();

            PeopleFragment.addPerson(firstName + " " + lastName, number, email);
        }
        finish();
    }
}
