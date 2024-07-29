package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzglf {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxm zzb;
    private static final zzgoc zzc = zzgoc.zzb(zzglb.zza, zzghx.class, zzgou.class);
    private static final zzgny zzd;
    private static final zzgna zze = zzgna.zzb(zzgld.zza, zzghp.class, zzgot.class);
    private static final zzgmw zzf;

    static {
        zzgxm zza2 = zzgpi.zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zza2;
        zzd = zzgny.zzb(zzglc.zza, zza2, zzgou.class);
        zzf = zzgmw.zzb(zzgle.zza, zza2, zzgot.class);
    }

    public static /* synthetic */ zzghp zza(zzgot zzgot, zzggn zzggn) {
        if (zzgot.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzgtb zze2 = zzgtb.zze(zzgot.zze(), zzgzf.zza());
                if (zze2.zza() == 0) {
                    zzghu zzd2 = zzghx.zzd();
                    zzd2.zzb(zze2.zzg().zzd());
                    zzd2.zza(zze2.zzf().zza());
                    zzd2.zzc(16);
                    zzd2.zzd(zzf(zzgot.zzc()));
                    zzghx zze3 = zzd2.zze();
                    zzghn zza2 = zzghp.zza();
                    zza2.zzc(zze3);
                    zza2.zzb(zzgxn.zzb(zze2.zzg().zzB(), zzggn));
                    zza2.zza(zzgot.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzhak unused) {
                throw new GeneralSecurityException("Parsing AesEaxcKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzghx zzb(zzgou zzgou) {
        if (zzgou.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzgte zze2 = zzgte.zze(zzgou.zzc().zzh(), zzgzf.zza());
                zzghu zzd2 = zzghx.zzd();
                zzd2.zzb(zze2.zza());
                zzd2.zza(zze2.zzf().zza());
                zzd2.zzc(16);
                zzd2.zzd(zzf(zzgou.zzc().zzg()));
                return zzd2.zze();
            } catch (zzhak e) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ".concat(String.valueOf(zzgou.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgot zzc(zzghp zzghp, zzggn zzggn) {
        zzgta zzc2 = zzgtb.zzc();
        zzc2.zzb(zzg(zzghp.zzb()));
        byte[] zzd2 = zzghp.zzd().zzd(zzggn);
        zzc2.zza(zzgyj.zzv(zzd2, 0, zzd2.length));
        return zzgot.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzgtb) zzc2.zzbr()).zzaN(), zzguo.SYMMETRIC, zzh(zzghp.zzb().zze()), zzghp.zze());
    }

    public static /* synthetic */ zzgou zzd(zzghx zzghx) {
        zzgut zza2 = zzguu.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzgtd zzc2 = zzgte.zzc();
        zzc2.zzb(zzg(zzghx));
        zzc2.zza(zzghx.zzc());
        zza2.zzc(((zzgte) zzc2.zzbr()).zzaN());
        zza2.zza(zzh(zzghx.zze()));
        return zzgou.zzb((zzguu) zza2.zzbr());
    }

    public static void zze(zzgnu zzgnu) throws GeneralSecurityException {
        zzgnu.zzi(zzc);
        zzgnu.zzh(zzd);
        zzgnu.zzg(zze);
        zzgnu.zzf(zzf);
    }

    private static zzghv zzf(zzgvv zzgvv) throws GeneralSecurityException {
        zzgvv zzgvv2 = zzgvv.UNKNOWN_PREFIX;
        int ordinal = zzgvv.ordinal();
        if (ordinal == 1) {
            return zzghv.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzghv.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzgvv.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzghv.zzb;
    }

    private static zzgth zzg(zzghx zzghx) throws GeneralSecurityException {
        zzgtg zzc2 = zzgth.zzc();
        zzc2.zza(zzghx.zzb());
        return (zzgth) zzc2.zzbr();
    }

    private static zzgvv zzh(zzghv zzghv) throws GeneralSecurityException {
        if (zzghv.zza.equals(zzghv)) {
            return zzgvv.TINK;
        }
        if (zzghv.zzb.equals(zzghv)) {
            return zzgvv.CRUNCHY;
        }
        if (zzghv.zzc.equals(zzghv)) {
            return zzgvv.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzghv))));
    }
}
