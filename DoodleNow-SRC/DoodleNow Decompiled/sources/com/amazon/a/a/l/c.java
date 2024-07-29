package com.amazon.a.a.l;

import android.app.Activity;
import android.content.Intent;
import com.amazon.a.a.c.f;
import com.amazon.a.a.k.d;
import com.amazon.a.a.n.b;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ActivityResultManagerImpl */
public class c implements d, b {
    /* access modifiers changed from: private */
    public static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("ActivityResultManagerImpl");
    private static final Random b = new Random();
    private static final int c = 65535;
    @com.amazon.a.a.k.a
    private b d;
    /* access modifiers changed from: private */
    @com.amazon.a.a.k.a
    public com.amazon.a.a.a.a e;
    @com.amazon.a.a.k.a
    private f f;
    /* access modifiers changed from: private */
    public AtomicReference<a> g = new AtomicReference<>();
    private BlockingQueue<a> h = new LinkedBlockingQueue();

    /* compiled from: ActivityResultManagerImpl */
    private static final class a {
        private final Intent a;
        private final int b;
        private Activity c;

        public int a() {
            return this.b;
        }

        public a(Intent intent, int i) {
            this.a = intent;
            this.b = i;
        }

        public void a(Activity activity) {
            com.amazon.a.a.o.c a2 = c.a;
            a2.a("Calling startActivityForResult from: " + activity);
            activity.startActivityForResult(this.a, this.b);
            this.c = activity;
        }

        public void b(Activity activity) {
            c.a.b("Context changed while awaiting result!");
            if (this.c != null) {
                com.amazon.a.a.o.c a2 = c.a;
                a2.b("Finishing activity from old context: " + this.c);
                this.c.finishActivity(this.b);
            }
            a(activity);
        }
    }

    public void e() {
        this.f.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() {
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.b.RESUME;
            }

            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }

            public void a(com.amazon.a.a.a.a.a aVar) {
                a aVar2 = (a) c.this.g.get();
                if (aVar2 != null) {
                    aVar2.b(aVar.b());
                }
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r8 = a;
        r8.a("Interrupted while awaiting for request, returning null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0092, code lost:
        r8.a("Received Response: " + r2.a());
        r7.g.set((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00aa, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00ab, code lost:
        r1 = a;
        r1.a("Received Response: " + r2.a());
        r7.g.set((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00c5, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0089, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x008b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazon.a.a.l.a a(android.content.Intent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "Received Response: "
            java.lang.String r1 = "Blocking for request: "
            com.amazon.a.a.l.c$a r2 = new com.amazon.a.a.l.c$a
            int r3 = r7.b()
            r2.<init>(r8, r3)
            java.util.concurrent.atomic.AtomicReference<com.amazon.a.a.l.c$a> r3 = r7.g
            r4 = 0
            boolean r3 = androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(r3, r4, r2)
            if (r3 != 0) goto L_0x001e
            com.amazon.a.a.o.c r8 = a
            java.lang.String r0 = "StartActivityForResult called while ActivityResultManager is already awaiting a result"
            r8.b(r0)
            return r4
        L_0x001e:
            com.amazon.a.a.o.c r3 = a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Starting activity for result: "
            r5.<init>(r6)
            r5.append(r8)
            java.lang.String r6 = ", "
            r5.append(r6)
            int r8 = r8.getFlags()
            r5.append(r8)
            java.lang.String r8 = ", requestId: "
            r5.append(r8)
            int r8 = r2.a()
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            r3.a(r8)
            com.amazon.a.a.l.c$2 r8 = new com.amazon.a.a.l.c$2
            r8.<init>(r2)
            com.amazon.a.a.n.b r5 = r7.d
            com.amazon.a.a.n.b.d r6 = com.amazon.a.a.n.b.d.FOREGROUND
            r5.b(r6, r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x008b }
            r8.<init>(r1)     // Catch:{ InterruptedException -> 0x008b }
            int r1 = r2.a()     // Catch:{ InterruptedException -> 0x008b }
            r8.append(r1)     // Catch:{ InterruptedException -> 0x008b }
            java.lang.String r8 = r8.toString()     // Catch:{ InterruptedException -> 0x008b }
            r3.a(r8)     // Catch:{ InterruptedException -> 0x008b }
            java.util.concurrent.BlockingQueue<com.amazon.a.a.l.a> r8 = r7.h     // Catch:{ InterruptedException -> 0x008b }
            java.lang.Object r8 = r8.take()     // Catch:{ InterruptedException -> 0x008b }
            com.amazon.a.a.l.a r8 = (com.amazon.a.a.l.a) r8     // Catch:{ InterruptedException -> 0x008b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            int r0 = r2.a()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r3.a(r0)
            java.util.concurrent.atomic.AtomicReference<com.amazon.a.a.l.c$a> r0 = r7.g
            r0.set(r4)
            return r8
        L_0x0089:
            r8 = move-exception
            goto L_0x00ab
        L_0x008b:
            com.amazon.a.a.o.c r8 = a     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = "Interrupted while awaiting for request, returning null"
            r8.a(r1)     // Catch:{ all -> 0x0089 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            int r0 = r2.a()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r8.a(r0)
            java.util.concurrent.atomic.AtomicReference<com.amazon.a.a.l.c$a> r8 = r7.g
            r8.set(r4)
            return r4
        L_0x00ab:
            com.amazon.a.a.o.c r1 = a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            int r0 = r2.a()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.a(r0)
            java.util.concurrent.atomic.AtomicReference<com.amazon.a.a.l.c$a> r0 = r7.g
            r0.set(r4)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.a.a.l.c.a(android.content.Intent):com.amazon.a.a.l.a");
    }

    private int b() {
        return b.nextInt(65535) + 1;
    }

    public boolean a(a aVar) {
        if (com.amazon.a.a.o.c.a) {
            com.amazon.a.a.o.c cVar = a;
            cVar.a("Recieved ActivityResult: " + aVar);
        }
        a aVar2 = this.g.get();
        if (aVar2 == null) {
            if (com.amazon.a.a.o.c.a) {
                a.a("We don't have a current open request, returning");
            }
            return false;
        } else if (aVar2.a() != aVar.b()) {
            if (com.amazon.a.a.o.c.a) {
                com.amazon.a.a.o.c cVar2 = a;
                cVar2.a("We don't have a request with code: " + aVar.b() + ", returning");
            }
            return false;
        } else {
            if (com.amazon.a.a.o.c.a) {
                com.amazon.a.a.o.c cVar3 = a;
                cVar3.a("Signaling thread waiting for request: " + aVar.b());
            }
            this.h.add(aVar);
            return true;
        }
    }
}
