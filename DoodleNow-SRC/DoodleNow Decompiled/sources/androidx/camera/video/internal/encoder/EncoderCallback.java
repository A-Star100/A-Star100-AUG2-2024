package androidx.camera.video.internal.encoder;

public interface EncoderCallback {
    public static final EncoderCallback EMPTY = new EncoderCallback() {
        public void onEncodeError(EncodeException encodeException) {
        }

        public /* synthetic */ void onEncodePaused() {
            CC.$default$onEncodePaused(this);
        }

        public void onEncodeStart() {
        }

        public void onEncodeStop() {
        }

        public void onEncodedData(EncodedData encodedData) {
        }

        public void onOutputConfigUpdate(OutputConfig outputConfig) {
        }
    };

    /* renamed from: androidx.camera.video.internal.encoder.EncoderCallback$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onEncodePaused(EncoderCallback _this) {
        }
    }

    void onEncodeError(EncodeException encodeException);

    void onEncodePaused();

    void onEncodeStart();

    void onEncodeStop();

    void onEncodedData(EncodedData encodedData);

    void onOutputConfigUpdate(OutputConfig outputConfig);
}
