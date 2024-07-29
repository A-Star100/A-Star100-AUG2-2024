package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.mac.AesCmacKey;
import com.google.crypto.tink.mac.AesCmacParameters;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EngineFactory;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

final class ChunkedAesCmacComputation implements ChunkedMacComputation {
    private static final byte[] FORMAT_VERSION = {0};
    private final Cipher aes;
    private boolean finalized = false;
    private final AesCmacKey key;
    private final ByteBuffer localStash;
    private final byte[] subKey1;
    private final byte[] subKey2;
    private final ByteBuffer x;
    private final ByteBuffer y;

    ChunkedAesCmacComputation(AesCmacKey aesCmacKey) throws GeneralSecurityException {
        this.key = aesCmacKey;
        Cipher instance = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        this.aes = instance;
        instance.init(1, new SecretKeySpec(aesCmacKey.getAesKey().toByteArray(InsecureSecretKeyAccess.get()), "AES"));
        byte[] dbl = AesUtil.dbl(instance.doFinal(new byte[16]));
        this.subKey1 = dbl;
        this.subKey2 = AesUtil.dbl(dbl);
        this.localStash = ByteBuffer.allocate(16);
        this.x = ByteBuffer.allocate(16);
        this.y = ByteBuffer.allocate(16);
    }

    private void munch(ByteBuffer byteBuffer) throws GeneralSecurityException {
        this.y.rewind();
        this.x.rewind();
        Bytes.xor(this.y, this.x, byteBuffer, 16);
        this.y.rewind();
        this.x.rewind();
        this.aes.doFinal(this.y, this.x);
    }

    public void update(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (!this.finalized) {
            if (this.localStash.remaining() != 16) {
                int min = Math.min(this.localStash.remaining(), byteBuffer.remaining());
                for (int i = 0; i < min; i++) {
                    this.localStash.put(byteBuffer.get());
                }
            }
            if (this.localStash.remaining() == 0 && byteBuffer.remaining() > 0) {
                this.localStash.rewind();
                munch(this.localStash);
                this.localStash.rewind();
            }
            while (byteBuffer.remaining() > 16) {
                munch(byteBuffer);
            }
            this.localStash.put(byteBuffer);
            return;
        }
        throw new IllegalStateException("Can not update after computing the MAC tag. Please create a new object.");
    }

    public byte[] computeMac() throws GeneralSecurityException {
        byte[] bArr;
        if (!this.finalized) {
            if (this.key.getParameters().getVariant() == AesCmacParameters.Variant.LEGACY) {
                update(ByteBuffer.wrap(FORMAT_VERSION));
            }
            this.finalized = true;
            if (this.localStash.remaining() > 0) {
                bArr = Bytes.xor(AesUtil.cmacPad(Arrays.copyOf(this.localStash.array(), this.localStash.position())), this.subKey2);
            } else {
                bArr = Bytes.xor(this.localStash.array(), 0, this.subKey1, 0, 16);
            }
            return Bytes.concat(this.key.getOutputPrefix().toByteArray(), Arrays.copyOf(this.aes.doFinal(Bytes.xor(bArr, this.x.array())), this.key.getParameters().getCryptographicTagSizeBytes()));
        }
        throw new IllegalStateException("Can not compute after computing the MAC tag. Please create a new object.");
    }
}
