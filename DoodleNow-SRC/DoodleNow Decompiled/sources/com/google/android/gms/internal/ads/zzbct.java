package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbct {
    /* access modifiers changed from: private */
    public zzbci zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final Object zzd = new Object();

    zzbct(Context context) {
        this.zzc = context;
    }

    /* access modifiers changed from: package-private */
    public final Future zzc(zzbcj zzbcj) {
        zzbcn zzbcn = new zzbcn(this);
        zzbcr zzbcr = new zzbcr(this, zzbcj, zzbcn);
        zzbcs zzbcs = new zzbcs(this, zzbcn);
        synchronized (this.zzd) {
            zzbci zzbci = new zzbci(this.zzc, zzu.zzt().zzb(), zzbcr, zzbcs);
            this.zza = zzbci;
            zzbci.checkAvailabilityAndConnect();
        }
        return zzbcn;
    }

    static /* bridge */ /* synthetic */ void zze(zzbct zzbct) {
        synchronized (zzbct.zzd) {
            zzbci zzbci = zzbct.zza;
            if (zzbci != null) {
                zzbci.disconnect();
                zzbct.zza = null;
                Binder.flushPendingCommands();
            }
        }
    }
}
