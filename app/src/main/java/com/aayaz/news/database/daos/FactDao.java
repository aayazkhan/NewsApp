package com.aayaz.news.database.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.aayaz.news.database.tables.Fact;
import com.aayaz.news.database.tables.Title;

import java.util.List;

@Dao
public interface FactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Fact fact);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Title> titles);

    @Delete
    void delete(Fact fact);

    @Delete
    void delete(List<Title> notes);

    @Query("SELECT * FROM Fact where id=:id")
    Title get(int id);

    @Query("SELECT * FROM Fact ")
    Title getAll();

    @Query("DELETE FROM Fact")
    int deleteAll();

}
