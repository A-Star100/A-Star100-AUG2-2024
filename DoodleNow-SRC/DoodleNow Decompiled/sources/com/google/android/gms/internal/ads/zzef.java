package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.Spanned;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzef {
    private static final String zza = Integer.toString(0, 36);
    private static final String zzb = Integer.toString(1, 36);
    private static final String zzc = Integer.toString(2, 36);
    private static final String zzd = Integer.toString(3, 36);
    private static final String zze = Integer.toString(4, 36);

    public static ArrayList zza(Spanned spanned) {
        ArrayList arrayList = new ArrayList();
        for (zzeh zzeh : (zzeh[]) spanned.getSpans(0, spanned.length(), zzeh.class)) {
            arrayList.add(zzb(spanned, zzeh, 1, zzeh.zza()));
        }
        for (zzej zzej : (zzej[]) spanned.getSpans(0, spanned.length(), zzej.class)) {
            arrayList.add(zzb(spanned, zzej, 2, zzej.zza()));
        }
        for (zzeg zzb2 : (zzeg[]) spanned.getSpans(0, spanned.length(), zzeg.class)) {
            arrayList.add(zzb(spanned, zzb2, 3, (Bundle) null));
        }
        return arrayList;
    }

    private static Bundle zzb(Spanned spanned, Object obj, int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(zza, spanned.getSpanStart(obj));
        bundle2.putInt(zzb, spanned.getSpanEnd(obj));
        bundle2.putInt(zzc, spanned.getSpanFlags(obj));
        bundle2.putInt(zzd, i);
        if (bundle != null) {
            bundle2.putBundle(zze, bundle);
        }
        return bundle2;
    }
}
