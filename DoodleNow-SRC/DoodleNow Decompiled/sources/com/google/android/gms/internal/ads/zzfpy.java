package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfpy implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzfra zza;
    private final String zzb;
    private final String zzc;
    private final zzazh zzd;
    private final LinkedBlockingQueue zze;
    private final HandlerThread zzf;
    private final zzfpp zzg;
    private final long zzh = System.currentTimeMillis();

    public zzfpy(Context context, int i, zzazh zzazh, String str, String str2, String str3, zzfpp zzfpp) {
        this.zzb = str;
        this.zzd = zzazh;
        this.zzc = str2;
        this.zzg = zzfpp;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zzf = handlerThread;
        handlerThread.start();
        zzfra zzfra = new zzfra(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zzfra;
        this.zze = new LinkedBlockingQueue();
        zzfra.checkAvailabilityAndConnect();
    }

    static zzfrm zza() {
        return new zzfrm((byte[]) null, 1);
    }

    private final void zze(int i, long j, Exception exc) {
        this.zzg.zzc(i, System.currentTimeMillis() - j, exc);
    }

    public final void onConnected(Bundle bundle) {
        zzfrf zzd2 = zzd();
        if (zzd2 != null) {
            try {
                zzfrm zzf2 = zzd2.zzf(new zzfrk(1, this.zzd, this.zzb, this.zzc));
                zze(5011, this.zzh, (Exception) null);
                this.zze.put(zzf2);
            } catch (Throwable th) {
                zzc();
                this.zzf.quit();
                throw th;
            }
            zzc();
            this.zzf.quit();
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zze(4012, this.zzh, (Exception) null);
            this.zze.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            zze(4011, this.zzh, (Exception) null);
            this.zze.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final zzfrm zzb(int i) {
        zzfrm zzfrm;
        try {
            zzfrm = (zzfrm) this.zze.poll(50000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zze(2009, this.zzh, e);
            zzfrm = null;
        }
        zze(3004, this.zzh, (Exception) null);
        if (zzfrm != null) {
            if (zzfrm.zzc == 7) {
                zzfpp.zzg(zzasn.DISABLED);
            } else {
                zzfpp.zzg(zzasn.ENABLED);
            }
        }
        return zzfrm == null ? zza() : zzfrm;
    }

    public final void zzc() {
        zzfra zzfra = this.zza;
        if (zzfra == null) {
            return;
        }
        if (zzfra.isConnected() || this.zza.isConnecting()) {
            this.zza.disconnect();
        }
    }

    /* access modifiers changed from: protected */
    public final zzfrf zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
