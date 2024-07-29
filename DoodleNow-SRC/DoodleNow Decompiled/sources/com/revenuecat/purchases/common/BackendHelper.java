package com.revenuecat.purchases.common;

import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.networking.Endpoint;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0001\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\f2\u001a\u0010\u0019\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001b\u0018\u00010\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00100\u001d2 \u0010\u001f\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00100 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/revenuecat/purchases/common/BackendHelper;", "", "apiKey", "", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "httpClient", "Lcom/revenuecat/purchases/common/HTTPClient;", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/HTTPClient;)V", "authenticationHeaders", "", "getAuthenticationHeaders$purchases_defaultsRelease", "()Ljava/util/Map;", "enqueue", "", "call", "Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "delay", "Lcom/revenuecat/purchases/common/Delay;", "performRequest", "endpoint", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "body", "postFieldsToSign", "", "Lkotlin/Pair;", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "onCompleted", "Lkotlin/Function3;", "", "Lorg/json/JSONObject;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BackendHelper.kt */
public final class BackendHelper {
    private final String apiKey;
    /* access modifiers changed from: private */
    public final AppConfig appConfig;
    private final Map<String, String> authenticationHeaders;
    private final Dispatcher dispatcher;
    /* access modifiers changed from: private */
    public final HTTPClient httpClient;

    public final Map<String, String> getAuthenticationHeaders$purchases_defaultsRelease() {
        return this.authenticationHeaders;
    }

    public BackendHelper(String str, Dispatcher dispatcher2, AppConfig appConfig2, HTTPClient hTTPClient) {
        Intrinsics.checkNotNullParameter(str, "apiKey");
        Intrinsics.checkNotNullParameter(dispatcher2, "dispatcher");
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        Intrinsics.checkNotNullParameter(hTTPClient, "httpClient");
        this.apiKey = str;
        this.dispatcher = dispatcher2;
        this.appConfig = appConfig2;
        this.httpClient = hTTPClient;
        this.authenticationHeaders = MapsKt.mapOf(TuplesKt.to("Authorization", "Bearer " + str));
    }

    public final void performRequest(Endpoint endpoint, Map<String, ? extends Object> map, List<Pair<String, String>> list, Delay delay, Function1<? super PurchasesError, Unit> function1, Function3<? super PurchasesError, ? super Integer, ? super JSONObject, Unit> function3) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(delay, "delay");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Intrinsics.checkNotNullParameter(function3, "onCompleted");
        enqueue(new BackendHelper$performRequest$1(this, endpoint, map, list, function1, function3), this.dispatcher, delay);
    }

    public static /* synthetic */ void enqueue$default(BackendHelper backendHelper, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher2, Delay delay, int i, Object obj) {
        if ((i & 4) != 0) {
            delay = Delay.NONE;
        }
        backendHelper.enqueue(asyncCall, dispatcher2, delay);
    }

    public final void enqueue(Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher2, Delay delay) {
        Intrinsics.checkNotNullParameter(asyncCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(dispatcher2, "dispatcher");
        Intrinsics.checkNotNullParameter(delay, "delay");
        if (dispatcher2.isClosed()) {
            LogUtilsKt.errorLog$default("Enqueuing operation in closed dispatcher.", (Throwable) null, 2, (Object) null);
        } else {
            dispatcher2.enqueue(asyncCall, delay);
        }
    }
}
