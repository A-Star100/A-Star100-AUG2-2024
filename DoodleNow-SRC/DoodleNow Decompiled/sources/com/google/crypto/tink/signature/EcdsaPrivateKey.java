package com.google.crypto.tink.signature;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.crypto.tink.signature.EcdsaParameters;
import com.google.crypto.tink.util.SecretBigInteger;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

@Immutable
public final class EcdsaPrivateKey extends SignaturePrivateKey {
    private final SecretBigInteger privateValue;
    private final EcdsaPublicKey publicKey;

    public SecretBigInteger getPrivateValue() {
        return this.privateValue;
    }

    public EcdsaPublicKey getPublicKey() {
        return this.publicKey;
    }

    public static class Builder {
        private SecretBigInteger privateValue;
        private EcdsaPublicKey publicKey;

        public Builder setPrivateValue(SecretBigInteger secretBigInteger) {
            this.privateValue = secretBigInteger;
            return this;
        }

        public Builder setPublicKey(EcdsaPublicKey ecdsaPublicKey) {
            this.publicKey = ecdsaPublicKey;
            return this;
        }

        private Builder() {
            this.publicKey = null;
            this.privateValue = null;
        }

        private static void validatePrivateValue(BigInteger bigInteger, ECPoint eCPoint, EcdsaParameters.CurveType curveType) throws GeneralSecurityException {
            BigInteger order = curveType.toParameterSpec().getOrder();
            if (bigInteger.signum() <= 0 || bigInteger.compareTo(order) >= 0) {
                throw new GeneralSecurityException("Invalid private value");
            } else if (!EllipticCurvesUtil.multiplyByGenerator(bigInteger, curveType.toParameterSpec()).equals(eCPoint)) {
                throw new GeneralSecurityException("Invalid private value");
            }
        }

        public EcdsaPrivateKey build() throws GeneralSecurityException {
            if (this.publicKey != null) {
                SecretBigInteger secretBigInteger = this.privateValue;
                if (secretBigInteger != null) {
                    validatePrivateValue(secretBigInteger.getBigInteger(InsecureSecretKeyAccess.get()), this.publicKey.getPublicPoint(), this.publicKey.getParameters().getCurveType());
                    return new EcdsaPrivateKey(this.publicKey, this.privateValue);
                }
                throw new GeneralSecurityException("Cannot build without a private value");
            }
            throw new GeneralSecurityException("Cannot build without a ecdsa public key");
        }
    }

    private EcdsaPrivateKey(EcdsaPublicKey ecdsaPublicKey, SecretBigInteger secretBigInteger) {
        this.publicKey = ecdsaPublicKey;
        this.privateValue = secretBigInteger;
    }

    public static Builder builder() {
        return new Builder();
    }

    public EcdsaParameters getParameters() {
        return this.publicKey.getParameters();
    }

    public boolean equalsKey(Key key) {
        if (!(key instanceof EcdsaPrivateKey)) {
            return false;
        }
        EcdsaPrivateKey ecdsaPrivateKey = (EcdsaPrivateKey) key;
        if (!ecdsaPrivateKey.publicKey.equalsKey(this.publicKey) || !this.privateValue.equalsSecretBigInteger(ecdsaPrivateKey.privateValue)) {
            return false;
        }
        return true;
    }
}
