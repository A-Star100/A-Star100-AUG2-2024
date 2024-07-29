package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzhax extends zzhaz {
    private zzhax() {
        super((zzhay) null);
    }

    /* synthetic */ zzhax(zzhaw zzhaw) {
        super((zzhay) null);
    }

    /* access modifiers changed from: package-private */
    public final List zza(Object obj, long j) {
        zzhah zzhah = (zzhah) zzhdh.zzh(obj, j);
        if (zzhah.zzc()) {
            return zzhah;
        }
        int size = zzhah.size();
        zzhah zzf = zzhah.zzf(size == 0 ? 10 : size + size);
        zzhdh.zzv(obj, j, zzf);
        return zzf;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        ((zzhah) zzhdh.zzh(obj, j)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj, Object obj2, long j) {
        zzhah zzhah = (zzhah) zzhdh.zzh(obj, j);
        zzhah zzhah2 = (zzhah) zzhdh.zzh(obj2, j);
        int size = zzhah.size();
        int size2 = zzhah2.size();
        if (size > 0 && size2 > 0) {
            if (!zzhah.zzc()) {
                zzhah = zzhah.zzf(size2 + size);
            }
            zzhah.addAll(zzhah2);
        }
        if (size > 0) {
            zzhah2 = zzhah;
        }
        zzhdh.zzv(obj, j, zzhah2);
    }
}
