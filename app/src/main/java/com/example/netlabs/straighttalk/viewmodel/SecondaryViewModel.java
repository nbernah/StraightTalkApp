package com.example.netlabs.straighttalk.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.netlabs.straighttalk.model.database.BursaryDBRepository;
import com.example.netlabs.straighttalk.model.database.entities.Secondary;

import java.util.List;

public class SecondaryViewModel extends AndroidViewModel {
    private BursaryDBRepository repo;
    private LiveData<List<Secondary>> secondarySchoolList;

    public SecondaryViewModel(@NonNull Application application) {
        super(application);
        repo = BursaryDBRepository.getRepository(application);
        secondarySchoolList = repo.getAllSecondaries();
    }

    public void insertSecondarySchool(Secondary secondary){
        repo.insertSecondary(secondary);
    }

    public LiveData<List<Secondary>> getSecondarySchools() {
        return secondarySchoolList;
    }



}
