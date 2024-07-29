package com.facebook.react.fabric;

import androidx.camera.video.AudioStats;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class LongStreamingStats {
    private int len = 0;
    private long max = 0;
    private final Queue<Long> maxHeap = new PriorityQueue(11, new LongStreamingStats$$ExternalSyntheticLambda2());
    private final Queue<Long> minHeap = new PriorityQueue(11, Comparator.comparingLong(new LongStreamingStats$$ExternalSyntheticLambda1()));
    private double streamingAverage = AudioStats.AUDIO_AMPLITUDE_NONE;

    public double getAverage() {
        return this.streamingAverage;
    }

    public long getMax() {
        return this.max;
    }

    LongStreamingStats() {
    }

    public void add(long j) {
        if (j != 0) {
            if (this.minHeap.size() == this.maxHeap.size()) {
                this.maxHeap.offer(Long.valueOf(j));
                this.minHeap.offer(this.maxHeap.poll());
            } else {
                this.minHeap.offer(Long.valueOf(j));
                this.maxHeap.offer(this.minHeap.poll());
            }
        }
        int i = this.len;
        int i2 = i + 1;
        this.len = i2;
        if (i2 == 1) {
            this.streamingAverage = (double) j;
        } else {
            this.streamingAverage = (this.streamingAverage / ((double) (i2 / i))) + ((double) (j / ((long) i2)));
        }
        long j2 = this.max;
        if (j <= j2) {
            j = j2;
        }
        this.max = j;
    }

    public double getMedian() {
        long j;
        if (this.minHeap.size() == 0 && this.maxHeap.size() == 0) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        if (this.minHeap.size() > this.maxHeap.size()) {
            j = this.minHeap.peek().longValue();
        } else {
            j = (this.minHeap.peek().longValue() + this.maxHeap.peek().longValue()) / 2;
        }
        return (double) j;
    }
}
