package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import com.onesignal.core.internal.config.InfluenceConfigModel;

public class ExtraSupportedOutputSizeQuirk implements Quirk {
    static boolean load() {
        return isMotoE5Play();
    }

    private static boolean isMotoE5Play() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL);
    }

    public Size[] getExtraSupportedResolutions(int i) {
        return (i != 34 || !isMotoE5Play()) ? new Size[0] : getMotoE5PlayExtraSupportedResolutions();
    }

    public <T> Size[] getExtraSupportedResolutions(Class<T> cls) {
        return (!StreamConfigurationMap.isOutputSupportedFor(cls) || !isMotoE5Play()) ? new Size[0] : getMotoE5PlayExtraSupportedResolutions();
    }

    private Size[] getMotoE5PlayExtraSupportedResolutions() {
        return new Size[]{new Size(InfluenceConfigModel.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW, 1080), new Size(960, 720)};
    }
}
