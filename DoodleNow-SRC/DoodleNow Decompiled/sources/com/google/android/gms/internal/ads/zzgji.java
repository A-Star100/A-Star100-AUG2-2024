package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgji {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxm zzb;
    private static final zzgoc zzc = zzgoc.zzb(zzgje.zza, zzgjd.class, zzgou.class);
    private static final zzgny zzd;
    private static final zzgna zze = zzgna.zzb(zzgjg.zza, zzgiy.class, zzgot.class);
    private static final zzgmw zzf;

    static {
        zzgxm zza2 = zzgpi.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzb = zza2;
        zzd = zzgny.zzb(zzgjf.zza, zza2, zzgou.class);
        zzf = zzgmw.zzb(zzgjh.zza, zza2, zzgot.class);
    }

    public static /* synthetic */ zzgiy zza(zzgot zzgot, zzggn zzggn) {
        if (zzgot.zzg().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzgtw zze2 = zzgtw.zze(zzgot.zze(), zzgzf.zza());
                if (zze2.zza() == 0) {
                    return zzgiy.zza(zzf(zzgot.zzc()), zzgxn.zzb(zze2.zzf().zzB(), zzggn), zzgot.zzf());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzhak unused) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgjd zzb(zzgou zzgou) {
        if (zzgou.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzgtz.zzd(zzgou.zzc().zzh(), zzgzf.zza());
                return zzgjd.zzc(zzf(zzgou.zzc().zzg()));
            } catch (zzhak e) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgou.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgot zzc(zzgiy zzgiy, zzggn zzggn) {
        zzgtv zzc2 = zzgtw.zzc();
        byte[] zzd2 = zzgiy.zzd().zzd(zzggn);
        zzc2.zza(zzgyj.zzv(zzd2, 0, zzd2.length));
        return zzgot.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((zzgtw) zzc2.zzbr()).zzaN(), zzguo.SYMMETRIC, zzg(zzgiy.zzb().zzb()), zzgiy.zze());
    }

    public static /* synthetic */ zzgou zzd(zzgjd zzgjd) {
        zzgut zza2 = zzguu.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zza2.zzc(zzgtz.zzc().zzaN());
        zza2.zza(zzg(zzgjd.zzb()));
        return zzgou.zzb((zzguu) zza2.zzbr());
    }

    public static void zze(zzgnu zzgnu) throws GeneralSecurityException {
        zzgnu.zzi(zzc);
        zzgnu.zzh(zzd);
        zzgnu.zzg(zze);
        zzgnu.zzf(zzf);
    }

    private static zzgjc zzf(zzgvv zzgvv) throws GeneralSecurityException {
        zzgvv zzgvv2 = zzgvv.UNKNOWN_PREFIX;
        int ordinal = zzgvv.ordinal();
        if (ordinal == 1) {
            return zzgjc.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgjc.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzgvv.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzgjc.zzb;
    }

    private static zzgvv zzg(zzgjc zzgjc) throws GeneralSecurityException {
        if (zzgjc.zza.equals(zzgjc)) {
            return zzgvv.TINK;
        }
        if (zzgjc.zzb.equals(zzgjc)) {
            return zzgvv.CRUNCHY;
        }
        if (zzgjc.zzc.equals(zzgjc)) {
            return zzgvv.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgjc.toString()));
    }
}
