package com.example.netlabs.straighttalk.model.database.entities;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface InstitutionsDAO {

    @Insert
    void insertInstitutions(Institutions institutions);

    @Update
    void updateInstitution(Institutions newInstitution);

    @Query("SELECT * FROM institutions")
    LiveData<List<Institutions>> getAllInstitutions();

    @Query("SELECT * FROM institutions WHERE STUDENT_NUMBER LIKE :studentNumber LIMIT 1")
    Institutions getInstitutions(int studentNumber);

    @Query("DELETE FROM institutions WHERE STUDENT_NUMBER LIKE :studentNumber")
    void deleteInstitutions(int studentNumber);
}