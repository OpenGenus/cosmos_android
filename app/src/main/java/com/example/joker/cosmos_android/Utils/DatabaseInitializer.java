package com.example.joker.cosmos_android.Utils;

import com.example.joker.cosmos_android.Database.Algorithms;
import com.example.joker.cosmos_android.Repositiory.Repositiory;

public class DatabaseInitializer {

    private Repositiory repositiory;

    public DatabaseInitializer(Repositiory repositiory){
        this.repositiory = repositiory;
    }

    public void insertAlogs() {

        String[] algos = DataSet.algorithms;

        for(int i=1; i<=algos.length; i++ ){

            Algorithms algorithm = new Algorithms();
            algorithm.setId(i);
            algorithm.setAlgoName(algos[i-1]);

            //TODO insertion of new data will be done here only
            repositiory.insertAlgo(algorithm);
        }

    }
}
