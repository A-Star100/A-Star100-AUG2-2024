package com.revenuecat.purchases.amazon;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazon.a.a.o.b;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.amazon.AmazonPurchasingData;
import com.revenuecat.purchases.amazon.listener.ProductDataResponseListener;
import com.revenuecat.purchases.amazon.listener.PurchaseResponseListener;
import com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener;
import com.revenuecat.purchases.amazon.listener.UserDataResponseListener;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000ª\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B7\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012Bq\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\b\u001a\u00020\u0015\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ\b\u0010(\u001a\u00020\u000bH\u0002J \u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020'H\u0014J\b\u00100\u001a\u00020'H\u0002J\u001e\u00101\u001a\u00020'2\u0014\u00102\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020'0\"H\u0002JH\u00103\u001a\u00020'2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002052\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020'0\"2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0016Jn\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u0002052\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>2N\u00109\u001aJ\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002050A¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(B\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020#0A¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020'0@H\u0002JM\u0010D\u001a\u00020'2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002050F2\u0006\u0010G\u001a\u0002052\u0018\u0010H\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0>\u0012\u0004\u0012\u00020'0\"2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0001J4\u0010J\u001a\u00020'2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020'0\"2\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"j\u0002`LH\u0016J\u0012\u0010M\u001a\u0004\u0018\u0001052\u0006\u0010N\u001a\u00020OH\u0002J1\u0010P\u001a\u00020'2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020'0\"2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0001J*\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020?2\u0006\u0010T\u001a\u00020Q2\u0006\u0010U\u001a\u00020I2\b\u0010V\u001a\u0004\u0018\u00010WH\u0002J\b\u0010X\u001a\u00020\u000bH\u0016J\u001c\u0010Y\u001a\u00020'2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020#0AH\u0002JC\u0010Z\u001a\u00020'2\u0006\u0010[\u001a\u00020\\2\u0006\u00104\u001a\u0002052\u0006\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010a\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010bJW\u0010c\u001a\u00020'2\u0006\u0010d\u001a\u0002052\u0006\u0010e\u001a\u0002052\u0006\u0010f\u001a\u0002052!\u0010K\u001a\u001d\u0012\u0013\u0012\u001105¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020'0\"2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0016J\u0010\u0010h\u001a\u00020'2\u0006\u0010N\u001a\u00020iH\u0016J\u0010\u0010j\u001a\u00020'2\u0006\u0010k\u001a\u00020#H\u0002J\u0010\u0010l\u001a\u00020'2\u0006\u0010N\u001a\u00020mH\u0016J\u0010\u0010n\u001a\u00020'2\u0006\u0010N\u001a\u00020oH\u0016J\u0010\u0010p\u001a\u00020'2\u0006\u0010N\u001a\u00020qH\u0016JW\u0010+\u001a\u00020'2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010[\u001a\u00020\\2\u0006\u00104\u001a\u0002052\u0006\u0010U\u001a\u00020I2\u0018\u0010K\u001a\u0014\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020'0@2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0001JB\u0010r\u001a\u00020'2\u0006\u00104\u001a\u0002052\u0018\u0010s\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0>\u0012\u0004\u0012\u00020'0\"2\u0016\u0010t\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"j\u0002`LH\u0016JT\u0010u\u001a\u00020'2\u0006\u00106\u001a\u0002072\f\u0010v\u001a\b\u0012\u0004\u0012\u0002050F2\u001c\u0010H\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0>\u0012\u0004\u0012\u00020'0\"j\u0002`w2\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"j\u0002`LH\u0016J=\u0010x\u001a\u00020'2\u001e\u0010K\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0>\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020'0@2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0001JD\u0010x\u001a\u00020'2\u0006\u0010y\u001a\u00020\u000b2\u001e\u0010K\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020,0A\u0012\u0004\u0012\u00020'0\"2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0002JD\u0010x\u001a\u00020'2\u0006\u00104\u001a\u0002052\u001e\u0010K\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020,0A\u0012\u0004\u0012\u00020'0\"2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0016J\u0010\u0010z\u001a\u00020'2\u0006\u0010{\u001a\u00020|H\u0002J.\u0010}\u001a\u00020'2\u0006\u0010[\u001a\u00020\\2\f\u0010~\u001a\b\u0012\u0004\u0012\u000200>2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020'0\u0001H\u0016J\t\u0010\u0001\u001a\u00020'H\u0016J\u0013\u0010\u0001\u001a\u00020'2\b\u0010\u0001\u001a\u00030\u0001H\u0016J;\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020,0A*\b\u0012\u0004\u0012\u00020?0>2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002050A2\u0006\u0010T\u001a\u00020QH\u0002R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R1\u0010 \u001a%\u0012!\u0012\u001f\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020'0\"0!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/revenuecat/purchases/amazon/AmazonBilling;", "Lcom/revenuecat/purchases/common/BillingAbstract;", "Lcom/revenuecat/purchases/amazon/listener/ProductDataResponseListener;", "Lcom/revenuecat/purchases/amazon/listener/PurchaseResponseListener;", "Lcom/revenuecat/purchases/amazon/listener/PurchaseUpdatesResponseListener;", "Lcom/revenuecat/purchases/amazon/listener/UserDataResponseListener;", "applicationContext", "Landroid/content/Context;", "cache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "observerMode", "", "mainHandler", "Landroid/os/Handler;", "backendHelper", "Lcom/revenuecat/purchases/common/BackendHelper;", "stateProvider", "Lcom/revenuecat/purchases/PurchasesStateProvider;", "(Landroid/content/Context;Lcom/revenuecat/purchases/common/caching/DeviceCache;ZLandroid/os/Handler;Lcom/revenuecat/purchases/common/BackendHelper;Lcom/revenuecat/purchases/PurchasesStateProvider;)V", "amazonBackend", "Lcom/revenuecat/purchases/amazon/AmazonBackend;", "Lcom/revenuecat/purchases/amazon/AmazonCache;", "purchasingServiceProvider", "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "productDataHandler", "purchaseHandler", "purchaseUpdatesHandler", "userDataHandler", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Landroid/content/Context;Lcom/revenuecat/purchases/amazon/AmazonBackend;Lcom/revenuecat/purchases/amazon/AmazonCache;ZLandroid/os/Handler;Lcom/revenuecat/purchases/PurchasesStateProvider;Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;Lcom/revenuecat/purchases/amazon/listener/ProductDataResponseListener;Lcom/revenuecat/purchases/amazon/listener/PurchaseResponseListener;Lcom/revenuecat/purchases/amazon/listener/PurchaseUpdatesResponseListener;Lcom/revenuecat/purchases/amazon/listener/UserDataResponseListener;Lcom/revenuecat/purchases/common/DateProvider;)V", "connected", "serviceRequests", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "Lkotlin/ParameterName;", "name", "connectionError", "", "checkObserverMode", "consumeAndSave", "shouldTryToConsume", "purchase", "Lcom/revenuecat/purchases/models/StoreTransaction;", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "endConnection", "executePendingRequests", "executeRequestOnUIThread", "request", "findPurchaseInPurchaseHistory", "appUserID", "", "productType", "Lcom/revenuecat/purchases/ProductType;", "productId", "onCompletion", "onError", "getMissingSkusForReceipts", "amazonUserID", "receipts", "", "Lcom/amazon/device/iap/model/Receipt;", "Lkotlin/Function2;", "", "tokensToSkusMap", "errors", "getProductData", "skus", "", "marketplace", "onReceive", "Lcom/revenuecat/purchases/models/StoreProduct;", "getStorefront", "onSuccess", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "getTermSkuFromJSON", "response", "Lorg/json/JSONObject;", "getUserData", "Lcom/amazon/device/iap/model/UserData;", "handleReceipt", "receipt", "userData", "storeProduct", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "isConnected", "logErrorsIfAny", "makePurchaseAsync", "activity", "Landroid/app/Activity;", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "replaceProductInfo", "Lcom/revenuecat/purchases/common/ReplaceProductInfo;", "isPersonalizedPrice", "(Landroid/app/Activity;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/common/ReplaceProductInfo;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Boolean;)V", "normalizePurchaseData", "productID", "purchaseToken", "storeUserID", "correctProductID", "onProductDataResponse", "Lcom/amazon/device/iap/model/ProductDataResponse;", "onPurchaseError", "error", "onPurchaseResponse", "Lcom/amazon/device/iap/model/PurchaseResponse;", "onPurchaseUpdatesResponse", "Lcom/amazon/device/iap/model/PurchaseUpdatesResponse;", "onUserDataResponse", "Lcom/amazon/device/iap/model/UserDataResponse;", "queryAllPurchases", "onReceivePurchaseHistory", "onReceivePurchaseHistoryError", "queryProductDetailsAsync", "productIds", "Lcom/revenuecat/purchases/common/StoreProductsCallback;", "queryPurchases", "filterOnlyActivePurchases", "runOnUIThread", "runnable", "Ljava/lang/Runnable;", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "subscriptionStatusChange", "Lkotlin/Function0;", "startConnection", "startConnectionOnMainThread", "delayMilliseconds", "", "toMapOfReceiptHashesToRestoredPurchases", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonBilling.kt */
public final class AmazonBilling extends BillingAbstract implements ProductDataResponseListener, PurchaseResponseListener, PurchaseUpdatesResponseListener, UserDataResponseListener {
    private final AmazonBackend amazonBackend;
    private final Context applicationContext;
    /* access modifiers changed from: private */
    public final AmazonCache cache;
    private boolean connected;
    /* access modifiers changed from: private */
    public final DateProvider dateProvider;
    /* access modifiers changed from: private */
    public final Handler mainHandler;
    private final boolean observerMode;
    /* access modifiers changed from: private */
    public final ProductDataResponseListener productDataHandler;
    /* access modifiers changed from: private */
    public final PurchaseResponseListener purchaseHandler;
    /* access modifiers changed from: private */
    public final PurchaseUpdatesResponseListener purchaseUpdatesHandler;
    /* access modifiers changed from: private */
    public final PurchasingServiceProvider purchasingServiceProvider;
    private final ConcurrentLinkedQueue<Function1<PurchasesError, Unit>> serviceRequests;
    /* access modifiers changed from: private */
    public final UserDataResponseListener userDataHandler;

    /* access modifiers changed from: protected */
    public void endConnection() {
    }

    public void getProductData(Set<String> set, String str, Function1<? super List<? extends StoreProduct>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(set, b.O);
        Intrinsics.checkNotNullParameter(str, b.m);
        Intrinsics.checkNotNullParameter(function1, "onReceive");
        Intrinsics.checkNotNullParameter(function12, "onError");
        this.productDataHandler.getProductData(set, str, function1, function12);
    }

    public void getUserData(Function1<? super UserData, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        this.userDataHandler.getUserData(function1, function12);
    }

    public boolean isConnected() {
        return this.connected;
    }

    public void purchase(Handler handler, Activity activity, String str, StoreProduct storeProduct, Function2<? super Receipt, ? super UserData, Unit> function2, Function1<? super PurchasesError, Unit> function1) {
        Intrinsics.checkNotNullParameter(handler, "mainHandler");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(function2, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        this.purchaseHandler.purchase(handler, activity, str, storeProduct, function2, function1);
    }

    public void queryPurchases(Function2<? super List<Receipt>, ? super UserData, Unit> function2, Function1<? super PurchasesError, Unit> function1) {
        Intrinsics.checkNotNullParameter(function2, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        this.purchaseUpdatesHandler.queryPurchases(function2, function1);
    }

    public void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> list, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(list, "inAppMessageTypes");
        Intrinsics.checkNotNullParameter(function0, "subscriptionStatusChange");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AmazonBilling(android.content.Context r16, com.revenuecat.purchases.amazon.AmazonBackend r17, com.revenuecat.purchases.amazon.AmazonCache r18, boolean r19, android.os.Handler r20, com.revenuecat.purchases.PurchasesStateProvider r21, com.revenuecat.purchases.amazon.PurchasingServiceProvider r22, com.revenuecat.purchases.amazon.listener.ProductDataResponseListener r23, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener r24, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener r25, com.revenuecat.purchases.amazon.listener.UserDataResponseListener r26, com.revenuecat.purchases.common.DateProvider r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r15 = this;
            r0 = r28
            r1 = r0 & 64
            if (r1 == 0) goto L_0x000f
            com.revenuecat.purchases.amazon.DefaultPurchasingServiceProvider r1 = new com.revenuecat.purchases.amazon.DefaultPurchasingServiceProvider
            r1.<init>()
            com.revenuecat.purchases.amazon.PurchasingServiceProvider r1 = (com.revenuecat.purchases.amazon.PurchasingServiceProvider) r1
            r9 = r1
            goto L_0x0011
        L_0x000f:
            r9 = r22
        L_0x0011:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0020
            com.revenuecat.purchases.amazon.handler.ProductDataHandler r1 = new com.revenuecat.purchases.amazon.handler.ProductDataHandler
            r8 = r20
            r1.<init>(r9, r8)
            com.revenuecat.purchases.amazon.listener.ProductDataResponseListener r1 = (com.revenuecat.purchases.amazon.listener.ProductDataResponseListener) r1
            r10 = r1
            goto L_0x0024
        L_0x0020:
            r8 = r20
            r10 = r23
        L_0x0024:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0032
            com.revenuecat.purchases.amazon.handler.PurchaseHandler r1 = new com.revenuecat.purchases.amazon.handler.PurchaseHandler
            r11 = r16
            r1.<init>(r9, r11)
            com.revenuecat.purchases.amazon.listener.PurchaseResponseListener r1 = (com.revenuecat.purchases.amazon.listener.PurchaseResponseListener) r1
            goto L_0x0036
        L_0x0032:
            r11 = r16
            r1 = r24
        L_0x0036:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0043
            com.revenuecat.purchases.amazon.handler.PurchaseUpdatesHandler r2 = new com.revenuecat.purchases.amazon.handler.PurchaseUpdatesHandler
            r2.<init>(r9)
            com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener r2 = (com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener) r2
            r12 = r2
            goto L_0x0045
        L_0x0043:
            r12 = r25
        L_0x0045:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x005a
            com.revenuecat.purchases.amazon.handler.UserDataHandler r13 = new com.revenuecat.purchases.amazon.handler.UserDataHandler
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r13
            r3 = r9
            r4 = r20
            r2.<init>(r3, r4, r5, r6, r7)
            r2 = r13
            com.revenuecat.purchases.amazon.listener.UserDataResponseListener r2 = (com.revenuecat.purchases.amazon.listener.UserDataResponseListener) r2
            r13 = r2
            goto L_0x005c
        L_0x005a:
            r13 = r26
        L_0x005c:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0069
            com.revenuecat.purchases.common.DefaultDateProvider r0 = new com.revenuecat.purchases.common.DefaultDateProvider
            r0.<init>()
            com.revenuecat.purchases.common.DateProvider r0 = (com.revenuecat.purchases.common.DateProvider) r0
            r14 = r0
            goto L_0x006b
        L_0x0069:
            r14 = r27
        L_0x006b:
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r11 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.AmazonBilling.<init>(android.content.Context, com.revenuecat.purchases.amazon.AmazonBackend, com.revenuecat.purchases.amazon.AmazonCache, boolean, android.os.Handler, com.revenuecat.purchases.PurchasesStateProvider, com.revenuecat.purchases.amazon.PurchasingServiceProvider, com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener, com.revenuecat.purchases.common.DateProvider, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AmazonBilling(Context context, AmazonBackend amazonBackend2, AmazonCache amazonCache, boolean z, Handler handler, PurchasesStateProvider purchasesStateProvider, PurchasingServiceProvider purchasingServiceProvider2, ProductDataResponseListener productDataResponseListener, PurchaseResponseListener purchaseResponseListener, PurchaseUpdatesResponseListener purchaseUpdatesResponseListener, UserDataResponseListener userDataResponseListener, DateProvider dateProvider2) {
        super(purchasesStateProvider);
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        Intrinsics.checkNotNullParameter(amazonBackend2, "amazonBackend");
        Intrinsics.checkNotNullParameter(amazonCache, "cache");
        Intrinsics.checkNotNullParameter(handler, "mainHandler");
        Intrinsics.checkNotNullParameter(purchasesStateProvider, "stateProvider");
        Intrinsics.checkNotNullParameter(purchasingServiceProvider2, "purchasingServiceProvider");
        Intrinsics.checkNotNullParameter(productDataResponseListener, "productDataHandler");
        Intrinsics.checkNotNullParameter(purchaseResponseListener, "purchaseHandler");
        Intrinsics.checkNotNullParameter(purchaseUpdatesResponseListener, "purchaseUpdatesHandler");
        Intrinsics.checkNotNullParameter(userDataResponseListener, "userDataHandler");
        Intrinsics.checkNotNullParameter(dateProvider2, "dateProvider");
        this.applicationContext = context;
        this.amazonBackend = amazonBackend2;
        this.cache = amazonCache;
        this.observerMode = z;
        this.mainHandler = handler;
        this.purchasingServiceProvider = purchasingServiceProvider2;
        this.productDataHandler = productDataResponseListener;
        this.purchaseHandler = purchaseResponseListener;
        this.purchaseUpdatesHandler = purchaseUpdatesResponseListener;
        this.userDataHandler = userDataResponseListener;
        this.dateProvider = dateProvider2;
        this.serviceRequests = new ConcurrentLinkedQueue<>();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AmazonBilling(android.content.Context r19, com.revenuecat.purchases.common.caching.DeviceCache r20, boolean r21, android.os.Handler r22, com.revenuecat.purchases.common.BackendHelper r23, com.revenuecat.purchases.PurchasesStateProvider r24) {
        /*
            r18 = this;
            r0 = r20
            r1 = r23
            java.lang.String r2 = "applicationContext"
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            java.lang.String r2 = "cache"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "mainHandler"
            r8 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            java.lang.String r2 = "backendHelper"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "stateProvider"
            r9 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            com.revenuecat.purchases.amazon.AmazonBackend r5 = new com.revenuecat.purchases.amazon.AmazonBackend
            r5.<init>(r1)
            com.revenuecat.purchases.amazon.AmazonCache r6 = new com.revenuecat.purchases.amazon.AmazonCache
            r6.<init>(r0)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 4032(0xfc0, float:5.65E-42)
            r17 = 0
            r3 = r18
            r7 = r21
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.AmazonBilling.<init>(android.content.Context, com.revenuecat.purchases.common.caching.DeviceCache, boolean, android.os.Handler, com.revenuecat.purchases.common.BackendHelper, com.revenuecat.purchases.PurchasesStateProvider):void");
    }

    public void startConnection() {
        if (!checkObserverMode()) {
            this.purchasingServiceProvider.registerListener(this.applicationContext, this);
            this.connected = true;
            BillingAbstract.StateListener stateListener = getStateListener();
            if (stateListener != null) {
                stateListener.onConnected();
            }
            executePendingRequests();
        }
    }

    public void startConnectionOnMainThread(long j) {
        runOnUIThread(new AmazonBilling$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public static final void startConnectionOnMainThread$lambda$0(AmazonBilling amazonBilling) {
        Intrinsics.checkNotNullParameter(amazonBilling, "this$0");
        amazonBilling.startConnection();
    }

    public void queryAllPurchases(String str, Function1<? super List<StoreTransaction>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(function1, "onReceivePurchaseHistory");
        Intrinsics.checkNotNullParameter(function12, "onReceivePurchaseHistoryError");
        queryPurchases(false, (Function1<? super Map<String, StoreTransaction>, Unit>) new AmazonBilling$queryAllPurchases$1(function1), function12);
    }

    public void normalizePurchaseData(String str, String str2, String str3, Function1<? super String, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "productID");
        Intrinsics.checkNotNullParameter(str2, "purchaseToken");
        Intrinsics.checkNotNullParameter(str3, "storeUserID");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        String str4 = this.cache.getReceiptSkus().get(str2);
        if (str4 != null) {
            function1.invoke(str4);
        } else {
            this.amazonBackend.getAmazonReceiptData(str2, str3, new AmazonBilling$normalizePurchaseData$2(this, function12, str2, function1), new AmazonBilling$normalizePurchaseData$3(function12));
        }
    }

    public void queryProductDetailsAsync(ProductType productType, Set<String> set, Function1<? super List<? extends StoreProduct>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(set, "productIds");
        Intrinsics.checkNotNullParameter(function1, "onReceive");
        Intrinsics.checkNotNullParameter(function12, "onError");
        if (!checkObserverMode()) {
            executeRequestOnUIThread(new AmazonBilling$queryProductDetailsAsync$1(this, function12, set, function1));
        }
    }

    public void consumeAndSave(boolean z, StoreTransaction storeTransaction, PostReceiptInitiationSource postReceiptInitiationSource) {
        Intrinsics.checkNotNullParameter(storeTransaction, "purchase");
        Intrinsics.checkNotNullParameter(postReceiptInitiationSource, "initiationSource");
        if (!checkObserverMode() && storeTransaction.getType() != ProductType.UNKNOWN && storeTransaction.getPurchaseState() != PurchaseState.PENDING) {
            if (z) {
                executeRequestOnUIThread(new AmazonBilling$consumeAndSave$1(this, storeTransaction));
            }
            this.cache.addSuccessfullyPostedToken(storeTransaction.getPurchaseToken());
        }
    }

    public void findPurchaseInPurchaseHistory(String str, ProductType productType, String str2, Function1<? super StoreTransaction, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(str2, "productId");
        Intrinsics.checkNotNullParameter(function1, "onCompletion");
        Intrinsics.checkNotNullParameter(function12, "onError");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(RestoreStrings.QUERYING_PURCHASE_WITH_TYPE, Arrays.copyOf(new Object[]{str2, productType.name()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        queryAllPurchases(str, new AmazonBilling$findPurchaseInPurchaseHistory$1(function1, str2, function12), function12);
    }

    public void makePurchaseAsync(Activity activity, String str, PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, PresentedOfferingContext presentedOfferingContext, Boolean bool) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(purchasingData, "purchasingData");
        AmazonPurchasingData.Product product = purchasingData instanceof AmazonPurchasingData.Product ? (AmazonPurchasingData.Product) purchasingData : null;
        if (product == null) {
            PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
            String format = String.format(PurchaseStrings.INVALID_PURCHASE_TYPE, Arrays.copyOf(new Object[]{"Amazon", "AmazonPurchaseInfo"}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            PurchasesError purchasesError = new PurchasesError(purchasesErrorCode, format);
            LogUtilsKt.errorLog(purchasesError);
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesFailedToUpdate(purchasesError);
                return;
            }
            return;
        }
        AmazonStoreProduct storeProduct = product.getStoreProduct();
        if (!checkObserverMode()) {
            if (replaceProductInfo != null) {
                LogWrapperKt.log(LogIntent.AMAZON_WARNING, AmazonStrings.PRODUCT_CHANGES_NOT_SUPPORTED);
            } else {
                executeRequestOnUIThread(new AmazonBilling$makePurchaseAsync$1(this, activity, str, storeProduct, presentedOfferingContext));
            }
        }
    }

    public void queryPurchases(String str, Function1<? super Map<String, StoreTransaction>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        if (!checkObserverMode()) {
            queryPurchases(true, function1, function12);
        }
    }

    public void getStorefront(Function1<? super String, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        executeRequestOnUIThread(new AmazonBilling$getStorefront$1(this, function12, function1));
    }

    /* access modifiers changed from: private */
    public final Map<String, StoreTransaction> toMapOfReceiptHashesToRestoredPurchases(List<Receipt> list, Map<String, String> map, UserData userData) {
        Collection arrayList = new ArrayList();
        for (Receipt receipt : list) {
            String str = map.get(receipt.getReceiptId());
            Pair pair = null;
            if (str == null) {
                LogWrapperKt.log(LogIntent.AMAZON_ERROR, AmazonStrings.ERROR_FINDING_RECEIPT_SKU);
            } else {
                StoreTransaction storeTransaction = StoreTransactionConversionsKt.toStoreTransaction(receipt, str, (PresentedOfferingContext) null, PurchaseState.UNSPECIFIED_STATE, userData);
                String receiptId = receipt.getReceiptId();
                Intrinsics.checkNotNullExpressionValue(receiptId, "receipt.receiptId");
                pair = TuplesKt.to(UtilsKt.sha1(receiptId), storeTransaction);
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap((List) arrayList);
    }

    public void onUserDataResponse(UserDataResponse userDataResponse) {
        Intrinsics.checkNotNullParameter(userDataResponse, "response");
        if (!checkObserverMode()) {
            this.userDataHandler.onUserDataResponse(userDataResponse);
        }
    }

    public void onProductDataResponse(ProductDataResponse productDataResponse) {
        Intrinsics.checkNotNullParameter(productDataResponse, "response");
        if (!checkObserverMode()) {
            this.productDataHandler.onProductDataResponse(productDataResponse);
        }
    }

    public void onPurchaseResponse(PurchaseResponse purchaseResponse) {
        Intrinsics.checkNotNullParameter(purchaseResponse, "response");
        if (!checkObserverMode()) {
            this.purchaseHandler.onPurchaseResponse(purchaseResponse);
        }
    }

    public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse purchaseUpdatesResponse) {
        Intrinsics.checkNotNullParameter(purchaseUpdatesResponse, "response");
        if (!checkObserverMode()) {
            this.purchaseUpdatesHandler.onPurchaseUpdatesResponse(purchaseUpdatesResponse);
        }
    }

    /* access modifiers changed from: private */
    public final String getTermSkuFromJSON(JSONObject jSONObject) {
        try {
            return jSONObject.getString(b.L);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void logErrorsIfAny(Map<String, PurchasesError> map) {
        if (!map.isEmpty()) {
            String joinToString$default = CollectionsKt.joinToString$default(map.keySet(), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            LogIntent logIntent = LogIntent.AMAZON_ERROR;
            String format = String.format(AmazonStrings.ERROR_FETCHING_RECEIPTS, Arrays.copyOf(new Object[]{joinToString$default}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
        }
    }

    private final void queryPurchases(boolean z, Function1<? super Map<String, StoreTransaction>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        executeRequestOnUIThread(new AmazonBilling$queryPurchases$1(this, function12, z, function1));
    }

    /* access modifiers changed from: private */
    public final void getMissingSkusForReceipts(String str, List<Receipt> list, Function2<? super Map<String, String>, ? super Map<String, PurchasesError>, Unit> function2) {
        Map<String, String> receiptSkus = this.cache.getReceiptSkus();
        Map<String, String> mutableMap = MapsKt.toMutableMap(receiptSkus);
        Map linkedHashMap = new LinkedHashMap();
        Iterable iterable = list;
        Collection arrayList = new ArrayList();
        for (Object next : iterable) {
            if (((Receipt) next).getProductType() != com.amazon.device.iap.model.ProductType.SUBSCRIPTION) {
                arrayList.add(next);
            }
        }
        Iterable<Receipt> iterable2 = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (Receipt receipt : iterable2) {
            arrayList2.add(TuplesKt.to(receipt.getReceiptId(), receipt.getSku()));
        }
        MapsKt.putAll(mutableMap, (List) arrayList2);
        Collection arrayList3 = new ArrayList();
        for (Object next2 : iterable) {
            if (((Receipt) next2).getProductType() == com.amazon.device.iap.model.ProductType.SUBSCRIPTION) {
                arrayList3.add(next2);
            }
        }
        Collection arrayList4 = new ArrayList();
        for (Object next3 : (List) arrayList3) {
            if (!receiptSkus.containsKey(((Receipt) next3).getReceiptId())) {
                arrayList4.add(next3);
            }
        }
        List<Receipt> list2 = (List) arrayList4;
        if (list2.isEmpty()) {
            function2.invoke(mutableMap, linkedHashMap);
            return;
        }
        Function2<? super Map<String, String>, ? super Map<String, PurchasesError>, Unit> function22 = function2;
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = list2.size();
        for (Receipt receipt2 : list2) {
            AmazonBackend amazonBackend2 = this.amazonBackend;
            String receiptId = receipt2.getReceiptId();
            Intrinsics.checkNotNullExpressionValue(receiptId, "receipt.receiptId");
            Function2<? super Map<String, String>, ? super Map<String, PurchasesError>, Unit> function23 = function2;
            amazonBackend2.getAmazonReceiptData(receiptId, str, new AmazonBilling$getMissingSkusForReceipts$1$1(mutableMap, receipt2, intRef, this, function23, linkedHashMap), new AmazonBilling$getMissingSkusForReceipts$1$2(linkedHashMap, receipt2, intRef, function23, mutableMap));
        }
    }

    /* access modifiers changed from: private */
    public final void handleReceipt(Receipt receipt, UserData userData, StoreProduct storeProduct, PresentedOfferingContext presentedOfferingContext) {
        if (receipt.getProductType() != com.amazon.device.iap.model.ProductType.SUBSCRIPTION) {
            StoreTransaction storeTransaction = StoreTransactionConversionsKt.toStoreTransaction(receipt, storeProduct.getId(), presentedOfferingContext, PurchaseState.PURCHASED, userData);
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesUpdated(CollectionsKt.listOf(storeTransaction));
                return;
            }
            return;
        }
        AmazonBackend amazonBackend2 = this.amazonBackend;
        String receiptId = receipt.getReceiptId();
        Intrinsics.checkNotNullExpressionValue(receiptId, "receipt.receiptId");
        String userId = userData.getUserId();
        Intrinsics.checkNotNullExpressionValue(userId, "userData.userId");
        amazonBackend2.getAmazonReceiptData(receiptId, userId, new AmazonBilling$handleReceipt$1(receipt, presentedOfferingContext, userData, this), new AmazonBilling$handleReceipt$2(this));
    }

    /* access modifiers changed from: private */
    public final void onPurchaseError(PurchasesError purchasesError) {
        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
        if (purchasesUpdatedListener != null) {
            purchasesUpdatedListener.onPurchasesFailedToUpdate(purchasesError);
        }
    }

    private final boolean checkObserverMode() {
        if (!this.observerMode) {
            return false;
        }
        LogWrapperKt.log(LogIntent.AMAZON_WARNING, AmazonStrings.WARNING_AMAZON_OBSERVER_MODE);
        return true;
    }

    private final synchronized void executeRequestOnUIThread(Function1<? super PurchasesError, Unit> function1) {
        if (getPurchasesUpdatedListener() != null) {
            this.serviceRequests.add(function1);
            if (!isConnected()) {
                BillingAbstract.startConnectionOnMainThread$default(this, 0, 1, (Object) null);
            } else {
                executePendingRequests();
            }
        }
    }

    private final void executePendingRequests() {
        synchronized (this) {
            while (isConnected() && !this.serviceRequests.isEmpty()) {
                runOnUIThread(new AmazonBilling$$ExternalSyntheticLambda1((Function1) this.serviceRequests.remove()));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final void executePendingRequests$lambda$9$lambda$8(Function1 function1) {
        function1.invoke(null);
    }

    private final void runOnUIThread(Runnable runnable) {
        if (Intrinsics.areEqual((Object) Looper.getMainLooper().getThread(), (Object) Thread.currentThread())) {
            runnable.run();
        } else {
            this.mainHandler.post(runnable);
        }
    }
}
