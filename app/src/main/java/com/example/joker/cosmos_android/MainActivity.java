package com.example.joker.cosmos_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.joker.cosmos_android.Adapter.AlgorithmAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlgorithmAdapter algorithmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.algorithm_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        algorithmAdapter = new AlgorithmAdapter(MainActivity.this);
        recyclerView.setAdapter(algorithmAdapter);


    }
}
