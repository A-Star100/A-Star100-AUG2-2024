package com.onesignal.session.internal.session;

import com.onesignal.common.modeling.SimpleModelStore;
import com.onesignal.common.modeling.SingletonModelStore;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/onesignal/session/internal/session/SessionModelStore;", "Lcom/onesignal/common/modeling/SingletonModelStore;", "Lcom/onesignal/session/internal/session/SessionModel;", "prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SessionModelStore.kt */
public class SessionModelStore extends SingletonModelStore<SessionModel> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SessionModelStore(IPreferencesService iPreferencesService) {
        super(new SimpleModelStore(AnonymousClass1.INSTANCE, OutcomeEventsTable.COLUMN_NAME_SESSION, iPreferencesService));
        Intrinsics.checkNotNullParameter(iPreferencesService, "prefs");
    }
}
