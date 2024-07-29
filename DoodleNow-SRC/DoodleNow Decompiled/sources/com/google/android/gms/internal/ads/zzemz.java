package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzemz extends zzbsp {
    private final String zza;
    private final zzbsn zzb;
    private final zzcbw zzc;
    private final JSONObject zzd;
    private final long zze;
    private boolean zzf = false;

    public zzemz(String str, zzbsn zzbsn, zzcbw zzcbw, long j) {
        JSONObject jSONObject = new JSONObject();
        this.zzd = jSONObject;
        this.zzc = zzcbw;
        this.zza = str;
        this.zzb = zzbsn;
        this.zze = j;
        try {
            jSONObject.put("adapter_version", zzbsn.zzf().toString());
            jSONObject.put("sdk_version", zzbsn.zzg().toString());
            jSONObject.put("name", str);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    public static synchronized void zzb(String str, zzcbw zzcbw) {
        synchronized (zzemz.class) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", str);
                jSONObject.put("signal_error", "Adapter failed to instantiate");
                if (((Boolean) zzba.zzc().zza(zzbdz.zzbA)).booleanValue()) {
                    jSONObject.put("signal_error_code", 1);
                }
                zzcbw.zzc(jSONObject);
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:6|7|(1:9)|10|(1:12)|13|14|15|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzh(java.lang.String r6, int r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.zzf     // Catch:{ all -> 0x0057 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r5)
            return
        L_0x0007:
            org.json.JSONObject r0 = r5.zzd     // Catch:{ JSONException -> 0x004b }
            java.lang.String r1 = "signal_error"
            r0.put(r1, r6)     // Catch:{ JSONException -> 0x004b }
            com.google.android.gms.internal.ads.zzbdq r6 = com.google.android.gms.internal.ads.zzbdz.zzbB     // Catch:{ JSONException -> 0x004b }
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ JSONException -> 0x004b }
            java.lang.Object r6 = r0.zza(r6)     // Catch:{ JSONException -> 0x004b }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ JSONException -> 0x004b }
            boolean r6 = r6.booleanValue()     // Catch:{ JSONException -> 0x004b }
            if (r6 == 0) goto L_0x0032
            org.json.JSONObject r6 = r5.zzd     // Catch:{ JSONException -> 0x004b }
            java.lang.String r0 = "latency"
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ JSONException -> 0x004b }
            long r1 = r1.elapsedRealtime()     // Catch:{ JSONException -> 0x004b }
            long r3 = r5.zze     // Catch:{ JSONException -> 0x004b }
            long r1 = r1 - r3
            r6.put(r0, r1)     // Catch:{ JSONException -> 0x004b }
        L_0x0032:
            com.google.android.gms.internal.ads.zzbdq r6 = com.google.android.gms.internal.ads.zzbdz.zzbA     // Catch:{ JSONException -> 0x004b }
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ JSONException -> 0x004b }
            java.lang.Object r6 = r0.zza(r6)     // Catch:{ JSONException -> 0x004b }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ JSONException -> 0x004b }
            boolean r6 = r6.booleanValue()     // Catch:{ JSONException -> 0x004b }
            if (r6 == 0) goto L_0x004b
            org.json.JSONObject r6 = r5.zzd     // Catch:{ JSONException -> 0x004b }
            java.lang.String r0 = "signal_error_code"
            r6.put(r0, r7)     // Catch:{ JSONException -> 0x004b }
        L_0x004b:
            com.google.android.gms.internal.ads.zzcbw r6 = r5.zzc     // Catch:{ all -> 0x0057 }
            org.json.JSONObject r7 = r5.zzd     // Catch:{ all -> 0x0057 }
            r6.zzc(r7)     // Catch:{ all -> 0x0057 }
            r6 = 1
            r5.zzf = r6     // Catch:{ all -> 0x0057 }
            monitor-exit(r5)
            return
        L_0x0057:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemz.zzh(java.lang.String, int):void");
    }

    public final synchronized void zzc() {
        zzh("Signal collection timeout.", 3);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|(1:9)|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzd() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzf     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzbA     // Catch:{ JSONException -> 0x0021 }
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ JSONException -> 0x0021 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ JSONException -> 0x0021 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ JSONException -> 0x0021 }
            boolean r0 = r0.booleanValue()     // Catch:{ JSONException -> 0x0021 }
            if (r0 == 0) goto L_0x0021
            org.json.JSONObject r0 = r3.zzd     // Catch:{ JSONException -> 0x0021 }
            java.lang.String r1 = "signal_error_code"
            r2 = 0
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0021 }
        L_0x0021:
            com.google.android.gms.internal.ads.zzcbw r0 = r3.zzc     // Catch:{ all -> 0x002d }
            org.json.JSONObject r1 = r3.zzd     // Catch:{ all -> 0x002d }
            r0.zzc(r1)     // Catch:{ all -> 0x002d }
            r0 = 1
            r3.zzf = r0     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return
        L_0x002d:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemz.zzd():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:12|13|(1:15)|16|(1:18)|19|20|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0055 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zze(java.lang.String r6) throws android.os.RemoteException {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.zzf     // Catch:{ all -> 0x0061 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r5)
            return
        L_0x0007:
            if (r6 != 0) goto L_0x0010
            java.lang.String r6 = "Adapter returned null signals"
            r5.zzf(r6)     // Catch:{ all -> 0x0061 }
            monitor-exit(r5)
            return
        L_0x0010:
            org.json.JSONObject r0 = r5.zzd     // Catch:{ JSONException -> 0x0055 }
            java.lang.String r1 = "signals"
            r0.put(r1, r6)     // Catch:{ JSONException -> 0x0055 }
            com.google.android.gms.internal.ads.zzbdq r6 = com.google.android.gms.internal.ads.zzbdz.zzbB     // Catch:{ JSONException -> 0x0055 }
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ JSONException -> 0x0055 }
            java.lang.Object r6 = r0.zza(r6)     // Catch:{ JSONException -> 0x0055 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ JSONException -> 0x0055 }
            boolean r6 = r6.booleanValue()     // Catch:{ JSONException -> 0x0055 }
            if (r6 == 0) goto L_0x003b
            org.json.JSONObject r6 = r5.zzd     // Catch:{ JSONException -> 0x0055 }
            java.lang.String r0 = "latency"
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ JSONException -> 0x0055 }
            long r1 = r1.elapsedRealtime()     // Catch:{ JSONException -> 0x0055 }
            long r3 = r5.zze     // Catch:{ JSONException -> 0x0055 }
            long r1 = r1 - r3
            r6.put(r0, r1)     // Catch:{ JSONException -> 0x0055 }
        L_0x003b:
            com.google.android.gms.internal.ads.zzbdq r6 = com.google.android.gms.internal.ads.zzbdz.zzbA     // Catch:{ JSONException -> 0x0055 }
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ JSONException -> 0x0055 }
            java.lang.Object r6 = r0.zza(r6)     // Catch:{ JSONException -> 0x0055 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ JSONException -> 0x0055 }
            boolean r6 = r6.booleanValue()     // Catch:{ JSONException -> 0x0055 }
            if (r6 == 0) goto L_0x0055
            org.json.JSONObject r6 = r5.zzd     // Catch:{ JSONException -> 0x0055 }
            java.lang.String r0 = "signal_error_code"
            r1 = 0
            r6.put(r0, r1)     // Catch:{ JSONException -> 0x0055 }
        L_0x0055:
            com.google.android.gms.internal.ads.zzcbw r6 = r5.zzc     // Catch:{ all -> 0x0061 }
            org.json.JSONObject r0 = r5.zzd     // Catch:{ all -> 0x0061 }
            r6.zzc(r0)     // Catch:{ all -> 0x0061 }
            r6 = 1
            r5.zzf = r6     // Catch:{ all -> 0x0061 }
            monitor-exit(r5)
            return
        L_0x0061:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemz.zze(java.lang.String):void");
    }

    public final synchronized void zzf(String str) throws RemoteException {
        zzh(str, 2);
    }

    public final synchronized void zzg(zze zze2) throws RemoteException {
        zzh(zze2.zzb, 2);
    }
}
