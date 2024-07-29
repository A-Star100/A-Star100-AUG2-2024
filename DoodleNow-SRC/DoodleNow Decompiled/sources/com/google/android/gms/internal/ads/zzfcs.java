package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfcs {
    public static void zza(AtomicReference atomicReference, zzfcr zzfcr) {
        Object obj = atomicReference.get();
        if (obj != null) {
            try {
                zzfcr.zza(obj);
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            } catch (NullPointerException e2) {
                zzm.zzk("NullPointerException occurs when invoking a method from a delegating listener.", e2);
            }
        }
    }
}
