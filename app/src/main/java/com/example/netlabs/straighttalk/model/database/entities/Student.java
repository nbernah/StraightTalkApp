package com.example.netlabs.straighttalk.model.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.netlabs.straighttalk.model.database.DBConstants;

import java.sql.Date;

@Entity(tableName = DBConstants.STUDENT_TABLE_NAME)
public class Student {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_ID)
    private int id;

    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_BURSARY_ID)
    private String bursaryID;

    @NonNull
    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_NAME)
    private String name;

    @NonNull
    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_DOB)
    private String dob; // format: 'DD-MM-YYYY'

    @NonNull
    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_ETHNICITY)
    private String ethnicity;

    @NonNull
    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_ENTRY_GRADE)
    private int entryGrade;

    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_STUDENT_PHONE)
    private int studentPhone;

    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_STUDENT_EMAIL)
    private String studentEmail;

    @NonNull
    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_PARENT1_NAME)
    private String parent1Name;

    @NonNull
    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_PARENT1_PHONE)
    private int parent1Phone;

    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_PARENT2_NAME)
    private String parent2Name;

    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_PARENT2_PHONE)
    private int parent2Phone;

    @NonNull
    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_VILLAGE)
    private String village;

    @NonNull
    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_CURRENT_STATE)
    private String currentState;

    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_DROPOUT_REASON)
    private String dropoutReason;

    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_NOTES)
    private String notes;

    @NonNull
    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_GENDER)
    private String gender;

    @NonNull
    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_DISTRICT_NAME)
    private String districtName;

    @NonNull
    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_SUBCOUNTY)
    private String subCounty;

    @NonNull
    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_NATIONAL_ID)
    private String nationalID;

    @NonNull
    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_LEVEL)
    private String level;

    @NonNull
    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_YEAR_OF_REGISTRATION)
    private String yearOfRegistration; // format: 'Y'

    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_YEAR_OF_START_AT_INSTITUTION)
    private String yearOfStartAtInstitution; // format: 'Y'

    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_YEAR_OF_END_AT_INSTITUTION)
    private String yearOfEndAtInstitution; // format: 'Y'

    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_UCE_GRADE)
    private String UCEGrade;

    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_UACE_GRADE)
    private String UACEGrade;

    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_COMMENTS)
    private String comments;

    @ColumnInfo(name = DBConstants.STUDENT_TABLE_COLUMN_FUNDER)
    private String funder;

    @ForeignKey(
            entity = School.class,
            parentColumns = {
                    DBConstants.SCHOOL_TABLE_COLUMN_ID,
                    DBConstants.SCHOOL_TABLE_COLUMN_SCHOOL_NAME,
                    DBConstants.SCHOOL_TABLE_COLUMN_LEVEL
            },
            childColumns = {
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
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
    )
    private int school;

    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getBursaryID() {
        return bursaryID;
    }

    public void setBursaryID(String bursaryID) {
        this.bursaryID = bursaryID;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getDob() {
        return dob;
    }

    public void setDob(@NonNull String dob) {
        this.dob = dob;
    }

    @NonNull
    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(@NonNull String ethnicity) {
        this.ethnicity = ethnicity;
    }

    @NonNull
    public int getEntryGrade() {
        return entryGrade;
    }

    public void setEntryGrade(@NonNull int entryGrade) {
        this.entryGrade = entryGrade;
    }

    public int getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(int studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    @NonNull
    public String getParent1Name() {
        return parent1Name;
    }

    public void setParent1Name(@NonNull String parent1Name) {
        this.parent1Name = parent1Name;
    }

    @NonNull
    public int getParent1Phone() {
        return parent1Phone;
    }

    public void setParent1Phone(@NonNull int parent1Phone) {
        this.parent1Phone = parent1Phone;
    }

    public String getParent2Name() {
        return parent2Name;
    }

    public void setParent2Name(String parent2Name) {
        this.parent2Name = parent2Name;
    }

    public int getParent2Phone() {
        return parent2Phone;
    }

    public void setParent2Phone(int parent2Phone) {
        this.parent2Phone = parent2Phone;
    }

    @NonNull
    public String getVillage() {
        return village;
    }

    public void setVillage(@NonNull String village) {
        this.village = village;
    }

    @NonNull
    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(@NonNull String currentState) {
        this.currentState = currentState;
    }

    public String getDropoutReason() {
        return dropoutReason;
    }

    public void setDropoutReason(String dropoutReason) {
        this.dropoutReason = dropoutReason;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @NonNull
    public String getGender() {
        return gender;
    }

    public void setGender(@NonNull String gender) {
        this.gender = gender;
    }

    @NonNull
    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(@NonNull String districtName) {
        this.districtName = districtName;
    }

    @NonNull
    public String getSubCounty() {
        return subCounty;
    }

    public void setSubCounty(@NonNull String subCounty) {
        this.subCounty = subCounty;
    }

    @NonNull
    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(@NonNull String nationalID) {
        this.nationalID = nationalID;
    }

    @NonNull
    public String getLevel() {
        return level;
    }

    public void setLevel(@NonNull String level) {
        this.level = level;
    }

    @NonNull
    public String getYearOfRegistration() {
        return yearOfRegistration;
    }

    public void setYearOfRegistration(@NonNull String yearOfRegistration) {
        this.yearOfRegistration = yearOfRegistration;
    }

    public String getYearOfStartAtInstitution() {
        return yearOfStartAtInstitution;
    }

    public void setYearOfStartAtInstitution(String yearOfStartAtInstitution) {
        this.yearOfStartAtInstitution = yearOfStartAtInstitution;
    }

    public String getYearOfEndAtInstitution() {
        return yearOfEndAtInstitution;
    }

    public void setYearOfEndAtInstitution(String yearOfEndAtInstitution) {
        this.yearOfEndAtInstitution = yearOfEndAtInstitution;
    }

    public String getUCEGrade() {
        return UCEGrade;
    }

    public void setUCEGrade(String UCEGrade) {
        this.UCEGrade = UCEGrade;
    }

    public String getUACEGrade() {
        return UACEGrade;
    }

    public void setUACEGrade(String UACEGrade) {
        this.UACEGrade = UACEGrade;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFunder() {
        return funder;
    }

    public void setFunder(String funder) {
        this.funder = funder;
    }
}
