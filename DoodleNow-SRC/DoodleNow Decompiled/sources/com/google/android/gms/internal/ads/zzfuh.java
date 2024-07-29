package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfuh extends zzfva {
    private final IBinder zza;
    private final String zzb;
    private final int zzc;
    private final float zzd;
    private final int zze;
    private final String zzf;

    /* synthetic */ zzfuh(IBinder iBinder, boolean z, String str, int i, float f, int i2, int i3, String str2, int i4, String str3, String str4, String str5, zzfug zzfug) {
        this.zza = iBinder;
        this.zzb = str;
        this.zzc = i;
        this.zzd = f;
        this.zze = i4;
        this.zzf = str4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfva) {
            zzfva zzfva = (zzfva) obj;
            if (this.zza.equals(zzfva.zzf())) {
                zzfva.zzl();
                String str = this.zzb;
                if (str != null ? str.equals(zzfva.zzh()) : zzfva.zzh() == null) {
                    if (this.zzc == zzfva.zzc() && Float.floatToIntBits(this.zzd) == Float.floatToIntBits(zzfva.zza())) {
                        zzfva.zzb();
                        zzfva.zzd();
                        zzfva.zzj();
                        if (this.zze == zzfva.zze()) {
                            zzfva.zzi();
                            String str2 = this.zzf;
                            if (str2 != null ? str2.equals(zzfva.zzg()) : zzfva.zzg() == null) {
                                zzfva.zzk();
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.zza.hashCode() ^ 1000003;
        String str = this.zzb;
        int i2 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int floatToIntBits = (((((((hashCode * 1000003) ^ 1237) * 1000003) ^ i) * 1000003) ^ this.zzc) * 1000003) ^ Float.floatToIntBits(this.zzd);
        int i3 = this.zze;
        String str2 = this.zzf;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((((floatToIntBits * 1525764945) ^ i3) * -721379959) ^ i2) * 1000003;
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "OverlayDisplayShowRequest{windowToken=" + obj + ", stableSessionToken=false, appId=" + this.zzb + ", layoutGravity=" + this.zzc + ", layoutVerticalMargin=" + this.zzd + ", displayMode=0, triggerMode=0, sessionToken=null, windowWidthPx=" + this.zze + ", deeplinkUrl=null, adFieldEnifd=" + this.zzf + ", thirdPartyAuthCallerId=null}";
    }

    public final float zza() {
        return this.zzd;
    }

    public final int zzb() {
        return 0;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return 0;
    }

    public final int zze() {
        return this.zze;
    }

    public final IBinder zzf() {
        return this.zza;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zzb;
    }

    public final String zzi() {
        return null;
    }

    public final String zzj() {
        return null;
    }

    public final String zzk() {
        return null;
    }

    public final boolean zzl() {
        return false;
    }
}
