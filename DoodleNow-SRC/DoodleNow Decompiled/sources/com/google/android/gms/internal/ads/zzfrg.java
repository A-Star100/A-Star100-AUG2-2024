package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.exoplayer2.PlaybackException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfrg implements zzfps {
    private final Object zza;
    private final zzfrh zzb;
    private final zzfrs zzc;
    private final zzfpp zzd;

    zzfrg(Object obj, zzfrh zzfrh, zzfrs zzfrs, zzfpp zzfpp) {
        this.zza = obj;
        this.zzb = zzfrh;
        this.zzc = zzfrs;
        this.zzd = zzfpp;
    }

    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzauv zza2 = zzauw.zza();
        zza2.zzb(zzauk.DG);
        zza2.zza(zzgyj.zzv(bArr, 0, bArr.length));
        return Base64.encodeToString(((zzauw) zza2.zzbr()).zzaV(), 11);
    }

    private final synchronized byte[] zzj(Map map, Map map2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            this.zzd.zzc(PlaybackException.ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED, System.currentTimeMillis() - currentTimeMillis, e);
            return null;
        }
        return (byte[]) this.zza.getClass().getDeclaredMethod("xss", new Class[]{Map.class, Map.class}).invoke(this.zza, new Object[]{null, map2});
    }

    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map zza2;
        zza2 = this.zzc.zza();
        zza2.put("f", "c");
        zza2.put("ctx", context);
        zza2.put("cs", str2);
        zza2.put("aid", (Object) null);
        zza2.put("view", view);
        zza2.put("act", activity);
        return zzi(zzj((Map) null, zza2));
    }

    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map zzc2;
        zzc2 = this.zzc.zzc();
        zzc2.put("f", "v");
        zzc2.put("ctx", context);
        zzc2.put("aid", (Object) null);
        zzc2.put("view", view);
        zzc2.put("act", activity);
        return zzi(zzj((Map) null, zzc2));
    }

    public final synchronized String zzc(Context context, String str) {
        Map zzb2;
        zzb2 = this.zzc.zzb();
        zzb2.put("f", "q");
        zzb2.put("ctx", context);
        zzb2.put("aid", (Object) null);
        return zzi(zzj((Map) null, zzb2));
    }

    public final synchronized void zzd(String str, MotionEvent motionEvent) throws zzfrq {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("t", new Throwable());
            hashMap.put("aid", (Object) null);
            hashMap.put("evt", motionEvent);
            this.zza.getClass().getDeclaredMethod("he", new Class[]{Map.class}).invoke(this.zza, new Object[]{hashMap});
            this.zzd.zzd(3003, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzfrq((int) PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND, (Throwable) e);
        }
    }

    public final synchronized int zze() throws zzfrq {
        try {
        } catch (Exception e) {
            throw new zzfrq((int) PlaybackException.ERROR_CODE_IO_NO_PERMISSION, (Throwable) e);
        }
        return ((Integer) this.zza.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zza, new Object[0])).intValue();
    }

    /* access modifiers changed from: package-private */
    public final zzfrh zzf() {
        return this.zzb;
    }

    public final synchronized void zzg() throws zzfrq {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.zza.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.zza, new Object[0]);
            this.zzd.zzd(3001, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzfrq((int) PlaybackException.ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE, (Throwable) e);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzh() throws zzfrq {
        try {
        } catch (Exception e) {
            throw new zzfrq((int) PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, (Throwable) e);
        }
        return ((Boolean) this.zza.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.zza, new Object[0])).booleanValue();
    }
}
