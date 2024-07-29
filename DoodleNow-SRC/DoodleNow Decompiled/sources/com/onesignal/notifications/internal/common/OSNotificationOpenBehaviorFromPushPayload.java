package com.onesignal.notifications.internal.common;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/onesignal/notifications/internal/common/OSNotificationOpenBehaviorFromPushPayload;", "", "context", "Landroid/content/Context;", "fcmPayload", "Lorg/json/JSONObject;", "(Landroid/content/Context;Lorg/json/JSONObject;)V", "shouldOpenApp", "", "getShouldOpenApp", "()Z", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OSNotificationOpenBehaviorFromPushPayload.kt */
public final class OSNotificationOpenBehaviorFromPushPayload {
    private final Context context;
    private final JSONObject fcmPayload;

    public OSNotificationOpenBehaviorFromPushPayload(Context context2, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(jSONObject, "fcmPayload");
        this.context = context2;
        this.fcmPayload = jSONObject;
    }

    public final boolean getShouldOpenApp() {
        return OSNotificationOpenAppSettings.INSTANCE.getShouldOpenActivity(this.context) && getUri() == null;
    }

    public final Uri getUri() {
        if (!OSNotificationOpenAppSettings.INSTANCE.getShouldOpenActivity(this.context) || OSNotificationOpenAppSettings.INSTANCE.getSuppressLaunchURL(this.context)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(this.fcmPayload.optString("custom"));
        if (jSONObject.has("u")) {
            String optString = jSONObject.optString("u");
            if (!Intrinsics.areEqual((Object) optString, (Object) "")) {
                Intrinsics.checkNotNullExpressionValue(optString, ImagesContract.URL);
                CharSequence charSequence = optString;
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
                return Uri.parse(charSequence.subSequence(i, length + 1).toString());
            }
        }
        return null;
    }
}
