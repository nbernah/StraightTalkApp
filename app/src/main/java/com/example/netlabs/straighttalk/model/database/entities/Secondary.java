package com.example.netlabs.straighttalk.model.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.netlabs.straighttalk.model.database.DBConstants;

@Entity(tableName = DBConstants.SECONDARY_TABLE_NAME)
public class Secondary {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = DBConstants.SECONDARY_TABLE_COLUMN_ID)
    private int id;

    @ColumnInfo(name = DBConstants.SECONDARY_TABLE_COLUMN_FORM)
    private int form;

    @ColumnInfo(name = DBConstants.SECONDARY_TABLE_COLUMN_STREAM)
    private char stream;

    @ColumnInfo(name = DBConstants.SECONDARY_TABLE_COLUMN_STUDENT_INDEX)
    private String studentIndex;

    @ForeignKey(
            entity = School.class,
            parentColumns = {
                    DBConstants.SCHOOL_TABLE_COLUMN_ID,
                    DBConstants.SCHOOL_TABLE_COLUMN_SCHOOL_NAME,
                    DBConstants.SCHOOL_TABLE_COLUMN_LEVEL
            },
            childColumns = {
                DBConstants.SECONDARY_TABLE_COLUMN_ID,
                    DBConstants.SECONDARY_TABLE_COLUMN_FORM,
                    DBConstants.SECONDARY_TABLE_COLUMN_STREAM,
                    DBConstants.SECONDARY_TABLE_COLUMN_STUDENT_INDEX
            },
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
    )
    private int school;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    @NonNull
    public int getForm() {
        return form;
    }

    public void setForm(@NonNull int form) {
        this.form = form;
    }

    @NonNull
    public char getStream() {
        return stream;
    }

    public void setStream(@NonNull char stream) {
        this.stream = stream;
    }

    @NonNull
    public String getStudentIndex() {
        return studentIndex;
    }

    public void setStudentIndex(@NonNull String studentIndex) {
        this.studentIndex = studentIndex;
    }

    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }
}
