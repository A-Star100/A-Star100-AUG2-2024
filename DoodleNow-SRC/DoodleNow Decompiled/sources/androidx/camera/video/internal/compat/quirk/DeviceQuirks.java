package androidx.camera.video.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;
import java.util.List;

public class DeviceQuirks {
    private static final Quirks QUIRKS = new Quirks(DeviceQuirksLoader.loadQuirks());

    public static Quirks getAll() {
        return QUIRKS;
    }

    private DeviceQuirks() {
    }

    public static <T extends Quirk> T get(Class<T> cls) {
        return QUIRKS.get(cls);
    }

    public static <T extends Quirk> List<T> getAll(Class<T> cls) {
        return QUIRKS.getAll(cls);
    }
}
