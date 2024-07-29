package com.onesignal.core.internal.config;

import com.onesignal.common.modeling.Model;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R$\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R$\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\f¨\u0006 "}, d2 = {"Lcom/onesignal/core/internal/config/InfluenceConfigModel;", "Lcom/onesignal/common/modeling/Model;", "parentModel", "parentProperty", "", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "value", "", "iamLimit", "getIamLimit", "()I", "setIamLimit", "(I)V", "indirectIAMAttributionWindow", "getIndirectIAMAttributionWindow", "setIndirectIAMAttributionWindow", "indirectNotificationAttributionWindow", "getIndirectNotificationAttributionWindow", "setIndirectNotificationAttributionWindow", "", "isDirectEnabled", "()Z", "setDirectEnabled", "(Z)V", "isIndirectEnabled", "setIndirectEnabled", "isUnattributedEnabled", "setUnattributedEnabled", "notificationLimit", "getNotificationLimit", "setNotificationLimit", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigModel.kt */
public final class InfluenceConfigModel extends Model {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_INDIRECT_ATTRIBUTION_WINDOW = 1440;
    public static final int DEFAULT_NOTIFICATION_LIMIT = 10;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfluenceConfigModel(Model model, String str) {
        super(model, str);
        Intrinsics.checkNotNullParameter(model, "parentModel");
        Intrinsics.checkNotNullParameter(str, "parentProperty");
    }

    public final int getIndirectNotificationAttributionWindow() {
        return getIntProperty("indirectNotificationAttributionWindow", InfluenceConfigModel$indirectNotificationAttributionWindow$2.INSTANCE);
    }

    public final void setIndirectNotificationAttributionWindow(int i) {
        Model.setIntProperty$default(this, "indirectNotificationAttributionWindow", i, (String) null, false, 12, (Object) null);
    }

    public final int getNotificationLimit() {
        return getIntProperty("notificationLimit", InfluenceConfigModel$notificationLimit$2.INSTANCE);
    }

    public final void setNotificationLimit(int i) {
        Model.setIntProperty$default(this, "notificationLimit", i, (String) null, false, 12, (Object) null);
    }

    public final int getIndirectIAMAttributionWindow() {
        return getIntProperty("indirectIAMAttributionWindow", InfluenceConfigModel$indirectIAMAttributionWindow$2.INSTANCE);
    }

    public final void setIndirectIAMAttributionWindow(int i) {
        Model.setIntProperty$default(this, "indirectIAMAttributionWindow", i, (String) null, false, 12, (Object) null);
    }

    public final int getIamLimit() {
        return getIntProperty("iamLimit", InfluenceConfigModel$iamLimit$2.INSTANCE);
    }

    public final void setIamLimit(int i) {
        Model.setIntProperty$default(this, "iamLimit", i, (String) null, false, 12, (Object) null);
    }

    public final boolean isDirectEnabled() {
        return getBooleanProperty("isDirectEnabled", InfluenceConfigModel$isDirectEnabled$2.INSTANCE);
    }

    public final void setDirectEnabled(boolean z) {
        Model.setBooleanProperty$default(this, "isDirectEnabled", z, (String) null, false, 12, (Object) null);
    }

    public final boolean isIndirectEnabled() {
        return getBooleanProperty("isIndirectEnabled", InfluenceConfigModel$isIndirectEnabled$2.INSTANCE);
    }

    public final void setIndirectEnabled(boolean z) {
        Model.setBooleanProperty$default(this, "isIndirectEnabled", z, (String) null, false, 12, (Object) null);
    }

    public final boolean isUnattributedEnabled() {
        return getBooleanProperty("isUnattributedEnabled", InfluenceConfigModel$isUnattributedEnabled$2.INSTANCE);
    }

    public final void setUnattributedEnabled(boolean z) {
        Model.setBooleanProperty$default(this, "isUnattributedEnabled", z, (String) null, false, 12, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/core/internal/config/InfluenceConfigModel$Companion;", "", "()V", "DEFAULT_INDIRECT_ATTRIBUTION_WINDOW", "", "DEFAULT_NOTIFICATION_LIMIT", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ConfigModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
