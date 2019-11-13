package com.aayaz.news.database.tables;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Fact {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String description;
    private String imageHref;
    private String title;

    public Fact() {
    }

    @Ignore
    public Fact(String description, String imageHref, String title) {
        this.description = description;
        this.imageHref = imageHref;
        this.title = title;
    }

    @Ignore
    public Fact(long id, String description, String imageHref, String title) {
        this.id = id;
        this.description = description;
        this.imageHref = imageHref;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageHref() {
        return imageHref;
    }

    public void setImageHref(String imageHref) {
        this.imageHref = imageHref;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
