package com.onesignal.user.internal;

import com.onesignal.common.IDManager;
import com.onesignal.common.OneSignalUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.modeling.ISingletonModelStoreChangeHandler;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.IUserManager;
import com.onesignal.user.internal.backend.IdentityConstants;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.internal.subscriptions.SubscriptionList;
import com.onesignal.user.state.IUserStateObserver;
import com.onesignal.user.state.UserState;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\b\b\u0010\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0016H\u0016J\u001c\u0010/\u001a\u00020,2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0010\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u0016H\u0016J\u0010\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020\u001bH\u0016J\u0010\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020\u0016H\u0016J\u0018\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0016H\u0016J\u001c\u00109\u001a\u00020,2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0014\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0018\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0016H\u0016J\u0018\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020A2\u0006\u0010>\u001a\u00020\u0016H\u0016J\u0010\u0010B\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0016H\u0016J\u0016\u0010C\u001a\u00020,2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00160EH\u0016J\u0010\u0010F\u001a\u00020,2\u0006\u00101\u001a\u00020\u0016H\u0016J\u0010\u0010G\u001a\u00020,2\u0006\u00103\u001a\u00020\u001bH\u0016J\u0010\u0010H\u001a\u00020,2\u0006\u00105\u001a\u00020\u0016H\u0016J\u0010\u0010I\u001a\u00020,2\u0006\u00107\u001a\u00020\u0016H\u0016J\u0016\u0010J\u001a\u00020,2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00160EH\u0016J\u0010\u0010L\u001a\u00020,2\u0006\u00108\u001a\u00020\u0016H\u0016R\u0014\u0010\r\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00158F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006M"}, d2 = {"Lcom/onesignal/user/internal/UserManager;", "Lcom/onesignal/user/IUserManager;", "Lcom/onesignal/common/modeling/ISingletonModelStoreChangeHandler;", "Lcom/onesignal/user/internal/identity/IdentityModel;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "_languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "(Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/core/internal/language/ILanguageContext;)V", "_identityModel", "get_identityModel", "()Lcom/onesignal/user/internal/identity/IdentityModel;", "_propertiesModel", "Lcom/onesignal/user/internal/properties/PropertiesModel;", "get_propertiesModel", "()Lcom/onesignal/user/internal/properties/PropertiesModel;", "aliases", "", "", "getAliases", "()Ljava/util/Map;", "changeHandlersNotifier", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/user/state/IUserStateObserver;", "getChangeHandlersNotifier", "()Lcom/onesignal/common/events/EventProducer;", "externalId", "getExternalId", "()Ljava/lang/String;", "onesignalId", "getOnesignalId", "pushSubscription", "Lcom/onesignal/user/subscriptions/IPushSubscription;", "getPushSubscription", "()Lcom/onesignal/user/subscriptions/IPushSubscription;", "subscriptions", "Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "getSubscriptions", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "addAlias", "", "label", "id", "addAliases", "addEmail", "email", "addObserver", "observer", "addSms", "sms", "addTag", "key", "value", "addTags", "tags", "getTags", "onModelReplaced", "model", "tag", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "removeAlias", "removeAliases", "labels", "", "removeEmail", "removeObserver", "removeSms", "removeTag", "removeTags", "keys", "setLanguage", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: UserManager.kt */
public class UserManager implements IUserManager, ISingletonModelStoreChangeHandler<IdentityModel> {
    private final IdentityModelStore _identityModelStore;
    private final ILanguageContext _languageContext;
    private final PropertiesModelStore _propertiesModelStore;
    private final ISubscriptionManager _subscriptionManager;
    private final EventProducer<IUserStateObserver> changeHandlersNotifier = new EventProducer<>();

    public final EventProducer<IUserStateObserver> getChangeHandlersNotifier() {
        return this.changeHandlersNotifier;
    }

    public void onModelReplaced(IdentityModel identityModel, String str) {
        Intrinsics.checkNotNullParameter(identityModel, "model");
        Intrinsics.checkNotNullParameter(str, "tag");
    }

    public UserManager(ISubscriptionManager iSubscriptionManager, IdentityModelStore identityModelStore, PropertiesModelStore propertiesModelStore, ILanguageContext iLanguageContext) {
        Intrinsics.checkNotNullParameter(iSubscriptionManager, "_subscriptionManager");
        Intrinsics.checkNotNullParameter(identityModelStore, "_identityModelStore");
        Intrinsics.checkNotNullParameter(propertiesModelStore, "_propertiesModelStore");
        Intrinsics.checkNotNullParameter(iLanguageContext, "_languageContext");
        this._subscriptionManager = iSubscriptionManager;
        this._identityModelStore = identityModelStore;
        this._propertiesModelStore = propertiesModelStore;
        this._languageContext = iLanguageContext;
        identityModelStore.subscribe(this);
    }

    public String getOnesignalId() {
        return IDManager.INSTANCE.isLocalId(get_identityModel().getOnesignalId()) ? "" : get_identityModel().getOnesignalId();
    }

    public String getExternalId() {
        String externalId = get_identityModel().getExternalId();
        return externalId == null ? "" : externalId;
    }

    public final Map<String, String> getAliases() {
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : get_identityModel().entrySet()) {
            if (!Intrinsics.areEqual(entry.getKey(), (Object) "id")) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return MapsKt.toMap(linkedHashMap);
    }

    public final SubscriptionList getSubscriptions() {
        return this._subscriptionManager.getSubscriptions();
    }

    public IPushSubscription getPushSubscription() {
        return this._subscriptionManager.getSubscriptions().getPush();
    }

    private final IdentityModel get_identityModel() {
        return (IdentityModel) this._identityModelStore.getModel();
    }

    private final PropertiesModel get_propertiesModel() {
        return (PropertiesModel) this._propertiesModelStore.getModel();
    }

    public void setLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this._languageContext.setLanguage(str);
    }

    public void addAlias(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(str2, "id");
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "setAlias(label: " + str + ", id: " + str2 + ')');
        if (str.length() == 0) {
            Logging.log(LogLevel.ERROR, "Cannot add empty alias");
        } else if (Intrinsics.areEqual((Object) str, (Object) IdentityConstants.ONESIGNAL_ID)) {
            Logging.log(LogLevel.ERROR, "Cannot add 'onesignal_id' alias");
        } else {
            get_identityModel().put(str, str2);
        }
    }

    public void addAliases(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "aliases");
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "addAliases(aliases: " + map);
        for (Map.Entry next : map.entrySet()) {
            if (((CharSequence) next.getKey()).length() == 0) {
                Logging.log(LogLevel.ERROR, "Cannot add empty alias");
                return;
            } else if (Intrinsics.areEqual(next.getKey(), (Object) IdentityConstants.ONESIGNAL_ID)) {
                Logging.log(LogLevel.ERROR, "Cannot add 'onesignal_id' alias");
                return;
            }
        }
        for (Map.Entry next2 : map.entrySet()) {
            get_identityModel().put(next2.getKey(), next2.getValue());
        }
    }

    public void removeAlias(String str) {
        Intrinsics.checkNotNullParameter(str, "label");
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "removeAlias(label: " + str + ')');
        if (str.length() == 0) {
            Logging.log(LogLevel.ERROR, "Cannot remove empty alias");
        } else if (Intrinsics.areEqual((Object) str, (Object) IdentityConstants.ONESIGNAL_ID)) {
            Logging.log(LogLevel.ERROR, "Cannot remove 'onesignal_id' alias");
        } else {
            get_identityModel().remove((Object) str);
        }
    }

    public void removeAliases(Collection<String> collection) {
        Intrinsics.checkNotNullParameter(collection, "labels");
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "removeAliases(labels: " + collection + ')');
        Iterable<String> iterable = collection;
        for (String str : iterable) {
            if (str.length() == 0) {
                Logging.log(LogLevel.ERROR, "Cannot remove empty alias");
                return;
            } else if (Intrinsics.areEqual((Object) str, (Object) IdentityConstants.ONESIGNAL_ID)) {
                Logging.log(LogLevel.ERROR, "Cannot remove 'onesignal_id' alias");
                return;
            }
        }
        for (String remove : iterable) {
            get_identityModel().remove((Object) remove);
        }
    }

    public void addEmail(String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "addEmail(email: " + str + ')');
        if (!OneSignalUtils.INSTANCE.isValidEmail(str)) {
            LogLevel logLevel2 = LogLevel.ERROR;
            Logging.log(logLevel2, "Cannot add invalid email address as subscription: " + str);
            return;
        }
        this._subscriptionManager.addEmailSubscription(str);
    }

    public void removeEmail(String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "removeEmail(email: " + str + ')');
        if (!OneSignalUtils.INSTANCE.isValidEmail(str)) {
            LogLevel logLevel2 = LogLevel.ERROR;
            Logging.log(logLevel2, "Cannot remove invalid email address as subscription: " + str);
            return;
        }
        this._subscriptionManager.removeEmailSubscription(str);
    }

    public void addSms(String str) {
        Intrinsics.checkNotNullParameter(str, "sms");
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "addSms(sms: " + str + ')');
        if (!OneSignalUtils.INSTANCE.isValidPhoneNumber(str)) {
            LogLevel logLevel2 = LogLevel.ERROR;
            Logging.log(logLevel2, "Cannot add invalid sms number as subscription: " + str);
            return;
        }
        this._subscriptionManager.addSmsSubscription(str);
    }

    public void removeSms(String str) {
        Intrinsics.checkNotNullParameter(str, "sms");
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "removeSms(sms: " + str + ')');
        if (!OneSignalUtils.INSTANCE.isValidPhoneNumber(str)) {
            LogLevel logLevel2 = LogLevel.ERROR;
            Logging.log(logLevel2, "Cannot remove invalid sms number as subscription: " + str);
            return;
        }
        this._subscriptionManager.removeSmsSubscription(str);
    }

    public void addTag(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        Intrinsics.checkNotNullParameter(str2, "value");
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "setTag(key: " + str + ", value: " + str2 + ')');
        if (str.length() == 0) {
            Logging.log(LogLevel.ERROR, "Cannot add tag with empty key");
        } else {
            get_propertiesModel().getTags().put(str, str2);
        }
    }

    public void addTags(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "tags");
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "setTags(tags: " + map + ')');
        for (Map.Entry<String, String> key : map.entrySet()) {
            if (((CharSequence) key.getKey()).length() == 0) {
                Logging.log(LogLevel.ERROR, "Cannot add tag with empty key");
                return;
            }
        }
        for (Map.Entry next : map.entrySet()) {
            get_propertiesModel().getTags().put(next.getKey(), next.getValue());
        }
    }

    public void removeTag(String str) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "removeTag(key: " + str + ')');
        if (str.length() == 0) {
            Logging.log(LogLevel.ERROR, "Cannot remove tag with empty key");
        } else {
            get_propertiesModel().getTags().remove((Object) str);
        }
    }

    public void removeTags(Collection<String> collection) {
        Intrinsics.checkNotNullParameter(collection, "keys");
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "removeTags(keys: " + collection + ')');
        Iterable<String> iterable = collection;
        for (String length : iterable) {
            if (length.length() == 0) {
                Logging.log(LogLevel.ERROR, "Cannot remove tag with empty key");
                return;
            }
        }
        for (String remove : iterable) {
            get_propertiesModel().getTags().remove((Object) remove);
        }
    }

    public Map<String, String> getTags() {
        return MapsKt.toMap(get_propertiesModel().getTags());
    }

    public void addObserver(IUserStateObserver iUserStateObserver) {
        Intrinsics.checkNotNullParameter(iUserStateObserver, "observer");
        this.changeHandlersNotifier.subscribe(iUserStateObserver);
    }

    public void removeObserver(IUserStateObserver iUserStateObserver) {
        Intrinsics.checkNotNullParameter(iUserStateObserver, "observer");
        this.changeHandlersNotifier.unsubscribe(iUserStateObserver);
    }

    public void onModelUpdated(ModelChangedArgs modelChangedArgs, String str) {
        Intrinsics.checkNotNullParameter(modelChangedArgs, "args");
        Intrinsics.checkNotNullParameter(str, "tag");
        if (Intrinsics.areEqual((Object) modelChangedArgs.getProperty(), (Object) IdentityConstants.ONESIGNAL_ID)) {
            this.changeHandlersNotifier.fire(new UserManager$onModelUpdated$1(new UserState(String.valueOf(modelChangedArgs.getNewValue()), getExternalId())));
        }
    }
}
