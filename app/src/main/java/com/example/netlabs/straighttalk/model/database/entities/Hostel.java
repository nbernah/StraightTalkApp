package com.example.netlabs.straighttalk.model.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.netlabs.straighttalk.model.database.DBConstants;

@Entity(tableName = DBConstants.HOSTEL_TABLE_NAME)
public class Hostel {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = DBConstants.HOSTEL_TABLE_COLUMN_ID)
    private int id;

    @ColumnInfo(name = DBConstants.HOSTEL_TABLE_COLUMN_HOSTEL_NAME)
    private String name;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
