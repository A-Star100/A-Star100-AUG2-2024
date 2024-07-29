package com.revenuecat.purchases.common.verification;

import android.util.Base64;
import com.amazon.a.a.o.b.f;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.utils.Result;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000b\u001a\u00020\u0007J,\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u001a\u0010\u000f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0011\u0018\u00010\u0010J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eJJ\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SigningManager;", "", "signatureVerificationMode", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "apiKey", "", "(Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;Lcom/revenuecat/purchases/common/AppConfig;Ljava/lang/String;)V", "getSignatureVerificationMode", "()Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "createRandomNonce", "getPostParamsForSigningHeaderIfNeeded", "endpoint", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "postFieldsToSign", "", "Lkotlin/Pair;", "shouldVerifyEndpoint", "", "verifyResponse", "Lcom/revenuecat/purchases/VerificationResult;", "urlPath", "signatureString", "nonce", "body", "requestTime", "eTag", "postFieldsToSignHeader", "Companion", "Parameters", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SigningManager.kt */
public final class SigningManager {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int NONCE_BYTES_SIZE = 12;
    @Deprecated
    public static final String POST_PARAMS_ALGORITHM = "sha256";
    @Deprecated
    public static final byte POST_PARAMS_SEPARATOR = 0;
    private final String apiKey;
    private final AppConfig appConfig;
    private final SignatureVerificationMode signatureVerificationMode;

    public final SignatureVerificationMode getSignatureVerificationMode() {
        return this.signatureVerificationMode;
    }

    public SigningManager(SignatureVerificationMode signatureVerificationMode2, AppConfig appConfig2, String str) {
        Intrinsics.checkNotNullParameter(signatureVerificationMode2, "signatureVerificationMode");
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        Intrinsics.checkNotNullParameter(str, "apiKey");
        this.signatureVerificationMode = signatureVerificationMode2;
        this.appConfig = appConfig2;
        this.apiKey = str;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SigningManager$Companion;", "", "()V", "NONCE_BYTES_SIZE", "", "POST_PARAMS_ALGORITHM", "", "POST_PARAMS_SEPARATOR", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SigningManager.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003Ja\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006'"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SigningManager$Parameters;", "", "salt", "", "apiKey", "", "nonce", "urlPath", "postParamsHashHeader", "requestTime", "eTag", "body", "([BLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "getBody", "getETag", "getNonce", "getPostParamsHashHeader", "getRequestTime", "getSalt", "()[B", "getUrlPath", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toSignatureToVerify", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SigningManager.kt */
    private static final class Parameters {
        private final String apiKey;
        private final String body;
        private final String eTag;
        private final String nonce;
        private final String postParamsHashHeader;
        private final String requestTime;
        private final byte[] salt;
        private final String urlPath;

        public static /* synthetic */ Parameters copy$default(Parameters parameters, byte[] bArr, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
            Parameters parameters2 = parameters;
            int i2 = i;
            return parameters.copy((i2 & 1) != 0 ? parameters2.salt : bArr, (i2 & 2) != 0 ? parameters2.apiKey : str, (i2 & 4) != 0 ? parameters2.nonce : str2, (i2 & 8) != 0 ? parameters2.urlPath : str3, (i2 & 16) != 0 ? parameters2.postParamsHashHeader : str4, (i2 & 32) != 0 ? parameters2.requestTime : str5, (i2 & 64) != 0 ? parameters2.eTag : str6, (i2 & 128) != 0 ? parameters2.body : str7);
        }

        public final byte[] component1() {
            return this.salt;
        }

        public final String component2() {
            return this.apiKey;
        }

        public final String component3() {
            return this.nonce;
        }

        public final String component4() {
            return this.urlPath;
        }

        public final String component5() {
            return this.postParamsHashHeader;
        }

        public final String component6() {
            return this.requestTime;
        }

        public final String component7() {
            return this.eTag;
        }

        public final String component8() {
            return this.body;
        }

        public final Parameters copy(byte[] bArr, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            Intrinsics.checkNotNullParameter(bArr, "salt");
            Intrinsics.checkNotNullParameter(str, "apiKey");
            Intrinsics.checkNotNullParameter(str3, "urlPath");
            String str8 = str5;
            Intrinsics.checkNotNullParameter(str8, "requestTime");
            return new Parameters(bArr, str, str2, str3, str4, str8, str6, str7);
        }

        public final String getApiKey() {
            return this.apiKey;
        }

        public final String getBody() {
            return this.body;
        }

        public final String getETag() {
            return this.eTag;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final String getPostParamsHashHeader() {
            return this.postParamsHashHeader;
        }

        public final String getRequestTime() {
            return this.requestTime;
        }

        public final byte[] getSalt() {
            return this.salt;
        }

        public final String getUrlPath() {
            return this.urlPath;
        }

        public String toString() {
            return "Parameters(salt=" + Arrays.toString(this.salt) + ", apiKey=" + this.apiKey + ", nonce=" + this.nonce + ", urlPath=" + this.urlPath + ", postParamsHashHeader=" + this.postParamsHashHeader + ", requestTime=" + this.requestTime + ", eTag=" + this.eTag + ", body=" + this.body + ')';
        }

        public Parameters(byte[] bArr, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            Intrinsics.checkNotNullParameter(bArr, "salt");
            Intrinsics.checkNotNullParameter(str, "apiKey");
            Intrinsics.checkNotNullParameter(str3, "urlPath");
            Intrinsics.checkNotNullParameter(str5, "requestTime");
            this.salt = bArr;
            this.apiKey = str;
            this.nonce = str2;
            this.urlPath = str3;
            this.postParamsHashHeader = str4;
            this.requestTime = str5;
            this.eTag = str6;
            this.body = str7;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.common.verification.SigningManager.Parameters");
            Parameters parameters = (Parameters) obj;
            return Arrays.equals(this.salt, parameters.salt) && Intrinsics.areEqual((Object) this.apiKey, (Object) parameters.apiKey) && Intrinsics.areEqual((Object) this.nonce, (Object) parameters.nonce) && Intrinsics.areEqual((Object) this.urlPath, (Object) parameters.urlPath) && Intrinsics.areEqual((Object) this.postParamsHashHeader, (Object) parameters.postParamsHashHeader) && Intrinsics.areEqual((Object) this.requestTime, (Object) parameters.requestTime) && Intrinsics.areEqual((Object) this.eTag, (Object) parameters.eTag) && Intrinsics.areEqual((Object) this.body, (Object) parameters.body);
        }

        public int hashCode() {
            int hashCode = ((Arrays.hashCode(this.salt) * 31) + this.apiKey.hashCode()) * 31;
            String str = this.nonce;
            int i = 0;
            int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.urlPath.hashCode()) * 31;
            String str2 = this.postParamsHashHeader;
            int hashCode3 = (((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.requestTime.hashCode()) * 31;
            String str3 = this.eTag;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.body;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode4 + i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0066, code lost:
            if (r1 == null) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x007b, code lost:
            if (r1 == null) goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
            if (r1 == null) goto L_0x0044;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final byte[] toSignatureToVerify() {
            /*
                r5 = this;
                byte[] r0 = r5.salt
                java.lang.String r1 = r5.apiKey
                java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
                byte[] r1 = r1.getBytes(r2)
                java.lang.String r2 = "this as java.lang.String).getBytes(charset)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                byte[] r0 = kotlin.collections.ArraysKt.plus((byte[]) r0, (byte[]) r1)
                java.lang.String r1 = r5.nonce
                r3 = 0
                if (r1 == 0) goto L_0x001d
                byte[] r1 = android.util.Base64.decode(r1, r3)
                goto L_0x001e
            L_0x001d:
                r1 = 0
            L_0x001e:
                if (r1 != 0) goto L_0x0022
                byte[] r1 = new byte[r3]
            L_0x0022:
                byte[] r0 = kotlin.collections.ArraysKt.plus((byte[]) r0, (byte[]) r1)
                java.lang.String r1 = r5.urlPath
                java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8
                byte[] r1 = r1.getBytes(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                byte[] r0 = kotlin.collections.ArraysKt.plus((byte[]) r0, (byte[]) r1)
                java.lang.String r1 = r5.postParamsHashHeader
                if (r1 == 0) goto L_0x0044
                java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8
                byte[] r1 = r1.getBytes(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                if (r1 != 0) goto L_0x0046
            L_0x0044:
                byte[] r1 = new byte[r3]
            L_0x0046:
                byte[] r0 = kotlin.collections.ArraysKt.plus((byte[]) r0, (byte[]) r1)
                java.lang.String r1 = r5.requestTime
                java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8
                byte[] r1 = r1.getBytes(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                byte[] r0 = kotlin.collections.ArraysKt.plus((byte[]) r0, (byte[]) r1)
                java.lang.String r1 = r5.eTag
                if (r1 == 0) goto L_0x0068
                java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8
                byte[] r1 = r1.getBytes(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                if (r1 != 0) goto L_0x006a
            L_0x0068:
                byte[] r1 = new byte[r3]
            L_0x006a:
                byte[] r0 = kotlin.collections.ArraysKt.plus((byte[]) r0, (byte[]) r1)
                java.lang.String r1 = r5.body
                if (r1 == 0) goto L_0x007d
                java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8
                byte[] r1 = r1.getBytes(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                if (r1 != 0) goto L_0x007f
            L_0x007d:
                byte[] r1 = new byte[r3]
            L_0x007f:
                byte[] r0 = kotlin.collections.ArraysKt.plus((byte[]) r0, (byte[]) r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.verification.SigningManager.Parameters.toSignatureToVerify():byte[]");
        }
    }

    public final boolean shouldVerifyEndpoint(Endpoint endpoint) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        return endpoint.getSupportsSignatureVerification() && this.signatureVerificationMode.getShouldVerify();
    }

    public final String createRandomNonce() {
        byte[] bArr = new byte[12];
        new SecureRandom().nextBytes(bArr);
        byte[] encode = Base64.encode(bArr, 0);
        Intrinsics.checkNotNullExpressionValue(encode, "encode(bytes, Base64.DEFAULT)");
        return StringsKt.trim((CharSequence) new String(encode, Charsets.UTF_8)).toString();
    }

    public final String getPostParamsForSigningHeaderIfNeeded(Endpoint endpoint, List<Pair<String, String>> list) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Collection collection = list;
        if (collection == null || collection.isEmpty() || !shouldVerifyEndpoint(endpoint)) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        Iterable iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        int i = 0;
        for (Object next : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) next;
            if (i > 0) {
                instance.update((byte) 0);
            }
            byte[] bytes = ((String) pair.getSecond()).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            instance.update(bytes);
            arrayList.add(Unit.INSTANCE);
            i = i2;
        }
        List list2 = (List) arrayList;
        byte[] digest = instance.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "sha256Digest.digest()");
        String str = "";
        for (byte valueOf : digest) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(valueOf)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            sb.append(format);
            str = sb.toString();
        }
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(CollectionsKt.joinToString$default(iterable, f.a, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, SigningManager$getPostParamsForSigningHeaderIfNeeded$header$1.INSTANCE, 30, (Object) null), POST_PARAMS_ALGORITHM, str), Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final VerificationResult verifyResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8 = str;
        String str9 = str2;
        Intrinsics.checkNotNullParameter(str8, "urlPath");
        if (this.appConfig.getForceSigningErrors()) {
            LogUtilsKt.warnLog("Forcing signing error for request with path: " + str8);
            return VerificationResult.FAILED;
        }
        IntermediateSignatureHelper intermediateSignatureHelper = this.signatureVerificationMode.getIntermediateSignatureHelper();
        if (intermediateSignatureHelper == null) {
            return VerificationResult.NOT_REQUESTED;
        }
        if (str9 == null) {
            String format = String.format(NetworkStrings.VERIFICATION_MISSING_SIGNATURE, Arrays.copyOf(new Object[]{str8}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogUtilsKt.errorLog$default(format, (Throwable) null, 2, (Object) null);
            return VerificationResult.FAILED;
        } else if (str5 == null) {
            String format2 = String.format(NetworkStrings.VERIFICATION_MISSING_REQUEST_TIME, Arrays.copyOf(new Object[]{str8}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
            LogUtilsKt.errorLog$default(format2, (Throwable) null, 2, (Object) null);
            return VerificationResult.FAILED;
        } else if (str4 == null && str6 == null) {
            String format3 = String.format(NetworkStrings.VERIFICATION_MISSING_BODY_OR_ETAG, Arrays.copyOf(new Object[]{str8}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
            LogUtilsKt.errorLog$default(format3, (Throwable) null, 2, (Object) null);
            return VerificationResult.FAILED;
        } else {
            try {
                Signature fromString$purchases_defaultsRelease = Signature.Companion.fromString$purchases_defaultsRelease(str9);
                Result<SignatureVerifier, PurchasesError> createIntermediateKeyVerifierIfVerified = intermediateSignatureHelper.createIntermediateKeyVerifierIfVerified(fromString$purchases_defaultsRelease);
                if (createIntermediateKeyVerifierIfVerified instanceof Result.Error) {
                    String format4 = String.format(NetworkStrings.VERIFICATION_INTERMEDIATE_KEY_FAILED, Arrays.copyOf(new Object[]{str8, ((PurchasesError) ((Result.Error) createIntermediateKeyVerifierIfVerified).getValue()).getUnderlyingErrorMessage()}, 2));
                    Intrinsics.checkNotNullExpressionValue(format4, "format(this, *args)");
                    LogUtilsKt.errorLog$default(format4, (Throwable) null, 2, (Object) null);
                    return VerificationResult.FAILED;
                } else if (createIntermediateKeyVerifierIfVerified instanceof Result.Success) {
                    if (((SignatureVerifier) ((Result.Success) createIntermediateKeyVerifierIfVerified).getValue()).verify(fromString$purchases_defaultsRelease.getPayload(), new Parameters(fromString$purchases_defaultsRelease.getSalt(), this.apiKey, str3, str, str7, str5, str6, str4).toSignatureToVerify())) {
                        String format5 = String.format(NetworkStrings.VERIFICATION_SUCCESS, Arrays.copyOf(new Object[]{str8}, 1));
                        Intrinsics.checkNotNullExpressionValue(format5, "format(this, *args)");
                        LogUtilsKt.verboseLog(format5);
                        return VerificationResult.VERIFIED;
                    }
                    String format6 = String.format(NetworkStrings.VERIFICATION_ERROR, Arrays.copyOf(new Object[]{str8}, 1));
                    Intrinsics.checkNotNullExpressionValue(format6, "format(this, *args)");
                    LogUtilsKt.errorLog$default(format6, (Throwable) null, 2, (Object) null);
                    return VerificationResult.FAILED;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } catch (InvalidSignatureSizeException e) {
                String format7 = String.format(NetworkStrings.VERIFICATION_INVALID_SIZE, Arrays.copyOf(new Object[]{str8, e.getMessage()}, 2));
                Intrinsics.checkNotNullExpressionValue(format7, "format(this, *args)");
                LogUtilsKt.errorLog$default(format7, (Throwable) null, 2, (Object) null);
                return VerificationResult.FAILED;
            }
        }
    }
}
