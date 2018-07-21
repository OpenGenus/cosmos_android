package com.example.joker.cosmos_android.Acitvity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;

import com.example.joker.cosmos_android.Adapter.QuestionAdapter;
import com.example.joker.cosmos_android.CirclePagerIndicatorDecoration;
import com.example.joker.cosmos_android.R;
import com.example.joker.cosmos_android.ViewModel.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {


    List<Question> productList;
    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_main);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        //initializing the productlist
        productList = new ArrayList<>();
        //adding some items to our list
        productList.add(new Question("Pick the Ticket", "Select the day,Pick your ticket.We give you the best prices.We guaranteed"
        ));
        productList.add(new Question("Pick the Ticket", "Select the day,Pick your ticket.We give you the best prices.We guaranteed"
        ));
        productList.add(new Question("Pick the Ticket", "Select the day,Pick your ticket.We give you the best prices.We guaranteed"
        ));
        //creating recyclerview adapter
        QuestionAdapter adapter = new QuestionAdapter(this, productList);
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new CirclePagerIndicatorDecoration());


    }


}
