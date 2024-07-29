package expo.modules.imagepicker;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/imagepicker/MediaType;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "VIDEO", "IMAGE", "expo-image-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ImagePickerResponse.kt */
public enum MediaType implements Enumerable {
    VIDEO("video"),
    IMAGE("image");
    
    private final String value;

    public static EnumEntries<MediaType> getEntries() {
        return $ENTRIES;
    }

    public final String getValue() {
        return this.value;
    }

    private MediaType(String str) {
        this.value = str;
    }

    static {
        MediaType[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
