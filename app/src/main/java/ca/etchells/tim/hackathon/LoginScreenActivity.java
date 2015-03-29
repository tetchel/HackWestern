package ca.etchells.tim.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
    }

    public void loginButtonClicked(View view){
        final Pattern EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        EditText emailET = (EditText) findViewById(R.id.loginEmailEt);

        Matcher matcher = EMAIL_ADDRESS_REGEX.matcher(emailET.getText().toString());

        if(matcher.find()) {
            //valid
            Intent mainIntent = new Intent(LoginScreenActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }
        else {
            Toast.makeText(this, "Not a valid email address", Toast.LENGTH_SHORT).show();
        }
    }

    public void createButtonClicked(View view){
        Intent signupIntent = new Intent(LoginScreenActivity.this, PatientSignupActivity.class);
        startActivity(signupIntent);
    }
}
