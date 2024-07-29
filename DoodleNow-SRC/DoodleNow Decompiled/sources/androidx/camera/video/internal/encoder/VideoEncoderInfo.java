package androidx.camera.video.internal.encoder;

import android.util.Range;

public interface VideoEncoderInfo extends EncoderInfo {
    boolean canSwapWidthHeight();

    int getHeightAlignment();

    Range<Integer> getSupportedBitrateRange();

    Range<Integer> getSupportedHeights();

    Range<Integer> getSupportedHeightsFor(int i);

    Range<Integer> getSupportedWidths();

    Range<Integer> getSupportedWidthsFor(int i);

    int getWidthAlignment();

    boolean isSizeSupported(int i, int i2);

    boolean isSizeSupportedAllowSwapping(int i, int i2);

    /* renamed from: androidx.camera.video.internal.encoder.VideoEncoderInfo$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isSizeSupportedAllowSwapping(VideoEncoderInfo _this, int i, int i2) {
            return _this.isSizeSupported(i, i2) || (_this.canSwapWidthHeight() && _this.isSizeSupported(i2, i));
        }
    }
}
