package com.example.joker.cosmos_android.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.joker.cosmos_android.Database.Algorithms;
import com.example.joker.cosmos_android.Repositiory.Repositiory;

import java.util.List;

public class AlgorithmsViewModel extends AndroidViewModel {

    private Repositiory repositiory;
    private LiveData<List<Algorithms>> algos;

    public AlgorithmsViewModel(@NonNull Application application) {
        super(application);

        repositiory = Repositiory.getInstance(application.getApplicationContext());
        algos = repositiory.getAllAlgos();

    }


    public LiveData<List<Algorithms>> getAlgos() {
        return algos;
    }

    public void insert(Algorithms algorithms){
        repositiory.insertAlgo(algorithms);
    }
}
