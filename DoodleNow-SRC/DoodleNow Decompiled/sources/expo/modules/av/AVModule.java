package expo.modules.av;

import androidx.tracing.Trace;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lexpo/modules/av/AVModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "_avManager", "Lexpo/modules/av/AVManagerInterface;", "get_avManager", "()Lexpo/modules/av/AVManagerInterface;", "_avManager$delegate", "Lkotlin/Lazy;", "avManager", "getAvManager", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-av_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AVModule.kt */
public final class AVModule extends Module {
    private final Lazy _avManager$delegate = LazyKt.lazy(new AVModule$_avManager$2(this));

    private final AVManagerInterface get_avManager() {
        return (AVManagerInterface) this._avManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final AVManagerInterface getAvManager() {
        AVManagerInterface aVManagerInterface = get_avManager();
        if (aVManagerInterface != null) {
            return aVManagerInterface;
        }
        throw new AVManagerModuleNotFound();
    }

    public ModuleDefinitionData definition() {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunction2;
        AsyncFunction asyncFunction3;
        AsyncFunction asyncFunction4;
        AsyncFunction asyncFunction5;
        AsyncFunction asyncFunction6;
        AsyncFunction asyncFunction7;
        AsyncFunction asyncFunction8;
        AsyncFunction asyncFunction9;
        AsyncFunction asyncFunction10;
        AsyncFunction asyncFunction11;
        AsyncFunction asyncFunctionComponent;
        AsyncFunction asyncFunctionComponent2;
        AsyncFunction asyncFunctionComponent3;
        AsyncFunction asyncFunctionComponent4;
        AsyncFunction asyncFunctionComponent5;
        AsyncFunction asyncFunctionComponent6;
        AsyncFunction asyncFunctionComponent7;
        AsyncFunction asyncFunctionComponent8;
        AsyncFunction asyncFunctionComponent9;
        AsyncFunction asyncFunctionComponent10;
        AsyncFunction asyncFunctionComponent11;
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name("ExponentAV");
            moduleDefinitionBuilder.Events("didUpdatePlaybackStatus", "ExponentAV.onError", "Expo.Recording.recorderUnloaded");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new AVModule$definition$lambda$24$$inlined$OnCreate$1(this)));
            ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Boolean.class, (Object) Promise.class)) {
                asyncFunction = new AsyncFunctionWithPromiseComponent("setAudioIsEnabled", new AnyType[0], new AVModule$definition$lambda$24$$inlined$AsyncFunction$1(this));
            } else {
                Class<Boolean> cls = Boolean.class;
                AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunction$2.INSTANCE))};
                Function1 aVModule$definition$lambda$24$$inlined$AsyncFunction$3 = new AVModule$definition$lambda$24$$inlined$AsyncFunction$3(this);
                Class<Unit> cls2 = Unit.class;
                if (Intrinsics.areEqual((Object) cls2, (Object) Integer.TYPE)) {
                    asyncFunctionComponent11 = new IntAsyncFunctionComponent("setAudioIsEnabled", anyTypeArr, aVModule$definition$lambda$24$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent11 = new BoolAsyncFunctionComponent("setAudioIsEnabled", anyTypeArr, aVModule$definition$lambda$24$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) Double.TYPE)) {
                    asyncFunctionComponent11 = new DoubleAsyncFunctionComponent("setAudioIsEnabled", anyTypeArr, aVModule$definition$lambda$24$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) Float.TYPE)) {
                    asyncFunctionComponent11 = new FloatAsyncFunctionComponent("setAudioIsEnabled", anyTypeArr, aVModule$definition$lambda$24$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) String.class)) {
                    asyncFunctionComponent11 = new StringAsyncFunctionComponent("setAudioIsEnabled", anyTypeArr, aVModule$definition$lambda$24$$inlined$AsyncFunction$3);
                } else {
                    asyncFunctionComponent11 = new AsyncFunctionComponent("setAudioIsEnabled", anyTypeArr, aVModule$definition$lambda$24$$inlined$AsyncFunction$3);
                }
                asyncFunction = asyncFunctionComponent11;
            }
            objectDefinitionBuilder.getAsyncFunctions().put("setAudioIsEnabled", asyncFunction);
            ObjectDefinitionBuilder objectDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) ReadableArguments.class, (Object) Promise.class)) {
                asyncFunction2 = new AsyncFunctionWithPromiseComponent("setAudioMode", new AnyType[0], new AVModule$definition$lambda$24$$inlined$AsyncFunction$4(this));
            } else {
                Class<ReadableArguments> cls3 = ReadableArguments.class;
                AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunction$5.INSTANCE))};
                Function1 aVModule$definition$lambda$24$$inlined$AsyncFunction$6 = new AVModule$definition$lambda$24$$inlined$AsyncFunction$6(this);
                Class<Unit> cls4 = Unit.class;
                if (Intrinsics.areEqual((Object) cls4, (Object) Integer.TYPE)) {
                    asyncFunctionComponent10 = new IntAsyncFunctionComponent("setAudioMode", anyTypeArr2, aVModule$definition$lambda$24$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent10 = new BoolAsyncFunctionComponent("setAudioMode", anyTypeArr2, aVModule$definition$lambda$24$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Double.TYPE)) {
                    asyncFunctionComponent10 = new DoubleAsyncFunctionComponent("setAudioMode", anyTypeArr2, aVModule$definition$lambda$24$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Float.TYPE)) {
                    asyncFunctionComponent10 = new FloatAsyncFunctionComponent("setAudioMode", anyTypeArr2, aVModule$definition$lambda$24$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) String.class)) {
                    asyncFunctionComponent10 = new StringAsyncFunctionComponent("setAudioMode", anyTypeArr2, aVModule$definition$lambda$24$$inlined$AsyncFunction$6);
                } else {
                    asyncFunctionComponent10 = new AsyncFunctionComponent("setAudioMode", anyTypeArr2, aVModule$definition$lambda$24$$inlined$AsyncFunction$6);
                }
                asyncFunction2 = asyncFunctionComponent10;
            }
            objectDefinitionBuilder2.getAsyncFunctions().put("setAudioMode", asyncFunction2);
            Class<ReadableArguments> cls5 = ReadableArguments.class;
            Class<ReadableArguments> cls6 = ReadableArguments.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("loadForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$1.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$2.INSTANCE))}, new AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$3(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("loadForSound", asyncFunctionWithPromiseComponent);
            AsyncFunction asyncFunction12 = asyncFunctionWithPromiseComponent;
            Class<Integer> cls7 = Integer.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("unloadForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$4.INSTANCE))}, new AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$5(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("unloadForSound", asyncFunctionWithPromiseComponent2);
            AsyncFunction asyncFunction13 = asyncFunctionWithPromiseComponent2;
            Class<Integer> cls8 = Integer.class;
            Class<ReadableArguments> cls9 = ReadableArguments.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("setStatusForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$6.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$7.INSTANCE))}, new AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$8(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("setStatusForSound", asyncFunctionWithPromiseComponent3);
            AsyncFunction asyncFunction14 = asyncFunctionWithPromiseComponent3;
            Class<Integer> cls10 = Integer.class;
            Class<ReadableArguments> cls11 = ReadableArguments.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("replaySound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$9.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$10.INSTANCE))}, new AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$11(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("replaySound", asyncFunctionWithPromiseComponent4);
            AsyncFunction asyncFunction15 = asyncFunctionWithPromiseComponent4;
            Class<Integer> cls12 = Integer.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent5 = new AsyncFunctionWithPromiseComponent("getStatusForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$12.INSTANCE))}, new AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$13(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("getStatusForSound", asyncFunctionWithPromiseComponent5);
            AsyncFunction asyncFunction16 = asyncFunctionWithPromiseComponent5;
            Class<Integer> cls13 = Integer.class;
            Class<ReadableArguments> cls14 = ReadableArguments.class;
            Class<ReadableArguments> cls15 = ReadableArguments.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent6 = new AsyncFunctionWithPromiseComponent("loadForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$14.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), true, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$15.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), true, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$16.INSTANCE))}, new AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$17(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("loadForVideo", asyncFunctionWithPromiseComponent6);
            AsyncFunction asyncFunction17 = asyncFunctionWithPromiseComponent6;
            Class<Integer> cls16 = Integer.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent7 = new AsyncFunctionWithPromiseComponent("unloadForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$18.INSTANCE))}, new AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$19(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("unloadForVideo", asyncFunctionWithPromiseComponent7);
            AsyncFunction asyncFunction18 = asyncFunctionWithPromiseComponent7;
            Class<Integer> cls17 = Integer.class;
            Class<ReadableArguments> cls18 = ReadableArguments.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent8 = new AsyncFunctionWithPromiseComponent("setStatusForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$20.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$21.INSTANCE))}, new AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$22(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("setStatusForVideo", asyncFunctionWithPromiseComponent8);
            AsyncFunction asyncFunction19 = asyncFunctionWithPromiseComponent8;
            Class<Integer> cls19 = Integer.class;
            Class<ReadableArguments> cls20 = ReadableArguments.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent9 = new AsyncFunctionWithPromiseComponent("replayVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$23.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$24.INSTANCE))}, new AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$25(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("replayVideo", asyncFunctionWithPromiseComponent9);
            AsyncFunction asyncFunction20 = asyncFunctionWithPromiseComponent9;
            Class<Integer> cls21 = Integer.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent10 = new AsyncFunctionWithPromiseComponent("getStatusForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$26.INSTANCE))}, new AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$27(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("getStatusForVideo", asyncFunctionWithPromiseComponent10);
            AsyncFunction asyncFunction21 = asyncFunctionWithPromiseComponent10;
            Class<ReadableArguments> cls22 = ReadableArguments.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent11 = new AsyncFunctionWithPromiseComponent("prepareAudioRecorder", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$28.INSTANCE))}, new AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$29(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("prepareAudioRecorder", asyncFunctionWithPromiseComponent11);
            AsyncFunction asyncFunction22 = asyncFunctionWithPromiseComponent11;
            ObjectDefinitionBuilder objectDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Promise.class, (Object) Promise.class)) {
                asyncFunction3 = new AsyncFunctionWithPromiseComponent("getAvailableInputs", new AnyType[0], new AVModule$definition$lambda$24$$inlined$AsyncFunction$7(this));
            } else {
                Class<Promise> cls23 = Promise.class;
                AnyType[] anyTypeArr3 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunction$8.INSTANCE))};
                Function1 aVModule$definition$lambda$24$$inlined$AsyncFunction$9 = new AVModule$definition$lambda$24$$inlined$AsyncFunction$9(this);
                Class<Unit> cls24 = Unit.class;
                if (Intrinsics.areEqual((Object) cls24, (Object) Integer.TYPE)) {
                    asyncFunctionComponent9 = new IntAsyncFunctionComponent("getAvailableInputs", anyTypeArr3, aVModule$definition$lambda$24$$inlined$AsyncFunction$9);
                } else if (Intrinsics.areEqual((Object) cls24, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent9 = new BoolAsyncFunctionComponent("getAvailableInputs", anyTypeArr3, aVModule$definition$lambda$24$$inlined$AsyncFunction$9);
                } else if (Intrinsics.areEqual((Object) cls24, (Object) Double.TYPE)) {
                    asyncFunctionComponent9 = new DoubleAsyncFunctionComponent("getAvailableInputs", anyTypeArr3, aVModule$definition$lambda$24$$inlined$AsyncFunction$9);
                } else if (Intrinsics.areEqual((Object) cls24, (Object) Float.TYPE)) {
                    asyncFunctionComponent9 = new FloatAsyncFunctionComponent("getAvailableInputs", anyTypeArr3, aVModule$definition$lambda$24$$inlined$AsyncFunction$9);
                } else if (Intrinsics.areEqual((Object) cls24, (Object) String.class)) {
                    asyncFunctionComponent9 = new StringAsyncFunctionComponent("getAvailableInputs", anyTypeArr3, aVModule$definition$lambda$24$$inlined$AsyncFunction$9);
                } else {
                    asyncFunctionComponent9 = new AsyncFunctionComponent("getAvailableInputs", anyTypeArr3, aVModule$definition$lambda$24$$inlined$AsyncFunction$9);
                }
                asyncFunction3 = asyncFunctionComponent9;
            }
            objectDefinitionBuilder3.getAsyncFunctions().put("getAvailableInputs", asyncFunction3);
            ObjectDefinitionBuilder objectDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Promise.class, (Object) Promise.class)) {
                asyncFunction4 = new AsyncFunctionWithPromiseComponent("getCurrentInput", new AnyType[0], new AVModule$definition$lambda$24$$inlined$AsyncFunction$10(this));
            } else {
                Class<Promise> cls25 = Promise.class;
                AnyType[] anyTypeArr4 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunction$11.INSTANCE))};
                Function1 aVModule$definition$lambda$24$$inlined$AsyncFunction$12 = new AVModule$definition$lambda$24$$inlined$AsyncFunction$12(this);
                Class<Unit> cls26 = Unit.class;
                if (Intrinsics.areEqual((Object) cls26, (Object) Integer.TYPE)) {
                    asyncFunctionComponent8 = new IntAsyncFunctionComponent("getCurrentInput", anyTypeArr4, aVModule$definition$lambda$24$$inlined$AsyncFunction$12);
                } else if (Intrinsics.areEqual((Object) cls26, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent8 = new BoolAsyncFunctionComponent("getCurrentInput", anyTypeArr4, aVModule$definition$lambda$24$$inlined$AsyncFunction$12);
                } else if (Intrinsics.areEqual((Object) cls26, (Object) Double.TYPE)) {
                    asyncFunctionComponent8 = new DoubleAsyncFunctionComponent("getCurrentInput", anyTypeArr4, aVModule$definition$lambda$24$$inlined$AsyncFunction$12);
                } else if (Intrinsics.areEqual((Object) cls26, (Object) Float.TYPE)) {
                    asyncFunctionComponent8 = new FloatAsyncFunctionComponent("getCurrentInput", anyTypeArr4, aVModule$definition$lambda$24$$inlined$AsyncFunction$12);
                } else if (Intrinsics.areEqual((Object) cls26, (Object) String.class)) {
                    asyncFunctionComponent8 = new StringAsyncFunctionComponent("getCurrentInput", anyTypeArr4, aVModule$definition$lambda$24$$inlined$AsyncFunction$12);
                } else {
                    asyncFunctionComponent8 = new AsyncFunctionComponent("getCurrentInput", anyTypeArr4, aVModule$definition$lambda$24$$inlined$AsyncFunction$12);
                }
                asyncFunction4 = asyncFunctionComponent8;
            }
            objectDefinitionBuilder4.getAsyncFunctions().put("getCurrentInput", asyncFunction4);
            Class<String> cls27 = String.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent12 = new AsyncFunctionWithPromiseComponent("setInput", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$30.INSTANCE))}, new AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$31(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("setInput", asyncFunctionWithPromiseComponent12);
            AsyncFunction asyncFunction23 = asyncFunctionWithPromiseComponent12;
            ObjectDefinitionBuilder objectDefinitionBuilder5 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Promise.class, (Object) Promise.class)) {
                asyncFunction5 = new AsyncFunctionWithPromiseComponent("startAudioRecording", new AnyType[0], new AVModule$definition$lambda$24$$inlined$AsyncFunction$13(this));
            } else {
                Class<Promise> cls28 = Promise.class;
                AnyType[] anyTypeArr5 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunction$14.INSTANCE))};
                Function1 aVModule$definition$lambda$24$$inlined$AsyncFunction$15 = new AVModule$definition$lambda$24$$inlined$AsyncFunction$15(this);
                Class<Unit> cls29 = Unit.class;
                if (Intrinsics.areEqual((Object) cls29, (Object) Integer.TYPE)) {
                    asyncFunctionComponent7 = new IntAsyncFunctionComponent("startAudioRecording", anyTypeArr5, aVModule$definition$lambda$24$$inlined$AsyncFunction$15);
                } else if (Intrinsics.areEqual((Object) cls29, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent7 = new BoolAsyncFunctionComponent("startAudioRecording", anyTypeArr5, aVModule$definition$lambda$24$$inlined$AsyncFunction$15);
                } else if (Intrinsics.areEqual((Object) cls29, (Object) Double.TYPE)) {
                    asyncFunctionComponent7 = new DoubleAsyncFunctionComponent("startAudioRecording", anyTypeArr5, aVModule$definition$lambda$24$$inlined$AsyncFunction$15);
                } else if (Intrinsics.areEqual((Object) cls29, (Object) Float.TYPE)) {
                    asyncFunctionComponent7 = new FloatAsyncFunctionComponent("startAudioRecording", anyTypeArr5, aVModule$definition$lambda$24$$inlined$AsyncFunction$15);
                } else if (Intrinsics.areEqual((Object) cls29, (Object) String.class)) {
                    asyncFunctionComponent7 = new StringAsyncFunctionComponent("startAudioRecording", anyTypeArr5, aVModule$definition$lambda$24$$inlined$AsyncFunction$15);
                } else {
                    asyncFunctionComponent7 = new AsyncFunctionComponent("startAudioRecording", anyTypeArr5, aVModule$definition$lambda$24$$inlined$AsyncFunction$15);
                }
                asyncFunction5 = asyncFunctionComponent7;
            }
            objectDefinitionBuilder5.getAsyncFunctions().put("startAudioRecording", asyncFunction5);
            ObjectDefinitionBuilder objectDefinitionBuilder6 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Promise.class, (Object) Promise.class)) {
                asyncFunction6 = new AsyncFunctionWithPromiseComponent("pauseAudioRecording", new AnyType[0], new AVModule$definition$lambda$24$$inlined$AsyncFunction$16(this));
            } else {
                Class<Promise> cls30 = Promise.class;
                AnyType[] anyTypeArr6 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunction$17.INSTANCE))};
                Function1 aVModule$definition$lambda$24$$inlined$AsyncFunction$18 = new AVModule$definition$lambda$24$$inlined$AsyncFunction$18(this);
                Class<Unit> cls31 = Unit.class;
                if (Intrinsics.areEqual((Object) cls31, (Object) Integer.TYPE)) {
                    asyncFunctionComponent6 = new IntAsyncFunctionComponent("pauseAudioRecording", anyTypeArr6, aVModule$definition$lambda$24$$inlined$AsyncFunction$18);
                } else if (Intrinsics.areEqual((Object) cls31, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent6 = new BoolAsyncFunctionComponent("pauseAudioRecording", anyTypeArr6, aVModule$definition$lambda$24$$inlined$AsyncFunction$18);
                } else if (Intrinsics.areEqual((Object) cls31, (Object) Double.TYPE)) {
                    asyncFunctionComponent6 = new DoubleAsyncFunctionComponent("pauseAudioRecording", anyTypeArr6, aVModule$definition$lambda$24$$inlined$AsyncFunction$18);
                } else if (Intrinsics.areEqual((Object) cls31, (Object) Float.TYPE)) {
                    asyncFunctionComponent6 = new FloatAsyncFunctionComponent("pauseAudioRecording", anyTypeArr6, aVModule$definition$lambda$24$$inlined$AsyncFunction$18);
                } else if (Intrinsics.areEqual((Object) cls31, (Object) String.class)) {
                    asyncFunctionComponent6 = new StringAsyncFunctionComponent("pauseAudioRecording", anyTypeArr6, aVModule$definition$lambda$24$$inlined$AsyncFunction$18);
                } else {
                    asyncFunctionComponent6 = new AsyncFunctionComponent("pauseAudioRecording", anyTypeArr6, aVModule$definition$lambda$24$$inlined$AsyncFunction$18);
                }
                asyncFunction6 = asyncFunctionComponent6;
            }
            objectDefinitionBuilder6.getAsyncFunctions().put("pauseAudioRecording", asyncFunction6);
            ObjectDefinitionBuilder objectDefinitionBuilder7 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Promise.class, (Object) Promise.class)) {
                asyncFunction7 = new AsyncFunctionWithPromiseComponent("stopAudioRecording", new AnyType[0], new AVModule$definition$lambda$24$$inlined$AsyncFunction$19(this));
            } else {
                Class<Promise> cls32 = Promise.class;
                AnyType[] anyTypeArr7 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunction$20.INSTANCE))};
                Function1 aVModule$definition$lambda$24$$inlined$AsyncFunction$21 = new AVModule$definition$lambda$24$$inlined$AsyncFunction$21(this);
                Class<Unit> cls33 = Unit.class;
                if (Intrinsics.areEqual((Object) cls33, (Object) Integer.TYPE)) {
                    asyncFunctionComponent5 = new IntAsyncFunctionComponent("stopAudioRecording", anyTypeArr7, aVModule$definition$lambda$24$$inlined$AsyncFunction$21);
                } else if (Intrinsics.areEqual((Object) cls33, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent5 = new BoolAsyncFunctionComponent("stopAudioRecording", anyTypeArr7, aVModule$definition$lambda$24$$inlined$AsyncFunction$21);
                } else if (Intrinsics.areEqual((Object) cls33, (Object) Double.TYPE)) {
                    asyncFunctionComponent5 = new DoubleAsyncFunctionComponent("stopAudioRecording", anyTypeArr7, aVModule$definition$lambda$24$$inlined$AsyncFunction$21);
                } else if (Intrinsics.areEqual((Object) cls33, (Object) Float.TYPE)) {
                    asyncFunctionComponent5 = new FloatAsyncFunctionComponent("stopAudioRecording", anyTypeArr7, aVModule$definition$lambda$24$$inlined$AsyncFunction$21);
                } else if (Intrinsics.areEqual((Object) cls33, (Object) String.class)) {
                    asyncFunctionComponent5 = new StringAsyncFunctionComponent("stopAudioRecording", anyTypeArr7, aVModule$definition$lambda$24$$inlined$AsyncFunction$21);
                } else {
                    asyncFunctionComponent5 = new AsyncFunctionComponent("stopAudioRecording", anyTypeArr7, aVModule$definition$lambda$24$$inlined$AsyncFunction$21);
                }
                asyncFunction7 = asyncFunctionComponent5;
            }
            objectDefinitionBuilder7.getAsyncFunctions().put("stopAudioRecording", asyncFunction7);
            ObjectDefinitionBuilder objectDefinitionBuilder8 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Promise.class, (Object) Promise.class)) {
                asyncFunction8 = new AsyncFunctionWithPromiseComponent("getAudioRecordingStatus", new AnyType[0], new AVModule$definition$lambda$24$$inlined$AsyncFunction$22(this));
            } else {
                Class<Promise> cls34 = Promise.class;
                AnyType[] anyTypeArr8 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunction$23.INSTANCE))};
                Function1 aVModule$definition$lambda$24$$inlined$AsyncFunction$24 = new AVModule$definition$lambda$24$$inlined$AsyncFunction$24(this);
                Class<Unit> cls35 = Unit.class;
                if (Intrinsics.areEqual((Object) cls35, (Object) Integer.TYPE)) {
                    asyncFunctionComponent4 = new IntAsyncFunctionComponent("getAudioRecordingStatus", anyTypeArr8, aVModule$definition$lambda$24$$inlined$AsyncFunction$24);
                } else if (Intrinsics.areEqual((Object) cls35, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent4 = new BoolAsyncFunctionComponent("getAudioRecordingStatus", anyTypeArr8, aVModule$definition$lambda$24$$inlined$AsyncFunction$24);
                } else if (Intrinsics.areEqual((Object) cls35, (Object) Double.TYPE)) {
                    asyncFunctionComponent4 = new DoubleAsyncFunctionComponent("getAudioRecordingStatus", anyTypeArr8, aVModule$definition$lambda$24$$inlined$AsyncFunction$24);
                } else if (Intrinsics.areEqual((Object) cls35, (Object) Float.TYPE)) {
                    asyncFunctionComponent4 = new FloatAsyncFunctionComponent("getAudioRecordingStatus", anyTypeArr8, aVModule$definition$lambda$24$$inlined$AsyncFunction$24);
                } else if (Intrinsics.areEqual((Object) cls35, (Object) String.class)) {
                    asyncFunctionComponent4 = new StringAsyncFunctionComponent("getAudioRecordingStatus", anyTypeArr8, aVModule$definition$lambda$24$$inlined$AsyncFunction$24);
                } else {
                    asyncFunctionComponent4 = new AsyncFunctionComponent("getAudioRecordingStatus", anyTypeArr8, aVModule$definition$lambda$24$$inlined$AsyncFunction$24);
                }
                asyncFunction8 = asyncFunctionComponent4;
            }
            objectDefinitionBuilder8.getAsyncFunctions().put("getAudioRecordingStatus", asyncFunction8);
            ObjectDefinitionBuilder objectDefinitionBuilder9 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Promise.class, (Object) Promise.class)) {
                asyncFunction9 = new AsyncFunctionWithPromiseComponent("unloadAudioRecorder", new AnyType[0], new AVModule$definition$lambda$24$$inlined$AsyncFunction$25(this));
            } else {
                Class<Promise> cls36 = Promise.class;
                AnyType[] anyTypeArr9 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunction$26.INSTANCE))};
                Function1 aVModule$definition$lambda$24$$inlined$AsyncFunction$27 = new AVModule$definition$lambda$24$$inlined$AsyncFunction$27(this);
                Class<Unit> cls37 = Unit.class;
                if (Intrinsics.areEqual((Object) cls37, (Object) Integer.TYPE)) {
                    asyncFunctionComponent3 = new IntAsyncFunctionComponent("unloadAudioRecorder", anyTypeArr9, aVModule$definition$lambda$24$$inlined$AsyncFunction$27);
                } else if (Intrinsics.areEqual((Object) cls37, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent3 = new BoolAsyncFunctionComponent("unloadAudioRecorder", anyTypeArr9, aVModule$definition$lambda$24$$inlined$AsyncFunction$27);
                } else if (Intrinsics.areEqual((Object) cls37, (Object) Double.TYPE)) {
                    asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("unloadAudioRecorder", anyTypeArr9, aVModule$definition$lambda$24$$inlined$AsyncFunction$27);
                } else if (Intrinsics.areEqual((Object) cls37, (Object) Float.TYPE)) {
                    asyncFunctionComponent3 = new FloatAsyncFunctionComponent("unloadAudioRecorder", anyTypeArr9, aVModule$definition$lambda$24$$inlined$AsyncFunction$27);
                } else if (Intrinsics.areEqual((Object) cls37, (Object) String.class)) {
                    asyncFunctionComponent3 = new StringAsyncFunctionComponent("unloadAudioRecorder", anyTypeArr9, aVModule$definition$lambda$24$$inlined$AsyncFunction$27);
                } else {
                    asyncFunctionComponent3 = new AsyncFunctionComponent("unloadAudioRecorder", anyTypeArr9, aVModule$definition$lambda$24$$inlined$AsyncFunction$27);
                }
                asyncFunction9 = asyncFunctionComponent3;
            }
            objectDefinitionBuilder9.getAsyncFunctions().put("unloadAudioRecorder", asyncFunction9);
            ObjectDefinitionBuilder objectDefinitionBuilder10 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Promise.class, (Object) Promise.class)) {
                asyncFunction10 = new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", new AnyType[0], new AVModule$definition$lambda$24$$inlined$AsyncFunction$28(this));
            } else {
                Class<Promise> cls38 = Promise.class;
                AnyType[] anyTypeArr10 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunction$29.INSTANCE))};
                Function1 aVModule$definition$lambda$24$$inlined$AsyncFunction$30 = new AVModule$definition$lambda$24$$inlined$AsyncFunction$30(this);
                Class<Unit> cls39 = Unit.class;
                if (Intrinsics.areEqual((Object) cls39, (Object) Integer.TYPE)) {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr10, aVModule$definition$lambda$24$$inlined$AsyncFunction$30);
                } else if (Intrinsics.areEqual((Object) cls39, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent2 = new BoolAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr10, aVModule$definition$lambda$24$$inlined$AsyncFunction$30);
                } else if (Intrinsics.areEqual((Object) cls39, (Object) Double.TYPE)) {
                    asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr10, aVModule$definition$lambda$24$$inlined$AsyncFunction$30);
                } else if (Intrinsics.areEqual((Object) cls39, (Object) Float.TYPE)) {
                    asyncFunctionComponent2 = new FloatAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr10, aVModule$definition$lambda$24$$inlined$AsyncFunction$30);
                } else if (Intrinsics.areEqual((Object) cls39, (Object) String.class)) {
                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr10, aVModule$definition$lambda$24$$inlined$AsyncFunction$30);
                } else {
                    asyncFunctionComponent2 = new AsyncFunctionComponent("requestPermissionsAsync", anyTypeArr10, aVModule$definition$lambda$24$$inlined$AsyncFunction$30);
                }
                asyncFunction10 = asyncFunctionComponent2;
            }
            objectDefinitionBuilder10.getAsyncFunctions().put("requestPermissionsAsync", asyncFunction10);
            ObjectDefinitionBuilder objectDefinitionBuilder11 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Promise.class, (Object) Promise.class)) {
                asyncFunction11 = new AsyncFunctionWithPromiseComponent("getPermissionsAsync", new AnyType[0], new AVModule$definition$lambda$24$$inlined$AsyncFunction$31(this));
            } else {
                Class<Promise> cls40 = Promise.class;
                AnyType[] anyTypeArr11 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, AVModule$definition$lambda$24$$inlined$AsyncFunction$32.INSTANCE))};
                Function1 aVModule$definition$lambda$24$$inlined$AsyncFunction$33 = new AVModule$definition$lambda$24$$inlined$AsyncFunction$33(this);
                Class<Unit> cls41 = Unit.class;
                if (Intrinsics.areEqual((Object) cls41, (Object) Integer.TYPE)) {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("getPermissionsAsync", anyTypeArr11, aVModule$definition$lambda$24$$inlined$AsyncFunction$33);
                } else if (Intrinsics.areEqual((Object) cls41, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("getPermissionsAsync", anyTypeArr11, aVModule$definition$lambda$24$$inlined$AsyncFunction$33);
                } else if (Intrinsics.areEqual((Object) cls41, (Object) Double.TYPE)) {
                    asyncFunctionComponent = new DoubleAsyncFunctionComponent("getPermissionsAsync", anyTypeArr11, aVModule$definition$lambda$24$$inlined$AsyncFunction$33);
                } else if (Intrinsics.areEqual((Object) cls41, (Object) Float.TYPE)) {
                    asyncFunctionComponent = new FloatAsyncFunctionComponent("getPermissionsAsync", anyTypeArr11, aVModule$definition$lambda$24$$inlined$AsyncFunction$33);
                } else if (Intrinsics.areEqual((Object) cls41, (Object) String.class)) {
                    asyncFunctionComponent = new StringAsyncFunctionComponent("getPermissionsAsync", anyTypeArr11, aVModule$definition$lambda$24$$inlined$AsyncFunction$33);
                } else {
                    asyncFunctionComponent = new AsyncFunctionComponent("getPermissionsAsync", anyTypeArr11, aVModule$definition$lambda$24$$inlined$AsyncFunction$33);
                }
                asyncFunction11 = asyncFunctionComponent;
            }
            objectDefinitionBuilder11.getAsyncFunctions().put("getPermissionsAsync", asyncFunction11);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
