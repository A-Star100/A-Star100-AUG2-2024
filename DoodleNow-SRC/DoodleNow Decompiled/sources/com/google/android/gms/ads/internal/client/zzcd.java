package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzazp;
import com.google.android.gms.internal.ads.zzazq;
import com.google.android.gms.internal.ads.zzbhi;
import com.google.android.gms.internal.ads.zzbho;
import com.google.android.gms.internal.ads.zzblw;
import com.google.android.gms.internal.ads.zzblx;
import com.google.android.gms.internal.ads.zzbma;
import com.google.android.gms.internal.ads.zzbqn;
import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbui;
import com.google.android.gms.internal.ads.zzbup;
import com.google.android.gms.internal.ads.zzbxt;
import com.google.android.gms.internal.ads.zzbyj;
import com.google.android.gms.internal.ads.zzcap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzcd extends zzazp implements zzce {
    public zzcd() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String readString = parcel.readString();
                zzbqo zzf = zzbqn.zzf(parcel.readStrongBinder());
                int readInt = parcel.readInt();
                zzazq.zzc(parcel);
                zzbu zzd = zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzq) zzazq.zza(parcel, zzq.CREATOR), readString, zzf, readInt);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zzd);
                return true;
            case 2:
                String readString2 = parcel.readString();
                zzbqo zzf2 = zzbqn.zzf(parcel.readStrongBinder());
                int readInt2 = parcel.readInt();
                zzazq.zzc(parcel);
                zzbu zze = zze(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzq) zzazq.zza(parcel, zzq.CREATOR), readString2, zzf2, readInt2);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zze);
                return true;
            case 3:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString3 = parcel.readString();
                zzbqo zzf3 = zzbqn.zzf(parcel.readStrongBinder());
                int readInt3 = parcel.readInt();
                zzazq.zzc(parcel);
                zzbq zzb = zzb(asInterface, readString3, zzf3, readInt3);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zzb);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, (IInterface) null);
                return true;
            case 5:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                zzbhi zzi = zzi(asInterface2, asInterface3);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zzi);
                return true;
            case 6:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbqo zzf4 = zzbqn.zzf(parcel.readStrongBinder());
                int readInt4 = parcel.readInt();
                zzazq.zzc(parcel);
                zzbxt zzn = zzn(asInterface4, zzf4, readInt4);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zzn);
                return true;
            case 7:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, (IInterface) null);
                return true;
            case 8:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                zzbup zzm = zzm(asInterface5);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zzm);
                return true;
            case 9:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int readInt5 = parcel.readInt();
                zzazq.zzc(parcel);
                zzco zzg = zzg(asInterface6, readInt5);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zzg);
                return true;
            case 10:
                String readString4 = parcel.readString();
                int readInt6 = parcel.readInt();
                zzazq.zzc(parcel);
                zzbu zzf5 = zzf(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzq) zzazq.zza(parcel, zzq.CREATOR), readString4, readInt6);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zzf5);
                return true;
            case 11:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                zzbho zzj = zzj(asInterface7, asInterface8, asInterface9);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zzj);
                return true;
            case 12:
                IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString5 = parcel.readString();
                zzbqo zzf6 = zzbqn.zzf(parcel.readStrongBinder());
                int readInt7 = parcel.readInt();
                zzazq.zzc(parcel);
                zzbyj zzo = zzo(asInterface10, readString5, zzf6, readInt7);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zzo);
                return true;
            case 13:
                String readString6 = parcel.readString();
                zzbqo zzf7 = zzbqn.zzf(parcel.readStrongBinder());
                int readInt8 = parcel.readInt();
                zzazq.zzc(parcel);
                zzbu zzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzq) zzazq.zza(parcel, zzq.CREATOR), readString6, zzf7, readInt8);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zzc);
                return true;
            case 14:
                IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbqo zzf8 = zzbqn.zzf(parcel.readStrongBinder());
                int readInt9 = parcel.readInt();
                zzazq.zzc(parcel);
                zzcap zzp = zzp(asInterface11, zzf8, readInt9);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zzp);
                return true;
            case 15:
                IObjectWrapper asInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbqo zzf9 = zzbqn.zzf(parcel.readStrongBinder());
                int readInt10 = parcel.readInt();
                zzazq.zzc(parcel);
                zzbui zzl = zzl(asInterface12, zzf9, readInt10);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zzl);
                return true;
            case 16:
                IObjectWrapper asInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbqo zzf10 = zzbqn.zzf(parcel.readStrongBinder());
                int readInt11 = parcel.readInt();
                zzblx zzc2 = zzblw.zzc(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                zzbma zzk = zzk(asInterface13, zzf10, readInt11, zzc2);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zzk);
                return true;
            case 17:
                IObjectWrapper asInterface14 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbqo zzf11 = zzbqn.zzf(parcel.readStrongBinder());
                int readInt12 = parcel.readInt();
                zzazq.zzc(parcel);
                zzdj zzh = zzh(asInterface14, zzf11, readInt12);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zzh);
                return true;
            default:
                return false;
        }
    }
}
