package com.aayaz.news.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.aayaz.news.database.tables.Fact;

import java.util.List;

@Dao
public interface FactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Fact fact);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Fact> facts);

    @Delete
    void delete(Fact fact);

    @Delete
    void delete(List<Fact> facts);

    @Query("SELECT * FROM Fact where id=:id")
    Fact get(int id);

    @Query("SELECT * FROM Fact ")
    LiveData<List<Fact>> getAll();

    @Query("DELETE FROM Fact")
    int deleteAll();

}
