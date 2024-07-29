package com.onesignal.core.internal.config;

import com.onesignal.common.modeling.Model;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R(\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR(\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/onesignal/core/internal/config/FCMConfigModel;", "Lcom/onesignal/common/modeling/Model;", "parentModel", "parentProperty", "", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "value", "apiKey", "getApiKey", "()Ljava/lang/String;", "setApiKey", "(Ljava/lang/String;)V", "appId", "getAppId", "setAppId", "projectId", "getProjectId", "setProjectId", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigModel.kt */
public final class FCMConfigModel extends Model {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FCMConfigModel(Model model, String str) {
        super(model, str);
        Intrinsics.checkNotNullParameter(model, "parentModel");
        Intrinsics.checkNotNullParameter(str, "parentProperty");
    }

    public final String getProjectId() {
        return getOptStringProperty("projectId", FCMConfigModel$projectId$2.INSTANCE);
    }

    public final void setProjectId(String str) {
        Model.setOptStringProperty$default(this, "projectId", str, (String) null, false, 12, (Object) null);
    }

    public final String getAppId() {
        return getOptStringProperty("appId", FCMConfigModel$appId$2.INSTANCE);
    }

    public final void setAppId(String str) {
        Model.setOptStringProperty$default(this, "appId", str, (String) null, false, 12, (Object) null);
    }

    public final String getApiKey() {
        return getOptStringProperty("apiKey", FCMConfigModel$apiKey$2.INSTANCE);
    }

    public final void setApiKey(String str) {
        Model.setOptStringProperty$default(this, "apiKey", str, (String) null, false, 12, (Object) null);
    }
}
