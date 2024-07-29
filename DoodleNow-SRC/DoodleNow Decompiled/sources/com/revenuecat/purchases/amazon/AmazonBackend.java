package com.revenuecat.purchases.amazon;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.BackendHelper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J>\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\f2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00110\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000RÌ\u0001\u0010\u0014\u001aU\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0012A\u0012?\u0012;\u00129\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00110\f0\u000bj\u0002`\u00130\n0\u00062Y\u0010\u0005\u001aU\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0012A\u0012?\u0012;\u00129\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00110\f0\u000bj\u0002`\u00130\n0\u00068F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/amazon/AmazonBackend;", "", "backendHelper", "Lcom/revenuecat/purchases/common/BackendHelper;", "(Lcom/revenuecat/purchases/common/BackendHelper;)V", "<set-?>", "", "", "", "Lcom/revenuecat/purchases/amazon/CallbackCacheKey;", "", "Lkotlin/Pair;", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "response", "", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/amazon/PostAmazonReceiptCallback;", "postAmazonReceiptCallbacks", "getPostAmazonReceiptCallbacks", "()Ljava/util/Map;", "setPostAmazonReceiptCallbacks", "(Ljava/util/Map;)V", "getAmazonReceiptData", "receiptId", "storeUserID", "onSuccess", "onError", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonBackend.kt */
public final class AmazonBackend {
    /* access modifiers changed from: private */
    public final BackendHelper backendHelper;
    private volatile Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>>> postAmazonReceiptCallbacks = new LinkedHashMap();

    public AmazonBackend(BackendHelper backendHelper2) {
        Intrinsics.checkNotNullParameter(backendHelper2, "backendHelper");
        this.backendHelper = backendHelper2;
    }

    public final synchronized Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>>> getPostAmazonReceiptCallbacks() {
        return this.postAmazonReceiptCallbacks;
    }

    public final synchronized void setPostAmazonReceiptCallbacks(Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.postAmazonReceiptCallbacks = map;
    }

    public final void getAmazonReceiptData(String str, String str2, Function1<? super JSONObject, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, b.E);
        Intrinsics.checkNotNullParameter(str2, "storeUserID");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        List listOfNotNull = CollectionsKt.listOfNotNull((T[]) new String[]{str, str2});
        Function0 amazonBackend$getAmazonReceiptData$call$1 = new AmazonBackend$getAmazonReceiptData$call$1(this, str2, str, listOfNotNull);
        Pair<A, B> pair = TuplesKt.to(function1, function12);
        synchronized (this) {
            if (!this.postAmazonReceiptCallbacks.containsKey(listOfNotNull)) {
                this.postAmazonReceiptCallbacks.put(listOfNotNull, CollectionsKt.mutableListOf(pair));
                amazonBackend$getAmazonReceiptData$call$1.invoke();
                Unit unit = Unit.INSTANCE;
            } else {
                List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>> list = this.postAmazonReceiptCallbacks.get(listOfNotNull);
                Intrinsics.checkNotNull(list);
                Boolean.valueOf(list.add(pair));
            }
        }
    }
}
