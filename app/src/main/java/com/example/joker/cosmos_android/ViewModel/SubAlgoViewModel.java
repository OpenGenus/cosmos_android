package com.example.joker.cosmos_android.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.joker.cosmos_android.Database.AlgorithmFiles;
import com.example.joker.cosmos_android.Database.SubAlgorithms;
import com.example.joker.cosmos_android.Repositiory.Repository;

import java.util.List;

public class SubAlgoViewModel extends AndroidViewModel {

    private Repository repository;
    private String id;

    public SubAlgoViewModel(@NonNull Application application) {
        super(application);

        repository = Repository.getInstance(application.getApplicationContext());

    }

    public LiveData<List<SubAlgorithms>> getSubAlgoById(String id){
        return repository.getSubAlgoById(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LiveData<AlgorithmFiles> getFilesBySubAlgoId(int id) {
        return repository.getFilesBySubAlgoId(id);
    }
}
