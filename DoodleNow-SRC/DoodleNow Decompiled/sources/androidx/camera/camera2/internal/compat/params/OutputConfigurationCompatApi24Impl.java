package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.UByte$$ExternalSyntheticBackport0;

class OutputConfigurationCompatApi24Impl extends OutputConfigurationCompatBaseImpl {
    OutputConfigurationCompatApi24Impl(Surface surface) {
        this((Object) new OutputConfigurationParamsApi24(new OutputConfiguration(surface)));
    }

    OutputConfigurationCompatApi24Impl(int i, Surface surface) {
        this((Object) new OutputConfigurationParamsApi24(new OutputConfiguration(i, surface)));
    }

    OutputConfigurationCompatApi24Impl(Object obj) {
        super(obj);
    }

    static OutputConfigurationCompatApi24Impl wrap(OutputConfiguration outputConfiguration) {
        return new OutputConfigurationCompatApi24Impl((Object) new OutputConfigurationParamsApi24(outputConfiguration));
    }

    public void enableSurfaceSharing() {
        ((OutputConfigurationParamsApi24) this.mObject).mIsShared = true;
    }

    /* access modifiers changed from: package-private */
    public boolean isSurfaceSharingEnabled() {
        return ((OutputConfigurationParamsApi24) this.mObject).mIsShared;
    }

    public void setPhysicalCameraId(String str) {
        ((OutputConfigurationParamsApi24) this.mObject).mPhysicalCameraId = str;
    }

    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi24) this.mObject).mPhysicalCameraId;
    }

    public long getDynamicRangeProfile() {
        return ((OutputConfigurationParamsApi24) this.mObject).mDynamicRangeProfile;
    }

    public void setDynamicRangeProfile(long j) {
        ((OutputConfigurationParamsApi24) this.mObject).mDynamicRangeProfile = j;
    }

    public Surface getSurface() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurface();
    }

    public List<Surface> getSurfaces() {
        return Collections.singletonList(getSurface());
    }

    public int getSurfaceGroupId() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurfaceGroupId();
    }

    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfigurationParamsApi24);
        return ((OutputConfigurationParamsApi24) this.mObject).mOutputConfiguration;
    }

    private static final class OutputConfigurationParamsApi24 {
        long mDynamicRangeProfile = 1;
        boolean mIsShared;
        final OutputConfiguration mOutputConfiguration;
        String mPhysicalCameraId;

        OutputConfigurationParamsApi24(OutputConfiguration outputConfiguration) {
            this.mOutputConfiguration = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OutputConfigurationParamsApi24)) {
                return false;
            }
            OutputConfigurationParamsApi24 outputConfigurationParamsApi24 = (OutputConfigurationParamsApi24) obj;
            if (!Objects.equals(this.mOutputConfiguration, outputConfigurationParamsApi24.mOutputConfiguration) || this.mIsShared != outputConfigurationParamsApi24.mIsShared || this.mDynamicRangeProfile != outputConfigurationParamsApi24.mDynamicRangeProfile || !Objects.equals(this.mPhysicalCameraId, outputConfigurationParamsApi24.mPhysicalCameraId)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i;
            int hashCode = this.mOutputConfiguration.hashCode() ^ 31;
            boolean z = this.mIsShared ^ ((hashCode << 5) - hashCode);
            int i2 = ((z ? 1 : 0) << true) - z;
            String str = this.mPhysicalCameraId;
            if (str == null) {
                i = 0;
            } else {
                i = str.hashCode();
            }
            int i3 = i ^ i2;
            return UByte$$ExternalSyntheticBackport0.m(this.mDynamicRangeProfile) ^ ((i3 << 5) - i3);
        }
    }
}
