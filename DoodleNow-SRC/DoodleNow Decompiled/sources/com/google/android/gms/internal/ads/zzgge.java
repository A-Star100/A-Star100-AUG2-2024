package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgge {
    private final zzgvc zza;
    private final List zzb;
    private final zzgrs zzc;

    private zzgge(zzgvc zzgvc, List list) {
        this.zza = zzgvc;
        this.zzb = list;
        this.zzc = zzgrs.zza;
    }

    /* synthetic */ zzgge(zzgvc zzgvc, List list, zzgrs zzgrs, zzggd zzggd) {
        this.zza = zzgvc;
        this.zzb = list;
        this.zzc = zzgrs;
    }

    static final zzgge zza(zzgvc zzgvc) throws GeneralSecurityException {
        zzh(zzgvc);
        return new zzgge(zzgvc, zzg(zzgvc));
    }

    public static final zzgge zzb(zzggi zzggi) throws GeneralSecurityException {
        zzgga zzgga = new zzgga();
        zzgfy zzgfy = new zzgfy(zzggi, (zzgfx) null);
        zzgfy.zzd();
        zzgfy.zzc();
        zzgga.zza(zzgfy);
        return zzgga.zzb();
    }

    private static zzgot zzf(zzgvb zzgvb) {
        try {
            return zzgot.zza(zzgvb.zzc().zzg(), zzgvb.zzc().zzf(), zzgvb.zzc().zzc(), zzgvb.zzg(), zzgvb.zzg() == zzgvv.RAW ? null : Integer.valueOf(zzgvb.zza()));
        } catch (GeneralSecurityException e) {
            throw new zzgph("Creating a protokey serialization failed", e);
        }
    }

    private static List zzg(zzgvc zzgvc) {
        zzgft zzgft;
        zzgfv zzgfv;
        ArrayList arrayList = new ArrayList(zzgvc.zza());
        for (zzgvb zzgvb : zzgvc.zzh()) {
            int zza2 = zzgvb.zza();
            try {
                zzgot zzf = zzf(zzgvb);
                zzgnu zzc2 = zzgnu.zzc();
                zzggn zza3 = zzggn.zza();
                if (!zzc2.zzj(zzf)) {
                    zzgft = new zzgnd(zzf, zza3);
                } else {
                    zzgft = zzc2.zza(zzf, zza3);
                }
                zzgur zzd = zzgvb.zzd();
                zzgur zzgur = zzgur.UNKNOWN_STATUS;
                int ordinal = zzd.ordinal();
                if (ordinal == 1) {
                    zzgfv = zzgfv.zza;
                } else if (ordinal == 2) {
                    zzgfv = zzgfv.zzb;
                } else if (ordinal == 3) {
                    zzgfv = zzgfv.zzc;
                } else {
                    throw new GeneralSecurityException("Unknown key status");
                }
                arrayList.add(new zzggc(zzgft, zzgfv, zza2, zza2 == zzgvc.zzc(), (zzggb) null));
            } catch (GeneralSecurityException unused) {
                arrayList.add((Object) null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: private */
    public static void zzh(zzgvc zzgvc) throws GeneralSecurityException {
        if (zzgvc == null || zzgvc.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    @Nullable
    private static final Object zzi(zzgmr zzgmr, zzgft zzgft, Class cls) throws GeneralSecurityException {
        try {
            return zzgnr.zza().zzc(zzgft, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public final String toString() {
        Charset charset = zzggq.zza;
        zzgvc zzgvc = this.zza;
        zzgve zza2 = zzgvh.zza();
        zza2.zzb(zzgvc.zzc());
        for (zzgvb zzgvb : zzgvc.zzh()) {
            zzgvf zza3 = zzgvg.zza();
            zza3.zzd(zzgvb.zzc().zzg());
            zza3.zzc(zzgvb.zzd());
            zza3.zzb(zzgvb.zzg());
            zza3.zza(zzgvb.zza());
            zza2.zza((zzgvg) zza3.zzbr());
        }
        return ((zzgvh) zza2.zzbr()).toString();
    }

    /* access modifiers changed from: package-private */
    public final zzgvc zzc() {
        return this.zza;
    }

    public final Object zzd(zzgfn zzgfn, Class cls) throws GeneralSecurityException {
        Class zza2 = zzggm.zza(cls);
        if (zza2 != null) {
            zzgvc zzgvc = this.zza;
            Charset charset = zzggq.zza;
            int zzc2 = zzgvc.zzc();
            int i = 0;
            boolean z = false;
            boolean z2 = true;
            for (zzgvb zzgvb : zzgvc.zzh()) {
                if (zzgvb.zzd() == zzgur.ENABLED) {
                    if (!zzgvb.zzl()) {
                        throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(zzgvb.zza())}));
                    } else if (zzgvb.zzg() == zzgvv.UNKNOWN_PREFIX) {
                        throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(zzgvb.zza())}));
                    } else if (zzgvb.zzd() != zzgur.UNKNOWN_STATUS) {
                        if (zzgvb.zza() == zzc2) {
                            if (!z) {
                                z = true;
                            } else {
                                throw new GeneralSecurityException("keyset contains multiple primary keys");
                            }
                        }
                        z2 &= zzgvb.zzc().zzc() == zzguo.ASYMMETRIC_PUBLIC;
                        i++;
                    } else {
                        throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(zzgvb.zza())}));
                    }
                }
            }
            if (i == 0) {
                throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
            } else if (z || z2) {
                zzgoo zza3 = zzgos.zza(zza2);
                zza3.zzc(this.zzc);
                for (int i2 = 0; i2 < this.zzb.size(); i2++) {
                    zzgvb zze = this.zza.zze(i2);
                    if (zze.zzd().equals(zzgur.ENABLED)) {
                        zzggc zzggc = (zzggc) this.zzb.get(i2);
                        if (zzggc != null) {
                            zzgft zza4 = zzggc.zza();
                            Object zzi = zzi((zzgmr) zzgfn, zza4, zza2);
                            if (zzi == null) {
                                throw new GeneralSecurityException("Unable to get primitive " + zza2.toString() + " for key of type " + zze.zzc().zzg() + ", see https://developers.google.com/tink/registration_errors");
                            } else if (zze.zza() == this.zza.zzc()) {
                                zza3.zzb(zzi, zza4, zze);
                            } else {
                                zza3.zza(zzi, zza4, zze);
                            }
                        } else {
                            throw new GeneralSecurityException("Key parsing of key with index " + i2 + " and type_url " + zze.zzc().zzg() + " failed, unable to get primitive");
                        }
                    }
                }
                return zzgnr.zza().zzd(zza3.zzd(), cls);
            } else {
                throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
            }
        } else {
            throw new GeneralSecurityException("No wrapper found for ".concat(String.valueOf(cls.getName())));
        }
    }
}
