package com.onesignal.user.internal.subscriptions;

import com.onesignal.user.subscriptions.IEmailSubscription;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.onesignal.user.subscriptions.ISmsSubscription;
import com.onesignal.user.subscriptions.ISubscription;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "", "collection", "", "Lcom/onesignal/user/subscriptions/ISubscription;", "_fallbackPushSub", "Lcom/onesignal/user/subscriptions/IPushSubscription;", "(Ljava/util/List;Lcom/onesignal/user/subscriptions/IPushSubscription;)V", "getCollection", "()Ljava/util/List;", "emails", "Lcom/onesignal/user/subscriptions/IEmailSubscription;", "getEmails", "push", "getPush", "()Lcom/onesignal/user/subscriptions/IPushSubscription;", "smss", "Lcom/onesignal/user/subscriptions/ISmsSubscription;", "getSmss", "getByEmail", "email", "", "getBySMS", "sms", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriptionList.kt */
public final class SubscriptionList {
    private final IPushSubscription _fallbackPushSub;
    private final List<ISubscription> collection;

    public final List<ISubscription> getCollection() {
        return this.collection;
    }

    public SubscriptionList(List<? extends ISubscription> list, IPushSubscription iPushSubscription) {
        Intrinsics.checkNotNullParameter(list, "collection");
        Intrinsics.checkNotNullParameter(iPushSubscription, "_fallbackPushSub");
        this.collection = list;
        this._fallbackPushSub = iPushSubscription;
    }

    public final IPushSubscription getPush() {
        Collection arrayList = new ArrayList();
        for (Object next : this.collection) {
            if (next instanceof IPushSubscription) {
                arrayList.add(next);
            }
        }
        IPushSubscription iPushSubscription = (IPushSubscription) CollectionsKt.firstOrNull((List) arrayList);
        return iPushSubscription == null ? this._fallbackPushSub : iPushSubscription;
    }

    public final List<IEmailSubscription> getEmails() {
        Collection arrayList = new ArrayList();
        for (Object next : this.collection) {
            if (next instanceof IEmailSubscription) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final List<ISmsSubscription> getSmss() {
        Collection arrayList = new ArrayList();
        for (Object next : this.collection) {
            if (next instanceof ISmsSubscription) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final IEmailSubscription getByEmail(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "email");
        Iterator it = getEmails().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((IEmailSubscription) obj).getEmail(), (Object) str)) {
                break;
            }
        }
        return (IEmailSubscription) obj;
    }

    public final ISmsSubscription getBySMS(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "sms");
        Iterator it = getSmss().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((ISmsSubscription) obj).getNumber(), (Object) str)) {
                break;
            }
        }
        return (ISmsSubscription) obj;
    }
}
