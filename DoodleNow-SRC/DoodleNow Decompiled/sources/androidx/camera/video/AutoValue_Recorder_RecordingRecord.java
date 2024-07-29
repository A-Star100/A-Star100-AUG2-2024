package androidx.camera.video;

import androidx.camera.video.Recorder;
import androidx.core.util.Consumer;
import java.util.concurrent.Executor;

final class AutoValue_Recorder_RecordingRecord extends Recorder.RecordingRecord {
    private final Executor getCallbackExecutor;
    private final Consumer<VideoRecordEvent> getEventListener;
    private final OutputOptions getOutputOptions;
    private final long getRecordingId;
    private final boolean hasAudioEnabled;
    private final boolean isPersistent;

    /* access modifiers changed from: package-private */
    public Executor getCallbackExecutor() {
        return this.getCallbackExecutor;
    }

    /* access modifiers changed from: package-private */
    public Consumer<VideoRecordEvent> getEventListener() {
        return this.getEventListener;
    }

    /* access modifiers changed from: package-private */
    public OutputOptions getOutputOptions() {
        return this.getOutputOptions;
    }

    /* access modifiers changed from: package-private */
    public long getRecordingId() {
        return this.getRecordingId;
    }

    /* access modifiers changed from: package-private */
    public boolean hasAudioEnabled() {
        return this.hasAudioEnabled;
    }

    /* access modifiers changed from: package-private */
    public boolean isPersistent() {
        return this.isPersistent;
    }

    AutoValue_Recorder_RecordingRecord(OutputOptions outputOptions, Executor executor, Consumer<VideoRecordEvent> consumer, boolean z, boolean z2, long j) {
        if (outputOptions != null) {
            this.getOutputOptions = outputOptions;
            this.getCallbackExecutor = executor;
            this.getEventListener = consumer;
            this.hasAudioEnabled = z;
            this.isPersistent = z2;
            this.getRecordingId = j;
            return;
        }
        throw new NullPointerException("Null getOutputOptions");
    }

    public String toString() {
        return "RecordingRecord{getOutputOptions=" + this.getOutputOptions + ", getCallbackExecutor=" + this.getCallbackExecutor + ", getEventListener=" + this.getEventListener + ", hasAudioEnabled=" + this.hasAudioEnabled + ", isPersistent=" + this.isPersistent + ", getRecordingId=" + this.getRecordingId + "}";
    }

    public boolean equals(Object obj) {
        Executor executor;
        Consumer<VideoRecordEvent> consumer;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Recorder.RecordingRecord)) {
            return false;
        }
        Recorder.RecordingRecord recordingRecord = (Recorder.RecordingRecord) obj;
        if (!this.getOutputOptions.equals(recordingRecord.getOutputOptions()) || ((executor = this.getCallbackExecutor) != null ? !executor.equals(recordingRecord.getCallbackExecutor()) : recordingRecord.getCallbackExecutor() != null) || ((consumer = this.getEventListener) != null ? !consumer.equals(recordingRecord.getEventListener()) : recordingRecord.getEventListener() != null) || this.hasAudioEnabled != recordingRecord.hasAudioEnabled() || this.isPersistent != recordingRecord.isPersistent() || this.getRecordingId != recordingRecord.getRecordingId()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i;
        int hashCode = (this.getOutputOptions.hashCode() ^ 1000003) * 1000003;
        Executor executor = this.getCallbackExecutor;
        int i2 = 0;
        if (executor == null) {
            i = 0;
        } else {
            i = executor.hashCode();
        }
        int i3 = (hashCode ^ i) * 1000003;
        Consumer<VideoRecordEvent> consumer = this.getEventListener;
        if (consumer != null) {
            i2 = consumer.hashCode();
        }
        int i4 = (i3 ^ i2) * 1000003;
        int i5 = 1231;
        int i6 = (i4 ^ (this.hasAudioEnabled ? 1231 : 1237)) * 1000003;
        if (!this.isPersistent) {
            i5 = 1237;
        }
        long j = this.getRecordingId;
        return ((i6 ^ i5) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }
}
