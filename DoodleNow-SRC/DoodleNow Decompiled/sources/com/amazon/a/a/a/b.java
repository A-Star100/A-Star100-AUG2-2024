package com.amazon.a.a.a;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.amazon.a.a.c.f;
import com.amazon.a.a.k.a;
import com.amazon.a.a.k.d;
import com.amazon.a.a.o.c;
import com.amazon.a.a.o.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ContextManagerImplV2 */
public final class b implements a, d {
    public static final c a = new c("ContextManagerImplV2");
    private final AtomicReference<Activity> b = new AtomicReference<>();
    private final List<Activity> c = new ArrayList();
    private final g<Service> d = new g<>();
    private final g<Activity> e = new g<>();
    private final AtomicBoolean f = new AtomicBoolean(false);
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    @a
    private Application i;
    @a
    private com.amazon.a.a.n.b j;
    @a
    private f k;
    private String l;
    private boolean m = false;

    public Activity a() {
        com.amazon.a.a.o.a.a.a();
        for (int size = this.c.size() - 1; size >= 0; size--) {
            Activity activity = this.c.get(size);
            if (g(activity)) {
                return activity;
            }
        }
        return null;
    }

    private boolean g(Activity activity) {
        if (activity == null) {
            return false;
        }
        return activity.isTaskRoot();
    }

    public void a(Activity activity) {
        com.amazon.a.a.o.a.a.a((Object) activity, "activity");
        com.amazon.a.a.o.a.a.a();
        this.c.add(activity);
        if (c.a) {
            c cVar = a;
            cVar.a("Activity->onCreate.  Activity: " + activity + ", Total Activities: " + this.c.size());
        }
        a(com.amazon.a.a.a.a.b.CREATE, activity);
        if (i()) {
            this.m = true;
            a(com.amazon.a.a.a.a.d.CREATE);
        }
    }

    private boolean i() {
        return !this.m && this.c.size() == 1;
    }

    private void a(com.amazon.a.a.a.a.b bVar, Activity activity) {
        this.k.a((com.amazon.a.a.c.a) new com.amazon.a.a.a.a.a(bVar, activity));
    }

    private void a(com.amazon.a.a.a.a.d dVar) {
        this.k.a((com.amazon.a.a.c.a) new com.amazon.a.a.a.a.c(dVar, this.i));
    }

    public void b(Activity activity) {
        com.amazon.a.a.o.a.a.a((Object) activity, "activity");
        com.amazon.a.a.o.a.a.a();
        this.c.remove(activity);
        if (c.a) {
            c cVar = a;
            cVar.a("Activity->onDestroy.  Activity: " + activity + ", Total Activities: " + this.c.size());
        }
        a(com.amazon.a.a.a.a.b.DESTROY, activity);
        if (h(activity)) {
            this.m = false;
            a(com.amazon.a.a.a.a.d.DESTROY);
        }
    }

    private boolean h(Activity activity) {
        if (c.a) {
            a.a("Checking if application is destroyed");
        }
        if (!this.c.isEmpty()) {
            return false;
        }
        c cVar = a;
        cVar.a("App is destroyed: " + activity.isTaskRoot() + ", " + activity.isFinishing());
        if (!activity.isTaskRoot() || !activity.isFinishing()) {
            return false;
        }
        return true;
    }

    public void e(Activity activity) {
        com.amazon.a.a.o.a.a.a((Object) activity, "activity");
        com.amazon.a.a.o.a.a.a();
        c cVar = a;
        cVar.a("Activity started: " + activity);
        this.e.a(activity);
        a(com.amazon.a.a.a.a.b.START, activity);
        if (this.e.b() == 1) {
            a(com.amazon.a.a.a.a.d.START);
        }
    }

    public void f(Activity activity) {
        com.amazon.a.a.o.a.a.a((Object) activity, "activity");
        com.amazon.a.a.o.a.a.a();
        c cVar = a;
        cVar.a("Activity stopped: " + activity);
        this.e.b(activity);
        a(com.amazon.a.a.a.a.b.STOP, activity);
        if (this.e.a()) {
            a(com.amazon.a.a.a.a.d.STOP);
        }
    }

    public void d(Activity activity) {
        com.amazon.a.a.o.a.a.a();
        if (c.a) {
            c cVar = a;
            cVar.a("Activity paused: " + activity + ", visible activity: " + b());
        }
        if (b() == activity) {
            if (c.a) {
                a.a("Setting visible activity to null");
            }
            this.b.set((Object) null);
            a(com.amazon.a.a.a.a.b.PAUSE, activity);
        }
    }

    public void c(Activity activity) {
        com.amazon.a.a.o.a.a.a();
        c cVar = a;
        cVar.a("Activity resumed: " + activity + ", is child: " + activity.isChild());
        Activity i2 = i(activity);
        StringBuilder sb = new StringBuilder("Setting visible to: ");
        sb.append(i2);
        cVar.a(sb.toString());
        this.b.set(i2);
        if (c.a) {
            cVar.a("Activity now visible: " + activity + ", publishing resume event");
        }
        a(com.amazon.a.a.a.a.b.RESUME, activity);
    }

    private Activity i(Activity activity) {
        while (activity.isChild()) {
            activity = activity.getParent();
        }
        return activity;
    }

    public void a(Service service) {
        com.amazon.a.a.o.a.a.a();
        if (c.a) {
            c cVar = a;
            cVar.a("Service->onCreate: " + service);
        }
        this.d.a(service);
    }

    public void b(Service service) {
        com.amazon.a.a.o.a.a.a();
        this.d.b(service);
    }

    public boolean d() {
        return this.g.get() || this.f.get();
    }

    public Activity b() {
        com.amazon.a.a.o.a.a.a();
        return this.b.get();
    }

    public boolean c() {
        return this.b.get() != null;
    }

    public void f() {
        if (this.f.compareAndSet(false, true)) {
            if (c.a) {
                c cVar = a;
                cVar.a("---------- SCHEDULING FINISH ACTIVITIES -----------");
                cVar.a(this.i.getPackageName());
                cVar.a(Thread.currentThread().toString());
                cVar.a("---------------------------------------------------");
            }
            this.j.a(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() {
                public String toString() {
                    return "ContextManager: init app shutdown on main thread";
                }

                public void a() {
                    b.this.j();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        if (c.a) {
            c cVar = a;
            cVar.a("----------- EXECUTING FINISH ACTIVITIES -----------");
            cVar.a(this.i.getPackageName());
            cVar.a("---------------------------------------------------");
        }
        k();
        l();
        m();
    }

    private void k() {
        Activity a2 = a();
        for (Activity next : this.c) {
            if (!next.equals(a2)) {
                j(next);
            }
        }
    }

    private void j(Activity activity) {
        if (activity != null) {
            if (activity.isChild()) {
                c cVar = a;
                cVar.a("Not finishing activity: " + activity + ", it is a child of: " + activity.getParent());
                return;
            }
            c cVar2 = a;
            cVar2.a("Finishing Activity: " + activity);
            activity.finish();
        }
    }

    private void l() {
        Activity a2 = a();
        if (a2 == null) {
            a.a("Shutdown found no root, no activities to pop off stack!");
            return;
        }
        c cVar = a;
        cVar.a("Moving task to background");
        a2.moveTaskToBack(true);
        cVar.a("Popping activity stack, root: " + a2);
        Intent intent = new Intent(a2, a2.getClass());
        intent.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        intent.addFlags(536870912);
        a2.startActivity(intent);
    }

    private void m() {
        this.j.a(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() {
            public String toString() {
                return "ContextManager: kill root task";
            }

            public void a() {
                Activity a2 = b.this.a();
                c cVar = b.a;
                cVar.a("Finishing Root Task: " + a2);
                if (a2 != null) {
                    b.a.a("Finishing Root");
                    a2.finish();
                }
            }
        });
    }

    public void g() {
        if (!this.g.compareAndSet(false, true) && c.a) {
            a.a("Ignoring duplicate stopServices request");
        }
        if (c.a) {
            c cVar = a;
            cVar.a("------------- STOPPING SERVICES -------------------");
            cVar.a(this.i.getPackageName());
            cVar.a("---------------------------------------------------");
        }
        Intent intent = new Intent(this.l);
        intent.setPackage(this.i.getPackageName());
        if (c.a) {
            c cVar2 = a;
            cVar2.a("Sending Broadcast!!!!: " + intent + ", Thread: " + Thread.currentThread());
        }
        this.i.sendBroadcast(intent);
    }

    public void e() {
        String packageName = this.i.getPackageName();
        this.l = "com.amazon." + packageName + ".shutdown";
        this.i.registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                b.this.a(intent);
            }
        }, new IntentFilter(this.l));
    }

    public boolean h() {
        com.amazon.a.a.o.a.a.a("Method isContextAware() is not used for Kiwi's ContextManagerImplV2");
        return false;
    }

    /* access modifiers changed from: private */
    public void a(Intent intent) {
        if (c.a) {
            c cVar = a;
            cVar.a("Received broadcast intent: " + intent);
        }
        if (!intent.getAction().equals(this.l)) {
            if (c.b) {
                c cVar2 = a;
                cVar2.b("Received broadcast for unrequested action: " + intent.getAction());
            }
        } else if (!this.g.get()) {
            if (c.b) {
                c cVar3 = a;
                cVar3.b("Received intent to shutdown app when we are not in shutdown state: " + intent);
            }
        } else if (this.h.compareAndSet(false, true)) {
            if (c.a) {
                c cVar4 = a;
                cVar4.a("Stopping services in response to broadcast");
                cVar4.a("Service to stop: " + this.d.b());
            }
            Iterator<Service> it = this.d.iterator();
            while (it.hasNext()) {
                c(it.next());
            }
        } else if (c.a) {
            a.a("shutdown broadcast already received, ignoring");
        }
    }

    private void c(Service service) {
        if (service != null) {
            if (c.a) {
                c cVar = a;
                cVar.a("Stopping service: " + service);
            }
            service.stopSelf();
        }
    }
}
