package com.example.netlabs.straighttalk.model.database.entities;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
@Dao
public interface PersonalDetailsDAO {
    @Insert
    void insertPersonalDetails(PersonalDetails personalDetails);

    @Update
    void updatePersonalDetails(PersonalDetails newPersonalDetails);

    @Query("SELECT * FROM students")
    LiveData<List<PersonalDetails>> getAllPersonalDetails();

    @Query("SELECT * FROM students WHERE STUD_FAMILY_NAME LIKE :studFamilyName LIMIT 1")
    PersonalDetails getPersonalDetails(String studFamilyName);

    @Query("DELETE FROM students WHERE STUD_FAMILY_NAME LIKE :studFamilyName")
    void deletePersonalDetails(String studFamilyName);
}
