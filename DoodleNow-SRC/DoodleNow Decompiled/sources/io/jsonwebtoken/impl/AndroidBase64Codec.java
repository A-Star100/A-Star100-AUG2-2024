package io.jsonwebtoken.impl;

import android.util.Base64;

public class AndroidBase64Codec extends AbstractTextCodec {
    public String encode(byte[] bArr) {
        return Base64.encodeToString(bArr, 3);
    }

    public byte[] decode(String str) {
        return Base64.decode(str, 0);
    }
}
