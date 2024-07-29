package androidx.camera.core;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.internal.utils.ImageUtil;
import java.nio.ByteBuffer;

public interface ImageProxy extends AutoCloseable {

    public interface PlaneProxy {
        ByteBuffer getBuffer();

        int getPixelStride();

        int getRowStride();
    }

    void close();

    Rect getCropRect();

    int getFormat();

    int getHeight();

    Image getImage();

    ImageInfo getImageInfo();

    PlaneProxy[] getPlanes();

    int getWidth();

    void setCropRect(Rect rect);

    Bitmap toBitmap();

    /* renamed from: androidx.camera.core.ImageProxy$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Bitmap $default$toBitmap(ImageProxy _this) {
            return ImageUtil.createBitmapFromImageProxy(_this);
        }
    }
}
