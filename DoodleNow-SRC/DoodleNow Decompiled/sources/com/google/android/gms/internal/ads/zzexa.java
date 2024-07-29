package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.amplitude.api.Constants;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzexa implements zzewq {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final boolean zze;
    public final int zzf;

    public zzexa(String str, int i, int i2, int i3, boolean z, int i4) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = z;
        this.zzf = i4;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        boolean z = true;
        zzfgw.zzf(bundle, Constants.AMP_TRACKING_OPTION_CARRIER, this.zza, !TextUtils.isEmpty(this.zza));
        int i = this.zzb;
        if (i == -2) {
            z = false;
        }
        zzfgw.zze(bundle, "cnt", i, z);
        bundle.putInt("gnt", this.zzc);
        bundle.putInt("pt", this.zzd);
        Bundle zza2 = zzfgw.zza(bundle, "device");
        bundle.putBundle("device", zza2);
        Bundle zza3 = zzfgw.zza(zza2, "network");
        zza2.putBundle("network", zza3);
        zza3.putInt("active_network_state", this.zzf);
        zza3.putBoolean("active_network_metered", this.zze);
    }
}
