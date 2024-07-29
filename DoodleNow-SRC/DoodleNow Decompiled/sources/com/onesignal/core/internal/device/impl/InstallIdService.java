package com.onesignal.core.internal.device.impl;

import com.onesignal.core.internal.device.IInstallIdService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u000b\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/onesignal/core/internal/device/impl/InstallIdService;", "Lcom/onesignal/core/internal/device/IInstallIdService;", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "currentId", "Ljava/util/UUID;", "getCurrentId", "()Ljava/util/UUID;", "currentId$delegate", "Lkotlin/Lazy;", "getId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InstallIdService.kt */
public final class InstallIdService implements IInstallIdService {
    /* access modifiers changed from: private */
    public final IPreferencesService _prefs;
    private final Lazy currentId$delegate = LazyKt.lazy(new InstallIdService$currentId$2(this));

    public InstallIdService(IPreferencesService iPreferencesService) {
        Intrinsics.checkNotNullParameter(iPreferencesService, "_prefs");
        this._prefs = iPreferencesService;
    }

    private final UUID getCurrentId() {
        Object value = this.currentId$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-currentId>(...)");
        return (UUID) value;
    }

    public Object getId(Continuation<? super UUID> continuation) {
        return getCurrentId();
    }
}
