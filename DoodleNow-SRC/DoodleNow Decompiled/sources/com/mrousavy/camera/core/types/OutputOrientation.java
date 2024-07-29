package com.mrousavy.camera.core.types;

import com.mrousavy.camera.core.types.JSUnionValue;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/mrousavy/camera/core/types/OutputOrientation;", "", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "lockedOrientation", "Lcom/mrousavy/camera/core/types/Orientation;", "getLockedOrientation", "()Lcom/mrousavy/camera/core/types/Orientation;", "getUnionValue", "()Ljava/lang/String;", "DEVICE", "PREVIEW", "PORTRAIT", "LANDSCAPE_RIGHT", "PORTRAIT_UPSIDE_DOWN", "LANDSCAPE_LEFT", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OutputOrientation.kt */
public enum OutputOrientation implements JSUnionValue {
    DEVICE("device"),
    PREVIEW("preview"),
    PORTRAIT("portrait"),
    LANDSCAPE_RIGHT("landscape-right"),
    PORTRAIT_UPSIDE_DOWN("portrait-upside-down"),
    LANDSCAPE_LEFT("landscape-left");
    
    public static final Companion Companion = null;
    private final String unionValue;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: OutputOrientation.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.mrousavy.camera.core.types.OutputOrientation[] r0 = com.mrousavy.camera.core.types.OutputOrientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.mrousavy.camera.core.types.OutputOrientation r1 = com.mrousavy.camera.core.types.OutputOrientation.PORTRAIT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.mrousavy.camera.core.types.OutputOrientation r1 = com.mrousavy.camera.core.types.OutputOrientation.LANDSCAPE_LEFT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.mrousavy.camera.core.types.OutputOrientation r1 = com.mrousavy.camera.core.types.OutputOrientation.PORTRAIT_UPSIDE_DOWN     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.types.OutputOrientation.WhenMappings.<clinit>():void");
        }
    }

    public static EnumEntries<OutputOrientation> getEntries() {
        return $ENTRIES;
    }

    public String getUnionValue() {
        return this.unionValue;
    }

    private OutputOrientation(String str) {
        this.unionValue = str;
    }

    static {
        OutputOrientation[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public final Orientation getLockedOrientation() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return Orientation.PORTRAIT;
        }
        if (i == 2) {
            return Orientation.LANDSCAPE_LEFT;
        }
        if (i != 3) {
            return null;
        }
        return Orientation.PORTRAIT_UPSIDE_DOWN;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/types/OutputOrientation$Companion;", "Lcom/mrousavy/camera/core/types/JSUnionValue$Companion;", "Lcom/mrousavy/camera/core/types/OutputOrientation;", "()V", "fromUnionValue", "unionValue", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: OutputOrientation.kt */
    public static final class Companion implements JSUnionValue.Companion<OutputOrientation> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public OutputOrientation fromUnionValue(String str) {
            if (str != null) {
                switch (str.hashCode()) {
                    case -1510435861:
                        if (str.equals("portrait-upside-down")) {
                            return OutputOrientation.PORTRAIT_UPSIDE_DOWN;
                        }
                        break;
                    case -1335157162:
                        if (str.equals("device")) {
                            return OutputOrientation.DEVICE;
                        }
                        break;
                    case -318184504:
                        if (str.equals("preview")) {
                            return OutputOrientation.PREVIEW;
                        }
                        break;
                    case 687313034:
                        if (str.equals("landscape-right")) {
                            return OutputOrientation.LANDSCAPE_RIGHT;
                        }
                        break;
                    case 729267099:
                        if (str.equals("portrait")) {
                            return OutputOrientation.PORTRAIT;
                        }
                        break;
                    case 1684556761:
                        if (str.equals("landscape-left")) {
                            return OutputOrientation.LANDSCAPE_LEFT;
                        }
                        break;
                }
            }
            return OutputOrientation.PORTRAIT;
        }
    }
}
