package com.google.android.gms.internal.play_billing;

import javax.annotation.CheckForNull;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzt extends zzs {
    public static boolean zza(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null) {
            return obj.equals(obj2);
        }
        return false;
    }
}
