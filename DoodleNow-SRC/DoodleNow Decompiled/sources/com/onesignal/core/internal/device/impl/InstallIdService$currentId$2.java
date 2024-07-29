package com.onesignal.core.internal.device.impl;

import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceOneSignalKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/UUID;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: InstallIdService.kt */
final class InstallIdService$currentId$2 extends Lambda implements Function0<UUID> {
    final /* synthetic */ InstallIdService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstallIdService$currentId$2(InstallIdService installIdService) {
        super(0);
        this.this$0 = installIdService;
    }

    public final UUID invoke() {
        String string$default = IPreferencesService.DefaultImpls.getString$default(this.this$0._prefs, PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_INSTALL_ID, (String) null, 4, (Object) null);
        if (string$default != null) {
            return UUID.fromString(string$default);
        }
        UUID randomUUID = UUID.randomUUID();
        this.this$0._prefs.saveString(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_INSTALL_ID, randomUUID.toString());
        return randomUUID;
    }
}
