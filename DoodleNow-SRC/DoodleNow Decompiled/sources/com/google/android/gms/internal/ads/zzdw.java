package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdw implements zzdt {
    private int zzb;
    private float zzc = 1.0f;
    private float zzd = 1.0f;
    private zzdr zze = zzdr.zza;
    private zzdr zzf;
    private zzdr zzg;
    private zzdr zzh;
    private boolean zzi;
    private zzdv zzj;
    private ByteBuffer zzk;
    private ShortBuffer zzl;
    private ByteBuffer zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;

    public zzdw() {
        zzdr zzdr = zzdr.zza;
        this.zzf = zzdr;
        this.zzg = zzdr;
        this.zzh = zzdr;
        ByteBuffer byteBuffer = zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = zza;
        this.zzb = -1;
    }

    public final zzdr zza(zzdr zzdr) throws zzds {
        if (zzdr.zzd == 2) {
            int i = this.zzb;
            if (i == -1) {
                i = zzdr.zzb;
            }
            this.zze = zzdr;
            zzdr zzdr2 = new zzdr(i, zzdr.zzc, 2);
            this.zzf = zzdr2;
            this.zzi = true;
            return zzdr2;
        }
        throw new zzds("Unhandled input format:", zzdr);
    }

    public final ByteBuffer zzb() {
        int zza;
        zzdv zzdv = this.zzj;
        if (zzdv != null && (zza = zzdv.zza()) > 0) {
            if (this.zzk.capacity() < zza) {
                ByteBuffer order = ByteBuffer.allocateDirect(zza).order(ByteOrder.nativeOrder());
                this.zzk = order;
                this.zzl = order.asShortBuffer();
            } else {
                this.zzk.clear();
                this.zzl.clear();
            }
            zzdv.zzd(this.zzl);
            this.zzo += (long) zza;
            this.zzk.limit(zza);
            this.zzm = this.zzk;
        }
        ByteBuffer byteBuffer = this.zzm;
        this.zzm = zza;
        return byteBuffer;
    }

    public final void zzc() {
        if (zzg()) {
            zzdr zzdr = this.zze;
            this.zzg = zzdr;
            this.zzh = this.zzf;
            if (this.zzi) {
                this.zzj = new zzdv(zzdr.zzb, zzdr.zzc, this.zzc, this.zzd, this.zzh.zzb);
            } else {
                zzdv zzdv = this.zzj;
                if (zzdv != null) {
                    zzdv.zzc();
                }
            }
        }
        this.zzm = zza;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final void zzd() {
        zzdv zzdv = this.zzj;
        if (zzdv != null) {
            zzdv.zze();
        }
        this.zzp = true;
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzdv zzdv = this.zzj;
            zzdv.getClass();
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzn += (long) remaining;
            zzdv.zzf(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    public final void zzf() {
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        this.zze = zzdr.zza;
        zzdr zzdr = zzdr.zza;
        this.zzf = zzdr;
        this.zzg = zzdr;
        this.zzh = zzdr;
        ByteBuffer byteBuffer = zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = zza;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final boolean zzg() {
        if (this.zzf.zzb == -1) {
            return false;
        }
        if (Math.abs(this.zzc - 4.0f) >= 1.0E-4f || Math.abs(this.zzd - 4.0f) >= 1.0E-4f) {
            return true;
        }
        if (this.zzf.zzb == this.zze.zzb) {
            return false;
        }
        return true;
    }

    public final boolean zzh() {
        if (!this.zzp) {
            return false;
        }
        zzdv zzdv = this.zzj;
        if (zzdv != null) {
            return zzdv.zza() == 0;
        }
        return true;
    }

    public final void zzj(float f) {
        if (this.zzd != f) {
            this.zzd = f;
            this.zzi = true;
        }
    }

    public final void zzk(float f) {
        if (this.zzc != f) {
            this.zzc = f;
            this.zzi = true;
        }
    }

    public final long zzi(long j) {
        long j2 = this.zzo;
        if (j2 < 1024) {
            return (long) (((double) this.zzc) * ((double) j));
        }
        long j3 = this.zzn;
        zzdv zzdv = this.zzj;
        zzdv.getClass();
        long zzb2 = j3 - ((long) zzdv.zzb());
        int i = this.zzh.zzb;
        int i2 = this.zzg.zzb;
        if (i == i2) {
            return zzfx.zzt(j, zzb2, j2, RoundingMode.FLOOR);
        }
        return zzfx.zzt(j, zzb2 * ((long) i), j2 * ((long) i2), RoundingMode.FLOOR);
    }
}
