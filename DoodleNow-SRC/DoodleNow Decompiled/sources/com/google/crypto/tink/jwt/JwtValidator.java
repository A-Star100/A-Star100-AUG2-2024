package com.google.crypto.tink.jwt;

import com.amazon.a.a.o.b.f;
import com.google.android.material.chip.Chip$$ExternalSyntheticApiModelOutline0;
import com.google.errorprone.annotations.Immutable;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;

@Immutable
public final class JwtValidator {
    /* access modifiers changed from: private */
    public static final Duration MAX_CLOCK_SKEW = Duration.ofMinutes(10);
    private final boolean allowMissingExpiration;
    private final Clock clock;
    private final Duration clockSkew;
    private final boolean expectIssuedInThePast;
    private final Optional<String> expectedAudience;
    private final Optional<String> expectedIssuer;
    private final Optional<String> expectedTypeHeader;
    private final boolean ignoreAudiences;
    private final boolean ignoreIssuer;
    private final boolean ignoreTypeHeader;

    private JwtValidator(Builder builder) {
        this.expectedTypeHeader = builder.expectedTypeHeader;
        this.ignoreTypeHeader = builder.ignoreTypeHeader;
        this.expectedIssuer = builder.expectedIssuer;
        this.ignoreIssuer = builder.ignoreIssuer;
        this.expectedAudience = builder.expectedAudience;
        this.ignoreAudiences = builder.ignoreAudiences;
        this.allowMissingExpiration = builder.allowMissingExpiration;
        this.expectIssuedInThePast = builder.expectIssuedInThePast;
        this.clock = builder.clock;
        this.clockSkew = builder.clockSkew;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean allowMissingExpiration;
        /* access modifiers changed from: private */
        public Clock clock;
        /* access modifiers changed from: private */
        public Duration clockSkew;
        /* access modifiers changed from: private */
        public boolean expectIssuedInThePast;
        /* access modifiers changed from: private */
        public Optional<String> expectedAudience;
        /* access modifiers changed from: private */
        public Optional<String> expectedIssuer;
        /* access modifiers changed from: private */
        public Optional<String> expectedTypeHeader;
        /* access modifiers changed from: private */
        public boolean ignoreAudiences;
        /* access modifiers changed from: private */
        public boolean ignoreIssuer;
        /* access modifiers changed from: private */
        public boolean ignoreTypeHeader;

        public Builder allowMissingExpiration() {
            this.allowMissingExpiration = true;
            return this;
        }

        public Builder expectIssuedInThePast() {
            this.expectIssuedInThePast = true;
            return this;
        }

        public Builder ignoreAudiences() {
            this.ignoreAudiences = true;
            return this;
        }

        public Builder ignoreIssuer() {
            this.ignoreIssuer = true;
            return this;
        }

        public Builder ignoreTypeHeader() {
            this.ignoreTypeHeader = true;
            return this;
        }

        private Builder() {
            this.clock = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m();
            this.clockSkew = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m();
            this.expectedTypeHeader = Chip$$ExternalSyntheticApiModelOutline0.m();
            this.ignoreTypeHeader = false;
            this.expectedIssuer = Chip$$ExternalSyntheticApiModelOutline0.m();
            this.ignoreIssuer = false;
            this.expectedAudience = Chip$$ExternalSyntheticApiModelOutline0.m();
            this.ignoreAudiences = false;
            this.allowMissingExpiration = false;
            this.expectIssuedInThePast = false;
        }

        public Builder expectTypeHeader(String str) {
            if (str != null) {
                this.expectedTypeHeader = Chip$$ExternalSyntheticApiModelOutline0.m((Object) str);
                return this;
            }
            throw new NullPointerException("typ header cannot be null");
        }

        public Builder expectIssuer(String str) {
            if (str != null) {
                this.expectedIssuer = Chip$$ExternalSyntheticApiModelOutline0.m((Object) str);
                return this;
            }
            throw new NullPointerException("issuer cannot be null");
        }

        public Builder expectAudience(String str) {
            if (str != null) {
                this.expectedAudience = Chip$$ExternalSyntheticApiModelOutline0.m((Object) str);
                return this;
            }
            throw new NullPointerException("audience cannot be null");
        }

        public Builder setClock(Clock clock2) {
            if (clock2 != null) {
                this.clock = clock2;
                return this;
            }
            throw new NullPointerException("clock cannot be null");
        }

        public Builder setClockSkew(Duration duration) {
            if (duration.compareTo(JwtValidator.MAX_CLOCK_SKEW) <= 0) {
                this.clockSkew = duration;
                return this;
            }
            throw new IllegalArgumentException("Clock skew too large, max is 10 minutes");
        }

        public JwtValidator build() {
            if (this.ignoreTypeHeader && Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedTypeHeader)) {
                throw new IllegalArgumentException("ignoreTypeHeader() and expectedTypeHeader() cannot be used together.");
            } else if (this.ignoreIssuer && Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedIssuer)) {
                throw new IllegalArgumentException("ignoreIssuer() and expectedIssuer() cannot be used together.");
            } else if (!this.ignoreAudiences || !Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedAudience)) {
                return new JwtValidator(this);
            } else {
                throw new IllegalArgumentException("ignoreAudiences() and expectedAudience() cannot be used together.");
            }
        }
    }

    private void validateTypeHeader(RawJwt rawJwt) throws JwtInvalidException {
        if (Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedTypeHeader)) {
            if (!rawJwt.hasTypeHeader()) {
                throw new JwtInvalidException(String.format("invalid JWT; missing expected type header %s.", new Object[]{Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedTypeHeader)}));
            } else if (!rawJwt.getTypeHeader().equals(Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedTypeHeader))) {
                throw new JwtInvalidException(String.format("invalid JWT; expected type header %s, but got %s", new Object[]{Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedTypeHeader), rawJwt.getTypeHeader()}));
            }
        } else if (rawJwt.hasTypeHeader() && !this.ignoreTypeHeader) {
            throw new JwtInvalidException("invalid JWT; token has type header set, but validator not.");
        }
    }

    private void validateIssuer(RawJwt rawJwt) throws JwtInvalidException {
        if (Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedIssuer)) {
            if (!rawJwt.hasIssuer()) {
                throw new JwtInvalidException(String.format("invalid JWT; missing expected issuer %s.", new Object[]{Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedIssuer)}));
            } else if (!rawJwt.getIssuer().equals(Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedIssuer))) {
                throw new JwtInvalidException(String.format("invalid JWT; expected issuer %s, but got %s", new Object[]{Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedIssuer), rawJwt.getIssuer()}));
            }
        } else if (rawJwt.hasIssuer() && !this.ignoreIssuer) {
            throw new JwtInvalidException("invalid JWT; token has issuer set, but validator not.");
        }
    }

    private void validateAudiences(RawJwt rawJwt) throws JwtInvalidException {
        if (Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedAudience)) {
            if (!rawJwt.hasAudiences() || !rawJwt.getAudiences().contains(Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedAudience))) {
                throw new JwtInvalidException(String.format("invalid JWT; missing expected audience %s.", new Object[]{Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedAudience)}));
            }
        } else if (rawJwt.hasAudiences() && !this.ignoreAudiences) {
            throw new JwtInvalidException("invalid JWT; token has audience set, but validator not.");
        }
    }

    /* access modifiers changed from: package-private */
    public VerifiedJwt validate(RawJwt rawJwt) throws JwtInvalidException {
        validateTimestampClaims(rawJwt);
        validateTypeHeader(rawJwt);
        validateIssuer(rawJwt);
        validateAudiences(rawJwt);
        return new VerifiedJwt(rawJwt);
    }

    private void validateTimestampClaims(RawJwt rawJwt) throws JwtInvalidException {
        Instant m = this.clock.instant();
        if (!rawJwt.hasExpiration() && !this.allowMissingExpiration) {
            throw new JwtInvalidException("token does not have an expiration set");
        } else if (rawJwt.hasExpiration() && !rawJwt.getExpiration().isAfter(m.minus(this.clockSkew))) {
            throw new JwtInvalidException("token has expired since " + rawJwt.getExpiration());
        } else if (rawJwt.hasNotBefore() && rawJwt.getNotBefore().isAfter(m.plus(this.clockSkew))) {
            throw new JwtInvalidException("token cannot be used before " + rawJwt.getNotBefore());
        } else if (!this.expectIssuedInThePast) {
        } else {
            if (!rawJwt.hasIssuedAt()) {
                throw new JwtInvalidException("token does not have an iat claim");
            } else if (rawJwt.getIssuedAt().isAfter(m.plus(this.clockSkew))) {
                throw new JwtInvalidException("token has a invalid iat claim in the future: " + rawJwt.getIssuedAt());
            }
        }
    }

    public String toString() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedTypeHeader)) {
            arrayList.add("expectedTypeHeader=" + ((String) Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedTypeHeader)));
        }
        if (this.ignoreTypeHeader) {
            arrayList.add("ignoreTypeHeader");
        }
        if (Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedIssuer)) {
            arrayList.add("expectedIssuer=" + ((String) Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedIssuer)));
        }
        if (this.ignoreIssuer) {
            arrayList.add("ignoreIssuer");
        }
        if (Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedAudience)) {
            arrayList.add("expectedAudience=" + ((String) Chip$$ExternalSyntheticApiModelOutline0.m((Optional) this.expectedAudience)));
        }
        if (this.ignoreAudiences) {
            arrayList.add("ignoreAudiences");
        }
        if (this.allowMissingExpiration) {
            arrayList.add("allowMissingExpiration");
        }
        if (this.expectIssuedInThePast) {
            arrayList.add("expectIssuedInThePast");
        }
        if (!this.clockSkew.isZero()) {
            arrayList.add("clockSkew=" + this.clockSkew);
        }
        StringBuilder sb = new StringBuilder("JwtValidator{");
        String str = "";
        for (String append : arrayList) {
            sb.append(str);
            sb.append(append);
            str = f.a;
        }
        sb.append("}");
        return sb.toString();
    }
}
