package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;

public class LocationServicesStatusApi31 implements LocationServicesStatus {
    private final CheckerLocationProvider checkerLocationProvider;
    private final CheckerScanPermission checkerScanPermission;
    private final boolean isAndroidWear;
    private final boolean isNearbyPermissionNeverForLoc;

    private boolean isLocationProviderEnabledRequired() {
        if (this.isAndroidWear) {
            return false;
        }
        return !this.isNearbyPermissionNeverForLoc;
    }

    @Inject
    LocationServicesStatusApi31(CheckerLocationProvider checkerLocationProvider2, CheckerScanPermission checkerScanPermission2, @Named("android-wear") boolean z, @Named("nearby-permission-never-for-location") boolean z2) {
        this.checkerLocationProvider = checkerLocationProvider2;
        this.checkerScanPermission = checkerScanPermission2;
        this.isAndroidWear = z;
        this.isNearbyPermissionNeverForLoc = z2;
    }

    public boolean isLocationPermissionOk() {
        return this.checkerScanPermission.isScanRuntimePermissionGranted();
    }

    public boolean isLocationProviderOk() {
        return !isLocationProviderEnabledRequired() || this.checkerLocationProvider.isLocationProviderEnabled();
    }
}
