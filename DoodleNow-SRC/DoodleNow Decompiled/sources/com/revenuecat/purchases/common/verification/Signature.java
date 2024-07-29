package com.revenuecat.purchases.common.verification;

import android.util.Base64;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/common/verification/Signature;", "", "intermediateKey", "", "intermediateKeyExpiration", "intermediateKeySignature", "salt", "payload", "([B[B[B[B[B)V", "getIntermediateKey", "()[B", "getIntermediateKeyExpiration", "getIntermediateKeySignature", "getPayload", "getSalt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "Component", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Signature.kt */
public final class Signature {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final byte[] intermediateKey;
    private final byte[] intermediateKeyExpiration;
    private final byte[] intermediateKeySignature;
    private final byte[] payload;
    private final byte[] salt;

    public static /* synthetic */ Signature copy$default(Signature signature, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = signature.intermediateKey;
        }
        if ((i & 2) != 0) {
            bArr2 = signature.intermediateKeyExpiration;
        }
        byte[] bArr6 = bArr2;
        if ((i & 4) != 0) {
            bArr3 = signature.intermediateKeySignature;
        }
        byte[] bArr7 = bArr3;
        if ((i & 8) != 0) {
            bArr4 = signature.salt;
        }
        byte[] bArr8 = bArr4;
        if ((i & 16) != 0) {
            bArr5 = signature.payload;
        }
        return signature.copy(bArr, bArr6, bArr7, bArr8, bArr5);
    }

    public final byte[] component1() {
        return this.intermediateKey;
    }

    public final byte[] component2() {
        return this.intermediateKeyExpiration;
    }

    public final byte[] component3() {
        return this.intermediateKeySignature;
    }

    public final byte[] component4() {
        return this.salt;
    }

    public final byte[] component5() {
        return this.payload;
    }

    public final Signature copy(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        Intrinsics.checkNotNullParameter(bArr, "intermediateKey");
        Intrinsics.checkNotNullParameter(bArr2, "intermediateKeyExpiration");
        Intrinsics.checkNotNullParameter(bArr3, "intermediateKeySignature");
        Intrinsics.checkNotNullParameter(bArr4, "salt");
        Intrinsics.checkNotNullParameter(bArr5, "payload");
        return new Signature(bArr, bArr2, bArr3, bArr4, bArr5);
    }

    public final byte[] getIntermediateKey() {
        return this.intermediateKey;
    }

    public final byte[] getIntermediateKeyExpiration() {
        return this.intermediateKeyExpiration;
    }

    public final byte[] getIntermediateKeySignature() {
        return this.intermediateKeySignature;
    }

    public final byte[] getPayload() {
        return this.payload;
    }

    public final byte[] getSalt() {
        return this.salt;
    }

    public String toString() {
        return "Signature(intermediateKey=" + Arrays.toString(this.intermediateKey) + ", intermediateKeyExpiration=" + Arrays.toString(this.intermediateKeyExpiration) + ", intermediateKeySignature=" + Arrays.toString(this.intermediateKeySignature) + ", salt=" + Arrays.toString(this.salt) + ", payload=" + Arrays.toString(this.payload) + ')';
    }

    public Signature(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        Intrinsics.checkNotNullParameter(bArr, "intermediateKey");
        Intrinsics.checkNotNullParameter(bArr2, "intermediateKeyExpiration");
        Intrinsics.checkNotNullParameter(bArr3, "intermediateKeySignature");
        Intrinsics.checkNotNullParameter(bArr4, "salt");
        Intrinsics.checkNotNullParameter(bArr5, "payload");
        this.intermediateKey = bArr;
        this.intermediateKeyExpiration = bArr2;
        this.intermediateKeySignature = bArr3;
        this.salt = bArr4;
        this.payload = bArr5;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/common/verification/Signature$Companion;", "", "()V", "fromString", "Lcom/revenuecat/purchases/common/verification/Signature;", "signature", "", "fromString$purchases_defaultsRelease", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Signature.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Signature fromString$purchases_defaultsRelease(String str) {
            Intrinsics.checkNotNullParameter(str, "signature");
            byte[] decode = Base64.decode(str, 0);
            int totalSize = Component.Companion.getTotalSize();
            if (decode.length == totalSize) {
                Intrinsics.checkNotNullExpressionValue(decode, "signatureBytes");
                return new Signature(SignatureKt.copyOf(decode, Component.INTERMEDIATE_KEY), SignatureKt.copyOf(decode, Component.INTERMEDIATE_KEY_EXPIRATION), SignatureKt.copyOf(decode, Component.INTERMEDIATE_KEY_SIGNATURE), SignatureKt.copyOf(decode, Component.SALT), SignatureKt.copyOf(decode, Component.PAYLOAD));
            }
            throw new InvalidSignatureSizeException("Invalid signature size. Expected " + totalSize + ", got " + decode.length + " bytes");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/common/verification/Signature$Component;", "", "size", "", "(Ljava/lang/String;II)V", "endByte", "getEndByte", "()I", "getSize", "startByte", "getStartByte", "INTERMEDIATE_KEY", "INTERMEDIATE_KEY_EXPIRATION", "INTERMEDIATE_KEY_SIGNATURE", "SALT", "PAYLOAD", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Signature.kt */
    public enum Component {
        INTERMEDIATE_KEY(32),
        INTERMEDIATE_KEY_EXPIRATION(4),
        INTERMEDIATE_KEY_SIGNATURE(64),
        SALT(16),
        PAYLOAD(64);
        
        public static final Companion Companion = null;
        private final int size;

        public final int getSize() {
            return this.size;
        }

        private Component(int i) {
            this.size = i;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/verification/Signature$Component$Companion;", "", "()V", "totalSize", "", "getTotalSize", "()I", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: Signature.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final int getTotalSize() {
                int i = 0;
                for (Component size : Component.values()) {
                    i += size.getSize();
                }
                return i;
            }
        }

        public final int getStartByte() {
            int i = 0;
            for (Object obj : ArraysKt.copyOfRange((T[]) values(), 0, ordinal())) {
                i += ((Component) obj).size;
            }
            return i;
        }

        public final int getEndByte() {
            return getStartByte() + this.size;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.common.verification.Signature");
        Signature signature = (Signature) obj;
        return Arrays.equals(this.intermediateKey, signature.intermediateKey) && Arrays.equals(this.intermediateKeyExpiration, signature.intermediateKeyExpiration) && Arrays.equals(this.intermediateKeySignature, signature.intermediateKeySignature) && Arrays.equals(this.salt, signature.salt) && Arrays.equals(this.payload, signature.payload);
    }

    public int hashCode() {
        return (((((((Arrays.hashCode(this.intermediateKey) * 31) + Arrays.hashCode(this.intermediateKeyExpiration)) * 31) + Arrays.hashCode(this.intermediateKeySignature)) * 31) + Arrays.hashCode(this.salt)) * 31) + Arrays.hashCode(this.payload);
    }
}
