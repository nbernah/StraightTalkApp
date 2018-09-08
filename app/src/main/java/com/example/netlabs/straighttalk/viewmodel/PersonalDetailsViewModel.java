package com.example.netlabs.straighttalk.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.netlabs.straighttalk.model.database.BursaryRepository;
import com.example.netlabs.straighttalk.model.database.entities.PersonalDetails;

import java.util.List;

public class PersonalDetailsViewModel extends AndroidViewModel {
    private BursaryRepository repo;
    private LiveData<List<PersonalDetails>> personalDetailsList;

    public PersonalDetailsViewModel(@NonNull Application application) {
        super(application);
        repo = BursaryRepository.getRepository(application);
        personalDetailsList = repo.getAllPersonalDetails();
    }

    public LiveData<List<PersonalDetails>> getPersonalDetails() {
        return personalDetailsList;
    }

    public void insertPersonalDetails(PersonalDetails personalDetails) {
        repo.insertPersonalDetails(personalDetails);
    }
}
