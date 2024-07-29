package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfrv {
    final zzfry zza;
    final boolean zzb;

    private zzfrv(zzfry zzfry) {
        this.zza = zzfry;
        this.zzb = zzfry != null;
    }

    public static zzfrv zzb(Context context, String str, String str2) {
        zzfry zzfry;
        try {
            IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
            if (instantiate == null) {
                zzfry = null;
            } else {
                IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                zzfry = queryLocalInterface instanceof zzfry ? (zzfry) queryLocalInterface : new zzfrw(instantiate);
            }
            try {
                zzfry.zze(ObjectWrapper.wrap(context), str, (String) null);
                Log.i("GASS", "GassClearcutLogger Initialized.");
                return new zzfrv(zzfry);
            } catch (RemoteException | zzfqx | NullPointerException | SecurityException unused) {
                Log.d("GASS", "Cannot dynamite load clearcut");
                return new zzfrv(new zzfrz());
            }
        } catch (Exception e) {
            throw new zzfqx(e);
        } catch (Exception e2) {
            throw new zzfqx(e2);
        }
    }

    public static zzfrv zzc() {
        zzfrz zzfrz = new zzfrz();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzfrv(zzfrz);
    }

    public final zzfru zza(byte[] bArr) {
        return new zzfru(this, bArr, (zzfrt) null);
    }
}
