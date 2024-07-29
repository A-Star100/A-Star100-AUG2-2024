package com.revenuecat.purchases.common.verification;

import com.revenuecat.purchases.EntitlementVerificationMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u000b2\u00020\u0001:\u0004\u000b\f\r\u000eB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "", "()V", "intermediateSignatureHelper", "Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;", "getIntermediateSignatureHelper", "()Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;", "shouldVerify", "", "getShouldVerify", "()Z", "Companion", "Disabled", "Enforced", "Informational", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode$Disabled;", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode$Enforced;", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode$Informational;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SignatureVerificationMode.kt */
public abstract class SignatureVerificationMode {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ SignatureVerificationMode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode$Companion;", "", "()V", "createIntermediateSignatureHelper", "Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;", "fromEntitlementVerificationMode", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "verificationMode", "Lcom/revenuecat/purchases/EntitlementVerificationMode;", "rootVerifier", "Lcom/revenuecat/purchases/common/verification/SignatureVerifier;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SignatureVerificationMode.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: SignatureVerificationMode.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    com.revenuecat.purchases.EntitlementVerificationMode[] r0 = com.revenuecat.purchases.EntitlementVerificationMode.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.revenuecat.purchases.EntitlementVerificationMode r1 = com.revenuecat.purchases.EntitlementVerificationMode.DISABLED     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.revenuecat.purchases.EntitlementVerificationMode r1 = com.revenuecat.purchases.EntitlementVerificationMode.INFORMATIONAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.verification.SignatureVerificationMode.Companion.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ SignatureVerificationMode fromEntitlementVerificationMode$default(Companion companion, EntitlementVerificationMode entitlementVerificationMode, SignatureVerifier signatureVerifier, int i, Object obj) {
            if ((i & 2) != 0) {
                signatureVerifier = null;
            }
            return companion.fromEntitlementVerificationMode(entitlementVerificationMode, signatureVerifier);
        }

        public final SignatureVerificationMode fromEntitlementVerificationMode(EntitlementVerificationMode entitlementVerificationMode, SignatureVerifier signatureVerifier) {
            Intrinsics.checkNotNullParameter(entitlementVerificationMode, "verificationMode");
            int i = WhenMappings.$EnumSwitchMapping$0[entitlementVerificationMode.ordinal()];
            if (i == 1) {
                return Disabled.INSTANCE;
            }
            if (i == 2) {
                if (signatureVerifier == null) {
                    signatureVerifier = new DefaultSignatureVerifier((String) null, 1, (DefaultConstructorMarker) null);
                }
                return new Informational(new IntermediateSignatureHelper(signatureVerifier));
            }
            throw new NoWhenBranchMatchedException();
        }

        /* access modifiers changed from: private */
        public final IntermediateSignatureHelper createIntermediateSignatureHelper() {
            return new IntermediateSignatureHelper(new DefaultSignatureVerifier((String) null, 1, (DefaultConstructorMarker) null));
        }
    }

    private SignatureVerificationMode() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode$Disabled;", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SignatureVerificationMode.kt */
    public static final class Disabled extends SignatureVerificationMode {
        public static final Disabled INSTANCE = new Disabled();

        private Disabled() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode$Informational;", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "intermediateSignatureHelper", "Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;", "(Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;)V", "getIntermediateSignatureHelper", "()Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SignatureVerificationMode.kt */
    public static final class Informational extends SignatureVerificationMode {
        private final IntermediateSignatureHelper intermediateSignatureHelper;

        public Informational() {
            this((IntermediateSignatureHelper) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Informational copy$default(Informational informational, IntermediateSignatureHelper intermediateSignatureHelper2, int i, Object obj) {
            if ((i & 1) != 0) {
                intermediateSignatureHelper2 = informational.getIntermediateSignatureHelper();
            }
            return informational.copy(intermediateSignatureHelper2);
        }

        public final IntermediateSignatureHelper component1() {
            return getIntermediateSignatureHelper();
        }

        public final Informational copy(IntermediateSignatureHelper intermediateSignatureHelper2) {
            Intrinsics.checkNotNullParameter(intermediateSignatureHelper2, "intermediateSignatureHelper");
            return new Informational(intermediateSignatureHelper2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Informational) && Intrinsics.areEqual((Object) getIntermediateSignatureHelper(), (Object) ((Informational) obj).getIntermediateSignatureHelper());
        }

        public IntermediateSignatureHelper getIntermediateSignatureHelper() {
            return this.intermediateSignatureHelper;
        }

        public int hashCode() {
            return getIntermediateSignatureHelper().hashCode();
        }

        public String toString() {
            return "Informational(intermediateSignatureHelper=" + getIntermediateSignatureHelper() + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Informational(IntermediateSignatureHelper intermediateSignatureHelper2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SignatureVerificationMode.Companion.createIntermediateSignatureHelper() : intermediateSignatureHelper2);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Informational(IntermediateSignatureHelper intermediateSignatureHelper2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(intermediateSignatureHelper2, "intermediateSignatureHelper");
            this.intermediateSignatureHelper = intermediateSignatureHelper2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode$Enforced;", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "intermediateSignatureHelper", "Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;", "(Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;)V", "getIntermediateSignatureHelper", "()Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SignatureVerificationMode.kt */
    public static final class Enforced extends SignatureVerificationMode {
        private final IntermediateSignatureHelper intermediateSignatureHelper;

        public Enforced() {
            this((IntermediateSignatureHelper) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Enforced copy$default(Enforced enforced, IntermediateSignatureHelper intermediateSignatureHelper2, int i, Object obj) {
            if ((i & 1) != 0) {
                intermediateSignatureHelper2 = enforced.getIntermediateSignatureHelper();
            }
            return enforced.copy(intermediateSignatureHelper2);
        }

        public final IntermediateSignatureHelper component1() {
            return getIntermediateSignatureHelper();
        }

        public final Enforced copy(IntermediateSignatureHelper intermediateSignatureHelper2) {
            Intrinsics.checkNotNullParameter(intermediateSignatureHelper2, "intermediateSignatureHelper");
            return new Enforced(intermediateSignatureHelper2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Enforced) && Intrinsics.areEqual((Object) getIntermediateSignatureHelper(), (Object) ((Enforced) obj).getIntermediateSignatureHelper());
        }

        public IntermediateSignatureHelper getIntermediateSignatureHelper() {
            return this.intermediateSignatureHelper;
        }

        public int hashCode() {
            return getIntermediateSignatureHelper().hashCode();
        }

        public String toString() {
            return "Enforced(intermediateSignatureHelper=" + getIntermediateSignatureHelper() + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Enforced(IntermediateSignatureHelper intermediateSignatureHelper2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SignatureVerificationMode.Companion.createIntermediateSignatureHelper() : intermediateSignatureHelper2);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Enforced(IntermediateSignatureHelper intermediateSignatureHelper2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(intermediateSignatureHelper2, "intermediateSignatureHelper");
            this.intermediateSignatureHelper = intermediateSignatureHelper2;
        }
    }

    public final boolean getShouldVerify() {
        if (Intrinsics.areEqual((Object) this, (Object) Disabled.INSTANCE)) {
            return false;
        }
        if ((this instanceof Informational) || (this instanceof Enforced)) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    public IntermediateSignatureHelper getIntermediateSignatureHelper() {
        if (this instanceof Disabled) {
            return null;
        }
        if (this instanceof Informational) {
            return ((Informational) this).getIntermediateSignatureHelper();
        }
        if (this instanceof Enforced) {
            return ((Enforced) this).getIntermediateSignatureHelper();
        }
        throw new NoWhenBranchMatchedException();
    }
}
