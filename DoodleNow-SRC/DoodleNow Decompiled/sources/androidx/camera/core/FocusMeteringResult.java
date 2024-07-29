package androidx.camera.core;

public final class FocusMeteringResult {
    private boolean mIsFocusSuccessful;

    public boolean isFocusSuccessful() {
        return this.mIsFocusSuccessful;
    }

    public static FocusMeteringResult emptyInstance() {
        return new FocusMeteringResult(false);
    }

    public static FocusMeteringResult create(boolean z) {
        return new FocusMeteringResult(z);
    }

    private FocusMeteringResult(boolean z) {
        this.mIsFocusSuccessful = z;
    }
}
