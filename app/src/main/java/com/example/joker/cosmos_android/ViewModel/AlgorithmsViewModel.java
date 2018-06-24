package com.example.joker.cosmos_android.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.joker.cosmos_android.Database.Algorithms;
import com.example.joker.cosmos_android.Repositiory.Repository;

import java.util.List;

public class AlgorithmsViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<Algorithms>> algos;

    public AlgorithmsViewModel(@NonNull Application application) {
        super(application);

        repository = Repository.getInstance(application.getApplicationContext());
        algos = repository.getAllAlgos();

    }


    public LiveData<List<Algorithms>> getAlgos() {
        return algos;
    }


}
