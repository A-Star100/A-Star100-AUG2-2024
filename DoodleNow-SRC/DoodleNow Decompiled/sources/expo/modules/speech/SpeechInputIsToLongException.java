package expo.modules.speech;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/speech/SpeechInputIsToLongException;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-speech_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SpeechInputIsToLongException.kt */
public final class SpeechInputIsToLongException extends CodedException {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SpeechInputIsToLongException() {
        /*
            r3 = this;
            int r0 = android.speech.tts.TextToSpeech.getMaxSpeechInputLength()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Speech input text is too long! Limit of input length is: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 0
            r2 = 2
            r3.<init>(r0, r1, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.speech.SpeechInputIsToLongException.<init>():void");
    }
}
