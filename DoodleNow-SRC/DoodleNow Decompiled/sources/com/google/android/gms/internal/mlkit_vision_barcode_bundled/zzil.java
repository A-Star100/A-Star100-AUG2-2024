package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
public final class zzil extends zzed implements zzfp {
    /* access modifiers changed from: private */
    public static final zzil zza;
    private int zzd;
    private int zze;
    private long zzf;

    static {
        zzil zzil = new zzil();
        zza = zzil;
        zzed.zzU(zzil.class, zzil);
    }

    private zzil() {
    }

    /* access modifiers changed from: protected */
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", zzim.zza, "zzf"});
        } else if (i2 == 3) {
            return new zzil();
        } else {
            if (i2 == 4) {
                return new zzik((zzhr) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
