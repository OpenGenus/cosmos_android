package com.example.joker.cosmos_android.Acitvity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joker.cosmos_android.Adapter.AlgorithmAdapter;
import com.example.joker.cosmos_android.R;
import com.example.joker.cosmos_android.ViewModel.AlgorithmsViewModel;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.Objects;

public class Tab1 extends Fragment {

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


        algorithmAdapter = new AlgorithmAdapter(getContext());

        recyclerView.setAdapter(algorithmAdapter);

        //setting up the observer
        viewModel.getAlgos().observe(Objects.requireNonNull(getActivity()), algorithms -> {

            algorithmAdapter.setAlgorithms(algorithms);
            Log.d("test", " returned length "+algorithms.size());

        });

        return view;
    }


}
