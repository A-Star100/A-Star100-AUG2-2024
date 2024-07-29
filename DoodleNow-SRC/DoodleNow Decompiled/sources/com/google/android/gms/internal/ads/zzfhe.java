package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzck;
import com.google.android.gms.ads.internal.client.zzcl;
import com.google.android.gms.ads.internal.client.zzen;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfhe {
    private static zzfhe zza;
    private final Context zzb;
    private final zzcl zzc;
    private final AtomicReference zzd = new AtomicReference();

    zzfhe(Context context, zzcl zzcl) {
        this.zzb = context;
        this.zzc = zzcl;
    }

    static zzcl zza(Context context) {
        try {
            return zzck.asInterface((IBinder) context.getClassLoader().loadClass("com.google.android.gms.ads.internal.client.LiteSdkInfo").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context}));
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            zzm.zzh("Failed to retrieve lite SDK info.", e);
            return null;
        }
    }

    public static zzfhe zzd(Context context) {
        synchronized (zzfhe.class) {
            zzfhe zzfhe = zza;
            if (zzfhe != null) {
                return zzfhe;
            }
            Context applicationContext = context.getApplicationContext();
            long longValue = ((Long) zzbfu.zzb.zze()).longValue();
            zzcl zzcl = null;
            if (longValue > 0 && longValue <= 241199800) {
                zzcl = zza(applicationContext);
            }
            zzfhe zzfhe2 = new zzfhe(applicationContext, zzcl);
            zza = zzfhe2;
            return zzfhe2;
        }
    }

    private final zzen zzg() {
        zzcl zzcl = this.zzc;
        if (zzcl != null) {
            try {
                return zzcl.getLiteSdkVersion();
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    public final zzbqo zzb() {
        return (zzbqo) this.zzd.get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0021, code lost:
        r5 = zzg();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.util.client.VersionInfoParcel zzc(int r3, boolean r4, int r5) {
        /*
            r2 = this;
            com.google.android.gms.ads.internal.zzu.zzp()
            android.content.Context r3 = r2.zzb
            boolean r3 = com.google.android.gms.ads.internal.util.zzt.zzE(r3)
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4 = new com.google.android.gms.ads.internal.util.client.VersionInfoParcel
            r0 = 241199000(0xe606798, float:2.766001E-30)
            r1 = 1
            r4.<init>(r0, r5, r1, r3)
            com.google.android.gms.internal.ads.zzbff r5 = com.google.android.gms.internal.ads.zzbfu.zzc
            java.lang.Object r5 = r5.zze()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x0021
            goto L_0x0030
        L_0x0021:
            com.google.android.gms.ads.internal.client.zzen r5 = r2.zzg()
            if (r5 == 0) goto L_0x0030
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4 = new com.google.android.gms.ads.internal.util.client.VersionInfoParcel
            int r5 = r5.zza()
            r4.<init>(r0, r5, r1, r3)
        L_0x0030:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfhe.zzc(int, boolean, int):com.google.android.gms.ads.internal.util.client.VersionInfoParcel");
    }

    public final String zze() {
        zzen zzg = zzg();
        if (zzg != null) {
            return zzg.zzb();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(com.google.android.gms.internal.ads.zzbqo r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzbff r0 = com.google.android.gms.internal.ads.zzbfu.zza
            java.lang.Object r0 = r0.zze()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.client.zzcl r0 = r3.zzc
            if (r0 != 0) goto L_0x0015
        L_0x0013:
            r0 = r1
            goto L_0x0019
        L_0x0015:
            com.google.android.gms.internal.ads.zzbqo r0 = r0.getAdapterCreator()     // Catch:{ RemoteException -> 0x0013 }
        L_0x0019:
            java.util.concurrent.atomic.AtomicReference r2 = r3.zzd
            if (r0 == 0) goto L_0x001e
            r4 = r0
        L_0x001e:
            com.google.android.gms.internal.ads.zzfhd.zza(r2, r1, r4)
            return
        L_0x0022:
            java.util.concurrent.atomic.AtomicReference r0 = r3.zzd
            com.google.android.gms.internal.ads.zzfhd.zza(r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfhe.zzf(com.google.android.gms.internal.ads.zzbqo):void");
    }
}
