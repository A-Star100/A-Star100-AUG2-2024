package androidx.camera.core.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;

public interface SurfaceProcessingQuirk extends Quirk {
    boolean workaroundBySurfaceProcessing();

    /* renamed from: androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$workaroundBySurfaceProcessing(SurfaceProcessingQuirk _this) {
            return true;
        }

        public static boolean workaroundBySurfaceProcessing(Quirks quirks) {
            for (SurfaceProcessingQuirk workaroundBySurfaceProcessing : quirks.getAll(SurfaceProcessingQuirk.class)) {
                if (workaroundBySurfaceProcessing.workaroundBySurfaceProcessing()) {
                    return true;
                }
            }
            return false;
        }
    }
}
