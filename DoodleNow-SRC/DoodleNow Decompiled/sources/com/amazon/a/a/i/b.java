package com.amazon.a.a.i;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import com.amazon.a.a.e.c;
import com.amazon.a.a.k.a;
import com.amazon.a.a.n.b.d;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Prompt */
public abstract class b extends c<b> {
    private static final com.amazon.a.a.o.c b = new com.amazon.a.a.o.c("Prompt");
    @a
    private com.amazon.a.a.m.c c;
    private final int d;
    private Activity e;
    private d f;
    private Dialog g;
    private final AtomicBoolean h = new AtomicBoolean(false);

    /* access modifiers changed from: protected */
    public abstract void a(d dVar);

    /* access modifiers changed from: protected */
    public boolean b(Activity activity) {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract Dialog d(Activity activity);

    public int j() {
        return this.d;
    }

    public b() {
        int i = i();
        this.d = i;
        if (com.amazon.a.a.o.c.a) {
            com.amazon.a.a.o.c cVar = b;
            cVar.a("Creating Prompt: " + i);
        }
    }

    private int i() {
        int nextInt = new Random().nextInt(2146249079) + 1234567;
        if (nextInt <= 1234567) {
            return 1234567;
        }
        return nextInt;
    }

    public final void a(Activity activity) {
        com.amazon.a.a.o.a.a.a((Object) activity, "activity");
        com.amazon.a.a.o.a.a.a();
        if (e(activity)) {
            f(activity);
        } else {
            b(d.NOT_COMPATIBLE);
        }
    }

    private boolean e(Activity activity) {
        if (this.c.b(com.amazon.a.a.m.c.e)) {
            return false;
        }
        return b(activity);
    }

    private void f(Activity activity) {
        if (com.amazon.a.a.o.c.a) {
            com.amazon.a.a.o.c cVar = b;
            cVar.a("Showing prompt, id: " + j() + ", prompt: " + this + ", activity: " + activity);
        }
        if (this.e != null) {
            m();
        }
        activity.showDialog(j());
    }

    private void b(d dVar) {
        if (com.amazon.a.a.o.c.a) {
            com.amazon.a.a.o.c cVar = b;
            cVar.a("Expiring prompt pre-maturely: id: " + j() + ", prompt: " + this + ",, reason: " + dVar);
        }
        this.f = dVar;
        c();
    }

    /* access modifiers changed from: protected */
    public final boolean k() {
        com.amazon.a.a.o.a.a.a();
        if (com.amazon.a.a.o.c.a) {
            com.amazon.a.a.o.c cVar = b;
            cVar.a("Dismissing Prompt: " + this.d);
        }
        if (!this.h.compareAndSet(false, true)) {
            if (com.amazon.a.a.o.c.a) {
                b.b("Prompt has already been dismissed");
            }
            return false;
        }
        if (this.e != null) {
            m();
        }
        f();
        return true;
    }

    public final Dialog c(Activity activity) {
        this.e = activity;
        Dialog d2 = d(activity);
        this.g = d2;
        d2.setCancelable(false);
        this.g.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 84;
            }
        });
        return this.g;
    }

    private void m() {
        if (com.amazon.a.a.o.c.a) {
            com.amazon.a.a.o.c cVar = b;
            cVar.b("Dismissing dialog: " + this.d);
        }
        try {
            this.e.dismissDialog(this.d);
            this.e.removeDialog(this.d);
        } catch (Exception unused) {
            if (com.amazon.a.a.o.c.a) {
                com.amazon.a.a.o.c cVar2 = b;
                cVar2.b("Unable to remove dialog: " + this.d);
            }
        }
        this.e = null;
        this.g = null;
    }

    /* access modifiers changed from: protected */
    public final void d() {
        if (com.amazon.a.a.o.c.a) {
            com.amazon.a.a.o.c cVar = b;
            cVar.a("Expiring prompt: " + this);
        }
        this.a.a(d.FOREGROUND, new com.amazon.a.a.n.a() {
            public void a() {
                b.this.k();
            }

            public String toString() {
                return "DismissPromptTask: " + b.this.toString();
            }
        });
        a(l());
    }

    /* access modifiers changed from: protected */
    public d l() {
        if (!g()) {
            return null;
        }
        d dVar = this.f;
        return dVar == null ? d.EXPIRATION_DURATION_ELAPSED : dVar;
    }

    public void a(Activity activity, boolean z) {
        if (activity != this.e) {
            if (com.amazon.a.a.o.c.a) {
                b.a("Unrecognized context");
            }
        } else if (z && !this.g.isShowing()) {
            if (com.amazon.a.a.o.c.a) {
                b.a("showing dialog because it was not showing");
            }
            this.g.show();
        }
    }
}
