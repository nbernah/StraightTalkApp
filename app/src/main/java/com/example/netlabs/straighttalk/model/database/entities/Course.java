package com.example.netlabs.straighttalk.model.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.netlabs.straighttalk.model.database.DBConstants;

@Entity(tableName = DBConstants.COURSE_TABLE_NAME)
public class Course {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = DBConstants.COURSE_TABLE_COLUMN_ID)
    private int id;

    @ColumnInfo(name = DBConstants.COURSE_TABLE_COLUMN_NAME)
    private String name;

    @ColumnInfo(name = DBConstants.COURSE_TABLE_COLUMN_CATEGORY)
    private String category;

    @ColumnInfo(name = DBConstants.COURSE_TABLE_COLUMN_LEVEL)
    private String level;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
