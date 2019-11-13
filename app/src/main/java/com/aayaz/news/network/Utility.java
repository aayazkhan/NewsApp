package com.aayaz.news.network;

import com.aayaz.news.network.Retrofit.RFClient;
import com.aayaz.news.network.Retrofit.RFInterface;


public class Utility {

    public static RFInterface getRetrofitInterface() {
        return RFClient.getClient().create(RFInterface.class);
    }
}
