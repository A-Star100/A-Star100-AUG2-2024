package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.aead.ChaCha20Poly1305Parameters;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

@Immutable
public final class ChaCha20Poly1305Key extends AeadKey {
    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final Bytes outputPrefix;
    private final ChaCha20Poly1305Parameters parameters;

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

    public ChaCha20Poly1305Parameters getParameters() {
        return this.parameters;
    }

    private ChaCha20Poly1305Key(ChaCha20Poly1305Parameters chaCha20Poly1305Parameters, SecretBytes secretBytes, Bytes bytes, @Nullable Integer num) {
        this.parameters = chaCha20Poly1305Parameters;
        this.keyBytes = secretBytes;
        this.outputPrefix = bytes;
        this.idRequirement = num;
    }

    private static Bytes getOutputPrefix(ChaCha20Poly1305Parameters chaCha20Poly1305Parameters, @Nullable Integer num) {
        if (chaCha20Poly1305Parameters.getVariant() == ChaCha20Poly1305Parameters.Variant.NO_PREFIX) {
            return Bytes.copyFrom(new byte[0]);
        }
        if (chaCha20Poly1305Parameters.getVariant() == ChaCha20Poly1305Parameters.Variant.CRUNCHY) {
            return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        }
        if (chaCha20Poly1305Parameters.getVariant() == ChaCha20Poly1305Parameters.Variant.TINK) {
            return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        throw new IllegalStateException("Unknown Variant: " + chaCha20Poly1305Parameters.getVariant());
    }

    public static ChaCha20Poly1305Key create(SecretBytes secretBytes) throws GeneralSecurityException {
        return create(ChaCha20Poly1305Parameters.Variant.NO_PREFIX, secretBytes, (Integer) null);
    }

    public static ChaCha20Poly1305Key create(ChaCha20Poly1305Parameters.Variant variant, SecretBytes secretBytes, @Nullable Integer num) throws GeneralSecurityException {
        if (variant != ChaCha20Poly1305Parameters.Variant.NO_PREFIX && num == null) {
            throw new GeneralSecurityException("For given Variant " + variant + " the value of idRequirement must be non-null");
        } else if (variant == ChaCha20Poly1305Parameters.Variant.NO_PREFIX && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (secretBytes.size() == 32) {
            ChaCha20Poly1305Parameters create = ChaCha20Poly1305Parameters.create(variant);
            return new ChaCha20Poly1305Key(create, secretBytes, getOutputPrefix(create, num), num);
        } else {
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + secretBytes.size());
        }
    }

    public boolean equalsKey(Key key) {
        if (!(key instanceof ChaCha20Poly1305Key)) {
            return false;
        }
        ChaCha20Poly1305Key chaCha20Poly1305Key = (ChaCha20Poly1305Key) key;
        if (!chaCha20Poly1305Key.parameters.equals(this.parameters) || !chaCha20Poly1305Key.keyBytes.equalsSecretBytes(this.keyBytes) || !Objects.equals(chaCha20Poly1305Key.idRequirement, this.idRequirement)) {
            return false;
        }
        return true;
    }
}
