package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.internal.util.zzbt;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzefd extends SQLiteOpenHelper {
    private final Context zza;
    private final zzgep zzb;

    public zzefd(Context context, zzgep zzgep) {
        super(context, "AdMobOfflineBufferedPings.db", (SQLiteDatabase.CursorFactory) null, ((Integer) zzba.zzc().zza(zzbdz.zzip)).intValue());
        this.zza = context;
        this.zzb = zzgep;
    }

    static /* synthetic */ void zzf(SQLiteDatabase sQLiteDatabase, String str, zzr zzr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", 1);
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{str});
        zzj(sQLiteDatabase, zzr);
    }

    static final void zzi(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{str, Integer.toString(0)});
    }

    /* access modifiers changed from: private */
    public static void zzj(SQLiteDatabase sQLiteDatabase, zzr zzr) {
        sQLiteDatabase.beginTransaction();
        try {
            Cursor query = sQLiteDatabase.query("offline_buffered_pings", new String[]{ImagesContract.URL}, "event_state = 1", (String[]) null, (String) null, (String) null, "timestamp ASC", (String) null);
            int count = query.getCount();
            String[] strArr = new String[count];
            int i = 0;
            while (query.moveToNext()) {
                int columnIndex = query.getColumnIndex(ImagesContract.URL);
                if (columnIndex != -1) {
                    strArr[i] = query.getString(columnIndex);
                }
                i++;
            }
            query.close();
            sQLiteDatabase.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
            sQLiteDatabase.setTransactionSuccessful();
            for (int i2 = 0; i2 < count; i2++) {
                zzr.zza(strArr[i2]);
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(zzeff zzeff, SQLiteDatabase sQLiteDatabase) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzeff.zza));
        contentValues.put("gws_query_id", zzeff.zzb);
        contentValues.put(ImagesContract.URL, zzeff.zzc);
        contentValues.put("event_state", Integer.valueOf(zzeff.zzd - 1));
        sQLiteDatabase.insert("offline_buffered_pings", (String) null, contentValues);
        zzu.zzp();
        zzbt zzz = zzt.zzz(this.zza);
        if (zzz != null) {
            try {
                zzz.zze(ObjectWrapper.wrap(this.zza));
            } catch (RemoteException e) {
                zze.zzb("Failed to schedule offline ping sender.", e);
            }
        }
        return null;
    }

    public final void zzc(String str) {
        zze(new zzefb(this, str));
    }

    public final void zzd(zzeff zzeff) {
        zze(new zzeex(this, zzeff));
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzfjq zzfjq) {
        zzgee.zzr(this.zzb.zzb(new zzeez(this)), new zzefc(this, zzfjq), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final void zzg(SQLiteDatabase sQLiteDatabase, zzr zzr, String str) {
        this.zzb.execute(new zzefa(sQLiteDatabase, str, zzr));
    }

    public final void zzh(zzr zzr, String str) {
        zze(new zzeey(this, zzr, str));
    }
}
