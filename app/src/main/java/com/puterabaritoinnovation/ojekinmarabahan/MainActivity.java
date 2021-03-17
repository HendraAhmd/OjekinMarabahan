package com.puterabaritoinnovation.ojekinmarabahan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getUserNameLocal();

    }

    public void getUserNameLocal () {
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");

        if (username_key_new.isEmpty()){
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent gotogetstarted = new Intent(MainActivity.this, GetStartedActivity.class);
                    startActivity(gotogetstarted);
                    finish();
                }
            }, 1000);
        }
        else {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent gotogetstarted = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(gotogetstarted);
                    finish();
                }
            }, 1000);
        }

    }

}
