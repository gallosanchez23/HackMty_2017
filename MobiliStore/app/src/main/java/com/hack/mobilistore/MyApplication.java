package com.hack.mobilistore;

import android.app.Application;

import com.estimote.coresdk.recognition.packets.Beacon;
import com.estimote.coresdk.service.BeaconManager;
import com.estimote.coresdk.observation.region.beacon.BeaconRegion;
import com.hack.mobilistore.preferences.ReadPreferencesUser;
import java.util.List;
import java.util.UUID;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class MyApplication extends Application {

    private BeaconManager beaconManager;
    private ReadPreferencesUser loginCheck;

    @Override
    public void onCreate() {
        super.onCreate();

        beaconManager = new BeaconManager(getApplicationContext());
        beaconManager.setMonitoringListener(new BeaconManager.BeaconMonitoringListener() {
            @Override
            public void onEnteredRegion(BeaconRegion region, List<Beacon> beacons) {
                showNotification("You entered a new store", "You can start our shopping!");
            }
            @Override
            public void onExitedRegion(BeaconRegion region) {
                showNotification("Thanks for shopping with us", "See you soon!");
            }
        });
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startMonitoring(new BeaconRegion(
                        "monitored region",
                        UUID.fromString("B9407F30-F5F8-466E-AFF9-25556B57FE6D"), 48614, 4385));
            }
        });
    }

    public void showNotification(String title, String message) {
        Intent notifyIntent;
        loginCheck = new ReadPreferencesUser(this);
        if (loginCheck.isUserLoggedIn()){
            notifyIntent = new Intent(this, CarritoDeCompras.class);
        }
        else{
            notifyIntent = new Intent(this, MainLogInActivity.class);
        }
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 0,
                new Intent[] { notifyIntent }, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();
        notification.defaults |= Notification.DEFAULT_SOUND;
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);

    }
}