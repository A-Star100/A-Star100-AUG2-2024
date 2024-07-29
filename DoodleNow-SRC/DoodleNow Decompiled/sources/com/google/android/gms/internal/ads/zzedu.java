package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzedu implements zzgea {
    final /* synthetic */ zzfjq zza;

    zzedu(zzedv zzedv, zzfjq zzfjq) {
        this.zza = zzfjq;
    }

    public final void zza(Throwable th) {
        zzm.zzg("Failed to get offline signal database: ".concat(String.valueOf(th.getMessage())));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zza((SQLiteDatabase) obj);
        } catch (Exception e) {
            zzm.zzg("Error executing function on offline signal database: ".concat(String.valueOf(e.getMessage())));
        }
    }
}
