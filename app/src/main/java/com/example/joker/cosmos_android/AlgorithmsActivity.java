package com.example.joker.cosmos_android;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.joker.cosmos_android.Adapter.AlgorithmAdapter;
import com.example.joker.cosmos_android.Database.Algorithms;
import com.example.joker.cosmos_android.ViewModel.AlgorithmsViewModel;

import java.util.List;

public class AlgorithmsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlgorithmAdapter algorithmAdapter;
    private AlgorithmsViewModel algorithmsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        algorithmsViewModel = ViewModelProviders.of(this).get(AlgorithmsViewModel.class);

        recyclerView = findViewById(R.id.algorithm_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        algorithmAdapter = new AlgorithmAdapter(AlgorithmsActivity.this);
        recyclerView.setAdapter(algorithmAdapter);

        algorithmsViewModel.getAlgos().observe(AlgorithmsActivity.this, algorithms -> {
            algorithmAdapter.setAlgorithms(algorithms);
            Log.d("test",""+algorithms.size());
        });

    }
}
