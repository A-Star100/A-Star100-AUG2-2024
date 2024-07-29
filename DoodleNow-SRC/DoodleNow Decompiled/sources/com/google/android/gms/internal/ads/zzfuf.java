package com.google.android.gms.internal.ads;

import android.os.IBinder;
import com.google.common.base.Ascii;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfuf extends zzfuz {
    private IBinder zza;
    private String zzb;
    private int zzc;
    private float zzd;
    private int zze;
    private String zzf;
    private byte zzg;

    zzfuf() {
    }

    public final zzfuz zza(String str) {
        this.zzf = str;
        return this;
    }

    public final zzfuz zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzfuz zzc(int i) {
        this.zzg = (byte) (this.zzg | 8);
        return this;
    }

    public final zzfuz zzd(int i) {
        this.zzc = i;
        this.zzg = (byte) (this.zzg | 2);
        return this;
    }

    public final zzfuz zze(float f) {
        this.zzd = f;
        this.zzg = (byte) (this.zzg | 4);
        return this;
    }

    public final zzfuz zzf(boolean z) {
        this.zzg = (byte) (this.zzg | 1);
        return this;
    }

    public final zzfuz zzg(int i) {
        this.zzg = (byte) (this.zzg | Ascii.DLE);
        return this;
    }

    public final zzfuz zzh(IBinder iBinder) {
        if (iBinder != null) {
            this.zza = iBinder;
            return this;
        }
        throw new NullPointerException("Null windowToken");
    }

    public final zzfuz zzi(int i) {
        this.zze = i;
        this.zzg = (byte) (this.zzg | 32);
        return this;
    }

    public final zzfva zzj() {
        IBinder iBinder;
        if (this.zzg == 63 && (iBinder = this.zza) != null) {
            return new zzfuh(iBinder, false, this.zzb, this.zzc, this.zzd, 0, 0, (String) null, this.zze, (String) null, this.zzf, (String) null, (zzfug) null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" windowToken");
        }
        if ((this.zzg & 1) == 0) {
            sb.append(" stableSessionToken");
        }
        if ((this.zzg & 2) == 0) {
            sb.append(" layoutGravity");
        }
        if ((this.zzg & 4) == 0) {
            sb.append(" layoutVerticalMargin");
        }
        if ((this.zzg & 8) == 0) {
            sb.append(" displayMode");
        }
        if ((this.zzg & Ascii.DLE) == 0) {
            sb.append(" triggerMode");
        }
        if ((this.zzg & 32) == 0) {
            sb.append(" windowWidthPx");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
