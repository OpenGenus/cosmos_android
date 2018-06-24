package com.example.joker.cosmos_android.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface AlgorithmFilesDao {

    //get files details of sub algorithm by id
    @Query("select * from file where id = :subAlgoId")
    AlgorithmFiles getFilesById(int subAlgoId);


    //insert files data at once
    @Insert(onConflict = IGNORE)
    void insertAlgoFile(List<AlgorithmFiles> filesList);

}
