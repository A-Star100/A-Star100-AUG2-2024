package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzbdg;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeef implements zzfjq {
    public final /* synthetic */ zzeeg zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ ArrayList zzc;
    public final /* synthetic */ zzbdg.zzab zzd;
    public final /* synthetic */ zzbdg.zzaf.zzd zze;

    public /* synthetic */ zzeef(zzeeg zzeeg, boolean z, ArrayList arrayList, zzbdg.zzab zzab, zzbdg.zzaf.zzd zzd2) {
        this.zza = zzeeg;
        this.zzb = z;
        this.zzc = arrayList;
        this.zzd = zzab;
        this.zze = zzd2;
    }

    public final Object zza(Object obj) {
        zzeeg zzeeg = this.zza;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (zzeeg.zzb.zzf()) {
            return null;
        }
        zzbdg.zzaf.zzd zzd2 = this.zze;
        zzbdg.zzab zzab = this.zzd;
        ArrayList arrayList = this.zzc;
        boolean z = this.zzb;
        byte[] zze2 = zzeeh.zze(zzeeg.zzb, z, arrayList, zzab, zzd2);
        zzeek.zzf(sQLiteDatabase, z, true);
        zzeek.zzc(sQLiteDatabase, zzeeg.zzb.zzf.zzd(), zze2);
        return null;
    }
}
