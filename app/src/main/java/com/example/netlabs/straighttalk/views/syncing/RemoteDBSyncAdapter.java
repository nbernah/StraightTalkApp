package com.example.netlabs.straighttalk.views.syncing;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;

public class RemoteDBSyncAdapter extends AbstractThreadedSyncAdapter {

    RemoteDBSyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority,
                              ContentProviderClient provider, SyncResult syncResult) {
        //sync with remote db from here
        //make the calls to the BursaryRemoteRepository to do the network stuff for us
    }
}
