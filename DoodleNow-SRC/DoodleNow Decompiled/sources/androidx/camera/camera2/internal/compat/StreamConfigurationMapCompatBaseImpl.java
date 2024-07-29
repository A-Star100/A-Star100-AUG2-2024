package androidx.camera.camera2.internal.compat;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat;

class StreamConfigurationMapCompatBaseImpl implements StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl {
    final StreamConfigurationMap mStreamConfigurationMap;

    public StreamConfigurationMap unwrap() {
        return this.mStreamConfigurationMap;
    }

    StreamConfigurationMapCompatBaseImpl(StreamConfigurationMap streamConfigurationMap) {
        this.mStreamConfigurationMap = streamConfigurationMap;
    }

    public int[] getOutputFormats() {
        return this.mStreamConfigurationMap.getOutputFormats();
    }

    public Size[] getOutputSizes(int i) {
        if (i == 34) {
            return this.mStreamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        }
        return this.mStreamConfigurationMap.getOutputSizes(i);
    }

    public <T> Size[] getOutputSizes(Class<T> cls) {
        return this.mStreamConfigurationMap.getOutputSizes(cls);
    }

    public Size[] getHighResolutionOutputSizes(int i) {
        return Api23Impl.getHighResolutionOutputSizes(this.mStreamConfigurationMap, i);
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static Size[] getHighResolutionOutputSizes(StreamConfigurationMap streamConfigurationMap, int i) {
            return streamConfigurationMap.getHighResolutionOutputSizes(i);
        }
    }
}
