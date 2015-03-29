package ca.etchells.tim.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Spencer on 2015-03-29.
 */
public class ChooseUserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);
    }

    public void patientButtonClicked(View view) {
        Intent patientIntent = new Intent(ChooseUserActivity.this, PatientSignupActivity.class);
        boolean isPatient = true;
        startActivity(patientIntent);
    }

}