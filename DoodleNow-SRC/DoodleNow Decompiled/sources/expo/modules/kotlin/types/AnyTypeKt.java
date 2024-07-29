package expo.modules.kotlin.types;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\b\u001a,\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\b¢\u0006\u0002\u0010\b\u001aD\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0007H\b¢\u0006\u0002\u0010\u000b\u001a\\\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u0007H\b¢\u0006\u0002\u0010\u000e\u001at\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00072\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0007H\b¢\u0006\u0002\u0010\u0011\u001a\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00072\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00072\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0007H\b¢\u0006\u0002\u0010\u0014\u001a¤\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00072\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00072\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00072\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0007H\b¢\u0006\u0002\u0010\u0017\u001a¼\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00072\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00072\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00072\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00072\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0007H\b¢\u0006\u0002\u0010\u001a\u001aÔ\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u0001\"\u0006\b\u0007\u0010\u001b\u0018\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00072\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00072\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00072\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00072\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00072\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0007H\b¢\u0006\u0002\u0010\u001d\u001a\u001e\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00020\u001f0\u001eH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006 "}, d2 = {"toAnyType", "Lexpo/modules/kotlin/types/AnyType;", "T", "toArgsArray", "", "P0", "p0", "Ljava/lang/Class;", "(Ljava/lang/Class;)[Lexpo/modules/kotlin/types/AnyType;", "P1", "p1", "(Ljava/lang/Class;Ljava/lang/Class;)[Lexpo/modules/kotlin/types/AnyType;", "P2", "p2", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)[Lexpo/modules/kotlin/types/AnyType;", "P3", "p3", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)[Lexpo/modules/kotlin/types/AnyType;", "P4", "p4", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)[Lexpo/modules/kotlin/types/AnyType;", "P5", "p5", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)[Lexpo/modules/kotlin/types/AnyType;", "P6", "p6", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)[Lexpo/modules/kotlin/types/AnyType;", "P7", "p7", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)[Lexpo/modules/kotlin/types/AnyType;", "Lkotlin/Function0;", "Lkotlin/reflect/KType;", "expo-modules-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: AnyType.kt */
public final class AnyTypeKt {
    public static final /* synthetic */ <T> AnyType toAnyType(Function0<? extends KType> function0) {
        Intrinsics.checkNotNullParameter(function0, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "T");
        return new AnyType(new LazyKType(orCreateKotlinClass, false, function0));
    }

    public static final /* synthetic */ <T> AnyType toAnyType() {
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "T");
        return new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toAnyType$1.INSTANCE));
    }

    public static /* synthetic */ AnyType[] toArgsArray$default(Class<Object> cls, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            cls = Object.class;
            Class cls2 = cls;
        }
        Intrinsics.checkNotNullParameter(cls, "p0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$1.INSTANCE))};
    }

    public static /* synthetic */ AnyType[] toArgsArray$default(Class<Object> cls, Class<Object> cls2, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            cls = Object.class;
            Class cls3 = cls;
        }
        if ((i & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P1");
            cls2 = Object.class;
            Class cls4 = cls2;
        }
        Intrinsics.checkNotNullParameter(cls, "p0");
        Intrinsics.checkNotNullParameter(cls2, "p1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$2.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$3.INSTANCE))};
    }

    public static /* synthetic */ AnyType[] toArgsArray$default(Class<Object> cls, Class<Object> cls2, Class<Object> cls3, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            cls = Object.class;
            Class cls4 = cls;
        }
        if ((i & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P1");
            cls2 = Object.class;
            Class cls5 = cls2;
        }
        if ((i & 4) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P2");
            cls3 = Object.class;
            Class cls6 = cls3;
        }
        Intrinsics.checkNotNullParameter(cls, "p0");
        Intrinsics.checkNotNullParameter(cls2, "p1");
        Intrinsics.checkNotNullParameter(cls3, "p2");
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
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$4.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$5.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$6.INSTANCE))};
    }

    public static /* synthetic */ AnyType[] toArgsArray$default(Class<Object> cls, Class<Object> cls2, Class<Object> cls3, Class<Object> cls4, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            cls = Object.class;
            Class cls5 = cls;
        }
        if ((i & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P1");
            cls2 = Object.class;
            Class cls6 = cls2;
        }
        if ((i & 4) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P2");
            cls3 = Object.class;
            Class cls7 = cls3;
        }
        if ((i & 8) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P3");
            cls4 = Object.class;
            Class cls8 = cls4;
        }
        Intrinsics.checkNotNullParameter(cls, "p0");
        Intrinsics.checkNotNullParameter(cls2, "p1");
        Intrinsics.checkNotNullParameter(cls3, "p2");
        Intrinsics.checkNotNullParameter(cls4, "p3");
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
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$7.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$8.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$9.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$10.INSTANCE))};
    }

    public static /* synthetic */ AnyType[] toArgsArray$default(Class<Object> cls, Class<Object> cls2, Class<Object> cls3, Class<Object> cls4, Class<Object> cls5, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            cls = Object.class;
            Class cls6 = cls;
        }
        if ((i & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P1");
            cls2 = Object.class;
            Class cls7 = cls2;
        }
        if ((i & 4) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P2");
            cls3 = Object.class;
            Class cls8 = cls3;
        }
        if ((i & 8) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P3");
            cls4 = Object.class;
            Class cls9 = cls4;
        }
        if ((i & 16) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P4");
            cls5 = Object.class;
            Class cls10 = cls5;
        }
        Intrinsics.checkNotNullParameter(cls, "p0");
        Intrinsics.checkNotNullParameter(cls2, "p1");
        Intrinsics.checkNotNullParameter(cls3, "p2");
        Intrinsics.checkNotNullParameter(cls4, "p3");
        Intrinsics.checkNotNullParameter(cls5, "p4");
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
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$11.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$12.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$13.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$14.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$15.INSTANCE))};
    }

    public static /* synthetic */ AnyType[] toArgsArray$default(Class<Object> cls, Class<Object> cls2, Class<Object> cls3, Class<Object> cls4, Class<Object> cls5, Class<Object> cls6, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            cls = Object.class;
            Class cls7 = cls;
        }
        if ((i & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P1");
            cls2 = Object.class;
            Class cls8 = cls2;
        }
        if ((i & 4) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P2");
            cls3 = Object.class;
            Class cls9 = cls3;
        }
        if ((i & 8) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P3");
            cls4 = Object.class;
            Class cls10 = cls4;
        }
        if ((i & 16) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P4");
            cls5 = Object.class;
            Class cls11 = cls5;
        }
        if ((i & 32) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P5");
            cls6 = Object.class;
            Class cls12 = cls6;
        }
        Intrinsics.checkNotNullParameter(cls, "p0");
        Intrinsics.checkNotNullParameter(cls2, "p1");
        Intrinsics.checkNotNullParameter(cls3, "p2");
        Intrinsics.checkNotNullParameter(cls4, "p3");
        Intrinsics.checkNotNullParameter(cls5, "p4");
        Intrinsics.checkNotNullParameter(cls6, "p5");
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
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$16.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$17.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$18.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$19.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$20.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$21.INSTANCE))};
    }

    public static /* synthetic */ AnyType[] toArgsArray$default(Class<Object> cls, Class<Object> cls2, Class<Object> cls3, Class<Object> cls4, Class<Object> cls5, Class<Object> cls6, Class<Object> cls7, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            cls = Object.class;
            Class cls8 = cls;
        }
        if ((i & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P1");
            cls2 = Object.class;
            Class cls9 = cls2;
        }
        if ((i & 4) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P2");
            cls3 = Object.class;
            Class cls10 = cls3;
        }
        if ((i & 8) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P3");
            cls4 = Object.class;
            Class cls11 = cls4;
        }
        if ((i & 16) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P4");
            cls5 = Object.class;
            Class cls12 = cls5;
        }
        if ((i & 32) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P5");
            cls6 = Object.class;
            Class cls13 = cls6;
        }
        if ((i & 64) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P6");
            cls7 = Object.class;
            Class cls14 = cls7;
        }
        Intrinsics.checkNotNullParameter(cls, "p0");
        Intrinsics.checkNotNullParameter(cls2, "p1");
        Intrinsics.checkNotNullParameter(cls3, "p2");
        Intrinsics.checkNotNullParameter(cls4, "p3");
        Intrinsics.checkNotNullParameter(cls5, "p4");
        Intrinsics.checkNotNullParameter(cls6, "p5");
        Intrinsics.checkNotNullParameter(cls7, "p6");
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
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$22.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$23.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$24.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$25.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$26.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$27.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$28.INSTANCE))};
    }

    public static /* synthetic */ AnyType[] toArgsArray$default(Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Class cls8, int i, Object obj) {
        Class cls9;
        Class cls10;
        Class cls11;
        Class cls12;
        Class cls13;
        Class cls14;
        Class cls15;
        Class cls16;
        int i2 = i;
        if ((i2 & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            cls9 = Object.class;
            Class cls17 = cls9;
        } else {
            cls9 = cls;
        }
        if ((i2 & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P1");
            cls10 = Object.class;
            Class cls18 = cls10;
        } else {
            cls10 = cls2;
        }
        if ((i2 & 4) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P2");
            cls11 = Object.class;
            Class cls19 = cls11;
        } else {
            cls11 = cls3;
        }
        if ((i2 & 8) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P3");
            cls12 = Object.class;
            Class cls20 = cls12;
        } else {
            cls12 = cls4;
        }
        if ((i2 & 16) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P4");
            cls13 = Object.class;
            Class cls21 = cls13;
        } else {
            cls13 = cls5;
        }
        if ((i2 & 32) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P5");
            cls14 = Object.class;
            Class cls22 = cls14;
        } else {
            cls14 = cls6;
        }
        if ((i2 & 64) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P6");
            cls15 = Object.class;
            Class cls23 = cls15;
        } else {
            cls15 = cls7;
        }
        String str = "P6";
        if ((i2 & 128) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P7");
            cls16 = Object.class;
            Class cls24 = cls16;
        } else {
            cls16 = cls8;
        }
        Intrinsics.checkNotNullParameter(cls9, "p0");
        Intrinsics.checkNotNullParameter(cls10, "p1");
        Intrinsics.checkNotNullParameter(cls11, "p2");
        Intrinsics.checkNotNullParameter(cls12, "p3");
        Intrinsics.checkNotNullParameter(cls13, "p4");
        Intrinsics.checkNotNullParameter(cls14, "p5");
        Intrinsics.checkNotNullParameter(cls15, "p6");
        Intrinsics.checkNotNullParameter(cls16, "p7");
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
        String str2 = str;
        Intrinsics.reifiedOperationMarker(4, str2);
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, str2);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$29.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$30.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$31.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$32.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$33.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$34.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$35.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass8, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$36.INSTANCE))};
    }

    public static final /* synthetic */ <P0> AnyType[] toArgsArray(Class<P0> cls) {
        Intrinsics.checkNotNullParameter(cls, "p0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$1.INSTANCE))};
    }

    public static final /* synthetic */ <P0, P1> AnyType[] toArgsArray(Class<P0> cls, Class<P1> cls2) {
        Intrinsics.checkNotNullParameter(cls, "p0");
        Intrinsics.checkNotNullParameter(cls2, "p1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$2.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$3.INSTANCE))};
    }

    public static final /* synthetic */ <P0, P1, P2> AnyType[] toArgsArray(Class<P0> cls, Class<P1> cls2, Class<P2> cls3) {
        Intrinsics.checkNotNullParameter(cls, "p0");
        Intrinsics.checkNotNullParameter(cls2, "p1");
        Intrinsics.checkNotNullParameter(cls3, "p2");
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
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$4.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$5.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$6.INSTANCE))};
    }

    public static final /* synthetic */ <P0, P1, P2, P3> AnyType[] toArgsArray(Class<P0> cls, Class<P1> cls2, Class<P2> cls3, Class<P3> cls4) {
        Intrinsics.checkNotNullParameter(cls, "p0");
        Intrinsics.checkNotNullParameter(cls2, "p1");
        Intrinsics.checkNotNullParameter(cls3, "p2");
        Intrinsics.checkNotNullParameter(cls4, "p3");
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
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$7.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$8.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$9.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$10.INSTANCE))};
    }

    public static final /* synthetic */ <P0, P1, P2, P3, P4> AnyType[] toArgsArray(Class<P0> cls, Class<P1> cls2, Class<P2> cls3, Class<P3> cls4, Class<P4> cls5) {
        Intrinsics.checkNotNullParameter(cls, "p0");
        Intrinsics.checkNotNullParameter(cls2, "p1");
        Intrinsics.checkNotNullParameter(cls3, "p2");
        Intrinsics.checkNotNullParameter(cls4, "p3");
        Intrinsics.checkNotNullParameter(cls5, "p4");
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
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$11.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$12.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$13.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$14.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$15.INSTANCE))};
    }

    public static final /* synthetic */ <P0, P1, P2, P3, P4, P5> AnyType[] toArgsArray(Class<P0> cls, Class<P1> cls2, Class<P2> cls3, Class<P3> cls4, Class<P4> cls5, Class<P5> cls6) {
        Intrinsics.checkNotNullParameter(cls, "p0");
        Intrinsics.checkNotNullParameter(cls2, "p1");
        Intrinsics.checkNotNullParameter(cls3, "p2");
        Intrinsics.checkNotNullParameter(cls4, "p3");
        Intrinsics.checkNotNullParameter(cls5, "p4");
        Intrinsics.checkNotNullParameter(cls6, "p5");
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
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$16.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$17.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$18.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$19.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$20.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$21.INSTANCE))};
    }

    public static final /* synthetic */ <P0, P1, P2, P3, P4, P5, P6> AnyType[] toArgsArray(Class<P0> cls, Class<P1> cls2, Class<P2> cls3, Class<P3> cls4, Class<P4> cls5, Class<P5> cls6, Class<P6> cls7) {
        Intrinsics.checkNotNullParameter(cls, "p0");
        Intrinsics.checkNotNullParameter(cls2, "p1");
        Intrinsics.checkNotNullParameter(cls3, "p2");
        Intrinsics.checkNotNullParameter(cls4, "p3");
        Intrinsics.checkNotNullParameter(cls5, "p4");
        Intrinsics.checkNotNullParameter(cls6, "p5");
        Intrinsics.checkNotNullParameter(cls7, "p6");
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
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$22.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$23.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$24.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$25.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$26.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$27.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$28.INSTANCE))};
    }

    public static final /* synthetic */ <P0, P1, P2, P3, P4, P5, P6, P7> AnyType[] toArgsArray(Class<P0> cls, Class<P1> cls2, Class<P2> cls3, Class<P3> cls4, Class<P4> cls5, Class<P5> cls6, Class<P6> cls7, Class<P7> cls8) {
        Intrinsics.checkNotNullParameter(cls, "p0");
        Intrinsics.checkNotNullParameter(cls2, "p1");
        Intrinsics.checkNotNullParameter(cls3, "p2");
        Intrinsics.checkNotNullParameter(cls4, "p3");
        Intrinsics.checkNotNullParameter(cls5, "p4");
        Intrinsics.checkNotNullParameter(cls6, "p5");
        Intrinsics.checkNotNullParameter(cls7, "p6");
        Intrinsics.checkNotNullParameter(cls8, "p7");
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
        return new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$29.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$30.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$31.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$32.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$33.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$34.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$35.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass8, false, AnyTypeKt$toArgsArray$$inlined$toAnyType$36.INSTANCE))};
    }
}
