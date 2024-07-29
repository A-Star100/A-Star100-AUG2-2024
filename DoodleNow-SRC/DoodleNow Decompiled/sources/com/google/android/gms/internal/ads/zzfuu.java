package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfuu extends zzfvh {
    final /* synthetic */ zzfva zza;
    final /* synthetic */ zzfvd zzb;
    final /* synthetic */ TaskCompletionSource zzc;
    final /* synthetic */ zzfuy zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfuu(zzfuy zzfuy, TaskCompletionSource taskCompletionSource, zzfva zzfva, zzfvd zzfvd, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zza = zzfva;
        this.zzb = zzfvd;
        this.zzc = taskCompletionSource2;
        this.zzd = zzfuy;
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzftz] */
    /* access modifiers changed from: protected */
    public final void zza() {
        try {
            ? zze = this.zzd.zza.zze();
            if (zze != 0) {
                zzfuy zzfuy = this.zzd;
                String zzb2 = zzfuy.zzd;
                zzfva zzfva = this.zza;
                String zzb3 = zzfuy.zzd;
                Bundle bundle = new Bundle();
                bundle.putBinder("windowToken", zzfva.zzf());
                bundle.putString("adFieldEnifd", zzfva.zzg());
                bundle.putInt("layoutGravity", zzfva.zzc());
                bundle.putFloat("layoutVerticalMargin", zzfva.zza());
                bundle.putInt("displayMode", 0);
                bundle.putInt("triggerMode", 0);
                bundle.putInt("windowWidthPx", zzfva.zze());
                bundle.putString("deeplinkUrl", (String) null);
                bundle.putBoolean("stableSessionToken", false);
                bundle.putString("callerPackage", zzb3);
                if (zzfva.zzh() != null) {
                    bundle.putString("appId", zzfva.zzh());
                }
                zze.zzf(zzb2, bundle, new zzfux(this.zzd, this.zzb));
            }
        } catch (RemoteException e) {
            zzfuy zzfuy2 = this.zzd;
            zzfuy.zzb.zzb(e, "show overlay display from: %s", zzfuy2.zzd);
            this.zzc.trySetException(new RuntimeException(e));
        }
    }
}
