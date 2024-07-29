package com.onesignal.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.common.internal.ImagesContract;
import com.onesignal.common.AndroidSupportV4Compat;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001<B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J$\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0013J\u0006\u0010#\u001a\u00020\u000fJ\u0006\u0010$\u001a\u00020\u000fJ\u001e\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010)\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!J\u0006\u0010*\u001a\u00020\u000fJ\u0010\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u0005J\u0010\u0010-\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u0005J\u0014\u0010/\u001a\u00020\u000f2\n\u00100\u001a\u0006\u0012\u0002\b\u000301H\u0007J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u000206J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u0005J\u000e\u00108\u001a\u0002092\u0006\u00105\u001a\u000206J\u000e\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020\u0013¨\u0006="}, d2 = {"Lcom/onesignal/common/AndroidUtils;", "", "()V", "filterManifestPermissions", "", "", "permissions", "applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "getAppVersion", "context", "Landroid/content/Context;", "getManifestMeta", "metaName", "getManifestMetaBoolean", "", "getManifestMetaBundle", "Landroid/os/Bundle;", "getRandomDelay", "", "minDelay", "maxDelay", "getResourceString", "key", "defaultStr", "getRootCauseMessage", "throwable", "", "getRootCauseThrowable", "subjectThrowable", "getTargetSdkVersion", "hasConfigChangeFlag", "activity", "Landroid/app/Activity;", "configChangeFlag", "hasJobIntentService", "hasNotificationManagerCompat", "hasPermission", "permission", "isUserGranted", "hasWakefulBroadcastReceiver", "isActivityFullyReady", "isRunningOnMainThread", "isStringNotEmpty", "body", "isValidResourceName", "name", "opaqueHasClass", "_class", "Ljava/lang/Class;", "openURLInBrowser", "", "appContext", "uri", "Landroid/net/Uri;", "url", "openURLInBrowserIntent", "Landroid/content/Intent;", "sleep", "ms", "SchemaType", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidUtils.kt */
public final class AndroidUtils {
    public static final AndroidUtils INSTANCE = new AndroidUtils();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AndroidUtils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SchemaType.values().length];
            iArr[SchemaType.DATA.ordinal()] = 1;
            iArr[SchemaType.HTTPS.ordinal()] = 2;
            iArr[SchemaType.HTTP.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean hasJobIntentService() {
        return true;
    }

    public final boolean hasNotificationManagerCompat() {
        return true;
    }

    public final boolean hasWakefulBroadcastReceiver() {
        return true;
    }

    public final boolean opaqueHasClass(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "_class");
        return true;
    }

    private AndroidUtils() {
    }

    public final int getRandomDelay(int i, int i2) {
        return new Random().nextInt((i2 + 1) - i) + i;
    }

    public final boolean isStringNotEmpty(String str) {
        return !TextUtils.isEmpty(str);
    }

    public final boolean isActivityFullyReady(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        boolean z = activity.getWindow().getDecorView().getApplicationWindowToken() != null;
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        boolean z2 = decorView.getRootWindowInsets() != null;
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    public final void sleep(int i) {
        try {
            Thread.sleep((long) i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public final boolean hasConfigChangeFlag(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            return (activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).configChanges & i) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final String getAppVersion(Context context) {
        Integer num;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            num = Integer.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            Integer num2 = null;
            num = null;
        }
        if (num != null) {
            return num.toString();
        }
        return null;
    }

    public final String getManifestMeta(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle manifestMetaBundle = getManifestMetaBundle(context);
        if (manifestMetaBundle != null) {
            return manifestMetaBundle.getString(str);
        }
        return null;
    }

    public final boolean getManifestMetaBoolean(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle manifestMetaBundle = getManifestMetaBundle(context);
        if (manifestMetaBundle != null) {
            return manifestMetaBundle.getBoolean(str);
        }
        return false;
    }

    public final Bundle getManifestMetaBundle(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "context.packageManager.g…A_DATA,\n                )");
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            Logging.error("Manifest application info not found", e);
            return null;
        }
    }

    public final String getResourceString(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(str, "string", context.getPackageName());
        return identifier != 0 ? resources.getString(identifier) : str2;
    }

    public final boolean isValidResourceName(String str) {
        if (str != null) {
            if (!new Regex("^[0-9]").matches(str)) {
                return true;
            }
        }
        return false;
    }

    public final Throwable getRootCauseThrowable(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "subjectThrowable");
        while (th.getCause() != null && th.getCause() != th) {
            th = th.getCause();
            Intrinsics.checkNotNull(th);
        }
        return th;
    }

    public final String getRootCauseMessage(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        return getRootCauseThrowable(th).getMessage();
    }

    public final boolean isRunningOnMainThread() {
        return Intrinsics.areEqual((Object) Thread.currentThread(), (Object) Looper.getMainLooper().getThread());
    }

    public final int getTargetSdkVersion(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "packageManager.getApplicationInfo(packageName, 0)");
            return applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 15;
        }
    }

    public final void openURLInBrowser(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(uri, "uri");
        context.startActivity(openURLInBrowserIntent(uri));
    }

    public final Intent openURLInBrowserIntent(Uri uri) {
        Intent intent;
        Intrinsics.checkNotNullParameter(uri, "uri");
        SchemaType fromString = uri.getScheme() != null ? SchemaType.Companion.fromString(uri.getScheme()) : null;
        if (fromString == null) {
            fromString = SchemaType.HTTP;
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            if (!StringsKt.contains$default((CharSequence) uri2, (CharSequence) "://", false, 2, (Object) null)) {
                uri = Uri.parse("http://" + uri);
                Intrinsics.checkNotNullExpressionValue(uri, "parse(\"http://$uri\")");
            }
        }
        int i = WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()];
        if (i == 1) {
            intent = Intent.makeMainSelectorActivity("android.intent.action.MAIN", "android.intent.category.APP_BROWSER");
            Intrinsics.checkNotNullExpressionValue(intent, "makeMainSelectorActivity…ent.CATEGORY_APP_BROWSER)");
            intent.setData(uri);
        } else if (i == 2 || i == 3) {
            intent = new Intent("android.intent.action.VIEW", uri);
        } else {
            intent = new Intent("android.intent.action.VIEW", uri);
        }
        intent.addFlags(268435456);
        return intent;
    }

    public final boolean hasPermission(String str, boolean z, IApplicationService iApplicationService) {
        Intrinsics.checkNotNullParameter(str, "permission");
        Intrinsics.checkNotNullParameter(iApplicationService, "applicationService");
        try {
            PackageInfo packageInfo = iApplicationService.getAppContext().getPackageManager().getPackageInfo(iApplicationService.getAppContext().getPackageName(), 4096);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "applicationService.appCo…NS,\n                    )");
            String[] strArr = packageInfo.requestedPermissions;
            Intrinsics.checkNotNullExpressionValue(strArr, "packageInfo.requestedPermissions");
            if (!CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length)).contains(str)) {
                return false;
            }
            if (z && AndroidSupportV4Compat.ContextCompat.INSTANCE.checkSelfPermission(iApplicationService.getAppContext(), str) == -1) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final List<String> filterManifestPermissions(List<String> list, IApplicationService iApplicationService) {
        Intrinsics.checkNotNullParameter(list, "permissions");
        Intrinsics.checkNotNullParameter(iApplicationService, "applicationService");
        PackageInfo packageInfo = iApplicationService.getAppContext().getPackageManager().getPackageInfo(iApplicationService.getAppContext().getPackageName(), 4096);
        Intrinsics.checkNotNullExpressionValue(packageInfo, "applicationService.appCo…eManager.GET_PERMISSIONS)");
        String[] strArr = packageInfo.requestedPermissions;
        Intrinsics.checkNotNullExpressionValue(strArr, "packageInfo.requestedPermissions");
        List listOf = CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length));
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (listOf.contains((String) next)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/onesignal/common/AndroidUtils$SchemaType;", "", "text", "", "(Ljava/lang/String;ILjava/lang/String;)V", "DATA", "HTTPS", "HTTP", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AndroidUtils.kt */
    public enum SchemaType {
        DATA("data"),
        HTTPS("https"),
        HTTP("http");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String text;

        private SchemaType(String str) {
            this.text = str;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/common/AndroidUtils$SchemaType$Companion;", "", "()V", "fromString", "Lcom/onesignal/common/AndroidUtils$SchemaType;", "text", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: AndroidUtils.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final SchemaType fromString(String str) {
                for (SchemaType schemaType : SchemaType.values()) {
                    if (StringsKt.equals(schemaType.text, str, true)) {
                        return schemaType;
                    }
                }
                return null;
            }
        }
    }

    public final void openURLInBrowser(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(str, ImagesContract.URL);
        CharSequence charSequence = str;
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) charSequence.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        Uri parse = Uri.parse(charSequence.subSequence(i, length + 1).toString());
        Intrinsics.checkNotNullExpressionValue(parse, "parse(url.trim { it <= ' ' })");
        openURLInBrowser(context, parse);
    }
}
