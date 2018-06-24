package com.example.joker.cosmos_android.Database;


import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Database;
import android.content.Context;

@Database(entities = {Algorithms.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "cosmos_android.db" ;
    private static AppDatabase INSTANCE;

    public abstract AlgorithmDao algorithmDao();

    public static AppDatabase getInstance(Context context){

        if(INSTANCE == null){

            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,DATABASE_NAME).build();

        }

        return INSTANCE;
    }

    public void destroyInstance(){
        INSTANCE = null;
    }

}
