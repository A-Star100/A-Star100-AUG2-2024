package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.HpkeAead;
import com.google.crypto.tink.proto.HpkeKdf;
import com.google.crypto.tink.proto.HpkeKem;
import com.google.crypto.tink.proto.HpkeParams;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.security.GeneralSecurityException;

public final class HpkeUtil {
    public static final byte[] AES_128_GCM_AEAD_ID = intToByteArray(2, 1);
    public static final byte[] AES_256_GCM_AEAD_ID = intToByteArray(2, 2);
    public static final byte[] BASE_MODE = intToByteArray(1, 0);
    public static final byte[] CHACHA20_POLY1305_AEAD_ID = intToByteArray(2, 3);
    public static final byte[] EMPTY_SALT = new byte[0];
    public static final byte[] HKDF_SHA256_KDF_ID = intToByteArray(2, 1);
    public static final byte[] HKDF_SHA384_KDF_ID = intToByteArray(2, 2);
    public static final byte[] HKDF_SHA512_KDF_ID = intToByteArray(2, 3);
    private static final byte[] HPKE = "HPKE".getBytes(Util.UTF_8);
    private static final byte[] HPKE_V1 = "HPKE-v1".getBytes(Util.UTF_8);
    private static final byte[] KEM = "KEM".getBytes(Util.UTF_8);
    public static final byte[] P256_HKDF_SHA256_KEM_ID = intToByteArray(2, 16);
    public static final byte[] P384_HKDF_SHA384_KEM_ID = intToByteArray(2, 17);
    public static final byte[] P521_HKDF_SHA512_KEM_ID = intToByteArray(2, 18);
    public static final byte[] X25519_HKDF_SHA256_KEM_ID = intToByteArray(2, 32);

    public static byte[] intToByteArray(int i, int i2) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((i2 >> (((i - i3) - 1) * 8)) & 255);
        }
        return bArr;
    }

    static byte[] kemSuiteId(byte[] bArr) throws GeneralSecurityException {
        return Bytes.concat(KEM, bArr);
    }

    static byte[] hpkeSuiteId(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return Bytes.concat(HPKE, bArr, bArr2, bArr3);
    }

    static byte[] labelIkm(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return Bytes.concat(HPKE_V1, bArr2, str.getBytes(Util.UTF_8), bArr);
    }

    static byte[] labelInfo(String str, byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        return Bytes.concat(intToByteArray(2, i), HPKE_V1, bArr2, str.getBytes(Util.UTF_8), bArr);
    }

    static void validateParams(HpkeParams hpkeParams) throws GeneralSecurityException {
        if (hpkeParams.getKem() == HpkeKem.KEM_UNKNOWN || hpkeParams.getKem() == HpkeKem.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid KEM param: " + hpkeParams.getKem().name());
        } else if (hpkeParams.getKdf() == HpkeKdf.KDF_UNKNOWN || hpkeParams.getKdf() == HpkeKdf.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid KDF param: " + hpkeParams.getKdf().name());
        } else if (hpkeParams.getAead() == HpkeAead.AEAD_UNKNOWN || hpkeParams.getAead() == HpkeAead.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid AEAD param: " + hpkeParams.getAead().name());
        }
    }

    /* renamed from: com.google.crypto.tink.hybrid.internal.HpkeUtil$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HpkeKem;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.crypto.tink.proto.HpkeKem[] r0 = com.google.crypto.tink.proto.HpkeKem.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem = r0
                com.google.crypto.tink.proto.HpkeKem r1 = com.google.crypto.tink.proto.HpkeKem.DHKEM_P256_HKDF_SHA256     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$HpkeKem     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.proto.HpkeKem r1 = com.google.crypto.tink.proto.HpkeKem.DHKEM_P384_HKDF_SHA384     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$HpkeKem     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.proto.HpkeKem r1 = com.google.crypto.tink.proto.HpkeKem.DHKEM_P521_HKDF_SHA512     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.hybrid.internal.HpkeUtil.AnonymousClass1.<clinit>():void");
        }
    }

    static EllipticCurves.CurveType nistHpkeKemToCurve(HpkeKem hpkeKem) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$HpkeKem[hpkeKem.ordinal()];
        if (i == 1) {
            return EllipticCurves.CurveType.NIST_P256;
        }
        if (i == 2) {
            return EllipticCurves.CurveType.NIST_P384;
        }
        if (i == 3) {
            return EllipticCurves.CurveType.NIST_P521;
        }
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }

    private HpkeUtil() {
    }
}
