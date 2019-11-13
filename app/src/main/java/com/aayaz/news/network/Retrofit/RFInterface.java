package com.aayaz.news.network.Retrofit;

import com.aayaz.news.network.Retrofit.ResponseModels.FactResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RFInterface {

    @GET("2iodh4vg0eortkl/facts.json")
    Call<FactResult> downloadFacts();

}