package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgrv {
    @Nullable
    private ArrayList zza = new ArrayList();
    private zzgrs zzb = zzgrs.zza;
    @Nullable
    private Integer zzc = null;

    public final zzgrv zza(zzgfv zzgfv, int i, String str, String str2) {
        ArrayList arrayList = this.zza;
        if (arrayList != null) {
            arrayList.add(new zzgrx(zzgfv, i, str, str2, (zzgrw) null));
            return this;
        }
        throw new IllegalStateException("addEntry cannot be called after build()");
    }

    public final zzgrv zzb(zzgrs zzgrs) {
        if (this.zza != null) {
            this.zzb = zzgrs;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build()");
    }

    public final zzgrv zzc(int i) {
        if (this.zza != null) {
            this.zzc = Integer.valueOf(i);
            return this;
        }
        throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
    }

    public final zzgrz zzd() throws GeneralSecurityException {
        if (this.zza != null) {
            Integer num = this.zzc;
            if (num != null) {
                int intValue = num.intValue();
                ArrayList arrayList = this.zza;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    int zza2 = ((zzgrx) arrayList.get(i)).zza();
                    i++;
                    if (zza2 == intValue) {
                    }
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            }
            zzgrz zzgrz = new zzgrz(this.zzb, Collections.unmodifiableList(this.zza), this.zzc, (zzgry) null);
            this.zza = null;
            return zzgrz;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
