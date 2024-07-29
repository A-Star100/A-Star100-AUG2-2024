package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgnq {
    private static final zzgnq zza = new zzgnq();
    private final Map zzb = new HashMap();

    zzgnq() {
    }

    public static zzgnq zzb() {
        return zza;
    }

    public final synchronized zzggi zza(String str) throws GeneralSecurityException {
        if (this.zzb.containsKey("AES128_GCM")) {
        } else {
            throw new GeneralSecurityException("Name AES128_GCM does not exist");
        }
        return (zzggi) this.zzb.get("AES128_GCM");
    }

    public final synchronized void zzc(String str, zzggi zzggi) throws GeneralSecurityException {
        if (!this.zzb.containsKey(str)) {
            this.zzb.put(str, zzggi);
        } else if (!((zzggi) this.zzb.get(str)).equals(zzggi)) {
            String valueOf = String.valueOf(this.zzb.get(str));
            String valueOf2 = String.valueOf(zzggi);
            throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + valueOf + "), cannot insert " + valueOf2);
        }
    }

    public final synchronized void zzd(Map map) throws GeneralSecurityException {
        for (Map.Entry entry : map.entrySet()) {
            zzc((String) entry.getKey(), (zzggi) entry.getValue());
        }
    }
}
