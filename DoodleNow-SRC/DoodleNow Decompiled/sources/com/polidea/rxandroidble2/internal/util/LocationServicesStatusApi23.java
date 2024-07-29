package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;

public class LocationServicesStatusApi23 implements LocationServicesStatus {
    private final CheckerLocationProvider checkerLocationProvider;
    private final CheckerScanPermission checkerScanPermission;
    private final int deviceSdk;
    private final boolean isAndroidWear;
    private final int targetSdk;

    private boolean isLocationProviderEnabledRequired() {
        return !this.isAndroidWear && (this.deviceSdk >= 29 || this.targetSdk >= 23);
    }

    @Inject
    LocationServicesStatusApi23(CheckerLocationProvider checkerLocationProvider2, CheckerScanPermission checkerScanPermission2, @Named("target-sdk") int i, @Named("device-sdk") int i2, @Named("android-wear") boolean z) {
        this.checkerLocationProvider = checkerLocationProvider2;
        this.checkerScanPermission = checkerScanPermission2;
        this.targetSdk = i;
        this.deviceSdk = i2;
        this.isAndroidWear = z;
    }

    public boolean isLocationPermissionOk() {
        return this.checkerScanPermission.isScanRuntimePermissionGranted();
    }

    public boolean isLocationProviderOk() {
        return !isLocationProviderEnabledRequired() || this.checkerLocationProvider.isLocationProviderEnabled();
    }
}
