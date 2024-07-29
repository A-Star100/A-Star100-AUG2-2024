package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzyd implements Comparator {
    public static final /* synthetic */ zzyd zza = new zzyd();

    private /* synthetic */ zzyd() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((zzyr) ((List) obj).get(0)).compareTo((zzyr) ((List) obj2).get(0));
    }
}
