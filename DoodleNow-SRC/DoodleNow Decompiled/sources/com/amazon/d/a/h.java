package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* compiled from: FailureResult */
public interface h extends IInterface {
    String a() throws RemoteException;

    String b() throws RemoteException;

    String c() throws RemoteException;

    String d() throws RemoteException;

    boolean e() throws RemoteException;

    Map f() throws RemoteException;

    String g() throws RemoteException;

    /* compiled from: FailureResult */
    public static abstract class a extends Binder implements h {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 4;
        static final int e = 5;
        static final int f = 6;
        static final int g = 7;
        private static final String h = "com.amazon.venezia.command.FailureResult";

        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, h);
        }

        public static h a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(h);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof h)) {
                return new C0008a(iBinder);
            }
            return (h) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(h);
                        String a2 = a();
                        parcel2.writeNoException();
                        parcel2.writeString(a2);
                        return true;
                    case 2:
                        parcel.enforceInterface(h);
                        String b2 = b();
                        parcel2.writeNoException();
                        parcel2.writeString(b2);
                        return true;
                    case 3:
                        parcel.enforceInterface(h);
                        String c2 = c();
                        parcel2.writeNoException();
                        parcel2.writeString(c2);
                        return true;
                    case 4:
                        parcel.enforceInterface(h);
                        String d2 = d();
                        parcel2.writeNoException();
                        parcel2.writeString(d2);
                        return true;
                    case 5:
                        parcel.enforceInterface(h);
                        boolean e2 = e();
                        parcel2.writeNoException();
                        parcel2.writeInt(e2 ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface(h);
                        Map f2 = f();
                        parcel2.writeNoException();
                        parcel2.writeMap(f2);
                        return true;
                    case 7:
                        parcel.enforceInterface(h);
                        String g2 = g();
                        parcel2.writeNoException();
                        parcel2.writeString(g2);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(h);
                return true;
            }
        }

        /* renamed from: com.amazon.d.a.h$a$a  reason: collision with other inner class name */
        /* compiled from: FailureResult */
        private static class C0008a implements h {
            private IBinder a;

            public IBinder asBinder() {
                return this.a;
            }

            public String h() {
                return a.h;
            }

            C0008a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.h);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.h);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.h);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.h);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.h);
                    boolean z = false;
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Map f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.h);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.h);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
