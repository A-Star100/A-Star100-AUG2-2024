package expo.modules.speech;

import com.amplitude.api.Constants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lexpo/modules/speech/VoiceRecord;", "Lexpo/modules/kotlin/records/Record;", "identifier", "", "name", "quality", "Lexpo/modules/speech/VoiceQuality;", "language", "(Ljava/lang/String;Ljava/lang/String;Lexpo/modules/speech/VoiceQuality;Ljava/lang/String;)V", "getIdentifier$annotations", "()V", "getIdentifier", "()Ljava/lang/String;", "getLanguage$annotations", "getLanguage", "getName$annotations", "getName", "getQuality$annotations", "getQuality", "()Lexpo/modules/speech/VoiceQuality;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "expo-speech_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: VoiceRecord.kt */
public final class VoiceRecord implements Record {
    private final String identifier;
    private final String language;
    private final String name;
    private final VoiceQuality quality;

    public static /* synthetic */ VoiceRecord copy$default(VoiceRecord voiceRecord, String str, String str2, VoiceQuality voiceQuality, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = voiceRecord.identifier;
        }
        if ((i & 2) != 0) {
            str2 = voiceRecord.name;
        }
        if ((i & 4) != 0) {
            voiceQuality = voiceRecord.quality;
        }
        if ((i & 8) != 0) {
            str3 = voiceRecord.language;
        }
        return voiceRecord.copy(str, str2, voiceQuality, str3);
    }

    @Field
    public static /* synthetic */ void getIdentifier$annotations() {
    }

    @Field
    public static /* synthetic */ void getLanguage$annotations() {
    }

    @Field
    public static /* synthetic */ void getName$annotations() {
    }

    @Field
    public static /* synthetic */ void getQuality$annotations() {
    }

    public final String component1() {
        return this.identifier;
    }

    public final String component2() {
        return this.name;
    }

    public final VoiceQuality component3() {
        return this.quality;
    }

    public final String component4() {
        return this.language;
    }

    public final VoiceRecord copy(String str, String str2, VoiceQuality voiceQuality, String str3) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(voiceQuality, "quality");
        Intrinsics.checkNotNullParameter(str3, Constants.AMP_TRACKING_OPTION_LANGUAGE);
        return new VoiceRecord(str, str2, voiceQuality, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoiceRecord)) {
            return false;
        }
        VoiceRecord voiceRecord = (VoiceRecord) obj;
        return Intrinsics.areEqual((Object) this.identifier, (Object) voiceRecord.identifier) && Intrinsics.areEqual((Object) this.name, (Object) voiceRecord.name) && this.quality == voiceRecord.quality && Intrinsics.areEqual((Object) this.language, (Object) voiceRecord.language);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getName() {
        return this.name;
    }

    public final VoiceQuality getQuality() {
        return this.quality;
    }

    public int hashCode() {
        return (((((this.identifier.hashCode() * 31) + this.name.hashCode()) * 31) + this.quality.hashCode()) * 31) + this.language.hashCode();
    }

    public String toString() {
        String str = this.identifier;
        String str2 = this.name;
        VoiceQuality voiceQuality = this.quality;
        String str3 = this.language;
        return "VoiceRecord(identifier=" + str + ", name=" + str2 + ", quality=" + voiceQuality + ", language=" + str3 + ")";
    }

    public VoiceRecord(String str, String str2, VoiceQuality voiceQuality, String str3) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(voiceQuality, "quality");
        Intrinsics.checkNotNullParameter(str3, Constants.AMP_TRACKING_OPTION_LANGUAGE);
        this.identifier = str;
        this.name = str2;
        this.quality = voiceQuality;
        this.language = str3;
    }
}
