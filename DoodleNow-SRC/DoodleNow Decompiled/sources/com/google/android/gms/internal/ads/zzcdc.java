package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcdc {
    private final Context zza;
    private final zzcdn zzb;
    private final ViewGroup zzc;
    private zzcdb zzd;

    public zzcdc(Context context, ViewGroup viewGroup, zzcgm zzcgm) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzcgm;
        this.zzd = null;
    }

    public final zzcdb zza() {
        return this.zzd;
    }

    public final Integer zzb() {
        zzcdb zzcdb = this.zzd;
        if (zzcdb != null) {
            return zzcdb.zzl();
        }
        return null;
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzcdb zzcdb = this.zzd;
        if (zzcdb != null) {
            zzcdb.zzF(i, i2, i3, i4);
        }
    }

    public final void zzd(int i, int i2, int i3, int i4, int i5, boolean z, zzcdm zzcdm) {
        if (this.zzd == null) {
            zzbeg.zza(this.zzb.zzm().zza(), this.zzb.zzk(), "vpr2");
            Context context = this.zza;
            zzcdn zzcdn = this.zzb;
            zzcdb zzcdb = new zzcdb(context, zzcdn, i5, z, zzcdn.zzm().zza(), zzcdm);
            this.zzd = zzcdb;
            this.zzc.addView(zzcdb, 0, new ViewGroup.LayoutParams(-1, -1));
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            this.zzd.zzF(i, i2, i3, i4);
            this.zzb.zzz(false);
        }
    }

    public final void zze() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzcdb zzcdb = this.zzd;
        if (zzcdb != null) {
            zzcdb.zzo();
            this.zzc.removeView(this.zzd);
            this.zzd = null;
        }
    }

    public final void zzf() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzcdb zzcdb = this.zzd;
        if (zzcdb != null) {
            zzcdb.zzu();
        }
    }

    public final void zzg(int i) {
        zzcdb zzcdb = this.zzd;
        if (zzcdb != null) {
            zzcdb.zzC(i);
        }
    }
}
