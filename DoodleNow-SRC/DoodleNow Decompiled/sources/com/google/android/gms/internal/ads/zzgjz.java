package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgjz {
    @Nullable
    private String zza;
    @Nullable
    private zzgka zzb;
    @Nullable
    private zzggt zzc;

    private zzgjz() {
    }

    /* synthetic */ zzgjz(zzgjy zzgjy) {
    }

    public final zzgjz zza(zzggt zzggt) {
        this.zzc = zzggt;
        return this;
    }

    public final zzgjz zzb(zzgka zzgka) {
        this.zzb = zzgka;
        return this;
    }

    public final zzgjz zzc(String str) {
        this.zza = str;
        return this;
    }

    public final zzgkc zzd() throws GeneralSecurityException {
        if (this.zza != null) {
            zzgka zzgka = this.zzb;
            if (zzgka != null) {
                zzggt zzggt = this.zzc;
                if (zzggt == null) {
                    throw new GeneralSecurityException("dekParametersForNewKeys must be set");
                } else if (zzggt.zza()) {
                    throw new GeneralSecurityException("dekParametersForNewKeys must note have ID Requirements");
                } else if ((zzgka.equals(zzgka.zza) && (zzggt instanceof zzgik)) || ((zzgka.equals(zzgka.zzc) && (zzggt instanceof zzgjd)) || ((zzgka.equals(zzgka.zzb) && (zzggt instanceof zzgkv)) || ((zzgka.equals(zzgka.zzd) && (zzggt instanceof zzghl)) || ((zzgka.equals(zzgka.zze) && (zzggt instanceof zzghx)) || (zzgka.equals(zzgka.zzf) && (zzggt instanceof zzgix))))))) {
                    return new zzgkc(this.zza, this.zzb, this.zzc, (zzgkb) null);
                } else {
                    String zzgka2 = this.zzb.toString();
                    String valueOf = String.valueOf(this.zzc);
                    throw new GeneralSecurityException("Cannot use parsing strategy " + zzgka2 + " when new keys are picked according to " + valueOf + ".");
                }
            } else {
                throw new GeneralSecurityException("dekParsingStrategy must be set");
            }
        } else {
            throw new GeneralSecurityException("kekUri must be set");
        }
    }
}
