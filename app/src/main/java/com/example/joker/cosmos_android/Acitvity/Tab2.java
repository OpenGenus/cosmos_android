package com.example.joker.cosmos_android.Acitvity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.joker.cosmos_android.Adapter.AlgorithmAdapter;
import com.example.joker.cosmos_android.R;
import com.example.joker.cosmos_android.Utils.CourseClickListener;
import com.example.joker.cosmos_android.ViewModel.AlgorithmsViewModel;

import java.util.Objects;

public class Tab2 extends Fragment implements CourseClickListener {
    Button button;
    RecyclerView rv;

    private AlgorithmAdapter algorithmAdapter;
    private AlgorithmsViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab2, container, false);

        viewModel = ViewModelProviders.of(this).get(AlgorithmsViewModel.class);

        button = (Button) v.findViewById(R.id.button);

        rv=v.findViewById(R.id.course_recycler_view);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));


        algorithmAdapter = new AlgorithmAdapter(this, 2);

        rv.setAdapter(algorithmAdapter);

        viewModel.getAlgos().observe(Objects.requireNonNull(getActivity()), algorithms -> {

            algorithmAdapter.setAlgorithms(algorithms);

        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  }
        });
        return v;

    }

    @Override
    public void getQuestion(String course_name) {

        Toast.makeText(getContext(),course_name,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), QuestionActivity.class);
        intent.putExtra("course_name",course_name);
        startActivity(intent);


    }
}
