package com.example.netlabs.straighttalk.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.netlabs.straighttalk.model.database.BursaryDBRepository;
import com.example.netlabs.straighttalk.model.database.entities.Institution;

import java.util.List;

public class InstitutionsViewModel extends AndroidViewModel {
    private BursaryDBRepository repository;
    private LiveData<List<Institution>> institutions;

    public InstitutionsViewModel(@NonNull Application application) {
        super(application);
        repository = BursaryDBRepository.getRepository(application);
        institutions = repository.getAllInstitutions();
    }

    public void insertInstitution(Institution institution) {
        repository.insertInstitution(institution);
    }

    public LiveData<List<Institution>> getInstitutions() {
        return institutions;
    }
}
