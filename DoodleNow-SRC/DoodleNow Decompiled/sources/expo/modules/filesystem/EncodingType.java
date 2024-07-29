package expo.modules.filesystem;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/filesystem/EncodingType;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UTF8", "BASE64", "expo-file-system_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: FileSystemRecords.kt */
public enum EncodingType implements Enumerable {
    UTF8(ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8),
    BASE64(ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64);
    
    private final String value;

    public static EnumEntries<EncodingType> getEntries() {
        return $ENTRIES;
    }

    public final String getValue() {
        return this.value;
    }

    private EncodingType(String str) {
        this.value = str;
    }

    static {
        EncodingType[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
