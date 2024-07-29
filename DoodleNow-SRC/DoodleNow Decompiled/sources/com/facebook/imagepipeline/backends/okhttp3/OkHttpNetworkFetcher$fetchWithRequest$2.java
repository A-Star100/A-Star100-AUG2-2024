package com.facebook.imagepipeline.backends.okhttp3;

import androidx.core.app.NotificationCompat;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/facebook/imagepipeline/backends/okhttp3/OkHttpNetworkFetcher$fetchWithRequest$2", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "imagepipeline-okhttp3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OkHttpNetworkFetcher.kt */
public final class OkHttpNetworkFetcher$fetchWithRequest$2 implements Callback {
    final /* synthetic */ NetworkFetcher.Callback $callback;
    final /* synthetic */ OkHttpNetworkFetcher.OkHttpNetworkFetchState $fetchState;
    final /* synthetic */ OkHttpNetworkFetcher this$0;

    OkHttpNetworkFetcher$fetchWithRequest$2(OkHttpNetworkFetcher.OkHttpNetworkFetchState okHttpNetworkFetchState, OkHttpNetworkFetcher okHttpNetworkFetcher, NetworkFetcher.Callback callback) {
        this.$fetchState = okHttpNetworkFetchState;
        this.this$0 = okHttpNetworkFetcher;
        this.$callback = callback;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008b, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008c, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008f, code lost:
        throw r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResponse(okhttp3.Call r12, okhttp3.Response r13) throws java.io.IOException {
        /*
            r11 = this;
            java.lang.String r0 = "Unexpected HTTP code "
            java.lang.String r1 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r1 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher$OkHttpNetworkFetchState r1 = r11.$fetchState
            long r2 = android.os.SystemClock.elapsedRealtime()
            r1.responseTime = r2
            okhttp3.ResponseBody r1 = r13.body()
            r2 = 0
            if (r1 == 0) goto L_0x0090
            java.io.Closeable r1 = (java.io.Closeable) r1
            com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher r3 = r11.this$0
            com.facebook.imagepipeline.producers.NetworkFetcher$Callback r4 = r11.$callback
            com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher$OkHttpNetworkFetchState r5 = r11.$fetchState
            r6 = r1
            okhttp3.ResponseBody r6 = (okhttp3.ResponseBody) r6     // Catch:{ all -> 0x0089 }
            boolean r7 = r13.isSuccessful()     // Catch:{ Exception -> 0x007d }
            if (r7 != 0) goto L_0x0043
            java.io.IOException r5 = new java.io.IOException     // Catch:{ Exception -> 0x007d }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r6.<init>(r0)     // Catch:{ Exception -> 0x007d }
            r6.append(r13)     // Catch:{ Exception -> 0x007d }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x007d }
            r5.<init>(r0)     // Catch:{ Exception -> 0x007d }
            java.lang.Exception r5 = (java.lang.Exception) r5     // Catch:{ Exception -> 0x007d }
            r3.handleException(r12, r5, r4)     // Catch:{ Exception -> 0x007d }
            goto L_0x0081
        L_0x0043:
            com.facebook.imagepipeline.common.BytesRange$Companion r0 = com.facebook.imagepipeline.common.BytesRange.Companion     // Catch:{ Exception -> 0x007d }
            java.lang.String r7 = "Content-Range"
            java.lang.String r7 = r13.header(r7)     // Catch:{ Exception -> 0x007d }
            com.facebook.imagepipeline.common.BytesRange r0 = r0.fromContentRangeHeader(r7)     // Catch:{ Exception -> 0x007d }
            if (r0 == 0) goto L_0x0064
            int r7 = r0.from     // Catch:{ Exception -> 0x007d }
            if (r7 != 0) goto L_0x005c
            int r7 = r0.to     // Catch:{ Exception -> 0x007d }
            r8 = 2147483647(0x7fffffff, float:NaN)
            if (r7 == r8) goto L_0x0064
        L_0x005c:
            r5.setResponseBytesRange(r0)     // Catch:{ Exception -> 0x007d }
            r0 = 8
            r5.setOnNewResultStatusFlags(r0)     // Catch:{ Exception -> 0x007d }
        L_0x0064:
            long r7 = r6.contentLength()     // Catch:{ Exception -> 0x007d }
            r9 = 0
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 >= 0) goto L_0x0070
            r0 = 0
            goto L_0x0075
        L_0x0070:
            long r7 = r6.contentLength()     // Catch:{ Exception -> 0x007d }
            int r0 = (int) r7     // Catch:{ Exception -> 0x007d }
        L_0x0075:
            java.io.InputStream r5 = r6.byteStream()     // Catch:{ Exception -> 0x007d }
            r4.onResponse(r5, r0)     // Catch:{ Exception -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r0 = move-exception
            r3.handleException(r12, r0, r4)     // Catch:{ all -> 0x0089 }
        L_0x0081:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0089 }
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x0090
        L_0x0089:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x008b }
        L_0x008b:
            r13 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r12)
            throw r13
        L_0x0090:
            if (r2 != 0) goto L_0x00ae
            com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher r0 = r11.this$0
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Response body null: "
            r2.<init>(r3)
            r2.append(r13)
            java.lang.String r13 = r2.toString()
            r1.<init>(r13)
            java.lang.Exception r1 = (java.lang.Exception) r1
            com.facebook.imagepipeline.producers.NetworkFetcher$Callback r13 = r11.$callback
            r0.handleException(r12, r1, r13)
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher$fetchWithRequest$2.onResponse(okhttp3.Call, okhttp3.Response):void");
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(iOException, "e");
        this.this$0.handleException(call, iOException, this.$callback);
    }
}
