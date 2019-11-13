package com.aayaz.news.database.tables;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Title {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String title;

    public Title() {
    }

    @Ignore
    public Title(String title) {
        this.title = title;
    }

    @Ignore
    public Title(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
