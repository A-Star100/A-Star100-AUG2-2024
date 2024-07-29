package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfqa {
    private final Context zza;
    private final Looper zzb;

    public zzfqa(Context context, Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(String str) {
        zzfqq zza2 = zzfqu.zza();
        zza2.zza(this.zza.getPackageName());
        zza2.zzc(zzfqt.BLOCKED_IMPRESSION);
        zzfqn zza3 = zzfqo.zza();
        zza3.zzb(str);
        zza3.zza(zzfqm.BLOCKED_REASON_BACKGROUND);
        zza2.zzb(zza3);
        new zzfqb(this.zza, this.zzb, (zzfqu) zza2.zzbr()).zza();
    }
}
