package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgrg {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxm zzb;
    private static final zzgoc zzc = zzgoc.zzb(zzgrc.zza, zzgpv.class, zzgou.class);
    private static final zzgny zzd;
    private static final zzgna zze = zzgna.zzb(zzgre.zza, zzgpm.class, zzgot.class);
    private static final zzgmw zzf;

    static {
        zzgxm zza2 = zzgpi.zza("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zza2;
        zzd = zzgny.zzb(zzgrd.zza, zza2, zzgou.class);
        zzf = zzgmw.zzb(zzgrf.zza, zza2, zzgot.class);
    }

    public static /* synthetic */ zzgot zza(zzgpm zzgpm, zzggn zzggn) {
        zzgsc zzc2 = zzgsd.zzc();
        zzc2.zzb(zzg(zzgpm.zzb()));
        byte[] zzd2 = zzgpm.zzd().zzd(zzggn);
        zzc2.zza(zzgyj.zzv(zzd2, 0, zzd2.length));
        return zzgot.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", ((zzgsd) zzc2.zzbr()).zzaN(), zzguo.SYMMETRIC, zzh(zzgpm.zzb().zzf()), zzgpm.zze());
    }

    public static /* synthetic */ zzgou zzb(zzgpv zzgpv) {
        zzgut zza2 = zzguu.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzgsf zzc2 = zzgsg.zzc();
        zzc2.zzb(zzg(zzgpv));
        zzc2.zza(zzgpv.zzc());
        zza2.zzc(((zzgsg) zzc2.zzbr()).zzaN());
        zza2.zza(zzh(zzgpv.zzf()));
        return zzgou.zzb((zzguu) zza2.zzbr());
    }

    public static /* synthetic */ zzgpm zzc(zzgot zzgot, zzggn zzggn) {
        if (zzgot.zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzgsd zze2 = zzgsd.zze(zzgot.zze(), zzgzf.zza());
                if (zze2.zza() == 0) {
                    zzgps zze3 = zzgpv.zze();
                    zze3.zza(zze2.zzg().zzd());
                    zze3.zzb(zze2.zzf().zza());
                    zze3.zzc(zzf(zzgot.zzc()));
                    zzgpv zzd2 = zze3.zzd();
                    zzgpk zza2 = zzgpm.zza();
                    zza2.zzc(zzd2);
                    zza2.zza(zzgxn.zzb(zze2.zzg().zzB(), zzggn));
                    zza2.zzb(zzgot.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzhak | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing AesCmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgpv zzd(zzgou zzgou) {
        if (zzgou.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzgsg zze2 = zzgsg.zze(zzgou.zzc().zzh(), zzgzf.zza());
                zzgps zze3 = zzgpv.zze();
                zze3.zza(zze2.zza());
                zze3.zzb(zze2.zzf().zza());
                zze3.zzc(zzf(zzgou.zzc().zzg()));
                return zze3.zzd();
            } catch (zzhak e) {
                throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgou.zzc().zzi())));
        }
    }

    public static void zze(zzgnu zzgnu) throws GeneralSecurityException {
        zzgnu.zzi(zzc);
        zzgnu.zzh(zzd);
        zzgnu.zzg(zze);
        zzgnu.zzf(zzf);
    }

    private static zzgpt zzf(zzgvv zzgvv) throws GeneralSecurityException {
        zzgvv zzgvv2 = zzgvv.UNKNOWN_PREFIX;
        int ordinal = zzgvv.ordinal();
        if (ordinal == 1) {
            return zzgpt.zza;
        }
        if (ordinal == 2) {
            return zzgpt.zzc;
        }
        if (ordinal == 3) {
            return zzgpt.zzd;
        }
        if (ordinal == 4) {
            return zzgpt.zzb;
        }
        int zza2 = zzgvv.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    private static zzgsj zzg(zzgpv zzgpv) {
        zzgsi zzc2 = zzgsj.zzc();
        zzc2.zza(zzgpv.zzb());
        return (zzgsj) zzc2.zzbr();
    }

    private static zzgvv zzh(zzgpt zzgpt) throws GeneralSecurityException {
        if (zzgpt.zza.equals(zzgpt)) {
            return zzgvv.TINK;
        }
        if (zzgpt.zzb.equals(zzgpt)) {
            return zzgvv.CRUNCHY;
        }
        if (zzgpt.zzd.equals(zzgpt)) {
            return zzgvv.RAW;
        }
        if (zzgpt.zzc.equals(zzgpt)) {
            return zzgvv.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgpt))));
    }
}
