package expo.modules.kotlin.classcomponent;

import com.amazon.a.a.o.b;
import expo.modules.kotlin.functions.AnyFunction;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis;
import expo.modules.kotlin.sharedobjects.SharedRef;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
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
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u0015\u001a\u00020\f2\u000e\b\u0004\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\bø\u0001\u0000J9\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u00012#\b\u0004\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00028\u00000\u0019H\bø\u0001\u0000JV\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u000128\b\u0004\u0010\u0016\u001a2\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00028\u00000\u001dH\bø\u0001\u0000Js\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u00012M\b\u0004\u0010\u0016\u001aG\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0004\u0012\u00028\u00000 H\bø\u0001\u0000J\u0001\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010\"\u0018\u00012b\b\u0004\u0010\u0016\u001a\\\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0004\u0012\u00028\u00000#H\bø\u0001\u0000J­\u0001\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010\"\u0018\u0001\"\u0006\b\u0005\u0010%\u0018\u00012w\b\u0004\u0010\u0016\u001aq\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b('\u0012\u0004\u0012\u00028\u00000&H\bø\u0001\u0000JÌ\u0001\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010\"\u0018\u0001\"\u0006\b\u0005\u0010%\u0018\u0001\"\u0006\b\u0006\u0010(\u0018\u00012\u0001\b\u0004\u0010\u0016\u001a\u0001\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(*\u0012\u0004\u0012\u00028\u00000)H\bø\u0001\u0000Jé\u0001\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010\"\u0018\u0001\"\u0006\b\u0005\u0010%\u0018\u0001\"\u0006\b\u0006\u0010(\u0018\u0001\"\u0006\b\u0007\u0010+\u0018\u00012¢\u0001\b\u0004\u0010\u0016\u001a\u0001\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(*\u0012\u0013\u0012\u0011H+¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(-\u0012\u0004\u0012\u00028\u00000,H\bø\u0001\u0000J\u0002\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010\"\u0018\u0001\"\u0006\b\u0005\u0010%\u0018\u0001\"\u0006\b\u0006\u0010(\u0018\u0001\"\u0006\b\u0007\u0010+\u0018\u0001\"\u0006\b\b\u0010.\u0018\u00012·\u0001\b\u0004\u0010\u0016\u001a°\u0001\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(*\u0012\u0013\u0012\u0011H+¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(-\u0012\u0013\u0012\u0011H.¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(0\u0012\u0004\u0012\u00028\u00000/H\bø\u0001\u0000J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00028\u0000022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016JE\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002\"\u0004\b\u0001\u001032\u0006\u0010\u0004\u001a\u00020\u00052#\b\u0004\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002H30\u0019H\bø\u0001\u0000J\u0006\u00105\u001a\u000206R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u0002\u0007\n\u0005\b20\u0001¨\u00067"}, d2 = {"Lexpo/modules/kotlin/classcomponent/ClassComponentBuilder;", "SharedObjectType", "", "Lexpo/modules/kotlin/objects/ObjectDefinitionBuilder;", "name", "", "ownerClass", "Lkotlin/reflect/KClass;", "ownerType", "Lkotlin/reflect/KType;", "(Ljava/lang/String;Lkotlin/reflect/KClass;Lkotlin/reflect/KType;)V", "constructor", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getConstructor", "()Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "setConstructor", "(Lexpo/modules/kotlin/functions/SyncFunctionComponent;)V", "getName", "()Ljava/lang/String;", "getOwnerType", "()Lkotlin/reflect/KType;", "Constructor", "body", "Lkotlin/Function0;", "P0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "Property", "Lexpo/modules/kotlin/objects/PropertyComponentBuilderWithThis;", "T", "owner", "buildClass", "Lexpo/modules/kotlin/classcomponent/ClassDefinitionData;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ClassComponentBuilder.kt */
public final class ClassComponentBuilder<SharedObjectType> extends ObjectDefinitionBuilder {
    private SyncFunctionComponent constructor;
    private final String name;
    private final KClass<SharedObjectType> ownerClass;
    private final KType ownerType;

    public final SyncFunctionComponent getConstructor() {
        return this.constructor;
    }

    public final String getName() {
        return this.name;
    }

    public final KType getOwnerType() {
        return this.ownerType;
    }

    public final void setConstructor(SyncFunctionComponent syncFunctionComponent) {
        this.constructor = syncFunctionComponent;
    }

    public ClassComponentBuilder(String str, KClass<SharedObjectType> kClass, KType kType) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(kClass, "ownerClass");
        Intrinsics.checkNotNullParameter(kType, "ownerType");
        this.name = str;
        this.ownerClass = kClass;
        this.ownerType = kType;
    }

    public final ClassDefinitionData buildClass() {
        ObjectDefinitionData buildObject = buildObject();
        Iterator functions = buildObject.getFunctions();
        while (functions.hasNext()) {
            AnyFunction anyFunction = (AnyFunction) functions.next();
            anyFunction.setOwnerType(this.ownerType);
            anyFunction.setCanTakeOwner(true);
        }
        if (this.ownerClass == Reflection.getOrCreateKotlinClass(Unit.class) || this.constructor != null || KClasses.isSubclassOf(this.ownerClass, Reflection.getOrCreateKotlinClass(SharedRef.class))) {
            SyncFunctionComponent syncFunctionComponent = this.constructor;
            if (syncFunctionComponent == null) {
                syncFunctionComponent = new SyncFunctionComponent("constructor", new AnyType[0], ClassComponentBuilder$buildClass$constructor$1.INSTANCE);
            }
            syncFunctionComponent.setCanTakeOwner(true);
            syncFunctionComponent.setOwnerType(this.ownerType);
            return new ClassDefinitionData(this.name, syncFunctionComponent, buildObject);
        }
        throw new IllegalArgumentException("constructor cannot be null");
    }

    public final SyncFunctionComponent Constructor(Function0<? extends SharedObjectType> function0) {
        Intrinsics.checkNotNullParameter(function0, TtmlNode.TAG_BODY);
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", new AnyType[0], new ClassComponentBuilder$Constructor$1(function0));
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0> SyncFunctionComponent Constructor(Function1<? super P0, ? extends SharedObjectType> function1) {
        Intrinsics.checkNotNullParameter(function1, TtmlNode.TAG_BODY);
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$1.INSTANCE))}, new ClassComponentBuilder$Constructor$3(function1));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1> SyncFunctionComponent Constructor(Function2<? super P0, ? super P1, ? extends SharedObjectType> function2) {
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
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$2.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$3.INSTANCE))}, new ClassComponentBuilder$Constructor$5(function2));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2> SyncFunctionComponent Constructor(Function3<? super P0, ? super P1, ? super P2, ? extends SharedObjectType> function3) {
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
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$4.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$5.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$6.INSTANCE))}, new ClassComponentBuilder$Constructor$7(function3));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3> SyncFunctionComponent Constructor(Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends SharedObjectType> function4) {
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
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$7.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$8.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$9.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$10.INSTANCE))}, new ClassComponentBuilder$Constructor$9(function4));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4> SyncFunctionComponent Constructor(Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends SharedObjectType> function5) {
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
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$11.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$12.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$13.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$14.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$15.INSTANCE))}, new ClassComponentBuilder$Constructor$11(function5));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4, P5> SyncFunctionComponent Constructor(Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends SharedObjectType> function6) {
        Intrinsics.checkNotNullParameter(function6, TtmlNode.TAG_BODY);
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
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$16.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$17.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$18.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$19.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$20.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$21.INSTANCE))}, new ClassComponentBuilder$Constructor$13(function6));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4, P5, P6> SyncFunctionComponent Constructor(Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends SharedObjectType> function7) {
        Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends SharedObjectType> function72 = function7;
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
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$22.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$23.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$24.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$25.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$26.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$27.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$28.INSTANCE))}, new ClassComponentBuilder$Constructor$15(function72));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4, P5, P6, P7> SyncFunctionComponent Constructor(Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends SharedObjectType> function8) {
        Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends SharedObjectType> function82 = function8;
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
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$29.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$30.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$31.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$32.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$33.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$34.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$35.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass8, false, ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$36.INSTANCE))}, new ClassComponentBuilder$Constructor$17(function82));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final <T> PropertyComponentBuilderWithThis<SharedObjectType> Property(String str, Function1<? super SharedObjectType, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, TtmlNode.TAG_BODY);
        PropertyComponentBuilderWithThis<SharedObjectType> propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis<>(getOwnerType(), str);
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(b.ar, new AnyType[]{new AnyType(propertyComponentBuilderWithThis.getThisType())}, new PropertyComponentBuilderWithThis$get$1$1(function1));
        syncFunctionComponent.setOwnerType(propertyComponentBuilderWithThis.getThisType());
        syncFunctionComponent.setCanTakeOwner(true);
        propertyComponentBuilderWithThis.setGetter(syncFunctionComponent);
        getProperties().put(str, propertyComponentBuilderWithThis);
        return propertyComponentBuilderWithThis;
    }

    public PropertyComponentBuilderWithThis<SharedObjectType> Property(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        PropertyComponentBuilderWithThis<SharedObjectType> propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis<>(this.ownerType, str);
        getProperties().put(str, propertyComponentBuilderWithThis);
        return propertyComponentBuilderWithThis;
    }
}
