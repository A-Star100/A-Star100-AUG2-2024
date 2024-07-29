package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzglp {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxm zzb;
    private static final zzgoc zzc = zzgoc.zzb(zzgll.zza, zzgix.class, zzgou.class);
    private static final zzgny zzd;
    private static final zzgna zze = zzgna.zzb(zzgln.zza, zzgio.class, zzgot.class);
    private static final zzgmw zzf;

    static {
        zzgxm zza2 = zzgpi.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zza2;
        zzd = zzgny.zzb(zzglm.zza, zza2, zzgou.class);
        zzf = zzgmw.zzb(zzglo.zza, zza2, zzgot.class);
    }

    public static /* synthetic */ zzgio zza(zzgot zzgot, zzggn zzggn) {
        if (zzgot.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzgtq zze2 = zzgtq.zze(zzgot.zze(), zzgzf.zza());
                if (zze2.zza() == 0) {
                    zzgiu zzc2 = zzgix.zzc();
                    zzc2.zza(zze2.zzf().zzd());
                    zzc2.zzb(zzf(zzgot.zzc()));
                    zzgix zzc3 = zzc2.zzc();
                    zzgim zza2 = zzgio.zza();
                    zza2.zzc(zzc3);
                    zza2.zzb(zzgxn.zzb(zze2.zzf().zzB(), zzggn));
                    zza2.zza(zzgot.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzhak unused) {
                throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgix zzb(zzgou zzgou) {
        if (zzgou.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzgtt zzf2 = zzgtt.zzf(zzgou.zzc().zzh(), zzgzf.zza());
                if (zzf2.zzc() == 0) {
                    zzgiu zzc2 = zzgix.zzc();
                    zzc2.zza(zzf2.zza());
                    zzc2.zzb(zzf(zzgou.zzc().zzg()));
                    return zzc2.zzc();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzhak e) {
                throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: ".concat(String.valueOf(zzgou.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgot zzc(zzgio zzgio, zzggn zzggn) {
        zzgtp zzc2 = zzgtq.zzc();
        byte[] zzd2 = zzgio.zzd().zzd(zzggn);
        zzc2.zza(zzgyj.zzv(zzd2, 0, zzd2.length));
        return zzgot.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzgtq) zzc2.zzbr()).zzaN(), zzguo.SYMMETRIC, zzg(zzgio.zzb().zzd()), zzgio.zze());
    }

    public static /* synthetic */ zzgou zzd(zzgix zzgix) {
        zzgut zza2 = zzguu.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzgts zzd2 = zzgtt.zzd();
        zzd2.zza(zzgix.zzb());
        zza2.zzc(((zzgtt) zzd2.zzbr()).zzaN());
        zza2.zza(zzg(zzgix.zzd()));
        return zzgou.zzb((zzguu) zza2.zzbr());
    }

    public static void zze(zzgnu zzgnu) throws GeneralSecurityException {
        zzgnu.zzi(zzc);
        zzgnu.zzh(zzd);
        zzgnu.zzg(zze);
        zzgnu.zzf(zzf);
    }

    private static zzgiv zzf(zzgvv zzgvv) throws GeneralSecurityException {
        zzgvv zzgvv2 = zzgvv.UNKNOWN_PREFIX;
        int ordinal = zzgvv.ordinal();
        if (ordinal == 1) {
            return zzgiv.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgiv.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzgvv.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzgiv.zzb;
    }

    private static zzgvv zzg(zzgiv zzgiv) throws GeneralSecurityException {
        if (zzgiv.zza.equals(zzgiv)) {
            return zzgvv.TINK;
        }
        if (zzgiv.zzb.equals(zzgiv)) {
            return zzgvv.CRUNCHY;
        }
        if (zzgiv.zzc.equals(zzgiv)) {
            return zzgvv.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgiv))));
    }
}
