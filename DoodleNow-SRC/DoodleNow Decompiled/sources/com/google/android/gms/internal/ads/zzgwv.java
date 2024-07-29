package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgwv {
    public static final zzgwv zza = new zzgwv(new zzgww());
    public static final zzgwv zzb = new zzgwv(new zzgxa());
    public static final zzgwv zzc = new zzgwv(new zzgxc());
    public static final zzgwv zzd = new zzgwv(new zzgxb());
    public static final zzgwv zze = new zzgwv(new zzgwx());
    public static final zzgwv zzf = new zzgwv(new zzgwz());
    public static final zzgwv zzg = new zzgwv(new zzgwy());
    private final zzgwu zzh;

    public zzgwv(zzgxd zzgxd) {
        this.zzh = !zzgmm.zzb() ? "The Android Project".equals(System.getProperty("java.vendor")) ? new zzgwp(zzgxd, (zzgwo) null) : new zzgwr(zzgxd, (zzgwq) null) : new zzgwt(zzgxd, (zzgws) null);
    }

    public static List zzb(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String provider : strArr) {
            Provider provider2 = Security.getProvider(provider);
            if (provider2 != null) {
                arrayList.add(provider2);
            }
        }
        return arrayList;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        return this.zzh.zza(str);
    }
}
