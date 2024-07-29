package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* compiled from: ChoiceContext */
public interface b extends IInterface {
    Map a() throws RemoteException;

    /* compiled from: ChoiceContext */
    public static abstract class a extends Binder implements b {
        static final int a = 1;
        private static final String b = "com.amazon.venezia.command.ChoiceContext";

        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, b);
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(b);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0002a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(b);
                Map a2 = a();
                parcel2.writeNoException();
                parcel2.writeMap(a2);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(b);
                return true;
            }
        }

        /* renamed from: com.amazon.d.a.b$a$a  reason: collision with other inner class name */
        /* compiled from: ChoiceContext */
        private static class C0002a implements b {
            private IBinder a;

            public IBinder asBinder() {
                return this.a;
            }

            public String b() {
                return a.b;
            }

            C0002a(IBinder iBinder) {
                this.a = iBinder;
            }

            public Map a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.b);
                    this.a.transact(1, obtain, obtain2, 0);
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
