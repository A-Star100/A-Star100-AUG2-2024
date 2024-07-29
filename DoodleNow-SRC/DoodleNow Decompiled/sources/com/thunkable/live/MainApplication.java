package com.thunkable.live;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactNativeHost;
import com.facebook.soloader.SoLoader;
import expo.modules.ApplicationLifecycleDispatcher;
import expo.modules.ReactNativeHostWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/thunkable/live/MainApplication;", "Landroid/app/Application;", "Lcom/facebook/react/ReactApplication;", "()V", "reactHost", "Lcom/facebook/react/ReactHost;", "getReactHost", "()Lcom/facebook/react/ReactHost;", "reactNativeHost", "Lcom/facebook/react/ReactNativeHost;", "getReactNativeHost", "()Lcom/facebook/react/ReactNativeHost;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "DoodleNow-v1_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainApplication.kt */
public final class MainApplication extends Application implements ReactApplication {
    private final ReactNativeHost reactNativeHost = new ReactNativeHostWrapper(this, new MainApplication$reactNativeHost$1(this));

    public ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    public ReactHost getReactHost() {
        ReactNativeHostWrapper.Companion companion = ReactNativeHostWrapper.Companion;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return companion.createReactHost(applicationContext, getReactNativeHost());
    }

    public void onCreate() {
        super.onCreate();
        SoLoader.init((Context) this, false);
        ApplicationLifecycleDispatcher.onApplicationCreate(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        ApplicationLifecycleDispatcher.onConfigurationChanged(this, configuration);
    }
}
