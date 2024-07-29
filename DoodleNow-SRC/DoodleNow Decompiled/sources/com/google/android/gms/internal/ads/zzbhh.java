package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzbhh extends zzazp implements zzbhi {
    public zzbhh() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public static zzbhi zzdA(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        return queryLocalInterface instanceof zzbhi ? (zzbhi) queryLocalInterface : new zzbhg(iBinder);
    }

    /* JADX WARNING: type inference failed for: r5v4, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            switch(r2) {
                case 1: goto L_0x009f;
                case 2: goto L_0x008d;
                case 3: goto L_0x007b;
                case 4: goto L_0x0074;
                case 5: goto L_0x0063;
                case 6: goto L_0x0051;
                case 7: goto L_0x003f;
                case 8: goto L_0x0018;
                case 9: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r2 = 0
            return r2
        L_0x0005:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            com.google.android.gms.internal.ads.zzazq.zzc(r3)
            r1.zzdy(r2)
            r4.writeNoException()
            goto L_0x00b4
        L_0x0018:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0020
            r2 = 0
            goto L_0x0034
        L_0x0020:
            java.lang.String r5 = "com.google.android.gms.ads.internal.formats.client.IMediaContent"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzbhb
            if (r0 == 0) goto L_0x002e
            r2 = r5
            com.google.android.gms.internal.ads.zzbhb r2 = (com.google.android.gms.internal.ads.zzbhb) r2
            goto L_0x0034
        L_0x002e:
            com.google.android.gms.internal.ads.zzbgz r5 = new com.google.android.gms.internal.ads.zzbgz
            r5.<init>(r2)
            r2 = r5
        L_0x0034:
            com.google.android.gms.internal.ads.zzazq.zzc(r3)
            r1.zzdx(r2)
            r4.writeNoException()
            goto L_0x00b4
        L_0x003f:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            com.google.android.gms.internal.ads.zzazq.zzc(r3)
            r1.zzd(r2)
            r4.writeNoException()
            goto L_0x00b4
        L_0x0051:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            com.google.android.gms.internal.ads.zzazq.zzc(r3)
            r1.zzdw(r2)
            r4.writeNoException()
            goto L_0x00b4
        L_0x0063:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r3.readInt()
            com.google.android.gms.internal.ads.zzazq.zzc(r3)
            r4.writeNoException()
            goto L_0x00b4
        L_0x0074:
            r1.zzc()
            r4.writeNoException()
            goto L_0x00b4
        L_0x007b:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            com.google.android.gms.internal.ads.zzazq.zzc(r3)
            r1.zzdz(r2)
            r4.writeNoException()
            goto L_0x00b4
        L_0x008d:
            java.lang.String r2 = r3.readString()
            com.google.android.gms.internal.ads.zzazq.zzc(r3)
            com.google.android.gms.dynamic.IObjectWrapper r2 = r1.zzb(r2)
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzazq.zzf(r4, r2)
            goto L_0x00b4
        L_0x009f:
            java.lang.String r2 = r3.readString()
            android.os.IBinder r5 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r5)
            com.google.android.gms.internal.ads.zzazq.zzc(r3)
            r1.zzdv(r2, r5)
            r4.writeNoException()
        L_0x00b4:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhh.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
