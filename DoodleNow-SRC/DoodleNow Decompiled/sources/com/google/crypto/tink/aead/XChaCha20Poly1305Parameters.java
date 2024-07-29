package com.google.crypto.tink.aead;

import com.google.errorprone.annotations.Immutable;
import java.util.Objects;

public final class XChaCha20Poly1305Parameters extends AeadParameters {
    private final Variant variant;

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

    public static XChaCha20Poly1305Parameters create() {
        return new XChaCha20Poly1305Parameters(Variant.NO_PREFIX);
    }

    public static XChaCha20Poly1305Parameters create(Variant variant2) {
        return new XChaCha20Poly1305Parameters(variant2);
    }

    private XChaCha20Poly1305Parameters(Variant variant2) {
        this.variant = variant2;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof XChaCha20Poly1305Parameters) && ((XChaCha20Poly1305Parameters) obj).getVariant() == getVariant()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.variant);
    }

    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public String toString() {
        return "XChaCha20Poly1305 Parameters (variant: " + this.variant + ")";
    }
}
