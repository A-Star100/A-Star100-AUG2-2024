package com.google.crypto.tink.jwt;

final class JwtNames {
    static final String CLAIM_AUDIENCE = "aud";
    static final String CLAIM_EXPIRATION = "exp";
    static final String CLAIM_ISSUED_AT = "iat";
    static final String CLAIM_ISSUER = "iss";
    static final String CLAIM_JWT_ID = "jti";
    static final String CLAIM_NOT_BEFORE = "nbf";
    static final String CLAIM_SUBJECT = "sub";
    static final String HEADER_ALGORITHM = "alg";
    static final String HEADER_CRITICAL = "crit";
    static final String HEADER_KEY_ID = "kid";
    static final String HEADER_TYPE = "typ";

    static void validate(String str) {
        if (isRegisteredName(str)) {
            throw new IllegalArgumentException(String.format("claim '%s' is invalid because it's a registered name; use the corresponding setter method.", new Object[]{str}));
        }
    }

    static boolean isRegisteredName(String str) {
        return str.equals("iss") || str.equals("sub") || str.equals("aud") || str.equals("exp") || str.equals("nbf") || str.equals("iat") || str.equals("jti");
    }

    private JwtNames() {
    }
}
