package com.example.joker.cosmos_android.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "file")
public class AlgorithmFiles {

    @PrimaryKey
    @NonNull
    private int id;

    private String f;
    private String c;
    private String cpp;
    private String cs;
    private String elm;
    private String exs;
    private String data;
    private String go;
    private String h;
    private String java;
    private String jl;
    private String js;
    private String kt;
    private String m;
    private String php;
    private String py;
    private String rb;
    private String rs;
    private String sh;
    private String sml;
    private String swift;
    private String ts;
    private String md;

    @NonNull
    public int getId() {
        return id;
    }

    public String getF() {
        return f;
    }

    public String getC() {
        return c;
    }

    public String getCpp() {
        return cpp;
    }

    public String getCs() {
        return cs;
    }

    public String getElm() {
        return elm;
    }

    public String getExs() {
        return exs;
    }

    public String getData() {
        return data;
    }

    public String getGo() {
        return go;
    }

    public String getH() {
        return h;
    }

    public String getJava() {
        return java;
    }

    public String getJl() {
        return jl;
    }

    public String getJs() {
        return js;
    }

    public String getKt() {
        return kt;
    }

    public String getM() {
        return m;
    }

    public String getPhp() {
        return php;
    }

    public String getPy() {
        return py;
    }

    public String getRb() {
        return rb;
    }

    public String getRs() {
        return rs;
    }

    public String getSh() {
        return sh;
    }

    public String getSml() {
        return sml;
    }

    public String getSwift() {
        return swift;
    }

    public String getTs() {
        return ts;
    }

    public String getMd() {
        return md;
    }
}
