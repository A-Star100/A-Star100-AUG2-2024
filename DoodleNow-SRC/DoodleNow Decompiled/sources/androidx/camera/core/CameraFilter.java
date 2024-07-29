package androidx.camera.core;

import androidx.camera.core.impl.Identifier;
import java.util.List;

public interface CameraFilter {
    public static final Identifier DEFAULT_ID = Identifier.create(new Object());

    /* renamed from: androidx.camera.core.CameraFilter$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Identifier $default$getIdentifier(CameraFilter _this) {
            return CameraFilter.DEFAULT_ID;
        }
    }

    List<CameraInfo> filter(List<CameraInfo> list);

    Identifier getIdentifier();
}
