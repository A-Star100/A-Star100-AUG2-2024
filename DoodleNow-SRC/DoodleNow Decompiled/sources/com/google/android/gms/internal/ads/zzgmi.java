package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgmi {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxm zzb;
    private static final zzgoc zzc = zzgoc.zzb(zzgme.zza, zzgkv.class, zzgou.class);
    private static final zzgny zzd;
    private static final zzgna zze = zzgna.zzb(zzgmg.zza, zzgkp.class, zzgot.class);
    private static final zzgmw zzf;

    static {
        zzgxm zza2 = zzgpi.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zza2;
        zzd = zzgny.zzb(zzgmf.zza, zza2, zzgou.class);
        zzf = zzgmw.zzb(zzgmh.zza, zza2, zzgot.class);
    }

    public static /* synthetic */ zzgkp zza(zzgot zzgot, zzggn zzggn) {
        if (zzgot.zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                zzgwb zze2 = zzgwb.zze(zzgot.zze(), zzgzf.zza());
                if (zze2.zza() == 0) {
                    return zzgkp.zza(zzf(zzgot.zzc()), zzgxn.zzb(zze2.zzf().zzB(), zzggn), zzgot.zzf());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzhak unused) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgkv zzb(zzgou zzgou) {
        if (zzgou.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                if (zzgwe.zze(zzgou.zzc().zzh(), zzgzf.zza()).zza() == 0) {
                    return zzgkv.zzc(zzf(zzgou.zzc().zzg()));
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzhak e) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgou.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgot zzc(zzgkp zzgkp, zzggn zzggn) {
        zzgwa zzc2 = zzgwb.zzc();
        byte[] zzd2 = zzgkp.zzd().zzd(zzggn);
        zzc2.zza(zzgyj.zzv(zzd2, 0, zzd2.length));
        return zzgot.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzgwb) zzc2.zzbr()).zzaN(), zzguo.SYMMETRIC, zzg(zzgkp.zzb().zzb()), zzgkp.zze());
    }

    public static /* synthetic */ zzgou zzd(zzgkv zzgkv) {
        zzgut zza2 = zzguu.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza2.zzc(zzgwe.zzd().zzaN());
        zza2.zza(zzg(zzgkv.zzb()));
        return zzgou.zzb((zzguu) zza2.zzbr());
    }

    public static void zze(zzgnu zzgnu) throws GeneralSecurityException {
        zzgnu.zzi(zzc);
        zzgnu.zzh(zzd);
        zzgnu.zzg(zze);
        zzgnu.zzf(zzf);
    }

    private static zzgku zzf(zzgvv zzgvv) throws GeneralSecurityException {
        zzgvv zzgvv2 = zzgvv.UNKNOWN_PREFIX;
        int ordinal = zzgvv.ordinal();
        if (ordinal == 1) {
            return zzgku.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgku.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzgvv.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzgku.zzb;
    }

    private static zzgvv zzg(zzgku zzgku) throws GeneralSecurityException {
        if (zzgku.zza.equals(zzgku)) {
            return zzgvv.TINK;
        }
        if (zzgku.zzb.equals(zzgku)) {
            return zzgvv.CRUNCHY;
        }
        if (zzgku.zzc.equals(zzgku)) {
            return zzgvv.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgku.toString()));
    }
}
