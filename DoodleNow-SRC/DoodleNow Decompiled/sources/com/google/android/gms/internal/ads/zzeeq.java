package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbdg;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeeq {
    private final zzbcx zza;
    private final Context zzb;
    private final zzedv zzc;
    private final VersionInfoParcel zzd;

    public zzeeq(Context context, VersionInfoParcel versionInfoParcel, zzbcx zzbcx, zzedv zzedv) {
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zza = zzbcx;
        this.zzc = zzedv;
    }

    public final void zzb(boolean z) {
        try {
            this.zzc.zza(new zzeen(this, z));
        } catch (Exception e) {
            zzm.zzg("Error in offline signals database startup: ".concat(String.valueOf(e.getMessage())));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(boolean z, SQLiteDatabase sQLiteDatabase) throws Exception {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        if (z) {
            this.zzb.deleteDatabase("OfflineUpload.db");
        } else {
            ArrayList arrayList = new ArrayList();
            Cursor query = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            while (query.moveToNext()) {
                try {
                    arrayList.add(zzbdg.zzaf.zza.zzx(query.getBlob(query.getColumnIndexOrThrow("serialized_proto_data"))));
                } catch (zzhak e) {
                    zzm.zzg("Unable to deserialize proto from offline signals database:");
                    zzm.zzg(e.getMessage());
                }
            }
            query.close();
            Context context = this.zzb;
            zzbdg.zzaf.zzc zzi = zzbdg.zzaf.zzi();
            zzi.zzv(context.getPackageName());
            zzi.zzy(Build.MODEL);
            zzi.zzA(zzeek.zza(sQLiteDatabase2, 0));
            zzi.zzh(arrayList);
            zzi.zzE(zzeek.zza(sQLiteDatabase2, 1));
            zzi.zzx(zzeek.zza(sQLiteDatabase2, 3));
            zzi.zzF(zzu.zzB().currentTimeMillis());
            zzi.zzB(zzeek.zzb(sQLiteDatabase2, 2));
            zzbdg.zzaf zzaf = (zzbdg.zzaf) zzi.zzbr();
            int size = arrayList.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                zzbdg.zzaf.zza zza2 = (zzbdg.zzaf.zza) arrayList.get(i);
                if (zza2.zzk() == zzbdg.zzq.ENUM_TRUE && zza2.zze() > j) {
                    j = zza2.zze();
                }
            }
            if (j != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", Long.valueOf(j));
                sQLiteDatabase2.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", (String[]) null);
            }
            this.zza.zzc(new zzeeo(zzaf));
            VersionInfoParcel versionInfoParcel = this.zzd;
            zzbdg.zzar.zza zzd2 = zzbdg.zzar.zzd();
            zzd2.zzg(versionInfoParcel.buddyApkVersion);
            zzd2.zzi(this.zzd.clientJarVersion);
            zzd2.zzh(true != this.zzd.isClientJar ? 2 : 0);
            this.zza.zzc(new zzeep((zzbdg.zzar) zzd2.zzbr()));
            this.zza.zzb(zzbcz.OFFLINE_UPLOAD);
            zzeek.zze(sQLiteDatabase);
        }
        return null;
    }
}
