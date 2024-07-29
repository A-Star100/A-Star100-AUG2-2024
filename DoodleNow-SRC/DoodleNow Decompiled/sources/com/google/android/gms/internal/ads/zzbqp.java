package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbqp extends zzazo implements zzbqr {
    zzbqp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public final void zzA(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbqu zzbqu) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzd(zza, zzl);
        zza.writeString(str);
        zzazq.zzf(zza, zzbqu);
        zzdc(28, zza);
    }

    public final void zzB(zzl zzl, String str, String str2) throws RemoteException {
        throw null;
    }

    public final void zzC(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbqu zzbqu) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzd(zza, zzl);
        zza.writeString(str);
        zzazq.zzf(zza, zzbqu);
        zzdc(32, zza);
    }

    public final void zzD(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(21, zza);
    }

    public final void zzE() throws RemoteException {
        zzdc(8, zza());
    }

    public final void zzF() throws RemoteException {
        zzdc(9, zza());
    }

    public final void zzG(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzazq.zza;
        zza.writeInt(z ? 1 : 0);
        zzdc(25, zza);
    }

    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(39, zza);
    }

    public final void zzI() throws RemoteException {
        zzdc(4, zza());
    }

    public final void zzJ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(37, zza);
    }

    public final void zzK(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(30, zza);
    }

    public final void zzL() throws RemoteException {
        zzdc(12, zza());
    }

    public final boolean zzM() throws RemoteException {
        Parcel zzdb = zzdb(22, zza());
        boolean zzg = zzazq.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzN() throws RemoteException {
        Parcel zzdb = zzdb(13, zza());
        boolean zzg = zzazq.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbqz zzO() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 15
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbqz
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbqz r1 = (com.google.android.gms.internal.ads.zzbqz) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbqz r2 = new com.google.android.gms.internal.ads.zzbqz
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqp.zzO():com.google.android.gms.internal.ads.zzbqz");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbra zzP() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 16
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbra
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbra r1 = (com.google.android.gms.internal.ads.zzbra) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbra r2 = new com.google.android.gms.internal.ads.zzbra
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqp.zzP():com.google.android.gms.internal.ads.zzbra");
    }

    public final Bundle zze() throws RemoteException {
        throw null;
    }

    public final Bundle zzf() throws RemoteException {
        throw null;
    }

    public final Bundle zzg() throws RemoteException {
        throw null;
    }

    public final zzdq zzh() throws RemoteException {
        Parcel zzdb = zzdb(26, zza());
        zzdq zzb = zzdp.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    public final zzbhy zzi() throws RemoteException {
        throw null;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbqx zzj() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 36
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbqx
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbqx r1 = (com.google.android.gms.internal.ads.zzbqx) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbqv r2 = new com.google.android.gms.internal.ads.zzbqv
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqp.zzj():com.google.android.gms.internal.ads.zzbqx");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbrd zzk() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 27
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbrd
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbrd r1 = (com.google.android.gms.internal.ads.zzbrd) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbrb r2 = new com.google.android.gms.internal.ads.zzbrb
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqp.zzk():com.google.android.gms.internal.ads.zzbrd");
    }

    public final zzbtc zzl() throws RemoteException {
        Parcel zzdb = zzdb(33, zza());
        zzbtc zzbtc = (zzbtc) zzazq.zza(zzdb, zzbtc.CREATOR);
        zzdb.recycle();
        return zzbtc;
    }

    public final zzbtc zzm() throws RemoteException {
        Parcel zzdb = zzdb(34, zza());
        zzbtc zzbtc = (zzbtc) zzazq.zza(zzdb, zzbtc.CREATOR);
        zzdb.recycle();
        return zzbtc;
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzdb.readStrongBinder());
        zzdb.recycle();
        return asInterface;
    }

    public final void zzo() throws RemoteException {
        zzdc(5, zza());
    }

    public final void zzp(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbyb zzbyb, String str2) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzd(zza, zzl);
        zza.writeString((String) null);
        zzazq.zzf(zza, zzbyb);
        zza.writeString(str2);
        zzdc(10, zza);
    }

    public final void zzq(IObjectWrapper iObjectWrapper, zzbna zzbna, List list) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, zzbna);
        zza.writeTypedList(list);
        zzdc(31, zza);
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzbyb zzbyb, List list) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, zzbyb);
        zza.writeStringList(list);
        zzdc(23, zza);
    }

    public final void zzs(zzl zzl, String str) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzl);
        zza.writeString(str);
        zzdc(11, zza);
    }

    public final void zzt(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbqu zzbqu) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzd(zza, zzl);
        zza.writeString(str);
        zzazq.zzf(zza, zzbqu);
        zzdc(38, zza);
    }

    public final void zzu(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl, String str, zzbqu zzbqu) throws RemoteException {
        throw null;
    }

    public final void zzv(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl, String str, String str2, zzbqu zzbqu) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzd(zza, zzq);
        zzazq.zzd(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzazq.zzf(zza, zzbqu);
        zzdc(6, zza);
    }

    public final void zzw(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl, String str, String str2, zzbqu zzbqu) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzd(zza, zzq);
        zzazq.zzd(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzazq.zzf(zza, zzbqu);
        zzdc(35, zza);
    }

    public final void zzx(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbqu zzbqu) throws RemoteException {
        throw null;
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzl zzl, String str, String str2, zzbqu zzbqu) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzd(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzazq.zzf(zza, zzbqu);
        zzdc(7, zza);
    }

    public final void zzz(IObjectWrapper iObjectWrapper, zzl zzl, String str, String str2, zzbqu zzbqu, zzbgt zzbgt, List list) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzd(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzazq.zzf(zza, zzbqu);
        zzazq.zzd(zza, zzbgt);
        zza.writeStringList(list);
        zzdc(14, zza);
    }
}
