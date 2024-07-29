package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* compiled from: DecisionExpirationContext */
public interface e extends IInterface {
    String a() throws RemoteException;

    Map b() throws RemoteException;

    /* compiled from: DecisionExpirationContext */
    public static abstract class a extends Binder implements e {
        private static final String a = "com.amazon.venezia.command.DecisionExpirationContext";
        static final int c = 1;
        static final int d = 2;

        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, a);
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof e)) {
                return new C0005a(iBinder);
            }
            return (e) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(a);
                String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(a);
                Map b = b();
                parcel2.writeNoException();
                parcel2.writeMap(b);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(a);
                return true;
            }
        }

        /* renamed from: com.amazon.d.a.e$a$a  reason: collision with other inner class name */
        /* compiled from: DecisionExpirationContext */
        private static class C0005a implements e {
            private IBinder a;

            public IBinder asBinder() {
                return this.a;
            }

            public String c() {
                return a.a;
            }

            C0005a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a() throws RemoteException {
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

            public Map b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.a);
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
