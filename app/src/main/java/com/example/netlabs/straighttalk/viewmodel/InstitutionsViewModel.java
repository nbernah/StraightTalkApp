package com.example.netlabs.straighttalk.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.netlabs.straighttalk.model.database.BursaryRepository;
import com.example.netlabs.straighttalk.model.database.entities.Institutions;

import java.util.List;

public class InstitutionsViewModel extends AndroidViewModel {
    private BursaryRepository repository;
    private LiveData<List<Institutions>> institutions;

    public InstitutionsViewModel(@NonNull Application application) {
        super(application);
        repository = BursaryRepository.getRepository(application);
        institutions = repository.getAllInstitutions();
    }

    public void insertInstitution(Institutions institution) {
        repository.insertInstitution(institution);
    }

    public LiveData<List<Institutions>> getInstitutions() {
        return institutions;
    }
}
