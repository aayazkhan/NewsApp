package com.aayaz.news.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.aayaz.news.database.tables.Fact;
import com.aayaz.news.database.tables.Title;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {

    private static AppRepository ourInstance;
    private AppDatabase mDatabase;

    private Executor mExecutor = Executors.newSingleThreadExecutor();

    public static AppRepository getInstance(Context context) {
        return ourInstance = new AppRepository(context);
    }

    private AppRepository(Context context) {
        mDatabase = AppDatabase.getInstance(context);
    }

    public LiveData<List<Fact>> getFactes() {
        return mDatabase.factDao().getAll();
    }

    public void addFact(final Fact fact) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mDatabase.factDao().insert(fact);
            }
        });
    }

    public void addFact(final List<Fact> fact) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mDatabase.factDao().insert(fact);
            }
        });
    }

    public void deleteAllFacts() {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mDatabase.factDao().deleteAll();
            }
        });
    }

    public LiveData<Title> getTitle() {
        return mDatabase.titleDao().get();
    }

    public void addTitle(final Title title) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mDatabase.titleDao().insert(title);
            }
        });
    }

    public void deleteAllTitle() {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mDatabase.titleDao().deleteAll();
            }
        });
    }

}
