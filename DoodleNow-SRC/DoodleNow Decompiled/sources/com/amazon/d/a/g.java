package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* compiled from: ExceptionResult */
public interface g extends IInterface {
    String a() throws RemoteException;

    Map b() throws RemoteException;

    /* compiled from: ExceptionResult */
    public static abstract class a extends Binder implements g {
        static final int a = 1;
        static final int b = 2;
        private static final String c = "com.amazon.venezia.command.ExceptionResult";

        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, c);
        }

        public static g a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(c);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof g)) {
                return new C0007a(iBinder);
            }
            return (g) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(c);
                String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(c);
                Map b2 = b();
                parcel2.writeNoException();
                parcel2.writeMap(b2);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(c);
                return true;
            }
        }

        /* renamed from: com.amazon.d.a.g$a$a  reason: collision with other inner class name */
        /* compiled from: ExceptionResult */
        private static class C0007a implements g {
            private IBinder a;

            public IBinder asBinder() {
                return this.a;
            }

            public String c() {
                return a.c;
            }

            C0007a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.c);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Map b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.c);
                    this.a.transact(2, obtain, obtain2, 0);
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
