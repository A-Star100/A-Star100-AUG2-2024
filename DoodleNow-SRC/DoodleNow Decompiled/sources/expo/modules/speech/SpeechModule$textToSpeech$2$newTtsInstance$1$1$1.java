package expo.modules.speech;

import android.os.Bundle;
import android.speech.tts.UtteranceProgressListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"expo/modules/speech/SpeechModule$textToSpeech$2$newTtsInstance$1$1$1", "Landroid/speech/tts/UtteranceProgressListener;", "onDone", "", "utteranceId", "", "onError", "onRangeStart", "start", "", "end", "frame", "onStart", "onStop", "interrupted", "", "expo-speech_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SpeechModule.kt */
public final class SpeechModule$textToSpeech$2$newTtsInstance$1$1$1 extends UtteranceProgressListener {
    final /* synthetic */ SpeechModule this$0;

    SpeechModule$textToSpeech$2$newTtsInstance$1$1$1(SpeechModule speechModule) {
        this.this$0 = speechModule;
    }

    public void onStart(String str) {
        Intrinsics.checkNotNullParameter(str, "utteranceId");
        SpeechModule speechModule = this.this$0;
        speechModule.sendEvent(SpeechModuleKt.speakingStartedEvent, speechModule.idToMap(str));
    }

    public void onRangeStart(String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "utteranceId");
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putInt("charIndex", i);
        bundle.putInt("charLength", i2 - i);
        this.this$0.sendEvent(SpeechModuleKt.speakingWillSayNextStringEvent, bundle);
    }

    public void onDone(String str) {
        Intrinsics.checkNotNullParameter(str, "utteranceId");
        SpeechModule speechModule = this.this$0;
        speechModule.sendEvent(SpeechModuleKt.speakingDoneEvent, speechModule.idToMap(str));
    }

    public void onStop(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "utteranceId");
        SpeechModule speechModule = this.this$0;
        speechModule.sendEvent(SpeechModuleKt.speakingStoppedEvent, speechModule.idToMap(str));
    }

    public void onError(String str) {
        Intrinsics.checkNotNullParameter(str, "utteranceId");
        SpeechModule speechModule = this.this$0;
        speechModule.sendEvent(SpeechModuleKt.speakingErrorEvent, speechModule.idToMap(str));
    }
}
