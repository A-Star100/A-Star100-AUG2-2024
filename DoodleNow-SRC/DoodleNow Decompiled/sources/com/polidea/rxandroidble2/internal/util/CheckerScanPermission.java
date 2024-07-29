package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.ClientScope;

@ClientScope
public class CheckerScanPermission {
    private final CheckerPermission checkerPermission;
    private final String[][] scanPermissions;

    @Inject
    CheckerScanPermission(CheckerPermission checkerPermission2, @Named("scan-permissions") String[][] strArr) {
        this.checkerPermission = checkerPermission2;
        this.scanPermissions = strArr;
    }

    public boolean isScanRuntimePermissionGranted() {
        boolean z = true;
        for (String[] isAnyPermissionGranted : this.scanPermissions) {
            z &= this.checkerPermission.isAnyPermissionGranted(isAnyPermissionGranted);
        }
        return z;
    }

    public String[] getRecommendedScanRuntimePermissions() {
        int i = 0;
        for (String[] length : this.scanPermissions) {
            i += length.length;
        }
        String[] strArr = new String[i];
        int i2 = 0;
        for (String[] strArr2 : this.scanPermissions) {
            int length2 = strArr2.length;
            int i3 = 0;
            while (i3 < length2) {
                strArr[i2] = strArr2[i3];
                i3++;
                i2++;
            }
        }
        return strArr;
    }
}
