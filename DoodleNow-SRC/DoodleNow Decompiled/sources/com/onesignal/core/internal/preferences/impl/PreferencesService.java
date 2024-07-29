package com.onesignal.core.internal.preferences.impl;

import android.content.SharedPreferences;
import com.onesignal.common.threading.Waiter;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\r\b\u0000\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J0\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0002J)\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010\u001bJ)\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010\u001eJ)\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0014\u001a\u00020\nH\u0002J$\u0010$\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016J0\u0010%\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010&2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010&H\u0016J\"\u0010'\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\fH\u0002J'\u0010)\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010*J'\u0010+\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010,J'\u0010-\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010.J\"\u0010/\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\nH\u0016J(\u00100\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010&H\u0016J\b\u00101\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/onesignal/core/internal/preferences/impl/PreferencesService;", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "Lcom/onesignal/core/internal/startup/IStartableService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/time/ITime;)V", "prefsToApply", "", "", "", "", "queueJob", "Lkotlinx/coroutines/Deferred;", "", "waiter", "Lcom/onesignal/common/threading/Waiter;", "doWorkAsync", "get", "store", "key", "type", "Ljava/lang/Class;", "defValue", "getBool", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "getInt", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "getLong", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "getSharedPrefsByName", "Landroid/content/SharedPreferences;", "getString", "getStringSet", "", "save", "value", "saveBool", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "saveInt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "saveLong", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "saveString", "saveStringSet", "start", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PreferencesService.kt */
public final class PreferencesService implements IPreferencesService, IStartableService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int WRITE_CALL_DELAY_TO_BUFFER_MS = 200;
    private final IApplicationService _applicationService;
    /* access modifiers changed from: private */
    public final ITime _time;
    /* access modifiers changed from: private */
    public final Map<String, Map<String, Object>> prefsToApply = MapsKt.mapOf(TuplesKt.to(PreferenceStores.ONESIGNAL, new LinkedHashMap()), TuplesKt.to(PreferenceStores.PLAYER_PURCHASES, new LinkedHashMap()));
    private Deferred<Unit> queueJob;
    /* access modifiers changed from: private */
    public final Waiter waiter = new Waiter();

    public PreferencesService(IApplicationService iApplicationService, ITime iTime) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        this._applicationService = iApplicationService;
        this._time = iTime;
    }

    public void start() {
        this.queueJob = doWorkAsync();
    }

    public String getString(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(str2, SubscriberAttributeKt.JSON_NAME_KEY);
        return (String) get(str, str2, String.class, str3);
    }

    public Boolean getBool(String str, String str2, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(str2, SubscriberAttributeKt.JSON_NAME_KEY);
        return (Boolean) get(str, str2, Boolean.TYPE, bool);
    }

    public Integer getInt(String str, String str2, Integer num) {
        Intrinsics.checkNotNullParameter(str, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(str2, SubscriberAttributeKt.JSON_NAME_KEY);
        return (Integer) get(str, str2, Integer.TYPE, num);
    }

    public Long getLong(String str, String str2, Long l) {
        Intrinsics.checkNotNullParameter(str, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(str2, SubscriberAttributeKt.JSON_NAME_KEY);
        return (Long) get(str, str2, Long.TYPE, l);
    }

    public Set<String> getStringSet(String str, String str2, Set<String> set) {
        Intrinsics.checkNotNullParameter(str, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(str2, SubscriberAttributeKt.JSON_NAME_KEY);
        return (Set) get(str, str2, Set.class, set);
    }

    public void saveString(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(str2, SubscriberAttributeKt.JSON_NAME_KEY);
        save(str, str2, str3);
    }

    public void saveBool(String str, String str2, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(str2, SubscriberAttributeKt.JSON_NAME_KEY);
        save(str, str2, bool);
    }

    public void saveInt(String str, String str2, Integer num) {
        Intrinsics.checkNotNullParameter(str, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(str2, SubscriberAttributeKt.JSON_NAME_KEY);
        save(str, str2, num);
    }

    public void saveLong(String str, String str2, Long l) {
        Intrinsics.checkNotNullParameter(str, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(str2, SubscriberAttributeKt.JSON_NAME_KEY);
        save(str, str2, l);
    }

    public void saveStringSet(String str, String str2, Set<String> set) {
        Intrinsics.checkNotNullParameter(str, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(str2, SubscriberAttributeKt.JSON_NAME_KEY);
        save(str, str2, set);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: boolean} */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r7 = getSharedPrefsByName(r7);
        r0 = 0;
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r7 == null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) java.lang.String.class) == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) java.lang.Boolean.TYPE) == false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0047, code lost:
        r4 = (java.lang.Boolean) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r4 == null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        r4 = r4.booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) java.lang.Integer.TYPE) == false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0063, code lost:
        r4 = (java.lang.Integer) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r4 == null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        r4 = r4.intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006d, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007d, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) java.lang.Long.TYPE) == false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007f, code lost:
        r4 = (java.lang.Long) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0082, code lost:
        if (r4 == null) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0084, code lost:
        r4 = r4.longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0089, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0099, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) java.util.Set.class) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a9, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) java.lang.String.class) != false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b5, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) java.lang.Boolean.TYPE) != false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b7, code lost:
        r10 = (java.lang.Boolean) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b9, code lost:
        if (r10 != null) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00bb, code lost:
        r3 = r10.booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ca, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) java.lang.Integer.TYPE) != false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00cc, code lost:
        r10 = (java.lang.Integer) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ce, code lost:
        if (r10 != null) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d0, code lost:
        r3 = r10.intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00df, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) java.lang.Long.TYPE) != false) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e1, code lost:
        r10 = (java.lang.Long) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e3, code lost:
        if (r10 != null) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e5, code lost:
        r0 = r10.longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f4, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) java.util.Set.class) != false) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00fb, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        return r7.getStringSet(r8, (java.util.Set) r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        return r7.getString(r8, (java.lang.String) r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        return java.lang.Boolean.valueOf(r7.getBoolean(r8, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        return java.lang.Integer.valueOf(r7.getInt(r8, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        return java.lang.Long.valueOf(r7.getLong(r8, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        return (java.util.Set) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        return (java.lang.String) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        return java.lang.Boolean.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        return java.lang.Integer.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        return java.lang.Long.valueOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        return null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object get(java.lang.String r7, java.lang.String r8, java.lang.Class<?> r9, java.lang.Object r10) {
        /*
            r6 = this;
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> r0 = r6.prefsToApply
            boolean r0 = r0.containsKey(r7)
            if (r0 == 0) goto L_0x00ff
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> r0 = r6.prefsToApply
            java.lang.Object r0 = r0.get(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.util.Map r0 = (java.util.Map) r0
            monitor-enter(r0)
            java.lang.Object r1 = r0.get(r8)     // Catch:{ all -> 0x00fc }
            if (r1 != 0) goto L_0x00fa
            boolean r2 = r0.containsKey(r8)     // Catch:{ all -> 0x00fc }
            if (r2 == 0) goto L_0x0022
            goto L_0x00fa
        L_0x0022:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00fc }
            monitor-exit(r0)
            android.content.SharedPreferences r7 = r6.getSharedPrefsByName(r7)
            r0 = 0
            r2 = 0
            r3 = 0
            if (r7 == 0) goto L_0x00a3
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r4)     // Catch:{ Exception -> 0x00a3 }
            if (r4 == 0) goto L_0x003f
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r2 = r7.getString(r8, r4)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00a2
        L_0x003f:
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x00a3 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r4)     // Catch:{ Exception -> 0x00a3 }
            if (r4 == 0) goto L_0x005b
            r4 = r10
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ Exception -> 0x00a3 }
            if (r4 == 0) goto L_0x0051
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x00a3 }
            goto L_0x0052
        L_0x0051:
            r4 = r3
        L_0x0052:
            boolean r7 = r7.getBoolean(r8, r4)     // Catch:{ Exception -> 0x00a3 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r7)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00a2
        L_0x005b:
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00a3 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r4)     // Catch:{ Exception -> 0x00a3 }
            if (r4 == 0) goto L_0x0077
            r4 = r10
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x00a3 }
            if (r4 == 0) goto L_0x006d
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x00a3 }
            goto L_0x006e
        L_0x006d:
            r4 = r3
        L_0x006e:
            int r7 = r7.getInt(r8, r4)     // Catch:{ Exception -> 0x00a3 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00a2
        L_0x0077:
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x00a3 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r4)     // Catch:{ Exception -> 0x00a3 }
            if (r4 == 0) goto L_0x0093
            r4 = r10
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x00a3 }
            if (r4 == 0) goto L_0x0089
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x00a3 }
            goto L_0x008a
        L_0x0089:
            r4 = r0
        L_0x008a:
            long r7 = r7.getLong(r8, r4)     // Catch:{ Exception -> 0x00a3 }
            java.lang.Long r2 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00a2
        L_0x0093:
            java.lang.Class<java.util.Set> r4 = java.util.Set.class
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r4)     // Catch:{ Exception -> 0x00a3 }
            if (r4 == 0) goto L_0x00a2
            r4 = r10
            java.util.Set r4 = (java.util.Set) r4     // Catch:{ Exception -> 0x00a3 }
            java.util.Set r2 = r7.getStringSet(r8, r4)     // Catch:{ Exception -> 0x00a3 }
        L_0x00a2:
            return r2
        L_0x00a3:
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x00af
            r2 = r10
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x00f9
        L_0x00af:
            java.lang.Class r7 = java.lang.Boolean.TYPE
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x00c4
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            if (r10 == 0) goto L_0x00bf
            boolean r3 = r10.booleanValue()
        L_0x00bf:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)
            goto L_0x00f9
        L_0x00c4:
            java.lang.Class r7 = java.lang.Integer.TYPE
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x00d9
            java.lang.Integer r10 = (java.lang.Integer) r10
            if (r10 == 0) goto L_0x00d4
            int r3 = r10.intValue()
        L_0x00d4:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            goto L_0x00f9
        L_0x00d9:
            java.lang.Class r7 = java.lang.Long.TYPE
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x00ee
            java.lang.Long r10 = (java.lang.Long) r10
            if (r10 == 0) goto L_0x00e9
            long r0 = r10.longValue()
        L_0x00e9:
            java.lang.Long r2 = java.lang.Long.valueOf(r0)
            goto L_0x00f9
        L_0x00ee:
            java.lang.Class<java.util.Set> r7 = java.util.Set.class
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x00f9
            r2 = r10
            java.util.Set r2 = (java.util.Set) r2
        L_0x00f9:
            return r2
        L_0x00fa:
            monitor-exit(r0)
            return r1
        L_0x00fc:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        L_0x00ff:
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Store not found: "
            r9.<init>(r10)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.preferences.impl.PreferencesService.get(java.lang.String, java.lang.String, java.lang.Class, java.lang.Object):java.lang.Object");
    }

    private final void save(String str, String str2, Object obj) {
        if (this.prefsToApply.containsKey(str)) {
            Map<String, Object> map = this.prefsToApply.get(str);
            Intrinsics.checkNotNull(map);
            Map map2 = map;
            synchronized (map2) {
                map2.put(str2, obj);
                Unit unit = Unit.INSTANCE;
            }
            this.waiter.wake();
            return;
        }
        throw new Exception("Store not found: " + str);
    }

    private final Deferred<Unit> doWorkAsync() {
        return BuildersKt__Builders_commonKt.async$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new PreferencesService$doWorkAsync$1(this, (Continuation<? super PreferencesService$doWorkAsync$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final synchronized SharedPreferences getSharedPrefsByName(String str) {
        return this._applicationService.getAppContext().getSharedPreferences(str, 0);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/core/internal/preferences/impl/PreferencesService$Companion;", "", "()V", "WRITE_CALL_DELAY_TO_BUFFER_MS", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PreferencesService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
