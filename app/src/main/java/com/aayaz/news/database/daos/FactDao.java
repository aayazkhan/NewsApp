package com.aayaz.news.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.aayaz.news.database.tables.Fact;

import java.util.List;

/**
 * Perform database operation for Fact table
 */

@Dao
public interface FactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Fact fact);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Fact> facts);

    @Query("SELECT * FROM Fact ")
    LiveData<List<Fact>> getAll();

    @Query("DELETE FROM Fact")
    int deleteAll();

}
