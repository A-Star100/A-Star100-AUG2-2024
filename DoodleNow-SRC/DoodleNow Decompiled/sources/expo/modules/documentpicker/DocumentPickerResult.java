package expo.modules.documentpicker;

import com.mrousavy.camera.core.types.Video$$ExternalSyntheticBackport0;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lexpo/modules/documentpicker/DocumentPickerResult;", "Lexpo/modules/kotlin/records/Record;", "canceled", "", "assets", "", "Lexpo/modules/documentpicker/DocumentInfo;", "(ZLjava/util/List;)V", "getAssets$annotations", "()V", "getAssets", "()Ljava/util/List;", "getCanceled$annotations", "getCanceled", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "expo-document-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DocumentPickerResults.kt */
public final class DocumentPickerResult implements Record {
    private final List<DocumentInfo> assets;
    private final boolean canceled;

    public DocumentPickerResult() {
        this(false, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DocumentPickerResult copy$default(DocumentPickerResult documentPickerResult, boolean z, List<DocumentInfo> list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = documentPickerResult.canceled;
        }
        if ((i & 2) != 0) {
            list = documentPickerResult.assets;
        }
        return documentPickerResult.copy(z, list);
    }

    @Field
    public static /* synthetic */ void getAssets$annotations() {
    }

    @Field
    public static /* synthetic */ void getCanceled$annotations() {
    }

    public final boolean component1() {
        return this.canceled;
    }

    public final List<DocumentInfo> component2() {
        return this.assets;
    }

    public final DocumentPickerResult copy(boolean z, List<DocumentInfo> list) {
        return new DocumentPickerResult(z, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DocumentPickerResult)) {
            return false;
        }
        DocumentPickerResult documentPickerResult = (DocumentPickerResult) obj;
        return this.canceled == documentPickerResult.canceled && Intrinsics.areEqual((Object) this.assets, (Object) documentPickerResult.assets);
    }

    public final List<DocumentInfo> getAssets() {
        return this.assets;
    }

    public final boolean getCanceled() {
        return this.canceled;
    }

    public int hashCode() {
        int m = Video$$ExternalSyntheticBackport0.m(this.canceled) * 31;
        List<DocumentInfo> list = this.assets;
        return m + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        boolean z = this.canceled;
        List<DocumentInfo> list = this.assets;
        return "DocumentPickerResult(canceled=" + z + ", assets=" + list + ")";
    }

    public DocumentPickerResult(boolean z, List<DocumentInfo> list) {
        this.canceled = z;
        this.assets = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DocumentPickerResult(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : list);
    }
}
