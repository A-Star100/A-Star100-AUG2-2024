package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
class zzfzg extends zzfzh {
    Object[] zza;
    int zzb = 0;
    boolean zzc;

    zzfzg(int i) {
        this.zza = new Object[i];
    }

    private final void zzf(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i) {
            this.zza = Arrays.copyOf(objArr, zze(length, i));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
    }

    public /* bridge */ /* synthetic */ zzfzh zzb(Object obj) {
        throw null;
    }

    public final zzfzh zzc(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzf(this.zzb + collection.size());
            if (collection instanceof zzfzi) {
                this.zzb = ((zzfzi) collection).zza(this.zza, this.zzb);
                return this;
            }
        }
        for (Object zzb2 : iterable) {
            zzb(zzb2);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Object[] objArr, int i) {
        zzgax.zzb(objArr, 2);
        zzf(this.zzb + 2);
        System.arraycopy(objArr, 0, this.zza, this.zzb, 2);
        this.zzb += 2;
    }

    public final zzfzg zza(Object obj) {
        obj.getClass();
        zzf(this.zzb + 1);
        Object[] objArr = this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        objArr[i] = obj;
        return this;
    }
}
