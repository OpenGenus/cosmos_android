package com.example.joker.cosmos_android.Acitvity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.joker.cosmos_android.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class File extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent i = getIntent();
        String fname = i.getStringExtra("filename");
        textView = findViewById(R.id.fileTextView);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getApplicationContext().getAssets().open("random.txt")));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                sb.append("\n");
                sb.append(line);
                line = reader.readLine();

            }
            reader.close();
            textView.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
