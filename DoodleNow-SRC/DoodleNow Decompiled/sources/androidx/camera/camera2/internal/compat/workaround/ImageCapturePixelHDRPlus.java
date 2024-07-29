package androidx.camera.camera2.internal.compat.workaround;

import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ImageCapturePixelHDRPlusQuirk;

public class ImageCapturePixelHDRPlus {
    public void toggleHDRPlus(int i, Camera2ImplConfig.Builder builder) {
        if (((ImageCapturePixelHDRPlusQuirk) DeviceQuirks.get(ImageCapturePixelHDRPlusQuirk.class)) != null) {
            if (i == 0) {
                builder.setCaptureRequestOption(ComponentDialog$$ExternalSyntheticApiModelOutline0.m$1(), true);
            } else if (i == 1) {
                builder.setCaptureRequestOption(ComponentDialog$$ExternalSyntheticApiModelOutline0.m$1(), false);
            }
        }
    }
}
