package com.example.joker.cosmos_android.Acitvity;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.joker.cosmos_android.Adapter.AlgorithmAdapter;
import com.example.joker.cosmos_android.Database.SubAlgorithms;
import com.example.joker.cosmos_android.R;
import com.example.joker.cosmos_android.Utils.AlgorithmsClickListener;
import com.example.joker.cosmos_android.ViewModel.AlgorithmsViewModel;

public class AlgorithmsActivity extends AppCompatActivity implements AlgorithmsClickListener {

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

    @Override
    public void getSubAlgo(String id) {

        algorithmsViewModel.getSubAlgosById(id).observe(AlgorithmsActivity.this, subAlgorithms -> {

            for(SubAlgorithms subAlgo : subAlgorithms){
                Log.d("subAlgoTest",subAlgo.toString());
            }

        });

    }
}
