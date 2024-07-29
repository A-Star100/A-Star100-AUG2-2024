package com.google.crypto.tink.aead;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

public final class AesGcmSivParameters extends AeadParameters {
    private final int keySizeBytes;
    private final Variant variant;

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    public Variant getVariant() {
        return this.variant;
    }

    @Immutable
    public static final class Variant {
        public static final Variant CRUNCHY = new Variant("CRUNCHY");
        public static final Variant NO_PREFIX = new Variant("NO_PREFIX");
        public static final Variant TINK = new Variant("TINK");
        private final String name;

        public String toString() {
            return this.name;
        }

        private Variant(String str) {
            this.name = str;
        }
    }

    public static final class Builder {
        @Nullable
        private Integer keySizeBytes;
        private Variant variant;

        public Builder setVariant(Variant variant2) {
            this.variant = variant2;
            return this;
        }

        private Builder() {
            this.keySizeBytes = null;
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setKeySizeBytes(int i) throws GeneralSecurityException {
            if (i == 16 || i == 32) {
                this.keySizeBytes = Integer.valueOf(i);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
        }

        public AesGcmSivParameters build() throws GeneralSecurityException {
            Integer num = this.keySizeBytes;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            } else if (this.variant != null) {
                return new AesGcmSivParameters(num.intValue(), this.variant);
            } else {
                throw new GeneralSecurityException("Variant is not set");
            }
        }
    }

    private AesGcmSivParameters(int i, Variant variant2) {
        this.keySizeBytes = i;
        this.variant = variant2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AesGcmSivParameters)) {
            return false;
        }
        AesGcmSivParameters aesGcmSivParameters = (AesGcmSivParameters) obj;
        if (aesGcmSivParameters.getKeySizeBytes() == getKeySizeBytes() && aesGcmSivParameters.getVariant() == getVariant()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.keySizeBytes), this.variant});
    }

    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public String toString() {
        return "AesGcmSiv Parameters (variant: " + this.variant + ", " + this.keySizeBytes + "-byte key)";
    }
}
