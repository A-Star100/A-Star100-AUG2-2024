package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
abstract class zzgdd extends zzgdj {
    private static final zzgeo zza = new zzgeo(zzgdd.class);
    @CheckForNull
    private zzfzi zzb;
    private final boolean zzc;
    private final boolean zzf;

    zzgdd(zzfzi zzfzi, boolean z, boolean z2) {
        super(zzfzi.size());
        zzfzi.getClass();
        this.zzb = zzfzi;
        this.zzc = z;
        this.zzf = z2;
    }

    private final void zzG(int i, Future future) {
        try {
            zzf(i, zzgee.zzp(future));
        } catch (ExecutionException e) {
            zzI(e.getCause());
        } catch (Throwable th) {
            zzI(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzH */
    public final void zzx(@CheckForNull zzfzi zzfzi) {
        int zzA = zzA();
        int i = 0;
        zzfwr.zzk(zzA >= 0, "Less than 0 remaining futures");
        if (zzA == 0) {
            if (zzfzi != null) {
                zzgbt zze = zzfzi.iterator();
                while (zze.hasNext()) {
                    Future future = (Future) zze.next();
                    if (!future.isCancelled()) {
                        zzG(i, future);
                    }
                    i++;
                }
            }
            zzF();
            zzu();
            zzy(2);
        }
    }

    private static void zzJ(Throwable th) {
        zza.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    private static boolean zzK(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final String zza() {
        zzfzi zzfzi = this.zzb;
        if (zzfzi != null) {
            return "futures=".concat(zzfzi.toString());
        }
        return super.zza();
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzfzi zzfzi = this.zzb;
        boolean z = true;
        zzy(1);
        boolean isCancelled = isCancelled();
        if (zzfzi == null) {
            z = false;
        }
        if (z && isCancelled) {
            boolean zzt = zzt();
            zzgbt zze = zzfzi.iterator();
            while (zze.hasNext()) {
                ((Future) zze.next()).cancel(zzt);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void zzf(int i, Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzu();

    /* access modifiers changed from: package-private */
    public final void zzv() {
        Objects.requireNonNull(this.zzb);
        if (this.zzb.isEmpty()) {
            zzu();
        } else if (this.zzc) {
            zzgbt zze = this.zzb.iterator();
            int i = 0;
            while (zze.hasNext()) {
                ListenableFuture listenableFuture = (ListenableFuture) zze.next();
                listenableFuture.addListener(new zzgdb(this, listenableFuture, i), zzgds.INSTANCE);
                i++;
            }
        } else {
            zzgdc zzgdc = new zzgdc(this, this.zzf ? this.zzb : null);
            zzgbt zze2 = this.zzb.iterator();
            while (zze2.hasNext()) {
                ((ListenableFuture) zze2.next()).addListener(zzgdc, zzgds.INSTANCE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzw(ListenableFuture listenableFuture, int i) {
        try {
            if (listenableFuture.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzG(i, listenableFuture);
            }
        } finally {
            zzx((zzfzi) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzy(int i) {
        this.zzb = null;
    }

    /* access modifiers changed from: package-private */
    public final void zze(Set set) {
        set.getClass();
        if (!isCancelled()) {
            zzK(set, (Throwable) Objects.requireNonNull(zzl()));
        }
    }

    private final void zzI(Throwable th) {
        th.getClass();
        if (this.zzc && !zzd(th) && zzK(zzC(), th)) {
            zzJ(th);
        } else if (th instanceof Error) {
            zzJ(th);
        }
    }
}
