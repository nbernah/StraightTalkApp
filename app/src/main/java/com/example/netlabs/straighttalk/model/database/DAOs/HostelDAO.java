package com.example.netlabs.straighttalk.model.database.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.netlabs.straighttalk.model.database.DBConstants;
import com.example.netlabs.straighttalk.model.database.entities.Hostel;

import java.util.List;

@Dao
public interface HostelDAO {
    @Insert
    void insertHostel(Hostel hostel);

    @Update
    void updateHostel(Hostel hostel);

    @Query("SELECT * FROM " + DBConstants.HOSTEL_TABLE_NAME)
    LiveData<List<Hostel>> getAllHostels();

    @Query("SELECT * FROM " + DBConstants.HOSTEL_TABLE_NAME +" WHERE id = :id")
    Hostel getHostel(int id);

    @Query("DELETE FROM " + DBConstants.HOSTEL_TABLE_NAME + " WHERE id = :id")
    void deleteHostel(int id);
}
