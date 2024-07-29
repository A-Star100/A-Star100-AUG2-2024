package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverter;
import expo.modules.kotlin.types.TypeConverterProviderImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\b\u0003\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0004J2\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00162\u0006\u0010\u0017\u001a\u00020\u0018H ¢\u0006\u0002\u0010\u0019J>\u0010\u0011\u001a\u00028\u00002\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u0016\"\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eR\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lexpo/modules/kotlin/jni/JavaScriptFunction;", "ReturnType", "Lexpo/modules/kotlin/jni/Destructible;", "mHybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "returnType", "Lkotlin/reflect/KType;", "getReturnType$annotations", "()V", "getReturnType", "()Lkotlin/reflect/KType;", "setReturnType", "(Lkotlin/reflect/KType;)V", "deallocate", "", "finalize", "invoke", "", "thisValue", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "args", "", "expectedReturnType", "Lexpo/modules/kotlin/jni/ExpectedType;", "(Lexpo/modules/kotlin/jni/JavaScriptObject;[Ljava/lang/Object;Lexpo/modules/kotlin/jni/ExpectedType;)Ljava/lang/Object;", "appContext", "Lexpo/modules/kotlin/AppContext;", "([Ljava/lang/Object;Lexpo/modules/kotlin/jni/JavaScriptObject;Lexpo/modules/kotlin/AppContext;)Ljava/lang/Object;", "isValid", "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: JavaScriptFunction.kt */
public final class JavaScriptFunction<ReturnType> implements Destructible {
    private final HybridData mHybridData;
    private KType returnType;

    public static /* synthetic */ void getReturnType$annotations() {
    }

    private final native Object invoke(JavaScriptObject javaScriptObject, Object[] objArr, ExpectedType expectedType);

    public final KType getReturnType() {
        return this.returnType;
    }

    public final void setReturnType(KType kType) {
        this.returnType = kType;
    }

    private JavaScriptFunction(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public final boolean isValid() {
        return this.mHybridData.isValid();
    }

    public static /* synthetic */ Object invoke$default(JavaScriptFunction javaScriptFunction, Object[] objArr, JavaScriptObject javaScriptObject, AppContext appContext, int i, Object obj) {
        if ((i & 2) != 0) {
            javaScriptObject = null;
        }
        if ((i & 4) != 0) {
            appContext = null;
        }
        return javaScriptFunction.invoke(objArr, javaScriptObject, appContext);
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        deallocate();
    }

    public void deallocate() {
        this.mHybridData.resetNative();
    }

    public final ReturnType invoke(Object[] objArr, JavaScriptObject javaScriptObject, AppContext appContext) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        Collection arrayList = new ArrayList(objArr.length);
        for (Object convertToJSValue$default : objArr) {
            arrayList.add(JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, convertToJSValue$default, (JSTypeConverter.ContainerProvider) null, 2, (Object) null));
        }
        Object[] array = ((List) arrayList).toArray(new Object[0]);
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        KType kType = this.returnType;
        if (kType == null) {
            kType = new LazyKType(Reflection.getOrCreateKotlinClass(Unit.class), false, JavaScriptFunction$invoke$converter$1.INSTANCE);
        }
        TypeConverter<?> obtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(kType);
        return obtainTypeConverter.convert(invoke(javaScriptObject, array, obtainTypeConverter.getCppRequiredTypes()), appContext);
    }
}
