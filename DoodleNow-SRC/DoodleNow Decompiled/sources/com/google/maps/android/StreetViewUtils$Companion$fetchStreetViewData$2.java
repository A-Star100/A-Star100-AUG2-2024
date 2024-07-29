package com.google.maps.android;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/google/maps/android/Status;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.google.maps.android.StreetViewUtils$Companion$fetchStreetViewData$2", f = "StreetViewUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StreetViewUtil.kt */
final class StreetViewUtils$Companion$fetchStreetViewData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Status>, Object> {
    final /* synthetic */ String $urlString;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StreetViewUtils$Companion$fetchStreetViewData$2(String str, Continuation<? super StreetViewUtils$Companion$fetchStreetViewData$2> continuation) {
        super(2, continuation);
        this.$urlString = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreetViewUtils$Companion$fetchStreetViewData$2(this.$urlString, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Status> continuation) {
        return ((StreetViewUtils$Companion$fetchStreetViewData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.String r0 = "HTTP Error: "
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            if (r1 != 0) goto L_0x0091
            kotlin.ResultKt.throwOnFailure(r5)
            java.net.URL r5 = new java.net.URL     // Catch:{ IOException -> 0x0075 }
            java.lang.String r1 = r4.$urlString     // Catch:{ IOException -> 0x0075 }
            r5.<init>(r1)     // Catch:{ IOException -> 0x0075 }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ IOException -> 0x0075 }
            java.lang.String r1 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r1)     // Catch:{ IOException -> 0x0075 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ IOException -> 0x0075 }
            java.lang.String r1 = "GET"
            r5.setRequestMethod(r1)     // Catch:{ IOException -> 0x0075 }
            int r1 = r5.getResponseCode()     // Catch:{ IOException -> 0x0075 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L_0x0063
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ IOException -> 0x0075 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0075 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0075 }
            r1.<init>(r5)     // Catch:{ IOException -> 0x0075 }
            java.io.Reader r1 = (java.io.Reader) r1     // Catch:{ IOException -> 0x0075 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0075 }
            r1 = r0
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ IOException -> 0x0075 }
            r2 = r1
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2     // Catch:{ all -> 0x005c }
            java.io.Reader r2 = (java.io.Reader) r2     // Catch:{ all -> 0x005c }
            java.lang.String r2 = kotlin.io.TextStreamsKt.readText(r2)     // Catch:{ all -> 0x005c }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r3)     // Catch:{ IOException -> 0x0075 }
            r0.close()     // Catch:{ IOException -> 0x0075 }
            r5.close()     // Catch:{ IOException -> 0x0075 }
            com.google.maps.android.StreetViewUtils$Companion r5 = com.google.maps.android.StreetViewUtils.Companion     // Catch:{ IOException -> 0x0075 }
            com.google.maps.android.ResponseStreetView r5 = r5.deserializeResponse(r2)     // Catch:{ IOException -> 0x0075 }
            com.google.maps.android.Status r5 = r5.getStatus()     // Catch:{ IOException -> 0x0075 }
            return r5
        L_0x005c:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x005e }
        L_0x005e:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r5)     // Catch:{ IOException -> 0x0075 }
            throw r0     // Catch:{ IOException -> 0x0075 }
        L_0x0063:
            java.io.IOException r5 = new java.io.IOException     // Catch:{ IOException -> 0x0075 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0075 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0075 }
            r2.append(r1)     // Catch:{ IOException -> 0x0075 }
            java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x0075 }
            r5.<init>(r0)     // Catch:{ IOException -> 0x0075 }
            throw r5     // Catch:{ IOException -> 0x0075 }
        L_0x0075:
            r5 = move-exception
            r5.printStackTrace()
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Network error: "
            r1.<init>(r2)
            java.lang.String r5 = r5.getMessage()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L_0x0091:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.StreetViewUtils$Companion$fetchStreetViewData$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
