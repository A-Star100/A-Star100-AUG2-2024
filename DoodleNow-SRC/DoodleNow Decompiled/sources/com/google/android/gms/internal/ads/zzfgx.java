package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfgx {
    public zzfgx() {
        try {
            zzggr.zza();
        } catch (GeneralSecurityException e) {
            zze.zza("Failed to Configure Aead. ".concat(e.toString()));
            zzu.zzo().zzw(e, "CryptoUtils.registerAead");
        }
    }

    public static final String zza() {
        zzgyg zzt = zzgyj.zzt();
        try {
            zzgfm.zzb(zzgge.zzb(zzgfw.zza(zzgnq.zzb().zza("AES128_GCM"))), zzgfl.zzb(zzt));
        } catch (IOException | GeneralSecurityException e) {
            zze.zza("Failed to generate key".concat(e.toString()));
            zzu.zzo().zzw(e, "CryptoUtils.generateKey");
        }
        String encodeToString = Base64.encodeToString(zzt.zzb().zzB(), 11);
        zzt.zzc();
        return encodeToString;
    }

    @Nullable
    public static final String zzb(byte[] bArr, byte[] bArr2, String str, zzduc zzduc) {
        zzgge zzc = zzc(str);
        if (zzc == null) {
            return null;
        }
        try {
            byte[] zza = ((zzgfj) zzc.zzd(zzgox.zza(), zzgfj.class)).zza(bArr, bArr2);
            zzduc.zzb().put("ds", "1");
            return new String(zza, "UTF-8");
        } catch (UnsupportedEncodingException | UnsupportedOperationException | GeneralSecurityException e) {
            zze.zza("Failed to decrypt ".concat(e.toString()));
            zzu.zzo().zzw(e, "CryptoUtils.decrypt");
            zzduc.zzb().put("dsf", e.toString());
            return null;
        }
    }

    @Nullable
    private static final zzgge zzc(String str) {
        try {
            return zzgfm.zza(zzgfk.zzb(Base64.decode(str, 11)));
        } catch (IOException | GeneralSecurityException e) {
            zze.zza("Failed to get keysethandle".concat(e.toString()));
            zzu.zzo().zzw(e, "CryptoUtils.getHandle");
            return null;
        }
    }
}
