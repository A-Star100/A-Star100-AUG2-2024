package androidx.autofill.inline.common;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.net.Uri;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.autofill.inline.UiVersions;

public abstract class SlicedContent implements UiVersions.Content {
    static final Uri INLINE_SLICE_URI = Uri.parse("inline.slice");
    protected final Slice mSlice;

    public abstract PendingIntent getAttributionIntent();

    public final Slice getSlice() {
        return this.mSlice;
    }

    public abstract boolean isValid();

    protected SlicedContent(Slice slice) {
        this.mSlice = slice;
    }

    public static String getVersion(Slice slice) {
        return ComponentDialog$$ExternalSyntheticApiModelOutline0.m(slice).getType();
    }

    public static abstract class Builder<T extends SlicedContent> {
        protected final Slice.Builder mSliceBuilder;

        public abstract T build();

        protected Builder(String str) {
            ComponentDialog$$ExternalSyntheticApiModelOutline0.m();
            this.mSliceBuilder = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(SlicedContent.INLINE_SLICE_URI, ComponentDialog$$ExternalSyntheticApiModelOutline0.m(str, 1));
        }
    }
}
