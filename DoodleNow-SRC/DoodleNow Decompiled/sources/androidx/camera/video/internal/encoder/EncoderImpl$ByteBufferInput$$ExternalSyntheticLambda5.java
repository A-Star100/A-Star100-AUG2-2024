package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EncoderImpl$ByteBufferInput$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ EncoderImpl.ByteBufferInput f$0;
    public final /* synthetic */ ListenableFuture f$1;

    public /* synthetic */ EncoderImpl$ByteBufferInput$$ExternalSyntheticLambda5(EncoderImpl.ByteBufferInput byteBufferInput, ListenableFuture listenableFuture) {
        this.f$0 = byteBufferInput;
        this.f$1 = listenableFuture;
    }

    public final void run() {
        this.f$0.m269lambda$acquireBuffer$2$androidxcameravideointernalencoderEncoderImpl$ByteBufferInput(this.f$1);
    }
}
