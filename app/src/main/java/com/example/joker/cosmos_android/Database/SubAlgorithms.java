package com.example.joker.cosmos_android.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "sub_algorithm")
public class SubAlgorithms {


    @PrimaryKey
    @NonNull
    private int id;

    @NonNull
    private String subAlgorithm;

    @NonNull
    private String algorithmId;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    @NonNull
    public String getSubAlgorithm() {
        return subAlgorithm;
    }

    public void setSubAlgorithm(@NonNull String subAlgorithm) {
        this.subAlgorithm = subAlgorithm;
    }

    @NonNull
    public String getAlgorithmId() {
        return algorithmId;
    }

    public void setAlgorithmId(@NonNull String algorithmId) {
        this.algorithmId = algorithmId;
    }
}
