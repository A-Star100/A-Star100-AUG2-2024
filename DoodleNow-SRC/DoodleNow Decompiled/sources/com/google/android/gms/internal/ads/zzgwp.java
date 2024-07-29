package com.google.android.gms.internal.ads;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.Provider;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgwp implements zzgwu {
    private final zzgxd zza;

    /* synthetic */ zzgwp(zzgxd zzgxd, zzgwo zzgwo) {
        this.zza = zzgxd;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        for (Provider zza2 : zzgwv.zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL")) {
            try {
                return this.zza.zza(str, zza2);
            } catch (Exception unused) {
            }
        }
        return this.zza.zza(str, (Provider) null);
    }
}
