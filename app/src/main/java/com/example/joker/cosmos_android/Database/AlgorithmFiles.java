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
    private String hs;
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

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public void setF(String f) {
        this.f = f;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void setCpp(String cpp) {
        this.cpp = cpp;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }

    public void setElm(String elm) {
        this.elm = elm;
    }

    public void setExs(String exs) {
        this.exs = exs;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setGo(String go) {
        this.go = go;
    }

    public void setH(String h) {
        this.h = h;
    }

    public void setJava(String java) {
        this.java = java;
    }

    public void setJl(String jl) {
        this.jl = jl;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public void setKt(String kt) {
        this.kt = kt;
    }

    public void setM(String m) {
        this.m = m;
    }

    public void setPhp(String php) {
        this.php = php;
    }

    public void setPy(String py) {
        this.py = py;
    }

    public void setRb(String rb) {
        this.rb = rb;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public void setSh(String sh) {
        this.sh = sh;
    }

    public void setSml(String sml) {
        this.sml = sml;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public void setMd(String md) {
        this.md = md;
    }

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

    public String getHs() {
        return hs;
    }

    public void setHs(String hs) {
        this.hs = hs;
    }
}
