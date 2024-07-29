package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeqn implements zzfwf {
    public static final /* synthetic */ zzeqn zza = new zzeqn();

    private /* synthetic */ zzeqn() {
    }

    public final Object apply(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzeqm(arrayList);
    }
}
