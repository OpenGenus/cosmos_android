package com.example.joker.cosmos_android.Repositiory;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.example.joker.cosmos_android.Database.AlgorithmDao;
import com.example.joker.cosmos_android.Database.Algorithms;
import com.example.joker.cosmos_android.Database.AppDatabase;

import java.util.List;

public class Repositiory {

    private AlgorithmDao algorithmDao;
    private LiveData<List<Algorithms>> allAlgos;

    private static Repositiory INSTANCE;

    //get instance of repository
    public static Repositiory getInstance(Context context){

        if(INSTANCE == null){
            INSTANCE = new Repositiory(context.getApplicationContext());
        }

        return INSTANCE;

    }

    //private constructor
    private Repositiory(Context applicationContext) {

        AppDatabase database = AppDatabase.getInstance(applicationContext);
        algorithmDao = database.algorithmDao();
        allAlgos = algorithmDao.getAllAlgo();

    }


    //get List of algos
    public LiveData<List<Algorithms>> getAllAlgos() {
        return allAlgos;
    }

    //insert algos
    public void insertAlgo(Algorithms algorithms){

        new insertAsync(algorithmDao).execute(algorithms);

    }

    //async task to insert data to database
    private static class insertAsync extends AsyncTask<Algorithms,Void,Void> {

        private AlgorithmDao dao;

        public insertAsync(AlgorithmDao algorithmDao) {
            this.dao = algorithmDao;
        }

        @Override
        protected Void doInBackground(Algorithms... algorithms) {

            dao.insertUser(algorithms[0]);

            return null;
        }
    }
}
