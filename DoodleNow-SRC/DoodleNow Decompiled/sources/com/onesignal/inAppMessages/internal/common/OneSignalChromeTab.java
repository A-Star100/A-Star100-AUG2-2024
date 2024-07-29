package com.onesignal.inAppMessages.internal.common;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J%\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/onesignal/inAppMessages/internal/common/OneSignalChromeTab;", "", "()V", "hasChromeTabLibrary", "", "open", "url", "", "openActivity", "context", "Landroid/content/Context;", "open$com_onesignal_inAppMessages", "OneSignalCustomTabsServiceConnection", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OneSignalChromeTab.kt */
public final class OneSignalChromeTab {
    public static final OneSignalChromeTab INSTANCE = new OneSignalChromeTab();

    private final boolean hasChromeTabLibrary() {
        return true;
    }

    private OneSignalChromeTab() {
    }

    public final boolean open$com_onesignal_inAppMessages(String str, boolean z, Context context) {
        Intrinsics.checkNotNullParameter(str, ImagesContract.URL);
        Intrinsics.checkNotNullParameter(context, "context");
        if (!hasChromeTabLibrary()) {
            return false;
        }
        return CustomTabsClient.bindCustomTabsService(context, "com.android.chrome", new OneSignalCustomTabsServiceConnection(str, z, context));
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/onesignal/inAppMessages/internal/common/OneSignalChromeTab$OneSignalCustomTabsServiceConnection;", "Landroidx/browser/customtabs/CustomTabsServiceConnection;", "url", "", "openActivity", "", "context", "Landroid/content/Context;", "(Ljava/lang/String;ZLandroid/content/Context;)V", "onCustomTabsServiceConnected", "", "componentName", "Landroid/content/ComponentName;", "customTabsClient", "Landroidx/browser/customtabs/CustomTabsClient;", "onServiceDisconnected", "name", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OneSignalChromeTab.kt */
    private static final class OneSignalCustomTabsServiceConnection extends CustomTabsServiceConnection {
        private final Context context;
        private final boolean openActivity;
        private final String url;

        public void onServiceDisconnected(ComponentName componentName) {
            Intrinsics.checkNotNullParameter(componentName, "name");
        }

        public OneSignalCustomTabsServiceConnection(String str, boolean z, Context context2) {
            Intrinsics.checkNotNullParameter(str, ImagesContract.URL);
            Intrinsics.checkNotNullParameter(context2, "context");
            this.url = str;
            this.openActivity = z;
            this.context = context2;
        }

        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            Intrinsics.checkNotNullParameter(componentName, "componentName");
            Intrinsics.checkNotNullParameter(customTabsClient, "customTabsClient");
            customTabsClient.warmup(0);
            CustomTabsSession newSession = customTabsClient.newSession((CustomTabsCallback) null);
            if (newSession != null) {
                Uri parse = Uri.parse(this.url);
                newSession.mayLaunchUrl(parse, (Bundle) null, (List<Bundle>) null);
                if (this.openActivity) {
                    CustomTabsIntent build = new CustomTabsIntent.Builder(newSession).build();
                    Intrinsics.checkNotNullExpressionValue(build, "mBuilder.build()");
                    build.intent.setData(parse);
                    build.intent.addFlags(268435456);
                    this.context.startActivity(build.intent, build.startAnimationBundle);
                }
            }
        }
    }
}
