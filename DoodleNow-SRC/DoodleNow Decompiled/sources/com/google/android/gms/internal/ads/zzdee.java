package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzdee {
    protected final Map zza = new HashMap();

    protected zzdee(Set set) {
        zzp(set);
    }

    public final synchronized void zzk(zzdgf zzdgf) {
        zzo(zzdgf.zza, zzdgf.zzb);
    }

    public final synchronized void zzo(Object obj, Executor executor) {
        this.zza.put(obj, executor);
    }

    public final synchronized void zzp(Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzk((zzdgf) it.next());
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzq(zzded zzded) {
        for (Map.Entry entry : this.zza.entrySet()) {
            ((Executor) entry.getValue()).execute(new zzdec(zzded, entry.getKey()));
        }
    }
}
