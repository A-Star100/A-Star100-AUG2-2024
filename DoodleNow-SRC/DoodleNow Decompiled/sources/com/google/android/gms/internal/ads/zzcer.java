package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcer implements Iterable {
    private final List zza = new ArrayList();

    public final Iterator iterator() {
        return this.zza.iterator();
    }

    /* access modifiers changed from: package-private */
    public final zzceq zza(zzcdn zzcdn) {
        Iterator it = iterator();
        while (it.hasNext()) {
            zzceq zzceq = (zzceq) it.next();
            if (zzceq.zza == zzcdn) {
                return zzceq;
            }
        }
        return null;
    }

    public final void zzb(zzceq zzceq) {
        this.zza.add(zzceq);
    }

    public final void zzc(zzceq zzceq) {
        this.zza.remove(zzceq);
    }

    public final boolean zzd(zzcdn zzcdn) {
        ArrayList<zzceq> arrayList = new ArrayList<>();
        Iterator it = iterator();
        while (it.hasNext()) {
            zzceq zzceq = (zzceq) it.next();
            if (zzceq.zza == zzcdn) {
                arrayList.add(zzceq);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (zzceq zzceq2 : arrayList) {
            zzceq2.zzb.zzf();
        }
        return true;
    }
}
