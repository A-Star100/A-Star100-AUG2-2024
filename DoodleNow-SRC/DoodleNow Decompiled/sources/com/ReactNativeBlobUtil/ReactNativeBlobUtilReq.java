package com.ReactNativeBlobUtil;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.polidea.rxandroidble2.ClientComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class ReactNativeBlobUtilReq extends BroadcastReceiver implements Runnable {
    public static HashMap<String, Long> androidDownloadManagerTaskTable = new HashMap<>();
    static ConnectionPool pool = new ConnectionPool();
    static HashMap<String, ReactNativeBlobUtilProgressConfig> progressReport = new HashMap<>();
    public static HashMap<String, Call> taskTable = new HashMap<>();
    static HashMap<String, ReactNativeBlobUtilProgressConfig> uploadProgressReport = new HashMap<>();
    private final int QUERY = 1314;
    Callback callback;
    boolean callbackfired;
    OkHttpClient client;
    long contentLength;
    String destPath;
    long downloadManagerId;
    /* access modifiers changed from: private */
    public Future<?> future;
    ReadableMap headers;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what == 1314 && message.getData().getLong("downloadManagerId") == ReactNativeBlobUtilReq.this.downloadManagerId) {
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(new long[]{ReactNativeBlobUtilReq.this.downloadManagerId});
                Cursor query2 = ((DownloadManager) ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getSystemService("download")).query(query);
                if (query2 != null && query2.moveToFirst()) {
                    long j = (long) query2.getInt(query2.getColumnIndex("bytes_so_far"));
                    long j2 = query2.getLong(query2.getColumnIndex("total_size"));
                    query2.close();
                    ReactNativeBlobUtilProgressConfig reportProgress = ReactNativeBlobUtilReq.getReportProgress(ReactNativeBlobUtilReq.this.taskId);
                    float f = j2 > 0 ? (float) (j / j2) : 0.0f;
                    if (reportProgress != null && reportProgress.shouldReport(f)) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("taskId", String.valueOf(ReactNativeBlobUtilReq.this.taskId));
                        createMap.putString("written", String.valueOf(j));
                        createMap.putString("total", String.valueOf(j2));
                        createMap.putString("chunk", "");
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_PROGRESS, createMap);
                    }
                    if (j2 == j) {
                        ReactNativeBlobUtilReq.this.future.cancel(true);
                    }
                }
            }
            return true;
        }
    });
    String method;
    ReactNativeBlobUtilConfig options;
    String rawRequestBody;
    ReadableArray rawRequestBodyArray;
    ArrayList<String> redirects = new ArrayList<>();
    ReactNativeBlobUtilBody requestBody;
    RequestType requestType;
    WritableMap respInfo;
    ResponseFormat responseFormat = ResponseFormat.Auto;
    ResponseType responseType;
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    String taskId;
    boolean timeout = false;
    String url;

    enum RequestType {
        Form,
        SingleFile,
        AsIs,
        WithoutBody,
        Others
    }

    enum ResponseFormat {
        Auto,
        UTF8,
        BASE64
    }

    enum ResponseType {
        KeepInMemory,
        FileStorage
    }

    public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder builder) {
        return builder;
    }

    private boolean shouldTransformFile() {
        return this.options.transformFile.booleanValue() && (this.options.fileCache.booleanValue() || this.options.path != null);
    }

    public ReactNativeBlobUtilReq(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, ReadableArray readableArray, OkHttpClient okHttpClient, Callback callback2) {
        this.method = str2.toUpperCase(Locale.ROOT);
        ReactNativeBlobUtilConfig reactNativeBlobUtilConfig = new ReactNativeBlobUtilConfig(readableMap);
        this.options = reactNativeBlobUtilConfig;
        this.taskId = str;
        this.url = str3;
        this.headers = readableMap2;
        this.callback = callback2;
        this.rawRequestBody = str4;
        this.rawRequestBodyArray = readableArray;
        this.client = okHttpClient;
        this.callbackfired = false;
        if ((reactNativeBlobUtilConfig.fileCache.booleanValue() || this.options.path != null) && !shouldTransformFile()) {
            this.responseType = ResponseType.FileStorage;
        } else {
            this.responseType = ResponseType.KeepInMemory;
        }
        if (str4 != null) {
            this.requestType = RequestType.SingleFile;
        } else if (readableArray != null) {
            this.requestType = RequestType.Form;
        } else {
            this.requestType = RequestType.WithoutBody;
        }
    }

    public static void cancelTask(String str) {
        Call call = taskTable.get(str);
        if (call != null) {
            call.cancel();
            taskTable.remove(str);
        }
        if (androidDownloadManagerTaskTable.containsKey(str)) {
            ((DownloadManager) ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getSystemService("download")).remove(new long[]{androidDownloadManagerTaskTable.get(str).longValue()});
        }
    }

    /* access modifiers changed from: private */
    public void invoke_callback(Object... objArr) {
        if (!this.callbackfired) {
            this.callback.invoke(objArr);
            this.callbackfired = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:166:0x0403 A[Catch:{ Exception -> 0x054a }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0492 A[Catch:{ Exception -> 0x054a }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x04fa A[Catch:{ Exception -> 0x054a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = ";base64"
            java.lang.String r3 = "post"
            java.lang.String r4 = "Content-Type"
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r5 = "."
            java.lang.String r6 = "path"
            r7 = 2
            r8 = 1
            if (r0 == 0) goto L_0x01d2
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r9 = "useDownloadManager"
            boolean r0 = r0.hasKey(r9)
            if (r0 == 0) goto L_0x01d2
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.getBoolean(r9)
            if (r0 == 0) goto L_0x01d2
            java.lang.String r0 = r1.url
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.app.DownloadManager$Request r2 = new android.app.DownloadManager$Request
            r2.<init>(r0)
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "notification"
            boolean r0 = r0.hasKey(r3)
            if (r0 == 0) goto L_0x0050
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.getBoolean(r3)
            if (r0 == 0) goto L_0x0050
            r2.setNotificationVisibility(r8)
            goto L_0x0053
        L_0x0050:
            r2.setNotificationVisibility(r7)
        L_0x0053:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "title"
            boolean r0 = r0.hasKey(r3)
            if (r0 == 0) goto L_0x006a
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r3)
            r2.setTitle(r0)
        L_0x006a:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r4 = "description"
            boolean r0 = r0.hasKey(r4)
            if (r0 == 0) goto L_0x0081
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r4)
            r2.setDescription(r0)
        L_0x0081:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.hasKey(r6)
            if (r0 == 0) goto L_0x00a8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "file://"
            r0.<init>(r4)
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r4 = r1.options
            com.facebook.react.bridge.ReadableMap r4 = r4.addAndroidDownloads
            java.lang.String r4 = r4.getString(r6)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r2.setDestinationUri(r0)
        L_0x00a8:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r4 = "mime"
            boolean r0 = r0.hasKey(r4)
            if (r0 == 0) goto L_0x00bf
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r4)
            r2.setMimeType(r0)
        L_0x00bf:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r4 = "mediaScannable"
            boolean r0 = r0.hasKey(r4)
            if (r0 == 0) goto L_0x00d8
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.getBoolean(r4)
            if (r0 == 0) goto L_0x00d8
            r2.allowScanningByMediaScanner()
        L_0x00d8:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r0 < r4) goto L_0x0137
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r4 = "storeInDownloads"
            boolean r0 = r0.hasKey(r4)
            if (r0 == 0) goto L_0x0137
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.getBoolean(r4)
            if (r0 == 0) goto L_0x0137
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r3)
            if (r0 == 0) goto L_0x0104
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x010c
        L_0x0104:
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
        L_0x010c:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r3 = r1.options
            java.lang.String r3 = r3.appendExt
            if (r3 == 0) goto L_0x0132
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r3 = r1.options
            java.lang.String r3 = r3.appendExt
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0132
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r5)
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            java.lang.String r0 = r0.appendExt
            r3.append(r0)
            java.lang.String r0 = r3.toString()
        L_0x0132:
            java.lang.String r3 = android.os.Environment.DIRECTORY_DOWNLOADS
            r2.setDestinationInExternalPublicDir(r3, r0)
        L_0x0137:
            com.facebook.react.bridge.ReadableMap r0 = r1.headers
            com.facebook.react.bridge.ReadableMapKeySetIterator r0 = r0.keySetIterator()
        L_0x013d:
            boolean r3 = r0.hasNextKey()
            if (r3 == 0) goto L_0x0151
            java.lang.String r3 = r0.nextKey()
            com.facebook.react.bridge.ReadableMap r4 = r1.headers
            java.lang.String r4 = r4.getString(r3)
            r2.addRequestHeader(r3, r4)
            goto L_0x013d
        L_0x0151:
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0182 }
            java.lang.String r3 = r1.url     // Catch:{ MalformedURLException -> 0x0182 }
            r0.<init>(r3)     // Catch:{ MalformedURLException -> 0x0182 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0182 }
            r3.<init>()     // Catch:{ MalformedURLException -> 0x0182 }
            java.lang.String r4 = r0.getProtocol()     // Catch:{ MalformedURLException -> 0x0182 }
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x0182 }
            java.lang.String r4 = "://"
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x0182 }
            java.lang.String r0 = r0.getHost()     // Catch:{ MalformedURLException -> 0x0182 }
            r3.append(r0)     // Catch:{ MalformedURLException -> 0x0182 }
            java.lang.String r0 = r3.toString()     // Catch:{ MalformedURLException -> 0x0182 }
            android.webkit.CookieManager r3 = android.webkit.CookieManager.getInstance()     // Catch:{ MalformedURLException -> 0x0182 }
            java.lang.String r0 = r3.getCookie(r0)     // Catch:{ MalformedURLException -> 0x0182 }
            java.lang.String r3 = "Cookie"
            r2.addRequestHeader(r3, r0)     // Catch:{ MalformedURLException -> 0x0182 }
            goto L_0x0186
        L_0x0182:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0186:
            com.facebook.react.bridge.ReactApplicationContext r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r3 = "download"
            java.lang.Object r3 = r0.getSystemService(r3)
            android.app.DownloadManager r3 = (android.app.DownloadManager) r3
            long r2 = r3.enqueue(r2)
            r1.downloadManagerId = r2
            java.util.HashMap<java.lang.String, java.lang.Long> r4 = androidDownloadManagerTaskTable
            java.lang.String r5 = r1.taskId
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r4.put(r5, r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 34
            java.lang.String r4 = "android.intent.action.DOWNLOAD_COMPLETE"
            if (r2 < r3) goto L_0x01b6
            android.content.IntentFilter r2 = new android.content.IntentFilter
            r2.<init>(r4)
            android.content.Intent unused = r0.registerReceiver(r1, r2, r7)
            goto L_0x01be
        L_0x01b6:
            android.content.IntentFilter r2 = new android.content.IntentFilter
            r2.<init>(r4)
            r0.registerReceiver(r1, r2)
        L_0x01be:
            java.util.concurrent.ScheduledExecutorService r5 = r1.scheduledExecutorService
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$2 r6 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$2
            r6.<init>()
            r7 = 0
            r9 = 100
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.ScheduledFuture r0 = r5.scheduleAtFixedRate(r6, r7, r9, r11)
            r1.future = r0
            return
        L_0x01d2:
            java.lang.String r0 = r1.taskId
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r9 = r1.options
            java.lang.String r9 = r9.appendExt
            java.lang.String r10 = ""
            if (r9 == 0) goto L_0x01f8
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r9 = r1.options
            java.lang.String r9 = r9.appendExt
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x01e7
            goto L_0x01f8
        L_0x01e7:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r5)
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r5 = r1.options
            java.lang.String r5 = r5.appendExt
            r9.append(r5)
            java.lang.String r5 = r9.toString()
            goto L_0x01f9
        L_0x01f8:
            r5 = r10
        L_0x01f9:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r9 = r1.options
            java.lang.String r9 = r9.key
            r11 = 3
            r12 = 0
            r13 = 0
            if (r9 == 0) goto L_0x023c
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            java.lang.String r0 = r0.key
            java.lang.String r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.getMD5(r0)
            if (r0 != 0) goto L_0x020e
            java.lang.String r0 = r1.taskId
        L_0x020e:
            java.io.File r9 = new java.io.File
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.getTmpPath(r0)
            r14.append(r15)
            r14.append(r5)
            java.lang.String r14 = r14.toString()
            r9.<init>(r14)
            boolean r14 = r9.exists()
            if (r14 == 0) goto L_0x023c
            java.lang.Object[] r0 = new java.lang.Object[r11]
            r0[r13] = r12
            r0[r8] = r6
            java.lang.String r2 = r9.getAbsolutePath()
            r0[r7] = r2
            r1.invoke_callback(r0)
            return
        L_0x023c:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r6 = r1.options
            java.lang.String r6 = r6.path
            if (r6 == 0) goto L_0x0249
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            java.lang.String r0 = r0.path
            r1.destPath = r0
            goto L_0x0268
        L_0x0249:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r6 = r1.options
            java.lang.Boolean r6 = r6.fileCache
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0268
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.getTmpPath(r0)
            r6.append(r0)
            r6.append(r5)
            java.lang.String r0 = r6.toString()
            r1.destPath = r0
        L_0x0268:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options     // Catch:{ Exception -> 0x054a }
            java.lang.Boolean r0 = r0.trusty     // Catch:{ Exception -> 0x054a }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x054a }
            if (r0 == 0) goto L_0x0279
            okhttp3.OkHttpClient r0 = r1.client     // Catch:{ Exception -> 0x054a }
            okhttp3.OkHttpClient$Builder r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.getUnsafeOkHttpClient(r0)     // Catch:{ Exception -> 0x054a }
            goto L_0x027f
        L_0x0279:
            okhttp3.OkHttpClient r0 = r1.client     // Catch:{ Exception -> 0x054a }
            okhttp3.OkHttpClient$Builder r0 = r0.newBuilder()     // Catch:{ Exception -> 0x054a }
        L_0x027f:
            r5 = r0
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options     // Catch:{ Exception -> 0x054a }
            java.lang.Boolean r0 = r0.wifiOnly     // Catch:{ Exception -> 0x054a }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x054a }
            if (r0 == 0) goto L_0x02dd
            com.facebook.react.bridge.ReactApplicationContext r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext     // Catch:{ Exception -> 0x054a }
            com.facebook.react.bridge.ReactApplicationContext r6 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext     // Catch:{ Exception -> 0x054a }
            java.lang.String r6 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r6)     // Catch:{ Exception -> 0x054a }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ Exception -> 0x054a }
            android.net.Network[] r6 = r0.getAllNetworks()     // Catch:{ Exception -> 0x054a }
            int r9 = r6.length     // Catch:{ Exception -> 0x054a }
            r14 = r13
        L_0x029c:
            if (r14 >= r9) goto L_0x02cb
            r15 = r6[r14]     // Catch:{ Exception -> 0x054a }
            android.net.NetworkInfo r16 = r0.getNetworkInfo(r15)     // Catch:{ Exception -> 0x054a }
            android.net.NetworkCapabilities r7 = r0.getNetworkCapabilities(r15)     // Catch:{ Exception -> 0x054a }
            if (r7 == 0) goto L_0x02c7
            if (r16 != 0) goto L_0x02ad
            goto L_0x02c7
        L_0x02ad:
            boolean r16 = r16.isConnected()     // Catch:{ Exception -> 0x054a }
            if (r16 != 0) goto L_0x02b4
            goto L_0x02c7
        L_0x02b4:
            boolean r7 = r7.hasTransport(r8)     // Catch:{ Exception -> 0x054a }
            if (r7 == 0) goto L_0x02c7
            java.net.Proxy r0 = java.net.Proxy.NO_PROXY     // Catch:{ Exception -> 0x054a }
            r5.proxy(r0)     // Catch:{ Exception -> 0x054a }
            javax.net.SocketFactory r0 = r15.getSocketFactory()     // Catch:{ Exception -> 0x054a }
            r5.socketFactory(r0)     // Catch:{ Exception -> 0x054a }
            goto L_0x02dd
        L_0x02c7:
            int r14 = r14 + 1
            r7 = 2
            goto L_0x029c
        L_0x02cb:
            java.lang.Object[] r0 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x054a }
            java.lang.String r2 = "No available WiFi connections."
            r0[r13] = r2     // Catch:{ Exception -> 0x054a }
            r0[r8] = r12     // Catch:{ Exception -> 0x054a }
            r2 = 2
            r0[r2] = r12     // Catch:{ Exception -> 0x054a }
            r1.invoke_callback(r0)     // Catch:{ Exception -> 0x054a }
            r17.releaseTaskResource()     // Catch:{ Exception -> 0x054a }
            return
        L_0x02dd:
            okhttp3.Request$Builder r6 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x054a }
            r6.<init>()     // Catch:{ Exception -> 0x054a }
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x02ed }
            java.lang.String r7 = r1.url     // Catch:{ MalformedURLException -> 0x02ed }
            r0.<init>(r7)     // Catch:{ MalformedURLException -> 0x02ed }
            r6.url((java.net.URL) r0)     // Catch:{ MalformedURLException -> 0x02ed }
            goto L_0x02f1
        L_0x02ed:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x054a }
        L_0x02f1:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x054a }
            r0.<init>()     // Catch:{ Exception -> 0x054a }
            com.facebook.react.bridge.ReadableMap r7 = r1.headers     // Catch:{ Exception -> 0x054a }
            if (r7 == 0) goto L_0x0344
            com.facebook.react.bridge.ReadableMapKeySetIterator r7 = r7.keySetIterator()     // Catch:{ Exception -> 0x054a }
        L_0x02fe:
            boolean r9 = r7.hasNextKey()     // Catch:{ Exception -> 0x054a }
            if (r9 == 0) goto L_0x0344
            java.lang.String r9 = r7.nextKey()     // Catch:{ Exception -> 0x054a }
            com.facebook.react.bridge.ReadableMap r14 = r1.headers     // Catch:{ Exception -> 0x054a }
            java.lang.String r14 = r14.getString(r9)     // Catch:{ Exception -> 0x054a }
            java.lang.String r15 = "RNFB-Response"
            boolean r15 = r9.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x054a }
            if (r15 == 0) goto L_0x0331
            java.lang.String r9 = "base64"
            boolean r9 = r14.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x054a }
            if (r9 == 0) goto L_0x0323
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseFormat.BASE64     // Catch:{ Exception -> 0x054a }
            r1.responseFormat = r9     // Catch:{ Exception -> 0x054a }
            goto L_0x02fe
        L_0x0323:
            java.lang.String r9 = "utf8"
            boolean r9 = r14.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x054a }
            if (r9 == 0) goto L_0x02fe
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseFormat.UTF8     // Catch:{ Exception -> 0x054a }
            r1.responseFormat = r9     // Catch:{ Exception -> 0x054a }
            goto L_0x02fe
        L_0x0331:
            java.util.Locale r15 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x054a }
            java.lang.String r15 = r9.toLowerCase(r15)     // Catch:{ Exception -> 0x054a }
            r6.header(r15, r14)     // Catch:{ Exception -> 0x054a }
            java.util.Locale r15 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x054a }
            java.lang.String r9 = r9.toLowerCase(r15)     // Catch:{ Exception -> 0x054a }
            r0.put(r9, r14)     // Catch:{ Exception -> 0x054a }
            goto L_0x02fe
        L_0x0344:
            java.lang.String r7 = r1.method     // Catch:{ Exception -> 0x054a }
            boolean r7 = r7.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x054a }
            java.lang.String r9 = "patch"
            java.lang.String r14 = "put"
            java.lang.String r15 = "content-type"
            if (r7 != 0) goto L_0x0369
            java.lang.String r7 = r1.method     // Catch:{ Exception -> 0x054a }
            boolean r7 = r7.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x054a }
            if (r7 != 0) goto L_0x0369
            java.lang.String r7 = r1.method     // Catch:{ Exception -> 0x054a }
            boolean r7 = r7.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x054a }
            if (r7 == 0) goto L_0x0363
            goto L_0x0369
        L_0x0363:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.WithoutBody     // Catch:{ Exception -> 0x054a }
            r1.requestType = r2     // Catch:{ Exception -> 0x054a }
            goto L_0x03ef
        L_0x0369:
            java.lang.String r7 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x054a }
            java.util.Locale r13 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x054a }
            java.lang.String r7 = r7.toLowerCase(r13)     // Catch:{ Exception -> 0x054a }
            com.facebook.react.bridge.ReadableArray r13 = r1.rawRequestBodyArray     // Catch:{ Exception -> 0x054a }
            if (r13 == 0) goto L_0x037c
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r13 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.Form     // Catch:{ Exception -> 0x054a }
            r1.requestType = r13     // Catch:{ Exception -> 0x054a }
            goto L_0x0393
        L_0x037c:
            if (r7 == 0) goto L_0x0384
            boolean r13 = r7.isEmpty()     // Catch:{ Exception -> 0x054a }
            if (r13 == 0) goto L_0x0393
        L_0x0384:
            boolean r13 = r7.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x054a }
            if (r13 != 0) goto L_0x038f
            java.lang.String r13 = "application/octet-stream"
            r6.header(r4, r13)     // Catch:{ Exception -> 0x054a }
        L_0x038f:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r13 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.SingleFile     // Catch:{ Exception -> 0x054a }
            r1.requestType = r13     // Catch:{ Exception -> 0x054a }
        L_0x0393:
            java.lang.String r13 = r1.rawRequestBody     // Catch:{ Exception -> 0x054a }
            if (r13 == 0) goto L_0x03ef
            java.lang.String r12 = "ReactNativeBlobUtil-file://"
            boolean r12 = r13.startsWith(r12)     // Catch:{ Exception -> 0x054a }
            if (r12 != 0) goto L_0x03eb
            java.lang.String r12 = r1.rawRequestBody     // Catch:{ Exception -> 0x054a }
            java.lang.String r13 = "ReactNativeBlobUtil-content://"
            boolean r12 = r12.startsWith(r13)     // Catch:{ Exception -> 0x054a }
            if (r12 == 0) goto L_0x03aa
            goto L_0x03eb
        L_0x03aa:
            java.util.Locale r12 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x054a }
            java.lang.String r12 = r7.toLowerCase(r12)     // Catch:{ Exception -> 0x054a }
            boolean r12 = r12.contains(r2)     // Catch:{ Exception -> 0x054a }
            if (r12 != 0) goto L_0x03ca
            java.util.Locale r12 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x054a }
            java.lang.String r12 = r7.toLowerCase(r12)     // Catch:{ Exception -> 0x054a }
            java.lang.String r13 = "application/octet"
            boolean r12 = r12.startsWith(r13)     // Catch:{ Exception -> 0x054a }
            if (r12 == 0) goto L_0x03c5
            goto L_0x03ca
        L_0x03c5:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.AsIs     // Catch:{ Exception -> 0x054a }
            r1.requestType = r2     // Catch:{ Exception -> 0x054a }
            goto L_0x03ef
        L_0x03ca:
            java.lang.String r2 = r7.replace(r2, r10)     // Catch:{ Exception -> 0x054a }
            java.lang.String r7 = ";BASE64"
            java.lang.String r2 = r2.replace(r7, r10)     // Catch:{ Exception -> 0x054a }
            boolean r7 = r0.containsKey(r15)     // Catch:{ Exception -> 0x054a }
            if (r7 == 0) goto L_0x03dd
            r0.put(r15, r2)     // Catch:{ Exception -> 0x054a }
        L_0x03dd:
            boolean r7 = r0.containsKey(r4)     // Catch:{ Exception -> 0x054a }
            if (r7 == 0) goto L_0x03e6
            r0.put(r4, r2)     // Catch:{ Exception -> 0x054a }
        L_0x03e6:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.SingleFile     // Catch:{ Exception -> 0x054a }
            r1.requestType = r2     // Catch:{ Exception -> 0x054a }
            goto L_0x03ef
        L_0x03eb:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.SingleFile     // Catch:{ Exception -> 0x054a }
            r1.requestType = r2     // Catch:{ Exception -> 0x054a }
        L_0x03ef:
            java.lang.String r2 = "Transfer-Encoding"
            java.lang.String r2 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x054a }
            java.lang.String r4 = "chunked"
            boolean r2 = r2.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r4 = r1.requestType     // Catch:{ Exception -> 0x054a }
            int r4 = r4.ordinal()     // Catch:{ Exception -> 0x054a }
            if (r4 == 0) goto L_0x0492
            if (r4 == r8) goto L_0x0467
            r7 = 2
            if (r4 == r7) goto L_0x043c
            if (r4 == r11) goto L_0x040c
            goto L_0x04dc
        L_0x040c:
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x054a }
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x054a }
            if (r0 != 0) goto L_0x042d
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x054a }
            boolean r0 = r0.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x054a }
            if (r0 != 0) goto L_0x042d
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x054a }
            boolean r0 = r0.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x054a }
            if (r0 == 0) goto L_0x0425
            goto L_0x042d
        L_0x0425:
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x054a }
            r2 = 0
            r6.method(r0, r2)     // Catch:{ Exception -> 0x054a }
            goto L_0x04dc
        L_0x042d:
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x054a }
            r2 = 0
            byte[] r3 = new byte[r2]     // Catch:{ Exception -> 0x054a }
            r2 = 0
            okhttp3.RequestBody r2 = okhttp3.RequestBody.create((okhttp3.MediaType) r2, (byte[]) r3)     // Catch:{ Exception -> 0x054a }
            r6.method(r0, r2)     // Catch:{ Exception -> 0x054a }
            goto L_0x04dc
        L_0x043c:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r3 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilBody     // Catch:{ Exception -> 0x054a }
            java.lang.String r4 = r1.taskId     // Catch:{ Exception -> 0x054a }
            r3.<init>(r4)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r3.chunkedEncoding(r2)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r3 = r1.requestType     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setRequestType(r3)     // Catch:{ Exception -> 0x054a }
            java.lang.String r3 = r1.rawRequestBody     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setBody((java.lang.String) r3)     // Catch:{ Exception -> 0x054a }
            java.lang.String r0 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r15)     // Catch:{ Exception -> 0x054a }
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r0 = r2.setMIME(r0)     // Catch:{ Exception -> 0x054a }
            r1.requestBody = r0     // Catch:{ Exception -> 0x054a }
            java.lang.String r2 = r1.method     // Catch:{ Exception -> 0x054a }
            r6.method(r2, r0)     // Catch:{ Exception -> 0x054a }
            goto L_0x04dc
        L_0x0467:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r3 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilBody     // Catch:{ Exception -> 0x054a }
            java.lang.String r4 = r1.taskId     // Catch:{ Exception -> 0x054a }
            r3.<init>(r4)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r3.chunkedEncoding(r2)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r3 = r1.requestType     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setRequestType(r3)     // Catch:{ Exception -> 0x054a }
            java.lang.String r3 = r1.rawRequestBody     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setBody((java.lang.String) r3)     // Catch:{ Exception -> 0x054a }
            java.lang.String r0 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r15)     // Catch:{ Exception -> 0x054a }
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r0 = r2.setMIME(r0)     // Catch:{ Exception -> 0x054a }
            r1.requestBody = r0     // Catch:{ Exception -> 0x054a }
            java.lang.String r2 = r1.method     // Catch:{ Exception -> 0x054a }
            r6.method(r2, r0)     // Catch:{ Exception -> 0x054a }
            goto L_0x04dc
        L_0x0492:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x054a }
            r0.<init>()     // Catch:{ Exception -> 0x054a }
            java.lang.String r3 = "ReactNativeBlobUtil-"
            r0.append(r3)     // Catch:{ Exception -> 0x054a }
            java.lang.String r3 = r1.taskId     // Catch:{ Exception -> 0x054a }
            r0.append(r3)     // Catch:{ Exception -> 0x054a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r3 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilBody     // Catch:{ Exception -> 0x054a }
            java.lang.String r4 = r1.taskId     // Catch:{ Exception -> 0x054a }
            r3.<init>(r4)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r3.chunkedEncoding(r2)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r3 = r1.requestType     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setRequestType(r3)     // Catch:{ Exception -> 0x054a }
            com.facebook.react.bridge.ReadableArray r3 = r1.rawRequestBodyArray     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setBody((com.facebook.react.bridge.ReadableArray) r3)     // Catch:{ Exception -> 0x054a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x054a }
            r3.<init>()     // Catch:{ Exception -> 0x054a }
            java.lang.String r4 = "multipart/form-data; boundary="
            r3.append(r4)     // Catch:{ Exception -> 0x054a }
            r3.append(r0)     // Catch:{ Exception -> 0x054a }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x054a }
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r0 = r2.setMIME(r0)     // Catch:{ Exception -> 0x054a }
            r1.requestBody = r0     // Catch:{ Exception -> 0x054a }
            java.lang.String r2 = r1.method     // Catch:{ Exception -> 0x054a }
            r6.method(r2, r0)     // Catch:{ Exception -> 0x054a }
        L_0x04dc:
            okhttp3.Request r0 = r6.build()     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$3 r2 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$3     // Catch:{ Exception -> 0x054a }
            r2.<init>()     // Catch:{ Exception -> 0x054a }
            r5.addNetworkInterceptor(r2)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$4 r2 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$4     // Catch:{ Exception -> 0x054a }
            r2.<init>(r0)     // Catch:{ Exception -> 0x054a }
            r5.addInterceptor(r2)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r2 = r1.options     // Catch:{ Exception -> 0x054a }
            long r2 = r2.timeout     // Catch:{ Exception -> 0x054a }
            r6 = 0
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x050c
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r2 = r1.options     // Catch:{ Exception -> 0x054a }
            long r2 = r2.timeout     // Catch:{ Exception -> 0x054a }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x054a }
            r5.connectTimeout(r2, r4)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r2 = r1.options     // Catch:{ Exception -> 0x054a }
            long r2 = r2.timeout     // Catch:{ Exception -> 0x054a }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x054a }
            r5.readTimeout(r2, r4)     // Catch:{ Exception -> 0x054a }
        L_0x050c:
            okhttp3.ConnectionPool r2 = pool     // Catch:{ Exception -> 0x054a }
            r5.connectionPool(r2)     // Catch:{ Exception -> 0x054a }
            r2 = 0
            r5.retryOnConnectionFailure(r2)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r2 = r1.options     // Catch:{ Exception -> 0x054a }
            java.lang.Boolean r2 = r2.followRedirect     // Catch:{ Exception -> 0x054a }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x054a }
            r5.followRedirects(r2)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r2 = r1.options     // Catch:{ Exception -> 0x054a }
            java.lang.Boolean r2 = r2.followRedirect     // Catch:{ Exception -> 0x054a }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x054a }
            r5.followSslRedirects(r2)     // Catch:{ Exception -> 0x054a }
            r5.retryOnConnectionFailure(r8)     // Catch:{ Exception -> 0x054a }
            okhttp3.OkHttpClient$Builder r2 = enableTls12OnPreLollipop(r5)     // Catch:{ Exception -> 0x054a }
            okhttp3.OkHttpClient r2 = r2.build()     // Catch:{ Exception -> 0x054a }
            okhttp3.Call r0 = r2.newCall(r0)     // Catch:{ Exception -> 0x054a }
            java.util.HashMap<java.lang.String, okhttp3.Call> r2 = taskTable     // Catch:{ Exception -> 0x054a }
            java.lang.String r3 = r1.taskId     // Catch:{ Exception -> 0x054a }
            r2.put(r3, r0)     // Catch:{ Exception -> 0x054a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$5 r2 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$5     // Catch:{ Exception -> 0x054a }
            r2.<init>()     // Catch:{ Exception -> 0x054a }
            r0.enqueue(r2)     // Catch:{ Exception -> 0x054a }
            goto L_0x0572
        L_0x054a:
            r0 = move-exception
            r0.printStackTrace()
            r17.releaseTaskResource()
            java.lang.Object[] r2 = new java.lang.Object[r8]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "ReactNativeBlobUtil request error: "
            r3.<init>(r4)
            java.lang.String r4 = r0.getMessage()
            r3.append(r4)
            java.lang.Throwable r0 = r0.getCause()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r3 = 0
            r2[r3] = r0
            r1.invoke_callback(r2)
        L_0x0572:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.run():void");
    }

    /* access modifiers changed from: private */
    public void releaseTaskResource() {
        if (taskTable.containsKey(this.taskId)) {
            taskTable.remove(this.taskId);
        }
        if (androidDownloadManagerTaskTable.containsKey(this.taskId)) {
            androidDownloadManagerTaskTable.remove(this.taskId);
        }
        if (uploadProgressReport.containsKey(this.taskId)) {
            uploadProgressReport.remove(this.taskId);
        }
        if (progressReport.containsKey(this.taskId)) {
            progressReport.remove(this.taskId);
        }
        ReactNativeBlobUtilBody reactNativeBlobUtilBody = this.requestBody;
        if (reactNativeBlobUtilBody != null) {
            reactNativeBlobUtilBody.clearRequestBody();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:82|83|84|85|(1:87)(1:88)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|(1:16)(1:15)) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a6, code lost:
        if (r0 != null) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b8, code lost:
        if (r0.source().buffer().size() > 0) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ba, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00bc, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c3, code lost:
        if (r0.contentLength() > 0) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c5, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c7, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d0, code lost:
        r13 = r0.string();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d3, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d6, code lost:
        invoke_callback("Unexpected FileStorage response file: " + r13, r4.copy());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f2, code lost:
        invoke_callback("Unexpected FileStorage response with no file.", r4.copy());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x006f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:84:0x0215 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x021b A[Catch:{ IOException -> 0x024a }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0233 A[Catch:{ IOException -> 0x024a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void done(okhttp3.Response r17) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            java.lang.String r3 = "Error from file transformer:"
            boolean r0 = r16.isBlobResponse(r17)
            com.facebook.react.bridge.WritableMap r4 = r1.getResponseInfo(r2, r0)
            com.facebook.react.bridge.WritableMap r5 = r4.copy()
            r1.emitStateEvent(r5)
            com.facebook.react.bridge.WritableMap r5 = r1.getResponseInfo(r2, r0)
            r1.emitStateEvent(r5)
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseType r5 = r1.responseType
            int r5 = r5.ordinal()
            java.lang.String r6 = "UTF-8"
            java.lang.String r7 = ""
            java.lang.String r8 = "?append=true"
            java.lang.String r9 = "path"
            java.lang.String r10 = "utf8"
            r11 = 4
            r13 = 0
            r14 = 2
            r15 = 0
            r12 = 1
            if (r5 == 0) goto L_0x0102
            if (r5 == r12) goto L_0x0068
            java.lang.Object[] r0 = new java.lang.Object[r11]     // Catch:{ IOException -> 0x0057 }
            r0[r15] = r13     // Catch:{ IOException -> 0x0057 }
            r0[r12] = r10     // Catch:{ IOException -> 0x0057 }
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x0057 }
            okhttp3.ResponseBody r5 = r17.body()     // Catch:{ IOException -> 0x0057 }
            byte[] r5 = r5.bytes()     // Catch:{ IOException -> 0x0057 }
            r3.<init>(r5, r6)     // Catch:{ IOException -> 0x0057 }
            r0[r14] = r3     // Catch:{ IOException -> 0x0057 }
            com.facebook.react.bridge.WritableMap r3 = r4.copy()     // Catch:{ IOException -> 0x0057 }
            r5 = 3
            r0[r5] = r3     // Catch:{ IOException -> 0x0057 }
            r1.invoke_callback(r0)     // Catch:{ IOException -> 0x0057 }
            goto L_0x0259
        L_0x0057:
            java.lang.Object[] r0 = new java.lang.Object[r14]
            java.lang.String r3 = "ReactNativeBlobUtil failed to encode response data to UTF8 string."
            r0[r15] = r3
            com.facebook.react.bridge.WritableMap r3 = r4.copy()
            r0[r12] = r3
            r1.invoke_callback(r0)
            goto L_0x0259
        L_0x0068:
            okhttp3.ResponseBody r0 = r17.body()
            r0.bytes()     // Catch:{ Exception -> 0x006f }
        L_0x006f:
            com.ReactNativeBlobUtil.Response.ReactNativeBlobUtilFileResp r0 = (com.ReactNativeBlobUtil.Response.ReactNativeBlobUtilFileResp) r0     // Catch:{ ClassCastException -> 0x00a6 }
            if (r0 == 0) goto L_0x008a
            boolean r0 = r0.isDownloadComplete()
            if (r0 != 0) goto L_0x008a
            java.lang.Object[] r0 = new java.lang.Object[r14]
            java.lang.String r3 = "Download interrupted."
            r0[r15] = r3
            com.facebook.react.bridge.WritableMap r3 = r4.copy()
            r0[r12] = r3
            r1.invoke_callback(r0)
            goto L_0x0259
        L_0x008a:
            java.lang.String r0 = r1.destPath
            java.lang.String r0 = r0.replace(r8, r7)
            r1.destPath = r0
            java.lang.Object[] r3 = new java.lang.Object[r11]
            r3[r15] = r13
            r3[r12] = r9
            r3[r14] = r0
            com.facebook.react.bridge.WritableMap r0 = r4.copy()
            r4 = 3
            r3[r4] = r0
            r1.invoke_callback(r3)
            goto L_0x0259
        L_0x00a6:
            if (r0 == 0) goto L_0x00f2
            okio.BufferedSource r2 = r0.source()     // Catch:{ IOException -> 0x00d2 }
            okio.Buffer r2 = r2.buffer()     // Catch:{ IOException -> 0x00d2 }
            long r2 = r2.size()     // Catch:{ IOException -> 0x00d2 }
            r5 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x00bc
            r2 = r12
            goto L_0x00bd
        L_0x00bc:
            r2 = r15
        L_0x00bd:
            long r7 = r0.contentLength()     // Catch:{ IOException -> 0x00d2 }
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00c7
            r3 = r12
            goto L_0x00c8
        L_0x00c7:
            r3 = r15
        L_0x00c8:
            if (r2 == 0) goto L_0x00d6
            if (r3 == 0) goto L_0x00d6
            java.lang.String r0 = r0.string()     // Catch:{ IOException -> 0x00d2 }
            r13 = r0
            goto L_0x00d6
        L_0x00d2:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00d6:
            java.lang.Object[] r0 = new java.lang.Object[r14]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unexpected FileStorage response file: "
            r2.<init>(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0[r15] = r2
            com.facebook.react.bridge.WritableMap r2 = r4.copy()
            r0[r12] = r2
            r1.invoke_callback(r0)
            goto L_0x0101
        L_0x00f2:
            java.lang.Object[] r0 = new java.lang.Object[r14]
            java.lang.String r2 = "Unexpected FileStorage response with no file."
            r0[r15] = r2
            com.facebook.react.bridge.WritableMap r2 = r4.copy()
            r0[r12] = r2
            r1.invoke_callback(r0)
        L_0x0101:
            return
        L_0x0102:
            if (r0 == 0) goto L_0x0152
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options     // Catch:{ IOException -> 0x024a }
            java.lang.Boolean r0 = r0.auto     // Catch:{ IOException -> 0x024a }
            boolean r0 = r0.booleanValue()     // Catch:{ IOException -> 0x024a }
            if (r0 == 0) goto L_0x0152
            java.lang.String r0 = r1.taskId     // Catch:{ IOException -> 0x024a }
            java.lang.String r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.getTmpPath(r0)     // Catch:{ IOException -> 0x024a }
            okhttp3.ResponseBody r3 = r17.body()     // Catch:{ IOException -> 0x024a }
            java.io.InputStream r3 = r3.byteStream()     // Catch:{ IOException -> 0x024a }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x024a }
            java.io.File r6 = new java.io.File     // Catch:{ IOException -> 0x024a }
            r6.<init>(r0)     // Catch:{ IOException -> 0x024a }
            r5.<init>(r6)     // Catch:{ IOException -> 0x024a }
            r6 = 10240(0x2800, float:1.4349E-41)
            byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x024a }
        L_0x012a:
            int r7 = r3.read(r6)     // Catch:{ IOException -> 0x024a }
            r8 = -1
            if (r7 == r8) goto L_0x0135
            r5.write(r6, r15, r7)     // Catch:{ IOException -> 0x024a }
            goto L_0x012a
        L_0x0135:
            r3.close()     // Catch:{ IOException -> 0x024a }
            r5.flush()     // Catch:{ IOException -> 0x024a }
            r5.close()     // Catch:{ IOException -> 0x024a }
            java.lang.Object[] r3 = new java.lang.Object[r11]     // Catch:{ IOException -> 0x024a }
            r3[r15] = r13     // Catch:{ IOException -> 0x024a }
            r3[r12] = r9     // Catch:{ IOException -> 0x024a }
            r3[r14] = r0     // Catch:{ IOException -> 0x024a }
            com.facebook.react.bridge.WritableMap r0 = r4.copy()     // Catch:{ IOException -> 0x024a }
            r5 = 3
            r3[r5] = r0     // Catch:{ IOException -> 0x024a }
            r1.invoke_callback(r3)     // Catch:{ IOException -> 0x024a }
            goto L_0x0259
        L_0x0152:
            okhttp3.ResponseBody r0 = r17.body()     // Catch:{ IOException -> 0x024a }
            byte[] r0 = r0.bytes()     // Catch:{ IOException -> 0x024a }
            boolean r5 = r16.shouldTransformFile()     // Catch:{ IOException -> 0x024a }
            if (r5 == 0) goto L_0x01d5
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r5 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ IOException -> 0x024a }
            if (r5 == 0) goto L_0x01cd
            java.lang.String r5 = r1.destPath     // Catch:{ IOException -> 0x024a }
            java.lang.String r5 = r5.replace(r8, r7)     // Catch:{ IOException -> 0x024a }
            r1.destPath = r5     // Catch:{ IOException -> 0x024a }
            java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x024a }
            java.lang.String r6 = r1.destPath     // Catch:{ IOException -> 0x024a }
            r5.<init>(r6)     // Catch:{ IOException -> 0x024a }
            boolean r6 = r5.exists()     // Catch:{ IOException -> 0x024a }
            if (r6 != 0) goto L_0x017c
            r5.createNewFile()     // Catch:{ IOException -> 0x024a }
        L_0x017c:
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x01ae }
            r6.<init>(r5)     // Catch:{ Exception -> 0x01ae }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r5 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ all -> 0x01a2 }
            byte[] r0 = r5.onWriteFile(r0)     // Catch:{ all -> 0x01a2 }
            r6.write(r0)     // Catch:{ all -> 0x01a2 }
            r6.close()     // Catch:{ Exception -> 0x01ae }
            java.lang.Object[] r0 = new java.lang.Object[r11]     // Catch:{ IOException -> 0x024a }
            r0[r15] = r13     // Catch:{ IOException -> 0x024a }
            r0[r12] = r9     // Catch:{ IOException -> 0x024a }
            java.lang.String r3 = r1.destPath     // Catch:{ IOException -> 0x024a }
            r0[r14] = r3     // Catch:{ IOException -> 0x024a }
            com.facebook.react.bridge.WritableMap r3 = r4.copy()     // Catch:{ IOException -> 0x024a }
            r5 = 3
            r0[r5] = r3     // Catch:{ IOException -> 0x024a }
            r1.invoke_callback(r0)     // Catch:{ IOException -> 0x024a }
            return
        L_0x01a2:
            r0 = move-exception
            r5 = r0
            r6.close()     // Catch:{ all -> 0x01a8 }
            goto L_0x01ad
        L_0x01a8:
            r0 = move-exception
            r6 = r0
            r5.addSuppressed(r6)     // Catch:{ Exception -> 0x01ae }
        L_0x01ad:
            throw r5     // Catch:{ Exception -> 0x01ae }
        L_0x01ae:
            r0 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ IOException -> 0x024a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x024a }
            r6.<init>(r3)     // Catch:{ IOException -> 0x024a }
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ IOException -> 0x024a }
            r6.append(r0)     // Catch:{ IOException -> 0x024a }
            java.lang.String r0 = r6.toString()     // Catch:{ IOException -> 0x024a }
            r5[r15] = r0     // Catch:{ IOException -> 0x024a }
            com.facebook.react.bridge.WritableMap r0 = r4.copy()     // Catch:{ IOException -> 0x024a }
            r5[r12] = r0     // Catch:{ IOException -> 0x024a }
            r1.invoke_callback(r5)     // Catch:{ IOException -> 0x024a }
            return
        L_0x01cd:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x024a }
            java.lang.String r3 = "Write file with transform was specified but the shared file transformer is not set"
            r0.<init>(r3)     // Catch:{ IOException -> 0x024a }
            throw r0     // Catch:{ IOException -> 0x024a }
        L_0x01d5:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r3 = r1.responseFormat     // Catch:{ IOException -> 0x024a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r5 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseFormat.BASE64     // Catch:{ IOException -> 0x024a }
            java.lang.String r7 = "base64"
            if (r3 != r5) goto L_0x01f4
            java.lang.Object[] r3 = new java.lang.Object[r11]     // Catch:{ IOException -> 0x024a }
            r3[r15] = r13     // Catch:{ IOException -> 0x024a }
            r3[r12] = r7     // Catch:{ IOException -> 0x024a }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r14)     // Catch:{ IOException -> 0x024a }
            r3[r14] = r0     // Catch:{ IOException -> 0x024a }
            com.facebook.react.bridge.WritableMap r0 = r4.copy()     // Catch:{ IOException -> 0x024a }
            r5 = 3
            r3[r5] = r0     // Catch:{ IOException -> 0x024a }
            r1.invoke_callback(r3)     // Catch:{ IOException -> 0x024a }
            return
        L_0x01f4:
            java.nio.charset.Charset r3 = java.nio.charset.Charset.forName(r6)     // Catch:{ CharacterCodingException -> 0x0215 }
            java.nio.charset.CharsetDecoder r5 = r3.newDecoder()     // Catch:{ CharacterCodingException -> 0x0215 }
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r0)     // Catch:{ CharacterCodingException -> 0x0215 }
            r5.decode(r6)     // Catch:{ CharacterCodingException -> 0x0215 }
            java.lang.String r5 = new java.lang.String     // Catch:{ CharacterCodingException -> 0x0215 }
            r5.<init>(r0, r3)     // Catch:{ CharacterCodingException -> 0x0215 }
            r3 = 3
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ CharacterCodingException -> 0x0215 }
            r6[r15] = r13     // Catch:{ CharacterCodingException -> 0x0215 }
            r6[r12] = r10     // Catch:{ CharacterCodingException -> 0x0215 }
            r6[r14] = r5     // Catch:{ CharacterCodingException -> 0x0215 }
            r1.invoke_callback(r6)     // Catch:{ CharacterCodingException -> 0x0215 }
            goto L_0x0259
        L_0x0215:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r3 = r1.responseFormat     // Catch:{ IOException -> 0x024a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r5 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseFormat.UTF8     // Catch:{ IOException -> 0x024a }
            if (r3 != r5) goto L_0x0233
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x024a }
            r3.<init>(r0)     // Catch:{ IOException -> 0x024a }
            java.lang.Object[] r0 = new java.lang.Object[r11]     // Catch:{ IOException -> 0x024a }
            r0[r15] = r13     // Catch:{ IOException -> 0x024a }
            r0[r12] = r10     // Catch:{ IOException -> 0x024a }
            r0[r14] = r3     // Catch:{ IOException -> 0x024a }
            com.facebook.react.bridge.WritableMap r3 = r4.copy()     // Catch:{ IOException -> 0x024a }
            r5 = 3
            r0[r5] = r3     // Catch:{ IOException -> 0x024a }
            r1.invoke_callback(r0)     // Catch:{ IOException -> 0x024a }
            goto L_0x0259
        L_0x0233:
            java.lang.Object[] r3 = new java.lang.Object[r11]     // Catch:{ IOException -> 0x024a }
            r3[r15] = r13     // Catch:{ IOException -> 0x024a }
            r3[r12] = r7     // Catch:{ IOException -> 0x024a }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r14)     // Catch:{ IOException -> 0x024a }
            r3[r14] = r0     // Catch:{ IOException -> 0x024a }
            com.facebook.react.bridge.WritableMap r0 = r4.copy()     // Catch:{ IOException -> 0x024a }
            r5 = 3
            r3[r5] = r0     // Catch:{ IOException -> 0x024a }
            r1.invoke_callback(r3)     // Catch:{ IOException -> 0x024a }
            goto L_0x0259
        L_0x024a:
            java.lang.Object[] r0 = new java.lang.Object[r14]
            java.lang.String r3 = "ReactNativeBlobUtil failed to encode response data to BASE64 string."
            r0[r15] = r3
            com.facebook.react.bridge.WritableMap r3 = r4.copy()
            r0[r12] = r3
            r1.invoke_callback(r0)
        L_0x0259:
            okhttp3.ResponseBody r0 = r17.body()
            r0.close()
            r16.releaseTaskResource()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.done(okhttp3.Response):void");
    }

    public static ReactNativeBlobUtilProgressConfig getReportProgress(String str) {
        if (!progressReport.containsKey(str)) {
            return null;
        }
        return progressReport.get(str);
    }

    public static ReactNativeBlobUtilProgressConfig getReportUploadProgress(String str) {
        if (!uploadProgressReport.containsKey(str)) {
            return null;
        }
        return uploadProgressReport.get(str);
    }

    private WritableMap getResponseInfo(Response response, boolean z) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("status", response.code());
        createMap.putString("state", ExifInterface.GPS_MEASUREMENT_2D);
        createMap.putString("taskId", this.taskId);
        createMap.putBoolean(ClientComponent.NamedSchedulers.TIMEOUT, this.timeout);
        WritableMap createMap2 = Arguments.createMap();
        for (int i = 0; i < response.headers().size(); i++) {
            createMap2.putString(response.headers().name(i), response.headers().value(i));
        }
        WritableArray createArray = Arguments.createArray();
        Iterator<String> it = this.redirects.iterator();
        while (it.hasNext()) {
            createArray.pushString(it.next());
        }
        createMap.putArray("redirects", createArray);
        createMap.putMap("headers", createMap2);
        Headers headers2 = response.headers();
        if (z) {
            createMap.putString("respType", "blob");
        } else if (getHeaderIgnoreCases(headers2, "content-type").equalsIgnoreCase("text/")) {
            createMap.putString("respType", "text");
        } else if (getHeaderIgnoreCases(headers2, "content-type").contains("application/json")) {
            createMap.putString("respType", "json");
        } else {
            createMap.putString("respType", "");
        }
        return createMap;
    }

    private boolean isBlobResponse(Response response) {
        boolean z;
        String headerIgnoreCases = getHeaderIgnoreCases(response.headers(), "Content-Type");
        boolean z2 = !headerIgnoreCases.equalsIgnoreCase("text/");
        boolean z3 = !headerIgnoreCases.equalsIgnoreCase("application/json");
        if (this.options.binaryContentTypes != null) {
            int i = 0;
            while (true) {
                if (i >= this.options.binaryContentTypes.size()) {
                    break;
                } else if (headerIgnoreCases.toLowerCase(Locale.ROOT).contains(this.options.binaryContentTypes.getString(i).toLowerCase(Locale.ROOT))) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        z = false;
        if ((z3 || z2) && !z) {
            return false;
        }
        return true;
    }

    private String getHeaderIgnoreCases(Headers headers2, String str) {
        String str2 = headers2.get(str);
        if (str2 != null) {
            return str2;
        }
        return headers2.get(str.toLowerCase(Locale.ROOT)) == null ? "" : headers2.get(str.toLowerCase(Locale.ROOT));
    }

    private String getHeaderIgnoreCases(HashMap<String, String> hashMap, String str) {
        String str2 = hashMap.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3 = hashMap.get(str.toLowerCase(Locale.ROOT));
        return str3 == null ? "" : str3;
    }

    private void emitStateEvent(WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_HTTP_STATE, writableMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e5 A[SYNTHETIC, Splitter:B:28:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r14, android.content.Intent r15) {
        /*
            r13 = this;
            java.lang.String r14 = r15.getAction()
            java.lang.String r0 = "android.intent.action.DOWNLOAD_COMPLETE"
            boolean r14 = r0.equals(r14)
            if (r14 == 0) goto L_0x0184
            com.facebook.react.bridge.ReactApplicationContext r14 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext
            android.content.Context r14 = r14.getApplicationContext()
            android.os.Bundle r15 = r15.getExtras()
            java.lang.String r0 = "extra_download_id"
            long r0 = r15.getLong(r0)
            long r2 = r13.downloadManagerId
            int r15 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r15 != 0) goto L_0x0184
            r13.releaseTaskResource()
            android.app.DownloadManager$Query r15 = new android.app.DownloadManager$Query
            r15.<init>()
            r0 = 1
            long[] r1 = new long[r0]
            long r2 = r13.downloadManagerId
            r4 = 0
            r1[r4] = r2
            r15.setFilterById(r1)
            java.lang.String r1 = "download"
            java.lang.Object r1 = r14.getSystemService(r1)
            android.app.DownloadManager r1 = (android.app.DownloadManager) r1
            r1.query(r15)
            android.database.Cursor r15 = r1.query(r15)
            r2 = 3
            r3 = 2
            r5 = 0
            java.lang.String r6 = "Download manager failed to download from  "
            if (r15 != 0) goto L_0x006a
            java.lang.Object[] r14 = new java.lang.Object[r2]
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r6)
            java.lang.String r1 = r13.url
            r15.append(r1)
            java.lang.String r1 = ". Query was unsuccessful "
            r15.append(r1)
            java.lang.String r15 = r15.toString()
            r14[r4] = r15
            r14[r0] = r5
            r14[r3] = r5
            r13.invoke_callback(r14)
            return
        L_0x006a:
            boolean r7 = r15.moveToFirst()     // Catch:{ all -> 0x017d }
            if (r7 == 0) goto L_0x00d3
            java.lang.String r7 = "status"
            int r7 = r15.getColumnIndex(r7)     // Catch:{ all -> 0x017d }
            int r7 = r15.getInt(r7)     // Catch:{ all -> 0x017d }
            r8 = 16
            if (r7 != r8) goto L_0x00a5
            java.lang.Object[] r14 = new java.lang.Object[r2]     // Catch:{ all -> 0x017d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x017d }
            r1.<init>(r6)     // Catch:{ all -> 0x017d }
            java.lang.String r2 = r13.url     // Catch:{ all -> 0x017d }
            r1.append(r2)     // Catch:{ all -> 0x017d }
            java.lang.String r2 = ". Status Code = "
            r1.append(r2)     // Catch:{ all -> 0x017d }
            r1.append(r7)     // Catch:{ all -> 0x017d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x017d }
            r14[r4] = r1     // Catch:{ all -> 0x017d }
            r14[r0] = r5     // Catch:{ all -> 0x017d }
            r14[r3] = r5     // Catch:{ all -> 0x017d }
            r13.invoke_callback(r14)     // Catch:{ all -> 0x017d }
            if (r15 == 0) goto L_0x00a4
            r15.close()
        L_0x00a4:
            return
        L_0x00a5:
            java.lang.String r6 = "local_uri"
            int r6 = r15.getColumnIndex(r6)     // Catch:{ all -> 0x017d }
            java.lang.String r6 = r15.getString(r6)     // Catch:{ all -> 0x017d }
            if (r6 == 0) goto L_0x00d3
            android.net.Uri r8 = android.net.Uri.parse(r6)     // Catch:{ all -> 0x017d }
            android.content.ContentResolver r7 = r14.getContentResolver()     // Catch:{ all -> 0x017d }
            java.lang.String[] r9 = new java.lang.String[r0]     // Catch:{ all -> 0x017d }
            java.lang.String r14 = "_data"
            r9[r4] = r14     // Catch:{ all -> 0x017d }
            r10 = 0
            r11 = 0
            r12 = 0
            android.database.Cursor r14 = r7.query(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x017d }
            if (r14 == 0) goto L_0x00d3
            r14.moveToFirst()     // Catch:{ all -> 0x017d }
            java.lang.String r6 = r14.getString(r4)     // Catch:{ all -> 0x017d }
            r14.close()     // Catch:{ all -> 0x017d }
            goto L_0x00d4
        L_0x00d3:
            r6 = r5
        L_0x00d4:
            if (r15 == 0) goto L_0x00d9
            r15.close()
        L_0x00d9:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r14 = r13.options
            com.facebook.react.bridge.ReadableMap r14 = r14.addAndroidDownloads
            java.lang.String r15 = "path"
            boolean r14 = r14.hasKey(r15)
            if (r14 == 0) goto L_0x011f
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r14 = r13.options     // Catch:{ Exception -> 0x010d }
            com.facebook.react.bridge.ReadableMap r14 = r14.addAndroidDownloads     // Catch:{ Exception -> 0x010d }
            java.lang.String r14 = r14.getString(r15)     // Catch:{ Exception -> 0x010d }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x010d }
            r1.<init>(r14)     // Catch:{ Exception -> 0x010d }
            boolean r1 = r1.exists()     // Catch:{ Exception -> 0x010d }
            if (r1 == 0) goto L_0x0105
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x010d }
            r1[r4] = r5     // Catch:{ Exception -> 0x010d }
            r1[r0] = r15     // Catch:{ Exception -> 0x010d }
            r1[r3] = r14     // Catch:{ Exception -> 0x010d }
            r13.invoke_callback(r1)     // Catch:{ Exception -> 0x010d }
            goto L_0x0184
        L_0x0105:
            java.lang.Exception r14 = new java.lang.Exception     // Catch:{ Exception -> 0x010d }
            java.lang.String r15 = "Download manager download failed, the file does not downloaded to destination."
            r14.<init>(r15)     // Catch:{ Exception -> 0x010d }
            throw r14     // Catch:{ Exception -> 0x010d }
        L_0x010d:
            r14 = move-exception
            r14.printStackTrace()
            java.lang.Object[] r15 = new java.lang.Object[r3]
            java.lang.String r14 = r14.getLocalizedMessage()
            r15[r4] = r14
            r15[r0] = r5
            r13.invoke_callback(r15)
            goto L_0x0184
        L_0x011f:
            int r14 = android.os.Build.VERSION.SDK_INT
            r7 = 29
            if (r14 < r7) goto L_0x0161
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r14 = r13.options
            com.facebook.react.bridge.ReadableMap r14 = r14.addAndroidDownloads
            java.lang.String r7 = "storeInDownloads"
            boolean r14 = r14.hasKey(r7)
            if (r14 == 0) goto L_0x0161
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r14 = r13.options
            com.facebook.react.bridge.ReadableMap r14 = r14.addAndroidDownloads
            boolean r14 = r14.getBoolean(r7)
            if (r14 == 0) goto L_0x0161
            long r6 = r13.downloadManagerId
            android.net.Uri r14 = r1.getUriForDownloadedFile(r6)
            if (r14 != 0) goto L_0x0151
            java.lang.Object[] r14 = new java.lang.Object[r2]
            java.lang.String r1 = "Download manager could not resolve downloaded file uri."
            r14[r4] = r1
            r14[r0] = r15
            r14[r3] = r5
            r13.invoke_callback(r14)
            goto L_0x0184
        L_0x0151:
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r1[r4] = r5
            r1[r0] = r15
            java.lang.String r14 = r14.toString()
            r1[r3] = r14
            r13.invoke_callback(r1)
            goto L_0x0184
        L_0x0161:
            if (r6 != 0) goto L_0x0171
            java.lang.Object[] r14 = new java.lang.Object[r2]
            java.lang.String r1 = "Download manager could not resolve downloaded file path."
            r14[r4] = r1
            r14[r0] = r15
            r14[r3] = r5
            r13.invoke_callback(r14)
            goto L_0x0184
        L_0x0171:
            java.lang.Object[] r14 = new java.lang.Object[r2]
            r14[r4] = r5
            r14[r0] = r15
            r14[r3] = r6
            r13.invoke_callback(r14)
            goto L_0x0184
        L_0x017d:
            r14 = move-exception
            if (r15 == 0) goto L_0x0183
            r15.close()
        L_0x0183:
            throw r14
        L_0x0184:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.onReceive(android.content.Context, android.content.Intent):void");
    }
}
