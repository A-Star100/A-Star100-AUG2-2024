package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfb {
    private final zzel zza;
    private final zzev zzb;
    private final zzez zzc;
    private final CopyOnWriteArraySet zzd;
    private final ArrayDeque zze;
    private final ArrayDeque zzf;
    private final Object zzg;
    private boolean zzh;
    private boolean zzi;

    public zzfb(Looper looper, zzel zzel, zzez zzez) {
        this(new CopyOnWriteArraySet(), looper, zzel, zzez, true);
    }

    public static /* synthetic */ boolean zzg(zzfb zzfb, Message message) {
        Iterator it = zzfb.zzd.iterator();
        while (it.hasNext()) {
            ((zzfa) it.next()).zzb(zzfb.zzc);
            if (zzfb.zzb.zzg(0)) {
                return true;
            }
        }
        return true;
    }

    private final void zzh() {
        if (this.zzi) {
            zzek.zzf(Thread.currentThread() == this.zzb.zza().getThread());
        }
    }

    public final zzfb zza(Looper looper, zzez zzez) {
        return new zzfb(this.zzd, looper, this.zza, zzez, this.zzi);
    }

    public final void zzb(Object obj) {
        synchronized (this.zzg) {
            if (!this.zzh) {
                this.zzd.add(new zzfa(obj));
            }
        }
    }

    public final void zzc() {
        zzh();
        if (!this.zzf.isEmpty()) {
            if (!this.zzb.zzg(0)) {
                zzev zzev = this.zzb;
                zzev.zzk(zzev.zzb(0));
            }
            boolean z = !this.zze.isEmpty();
            this.zze.addAll(this.zzf);
            this.zzf.clear();
            if (!z) {
                while (!this.zze.isEmpty()) {
                    ((Runnable) this.zze.peekFirst()).run();
                    this.zze.removeFirst();
                }
            }
        }
    }

    public final void zzd(int i, zzey zzey) {
        zzh();
        this.zzf.add(new zzex(new CopyOnWriteArraySet(this.zzd), i, zzey));
    }

    public final void zze() {
        zzh();
        synchronized (this.zzg) {
            this.zzh = true;
        }
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            ((zzfa) it.next()).zzc(this.zzc);
        }
        this.zzd.clear();
    }

    public final void zzf(Object obj) {
        zzh();
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            zzfa zzfa = (zzfa) it.next();
            if (zzfa.zza.equals(obj)) {
                zzfa.zzc(this.zzc);
                this.zzd.remove(zzfa);
            }
        }
    }

    private zzfb(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, zzel zzel, zzez zzez, boolean z) {
        this.zza = zzel;
        this.zzd = copyOnWriteArraySet;
        this.zzc = zzez;
        this.zzg = new Object();
        this.zze = new ArrayDeque();
        this.zzf = new ArrayDeque();
        this.zzb = zzel.zzb(looper, new zzew(this));
        this.zzi = z;
    }
}
