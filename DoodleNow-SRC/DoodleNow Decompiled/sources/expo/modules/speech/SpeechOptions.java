package expo.modules.speech;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\f¨\u0006\""}, d2 = {"Lexpo/modules/speech/SpeechOptions;", "Lexpo/modules/kotlin/records/Record;", "language", "", "pitch", "", "rate", "voice", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)V", "getLanguage$annotations", "()V", "getLanguage", "()Ljava/lang/String;", "getPitch$annotations", "getPitch", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getRate$annotations", "getRate", "getVoice$annotations", "getVoice", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)Lexpo/modules/speech/SpeechOptions;", "equals", "", "other", "", "hashCode", "", "toString", "expo-speech_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SpeechOptions.kt */
public final class SpeechOptions implements Record {
    private final String language;
    private final Float pitch;
    private final Float rate;
    private final String voice;

    public static /* synthetic */ SpeechOptions copy$default(SpeechOptions speechOptions, String str, Float f, Float f2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = speechOptions.language;
        }
        if ((i & 2) != 0) {
            f = speechOptions.pitch;
        }
        if ((i & 4) != 0) {
            f2 = speechOptions.rate;
        }
        if ((i & 8) != 0) {
            str2 = speechOptions.voice;
        }
        return speechOptions.copy(str, f, f2, str2);
    }

    @Field
    public static /* synthetic */ void getLanguage$annotations() {
    }

    @Field
    public static /* synthetic */ void getPitch$annotations() {
    }

    @Field
    public static /* synthetic */ void getRate$annotations() {
    }

    @Field
    public static /* synthetic */ void getVoice$annotations() {
    }

    public final String component1() {
        return this.language;
    }

    public final Float component2() {
        return this.pitch;
    }

    public final Float component3() {
        return this.rate;
    }

    public final String component4() {
        return this.voice;
    }

    public final SpeechOptions copy(String str, Float f, Float f2, String str2) {
        return new SpeechOptions(str, f, f2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpeechOptions)) {
            return false;
        }
        SpeechOptions speechOptions = (SpeechOptions) obj;
        return Intrinsics.areEqual((Object) this.language, (Object) speechOptions.language) && Intrinsics.areEqual((Object) this.pitch, (Object) speechOptions.pitch) && Intrinsics.areEqual((Object) this.rate, (Object) speechOptions.rate) && Intrinsics.areEqual((Object) this.voice, (Object) speechOptions.voice);
    }

    public final String getLanguage() {
        return this.language;
    }

    public final Float getPitch() {
        return this.pitch;
    }

    public final Float getRate() {
        return this.rate;
    }

    public final String getVoice() {
        return this.voice;
    }

    public int hashCode() {
        String str = this.language;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Float f = this.pitch;
        int hashCode2 = (hashCode + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.rate;
        int hashCode3 = (hashCode2 + (f2 == null ? 0 : f2.hashCode())) * 31;
        String str2 = this.voice;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        String str = this.language;
        Float f = this.pitch;
        Float f2 = this.rate;
        String str2 = this.voice;
        return "SpeechOptions(language=" + str + ", pitch=" + f + ", rate=" + f2 + ", voice=" + str2 + ")";
    }

    public SpeechOptions(String str, Float f, Float f2, String str2) {
        this.language = str;
        this.pitch = f;
        this.rate = f2;
        this.voice = str2;
    }
}
