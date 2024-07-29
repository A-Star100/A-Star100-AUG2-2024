package com.google.android.gms.iid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.gcm.zzj;
import java.util.ArrayDeque;
import java.util.Queue;

final class zzt implements ServiceConnection {
    int state;
    final Messenger zzch;
    zzy zzci;
    final Queue<zzz<?>> zzcj;
    final SparseArray<zzz<?>> zzck;
    final /* synthetic */ zzr zzcl;

    private zzt(zzr zzr) {
        this.zzcl = zzr;
        this.state = 0;
        this.zzch = new Messenger(new zzj(Looper.getMainLooper(), new zzu(this)));
        this.zzcj = new ArrayDeque();
        this.zzck = new SparseArray<>();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zze(com.google.android.gms.iid.zzz r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            int r0 = r6.state     // Catch:{ all -> 0x0097 }
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0041
            if (r0 == r3) goto L_0x003a
            if (r0 == r1) goto L_0x0030
            r7 = 3
            if (r0 == r7) goto L_0x002e
            r7 = 4
            if (r0 != r7) goto L_0x0013
            goto L_0x002e
        L_0x0013:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0097 }
            int r0 = r6.state     // Catch:{ all -> 0x0097 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0097 }
            r2 = 26
            r1.<init>(r2)     // Catch:{ all -> 0x0097 }
            java.lang.String r2 = "Unknown state: "
            r1.append(r2)     // Catch:{ all -> 0x0097 }
            r1.append(r0)     // Catch:{ all -> 0x0097 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0097 }
            r7.<init>(r0)     // Catch:{ all -> 0x0097 }
            throw r7     // Catch:{ all -> 0x0097 }
        L_0x002e:
            monitor-exit(r6)
            return r2
        L_0x0030:
            java.util.Queue<com.google.android.gms.iid.zzz<?>> r0 = r6.zzcj     // Catch:{ all -> 0x0097 }
            r0.add(r7)     // Catch:{ all -> 0x0097 }
            r6.zzt()     // Catch:{ all -> 0x0097 }
            monitor-exit(r6)
            return r3
        L_0x003a:
            java.util.Queue<com.google.android.gms.iid.zzz<?>> r0 = r6.zzcj     // Catch:{ all -> 0x0097 }
            r0.add(r7)     // Catch:{ all -> 0x0097 }
            monitor-exit(r6)
            return r3
        L_0x0041:
            java.util.Queue<com.google.android.gms.iid.zzz<?>> r0 = r6.zzcj     // Catch:{ all -> 0x0097 }
            r0.add(r7)     // Catch:{ all -> 0x0097 }
            int r7 = r6.state     // Catch:{ all -> 0x0097 }
            if (r7 != 0) goto L_0x004c
            r7 = r3
            goto L_0x004d
        L_0x004c:
            r7 = r2
        L_0x004d:
            com.google.android.gms.common.internal.Preconditions.checkState(r7)     // Catch:{ all -> 0x0097 }
            java.lang.String r7 = "MessengerIpcClient"
            boolean r7 = android.util.Log.isLoggable(r7, r1)     // Catch:{ all -> 0x0097 }
            if (r7 == 0) goto L_0x005f
            java.lang.String r7 = "MessengerIpcClient"
            java.lang.String r0 = "Starting bind to GmsCore"
            android.util.Log.v(r7, r0)     // Catch:{ all -> 0x0097 }
        L_0x005f:
            r6.state = r3     // Catch:{ all -> 0x0097 }
            android.content.Intent r7 = new android.content.Intent     // Catch:{ all -> 0x0097 }
            java.lang.String r0 = "com.google.android.c2dm.intent.REGISTER"
            r7.<init>(r0)     // Catch:{ all -> 0x0097 }
            java.lang.String r0 = "com.google.android.gms"
            r7.setPackage(r0)     // Catch:{ all -> 0x0097 }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ all -> 0x0097 }
            com.google.android.gms.iid.zzr r1 = r6.zzcl     // Catch:{ all -> 0x0097 }
            android.content.Context r1 = r1.zzl     // Catch:{ all -> 0x0097 }
            boolean r7 = r0.bindService(r1, r7, r6, r3)     // Catch:{ all -> 0x0097 }
            if (r7 != 0) goto L_0x0083
            java.lang.String r7 = "Unable to bind to service"
            r6.zzd(r2, r7)     // Catch:{ all -> 0x0097 }
            goto L_0x0095
        L_0x0083:
            com.google.android.gms.iid.zzr r7 = r6.zzcl     // Catch:{ all -> 0x0097 }
            java.util.concurrent.ScheduledExecutorService r7 = r7.zzce     // Catch:{ all -> 0x0097 }
            com.google.android.gms.iid.zzv r0 = new com.google.android.gms.iid.zzv     // Catch:{ all -> 0x0097 }
            r0.<init>(r6)     // Catch:{ all -> 0x0097 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0097 }
            r4 = 30
            r7.schedule(r0, r4, r1)     // Catch:{ all -> 0x0097 }
        L_0x0095:
            monitor-exit(r6)
            return r3
        L_0x0097:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzt.zze(com.google.android.gms.iid.zzz):boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        r5 = r5.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005d, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
        r1.zzd(new com.google.android.gms.iid.zzaa(4, "Not supported by GmsCore"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        r1.zzh(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(android.os.Message r5) {
        /*
            r4 = this;
            int r0 = r5.arg1
            java.lang.String r1 = "MessengerIpcClient"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)
            if (r1 == 0) goto L_0x0023
            java.lang.String r1 = "MessengerIpcClient"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 41
            r2.<init>(r3)
            java.lang.String r3 = "Received response to request: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
        L_0x0023:
            monitor-enter(r4)
            android.util.SparseArray<com.google.android.gms.iid.zzz<?>> r1 = r4.zzck     // Catch:{ all -> 0x006f }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x006f }
            com.google.android.gms.iid.zzz r1 = (com.google.android.gms.iid.zzz) r1     // Catch:{ all -> 0x006f }
            r2 = 1
            if (r1 != 0) goto L_0x0049
            java.lang.String r5 = "MessengerIpcClient"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r3 = 50
            r1.<init>(r3)     // Catch:{ all -> 0x006f }
            java.lang.String r3 = "Received response for unknown request: "
            r1.append(r3)     // Catch:{ all -> 0x006f }
            r1.append(r0)     // Catch:{ all -> 0x006f }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x006f }
            android.util.Log.w(r5, r0)     // Catch:{ all -> 0x006f }
            monitor-exit(r4)     // Catch:{ all -> 0x006f }
            return r2
        L_0x0049:
            android.util.SparseArray<com.google.android.gms.iid.zzz<?>> r3 = r4.zzck     // Catch:{ all -> 0x006f }
            r3.remove(r0)     // Catch:{ all -> 0x006f }
            r4.zzu()     // Catch:{ all -> 0x006f }
            monitor-exit(r4)     // Catch:{ all -> 0x006f }
            android.os.Bundle r5 = r5.getData()
            java.lang.String r0 = "unsupported"
            r3 = 0
            boolean r0 = r5.getBoolean(r0, r3)
            if (r0 == 0) goto L_0x006b
            com.google.android.gms.iid.zzaa r5 = new com.google.android.gms.iid.zzaa
            r0 = 4
            java.lang.String r3 = "Not supported by GmsCore"
            r5.<init>(r0, r3)
            r1.zzd(r5)
            goto L_0x006e
        L_0x006b:
            r1.zzh(r5)
        L_0x006e:
            return r2
        L_0x006f:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x006f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzt.zzd(android.os.Message):boolean");
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            zzd(0, "Null service connection");
            return;
        }
        try {
            this.zzci = new zzy(iBinder);
            this.state = 2;
            zzt();
        } catch (RemoteException e) {
            zzd(0, e.getMessage());
        }
    }

    private final void zzt() {
        this.zzcl.zzce.execute(new zzw(this));
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        zzd(2, "Service disconnected");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzd(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        int i2 = this.state;
        if (i2 == 0) {
            throw new IllegalStateException();
        } else if (i2 == 1 || i2 == 2) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.state = 4;
            ConnectionTracker.getInstance().unbindService(this.zzcl.zzl, this);
            zzaa zzaa = new zzaa(i, str);
            for (zzz zzd : this.zzcj) {
                zzd.zzd(zzaa);
            }
            this.zzcj.clear();
            for (int i3 = 0; i3 < this.zzck.size(); i3++) {
                this.zzck.valueAt(i3).zzd(zzaa);
            }
            this.zzck.clear();
        } else if (i2 == 3) {
            this.state = 4;
        } else if (i2 != 4) {
            int i4 = this.state;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i4);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzu() {
        if (this.state == 2 && this.zzcj.isEmpty() && this.zzck.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.state = 3;
            ConnectionTracker.getInstance().unbindService(this.zzcl.zzl, this);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzv() {
        if (this.state == 1) {
            zzd(1, "Timed out while binding");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzg(int i) {
        zzz zzz = this.zzck.get(i);
        if (zzz != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            Log.w("MessengerIpcClient", sb.toString());
            this.zzck.remove(i);
            zzz.zzd(new zzaa(3, "Timed out waiting for response"));
            zzu();
        }
    }
}
