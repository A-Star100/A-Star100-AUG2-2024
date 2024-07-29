package expo.modules.location.records;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/location/records/GeofencingRegionState;", "", "Lexpo/modules/kotlin/types/Enumerable;", "(Ljava/lang/String;I)V", "UNKNOWN", "INSIDE", "OUTSIDE", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationArguments.kt */
public enum GeofencingRegionState implements Enumerable {
    UNKNOWN,
    INSIDE,
    OUTSIDE;

    public static EnumEntries<GeofencingRegionState> getEntries() {
        return $ENTRIES;
    }

    static {
        GeofencingRegionState[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
