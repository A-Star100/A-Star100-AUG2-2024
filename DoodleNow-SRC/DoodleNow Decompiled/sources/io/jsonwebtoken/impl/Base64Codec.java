package io.jsonwebtoken.impl;

import javax.xml.bind.DatatypeConverter;

public class Base64Codec extends AbstractTextCodec {
    public String encode(byte[] bArr) {
        return DatatypeConverter.printBase64Binary(bArr);
    }

    public byte[] decode(String str) {
        return DatatypeConverter.parseBase64Binary(str);
    }
}
