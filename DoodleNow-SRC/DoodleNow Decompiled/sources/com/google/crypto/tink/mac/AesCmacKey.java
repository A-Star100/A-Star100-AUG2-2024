package com.google.crypto.tink.mac;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.mac.AesCmacParameters;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

@Immutable
public final class AesCmacKey extends MacKey {
    private final SecretBytes aesKeyBytes;
    @Nullable
    private final Integer idRequirement;
    private final Bytes outputPrefix;
    private final AesCmacParameters parameters;

    public SecretBytes getAesKey() {
        return this.aesKeyBytes;
    }

    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    public AesCmacParameters getParameters() {
        return this.parameters;
    }

    public static class Builder {
        @Nullable
        private SecretBytes aesKeyBytes;
        @Nullable
        private Integer idRequirement;
        @Nullable
        private AesCmacParameters parameters;

        public Builder setAesKeyBytes(SecretBytes secretBytes) throws GeneralSecurityException {
            this.aesKeyBytes = secretBytes;
            return this;
        }

        public Builder setIdRequirement(@Nullable Integer num) {
            this.idRequirement = num;
            return this;
        }

        public Builder setParameters(AesCmacParameters aesCmacParameters) {
            this.parameters = aesCmacParameters;
            return this;
        }

        private Builder() {
            this.parameters = null;
            this.aesKeyBytes = null;
            this.idRequirement = null;
        }

        private Bytes getOutputPrefix() {
            if (this.parameters.getVariant() == AesCmacParameters.Variant.NO_PREFIX) {
                return Bytes.copyFrom(new byte[0]);
            }
            if (this.parameters.getVariant() == AesCmacParameters.Variant.LEGACY || this.parameters.getVariant() == AesCmacParameters.Variant.CRUNCHY) {
                return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(this.idRequirement.intValue()).array());
            }
            if (this.parameters.getVariant() == AesCmacParameters.Variant.TINK) {
                return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(this.idRequirement.intValue()).array());
            }
            throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: " + this.parameters.getVariant());
        }

        public AesCmacKey build() throws GeneralSecurityException {
            AesCmacParameters aesCmacParameters = this.parameters;
            if (aesCmacParameters == null || this.aesKeyBytes == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            } else if (aesCmacParameters.getKeySizeBytes() != this.aesKeyBytes.size()) {
                throw new GeneralSecurityException("Key size mismatch");
            } else if (this.parameters.hasIdRequirement() && this.idRequirement == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.parameters.hasIdRequirement() || this.idRequirement == null) {
                return new AesCmacKey(this.parameters, this.aesKeyBytes, getOutputPrefix(), this.idRequirement);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        }
    }

    private AesCmacKey(AesCmacParameters aesCmacParameters, SecretBytes secretBytes, Bytes bytes, @Nullable Integer num) {
        this.parameters = aesCmacParameters;
        this.aesKeyBytes = secretBytes;
        this.outputPrefix = bytes;
        this.idRequirement = num;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equalsKey(Key key) {
        if (!(key instanceof AesCmacKey)) {
            return false;
        }
        AesCmacKey aesCmacKey = (AesCmacKey) key;
        if (!aesCmacKey.parameters.equals(this.parameters) || !aesCmacKey.aesKeyBytes.equalsSecretBytes(this.aesKeyBytes) || !Objects.equals(aesCmacKey.idRequirement, this.idRequirement)) {
            return false;
        }
        return true;
    }
}
