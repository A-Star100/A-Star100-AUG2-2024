package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;

/* compiled from: JvmMetadataVersion.kt */
public final class JvmMetadataVersion extends BinaryVersion {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final JvmMetadataVersion INSTANCE = new JvmMetadataVersion(1, 8, 0);
    public static final JvmMetadataVersion INVALID_VERSION = new JvmMetadataVersion(new int[0]);
    private final boolean isStrictSemantics;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmMetadataVersion(int[] iArr, boolean z) {
        super(Arrays.copyOf(iArr, iArr.length));
        Intrinsics.checkNotNullParameter(iArr, "versionArray");
        this.isStrictSemantics = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public JvmMetadataVersion(int... iArr) {
        this(iArr, false);
        Intrinsics.checkNotNullParameter(iArr, "numbers");
    }

    public boolean isCompatible() {
        if (!(getMajor() == 1 && getMinor() == 0)) {
            if (!this.isStrictSemantics) {
                int major = getMajor();
                JvmMetadataVersion jvmMetadataVersion = INSTANCE;
                if (major != jvmMetadataVersion.getMajor() || getMinor() > jvmMetadataVersion.getMinor() + 1) {
                    return false;
                }
                return true;
            } else if (isCompatibleTo(INSTANCE)) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: JvmMetadataVersion.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
