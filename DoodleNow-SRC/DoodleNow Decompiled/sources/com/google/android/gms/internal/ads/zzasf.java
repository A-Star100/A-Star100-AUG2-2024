package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzasf extends zzhie {
    private Date zza;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk = 1.0d;
    private float zzl = 1.0f;
    private zzhio zzm = zzhio.zza;
    private long zzn;

    public zzasf() {
        super("mvhd");
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zza + ";modificationTime=" + this.zzh + ";timescale=" + this.zzi + ";duration=" + this.zzj + ";rate=" + this.zzk + ";volume=" + this.zzl + ";matrix=" + this.zzm + ";nextTrackId=" + this.zzn + "]";
    }

    public final long zzd() {
        return this.zzj;
    }

    public final long zze() {
        return this.zzi;
    }

    public final void zzf(ByteBuffer byteBuffer) {
        zzi(byteBuffer);
        if (zzh() == 1) {
            this.zza = zzhij.zza(zzasb.zzf(byteBuffer));
            this.zzh = zzhij.zza(zzasb.zzf(byteBuffer));
            this.zzi = zzasb.zze(byteBuffer);
            this.zzj = zzasb.zzf(byteBuffer);
        } else {
            this.zza = zzhij.zza(zzasb.zze(byteBuffer));
            this.zzh = zzhij.zza(zzasb.zze(byteBuffer));
            this.zzi = zzasb.zze(byteBuffer);
            this.zzj = zzasb.zze(byteBuffer);
        }
        this.zzk = zzasb.zzb(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzl = ((float) ((short) ((bArr[1] & 255) | ((short) (65280 & (bArr[0] << 8)))))) / 256.0f;
        zzasb.zzd(byteBuffer);
        zzasb.zze(byteBuffer);
        zzasb.zze(byteBuffer);
        double zzb = zzasb.zzb(byteBuffer);
        double zzb2 = zzasb.zzb(byteBuffer);
        double zza2 = zzasb.zza(byteBuffer);
        this.zzm = new zzhio(zzb, zzb2, zzasb.zzb(byteBuffer), zzasb.zzb(byteBuffer), zza2, zzasb.zza(byteBuffer), zzasb.zza(byteBuffer), zzasb.zzb(byteBuffer), zzasb.zzb(byteBuffer));
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzasb.zze(byteBuffer);
    }
}
