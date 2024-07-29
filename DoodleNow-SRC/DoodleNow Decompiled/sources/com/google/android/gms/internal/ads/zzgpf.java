package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgpf {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;
    /* access modifiers changed from: private */
    public final Map zzc;
    /* access modifiers changed from: private */
    public final Map zzd;

    /* synthetic */ zzgpf(zzgoz zzgoz, zzgpe zzgpe) {
        this.zza = new HashMap(zzgoz.zza);
        this.zzb = new HashMap(zzgoz.zzb);
        this.zzc = new HashMap(zzgoz.zzc);
        this.zzd = new HashMap(zzgoz.zzd);
    }

    public final zzgft zza(zzgoy zzgoy, @Nullable zzggn zzggn) throws GeneralSecurityException {
        zzgpb zzgpb = new zzgpb(zzgoy.getClass(), zzgoy.zzd(), (zzgpa) null);
        if (this.zzb.containsKey(zzgpb)) {
            return ((zzgmw) this.zzb.get(zzgpb)).zza(zzgoy, zzggn);
        }
        String obj = zzgpb.toString();
        throw new GeneralSecurityException("No Key Parser for requested key type " + obj + " available");
    }

    public final zzggi zzb(zzgoy zzgoy) throws GeneralSecurityException {
        zzgpb zzgpb = new zzgpb(zzgoy.getClass(), zzgoy.zzd(), (zzgpa) null);
        if (this.zzd.containsKey(zzgpb)) {
            return ((zzgny) this.zzd.get(zzgpb)).zza(zzgoy);
        }
        String obj = zzgpb.toString();
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + obj + " available");
    }

    public final zzgoy zzc(zzgft zzgft, Class cls, @Nullable zzggn zzggn) throws GeneralSecurityException {
        zzgpd zzgpd = new zzgpd(zzgft.getClass(), cls, (zzgpc) null);
        if (this.zza.containsKey(zzgpd)) {
            return ((zzgna) this.zza.get(zzgpd)).zza(zzgft, zzggn);
        }
        String obj = zzgpd.toString();
        throw new GeneralSecurityException("No Key serializer for " + obj + " available");
    }

    public final zzgoy zzd(zzggi zzggi, Class cls) throws GeneralSecurityException {
        zzgpd zzgpd = new zzgpd(zzggi.getClass(), cls, (zzgpc) null);
        if (this.zzc.containsKey(zzgpd)) {
            return ((zzgoc) this.zzc.get(zzgpd)).zza(zzggi);
        }
        String obj = zzgpd.toString();
        throw new GeneralSecurityException("No Key Format serializer for " + obj + " available");
    }

    public final boolean zzi(zzgoy zzgoy) {
        return this.zzb.containsKey(new zzgpb(zzgoy.getClass(), zzgoy.zzd(), (zzgpa) null));
    }

    public final boolean zzj(zzgoy zzgoy) {
        return this.zzd.containsKey(new zzgpb(zzgoy.getClass(), zzgoy.zzd(), (zzgpa) null));
    }
}
