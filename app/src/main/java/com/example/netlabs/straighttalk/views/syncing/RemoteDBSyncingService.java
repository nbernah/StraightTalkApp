package com.example.netlabs.straighttalk.views.syncing;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class RemoteDBSyncingService extends Service {

    private static final Object syncAdapterLock = new Object();
    private static RemoteDBSyncAdapter adapter;
    private static final String LOG_TAG = RemoteDBSyncingService.class.getSimpleName();

    public RemoteDBSyncingService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        synchronized (syncAdapterLock) {
            if (adapter == null)
                adapter = new RemoteDBSyncAdapter(getApplicationContext(),true,
                        getApplication());
        }
        Log.i(LOG_TAG, "Created the sync service and adapter");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return adapter.getSyncAdapterBinder();
    }
}
