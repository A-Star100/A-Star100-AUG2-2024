package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzgjo implements zzgoe {
    public static final /* synthetic */ zzgjo zza = new zzgjo();

    private /* synthetic */ zzgjo() {
    }

    public final Object zza(zzgft zzgft) {
        zzgjx zzgjx = (zzgjx) zzgft;
        int i = zzgjp.zza;
        try {
            return new zzgjm(zzguu.zzf(zzggp.zzb(zzgjx.zzb().zzb()), zzgzf.zza()), zzggg.zza(zzgjx.zzb().zzc()).zzb());
        } catch (zzhak e) {
            throw new GeneralSecurityException("Parsing of DEK key template failed: ", e);
        }
    }
}
