package ca.etchells.tim.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
    private static final int SPLASH_TIMEOUT = 2000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent splashIntent = new Intent(SplashActivity.this, LoginScreenActivity.class);
                startActivity(splashIntent);

                finish();
            }

        }, SPLASH_TIMEOUT);
    }
}
