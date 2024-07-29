package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
public final class zzcd extends zzed implements zzfp {
    /* access modifiers changed from: private */
    public static final zzcd zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        zzcd zzcd = new zzcd();
        zza = zzcd;
        zzed.zzU(zzcd.class, zzcd);
    }

    private zzcd() {
    }

    public static zzcd zzb() {
        return zza;
    }

    public final String zzc() {
        return this.zzh;
    }

    public final String zzd() {
        return this.zze;
    }

    public final String zze() {
        return this.zzj;
    }

    public final String zzf() {
        return this.zzi;
    }

    /* access modifiers changed from: protected */
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzcd();
        } else {
            if (i2 == 4) {
                return new zzcc((zzbw) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final String zzh() {
        return this.zzg;
    }

    public final String zzi() {
        return this.zzf;
    }

    public final String zzj() {
        return this.zzk;
    }
}
