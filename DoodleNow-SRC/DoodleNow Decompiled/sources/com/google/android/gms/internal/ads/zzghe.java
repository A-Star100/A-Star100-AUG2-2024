package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzghe implements zzgnj {
    public static final /* synthetic */ zzghe zza = new zzghe();

    private /* synthetic */ zzghe() {
    }

    public final zzgft zza(zzggi zzggi, Integer num) {
        zzghl zzghl = (zzghl) zzggi;
        int i = zzghf.zza;
        if (zzghl.zzb() == 16 || zzghl.zzb() == 32) {
            zzggz zzggz = new zzggz((zzggy) null);
            zzggz.zzd(zzghl);
            zzggz.zzc(num);
            zzggz.zza(zzgxn.zzc(zzghl.zzb()));
            zzggz.zzb(zzgxn.zzc(zzghl.zzc()));
            return zzggz.zze();
        }
        throw new GeneralSecurityException("AES key size must be 16 or 32 bytes");
    }
}
