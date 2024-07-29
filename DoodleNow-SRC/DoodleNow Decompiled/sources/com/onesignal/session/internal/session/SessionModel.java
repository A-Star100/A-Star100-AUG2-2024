package com.onesignal.session.internal.session;

import com.onesignal.common.modeling.Model;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/onesignal/session/internal/session/SessionModel;", "Lcom/onesignal/common/modeling/Model;", "()V", "value", "", "activeDuration", "getActiveDuration", "()J", "setActiveDuration", "(J)V", "focusTime", "getFocusTime", "setFocusTime", "", "isValid", "()Z", "setValid", "(Z)V", "", "sessionId", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "startTime", "getStartTime", "setStartTime", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SessionModel.kt */
public final class SessionModel extends Model {
    public SessionModel() {
        super((Model) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public final String getSessionId() {
        return Model.getStringProperty$default(this, "sessionId", (Function0) null, 2, (Object) null);
    }

    public final void setSessionId(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        Model.setStringProperty$default(this, "sessionId", str, (String) null, false, 12, (Object) null);
    }

    public final boolean isValid() {
        return getBooleanProperty("isValid", SessionModel$isValid$2.INSTANCE);
    }

    public final void setValid(boolean z) {
        Model.setBooleanProperty$default(this, "isValid", z, (String) null, false, 12, (Object) null);
    }

    public final long getStartTime() {
        return getLongProperty("startTime", SessionModel$startTime$2.INSTANCE);
    }

    public final void setStartTime(long j) {
        Model.setLongProperty$default(this, "startTime", j, (String) null, false, 12, (Object) null);
    }

    public final long getFocusTime() {
        return getLongProperty("focusTime", SessionModel$focusTime$2.INSTANCE);
    }

    public final void setFocusTime(long j) {
        Model.setLongProperty$default(this, "focusTime", j, (String) null, false, 12, (Object) null);
    }

    public final long getActiveDuration() {
        return getLongProperty("activeDuration", SessionModel$activeDuration$2.INSTANCE);
    }

    public final void setActiveDuration(long j) {
        Model.setLongProperty$default(this, "activeDuration", j, (String) null, false, 12, (Object) null);
    }
}
