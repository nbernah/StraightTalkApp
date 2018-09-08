package com.example.netlabs.straighttalk.model.database.entities;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface SecondaryDAO {

    @Insert
    void insertSecondary(Secondary secondary);

    @Update
    void updateSecondary(Secondary newSecondary);

    @Query("SELECT * FROM SECONDARY")
    LiveData<List<Secondary>> getAllSecondaries();

    @Query("SELECT * FROM SECONDARY WHERE SS_NAME LIKE :ssName LIMIT 1")
    Secondary getSecondary(String ssName);

    @Query("DELETE FROM SECONDARY WHERE SS_NAME LIKE :ssName")
    void deleteSecondary(String ssName);
}
