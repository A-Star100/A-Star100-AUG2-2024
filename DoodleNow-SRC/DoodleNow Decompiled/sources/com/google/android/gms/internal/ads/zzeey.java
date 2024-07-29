package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.util.client.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeey implements zzfjq {
    public final /* synthetic */ zzefd zza;
    public final /* synthetic */ zzr zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzeey(zzefd zzefd, zzr zzr, String str) {
        this.zza = zzefd;
        this.zzb = zzr;
        this.zzc = str;
    }

    public final Object zza(Object obj) {
        this.zza.zzg((SQLiteDatabase) obj, this.zzb, this.zzc);
        return null;
    }
}
