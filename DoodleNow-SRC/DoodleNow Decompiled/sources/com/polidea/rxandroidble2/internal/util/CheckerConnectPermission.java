package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.ClientScope;

@ClientScope
public class CheckerConnectPermission {
    private final CheckerPermission checkerPermission;
    private final String[][] connectPermissions;

    @Inject
    CheckerConnectPermission(CheckerPermission checkerPermission2, @Named("connect-permissions") String[][] strArr) {
        this.checkerPermission = checkerPermission2;
        this.connectPermissions = strArr;
    }

    public boolean isConnectRuntimePermissionGranted() {
        boolean z = true;
        for (String[] isAnyPermissionGranted : this.connectPermissions) {
            z &= this.checkerPermission.isAnyPermissionGranted(isAnyPermissionGranted);
        }
        return z;
    }

    public String[] getRecommendedConnectRuntimePermissions() {
        int i = 0;
        for (String[] length : this.connectPermissions) {
            i += length.length;
        }
        String[] strArr = new String[i];
        int i2 = 0;
        for (String[] strArr2 : this.connectPermissions) {
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
