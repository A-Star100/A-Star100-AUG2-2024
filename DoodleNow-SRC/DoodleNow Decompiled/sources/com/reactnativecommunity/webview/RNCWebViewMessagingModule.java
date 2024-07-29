package com.reactnativecommunity.webview;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/reactnativecommunity/webview/RNCWebViewMessagingModule;", "Lcom/facebook/react/bridge/JavaScriptModule;", "onMessage", "", "event", "Lcom/facebook/react/bridge/WritableMap;", "onShouldStartLoadWithRequest", "react-native-webview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RNCWebViewMessagingModule.kt */
public interface RNCWebViewMessagingModule extends JavaScriptModule {
    void onMessage(WritableMap writableMap);

    void onShouldStartLoadWithRequest(WritableMap writableMap);
}
