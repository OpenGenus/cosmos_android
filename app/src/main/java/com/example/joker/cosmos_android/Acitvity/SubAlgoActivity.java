package com.example.joker.cosmos_android.Acitvity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.joker.cosmos_android.Adapter.SubAlgoAdapter;
import com.example.joker.cosmos_android.Database.SubAlgorithms;
import com.example.joker.cosmos_android.R;
import com.example.joker.cosmos_android.Utils.SubAlgorithmClickListener;
import com.example.joker.cosmos_android.ViewModel.SubAlgoViewModel;

import java.util.List;

public class SubAlgoActivity extends AppCompatActivity implements SubAlgorithmClickListener{

    private SubAlgoViewModel viewModel;

    private RecyclerView recyclerView,frecyclerView;
    private SubAlgoAdapter adapter;

    private BottomSheetBehavior mBottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_algo);

        viewModel = ViewModelProviders.of(this).get(SubAlgoViewModel.class);

        android.view.View bottomSheet = findViewById(R.id.bottom_sheet);

       mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);


        if(viewModel.getId()  == null) {
            Intent intent = getIntent();
            String id = intent.getStringExtra("id");
            viewModel.setId(id);
        }

        recyclerView = findViewById(R.id.subAlgoRecyclerView);
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));



        GridLayoutManager manager=new GridLayoutManager(this,2);
        manager.setSpanSizeLookup(new GridLayoutManager.DefaultSpanSizeLookup());
        recyclerView.setLayoutManager(manager);


        adapter = new SubAlgoAdapter(this);
        recyclerView.setAdapter(adapter);


        viewModel.getSubAlgoById(viewModel.getId()).observe(this, subAlgorithms -> {

            assert subAlgorithms != null;

            adapter.setAdapter(subAlgorithms);

            for(SubAlgorithms subAlgo : subAlgorithms){
                Log.d("test",subAlgo.toString());
            }
        });

    }


    @Override
    public void languages(int id) {

        Toast.makeText(this,"heyy card"+id,Toast.LENGTH_SHORT).show();
        if(mBottomSheetBehavior.getState()==BottomSheetBehavior.STATE_COLLAPSED) {

            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
        else
        {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }
}
