package com.bhargav.hcms.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.bhargav.hcms.data.DatabaseHelper;
import com.bhargav.hcms.model.Alarm;

import java.util.ArrayList;

public class LoadAlarmsService extends IntentService {

    private static final String TAG = LoadAlarmsService.class.getSimpleName();
    public static final String ACTION_COMPLETE = TAG + ".ACTION_COMPLETE";
    public static final String ALARMS_EXTRA = "alarms_extra";

    @SuppressWarnings("unused")
    public LoadAlarmsService() {
        this(TAG);
    }

    public LoadAlarmsService(String name){
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        final ArrayList<Alarm> alarms = DatabaseHelper.getInstance(this).getAlarms();

        final Intent i = new Intent(ACTION_COMPLETE);
        i.putParcelableArrayListExtra(ALARMS_EXTRA, alarms);
        LocalBroadcastManager.getInstance(this).sendBroadcast(i);

    }

    public static void launchLoadAlarmsService(Context context) {
        final Intent launchLoadAlarmsServiceIntent = new Intent(context, LoadAlarmsService.class);
        context.startService(launchLoadAlarmsServiceIntent);
    }
}
