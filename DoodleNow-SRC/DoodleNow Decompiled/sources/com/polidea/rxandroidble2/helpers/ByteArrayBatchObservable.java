package com.polidea.rxandroidble2.helpers;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.nio.ByteBuffer;
import org.reactivestreams.Subscriber;

public class ByteArrayBatchObservable extends Flowable<byte[]> {
    final ByteBuffer byteBuffer;
    final int maxBatchSize;

    public ByteArrayBatchObservable(byte[] bArr, int i) {
        if (i > 0) {
            this.byteBuffer = ByteBuffer.wrap(bArr);
            this.maxBatchSize = i;
            return;
        }
        throw new IllegalArgumentException("maxBatchSize must be > 0 but found: " + i);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super byte[]> subscriber) {
        Flowable.generate(new Consumer<Emitter<byte[]>>() {
            public void accept(Emitter<byte[]> emitter) {
                int min = Math.min(ByteArrayBatchObservable.this.byteBuffer.remaining(), ByteArrayBatchObservable.this.maxBatchSize);
                if (min == 0) {
                    emitter.onComplete();
                    return;
                }
                byte[] bArr = new byte[min];
                ByteArrayBatchObservable.this.byteBuffer.get(bArr);
                emitter.onNext(bArr);
            }
        }).subscribe(subscriber);
    }
}
