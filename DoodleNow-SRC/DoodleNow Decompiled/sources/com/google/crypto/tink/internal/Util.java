package com.google.crypto.tink.internal;

import com.google.common.base.Ascii;
import com.google.crypto.tink.util.Bytes;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Objects;
import javax.annotation.Nullable;

public final class Util {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static int randKeyId() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        byte b = 0;
        while (b == 0) {
            secureRandom.nextBytes(bArr);
            b = ((bArr[0] & Byte.MAX_VALUE) << Ascii.CAN) | ((bArr[1] & 255) << Ascii.DLE) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return b;
    }

    private static final byte toByteFromPrintableAscii(char c) {
        if (c >= '!' && c <= '~') {
            return (byte) c;
        }
        throw new TinkBugException("Not a printable ASCII character: " + c);
    }

    public static final Bytes toBytesFromPrintableAscii(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            bArr[i] = toByteFromPrintableAscii(str.charAt(i));
        }
        return Bytes.copyFrom(bArr);
    }

    public static boolean isAndroid() {
        return Objects.equals(System.getProperty("java.vendor"), "The Android Project");
    }

    @Nullable
    public static Integer getAndroidApiLevel() {
        if (!isAndroid()) {
            return null;
        }
        return BuildDispatchedCode.getApiLevel();
    }

    private Util() {
    }
}
