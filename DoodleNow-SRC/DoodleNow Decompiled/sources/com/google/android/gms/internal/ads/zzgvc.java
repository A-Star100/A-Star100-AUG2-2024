package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgvc extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgvc zza;
    private static volatile zzhbt zzb;
    /* access modifiers changed from: private */
    public int zzc;
    private zzhah zzd = zzbK();

    static {
        zzgvc zzgvc = new zzgvc();
        zza = zzgvc;
        zzgzv.zzca(zzgvc.class, zzgvc);
    }

    private zzgvc() {
    }

    public static zzguz zzd() {
        return (zzguz) zza.zzaZ();
    }

    public static zzgvc zzg(InputStream inputStream, zzgzf zzgzf) throws IOException {
        return (zzgvc) zzgzv.zzbu(zza, inputStream, zzgzf);
    }

    static /* synthetic */ void zzj(zzgvc zzgvc, zzgvb zzgvb) {
        zzgvb.getClass();
        zzhah zzhah = zzgvc.zzd;
        if (!zzhah.zzc()) {
            zzgvc.zzd = zzgzv.zzbL(zzhah);
        }
        zzgvc.zzd.add(zzgvb);
    }

    public final int zza() {
        return this.zzd.size();
    }

    public final int zzc() {
        return this.zzc;
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
                return zzbR(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzc", "zzd", zzgvb.class});
            case 3:
                return new zzgvc();
            case 4:
                return new zzguz((zzguy) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgvc.class) {
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

    public final zzgvb zze(int i) {
        return (zzgvb) this.zzd.get(i);
    }

    public final List zzh() {
        return this.zzd;
    }
}
