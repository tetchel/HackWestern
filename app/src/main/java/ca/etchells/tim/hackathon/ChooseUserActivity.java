package ca.etchells.tim.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseUserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);
    }

    public void patientButtonClicked(View view) {
        startPatientIntent(true);
    }

    public void caretakerButtonClicked(View view) {
        startPatientIntent(false);
    }

    private void startPatientIntent(boolean isPatient) {
        Intent patientIntent = new Intent(ChooseUserActivity.this, PatientSignupActivity.class);
        patientIntent.putExtra("isPatient", isPatient);
        startActivity(patientIntent);
    }

}