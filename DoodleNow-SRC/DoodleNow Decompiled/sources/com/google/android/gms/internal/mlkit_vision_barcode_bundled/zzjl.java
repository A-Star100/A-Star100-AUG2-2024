package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
public final class zzjl extends zzed implements zzfp {
    /* access modifiers changed from: private */
    public static final zzjl zza;
    private int zzd;
    private zzel zze = zzO();
    private zzjn zzf;
    private zzhv zzg;

    static {
        zzjl zzjl = new zzjl();
        zza = zzjl;
        zzed.zzU(zzjl.class, zzjl);
    }

    private zzjl() {
    }

    /* access modifiers changed from: protected */
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzd", "zze", zzjx.class, "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzjl();
        } else {
            if (i2 == 4) {
                return new zzjk((zzhr) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
