
package com.aayaz.news.network.Retrofit.ResponseModels;

import com.aayaz.news.database.tables.Fact;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * using this call for json parsing
 */

public class FactResult implements Serializable {

    @Expose
    @SerializedName("rows")
    private List<Fact> facts;
    @Expose
    private String title;

    public List<Fact> getFacts() {
        return facts;
    }

    public void setFacts(List<Fact> facts) {
        this.facts = facts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
