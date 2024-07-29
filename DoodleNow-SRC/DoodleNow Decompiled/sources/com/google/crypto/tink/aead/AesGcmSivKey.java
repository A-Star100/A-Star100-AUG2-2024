package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.aead.AesGcmSivParameters;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

@Immutable
public final class AesGcmSivKey extends AeadKey {
    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final Bytes outputPrefix;
    private final AesGcmSivParameters parameters;

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

    public AesGcmSivParameters getParameters() {
        return this.parameters;
    }

    public static class Builder {
        @Nullable
        private Integer idRequirement;
        @Nullable
        private SecretBytes keyBytes;
        @Nullable
        private AesGcmSivParameters parameters;

        public Builder setIdRequirement(@Nullable Integer num) {
            this.idRequirement = num;
            return this;
        }

        public Builder setKeyBytes(SecretBytes secretBytes) {
            this.keyBytes = secretBytes;
            return this;
        }

        public Builder setParameters(AesGcmSivParameters aesGcmSivParameters) {
            this.parameters = aesGcmSivParameters;
            return this;
        }

        private Builder() {
            this.parameters = null;
            this.keyBytes = null;
            this.idRequirement = null;
        }

        private Bytes getOutputPrefix() {
            if (this.parameters.getVariant() == AesGcmSivParameters.Variant.NO_PREFIX) {
                return Bytes.copyFrom(new byte[0]);
            }
            if (this.parameters.getVariant() == AesGcmSivParameters.Variant.CRUNCHY) {
                return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(this.idRequirement.intValue()).array());
            }
            if (this.parameters.getVariant() == AesGcmSivParameters.Variant.TINK) {
                return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(this.idRequirement.intValue()).array());
            }
            throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: " + this.parameters.getVariant());
        }

        public AesGcmSivKey build() throws GeneralSecurityException {
            AesGcmSivParameters aesGcmSivParameters = this.parameters;
            if (aesGcmSivParameters == null || this.keyBytes == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            } else if (aesGcmSivParameters.getKeySizeBytes() != this.keyBytes.size()) {
                throw new GeneralSecurityException("Key size mismatch");
            } else if (this.parameters.hasIdRequirement() && this.idRequirement == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.parameters.hasIdRequirement() || this.idRequirement == null) {
                return new AesGcmSivKey(this.parameters, this.keyBytes, getOutputPrefix(), this.idRequirement);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        }
    }

    private AesGcmSivKey(AesGcmSivParameters aesGcmSivParameters, SecretBytes secretBytes, Bytes bytes, @Nullable Integer num) {
        this.parameters = aesGcmSivParameters;
        this.keyBytes = secretBytes;
        this.outputPrefix = bytes;
        this.idRequirement = num;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equalsKey(Key key) {
        if (!(key instanceof AesGcmSivKey)) {
            return false;
        }
        AesGcmSivKey aesGcmSivKey = (AesGcmSivKey) key;
        if (!aesGcmSivKey.parameters.equals(this.parameters) || !aesGcmSivKey.keyBytes.equalsSecretBytes(this.keyBytes) || !Objects.equals(aesGcmSivKey.idRequirement, this.idRequirement)) {
            return false;
        }
        return true;
    }
}
