package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfuw extends zzfvh {
    final /* synthetic */ zzfvf zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzfvd zzc;
    final /* synthetic */ TaskCompletionSource zzd;
    final /* synthetic */ zzfuy zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfuw(zzfuy zzfuy, TaskCompletionSource taskCompletionSource, zzfvf zzfvf, int i, zzfvd zzfvd, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zza = zzfvf;
        this.zzb = i;
        this.zzc = zzfvd;
        this.zzd = taskCompletionSource2;
        this.zze = zzfuy;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzftz] */
    /* access modifiers changed from: protected */
    public final void zza() {
        try {
            ? zze2 = this.zze.zza.zze();
            if (zze2 != 0) {
                zzfvf zzfvf = this.zza;
                String zzb2 = this.zze.zzd;
                int i = this.zzb;
                Bundle bundle = new Bundle();
                bundle.putString("sessionToken", zzfvf.zzb());
                bundle.putInt("displayMode", i);
                bundle.putString("callerPackage", zzb2);
                bundle.putString("appId", zzfvf.zza());
                zze2.zzg(bundle, new zzfux(this.zze, this.zzc));
            }
        } catch (RemoteException e) {
            int i2 = this.zzb;
            zzfuy.zzb.zzb(e, "switchDisplayMode overlay display to %d from: %s", Integer.valueOf(i2), this.zze.zzd);
            this.zzd.trySetException(new RuntimeException(e));
        }
    }
}
