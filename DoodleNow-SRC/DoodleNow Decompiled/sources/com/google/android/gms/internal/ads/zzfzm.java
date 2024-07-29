package com.google.android.gms.internal.ads;

import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfzm extends zzfzn {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzfzn zzc;

    zzfzm(zzfzn zzfzn, int i, int i2) {
        this.zzc = zzfzn;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzfwr.zza(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    public final zzfzn zzh(int i, int i2) {
        zzfwr.zzi(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
