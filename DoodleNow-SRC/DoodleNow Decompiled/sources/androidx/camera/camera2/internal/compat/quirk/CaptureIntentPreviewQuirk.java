package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;

public interface CaptureIntentPreviewQuirk extends Quirk {
    boolean workaroundByCaptureIntentPreview();

    /* renamed from: androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$workaroundByCaptureIntentPreview(CaptureIntentPreviewQuirk _this) {
            return true;
        }

        public static boolean workaroundByCaptureIntentPreview(Quirks quirks) {
            for (CaptureIntentPreviewQuirk workaroundByCaptureIntentPreview : quirks.getAll(CaptureIntentPreviewQuirk.class)) {
                if (workaroundByCaptureIntentPreview.workaroundByCaptureIntentPreview()) {
                    return true;
                }
            }
            return false;
        }
    }
}
