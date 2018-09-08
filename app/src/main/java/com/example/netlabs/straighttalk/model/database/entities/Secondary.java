package com.example.netlabs.straighttalk.model.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "secondary")
public class Secondary {


    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "STF_ID")
    private int stfId;


    @NonNull
    @ColumnInfo(name = "SS_NAME")
    private String ssName;

    @NonNull
    @ColumnInfo(name = "SS_FORM")
    private int ssForm;

    @NonNull
    @ColumnInfo(name = "SS_STREAM")
    private char ssStream;

    @NonNull
    @ColumnInfo(name = "FAV_SUBJECT")
    private String favSubject;

    @NonNull
    @ColumnInfo(name = "FAV_SPORT")
    private String favSport;

    @NonNull
    @ColumnInfo(name = "STUDENT_ID")
    private String studentId;

    @NonNull
    @ColumnInfo(name = "BURSARY_FUNDER")
    private String bursaryFunder;

    @NonNull
    @ColumnInfo(name = "CURRENT_CLASS")
    private String currentClass;


    @NonNull
    @ColumnInfo(name = "CLASS_COMPLETION_SS")
    private String classCompletionSS;

    @NonNull
    @ColumnInfo(name = "COMPLETION_SS")
    private String completionSS;


    @NonNull
    @ColumnInfo(name = "EXAM_DATE")
    private String examDate;

    @NonNull
    @ColumnInfo(name = "BURSARY_DATE")
    private String bursaryDate;

    @NonNull
    @ColumnInfo(name = "BURSARY_YO_START")
    private String bursaryYoStart;

    //private List<SSSubject> subjectList;
    //private SSchools schoolCode;

    public Secondary() {
    }

    public int getStfId() {
        return stfId;
    }

    public void setStfId(int stfId) {
        this.stfId = stfId;
    }

    public String getSsName() {
        return ssName;
    }

    public void setSsName(String ssName) {
        this.ssName = ssName;
    }

    public int getSsForm() {
        return ssForm;
    }

    public void setSsForm(int ssForm) {
        this.ssForm = ssForm;
    }

    public char getSsStream() {
        return ssStream;
    }

    public void setSsStream(char ssStream) {
        this.ssStream = ssStream;
    }

    public String getFavSubject() {
        return favSubject;
    }

    public void setFavSubject(String favSubject) {
        this.favSubject = favSubject;
    }

    public String getFavSport() {
        return favSport;
    }

    public void setFavSport(String favSport) {
        this.favSport = favSport;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getBursaryFunder() {
        return bursaryFunder;
    }

    public void setBursaryFunder(String bursaryFunder) {
        this.bursaryFunder = bursaryFunder;
    }

    public String getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(String currentClass) {
        this.currentClass = currentClass;
    }

    public String getClassCompletionSS() {
        return classCompletionSS;
    }

    public void setClassCompletionSS(String classCompletionSS) {
        this.classCompletionSS = classCompletionSS;
    }

    public String getCompletionSS() {
        return completionSS;
    }

    public void setCompletionSS(String completionSS) {
        this.completionSS = completionSS;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getBursaryDate() {
        return bursaryDate;
    }

    public void setBursaryDate(String bursaryDate) {
        this.bursaryDate = bursaryDate;
    }

    public String getBursaryYoStart() {
        return bursaryYoStart;
    }

    public void setBursaryYoStart(String bursaryYoStart) {
        this.bursaryYoStart = bursaryYoStart;
    }
}
