package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbqk extends zzbqn {
    private static final zzbsr zza = new zzbsr();

    public final zzbqr zzb(String str) throws RemoteException {
        try {
            Class<?> cls = Class.forName(str, false, zzbqk.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                return new zzbrp((MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            if (Adapter.class.isAssignableFrom(cls)) {
                return new zzbrp((Adapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            zzm.zzj("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
            throw new RemoteException();
        } catch (Throwable th) {
            zzm.zzk("Could not instantiate mediation adapter: " + str + ". ", th);
        }
        throw new RemoteException();
    }

    public final zzbsn zzc(String str) throws RemoteException {
        try {
            return new zzbta((RtbAdapter) Class.forName(str, false, zzbsr.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Throwable unused) {
            throw new RemoteException();
        }
    }

    public final boolean zzd(String str) throws RemoteException {
        try {
            return Adapter.class.isAssignableFrom(Class.forName(str, false, zzbqk.class.getClassLoader()));
        } catch (Throwable unused) {
            zzm.zzj("Could not load custom event implementation class as Adapter: " + str + ", assuming old custom event implementation.");
            return false;
        }
    }

    public final boolean zze(String str) throws RemoteException {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzbqk.class.getClassLoader()));
        } catch (Throwable unused) {
            zzm.zzj("Could not load custom event implementation class: " + str + ", trying Adapter implementation class.");
            return false;
        }
    }
}
