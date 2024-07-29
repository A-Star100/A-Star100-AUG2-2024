package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgdm extends zzgdo {
    zzgdm(zzfzi zzfzi, boolean z) {
        super(zzfzi, z);
        zzv();
    }

    public final /* bridge */ /* synthetic */ Object zzG(List list) {
        ArrayList zza = zzgad.zza(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzgdn zzgdn = (zzgdn) it.next();
            zza.add(zzgdn != null ? zzgdn.zza : null);
        }
        return Collections.unmodifiableList(zza);
    }
}
