package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.text.Layout;
import androidx.core.view.ViewCompat;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzea {
    private CharSequence zza;
    private Bitmap zzb;
    private Layout.Alignment zzc;
    private Layout.Alignment zzd;
    private float zze;
    private int zzf;
    private int zzg;
    private float zzh;
    private int zzi;
    private int zzj;
    private float zzk;
    private float zzl;
    private float zzm;
    private int zzn;
    private float zzo;

    public zzea() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = -3.4028235E38f;
        this.zzf = Integer.MIN_VALUE;
        this.zzg = Integer.MIN_VALUE;
        this.zzh = -3.4028235E38f;
        this.zzi = Integer.MIN_VALUE;
        this.zzj = Integer.MIN_VALUE;
        this.zzk = -3.4028235E38f;
        this.zzl = -3.4028235E38f;
        this.zzm = -3.4028235E38f;
        this.zzn = Integer.MIN_VALUE;
    }

    /* synthetic */ zzea(zzec zzec, zzdz zzdz) {
        this.zza = zzec.zzc;
        this.zzb = zzec.zzf;
        this.zzc = zzec.zzd;
        this.zzd = zzec.zze;
        this.zze = zzec.zzg;
        this.zzf = zzec.zzh;
        this.zzg = zzec.zzi;
        this.zzh = zzec.zzj;
        this.zzi = zzec.zzk;
        this.zzj = zzec.zzn;
        this.zzk = zzec.zzo;
        this.zzl = zzec.zzl;
        this.zzm = zzec.zzm;
        this.zzn = zzec.zzp;
        this.zzo = zzec.zzq;
    }

    @Pure
    public final int zza() {
        return this.zzg;
    }

    @Pure
    public final int zzb() {
        return this.zzi;
    }

    public final zzea zzc(Bitmap bitmap) {
        this.zzb = bitmap;
        return this;
    }

    public final zzea zzd(float f) {
        this.zzm = f;
        return this;
    }

    public final zzea zze(float f, int i) {
        this.zze = f;
        this.zzf = i;
        return this;
    }

    public final zzea zzf(int i) {
        this.zzg = i;
        return this;
    }

    public final zzea zzg(Layout.Alignment alignment) {
        this.zzd = alignment;
        return this;
    }

    public final zzea zzh(float f) {
        this.zzh = f;
        return this;
    }

    public final zzea zzi(int i) {
        this.zzi = i;
        return this;
    }

    public final zzea zzj(float f) {
        this.zzo = f;
        return this;
    }

    public final zzea zzk(float f) {
        this.zzl = f;
        return this;
    }

    public final zzea zzl(CharSequence charSequence) {
        this.zza = charSequence;
        return this;
    }

    public final zzea zzm(Layout.Alignment alignment) {
        this.zzc = alignment;
        return this;
    }

    public final zzea zzn(float f, int i) {
        this.zzk = f;
        this.zzj = i;
        return this;
    }

    public final zzea zzo(int i) {
        this.zzn = i;
        return this;
    }

    public final zzec zzp() {
        return new zzec(this.zza, this.zzc, this.zzd, this.zzb, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, false, ViewCompat.MEASURED_STATE_MASK, this.zzn, this.zzo, (zzeb) null);
    }

    @Pure
    public final CharSequence zzq() {
        return this.zza;
    }
}
