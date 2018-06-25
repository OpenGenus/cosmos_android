package com.example.joker.cosmos_android.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.joker.cosmos_android.Database.AlgorithmFiles;
import com.example.joker.cosmos_android.Database.Algorithms;
import com.example.joker.cosmos_android.Database.SubAlgorithms;
import com.example.joker.cosmos_android.Repositiory.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SplashViewModel extends AndroidViewModel {

    private Repository repository;

    public SplashViewModel(@NonNull Application application) {
        super(application);

        repository = Repository.getInstance(application.getApplicationContext());

    }


    public void populateDatabase() {

        List<Algorithms> algorithms = getAlgorithmFromAsset();

        List<SubAlgorithms> subAlgorithms = getSubAlgorithmFromAsset();

        List<AlgorithmFiles> algorithmFiles = getAlgorithmFilesFromAsset();


        for(Algorithms algo : algorithms){
            repository.insertAlgo(algo);
            Log.d("algo_test",algo.toString());
        }
        //repository.insertAlgo(algorithms);


        for(SubAlgorithms subAlgo : subAlgorithms){
            repository.insertSubAlgo(subAlgo);
        }
        //repository.insertSubAlgo(subAlgorithms);


        for(AlgorithmFiles algoFiles : algorithmFiles){
            repository.insertAlgoFiles(algoFiles);
        }

    }


    //get algorithms
    private List<Algorithms> getAlgorithmFromAsset() {

        List<Algorithms> algorithms = new ArrayList<>();

        try{

            InputStreamReader inputStreamReader = new InputStreamReader(getApplication().getAssets().open("algorithms.csv"));
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line = null;

            while((line = reader.readLine()) != null){

                String[] data = line.split(",");

                Algorithms algo = new Algorithms();
                algo.setId(data[0]);
                algo.setAlgoName(data[1]);

                algorithms.add(algo);
            }

            inputStreamReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return algorithms;

    }


    //get subAlgorithm
    private List<SubAlgorithms> getSubAlgorithmFromAsset() {

        List<SubAlgorithms> subAlgorithms = new ArrayList<>();

        try{

            InputStreamReader inputStreamReader = new InputStreamReader(getApplication().getAssets().open("subAlgorithms.csv"));
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line = null;

            while((line = reader.readLine()) != null){

                String[] data = line.split(",");

                SubAlgorithms subAlgo = new SubAlgorithms();
                subAlgo.setId(Integer.parseInt(data[0]));
                subAlgo.setSubAlgorithm(data[1]);
                subAlgo.setAlgorithmId(data[2]);

                subAlgorithms.add(subAlgo);
            }

            inputStreamReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return subAlgorithms;

    }


    //get files details for algorithm
    private List<AlgorithmFiles> getAlgorithmFilesFromAsset() {

        List<AlgorithmFiles> algorithmFiles = new ArrayList<>();

        try{

            InputStreamReader inputStreamReader = new InputStreamReader(getApplication().getAssets().open("file.csv"));
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line = null;

            while((line = reader.readLine()) != null){

                String[] data = line.split(",",25);

                AlgorithmFiles algoFile = new AlgorithmFiles();

                for(int i =0; i< data.length; i++){

                    if(data[i].length() == 0){
                        data[i] = "null";
                    }

                }

                algoFile.setId(Integer.parseInt(data[0]));
                algoFile.setF(data[1]);
                algoFile.setC(data[2]);
                algoFile.setCpp(data[3]);
                algoFile.setCs(data[4]);
                algoFile.setElm(data[5]);
                algoFile.setExs(data[6]);
                algoFile.setData(data[7]);
                algoFile.setGo(data[8]);
                algoFile.setH(data[9]);
                algoFile.setHs(data[10]);
                algoFile.setJava(data[11]);
                algoFile.setJl(data[12]);
                algoFile.setJs(data[13]);
                algoFile.setKt(data[14]);
                algoFile.setM(data[15]);
                algoFile.setPhp(data[16]);
                algoFile.setPy(data[17]);
                algoFile.setRb(data[18]);
                algoFile.setRs(data[19]);
                algoFile.setSh(data[20]);
                algoFile.setSml(data[21]);
                algoFile.setSwift(data[22]);
                algoFile.setTs(data[23]);
                algoFile.setMd(data[24]);

                algorithmFiles.add(algoFile);
            }

            inputStreamReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return algorithmFiles;


    }
}
