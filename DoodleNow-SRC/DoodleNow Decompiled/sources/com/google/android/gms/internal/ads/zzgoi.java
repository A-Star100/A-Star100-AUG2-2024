package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgoi {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;

    private zzgoi() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzgoi zza(zzgog zzgog) throws GeneralSecurityException {
        if (zzgog != null) {
            zzgok zzgok = new zzgok(zzgog.zzc(), zzgog.zzd(), (zzgoj) null);
            if (this.zza.containsKey(zzgok)) {
                zzgog zzgog2 = (zzgog) this.zza.get(zzgok);
                if (!zzgog2.equals(zzgog) || !zzgog.equals(zzgog2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzgok.toString()));
                }
            } else {
                this.zza.put(zzgok, zzgog);
            }
            return this;
        }
        throw new NullPointerException("primitive constructor must be non-null");
    }

    public final zzgoi zzb(zzggj zzggj) throws GeneralSecurityException {
        Map map = this.zzb;
        Class zzb2 = zzggj.zzb();
        if (map.containsKey(zzb2)) {
            zzggj zzggj2 = (zzggj) this.zzb.get(zzb2);
            if (!zzggj2.equals(zzggj) || !zzggj.equals(zzggj2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(zzb2.toString()));
            }
        } else {
            this.zzb.put(zzb2, zzggj);
        }
        return this;
    }

    /* synthetic */ zzgoi(zzgoh zzgoh) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    /* synthetic */ zzgoi(zzgom zzgom, zzgoh zzgoh) {
        this.zza = new HashMap(zzgom.zza);
        this.zzb = new HashMap(zzgom.zzb);
    }
}
