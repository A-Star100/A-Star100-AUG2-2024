package com.google.crypto.tink.mac;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

public final class AesCmacParameters extends MacParameters {
    private final int keySizeBytes;
    private final int tagSizeBytes;
    private final Variant variant;

    public int getCryptographicTagSizeBytes() {
        return this.tagSizeBytes;
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    public Variant getVariant() {
        return this.variant;
    }

    @Immutable
    public static final class Variant {
        public static final Variant CRUNCHY = new Variant("CRUNCHY");
        public static final Variant LEGACY = new Variant("LEGACY");
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
        @Nullable
        private Integer tagSizeBytes;
        private Variant variant;

        public Builder setVariant(Variant variant2) {
            this.variant = variant2;
            return this;
        }

        private Builder() {
            this.keySizeBytes = null;
            this.tagSizeBytes = null;
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setKeySizeBytes(int i) throws GeneralSecurityException {
            if (i == 16 || i == 32) {
                this.keySizeBytes = Integer.valueOf(i);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", new Object[]{Integer.valueOf(i * 8)}));
        }

        public Builder setTagSizeBytes(int i) throws GeneralSecurityException {
            if (i < 10 || 16 < i) {
                throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i);
            }
            this.tagSizeBytes = Integer.valueOf(i);
            return this;
        }

        public AesCmacParameters build() throws GeneralSecurityException {
            Integer num = this.keySizeBytes;
            if (num == null) {
                throw new GeneralSecurityException("key size not set");
            } else if (this.tagSizeBytes == null) {
                throw new GeneralSecurityException("tag size not set");
            } else if (this.variant != null) {
                return new AesCmacParameters(num.intValue(), this.tagSizeBytes.intValue(), this.variant);
            } else {
                throw new GeneralSecurityException("variant not set");
            }
        }
    }

    private AesCmacParameters(int i, int i2, Variant variant2) {
        this.keySizeBytes = i;
        this.tagSizeBytes = i2;
        this.variant = variant2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getTotalTagSizeBytes() {
        int cryptographicTagSizeBytes;
        if (this.variant == Variant.NO_PREFIX) {
            return getCryptographicTagSizeBytes();
        }
        if (this.variant == Variant.TINK) {
            cryptographicTagSizeBytes = getCryptographicTagSizeBytes();
        } else if (this.variant == Variant.CRUNCHY) {
            cryptographicTagSizeBytes = getCryptographicTagSizeBytes();
        } else if (this.variant == Variant.LEGACY) {
            cryptographicTagSizeBytes = getCryptographicTagSizeBytes();
        } else {
            throw new IllegalStateException("Unknown variant");
        }
        return cryptographicTagSizeBytes + 5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AesCmacParameters)) {
            return false;
        }
        AesCmacParameters aesCmacParameters = (AesCmacParameters) obj;
        if (aesCmacParameters.getKeySizeBytes() == getKeySizeBytes() && aesCmacParameters.getTotalTagSizeBytes() == getTotalTagSizeBytes() && aesCmacParameters.getVariant() == getVariant()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.keySizeBytes), Integer.valueOf(this.tagSizeBytes), this.variant});
    }

    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public String toString() {
        return "AES-CMAC Parameters (variant: " + this.variant + ", " + this.tagSizeBytes + "-byte tags, and " + this.keySizeBytes + "-byte key)";
    }
}
