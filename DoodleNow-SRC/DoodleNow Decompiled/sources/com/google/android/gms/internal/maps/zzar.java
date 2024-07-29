package com.google.android.gms.internal.maps;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class zzar extends zzaq {
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
