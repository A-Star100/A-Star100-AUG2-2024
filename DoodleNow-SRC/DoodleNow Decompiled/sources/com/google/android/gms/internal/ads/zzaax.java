package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaax extends HandlerThread implements Handler.Callback {
    private zzer zza;
    private Handler zzb;
    private Error zzc;
    private RuntimeException zzd;
    private zzaaz zze;

    public zzaax() {
        super("ExoPlayer:PlaceholderSurface");
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            try {
                int i2 = message.arg1;
                zzer zzer = this.zza;
                zzer.getClass();
                zzer.zzb(i2);
                this.zze = new zzaaz(this, this.zza.zza(), i2 != 0, (zzaay) null);
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e) {
                zzfe.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e);
                this.zzd = e;
                synchronized (this) {
                    notify();
                }
            } catch (zzes e2) {
                zzfe.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                this.zzd = new IllegalStateException(e2);
                synchronized (this) {
                    notify();
                }
            } catch (Error e3) {
                try {
                    zzfe.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                    this.zzc = e3;
                    synchronized (this) {
                        notify();
                    }
                } catch (Throwable th) {
                    synchronized (this) {
                        notify();
                        throw th;
                    }
                }
            }
        } else if (i == 2) {
            try {
                zzer zzer2 = this.zza;
                zzer2.getClass();
                zzer2.zzc();
            } catch (Throwable th2) {
                quit();
                throw th2;
            }
            quit();
            return true;
        }
        return true;
    }

    public final zzaaz zza(int i) {
        boolean z;
        start();
        this.zzb = new Handler(getLooper(), this);
        this.zza = new zzer(this.zzb, (zzeq) null);
        synchronized (this) {
            z = false;
            this.zzb.obtainMessage(1, i, 0).sendToTarget();
            while (this.zze == null && this.zzd == null && this.zzc == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzd;
        if (runtimeException == null) {
            Error error = this.zzc;
            if (error == null) {
                zzaaz zzaaz = this.zze;
                zzaaz.getClass();
                return zzaaz;
            }
            throw error;
        }
        throw runtimeException;
    }

    public final void zzb() {
        Handler handler = this.zzb;
        handler.getClass();
        handler.sendEmptyMessage(2);
    }
}
