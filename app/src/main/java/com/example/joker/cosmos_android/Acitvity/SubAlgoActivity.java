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
import android.view.View;
import android.widget.Toast;

import com.example.joker.cosmos_android.Adapter.FileAdapter;
import com.example.joker.cosmos_android.Adapter.SubAlgoAdapter;
import com.example.joker.cosmos_android.Database.AlgorithmFiles;
import com.example.joker.cosmos_android.Database.SubAlgorithms;
import com.example.joker.cosmos_android.R;
import com.example.joker.cosmos_android.Utils.FileClickListner;
import com.example.joker.cosmos_android.Utils.SubAlgorithmClickListener;
import com.example.joker.cosmos_android.ViewModel.SubAlgoViewModel;

import java.util.ArrayList;
import java.util.List;

public class SubAlgoActivity extends AppCompatActivity implements SubAlgorithmClickListener, FileClickListner {

    private SubAlgoViewModel viewModel;

    private RecyclerView subAlgoRecyclerView, fileRecyclerView;
    private SubAlgoAdapter adapter;
    private FileAdapter fileAdapter;

    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_algo);

        viewModel = ViewModelProviders.of(this).get(SubAlgoViewModel.class);

        View bottomSheet = findViewById(R.id.bottom_sheet);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        if (viewModel.getId() == null) {
            Intent intent = getIntent();
            String id = intent.getStringExtra("id");
            viewModel.setId(id);
        }

        subAlgoRecyclerView = findViewById(R.id.subAlgoRecyclerView);
        // subAlgoRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setSpanSizeLookup(new GridLayoutManager.DefaultSpanSizeLookup());
        subAlgoRecyclerView.setLayoutManager(manager);

        adapter = new SubAlgoAdapter(this);
        subAlgoRecyclerView.setAdapter(adapter);


        fileRecyclerView = findViewById(R.id.fileRecyclerView);
        fileRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        fileAdapter = new FileAdapter(this);

        fileRecyclerView.setAdapter(fileAdapter);


        viewModel.getSubAlgoById(viewModel.getId()).observe(this, subAlgorithms -> {

            assert subAlgorithms != null;

            adapter.setAdapter(subAlgorithms);

            for (SubAlgorithms subAlgo : subAlgorithms) {
                Log.d("test", subAlgo.toString());
            }
        });

    }


    //gets called when subalgo is clicked
    @Override
    public void languages(int id) {

        if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            viewModel.getFilesBySubAlgoId(id).observe(SubAlgoActivity.this, algorithmFiles -> {

                List<String> fileName = new ArrayList<>();

                if(algorithmFiles != null){
                    fileName = getFileName(algorithmFiles);
                }

                fileAdapter.setAdapter(fileName);

            });

        } else {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }

    private List<String> getFileName(AlgorithmFiles algorithmFiles) {
        List<String> fileNames = new ArrayList<>();

        if(!algorithmFiles.getC().equals("null")){
            fileNames.add(algorithmFiles.getC());
        }

        if(!algorithmFiles.getCpp().equals("null")){
            fileNames.add(algorithmFiles.getCpp());
        }

        if(!algorithmFiles.getCs().equals("null")){
            fileNames.add(algorithmFiles.getCs());
        }

        if(!algorithmFiles.getData().equals("null")){
            fileNames.add(algorithmFiles.getData());
        }

        if(!algorithmFiles.getElm().equals("null")){
            fileNames.add(algorithmFiles.getElm());
        }

        if(!algorithmFiles.getExs().equals("null")){
            fileNames.add(algorithmFiles.getExs());
        }

        if(!algorithmFiles.getF().equals("null")){
            fileNames.add(algorithmFiles.getF());
        }

        if(!algorithmFiles.getGo().equals("null")){
            fileNames.add(algorithmFiles.getGo());
        }

        if(!algorithmFiles.getH().equals("null")){
            fileNames.add(algorithmFiles.getH());
        }

        if(!algorithmFiles.getHs().equals("null")){
            fileNames.add(algorithmFiles.getHs());
        }

        if(!algorithmFiles.getJava().equals("null")){
            fileNames.add(algorithmFiles.getJava());
        }

        if(!algorithmFiles.getJl().equals("null")){
            fileNames.add(algorithmFiles.getJl());
        }

        if(!algorithmFiles.getJs().equals("null")){
            fileNames.add(algorithmFiles.getJs());
        }

        if(!algorithmFiles.getKt().equals("null")){
            fileNames.add(algorithmFiles.getKt());
        }

        if(!algorithmFiles.getM().equals("null")){
            fileNames.add(algorithmFiles.getM());
        }

        if(!algorithmFiles.getMd().equals("null")){
            fileNames.add(algorithmFiles.getMd());
        }

        if(!algorithmFiles.getPhp().equals("null")){
            fileNames.add(algorithmFiles.getPhp());
        }

        if(!algorithmFiles.getPy().equals("null")){
            fileNames.add(algorithmFiles.getPy());
        }

        if(!algorithmFiles.getRb().equals("null")){
            fileNames.add(algorithmFiles.getRb());
        }

        if(!algorithmFiles.getRs().equals("null")){
            fileNames.add(algorithmFiles.getRs());
        }

        if(!algorithmFiles.getSh().equals("null")){
            fileNames.add(algorithmFiles.getSh());
        }

        if(!algorithmFiles.getSml().equals("null")){
            fileNames.add(algorithmFiles.getSml());
        }

        if(!algorithmFiles.getSwift().equals("null")){
            fileNames.add(algorithmFiles.getSwift());
        }

        if(!algorithmFiles.getTs().equals("null")){
            fileNames.add(algorithmFiles.getTs());
        }

        return fileNames;
    }

    @Override
    public void onBackPressed() {

        if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED){
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }else{
            super.onBackPressed();
        }

    }

    //gets called when filename is called
    @Override
    public void onFileClick(String fileName) {


        Toast.makeText(this,fileName,Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getApplicationContext(),File.class);
        //intent.putExtra("filename",fileName);
        startActivity(intent);


    }
}
