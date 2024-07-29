package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgsv extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgsv zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private zzgsy zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgsv zzgsv = new zzgsv();
        zza = zzgsv;
        zzgzv.zzca(zzgsv.class, zzgsv);
    }

    private zzgsv() {
    }

    public static zzgsu zzc() {
        return (zzgsu) zza.zzaZ();
    }

    public static zzgsv zze() {
        return zza;
    }

    static /* synthetic */ void zzg(zzgsv zzgsv, zzgsy zzgsy) {
        zzgsy.getClass();
        zzgsv.zzd = zzgsy;
        zzgsv.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzgzu zzgzu, Object obj, Object obj2) {
        zzgzu zzgzu2 = zzgzu.GET_MEMOIZED_IS_INITIALIZED;
        switch (zzgzu.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzbR(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgsv();
            case 4:
                return new zzgsu((zzgst) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgsv.class) {
                        zzhbt = zzb;
                        if (zzhbt == null) {
                            zzhbt = new zzgzq(zza);
                            zzb = zzhbt;
                        }
                    }
                }
                return zzhbt;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final zzgsy zzf() {
        zzgsy zzgsy = this.zzd;
        return zzgsy == null ? zzgsy.zze() : zzgsy;
    }
}
