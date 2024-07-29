package com.onesignal.core.internal.purchases.impl;

import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.PurchaseInfo;
import com.onesignal.user.internal.operations.TrackPurchaseOperation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0002\u001f B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0018\u00010\u0013R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/onesignal/core/internal/purchases/impl/TrackAmazonPurchase;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/identity/IdentityModelStore;)V", "canTrack", "", "listenerHandlerField", "Ljava/lang/reflect/Field;", "listenerHandlerObject", "", "osPurchasingListener", "Lcom/onesignal/core/internal/purchases/impl/TrackAmazonPurchase$OSPurchasingListener;", "registerListenerOnMainThread", "logAmazonIAPListenerError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onFocus", "firedOnSubscribe", "onUnfocused", "setListener", "start", "Companion", "OSPurchasingListener", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TrackAmazonPurchase.kt */
public final class TrackAmazonPurchase implements IStartableService, IApplicationLifecycleHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final IOperationRepo _operationRepo;
    private boolean canTrack;
    private Field listenerHandlerField;
    private Object listenerHandlerObject;
    /* access modifiers changed from: private */
    public OSPurchasingListener osPurchasingListener;
    private boolean registerListenerOnMainThread;

    public void onFocus(boolean z) {
    }

    public TrackAmazonPurchase(IApplicationService iApplicationService, IOperationRepo iOperationRepo, ConfigModelStore configModelStore, IdentityModelStore identityModelStore) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iOperationRepo, "_operationRepo");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(identityModelStore, "_identityModelStore");
        this._applicationService = iApplicationService;
        this._operationRepo = iOperationRepo;
        this._configModelStore = configModelStore;
        this._identityModelStore = identityModelStore;
    }

    public void start() {
        if (Companion.canTrack()) {
            try {
                Class<?> cls = Class.forName("com.amazon.device.iap.internal.d");
                try {
                    this.listenerHandlerObject = cls.getMethod("d", new Class[0]).invoke((Object) null, new Object[0]);
                } catch (NullPointerException unused) {
                    try {
                        this.listenerHandlerObject = cls.getMethod("e", new Class[0]).invoke((Object) null, new Object[0]);
                        this.registerListenerOnMainThread = true;
                    } catch (NullPointerException unused2) {
                        this.listenerHandlerObject = cls.getMethod("g", new Class[0]).invoke((Object) null, new Object[0]);
                        this.registerListenerOnMainThread = true;
                    }
                }
                Field declaredField = cls.getDeclaredField("f");
                declaredField.setAccessible(true);
                OSPurchasingListener oSPurchasingListener = new OSPurchasingListener(this, this._operationRepo, this._configModelStore, this._identityModelStore);
                this.osPurchasingListener = oSPurchasingListener;
                Intrinsics.checkNotNull(oSPurchasingListener);
                oSPurchasingListener.setOrgPurchasingListener((PurchasingListener) declaredField.get(this.listenerHandlerObject));
                this.listenerHandlerField = declaredField;
                this.canTrack = true;
                setListener();
            } catch (ClassNotFoundException e) {
                logAmazonIAPListenerError(e);
            } catch (IllegalAccessException e2) {
                logAmazonIAPListenerError(e2);
            } catch (InvocationTargetException e3) {
                logAmazonIAPListenerError(e3);
            } catch (NoSuchMethodException e4) {
                logAmazonIAPListenerError(e4);
            } catch (NoSuchFieldException e5) {
                logAmazonIAPListenerError(e5);
            } catch (ClassCastException e6) {
                logAmazonIAPListenerError(e6);
            }
            this._applicationService.addApplicationLifecycleHandler(this);
        }
    }

    private final void logAmazonIAPListenerError(Exception exc) {
        Logging.error("Error adding Amazon IAP listener.", exc);
        exc.printStackTrace();
    }

    public void onUnfocused() {
        if (this.canTrack) {
            try {
                Field field = this.listenerHandlerField;
                Intrinsics.checkNotNull(field);
                PurchasingListener purchasingListener = (PurchasingListener) field.get(this.listenerHandlerObject);
                OSPurchasingListener oSPurchasingListener = this.osPurchasingListener;
                if (purchasingListener != oSPurchasingListener) {
                    Intrinsics.checkNotNull(oSPurchasingListener);
                    oSPurchasingListener.setOrgPurchasingListener(purchasingListener);
                    setListener();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private final void setListener() {
        if (this.registerListenerOnMainThread) {
            ThreadUtilsKt.suspendifyOnMain(new TrackAmazonPurchase$setListener$1(this, (Continuation<? super TrackAmazonPurchase$setListener$1>) null));
        } else {
            PurchasingService.registerListener(this._applicationService.getAppContext(), this.osPurchasingListener);
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/onesignal/core/internal/purchases/impl/TrackAmazonPurchase$OSPurchasingListener;", "Lcom/amazon/device/iap/PurchasingListener;", "_operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "(Lcom/onesignal/core/internal/purchases/impl/TrackAmazonPurchase;Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/identity/IdentityModelStore;)V", "currentMarket", "", "lastRequestId", "Lcom/amazon/device/iap/model/RequestId;", "orgPurchasingListener", "getOrgPurchasingListener", "()Lcom/amazon/device/iap/PurchasingListener;", "setOrgPurchasingListener", "(Lcom/amazon/device/iap/PurchasingListener;)V", "marketToCurrencyCode", "market", "onProductDataResponse", "", "response", "Lcom/amazon/device/iap/model/ProductDataResponse;", "onPurchaseResponse", "Lcom/amazon/device/iap/model/PurchaseResponse;", "onPurchaseUpdatesResponse", "Lcom/amazon/device/iap/model/PurchaseUpdatesResponse;", "onUserDataResponse", "Lcom/amazon/device/iap/model/UserDataResponse;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TrackAmazonPurchase.kt */
    private final class OSPurchasingListener implements PurchasingListener {
        private final ConfigModelStore _configModelStore;
        private final IdentityModelStore _identityModelStore;
        private final IOperationRepo _operationRepo;
        private String currentMarket;
        private RequestId lastRequestId;
        private PurchasingListener orgPurchasingListener;
        final /* synthetic */ TrackAmazonPurchase this$0;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: TrackAmazonPurchase.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ProductDataResponse.RequestStatus.values().length];
                iArr[ProductDataResponse.RequestStatus.SUCCESSFUL.ordinal()] = 1;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final PurchasingListener getOrgPurchasingListener() {
            return this.orgPurchasingListener;
        }

        public final void setOrgPurchasingListener(PurchasingListener purchasingListener) {
            this.orgPurchasingListener = purchasingListener;
        }

        public OSPurchasingListener(TrackAmazonPurchase trackAmazonPurchase, IOperationRepo iOperationRepo, ConfigModelStore configModelStore, IdentityModelStore identityModelStore) {
            Intrinsics.checkNotNullParameter(iOperationRepo, "_operationRepo");
            Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
            Intrinsics.checkNotNullParameter(identityModelStore, "_identityModelStore");
            this.this$0 = trackAmazonPurchase;
            this._operationRepo = iOperationRepo;
            this._configModelStore = configModelStore;
            this._identityModelStore = identityModelStore;
        }

        private final String marketToCurrencyCode(String str) {
            if (str == null) {
                return "";
            }
            int hashCode = str.hashCode();
            return hashCode != 2100 ? hashCode != 2128 ? hashCode != 2142 ? hashCode != 2177 ? hashCode != 2222 ? hashCode != 2252 ? hashCode != 2267 ? hashCode != 2347 ? hashCode != 2374 ? (hashCode == 2718 && str.equals("US")) ? "USD" : "" : !str.equals("JP") ? "" : "JPY" : !str.equals("IT") ? "" : "EUR" : !str.equals("GB") ? "" : "GBP" : !str.equals("FR") ? "" : "EUR" : !str.equals("ES") ? "" : "EUR" : !str.equals("DE") ? "" : "EUR" : !str.equals("CA") ? "" : "CDN" : !str.equals("BR") ? "" : "BRL" : !str.equals("AU") ? "" : "AUD";
        }

        public void onProductDataResponse(ProductDataResponse productDataResponse) {
            Intrinsics.checkNotNullParameter(productDataResponse, "response");
            RequestId requestId = this.lastRequestId;
            if (requestId == null || !Intrinsics.areEqual((Object) String.valueOf(requestId), (Object) productDataResponse.getRequestId().toString())) {
                PurchasingListener purchasingListener = this.orgPurchasingListener;
                if (purchasingListener != null) {
                    Intrinsics.checkNotNull(purchasingListener);
                    purchasingListener.onProductDataResponse(productDataResponse);
                    return;
                }
                return;
            }
            ProductDataResponse.RequestStatus requestStatus = productDataResponse.getRequestStatus();
            if (requestStatus != null && WhenMappings.$EnumSwitchMapping$0[requestStatus.ordinal()] == 1) {
                List arrayList = new ArrayList();
                Map<String, Product> productData = productDataResponse.getProductData();
                BigDecimal bigDecimal = new BigDecimal(0);
                BigDecimal bigDecimal2 = bigDecimal;
                for (String str : productData.keySet()) {
                    Product product = productData.get(str);
                    Intrinsics.checkNotNull(product);
                    String sku = product.getSku();
                    String marketToCurrencyCode = marketToCurrencyCode(this.currentMarket);
                    String price = product.getPrice();
                    Intrinsics.checkNotNullExpressionValue(price, "priceStr");
                    if (!new Regex("^[0-9]").matches(price)) {
                        Intrinsics.checkNotNullExpressionValue(price, "priceStr");
                        price = price.substring(1);
                        Intrinsics.checkNotNullExpressionValue(price, "this as java.lang.String).substring(startIndex)");
                    }
                    BigDecimal bigDecimal3 = new BigDecimal(price);
                    bigDecimal2 = bigDecimal2.add(bigDecimal3);
                    Intrinsics.checkNotNullExpressionValue(bigDecimal2, "this.add(other)");
                    Intrinsics.checkNotNullExpressionValue(sku, "sku");
                    arrayList.add(new PurchaseInfo(sku, marketToCurrencyCode, bigDecimal3));
                }
                IOperationRepo.DefaultImpls.enqueue$default(this._operationRepo, new TrackPurchaseOperation(((ConfigModel) this._configModelStore.getModel()).getAppId(), ((IdentityModel) this._identityModelStore.getModel()).getOnesignalId(), false, bigDecimal2, arrayList), false, 2, (Object) null);
            }
        }

        public void onPurchaseResponse(PurchaseResponse purchaseResponse) {
            Intrinsics.checkNotNullParameter(purchaseResponse, "response");
            if (purchaseResponse.getRequestStatus() == PurchaseResponse.RequestStatus.SUCCESSFUL) {
                this.currentMarket = purchaseResponse.getUserData().getMarketplace();
                Set hashSet = new HashSet();
                String sku = purchaseResponse.getReceipt().getSku();
                Intrinsics.checkNotNullExpressionValue(sku, "response.receipt.sku");
                hashSet.add(sku);
                this.lastRequestId = PurchasingService.getProductData(hashSet);
            }
            PurchasingListener purchasingListener = this.orgPurchasingListener;
            if (purchasingListener != null) {
                Intrinsics.checkNotNull(purchasingListener);
                purchasingListener.onPurchaseResponse(purchaseResponse);
            }
        }

        public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse purchaseUpdatesResponse) {
            Intrinsics.checkNotNullParameter(purchaseUpdatesResponse, "response");
            PurchasingListener purchasingListener = this.orgPurchasingListener;
            if (purchasingListener != null) {
                Intrinsics.checkNotNull(purchasingListener);
                purchasingListener.onPurchaseUpdatesResponse(purchaseUpdatesResponse);
            }
        }

        public void onUserDataResponse(UserDataResponse userDataResponse) {
            Intrinsics.checkNotNullParameter(userDataResponse, "response");
            PurchasingListener purchasingListener = this.orgPurchasingListener;
            if (purchasingListener != null) {
                Intrinsics.checkNotNull(purchasingListener);
                purchasingListener.onUserDataResponse(userDataResponse);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/onesignal/core/internal/purchases/impl/TrackAmazonPurchase$Companion;", "", "()V", "canTrack", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TrackAmazonPurchase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean canTrack() {
            try {
                Class.forName("com.amazon.device.iap.PurchasingListener");
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
    }
}
