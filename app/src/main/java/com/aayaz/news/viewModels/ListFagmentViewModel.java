package com.aayaz.news.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.aayaz.news.database.AppRepository;
import com.aayaz.news.database.tables.Fact;

import java.util.List;

public class ListFagmentViewModel extends AndroidViewModel {

    private AppRepository mRepository;

    public ListFagmentViewModel(@NonNull Application application) {
        super(application);
        mRepository = AppRepository.getInstance(application.getApplicationContext());
    }


    /**
     * get fact data from database and return
     */
    public LiveData<List<Fact>> getFacts(){
        return mRepository.getFactes();
    }

}
