package com.facebook.react.devsupport;

import android.os.Handler;
import android.os.Looper;
import com.facebook.jni.HybridData;
import com.facebook.react.views.text.ReactTextView$$ExternalSyntheticApiModelOutline0;
import java.io.Closeable;
import java.util.OptionalInt;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

class CxxInspectorPackagerConnection implements IInspectorPackagerConnection {
    private final HybridData mHybridData;

    private interface IWebSocket extends Closeable {
        void close();

        void send(String str);
    }

    private static native HybridData initHybrid(String str, String str2, DelegateImpl delegateImpl);

    public native void closeQuietly();

    public native void connect();

    public native void sendEventToAllConnections(String str);

    static {
        DevSupportSoLoader.staticInit();
    }

    public CxxInspectorPackagerConnection(String str, String str2) {
        this.mHybridData = initHybrid(str, str2, new DelegateImpl());
    }

    private static class WebSocketDelegate implements Closeable {
        private final HybridData mHybridData;

        public native void didClose();

        public native void didFailWithError(OptionalInt optionalInt, String str);

        public native void didReceiveMessage(String str);

        public void close() {
            this.mHybridData.resetNative();
        }

        private WebSocketDelegate(HybridData hybridData) {
            this.mHybridData = hybridData;
        }
    }

    private static class DelegateImpl {
        private final Handler mHandler;
        private final OkHttpClient mHttpClient;

        private DelegateImpl() {
            this.mHttpClient = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).readTimeout(0, TimeUnit.MINUTES).build();
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        public IWebSocket connectWebSocket(String str, final WebSocketDelegate webSocketDelegate) {
            final WebSocket newWebSocket = this.mHttpClient.newWebSocket(new Request.Builder().url(str).build(), new WebSocketListener() {
                public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                    String message = th.getMessage();
                    WebSocketDelegate webSocketDelegate = webSocketDelegate;
                    OptionalInt m = ReactTextView$$ExternalSyntheticApiModelOutline0.m();
                    if (message == null) {
                        message = "<Unknown error>";
                    }
                    webSocketDelegate.didFailWithError(m, message);
                    webSocketDelegate.close();
                }

                public void onMessage(WebSocket webSocket, String str) {
                    webSocketDelegate.didReceiveMessage(str);
                }

                public void onClosed(WebSocket webSocket, int i, String str) {
                    webSocketDelegate.didClose();
                    webSocketDelegate.close();
                }
            });
            return new IWebSocket() {
                public void send(String str) {
                    newWebSocket.send(str);
                }

                public void close() {
                    newWebSocket.close(1000, "End of session");
                }
            };
        }

        public void scheduleCallback(Runnable runnable, long j) {
            this.mHandler.postDelayed(runnable, j);
        }
    }
}
