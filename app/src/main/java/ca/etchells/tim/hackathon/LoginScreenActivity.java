package ca.etchells.tim.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.ProgressBar;


public class LoginScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
    }

    public void loginButtonClicked(View view){
        Intent mainIntent = new Intent(LoginScreenActivity.this, MainActivity.class);
        startActivity(mainIntent);
    }

    public void createButtonClicked(View view){
        Intent signupIntent = new Intent(LoginScreenActivity.this, PatientSignupActivity.class);
        startActivity(signupIntent);
    }

    public void progressbar(){
        private ProgressBar progressBar;
        private int progressStatus = 0;
    }
}
