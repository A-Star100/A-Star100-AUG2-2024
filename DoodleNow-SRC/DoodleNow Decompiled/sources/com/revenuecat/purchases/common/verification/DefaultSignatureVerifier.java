package com.revenuecat.purchases.common.verification;

import com.google.crypto.tink.subtle.Ed25519Verify;
import java.security.GeneralSecurityException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/common/verification/DefaultSignatureVerifier;", "Lcom/revenuecat/purchases/common/verification/SignatureVerifier;", "publicKey", "", "(Ljava/lang/String;)V", "publicKeyBytes", "", "([B)V", "verifier", "Lcom/google/crypto/tink/subtle/Ed25519Verify;", "verify", "", "signatureToVerify", "messageToVerify", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SignatureVerifier.kt */
public final class DefaultSignatureVerifier implements SignatureVerifier {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEFAULT_PUBLIC_KEY = "UC1upXWg5QVmyOSwozp755xLqquBKjjU+di6U8QhMlM=";
    private final Ed25519Verify verifier;

    public DefaultSignatureVerifier(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "publicKeyBytes");
        this.verifier = new Ed25519Verify(bArr);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/common/verification/DefaultSignatureVerifier$Companion;", "", "()V", "DEFAULT_PUBLIC_KEY", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SignatureVerifier.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultSignatureVerifier(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "publicKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = 0
            byte[] r2 = android.util.Base64.decode(r2, r0)
            java.lang.String r0 = "decode(publicKey, Base64.DEFAULT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            r1.<init>((byte[]) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.verification.DefaultSignatureVerifier.<init>(java.lang.String):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultSignatureVerifier(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DEFAULT_PUBLIC_KEY : str);
    }

    public boolean verify(byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "signatureToVerify");
        Intrinsics.checkNotNullParameter(bArr2, "messageToVerify");
        try {
            this.verifier.verify(bArr, bArr2);
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
