package com.polidea.rxandroidble2.internal.util;

import android.content.Context;
import android.os.Process;
import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.ClientScope;
import java.util.HashSet;
import java.util.Set;

@ClientScope
public class CheckerPermission {
    private final Context context;
    private final Set<String> grantedPermissions = new HashSet();

    @Inject
    CheckerPermission(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: package-private */
    public boolean isAnyPermissionGranted(String[] strArr) {
        for (String isPermissionGranted : strArr) {
            if (isPermissionGranted(isPermissionGranted)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPermissionGranted(String str) {
        if (str != null) {
            boolean z = true;
            if (this.grantedPermissions.contains(str)) {
                return true;
            }
            if (this.context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                z = false;
            }
            if (z) {
                this.grantedPermissions.add(str);
            }
            return z;
        }
        throw new IllegalArgumentException("permission is null");
    }
}
