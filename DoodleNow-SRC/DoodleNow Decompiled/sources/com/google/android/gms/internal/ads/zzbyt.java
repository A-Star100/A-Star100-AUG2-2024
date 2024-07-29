package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbyt implements RewardItem {
    private final zzbyg zza;

    public zzbyt(zzbyg zzbyg) {
        this.zza = zzbyg;
    }

    public final int getAmount() {
        zzbyg zzbyg = this.zza;
        if (zzbyg != null) {
            try {
                return zzbyg.zze();
            } catch (RemoteException e) {
                zzm.zzk("Could not forward getAmount to RewardItem", e);
            }
        }
        return 0;
    }

    public final String getType() {
        zzbyg zzbyg = this.zza;
        if (zzbyg != null) {
            try {
                return zzbyg.zzf();
            } catch (RemoteException e) {
                zzm.zzk("Could not forward getType to RewardItem", e);
            }
        }
        return null;
    }
}
