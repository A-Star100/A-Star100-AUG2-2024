package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzefb implements zzfjq {
    public final /* synthetic */ zzefd zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzefb(zzefd zzefd, String str) {
        this.zza = zzefd;
        this.zzb = str;
    }

    public final Object zza(Object obj) {
        zzefd.zzi((SQLiteDatabase) obj, this.zzb);
        return null;
    }
}
