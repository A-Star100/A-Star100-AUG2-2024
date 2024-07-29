package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdd;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzffc implements OnAdMetadataChangedListener {
    final /* synthetic */ zzdd zza;
    final /* synthetic */ zzffe zzb;

    zzffc(zzffe zzffe, zzdd zzdd) {
        this.zza = zzdd;
        this.zzb = zzffe;
    }

    public final void onAdMetadataChanged() {
        if (this.zzb.zzi != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
