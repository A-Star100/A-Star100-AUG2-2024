package com.amazon.a.a.n.a;

import android.os.Binder;
import android.os.RemoteException;
import com.amazon.d.a.f;
import com.amazon.d.a.g;
import com.amazon.d.a.h;
import com.amazon.d.a.j;

/* compiled from: CommandResult */
public final class c {
    private String a;
    private RemoteException b;
    private j c;
    private h d;
    private f e;
    private g f;
    private int g = Binder.getCallingUid();

    public j b() {
        return this.c;
    }

    public h c() {
        return this.d;
    }

    public f d() {
        return this.e;
    }

    public g e() {
        return this.f;
    }

    public int f() {
        return this.g;
    }

    public c(j jVar) {
        this.c = jVar;
        try {
            this.a = jVar.a();
        } catch (RemoteException e2) {
            this.b = e2;
        }
    }

    public c(h hVar) {
        this.d = hVar;
        try {
            this.a = hVar.a();
        } catch (RemoteException e2) {
            this.b = e2;
        }
    }

    public c(f fVar) {
        this.e = fVar;
        try {
            this.a = fVar.a();
        } catch (RemoteException e2) {
            this.b = e2;
        }
    }

    public c(g gVar) {
        this.f = gVar;
    }

    public String a() throws RemoteException {
        RemoteException remoteException = this.b;
        if (remoteException == null) {
            return this.a;
        }
        throw remoteException;
    }

    public String toString() {
        return "CommandResult: [CallingUid: " + this.g + ", SuccessResult: " + this.c + ", FailureResult: " + this.d + ", DecisionResult: " + this.e + ", ExceptionResult: " + this.f + "]";
    }
}
