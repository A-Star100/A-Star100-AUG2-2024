package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureException;

public interface Signer {
    byte[] sign(byte[] bArr) throws SignatureException;
}
