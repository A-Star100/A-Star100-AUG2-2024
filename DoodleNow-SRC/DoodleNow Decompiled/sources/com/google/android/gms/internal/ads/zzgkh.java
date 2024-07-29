package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgkh {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxm zzb;
    private static final zzgoc zzc = zzgoc.zzb(zzgkd.zza, zzgkc.class, zzgou.class);
    private static final zzgny zzd;
    private static final zzgna zze = zzgna.zzb(zzgkf.zza, zzgjx.class, zzgot.class);
    private static final zzgmw zzf;

    static {
        zzgxm zza2 = zzgpi.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzb = zza2;
        zzd = zzgny.zzb(zzgke.zza, zza2, zzgou.class);
        zzf = zzgmw.zzb(zzgkg.zza, zza2, zzgot.class);
    }

    public static /* synthetic */ zzgjx zza(zzgot zzgot, zzggn zzggn) {
        if (zzgot.zzg().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                zzgvq zze2 = zzgvq.zze(zzgot.zze(), zzgzf.zza());
                if (zzgot.zzc() != zzgvv.RAW) {
                    String valueOf = String.valueOf(zze2);
                    throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with OutputPrefixType RAW, got " + valueOf);
                } else if (zze2.zza() == 0) {
                    return zzgjx.zza(zzf(zze2.zzf()));
                } else {
                    String valueOf2 = String.valueOf(zze2);
                    throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got " + valueOf2);
                }
            } catch (zzhak e) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgkc zzb(zzgou zzgou) {
        if (zzgou.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                return zzf(zzgvt.zzf(zzgou.zzc().zzh(), zzgzf.zza()));
            } catch (zzhak e) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgou.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgot zzc(zzgjx zzgjx, zzggn zzggn) {
        zzgvp zzc2 = zzgvq.zzc();
        zzc2.zza(zzg(zzgjx.zzb()));
        return zzgot.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", ((zzgvq) zzc2.zzbr()).zzaN(), zzguo.REMOTE, zzgvv.RAW, (Integer) null);
    }

    public static /* synthetic */ zzgou zzd(zzgkc zzgkc) {
        zzgut zza2 = zzguu.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zza2.zzc(zzg(zzgkc).zzaN());
        zza2.zza(zzgvv.RAW);
        return zzgou.zzb((zzguu) zza2.zzbr());
    }

    public static void zze(zzgnu zzgnu) throws GeneralSecurityException {
        zzgnu.zzi(zzc);
        zzgnu.zzh(zzd);
        zzgnu.zzg(zze);
        zzgnu.zzf(zzf);
    }

    private static zzgkc zzf(zzgvt zzgvt) throws GeneralSecurityException {
        zzgka zzgka;
        zzgut zza2 = zzguu.zza();
        zza2.zzb(zzgvt.zza().zzi());
        zza2.zzc(zzgvt.zza().zzh());
        zza2.zza(zzgvv.RAW);
        zzggi zza3 = zzggp.zza(((zzguu) zza2.zzbr()).zzaV());
        if (zza3 instanceof zzgik) {
            zzgka = zzgka.zza;
        } else if (zza3 instanceof zzgjd) {
            zzgka = zzgka.zzc;
        } else if (zza3 instanceof zzgkv) {
            zzgka = zzgka.zzb;
        } else if (zza3 instanceof zzghl) {
            zzgka = zzgka.zzd;
        } else if (zza3 instanceof zzghx) {
            zzgka = zzgka.zze;
        } else if (zza3 instanceof zzgix) {
            zzgka = zzgka.zzf;
        } else {
            throw new GeneralSecurityException("Unsupported DEK parameters when parsing ".concat(zza3.toString()));
        }
        zzgjz zzgjz = new zzgjz((zzgjy) null);
        zzgjz.zzc(zzgvt.zzg());
        zzgjz.zza((zzggt) zza3);
        zzgjz.zzb(zzgka);
        return zzgjz.zzd();
    }

    private static zzgvt zzg(zzgkc zzgkc) throws GeneralSecurityException {
        try {
            zzguu zzf2 = zzguu.zzf(zzggp.zzb(zzgkc.zzb()), zzgzf.zza());
            zzgvs zzc2 = zzgvt.zzc();
            zzc2.zzb(zzgkc.zzc());
            zzc2.zza(zzf2);
            return (zzgvt) zzc2.zzbr();
        } catch (zzhak e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }
}
