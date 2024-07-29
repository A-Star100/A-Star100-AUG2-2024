package com.revenuecat.purchases.google;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.InAppMessageParams;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PurchaseExtensionsKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase;
import com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCaseParams;
import com.revenuecat.purchases.google.usecase.BillingClientUseCase;
import com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCase;
import com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCaseParams;
import com.revenuecat.purchases.google.usecase.GetBillingConfigUseCase;
import com.revenuecat.purchases.google.usecase.GetBillingConfigUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase;
import com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCase;
import com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCase;
import com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryPurchasesUseCase;
import com.revenuecat.purchases.google.usecase.QueryPurchasesUseCaseParams;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.OfferingStrings;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import com.revenuecat.purchases.utils.Result;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000ª\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0001B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J@\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020+0&H\u0000¢\u0006\u0002\b2J3\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020'042\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010:J=\u0010;\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020'042\u0006\u00106\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u00108\u001a\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010?J=\u0010@\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020'042\u0006\u00106\u001a\u00020A2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u00108\u001a\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010BJ \u0010C\u001a\u00020+2\u0006\u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020F2\u0006\u0010.\u001a\u00020/H\u0016J@\u0010G\u001a\u00020+2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/2!\u0010H\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020+0&H\u0000¢\u0006\u0002\bIJ\b\u0010J\u001a\u00020+H\u0014J\b\u0010K\u001a\u00020+H\u0002J/\u0010L\u001a\u00020+2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010!2\u0014\u0010N\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0004\u0012\u00020+0&H\u0002¢\u0006\u0002\u0010OJH\u0010P\u001a\u00020+2\u0006\u00108\u001a\u00020\u001e2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u001e2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020+0&2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020+0&H\u0016J)\u0010V\u001a\u00020+2\u0006\u00101\u001a\u00020\u001e2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020+0&H\u0001¢\u0006\u0002\bXJ\b\u0010Y\u001a\u00020\u001eH\u0002J3\u0010Z\u001a\u00020+2\u0006\u0010E\u001a\u00020[2!\u0010\\\u001a\u001d\u0012\u0013\u0012\u00110F¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(]\u0012\u0004\u0012\u00020+0&H\u0002J4\u0010^\u001a\u00020+2\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020+0&2\u0016\u0010U\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020+0&j\u0002``H\u0016J\b\u0010a\u001a\u00020\u0012H\u0016J\u0018\u0010b\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u000205H\u0003JC\u0010f\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\u0006\u00108\u001a\u00020\u001e2\u0006\u0010g\u001a\u00020h2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010i\u001a\u0004\u0018\u00010j2\b\u00109\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010kJ\b\u0010l\u001a\u00020+H\u0016J\u0010\u0010m\u001a\u00020+2\u0006\u0010n\u001a\u00020oH\u0016J \u0010p\u001a\u00020+2\u0006\u0010n\u001a\u00020o2\u000e\u0010q\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010rH\u0016J>\u0010s\u001a\u00020+2\u0006\u00108\u001a\u00020\u001e2\u0018\u0010t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0r\u0012\u0004\u0012\u00020+0&2\u0012\u0010u\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020+0&H\u0016JT\u0010v\u001a\u00020+2\u0006\u0010Q\u001a\u00020R2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u001e0x2\u001c\u0010y\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020z0r\u0012\u0004\u0012\u00020+0&j\u0002`{2\u0016\u0010U\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020+0&j\u0002``H\u0016J<\u0010|\u001a\u00020+2\u0006\u0010Q\u001a\u00020\u001e2\u0018\u0010t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020}0r\u0012\u0004\u0012\u00020+0&2\u0012\u0010u\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020+0&J@\u0010~\u001a\u00020+2\u0006\u0010Q\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001e2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020+0&2\u0012\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020+0&H\u0002JF\u0010\u0001\u001a\u00020+2\u0006\u00108\u001a\u00020\u001e2\u001f\u0010_\u001a\u001b\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020F0\u0001\u0012\u0004\u0012\u00020+0&2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020+0&H\u0016J\t\u0010\u0001\u001a\u00020+H\u0002J\u0012\u0010\u0001\u001a\u00020+2\u0007\u0010\u0001\u001a\u00020'H\u0002J1\u0010\u0001\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010r2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020+0\u0001H\u0016J\t\u0010\u0001\u001a\u00020+H\u0016J\u0011\u0010\u0001\u001a\u00020+2\u0006\u0010M\u001a\u00020!H\u0016J\t\u0010\u0001\u001a\u00020+H\u0002J$\u0010\u0001\u001a\u00020+2\u0019\u0010\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020+0&¢\u0006\u0003\b\u0001H\u0002R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00128B@BX\u000e¢\u0006\u0002\n\u0000R?\u0010#\u001a3\u0012/\u0012-\u0012!\u0012\u001f\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020+0&\u0012\u0006\u0012\u0004\u0018\u00010!0%0$X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/revenuecat/purchases/google/BillingWrapper;", "Lcom/revenuecat/purchases/common/BillingAbstract;", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "Lcom/android/billingclient/api/BillingClientStateListener;", "clientFactory", "Lcom/revenuecat/purchases/google/BillingWrapper$ClientFactory;", "mainHandler", "Landroid/os/Handler;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "purchasesStateProvider", "Lcom/revenuecat/purchases/PurchasesStateProvider;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Lcom/revenuecat/purchases/google/BillingWrapper$ClientFactory;Landroid/os/Handler;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/PurchasesStateProvider;Lcom/revenuecat/purchases/common/DateProvider;)V", "appInBackground", "", "getAppInBackground", "()Z", "<set-?>", "Lcom/android/billingclient/api/BillingClient;", "billingClient", "getBillingClient", "()Lcom/android/billingclient/api/BillingClient;", "setBillingClient", "(Lcom/android/billingclient/api/BillingClient;)V", "purchaseContext", "", "", "Lcom/revenuecat/purchases/google/PurchaseContext;", "reconnectMilliseconds", "", "reconnectionAlreadyScheduled", "serviceRequests", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Pair;", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "Lkotlin/ParameterName;", "name", "connectionError", "", "acknowledge", "token", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "onAcknowledged", "purchaseToken", "acknowledge$purchases_defaultsRelease", "buildOneTimePurchaseParams", "Lcom/revenuecat/purchases/utils/Result;", "Lcom/android/billingclient/api/BillingFlowParams;", "purchaseInfo", "Lcom/revenuecat/purchases/models/GooglePurchasingData$InAppProduct;", "appUserID", "isPersonalizedPrice", "(Lcom/revenuecat/purchases/models/GooglePurchasingData$InAppProduct;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/utils/Result;", "buildPurchaseParams", "Lcom/revenuecat/purchases/models/GooglePurchasingData;", "replaceProductInfo", "Lcom/revenuecat/purchases/common/ReplaceProductInfo;", "(Lcom/revenuecat/purchases/models/GooglePurchasingData;Lcom/revenuecat/purchases/common/ReplaceProductInfo;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/utils/Result;", "buildSubscriptionPurchaseParams", "Lcom/revenuecat/purchases/models/GooglePurchasingData$Subscription;", "(Lcom/revenuecat/purchases/models/GooglePurchasingData$Subscription;Lcom/revenuecat/purchases/common/ReplaceProductInfo;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/utils/Result;", "consumeAndSave", "shouldTryToConsume", "purchase", "Lcom/revenuecat/purchases/models/StoreTransaction;", "consumePurchase", "onConsumed", "consumePurchase$purchases_defaultsRelease", "endConnection", "executePendingRequests", "executeRequestOnUIThread", "delayMilliseconds", "request", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "findPurchaseInPurchaseHistory", "productType", "Lcom/revenuecat/purchases/ProductType;", "productId", "onCompletion", "onError", "getPurchaseType", "listener", "getPurchaseType$purchases_defaultsRelease", "getStackTrace", "getStoreTransaction", "Lcom/android/billingclient/api/Purchase;", "completion", "storeTxn", "getStorefront", "onSuccess", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "isConnected", "launchBillingFlow", "activity", "Landroid/app/Activity;", "params", "makePurchaseAsync", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/common/ReplaceProductInfo;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Boolean;)V", "onBillingServiceDisconnected", "onBillingSetupFinished", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "onPurchasesUpdated", "purchases", "", "queryAllPurchases", "onReceivePurchaseHistory", "onReceivePurchaseHistoryError", "queryProductDetailsAsync", "productIds", "", "onReceive", "Lcom/revenuecat/purchases/models/StoreProduct;", "Lcom/revenuecat/purchases/common/StoreProductsCallback;", "queryPurchaseHistoryAsync", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "queryPurchaseType", "resultHandler", "queryPurchases", "", "retryBillingServiceConnectionWithExponentialBackoff", "sendErrorsToAllPendingRequests", "error", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "subscriptionStatusChange", "Lkotlin/Function0;", "startConnection", "startConnectionOnMainThread", "trackProductDetailsNotSupportedIfNeeded", "withConnectedClient", "receivingFunction", "Lkotlin/ExtensionFunctionType;", "ClientFactory", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingWrapper.kt */
public final class BillingWrapper extends BillingAbstract implements PurchasesUpdatedListener, BillingClientStateListener {
    private volatile BillingClient billingClient;
    private final ClientFactory clientFactory;
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final Handler mainHandler;
    private final Map<String, PurchaseContext> purchaseContext;
    private long reconnectMilliseconds;
    private boolean reconnectionAlreadyScheduled;
    private final ConcurrentLinkedQueue<Pair<Function1<PurchasesError, Unit>, Long>> serviceRequests;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillingWrapper(ClientFactory clientFactory2, Handler handler, DeviceCache deviceCache2, DiagnosticsTracker diagnosticsTracker, PurchasesStateProvider purchasesStateProvider, DateProvider dateProvider2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(clientFactory2, handler, deviceCache2, diagnosticsTracker, purchasesStateProvider, (i & 32) != 0 ? new DefaultDateProvider() : dateProvider2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingWrapper(ClientFactory clientFactory2, Handler handler, DeviceCache deviceCache2, DiagnosticsTracker diagnosticsTracker, PurchasesStateProvider purchasesStateProvider, DateProvider dateProvider2) {
        super(purchasesStateProvider);
        Intrinsics.checkNotNullParameter(clientFactory2, "clientFactory");
        Intrinsics.checkNotNullParameter(handler, "mainHandler");
        Intrinsics.checkNotNullParameter(deviceCache2, "deviceCache");
        Intrinsics.checkNotNullParameter(purchasesStateProvider, "purchasesStateProvider");
        Intrinsics.checkNotNullParameter(dateProvider2, "dateProvider");
        this.clientFactory = clientFactory2;
        this.mainHandler = handler;
        this.deviceCache = deviceCache2;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.dateProvider = dateProvider2;
        this.purchaseContext = new LinkedHashMap();
        this.serviceRequests = new ConcurrentLinkedQueue<>();
        this.reconnectMilliseconds = 1000;
    }

    public final synchronized BillingClient getBillingClient() {
        return this.billingClient;
    }

    public final synchronized void setBillingClient(BillingClient billingClient2) {
        this.billingClient = billingClient2;
    }

    public final boolean getAppInBackground() {
        return getPurchasesStateProvider().getPurchasesState().getAppInBackground();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/google/BillingWrapper$ClientFactory;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "buildClient", "Lcom/android/billingclient/api/BillingClient;", "listener", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BillingWrapper.kt */
    public static final class ClientFactory {
        private final Context context;

        public ClientFactory(Context context2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            this.context = context2;
        }

        public final BillingClient buildClient(PurchasesUpdatedListener purchasesUpdatedListener) {
            Intrinsics.checkNotNullParameter(purchasesUpdatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            BillingClient build = BillingClient.newBuilder(this.context).enablePendingPurchases().setListener(purchasesUpdatedListener).build();
            Intrinsics.checkNotNullExpressionValue(build, "newBuilder(context).enab…\n                .build()");
            return build;
        }
    }

    private final void executePendingRequests() {
        Pair poll;
        synchronized (this) {
            while (true) {
                BillingClient billingClient2 = this.billingClient;
                if (billingClient2 == null || !billingClient2.isReady() || (poll = this.serviceRequests.poll()) == null) {
                    Unit unit = Unit.INSTANCE;
                } else {
                    Intrinsics.checkNotNullExpressionValue(poll, "poll()");
                    Function1 function1 = (Function1) poll.component1();
                    Long l = (Long) poll.component2();
                    if (l != null) {
                        this.mainHandler.postDelayed(new BillingWrapper$$ExternalSyntheticLambda1(function1), l.longValue());
                    } else {
                        this.mainHandler.post(new BillingWrapper$$ExternalSyntheticLambda2(function1));
                    }
                }
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final void executePendingRequests$lambda$3$lambda$2$lambda$0(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "$request");
        function1.invoke(null);
    }

    /* access modifiers changed from: private */
    public static final void executePendingRequests$lambda$3$lambda$2$lambda$1(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "$request");
        function1.invoke(null);
    }

    public void startConnectionOnMainThread(long j) {
        this.mainHandler.postDelayed(new BillingWrapper$$ExternalSyntheticLambda3(this), j);
    }

    /* access modifiers changed from: private */
    public static final void startConnectionOnMainThread$lambda$4(BillingWrapper billingWrapper) {
        Intrinsics.checkNotNullParameter(billingWrapper, "this$0");
        billingWrapper.startConnection();
    }

    public void startConnection() {
        synchronized (this) {
            if (this.billingClient == null) {
                this.billingClient = this.clientFactory.buildClient(this);
            }
            this.reconnectionAlreadyScheduled = false;
            BillingClient billingClient2 = this.billingClient;
            if (billingClient2 != null) {
                if (!billingClient2.isReady()) {
                    LogIntent logIntent = LogIntent.DEBUG;
                    String format = String.format(BillingStrings.BILLING_CLIENT_STARTING, Arrays.copyOf(new Object[]{billingClient2}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    LogWrapperKt.log(logIntent, format);
                    try {
                        billingClient2.startConnection(this);
                    } catch (IllegalStateException e) {
                        LogIntent logIntent2 = LogIntent.GOOGLE_ERROR;
                        String format2 = String.format(BillingStrings.ILLEGAL_STATE_EXCEPTION_WHEN_CONNECTING, Arrays.copyOf(new Object[]{e}, 1));
                        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                        LogWrapperKt.log(logIntent2, format2);
                        sendErrorsToAllPendingRequests(new PurchasesError(PurchasesErrorCode.StoreProblemError, e.getMessage()));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void endConnection() {
        this.mainHandler.post(new BillingWrapper$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public static final void endConnection$lambda$9(BillingWrapper billingWrapper) {
        Intrinsics.checkNotNullParameter(billingWrapper, "this$0");
        synchronized (billingWrapper) {
            BillingClient billingClient2 = billingWrapper.billingClient;
            if (billingClient2 != null) {
                LogIntent logIntent = LogIntent.DEBUG;
                String format = String.format(BillingStrings.BILLING_CLIENT_ENDING, Arrays.copyOf(new Object[]{billingClient2}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogWrapperKt.log(logIntent, format);
                billingClient2.endConnection();
            }
            billingWrapper.billingClient = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    static /* synthetic */ void executeRequestOnUIThread$default(BillingWrapper billingWrapper, Long l, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        billingWrapper.executeRequestOnUIThread(l, function1);
    }

    /* access modifiers changed from: private */
    public final synchronized void executeRequestOnUIThread(Long l, Function1<? super PurchasesError, Unit> function1) {
        if (getPurchasesUpdatedListener() != null) {
            this.serviceRequests.add(TuplesKt.to(function1, l));
            BillingClient billingClient2 = this.billingClient;
            if (billingClient2 == null || billingClient2.isReady()) {
                executePendingRequests();
            } else {
                BillingAbstract.startConnectionOnMainThread$default(this, 0, 1, (Object) null);
            }
        } else {
            function1.invoke(new PurchasesError(PurchasesErrorCode.UnknownError, "BillingWrapper is not attached to a listener"));
        }
    }

    public void queryProductDetailsAsync(ProductType productType, Set<String> set, Function1<? super List<? extends StoreProduct>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Set<String> set2 = set;
        ProductType productType2 = productType;
        Intrinsics.checkNotNullParameter(productType2, "productType");
        Intrinsics.checkNotNullParameter(set2, "productIds");
        Intrinsics.checkNotNullParameter(function1, "onReceive");
        Intrinsics.checkNotNullParameter(function12, "onError");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(OfferingStrings.FETCHING_PRODUCTS, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(set2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        BillingClientUseCase.run$default(new QueryProductDetailsUseCase(new QueryProductDetailsUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, set2, productType2, getAppInBackground()), function1, function12, new BillingWrapper$queryProductDetailsAsync$useCase$1(this), new BillingWrapper$queryProductDetailsAsync$useCase$2(this)), 0, 1, (Object) null);
    }

    public void makePurchaseAsync(Activity activity, String str, PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, PresentedOfferingContext presentedOfferingContext, Boolean bool) {
        String str2;
        PresentedOfferingContext presentedOfferingContext2;
        GoogleReplacementMode googleReplacementMode;
        PurchasingData purchasingData2 = purchasingData;
        Activity activity2 = activity;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(purchasingData2, "purchasingData");
        GooglePurchasingData googlePurchasingData = purchasingData2 instanceof GooglePurchasingData ? (GooglePurchasingData) purchasingData2 : null;
        if (googlePurchasingData == null) {
            PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
            String format = String.format(PurchaseStrings.INVALID_PURCHASE_TYPE, Arrays.copyOf(new Object[]{"Play", "GooglePurchasingData"}, 2));
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
        if (googlePurchasingData instanceof GooglePurchasingData.InAppProduct) {
            str2 = null;
        } else if (googlePurchasingData instanceof GooglePurchasingData.Subscription) {
            str2 = ((GooglePurchasingData.Subscription) googlePurchasingData).getOptionId();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (replaceProductInfo != null) {
            LogIntent logIntent = LogIntent.PURCHASE;
            String format2 = String.format(PurchaseStrings.UPGRADING_SKU, Arrays.copyOf(new Object[]{replaceProductInfo.getOldPurchase().getProductIds().get(0), googlePurchasingData.getProductId()}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
            LogWrapperKt.log(logIntent, format2);
        } else {
            LogIntent logIntent2 = LogIntent.PURCHASE;
            String format3 = String.format(PurchaseStrings.PURCHASING_PRODUCT, Arrays.copyOf(new Object[]{googlePurchasingData.getProductId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
            LogWrapperKt.log(logIntent2, format3);
        }
        synchronized (this) {
            String productId = googlePurchasingData.getProductId();
            Map<String, PurchaseContext> map = this.purchaseContext;
            ProductType productType = googlePurchasingData.getProductType();
            ReplacementMode replacementMode = replaceProductInfo != null ? replaceProductInfo.getReplacementMode() : null;
            if (replacementMode instanceof GoogleReplacementMode) {
                googleReplacementMode = (GoogleReplacementMode) replacementMode;
                presentedOfferingContext2 = presentedOfferingContext;
            } else {
                presentedOfferingContext2 = presentedOfferingContext;
                googleReplacementMode = null;
            }
            map.put(productId, new PurchaseContext(productType, presentedOfferingContext2, str2, googleReplacementMode));
            Unit unit = Unit.INSTANCE;
        }
        executeRequestOnUIThread$default(this, (Long) null, new BillingWrapper$makePurchaseAsync$2(this, purchasingData, replaceProductInfo, str, bool, activity), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams) {
        if (activity.getIntent() == null) {
            LogWrapperKt.log(LogIntent.WARNING, BillingStrings.NULL_ACTIVITY_INTENT);
        }
        withConnectedClient(new BillingWrapper$launchBillingFlow$1(activity, billingFlowParams));
    }

    public final void queryPurchaseHistoryAsync(String str, Function1<? super List<? extends PurchaseHistoryRecord>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "productType");
        Intrinsics.checkNotNullParameter(function1, "onReceivePurchaseHistory");
        Intrinsics.checkNotNullParameter(function12, "onReceivePurchaseHistoryError");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(RestoreStrings.QUERYING_PURCHASE_HISTORY, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        BillingClientUseCase.run$default(new QueryPurchaseHistoryUseCase(new QueryPurchaseHistoryUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, str, getAppInBackground()), function1, function12, new BillingWrapper$queryPurchaseHistoryAsync$1(this), new BillingWrapper$queryPurchaseHistoryAsync$2(this)), 0, 1, (Object) null);
    }

    public void queryAllPurchases(String str, Function1<? super List<StoreTransaction>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(function1, "onReceivePurchaseHistory");
        Intrinsics.checkNotNullParameter(function12, "onReceivePurchaseHistoryError");
        queryPurchaseHistoryAsync("subs", new BillingWrapper$queryAllPurchases$1(this, function12, function1), function12);
    }

    public void consumeAndSave(boolean z, StoreTransaction storeTransaction, PostReceiptInitiationSource postReceiptInitiationSource) {
        Intrinsics.checkNotNullParameter(storeTransaction, "purchase");
        Intrinsics.checkNotNullParameter(postReceiptInitiationSource, "initiationSource");
        if (storeTransaction.getType() != ProductType.UNKNOWN && storeTransaction.getPurchaseState() != PurchaseState.PENDING) {
            Purchase originalGooglePurchase = StoreTransactionConversionsKt.getOriginalGooglePurchase(storeTransaction);
            boolean isAcknowledged = originalGooglePurchase != null ? originalGooglePurchase.isAcknowledged() : false;
            if (z && storeTransaction.getType() == ProductType.INAPP) {
                consumePurchase$purchases_defaultsRelease(storeTransaction.getPurchaseToken(), postReceiptInitiationSource, new BillingWrapper$consumeAndSave$1(this.deviceCache));
            } else if (!z || isAcknowledged) {
                this.deviceCache.addSuccessfullyPostedToken(storeTransaction.getPurchaseToken());
            } else {
                acknowledge$purchases_defaultsRelease(storeTransaction.getPurchaseToken(), postReceiptInitiationSource, new BillingWrapper$consumeAndSave$2(this.deviceCache));
            }
        }
    }

    public final void consumePurchase$purchases_defaultsRelease(String str, PostReceiptInitiationSource postReceiptInitiationSource, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(postReceiptInitiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(function1, "onConsumed");
        LogIntent logIntent = LogIntent.PURCHASE;
        String format = String.format(PurchaseStrings.CONSUMING_PURCHASE, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        BillingClientUseCase.run$default(new ConsumePurchaseUseCase(new ConsumePurchaseUseCaseParams(str, postReceiptInitiationSource, getAppInBackground()), function1, BillingWrapper$consumePurchase$1.INSTANCE, new BillingWrapper$consumePurchase$2(this), new BillingWrapper$consumePurchase$3(this)), 0, 1, (Object) null);
    }

    public final void acknowledge$purchases_defaultsRelease(String str, PostReceiptInitiationSource postReceiptInitiationSource, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(postReceiptInitiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(function1, "onAcknowledged");
        LogIntent logIntent = LogIntent.PURCHASE;
        String format = String.format(PurchaseStrings.ACKNOWLEDGING_PURCHASE, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        BillingClientUseCase.run$default(new AcknowledgePurchaseUseCase(new AcknowledgePurchaseUseCaseParams(str, postReceiptInitiationSource, getAppInBackground()), function1, BillingWrapper$acknowledge$1.INSTANCE, new BillingWrapper$acknowledge$2(this), new BillingWrapper$acknowledge$3(this)), 0, 1, (Object) null);
    }

    public void queryPurchases(String str, Function1<? super Map<String, StoreTransaction>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        LogWrapperKt.log(LogIntent.DEBUG, RestoreStrings.QUERYING_PURCHASE);
        BillingClientUseCase.run$default(new QueryPurchasesUseCase(new QueryPurchasesUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, getAppInBackground()), function1, function12, new BillingWrapper$queryPurchases$1(this), new BillingWrapper$queryPurchases$2(this)), 0, 1, (Object) null);
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
        String googleProductType = ProductTypeConversionsKt.toGoogleProductType(productType);
        Unit unit = null;
        if (googleProductType != null) {
            BillingClientUseCase.run$default(new QueryPurchaseHistoryUseCase(new QueryPurchaseHistoryUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, googleProductType, getAppInBackground()), new BillingWrapper$findPurchaseInPurchaseHistory$1$1(productType, function1, str2, function12), function12, new BillingWrapper$findPurchaseInPurchaseHistory$1$2(this), new BillingWrapper$findPurchaseInPurchaseHistory$1$3(this)), 0, 1, (Object) null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            function12.invoke(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, PurchaseStrings.NOT_RECOGNIZED_PRODUCT_TYPE));
        }
    }

    public final void getPurchaseType$purchases_defaultsRelease(String str, Function1<? super ProductType, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "purchaseToken");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        queryPurchaseType("subs", str, function1, new BillingWrapper$getPurchaseType$1(function1, this, str));
    }

    /* access modifiers changed from: private */
    public final void queryPurchaseType(String str, String str2, Function1<? super ProductType, Unit> function1, Function1<? super Boolean, Unit> function12) {
        BillingClientUseCase.run$default(new QueryPurchasesByTypeUseCase(new QueryPurchasesByTypeUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, getAppInBackground(), str), new BillingWrapper$queryPurchaseType$1(function12, str2), new BillingWrapper$queryPurchaseType$2(function1), new BillingWrapper$queryPurchaseType$3(this), new BillingWrapper$queryPurchaseType$4(this)), 0, 1, (Object) null);
    }

    public void onPurchasesUpdated(BillingResult billingResult, List<? extends Purchase> list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        List<? extends Purchase> emptyList = list == null ? CollectionsKt.emptyList() : list;
        if (billingResult.getResponseCode() != 0 || !(!emptyList.isEmpty())) {
            LogIntent logIntent = LogIntent.GOOGLE_ERROR;
            StringBuilder sb = new StringBuilder();
            String format = String.format(BillingStrings.BILLING_WRAPPER_PURCHASES_ERROR, Arrays.copyOf(new Object[]{BillingResultExtensionsKt.toHumanReadableDescription(billingResult)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            sb.append(format);
            String str = null;
            if (emptyList.isEmpty()) {
                emptyList = null;
            }
            if (emptyList != null) {
                str = "Purchases:" + CollectionsKt.joinToString$default(emptyList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, BillingWrapper$onPurchasesUpdated$3$1.INSTANCE, 30, (Object) null);
            }
            sb.append(str);
            LogWrapperKt.log(logIntent, sb.toString());
            String str2 = "Error updating purchases. " + BillingResultExtensionsKt.toHumanReadableDescription(billingResult);
            int responseCode = billingResult.getResponseCode();
            if (list == null && billingResult.getResponseCode() == 0) {
                str2 = "Error: onPurchasesUpdated received an OK BillingResult with a Null purchases list.";
                responseCode = 6;
            }
            PurchasesError billingResponseToPurchasesError = ErrorsKt.billingResponseToPurchasesError(responseCode, str2);
            LogUtilsKt.errorLog(billingResponseToPurchasesError);
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesFailedToUpdate(billingResponseToPurchasesError);
                return;
            }
            return;
        }
        List arrayList = new ArrayList();
        for (Purchase storeTransaction : emptyList) {
            getStoreTransaction(storeTransaction, new BillingWrapper$onPurchasesUpdated$1$1(arrayList, emptyList, this));
        }
    }

    public void onBillingSetupFinished(BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        this.mainHandler.post(new BillingWrapper$$ExternalSyntheticLambda4(billingResult, this));
    }

    /* access modifiers changed from: private */
    public static final void onBillingSetupFinished$lambda$18(BillingResult billingResult, BillingWrapper billingWrapper) {
        PurchasesError purchasesError;
        Intrinsics.checkNotNullParameter(billingResult, "$billingResult");
        Intrinsics.checkNotNullParameter(billingWrapper, "this$0");
        int responseCode = billingResult.getResponseCode();
        if (responseCode != 6) {
            if (!(responseCode == 7 || responseCode == 8)) {
                if (responseCode != 12) {
                    switch (responseCode) {
                        case -2:
                        case 3:
                            String humanReadableDescription = BillingResultExtensionsKt.toHumanReadableDescription(billingResult);
                            if (Intrinsics.areEqual((Object) billingResult.getDebugMessage(), (Object) ErrorsKt.IN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE)) {
                                String format = String.format(BillingStrings.BILLING_UNAVAILABLE_LESS_THAN_3, Arrays.copyOf(new Object[]{humanReadableDescription}, 1));
                                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                                purchasesError = new PurchasesError(PurchasesErrorCode.StoreProblemError, format);
                                LogUtilsKt.errorLog(purchasesError);
                            } else {
                                String format2 = String.format(BillingStrings.BILLING_UNAVAILABLE, Arrays.copyOf(new Object[]{humanReadableDescription}, 1));
                                Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                                purchasesError = ErrorsKt.billingResponseToPurchasesError(billingResult.getResponseCode(), format2);
                                LogUtilsKt.errorLog(purchasesError);
                            }
                            billingWrapper.sendErrorsToAllPendingRequests(purchasesError);
                            return;
                        case -1:
                        case 1:
                        case 2:
                            break;
                        case 0:
                            LogIntent logIntent = LogIntent.DEBUG;
                            Object[] objArr = new Object[1];
                            BillingClient billingClient2 = billingWrapper.billingClient;
                            objArr[0] = billingClient2 != null ? billingClient2.toString() : null;
                            String format3 = String.format(BillingStrings.BILLING_SERVICE_SETUP_FINISHED, Arrays.copyOf(objArr, 1));
                            Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
                            LogWrapperKt.log(logIntent, format3);
                            BillingAbstract.StateListener stateListener = billingWrapper.getStateListener();
                            if (stateListener != null) {
                                stateListener.onConnected();
                            }
                            billingWrapper.executePendingRequests();
                            billingWrapper.reconnectMilliseconds = 1000;
                            billingWrapper.trackProductDetailsNotSupportedIfNeeded();
                            return;
                        case 4:
                            break;
                        default:
                            return;
                    }
                }
            }
            LogIntent logIntent2 = LogIntent.GOOGLE_WARNING;
            String format4 = String.format(BillingStrings.BILLING_CLIENT_ERROR, Arrays.copyOf(new Object[]{BillingResultExtensionsKt.toHumanReadableDescription(billingResult)}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "format(this, *args)");
            LogWrapperKt.log(logIntent2, format4);
            return;
        }
        LogIntent logIntent3 = LogIntent.GOOGLE_WARNING;
        String format5 = String.format(BillingStrings.BILLING_CLIENT_ERROR, Arrays.copyOf(new Object[]{BillingResultExtensionsKt.toHumanReadableDescription(billingResult)}, 1));
        Intrinsics.checkNotNullExpressionValue(format5, "format(this, *args)");
        LogWrapperKt.log(logIntent3, format5);
        billingWrapper.retryBillingServiceConnectionWithExponentialBackoff();
    }

    public void onBillingServiceDisconnected() {
        LogIntent logIntent = LogIntent.WARNING;
        Object[] objArr = new Object[1];
        BillingClient billingClient2 = this.billingClient;
        objArr[0] = billingClient2 != null ? billingClient2.toString() : null;
        String format = String.format(BillingStrings.BILLING_SERVICE_DISCONNECTED_INSTANCE, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
    }

    private final void retryBillingServiceConnectionWithExponentialBackoff() {
        if (this.reconnectionAlreadyScheduled) {
            LogWrapperKt.log(LogIntent.WARNING, BillingStrings.BILLING_CLIENT_RETRY_ALREADY_SCHEDULED);
            return;
        }
        LogIntent logIntent = LogIntent.WARNING;
        String format = String.format(BillingStrings.BILLING_CLIENT_RETRY, Arrays.copyOf(new Object[]{Long.valueOf(this.reconnectMilliseconds)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.reconnectionAlreadyScheduled = true;
        startConnectionOnMainThread(this.reconnectMilliseconds);
        this.reconnectMilliseconds = Math.min(this.reconnectMilliseconds * ((long) 2), 900000);
    }

    public boolean isConnected() {
        BillingClient billingClient2 = this.billingClient;
        if (billingClient2 != null) {
            return billingClient2.isReady();
        }
        return false;
    }

    public void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> list, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(list, "inAppMessageTypes");
        Intrinsics.checkNotNullParameter(function0, "subscriptionStatusChange");
        if (list.isEmpty()) {
            LogUtilsKt.errorLog$default(BillingStrings.BILLING_UNSPECIFIED_INAPP_MESSAGE_TYPES, (Throwable) null, 2, (Object) null);
            return;
        }
        InAppMessageParams.Builder newBuilder = InAppMessageParams.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        for (InAppMessageType inAppMessageCategoryId$purchases_defaultsRelease : list) {
            newBuilder.addInAppMessageCategoryToShow(inAppMessageCategoryId$purchases_defaultsRelease.getInAppMessageCategoryId$purchases_defaultsRelease());
        }
        InAppMessageParams build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "inAppMessageParamsBuilder.build()");
        executeRequestOnUIThread$default(this, (Long) null, new BillingWrapper$showInAppMessagesIfNeeded$1(this, new WeakReference(activity), build, function0), 1, (Object) null);
    }

    public void getStorefront(Function1<? super String, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        LogUtilsKt.verboseLog(BillingStrings.BILLING_INITIATE_GETTING_COUNTRY_CODE);
        BillingClientUseCase.run$default(new GetBillingConfigUseCase(new GetBillingConfigUseCaseParams(getAppInBackground()), this.deviceCache, new BillingWrapper$getStorefront$1(function1), function12, new BillingWrapper$getStorefront$2(this), new BillingWrapper$getStorefront$3(this)), 0, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void withConnectedClient(Function1<? super BillingClient, Unit> function1) {
        BillingClient billingClient2 = this.billingClient;
        Unit unit = null;
        if (billingClient2 != null) {
            if (!billingClient2.isReady()) {
                billingClient2 = null;
            }
            if (billingClient2 != null) {
                function1.invoke(billingClient2);
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            LogIntent logIntent = LogIntent.GOOGLE_WARNING;
            String format = String.format(BillingStrings.BILLING_CLIENT_DISCONNECTED, Arrays.copyOf(new Object[]{getStackTrace()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
        }
    }

    private final String getStackTrace() {
        StringWriter stringWriter = new StringWriter();
        new Throwable().printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "stringWriter.toString()");
        return stringWriter2;
    }

    private final void getStoreTransaction(Purchase purchase, Function1<? super StoreTransaction, Unit> function1) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(BillingStrings.BILLING_WRAPPER_PURCHASES_UPDATED, Arrays.copyOf(new Object[]{PurchaseExtensionsKt.toHumanReadableDescription(purchase)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        synchronized (this) {
            PurchaseContext purchaseContext2 = this.purchaseContext.get(PurchaseExtensionsKt.getFirstProductId(purchase));
            if (purchaseContext2 == null || purchaseContext2.getProductType() == null) {
                String purchaseToken = purchase.getPurchaseToken();
                Intrinsics.checkNotNullExpressionValue(purchaseToken, "purchase.purchaseToken");
                getPurchaseType$purchases_defaultsRelease(purchaseToken, new BillingWrapper$getStoreTransaction$1$2(function1, purchase));
                Unit unit = Unit.INSTANCE;
                return;
            }
            function1.invoke(StoreTransactionConversionsKt.toStoreTransaction(purchase, purchaseContext2));
        }
    }

    private final void trackProductDetailsNotSupportedIfNeeded() {
        if (this.diagnosticsTrackerIfEnabled != null) {
            BillingClient billingClient2 = this.billingClient;
            BillingResult isFeatureSupported = billingClient2 != null ? billingClient2.isFeatureSupported(BillingClient.FeatureType.PRODUCT_DETAILS) : null;
            if (isFeatureSupported != null && isFeatureSupported.getResponseCode() == -2) {
                DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
                int responseCode = isFeatureSupported.getResponseCode();
                String debugMessage = isFeatureSupported.getDebugMessage();
                Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
                diagnosticsTracker.trackProductDetailsNotSupported(responseCode, debugMessage);
            }
        }
    }

    /* access modifiers changed from: private */
    public final Result<BillingFlowParams, PurchasesError> buildPurchaseParams(GooglePurchasingData googlePurchasingData, ReplaceProductInfo replaceProductInfo, String str, Boolean bool) {
        if (googlePurchasingData instanceof GooglePurchasingData.InAppProduct) {
            return buildOneTimePurchaseParams((GooglePurchasingData.InAppProduct) googlePurchasingData, str, bool);
        }
        if (googlePurchasingData instanceof GooglePurchasingData.Subscription) {
            return buildSubscriptionPurchaseParams((GooglePurchasingData.Subscription) googlePurchasingData, replaceProductInfo, str, bool);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<BillingFlowParams, PurchasesError> buildOneTimePurchaseParams(GooglePurchasingData.InAppProduct inAppProduct, String str, Boolean bool) {
        BillingFlowParams.ProductDetailsParams.Builder newBuilder = BillingFlowParams.ProductDetailsParams.newBuilder();
        newBuilder.setProductDetails(inAppProduct.getProductDetails());
        BillingFlowParams.ProductDetailsParams build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().apply {\n   …etails)\n        }.build()");
        BillingFlowParams.Builder obfuscatedAccountId = BillingFlowParams.newBuilder().setProductDetailsParamsList(CollectionsKt.listOf(build)).setObfuscatedAccountId(UtilsKt.sha256(str));
        if (bool != null) {
            obfuscatedAccountId.setIsOfferPersonalized(bool.booleanValue());
        }
        BillingFlowParams build2 = obfuscatedAccountId.build();
        Intrinsics.checkNotNullExpressionValue(build2, "newBuilder()\n           …\n                .build()");
        return new Result.Success<>(build2);
    }

    private final Result<BillingFlowParams, PurchasesError> buildSubscriptionPurchaseParams(GooglePurchasingData.Subscription subscription, ReplaceProductInfo replaceProductInfo, String str, Boolean bool) {
        BillingFlowParams.ProductDetailsParams.Builder newBuilder = BillingFlowParams.ProductDetailsParams.newBuilder();
        newBuilder.setOfferToken(subscription.getToken());
        newBuilder.setProductDetails(subscription.getProductDetails());
        BillingFlowParams.ProductDetailsParams build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().apply {\n   …etails)\n        }.build()");
        BillingFlowParams.Builder productDetailsParamsList = BillingFlowParams.newBuilder().setProductDetailsParamsList(CollectionsKt.listOf(build));
        if (replaceProductInfo != null) {
            Intrinsics.checkNotNullExpressionValue(productDetailsParamsList, "buildSubscriptionPurchas…arams$lambda$29$lambda$27");
            BillingFlowParamsExtensionsKt.setUpgradeInfo(productDetailsParamsList, replaceProductInfo);
            Unit unit = Unit.INSTANCE;
        } else {
            Intrinsics.checkNotNullExpressionValue(productDetailsParamsList.setObfuscatedAccountId(UtilsKt.sha256(str)), "setObfuscatedAccountId(appUserID.sha256())");
        }
        if (bool != null) {
            productDetailsParamsList.setIsOfferPersonalized(bool.booleanValue());
        }
        BillingFlowParams build2 = productDetailsParamsList.build();
        Intrinsics.checkNotNullExpressionValue(build2, "newBuilder()\n           …\n                .build()");
        return new Result.Success<>(build2);
    }

    private final synchronized void sendErrorsToAllPendingRequests(PurchasesError purchasesError) {
        while (true) {
            Pair poll = this.serviceRequests.poll();
            if (poll != null) {
                this.mainHandler.post(new BillingWrapper$$ExternalSyntheticLambda5((Function1) poll.component1(), purchasesError));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void sendErrorsToAllPendingRequests$lambda$31$lambda$30(Function1 function1, PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(function1, "$serviceRequest");
        Intrinsics.checkNotNullParameter(purchasesError, "$error");
        function1.invoke(purchasesError);
    }
}
