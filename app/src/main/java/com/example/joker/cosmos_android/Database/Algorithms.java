package com.example.joker.cosmos_android.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity (tableName = "algorithm")
public class Algorithms {

    @PrimaryKey
    @NonNull
    private String id;


    @NonNull
    private String algoName;

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getAlgoName() {
        return algoName;
    }

    public void setAlgoName(@NonNull String algoName) {
        this.algoName = algoName;
    }
}
