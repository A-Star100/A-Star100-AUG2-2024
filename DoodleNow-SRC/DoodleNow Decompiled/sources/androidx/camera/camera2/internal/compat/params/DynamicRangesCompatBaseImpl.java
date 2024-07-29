package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.DynamicRangeProfiles;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Set;

class DynamicRangesCompatBaseImpl implements DynamicRangesCompat.DynamicRangeProfilesCompatImpl {
    static final DynamicRangesCompat COMPAT_INSTANCE = new DynamicRangesCompat(new DynamicRangesCompatBaseImpl());
    private static final Set<DynamicRange> SDR_ONLY = Collections.singleton(DynamicRange.SDR);

    public Set<DynamicRange> getSupportedDynamicRanges() {
        return SDR_ONLY;
    }

    public DynamicRangeProfiles unwrap() {
        return null;
    }

    DynamicRangesCompatBaseImpl() {
    }

    public Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(DynamicRange dynamicRange) {
        boolean equals = DynamicRange.SDR.equals(dynamicRange);
        Preconditions.checkArgument(equals, "DynamicRange is not supported: " + dynamicRange);
        return SDR_ONLY;
    }

    public boolean isExtraLatencyPresent(DynamicRange dynamicRange) {
        boolean equals = DynamicRange.SDR.equals(dynamicRange);
        Preconditions.checkArgument(equals, "DynamicRange is not supported: " + dynamicRange);
        return false;
    }
}
