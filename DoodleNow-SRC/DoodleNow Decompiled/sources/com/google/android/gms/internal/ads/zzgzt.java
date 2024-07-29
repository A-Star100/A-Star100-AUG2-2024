package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzhbl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzgzt<ContainingType extends zzhbl, Type> extends zzgzd<ContainingType, Type> {
    final zzhbl zza;
    final Object zzb;
    final zzhbl zzc;
    final zzgzs zzd;

    zzgzt(zzhbl zzhbl, Object obj, zzhbl zzhbl2, zzgzs zzgzs, Class cls) {
        if (zzhbl == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        } else if (zzgzs.zzc == zzhdn.MESSAGE && zzhbl2 == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        } else {
            this.zza = zzhbl;
            this.zzb = obj;
            this.zzc = zzhbl2;
            this.zzd = zzgzs;
        }
    }
}
