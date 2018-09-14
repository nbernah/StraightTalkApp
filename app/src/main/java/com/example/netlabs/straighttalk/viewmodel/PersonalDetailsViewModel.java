package com.example.netlabs.straighttalk.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.netlabs.straighttalk.model.database.BursaryDBRepository;
import com.example.netlabs.straighttalk.model.database.entities.Student;

import java.util.List;

public class PersonalDetailsViewModel extends AndroidViewModel {
    private BursaryDBRepository repo;
    private LiveData<List<Student>> personalDetailsList;

    public PersonalDetailsViewModel(@NonNull Application application) {
        super(application);
        repo = BursaryDBRepository.getRepository(application);
//        personalDetailsList = repo.getAllPersonalDetails();
    }

    public LiveData<List<Student>> getPersonalDetails() {
        return personalDetailsList;
    }

    public void insertPersonalDetails(Student student) {
//        repo.insertPersonalDetails(student);
    }
}
