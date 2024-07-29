package com.reactnativecommunity.webview;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.ContentSizeChangeEvent;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.views.scroll.OnScrollDispatchHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.reactnativecommunity.webview.events.TopCustomMenuSelectionEvent;
import com.reactnativecommunity.webview.events.TopMessageEvent;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RNCWebView extends WebView implements LifecycleEventListener {
    protected static final String JAVASCRIPT_INTERFACE = "ReactNativeWebView";
    protected RNCWebViewBridge bridge;
    protected boolean hasScrollEvent = false;
    protected String injectedJS;
    protected String injectedJSBeforeContentLoaded;
    protected boolean injectedJavaScriptBeforeContentLoadedForMainFrameOnly = true;
    protected boolean injectedJavaScriptForMainFrameOnly = true;
    protected RNCWebViewMessagingModule mMessagingJSModule = ((RNCWebViewMessagingModule) ((ThemedReactContext) getContext()).getReactApplicationContext().getJSModule(RNCWebViewMessagingModule.class));
    private OnScrollDispatchHelper mOnScrollDispatchHelper;
    protected RNCWebViewClient mRNCWebViewClient;
    WebChromeClient mWebChromeClient;
    protected List<Map<String, String>> menuCustomItems;
    protected boolean messagingEnabled = false;
    protected String messagingModuleName;
    protected boolean nestedScrollEnabled = false;
    protected ProgressChangedFilter progressChangedFilter = new ProgressChangedFilter();
    protected boolean sendContentSizeChangeEvents = false;

    public boolean getMessagingEnabled() {
        return this.messagingEnabled;
    }

    public RNCWebViewClient getRNCWebViewClient() {
        return this.mRNCWebViewClient;
    }

    public WebChromeClient getWebChromeClient() {
        return this.mWebChromeClient;
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public void setHasScrollEvent(boolean z) {
        this.hasScrollEvent = z;
    }

    public void setMenuCustomItems(List<Map<String, String>> list) {
        this.menuCustomItems = list;
    }

    public void setNestedScrollEnabled(boolean z) {
        this.nestedScrollEnabled = z;
    }

    public void setSendContentSizeChangeEvents(boolean z) {
        this.sendContentSizeChangeEvents = z;
    }

    public RNCWebView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
    }

    public void setIgnoreErrFailedForThisURL(String str) {
        this.mRNCWebViewClient.setIgnoreErrFailedForThisURL(str);
    }

    public void setBasicAuthCredential(RNCBasicAuthCredential rNCBasicAuthCredential) {
        this.mRNCWebViewClient.setBasicAuthCredential(rNCBasicAuthCredential);
    }

    public void onHostDestroy() {
        cleanupCallbacksAndDestroy();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nestedScrollEnabled) {
            requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.sendContentSizeChangeEvents) {
            dispatchEvent(this, new ContentSizeChangeEvent(RNCWebViewWrapper.getReactTagFromWebView(this), i, i2));
        }
    }

    public ActionMode startActionMode(final ActionMode.Callback callback, int i) {
        if (this.menuCustomItems == null) {
            return super.startActionMode(callback, i);
        }
        return super.startActionMode(new ActionMode.Callback2() {
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                for (int i = 0; i < RNCWebView.this.menuCustomItems.size(); i++) {
                    menu.add(0, i, i, (CharSequence) RNCWebView.this.menuCustomItems.get(i).get("label"));
                }
                return true;
            }

            public boolean onActionItemClicked(final ActionMode actionMode, final MenuItem menuItem) {
                final WritableMap createMap = Arguments.createMap();
                RNCWebView.this.evaluateJavascript("(function(){return {selection: window.getSelection().toString()} })()", new ValueCallback<String>() {
                    public void onReceiveValue(String str) {
                        String str2;
                        Map map = RNCWebView.this.menuCustomItems.get(menuItem.getItemId());
                        createMap.putString("label", (String) map.get("label"));
                        createMap.putString(SubscriberAttributeKt.JSON_NAME_KEY, (String) map.get(SubscriberAttributeKt.JSON_NAME_KEY));
                        try {
                            str2 = new JSONObject(str).getString("selection");
                        } catch (JSONException unused) {
                            str2 = "";
                        }
                        createMap.putString("selectedText", str2);
                        RNCWebView.this.dispatchEvent(RNCWebView.this, new TopCustomMenuSelectionEvent(RNCWebViewWrapper.getReactTagFromWebView(RNCWebView.this), createMap));
                        actionMode.finish();
                    }
                });
                return true;
            }

            public void onGetContentRect(ActionMode actionMode, View view, Rect rect) {
                ActionMode.Callback callback = callback;
                if (callback instanceof ActionMode.Callback2) {
                    ((ActionMode.Callback2) callback).onGetContentRect(actionMode, view, rect);
                } else {
                    super.onGetContentRect(actionMode, view, rect);
                }
            }
        }, i);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof RNCWebViewClient) {
            RNCWebViewClient rNCWebViewClient = (RNCWebViewClient) webViewClient;
            this.mRNCWebViewClient = rNCWebViewClient;
            rNCWebViewClient.setProgressChangedFilter(this.progressChangedFilter);
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.mWebChromeClient = webChromeClient;
        super.setWebChromeClient(webChromeClient);
        if (webChromeClient instanceof RNCWebChromeClient) {
            ((RNCWebChromeClient) webChromeClient).setProgressChangedFilter(this.progressChangedFilter);
        }
    }

    /* access modifiers changed from: protected */
    public RNCWebViewBridge createRNCWebViewBridge(RNCWebView rNCWebView) {
        if (this.bridge == null) {
            RNCWebViewBridge rNCWebViewBridge = new RNCWebViewBridge(rNCWebView);
            this.bridge = rNCWebViewBridge;
            addJavascriptInterface(rNCWebViewBridge, JAVASCRIPT_INTERFACE);
        }
        return this.bridge;
    }

    public void setMessagingEnabled(boolean z) {
        if (this.messagingEnabled != z) {
            this.messagingEnabled = z;
            if (z) {
                createRNCWebViewBridge(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void evaluateJavascriptWithFallback(String str) {
        evaluateJavascript(str, (ValueCallback) null);
    }

    public void callInjectedJavaScript() {
        String str;
        if (getSettings().getJavaScriptEnabled() && (str = this.injectedJS) != null && !TextUtils.isEmpty(str)) {
            evaluateJavascriptWithFallback("(function() {\n" + this.injectedJS + ";\n})();");
        }
    }

    public void callInjectedJavaScriptBeforeContentLoaded() {
        String str;
        if (getSettings().getJavaScriptEnabled() && (str = this.injectedJSBeforeContentLoaded) != null && !TextUtils.isEmpty(str)) {
            evaluateJavascriptWithFallback("(function() {\n" + this.injectedJSBeforeContentLoaded + ";\n})();");
        }
    }

    public void setInjectedJavaScriptObject(String str) {
        if (getSettings().getJavaScriptEnabled()) {
            createRNCWebViewBridge(this).setInjectedObjectJson(str);
        }
    }

    public void onMessage(final String str) {
        getThemedReactContext();
        if (this.mRNCWebViewClient != null) {
            post(new Runnable() {
                public void run() {
                    if (RNCWebView.this.mRNCWebViewClient != null) {
                        RNCWebViewClient rNCWebViewClient = RNCWebView.this.mRNCWebViewClient;
                        WebView webView = this;
                        WritableMap createWebViewEvent = rNCWebViewClient.createWebViewEvent(webView, webView.getUrl());
                        createWebViewEvent.putString("data", str);
                        if (RNCWebView.this.mMessagingJSModule != null) {
                            RNCWebView.this.dispatchDirectMessage(createWebViewEvent);
                        } else {
                            RNCWebView.this.dispatchEvent(this, new TopMessageEvent(RNCWebViewWrapper.getReactTagFromWebView(this), createWebViewEvent));
                        }
                    }
                }
            });
            return;
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putString("data", str);
        if (this.mMessagingJSModule != null) {
            dispatchDirectMessage(createMap);
        } else {
            dispatchEvent(this, new TopMessageEvent(RNCWebViewWrapper.getReactTagFromWebView(this), createMap));
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDirectMessage(WritableMap writableMap) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putMap("nativeEvent", writableMap);
        writableNativeMap.putString("messagingModuleName", this.messagingModuleName);
        this.mMessagingJSModule.onMessage(writableNativeMap);
    }

    /* access modifiers changed from: protected */
    public boolean dispatchDirectShouldStartLoadWithRequest(WritableMap writableMap) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putMap("nativeEvent", writableMap);
        writableNativeMap.putString("messagingModuleName", this.messagingModuleName);
        this.mMessagingJSModule.onShouldStartLoadWithRequest(writableNativeMap);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.hasScrollEvent) {
            if (this.mOnScrollDispatchHelper == null) {
                this.mOnScrollDispatchHelper = new OnScrollDispatchHelper();
            }
            if (this.mOnScrollDispatchHelper.onScrollChanged(i, i2)) {
                dispatchEvent(this, ScrollEvent.obtain(RNCWebViewWrapper.getReactTagFromWebView(this), ScrollEventType.SCROLL, (float) i, (float) i2, this.mOnScrollDispatchHelper.getXFlingVelocity(), this.mOnScrollDispatchHelper.getYFlingVelocity(), computeHorizontalScrollRange(), computeVerticalScrollRange(), getWidth(), getHeight()));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchEvent(WebView webView, Event event) {
        UIManagerHelper.getEventDispatcherForReactTag(getThemedReactContext(), RNCWebViewWrapper.getReactTagFromWebView(webView)).dispatchEvent(event);
    }

    /* access modifiers changed from: protected */
    public void cleanupCallbacksAndDestroy() {
        setWebViewClient((WebViewClient) null);
        destroy();
    }

    public void destroy() {
        WebChromeClient webChromeClient = this.mWebChromeClient;
        if (webChromeClient != null) {
            webChromeClient.onHideCustomView();
        }
        super.destroy();
    }

    public ThemedReactContext getThemedReactContext() {
        return (ThemedReactContext) getContext();
    }

    public ReactApplicationContext getReactApplicationContext() {
        return getThemedReactContext().getReactApplicationContext();
    }

    protected class RNCWebViewBridge {
        private String TAG = "RNCWebViewBridge";
        String injectedObjectJson;
        RNCWebView mWebView;

        @JavascriptInterface
        public String injectedObjectJson() {
            return this.injectedObjectJson;
        }

        public void setInjectedObjectJson(String str) {
            this.injectedObjectJson = str;
        }

        RNCWebViewBridge(RNCWebView rNCWebView) {
            this.mWebView = rNCWebView;
        }

        @JavascriptInterface
        public void postMessage(String str) {
            if (this.mWebView.getMessagingEnabled()) {
                this.mWebView.onMessage(str);
            } else {
                FLog.w(this.TAG, "ReactNativeWebView.postMessage method was called but messaging is disabled. Pass an onMessage handler to the WebView.");
            }
        }
    }

    protected static class ProgressChangedFilter {
        private boolean waitingForCommandLoadUrl = false;

        public boolean isWaitingForCommandLoadUrl() {
            return this.waitingForCommandLoadUrl;
        }

        public void setWaitingForCommandLoadUrl(boolean z) {
            this.waitingForCommandLoadUrl = z;
        }

        protected ProgressChangedFilter() {
        }
    }
}
