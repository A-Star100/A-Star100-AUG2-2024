package expo.modules.kotlin.functions;

import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0010\u001a\u00020\u00062\u0010\b\u0004\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\bø\u0001\u0000¢\u0006\u0002\b\u0013J,\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0004\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0012H\bø\u0001\u0000JI\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\u00140\u0016H\bø\u0001\u0000Jf\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u0001\"\u0006\b\u0002\u0010\u0019\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u000328\b\u0004\u0010\u0011\u001a2\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\u0019¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00140\u001aH\bø\u0001\u0000J\u0001\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u0001\"\u0006\b\u0002\u0010\u0019\u0018\u0001\"\u0006\b\u0003\u0010\u001c\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032M\b\u0004\u0010\u0011\u001aG\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\u0019¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u0002H\u00140\u001dH\bø\u0001\u0000J \u0001\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u0001\"\u0006\b\u0002\u0010\u0019\u0018\u0001\"\u0006\b\u0003\u0010\u001c\u0018\u0001\"\u0006\b\u0004\u0010\u001f\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032b\b\u0004\u0010\u0011\u001a\\\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\u0019¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\u0004\u0012\u0002H\u00140 H\bø\u0001\u0000J½\u0001\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u0001\"\u0006\b\u0002\u0010\u0019\u0018\u0001\"\u0006\b\u0003\u0010\u001c\u0018\u0001\"\u0006\b\u0004\u0010\u001f\u0018\u0001\"\u0006\b\u0005\u0010\"\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032w\b\u0004\u0010\u0011\u001aq\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\u0019¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0004\u0012\u0002H\u00140#H\bø\u0001\u0000JÜ\u0001\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u0001\"\u0006\b\u0002\u0010\u0019\u0018\u0001\"\u0006\b\u0003\u0010\u001c\u0018\u0001\"\u0006\b\u0004\u0010\u001f\u0018\u0001\"\u0006\b\u0005\u0010\"\u0018\u0001\"\u0006\b\u0006\u0010%\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0001\b\u0004\u0010\u0011\u001a\u0001\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\u0019¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b('\u0012\u0004\u0012\u0002H\u00140&H\bø\u0001\u0000Jù\u0001\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u0001\"\u0006\b\u0002\u0010\u0019\u0018\u0001\"\u0006\b\u0003\u0010\u001c\u0018\u0001\"\u0006\b\u0004\u0010\u001f\u0018\u0001\"\u0006\b\u0005\u0010\"\u0018\u0001\"\u0006\b\u0006\u0010%\u0018\u0001\"\u0006\b\u0007\u0010(\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032¢\u0001\b\u0004\u0010\u0011\u001a\u0001\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\u0019¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(*\u0012\u0004\u0012\u0002H\u00140)H\bø\u0001\u0000J\u0002\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u0001\"\u0006\b\u0002\u0010\u0019\u0018\u0001\"\u0006\b\u0003\u0010\u001c\u0018\u0001\"\u0006\b\u0004\u0010\u001f\u0018\u0001\"\u0006\b\u0005\u0010\"\u0018\u0001\"\u0006\b\u0006\u0010%\u0018\u0001\"\u0006\b\u0007\u0010(\u0018\u0001\"\u0006\b\b\u0010+\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032·\u0001\b\u0004\u0010\u0011\u001a°\u0001\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\u0019¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(*\u0012\u0013\u0012\u0011H+¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(-\u0012\u0004\u0012\u0002H\u00140,H\bø\u0001\u0000J\r\u0010.\u001a\u00020\u0006H\u0000¢\u0006\u0002\b/R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\u000f\u0002\u0007\n\u0005\b20\u0001¨\u00060"}, d2 = {"Lexpo/modules/kotlin/functions/FunctionBuilder;", "", "name", "", "(Ljava/lang/String;)V", "functionComponent", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getFunctionComponent$annotations", "()V", "getFunctionComponent", "()Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "setFunctionComponent", "(Lexpo/modules/kotlin/functions/SyncFunctionComponent;)V", "getName$annotations", "getName", "()Ljava/lang/String;", "Body", "body", "Lkotlin/Function0;", "BodyWithoutArgs", "R", "P0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "build", "build$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: FunctionBuilder.kt */
public final class FunctionBuilder {
    private SyncFunctionComponent functionComponent;
    private final String name;

    public static /* synthetic */ void getFunctionComponent$annotations() {
    }

    public static /* synthetic */ void getName$annotations() {
    }

    public final SyncFunctionComponent getFunctionComponent() {
        return this.functionComponent;
    }

    public final String getName() {
        return this.name;
    }

    public final void setFunctionComponent(SyncFunctionComponent syncFunctionComponent) {
        this.functionComponent = syncFunctionComponent;
    }

    public FunctionBuilder(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    public final SyncFunctionComponent BodyWithoutArgs(Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, TtmlNode.TAG_BODY);
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(getName(), new AnyType[0], new FunctionBuilder$Body$1(function0));
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R> SyncFunctionComponent Body(String str, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, TtmlNode.TAG_BODY);
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, new AnyType[0], new FunctionBuilder$Body$3(function0));
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> SyncFunctionComponent Body(String str, Function1<? super P0, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, TtmlNode.TAG_BODY);
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, FunctionBuilder$Body$$inlined$toArgsArray$default$1.INSTANCE))}, new FunctionBuilder$Body$5(function1));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1> SyncFunctionComponent Body(String str, Function2<? super P0, ? super P1, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function2, TtmlNode.TAG_BODY);
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, FunctionBuilder$Body$$inlined$toArgsArray$default$2.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, FunctionBuilder$Body$$inlined$toArgsArray$default$3.INSTANCE))}, new FunctionBuilder$Body$7(function2));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> SyncFunctionComponent Body(String str, Function3<? super P0, ? super P1, ? super P2, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function3, TtmlNode.TAG_BODY);
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, FunctionBuilder$Body$$inlined$toArgsArray$default$4.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, FunctionBuilder$Body$$inlined$toArgsArray$default$5.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, FunctionBuilder$Body$$inlined$toArgsArray$default$6.INSTANCE))}, new FunctionBuilder$Body$9(function3));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> SyncFunctionComponent Body(String str, Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function4, TtmlNode.TAG_BODY);
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, FunctionBuilder$Body$$inlined$toArgsArray$default$7.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, FunctionBuilder$Body$$inlined$toArgsArray$default$8.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, FunctionBuilder$Body$$inlined$toArgsArray$default$9.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, FunctionBuilder$Body$$inlined$toArgsArray$default$10.INSTANCE))}, new FunctionBuilder$Body$11(function4));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> SyncFunctionComponent Body(String str, Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> function5) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function5, TtmlNode.TAG_BODY);
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P4");
        Class cls5 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, FunctionBuilder$Body$$inlined$toArgsArray$default$11.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, FunctionBuilder$Body$$inlined$toArgsArray$default$12.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, FunctionBuilder$Body$$inlined$toArgsArray$default$13.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, FunctionBuilder$Body$$inlined$toArgsArray$default$14.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, FunctionBuilder$Body$$inlined$toArgsArray$default$15.INSTANCE))}, new FunctionBuilder$Body$13(function5));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> SyncFunctionComponent Body(String str, Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> function6) {
        String str2 = str;
        Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> function62 = function6;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function62, TtmlNode.TAG_BODY);
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P4");
        Class cls5 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P5");
        Class cls6 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, FunctionBuilder$Body$$inlined$toArgsArray$default$16.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, FunctionBuilder$Body$$inlined$toArgsArray$default$17.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, FunctionBuilder$Body$$inlined$toArgsArray$default$18.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, FunctionBuilder$Body$$inlined$toArgsArray$default$19.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, FunctionBuilder$Body$$inlined$toArgsArray$default$20.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, FunctionBuilder$Body$$inlined$toArgsArray$default$21.INSTANCE))}, new FunctionBuilder$Body$15(function62));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> SyncFunctionComponent Body(String str, Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function7) {
        String str2 = str;
        Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function72 = function7;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function72, TtmlNode.TAG_BODY);
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P4");
        Class cls5 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P5");
        Class cls6 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P6");
        Class cls7 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, FunctionBuilder$Body$$inlined$toArgsArray$default$22.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, FunctionBuilder$Body$$inlined$toArgsArray$default$23.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, FunctionBuilder$Body$$inlined$toArgsArray$default$24.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, FunctionBuilder$Body$$inlined$toArgsArray$default$25.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, FunctionBuilder$Body$$inlined$toArgsArray$default$26.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, FunctionBuilder$Body$$inlined$toArgsArray$default$27.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, FunctionBuilder$Body$$inlined$toArgsArray$default$28.INSTANCE))}, new FunctionBuilder$Body$17(function72));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> SyncFunctionComponent Body(String str, Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function8) {
        Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function82 = function8;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function82, TtmlNode.TAG_BODY);
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P4");
        Class cls5 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P5");
        Class cls6 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P6");
        Class cls7 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P7");
        Class cls8 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        String str2 = str;
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, FunctionBuilder$Body$$inlined$toArgsArray$default$29.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, FunctionBuilder$Body$$inlined$toArgsArray$default$30.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, FunctionBuilder$Body$$inlined$toArgsArray$default$31.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, FunctionBuilder$Body$$inlined$toArgsArray$default$32.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, FunctionBuilder$Body$$inlined$toArgsArray$default$33.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, FunctionBuilder$Body$$inlined$toArgsArray$default$34.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, FunctionBuilder$Body$$inlined$toArgsArray$default$35.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass8, false, FunctionBuilder$Body$$inlined$toArgsArray$default$36.INSTANCE))}, new FunctionBuilder$Body$19(function82));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final SyncFunctionComponent build$expo_modules_core_release() {
        SyncFunctionComponent syncFunctionComponent = this.functionComponent;
        if (syncFunctionComponent != null) {
            return syncFunctionComponent;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
