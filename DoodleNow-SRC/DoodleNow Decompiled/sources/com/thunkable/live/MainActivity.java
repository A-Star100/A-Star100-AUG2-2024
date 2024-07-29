package com.thunkable.live;

import android.os.Build;
import android.os.Bundle;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import expo.modules.ReactActivityDelegateWrapper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¨\u0006\f"}, d2 = {"Lcom/thunkable/live/MainActivity;", "Lcom/facebook/react/ReactActivity;", "()V", "createReactActivityDelegate", "Lcom/facebook/react/ReactActivityDelegate;", "getMainComponentName", "", "invokeDefaultOnBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "DoodleNow-v1_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity extends ReactActivity {
    /* access modifiers changed from: protected */
    public String getMainComponentName() {
        return "main";
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setTheme(R.style.AppTheme);
        super.onCreate((Bundle) null);
    }

    /* access modifiers changed from: protected */
    public ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegateWrapper(this, false, new MainActivity$createReactActivityDelegate$1(this, getMainComponentName(), DefaultNewArchitectureEntryPoint.getFabricEnabled()));
    }

    public void invokeDefaultOnBackPressed() {
        if (Build.VERSION.SDK_INT > 30) {
            super.invokeDefaultOnBackPressed();
        } else if (!moveTaskToBack(false)) {
            super.invokeDefaultOnBackPressed();
        }
    }
}
