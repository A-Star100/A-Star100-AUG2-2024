package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbza extends zzbyf {
    private final String zza;
    private final int zzb;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzbza(RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public final int zze() throws RemoteException {
        return this.zzb;
    }

    public final String zzf() throws RemoteException {
        return this.zza;
    }

    public zzbza(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }
}
