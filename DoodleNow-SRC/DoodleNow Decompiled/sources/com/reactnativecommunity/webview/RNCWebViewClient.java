package com.reactnativecommunity.webview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.util.Log;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.google.android.gms.common.internal.ImagesContract;
import com.reactnativecommunity.webview.RNCWebView;
import com.reactnativecommunity.webview.events.TopHttpErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingFinishEvent;
import com.reactnativecommunity.webview.events.TopLoadingStartEvent;
import com.reactnativecommunity.webview.events.TopRenderProcessGoneEvent;

public class RNCWebViewClient extends WebViewClient {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final int SHOULD_OVERRIDE_URL_LOADING_TIMEOUT = 250;
    private static String TAG = "RNCWebViewClient";
    protected RNCBasicAuthCredential basicAuthCredential = null;
    protected String ignoreErrFailedForThisURL = null;
    protected boolean mLastLoadFailed = false;
    protected RNCWebView.ProgressChangedFilter progressChangedFilter = null;

    public void setBasicAuthCredential(RNCBasicAuthCredential rNCBasicAuthCredential) {
        this.basicAuthCredential = rNCBasicAuthCredential;
    }

    public void setIgnoreErrFailedForThisURL(String str) {
        this.ignoreErrFailedForThisURL = str;
    }

    public void setProgressChangedFilter(RNCWebView.ProgressChangedFilter progressChangedFilter2) {
        this.progressChangedFilter = progressChangedFilter2;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (!this.mLastLoadFailed) {
            ((RNCWebView) webView).callInjectedJavaScript();
            emitFinishEvent(webView, str);
        }
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
        ((RNCWebView) webView).dispatchEvent(webView, new TopLoadingStartEvent(RNCWebViewWrapper.getReactTagFromWebView(webView), createWebViewEvent(webView, str)));
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.mLastLoadFailed = false;
        ((RNCWebView) webView).callInjectedJavaScriptBeforeContentLoaded();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0070, code lost:
        if (r1.get() != com.reactnativecommunity.webview.RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.SHOULD_OVERRIDE) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0074, code lost:
        com.reactnativecommunity.webview.RNCWebViewModuleImpl.shouldOverrideUrlLoadingLock.removeLock(java.lang.Double.valueOf(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007d, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldOverrideUrlLoading(android.webkit.WebView r12, java.lang.String r13) {
        /*
            r11 = this;
            r0 = r12
            com.reactnativecommunity.webview.RNCWebView r0 = (com.reactnativecommunity.webview.RNCWebView) r0
            com.facebook.react.bridge.ReactApplicationContext r1 = r0.getReactApplicationContext()
            com.facebook.react.bridge.JavaScriptContextHolder r1 = r1.getJavaScriptContextHolder()
            long r1 = r1.get()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 1
            if (r1 != 0) goto L_0x0018
            goto L_0x0093
        L_0x0018:
            com.reactnativecommunity.webview.RNCWebViewMessagingModule r1 = r0.mMessagingJSModule
            if (r1 == 0) goto L_0x0093
            com.reactnativecommunity.webview.RNCWebViewModuleImpl$ShouldOverrideUrlLoadingLock r1 = com.reactnativecommunity.webview.RNCWebViewModuleImpl.shouldOverrideUrlLoadingLock
            androidx.core.util.Pair r1 = r1.getNewLock()
            F r3 = r1.first
            java.lang.Double r3 = (java.lang.Double) r3
            double r3 = r3.doubleValue()
            S r1 = r1.second
            java.util.concurrent.atomic.AtomicReference r1 = (java.util.concurrent.atomic.AtomicReference) r1
            com.facebook.react.bridge.WritableMap r12 = r11.createWebViewEvent(r12, r13)
            java.lang.String r13 = "lockIdentifier"
            r12.putDouble(r13, r3)
            r0.dispatchDirectShouldStartLoadWithRequest(r12)
            r12 = 0
            monitor-enter(r1)     // Catch:{ InterruptedException -> 0x0081 }
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x007e }
        L_0x0040:
            java.lang.Object r13 = r1.get()     // Catch:{ all -> 0x007e }
            com.reactnativecommunity.webview.RNCWebViewModuleImpl$ShouldOverrideUrlLoadingLock$ShouldOverrideCallbackState r0 = com.reactnativecommunity.webview.RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.UNDECIDED     // Catch:{ all -> 0x007e }
            if (r13 != r0) goto L_0x0069
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x007e }
            long r7 = r7 - r5
            r9 = 250(0xfa, double:1.235E-321)
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 <= 0) goto L_0x0065
            java.lang.String r13 = TAG     // Catch:{ all -> 0x007e }
            java.lang.String r0 = "Did not receive response to shouldOverrideUrlLoading in time, defaulting to allow loading."
            com.facebook.common.logging.FLog.w((java.lang.String) r13, (java.lang.String) r0)     // Catch:{ all -> 0x007e }
            com.reactnativecommunity.webview.RNCWebViewModuleImpl$ShouldOverrideUrlLoadingLock r13 = com.reactnativecommunity.webview.RNCWebViewModuleImpl.shouldOverrideUrlLoadingLock     // Catch:{ all -> 0x007e }
            java.lang.Double r0 = java.lang.Double.valueOf(r3)     // Catch:{ all -> 0x007e }
            r13.removeLock(r0)     // Catch:{ all -> 0x007e }
            monitor-exit(r1)     // Catch:{ all -> 0x007e }
            return r12
        L_0x0065:
            r1.wait(r9)     // Catch:{ all -> 0x007e }
            goto L_0x0040
        L_0x0069:
            monitor-exit(r1)     // Catch:{ all -> 0x007e }
            java.lang.Object r13 = r1.get()
            com.reactnativecommunity.webview.RNCWebViewModuleImpl$ShouldOverrideUrlLoadingLock$ShouldOverrideCallbackState r0 = com.reactnativecommunity.webview.RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.SHOULD_OVERRIDE
            if (r13 != r0) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r2 = r12
        L_0x0074:
            com.reactnativecommunity.webview.RNCWebViewModuleImpl$ShouldOverrideUrlLoadingLock r12 = com.reactnativecommunity.webview.RNCWebViewModuleImpl.shouldOverrideUrlLoadingLock
            java.lang.Double r13 = java.lang.Double.valueOf(r3)
            r12.removeLock(r13)
            return r2
        L_0x007e:
            r13 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x007e }
            throw r13     // Catch:{ InterruptedException -> 0x0081 }
        L_0x0081:
            r13 = move-exception
            java.lang.String r0 = TAG
            java.lang.String r1 = "shouldOverrideUrlLoading was interrupted while waiting for result."
            com.facebook.common.logging.FLog.e((java.lang.String) r0, (java.lang.String) r1, (java.lang.Throwable) r13)
            com.reactnativecommunity.webview.RNCWebViewModuleImpl$ShouldOverrideUrlLoadingLock r13 = com.reactnativecommunity.webview.RNCWebViewModuleImpl.shouldOverrideUrlLoadingLock
            java.lang.Double r0 = java.lang.Double.valueOf(r3)
            r13.removeLock(r0)
            return r12
        L_0x0093:
            java.lang.String r0 = TAG
            java.lang.String r1 = "Couldn't use blocking synchronous call for onShouldStartLoadWithRequest due to debugging or missing Catalyst instance, falling back to old event-and-load."
            com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r1)
            com.reactnativecommunity.webview.RNCWebView$ProgressChangedFilter r0 = r11.progressChangedFilter
            r0.setWaitingForCommandLoadUrl(r2)
            int r0 = com.reactnativecommunity.webview.RNCWebViewWrapper.getReactTagFromWebView(r12)
            android.content.Context r1 = r12.getContext()
            com.facebook.react.bridge.ReactContext r1 = (com.facebook.react.bridge.ReactContext) r1
            com.facebook.react.uimanager.events.EventDispatcher r1 = com.facebook.react.uimanager.UIManagerHelper.getEventDispatcherForReactTag(r1, r0)
            com.reactnativecommunity.webview.events.TopShouldStartLoadWithRequestEvent r3 = new com.reactnativecommunity.webview.events.TopShouldStartLoadWithRequestEvent
            com.facebook.react.bridge.WritableMap r12 = r11.createWebViewEvent(r12, r13)
            r3.<init>(r0, r12)
            r1.dispatchEvent(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewClient.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        RNCBasicAuthCredential rNCBasicAuthCredential = this.basicAuthCredential;
        if (rNCBasicAuthCredential != null) {
            httpAuthHandler.proceed(rNCBasicAuthCredential.username, this.basicAuthCredential.password);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String url = webView.getUrl();
        String url2 = sslError.getUrl();
        sslErrorHandler.cancel();
        if (!url.equalsIgnoreCase(url2)) {
            String str = TAG;
            Log.w(str, "Resource blocked from loading due to SSL error. Blocked URL: " + url2);
            return;
        }
        int primaryError = sslError.getPrimaryError();
        onReceivedError(webView, primaryError, "SSL error: ".concat(primaryError != 0 ? primaryError != 1 ? primaryError != 2 ? primaryError != 3 ? primaryError != 4 ? primaryError != 5 ? "Unknown SSL Error" : "A generic error occurred" : "The date of the certificate is invalid" : "The certificate authority is not trusted" : "Hostname mismatch" : "The certificate has expired" : "The certificate is not yet valid"), url2);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        String str3 = this.ignoreErrFailedForThisURL;
        if (str3 == null || !str2.equals(str3) || i != -1 || !str.equals("net::ERR_FAILED")) {
            super.onReceivedError(webView, i, str, str2);
            this.mLastLoadFailed = true;
            emitFinishEvent(webView, str2);
            WritableMap createWebViewEvent = createWebViewEvent(webView, str2);
            createWebViewEvent.putDouble("code", (double) i);
            createWebViewEvent.putString(b.c, str);
            int reactTagFromWebView = RNCWebViewWrapper.getReactTagFromWebView(webView);
            UIManagerHelper.getEventDispatcherForReactTag((ReactContext) webView.getContext(), reactTagFromWebView).dispatchEvent(new TopLoadingErrorEvent(reactTagFromWebView, createWebViewEvent));
            return;
        }
        setIgnoreErrFailedForThisURL((String) null);
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (webResourceRequest.isForMainFrame()) {
            WritableMap createWebViewEvent = createWebViewEvent(webView, webResourceRequest.getUrl().toString());
            createWebViewEvent.putInt("statusCode", webResourceResponse.getStatusCode());
            createWebViewEvent.putString(b.c, webResourceResponse.getReasonPhrase());
            int reactTagFromWebView = RNCWebViewWrapper.getReactTagFromWebView(webView);
            UIManagerHelper.getEventDispatcherForReactTag((ReactContext) webView.getContext(), reactTagFromWebView).dispatchEvent(new TopHttpErrorEvent(reactTagFromWebView, createWebViewEvent));
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        super.onRenderProcessGone(webView, renderProcessGoneDetail);
        if (renderProcessGoneDetail.didCrash()) {
            Log.e(TAG, "The WebView rendering process crashed.");
        } else {
            Log.w(TAG, "The WebView rendering process was killed by the system.");
        }
        if (webView == null) {
            return true;
        }
        WritableMap createWebViewEvent = createWebViewEvent(webView, webView.getUrl());
        createWebViewEvent.putBoolean("didCrash", renderProcessGoneDetail.didCrash());
        int reactTagFromWebView = RNCWebViewWrapper.getReactTagFromWebView(webView);
        UIManagerHelper.getEventDispatcherForReactTag((ReactContext) webView.getContext(), reactTagFromWebView).dispatchEvent(new TopRenderProcessGoneEvent(reactTagFromWebView, createWebViewEvent));
        return true;
    }

    /* access modifiers changed from: protected */
    public void emitFinishEvent(WebView webView, String str) {
        int reactTagFromWebView = RNCWebViewWrapper.getReactTagFromWebView(webView);
        UIManagerHelper.getEventDispatcherForReactTag((ReactContext) webView.getContext(), reactTagFromWebView).dispatchEvent(new TopLoadingFinishEvent(reactTagFromWebView, createWebViewEvent(webView, str)));
    }

    /* access modifiers changed from: protected */
    public WritableMap createWebViewEvent(WebView webView, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble(TouchesHelper.TARGET_KEY, (double) RNCWebViewWrapper.getReactTagFromWebView(webView));
        createMap.putString(ImagesContract.URL, str);
        createMap.putBoolean("loading", !this.mLastLoadFailed && webView.getProgress() != 100);
        createMap.putString("title", webView.getTitle());
        createMap.putBoolean("canGoBack", webView.canGoBack());
        createMap.putBoolean("canGoForward", webView.canGoForward());
        return createMap;
    }
}
