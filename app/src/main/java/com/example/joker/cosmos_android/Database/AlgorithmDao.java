package com.example.joker.cosmos_android.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface AlgorithmDao {

    @Query("select * from algorithm")
    LiveData<List<Algorithms>> getAllAlgo();

    @Insert(onConflict = IGNORE)
    void insertUser(Algorithms algorithms);


}
