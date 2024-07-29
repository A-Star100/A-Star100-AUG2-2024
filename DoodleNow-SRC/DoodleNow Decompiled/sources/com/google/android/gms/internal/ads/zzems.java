package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzems {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();
    private final zzdry zzb;

    public zzems(zzdry zzdry) {
        this.zzb = zzdry;
    }

    @CheckForNull
    public final zzbsn zza(String str) {
        if (this.zza.containsKey(str)) {
            return (zzbsn) this.zza.get(str);
        }
        return null;
    }

    public final void zzb(String str) {
        try {
            this.zza.put(str, this.zzb.zzb(str));
        } catch (RemoteException e) {
            zzm.zzh("Couldn't create RTB adapter : ", e);
        }
    }
}
