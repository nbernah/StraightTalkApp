package com.example.netlabs.straighttalk.views.syncing;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class RemoteDBAuthenticatorService extends Service {

    private RemoteDBAuthenticator authenticator;

    public RemoteDBAuthenticatorService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        authenticator = new RemoteDBAuthenticator(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return authenticator.getIBinder();
    }
}
