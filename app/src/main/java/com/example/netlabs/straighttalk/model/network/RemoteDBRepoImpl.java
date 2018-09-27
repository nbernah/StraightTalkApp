package com.example.netlabs.straighttalk.model.network;

import com.example.netlabs.straighttalk.model.database.BursaryDBRepository;

public class RemoteDBRepoImpl implements BursaryRemoteRepository {

    private BursaryDBRepository dbRepo;

    public RemoteDBRepoImpl(BursaryDBRepository dbRepo) {
        this.dbRepo = dbRepo;
    }

    @Override
    public void downloadCoursesFromRemote() {

    }

    @Override
    public void downloadSchoolsFromRemote() {

    }

    @Override
    public void downloadHostelsFromRemote() {

    }

    @Override
    public void downloadFundersFromRemote() {

    }

    @Override
    public void uploadStudentPersonalDetailsToRemote() {

    }

    @Override
    public void uploadSecondarySchoolStudentInfoToRemote() {

    }

    @Override
    public void uploadInstitutionStudentInfoToRemote() {

    }
}
