package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgla {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxm zzb;
    private static final zzgoc zzc = zzgoc.zzb(zzgkw.zza, zzghl.class, zzgou.class);
    private static final zzgny zzd;
    private static final zzgna zze = zzgna.zzb(zzgky.zza, zzghb.class, zzgot.class);
    private static final zzgmw zzf;

    static {
        zzgxm zza2 = zzgpi.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzb = zza2;
        zzd = zzgny.zzb(zzgkx.zza, zza2, zzgou.class);
        zzf = zzgmw.zzb(zzgkz.zza, zza2, zzgot.class);
    }

    public static /* synthetic */ zzghb zza(zzgot zzgot, zzggn zzggn) {
        if (zzgot.zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzgsm zze2 = zzgsm.zze(zzgot.zze(), zzgzf.zza());
                if (zze2.zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                } else if (zze2.zzf().zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
                } else if (zze2.zzg().zza() == 0) {
                    zzghh zzf2 = zzghl.zzf();
                    zzf2.zza(zze2.zzf().zzg().zzd());
                    zzf2.zzc(zze2.zzg().zzh().zzd());
                    zzf2.zzd(zze2.zzf().zzf().zza());
                    zzf2.zze(zze2.zzg().zzg().zza());
                    zzf2.zzb(zzf(zze2.zzg().zzg().zzc()));
                    zzf2.zzf(zzg(zzgot.zzc()));
                    zzghl zzg = zzf2.zzg();
                    zzggz zza2 = zzghb.zza();
                    zza2.zzd(zzg);
                    zza2.zza(zzgxn.zzb(zze2.zzf().zzg().zzB(), zzggn));
                    zza2.zzb(zzgxn.zzb(zze2.zzg().zzh().zzB(), zzggn));
                    zza2.zzc(zzgot.zzf());
                    return zza2.zze();
                } else {
                    throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
                }
            } catch (zzhak unused) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzghl zzb(zzgou zzgou) {
        if (zzgou.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzgsp zzd2 = zzgsp.zzd(zzgou.zzc().zzh(), zzgzf.zza());
                if (zzd2.zzf().zzc() == 0) {
                    zzghh zzf2 = zzghl.zzf();
                    zzf2.zza(zzd2.zze().zza());
                    zzf2.zzc(zzd2.zzf().zza());
                    zzf2.zzd(zzd2.zze().zzf().zza());
                    zzf2.zze(zzd2.zzf().zzh().zza());
                    zzf2.zzb(zzf(zzd2.zzf().zzh().zzc()));
                    zzf2.zzf(zzg(zzgou.zzc().zzg()));
                    return zzf2.zzg();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzhak e) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgou.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgot zzc(zzghb zzghb, zzggn zzggn) {
        zzgsl zzc2 = zzgsm.zzc();
        zzgsr zzc3 = zzgss.zzc();
        zzgsx zzc4 = zzgsy.zzc();
        zzc4.zza(zzghb.zzb().zzd());
        zzc3.zzb((zzgsy) zzc4.zzbr());
        byte[] zzd2 = zzghb.zzd().zzd(zzggn);
        zzc3.zza(zzgyj.zzv(zzd2, 0, zzd2.length));
        zzc2.zza((zzgss) zzc3.zzbr());
        zzgud zzc5 = zzgue.zzc();
        zzc5.zzb(zzh(zzghb.zzb()));
        byte[] zzd3 = zzghb.zze().zzd(zzggn);
        zzc5.zza(zzgyj.zzv(zzd3, 0, zzd3.length));
        zzc2.zzb((zzgue) zzc5.zzbr());
        return zzgot.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", ((zzgsm) zzc2.zzbr()).zzaN(), zzguo.SYMMETRIC, zzi(zzghb.zzb().zzh()), zzghb.zzf());
    }

    public static /* synthetic */ zzgou zzd(zzghl zzghl) {
        zzgut zza2 = zzguu.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzgso zza3 = zzgsp.zza();
        zzgsu zzc2 = zzgsv.zzc();
        zzgsx zzc3 = zzgsy.zzc();
        zzc3.zza(zzghl.zzd());
        zzc2.zzb((zzgsy) zzc3.zzbr());
        zzc2.zza(zzghl.zzb());
        zza3.zza((zzgsv) zzc2.zzbr());
        zzgug zzd2 = zzguh.zzd();
        zzd2.zzb(zzh(zzghl));
        zzd2.zza(zzghl.zzc());
        zza3.zzb((zzguh) zzd2.zzbr());
        zza2.zzc(((zzgsp) zza3.zzbr()).zzaN());
        zza2.zza(zzi(zzghl.zzh()));
        return zzgou.zzb((zzguu) zza2.zzbr());
    }

    public static void zze(zzgnu zzgnu) throws GeneralSecurityException {
        zzgnu.zzi(zzc);
        zzgnu.zzh(zzd);
        zzgnu.zzg(zze);
        zzgnu.zzf(zzf);
    }

    private static zzghi zzf(zzgub zzgub) throws GeneralSecurityException {
        zzgub zzgub2 = zzgub.UNKNOWN_HASH;
        zzgvv zzgvv = zzgvv.UNKNOWN_PREFIX;
        int ordinal = zzgub.ordinal();
        if (ordinal == 1) {
            return zzghi.zza;
        }
        if (ordinal == 2) {
            return zzghi.zzd;
        }
        if (ordinal == 3) {
            return zzghi.zzc;
        }
        if (ordinal == 4) {
            return zzghi.zze;
        }
        if (ordinal == 5) {
            return zzghi.zzb;
        }
        int zza2 = zzgub.zza();
        throw new GeneralSecurityException("Unable to parse HashType: " + zza2);
    }

    private static zzghj zzg(zzgvv zzgvv) throws GeneralSecurityException {
        zzgub zzgub = zzgub.UNKNOWN_HASH;
        zzgvv zzgvv2 = zzgvv.UNKNOWN_PREFIX;
        int ordinal = zzgvv.ordinal();
        if (ordinal == 1) {
            return zzghj.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzghj.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzgvv.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzghj.zzb;
    }

    private static zzguk zzh(zzghl zzghl) throws GeneralSecurityException {
        zzgub zzgub;
        zzguj zzd2 = zzguk.zzd();
        zzd2.zzb(zzghl.zze());
        zzghi zzg = zzghl.zzg();
        if (zzghi.zza.equals(zzg)) {
            zzgub = zzgub.SHA1;
        } else if (zzghi.zzb.equals(zzg)) {
            zzgub = zzgub.SHA224;
        } else if (zzghi.zzc.equals(zzg)) {
            zzgub = zzgub.SHA256;
        } else if (zzghi.zzd.equals(zzg)) {
            zzgub = zzgub.SHA384;
        } else if (zzghi.zze.equals(zzg)) {
            zzgub = zzgub.SHA512;
        } else {
            throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(String.valueOf(zzg))));
        }
        zzd2.zza(zzgub);
        return (zzguk) zzd2.zzbr();
    }

    private static zzgvv zzi(zzghj zzghj) throws GeneralSecurityException {
        if (zzghj.zza.equals(zzghj)) {
            return zzgvv.TINK;
        }
        if (zzghj.zzb.equals(zzghj)) {
            return zzgvv.CRUNCHY;
        }
        if (zzghj.zzc.equals(zzghj)) {
            return zzgvv.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzghj))));
    }
}
