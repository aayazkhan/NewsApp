package com.aayaz.news.database.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.aayaz.news.database.tables.Title;

import java.util.List;

@Dao
public interface TitleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Title title);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Title> titles);

    @Delete
    void delete(Title title);

    @Delete
    void delete(List<Title> notes);

    @Query("SELECT * FROM Title where id=:id")
    Title get(int id);

    @Query("SELECT * FROM Title LIMIT 1 ")
    Title get();

    @Query("DELETE FROM Title")
    int deleteAll();


}
