package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

public final class TextRenderer extends BaseRenderer implements Handler.Callback {
    private static final int MSG_UPDATE_OUTPUT = 0;
    private static final int REPLACEMENT_STATE_NONE = 0;
    private static final int REPLACEMENT_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REPLACEMENT_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "TextRenderer";
    private SubtitleDecoder decoder;
    private final SubtitleDecoderFactory decoderFactory;
    private int decoderReplacementState;
    private long finalStreamEndPositionUs;
    private final FormatHolder formatHolder;
    private boolean inputStreamEnded;
    private SubtitleInputBuffer nextInputBuffer;
    private SubtitleOutputBuffer nextSubtitle;
    private int nextSubtitleEventIndex;
    private final TextOutput output;
    private final Handler outputHandler;
    private boolean outputStreamEnded;
    private Format streamFormat;
    private SubtitleOutputBuffer subtitle;
    private boolean waitingForKeyFrame;

    public String getName() {
        return TAG;
    }

    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    public boolean isReady() {
        return true;
    }

    public TextRenderer(TextOutput textOutput, Looper looper) {
        this(textOutput, looper, SubtitleDecoderFactory.DEFAULT);
    }

    public TextRenderer(TextOutput textOutput, Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        Handler handler;
        this.output = (TextOutput) Assertions.checkNotNull(textOutput);
        if (looper == null) {
            handler = null;
        } else {
            handler = Util.createHandler(looper, this);
        }
        this.outputHandler = handler;
        this.decoderFactory = subtitleDecoderFactory;
        this.formatHolder = new FormatHolder();
        this.finalStreamEndPositionUs = C.TIME_UNSET;
    }

    public int supportsFormat(Format format) {
        if (this.decoderFactory.supportsFormat(format)) {
            return RendererCapabilities.CC.create(format.cryptoType == 0 ? 4 : 2);
        } else if (MimeTypes.isText(format.sampleMimeType)) {
            return RendererCapabilities.CC.create(1);
        } else {
            return RendererCapabilities.CC.create(0);
        }
    }

    public void setFinalStreamEndPositionUs(long j) {
        Assertions.checkState(isCurrentStreamFinal());
        this.finalStreamEndPositionUs = j;
    }

    /* access modifiers changed from: protected */
    public void onStreamChanged(Format[] formatArr, long j, long j2) {
        this.streamFormat = formatArr[0];
        if (this.decoder != null) {
            this.decoderReplacementState = 1;
        } else {
            initDecoder();
        }
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j, boolean z) {
        clearOutput();
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.finalStreamEndPositionUs = C.TIME_UNSET;
        if (this.decoderReplacementState != 0) {
            replaceDecoder();
            return;
        }
        releaseBuffers();
        ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).flush();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a7, code lost:
        if (r11 != false) goto L_0x00a9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void render(long r9, long r11) {
        /*
            r8 = this;
            boolean r11 = r8.isCurrentStreamFinal()
            r12 = 1
            if (r11 == 0) goto L_0x001b
            long r0 = r8.finalStreamEndPositionUs
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r11 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r11 == 0) goto L_0x001b
            int r11 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r11 < 0) goto L_0x001b
            r8.releaseBuffers()
            r8.outputStreamEnded = r12
        L_0x001b:
            boolean r11 = r8.outputStreamEnded
            if (r11 == 0) goto L_0x0020
            return
        L_0x0020:
            com.google.android.exoplayer2.text.SubtitleOutputBuffer r11 = r8.nextSubtitle
            if (r11 != 0) goto L_0x0045
            com.google.android.exoplayer2.text.SubtitleDecoder r11 = r8.decoder
            java.lang.Object r11 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r11)
            com.google.android.exoplayer2.text.SubtitleDecoder r11 = (com.google.android.exoplayer2.text.SubtitleDecoder) r11
            r11.setPositionUs(r9)
            com.google.android.exoplayer2.text.SubtitleDecoder r11 = r8.decoder     // Catch:{ SubtitleDecoderException -> 0x0040 }
            java.lang.Object r11 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r11)     // Catch:{ SubtitleDecoderException -> 0x0040 }
            com.google.android.exoplayer2.text.SubtitleDecoder r11 = (com.google.android.exoplayer2.text.SubtitleDecoder) r11     // Catch:{ SubtitleDecoderException -> 0x0040 }
            java.lang.Object r11 = r11.dequeueOutputBuffer()     // Catch:{ SubtitleDecoderException -> 0x0040 }
            com.google.android.exoplayer2.text.SubtitleOutputBuffer r11 = (com.google.android.exoplayer2.text.SubtitleOutputBuffer) r11     // Catch:{ SubtitleDecoderException -> 0x0040 }
            r8.nextSubtitle = r11     // Catch:{ SubtitleDecoderException -> 0x0040 }
            goto L_0x0045
        L_0x0040:
            r9 = move-exception
            r8.handleDecoderError(r9)
            return
        L_0x0045:
            int r11 = r8.getState()
            r0 = 2
            if (r11 == r0) goto L_0x004d
            return
        L_0x004d:
            com.google.android.exoplayer2.text.SubtitleOutputBuffer r11 = r8.subtitle
            r1 = 0
            if (r11 == 0) goto L_0x0066
            long r2 = r8.getNextEventTime()
            r11 = r1
        L_0x0057:
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 > 0) goto L_0x0067
            int r11 = r8.nextSubtitleEventIndex
            int r11 = r11 + r12
            r8.nextSubtitleEventIndex = r11
            long r2 = r8.getNextEventTime()
            r11 = r12
            goto L_0x0057
        L_0x0066:
            r11 = r1
        L_0x0067:
            com.google.android.exoplayer2.text.SubtitleOutputBuffer r2 = r8.nextSubtitle
            r3 = 0
            if (r2 == 0) goto L_0x00a7
            boolean r4 = r2.isEndOfStream()
            if (r4 == 0) goto L_0x008f
            if (r11 != 0) goto L_0x00a7
            long r4 = r8.getNextEventTime()
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x00a7
            int r2 = r8.decoderReplacementState
            if (r2 != r0) goto L_0x0089
            r8.replaceDecoder()
            goto L_0x00a7
        L_0x0089:
            r8.releaseBuffers()
            r8.outputStreamEnded = r12
            goto L_0x00a7
        L_0x008f:
            long r4 = r2.timeUs
            int r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r4 > 0) goto L_0x00a7
            com.google.android.exoplayer2.text.SubtitleOutputBuffer r11 = r8.subtitle
            if (r11 == 0) goto L_0x009c
            r11.release()
        L_0x009c:
            int r11 = r2.getNextEventTimeIndex(r9)
            r8.nextSubtitleEventIndex = r11
            r8.subtitle = r2
            r8.nextSubtitle = r3
            goto L_0x00a9
        L_0x00a7:
            if (r11 == 0) goto L_0x00b7
        L_0x00a9:
            com.google.android.exoplayer2.text.SubtitleOutputBuffer r11 = r8.subtitle
            com.google.android.exoplayer2.util.Assertions.checkNotNull(r11)
            com.google.android.exoplayer2.text.SubtitleOutputBuffer r11 = r8.subtitle
            java.util.List r9 = r11.getCues(r9)
            r8.updateOutput(r9)
        L_0x00b7:
            int r9 = r8.decoderReplacementState
            if (r9 != r0) goto L_0x00bc
            return
        L_0x00bc:
            boolean r9 = r8.inputStreamEnded     // Catch:{ SubtitleDecoderException -> 0x0131 }
            if (r9 != 0) goto L_0x0135
            com.google.android.exoplayer2.text.SubtitleInputBuffer r9 = r8.nextInputBuffer     // Catch:{ SubtitleDecoderException -> 0x0131 }
            if (r9 != 0) goto L_0x00d7
            com.google.android.exoplayer2.text.SubtitleDecoder r9 = r8.decoder     // Catch:{ SubtitleDecoderException -> 0x0131 }
            java.lang.Object r9 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r9)     // Catch:{ SubtitleDecoderException -> 0x0131 }
            com.google.android.exoplayer2.text.SubtitleDecoder r9 = (com.google.android.exoplayer2.text.SubtitleDecoder) r9     // Catch:{ SubtitleDecoderException -> 0x0131 }
            java.lang.Object r9 = r9.dequeueInputBuffer()     // Catch:{ SubtitleDecoderException -> 0x0131 }
            com.google.android.exoplayer2.text.SubtitleInputBuffer r9 = (com.google.android.exoplayer2.text.SubtitleInputBuffer) r9     // Catch:{ SubtitleDecoderException -> 0x0131 }
            if (r9 != 0) goto L_0x00d5
            return
        L_0x00d5:
            r8.nextInputBuffer = r9     // Catch:{ SubtitleDecoderException -> 0x0131 }
        L_0x00d7:
            int r10 = r8.decoderReplacementState     // Catch:{ SubtitleDecoderException -> 0x0131 }
            if (r10 != r12) goto L_0x00ef
            r10 = 4
            r9.setFlags(r10)     // Catch:{ SubtitleDecoderException -> 0x0131 }
            com.google.android.exoplayer2.text.SubtitleDecoder r10 = r8.decoder     // Catch:{ SubtitleDecoderException -> 0x0131 }
            java.lang.Object r10 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r10)     // Catch:{ SubtitleDecoderException -> 0x0131 }
            com.google.android.exoplayer2.text.SubtitleDecoder r10 = (com.google.android.exoplayer2.text.SubtitleDecoder) r10     // Catch:{ SubtitleDecoderException -> 0x0131 }
            r10.queueInputBuffer(r9)     // Catch:{ SubtitleDecoderException -> 0x0131 }
            r8.nextInputBuffer = r3     // Catch:{ SubtitleDecoderException -> 0x0131 }
            r8.decoderReplacementState = r0     // Catch:{ SubtitleDecoderException -> 0x0131 }
            return
        L_0x00ef:
            com.google.android.exoplayer2.FormatHolder r10 = r8.formatHolder     // Catch:{ SubtitleDecoderException -> 0x0131 }
            int r10 = r8.readSource(r10, r9, r1)     // Catch:{ SubtitleDecoderException -> 0x0131 }
            r11 = -4
            if (r10 != r11) goto L_0x012d
            boolean r10 = r9.isEndOfStream()     // Catch:{ SubtitleDecoderException -> 0x0131 }
            if (r10 == 0) goto L_0x0103
            r8.inputStreamEnded = r12     // Catch:{ SubtitleDecoderException -> 0x0131 }
            r8.waitingForKeyFrame = r1     // Catch:{ SubtitleDecoderException -> 0x0131 }
            goto L_0x011b
        L_0x0103:
            com.google.android.exoplayer2.FormatHolder r10 = r8.formatHolder     // Catch:{ SubtitleDecoderException -> 0x0131 }
            com.google.android.exoplayer2.Format r10 = r10.format     // Catch:{ SubtitleDecoderException -> 0x0131 }
            if (r10 != 0) goto L_0x010a
            return
        L_0x010a:
            long r10 = r10.subsampleOffsetUs     // Catch:{ SubtitleDecoderException -> 0x0131 }
            r9.subsampleOffsetUs = r10     // Catch:{ SubtitleDecoderException -> 0x0131 }
            r9.flip()     // Catch:{ SubtitleDecoderException -> 0x0131 }
            boolean r10 = r8.waitingForKeyFrame     // Catch:{ SubtitleDecoderException -> 0x0131 }
            boolean r11 = r9.isKeyFrame()     // Catch:{ SubtitleDecoderException -> 0x0131 }
            r11 = r11 ^ r12
            r10 = r10 & r11
            r8.waitingForKeyFrame = r10     // Catch:{ SubtitleDecoderException -> 0x0131 }
        L_0x011b:
            boolean r10 = r8.waitingForKeyFrame     // Catch:{ SubtitleDecoderException -> 0x0131 }
            if (r10 != 0) goto L_0x00bc
            com.google.android.exoplayer2.text.SubtitleDecoder r10 = r8.decoder     // Catch:{ SubtitleDecoderException -> 0x0131 }
            java.lang.Object r10 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r10)     // Catch:{ SubtitleDecoderException -> 0x0131 }
            com.google.android.exoplayer2.text.SubtitleDecoder r10 = (com.google.android.exoplayer2.text.SubtitleDecoder) r10     // Catch:{ SubtitleDecoderException -> 0x0131 }
            r10.queueInputBuffer(r9)     // Catch:{ SubtitleDecoderException -> 0x0131 }
            r8.nextInputBuffer = r3     // Catch:{ SubtitleDecoderException -> 0x0131 }
            goto L_0x00bc
        L_0x012d:
            r9 = -3
            if (r10 != r9) goto L_0x00bc
            return
        L_0x0131:
            r9 = move-exception
            r8.handleDecoderError(r9)
        L_0x0135:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.TextRenderer.render(long, long):void");
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
        this.streamFormat = null;
        this.finalStreamEndPositionUs = C.TIME_UNSET;
        clearOutput();
        releaseDecoder();
    }

    private void releaseBuffers() {
        this.nextInputBuffer = null;
        this.nextSubtitleEventIndex = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.subtitle;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.release();
            this.subtitle = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.nextSubtitle;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.release();
            this.nextSubtitle = null;
        }
    }

    private void releaseDecoder() {
        releaseBuffers();
        ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).release();
        this.decoder = null;
        this.decoderReplacementState = 0;
    }

    private void initDecoder() {
        this.waitingForKeyFrame = true;
        this.decoder = this.decoderFactory.createDecoder((Format) Assertions.checkNotNull(this.streamFormat));
    }

    private void replaceDecoder() {
        releaseDecoder();
        initDecoder();
    }

    private long getNextEventTime() {
        if (this.nextSubtitleEventIndex == -1) {
            return Long.MAX_VALUE;
        }
        Assertions.checkNotNull(this.subtitle);
        if (this.nextSubtitleEventIndex >= this.subtitle.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.subtitle.getEventTime(this.nextSubtitleEventIndex);
    }

    private void updateOutput(List<Cue> list) {
        Handler handler = this.outputHandler;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            invokeUpdateOutputInternal(list);
        }
    }

    private void clearOutput() {
        updateOutput(Collections.emptyList());
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            invokeUpdateOutputInternal((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    private void invokeUpdateOutputInternal(List<Cue> list) {
        this.output.onCues(list);
        this.output.onCues(new CueGroup(list));
    }

    private void handleDecoderError(SubtitleDecoderException subtitleDecoderException) {
        Log.e(TAG, "Subtitle decoding failed. streamFormat=" + this.streamFormat, subtitleDecoderException);
        clearOutput();
        replaceDecoder();
    }
}
