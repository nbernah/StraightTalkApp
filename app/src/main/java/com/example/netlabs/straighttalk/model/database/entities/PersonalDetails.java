package com.example.netlabs.straighttalk.model.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.GenericDeclaration;
import java.util.List;

@Entity(tableName = "students")
public class PersonalDetails {


    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "STF_ID")
    private int stfId;

    @NonNull
    @ColumnInfo(name = "STUD_FAMILY_NAME")
    private String studFamilyName;

    @NonNull
    @ColumnInfo(name = "STUD_GIVEN_NAME")
    private String studGivenName;

    @NonNull
    @ColumnInfo(name = "DOB")
    private String dob;

    @NonNull
    @ColumnInfo(name = "ETHNICITY")
    private String ethnicity;

    @NonNull
    @ColumnInfo(name = "ENTRY_AGGRTS")
    private int entryAggrts;

    @NonNull
    @ColumnInfo(name = "HEALTH_STATUS")
    private String healthStatus;

    @NonNull
    @ColumnInfo(name = "STUD_CONTACT_PHONE")
    private int studContactPhone;

    @NonNull
    @ColumnInfo(name = "STUD_CONTACT_EMAIL")
    private String studContactEmail;

    @NonNull
    @ColumnInfo(name = "PARENT1_FAMILY_NAME")
    private String parent1FamilyName;

    @NonNull
    @ColumnInfo(name = "PARENT1_GIVEN_NAME")
    private String parent1GivenName;

    @NonNull
    @ColumnInfo(name = "PARENT1_CONTACT")
    private int parent1Contact;

    @NonNull
    @ColumnInfo(name = "PARENT2_FAMILY_NAME")
    private String parent2FamilyName;

    @NonNull
    @ColumnInfo(name = "PARENT2_GIVEN_NAME")
    private String parent2GivenName;

    @NonNull
    @ColumnInfo(name = "PARENT2_CONTACT")
    private int parent2Contact;

    @NonNull
    @ColumnInfo(name = "VILLAGE_NAME")
    private String villageName;

    @NonNull
    @ColumnInfo(name = "BANK")
    private String bank;

    @NonNull
    @ColumnInfo(name = "BANK_ADDR")
    private String bankAddr;

    @NonNull
    @ColumnInfo(name = "CONTACT_NUMBER")
    private int contactNumber;

    @NonNull
    @ColumnInfo(name = "CURRENT_STATE")
    private String currentState;

    @NonNull
    @ColumnInfo(name = "DROPOUT_REASON")
    private String dropOutReason;

    @NonNull
    @ColumnInfo(name = "NOTES")
    private String notes;

    @NonNull
    @ColumnInfo(name = "GENDER")
    private String gender;

    @NonNull
    @ColumnInfo(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    //private District distOrigin;
    //private Sub-County subCounty;

    public int getStfId() {
        return stfId;
    }

    public void setStfId(int stfId) {
        this.stfId = stfId;
    }

    public String getStudFamilyName() {
        return studFamilyName;
    }

    public void setStudFamilyName(String studFamilyName) {
        this.studFamilyName = studFamilyName;
    }

    public String getStudGivenName() {
        return studGivenName;
    }

    public void setStudGivenName(String studGivenName) {
        this.studGivenName = studGivenName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public int getEntryAggrts() {
        return entryAggrts;
    }

    public void setEntryAggrts(int entryAggrts) {
        this.entryAggrts = entryAggrts;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public int getStudContactPhone() {
        return studContactPhone;
    }

    public void setStudContactPhone(int studContactPhone) {
        this.studContactPhone = studContactPhone;
    }

    public String getStudContactEmail() {
        return studContactEmail;
    }

    public void setStudContactEmail(String studContactEmail) {
        this.studContactEmail = studContactEmail;
    }

    public String getParent1FamilyName() {
        return parent1FamilyName;
    }

    public void setParent1FamilyName(String parent1FamilyName) {
        this.parent1FamilyName = parent1FamilyName;
    }

    public String getParent1GivenName() {
        return parent1GivenName;
    }

    public void setParent1GivenName(String parent1GivenName) {
        this.parent1GivenName = parent1GivenName;
    }

    public int getParent1Contact() {
        return parent1Contact;
    }

    public void setParent1Contact(int parent1Contact) {
        this.parent1Contact = parent1Contact;
    }

    public String getParent2FamilyName() {
        return parent2FamilyName;
    }

    public void setParent2FamilyName(String parent2FamilyName) {
        this.parent2FamilyName = parent2FamilyName;
    }

    public String getParent2GivenName() {
        return parent2GivenName;
    }

    public void setParent2GivenName(String parent2GivenName) {
        this.parent2GivenName = parent2GivenName;
    }

    public int getParent2Contact() {
        return parent2Contact;
    }

    public void setParent2Contact(int parent2Contact) {
        this.parent2Contact = parent2Contact;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankAddr() {
        return bankAddr;
    }

    public void setBankAddr(String bankAddr) {
        this.bankAddr = bankAddr;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getDropOutReason() {
        return dropOutReason;
    }

    public void setDropOutReason(String dropOutReason) {
        this.dropOutReason = dropOutReason;
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
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(@NonNull String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
