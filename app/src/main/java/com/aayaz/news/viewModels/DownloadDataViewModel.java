package com.aayaz.news.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.aayaz.news.database.AppRepository;
import com.aayaz.news.database.tables.Fact;
import com.aayaz.news.database.tables.Title;
import com.aayaz.news.network.Retrofit.RFInterface;
import com.aayaz.news.network.Retrofit.ResponseModels.FactResult;
import com.aayaz.news.network.Utility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DownloadDataViewModel extends AndroidViewModel {

    private AppRepository mRepository;

    public DownloadDataViewModel(@NonNull Application application) {
        super(application);
        mRepository = AppRepository.getInstance(application.getApplicationContext());
    }

    /**
     * Download data from api and save in database
     */
    public void downloadData() {
        RFInterface rfInterface = Utility.getRetrofitInterface();

        rfInterface.downloadFacts().enqueue(new Callback<FactResult>() {
            @Override
            public void onResponse(Call<FactResult> call, Response<FactResult> response) {
                if (response.isSuccessful()) {

                    mRepository.deleteAllTitle();
                    mRepository.addTitle(new Title(response.body().getTitle()));

                    mRepository.deleteAllFacts();

                    for (Fact fact : response.body().getFacts()) {
                        mRepository.addFact(fact);
                    }
                }
            }

            @Override
            public void onFailure(Call<FactResult> call, Throwable t) {
                System.err.println(t.getMessage());
            }
        });
    }

    public LiveData<Title> getTitle() {
        return mRepository.getTitle();
    }

}
