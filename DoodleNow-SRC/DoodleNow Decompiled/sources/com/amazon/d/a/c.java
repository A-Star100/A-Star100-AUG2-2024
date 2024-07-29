package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* compiled from: Command */
public interface c extends IInterface {
    String a() throws RemoteException;

    String b() throws RemoteException;

    Map c() throws RemoteException;

    String d() throws RemoteException;

    /* compiled from: Command */
    public static abstract class a extends Binder implements c {
        private static final String a = "com.amazon.venezia.command.Command";
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

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                return new C0003a(iBinder);
            }
            return (c) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(a);
                String b2 = b();
                parcel2.writeNoException();
                parcel2.writeString(b2);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(a);
                String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(a);
                String d2 = d();
                parcel2.writeNoException();
                parcel2.writeString(d2);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface(a);
                Map c2 = c();
                parcel2.writeNoException();
                parcel2.writeMap(c2);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(a);
                return true;
            }
        }

        /* renamed from: com.amazon.d.a.c$a$a  reason: collision with other inner class name */
        /* compiled from: Command */
        private static class C0003a implements c {
            private IBinder a;

            public IBinder asBinder() {
                return this.a;
            }

            public String e() {
                return a.a;
            }

            C0003a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.a);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.a);
                    this.a.transact(2, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken(a.a);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Map c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.a);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
