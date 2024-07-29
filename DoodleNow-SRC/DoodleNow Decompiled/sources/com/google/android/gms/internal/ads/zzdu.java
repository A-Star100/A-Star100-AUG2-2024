package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzdu implements zzdt {
    protected zzdr zzb;
    protected zzdr zzc;
    private zzdr zzd = zzdr.zza;
    private zzdr zze;
    private ByteBuffer zzf;
    private ByteBuffer zzg;
    private boolean zzh;

    public zzdu() {
        ByteBuffer byteBuffer = zza;
        this.zzf = byteBuffer;
        this.zzg = byteBuffer;
        zzdr zzdr = zzdr.zza;
        this.zze = zzdr;
        this.zzb = zzdr;
        this.zzc = zzdr;
    }

    public final zzdr zza(zzdr zzdr) throws zzds {
        this.zzd = zzdr;
        this.zze = zzi(zzdr);
        return zzg() ? this.zze : zzdr.zza;
    }

    public ByteBuffer zzb() {
        ByteBuffer byteBuffer = this.zzg;
        this.zzg = zza;
        return byteBuffer;
    }

    public final void zzc() {
        this.zzg = zza;
        this.zzh = false;
        this.zzb = this.zzd;
        this.zzc = this.zze;
        zzk();
    }

    public final void zzd() {
        this.zzh = true;
        zzl();
    }

    public final void zzf() {
        zzc();
        this.zzf = zza;
        this.zzd = zzdr.zza;
        zzdr zzdr = zzdr.zza;
        this.zze = zzdr;
        this.zzb = zzdr;
        this.zzc = zzdr;
        zzm();
    }

    public boolean zzg() {
        return this.zze != zzdr.zza;
    }

    public boolean zzh() {
        return this.zzh && this.zzg == zza;
    }

    /* access modifiers changed from: protected */
    public zzdr zzi(zzdr zzdr) throws zzds {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final ByteBuffer zzj(int i) {
        if (this.zzf.capacity() < i) {
            this.zzf = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.zzf.clear();
        }
        ByteBuffer byteBuffer = this.zzf;
        this.zzg = byteBuffer;
        return byteBuffer;
    }

    /* access modifiers changed from: protected */
    public void zzk() {
    }

    /* access modifiers changed from: protected */
    public void zzl() {
    }

    /* access modifiers changed from: protected */
    public void zzm() {
    }

    /* access modifiers changed from: protected */
    public final boolean zzn() {
        return this.zzg.hasRemaining();
    }
}
