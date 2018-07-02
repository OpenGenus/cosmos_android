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

    //get SubAlgo by ids
    public LiveData<List<SubAlgorithms>> getSubAlgoById(String id){
        return subAlgorithmsDao.getSubAlgoById(id);
    }


    /****************Insertion code below******************/

    //insert algorithms
    public void insertAlgo(Algorithms algorithms){

        new insertAlgoAsync(algorithmDao).execute(algorithms);

    }

    public LiveData<AlgorithmFiles> getFilesBySubAlgoId(int id) {
        return algorithmFilesDao.getFilesById(id);
    }

    //async insertion of algorithm
    static class insertAlgoAsync extends AsyncTask<Algorithms,Void,Void>{

        AlgorithmDao algorithmDao;

        public insertAlgoAsync(AlgorithmDao algorithmDao) {

            this.algorithmDao = algorithmDao;
        }

        @Override
        protected Void doInBackground(Algorithms... algorithms) {

            algorithmDao.insertUser(algorithms[0]);

            return null;
        }
    }



    //insert subAlgorithms
    public void insertSubAlgo(SubAlgorithms subAlgorithms){

        new insertSubAlgoAsync(subAlgorithmsDao).execute(subAlgorithms);

    }

    //async insertion of sub algorithm
    static class insertSubAlgoAsync extends AsyncTask<SubAlgorithms,Void,Void>{

        private SubAlgorithmsDao subAlgorithmsDao;

        public insertSubAlgoAsync(SubAlgorithmsDao subAlgorithmsDao) {
            this.subAlgorithmsDao = subAlgorithmsDao;
        }

        @Override
        protected Void doInBackground(SubAlgorithms... subAlgorithms) {

            subAlgorithmsDao.insertSubAlgorithms(subAlgorithms[0]);

            return null;
        }
    }



    //insert files data
    public void insertAlgoFiles(AlgorithmFiles algorithmFiles){

        new insertAlgoFilesAsync(algorithmFilesDao).execute(algorithmFiles);

    }

    //async insertiong of algo files
    static class insertAlgoFilesAsync extends AsyncTask<AlgorithmFiles,Void,Void>{

        AlgorithmFilesDao filesDao;

        public insertAlgoFilesAsync(AlgorithmFilesDao algorithmFilesDao) {
            this.filesDao = algorithmFilesDao;
        }


        @Override
        protected Void doInBackground(AlgorithmFiles... algorithmFiles) {
                filesDao.insertAlgoFile(algorithmFiles[0]);
            return null;
        }
    }

}
