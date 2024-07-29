package com.amazon.d.c.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IApplicationVerificationService */
public interface a extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    void a(String str, boolean z, String str2) throws RemoteException;

    String b() throws RemoteException;

    /* renamed from: com.amazon.d.c.a.a$a  reason: collision with other inner class name */
    /* compiled from: IApplicationVerificationService */
    public static abstract class C0011a extends Binder implements a {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 4;
        private static final String e = "com.amazon.venezia.service.verify.IApplicationVerificationService";

        public IBinder asBinder() {
            return this;
        }

        public C0011a() {
            attachInterface(this, e);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(e);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0012a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(e);
                a(parcel.readString(), parcel.readInt() != 0, parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(e);
                String a2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(e);
                String a3 = a();
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface(e);
                String b2 = b();
                parcel2.writeNoException();
                parcel2.writeString(b2);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(e);
                return true;
            }
        }

        /* renamed from: com.amazon.d.c.a.a$a$a  reason: collision with other inner class name */
        /* compiled from: IApplicationVerificationService */
        private static class C0012a implements a {
            private IBinder a;

            public IBinder asBinder() {
                return this.a;
            }

            public String c() {
                return C0011a.e;
            }

            C0012a(IBinder iBinder) {
                this.a = iBinder;
            }

            public void a(String str, boolean z, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(C0011a.e);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str2);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(C0011a.e);
                    obtain.writeString(str);
                    this.a.transact(2, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken(C0011a.e);
                    this.a.transact(3, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken(C0011a.e);
                    this.a.transact(4, obtain, obtain2, 0);
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
