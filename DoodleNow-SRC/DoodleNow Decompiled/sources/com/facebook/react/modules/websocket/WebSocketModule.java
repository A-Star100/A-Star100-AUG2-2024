package com.facebook.react.modules.websocket;

import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeWebSocketModuleSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.CustomClientBuilder;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.google.common.net.HttpHeaders;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.OkHttpClient;
import okhttp3.WebSocket;
import okio.ByteString;

@ReactModule(name = "WebSocketModule")
public final class WebSocketModule extends NativeWebSocketModuleSpec {
    private static CustomClientBuilder customClientBuilder;
    /* access modifiers changed from: private */
    public final Map<Integer, ContentHandler> mContentHandlers = new ConcurrentHashMap();
    private ForwardingCookieHandler mCookieHandler;
    /* access modifiers changed from: private */
    public final Map<Integer, WebSocket> mWebSocketConnections = new ConcurrentHashMap();

    public interface ContentHandler {
        void onMessage(String str, WritableMap writableMap);

        void onMessage(ByteString byteString, WritableMap writableMap);
    }

    public static void setCustomClientBuilder(CustomClientBuilder customClientBuilder2) {
        customClientBuilder = customClientBuilder2;
    }

    public void addListener(String str) {
    }

    public void removeListeners(double d) {
    }

    public WebSocketModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mCookieHandler = new ForwardingCookieHandler(reactApplicationContext);
    }

    private static void applyCustomBuilder(OkHttpClient.Builder builder) {
        CustomClientBuilder customClientBuilder2 = customClientBuilder;
        if (customClientBuilder2 != null) {
            customClientBuilder2.apply(builder);
        }
    }

    public void invalidate() {
        for (WebSocket close : this.mWebSocketConnections.values()) {
            close.close(1001, (String) null);
        }
        this.mWebSocketConnections.clear();
        this.mContentHandlers.clear();
    }

    /* access modifiers changed from: private */
    public void sendEvent(String str, WritableMap writableMap) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext.hasActiveReactInstance()) {
            reactApplicationContext.emitDeviceEvent(str, writableMap);
        }
    }

    public void setContentHandler(int i, ContentHandler contentHandler) {
        if (contentHandler != null) {
            this.mContentHandlers.put(Integer.valueOf(i), contentHandler);
        } else {
            this.mContentHandlers.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a0, code lost:
        if (r5 == false) goto L_0x00a2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(java.lang.String r10, com.facebook.react.bridge.ReadableArray r11, com.facebook.react.bridge.ReadableMap r12, double r13) {
        /*
            r9 = this;
            int r13 = (int) r13
            okhttp3.OkHttpClient$Builder r14 = new okhttp3.OkHttpClient$Builder
            r14.<init>()
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            r1 = 10
            okhttp3.OkHttpClient$Builder r14 = r14.connectTimeout(r1, r0)
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            okhttp3.OkHttpClient$Builder r14 = r14.writeTimeout(r1, r0)
            r0 = 0
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MINUTES
            okhttp3.OkHttpClient$Builder r14 = r14.readTimeout(r0, r2)
            applyCustomBuilder(r14)
            okhttp3.OkHttpClient r14 = r14.build()
            okhttp3.Request$Builder r0 = new okhttp3.Request$Builder
            r0.<init>()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            okhttp3.Request$Builder r0 = r0.tag(r1)
            okhttp3.Request$Builder r0 = r0.url((java.lang.String) r10)
            java.lang.String r1 = r9.getCookie(r10)
            if (r1 == 0) goto L_0x003f
            java.lang.String r2 = "Cookie"
            r0.addHeader(r2, r1)
        L_0x003f:
            java.lang.String r1 = "origin"
            r2 = 0
            r3 = 1
            if (r12 == 0) goto L_0x00a2
            java.lang.String r4 = "headers"
            boolean r5 = r12.hasKey(r4)
            if (r5 == 0) goto L_0x00a2
            com.facebook.react.bridge.ReadableType r5 = r12.getType(r4)
            com.facebook.react.bridge.ReadableType r6 = com.facebook.react.bridge.ReadableType.Map
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x00a2
            com.facebook.react.bridge.ReadableMap r12 = r12.getMap(r4)
            com.facebook.react.bridge.ReadableMapKeySetIterator r4 = r12.keySetIterator()
            r5 = r2
        L_0x0062:
            boolean r6 = r4.hasNextKey()
            if (r6 == 0) goto L_0x00a0
            java.lang.String r6 = r4.nextKey()
            com.facebook.react.bridge.ReadableType r7 = com.facebook.react.bridge.ReadableType.String
            com.facebook.react.bridge.ReadableType r8 = r12.getType(r6)
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0087
            boolean r7 = r6.equalsIgnoreCase(r1)
            if (r7 == 0) goto L_0x007f
            r5 = r3
        L_0x007f:
            java.lang.String r7 = r12.getString(r6)
            r0.addHeader(r6, r7)
            goto L_0x0062
        L_0x0087:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Ignoring: requested "
            r7.<init>(r8)
            r7.append(r6)
            java.lang.String r6 = ", value not a string"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "ReactNative"
            com.facebook.common.logging.FLog.w((java.lang.String) r7, (java.lang.String) r6)
            goto L_0x0062
        L_0x00a0:
            if (r5 != 0) goto L_0x00a9
        L_0x00a2:
            java.lang.String r10 = getDefaultOrigin(r10)
            r0.addHeader(r1, r10)
        L_0x00a9:
            if (r11 == 0) goto L_0x00f8
            int r10 = r11.size()
            if (r10 <= 0) goto L_0x00f8
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r12 = ""
            r10.<init>(r12)
        L_0x00b8:
            int r1 = r11.size()
            if (r2 >= r1) goto L_0x00dd
            java.lang.String r1 = r11.getString(r2)
            java.lang.String r1 = r1.trim()
            boolean r4 = r1.isEmpty()
            if (r4 != 0) goto L_0x00da
            java.lang.String r4 = ","
            boolean r5 = r1.contains(r4)
            if (r5 != 0) goto L_0x00da
            r10.append(r1)
            r10.append(r4)
        L_0x00da:
            int r2 = r2 + 1
            goto L_0x00b8
        L_0x00dd:
            int r11 = r10.length()
            if (r11 <= 0) goto L_0x00f8
            int r11 = r10.length()
            int r11 = r11 - r3
            int r1 = r10.length()
            r10.replace(r11, r1, r12)
            java.lang.String r11 = "Sec-WebSocket-Protocol"
            java.lang.String r10 = r10.toString()
            r0.addHeader(r11, r10)
        L_0x00f8:
            okhttp3.Request r10 = r0.build()
            com.facebook.react.modules.websocket.WebSocketModule$1 r11 = new com.facebook.react.modules.websocket.WebSocketModule$1
            r11.<init>(r13)
            r14.newWebSocket(r10, r11)
            okhttp3.Dispatcher r10 = r14.dispatcher()
            java.util.concurrent.ExecutorService r10 = r10.executorService()
            r10.shutdown()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.websocket.WebSocketModule.connect(java.lang.String, com.facebook.react.bridge.ReadableArray, com.facebook.react.bridge.ReadableMap, double):void");
    }

    public void close(double d, String str, double d2) {
        int i = (int) d2;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i));
        if (webSocket != null) {
            try {
                webSocket.close((int) d, str);
                this.mWebSocketConnections.remove(Integer.valueOf(i));
                this.mContentHandlers.remove(Integer.valueOf(i));
            } catch (Exception e) {
                FLog.e(ReactConstants.TAG, "Could not close WebSocket connection for id " + i, (Throwable) e);
            }
        }
    }

    public void send(String str, double d) {
        int i = (int) d;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i);
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i);
            createMap2.putInt("code", 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i));
            this.mContentHandlers.remove(Integer.valueOf(i));
            return;
        }
        try {
            webSocket.send(str);
        } catch (Exception e) {
            notifyWebSocketFailed(i, e.getMessage());
        }
    }

    public void sendBinary(String str, double d) {
        int i = (int) d;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i);
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i);
            createMap2.putInt("code", 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i));
            this.mContentHandlers.remove(Integer.valueOf(i));
            return;
        }
        try {
            webSocket.send(ByteString.decodeBase64(str));
        } catch (Exception e) {
            notifyWebSocketFailed(i, e.getMessage());
        }
    }

    public void sendBinary(ByteString byteString, int i) {
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i);
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i);
            createMap2.putInt("code", 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i));
            this.mContentHandlers.remove(Integer.valueOf(i));
            return;
        }
        try {
            webSocket.send(byteString);
        } catch (Exception e) {
            notifyWebSocketFailed(i, e.getMessage());
        }
    }

    public void ping(double d) {
        int i = (int) d;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i);
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i);
            createMap2.putInt("code", 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i));
            this.mContentHandlers.remove(Integer.valueOf(i));
            return;
        }
        try {
            webSocket.send(ByteString.EMPTY);
        } catch (Exception e) {
            notifyWebSocketFailed(i, e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void notifyWebSocketFailed(int i, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", i);
        createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, str);
        sendEvent("websocketFailed", createMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072 A[Catch:{ URISyntaxException -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008d A[Catch:{ URISyntaxException -> 0x009e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getDefaultOrigin(java.lang.String r11) {
        /*
            java.net.URI r0 = new java.net.URI     // Catch:{ URISyntaxException -> 0x009e }
            r0.<init>(r11)     // Catch:{ URISyntaxException -> 0x009e }
            java.lang.String r1 = r0.getScheme()     // Catch:{ URISyntaxException -> 0x009e }
            int r2 = r1.hashCode()     // Catch:{ URISyntaxException -> 0x009e }
            r3 = 3804(0xedc, float:5.33E-42)
            java.lang.String r4 = "https"
            java.lang.String r5 = "http"
            r6 = -1
            r7 = 0
            r8 = 3
            r9 = 2
            r10 = 1
            if (r2 == r3) goto L_0x0044
            r3 = 118039(0x1cd17, float:1.65408E-40)
            if (r2 == r3) goto L_0x003a
            r3 = 3213448(0x310888, float:4.503E-39)
            if (r2 == r3) goto L_0x0032
            r3 = 99617003(0x5f008eb, float:2.2572767E-35)
            if (r2 == r3) goto L_0x002a
            goto L_0x004e
        L_0x002a:
            boolean r1 = r1.equals(r4)     // Catch:{ URISyntaxException -> 0x009e }
            if (r1 == 0) goto L_0x004e
            r1 = r8
            goto L_0x004f
        L_0x0032:
            boolean r1 = r1.equals(r5)     // Catch:{ URISyntaxException -> 0x009e }
            if (r1 == 0) goto L_0x004e
            r1 = r9
            goto L_0x004f
        L_0x003a:
            java.lang.String r2 = "wss"
            boolean r1 = r1.equals(r2)     // Catch:{ URISyntaxException -> 0x009e }
            if (r1 == 0) goto L_0x004e
            r1 = r7
            goto L_0x004f
        L_0x0044:
            java.lang.String r2 = "ws"
            boolean r1 = r1.equals(r2)     // Catch:{ URISyntaxException -> 0x009e }
            if (r1 == 0) goto L_0x004e
            r1 = r10
            goto L_0x004f
        L_0x004e:
            r1 = r6
        L_0x004f:
            if (r1 == 0) goto L_0x006c
            if (r1 == r10) goto L_0x006b
            java.lang.String r4 = ""
            if (r1 == r9) goto L_0x005a
            if (r1 == r8) goto L_0x005a
            goto L_0x006c
        L_0x005a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x009e }
            r1.<init>(r4)     // Catch:{ URISyntaxException -> 0x009e }
            java.lang.String r2 = r0.getScheme()     // Catch:{ URISyntaxException -> 0x009e }
            r1.append(r2)     // Catch:{ URISyntaxException -> 0x009e }
            java.lang.String r4 = r1.toString()     // Catch:{ URISyntaxException -> 0x009e }
            goto L_0x006c
        L_0x006b:
            r4 = r5
        L_0x006c:
            int r1 = r0.getPort()     // Catch:{ URISyntaxException -> 0x009e }
            if (r1 == r6) goto L_0x008d
            java.lang.String r1 = "%s://%s:%s"
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ URISyntaxException -> 0x009e }
            r2[r7] = r4     // Catch:{ URISyntaxException -> 0x009e }
            java.lang.String r3 = r0.getHost()     // Catch:{ URISyntaxException -> 0x009e }
            r2[r10] = r3     // Catch:{ URISyntaxException -> 0x009e }
            int r0 = r0.getPort()     // Catch:{ URISyntaxException -> 0x009e }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ URISyntaxException -> 0x009e }
            r2[r9] = r0     // Catch:{ URISyntaxException -> 0x009e }
            java.lang.String r11 = java.lang.String.format(r1, r2)     // Catch:{ URISyntaxException -> 0x009e }
            goto L_0x009d
        L_0x008d:
            java.lang.String r1 = "%s://%s"
            java.lang.Object[] r2 = new java.lang.Object[r9]     // Catch:{ URISyntaxException -> 0x009e }
            r2[r7] = r4     // Catch:{ URISyntaxException -> 0x009e }
            java.lang.String r0 = r0.getHost()     // Catch:{ URISyntaxException -> 0x009e }
            r2[r10] = r0     // Catch:{ URISyntaxException -> 0x009e }
            java.lang.String r11 = java.lang.String.format(r1, r2)     // Catch:{ URISyntaxException -> 0x009e }
        L_0x009d:
            return r11
        L_0x009e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unable to set "
            r1.<init>(r2)
            r1.append(r11)
            java.lang.String r11 = " as default origin header"
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.websocket.WebSocketModule.getDefaultOrigin(java.lang.String):java.lang.String");
    }

    private String getCookie(String str) {
        try {
            List list = this.mCookieHandler.get(new URI(getDefaultOrigin(str)), new HashMap()).get(HttpHeaders.COOKIE);
            if (list == null) {
                return null;
            }
            if (list.isEmpty()) {
                return null;
            }
            return (String) list.get(0);
        } catch (IOException | URISyntaxException unused) {
            throw new IllegalArgumentException("Unable to get cookie from " + str);
        }
    }
}
