package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdpj implements zzbky {
    private final zzbii zza;
    private final zzdpx zzb;
    private final zzhip zzc;

    public zzdpj(zzdlj zzdlj, zzdky zzdky, zzdpx zzdpx, zzhip zzhip) {
        this.zza = zzdlj.zzc(zzdky.zzA());
        this.zzb = zzdpx;
        this.zzc = zzhip;
    }

    public final void zza(Object obj, Map map) {
        String str = (String) map.get(UriUtil.LOCAL_ASSET_SCHEME);
        try {
            this.zza.zze((zzbhy) this.zzc.zzb(), str);
        } catch (RemoteException e) {
            zzm.zzk("Failed to call onCustomClick for asset " + str + ".", e);
        }
    }

    public final void zzb() {
        if (this.zza != null) {
            this.zzb.zzl("/nativeAdCustomClick", this);
        }
    }
}
