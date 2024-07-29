package expo.modules.speech;

import android.speech.tts.Voice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "R", "it", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$3"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class SpeechModule$definition$lambda$6$$inlined$AsyncFunction$2 extends Lambda implements Function1<Object[], List<? extends VoiceRecord>> {
    final /* synthetic */ SpeechModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpeechModule$definition$lambda$6$$inlined$AsyncFunction$2(SpeechModule speechModule) {
        super(1);
        this.this$0 = speechModule;
    }

    public final List<? extends VoiceRecord> invoke(Object[] objArr) {
        List list;
        VoiceQuality voiceQuality;
        Intrinsics.checkNotNullParameter(objArr, "it");
        try {
            Set<Voice> voices = this.this$0.getTextToSpeech().getVoices();
            Intrinsics.checkNotNullExpressionValue(voices, "getVoices(...)");
            list = CollectionsKt.toList(voices);
        } catch (Exception unused) {
            list = CollectionsKt.emptyList();
        }
        Iterable<Voice> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Voice voice : iterable) {
            if (voice.getQuality() > 300) {
                voiceQuality = VoiceQuality.ENHANCED;
            } else {
                voiceQuality = VoiceQuality.DEFAULT;
            }
            String name = voice.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            String name2 = voice.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            LanguageUtils languageUtils = LanguageUtils.INSTANCE;
            Locale locale = voice.getLocale();
            Intrinsics.checkNotNullExpressionValue(locale, "getLocale(...)");
            arrayList.add(new VoiceRecord(name, name2, voiceQuality, languageUtils.getISOCode(locale)));
        }
        return (List) arrayList;
    }
}
