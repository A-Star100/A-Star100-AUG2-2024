package com.onesignal.user.internal.properties;

import com.onesignal.common.modeling.MapModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/onesignal/common/modeling/MapModel;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PropertiesModel.kt */
final class PropertiesModel$tags$2 extends Lambda implements Function0<MapModel<String>> {
    final /* synthetic */ PropertiesModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PropertiesModel$tags$2(PropertiesModel propertiesModel) {
        super(0);
        this.this$0 = propertiesModel;
    }

    public final MapModel<String> invoke() {
        return new MapModel<>(this.this$0, "tags");
    }
}
