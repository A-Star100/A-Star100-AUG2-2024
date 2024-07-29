package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzm;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcgz {
    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.gms.internal.ads.zzcgm, java.lang.Object] */
    public static final zzcgm zza(Context context, zzcie zzcie, String str, boolean z, boolean z2, zzawo zzawo, zzbfc zzbfc, VersionInfoParcel versionInfoParcel, zzbeo zzbeo, zzm zzm, zza zza, zzbcx zzbcx, zzffn zzffn, zzffq zzffq, zzefo zzefo, zzfgm zzfgm) throws zzcgy {
        StrictMode.ThreadPolicy threadPolicy;
        zzbdz.zza(context);
        try {
            zzcgv zzcgv = new zzcgv(context, zzcie, str, z, z2, zzawo, zzbfc, versionInfoParcel, (zzbeo) null, zzm, zza, zzbcx, zzffn, zzffq, zzfgm, zzefo);
            threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            ? zza2 = zzcgv.zza();
            StrictMode.setThreadPolicy(threadPolicy);
            return zza2;
        } catch (Throwable th) {
            throw new zzcgy("Webview initialization failed.", th);
        }
    }
}
