package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzfxe {
    /* access modifiers changed from: private */
    public final zzfwc zza;
    private final zzfxd zzb;

    private zzfxe(zzfxd zzfxd) {
        zzfwc zzfwc = zzfwb.zza;
        this.zzb = zzfxd;
        this.zza = zzfwc;
    }

    public static zzfxe zzb(int i) {
        return new zzfxe(new zzfxa(4000));
    }

    public static zzfxe zzc(zzfwc zzfwc) {
        return new zzfxe(new zzfwy(zzfwc));
    }

    /* access modifiers changed from: private */
    public final Iterator zzg(CharSequence charSequence) {
        return this.zzb.zza(this, charSequence);
    }

    public final Iterable zzd(CharSequence charSequence) {
        charSequence.getClass();
        return new zzfxb(this, charSequence);
    }

    public final List zzf(CharSequence charSequence) {
        charSequence.getClass();
        Iterator zzg = zzg(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzg.hasNext()) {
            arrayList.add((String) zzg.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
