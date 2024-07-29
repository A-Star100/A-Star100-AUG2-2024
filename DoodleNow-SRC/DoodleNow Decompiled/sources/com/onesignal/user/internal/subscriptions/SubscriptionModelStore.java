package com.onesignal.user.internal.subscriptions;

import com.onesignal.common.modeling.ModelChangeTags;
import com.onesignal.common.modeling.SimpleModelStore;
import com.onesignal.core.internal.preferences.IPreferencesService;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "Lcom/onesignal/common/modeling/SimpleModelStore;", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "replaceAll", "", "models", "", "tag", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriptionModelStore.kt */
public class SubscriptionModelStore extends SimpleModelStore<SubscriptionModel> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionModelStore(IPreferencesService iPreferencesService) {
        super(AnonymousClass1.INSTANCE, "subscriptions", iPreferencesService);
        Intrinsics.checkNotNullParameter(iPreferencesService, "prefs");
    }

    public void replaceAll(List<SubscriptionModel> list, String str) {
        Intrinsics.checkNotNullParameter(list, "models");
        Intrinsics.checkNotNullParameter(str, "tag");
        if (!Intrinsics.areEqual((Object) str, (Object) ModelChangeTags.HYDRATE)) {
            super.replaceAll(list, str);
            return;
        }
        synchronized (list) {
            Iterator<SubscriptionModel> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SubscriptionModel next = it.next();
                if (next.getType() == SubscriptionType.PUSH) {
                    SubscriptionModel subscriptionModel = (SubscriptionModel) get(next.getId());
                    if (subscriptionModel != null) {
                        next.setSdk(subscriptionModel.getSdk());
                        next.setDeviceOS(subscriptionModel.getDeviceOS());
                        next.setCarrier(subscriptionModel.getCarrier());
                        next.setAppVersion(subscriptionModel.getAppVersion());
                        next.setStatus(subscriptionModel.getStatus());
                    }
                }
            }
            super.replaceAll(list, str);
            Unit unit = Unit.INSTANCE;
        }
    }
}
