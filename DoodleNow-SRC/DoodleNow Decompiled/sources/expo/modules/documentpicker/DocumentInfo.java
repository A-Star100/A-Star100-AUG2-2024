package expo.modules.documentpicker;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J:\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\f¨\u0006!"}, d2 = {"Lexpo/modules/documentpicker/DocumentInfo;", "Lexpo/modules/kotlin/records/Record;", "uri", "", "name", "mimeType", "size", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getMimeType$annotations", "()V", "getMimeType", "()Ljava/lang/String;", "getName$annotations", "getName", "getSize$annotations", "getSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri$annotations", "getUri", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lexpo/modules/documentpicker/DocumentInfo;", "equals", "", "other", "", "hashCode", "toString", "expo-document-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DocumentPickerResults.kt */
public final class DocumentInfo implements Record {
    private final String mimeType;
    private final String name;
    private final Integer size;
    private final String uri;

    public static /* synthetic */ DocumentInfo copy$default(DocumentInfo documentInfo, String str, String str2, String str3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = documentInfo.uri;
        }
        if ((i & 2) != 0) {
            str2 = documentInfo.name;
        }
        if ((i & 4) != 0) {
            str3 = documentInfo.mimeType;
        }
        if ((i & 8) != 0) {
            num = documentInfo.size;
        }
        return documentInfo.copy(str, str2, str3, num);
    }

    @Field
    public static /* synthetic */ void getMimeType$annotations() {
    }

    @Field
    public static /* synthetic */ void getName$annotations() {
    }

    @Field
    public static /* synthetic */ void getSize$annotations() {
    }

    @Field
    public static /* synthetic */ void getUri$annotations() {
    }

    public final String component1() {
        return this.uri;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.mimeType;
    }

    public final Integer component4() {
        return this.size;
    }

    public final DocumentInfo copy(String str, String str2, String str3, Integer num) {
        Intrinsics.checkNotNullParameter(str, "uri");
        Intrinsics.checkNotNullParameter(str2, "name");
        return new DocumentInfo(str, str2, str3, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DocumentInfo)) {
            return false;
        }
        DocumentInfo documentInfo = (DocumentInfo) obj;
        return Intrinsics.areEqual((Object) this.uri, (Object) documentInfo.uri) && Intrinsics.areEqual((Object) this.name, (Object) documentInfo.name) && Intrinsics.areEqual((Object) this.mimeType, (Object) documentInfo.mimeType) && Intrinsics.areEqual((Object) this.size, (Object) documentInfo.size);
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final String getUri() {
        return this.uri;
    }

    public int hashCode() {
        int hashCode = ((this.uri.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.mimeType;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.size;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        String str = this.uri;
        String str2 = this.name;
        String str3 = this.mimeType;
        Integer num = this.size;
        return "DocumentInfo(uri=" + str + ", name=" + str2 + ", mimeType=" + str3 + ", size=" + num + ")";
    }

    public DocumentInfo(String str, String str2, String str3, Integer num) {
        Intrinsics.checkNotNullParameter(str, "uri");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.uri = str;
        this.name = str2;
        this.mimeType = str3;
        this.size = num;
    }
}
