package com.example.netlabs.straighttalk.model.database.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.netlabs.straighttalk.model.database.DBConstants;
import com.example.netlabs.straighttalk.model.database.entities.Institution;

import java.util.List;

@Dao
public interface InstitutionDAO {

    @Insert
    void insertInstitution(Institution institution);

    @Update
    void updateInstitution(Institution newInstitution);

    @Query("SELECT * FROM " + DBConstants.INSTITUTION_TABLE_NAME)
    LiveData<List<Institution>> getAllInstitutions();

    @Query("SELECT * FROM " + DBConstants.INSTITUTION_TABLE_NAME + " WHERE studentId = :studentId")
    Institution getInstitution(int studentId);

    @Query("DELETE FROM " + DBConstants.INSTITUTION_TABLE_NAME + " WHERE studentId = :studentId")
    void deleteInstitution(int studentId);
}