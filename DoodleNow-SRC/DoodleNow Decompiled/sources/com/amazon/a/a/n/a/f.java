package com.amazon.a.a.n.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import com.amazon.a.a.i.d;
import com.amazon.a.a.n.a.a.e;
import com.amazon.a.a.o.c;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: DecisionPrompt */
public class f extends com.amazon.a.a.i.b {
    /* access modifiers changed from: private */
    public static final c b = new c("DecisionDialog");
    private final Thread c = Thread.currentThread();
    private final b d;
    /* access modifiers changed from: private */
    public final BlockingQueue<a> e = new LinkedBlockingQueue();

    /* compiled from: DecisionPrompt */
    private static class b {
        private final String a;
        private final String b;
        private final long c;
        private final a d;
        private final a e;
        private final a f;

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public long c() {
            return this.c;
        }

        public a d() {
            return this.f;
        }

        public a e() {
            return this.e;
        }

        public a f() {
            return this.d;
        }

        public b(com.amazon.d.a.f fVar) throws RemoteException {
            this.a = fVar.b();
            this.b = fVar.c();
            this.c = fVar.d();
            this.d = a(fVar.e());
            this.e = a(fVar.f());
            this.f = a(fVar.g());
        }

        private a a(com.amazon.d.a.a aVar) throws RemoteException {
            if (aVar == null) {
                return null;
            }
            return new a(aVar);
        }
    }

    /* compiled from: DecisionPrompt */
    private static class a {
        private final com.amazon.d.a.a a;
        private final String b;
        private final Intent c;

        public com.amazon.d.a.a a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public Intent c() {
            return this.c;
        }

        public a(com.amazon.d.a.a aVar) throws RemoteException {
            this.a = aVar;
            this.b = aVar.a();
            this.c = aVar.b();
        }
    }

    public f(com.amazon.d.a.f fVar) throws RemoteException {
        this.d = new b(fVar);
    }

    public com.amazon.d.a.a i() throws e {
        if (c.a) {
            c cVar = b;
            cVar.a("GetCustomerDecision: " + this.c);
        }
        return n();
    }

    private com.amazon.d.a.a n() throws e {
        try {
            if (c.a) {
                c cVar = b;
                cVar.a("Blocking while awaiting customer decision: " + Thread.currentThread());
            }
            return this.e.take().a();
        } catch (InterruptedException unused) {
            if (c.a) {
                b.a("Interrupted while awaiting decision, throwing decision expired!");
            }
            throw new e(o());
        }
    }

    private e o() {
        if (l() == d.NOT_COMPATIBLE) {
            return e.APP_NOT_COMPATIBLE;
        }
        return e.EXPIRATION_DURATION_ELAPSED;
    }

    public Dialog d(Activity activity) {
        return f(activity);
    }

    public boolean b(Activity activity) {
        if (!p()) {
            return true;
        }
        ActivityInfo e2 = e(activity);
        if (e2 == null) {
            return false;
        }
        boolean z = e2.launchMode == 3;
        c cVar = b;
        cVar.a("Single instance: " + z);
        boolean z2 = (e2.flags & 2) != 0;
        cVar.a("Finish on task launch:" + z2);
        boolean z3 = (e2.flags & 128) != 0;
        cVar.a("No History: " + z3);
        if (z || z2 || z3) {
            return false;
        }
        return true;
    }

    private boolean p() {
        return a(this.d.f()) || a(this.d.e()) || a(this.d.d());
    }

    private boolean a(a aVar) {
        return (aVar == null || aVar.c() == null) ? false : true;
    }

    private ActivityInfo e(Activity activity) {
        try {
            return activity.getPackageManager().getActivityInfo(activity.getComponentName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            if (!c.b) {
                return null;
            }
            c cVar = b;
            cVar.b("Unable to get info for activity: " + activity);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public long h() {
        return this.d.c();
    }

    /* access modifiers changed from: protected */
    public void a(d dVar) {
        if (c.a) {
            c cVar = b;
            cVar.a("Expiring Decision Dialog: Thread: " + Thread.currentThread());
        }
        this.c.interrupt();
    }

    private Dialog f(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(this.d.a()).setMessage(this.d.b()).setCancelable(false);
        AlertDialog create = builder.create();
        a(activity, create, this.d.f(), -1);
        a(activity, create, this.d.e(), -3);
        a(activity, create, this.d.d(), -2);
        return create;
    }

    private void a(Activity activity, AlertDialog alertDialog, final a aVar, int i) {
        if (aVar != null) {
            alertDialog.setButton(i, aVar.b(), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (c.a) {
                        f.b.a("Choice selected!");
                    }
                    if (f.this.k()) {
                        f.this.e.add(aVar);
                    }
                }
            });
        }
    }

    public String toString() {
        return "DecisionDialog: " + this.d.a();
    }
}
