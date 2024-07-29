package com.amazon.a.a.n.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.amazon.a.a.n.a;
import com.amazon.a.a.o.c;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SimpleTaskPipeline */
public class b implements c {
    /* access modifiers changed from: private */
    public static final c a = new c("SimpleTaskPipeline");
    private final Handler b;
    /* access modifiers changed from: private */
    public final Set<Runnable> c = Collections.synchronizedSet(new HashSet());
    /* access modifiers changed from: private */
    public final String d;

    private b(HandlerThread handlerThread) {
        this.d = handlerThread.getName();
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper());
    }

    private b(String str) {
        this.d = str;
        this.b = new Handler();
    }

    public static b a(String str) {
        return new b(new HandlerThread("KIWI_" + str));
    }

    public static b b(String str) {
        return new b(str);
    }

    public void a(a aVar) {
        if (c.a) {
            c cVar = a;
            cVar.a("Scheduling task: " + aVar);
        }
        this.b.post(c(aVar));
    }

    public void b(a aVar) {
        if (c.a) {
            c cVar = a;
            cVar.a(this.d + ": Scheduling task immediately: " + aVar);
        }
        this.b.postAtFrontOfQueue(c(aVar));
    }

    public void a(a aVar, Date date) {
        long a2 = a(date);
        if (c.a) {
            c cVar = a;
            cVar.a(this.d + ": Scheduling task: " + aVar + ", at time: " + date + ", System uptimeMillis: " + System.currentTimeMillis() + ", uptimeMillis: " + a2);
        }
        this.b.postAtTime(c(aVar), a2);
    }

    private long a(Date date) {
        return SystemClock.uptimeMillis() + (date.getTime() - System.currentTimeMillis());
    }

    public void a(a aVar, long j) {
        if (c.a) {
            c cVar = a;
            cVar.a(this.d + ": Scheduling task: " + aVar + ", with delay: " + j);
        }
        this.b.postDelayed(c(aVar), j);
    }

    private Runnable c(final a aVar) {
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                StringBuilder sb;
                c cVar;
                b.this.c.remove(this);
                try {
                    if (c.a) {
                        c b2 = b.a;
                        b2.a(b.this.d + ": Executing Task: " + aVar + ", current time: " + new Date() + ", uptime: " + SystemClock.uptimeMillis());
                    }
                    aVar.a();
                    if (c.a) {
                        cVar = b.a;
                        sb = new StringBuilder();
                        sb.append(b.this.d);
                        sb.append(": Task finished executing: ");
                        sb.append(aVar);
                        cVar.a(sb.toString());
                    }
                } catch (Throwable th) {
                    if (c.a) {
                        c b3 = b.a;
                        b3.a(b.this.d + ": Task finished executing: " + aVar);
                    }
                    throw th;
                }
            }

            public String toString() {
                return aVar.toString();
            }
        };
        this.c.add(r0);
        return r0;
    }

    public void a() {
        for (Runnable next : this.c) {
            if (c.a) {
                c cVar = a;
                cVar.a(this.d + ": Removing callback: " + next);
            }
            this.b.removeCallbacks(next);
        }
        this.c.clear();
        if (this.b.getLooper() != Looper.getMainLooper() && this.b.getLooper().getThread().isAlive()) {
            c cVar2 = a;
            cVar2.a("Interrupting looper thread!");
            this.b.getLooper().getThread().interrupt();
            cVar2.a("Quitting looper: " + this.b.getLooper().getThread() + ", " + this.b.getLooper().getThread().isAlive());
            this.b.getLooper().quit();
        }
    }
}
