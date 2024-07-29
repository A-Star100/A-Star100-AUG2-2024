package com.onesignal.internal;

import android.os.Build;
import com.onesignal.IOneSignal;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.DeviceUtils;
import com.onesignal.common.IDManager;
import com.onesignal.common.OneSignalUtils;
import com.onesignal.common.modeling.IModelStore;
import com.onesignal.common.modeling.ISingletonModelStore;
import com.onesignal.common.modeling.ModelChangeTags;
import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.IServiceProvider;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.common.services.ServiceProvider;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.CoreModule;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.startup.StartupService;
import com.onesignal.debug.IDebugManager;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.DebugManager;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.onesignal.location.ILocationManager;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.session.ISessionManager;
import com.onesignal.session.SessionModule;
import com.onesignal.session.internal.session.SessionModel;
import com.onesignal.user.IUserManager;
import com.onesignal.user.UserModule;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.LoginUserOperation;
import com.onesignal.user.internal.operations.TransferSubscriptionOperation;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003JN\u0010O\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020\u00052:\b\u0002\u0010R\u001a4\u0012\u0013\u0012\u00110T¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(W\u0012\u0013\u0012\u00110X¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(Y\u0012\u0004\u0012\u00020P\u0018\u00010SH\u0002J\"\u0010Z\u001a\b\u0012\u0004\u0012\u0002H[0/\"\u0004\b\u0000\u0010[2\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002H[0]H\u0016J!\u0010^\u001a\u0002H[\"\u0004\b\u0000\u0010[2\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002H[0]H\u0016¢\u0006\u0002\u0010_J#\u0010`\u001a\u0004\u0018\u0001H[\"\u0004\b\u0000\u0010[2\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002H[0]H\u0016¢\u0006\u0002\u0010_J\u001c\u0010a\u001a\u00020\u0005\"\u0004\b\u0000\u0010[2\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002H[0]H\u0016J\u001a\u0010b\u001a\u00020\u00052\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u000100H\u0016J\u001a\u0010f\u001a\u00020P2\u0006\u0010g\u001a\u0002002\b\u0010h\u001a\u0004\u0018\u000100H\u0016J\b\u0010i\u001a\u00020PH\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058V@VX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058V@VX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058V@VX\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u000200XD¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020BX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0010\u0010F\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\bM\u0010N¨\u0006j"}, d2 = {"Lcom/onesignal/internal/OneSignalImp;", "Lcom/onesignal/IOneSignal;", "Lcom/onesignal/common/services/IServiceProvider;", "()V", "_consentGiven", "", "Ljava/lang/Boolean;", "_consentRequired", "_disableGMSMissingPrompt", "_location", "Lcom/onesignal/location/ILocationManager;", "_notifications", "Lcom/onesignal/notifications/INotificationsManager;", "_session", "Lcom/onesignal/session/ISessionManager;", "_user", "Lcom/onesignal/user/IUserManager;", "configModel", "Lcom/onesignal/core/internal/config/ConfigModel;", "value", "consentGiven", "getConsentGiven", "()Z", "setConsentGiven", "(Z)V", "consentRequired", "getConsentRequired", "setConsentRequired", "debug", "Lcom/onesignal/debug/IDebugManager;", "getDebug", "()Lcom/onesignal/debug/IDebugManager;", "disableGMSMissingPrompt", "getDisableGMSMissingPrompt", "setDisableGMSMissingPrompt", "iam", "Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "inAppMessages", "getInAppMessages", "()Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "initLock", "", "isInitialized", "setInitialized", "listOfModules", "", "", "location", "getLocation", "()Lcom/onesignal/location/ILocationManager;", "loginLock", "notifications", "getNotifications", "()Lcom/onesignal/notifications/INotificationsManager;", "operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "preferencesService", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "sdkVersion", "getSdkVersion", "()Ljava/lang/String;", "services", "Lcom/onesignal/common/services/ServiceProvider;", "session", "getSession", "()Lcom/onesignal/session/ISessionManager;", "sessionModel", "Lcom/onesignal/session/internal/session/SessionModel;", "startupService", "Lcom/onesignal/core/internal/startup/StartupService;", "subscriptionModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "user", "getUser", "()Lcom/onesignal/user/IUserManager;", "createAndSwitchToNewUser", "", "suppressBackendOperation", "modify", "Lkotlin/Function2;", "Lcom/onesignal/user/internal/identity/IdentityModel;", "Lkotlin/ParameterName;", "name", "identityModel", "Lcom/onesignal/user/internal/properties/PropertiesModel;", "propertiesModel", "getAllServices", "T", "c", "Ljava/lang/Class;", "getService", "(Ljava/lang/Class;)Ljava/lang/Object;", "getServiceOrNull", "hasService", "initWithContext", "context", "Landroid/content/Context;", "appId", "login", "externalId", "jwtBearerToken", "logout", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OneSignalImp.kt */
public final class OneSignalImp implements IOneSignal, IServiceProvider {
    private Boolean _consentGiven;
    private Boolean _consentRequired;
    private Boolean _disableGMSMissingPrompt;
    private ILocationManager _location;
    private INotificationsManager _notifications;
    private ISessionManager _session;
    private IUserManager _user;
    /* access modifiers changed from: private */
    public ConfigModel configModel;
    private final IDebugManager debug = new DebugManager();
    private IInAppMessagesManager iam;
    private IdentityModelStore identityModelStore;
    private final Object initLock = new Object();
    private boolean isInitialized;
    private final List<String> listOfModules;
    private final Object loginLock = new Object();
    /* access modifiers changed from: private */
    public IOperationRepo operationRepo;
    private IPreferencesService preferencesService;
    private PropertiesModelStore propertiesModelStore;
    private final String sdkVersion = OneSignalUtils.SDK_VERSION;
    private final ServiceProvider services;
    private SessionModel sessionModel;
    private StartupService startupService;
    private SubscriptionModelStore subscriptionModelStore;

    public IDebugManager getDebug() {
        return this.debug;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public boolean isInitialized() {
        return this.isInitialized;
    }

    public void setInitialized(boolean z) {
        this.isInitialized = z;
    }

    public OneSignalImp() {
        List<String> listOf = CollectionsKt.listOf("com.onesignal.notifications.NotificationsModule", "com.onesignal.inAppMessages.InAppMessagesModule", "com.onesignal.location.LocationModule");
        this.listOfModules = listOf;
        ServiceBuilder serviceBuilder = new ServiceBuilder();
        List<IModule> arrayList = new ArrayList<>();
        arrayList.add(new CoreModule());
        arrayList.add(new SessionModule());
        arrayList.add(new UserModule());
        for (String cls : listOf) {
            try {
                Object newInstance = Class.forName(cls).newInstance();
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.onesignal.common.modules.IModule");
                arrayList.add((IModule) newInstance);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        for (IModule register : arrayList) {
            register.register(serviceBuilder);
        }
        this.services = serviceBuilder.build();
    }

    public void login(String str) {
        IOneSignal.DefaultImpls.login(this, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getConsentRequired();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean getConsentRequired() {
        /*
            r2 = this;
            com.onesignal.core.internal.config.ConfigModel r0 = r2.configModel
            if (r0 == 0) goto L_0x000f
            java.lang.Boolean r0 = r0.getConsentRequired()
            if (r0 == 0) goto L_0x000f
            boolean r0 = r0.booleanValue()
            goto L_0x001a
        L_0x000f:
            java.lang.Boolean r0 = r2._consentRequired
            r1 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.internal.OneSignalImp.getConsentRequired():boolean");
    }

    public void setConsentRequired(boolean z) {
        this._consentRequired = Boolean.valueOf(z);
        ConfigModel configModel2 = this.configModel;
        if (configModel2 != null) {
            configModel2.setConsentRequired(Boolean.valueOf(z));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getConsentGiven();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean getConsentGiven() {
        /*
            r2 = this;
            com.onesignal.core.internal.config.ConfigModel r0 = r2.configModel
            if (r0 == 0) goto L_0x000f
            java.lang.Boolean r0 = r0.getConsentGiven()
            if (r0 == 0) goto L_0x000f
            boolean r0 = r0.booleanValue()
            goto L_0x001a
        L_0x000f:
            java.lang.Boolean r0 = r2._consentGiven
            r1 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.internal.OneSignalImp.getConsentGiven():boolean");
    }

    public void setConsentGiven(boolean z) {
        IOperationRepo iOperationRepo;
        Boolean bool = this._consentGiven;
        this._consentGiven = Boolean.valueOf(z);
        ConfigModel configModel2 = this.configModel;
        if (configModel2 != null) {
            configModel2.setConsentGiven(Boolean.valueOf(z));
        }
        if (!Intrinsics.areEqual((Object) bool, (Object) Boolean.valueOf(z)) && z && (iOperationRepo = this.operationRepo) != null) {
            iOperationRepo.forceExecuteOperations();
        }
    }

    public boolean getDisableGMSMissingPrompt() {
        ConfigModel configModel2 = this.configModel;
        return configModel2 != null ? configModel2.getDisableGMSMissingPrompt() : Intrinsics.areEqual((Object) this._disableGMSMissingPrompt, (Object) true);
    }

    public void setDisableGMSMissingPrompt(boolean z) {
        this._disableGMSMissingPrompt = Boolean.valueOf(z);
        ConfigModel configModel2 = this.configModel;
        if (configModel2 != null) {
            configModel2.setDisableGMSMissingPrompt(z);
        }
    }

    public ISessionManager getSession() {
        if (isInitialized()) {
            ISessionManager iSessionManager = this._session;
            Intrinsics.checkNotNull(iSessionManager);
            return iSessionManager;
        }
        throw new Exception("Must call 'initWithContext' before use");
    }

    public INotificationsManager getNotifications() {
        if (isInitialized()) {
            INotificationsManager iNotificationsManager = this._notifications;
            Intrinsics.checkNotNull(iNotificationsManager);
            return iNotificationsManager;
        }
        throw new Exception("Must call 'initWithContext' before use");
    }

    public ILocationManager getLocation() {
        if (isInitialized()) {
            ILocationManager iLocationManager = this._location;
            Intrinsics.checkNotNull(iLocationManager);
            return iLocationManager;
        }
        throw new Exception("Must call 'initWithContext' before use");
    }

    public IInAppMessagesManager getInAppMessages() {
        if (isInitialized()) {
            IInAppMessagesManager iInAppMessagesManager = this.iam;
            Intrinsics.checkNotNull(iInAppMessagesManager);
            return iInAppMessagesManager;
        }
        throw new Exception("Must call 'initWithContext' before use");
    }

    public IUserManager getUser() {
        if (isInitialized()) {
            IUserManager iUserManager = this._user;
            Intrinsics.checkNotNull(iUserManager);
            return iUserManager;
        }
        throw new Exception("Must call 'initWithContext' before use");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0260, code lost:
        if (r0.intValue() != r7) goto L_0x0262;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x026f, code lost:
        if (r0.intValue() != r7) goto L_0x0271;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0273, code lost:
        r7 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean initWithContext(android.content.Context r14, java.lang.String r15) {
        /*
            r13 = this;
            java.lang.String r0 = "initWithContext: using cached user "
            java.lang.String r1 = "initWithContext: creating user linked to subscription "
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r2)
            com.onesignal.debug.LogLevel r2 = com.onesignal.debug.LogLevel.DEBUG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "initWithContext(context: "
            r3.<init>(r4)
            r3.append(r14)
            java.lang.String r4 = ", appId: "
            r3.append(r4)
            r3.append(r15)
            r4 = 41
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.onesignal.debug.internal.logging.Logging.log(r2, r3)
            java.lang.Object r2 = r13.initLock
            monitor-enter(r2)
            boolean r3 = r13.isInitialized()     // Catch:{ all -> 0x033c }
            r4 = 1
            if (r3 == 0) goto L_0x003c
            com.onesignal.debug.LogLevel r14 = com.onesignal.debug.LogLevel.DEBUG     // Catch:{ all -> 0x033c }
            java.lang.String r15 = "initWithContext: SDK already initialized"
            com.onesignal.debug.internal.logging.Logging.log(r14, r15)     // Catch:{ all -> 0x033c }
            monitor-exit(r2)
            return r4
        L_0x003c:
            com.onesignal.debug.LogLevel r3 = com.onesignal.debug.LogLevel.DEBUG     // Catch:{ all -> 0x033c }
            java.lang.String r5 = "initWithContext: SDK initializing"
            com.onesignal.debug.internal.logging.Logging.log(r3, r5)     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.preferences.PreferenceStoreFix r3 = com.onesignal.core.internal.preferences.PreferenceStoreFix.INSTANCE     // Catch:{ all -> 0x033c }
            r3.ensureNoObfuscatedPrefStore(r14)     // Catch:{ all -> 0x033c }
            com.onesignal.common.services.ServiceProvider r3 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.core.internal.application.IApplicationService> r5 = com.onesignal.core.internal.application.IApplicationService.class
            java.lang.Object r3 = r3.getService(r5)     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.application.IApplicationService r3 = (com.onesignal.core.internal.application.IApplicationService) r3     // Catch:{ all -> 0x033c }
            java.lang.String r5 = "null cannot be cast to non-null type com.onesignal.core.internal.application.impl.ApplicationService"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r5)     // Catch:{ all -> 0x033c }
            r5 = r3
            com.onesignal.core.internal.application.impl.ApplicationService r5 = (com.onesignal.core.internal.application.impl.ApplicationService) r5     // Catch:{ all -> 0x033c }
            r5.start(r14)     // Catch:{ all -> 0x033c }
            com.onesignal.debug.internal.logging.Logging r14 = com.onesignal.debug.internal.logging.Logging.INSTANCE     // Catch:{ all -> 0x033c }
            r14.setApplicationService(r3)     // Catch:{ all -> 0x033c }
            com.onesignal.common.services.ServiceProvider r14 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.core.internal.config.ConfigModelStore> r3 = com.onesignal.core.internal.config.ConfigModelStore.class
            java.lang.Object r14 = r14.getService(r3)     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.config.ConfigModelStore r14 = (com.onesignal.core.internal.config.ConfigModelStore) r14     // Catch:{ all -> 0x033c }
            com.onesignal.common.modeling.Model r14 = r14.getModel()     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.config.ConfigModel r14 = (com.onesignal.core.internal.config.ConfigModel) r14     // Catch:{ all -> 0x033c }
            r13.configModel = r14     // Catch:{ all -> 0x033c }
            com.onesignal.common.services.ServiceProvider r14 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.session.internal.session.SessionModelStore> r3 = com.onesignal.session.internal.session.SessionModelStore.class
            java.lang.Object r14 = r14.getService(r3)     // Catch:{ all -> 0x033c }
            com.onesignal.session.internal.session.SessionModelStore r14 = (com.onesignal.session.internal.session.SessionModelStore) r14     // Catch:{ all -> 0x033c }
            com.onesignal.common.modeling.Model r14 = r14.getModel()     // Catch:{ all -> 0x033c }
            com.onesignal.session.internal.session.SessionModel r14 = (com.onesignal.session.internal.session.SessionModel) r14     // Catch:{ all -> 0x033c }
            r13.sessionModel = r14     // Catch:{ all -> 0x033c }
            r14 = 2
            r3 = 0
            r5 = 0
            if (r15 != 0) goto L_0x009f
            com.onesignal.core.internal.config.ConfigModel r6 = r13.configModel     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ all -> 0x033c }
            java.lang.String r7 = "appId"
            boolean r6 = r6.hasProperty(r7)     // Catch:{ all -> 0x033c }
            if (r6 != 0) goto L_0x009f
            java.lang.String r15 = "initWithContext called without providing appId, and no appId has been established!"
            com.onesignal.debug.internal.logging.Logging.warn$default(r15, r5, r14, r5)     // Catch:{ all -> 0x033c }
            monitor-exit(r2)
            return r3
        L_0x009f:
            if (r15 == 0) goto L_0x00ca
            com.onesignal.core.internal.config.ConfigModel r6 = r13.configModel     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ all -> 0x033c }
            java.lang.String r7 = "appId"
            boolean r6 = r6.hasProperty(r7)     // Catch:{ all -> 0x033c }
            if (r6 == 0) goto L_0x00c0
            com.onesignal.core.internal.config.ConfigModel r6 = r13.configModel     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ all -> 0x033c }
            java.lang.String r6 = r6.getAppId()     // Catch:{ all -> 0x033c }
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r15)     // Catch:{ all -> 0x033c }
            if (r6 != 0) goto L_0x00be
            goto L_0x00c0
        L_0x00be:
            r6 = r3
            goto L_0x00c1
        L_0x00c0:
            r6 = r4
        L_0x00c1:
            com.onesignal.core.internal.config.ConfigModel r7 = r13.configModel     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x033c }
            r7.setAppId(r15)     // Catch:{ all -> 0x033c }
            goto L_0x00cb
        L_0x00ca:
            r6 = r3
        L_0x00cb:
            java.lang.Boolean r15 = r13._consentRequired     // Catch:{ all -> 0x033c }
            if (r15 == 0) goto L_0x00dc
            com.onesignal.core.internal.config.ConfigModel r15 = r13.configModel     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)     // Catch:{ all -> 0x033c }
            java.lang.Boolean r7 = r13._consentRequired     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x033c }
            r15.setConsentRequired(r7)     // Catch:{ all -> 0x033c }
        L_0x00dc:
            java.lang.Boolean r15 = r13._consentGiven     // Catch:{ all -> 0x033c }
            if (r15 == 0) goto L_0x00ed
            com.onesignal.core.internal.config.ConfigModel r15 = r13.configModel     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)     // Catch:{ all -> 0x033c }
            java.lang.Boolean r7 = r13._consentGiven     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x033c }
            r15.setConsentGiven(r7)     // Catch:{ all -> 0x033c }
        L_0x00ed:
            java.lang.Boolean r15 = r13._disableGMSMissingPrompt     // Catch:{ all -> 0x033c }
            if (r15 == 0) goto L_0x0102
            com.onesignal.core.internal.config.ConfigModel r15 = r13.configModel     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)     // Catch:{ all -> 0x033c }
            java.lang.Boolean r7 = r13._disableGMSMissingPrompt     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x033c }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x033c }
            r15.setDisableGMSMissingPrompt(r7)     // Catch:{ all -> 0x033c }
        L_0x0102:
            com.onesignal.common.services.ServiceProvider r15 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.location.ILocationManager> r7 = com.onesignal.location.ILocationManager.class
            java.lang.Object r15 = r15.getService(r7)     // Catch:{ all -> 0x033c }
            com.onesignal.location.ILocationManager r15 = (com.onesignal.location.ILocationManager) r15     // Catch:{ all -> 0x033c }
            r13._location = r15     // Catch:{ all -> 0x033c }
            com.onesignal.common.services.ServiceProvider r15 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.user.IUserManager> r7 = com.onesignal.user.IUserManager.class
            java.lang.Object r15 = r15.getService(r7)     // Catch:{ all -> 0x033c }
            com.onesignal.user.IUserManager r15 = (com.onesignal.user.IUserManager) r15     // Catch:{ all -> 0x033c }
            r13._user = r15     // Catch:{ all -> 0x033c }
            com.onesignal.common.services.ServiceProvider r15 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.session.ISessionManager> r7 = com.onesignal.session.ISessionManager.class
            java.lang.Object r15 = r15.getService(r7)     // Catch:{ all -> 0x033c }
            com.onesignal.session.ISessionManager r15 = (com.onesignal.session.ISessionManager) r15     // Catch:{ all -> 0x033c }
            r13._session = r15     // Catch:{ all -> 0x033c }
            com.onesignal.common.services.ServiceProvider r15 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.inAppMessages.IInAppMessagesManager> r7 = com.onesignal.inAppMessages.IInAppMessagesManager.class
            java.lang.Object r15 = r15.getService(r7)     // Catch:{ all -> 0x033c }
            com.onesignal.inAppMessages.IInAppMessagesManager r15 = (com.onesignal.inAppMessages.IInAppMessagesManager) r15     // Catch:{ all -> 0x033c }
            r13.iam = r15     // Catch:{ all -> 0x033c }
            com.onesignal.common.services.ServiceProvider r15 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.notifications.INotificationsManager> r7 = com.onesignal.notifications.INotificationsManager.class
            java.lang.Object r15 = r15.getService(r7)     // Catch:{ all -> 0x033c }
            com.onesignal.notifications.INotificationsManager r15 = (com.onesignal.notifications.INotificationsManager) r15     // Catch:{ all -> 0x033c }
            r13._notifications = r15     // Catch:{ all -> 0x033c }
            com.onesignal.common.services.ServiceProvider r15 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.core.internal.operations.IOperationRepo> r7 = com.onesignal.core.internal.operations.IOperationRepo.class
            java.lang.Object r15 = r15.getService(r7)     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.operations.IOperationRepo r15 = (com.onesignal.core.internal.operations.IOperationRepo) r15     // Catch:{ all -> 0x033c }
            r13.operationRepo = r15     // Catch:{ all -> 0x033c }
            com.onesignal.common.services.ServiceProvider r15 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.user.internal.properties.PropertiesModelStore> r7 = com.onesignal.user.internal.properties.PropertiesModelStore.class
            java.lang.Object r15 = r15.getService(r7)     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.properties.PropertiesModelStore r15 = (com.onesignal.user.internal.properties.PropertiesModelStore) r15     // Catch:{ all -> 0x033c }
            r13.propertiesModelStore = r15     // Catch:{ all -> 0x033c }
            com.onesignal.common.services.ServiceProvider r15 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.user.internal.identity.IdentityModelStore> r7 = com.onesignal.user.internal.identity.IdentityModelStore.class
            java.lang.Object r15 = r15.getService(r7)     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.identity.IdentityModelStore r15 = (com.onesignal.user.internal.identity.IdentityModelStore) r15     // Catch:{ all -> 0x033c }
            r13.identityModelStore = r15     // Catch:{ all -> 0x033c }
            com.onesignal.common.services.ServiceProvider r15 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.user.internal.subscriptions.SubscriptionModelStore> r7 = com.onesignal.user.internal.subscriptions.SubscriptionModelStore.class
            java.lang.Object r15 = r15.getService(r7)     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.subscriptions.SubscriptionModelStore r15 = (com.onesignal.user.internal.subscriptions.SubscriptionModelStore) r15     // Catch:{ all -> 0x033c }
            r13.subscriptionModelStore = r15     // Catch:{ all -> 0x033c }
            com.onesignal.common.services.ServiceProvider r15 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.core.internal.preferences.IPreferencesService> r7 = com.onesignal.core.internal.preferences.IPreferencesService.class
            java.lang.Object r15 = r15.getService(r7)     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.preferences.IPreferencesService r15 = (com.onesignal.core.internal.preferences.IPreferencesService) r15     // Catch:{ all -> 0x033c }
            r13.preferencesService = r15     // Catch:{ all -> 0x033c }
            com.onesignal.common.services.ServiceProvider r15 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.core.internal.startup.StartupService> r7 = com.onesignal.core.internal.startup.StartupService.class
            java.lang.Object r15 = r15.getService(r7)     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.startup.StartupService r15 = (com.onesignal.core.internal.startup.StartupService) r15     // Catch:{ all -> 0x033c }
            r13.startupService = r15     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)     // Catch:{ all -> 0x033c }
            r15.bootstrap()     // Catch:{ all -> 0x033c }
            if (r6 != 0) goto L_0x01c2
            com.onesignal.user.internal.identity.IdentityModelStore r15 = r13.identityModelStore     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)     // Catch:{ all -> 0x033c }
            com.onesignal.common.modeling.Model r15 = r15.getModel()     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.identity.IdentityModel r15 = (com.onesignal.user.internal.identity.IdentityModel) r15     // Catch:{ all -> 0x033c }
            java.lang.String r6 = "onesignal_id"
            boolean r15 = r15.hasProperty(r6)     // Catch:{ all -> 0x033c }
            if (r15 != 0) goto L_0x01a2
            goto L_0x01c2
        L_0x01a2:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x033c }
            r15.<init>(r0)     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.identity.IdentityModelStore r0 = r13.identityModelStore     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x033c }
            com.onesignal.common.modeling.Model r0 = r0.getModel()     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.identity.IdentityModel r0 = (com.onesignal.user.internal.identity.IdentityModel) r0     // Catch:{ all -> 0x033c }
            java.lang.String r0 = r0.getOnesignalId()     // Catch:{ all -> 0x033c }
            r15.append(r0)     // Catch:{ all -> 0x033c }
            java.lang.String r15 = r15.toString()     // Catch:{ all -> 0x033c }
            com.onesignal.debug.internal.logging.Logging.debug$default(r15, r5, r14, r5)     // Catch:{ all -> 0x033c }
            goto L_0x032f
        L_0x01c2:
            com.onesignal.core.internal.preferences.IPreferencesService r6 = r13.preferencesService     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ all -> 0x033c }
            java.lang.String r7 = "OneSignal"
            java.lang.String r8 = "GT_PLAYER_ID"
            r9 = 0
            r10 = 4
            r11 = 0
            java.lang.String r15 = com.onesignal.core.internal.preferences.IPreferencesService.DefaultImpls.getString$default(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x033c }
            if (r15 != 0) goto L_0x021a
            java.lang.String r15 = "initWithContext: creating new device-scoped user"
            com.onesignal.debug.internal.logging.Logging.debug$default(r15, r5, r14, r5)     // Catch:{ all -> 0x033c }
            r15 = 3
            createAndSwitchToNewUser$default(r13, r3, r5, r15, r5)     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.operations.IOperationRepo r15 = r13.operationRepo     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.operations.LoginUserOperation r0 = new com.onesignal.user.internal.operations.LoginUserOperation     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.config.ConfigModel r1 = r13.configModel     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x033c }
            java.lang.String r7 = r1.getAppId()     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.identity.IdentityModelStore r1 = r13.identityModelStore     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x033c }
            com.onesignal.common.modeling.Model r1 = r1.getModel()     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.identity.IdentityModel r1 = (com.onesignal.user.internal.identity.IdentityModel) r1     // Catch:{ all -> 0x033c }
            java.lang.String r8 = r1.getOnesignalId()     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.identity.IdentityModelStore r1 = r13.identityModelStore     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x033c }
            com.onesignal.common.modeling.Model r1 = r1.getModel()     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.identity.IdentityModel r1 = (com.onesignal.user.internal.identity.IdentityModel) r1     // Catch:{ all -> 0x033c }
            java.lang.String r9 = r1.getExternalId()     // Catch:{ all -> 0x033c }
            r10 = 0
            r11 = 8
            r12 = 0
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.operations.IOperationRepo.DefaultImpls.enqueue$default(r15, r0, r3, r14, r5)     // Catch:{ all -> 0x033c }
            goto L_0x032f
        L_0x021a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x033c }
            r0.<init>(r1)     // Catch:{ all -> 0x033c }
            r0.append(r15)     // Catch:{ all -> 0x033c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x033c }
            com.onesignal.debug.internal.logging.Logging.debug$default(r0, r5, r14, r5)     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.preferences.IPreferencesService r6 = r13.preferencesService     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ all -> 0x033c }
            java.lang.String r7 = "OneSignal"
            java.lang.String r8 = "ONESIGNAL_USERSTATE_SYNCVALYES_CURRENT_STATE"
            r9 = 0
            r10 = 4
            r11 = 0
            java.lang.String r0 = com.onesignal.core.internal.preferences.IPreferencesService.DefaultImpls.getString$default(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x033c }
            if (r0 == 0) goto L_0x02f8
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x033c }
            r1.<init>(r0)     // Catch:{ all -> 0x033c }
            java.lang.String r0 = "notification_types"
            java.lang.Integer r0 = com.onesignal.common.JSONObjectExtensionsKt.safeInt(r1, r0)     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.subscriptions.SubscriptionModel r6 = new com.onesignal.user.internal.subscriptions.SubscriptionModel     // Catch:{ all -> 0x033c }
            r6.<init>()     // Catch:{ all -> 0x033c }
            r6.setId(r15)     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.subscriptions.SubscriptionType r7 = com.onesignal.user.internal.subscriptions.SubscriptionType.PUSH     // Catch:{ all -> 0x033c }
            r6.setType(r7)     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r7 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.NO_PERMISSION     // Catch:{ all -> 0x033c }
            int r7 = r7.getValue()     // Catch:{ all -> 0x033c }
            if (r0 != 0) goto L_0x025c
            goto L_0x0262
        L_0x025c:
            int r8 = r0.intValue()     // Catch:{ all -> 0x033c }
            if (r8 == r7) goto L_0x0273
        L_0x0262:
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r7 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.UNSUBSCRIBE     // Catch:{ all -> 0x033c }
            int r7 = r7.getValue()     // Catch:{ all -> 0x033c }
            if (r0 != 0) goto L_0x026b
            goto L_0x0271
        L_0x026b:
            int r8 = r0.intValue()     // Catch:{ all -> 0x033c }
            if (r8 == r7) goto L_0x0273
        L_0x0271:
            r7 = r4
            goto L_0x0274
        L_0x0273:
            r7 = r3
        L_0x0274:
            r6.setOptedIn(r7)     // Catch:{ all -> 0x033c }
            java.lang.String r7 = "identifier"
            java.lang.String r1 = com.onesignal.common.JSONObjectExtensionsKt.safeString(r1, r7)     // Catch:{ all -> 0x033c }
            if (r1 != 0) goto L_0x0281
            java.lang.String r1 = ""
        L_0x0281:
            r6.setAddress(r1)     // Catch:{ all -> 0x033c }
            if (r0 == 0) goto L_0x0298
            com.onesignal.user.internal.subscriptions.SubscriptionStatus$Companion r1 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.Companion     // Catch:{ all -> 0x033c }
            int r0 = r0.intValue()     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = r1.fromInt(r0)     // Catch:{ all -> 0x033c }
            if (r0 != 0) goto L_0x0294
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.NO_PERMISSION     // Catch:{ all -> 0x033c }
        L_0x0294:
            r6.setStatus(r0)     // Catch:{ all -> 0x033c }
            goto L_0x029d
        L_0x0298:
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.SUBSCRIBED     // Catch:{ all -> 0x033c }
            r6.setStatus(r0)     // Catch:{ all -> 0x033c }
        L_0x029d:
            java.lang.String r0 = "050115"
            r6.setSdk(r0)     // Catch:{ all -> 0x033c }
            java.lang.String r0 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x033c }
            java.lang.String r1 = "RELEASE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ all -> 0x033c }
            r6.setDeviceOS(r0)     // Catch:{ all -> 0x033c }
            com.onesignal.common.DeviceUtils r0 = com.onesignal.common.DeviceUtils.INSTANCE     // Catch:{ all -> 0x033c }
            com.onesignal.common.services.ServiceProvider r1 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.core.internal.application.IApplicationService> r7 = com.onesignal.core.internal.application.IApplicationService.class
            java.lang.Object r1 = r1.getService(r7)     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.application.IApplicationService r1 = (com.onesignal.core.internal.application.IApplicationService) r1     // Catch:{ all -> 0x033c }
            android.content.Context r1 = r1.getAppContext()     // Catch:{ all -> 0x033c }
            java.lang.String r0 = r0.getCarrierName(r1)     // Catch:{ all -> 0x033c }
            if (r0 != 0) goto L_0x02c4
            java.lang.String r0 = ""
        L_0x02c4:
            r6.setCarrier(r0)     // Catch:{ all -> 0x033c }
            com.onesignal.common.AndroidUtils r0 = com.onesignal.common.AndroidUtils.INSTANCE     // Catch:{ all -> 0x033c }
            com.onesignal.common.services.ServiceProvider r1 = r13.services     // Catch:{ all -> 0x033c }
            java.lang.Class<com.onesignal.core.internal.application.IApplicationService> r7 = com.onesignal.core.internal.application.IApplicationService.class
            java.lang.Object r1 = r1.getService(r7)     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.application.IApplicationService r1 = (com.onesignal.core.internal.application.IApplicationService) r1     // Catch:{ all -> 0x033c }
            android.content.Context r1 = r1.getAppContext()     // Catch:{ all -> 0x033c }
            java.lang.String r0 = r0.getAppVersion(r1)     // Catch:{ all -> 0x033c }
            if (r0 != 0) goto L_0x02df
            java.lang.String r0 = ""
        L_0x02df:
            r6.setAppVersion(r0)     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.config.ConfigModel r0 = r13.configModel     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x033c }
            r0.setPushSubscriptionId(r15)     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.subscriptions.SubscriptionModelStore r0 = r13.subscriptionModelStore     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x033c }
            com.onesignal.common.modeling.Model r6 = (com.onesignal.common.modeling.Model) r6     // Catch:{ all -> 0x033c }
            java.lang.String r1 = "NO_PROPOGATE"
            r0.add(r6, r1)     // Catch:{ all -> 0x033c }
            r0 = r4
            goto L_0x02f9
        L_0x02f8:
            r0 = r3
        L_0x02f9:
            createAndSwitchToNewUser$default(r13, r0, r5, r14, r5)     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.operations.IOperationRepo r0 = r13.operationRepo     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation r1 = new com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.config.ConfigModel r6 = r13.configModel     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ all -> 0x033c }
            java.lang.String r6 = r6.getAppId()     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.identity.IdentityModelStore r7 = r13.identityModelStore     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x033c }
            com.onesignal.common.modeling.Model r7 = r7.getModel()     // Catch:{ all -> 0x033c }
            com.onesignal.user.internal.identity.IdentityModel r7 = (com.onesignal.user.internal.identity.IdentityModel) r7     // Catch:{ all -> 0x033c }
            java.lang.String r7 = r7.getOnesignalId()     // Catch:{ all -> 0x033c }
            r1.<init>(r6, r7, r15)     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.operations.Operation r1 = (com.onesignal.core.internal.operations.Operation) r1     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.operations.IOperationRepo.DefaultImpls.enqueue$default(r0, r1, r3, r14, r5)     // Catch:{ all -> 0x033c }
            com.onesignal.core.internal.preferences.IPreferencesService r14 = r13.preferencesService     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)     // Catch:{ all -> 0x033c }
            java.lang.String r15 = "OneSignal"
            java.lang.String r0 = "GT_PLAYER_ID"
            r14.saveString(r15, r0, r5)     // Catch:{ all -> 0x033c }
        L_0x032f:
            com.onesignal.core.internal.startup.StartupService r14 = r13.startupService     // Catch:{ all -> 0x033c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)     // Catch:{ all -> 0x033c }
            r14.start()     // Catch:{ all -> 0x033c }
            r13.setInitialized(r4)     // Catch:{ all -> 0x033c }
            monitor-exit(r2)
            return r4
        L_0x033c:
            r14 = move-exception
            monitor-exit(r2)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.internal.OneSignalImp.initWithContext(android.content.Context, java.lang.String):boolean");
    }

    public void login(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "externalId");
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "login(externalId: " + str + ", jwtBearerToken: " + str2 + ')');
        if (isInitialized()) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.element = "";
            synchronized (this.loginLock) {
                IdentityModelStore identityModelStore2 = this.identityModelStore;
                Intrinsics.checkNotNull(identityModelStore2);
                objectRef.element = ((IdentityModel) identityModelStore2.getModel()).getExternalId();
                IdentityModelStore identityModelStore3 = this.identityModelStore;
                Intrinsics.checkNotNull(identityModelStore3);
                objectRef2.element = ((IdentityModel) identityModelStore3.getModel()).getOnesignalId();
                if (!Intrinsics.areEqual((Object) objectRef.element, (Object) str)) {
                    createAndSwitchToNewUser$default(this, false, new OneSignalImp$login$1$1(str), 1, (Object) null);
                    IdentityModelStore identityModelStore4 = this.identityModelStore;
                    Intrinsics.checkNotNull(identityModelStore4);
                    objectRef3.element = ((IdentityModel) identityModelStore4.getModel()).getOnesignalId();
                    Unit unit = Unit.INSTANCE;
                    ThreadUtilsKt.suspendifyOnThread$default(0, new OneSignalImp$login$2(this, objectRef3, str, objectRef, objectRef2, (Continuation<? super OneSignalImp$login$2>) null), 1, (Object) null);
                    return;
                }
                return;
            }
        }
        throw new Exception("Must call 'initWithContext' before 'login'");
    }

    public void logout() {
        Logging.log(LogLevel.DEBUG, "logout()");
        if (isInitialized()) {
            synchronized (this.loginLock) {
                IdentityModelStore identityModelStore2 = this.identityModelStore;
                Intrinsics.checkNotNull(identityModelStore2);
                if (((IdentityModel) identityModelStore2.getModel()).getExternalId() != null) {
                    createAndSwitchToNewUser$default(this, false, (Function2) null, 3, (Object) null);
                    IOperationRepo iOperationRepo = this.operationRepo;
                    Intrinsics.checkNotNull(iOperationRepo);
                    ConfigModel configModel2 = this.configModel;
                    Intrinsics.checkNotNull(configModel2);
                    String appId = configModel2.getAppId();
                    IdentityModelStore identityModelStore3 = this.identityModelStore;
                    Intrinsics.checkNotNull(identityModelStore3);
                    String onesignalId = ((IdentityModel) identityModelStore3.getModel()).getOnesignalId();
                    IdentityModelStore identityModelStore4 = this.identityModelStore;
                    Intrinsics.checkNotNull(identityModelStore4);
                    IOperationRepo.DefaultImpls.enqueue$default(iOperationRepo, new LoginUserOperation(appId, onesignalId, ((IdentityModel) identityModelStore4.getModel()).getExternalId(), (String) null, 8, (DefaultConstructorMarker) null), false, 2, (Object) null);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                return;
            }
        }
        throw new Exception("Must call 'initWithContext' before 'logout'");
    }

    static /* synthetic */ void createAndSwitchToNewUser$default(OneSignalImp oneSignalImp, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        oneSignalImp.createAndSwitchToNewUser(z, function2);
    }

    private final void createAndSwitchToNewUser(boolean z, Function2<? super IdentityModel, ? super PropertiesModel, Unit> function2) {
        Object obj;
        String str;
        String str2;
        SubscriptionStatus subscriptionStatus;
        Logging.debug$default("createAndSwitchToNewUser()", (Throwable) null, 2, (Object) null);
        String createLocalId = IDManager.INSTANCE.createLocalId();
        IdentityModel identityModel = new IdentityModel();
        identityModel.setOnesignalId(createLocalId);
        PropertiesModel propertiesModel = new PropertiesModel();
        propertiesModel.setOnesignalId(createLocalId);
        if (function2 != null) {
            function2.invoke(identityModel, propertiesModel);
        }
        List arrayList = new ArrayList();
        SubscriptionModelStore subscriptionModelStore2 = this.subscriptionModelStore;
        Intrinsics.checkNotNull(subscriptionModelStore2);
        Iterator it = subscriptionModelStore2.list().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            String id = ((SubscriptionModel) obj).getId();
            ConfigModel configModel2 = this.configModel;
            Intrinsics.checkNotNull(configModel2);
            if (Intrinsics.areEqual((Object) id, (Object) configModel2.getPushSubscriptionId())) {
                break;
            }
        }
        SubscriptionModel subscriptionModel = (SubscriptionModel) obj;
        SubscriptionModel subscriptionModel2 = new SubscriptionModel();
        if (subscriptionModel == null || (str = subscriptionModel.getId()) == null) {
            str = IDManager.INSTANCE.createLocalId();
        }
        subscriptionModel2.setId(str);
        subscriptionModel2.setType(SubscriptionType.PUSH);
        subscriptionModel2.setOptedIn(subscriptionModel != null ? subscriptionModel.getOptedIn() : true);
        String str3 = "";
        if (subscriptionModel == null || (str2 = subscriptionModel.getAddress()) == null) {
            str2 = str3;
        }
        subscriptionModel2.setAddress(str2);
        if (subscriptionModel == null || (subscriptionStatus = subscriptionModel.getStatus()) == null) {
            subscriptionStatus = SubscriptionStatus.NO_PERMISSION;
        }
        subscriptionModel2.setStatus(subscriptionStatus);
        subscriptionModel2.setSdk(OneSignalUtils.SDK_VERSION);
        String str4 = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str4, "RELEASE");
        subscriptionModel2.setDeviceOS(str4);
        String carrierName = DeviceUtils.INSTANCE.getCarrierName(((IApplicationService) this.services.getService(IApplicationService.class)).getAppContext());
        if (carrierName == null) {
            carrierName = str3;
        }
        subscriptionModel2.setCarrier(carrierName);
        String appVersion = AndroidUtils.INSTANCE.getAppVersion(((IApplicationService) this.services.getService(IApplicationService.class)).getAppContext());
        if (appVersion != null) {
            str3 = appVersion;
        }
        subscriptionModel2.setAppVersion(str3);
        ConfigModel configModel3 = this.configModel;
        Intrinsics.checkNotNull(configModel3);
        configModel3.setPushSubscriptionId(subscriptionModel2.getId());
        arrayList.add(subscriptionModel2);
        SubscriptionModelStore subscriptionModelStore3 = this.subscriptionModelStore;
        Intrinsics.checkNotNull(subscriptionModelStore3);
        subscriptionModelStore3.clear(ModelChangeTags.NO_PROPOGATE);
        IdentityModelStore identityModelStore2 = this.identityModelStore;
        Intrinsics.checkNotNull(identityModelStore2);
        ISingletonModelStore.DefaultImpls.replace$default(identityModelStore2, identityModel, (String) null, 2, (Object) null);
        PropertiesModelStore propertiesModelStore2 = this.propertiesModelStore;
        Intrinsics.checkNotNull(propertiesModelStore2);
        ISingletonModelStore.DefaultImpls.replace$default(propertiesModelStore2, propertiesModel, (String) null, 2, (Object) null);
        if (z) {
            SubscriptionModelStore subscriptionModelStore4 = this.subscriptionModelStore;
            Intrinsics.checkNotNull(subscriptionModelStore4);
            subscriptionModelStore4.replaceAll(arrayList, ModelChangeTags.NO_PROPOGATE);
        } else if (subscriptionModel != null) {
            IOperationRepo iOperationRepo = this.operationRepo;
            Intrinsics.checkNotNull(iOperationRepo);
            ConfigModel configModel4 = this.configModel;
            Intrinsics.checkNotNull(configModel4);
            IOperationRepo.DefaultImpls.enqueue$default(iOperationRepo, new TransferSubscriptionOperation(configModel4.getAppId(), subscriptionModel.getId(), createLocalId), false, 2, (Object) null);
            SubscriptionModelStore subscriptionModelStore5 = this.subscriptionModelStore;
            Intrinsics.checkNotNull(subscriptionModelStore5);
            subscriptionModelStore5.replaceAll(arrayList, ModelChangeTags.NO_PROPOGATE);
        } else {
            SubscriptionModelStore subscriptionModelStore6 = this.subscriptionModelStore;
            Intrinsics.checkNotNull(subscriptionModelStore6);
            IModelStore.DefaultImpls.replaceAll$default(subscriptionModelStore6, arrayList, (String) null, 2, (Object) null);
        }
    }

    public <T> boolean hasService(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "c");
        return this.services.hasService(cls);
    }

    public <T> T getService(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "c");
        return this.services.getService(cls);
    }

    public <T> T getServiceOrNull(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "c");
        return this.services.getServiceOrNull(cls);
    }

    public <T> List<T> getAllServices(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "c");
        return this.services.getAllServices(cls);
    }
}
