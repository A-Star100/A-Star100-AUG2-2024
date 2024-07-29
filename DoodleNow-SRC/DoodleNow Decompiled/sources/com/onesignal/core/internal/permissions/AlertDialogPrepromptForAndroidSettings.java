package com.onesignal.core.internal.permissions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.onesignal.core.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/onesignal/core/internal/permissions/AlertDialogPrepromptForAndroidSettings;", "", "()V", "show", "", "activity", "Landroid/app/Activity;", "titlePrefix", "", "previouslyDeniedPostfix", "callback", "Lcom/onesignal/core/internal/permissions/AlertDialogPrepromptForAndroidSettings$Callback;", "Callback", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AlertDialogPrepromptForAndroidSettings.kt */
public final class AlertDialogPrepromptForAndroidSettings {
    public static final AlertDialogPrepromptForAndroidSettings INSTANCE = new AlertDialogPrepromptForAndroidSettings();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/onesignal/core/internal/permissions/AlertDialogPrepromptForAndroidSettings$Callback;", "", "onAccept", "", "onDecline", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AlertDialogPrepromptForAndroidSettings.kt */
    public interface Callback {
        void onAccept();

        void onDecline();
    }

    private AlertDialogPrepromptForAndroidSettings() {
    }

    public final void show(Activity activity, String str, String str2, Callback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "titlePrefix");
        Intrinsics.checkNotNullParameter(str2, "previouslyDeniedPostfix");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String string = activity.getString(R.string.permission_not_available_title);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…sion_not_available_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        String string2 = activity.getString(R.string.permission_not_available_message);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str…on_not_available_message)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{str2}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
        new AlertDialog.Builder(activity).setTitle(format).setMessage(format2).setPositiveButton(R.string.permission_not_available_open_settings_option, new AlertDialogPrepromptForAndroidSettings$$ExternalSyntheticLambda0(callback)).setNegativeButton(17039369, new AlertDialogPrepromptForAndroidSettings$$ExternalSyntheticLambda1(callback)).setOnCancelListener(new AlertDialogPrepromptForAndroidSettings$$ExternalSyntheticLambda2(callback)).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-0  reason: not valid java name */
    public static final void m1029show$lambda0(Callback callback, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onAccept();
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-1  reason: not valid java name */
    public static final void m1030show$lambda1(Callback callback, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onDecline();
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-2  reason: not valid java name */
    public static final void m1031show$lambda2(Callback callback, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onDecline();
    }
}
