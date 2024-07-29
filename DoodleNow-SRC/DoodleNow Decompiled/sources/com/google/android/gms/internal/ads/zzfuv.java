package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfuv extends zzfvh {
    final /* synthetic */ zzfup zza;
    final /* synthetic */ zzfvd zzb;
    final /* synthetic */ TaskCompletionSource zzc;
    final /* synthetic */ zzfuy zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfuv(zzfuy zzfuy, TaskCompletionSource taskCompletionSource, zzfup zzfup, zzfvd zzfvd, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zza = zzfup;
        this.zzb = zzfvd;
        this.zzc = taskCompletionSource2;
        this.zzd = zzfuy;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzftz] */
    /* access modifiers changed from: protected */
    public final void zza() {
        try {
            ? zze = this.zzd.zza.zze();
            if (zze != 0) {
                zzfup zzfup = this.zza;
                String zzb2 = this.zzd.zzd;
                Bundle bundle = new Bundle();
                bundle.putString("sessionToken", zzfup.zzb());
                bundle.putString("callerPackage", zzb2);
                bundle.putString("appId", zzfup.zza());
                zze.zze(bundle, new zzfux(this.zzd, this.zzb));
            }
        } catch (RemoteException e) {
            zzfuy zzfuy = this.zzd;
            zzfuy.zzb.zzb(e, "dismiss overlay display from: %s", zzfuy.zzd);
            this.zzc.trySetException(new RuntimeException(e));
        }
    }
}
