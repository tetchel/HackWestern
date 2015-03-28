package ca.etchells.tim.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Rohit on 15-03-28.
 */
public class LoginScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

    }

    public void loginButtonClicked(){
        Intent mainIntent = new Intent(LoginScreenActivity.this, MainActivity.class);
        startActivity(mainIntent);
    }

    public void createButtonClicked(){
        Intent signupIntent = new Intent(LoginScreenActivity.this, PatientSignupActivity.class);
        startActivity(signupIntent);
    }




}
