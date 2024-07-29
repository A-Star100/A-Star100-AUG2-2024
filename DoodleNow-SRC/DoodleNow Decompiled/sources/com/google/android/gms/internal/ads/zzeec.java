package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzbdg;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeec implements zzfjq {
    public final /* synthetic */ zzeed zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzeec(zzeed zzeed, long j) {
        this.zza = zzeed;
        this.zzb = j;
    }

    public final Object zza(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (this.zza.zzf()) {
            return null;
        }
        long j = this.zzb;
        zzbdg.zzaf.zza.C0015zza zzn = zzbdg.zzaf.zza.zzn();
        zzn.zzP(j);
        byte[] zzaV = ((zzbdg.zzaf.zza) zzn.zzbr()).zzaV();
        zzeek.zzf(sQLiteDatabase, false, false);
        zzeek.zzc(sQLiteDatabase, j, zzaV);
        return null;
    }
}
