package com.example.joker.cosmos_android.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface SubAlgorithmsDao {

    //when use use search to find the algorithm
    @Query("select * from sub_algorithm where subAlgorithm like :search")
    LiveData<List<SubAlgorithms>> searchSubAlgo(String search);


    //when use clicks on algorithm to get the sub algorithm
    @Query("select * from sub_algorithm where algorithmId = :algoId")
    LiveData<List<SubAlgorithms>> getSubAlgoById(String algoId);


    //insert data into sub_algorithm
    @Insert(onConflict = IGNORE)
    void insertSubAlgorithms(SubAlgorithms subAlgorithms);


}
