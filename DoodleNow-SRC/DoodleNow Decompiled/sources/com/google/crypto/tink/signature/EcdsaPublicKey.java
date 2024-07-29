package com.google.crypto.tink.signature;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.crypto.tink.signature.EcdsaParameters;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.util.Objects;
import javax.annotation.Nullable;

@Immutable
public final class EcdsaPublicKey extends SignaturePublicKey {
    @Nullable
    private final Integer idRequirement;
    private final Bytes outputPrefix;
    private final EcdsaParameters parameters;
    private final ECPoint publicPoint;

    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    public EcdsaParameters getParameters() {
        return this.parameters;
    }

    public ECPoint getPublicPoint() {
        return this.publicPoint;
    }

    public static class Builder {
        @Nullable
        private Integer idRequirement;
        @Nullable
        private EcdsaParameters parameters;
        @Nullable
        private ECPoint publicPoint;

        public Builder setIdRequirement(@Nullable Integer num) {
            this.idRequirement = num;
            return this;
        }

        public Builder setParameters(EcdsaParameters ecdsaParameters) {
            this.parameters = ecdsaParameters;
            return this;
        }

        public Builder setPublicPoint(ECPoint eCPoint) {
            this.publicPoint = eCPoint;
            return this;
        }

        private Builder() {
            this.parameters = null;
            this.publicPoint = null;
            this.idRequirement = null;
        }

        private Bytes getOutputPrefix() {
            if (this.parameters.getVariant() == EcdsaParameters.Variant.NO_PREFIX) {
                return Bytes.copyFrom(new byte[0]);
            }
            if (this.parameters.getVariant() == EcdsaParameters.Variant.LEGACY || this.parameters.getVariant() == EcdsaParameters.Variant.CRUNCHY) {
                return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(this.idRequirement.intValue()).array());
            }
            if (this.parameters.getVariant() == EcdsaParameters.Variant.TINK) {
                return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(this.idRequirement.intValue()).array());
            }
            throw new IllegalStateException("Unknown EcdsaParameters.Variant: " + this.parameters.getVariant());
        }

        public EcdsaPublicKey build() throws GeneralSecurityException {
            EcdsaParameters ecdsaParameters = this.parameters;
            if (ecdsaParameters != null) {
                ECPoint eCPoint = this.publicPoint;
                if (eCPoint != null) {
                    EllipticCurvesUtil.checkPointOnCurve(eCPoint, ecdsaParameters.getCurveType().toParameterSpec().getCurve());
                    if (this.parameters.hasIdRequirement() && this.idRequirement == null) {
                        throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                    } else if (this.parameters.hasIdRequirement() || this.idRequirement == null) {
                        return new EcdsaPublicKey(this.parameters, this.publicPoint, getOutputPrefix(), this.idRequirement);
                    } else {
                        throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                    }
                } else {
                    throw new GeneralSecurityException("Cannot build without public point");
                }
            } else {
                throw new GeneralSecurityException("Cannot build without parameters");
            }
        }
    }

    private EcdsaPublicKey(EcdsaParameters ecdsaParameters, ECPoint eCPoint, Bytes bytes, @Nullable Integer num) {
        this.parameters = ecdsaParameters;
        this.publicPoint = eCPoint;
        this.outputPrefix = bytes;
        this.idRequirement = num;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equalsKey(Key key) {
        if (!(key instanceof EcdsaPublicKey)) {
            return false;
        }
        EcdsaPublicKey ecdsaPublicKey = (EcdsaPublicKey) key;
        if (!ecdsaPublicKey.parameters.equals(this.parameters) || !ecdsaPublicKey.publicPoint.equals(this.publicPoint) || !Objects.equals(ecdsaPublicKey.idRequirement, this.idRequirement)) {
            return false;
        }
        return true;
    }
}
