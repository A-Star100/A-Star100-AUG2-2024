package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzu;
import com.google.android.gms.internal.maps.zzw;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class IndoorBuilding {
    private final zzu zza;
    private final zzh zzb;

    public IndoorBuilding(zzu zzu) {
        zzh zzh = zzh.zza;
        this.zza = (zzu) Preconditions.checkNotNull(zzu, "delegate");
        this.zzb = (zzh) Preconditions.checkNotNull(zzh, "shim");
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.zza.zzh(((IndoorBuilding) obj).zza);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getActiveLevelIndex() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getDefaultLevelIndex() {
        try {
            return this.zza.zze();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<IndoorLevel> getLevels() {
        try {
            List<IBinder> zzg = this.zza.zzg();
            ArrayList arrayList = new ArrayList(zzg.size());
            for (IBinder zzb2 : zzg) {
                arrayList.add(new IndoorLevel(zzw.zzb(zzb2)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUnderground() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
