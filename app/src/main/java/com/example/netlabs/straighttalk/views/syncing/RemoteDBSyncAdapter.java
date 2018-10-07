package com.example.netlabs.straighttalk.views.syncing;

import android.accounts.Account;
import android.app.Application;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

import com.example.netlabs.straighttalk.model.database.BursaryDBRepository;
import com.example.netlabs.straighttalk.model.network.BursaryRemoteRepository;
import com.example.netlabs.straighttalk.model.network.RemoteDBRepoImpl;

public class RemoteDBSyncAdapter extends AbstractThreadedSyncAdapter {

    private Application app;
    private static final String LOG_TAG = RemoteDBSyncAdapter.class.getSimpleName();

    RemoteDBSyncAdapter(Context context, boolean autoInitialize, Application app) {
        super(context, autoInitialize);
        this.app = app;
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority,
                              ContentProviderClient provider, SyncResult syncResult) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i(LOG_TAG, "Started syncing thread");
                BursaryDBRepository dbRepository = BursaryDBRepository.getRepository(app);
                BursaryRemoteRepository netRepo = new RemoteDBRepoImpl(dbRepository);
                // TODO add dependency injection for Remote DB repo

//                netRepo.downloadCoursesFromRemote();
//                netRepo.downloadHostelsFromRemote();
//                netRepo.downloadSchoolsFromRemote();

                netRepo.uploadStudentPersonalDetailsToRemote();
                netRepo.uploadSecondarySchoolStudentInfoToRemote();
                netRepo.uploadInstitutionStudentInfoToRemote();
                Log.i(LOG_TAG, "Syncing thread done");
            }
        }).start();
    }
}
