package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzbd;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbpq {
    static final zzbd zza = new zzbpo();
    static final zzbd zzb = new zzbpp();
    private final zzbpc zzc;

    public zzbpq(Context context, VersionInfoParcel versionInfoParcel, String str, @Nullable zzflk zzflk) {
        this.zzc = new zzbpc(context, versionInfoParcel, str, zza, zzb, zzflk);
    }

    public final zzbpg zza(String str, zzbpj zzbpj, zzbpi zzbpi) {
        return new zzbpu(this.zzc, str, zzbpj, zzbpi);
    }

    public final zzbpz zzb() {
        return new zzbpz(this.zzc);
    }
}
