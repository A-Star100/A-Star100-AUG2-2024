package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.mac.HmacKey;
import com.google.crypto.tink.mac.HmacParameters;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EngineFactory;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

final class ChunkedHmacComputation implements ChunkedMacComputation {
    private static final byte[] FORMAT_VERSION = {0};
    private boolean finalized = false;
    private final HmacKey key;
    private final Mac mac;

    ChunkedHmacComputation(HmacKey hmacKey) throws GeneralSecurityException {
        Mac instance = EngineFactory.MAC.getInstance(composeAlgorithmName(hmacKey));
        this.mac = instance;
        instance.init(new SecretKeySpec(hmacKey.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), "HMAC"));
        this.key = hmacKey;
    }

    public void update(ByteBuffer byteBuffer) {
        if (!this.finalized) {
            this.mac.update(byteBuffer);
            return;
        }
        throw new IllegalStateException("Cannot update after computing the MAC tag. Please create a new object.");
    }

    public byte[] computeMac() throws GeneralSecurityException {
        if (!this.finalized) {
            if (this.key.getParameters().getVariant() == HmacParameters.Variant.LEGACY) {
                update(ByteBuffer.wrap(FORMAT_VERSION));
            }
            this.finalized = true;
            return Bytes.concat(this.key.getOutputPrefix().toByteArray(), Arrays.copyOf(this.mac.doFinal(), this.key.getParameters().getCryptographicTagSizeBytes()));
        }
        throw new IllegalStateException("Cannot compute after already computing the MAC tag. Please create a new object.");
    }

    private static String composeAlgorithmName(HmacKey hmacKey) {
        return "HMAC" + hmacKey.getParameters().getHashType();
    }
}
