package com.onesignal.core.internal.preferences;

import android.content.Context;
import android.os.Build;
import com.android.billingclient.api.zzg$$ExternalSyntheticApiModelOutline0;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/core/internal/preferences/PreferenceStoreFix;", "", "()V", "ensureNoObfuscatedPrefStore", "", "context", "Landroid/content/Context;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PreferenceStoreFix.kt */
public final class PreferenceStoreFix {
    public static final PreferenceStoreFix INSTANCE = new PreferenceStoreFix();

    private PreferenceStoreFix() {
    }

    public final void ensureNoObfuscatedPrefStore(Context context) {
        File file;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                file = new File(zzg$$ExternalSyntheticApiModelOutline0.m(context), "shared_prefs");
            } else {
                file = new File(context.getFilesDir().getParentFile(), "shared_prefs");
            }
            File file2 = new File(file, "OneSignal.xml");
            if (file.exists() && file.isDirectory()) {
                if (!file2.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file3 : listFiles) {
                            Intrinsics.checkNotNullExpressionValue(file3, "prefsFile");
                            if (context.getSharedPreferences(FilesKt.getNameWithoutExtension(file3), 0).contains(PreferenceOneSignalKeys.PREFS_LEGACY_PLAYER_ID)) {
                                file3.renameTo(file2);
                                return;
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Logging.log(LogLevel.ERROR, "error attempting to fix obfuscated preference store", th);
        }
    }
}
