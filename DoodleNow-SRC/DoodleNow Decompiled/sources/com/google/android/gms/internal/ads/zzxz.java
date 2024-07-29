package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzxz implements Comparator {
    public static final /* synthetic */ zzxz zza = new zzxz();

    private /* synthetic */ zzxz() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((zzye) Collections.max((List) obj)).compareTo((zzye) Collections.max((List) obj2));
    }
}
