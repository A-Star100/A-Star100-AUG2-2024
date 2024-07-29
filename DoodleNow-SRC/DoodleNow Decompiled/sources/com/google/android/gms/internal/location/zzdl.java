package com.google.android.gms.internal.location;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
public final class zzdl extends zzdk {
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
