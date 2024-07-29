package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzcs;
import com.google.android.gms.ads.internal.client.zzcw;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdm;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbiz extends zzazo implements zzbjb {
    zzbiz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    public final void zzA() throws RemoteException {
        zzdc(28, zza());
    }

    public final void zzB(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, bundle);
        zzdc(17, zza);
    }

    public final void zzC() throws RemoteException {
        zzdc(27, zza());
    }

    public final void zzD(zzcs zzcs) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzcs);
        zzdc(26, zza);
    }

    public final void zzE(zzdg zzdg) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzdg);
        zzdc(32, zza);
    }

    public final void zzF(zzbiy zzbiy) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzbiy);
        zzdc(21, zza);
    }

    public final boolean zzG() throws RemoteException {
        Parcel zzdb = zzdb(30, zza());
        boolean zzg = zzazq.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzH() throws RemoteException {
        Parcel zzdb = zzdb(24, zza());
        boolean zzg = zzazq.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzI(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, bundle);
        Parcel zzdb = zzdb(16, zza);
        boolean zzg = zzazq.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final double zze() throws RemoteException {
        Parcel zzdb = zzdb(8, zza());
        double readDouble = zzdb.readDouble();
        zzdb.recycle();
        return readDouble;
    }

    public final Bundle zzf() throws RemoteException {
        Parcel zzdb = zzdb(20, zza());
        Bundle bundle = (Bundle) zzazq.zza(zzdb, Bundle.CREATOR);
        zzdb.recycle();
        return bundle;
    }

    public final zzdn zzg() throws RemoteException {
        Parcel zzdb = zzdb(31, zza());
        zzdn zzb = zzdm.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    public final zzdq zzh() throws RemoteException {
        Parcel zzdb = zzdb(11, zza());
        zzdq zzb = zzdp.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbgx zzi() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 14
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IAttributionInfo"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbgx
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbgx r1 = (com.google.android.gms.internal.ads.zzbgx) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbgv r2 = new com.google.android.gms.internal.ads.zzbgv
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbiz.zzi():com.google.android.gms.internal.ads.zzbgx");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbhb zzj() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 29
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IMediaContent"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbhb
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbhb r1 = (com.google.android.gms.internal.ads.zzbhb) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbgz r2 = new com.google.android.gms.internal.ads.zzbgz
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbiz.zzj():com.google.android.gms.internal.ads.zzbhb");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbhe zzk() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 5
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbhe
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.internal.ads.zzbhe r1 = (com.google.android.gms.internal.ads.zzbhe) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.internal.ads.zzbhc r2 = new com.google.android.gms.internal.ads.zzbhc
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbiz.zzk():com.google.android.gms.internal.ads.zzbhe");
    }

    public final IObjectWrapper zzl() throws RemoteException {
        Parcel zzdb = zzdb(19, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzdb.readStrongBinder());
        zzdb.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzm() throws RemoteException {
        Parcel zzdb = zzdb(18, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzdb.readStrongBinder());
        zzdb.recycle();
        return asInterface;
    }

    public final String zzn() throws RemoteException {
        Parcel zzdb = zzdb(7, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final String zzo() throws RemoteException {
        Parcel zzdb = zzdb(4, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final String zzp() throws RemoteException {
        Parcel zzdb = zzdb(6, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final String zzq() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final String zzr() throws RemoteException {
        throw null;
    }

    public final String zzs() throws RemoteException {
        Parcel zzdb = zzdb(10, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final String zzt() throws RemoteException {
        Parcel zzdb = zzdb(9, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final List zzu() throws RemoteException {
        Parcel zzdb = zzdb(3, zza());
        ArrayList zzb = zzazq.zzb(zzdb);
        zzdb.recycle();
        return zzb;
    }

    public final List zzv() throws RemoteException {
        Parcel zzdb = zzdb(23, zza());
        ArrayList zzb = zzazq.zzb(zzdb);
        zzdb.recycle();
        return zzb;
    }

    public final void zzw() throws RemoteException {
        zzdc(22, zza());
    }

    public final void zzx() throws RemoteException {
        zzdc(13, zza());
    }

    public final void zzy(zzcw zzcw) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzcw);
        zzdc(25, zza);
    }

    public final void zzz(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, bundle);
        zzdc(15, zza);
    }
}
