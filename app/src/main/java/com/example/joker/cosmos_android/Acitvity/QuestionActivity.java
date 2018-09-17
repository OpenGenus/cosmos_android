package com.example.joker.cosmos_android.Acitvity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.joker.cosmos_android.Adapter.QuestionAdapter;
import com.example.joker.cosmos_android.CirclePagerIndicatorDecoration;
import com.example.joker.cosmos_android.R;
import com.example.joker.cosmos_android.ViewModel.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {


    List<Question> productList;
    //the recyclerview
    RecyclerView recyclerView;
    String course_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_main);

        course_name = getIntent().getStringExtra("course_name");
        Toast.makeText(this, course_name, Toast.LENGTH_SHORT).show();

        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //initializing the productlist
        productList = new ArrayList<>();
        //adding some items to our list

        for (int count = 1; count < 6; count++) {
            StringBuilder sb = new StringBuilder();
            String line;

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(getApplicationContext().getAssets().open("Question_Bank/" + course_name + "/File" + count + ".txt")));
                line = reader.readLine();
                while (line != null) {

                    sb.append(line);
                    line = reader.readLine();
                    sb.append("\n");

                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Toast.makeText(this,sb,Toast.LENGTH_SHORT).show();
            productList.add(new Question(sb.toString()));


        }


        //creating recyclerview adapter
        QuestionAdapter adapter = new QuestionAdapter(this, productList);
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new CirclePagerIndicatorDecoration());


    }


}
