package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgoz {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;
    /* access modifiers changed from: private */
    public final Map zzc;
    /* access modifiers changed from: private */
    public final Map zzd;

    public zzgoz() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzgoz zza(zzgmw zzgmw) throws GeneralSecurityException {
        zzgpb zzgpb = new zzgpb(zzgmw.zzd(), zzgmw.zzc(), (zzgpa) null);
        if (this.zzb.containsKey(zzgpb)) {
            zzgmw zzgmw2 = (zzgmw) this.zzb.get(zzgpb);
            if (!zzgmw2.equals(zzgmw) || !zzgmw.equals(zzgmw2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgpb.toString()));
            }
        } else {
            this.zzb.put(zzgpb, zzgmw);
        }
        return this;
    }

    public final zzgoz zzb(zzgna zzgna) throws GeneralSecurityException {
        zzgpd zzgpd = new zzgpd(zzgna.zzc(), zzgna.zzd(), (zzgpc) null);
        if (this.zza.containsKey(zzgpd)) {
            zzgna zzgna2 = (zzgna) this.zza.get(zzgpd);
            if (!zzgna2.equals(zzgna) || !zzgna.equals(zzgna2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgpd.toString()));
            }
        } else {
            this.zza.put(zzgpd, zzgna);
        }
        return this;
    }

    public final zzgoz zzc(zzgny zzgny) throws GeneralSecurityException {
        zzgpb zzgpb = new zzgpb(zzgny.zzd(), zzgny.zzc(), (zzgpa) null);
        if (this.zzd.containsKey(zzgpb)) {
            zzgny zzgny2 = (zzgny) this.zzd.get(zzgpb);
            if (!zzgny2.equals(zzgny) || !zzgny.equals(zzgny2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgpb.toString()));
            }
        } else {
            this.zzd.put(zzgpb, zzgny);
        }
        return this;
    }

    public final zzgoz zzd(zzgoc zzgoc) throws GeneralSecurityException {
        zzgpd zzgpd = new zzgpd(zzgoc.zzc(), zzgoc.zzd(), (zzgpc) null);
        if (this.zzc.containsKey(zzgpd)) {
            zzgoc zzgoc2 = (zzgoc) this.zzc.get(zzgpd);
            if (!zzgoc2.equals(zzgoc) || !zzgoc.equals(zzgoc2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgpd.toString()));
            }
        } else {
            this.zzc.put(zzgpd, zzgoc);
        }
        return this;
    }

    public zzgoz(zzgpf zzgpf) {
        this.zza = new HashMap(zzgpf.zza);
        this.zzb = new HashMap(zzgpf.zzb);
        this.zzc = new HashMap(zzgpf.zzc);
        this.zzd = new HashMap(zzgpf.zzd);
    }
}
