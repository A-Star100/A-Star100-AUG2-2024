package expo.modules.documentpicker;

import com.mrousavy.camera.core.types.Video$$ExternalSyntheticBackport0;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.IsNotEmpty;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lexpo/modules/documentpicker/DocumentPickerOptions;", "Lexpo/modules/kotlin/records/Record;", "copyToCacheDirectory", "", "type", "", "", "multiple", "(ZLjava/util/List;Z)V", "getCopyToCacheDirectory$annotations", "()V", "getCopyToCacheDirectory", "()Z", "getMultiple$annotations", "getMultiple", "getType$annotations", "getType", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "expo-document-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DocumentPickerOptions.kt */
public final class DocumentPickerOptions implements Record {
    private final boolean copyToCacheDirectory;
    private final boolean multiple;
    private final List<String> type;

    public static /* synthetic */ DocumentPickerOptions copy$default(DocumentPickerOptions documentPickerOptions, boolean z, List<String> list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = documentPickerOptions.copyToCacheDirectory;
        }
        if ((i & 2) != 0) {
            list = documentPickerOptions.type;
        }
        if ((i & 4) != 0) {
            z2 = documentPickerOptions.multiple;
        }
        return documentPickerOptions.copy(z, list, z2);
    }

    @Field
    public static /* synthetic */ void getCopyToCacheDirectory$annotations() {
    }

    @Field
    public static /* synthetic */ void getMultiple$annotations() {
    }

    @Field
    @IsNotEmpty
    public static /* synthetic */ void getType$annotations() {
    }

    public final boolean component1() {
        return this.copyToCacheDirectory;
    }

    public final List<String> component2() {
        return this.type;
    }

    public final boolean component3() {
        return this.multiple;
    }

    public final DocumentPickerOptions copy(boolean z, List<String> list, boolean z2) {
        Intrinsics.checkNotNullParameter(list, "type");
        return new DocumentPickerOptions(z, list, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DocumentPickerOptions)) {
            return false;
        }
        DocumentPickerOptions documentPickerOptions = (DocumentPickerOptions) obj;
        return this.copyToCacheDirectory == documentPickerOptions.copyToCacheDirectory && Intrinsics.areEqual((Object) this.type, (Object) documentPickerOptions.type) && this.multiple == documentPickerOptions.multiple;
    }

    public final boolean getCopyToCacheDirectory() {
        return this.copyToCacheDirectory;
    }

    public final boolean getMultiple() {
        return this.multiple;
    }

    public final List<String> getType() {
        return this.type;
    }

    public int hashCode() {
        return (((Video$$ExternalSyntheticBackport0.m(this.copyToCacheDirectory) * 31) + this.type.hashCode()) * 31) + Video$$ExternalSyntheticBackport0.m(this.multiple);
    }

    public String toString() {
        boolean z = this.copyToCacheDirectory;
        List<String> list = this.type;
        boolean z2 = this.multiple;
        return "DocumentPickerOptions(copyToCacheDirectory=" + z + ", type=" + list + ", multiple=" + z2 + ")";
    }

    public DocumentPickerOptions(boolean z, List<String> list, boolean z2) {
        Intrinsics.checkNotNullParameter(list, "type");
        this.copyToCacheDirectory = z;
        this.type = list;
        this.multiple = z2;
    }
}
