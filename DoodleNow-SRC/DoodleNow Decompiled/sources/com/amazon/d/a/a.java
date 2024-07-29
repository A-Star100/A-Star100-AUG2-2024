package com.amazon.d.a;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.amazon.d.a.b;
import java.util.Map;

/* compiled from: Choice */
public interface a extends IInterface {
    String a() throws RemoteException;

    void a(b bVar) throws RemoteException;

    Intent b() throws RemoteException;

    Map c() throws RemoteException;

    /* renamed from: com.amazon.d.a.a$a  reason: collision with other inner class name */
    /* compiled from: Choice */
    public static abstract class C0000a extends Binder implements a {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 4;
        private static final String e = "com.amazon.venezia.command.Choice";

        public IBinder asBinder() {
            return this;
        }

        public C0000a() {
            attachInterface(this, e);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(e);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0001a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(e);
                String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(e);
                Intent b2 = b();
                parcel2.writeNoException();
                if (b2 != null) {
                    parcel2.writeInt(1);
                    b2.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(e);
                a(b.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i == 4) {
                parcel.enforceInterface(e);
                Map c2 = c();
                parcel2.writeNoException();
                parcel2.writeMap(c2);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(e);
                return true;
            }
        }

        /* renamed from: com.amazon.d.a.a$a$a  reason: collision with other inner class name */
        /* compiled from: Choice */
        private static class C0001a implements a {
            private IBinder a;

            public IBinder asBinder() {
                return this.a;
            }

            public String d() {
                return C0000a.e;
            }

            C0001a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(C0000a.e);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(C0000a.e);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(C0000a.e);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Map c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(C0000a.e);
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
