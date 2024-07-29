package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzctb extends zzcrm {
    private final zzbiv zzc;
    private final Runnable zzd;
    private final Executor zze;

    public zzctb(zzctu zzctu, zzbiv zzbiv, Runnable runnable, Executor executor) {
        super(zzctu);
        this.zzc = zzbiv;
        this.zzd = runnable;
        this.zze = executor;
    }

    static /* synthetic */ void zzi(AtomicReference atomicReference) {
        Runnable runnable = (Runnable) atomicReference.getAndSet((Object) null);
        if (runnable != null) {
            runnable.run();
        }
    }

    public final int zza() {
        return 0;
    }

    public final View zzc() {
        return null;
    }

    public final zzdq zzd() {
        return null;
    }

    public final zzffo zze() {
        return null;
    }

    public final zzffo zzf() {
        return null;
    }

    public final void zzg() {
    }

    public final void zzh(ViewGroup viewGroup, zzq zzq) {
    }

    public final void zzj() {
        this.zze.execute(new zzcta(this, new zzcsz(new AtomicReference(this.zzd))));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(Runnable runnable) {
        try {
            if (!this.zzc.zze(ObjectWrapper.wrap(runnable))) {
                zzi(((zzcsz) runnable).zza);
            }
        } catch (RemoteException unused) {
            zzi(((zzcsz) runnable).zza);
        }
    }
}
