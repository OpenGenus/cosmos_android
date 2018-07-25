package com.example.joker.cosmos_android.Acitvity;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joker.cosmos_android.Adapter.AlgorithmAdapter;
import com.example.joker.cosmos_android.R;
import com.example.joker.cosmos_android.Utils.AlgorithmsClickListener;
import com.example.joker.cosmos_android.ViewModel.AlgorithmsViewModel;



import java.util.Objects;

public class Tab1 extends Fragment implements AlgorithmsClickListener {

    private RecyclerView recyclerView;
    private AlgorithmAdapter algorithmAdapter;
    private AlgorithmsViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab1, container, false);

        viewModel = ViewModelProviders.of(this).get(AlgorithmsViewModel.class);

        recyclerView = view.findViewById(R.id.algoRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        algorithmAdapter = new AlgorithmAdapter(this, 1);

        recyclerView.setAdapter(algorithmAdapter);

        //setting up the observer
        viewModel.getAlgos().observe(Objects.requireNonNull(getActivity()), algorithms -> {

            algorithmAdapter.setAlgorithms(algorithms);
//            Log.d("test", " returned length "+algorithms.size());

        });

        return view;
    }


    @Override
    public void getSubAlgo(String id) {

        Intent intent = new Intent(getContext(),SubAlgoActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);

    }
}
