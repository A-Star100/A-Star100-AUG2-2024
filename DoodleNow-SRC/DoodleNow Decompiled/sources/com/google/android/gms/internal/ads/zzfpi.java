package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfpi {
    protected static final byte[] zza = {Base64.padSymbol, 122, Ascii.DC2, 35, 1, -102, -93, -99, -98, -96, -29, 67, 106, -73, -64, -119, 107, -5, 79, -74, 121, -12, -34, 95, -25, -62, Utf8.REPLACEMENT_BYTE, 50, 108, -113, -103, 74};
    protected static final byte[] zzb = {-110, -13, -34, 70, -83, 43, 97, Ascii.NAK, -44, Ascii.DLE, -54, -125, -28, -57, -125, -127, -7, 17, 102, -69, 116, -121, -79, 43, -13, 120, 58, 55, -29, -108, 95, 83};
    private final byte[] zzc = zzb;
    private final byte[] zzd = zza;

    public final boolean zza(File file) throws GeneralSecurityException {
        try {
            X509Certificate[][] zza2 = zzapw.zza(file.getAbsolutePath());
            if (zza2.length == 1) {
                byte[] digest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(zza2[0][0].getEncoded());
                if (Arrays.equals(this.zzd, digest)) {
                    return true;
                }
                if (!"user".equals(Build.TYPE)) {
                    return Arrays.equals(this.zzc, digest);
                }
                return false;
            }
            throw new GeneralSecurityException("APK has more than one signature.");
        } catch (zzapt e) {
            throw new GeneralSecurityException("Package is not signed", e);
        } catch (IOException | RuntimeException e2) {
            throw new GeneralSecurityException("Failed to verify signatures", e2);
        }
    }
}
