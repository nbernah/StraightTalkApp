package com.example.netlabs.straighttalk.model.database.entities;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.netlabs.straighttalk.model.database.DBConstants;

@Entity(tableName = DBConstants.SCHOOL_TABLE_NAME)
public class School {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = DBConstants.SCHOOL_TABLE_COLUMN_ID)
    private int id;

    @ColumnInfo(name = DBConstants.SCHOOL_TABLE_COLUMN_SCHOOL_NAME)
    private String schoolName;

    @ColumnInfo(name = DBConstants.SCHOOL_TABLE_COLUMN_LEVEL)
    private String level;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
