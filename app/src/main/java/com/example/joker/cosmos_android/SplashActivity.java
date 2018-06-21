package com.example.joker.cosmos_android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.joker.cosmos_android.Repositiory.Repositiory;
import com.example.joker.cosmos_android.Utils.DatabaseInitializer;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //check for new user
        checkForUser();

    }

    private void checkForUser() {

        SharedPreferences sp = getSharedPreferences("details",MODE_PRIVATE);

        boolean isNewUser = sp.getBoolean("new",true);

        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("new",false);
        editor.apply();

        if(isNewUser){

            initaliseDatabase();
        }

        startMainActivity();

    }

    private void initaliseDatabase() {

        Repositiory repositiory = Repositiory.getInstance(SplashActivity.this);
        DatabaseInitializer initializer = new DatabaseInitializer(repositiory);

        initializer.insertAlogs();


    }

    private void startMainActivity() {

        startActivity(new Intent(SplashActivity.this,AlgorithmsActivity.class));

    }
}
