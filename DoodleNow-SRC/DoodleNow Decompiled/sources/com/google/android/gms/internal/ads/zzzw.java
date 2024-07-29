package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzzw extends Handler implements Runnable {
    final /* synthetic */ zzaab zza;
    private final zzzx zzb;
    private final long zzc;
    private zzzt zzd;
    private IOException zze;
    private int zzf;
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzzw(zzaab zzaab, Looper looper, zzzx zzzx, zzzt zzzt, int i, long j) {
        super(looper);
        this.zza = zzaab;
        this.zzb = zzzx;
        this.zzd = zzzt;
        this.zzc = j;
    }

    public final void handleMessage(Message message) {
        long j;
        if (!this.zzi) {
            if (message.what == 0) {
                zzd();
            } else if (message.what != 3) {
                this.zza.zzf = null;
                long j2 = this.zzc;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j3 = elapsedRealtime - j2;
                zzzt zzzt = this.zzd;
                zzzt.getClass();
                if (this.zzh) {
                    zzzt.zzJ(this.zzb, elapsedRealtime, j3, false);
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    try {
                        zzzt.zzK(this.zzb, elapsedRealtime, j3);
                    } catch (RuntimeException e) {
                        zzfe.zzd("LoadTask", "Unexpected exception handling load completed", e);
                        this.zza.zzg = new zzaaa(e);
                    }
                } else if (i == 2) {
                    IOException iOException = (IOException) message.obj;
                    this.zze = iOException;
                    int i2 = this.zzf + 1;
                    this.zzf = i2;
                    zzzv zzu = zzzt.zzu(this.zzb, elapsedRealtime, j3, iOException, i2);
                    if (zzu.zza == 3) {
                        this.zza.zzg = this.zze;
                    } else if (zzu.zza != 2) {
                        if (zzu.zza == 1) {
                            this.zzf = 1;
                        }
                        if (zzu.zzb != C.TIME_UNSET) {
                            j = zzu.zzb;
                        } else {
                            j = (long) Math.min((this.zzf - 1) * 1000, 5000);
                        }
                        zzc(j);
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = !this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (z) {
                Trace.beginSection("load:" + this.zzb.getClass().getSimpleName());
                this.zzb.zzh();
                Trace.endSection();
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (!this.zzi) {
                sendEmptyMessage(1);
            }
        } catch (IOException e) {
            if (!this.zzi) {
                obtainMessage(2, e).sendToTarget();
            }
        } catch (Exception e2) {
            if (!this.zzi) {
                zzfe.zzd("LoadTask", "Unexpected exception loading stream", e2);
                obtainMessage(2, new zzaaa(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            if (!this.zzi) {
                zzfe.zzd("LoadTask", "OutOfMemory error loading stream", e3);
                obtainMessage(2, new zzaaa(e3)).sendToTarget();
            }
        } catch (Error e4) {
            if (!this.zzi) {
                zzfe.zzd("LoadTask", "Unexpected error loading stream", e4);
                obtainMessage(3, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final void zza(boolean z) {
        this.zzi = z;
        this.zze = null;
        if (hasMessages(0)) {
            this.zzh = true;
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.zzh = true;
                this.zzb.zzg();
                Thread thread = this.zzg;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z) {
            this.zza.zzf = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zzzt zzzt = this.zzd;
            zzzt.getClass();
            zzzt.zzJ(this.zzb, elapsedRealtime, elapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }

    public final void zzb(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i) {
            throw iOException;
        }
    }

    public final void zzc(long j) {
        zzek.zzf(this.zza.zzf == null);
        this.zza.zzf = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            zzd();
        }
    }

    private final void zzd() {
        this.zze = null;
        zzaab zzaab = this.zza;
        ExecutorService zzd2 = zzaab.zze;
        zzzw zzc2 = zzaab.zzf;
        zzc2.getClass();
        zzd2.execute(zzc2);
    }
}
