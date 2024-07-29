package expo.modules.sms;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lexpo/modules/sms/SMSAttachment;", "Lexpo/modules/kotlin/records/Record;", "uri", "", "mimeType", "filename", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFilename$annotations", "()V", "getFilename", "()Ljava/lang/String;", "getMimeType$annotations", "getMimeType", "getUri$annotations", "getUri", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "expo-sms_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SMSOptions.kt */
public final class SMSAttachment implements Record {
    private final String filename;
    private final String mimeType;
    private final String uri;

    public static /* synthetic */ SMSAttachment copy$default(SMSAttachment sMSAttachment, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sMSAttachment.uri;
        }
        if ((i & 2) != 0) {
            str2 = sMSAttachment.mimeType;
        }
        if ((i & 4) != 0) {
            str3 = sMSAttachment.filename;
        }
        return sMSAttachment.copy(str, str2, str3);
    }

    @Field
    public static /* synthetic */ void getFilename$annotations() {
    }

    @Field
    public static /* synthetic */ void getMimeType$annotations() {
    }

    @Field
    public static /* synthetic */ void getUri$annotations() {
    }

    public final String component1() {
        return this.uri;
    }

    public final String component2() {
        return this.mimeType;
    }

    public final String component3() {
        return this.filename;
    }

    public final SMSAttachment copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "uri");
        Intrinsics.checkNotNullParameter(str2, "mimeType");
        Intrinsics.checkNotNullParameter(str3, "filename");
        return new SMSAttachment(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SMSAttachment)) {
            return false;
        }
        SMSAttachment sMSAttachment = (SMSAttachment) obj;
        return Intrinsics.areEqual((Object) this.uri, (Object) sMSAttachment.uri) && Intrinsics.areEqual((Object) this.mimeType, (Object) sMSAttachment.mimeType) && Intrinsics.areEqual((Object) this.filename, (Object) sMSAttachment.filename);
    }

    public final String getFilename() {
        return this.filename;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getUri() {
        return this.uri;
    }

    public int hashCode() {
        return (((this.uri.hashCode() * 31) + this.mimeType.hashCode()) * 31) + this.filename.hashCode();
    }

    public String toString() {
        String str = this.uri;
        String str2 = this.mimeType;
        String str3 = this.filename;
        return "SMSAttachment(uri=" + str + ", mimeType=" + str2 + ", filename=" + str3 + ")";
    }

    public SMSAttachment(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "uri");
        Intrinsics.checkNotNullParameter(str2, "mimeType");
        Intrinsics.checkNotNullParameter(str3, "filename");
        this.uri = str;
        this.mimeType = str2;
        this.filename = str3;
    }
}
