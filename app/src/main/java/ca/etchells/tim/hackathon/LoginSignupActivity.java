
package ca.etchells.tim.hackathon;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginSignupActivity extends Activity {
    // Declare Variables
    Button loginbutton;
    Button signup;
    Button loginsignup;
    String emailTxt, passwordTxt, firstNameTxt, lastNameTxt, caretakerEmailTxt;
    EditText password, email, firstName, lastName, caretakerEmail;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        boolean isPatient = savedInstanceState.getBoolean("isPatient");

        // Get the view from main.xml
        setContentView(R.layout.login_screen);
        // Locate EditTexts in main.xml
        email = (EditText) findViewById(R.id.loginEmailEt);
        password = (EditText) findViewById(R.id.loginPasswordEt);
//        firstName = (EditText) findViewById(R.id.firstNameEt);
//        lastName = (EditText) findViewById(R.id.lastNameEt);

        // Locate Buttons in main.xml
        loginbutton = (Button) findViewById(R.id.loginLoginB);
        loginsignup = (Button) findViewById(R.id.loginSignupB);
//        if(isPatient)
//        {
//            email = (EditText) findViewById(R.id.);
//        }

        // Login Button Click Listener
        loginbutton.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // Retrieve the text entered from the EditText
                emailTxt = email.getText().toString();
                passwordTxt = password.getText().toString();
                firstNameTxt = firstName.getText().toString();
                lastNameTxt = lastName.getText().toString();


                // Send data to Parse.com for verification
                ParseUser.logInInBackground(emailTxt, passwordTxt,
                        new LogInCallback() {
                            public void done(ParseUser user, ParseException e) {
                                if (user != null) {

                                    Toast.makeText(getApplicationContext(),
                                            "Successfully Logged in",
                                            Toast.LENGTH_LONG).show();
                                    finish();
                                } else {
                                    Toast.makeText(
                                            getApplicationContext(),
                                            "No such user exist, please signup",
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
        // Sign up Button Click Listener
        loginsignup.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // Retrieve the text entered from the EditText
                emailTxt = email.getText().toString();
                passwordTxt = password.getText().toString();

                // Force user to fill up the form
                if (emailTxt.equals("") && passwordTxt.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please complete the sign up form",
                            Toast.LENGTH_LONG).show();

                } else {
                    // Save new user data into Parse.com Data Storage
                    ParseUser user = new ParseUser();
                    user.setUsername(emailTxt);
                    user.setPassword(passwordTxt);
                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                // Show a simple Toast message upon successful registration
                                Toast.makeText(getApplicationContext(),
                                        "Successfully Signed up, please log in.",
                                        Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Sign up Error", Toast.LENGTH_LONG)
                                        .show();
                            }
                        }
                    });
                }

            }
        });

    }
}