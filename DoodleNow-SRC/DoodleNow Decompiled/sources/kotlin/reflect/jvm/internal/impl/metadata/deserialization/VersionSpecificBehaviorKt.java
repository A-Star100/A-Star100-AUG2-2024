package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.amplitude.api.Constants;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: versionSpecificBehavior.kt */
public final class VersionSpecificBehaviorKt {
    public static final boolean isVersionRequirementTableWrittenCorrectly(BinaryVersion binaryVersion) {
        Intrinsics.checkNotNullParameter(binaryVersion, Constants.AMP_PLAN_VERSION);
        return isKotlin1Dot4OrLater(binaryVersion);
    }

    public static final boolean isKotlin1Dot4OrLater(BinaryVersion binaryVersion) {
        Intrinsics.checkNotNullParameter(binaryVersion, Constants.AMP_PLAN_VERSION);
        return binaryVersion.getMajor() == 1 && binaryVersion.getMinor() >= 4;
    }
}
