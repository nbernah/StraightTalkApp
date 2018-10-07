package com.example.netlabs.straighttalk.model.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.netlabs.straighttalk.model.database.DBConstants;

@Entity(tableName = DBConstants.INSTITUTION_TABLE_NAME)
public class Institution {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = DBConstants.INSTITUTION_TABLE_COLUMN_ID)
    private int id;

    @ColumnInfo(name = DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_NUMBER)
    private String studentNumber; // TODO change student number to string

    @ColumnInfo(name = DBConstants.INSTITUTION_TABLE_COLUMN_REGISTRATION_NUMBER)
    private String registrationNumber;

    @ColumnInfo(name = DBConstants.INSTITUTION_TABLE_COLUMN_QUALIFICATION)
    private String qualification;

    @ColumnInfo(name = DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_BANK_NAME)
    private String studentBankName;

    @ColumnInfo(name = DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_BANK_ACCOUNT)
    private String studentBankAccount;

    @ColumnInfo(name = DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_BANK_ADDRESS)
    private String studentBankAddress;

    @ColumnInfo(name = DBConstants.INSTITUTION_TABLE_COLUMN_OTHER_BANK_NAME)
    private String otherBankName;

    @ColumnInfo(name = DBConstants.INSTITUTION_TABLE_COLUMN_OTHER_BANK_ACCOUNT)
    private String otherBankAccount;

    @ColumnInfo(name = DBConstants.INSTITUTION_TABLE_COLUMN_OTHER_BANK_ADDRESS)
    private String otherBankAddress;

    @ForeignKey(
            entity = School.class,
            parentColumns = {
                    DBConstants.SCHOOL_TABLE_COLUMN_ID,
                    DBConstants.SCHOOL_TABLE_COLUMN_SCHOOL_NAME,
                    DBConstants.SCHOOL_TABLE_COLUMN_LEVEL
            },
            childColumns = {
                    DBConstants.INSTITUTION_TABLE_COLUMN_ID,
                    DBConstants.INSTITUTION_TABLE_COLUMN_NAME,
                    DBConstants.INSTITUTION_TABLE_COLUMN_QUALIFICATION,
                    DBConstants.INSTITUTION_TABLE_COLUMN_REGISTRATION_NUMBER,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_NUMBER,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_BANK_NAME,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_BANK_ACCOUNT,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_BANK_ADDRESS,
                    DBConstants.INSTITUTION_TABLE_COLUMN_OTHER_BANK_NAME,
                    DBConstants.INSTITUTION_TABLE_COLUMN_OTHER_BANK_ACCOUNT,
                    DBConstants.INSTITUTION_TABLE_COLUMN_OTHER_BANK_ADDRESS
            },
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
    )
    private int school;

    @ForeignKey(
            entity = Hostel.class,
            parentColumns = {
                    DBConstants.HOSTEL_TABLE_COLUMN_ID,
                    DBConstants.HOSTEL_TABLE_COLUMN_HOSTEL_NAME
            },
            childColumns = {
                    DBConstants.INSTITUTION_TABLE_COLUMN_ID,
                    DBConstants.INSTITUTION_TABLE_COLUMN_NAME,
                    DBConstants.INSTITUTION_TABLE_COLUMN_QUALIFICATION,
                    DBConstants.INSTITUTION_TABLE_COLUMN_REGISTRATION_NUMBER,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_NUMBER,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_BANK_NAME,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_BANK_ACCOUNT,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_BANK_ADDRESS,
                    DBConstants.INSTITUTION_TABLE_COLUMN_OTHER_BANK_NAME,
                    DBConstants.INSTITUTION_TABLE_COLUMN_OTHER_BANK_ACCOUNT,
                    DBConstants.INSTITUTION_TABLE_COLUMN_OTHER_BANK_ADDRESS
            },
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
    )
    private int hostel;

    @ForeignKey(
            entity = Course.class,
            parentColumns = {
                    DBConstants.COURSE_TABLE_COLUMN_ID,
                    DBConstants.COURSE_TABLE_COLUMN_NAME,
                    DBConstants.COURSE_TABLE_COLUMN_LEVEL,
                    DBConstants.COURSE_TABLE_COLUMN_CATEGORY
            },
            childColumns = {
                    DBConstants.INSTITUTION_TABLE_COLUMN_ID,
                    DBConstants.INSTITUTION_TABLE_COLUMN_NAME,
                    DBConstants.INSTITUTION_TABLE_COLUMN_QUALIFICATION,
                    DBConstants.INSTITUTION_TABLE_COLUMN_REGISTRATION_NUMBER,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_NUMBER,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_BANK_NAME,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_BANK_ACCOUNT,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_BANK_ADDRESS,
                    DBConstants.INSTITUTION_TABLE_COLUMN_OTHER_BANK_NAME,
                    DBConstants.INSTITUTION_TABLE_COLUMN_OTHER_BANK_ACCOUNT,
                    DBConstants.INSTITUTION_TABLE_COLUMN_OTHER_BANK_ADDRESS
            },
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
    )
    private int course;

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
                    DBConstants.INSTITUTION_TABLE_COLUMN_ID,
                    DBConstants.INSTITUTION_TABLE_COLUMN_NAME,
                    DBConstants.INSTITUTION_TABLE_COLUMN_QUALIFICATION,
                    DBConstants.INSTITUTION_TABLE_COLUMN_REGISTRATION_NUMBER,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_NUMBER,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_BANK_NAME,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_BANK_ACCOUNT,
                    DBConstants.INSTITUTION_TABLE_COLUMN_STUDENT_BANK_ADDRESS,
                    DBConstants.INSTITUTION_TABLE_COLUMN_OTHER_BANK_NAME,
                    DBConstants.INSTITUTION_TABLE_COLUMN_OTHER_BANK_ACCOUNT,
                    DBConstants.INSTITUTION_TABLE_COLUMN_OTHER_BANK_ADDRESS
            },
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
    )
    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    //private String sForm;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getStudentBankName() {
        return studentBankName;
    }

    public void setStudentBankName(String studentBankName) {
        this.studentBankName = studentBankName;
    }

    public String getStudentBankAccount() {
        return studentBankAccount;
    }

    public void setStudentBankAccount(String studentBankAccount) {
        this.studentBankAccount = studentBankAccount;
    }

    public String getStudentBankAddress() {
        return studentBankAddress;
    }

    public void setStudentBankAddress(String studentBankAddress) {
        this.studentBankAddress = studentBankAddress;
    }

    public String getOtherBankName() {
        return otherBankName;
    }

    public void setOtherBankName(String otherBankName) {
        this.otherBankName = otherBankName;
    }

    public String getOtherBankAccount() {
        return otherBankAccount;
    }

    public void setOtherBankAccount(String otherBankAccount) {
        this.otherBankAccount = otherBankAccount;
    }

    public String getOtherBankAddress() {
        return otherBankAddress;
    }

    public void setOtherBankAddress(String otherBankAddress) {
        this.otherBankAddress = otherBankAddress;
    }

    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    public int getHostel() {
        return hostel;
    }

    public void setHostel(int hostel) {
        this.hostel = hostel;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
