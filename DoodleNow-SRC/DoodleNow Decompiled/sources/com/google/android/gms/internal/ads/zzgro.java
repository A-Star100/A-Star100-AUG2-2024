package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgro {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxm zzb;
    private static final zzgmq zzc;
    private static final zzgmq zzd;
    private static final zzgoc zze = zzgoc.zzb(zzgrk.zza, zzgqo.class, zzgou.class);
    private static final zzgny zzf;
    private static final zzgna zzg = zzgna.zzb(zzgrm.zza, zzgqd.class, zzgot.class);
    private static final zzgmw zzh;

    static {
        zzgxm zza2 = zzgpi.zza("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zza2;
        zzgmo zza3 = zzgmq.zza();
        zza3.zza(zzgvv.RAW, zzgqm.zzd);
        zza3.zza(zzgvv.TINK, zzgqm.zza);
        zza3.zza(zzgvv.LEGACY, zzgqm.zzc);
        zza3.zza(zzgvv.CRUNCHY, zzgqm.zzb);
        zzc = zza3.zzb();
        zzgmo zza4 = zzgmq.zza();
        zza4.zza(zzgub.SHA1, zzgql.zza);
        zza4.zza(zzgub.SHA224, zzgql.zzb);
        zza4.zza(zzgub.SHA256, zzgql.zzc);
        zza4.zza(zzgub.SHA384, zzgql.zzd);
        zza4.zza(zzgub.SHA512, zzgql.zze);
        zzd = zza4.zzb();
        zzf = zzgny.zzb(zzgrl.zza, zza2, zzgou.class);
        zzh = zzgmw.zzb(zzgrn.zza, zza2, zzgot.class);
    }

    public static /* synthetic */ zzgot zza(zzgqd zzgqd, zzggn zzggn) {
        zzgud zzc2 = zzgue.zzc();
        zzc2.zzb(zzf(zzgqd.zzb()));
        byte[] zzd2 = zzgqd.zzd().zzd(zzggn);
        zzc2.zza(zzgyj.zzv(zzd2, 0, zzd2.length));
        return zzgot.zza("type.googleapis.com/google.crypto.tink.HmacKey", ((zzgue) zzc2.zzbr()).zzaN(), zzguo.SYMMETRIC, (zzgvv) zzc.zzb(zzgqd.zzb().zzg()), zzgqd.zze());
    }

    public static /* synthetic */ zzgou zzb(zzgqo zzgqo) {
        zzgut zza2 = zzguu.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzgug zzd2 = zzguh.zzd();
        zzd2.zzb(zzf(zzgqo));
        zzd2.zza(zzgqo.zzc());
        zza2.zzc(((zzguh) zzd2.zzbr()).zzaN());
        zza2.zza((zzgvv) zzc.zzb(zzgqo.zzg()));
        return zzgou.zzb((zzguu) zza2.zzbr());
    }

    public static /* synthetic */ zzgqd zzc(zzgot zzgot, zzggn zzggn) {
        if (zzgot.zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzgue zzf2 = zzgue.zzf(zzgot.zze(), zzgzf.zza());
                if (zzf2.zza() == 0) {
                    zzgqk zze2 = zzgqo.zze();
                    zze2.zzb(zzf2.zzh().zzd());
                    zze2.zzc(zzf2.zzg().zza());
                    zze2.zza((zzgql) zzd.zzc(zzf2.zzg().zzc()));
                    zze2.zzd((zzgqm) zzc.zzc(zzgot.zzc()));
                    zzgqo zze3 = zze2.zze();
                    zzgqb zza2 = zzgqd.zza();
                    zza2.zzc(zze3);
                    zza2.zzb(zzgxn.zzb(zzf2.zzh().zzB(), zzggn));
                    zza2.zza(zzgot.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzhak | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing HmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgqo zzd(zzgou zzgou) {
        if (zzgou.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzguh zzg2 = zzguh.zzg(zzgou.zzc().zzh(), zzgzf.zza());
                if (zzg2.zzc() == 0) {
                    zzgqk zze2 = zzgqo.zze();
                    zze2.zzb(zzg2.zza());
                    zze2.zzc(zzg2.zzh().zza());
                    zze2.zza((zzgql) zzd.zzc(zzg2.zzh().zzc()));
                    zze2.zzd((zzgqm) zzc.zzc(zzgou.zzc().zzg()));
                    return zze2.zze();
                }
                int zzc2 = zzg2.zzc();
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zzc2);
            } catch (zzhak e) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgou.zzc().zzi())));
        }
    }

    public static void zze(zzgnu zzgnu) throws GeneralSecurityException {
        zzgnu.zzi(zze);
        zzgnu.zzh(zzf);
        zzgnu.zzg(zzg);
        zzgnu.zzf(zzh);
    }

    private static zzguk zzf(zzgqo zzgqo) throws GeneralSecurityException {
        zzguj zzd2 = zzguk.zzd();
        zzd2.zzb(zzgqo.zzb());
        zzd2.zza((zzgub) zzd.zzb(zzgqo.zzf()));
        return (zzguk) zzd2.zzbr();
    }
}
