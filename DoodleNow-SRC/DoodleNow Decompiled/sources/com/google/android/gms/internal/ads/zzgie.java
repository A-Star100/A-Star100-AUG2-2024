package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzgie implements zzgnj {
    public static final /* synthetic */ zzgie zza = new zzgie();

    private /* synthetic */ zzgie() {
    }

    public final zzgft zza(zzggi zzggi, Integer num) {
        zzgik zzgik = (zzgik) zzggi;
        int i = zzgif.zza;
        if (zzgik.zzb() != 24) {
            zzghz zzghz = new zzghz((zzghy) null);
            zzghz.zzc(zzgik);
            zzghz.zza(num);
            zzghz.zzb(zzgxn.zzc(zzgik.zzb()));
            return zzghz.zzd();
        }
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }
}
