package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzglk {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxm zzb;
    private static final zzgoc zzc = zzgoc.zzb(zzglg.zza, zzgik.class, zzgou.class);
    private static final zzgny zzd;
    private static final zzgna zze = zzgna.zzb(zzgli.zza, zzgib.class, zzgot.class);
    private static final zzgmw zzf;

    static {
        zzgxm zza2 = zzgpi.zza("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zza2;
        zzd = zzgny.zzb(zzglh.zza, zza2, zzgou.class);
        zzf = zzgmw.zzb(zzglj.zza, zza2, zzgot.class);
    }

    public static /* synthetic */ zzgib zza(zzgot zzgot, zzggn zzggn) {
        if (zzgot.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzgtk zze2 = zzgtk.zze(zzgot.zze(), zzgzf.zza());
                if (zze2.zza() == 0) {
                    zzgih zzc2 = zzgik.zzc();
                    zzc2.zzb(zze2.zzf().zzd());
                    zzc2.zza(12);
                    zzc2.zzc(16);
                    zzc2.zzd(zzf(zzgot.zzc()));
                    zzgik zze3 = zzc2.zze();
                    zzghz zza2 = zzgib.zza();
                    zza2.zzc(zze3);
                    zza2.zzb(zzgxn.zzb(zze2.zzf().zzB(), zzggn));
                    zza2.zza(zzgot.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzhak unused) {
                throw new GeneralSecurityException("Parsing AesGcmKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgik zzb(zzgou zzgou) {
        if (zzgou.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzgtn zzf2 = zzgtn.zzf(zzgou.zzc().zzh(), zzgzf.zza());
                if (zzf2.zzc() == 0) {
                    zzgih zzc2 = zzgik.zzc();
                    zzc2.zzb(zzf2.zza());
                    zzc2.zza(12);
                    zzc2.zzc(16);
                    zzc2.zzd(zzf(zzgou.zzc().zzg()));
                    return zzc2.zze();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzhak e) {
                throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzgou.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgot zzc(zzgib zzgib, zzggn zzggn) {
        zzgtj zzc2 = zzgtk.zzc();
        byte[] zzd2 = zzgib.zzd().zzd(zzggn);
        zzc2.zza(zzgyj.zzv(zzd2, 0, zzd2.length));
        return zzgot.zza("type.googleapis.com/google.crypto.tink.AesGcmKey", ((zzgtk) zzc2.zzbr()).zzaN(), zzguo.SYMMETRIC, zzg(zzgib.zzb().zzd()), zzgib.zze());
    }

    public static /* synthetic */ zzgou zzd(zzgik zzgik) {
        zzgut zza2 = zzguu.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzgtm zzd2 = zzgtn.zzd();
        zzd2.zza(zzgik.zzb());
        zza2.zzc(((zzgtn) zzd2.zzbr()).zzaN());
        zza2.zza(zzg(zzgik.zzd()));
        return zzgou.zzb((zzguu) zza2.zzbr());
    }

    public static void zze(zzgnu zzgnu) throws GeneralSecurityException {
        zzgnu.zzi(zzc);
        zzgnu.zzh(zzd);
        zzgnu.zzg(zze);
        zzgnu.zzf(zzf);
    }

    private static zzgii zzf(zzgvv zzgvv) throws GeneralSecurityException {
        zzgvv zzgvv2 = zzgvv.UNKNOWN_PREFIX;
        int ordinal = zzgvv.ordinal();
        if (ordinal == 1) {
            return zzgii.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgii.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzgvv.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzgii.zzb;
    }

    private static zzgvv zzg(zzgii zzgii) throws GeneralSecurityException {
        if (zzgii.zza.equals(zzgii)) {
            return zzgvv.TINK;
        }
        if (zzgii.zzb.equals(zzgii)) {
            return zzgvv.CRUNCHY;
        }
        if (zzgii.zzc.equals(zzgii)) {
            return zzgvv.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgii))));
    }
}
