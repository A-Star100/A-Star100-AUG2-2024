package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.amazon.d.a.f;
import com.amazon.d.a.g;
import com.amazon.d.a.h;
import com.amazon.d.a.j;

/* compiled from: ResultCallback */
public interface i extends IInterface {
    void a(f fVar) throws RemoteException;

    void a(g gVar) throws RemoteException;

    void a(h hVar) throws RemoteException;

    void a(j jVar) throws RemoteException;

    /* compiled from: ResultCallback */
    public static abstract class a extends Binder implements i {
        private static final String a = "com.amazon.venezia.command.ResultCallback";
        static final int b = 1;
        static final int c = 2;
        static final int d = 3;
        static final int e = 4;

        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, a);
        }

        public static i a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof i)) {
                return new C0009a(iBinder);
            }
            return (i) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(a);
                a(j.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(a);
                a(h.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(a);
                a(f.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i == 4) {
                parcel.enforceInterface(a);
                a(g.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(a);
                return true;
            }
        }

        /* renamed from: com.amazon.d.a.i$a$a  reason: collision with other inner class name */
        /* compiled from: ResultCallback */
        private static class C0009a implements i {
            private IBinder a;

            public String a() {
                return a.a;
            }

            public IBinder asBinder() {
                return this.a;
            }

            C0009a(IBinder iBinder) {
                this.a = iBinder;
            }

            public void a(j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.a);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(h hVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.a);
                    obtain.writeStrongBinder(hVar != null ? hVar.asBinder() : null);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(f fVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.a);
                    obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(g gVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.a);
                    obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
