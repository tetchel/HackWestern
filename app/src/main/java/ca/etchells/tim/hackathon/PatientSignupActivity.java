package ca.etchells.tim.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Rohit on 15-03-29.
 */
public class PatientSignupActivity extends Activity{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.patient_signup);
        }

        public void addButtonClicked(View view){
            Intent loginIntent = new Intent(PatientSignupActivity.this, LoginScreenActivity.class);
            startActivity(loginIntent);
        }
    }

