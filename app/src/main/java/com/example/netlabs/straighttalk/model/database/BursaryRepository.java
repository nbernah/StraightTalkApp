package com.example.netlabs.straighttalk.model.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.example.netlabs.straighttalk.model.database.entities.Institutions;
import com.example.netlabs.straighttalk.model.database.entities.InstitutionsDAO;
import com.example.netlabs.straighttalk.model.database.entities.PersonalDetails;
import com.example.netlabs.straighttalk.model.database.entities.PersonalDetailsDAO;
import com.example.netlabs.straighttalk.model.database.entities.Secondary;
import com.example.netlabs.straighttalk.model.database.entities.SecondaryDAO;

import java.util.List;

public class BursaryRepository {

    private InstitutionsDAO institutionsDAO;
    private LiveData<List<Institutions>> allInstitutions;

    private SecondaryDAO secondaryDAO;
    private LiveData<List<Secondary>> allSecondaries;

    private PersonalDetailsDAO personalDetailsDAO;
    private LiveData<List<PersonalDetails>> allPersonalDetails;

    private static BursaryRepository INSTANCE;

    private BursaryRepository(Application app) {
        BursaryDatabase db = BursaryDatabase.getDatabase(app);
        institutionsDAO = db.institutionsDAO();
        allInstitutions = institutionsDAO.getAllInstitutions();
        secondaryDAO = db.secondaryDAO();
        allSecondaries = secondaryDAO.getAllSecondaries();
        personalDetailsDAO = db.personalDetailsDAO();
        allPersonalDetails = personalDetailsDAO.getAllPersonalDetails();
    }

    public static BursaryRepository getRepository(Application app) {
        if (INSTANCE == null) {
            synchronized (BursaryRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BursaryRepository(app);
                }
            }
        }
        return INSTANCE;
    }

    public LiveData<List<Institutions>> getAllInstitutions() {
        return allInstitutions;
    }

    public LiveData<List<Secondary>> getAllSecondaries() {
        return allSecondaries;
    }

    public LiveData<List<PersonalDetails>> getAllPersonalDetails() {
        return allPersonalDetails;
    }

    public void insertInstitution(Institutions institution) {
        new InsertInstitutionAsyncTask(institutionsDAO).execute(institution);
    }

    public void insertPersonalDetails(PersonalDetails personalDetail){
        new InsertPersonalDetailsAsyncTask(personalDetailsDAO).execute(personalDetail);
    }

    public void insertSecondary(Secondary secondarySchool){
        new InsertSecondaryAsyncTask(secondaryDAO).execute(secondarySchool);
    }

    private static class InsertInstitutionAsyncTask extends AsyncTask<Institutions,Void,Void> {

        InstitutionsDAO institutionsDAO;
        public InsertInstitutionAsyncTask(InstitutionsDAO institutionsDAO) {
            this.institutionsDAO = institutionsDAO;
        }

        @Override
        protected Void doInBackground(Institutions... institutions) {
            for (Institutions institution : institutions)
                institutionsDAO.insertInstitutions(institution);
            return null;
        }
    }

    private static class InsertPersonalDetailsAsyncTask extends AsyncTask<PersonalDetails, Void, Void> {

        PersonalDetailsDAO personalDetailsDAO;
        public InsertPersonalDetailsAsyncTask(PersonalDetailsDAO personalDetailsDAO) {
            this.personalDetailsDAO = personalDetailsDAO;
        }

        @Override
        protected Void doInBackground(PersonalDetails... personalDetails) {
            for (PersonalDetails detail : personalDetails)
                personalDetailsDAO.insertPersonalDetails(detail);
            return null;
        }
    }

    private static class InsertSecondaryAsyncTask extends AsyncTask<Secondary, Void, Void> {
        private SecondaryDAO secondaryDAO;
        public InsertSecondaryAsyncTask(SecondaryDAO dao) {
            this.secondaryDAO = dao;
        }

        @Override
        protected Void doInBackground(Secondary... secondaries) {
            for (Secondary secondarySchool : secondaries)
                secondaryDAO.insertSecondary(secondarySchool);
            return null;
        }
    }
}
