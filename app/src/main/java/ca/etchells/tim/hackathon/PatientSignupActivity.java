package ca.etchells.tim.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PatientSignupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_signup);

    }

    public void signupButtonClicked(View view){
        Intent loginIntent = new Intent(PatientSignupActivity.this, LoginScreenActivity.class);
        startActivity(loginIntent);
    }
}
