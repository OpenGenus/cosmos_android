package com.example.joker.cosmos_android;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.joker.cosmos_android.ViewModel.SplashViewModel;

public class SplashActivity extends AppCompatActivity {

    private SplashViewModel splashViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel.class);

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

            ProgressDialog progressDialog = new ProgressDialog(SplashActivity.this);
            progressDialog.setTitle("Preparing Database");
            progressDialog.setTitle("Please wait...");
            progressDialog.setCancelable(false);

            splashViewModel.populateDatabase();

            progressDialog.dismiss();
        }

        startMainActivity();

    }

    private void startMainActivity() {

        startActivity(new Intent(SplashActivity.this,AlgorithmsActivity.class));
        finish();

    }

}
