package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.aead.XChaCha20Poly1305Parameters;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

@Immutable
public final class XChaCha20Poly1305Key extends AeadKey {
    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final Bytes outputPrefix;
    private final XChaCha20Poly1305Parameters parameters;

    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    public XChaCha20Poly1305Parameters getParameters() {
        return this.parameters;
    }

    private XChaCha20Poly1305Key(XChaCha20Poly1305Parameters xChaCha20Poly1305Parameters, SecretBytes secretBytes, Bytes bytes, @Nullable Integer num) {
        this.parameters = xChaCha20Poly1305Parameters;
        this.keyBytes = secretBytes;
        this.outputPrefix = bytes;
        this.idRequirement = num;
    }

    private static Bytes getOutputPrefix(XChaCha20Poly1305Parameters xChaCha20Poly1305Parameters, @Nullable Integer num) {
        if (xChaCha20Poly1305Parameters.getVariant() == XChaCha20Poly1305Parameters.Variant.NO_PREFIX) {
            return Bytes.copyFrom(new byte[0]);
        }
        if (xChaCha20Poly1305Parameters.getVariant() == XChaCha20Poly1305Parameters.Variant.CRUNCHY) {
            return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        }
        if (xChaCha20Poly1305Parameters.getVariant() == XChaCha20Poly1305Parameters.Variant.TINK) {
            return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        throw new IllegalStateException("Unknown Variant: " + xChaCha20Poly1305Parameters.getVariant());
    }

    public static XChaCha20Poly1305Key create(SecretBytes secretBytes) throws GeneralSecurityException {
        return create(XChaCha20Poly1305Parameters.Variant.NO_PREFIX, secretBytes, (Integer) null);
    }

    public static XChaCha20Poly1305Key create(XChaCha20Poly1305Parameters.Variant variant, SecretBytes secretBytes, @Nullable Integer num) throws GeneralSecurityException {
        if (variant != XChaCha20Poly1305Parameters.Variant.NO_PREFIX && num == null) {
            throw new GeneralSecurityException("For given Variant " + variant + " the value of idRequirement must be non-null");
        } else if (variant == XChaCha20Poly1305Parameters.Variant.NO_PREFIX && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (secretBytes.size() == 32) {
            XChaCha20Poly1305Parameters create = XChaCha20Poly1305Parameters.create(variant);
            return new XChaCha20Poly1305Key(create, secretBytes, getOutputPrefix(create, num), num);
        } else {
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + secretBytes.size());
        }
    }

    public boolean equalsKey(Key key) {
        if (!(key instanceof XChaCha20Poly1305Key)) {
            return false;
        }
        XChaCha20Poly1305Key xChaCha20Poly1305Key = (XChaCha20Poly1305Key) key;
        if (!xChaCha20Poly1305Key.parameters.equals(this.parameters) || !xChaCha20Poly1305Key.keyBytes.equalsSecretBytes(this.keyBytes) || !Objects.equals(xChaCha20Poly1305Key.idRequirement, this.idRequirement)) {
            return false;
        }
        return true;
    }
}
