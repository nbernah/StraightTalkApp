package com.example.netlabs.straighttalk.views.syncing;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class RemoteDBSyncingService extends Service {

    private static final Object syncAdapterLock = new Object();
    private static RemoteDBSyncAdapter adapter;

    public RemoteDBSyncingService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        synchronized (syncAdapterLock) {
            if (adapter == null)
                adapter = new RemoteDBSyncAdapter(getApplicationContext(), true);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return adapter.getSyncAdapterBinder();
    }
}
