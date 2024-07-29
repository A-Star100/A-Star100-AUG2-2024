package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbmv implements zzaqj {
    /* access modifiers changed from: private */
    public volatile zzbmi zza;
    private final Context zzb;

    public zzbmv(Context context) {
        this.zzb = context;
    }

    static /* bridge */ /* synthetic */ void zzc(zzbmv zzbmv) {
        if (zzbmv.zza != null) {
            zzbmv.zza.disconnect();
            Binder.flushPendingCommands();
        }
    }

    public final zzaqm zza(zzaqq zzaqq) throws zzaqz {
        Parcelable.Creator<zzbmj> creator = zzbmj.CREATOR;
        Map zzl = zzaqq.zzl();
        int size = zzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        int i2 = 0;
        for (Map.Entry entry : zzl.entrySet()) {
            strArr[i2] = (String) entry.getKey();
            strArr2[i2] = (String) entry.getValue();
            i2++;
        }
        zzbmj zzbmj = new zzbmj(zzaqq.zzk(), strArr, strArr2);
        long elapsedRealtime = zzu.zzB().elapsedRealtime();
        try {
            zzcbw zzcbw = new zzcbw();
            this.zza = new zzbmi(this.zzb, zzu.zzt().zzb(), new zzbmt(this, zzcbw), new zzbmu(this, zzcbw));
            this.zza.checkAvailabilityAndConnect();
            ListenableFuture zzo = zzgee.zzo(zzgee.zzn(zzcbw, new zzbmr(this, zzbmj), zzcbr.zza), (long) ((Integer) zzba.zzc().zza(zzbdz.zzev)).intValue(), TimeUnit.MILLISECONDS, zzcbr.zzd);
            zzo.addListener(new zzbms(this), zzcbr.zza);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzo.get();
            zze.zza("Http assets remote cache took " + (zzu.zzB().elapsedRealtime() - elapsedRealtime) + "ms");
            zzbml zzbml = (zzbml) new zzbxb(parcelFileDescriptor).zza(zzbml.CREATOR);
            if (zzbml == null) {
                return null;
            }
            if (!zzbml.zza) {
                if (zzbml.zze.length != zzbml.zzf.length) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                while (true) {
                    String[] strArr3 = zzbml.zze;
                    if (i >= strArr3.length) {
                        return new zzaqm(zzbml.zzc, zzbml.zzd, (Map) hashMap, zzbml.zzg, zzbml.zzh);
                    }
                    hashMap.put(strArr3[i], zzbml.zzf[i]);
                    i++;
                }
            } else {
                throw new zzaqz(zzbml.zzb);
            }
        } catch (InterruptedException | ExecutionException unused) {
            zze.zza("Http assets remote cache took " + (zzu.zzB().elapsedRealtime() - elapsedRealtime) + "ms");
            return null;
        } catch (Throwable th) {
            zze.zza("Http assets remote cache took " + (zzu.zzB().elapsedRealtime() - elapsedRealtime) + "ms");
            throw th;
        }
    }
}
