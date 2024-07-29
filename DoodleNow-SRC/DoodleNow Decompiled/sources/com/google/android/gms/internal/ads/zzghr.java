package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzghr implements zzgnj {
    public static final /* synthetic */ zzghr zza = new zzghr();

    private /* synthetic */ zzghr() {
    }

    public final zzgft zza(zzggi zzggi, Integer num) {
        zzghx zzghx = (zzghx) zzggi;
        int i = zzghs.zza;
        if (zzghx.zzc() != 24) {
            zzghn zzghn = new zzghn((zzghm) null);
            zzghn.zzc(zzghx);
            zzghn.zza(num);
            zzghn.zzb(zzgxn.zzc(zzghx.zzc()));
            return zzghn.zzd();
        }
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }
}
