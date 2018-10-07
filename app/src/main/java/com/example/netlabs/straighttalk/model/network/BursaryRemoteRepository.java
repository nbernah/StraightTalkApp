package com.example.netlabs.straighttalk.model.network;

public interface BursaryRemoteRepository {
    //needs the ref to local DB
    //and maybe the auth token to connect to the remote API

    void downloadCoursesFromRemote();
    void downloadSchoolsFromRemote();
    void downloadHostelsFromRemote();
//    void downloadFundersFromRemote();

    void uploadStudentPersonalDetailsToRemote();
    void uploadSecondarySchoolStudentInfoToRemote();
    void uploadInstitutionStudentInfoToRemote();

}
