package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfvr {
    private static final Map zza = new HashMap();
    /* access modifiers changed from: private */
    public final Context zzb;
    /* access modifiers changed from: private */
    public final zzfvg zzc;
    private final String zzd;
    /* access modifiers changed from: private */
    public final List zze = new ArrayList();
    private final Set zzf = new HashSet();
    /* access modifiers changed from: private */
    public final Object zzg = new Object();
    /* access modifiers changed from: private */
    public boolean zzh;
    private final Intent zzi;
    private final WeakReference zzj;
    private final IBinder.DeathRecipient zzk = new zzfvi(this);
    /* access modifiers changed from: private */
    public final AtomicInteger zzl = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public ServiceConnection zzm;
    /* access modifiers changed from: private */
    public IInterface zzn;
    private final zzfut zzo;

    public zzfvr(Context context, zzfvg zzfvg, String str, Intent intent, zzfut zzfut, zzfvm zzfvm) {
        this.zzb = context;
        this.zzc = zzfvg;
        this.zzd = "OverlayDisplayService";
        this.zzi = intent;
        this.zzo = zzfut;
        this.zzj = new WeakReference((Object) null);
    }

    public static /* synthetic */ void zzj(zzfvr zzfvr) {
        zzfvr.zzc.zzc("reportBinderDeath", new Object[0]);
        zzfvm zzfvm = (zzfvm) zzfvr.zzj.get();
        if (zzfvm != null) {
            zzfvr.zzc.zzc("calling onBinderDied", new Object[0]);
            zzfvm.zza();
        } else {
            zzfvr.zzc.zzc("%s : Binder has died.", zzfvr.zzd);
            for (zzfvh zzc2 : zzfvr.zze) {
                zzc2.zzc(zzfvr.zzv());
            }
            zzfvr.zze.clear();
        }
        synchronized (zzfvr.zzg) {
            zzfvr.zzw();
        }
    }

    static /* bridge */ /* synthetic */ void zzn(zzfvr zzfvr, TaskCompletionSource taskCompletionSource) {
        zzfvr.zzf.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new zzfvj(zzfvr, taskCompletionSource));
    }

    static /* bridge */ /* synthetic */ void zzq(zzfvr zzfvr) {
        zzfvr.zzc.zzc("linkToDeath", new Object[0]);
        try {
            zzfvr.zzn.asBinder().linkToDeath(zzfvr.zzk, 0);
        } catch (RemoteException e) {
            zzfvr.zzc.zzb(e, "linkToDeath failed", new Object[0]);
        }
    }

    static /* bridge */ /* synthetic */ void zzr(zzfvr zzfvr) {
        zzfvr.zzc.zzc("unlinkToDeath", new Object[0]);
        zzfvr.zzn.asBinder().unlinkToDeath(zzfvr.zzk, 0);
    }

    private final RemoteException zzv() {
        return new RemoteException(String.valueOf(this.zzd).concat(" : Binder has died."));
    }

    /* access modifiers changed from: private */
    public final void zzw() {
        for (TaskCompletionSource trySetException : this.zzf) {
            trySetException.trySetException(zzv());
        }
        this.zzf.clear();
    }

    public final Handler zzc() {
        Handler handler;
        Map map = zza;
        synchronized (map) {
            if (!map.containsKey(this.zzd)) {
                HandlerThread handlerThread = new HandlerThread(this.zzd, 10);
                handlerThread.start();
                map.put(this.zzd, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) map.get(this.zzd);
        }
        return handler;
    }

    public final IInterface zze() {
        return this.zzn;
    }

    public final void zzs(zzfvh zzfvh, TaskCompletionSource taskCompletionSource) {
        zzc().post(new zzfvk(this, zzfvh.zzb(), taskCompletionSource, zzfvh));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzt(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.zzg) {
            this.zzf.remove(taskCompletionSource);
        }
    }

    public final void zzu() {
        zzc().post(new zzfvl(this));
    }

    static /* bridge */ /* synthetic */ void zzp(zzfvr zzfvr, zzfvh zzfvh) {
        if (zzfvr.zzn == null && !zzfvr.zzh) {
            zzfvr.zzc.zzc("Initiate binding to the service.", new Object[0]);
            zzfvr.zze.add(zzfvh);
            zzfvq zzfvq = new zzfvq(zzfvr, (zzfvp) null);
            zzfvr.zzm = zzfvq;
            zzfvr.zzh = true;
            if (!zzfvr.zzb.bindService(zzfvr.zzi, zzfvq, 1)) {
                zzfvr.zzc.zzc("Failed to bind to the service.", new Object[0]);
                zzfvr.zzh = false;
                for (zzfvh zzc2 : zzfvr.zze) {
                    zzc2.zzc(new zzfvs());
                }
                zzfvr.zze.clear();
            }
        } else if (zzfvr.zzh) {
            zzfvr.zzc.zzc("Waiting to bind to the service.", new Object[0]);
            zzfvr.zze.add(zzfvh);
        } else {
            zzfvh.run();
        }
    }
}
