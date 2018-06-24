package com.example.joker.cosmos_android.Repositiory;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.example.joker.cosmos_android.Database.AlgorithmDao;
import com.example.joker.cosmos_android.Database.AlgorithmFiles;
import com.example.joker.cosmos_android.Database.AlgorithmFilesDao;
import com.example.joker.cosmos_android.Database.Algorithms;
import com.example.joker.cosmos_android.Database.AppDatabase;
import com.example.joker.cosmos_android.Database.SubAlgorithms;
import com.example.joker.cosmos_android.Database.SubAlgorithmsDao;

import java.util.List;

public class Repository {

    private AlgorithmDao algorithmDao;
    private SubAlgorithmsDao subAlgorithmsDao;
    private AlgorithmFilesDao algorithmFilesDao;

    private LiveData<List<Algorithms>> allAlgos;

    private static Repository INSTANCE;

    //get instance of repository
    public static Repository getInstance(Context context){

        if(INSTANCE == null){
            INSTANCE = new Repository(context.getApplicationContext());
        }

        return INSTANCE;

    }

    //private constructor
    private Repository(Context applicationContext) {

        AppDatabase database = AppDatabase.getInstance(applicationContext);

        algorithmDao = database.algorithmDao();
        subAlgorithmsDao = database.subAlgorithmsDao();
        algorithmFilesDao = database.algorithmFilesDao();

        allAlgos = algorithmDao.getAllAlgo();


    }


    //get List of algos
    public LiveData<List<Algorithms>> getAllAlgos() {
        return allAlgos;
    }

    //insert algorithms
    public void insertAlgo(List<Algorithms> algorithms){

        insertDataAsync(algorithms,algorithmDao);

    }


    //insert subAlgorithms
    public void insertSubAlgo(List<SubAlgorithms> subAlgorithms){

        subAlgorithmsDao.insertSubAlgorithms(subAlgorithms);

    }


    //insert files data
    public void insertAlgorithmFilesData(List<AlgorithmFiles> algorithmFiles){

        algorithmFilesDao.insertAlgoFile(algorithmFiles);

    }


    private void insertDataAsync(List<Algorithms> algorithms, AlgorithmDao algorithmDao) {



    }
}
