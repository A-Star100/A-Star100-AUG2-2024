package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeqm implements zzewq {
    public final /* synthetic */ ArrayList zza;

    public /* synthetic */ zzeqm(ArrayList arrayList) {
        this.zza = arrayList;
    }

    public final void zzj(Object obj) {
        ((Bundle) obj).putStringArrayList("android_permissions", this.zza);
    }
}
