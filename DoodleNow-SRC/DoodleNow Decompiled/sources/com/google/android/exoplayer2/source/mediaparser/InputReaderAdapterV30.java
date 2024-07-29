package com.google.android.exoplayer2.source.mediaparser;

import android.media.MediaParser$SeekableInputReader;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class InputReaderAdapterV30 implements MediaParser$SeekableInputReader {
    private long currentPosition;
    private DataReader dataReader;
    private long lastSeekPosition;
    private long resourceLength;

    public long getAndResetSeekPosition() {
        long j = this.lastSeekPosition;
        this.lastSeekPosition = -1;
        return j;
    }

    public long getLength() {
        return this.resourceLength;
    }

    public long getPosition() {
        return this.currentPosition;
    }

    public void seekToPosition(long j) {
        this.lastSeekPosition = j;
    }

    public void setCurrentPosition(long j) {
        this.currentPosition = j;
    }

    public void setDataReader(DataReader dataReader2, long j) {
        this.dataReader = dataReader2;
        this.resourceLength = j;
        this.lastSeekPosition = -1;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = ((DataReader) Util.castNonNull(this.dataReader)).read(bArr, i, i2);
        this.currentPosition += (long) read;
        return read;
    }
}
