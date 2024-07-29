package expo.modules.crypto;

import android.util.Base64;
import androidx.tracing.Trace;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.typedarray.TypedArray;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.security.MessageDigest;
import java.security.SecureRandom;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0010H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"Lexpo/modules/crypto/CryptoModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "secureRandom", "Ljava/security/SecureRandom;", "getSecureRandom", "()Ljava/security/SecureRandom;", "secureRandom$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "digest", "", "algorithm", "Lexpo/modules/crypto/DigestAlgorithm;", "output", "Lexpo/modules/kotlin/typedarray/TypedArray;", "data", "digestString", "", "options", "Lexpo/modules/crypto/DigestOptions;", "getRandomBase64String", "randomByteCount", "", "getRandomValues", "typedArray", "expo-crypto_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CryptoModule.kt */
public final class CryptoModule extends Module {
    private final Lazy secureRandom$delegate = LazyKt.lazy(CryptoModule$secureRandom$2.INSTANCE);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CryptoModule.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                expo.modules.crypto.DigestOptions$Encoding[] r0 = expo.modules.crypto.DigestOptions.Encoding.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                expo.modules.crypto.DigestOptions$Encoding r1 = expo.modules.crypto.DigestOptions.Encoding.BASE64     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                expo.modules.crypto.DigestOptions$Encoding r1 = expo.modules.crypto.DigestOptions.Encoding.HEX     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.crypto.CryptoModule.WhenMappings.<clinit>():void");
        }
    }

    private final SecureRandom getSecureRandom() {
        return (SecureRandom) this.secureRandom$delegate.getValue();
    }

    public ModuleDefinitionData definition() {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunction2;
        AsyncFunction asyncFunctionComponent;
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name("ExpoCrypto");
            Class<DigestAlgorithm> cls = DigestAlgorithm.class;
            Class<String> cls2 = String.class;
            Class<DigestOptions> cls3 = DigestOptions.class;
            moduleDefinitionBuilder.getSyncFunctions().put("digestString", new SyncFunctionComponent("digestString", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestAlgorithm.class), false, CryptoModule$definition$lambda$6$$inlined$Function$1.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, CryptoModule$definition$lambda$6$$inlined$Function$2.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestOptions.class), false, CryptoModule$definition$lambda$6$$inlined$Function$3.INSTANCE))}, new CryptoModule$definition$lambda$6$$inlined$Function$4(this)));
            ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
            Class<DigestAlgorithm> cls4 = DigestAlgorithm.class;
            Class<String> cls5 = String.class;
            Class<DigestOptions> cls6 = DigestOptions.class;
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestAlgorithm.class), false, CryptoModule$definition$lambda$6$$inlined$AsyncFunction$1.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, CryptoModule$definition$lambda$6$$inlined$AsyncFunction$2.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestOptions.class), false, CryptoModule$definition$lambda$6$$inlined$AsyncFunction$3.INSTANCE))};
            Function1 cryptoModule$definition$lambda$6$$inlined$AsyncFunction$4 = new CryptoModule$definition$lambda$6$$inlined$AsyncFunction$4(this);
            Class<String> cls7 = String.class;
            if (Intrinsics.areEqual((Object) cls7, (Object) Integer.TYPE)) {
                asyncFunction = new IntAsyncFunctionComponent("digestStringAsync", anyTypeArr, cryptoModule$definition$lambda$6$$inlined$AsyncFunction$4);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) Boolean.TYPE)) {
                asyncFunction = new BoolAsyncFunctionComponent("digestStringAsync", anyTypeArr, cryptoModule$definition$lambda$6$$inlined$AsyncFunction$4);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) Double.TYPE)) {
                asyncFunction = new DoubleAsyncFunctionComponent("digestStringAsync", anyTypeArr, cryptoModule$definition$lambda$6$$inlined$AsyncFunction$4);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) Float.TYPE)) {
                asyncFunction = new FloatAsyncFunctionComponent("digestStringAsync", anyTypeArr, cryptoModule$definition$lambda$6$$inlined$AsyncFunction$4);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) String.class)) {
                asyncFunction = new StringAsyncFunctionComponent("digestStringAsync", anyTypeArr, cryptoModule$definition$lambda$6$$inlined$AsyncFunction$4);
            } else {
                asyncFunction = new AsyncFunctionComponent("digestStringAsync", anyTypeArr, cryptoModule$definition$lambda$6$$inlined$AsyncFunction$4);
            }
            objectDefinitionBuilder.getAsyncFunctions().put("digestStringAsync", asyncFunction);
            Class<Integer> cls8 = Integer.class;
            moduleDefinitionBuilder.getSyncFunctions().put("getRandomBase64String", new SyncFunctionComponent("getRandomBase64String", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, CryptoModule$definition$lambda$6$$inlined$Function$5.INSTANCE))}, new CryptoModule$definition$lambda$6$$inlined$Function$6(this)));
            ObjectDefinitionBuilder objectDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Integer.class, (Object) Promise.class)) {
                asyncFunction2 = new AsyncFunctionWithPromiseComponent("getRandomBase64StringAsync", new AnyType[0], new CryptoModule$definition$lambda$6$$inlined$AsyncFunction$5(this));
            } else {
                Class<Integer> cls9 = Integer.class;
                AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, CryptoModule$definition$lambda$6$$inlined$AsyncFunction$6.INSTANCE))};
                Function1 cryptoModule$definition$lambda$6$$inlined$AsyncFunction$7 = new CryptoModule$definition$lambda$6$$inlined$AsyncFunction$7(this);
                Class<String> cls10 = String.class;
                if (Intrinsics.areEqual((Object) cls10, (Object) Integer.TYPE)) {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("getRandomBase64StringAsync", anyTypeArr2, cryptoModule$definition$lambda$6$$inlined$AsyncFunction$7);
                } else if (Intrinsics.areEqual((Object) cls10, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("getRandomBase64StringAsync", anyTypeArr2, cryptoModule$definition$lambda$6$$inlined$AsyncFunction$7);
                } else if (Intrinsics.areEqual((Object) cls10, (Object) Double.TYPE)) {
                    asyncFunctionComponent = new DoubleAsyncFunctionComponent("getRandomBase64StringAsync", anyTypeArr2, cryptoModule$definition$lambda$6$$inlined$AsyncFunction$7);
                } else if (Intrinsics.areEqual((Object) cls10, (Object) Float.TYPE)) {
                    asyncFunctionComponent = new FloatAsyncFunctionComponent("getRandomBase64StringAsync", anyTypeArr2, cryptoModule$definition$lambda$6$$inlined$AsyncFunction$7);
                } else if (Intrinsics.areEqual((Object) cls10, (Object) String.class)) {
                    asyncFunctionComponent = new StringAsyncFunctionComponent("getRandomBase64StringAsync", anyTypeArr2, cryptoModule$definition$lambda$6$$inlined$AsyncFunction$7);
                } else {
                    asyncFunctionComponent = new AsyncFunctionComponent("getRandomBase64StringAsync", anyTypeArr2, cryptoModule$definition$lambda$6$$inlined$AsyncFunction$7);
                }
                asyncFunction2 = asyncFunctionComponent;
            }
            objectDefinitionBuilder2.getAsyncFunctions().put("getRandomBase64StringAsync", asyncFunction2);
            Class<TypedArray> cls11 = TypedArray.class;
            moduleDefinitionBuilder.getSyncFunctions().put("getRandomValues", new SyncFunctionComponent("getRandomValues", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(TypedArray.class), false, CryptoModule$definition$lambda$6$$inlined$Function$7.INSTANCE))}, new CryptoModule$definition$lambda$6$$inlined$Function$8(this)));
            Class<DigestAlgorithm> cls12 = DigestAlgorithm.class;
            Class<TypedArray> cls13 = TypedArray.class;
            Class<TypedArray> cls14 = TypedArray.class;
            moduleDefinitionBuilder.getSyncFunctions().put("digest", new SyncFunctionComponent("digest", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestAlgorithm.class), false, CryptoModule$definition$lambda$6$$inlined$Function$9.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(TypedArray.class), false, CryptoModule$definition$lambda$6$$inlined$Function$10.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(TypedArray.class), false, CryptoModule$definition$lambda$6$$inlined$Function$11.INSTANCE))}, new CryptoModule$definition$lambda$6$$inlined$Function$12(this)));
            moduleDefinitionBuilder.getSyncFunctions().put("randomUUID", new SyncFunctionComponent("randomUUID", new AnyType[0], new CryptoModule$definition$lambda$6$$inlined$FunctionWithoutArgs$1()));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* access modifiers changed from: private */
    public final String getRandomBase64String(int i) {
        byte[] bArr = new byte[i];
        getSecureRandom().nextBytes(bArr);
        String encodeToString = Base64.encodeToString(bArr, 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(...)");
        return encodeToString;
    }

    /* access modifiers changed from: private */
    public final String digestString(DigestAlgorithm digestAlgorithm, String str, DigestOptions digestOptions) {
        MessageDigest instance = MessageDigest.getInstance(digestAlgorithm.getValue());
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        instance.update(bytes);
        byte[] digest = instance.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        int i = WhenMappings.$EnumSwitchMapping$0[digestOptions.getEncoding().ordinal()];
        if (i == 1) {
            String encodeToString = Base64.encodeToString(digest, 2);
            Intrinsics.checkNotNull(encodeToString);
            return encodeToString;
        } else if (i == 2) {
            return ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) CryptoModule$digestString$1.INSTANCE, 30, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public final void digest(DigestAlgorithm digestAlgorithm, TypedArray typedArray, TypedArray typedArray2) {
        MessageDigest instance = MessageDigest.getInstance(digestAlgorithm.getValue());
        instance.update(typedArray2.toDirectBuffer());
        byte[] digest = instance.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        typedArray.write(digest, typedArray.getByteOffset(), typedArray.getByteLength());
    }

    /* access modifiers changed from: private */
    public final void getRandomValues(TypedArray typedArray) {
        byte[] bArr = new byte[typedArray.getByteLength()];
        getSecureRandom().nextBytes(bArr);
        typedArray.write(bArr, typedArray.getByteOffset(), typedArray.getByteLength());
    }
}
