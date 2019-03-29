package com.example.androidlab1;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread backgrounds = new Thread() {
            public void run() {
                try {
                    sleep(2*1000);
                    Intent i = new Intent(getBaseContext(), ElementsList.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        backgrounds.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
