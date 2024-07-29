package androidx.camera.video;

import android.content.Context;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.core.content.PermissionChecker;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

public final class PendingRecording {
    private boolean mAudioEnabled = false;
    private final Context mContext;
    private Consumer<VideoRecordEvent> mEventListener;
    private boolean mIsPersistent = false;
    private Executor mListenerExecutor;
    private final OutputOptions mOutputOptions;
    private final Recorder mRecorder;

    public PendingRecording asPersistentRecording() {
        this.mIsPersistent = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    public Context getApplicationContext() {
        return this.mContext;
    }

    /* access modifiers changed from: package-private */
    public Consumer<VideoRecordEvent> getEventListener() {
        return this.mEventListener;
    }

    /* access modifiers changed from: package-private */
    public Executor getListenerExecutor() {
        return this.mListenerExecutor;
    }

    /* access modifiers changed from: package-private */
    public OutputOptions getOutputOptions() {
        return this.mOutputOptions;
    }

    /* access modifiers changed from: package-private */
    public Recorder getRecorder() {
        return this.mRecorder;
    }

    /* access modifiers changed from: package-private */
    public boolean isAudioEnabled() {
        return this.mAudioEnabled;
    }

    /* access modifiers changed from: package-private */
    public boolean isPersistent() {
        return this.mIsPersistent;
    }

    PendingRecording(Context context, Recorder recorder, OutputOptions outputOptions) {
        this.mContext = ContextUtil.getApplicationContext(context);
        this.mRecorder = recorder;
        this.mOutputOptions = outputOptions;
    }

    public PendingRecording withAudioEnabled() {
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.RECORD_AUDIO") != -1) {
            Preconditions.checkState(this.mRecorder.isAudioSupported(), "The Recorder this recording is associated to doesn't support audio.");
            this.mAudioEnabled = true;
            return this;
        }
        throw new SecurityException("Attempted to enable audio for recording but application does not have RECORD_AUDIO permission granted.");
    }

    public Recording start(Executor executor, Consumer<VideoRecordEvent> consumer) {
        Preconditions.checkNotNull(executor, "Listener Executor can't be null.");
        Preconditions.checkNotNull(consumer, "Event listener can't be null");
        this.mListenerExecutor = executor;
        this.mEventListener = consumer;
        return this.mRecorder.start(this);
    }
}
