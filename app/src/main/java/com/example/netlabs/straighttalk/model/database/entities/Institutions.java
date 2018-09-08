package com.example.netlabs.straighttalk.model.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

@Entity(tableName = "institutions")
public class Institutions {


    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "STF_ID")
    private int stfId;

    @NonNull
    @ColumnInfo(name = "STUDENT_NUMBER")
    private int studentNumber;

    @NonNull
    @ColumnInfo(name = "REGISTRATION_NUMBER")
    private String registrationNumber;


    @NonNull
    @ColumnInfo(name = "UNI_YOS")
    private String uniYos;

    @NonNull
    @ColumnInfo(name = "UNI_YOC")
    private String uniYoc;

    @NonNull
    @ColumnInfo(name = "AWARD_LEVEL")
    private String awardLevel;

    //private List<CollegeName> collegeName;
    //private List<UNICourse> uniCourse;
    //private List<Accomodation> accomodaton;

    public Institutions() {
    }

    public int getStfId() {
        return stfId;
    }

    public void setStfId( int stfId) {
        this.stfId = stfId;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber( int studentNumber) {
        this.studentNumber = studentNumber;
    }


    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber( String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }


    public String getUniYos() {
        return uniYos;
    }

    public void setUniYos( String uniYos) {
        this.uniYos = uniYos;
    }


    public String getUniYoc() {
        return uniYoc;
    }

    public void setUniYoc( String uniYoc) {
        this.uniYoc = uniYoc;
    }


    public String getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel( String awardLevel) {
        this.awardLevel = awardLevel;
    }
}
