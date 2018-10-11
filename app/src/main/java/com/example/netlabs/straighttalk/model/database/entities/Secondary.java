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
    private String form; // TODO change form to string

    @ColumnInfo(name = DBConstants.SECONDARY_TABLE_COLUMN_STREAM)
    private String stream; // TODO change stream to string

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

    @ForeignKey(
            entity = Student.class,
            parentColumns = {
                    DBConstants.STUDENT_TABLE_COLUMN_ID,
                    DBConstants.STUDENT_TABLE_COLUMN_BURSARY_ID,
                    DBConstants.STUDENT_TABLE_COLUMN_COMMENTS,
                    DBConstants.STUDENT_TABLE_COLUMN_CURRENT_STATE,
                    DBConstants.STUDENT_TABLE_COLUMN_DISTRICT_NAME,
                    DBConstants.STUDENT_TABLE_COLUMN_DOB,
                    DBConstants.STUDENT_TABLE_COLUMN_DROPOUT_REASON,
                    DBConstants.STUDENT_TABLE_COLUMN_ENTRY_GRADE,
                    DBConstants.STUDENT_TABLE_COLUMN_ETHNICITY,
                    DBConstants.STUDENT_TABLE_COLUMN_FUNDER,
                    DBConstants.STUDENT_TABLE_COLUMN_GENDER,
                    DBConstants.STUDENT_TABLE_COLUMN_LEVEL,
                    DBConstants.STUDENT_TABLE_COLUMN_NAME,
                    DBConstants.STUDENT_TABLE_COLUMN_NATIONAL_ID,
                    DBConstants.STUDENT_TABLE_COLUMN_NOTES,
                    DBConstants.STUDENT_TABLE_COLUMN_PARENT1_NAME,
                    DBConstants.STUDENT_TABLE_COLUMN_PARENT1_PHONE,
                    DBConstants.STUDENT_TABLE_COLUMN_PARENT2_NAME,
                    DBConstants.STUDENT_TABLE_COLUMN_PARENT2_PHONE,
                    DBConstants.STUDENT_TABLE_COLUMN_STUDENT_EMAIL,
                    DBConstants.STUDENT_TABLE_COLUMN_STUDENT_PHONE,
                    DBConstants.STUDENT_TABLE_COLUMN_SUBCOUNTY,
                    DBConstants.STUDENT_TABLE_COLUMN_UACE_GRADE,
                    DBConstants.STUDENT_TABLE_COLUMN_UCE_GRADE,
                    DBConstants.STUDENT_TABLE_COLUMN_VILLAGE,
                    DBConstants.STUDENT_TABLE_COLUMN_YEAR_OF_END_AT_INSTITUTION,
                    DBConstants.STUDENT_TABLE_COLUMN_YEAR_OF_REGISTRATION,
                    DBConstants.STUDENT_TABLE_COLUMN_YEAR_OF_START_AT_INSTITUTION
            },
            childColumns = {
                    DBConstants.SECONDARY_TABLE_COLUMN_ID,
                    DBConstants.SECONDARY_TABLE_COLUMN_FORM,
                    DBConstants.SECONDARY_TABLE_COLUMN_STREAM,
                    DBConstants.SECONDARY_TABLE_COLUMN_STUDENT_INDEX
            },
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
    )
    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    @NonNull
    public String getForm() {
        return form;
    }

    public void setForm(@NonNull String form) {
        this.form = form;
    }

    @NonNull
    public String getStream() {
        return stream;
    }

    public void setStream(@NonNull String stream) {
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
