package com.aayaz.news.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.aayaz.news.database.daos.FactDao;
import com.aayaz.news.database.daos.TitleDao;
import com.aayaz.news.database.tables.Fact;
import com.aayaz.news.database.tables.Title;

@Database(entities = {Title.class, Fact.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "news.db";

    public static volatile AppDatabase instance = null;
    public static final Object LOCK = new Object();

    public abstract TitleDao titleDao();

    public abstract FactDao factDao();

    public static AppDatabase getInstance(Context context) {

        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME).build();
                }
            }
        }

        return instance;
    }
}
