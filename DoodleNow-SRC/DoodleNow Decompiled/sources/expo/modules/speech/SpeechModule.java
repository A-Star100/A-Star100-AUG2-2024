package expo.modules.speech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import androidx.tracing.Trace;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
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
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lexpo/modules/speech/SpeechModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "_textToSpeech", "Landroid/speech/tts/TextToSpeech;", "_ttsReady", "", "delayedUtterances", "Ljava/util/Queue;", "Lexpo/modules/speech/SpeechModule$Utterance;", "isTextToSpeechReady", "()Z", "textToSpeech", "getTextToSpeech", "()Landroid/speech/tts/TextToSpeech;", "textToSpeech$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "idToMap", "Landroid/os/Bundle;", "id", "", "speakOut", "", "text", "options", "Lexpo/modules/speech/SpeechOptions;", "Utterance", "expo-speech_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SpeechModule.kt */
public final class SpeechModule extends Module {
    /* access modifiers changed from: private */
    public TextToSpeech _textToSpeech;
    /* access modifiers changed from: private */
    public boolean _ttsReady;
    /* access modifiers changed from: private */
    public final Queue<Utterance> delayedUtterances = new ArrayDeque();
    private final Lazy textToSpeech$delegate = LazyKt.lazy(new SpeechModule$textToSpeech$2(this));

    /* access modifiers changed from: private */
    public final boolean isTextToSpeechReady() {
        return this._ttsReady;
    }

    public ModuleDefinitionData definition() {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunction2;
        AsyncFunction asyncFunction3;
        AsyncFunction asyncFunction4;
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name("ExpoSpeech");
            moduleDefinitionBuilder.Events(SpeechModuleKt.speakingStartedEvent, SpeechModuleKt.speakingWillSayNextStringEvent, SpeechModuleKt.speakingDoneEvent, SpeechModuleKt.speakingStoppedEvent, SpeechModuleKt.speakingErrorEvent);
            moduleDefinitionBuilder.Constants((Pair<String, ? extends Object>[]) new Pair[]{TuplesKt.to("maxSpeechInputLength", Integer.valueOf(TextToSpeech.getMaxSpeechInputLength()))});
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_DESTROYS, new BasicEventListener(EventName.ACTIVITY_DESTROYS, new SpeechModule$definition$lambda$6$$inlined$OnActivityDestroys$1(this)));
            ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            Function1 speechModule$definition$lambda$6$$inlined$AsyncFunction$1 = new SpeechModule$definition$lambda$6$$inlined$AsyncFunction$1(this);
            Class<Boolean> cls = Boolean.class;
            if (Intrinsics.areEqual((Object) cls, (Object) Integer.TYPE)) {
                asyncFunction = new IntAsyncFunctionComponent("isSpeaking", anyTypeArr, speechModule$definition$lambda$6$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls, (Object) Boolean.TYPE)) {
                asyncFunction = new BoolAsyncFunctionComponent("isSpeaking", anyTypeArr, speechModule$definition$lambda$6$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls, (Object) Double.TYPE)) {
                asyncFunction = new DoubleAsyncFunctionComponent("isSpeaking", anyTypeArr, speechModule$definition$lambda$6$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls, (Object) Float.TYPE)) {
                asyncFunction = new FloatAsyncFunctionComponent("isSpeaking", anyTypeArr, speechModule$definition$lambda$6$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls, (Object) String.class)) {
                asyncFunction = new StringAsyncFunctionComponent("isSpeaking", anyTypeArr, speechModule$definition$lambda$6$$inlined$AsyncFunction$1);
            } else {
                asyncFunction = new AsyncFunctionComponent("isSpeaking", anyTypeArr, speechModule$definition$lambda$6$$inlined$AsyncFunction$1);
            }
            objectDefinitionBuilder.getAsyncFunctions().put("isSpeaking", asyncFunction);
            ObjectDefinitionBuilder objectDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[0];
            Function1 speechModule$definition$lambda$6$$inlined$AsyncFunction$2 = new SpeechModule$definition$lambda$6$$inlined$AsyncFunction$2(this);
            Class<List> cls2 = List.class;
            if (Intrinsics.areEqual((Object) cls2, (Object) Integer.TYPE)) {
                asyncFunction2 = new IntAsyncFunctionComponent("getVoices", anyTypeArr2, speechModule$definition$lambda$6$$inlined$AsyncFunction$2);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Boolean.TYPE)) {
                asyncFunction2 = new BoolAsyncFunctionComponent("getVoices", anyTypeArr2, speechModule$definition$lambda$6$$inlined$AsyncFunction$2);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Double.TYPE)) {
                asyncFunction2 = new DoubleAsyncFunctionComponent("getVoices", anyTypeArr2, speechModule$definition$lambda$6$$inlined$AsyncFunction$2);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Float.TYPE)) {
                asyncFunction2 = new FloatAsyncFunctionComponent("getVoices", anyTypeArr2, speechModule$definition$lambda$6$$inlined$AsyncFunction$2);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) String.class)) {
                asyncFunction2 = new StringAsyncFunctionComponent("getVoices", anyTypeArr2, speechModule$definition$lambda$6$$inlined$AsyncFunction$2);
            } else {
                asyncFunction2 = new AsyncFunctionComponent("getVoices", anyTypeArr2, speechModule$definition$lambda$6$$inlined$AsyncFunction$2);
            }
            objectDefinitionBuilder2.getAsyncFunctions().put("getVoices", asyncFunction2);
            ObjectDefinitionBuilder objectDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1 speechModule$definition$lambda$6$$inlined$AsyncFunction$3 = new SpeechModule$definition$lambda$6$$inlined$AsyncFunction$3(this);
            Class<Unit> cls3 = Unit.class;
            if (Intrinsics.areEqual((Object) cls3, (Object) Integer.TYPE)) {
                asyncFunction3 = new IntAsyncFunctionComponent("stop", anyTypeArr3, speechModule$definition$lambda$6$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls3, (Object) Boolean.TYPE)) {
                asyncFunction3 = new BoolAsyncFunctionComponent("stop", anyTypeArr3, speechModule$definition$lambda$6$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls3, (Object) Double.TYPE)) {
                asyncFunction3 = new DoubleAsyncFunctionComponent("stop", anyTypeArr3, speechModule$definition$lambda$6$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls3, (Object) Float.TYPE)) {
                asyncFunction3 = new FloatAsyncFunctionComponent("stop", anyTypeArr3, speechModule$definition$lambda$6$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls3, (Object) String.class)) {
                asyncFunction3 = new StringAsyncFunctionComponent("stop", anyTypeArr3, speechModule$definition$lambda$6$$inlined$AsyncFunction$3);
            } else {
                asyncFunction3 = new AsyncFunctionComponent("stop", anyTypeArr3, speechModule$definition$lambda$6$$inlined$AsyncFunction$3);
            }
            objectDefinitionBuilder3.getAsyncFunctions().put("stop", asyncFunction3);
            ObjectDefinitionBuilder objectDefinitionBuilder4 = moduleDefinitionBuilder;
            Class<String> cls4 = String.class;
            Class<String> cls5 = String.class;
            Class<SpeechOptions> cls6 = SpeechOptions.class;
            AnyType[] anyTypeArr4 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, SpeechModule$definition$lambda$6$$inlined$AsyncFunction$4.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, SpeechModule$definition$lambda$6$$inlined$AsyncFunction$5.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SpeechOptions.class), false, SpeechModule$definition$lambda$6$$inlined$AsyncFunction$6.INSTANCE))};
            Function1 speechModule$definition$lambda$6$$inlined$AsyncFunction$7 = new SpeechModule$definition$lambda$6$$inlined$AsyncFunction$7(this);
            Class<Unit> cls7 = Unit.class;
            if (Intrinsics.areEqual((Object) cls7, (Object) Integer.TYPE)) {
                asyncFunction4 = new IntAsyncFunctionComponent("speak", anyTypeArr4, speechModule$definition$lambda$6$$inlined$AsyncFunction$7);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) Boolean.TYPE)) {
                asyncFunction4 = new BoolAsyncFunctionComponent("speak", anyTypeArr4, speechModule$definition$lambda$6$$inlined$AsyncFunction$7);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) Double.TYPE)) {
                asyncFunction4 = new DoubleAsyncFunctionComponent("speak", anyTypeArr4, speechModule$definition$lambda$6$$inlined$AsyncFunction$7);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) Float.TYPE)) {
                asyncFunction4 = new FloatAsyncFunctionComponent("speak", anyTypeArr4, speechModule$definition$lambda$6$$inlined$AsyncFunction$7);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) String.class)) {
                asyncFunction4 = new StringAsyncFunctionComponent("speak", anyTypeArr4, speechModule$definition$lambda$6$$inlined$AsyncFunction$7);
            } else {
                asyncFunction4 = new AsyncFunctionComponent("speak", anyTypeArr4, speechModule$definition$lambda$6$$inlined$AsyncFunction$7);
            }
            objectDefinitionBuilder4.getAsyncFunctions().put("speak", asyncFunction4);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        if (r2 == null) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void speakOut(java.lang.String r5, java.lang.String r6, expo.modules.speech.SpeechOptions r7) {
        /*
            r4 = this;
            java.lang.Float r0 = r7.getPitch()
            if (r0 == 0) goto L_0x0013
            android.speech.tts.TextToSpeech r1 = r4.getTextToSpeech()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            r1.setPitch(r0)
        L_0x0013:
            java.lang.Float r0 = r7.getRate()
            if (r0 == 0) goto L_0x0026
            android.speech.tts.TextToSpeech r1 = r4.getTextToSpeech()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            r1.setSpeechRate(r0)
        L_0x0026:
            android.speech.tts.TextToSpeech r0 = r4.getTextToSpeech()
            java.lang.String r1 = r7.getLanguage()
            if (r1 == 0) goto L_0x004a
            java.util.Locale r2 = new java.util.Locale
            r2.<init>(r1)
            android.speech.tts.TextToSpeech r1 = r4.getTextToSpeech()
            int r1 = r1.isLanguageAvailable(r2)
            r3 = -1
            if (r1 == r3) goto L_0x0044
            r3 = -2
            if (r1 == r3) goto L_0x0044
            goto L_0x0048
        L_0x0044:
            java.util.Locale r2 = java.util.Locale.getDefault()
        L_0x0048:
            if (r2 != 0) goto L_0x004e
        L_0x004a:
            java.util.Locale r2 = java.util.Locale.getDefault()
        L_0x004e:
            r0.setLanguage(r2)
            java.lang.String r7 = r7.getVoice()
            r0 = 0
            if (r7 == 0) goto L_0x008f
            android.speech.tts.TextToSpeech r1 = r4.getTextToSpeech()
            java.util.Set r1 = r1.getVoices()
            java.lang.String r2 = "getVoices(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x006b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0083
            java.lang.Object r2 = r1.next()
            r3 = r2
            android.speech.tts.Voice r3 = (android.speech.tts.Voice) r3
            java.lang.String r3 = r3.getName()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r7)
            if (r3 == 0) goto L_0x006b
            goto L_0x0084
        L_0x0083:
            r2 = r0
        L_0x0084:
            android.speech.tts.Voice r2 = (android.speech.tts.Voice) r2
            if (r2 == 0) goto L_0x008f
            android.speech.tts.TextToSpeech r7 = r4.getTextToSpeech()
            r7.setVoice(r2)
        L_0x008f:
            android.speech.tts.TextToSpeech r7 = r4.getTextToSpeech()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r1 = 1
            r7.speak(r6, r1, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.speech.SpeechModule.speakOut(java.lang.String, java.lang.String, expo.modules.speech.SpeechOptions):void");
    }

    /* access modifiers changed from: private */
    public final TextToSpeech getTextToSpeech() {
        return (TextToSpeech) this.textToSpeech$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Bundle idToMap(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        return bundle;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lexpo/modules/speech/SpeechModule$Utterance;", "", "id", "", "text", "options", "Lexpo/modules/speech/SpeechOptions;", "(Ljava/lang/String;Ljava/lang/String;Lexpo/modules/speech/SpeechOptions;)V", "getId", "()Ljava/lang/String;", "getOptions", "()Lexpo/modules/speech/SpeechOptions;", "getText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "expo-speech_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SpeechModule.kt */
    private static final class Utterance {
        private final String id;
        private final SpeechOptions options;
        private final String text;

        public static /* synthetic */ Utterance copy$default(Utterance utterance, String str, String str2, SpeechOptions speechOptions, int i, Object obj) {
            if ((i & 1) != 0) {
                str = utterance.id;
            }
            if ((i & 2) != 0) {
                str2 = utterance.text;
            }
            if ((i & 4) != 0) {
                speechOptions = utterance.options;
            }
            return utterance.copy(str, str2, speechOptions);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.text;
        }

        public final SpeechOptions component3() {
            return this.options;
        }

        public final Utterance copy(String str, String str2, SpeechOptions speechOptions) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(speechOptions, "options");
            return new Utterance(str, str2, speechOptions);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Utterance)) {
                return false;
            }
            Utterance utterance = (Utterance) obj;
            return Intrinsics.areEqual((Object) this.id, (Object) utterance.id) && Intrinsics.areEqual((Object) this.text, (Object) utterance.text) && Intrinsics.areEqual((Object) this.options, (Object) utterance.options);
        }

        public final String getId() {
            return this.id;
        }

        public final SpeechOptions getOptions() {
            return this.options;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.text.hashCode()) * 31) + this.options.hashCode();
        }

        public String toString() {
            String str = this.id;
            String str2 = this.text;
            SpeechOptions speechOptions = this.options;
            return "Utterance(id=" + str + ", text=" + str2 + ", options=" + speechOptions + ")";
        }

        public Utterance(String str, String str2, SpeechOptions speechOptions) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(speechOptions, "options");
            this.id = str;
            this.text = str2;
            this.options = speechOptions;
        }
    }
}
