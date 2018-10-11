package com.example.netlabs.straighttalk.model.database.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.netlabs.straighttalk.model.database.DBConstants;
import com.example.netlabs.straighttalk.model.database.entities.Secondary;

import java.util.List;

@Dao
public interface SecondaryDAO {

    @Insert
    void insertSecondary(Secondary secondary);

    @Update
    void updateSecondary(Secondary secondary);

    @Query("SELECT * FROM " + DBConstants.SECONDARY_TABLE_NAME)
    LiveData<List<Secondary>> getAllSecondaries();

    @Query("SELECT * FROM " + DBConstants.SECONDARY_TABLE_NAME + " WHERE studentId = :studentId")
    Secondary getSecondary(int studentId);

    @Query("DELETE FROM " + DBConstants.SECONDARY_TABLE_NAME + " WHERE studentId = :studentId")
    void deleteSecondary(int studentId);
}
