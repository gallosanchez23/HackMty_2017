package com.hack.mobilistore;

import com.estimote.coresdk.common.requirements.SystemRequirementsChecker;
import com.estimote.coresdk.recognition.packets.Beacon;
import com.estimote.coresdk.service.BeaconManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;
import java.util.UUID;
import com.estimote.coresdk.observation.region.beacon.BeaconRegion;

import static com.estimote.coresdk.common.config.EstimoteSDK.getApplicationContext;

public class BeaconState {
    public boolean adentro;
    private BeaconManager beaconManager;
    private Bundle savedInstanceState;

    public BeaconState(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;

        beaconManager = new BeaconManager(getApplicationContext());
        beaconManager.setMonitoringListener(new BeaconManager.BeaconMonitoringListener() {
            @Override
            public void onEnteredRegion(BeaconRegion region, List<Beacon> beacons) {
                adentro = true;
            }
            @Override
            public void onExitedRegion(BeaconRegion region) {
                adentro = false;
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
}

