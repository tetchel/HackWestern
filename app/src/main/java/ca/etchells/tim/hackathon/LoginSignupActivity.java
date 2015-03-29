
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

    Button loginbutton;
    Button loginsignup;
    String emailTxt, passwordTxt, firstNameTxt, lastNameTxt, caretakerEmailTxt;
    EditText password, email, firstName, lastName, caretakerEmail;
    boolean isPatient = true;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_screen);

        email = (EditText) findViewById(R.id.loginEmailEt);
        password = (EditText) findViewById(R.id.loginPasswordEt);
        firstName = (EditText) findViewById(R.id.firstNameEt);
        lastName = (EditText) findViewById(R.id.lastNameEt);


        loginbutton = (Button) findViewById(R.id.loginLoginB);
        loginsignup = (Button) findViewById(R.id.loginSignupB);
        if(isPatient)
        {
            caretakerEmail = (EditText) findViewById(R.id.caretakerEmailEt);
        }


        loginbutton.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {

                emailTxt = email.getText().toString();
                passwordTxt = password.getText().toString();
                firstNameTxt = firstName.getText().toString();
                lastNameTxt = lastName.getText().toString();
                caretakerEmailTxt = caretakerEmail.getText().toString();

                ParseUser.logInInBackground(emailTxt, passwordTxt,
                        new LogInCallback() {
                            public void done(ParseUser user, ParseException e) {
                                if (user != null) {

                                    Toast.makeText(getApplicationContext(),
                                            "Successfully logged in.",
                                            Toast.LENGTH_LONG).show();
                                    finish();
                                } else {
                                    Toast.makeText(
                                            getApplicationContext(),
                                            "No such user exists; please sign up.",
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });

        loginsignup.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {

                emailTxt = email.getText().toString();
                passwordTxt = password.getText().toString();

                if (emailTxt.equals("") && passwordTxt.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please complete the sign up form",
                            Toast.LENGTH_LONG).show();

                } else {

                    ParseUser user = new ParseUser();
                    user.setUsername(emailTxt);
                    user.setPassword(passwordTxt);
                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {

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