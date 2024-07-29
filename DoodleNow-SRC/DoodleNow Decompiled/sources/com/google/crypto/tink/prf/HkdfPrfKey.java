package com.google.crypto.tink.prf;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

@Immutable
public final class HkdfPrfKey extends PrfKey {
    private final SecretBytes keyBytes;
    private final HkdfPrfParameters parameters;

    @Nullable
    public Integer getIdRequirementOrNull() {
        return null;
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    public HkdfPrfParameters getParameters() {
        return this.parameters;
    }

    public static final class Builder {
        @Nullable
        private SecretBytes keyBytes;
        @Nullable
        private HkdfPrfParameters parameters;

        public Builder setKeyBytes(SecretBytes secretBytes) {
            this.keyBytes = secretBytes;
            return this;
        }

        public Builder setParameters(HkdfPrfParameters hkdfPrfParameters) {
            this.parameters = hkdfPrfParameters;
            return this;
        }

        private Builder() {
            this.parameters = null;
            this.keyBytes = null;
        }

        public HkdfPrfKey build() throws GeneralSecurityException {
            HkdfPrfParameters hkdfPrfParameters = this.parameters;
            if (hkdfPrfParameters == null || this.keyBytes == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            } else if (hkdfPrfParameters.getKeySizeBytes() == this.keyBytes.size()) {
                return new HkdfPrfKey(this.parameters, this.keyBytes);
            } else {
                throw new GeneralSecurityException("Key size mismatch");
            }
        }
    }

    private HkdfPrfKey(HkdfPrfParameters hkdfPrfParameters, SecretBytes secretBytes) {
        this.parameters = hkdfPrfParameters;
        this.keyBytes = secretBytes;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equalsKey(Key key) {
        if (!(key instanceof HkdfPrfKey)) {
            return false;
        }
        HkdfPrfKey hkdfPrfKey = (HkdfPrfKey) key;
        if (!hkdfPrfKey.parameters.equals(this.parameters) || !hkdfPrfKey.keyBytes.equalsSecretBytes(this.keyBytes)) {
            return false;
        }
        return true;
    }
}
