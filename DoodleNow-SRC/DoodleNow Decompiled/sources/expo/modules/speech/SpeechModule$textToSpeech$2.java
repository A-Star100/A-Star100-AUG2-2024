package expo.modules.speech;

import android.speech.tts.TextToSpeech;
import expo.modules.speech.SpeechModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/speech/tts/TextToSpeech;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: SpeechModule.kt */
final class SpeechModule$textToSpeech$2 extends Lambda implements Function0<TextToSpeech> {
    final /* synthetic */ SpeechModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpeechModule$textToSpeech$2(SpeechModule speechModule) {
        super(0);
        this.this$0 = speechModule;
    }

    public final TextToSpeech invoke() {
        TextToSpeech textToSpeech = new TextToSpeech(this.this$0.getAppContext().getReactContext(), new SpeechModule$textToSpeech$2$$ExternalSyntheticLambda0(this.this$0));
        this.this$0._textToSpeech = textToSpeech;
        return textToSpeech;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1(SpeechModule speechModule, int i) {
        Intrinsics.checkNotNullParameter(speechModule, "this$0");
        if (i == 0) {
            synchronized (speechModule) {
                speechModule._ttsReady = true;
                TextToSpeech access$get_textToSpeech$p = speechModule._textToSpeech;
                Intrinsics.checkNotNull(access$get_textToSpeech$p);
                access$get_textToSpeech$p.setOnUtteranceProgressListener(new SpeechModule$textToSpeech$2$newTtsInstance$1$1$1(speechModule));
                for (SpeechModule.Utterance utterance : speechModule.delayedUtterances) {
                    speechModule.speakOut(utterance.component1(), utterance.component2(), utterance.component3());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
