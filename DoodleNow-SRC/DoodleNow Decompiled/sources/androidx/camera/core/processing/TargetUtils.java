package androidx.camera.core.processing;

import androidx.core.util.Preconditions;
import com.amazon.a.a.o.b.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import kotlin.UByte$$ExternalSyntheticBackport0;

public class TargetUtils {
    public static int getNumberOfTargets(int i) {
        int i2 = 0;
        while (i != 0) {
            i2 += i & 1;
            i >>= 1;
        }
        return i2;
    }

    public static boolean isSuperset(int i, int i2) {
        return (i & i2) == i2;
    }

    private TargetUtils() {
    }

    public static void checkSupportedTargets(Collection<Integer> collection, int i) {
        Preconditions.checkArgument(collection.contains(Integer.valueOf(i)), String.format(Locale.US, "Effects target %s is not in the supported list %s.", new Object[]{getHumanReadableName(i), getHumanReadableNames(collection)}));
    }

    private static String getHumanReadableNames(Collection<Integer> collection) {
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : collection) {
            arrayList.add(getHumanReadableName(intValue.intValue()));
        }
        return "[" + UByte$$ExternalSyntheticBackport0.m((CharSequence) ", ", (Iterable) arrayList) + "]";
    }

    public static String getHumanReadableName(int i) {
        ArrayList arrayList = new ArrayList();
        if ((i & 4) != 0) {
            arrayList.add("IMAGE_CAPTURE");
        }
        if ((i & 1) != 0) {
            arrayList.add("PREVIEW");
        }
        if ((i & 2) != 0) {
            arrayList.add("VIDEO_CAPTURE");
        }
        return UByte$$ExternalSyntheticBackport0.m((CharSequence) f.c, (Iterable) arrayList);
    }
}
