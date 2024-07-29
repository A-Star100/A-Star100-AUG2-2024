package com.onesignal.user.internal.operations.impl.states;

import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.time.ITime;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/states/NewRecordsState;", "", "_time", "Lcom/onesignal/core/internal/time/ITime;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "(Lcom/onesignal/core/internal/time/ITime;Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "records", "", "", "", "add", "", "key", "canAccess", "", "isInMissingRetryWindow", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NewRecordsState.kt */
public final class NewRecordsState {
    private final ConfigModelStore _configModelStore;
    private final ITime _time;
    private final Map<String, Long> records = new LinkedHashMap();

    public NewRecordsState(ITime iTime, ConfigModelStore configModelStore) {
        Intrinsics.checkNotNullParameter(iTime, "_time");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        this._time = iTime;
        this._configModelStore = configModelStore;
    }

    public final void add(String str) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        this.records.put(str, Long.valueOf(this._time.getCurrentTimeMillis()));
    }

    public final boolean canAccess(String str) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        Long l = this.records.get(str);
        if (l == null) {
            return true;
        }
        if (this._time.getCurrentTimeMillis() - l.longValue() >= ((ConfigModel) this._configModelStore.getModel()).getOpRepoPostCreateDelay()) {
            return true;
        }
        return false;
    }

    public final boolean isInMissingRetryWindow(String str) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        Long l = this.records.get(str);
        if (l == null) {
            return false;
        }
        if (this._time.getCurrentTimeMillis() - l.longValue() <= ((ConfigModel) this._configModelStore.getModel()).getOpRepoPostCreateRetryUpTo()) {
            return true;
        }
        return false;
    }
}
