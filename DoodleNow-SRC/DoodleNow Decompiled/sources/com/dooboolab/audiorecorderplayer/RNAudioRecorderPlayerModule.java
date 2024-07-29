package com.dooboolab.audiorecorderplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.PermissionListener;
import com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001f\u001a\u00020\tH\u0016J+\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0#2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010+\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010,\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010-\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0018\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\u0006\u0010)\u001a\u00020*H\u0007J\"\u00101\u001a\u00020(2\u0006\u0010\u0003\u001a\u0002022\u0006\u00103\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u000105H\u0002J\u0018\u00106\u001a\u00020(2\u0006\u00107\u001a\u0002002\u0006\u0010)\u001a\u00020*H\u0007J\u0018\u00108\u001a\u00020(2\u0006\u00109\u001a\u0002002\u0006\u0010)\u001a\u00020*H\u0007J\"\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010)\u001a\u00020*H\u0007J*\u0010>\u001a\u00020(2\u0006\u0010;\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010=2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010A\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010B\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/dooboolab/audiorecorderplayer/RNAudioRecorderPlayerModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "Lcom/facebook/react/modules/core/PermissionListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "_meteringEnabled", "", "audioFileURL", "", "mTask", "Ljava/util/TimerTask;", "mTimer", "Ljava/util/Timer;", "mediaPlayer", "Landroid/media/MediaPlayer;", "mediaRecorder", "Landroid/media/MediaRecorder;", "pausedRecordTime", "", "recordHandler", "Landroid/os/Handler;", "getRecordHandler", "()Landroid/os/Handler;", "setRecordHandler", "(Landroid/os/Handler;)V", "recorderRunnable", "Ljava/lang/Runnable;", "subsDurationMillis", "", "totalPausedRecordTime", "getName", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)Z", "pausePlayer", "", "promise", "Lcom/facebook/react/bridge/Promise;", "pauseRecorder", "resumePlayer", "resumeRecorder", "seekToPlayer", "time", "", "sendEvent", "Lcom/facebook/react/bridge/ReactContext;", "eventName", "params", "Lcom/facebook/react/bridge/WritableMap;", "setSubscriptionDuration", "sec", "setVolume", "volume", "startPlayer", "path", "httpHeaders", "Lcom/facebook/react/bridge/ReadableMap;", "startRecorder", "audioSet", "meteringEnabled", "stopPlayer", "stopRecorder", "Companion", "react-native-audio-recorder-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RNAudioRecorderPlayerModule.kt */
public final class RNAudioRecorderPlayerModule extends ReactContextBaseJavaModule implements PermissionListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static List<String> defaultFileExtensions = CollectionsKt.listOf("mp4", "3gp", "mp4", "amr", "amr", "aac", "aac", "rtp", "ts", "webm", "xxx", "ogg");
    private static String defaultFileName = "sound.mp4";
    /* access modifiers changed from: private */
    public static String tag = "RNAudioRecorderPlayer";
    /* access modifiers changed from: private */
    public boolean _meteringEnabled;
    private String audioFileURL = "";
    private TimerTask mTask;
    private Timer mTimer;
    private MediaPlayer mediaPlayer;
    /* access modifiers changed from: private */
    public MediaRecorder mediaRecorder;
    private long pausedRecordTime;
    /* access modifiers changed from: private */
    public final ReactApplicationContext reactContext;
    private Handler recordHandler = new Handler(Looper.getMainLooper());
    private Runnable recorderRunnable;
    /* access modifiers changed from: private */
    public int subsDurationMillis = 500;
    /* access modifiers changed from: private */
    public long totalPausedRecordTime;

    public String getName() {
        return tag;
    }

    public final Handler getRecordHandler() {
        return this.recordHandler;
    }

    public final void setRecordHandler(Handler handler) {
        this.recordHandler = handler;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RNAudioRecorderPlayerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        this.reactContext = reactApplicationContext;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        if (androidx.core.app.ActivityCompat.checkSelfPermission(r9.reactContext, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L_0x0031;
     */
    @com.facebook.react.bridge.ReactMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void startRecorder(java.lang.String r10, com.facebook.react.bridge.ReadableMap r11, boolean r12, com.facebook.react.bridge.Promise r13) {
        /*
            r9 = this;
            java.lang.String r0 = "Try again after adding permission."
            java.lang.String r1 = "No permission granted."
            java.lang.String r2 = "file:///"
            java.lang.String r3 = "path"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r3)
            java.lang.String r3 = "promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r3)
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ NullPointerException -> 0x01a0 }
            r4 = 29
            r5 = 2
            r6 = 0
            r7 = 1
            java.lang.String r8 = "android.permission.RECORD_AUDIO"
            if (r3 >= r4) goto L_0x0045
            com.facebook.react.bridge.ReactApplicationContext r3 = r9.reactContext     // Catch:{ NullPointerException -> 0x01a0 }
            android.content.Context r3 = (android.content.Context) r3     // Catch:{ NullPointerException -> 0x01a0 }
            int r3 = androidx.core.app.ActivityCompat.checkSelfPermission(r3, r8)     // Catch:{ NullPointerException -> 0x01a0 }
            java.lang.String r4 = "android.permission.WRITE_EXTERNAL_STORAGE"
            if (r3 != 0) goto L_0x0031
            com.facebook.react.bridge.ReactApplicationContext r3 = r9.reactContext     // Catch:{ NullPointerException -> 0x01a0 }
            android.content.Context r3 = (android.content.Context) r3     // Catch:{ NullPointerException -> 0x01a0 }
            int r3 = androidx.core.app.ActivityCompat.checkSelfPermission(r3, r4)     // Catch:{ NullPointerException -> 0x01a0 }
            if (r3 == 0) goto L_0x0045
        L_0x0031:
            android.app.Activity r10 = r9.getCurrentActivity()     // Catch:{ NullPointerException -> 0x01a0 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)     // Catch:{ NullPointerException -> 0x01a0 }
            java.lang.String[] r11 = new java.lang.String[r5]     // Catch:{ NullPointerException -> 0x01a0 }
            r11[r6] = r8     // Catch:{ NullPointerException -> 0x01a0 }
            r11[r7] = r4     // Catch:{ NullPointerException -> 0x01a0 }
            androidx.core.app.ActivityCompat.requestPermissions(r10, r11, r6)     // Catch:{ NullPointerException -> 0x01a0 }
            r13.reject((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ NullPointerException -> 0x01a0 }
            return
        L_0x0045:
            com.facebook.react.bridge.ReactApplicationContext r3 = r9.reactContext     // Catch:{ NullPointerException -> 0x01a0 }
            android.content.Context r3 = (android.content.Context) r3     // Catch:{ NullPointerException -> 0x01a0 }
            int r3 = androidx.core.app.ActivityCompat.checkSelfPermission(r3, r8)     // Catch:{ NullPointerException -> 0x01a0 }
            if (r3 == 0) goto L_0x0061
            android.app.Activity r10 = r9.getCurrentActivity()     // Catch:{ NullPointerException -> 0x01a0 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)     // Catch:{ NullPointerException -> 0x01a0 }
            java.lang.String[] r11 = new java.lang.String[r7]     // Catch:{ NullPointerException -> 0x01a0 }
            r11[r6] = r8     // Catch:{ NullPointerException -> 0x01a0 }
            androidx.core.app.ActivityCompat.requestPermissions(r10, r11, r6)     // Catch:{ NullPointerException -> 0x01a0 }
            r13.reject((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ NullPointerException -> 0x01a0 }
            return
        L_0x0061:
            if (r11 == 0) goto L_0x0070
            java.lang.String r0 = "OutputFormatAndroid"
            boolean r1 = r11.hasKey(r0)
            if (r1 == 0) goto L_0x0070
            int r0 = r11.getInt(r0)
            goto L_0x0071
        L_0x0070:
            r0 = r5
        L_0x0071:
            java.lang.String r1 = "DEFAULT"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0099
            com.facebook.react.bridge.ReactApplicationContext r10 = r9.reactContext
            java.io.File r10 = r10.getCacheDir()
            java.util.List<java.lang.String> r1 = defaultFileExtensions
            java.lang.Object r1 = r1.get(r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r10)
            java.lang.String r10 = "/sound."
            r3.append(r10)
            r3.append(r1)
            java.lang.String r10 = r3.toString()
        L_0x0099:
            r9.audioFileURL = r10
            r9._meteringEnabled = r12
            android.media.MediaRecorder r10 = r9.mediaRecorder
            if (r10 != 0) goto L_0x00a8
            android.media.MediaRecorder r10 = new android.media.MediaRecorder
            r10.<init>()
            r9.mediaRecorder = r10
        L_0x00a8:
            r10 = 48000(0xbb80, float:6.7262E-41)
            r12 = 128000(0x1f400, float:1.79366E-40)
            r1 = 3
            if (r11 == 0) goto L_0x011e
            android.media.MediaRecorder r3 = r9.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.String r4 = "AudioSourceAndroid"
            boolean r6 = r11.hasKey(r4)
            if (r6 == 0) goto L_0x00c2
            int r7 = r11.getInt(r4)
        L_0x00c2:
            r3.setAudioSource(r7)
            android.media.MediaRecorder r3 = r9.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r3.setOutputFormat(r0)
            android.media.MediaRecorder r0 = r9.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r3 = "AudioEncoderAndroid"
            boolean r4 = r11.hasKey(r3)
            if (r4 == 0) goto L_0x00de
            int r1 = r11.getInt(r3)
        L_0x00de:
            r0.setAudioEncoder(r1)
            android.media.MediaRecorder r0 = r9.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r1 = "AudioSamplingRateAndroid"
            boolean r3 = r11.hasKey(r1)
            if (r3 == 0) goto L_0x00f2
            int r10 = r11.getInt(r1)
        L_0x00f2:
            r0.setAudioSamplingRate(r10)
            android.media.MediaRecorder r10 = r9.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.lang.String r0 = "AudioEncodingBitRateAndroid"
            boolean r1 = r11.hasKey(r0)
            if (r1 == 0) goto L_0x0106
            int r12 = r11.getInt(r0)
        L_0x0106:
            r10.setAudioEncodingBitRate(r12)
            android.media.MediaRecorder r10 = r9.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.lang.String r12 = "AudioChannelsAndroid"
            boolean r0 = r11.hasKey(r12)
            if (r0 == 0) goto L_0x011a
            int r5 = r11.getInt(r12)
        L_0x011a:
            r10.setAudioChannels(r5)
            goto L_0x0146
        L_0x011e:
            android.media.MediaRecorder r11 = r9.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r11.setAudioSource(r7)
            android.media.MediaRecorder r11 = r9.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r11.setOutputFormat(r0)
            android.media.MediaRecorder r11 = r9.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r11.setAudioEncoder(r1)
            android.media.MediaRecorder r11 = r9.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r11.setAudioEncodingBitRate(r12)
            android.media.MediaRecorder r11 = r9.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r11.setAudioSamplingRate(r10)
        L_0x0146:
            android.media.MediaRecorder r10 = r9.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.lang.String r11 = r9.audioFileURL
            r10.setOutputFile(r11)
            android.media.MediaRecorder r10 = r9.mediaRecorder     // Catch:{ Exception -> 0x018b }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)     // Catch:{ Exception -> 0x018b }
            r10.prepare()     // Catch:{ Exception -> 0x018b }
            r10 = 0
            r9.totalPausedRecordTime = r10     // Catch:{ Exception -> 0x018b }
            android.media.MediaRecorder r10 = r9.mediaRecorder     // Catch:{ Exception -> 0x018b }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)     // Catch:{ Exception -> 0x018b }
            r10.start()     // Catch:{ Exception -> 0x018b }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x018b }
            com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule$startRecorder$1 r12 = new com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule$startRecorder$1     // Catch:{ Exception -> 0x018b }
            r12.<init>(r10, r9)     // Catch:{ Exception -> 0x018b }
            java.lang.Runnable r12 = (java.lang.Runnable) r12     // Catch:{ Exception -> 0x018b }
            r9.recorderRunnable = r12     // Catch:{ Exception -> 0x018b }
            java.lang.String r10 = "null cannot be cast to non-null type java.lang.Runnable"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r10)     // Catch:{ Exception -> 0x018b }
            r12.run()     // Catch:{ Exception -> 0x018b }
            java.lang.String r10 = r9.audioFileURL     // Catch:{ Exception -> 0x018b }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018b }
            r11.<init>(r2)     // Catch:{ Exception -> 0x018b }
            r11.append(r10)     // Catch:{ Exception -> 0x018b }
            java.lang.String r10 = r11.toString()     // Catch:{ Exception -> 0x018b }
            r13.resolve(r10)     // Catch:{ Exception -> 0x018b }
            goto L_0x019f
        L_0x018b:
            r10 = move-exception
            java.lang.String r11 = tag
            java.lang.String r12 = "Exception: "
            r0 = r10
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            android.util.Log.e(r11, r12, r0)
            java.lang.String r11 = "startRecord"
            java.lang.String r10 = r10.getMessage()
            r13.reject((java.lang.String) r11, (java.lang.String) r10)
        L_0x019f:
            return
        L_0x01a0:
            r10 = move-exception
            java.lang.String r11 = tag
            java.lang.String r10 = r10.toString()
            android.util.Log.w(r11, r10)
            r13.reject((java.lang.String) r1, (java.lang.String) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule.startRecorder(java.lang.String, com.facebook.react.bridge.ReadableMap, boolean, com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    public final void resumeRecorder(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        MediaRecorder mediaRecorder2 = this.mediaRecorder;
        if (mediaRecorder2 == null) {
            promise.reject("resumeReocrder", "Recorder is null.");
            return;
        }
        try {
            Intrinsics.checkNotNull(mediaRecorder2);
            Downloader$$ExternalSyntheticApiModelOutline0.m(mediaRecorder2);
            this.totalPausedRecordTime += SystemClock.elapsedRealtime() - this.pausedRecordTime;
            Runnable runnable = this.recorderRunnable;
            if (runnable != null) {
                Handler handler = this.recordHandler;
                Intrinsics.checkNotNull(handler);
                handler.postDelayed(runnable, (long) this.subsDurationMillis);
            }
            promise.resolve("Recorder resumed.");
        } catch (Exception e) {
            Log.e(tag, "Recorder resume: " + e.getMessage());
            promise.reject("resumeRecorder", e.getMessage());
        }
    }

    @ReactMethod
    public final void pauseRecorder(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        MediaRecorder mediaRecorder2 = this.mediaRecorder;
        if (mediaRecorder2 == null) {
            promise.reject("pauseRecorder", "Recorder is null.");
            return;
        }
        try {
            Intrinsics.checkNotNull(mediaRecorder2);
            Downloader$$ExternalSyntheticApiModelOutline0.m$1(mediaRecorder2);
            this.pausedRecordTime = SystemClock.elapsedRealtime();
            Runnable runnable = this.recorderRunnable;
            if (runnable != null) {
                Handler handler = this.recordHandler;
                Intrinsics.checkNotNull(handler);
                handler.removeCallbacks(runnable);
            }
            promise.resolve("Recorder paused.");
        } catch (Exception e) {
            String str = tag;
            String message = e.getMessage();
            Log.e(str, "pauseRecorder exception: " + message);
            promise.reject("pauseRecorder", e.getMessage());
        }
    }

    @ReactMethod
    public final void stopRecorder(Promise promise) {
        Runnable runnable;
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Handler handler = this.recordHandler;
        if (!(handler == null || (runnable = this.recorderRunnable) == null)) {
            Intrinsics.checkNotNull(handler);
            handler.removeCallbacks(runnable);
        }
        MediaRecorder mediaRecorder2 = this.mediaRecorder;
        if (mediaRecorder2 == null) {
            promise.reject("stopRecord", "recorder is null.");
            return;
        }
        try {
            Intrinsics.checkNotNull(mediaRecorder2);
            mediaRecorder2.stop();
            MediaRecorder mediaRecorder3 = this.mediaRecorder;
            Intrinsics.checkNotNull(mediaRecorder3);
            mediaRecorder3.reset();
            MediaRecorder mediaRecorder4 = this.mediaRecorder;
            Intrinsics.checkNotNull(mediaRecorder4);
            mediaRecorder4.release();
            this.mediaRecorder = null;
            String str = this.audioFileURL;
            promise.resolve("file:///" + str);
        } catch (RuntimeException e) {
            String message = e.getMessage();
            if (message != null) {
                String str2 = tag;
                Log.d(str2, message);
            }
            promise.reject("stopRecord", e.getMessage());
        }
    }

    @ReactMethod
    public final void setVolume(double d, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 == null) {
            promise.reject("setVolume", "player is null.");
            return;
        }
        float f = (float) d;
        Intrinsics.checkNotNull(mediaPlayer2);
        mediaPlayer2.setVolume(f, f);
        promise.resolve("set volume");
    }

    @ReactMethod
    public final void startPlayer(String str, ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(str, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            Intrinsics.checkNotNull(mediaPlayer2);
            if (!mediaPlayer2.isPlaying()) {
                MediaPlayer mediaPlayer3 = this.mediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer3);
                if (mediaPlayer3.getCurrentPosition() > 1) {
                    MediaPlayer mediaPlayer4 = this.mediaPlayer;
                    Intrinsics.checkNotNull(mediaPlayer4);
                    mediaPlayer4.start();
                    promise.resolve("player resumed.");
                    return;
                }
            }
            Log.e(tag, "Player is already running. Stop it first.");
            promise.reject("startPlay", "Player is already running. Stop it first.");
            return;
        }
        this.mediaPlayer = new MediaPlayer();
        try {
            if (Intrinsics.areEqual((Object) str, (Object) "DEFAULT")) {
                MediaPlayer mediaPlayer5 = this.mediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer5);
                File cacheDir = this.reactContext.getCacheDir();
                String str2 = defaultFileName;
                mediaPlayer5.setDataSource(cacheDir + "/" + str2);
            } else if (readableMap != null) {
                Map hashMap = new HashMap();
                ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
                Intrinsics.checkNotNullExpressionValue(keySetIterator, "keySetIterator(...)");
                while (keySetIterator.hasNextKey()) {
                    String nextKey = keySetIterator.nextKey();
                    Intrinsics.checkNotNull(nextKey);
                    hashMap.put(nextKey, readableMap.getString(nextKey));
                }
                MediaPlayer mediaPlayer6 = this.mediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer6);
                Activity currentActivity = getCurrentActivity();
                Intrinsics.checkNotNull(currentActivity);
                mediaPlayer6.setDataSource(currentActivity.getApplicationContext(), Uri.parse(str), hashMap);
            } else {
                MediaPlayer mediaPlayer7 = this.mediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer7);
                mediaPlayer7.setDataSource(str);
            }
            MediaPlayer mediaPlayer8 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer8);
            mediaPlayer8.setOnPreparedListener(new RNAudioRecorderPlayerModule$$ExternalSyntheticLambda2(this, str, promise));
            MediaPlayer mediaPlayer9 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer9);
            mediaPlayer9.setOnCompletionListener(new RNAudioRecorderPlayerModule$$ExternalSyntheticLambda3(this));
            MediaPlayer mediaPlayer10 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer10);
            mediaPlayer10.prepare();
        } catch (IOException e) {
            Log.e(tag, "startPlay() io exception");
            promise.reject("startPlay", e.getMessage());
        } catch (NullPointerException unused) {
            Log.e(tag, "startPlay() null exception");
        }
    }

    /* access modifiers changed from: private */
    public static final void startPlayer$lambda$4(RNAudioRecorderPlayerModule rNAudioRecorderPlayerModule, String str, Promise promise, MediaPlayer mediaPlayer2) {
        Intrinsics.checkNotNullParameter(rNAudioRecorderPlayerModule, "this$0");
        Intrinsics.checkNotNullParameter(str, "$path");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Log.d(tag, "Mediaplayer prepared and start");
        mediaPlayer2.start();
        rNAudioRecorderPlayerModule.mTask = new RNAudioRecorderPlayerModule$startPlayer$1$1(mediaPlayer2, rNAudioRecorderPlayerModule);
        Timer timer = new Timer();
        rNAudioRecorderPlayerModule.mTimer = timer;
        Intrinsics.checkNotNull(timer);
        timer.schedule(rNAudioRecorderPlayerModule.mTask, 0, (long) rNAudioRecorderPlayerModule.subsDurationMillis);
        if (Intrinsics.areEqual((Object) str, (Object) "DEFAULT")) {
            str = rNAudioRecorderPlayerModule.reactContext.getCacheDir() + "/" + defaultFileName;
        }
        promise.resolve(str);
    }

    /* access modifiers changed from: private */
    public static final void startPlayer$lambda$5(RNAudioRecorderPlayerModule rNAudioRecorderPlayerModule, MediaPlayer mediaPlayer2) {
        Intrinsics.checkNotNullParameter(rNAudioRecorderPlayerModule, "this$0");
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("duration", mediaPlayer2.getDuration());
        createMap.putInt("currentPosition", mediaPlayer2.getCurrentPosition());
        createMap.putBoolean("isFinished", true);
        rNAudioRecorderPlayerModule.sendEvent(rNAudioRecorderPlayerModule.reactContext, "rn-playback", createMap);
        Log.d(tag, "Plays completed.");
        Timer timer = rNAudioRecorderPlayerModule.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        mediaPlayer2.stop();
        mediaPlayer2.reset();
        mediaPlayer2.release();
        rNAudioRecorderPlayerModule.mediaPlayer = null;
    }

    @ReactMethod
    public final void resumePlayer(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 == null) {
            promise.reject("resume", "Mediaplayer is null on resume.");
            return;
        }
        Intrinsics.checkNotNull(mediaPlayer2);
        if (mediaPlayer2.isPlaying()) {
            promise.reject("resume", "Mediaplayer is already running.");
            return;
        }
        try {
            MediaPlayer mediaPlayer3 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer3);
            MediaPlayer mediaPlayer4 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer4);
            mediaPlayer3.seekTo(mediaPlayer4.getCurrentPosition());
            MediaPlayer mediaPlayer5 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer5);
            mediaPlayer5.start();
            promise.resolve("resume player");
        } catch (Exception e) {
            String str = tag;
            String message = e.getMessage();
            Log.e(str, "Mediaplayer resume: " + message);
            promise.reject("resume", e.getMessage());
        }
    }

    @ReactMethod
    public final void pausePlayer(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 == null) {
            promise.reject("pausePlay", "Mediaplayer is null on pause.");
            return;
        }
        try {
            Intrinsics.checkNotNull(mediaPlayer2);
            mediaPlayer2.pause();
            promise.resolve("pause player");
        } catch (Exception e) {
            String str = tag;
            String message = e.getMessage();
            Log.e(str, "pausePlay exception: " + message);
            promise.reject("pausePlay", e.getMessage());
        }
    }

    @ReactMethod
    public final void seekToPlayer(double d, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 == null) {
            promise.reject("seekTo", "Mediaplayer is null on seek.");
            return;
        }
        Intrinsics.checkNotNull(mediaPlayer2);
        mediaPlayer2.seekTo((int) d);
        promise.resolve("pause player");
    }

    /* access modifiers changed from: private */
    public final void sendEvent(ReactContext reactContext2, String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext2.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    @ReactMethod
    public final void stopPlayer(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Timer timer = this.mTimer;
        if (timer != null) {
            Intrinsics.checkNotNull(timer);
            timer.cancel();
        }
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 == null) {
            promise.resolve("Already stopped player");
            return;
        }
        try {
            Intrinsics.checkNotNull(mediaPlayer2);
            mediaPlayer2.stop();
            MediaPlayer mediaPlayer3 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer3);
            mediaPlayer3.reset();
            MediaPlayer mediaPlayer4 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer4);
            mediaPlayer4.release();
            this.mediaPlayer = null;
            promise.resolve("stopped player");
        } catch (Exception e) {
            String str = tag;
            String message = e.getMessage();
            Log.e(str, "stopPlay exception: " + message);
            promise.reject("stopPlay", e.getMessage());
        }
    }

    @ReactMethod
    public final void setSubscriptionDuration(double d, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        int i = (int) (d * ((double) 1000));
        this.subsDurationMillis = i;
        promise.resolve("setSubscriptionDuration: " + i);
    }

    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        return i == 200 && iArr[0] == 0;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/dooboolab/audiorecorderplayer/RNAudioRecorderPlayerModule$Companion;", "", "()V", "defaultFileExtensions", "", "", "defaultFileName", "tag", "react-native-audio-recorder-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: RNAudioRecorderPlayerModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
