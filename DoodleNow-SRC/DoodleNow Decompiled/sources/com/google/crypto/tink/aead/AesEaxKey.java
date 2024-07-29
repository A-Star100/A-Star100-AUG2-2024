package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.aead.AesEaxParameters;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

@Immutable
public final class AesEaxKey extends AeadKey {
    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final Bytes outputPrefix;
    private final AesEaxParameters parameters;

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

    public AesEaxParameters getParameters() {
        return this.parameters;
    }

    public static class Builder {
        @Nullable
        private Integer idRequirement;
        @Nullable
        private SecretBytes keyBytes;
        @Nullable
        private AesEaxParameters parameters;

        public Builder setIdRequirement(@Nullable Integer num) {
            this.idRequirement = num;
            return this;
        }

        public Builder setKeyBytes(SecretBytes secretBytes) {
            this.keyBytes = secretBytes;
            return this;
        }

        public Builder setParameters(AesEaxParameters aesEaxParameters) {
            this.parameters = aesEaxParameters;
            return this;
        }

        private Builder() {
            this.parameters = null;
            this.keyBytes = null;
            this.idRequirement = null;
        }

        private Bytes getOutputPrefix() {
            if (this.parameters.getVariant() == AesEaxParameters.Variant.NO_PREFIX) {
                return Bytes.copyFrom(new byte[0]);
            }
            if (this.parameters.getVariant() == AesEaxParameters.Variant.CRUNCHY) {
                return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(this.idRequirement.intValue()).array());
            }
            if (this.parameters.getVariant() == AesEaxParameters.Variant.TINK) {
                return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(this.idRequirement.intValue()).array());
            }
            throw new IllegalStateException("Unknown AesEaxParameters.Variant: " + this.parameters.getVariant());
        }

        public AesEaxKey build() throws GeneralSecurityException {
            AesEaxParameters aesEaxParameters = this.parameters;
            if (aesEaxParameters == null || this.keyBytes == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            } else if (aesEaxParameters.getKeySizeBytes() != this.keyBytes.size()) {
                throw new GeneralSecurityException("Key size mismatch");
            } else if (this.parameters.hasIdRequirement() && this.idRequirement == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.parameters.hasIdRequirement() || this.idRequirement == null) {
                return new AesEaxKey(this.parameters, this.keyBytes, getOutputPrefix(), this.idRequirement);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        }
    }

    private AesEaxKey(AesEaxParameters aesEaxParameters, SecretBytes secretBytes, Bytes bytes, @Nullable Integer num) {
        this.parameters = aesEaxParameters;
        this.keyBytes = secretBytes;
        this.outputPrefix = bytes;
        this.idRequirement = num;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equalsKey(Key key) {
        if (!(key instanceof AesEaxKey)) {
            return false;
        }
        AesEaxKey aesEaxKey = (AesEaxKey) key;
        if (!aesEaxKey.parameters.equals(this.parameters) || !aesEaxKey.keyBytes.equalsSecretBytes(this.keyBytes) || !Objects.equals(aesEaxKey.idRequirement, this.idRequirement)) {
            return false;
        }
        return true;
    }
}
