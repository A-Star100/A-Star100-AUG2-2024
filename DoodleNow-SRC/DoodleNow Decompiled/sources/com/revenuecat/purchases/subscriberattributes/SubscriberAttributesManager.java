package com.revenuecat.purchases.subscriberattributes;

import android.app.Application;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u00016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\u00102\n\u0010\u0016\u001a\u00060\u0012j\u0002`\u00172\n\u0010\u0018\u001a\u00060\u0012j\u0002`\u0017JA\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142/\u0010\u001a\u001a+\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00100\u001bH\u0002J2\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\"\u0010\u001a\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020!0\u001cj\u0002`\"\u0012\u0004\u0012\u00020\u00100\u001bJ0\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020!0\u001c2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&J \u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0012J$\u0010,\u001a\u00020\u00102\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001c2\u0006\u0010\u0011\u001a\u00020\u0012J(\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u0002002\b\u0010+\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J$\u00101\u001a\u00020\u00102\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020!0\u001c2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J$\u00103\u001a\u00020\u00102\n\u00104\u001a\u00060\u0012j\u0002`\u00172\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u000105R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;", "", "deviceCache", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "backend", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;", "deviceIdentifiersFetcher", "Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;", "(Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;)V", "getBackend", "()Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;", "getDeviceCache", "()Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "obtainingDeviceIdentifiersObservable", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager$ObtainDeviceIdentifiersObservable;", "collectDeviceIdentifiers", "", "appUserID", "", "applicationContext", "Landroid/app/Application;", "copyUnsyncedSubscriberAttributes", "originalAppUserId", "Lcom/revenuecat/purchases/subscriberattributes/caching/AppUserID;", "newAppUserID", "getDeviceIdentifiers", "completion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "deviceIdentifiers", "getUnsyncedSubscriberAttributes", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "markAsSynced", "attributesToMarkAsSynced", "attributeErrors", "", "Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "setAttribute", "key", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "value", "setAttributes", "attributesToSet", "setAttributionID", "attributionKey", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds;", "storeAttributesIfNeeded", "attributesAsObjects", "synchronizeSubscriberAttributesForAllUsers", "currentAppUserID", "Lkotlin/Function0;", "ObtainDeviceIdentifiersObservable", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriberAttributesManager.kt */
public final class SubscriberAttributesManager {
    private final SubscriberAttributesPoster backend;
    private final SubscriberAttributesCache deviceCache;
    private final DeviceIdentifiersFetcher deviceIdentifiersFetcher;
    /* access modifiers changed from: private */
    public final ObtainDeviceIdentifiersObservable obtainingDeviceIdentifiersObservable = new ObtainDeviceIdentifiersObservable();

    public final SubscriberAttributesPoster getBackend() {
        return this.backend;
    }

    public final SubscriberAttributesCache getDeviceCache() {
        return this.deviceCache;
    }

    public SubscriberAttributesManager(SubscriberAttributesCache subscriberAttributesCache, SubscriberAttributesPoster subscriberAttributesPoster, DeviceIdentifiersFetcher deviceIdentifiersFetcher2) {
        Intrinsics.checkNotNullParameter(subscriberAttributesCache, "deviceCache");
        Intrinsics.checkNotNullParameter(subscriberAttributesPoster, "backend");
        Intrinsics.checkNotNullParameter(deviceIdentifiersFetcher2, "deviceIdentifiersFetcher");
        this.deviceCache = subscriberAttributesCache;
        this.backend = subscriberAttributesPoster;
        this.deviceIdentifiersFetcher = deviceIdentifiersFetcher2;
    }

    private final void storeAttributesIfNeeded(Map<String, SubscriberAttribute> map, String str) {
        Map<String, SubscriberAttribute> allStoredSubscriberAttributes = this.deviceCache.getAllStoredSubscriberAttributes(str);
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getKey();
            SubscriberAttribute subscriberAttribute = (SubscriberAttribute) next.getValue();
            if (allStoredSubscriberAttributes.containsKey(str2)) {
                SubscriberAttribute subscriberAttribute2 = allStoredSubscriberAttributes.get(str2);
                if (Intrinsics.areEqual((Object) subscriberAttribute2 != null ? subscriberAttribute2.getValue() : null, (Object) subscriberAttribute.getValue())) {
                }
            }
            linkedHashMap.put(next.getKey(), next.getValue());
        }
        if (!linkedHashMap.isEmpty()) {
            this.deviceCache.setAttributes(str, linkedHashMap);
        }
    }

    public final synchronized void setAttribute(SubscriberAttributeKey subscriberAttributeKey, String str, String str2) {
        Intrinsics.checkNotNullParameter(subscriberAttributeKey, SubscriberAttributeKt.JSON_NAME_KEY);
        Intrinsics.checkNotNullParameter(str2, "appUserID");
        setAttributes(MapsKt.mapOf(TuplesKt.to(subscriberAttributeKey.getBackendKey(), str)), str2);
    }

    public static /* synthetic */ void synchronizeSubscriberAttributesForAllUsers$default(SubscriberAttributesManager subscriberAttributesManager, String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(str, function0);
    }

    public final void synchronizeSubscriberAttributesForAllUsers(String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "currentAppUserID");
        this.obtainingDeviceIdentifiersObservable.waitUntilIdle(new SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1(this, function0, str));
    }

    public final synchronized void copyUnsyncedSubscriberAttributes(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "originalAppUserId");
        Intrinsics.checkNotNullParameter(str2, "newAppUserID");
        Map<String, SubscriberAttribute> unsyncedSubscriberAttributes = this.deviceCache.getUnsyncedSubscriberAttributes(str);
        if (!unsyncedSubscriberAttributes.isEmpty()) {
            String format = String.format(AttributionStrings.COPYING_ATTRIBUTES_FROM_TO_USER, Arrays.copyOf(new Object[]{str, str2}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogUtilsKt.infoLog(format);
            this.deviceCache.setAttributes(str2, unsyncedSubscriberAttributes);
            this.deviceCache.clearAllSubscriberAttributesFromUser(str);
        }
    }

    public final synchronized void getUnsyncedSubscriberAttributes(String str, Function1<? super Map<String, SubscriberAttribute>, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(function1, "completion");
        this.obtainingDeviceIdentifiersObservable.waitUntilIdle(new SubscriberAttributesManager$getUnsyncedSubscriberAttributes$1(function1, this, str));
    }

    public final synchronized void markAsSynced(String str, Map<String, SubscriberAttribute> map, List<SubscriberAttributeError> list) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(map, "attributesToMarkAsSynced");
        Intrinsics.checkNotNullParameter(list, "attributeErrors");
        if (!list.isEmpty()) {
            LogIntent logIntent = LogIntent.RC_ERROR;
            String format = String.format(AttributionStrings.SUBSCRIBER_ATTRIBUTES_ERROR, Arrays.copyOf(new Object[]{list}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
        }
        if (!map.isEmpty()) {
            LogIntent logIntent2 = LogIntent.INFO;
            StringBuilder sb = new StringBuilder();
            String format2 = String.format(AttributionStrings.MARKING_ATTRIBUTES_SYNCED, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
            sb.append(format2);
            sb.append(CollectionsKt.joinToString$default(map.values(), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            LogWrapperKt.log(logIntent2, sb.toString());
            Map<String, SubscriberAttribute> allStoredSubscriberAttributes = this.deviceCache.getAllStoredSubscriberAttributes(str);
            Map<String, SubscriberAttribute> mutableMap = MapsKt.toMutableMap(allStoredSubscriberAttributes);
            for (Map.Entry next : map.entrySet()) {
                String str2 = (String) next.getKey();
                SubscriberAttribute subscriberAttribute = (SubscriberAttribute) next.getValue();
                SubscriberAttribute subscriberAttribute2 = allStoredSubscriberAttributes.get(str2);
                if (subscriberAttribute2 != null) {
                    SubscriberAttribute subscriberAttribute3 = null;
                    if (subscriberAttribute2.isSynced()) {
                        subscriberAttribute2 = null;
                    }
                    if (subscriberAttribute2 != null) {
                        if (Intrinsics.areEqual((Object) subscriberAttribute2.getValue(), (Object) subscriberAttribute.getValue())) {
                            subscriberAttribute3 = subscriberAttribute2;
                        }
                        if (subscriberAttribute3 != null) {
                            mutableMap.put(str2, SubscriberAttribute.copy$default(subscriberAttribute, (SubscriberAttributeKey) null, (String) null, (DateProvider) null, (Date) null, true, 15, (Object) null));
                        }
                    }
                }
            }
            this.deviceCache.setAttributes(str, mutableMap);
        }
    }

    public final void collectDeviceIdentifiers(String str, Application application) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(application, "applicationContext");
        getDeviceIdentifiers(application, new SubscriberAttributesManager$collectDeviceIdentifiers$1(this, str));
    }

    public final void setAttributionID(SubscriberAttributeKey.AttributionIds attributionIds, String str, String str2, Application application) {
        Intrinsics.checkNotNullParameter(attributionIds, "attributionKey");
        Intrinsics.checkNotNullParameter(str2, "appUserID");
        Intrinsics.checkNotNullParameter(application, "applicationContext");
        getDeviceIdentifiers(application, new SubscriberAttributesManager$setAttributionID$1(attributionIds, str, this, str2));
    }

    private final void getDeviceIdentifiers(Application application, Function1<? super Map<String, String>, Unit> function1) {
        ObtainDeviceIdentifiersObservable obtainDeviceIdentifiersObservable = this.obtainingDeviceIdentifiersObservable;
        obtainDeviceIdentifiersObservable.setNumberOfProcesses(obtainDeviceIdentifiersObservable.getNumberOfProcesses() + 1);
        this.deviceIdentifiersFetcher.getDeviceIdentifiers(application, new SubscriberAttributesManager$getDeviceIdentifiers$1(function1, this));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R,\u0010\u0003\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u00078BX\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager$ObtainDeviceIdentifiersObservable;", "Ljava/util/Observable;", "()V", "listeners", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "", "Lkotlin/collections/ArrayList;", "value", "", "numberOfProcesses", "getNumberOfProcesses", "()I", "setNumberOfProcesses", "(I)V", "waitUntilIdle", "completion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SubscriberAttributesManager.kt */
    private static final class ObtainDeviceIdentifiersObservable extends Observable {
        private final ArrayList<Function0<Unit>> listeners = new ArrayList<>();
        private int numberOfProcesses;

        public ObtainDeviceIdentifiersObservable() {
            addObserver(new SubscriberAttributesManager$ObtainDeviceIdentifiersObservable$$ExternalSyntheticLambda0(this));
        }

        public final synchronized int getNumberOfProcesses() {
            return this.numberOfProcesses;
        }

        public final synchronized void setNumberOfProcesses(int i) {
            if (this.numberOfProcesses != i) {
                this.numberOfProcesses = i;
                setChanged();
                notifyObservers();
            }
        }

        /* access modifiers changed from: private */
        public static final void _init_$lambda$2(ObtainDeviceIdentifiersObservable obtainDeviceIdentifiersObservable, Observable observable, Object obj) {
            Intrinsics.checkNotNullParameter(obtainDeviceIdentifiersObservable, "this$0");
            Intrinsics.checkNotNull(observable, "null cannot be cast to non-null type com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.ObtainDeviceIdentifiersObservable");
            if (((ObtainDeviceIdentifiersObservable) observable).numberOfProcesses == 0) {
                synchronized (obtainDeviceIdentifiersObservable) {
                    for (Function0 invoke : obtainDeviceIdentifiersObservable.listeners) {
                        invoke.invoke();
                    }
                    obtainDeviceIdentifiersObservable.listeners.clear();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final synchronized void waitUntilIdle(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "completion");
            if (this.numberOfProcesses == 0) {
                function0.invoke();
            } else {
                this.listeners.add(new SubscriberAttributesManager$ObtainDeviceIdentifiersObservable$waitUntilIdle$1(function0));
            }
        }
    }

    public final synchronized void setAttributes(Map<String, String> map, String str) {
        Intrinsics.checkNotNullParameter(map, "attributesToSet");
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Collection arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getKey();
            arrayList.add(TuplesKt.to(str2, new SubscriberAttribute(str2, (String) next.getValue(), (DateProvider) null, (Date) null, false, 28, (DefaultConstructorMarker) null)));
        }
        storeAttributesIfNeeded(MapsKt.toMap((List) arrayList), str);
    }
}
