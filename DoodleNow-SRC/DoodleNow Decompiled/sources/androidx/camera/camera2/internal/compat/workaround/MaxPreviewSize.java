package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;

public class MaxPreviewSize {
    private final ExtraCroppingQuirk mExtraCroppingQuirk;

    public MaxPreviewSize() {
        this((ExtraCroppingQuirk) DeviceQuirks.get(ExtraCroppingQuirk.class));
    }

    MaxPreviewSize(ExtraCroppingQuirk extraCroppingQuirk) {
        this.mExtraCroppingQuirk = extraCroppingQuirk;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r0 = r0.getVerifiedResolution(androidx.camera.core.impl.SurfaceConfig.ConfigType.PRIV);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Size getMaxPreviewResolution(android.util.Size r5) {
        /*
            r4 = this;
            androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk r0 = r4.mExtraCroppingQuirk
            if (r0 != 0) goto L_0x0005
            return r5
        L_0x0005:
            androidx.camera.core.impl.SurfaceConfig$ConfigType r1 = androidx.camera.core.impl.SurfaceConfig.ConfigType.PRIV
            android.util.Size r0 = r0.getVerifiedResolution(r1)
            if (r0 != 0) goto L_0x000e
            return r5
        L_0x000e:
            int r1 = r0.getWidth()
            int r2 = r0.getHeight()
            int r1 = r1 * r2
            int r2 = r5.getWidth()
            int r3 = r5.getHeight()
            int r2 = r2 * r3
            if (r1 <= r2) goto L_0x0023
            r5 = r0
        L_0x0023:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.compat.workaround.MaxPreviewSize.getMaxPreviewResolution(android.util.Size):android.util.Size");
    }
}
