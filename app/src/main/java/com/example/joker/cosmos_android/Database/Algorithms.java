package com.example.joker.cosmos_android.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity (tableName = "algorithm")
public class Algorithms {

    @NonNull
    private int id;

    @PrimaryKey
    @NonNull
    private String algoName;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
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
