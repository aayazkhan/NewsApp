package com.aayaz.news.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.aayaz.news.database.tables.Title;

/**
 * Perform database operation for Title table
 */

@Dao
public interface TitleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Title title);

    @Query("SELECT * FROM Title LIMIT 1 ")
    LiveData<Title> get();

    @Query("DELETE FROM Title")
    int deleteAll();


}
