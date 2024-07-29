package expo.modules.speech;

import android.speech.tts.TextToSpeech;
import expo.modules.speech.SpeechModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u0003\u0018\u0001\"\u0006\b\u0003\u0010\u0004\u0018\u00012\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"<anonymous>", "R", "P0", "P1", "P2", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$12"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class SpeechModule$definition$lambda$6$$inlined$AsyncFunction$7 extends Lambda implements Function1<Object[], Unit> {
    final /* synthetic */ SpeechModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpeechModule$definition$lambda$6$$inlined$AsyncFunction$7(SpeechModule speechModule) {
        super(1);
        this.this$0 = speechModule;
    }

    public final Unit invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        String str = objArr[0];
        String str2 = objArr[1];
        SpeechOptions speechOptions = objArr[2];
        String str3 = str2;
        String str4 = str;
        if (str3.length() <= TextToSpeech.getMaxSpeechInputLength()) {
            if (this.this$0.isTextToSpeechReady()) {
                this.this$0.speakOut(str4, str3, speechOptions);
            } else {
                this.this$0.delayedUtterances.add(new SpeechModule.Utterance(str4, str3, speechOptions));
                TextToSpeech unused = this.this$0.getTextToSpeech();
            }
            return Unit.INSTANCE;
        }
        throw new SpeechInputIsToLongException();
    }
}
