package com.example.netlabs.straighttalk.model.database.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.netlabs.straighttalk.model.database.DBConstants;
import com.example.netlabs.straighttalk.model.database.entities.School;

import java.util.List;

@Dao
public interface SchoolDAO {
    @Insert
    void insertSchool(School school);

    @Update
    void updateSchool(School school);

    @Query("SELECT * FROM " + DBConstants.SCHOOL_TABLE_NAME)
    LiveData<List<School>> getAllSchools();

    @Query("SELECT * FROM " + DBConstants.SCHOOL_TABLE_NAME + " WHERE id = :id")
    School getSchool(int id);

    @Query("DELETE FROM " + DBConstants.SCHOOL_TABLE_NAME + " WHERE id = :id")
    void deleteSchool(int id);
}
