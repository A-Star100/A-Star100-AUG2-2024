package com.google.android.gms.internal.fido;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
final class zzax extends zzau {
    static final zzax zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzax(objArr, 0, objArr, 0, 0);
    }

    zzax(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzb = objArr;
        this.zze = i;
        this.zzc = objArr2;
        this.zzf = i2;
        this.zzg = i3;
    }

    public final boolean contains(@CheckForNull Object obj) {
        Object[] objArr = this.zzc;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int zza2 = zzap.zza(obj.hashCode());
        while (true) {
            int i = zza2 & this.zzf;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zza2 = i + 1;
        }
    }

    public final int hashCode() {
        return this.zze;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    public final int size() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzg);
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return 0;
    }

    public final zzaz zzd() {
        return zzg().listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final zzat zzh() {
        return zzat.zzg(this.zzb, this.zzg);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzj() {
        return true;
    }
}
