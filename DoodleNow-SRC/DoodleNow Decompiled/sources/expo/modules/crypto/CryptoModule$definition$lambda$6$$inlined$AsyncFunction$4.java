package expo.modules.crypto;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u0003\u0018\u0001\"\u0006\b\u0003\u0010\u0004\u0018\u00012\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"<anonymous>", "R", "P0", "P1", "P2", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$12"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class CryptoModule$definition$lambda$6$$inlined$AsyncFunction$4 extends Lambda implements Function1<Object[], String> {
    final /* synthetic */ CryptoModule $receiver$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CryptoModule$definition$lambda$6$$inlined$AsyncFunction$4(CryptoModule cryptoModule) {
        super(1);
        this.$receiver$inlined = cryptoModule;
    }

    public final String invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        DigestAlgorithm digestAlgorithm = objArr[0];
        String str = objArr[1];
        DigestAlgorithm digestAlgorithm2 = digestAlgorithm;
        return this.$receiver$inlined.digestString(digestAlgorithm2, str, objArr[2]);
    }
}
