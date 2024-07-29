package com.google.crypto.tink.aead;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

public final class AesEaxParameters extends AeadParameters {
    private final int ivSizeBytes;
    private final int keySizeBytes;
    private final int tagSizeBytes;
    private final Variant variant;

    public int getIvSizeBytes() {
        return this.ivSizeBytes;
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    public int getTagSizeBytes() {
        return this.tagSizeBytes;
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
        private Integer ivSizeBytes;
        @Nullable
        private Integer keySizeBytes;
        @Nullable
        private Integer tagSizeBytes;
        private Variant variant;

        public Builder setVariant(Variant variant2) {
            this.variant = variant2;
            return this;
        }

        private Builder() {
            this.keySizeBytes = null;
            this.ivSizeBytes = null;
            this.tagSizeBytes = null;
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setKeySizeBytes(int i) throws GeneralSecurityException {
            if (i == 16 || i == 24 || i == 32) {
                this.keySizeBytes = Integer.valueOf(i);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
        }

        public Builder setIvSizeBytes(int i) throws GeneralSecurityException {
            if (i == 12 || i == 16) {
                this.ivSizeBytes = Integer.valueOf(i);
                return this;
            }
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", new Object[]{Integer.valueOf(i)}));
        }

        public Builder setTagSizeBytes(int i) throws GeneralSecurityException {
            if (i < 0 || i > 16) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; value must be at most 16 bytes", new Object[]{Integer.valueOf(i)}));
            }
            this.tagSizeBytes = Integer.valueOf(i);
            return this;
        }

        public AesEaxParameters build() throws GeneralSecurityException {
            Integer num = this.keySizeBytes;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            } else if (this.ivSizeBytes == null) {
                throw new GeneralSecurityException("IV size is not set");
            } else if (this.variant == null) {
                throw new GeneralSecurityException("Variant is not set");
            } else if (this.tagSizeBytes != null) {
                return new AesEaxParameters(num.intValue(), this.ivSizeBytes.intValue(), this.tagSizeBytes.intValue(), this.variant);
            } else {
                throw new GeneralSecurityException("Tag size is not set");
            }
        }
    }

    private AesEaxParameters(int i, int i2, int i3, Variant variant2) {
        this.keySizeBytes = i;
        this.ivSizeBytes = i2;
        this.tagSizeBytes = i3;
        this.variant = variant2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AesEaxParameters)) {
            return false;
        }
        AesEaxParameters aesEaxParameters = (AesEaxParameters) obj;
        if (aesEaxParameters.getKeySizeBytes() == getKeySizeBytes() && aesEaxParameters.getIvSizeBytes() == getIvSizeBytes() && aesEaxParameters.getTagSizeBytes() == getTagSizeBytes() && aesEaxParameters.getVariant() == getVariant()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.keySizeBytes), Integer.valueOf(this.ivSizeBytes), Integer.valueOf(this.tagSizeBytes), this.variant});
    }

    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public String toString() {
        return "AesEax Parameters (variant: " + this.variant + ", " + this.ivSizeBytes + "-byte IV, " + this.tagSizeBytes + "-byte tag, and " + this.keySizeBytes + "-byte key)";
    }
}
