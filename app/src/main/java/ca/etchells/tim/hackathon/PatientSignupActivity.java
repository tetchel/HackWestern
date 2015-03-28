package ca.etchells.tim.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Rohit on 15-03-28.
 */
public class PatientSignupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_signup);

    }

    public void signupButtonClicked(){
        Intent loginIntent = new Intent(PatientSignupActivity.this, LoginScreenActivity.class);
        startActivity(loginIntent);
    }
}
