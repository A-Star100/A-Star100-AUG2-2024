package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.StreamSpec;

final class AutoValue_StreamSpec extends StreamSpec {
    private final DynamicRange dynamicRange;
    private final Range<Integer> expectedFrameRateRange;
    private final Config implementationOptions;
    private final Size resolution;

    public DynamicRange getDynamicRange() {
        return this.dynamicRange;
    }

    public Range<Integer> getExpectedFrameRateRange() {
        return this.expectedFrameRateRange;
    }

    public Config getImplementationOptions() {
        return this.implementationOptions;
    }

    public Size getResolution() {
        return this.resolution;
    }

    private AutoValue_StreamSpec(Size size, DynamicRange dynamicRange2, Range<Integer> range, Config config) {
        this.resolution = size;
        this.dynamicRange = dynamicRange2;
        this.expectedFrameRateRange = range;
        this.implementationOptions = config;
    }

    public String toString() {
        return "StreamSpec{resolution=" + this.resolution + ", dynamicRange=" + this.dynamicRange + ", expectedFrameRateRange=" + this.expectedFrameRateRange + ", implementationOptions=" + this.implementationOptions + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StreamSpec)) {
            return false;
        }
        StreamSpec streamSpec = (StreamSpec) obj;
        if (this.resolution.equals(streamSpec.getResolution()) && this.dynamicRange.equals(streamSpec.getDynamicRange()) && this.expectedFrameRateRange.equals(streamSpec.getExpectedFrameRateRange())) {
            Config config = this.implementationOptions;
            if (config == null) {
                if (streamSpec.getImplementationOptions() == null) {
                    return true;
                }
            } else if (config.equals(streamSpec.getImplementationOptions())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i;
        int hashCode = (((((this.resolution.hashCode() ^ 1000003) * 1000003) ^ this.dynamicRange.hashCode()) * 1000003) ^ this.expectedFrameRateRange.hashCode()) * 1000003;
        Config config = this.implementationOptions;
        if (config == null) {
            i = 0;
        } else {
            i = config.hashCode();
        }
        return hashCode ^ i;
    }

    public StreamSpec.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends StreamSpec.Builder {
        private DynamicRange dynamicRange;
        private Range<Integer> expectedFrameRateRange;
        private Config implementationOptions;
        private Size resolution;

        public StreamSpec.Builder setImplementationOptions(Config config) {
            this.implementationOptions = config;
            return this;
        }

        Builder() {
        }

        private Builder(StreamSpec streamSpec) {
            this.resolution = streamSpec.getResolution();
            this.dynamicRange = streamSpec.getDynamicRange();
            this.expectedFrameRateRange = streamSpec.getExpectedFrameRateRange();
            this.implementationOptions = streamSpec.getImplementationOptions();
        }

        public StreamSpec.Builder setResolution(Size size) {
            if (size != null) {
                this.resolution = size;
                return this;
            }
            throw new NullPointerException("Null resolution");
        }

        public StreamSpec.Builder setDynamicRange(DynamicRange dynamicRange2) {
            if (dynamicRange2 != null) {
                this.dynamicRange = dynamicRange2;
                return this;
            }
            throw new NullPointerException("Null dynamicRange");
        }

        public StreamSpec.Builder setExpectedFrameRateRange(Range<Integer> range) {
            if (range != null) {
                this.expectedFrameRateRange = range;
                return this;
            }
            throw new NullPointerException("Null expectedFrameRateRange");
        }

        public StreamSpec build() {
            String str = this.resolution == null ? " resolution" : "";
            if (this.dynamicRange == null) {
                str = str + " dynamicRange";
            }
            if (this.expectedFrameRateRange == null) {
                str = str + " expectedFrameRateRange";
            }
            if (str.isEmpty()) {
                return new AutoValue_StreamSpec(this.resolution, this.dynamicRange, this.expectedFrameRateRange, this.implementationOptions);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
