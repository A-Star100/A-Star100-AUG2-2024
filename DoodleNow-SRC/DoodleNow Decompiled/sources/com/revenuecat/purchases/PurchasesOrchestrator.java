package com.revenuecat.purchases;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer;
import com.revenuecat.purchases.common.offerings.OfferingsManager;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.PurchaseErrorCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import com.revenuecat.purchases.models.BillingFeature;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.paywalls.PaywallPresentedCache;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallEventsManager;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.strings.ConfigureStrings;
import com.revenuecat.purchases.strings.CustomerInfoStrings;
import com.revenuecat.purchases.strings.IdentityStrings;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.utils.AndroidVersionUtilsKt;
import com.revenuecat.purchases.utils.CustomActivityLifecycleHandler;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 æ\u00012\u00020\u00012\u00020\u0002:\u0002æ\u0001B·\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\u0006\u0010!\u001a\u00020\"\u0012\u0006\u0010#\u001a\u00020$\u0012\b\u0010%\u001a\u0004\u0018\u00010&\u0012\u0006\u0010'\u001a\u00020(\u0012\u0006\u0010)\u001a\u00020*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,¢\u0006\u0002\u0010-J\u0006\u0010X\u001a\u00020YJ\u0006\u0010Z\u001a\u00020YJ\u0016\u0010[\u001a\u00020Y2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0]H\u0002J\b\u0010^\u001a\u00020YH\u0002J\u000e\u0010_\u001a\b\u0012\u0004\u0012\u00020a0`H\u0002J\n\u0010b\u001a\u0004\u0018\u00010cH\u0002J\u0016\u0010d\u001a\u00020Y2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020hJ\u000e\u0010d\u001a\u00020Y2\u0006\u0010g\u001a\u00020hJ\u000e\u0010i\u001a\u00020Y2\u0006\u0010j\u001a\u00020kJJ\u0010l\u001a:\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020p\u0012\u0004\u0012\u00020Y0nj\u0002`q\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020Y0nj\u0002`s0m2\b\u0010t\u001a\u0004\u0018\u00010cH\u0002J(\u0010u\u001a\u00020Y2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00060`2\n\b\u0002\u0010w\u001a\u0004\u0018\u00010x2\u0006\u0010g\u001a\u00020yJ*\u0010z\u001a\u00020Y2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00060{2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020x0{2\u0006\u0010g\u001a\u00020yJ:\u0010z\u001a\u00020Y2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00060{2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020x0{2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020~0`2\u0006\u0010g\u001a\u00020yH\u0002J\u0013\u0010\u001a\u0004\u0018\u00010a2\u0007\u0010\u0001\u001a\u00020\u0006H\u0002JA\u0010\u0001\u001a:\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020p\u0012\u0004\u0012\u00020Y0nj\u0002`q\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020Y0nj\u0002`s0mH\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0007\u0010\u0001\u001a\u00020YJ\u001d\u0010\u0001\u001a\u00020Y2\u0007\u0010\u0001\u001a\u00020\u00062\u000b\b\u0002\u0010g\u001a\u0005\u0018\u00010\u0001J\u0013\u0010\u0001\u001a\u00020Y2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010hJ\u0013\u0010\u0001\u001a\u00020Y2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020YH\u0016J\t\u0010\u0001\u001a\u00020YH\u0016J\u0019\u0010\u0001\u001a\u00020Y2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010g\u001a\u00020aJ\u0007\u0010\u0001\u001a\u00020YJ`\u0010\u0001\u001a\u00020Y2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00062\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\u0006\u00109\u001a\u00020\u00062\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010/2\u0007\u0010j\u001a\u00030\u0001H\u0002¢\u0006\u0003\u0010\u0001J\u000f\u0010\u0001\u001a\u00020Y2\u0006\u0010g\u001a\u00020hJ\u0012\u0010\u0001\u001a\u00020Y2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010 \u0001\u001a\u00020Y2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010¢\u0001\u001a\u00020Y2\t\u0010£\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010¤\u0001\u001a\u00020Y2\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010¦\u0001\u001a\u00020Y2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u0006J\u001f\u0010¨\u0001\u001a\u00020Y2\u0016\u0010©\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060ª\u0001J\u0012\u0010«\u0001\u001a\u00020Y2\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010­\u0001\u001a\u00020Y2\t\u0010®\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010¯\u0001\u001a\u00020Y2\t\u0010°\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010±\u0001\u001a\u00020Y2\t\u0010²\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010³\u0001\u001a\u00020Y2\t\u0010´\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010µ\u0001\u001a\u00020Y2\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010·\u0001\u001a\u00020Y2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010¹\u0001\u001a\u00020Y2\t\u0010º\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010»\u0001\u001a\u00020Y2\t\u0010¼\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010½\u0001\u001a\u00020Y2\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010¿\u0001\u001a\u00020Y2\t\u0010À\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010Á\u0001\u001a\u00020Y2\t\u0010Â\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010Ã\u0001\u001a\u00020Y2\t\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010Å\u0001\u001a\u00020Y2\t\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010Ç\u0001\u001a\u00020Y2\t\u0010È\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010É\u0001\u001a\u00020/2\u0007\u0010Ê\u0001\u001a\u00020/H\u0002J!\u0010Ë\u0001\u001a\u00020Y2\b\u0010\u0001\u001a\u00030\u00012\u000e\u0010Ì\u0001\u001a\t\u0012\u0005\u0012\u00030Í\u00010`JD\u0010Î\u0001\u001a\u00020Y2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\u00062\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010j\u001a\u00020cJT\u0010Ï\u0001\u001a\u00020Y2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\u00062\b\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010/2\u0007\u0010Ð\u0001\u001a\u00020a¢\u0006\u0003\u0010Ñ\u0001J@\u0010Ò\u0001\u001a\u00020Y2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010/2\u0006\u0010j\u001a\u00020a¢\u0006\u0003\u0010Ó\u0001J\u0010\u0010Ô\u0001\u001a\u00020Y2\u0007\u0010\u0001\u001a\u00020\u0006J?\u0010Õ\u0001\u001a\u00020Y2\u0007\u0010Ö\u0001\u001a\u00020\u00062\u0007\u0010×\u0001\u001a\u00020\u00062\u0007\u0010Ø\u0001\u001a\u00020\u00062\t\u0010Ù\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010Ú\u0001\u001a\u0005\u0018\u00010Û\u0001¢\u0006\u0003\u0010Ü\u0001J\u0014\u0010Ý\u0001\u001a\u00020Y2\u000b\b\u0002\u0010j\u001a\u0005\u0018\u00010Þ\u0001J\t\u0010ß\u0001\u001a\u00020YH\u0002J\u0013\u0010à\u0001\u001a\u00020Y2\b\u0010á\u0001\u001a\u00030â\u0001H\u0007J\u001e\u0010ã\u0001\u001a\u00020Y2\u0006\u00109\u001a\u00020\u00062\u000b\b\u0002\u0010ä\u0001\u001a\u0004\u0018\u00010hH\u0002J\u0016\u0010[\u001a\u00020Y*\u00030\u00012\u0007\u0010å\u0001\u001a\u00020rH\u0002R$\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020/8F@FX\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0011\u00109\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R$\u0010<\u001a\u00020/2\u0006\u0010.\u001a\u00020/8F@FX\u000e¢\u0006\f\u001a\u0004\b=\u00102\"\u0004\b>\u00104R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010?\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b?\u00102R\u001b\u0010@\u001a\u00020A8BX\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bB\u0010CR\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0019\u001a\u00020\u001a8\u0007¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R$\u0010I\u001a\u00020H2\u0006\u0010.\u001a\u00020H8@@@X\u000e¢\u0006\f\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020O8F¢\u0006\u0006\u001a\u0004\bP\u0010QR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R(\u0010S\u001a\u0004\u0018\u00010R2\b\u0010.\u001a\u0004\u0018\u00010R8F@FX\u000e¢\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006ç\u0001"}, d2 = {"Lcom/revenuecat/purchases/PurchasesOrchestrator;", "Lcom/revenuecat/purchases/LifecycleDelegate;", "Lcom/revenuecat/purchases/utils/CustomActivityLifecycleHandler;", "application", "Landroid/app/Application;", "backingFieldAppUserID", "", "backend", "Lcom/revenuecat/purchases/common/Backend;", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "subscriberAttributesManager", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "customerInfoHelper", "Lcom/revenuecat/purchases/CustomerInfoHelper;", "customerInfoUpdateHandler", "Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;", "diagnosticsSynchronizer", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsSynchronizer;", "offlineEntitlementsManager", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "postReceiptHelper", "Lcom/revenuecat/purchases/PostReceiptHelper;", "postTransactionWithProductDetailsHelper", "Lcom/revenuecat/purchases/PostTransactionWithProductDetailsHelper;", "postPendingTransactionsHelper", "Lcom/revenuecat/purchases/PostPendingTransactionsHelper;", "syncPurchasesHelper", "Lcom/revenuecat/purchases/SyncPurchasesHelper;", "offeringsManager", "Lcom/revenuecat/purchases/common/offerings/OfferingsManager;", "paywallEventsManager", "Lcom/revenuecat/purchases/paywalls/events/PaywallEventsManager;", "paywallPresentedCache", "Lcom/revenuecat/purchases/paywalls/PaywallPresentedCache;", "purchasesStateCache", "Lcom/revenuecat/purchases/PurchasesStateCache;", "mainHandler", "Landroid/os/Handler;", "(Landroid/app/Application;Ljava/lang/String;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/CustomerInfoHelper;Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsSynchronizer;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;Lcom/revenuecat/purchases/PostReceiptHelper;Lcom/revenuecat/purchases/PostTransactionWithProductDetailsHelper;Lcom/revenuecat/purchases/PostPendingTransactionsHelper;Lcom/revenuecat/purchases/SyncPurchasesHelper;Lcom/revenuecat/purchases/common/offerings/OfferingsManager;Lcom/revenuecat/purchases/paywalls/events/PaywallEventsManager;Lcom/revenuecat/purchases/paywalls/PaywallPresentedCache;Lcom/revenuecat/purchases/PurchasesStateCache;Landroid/os/Handler;)V", "value", "", "allowSharingPlayStoreAccount", "getAllowSharingPlayStoreAccount", "()Z", "setAllowSharingPlayStoreAccount", "(Z)V", "getAppConfig", "()Lcom/revenuecat/purchases/common/AppConfig;", "setAppConfig", "(Lcom/revenuecat/purchases/common/AppConfig;)V", "appUserID", "getAppUserID", "()Ljava/lang/String;", "finishTransactions", "getFinishTransactions", "setFinishTransactions", "isAnonymous", "lifecycleHandler", "Lcom/revenuecat/purchases/AppLifecycleHandler;", "getLifecycleHandler", "()Lcom/revenuecat/purchases/AppLifecycleHandler;", "lifecycleHandler$delegate", "Lkotlin/Lazy;", "getOfflineEntitlementsManager", "()Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "Lcom/revenuecat/purchases/PurchasesState;", "state", "getState$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/PurchasesState;", "setState$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/PurchasesState;)V", "store", "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", "Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "updatedCustomerInfoListener", "getUpdatedCustomerInfoListener", "()Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "setUpdatedCustomerInfoListener", "(Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;)V", "close", "", "collectDeviceIdentifiers", "dispatch", "action", "Lkotlin/Function0;", "flushPaywallEvents", "getAndClearAllPurchaseCallbacks", "", "Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "getAndClearProductChangeCallback", "Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "getCustomerInfo", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "callback", "Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;", "getOfferings", "listener", "Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsCallback;", "getProductChangeCompletedCallbacks", "Landroid/util/Pair;", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/models/StoreTransaction;", "Lcom/revenuecat/purchases/CustomerInfo;", "Lcom/revenuecat/purchases/SuccessfulPurchaseCallback;", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/ErrorPurchaseCallback;", "productChangeListener", "getProducts", "productIds", "type", "Lcom/revenuecat/purchases/ProductType;", "Lcom/revenuecat/purchases/interfaces/GetStoreProductsCallback;", "getProductsOfTypes", "", "types", "collectedStoreProducts", "Lcom/revenuecat/purchases/models/StoreProduct;", "getPurchaseCallback", "productId", "getPurchaseCompletedCallbacks", "getPurchasesUpdatedListener", "Lcom/revenuecat/purchases/common/BillingAbstract$PurchasesUpdatedListener;", "invalidateCustomerInfoCache", "logIn", "newAppUserID", "Lcom/revenuecat/purchases/interfaces/LogInCallback;", "logOut", "onActivityStarted", "activity", "Landroid/app/Activity;", "onAppBackgrounded", "onAppForegrounded", "purchase", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams;", "removeUpdatedCustomerInfoListener", "replaceOldPurchaseWithNewProduct", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "oldProductId", "googleReplacementMode", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "isPersonalizedPrice", "Lcom/revenuecat/purchases/interfaces/PurchaseErrorCallback;", "(Lcom/revenuecat/purchases/models/PurchasingData;Ljava/lang/String;Lcom/revenuecat/purchases/models/GoogleReplacementMode;Landroid/app/Activity;Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Boolean;Lcom/revenuecat/purchases/interfaces/PurchaseErrorCallback;)V", "restorePurchases", "setAd", "ad", "setAdGroup", "adGroup", "setAdjustID", "adjustID", "setAirshipChannelID", "airshipChannelID", "setAppsflyerID", "appsflyerID", "setAttributes", "attributes", "", "setCampaign", "campaign", "setCleverTapID", "cleverTapID", "setCreative", "creative", "setDisplayName", "displayName", "setEmail", "email", "setFBAnonymousID", "fbAnonymousID", "setFirebaseAppInstanceID", "firebaseAppInstanceID", "setKeyword", "keyword", "setMediaSource", "mediaSource", "setMixpanelDistinctID", "mixpanelDistinctID", "setMparticleID", "mparticleID", "setOnesignalID", "onesignalID", "setOnesignalUserID", "onesignalUserID", "setPhoneNumber", "phoneNumber", "setPushToken", "fcmToken", "shouldRefreshCustomerInfo", "firstTimeInForeground", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "startDeprecatedProductChange", "startProductChange", "purchaseCallback", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/String;Lcom/revenuecat/purchases/models/GoogleReplacementMode;Ljava/lang/Boolean;Lcom/revenuecat/purchases/interfaces/PurchaseCallback;)V", "startPurchase", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Boolean;Lcom/revenuecat/purchases/interfaces/PurchaseCallback;)V", "switchUser", "syncObserverModeAmazonPurchase", "productID", "receiptID", "amazonUserID", "isoCurrencyCode", "price", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "syncPurchases", "Lcom/revenuecat/purchases/interfaces/SyncPurchasesCallback;", "synchronizeSubscriberAttributesIfNeeded", "track", "paywallEvent", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "updateAllCaches", "completion", "error", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesOrchestrator.kt */
public final class PurchasesOrchestrator implements LifecycleDelegate, CustomActivityLifecycleHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String frameworkVersion = "7.6.0";
    /* access modifiers changed from: private */
    public static PlatformInfo platformInfo = new PlatformInfo("native", (String) null);
    /* access modifiers changed from: private */
    public static URL proxyURL;
    private AppConfig appConfig;
    /* access modifiers changed from: private */
    public final Application application;
    private final Backend backend;
    /* access modifiers changed from: private */
    public final BillingAbstract billing;
    private final CustomerInfoHelper customerInfoHelper;
    /* access modifiers changed from: private */
    public final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    private final DeviceCache deviceCache;
    /* access modifiers changed from: private */
    public final IdentityManager identityManager;
    private final Lazy lifecycleHandler$delegate;
    private final Handler mainHandler;
    /* access modifiers changed from: private */
    public final OfferingsManager offeringsManager;
    private final OfflineEntitlementsManager offlineEntitlementsManager;
    private final PaywallEventsManager paywallEventsManager;
    private final PaywallPresentedCache paywallPresentedCache;
    /* access modifiers changed from: private */
    public final PostPendingTransactionsHelper postPendingTransactionsHelper;
    /* access modifiers changed from: private */
    public final PostReceiptHelper postReceiptHelper;
    /* access modifiers changed from: private */
    public final PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper;
    private final PurchasesStateCache purchasesStateCache;
    private final SubscriberAttributesManager subscriberAttributesManager;
    private final SyncPurchasesHelper syncPurchasesHelper;

    public final AppConfig getAppConfig() {
        return this.appConfig;
    }

    public final OfflineEntitlementsManager getOfflineEntitlementsManager() {
        return this.offlineEntitlementsManager;
    }

    public final void setAppConfig(AppConfig appConfig2) {
        Intrinsics.checkNotNullParameter(appConfig2, "<set-?>");
        this.appConfig = appConfig2;
    }

    public PurchasesOrchestrator(Application application2, String str, Backend backend2, BillingAbstract billingAbstract, DeviceCache deviceCache2, IdentityManager identityManager2, SubscriberAttributesManager subscriberAttributesManager2, AppConfig appConfig2, CustomerInfoHelper customerInfoHelper2, CustomerInfoUpdateHandler customerInfoUpdateHandler2, DiagnosticsSynchronizer diagnosticsSynchronizer, OfflineEntitlementsManager offlineEntitlementsManager2, PostReceiptHelper postReceiptHelper2, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper2, PostPendingTransactionsHelper postPendingTransactionsHelper2, SyncPurchasesHelper syncPurchasesHelper2, OfferingsManager offeringsManager2, PaywallEventsManager paywallEventsManager2, PaywallPresentedCache paywallPresentedCache2, PurchasesStateCache purchasesStateCache2, Handler handler) {
        Application application3 = application2;
        Backend backend3 = backend2;
        BillingAbstract billingAbstract2 = billingAbstract;
        DeviceCache deviceCache3 = deviceCache2;
        IdentityManager identityManager3 = identityManager2;
        SubscriberAttributesManager subscriberAttributesManager3 = subscriberAttributesManager2;
        AppConfig appConfig3 = appConfig2;
        CustomerInfoHelper customerInfoHelper3 = customerInfoHelper2;
        CustomerInfoUpdateHandler customerInfoUpdateHandler3 = customerInfoUpdateHandler2;
        OfflineEntitlementsManager offlineEntitlementsManager3 = offlineEntitlementsManager2;
        PostReceiptHelper postReceiptHelper3 = postReceiptHelper2;
        PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper3 = postTransactionWithProductDetailsHelper2;
        PostPendingTransactionsHelper postPendingTransactionsHelper3 = postPendingTransactionsHelper2;
        SyncPurchasesHelper syncPurchasesHelper3 = syncPurchasesHelper2;
        PaywallPresentedCache paywallPresentedCache3 = paywallPresentedCache2;
        Intrinsics.checkNotNullParameter(application3, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(backend3, "backend");
        Intrinsics.checkNotNullParameter(billingAbstract2, "billing");
        Intrinsics.checkNotNullParameter(deviceCache3, "deviceCache");
        Intrinsics.checkNotNullParameter(identityManager3, "identityManager");
        Intrinsics.checkNotNullParameter(subscriberAttributesManager3, "subscriberAttributesManager");
        Intrinsics.checkNotNullParameter(appConfig3, "appConfig");
        Intrinsics.checkNotNullParameter(customerInfoHelper3, "customerInfoHelper");
        Intrinsics.checkNotNullParameter(customerInfoUpdateHandler3, "customerInfoUpdateHandler");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager3, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(postReceiptHelper3, "postReceiptHelper");
        Intrinsics.checkNotNullParameter(postTransactionWithProductDetailsHelper3, "postTransactionWithProductDetailsHelper");
        Intrinsics.checkNotNullParameter(postPendingTransactionsHelper3, "postPendingTransactionsHelper");
        Intrinsics.checkNotNullParameter(syncPurchasesHelper3, "syncPurchasesHelper");
        Intrinsics.checkNotNullParameter(offeringsManager2, "offeringsManager");
        Intrinsics.checkNotNullParameter(paywallPresentedCache2, "paywallPresentedCache");
        Intrinsics.checkNotNullParameter(purchasesStateCache2, "purchasesStateCache");
        this.application = application3;
        this.backend = backend3;
        this.billing = billingAbstract2;
        this.deviceCache = deviceCache3;
        this.identityManager = identityManager3;
        this.subscriberAttributesManager = subscriberAttributesManager3;
        this.appConfig = appConfig3;
        this.customerInfoHelper = customerInfoHelper3;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler3;
        this.offlineEntitlementsManager = offlineEntitlementsManager3;
        this.postReceiptHelper = postReceiptHelper3;
        this.postTransactionWithProductDetailsHelper = postTransactionWithProductDetailsHelper3;
        this.postPendingTransactionsHelper = postPendingTransactionsHelper3;
        this.syncPurchasesHelper = syncPurchasesHelper3;
        this.offeringsManager = offeringsManager2;
        this.paywallEventsManager = paywallEventsManager2;
        this.paywallPresentedCache = paywallPresentedCache2;
        this.purchasesStateCache = purchasesStateCache2;
        this.mainHandler = handler;
        this.lifecycleHandler$delegate = LazyKt.lazy(new PurchasesOrchestrator$lifecycleHandler$2(this));
        identityManager3.configure(str);
        billingAbstract2.setStateListener(new BillingAbstract.StateListener(this) {
            final /* synthetic */ PurchasesOrchestrator this$0;

            {
                this.this$0 = r1;
            }

            public void onConnected() {
                PostPendingTransactionsHelper.syncPendingPurchaseQueue$default(this.this$0.postPendingTransactionsHelper, this.this$0.getAllowSharingPlayStoreAccount(), (Function1) null, (Function1) null, 6, (Object) null);
                this.this$0.billing.getStorefront(PurchasesOrchestrator$1$onConnected$1.INSTANCE, PurchasesOrchestrator$1$onConnected$2.INSTANCE);
            }
        });
        billingAbstract2.setPurchasesUpdatedListener(getPurchasesUpdatedListener());
        BillingAbstract.startConnectionOnMainThread$default(billingAbstract2, 0, 1, (Object) null);
        dispatch(new Function0<Unit>(this) {
            final /* synthetic */ PurchasesOrchestrator this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                ProcessLifecycleOwner.get().getLifecycle().addObserver(this.this$0.getLifecycleHandler());
                this.this$0.application.registerActivityLifecycleCallbacks(this.this$0);
            }
        });
        if (!this.appConfig.getDangerousSettings().getAutoSyncPurchases()) {
            LogWrapperKt.log(LogIntent.WARNING, ConfigureStrings.AUTO_SYNC_PURCHASES_DISABLED);
        }
        if (AndroidVersionUtilsKt.isAndroidNOrNewer()) {
            if (diagnosticsSynchronizer != null) {
                diagnosticsSynchronizer.clearDiagnosticsFileIfTooBig();
            }
            if (diagnosticsSynchronizer != null) {
                diagnosticsSynchronizer.syncDiagnosticsFileIfNeeded();
            }
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        CustomActivityLifecycleHandler.DefaultImpls.onActivityCreated(this, activity, bundle);
    }

    public void onActivityDestroyed(Activity activity) {
        CustomActivityLifecycleHandler.DefaultImpls.onActivityDestroyed(this, activity);
    }

    public void onActivityPaused(Activity activity) {
        CustomActivityLifecycleHandler.DefaultImpls.onActivityPaused(this, activity);
    }

    public void onActivityResumed(Activity activity) {
        CustomActivityLifecycleHandler.DefaultImpls.onActivityResumed(this, activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        CustomActivityLifecycleHandler.DefaultImpls.onActivitySaveInstanceState(this, activity, bundle);
    }

    public void onActivityStopped(Activity activity) {
        CustomActivityLifecycleHandler.DefaultImpls.onActivityStopped(this, activity);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PurchasesOrchestrator(Application application2, String str, Backend backend2, BillingAbstract billingAbstract, DeviceCache deviceCache2, IdentityManager identityManager2, SubscriberAttributesManager subscriberAttributesManager2, AppConfig appConfig2, CustomerInfoHelper customerInfoHelper2, CustomerInfoUpdateHandler customerInfoUpdateHandler2, DiagnosticsSynchronizer diagnosticsSynchronizer, OfflineEntitlementsManager offlineEntitlementsManager2, PostReceiptHelper postReceiptHelper2, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper2, PostPendingTransactionsHelper postPendingTransactionsHelper2, SyncPurchasesHelper syncPurchasesHelper2, OfferingsManager offeringsManager2, PaywallEventsManager paywallEventsManager2, PaywallPresentedCache paywallPresentedCache2, PurchasesStateCache purchasesStateCache2, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application2, str, backend2, billingAbstract, deviceCache2, identityManager2, subscriberAttributesManager2, appConfig2, customerInfoHelper2, customerInfoUpdateHandler2, diagnosticsSynchronizer, offlineEntitlementsManager2, postReceiptHelper2, postTransactionWithProductDetailsHelper2, postPendingTransactionsHelper2, syncPurchasesHelper2, offeringsManager2, paywallEventsManager2, paywallPresentedCache2, purchasesStateCache2, (i & 1048576) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }

    public final PurchasesState getState$purchases_defaultsRelease() {
        return this.purchasesStateCache.getPurchasesState();
    }

    public final void setState$purchases_defaultsRelease(PurchasesState purchasesState) {
        Intrinsics.checkNotNullParameter(purchasesState, "value");
        this.purchasesStateCache.setPurchasesState(purchasesState);
    }

    public final synchronized boolean getFinishTransactions() {
        return this.appConfig.getFinishTransactions();
    }

    public final synchronized void setFinishTransactions(boolean z) {
        this.appConfig.setFinishTransactions(z);
    }

    public final synchronized String getAppUserID() {
        return this.identityManager.getCurrentAppUserID();
    }

    public final synchronized UpdatedCustomerInfoListener getUpdatedCustomerInfoListener() {
        return this.customerInfoUpdateHandler.getUpdatedCustomerInfoListener();
    }

    public final synchronized void setUpdatedCustomerInfoListener(UpdatedCustomerInfoListener updatedCustomerInfoListener) {
        this.customerInfoUpdateHandler.setUpdatedCustomerInfoListener(updatedCustomerInfoListener);
    }

    public final boolean isAnonymous() {
        return this.identityManager.currentUserIsAnonymous();
    }

    public final Store getStore() {
        return this.appConfig.getStore();
    }

    /* access modifiers changed from: private */
    public final AppLifecycleHandler getLifecycleHandler() {
        return (AppLifecycleHandler) this.lifecycleHandler$delegate.getValue();
    }

    public final synchronized boolean getAllowSharingPlayStoreAccount() {
        Boolean allowSharingPlayStoreAccount;
        allowSharingPlayStoreAccount = getState$purchases_defaultsRelease().getAllowSharingPlayStoreAccount();
        return allowSharingPlayStoreAccount != null ? allowSharingPlayStoreAccount.booleanValue() : this.identityManager.currentUserIsAnonymous();
    }

    public final synchronized void setAllowSharingPlayStoreAccount(boolean z) {
        setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), Boolean.valueOf(z), (Map) null, (ProductChangeCallback) null, false, false, 30, (Object) null));
    }

    public void onAppBackgrounded() {
        synchronized (this) {
            setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), (Boolean) null, (Map) null, (ProductChangeCallback) null, true, false, 23, (Object) null));
            Unit unit = Unit.INSTANCE;
        }
        LogWrapperKt.log(LogIntent.DEBUG, ConfigureStrings.APP_BACKGROUNDED);
        synchronizeSubscriberAttributesIfNeeded();
    }

    public void onAppForegrounded() {
        boolean firstTimeInForeground;
        synchronized (this) {
            firstTimeInForeground = getState$purchases_defaultsRelease().getFirstTimeInForeground();
            setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), (Boolean) null, (Map) null, (ProductChangeCallback) null, false, false, 7, (Object) null));
            Unit unit = Unit.INSTANCE;
        }
        LogWrapperKt.log(LogIntent.DEBUG, ConfigureStrings.APP_FOREGROUNDED);
        if (shouldRefreshCustomerInfo(firstTimeInForeground)) {
            LogWrapperKt.log(LogIntent.DEBUG, CustomerInfoStrings.CUSTOMERINFO_STALE_UPDATING_FOREGROUND);
            CustomerInfoHelper.retrieveCustomerInfo$default(this.customerInfoHelper, this.identityManager.getCurrentAppUserID(), CacheFetchPolicy.FETCH_CURRENT, false, getAllowSharingPlayStoreAccount(), (ReceiveCustomerInfoCallback) null, 16, (Object) null);
        }
        this.offeringsManager.onAppForeground(this.identityManager.getCurrentAppUserID());
        PostPendingTransactionsHelper.syncPendingPurchaseQueue$default(this.postPendingTransactionsHelper, getAllowSharingPlayStoreAccount(), (Function1) null, (Function1) null, 6, (Object) null);
        synchronizeSubscriberAttributesIfNeeded();
        OfflineEntitlementsManager.updateProductEntitlementMappingCacheIfStale$default(this.offlineEntitlementsManager, (Function1) null, 1, (Object) null);
        flushPaywallEvents();
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.appConfig.getShowInAppMessagesAutomatically()) {
            showInAppMessagesIfNeeded(activity, ArraysKt.toList((T[]) InAppMessageType.values()));
        }
    }

    public static /* synthetic */ void syncPurchases$default(PurchasesOrchestrator purchasesOrchestrator, SyncPurchasesCallback syncPurchasesCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            syncPurchasesCallback = null;
        }
        purchasesOrchestrator.syncPurchases(syncPurchasesCallback);
    }

    public final void syncPurchases(SyncPurchasesCallback syncPurchasesCallback) {
        this.syncPurchasesHelper.syncPurchases(getAllowSharingPlayStoreAccount(), getState$purchases_defaultsRelease().getAppInBackground(), new PurchasesOrchestrator$syncPurchases$1(syncPurchasesCallback), new PurchasesOrchestrator$syncPurchases$2(syncPurchasesCallback));
    }

    public final void syncObserverModeAmazonPurchase(String str, String str2, String str3, String str4, Double d) {
        Intrinsics.checkNotNullParameter(str, "productID");
        Intrinsics.checkNotNullParameter(str2, "receiptID");
        Intrinsics.checkNotNullParameter(str3, "amazonUserID");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(PurchaseStrings.SYNCING_PURCHASE_STORE_USER_ID, Arrays.copyOf(new Object[]{str2, str3}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        Set<String> previouslySentHashedTokens = this.deviceCache.getPreviouslySentHashedTokens();
        if (!previouslySentHashedTokens.contains(UtilsKt.sha1(str2))) {
            previouslySentHashedTokens = null;
        }
        if (previouslySentHashedTokens != null) {
            LogIntent logIntent2 = LogIntent.DEBUG;
            String format2 = String.format(PurchaseStrings.SYNCING_PURCHASE_SKIPPING, Arrays.copyOf(new Object[]{str2, str3}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
            LogWrapperKt.log(logIntent2, format2);
            return;
        }
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        this.billing.normalizePurchaseData(str5, str6, str7, new PurchasesOrchestrator$syncObserverModeAmazonPurchase$3(d, str4, this, str2, str3, this.identityManager.getCurrentAppUserID()), new PurchasesOrchestrator$syncObserverModeAmazonPurchase$4(str2, str3));
    }

    public final void getOfferings(ReceiveOfferingsCallback receiveOfferingsCallback) {
        Intrinsics.checkNotNullParameter(receiveOfferingsCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.offeringsManager.getOfferings(this.identityManager.getCurrentAppUserID(), getState$purchases_defaultsRelease().getAppInBackground(), new PurchasesOrchestrator$getOfferings$1(receiveOfferingsCallback), new PurchasesOrchestrator$getOfferings$2(receiveOfferingsCallback));
    }

    public static /* synthetic */ void getProducts$default(PurchasesOrchestrator purchasesOrchestrator, List list, ProductType productType, GetStoreProductsCallback getStoreProductsCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            productType = null;
        }
        purchasesOrchestrator.getProducts(list, productType, getStoreProductsCallback);
    }

    public final void getProducts(List<String> list, ProductType productType, GetStoreProductsCallback getStoreProductsCallback) {
        Set set;
        Intrinsics.checkNotNullParameter(list, "productIds");
        Intrinsics.checkNotNullParameter(getStoreProductsCallback, "callback");
        if (productType == null || (set = SetsKt.setOf(productType)) == null) {
            set = SetsKt.setOf(ProductType.SUBS, ProductType.INAPP);
        }
        getProductsOfTypes(CollectionsKt.toSet(list), set, new PurchasesOrchestrator$getProducts$1(getStoreProductsCallback));
    }

    public final void purchase(PurchaseParams purchaseParams, PurchaseCallback purchaseCallback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(purchaseParams, "purchaseParams");
        Intrinsics.checkNotNullParameter(purchaseCallback, "callback");
        String oldProductId = purchaseParams.getOldProductId();
        if (oldProductId != null) {
            startProductChange(purchaseParams.getActivity$purchases_defaultsRelease(), purchaseParams.getPurchasingData$purchases_defaultsRelease(), purchaseParams.getPresentedOfferingContext$purchases_defaultsRelease(), oldProductId, purchaseParams.getGoogleReplacementMode(), purchaseParams.isPersonalizedPrice(), purchaseCallback);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            startPurchase(purchaseParams.getActivity$purchases_defaultsRelease(), purchaseParams.getPurchasingData$purchases_defaultsRelease(), purchaseParams.getPresentedOfferingContext$purchases_defaultsRelease(), purchaseParams.isPersonalizedPrice(), purchaseCallback);
        }
    }

    public final void restorePurchases(ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        Intrinsics.checkNotNullParameter(receiveCustomerInfoCallback, "callback");
        LogWrapperKt.log(LogIntent.DEBUG, RestoreStrings.RESTORING_PURCHASE);
        if (!getAllowSharingPlayStoreAccount()) {
            LogWrapperKt.log(LogIntent.WARNING, RestoreStrings.SHARING_ACC_RESTORE_FALSE);
        }
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        this.billing.queryAllPurchases(currentAppUserID, new PurchasesOrchestrator$restorePurchases$1(this, receiveCustomerInfoCallback, currentAppUserID), new PurchasesOrchestrator$restorePurchases$2(this, receiveCustomerInfoCallback));
    }

    public static /* synthetic */ void logIn$default(PurchasesOrchestrator purchasesOrchestrator, String str, LogInCallback logInCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            logInCallback = null;
        }
        purchasesOrchestrator.logIn(str, logInCallback);
    }

    public final void logIn(String str, LogInCallback logInCallback) {
        Intrinsics.checkNotNullParameter(str, "newAppUserID");
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        Unit unit = null;
        if (Intrinsics.areEqual((Object) currentAppUserID, (Object) str)) {
            currentAppUserID = null;
        }
        if (currentAppUserID != null) {
            this.identityManager.logIn(str, new PurchasesOrchestrator$logIn$2$1(this, str, logInCallback), new PurchasesOrchestrator$logIn$2$2(this, logInCallback));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.customerInfoHelper.retrieveCustomerInfo(this.identityManager.getCurrentAppUserID(), CacheFetchPolicy.Companion.m1086default(), getState$purchases_defaultsRelease().getAppInBackground(), getAllowSharingPlayStoreAccount(), ListenerConversionsCommonKt.receiveCustomerInfoCallback(new PurchasesOrchestrator$logIn$3(this, logInCallback), new PurchasesOrchestrator$logIn$4(this, logInCallback)));
        }
    }

    public static /* synthetic */ void logOut$default(PurchasesOrchestrator purchasesOrchestrator, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchasesOrchestrator.logOut(receiveCustomerInfoCallback);
    }

    public final void logOut(ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        this.identityManager.logOut(new PurchasesOrchestrator$logOut$1(receiveCustomerInfoCallback, this));
    }

    public final void close() {
        synchronized (this) {
            PurchasesState state$purchases_defaultsRelease = getState$purchases_defaultsRelease();
            Map emptyMap = Collections.emptyMap();
            Intrinsics.checkNotNullExpressionValue(emptyMap, "emptyMap()");
            setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, (Boolean) null, emptyMap, (ProductChangeCallback) null, false, false, 29, (Object) null));
            Unit unit = Unit.INSTANCE;
        }
        this.backend.close();
        this.billing.close();
        setUpdatedCustomerInfoListener((UpdatedCustomerInfoListener) null);
        dispatch(new PurchasesOrchestrator$close$2(this));
    }

    public final void getCustomerInfo(ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        Intrinsics.checkNotNullParameter(receiveCustomerInfoCallback, "callback");
        getCustomerInfo(CacheFetchPolicy.Companion.m1086default(), receiveCustomerInfoCallback);
    }

    public final void getCustomerInfo(CacheFetchPolicy cacheFetchPolicy, ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        Intrinsics.checkNotNullParameter(cacheFetchPolicy, "fetchPolicy");
        Intrinsics.checkNotNullParameter(receiveCustomerInfoCallback, "callback");
        this.customerInfoHelper.retrieveCustomerInfo(this.identityManager.getCurrentAppUserID(), cacheFetchPolicy, getState$purchases_defaultsRelease().getAppInBackground(), getAllowSharingPlayStoreAccount(), receiveCustomerInfoCallback);
    }

    public final void removeUpdatedCustomerInfoListener() {
        setUpdatedCustomerInfoListener((UpdatedCustomerInfoListener) null);
    }

    public final void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> list) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(list, "inAppMessageTypes");
        this.billing.showInAppMessagesIfNeeded(activity, list, new PurchasesOrchestrator$showInAppMessagesIfNeeded$1(this));
    }

    public final void invalidateCustomerInfoCache() {
        LogWrapperKt.log(LogIntent.DEBUG, CustomerInfoStrings.INVALIDATING_CUSTOMERINFO_CACHE);
        this.deviceCache.clearCustomerInfoCache(getAppUserID());
    }

    public final void getProductsOfTypes(Set<String> set, Set<? extends ProductType> set2, GetStoreProductsCallback getStoreProductsCallback) {
        Intrinsics.checkNotNullParameter(set, "productIds");
        Intrinsics.checkNotNullParameter(set2, "types");
        Intrinsics.checkNotNullParameter(getStoreProductsCallback, "callback");
        Collection arrayList = new ArrayList();
        for (Object next : set2) {
            if (((ProductType) next) != ProductType.UNKNOWN) {
                arrayList.add(next);
            }
        }
        getProductsOfTypes(set, CollectionsKt.toSet((List) arrayList), CollectionsKt.emptyList(), getStoreProductsCallback);
    }

    public final void track(PaywallEvent paywallEvent) {
        PaywallEventsManager paywallEventsManager2;
        Intrinsics.checkNotNullParameter(paywallEvent, "paywallEvent");
        this.paywallPresentedCache.receiveEvent(paywallEvent);
        if (AndroidVersionUtilsKt.isAndroidNOrNewer() && (paywallEventsManager2 = this.paywallEventsManager) != null) {
            paywallEventsManager2.track(paywallEvent);
        }
    }

    public final void setAttributes(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "attributes");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAttributes"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttributes(map, getAppUserID());
    }

    public final void setEmail(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setEmail"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.Email.INSTANCE, str, getAppUserID());
    }

    public final void setPhoneNumber(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setPhoneNumber"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.PhoneNumber.INSTANCE, str, getAppUserID());
    }

    public final void setDisplayName(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setDisplayName"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.DisplayName.INSTANCE, str, getAppUserID());
    }

    public final void setPushToken(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setPushToken"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.FCMTokens.INSTANCE, str, getAppUserID());
    }

    public final void setMixpanelDistinctID(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setMixpanelDistinctID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.MixpanelDistinctId.INSTANCE, str, getAppUserID());
    }

    public final void setOnesignalID(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setOnesignalID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.OneSignal.INSTANCE, str, getAppUserID());
    }

    public final void setOnesignalUserID(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setOnesignalUserID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.OneSignalUserId.INSTANCE, str, getAppUserID());
    }

    public final void setAirshipChannelID(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAirshipChannelID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.Airship.INSTANCE, str, getAppUserID());
    }

    public final void setFirebaseAppInstanceID(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setFirebaseAppInstanceID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.FirebaseAppInstanceId.INSTANCE, str, getAppUserID());
    }

    public final void collectDeviceIdentifiers() {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"collectDeviceIdentifiers"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.collectDeviceIdentifiers(getAppUserID(), this.application);
    }

    public final void setAdjustID(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAdjustID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Adjust.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setAppsflyerID(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAppsflyerID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.AppsFlyer.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setFBAnonymousID(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setFBAnonymousID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Facebook.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setMparticleID(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setMparticleID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Mparticle.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setCleverTapID(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setCleverTapID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.CleverTap.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setMediaSource(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setMediaSource"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.MediaSource.INSTANCE, str, getAppUserID());
    }

    public final void setCampaign(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setCampaign"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Campaign.INSTANCE, str, getAppUserID());
    }

    public final void setAdGroup(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAdGroup"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.AdGroup.INSTANCE, str, getAppUserID());
    }

    public final void setAd(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAd"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Ad.INSTANCE, str, getAppUserID());
    }

    public final void setKeyword(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"seKeyword"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Keyword.INSTANCE, str, getAppUserID());
    }

    public final void setCreative(String str) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setCreative"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Creative.INSTANCE, str, getAppUserID());
    }

    public final void switchUser(String str) {
        Intrinsics.checkNotNullParameter(str, "newAppUserID");
        if (Intrinsics.areEqual((Object) this.identityManager.getCurrentAppUserID(), (Object) str)) {
            String format = String.format(IdentityStrings.SWITCHING_USER_SAME_APP_USER_ID, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogUtilsKt.warnLog(format);
            return;
        }
        this.identityManager.switchUser(str);
        OfferingsManager.fetchAndCacheOfferings$default(this.offeringsManager, str, getState$purchases_defaultsRelease().getAppInBackground(), (Function1) null, (Function1) null, 12, (Object) null);
    }

    private final boolean shouldRefreshCustomerInfo(boolean z) {
        if (this.appConfig.getCustomEntitlementComputation()) {
            return false;
        }
        if (z || this.deviceCache.isCustomerInfoCacheStale(getAppUserID(), false)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void getProductsOfTypes(Set<String> set, Set<? extends ProductType> set2, List<? extends StoreProduct> list, GetStoreProductsCallback getStoreProductsCallback) {
        Set mutableSet = CollectionsKt.toMutableSet(set2);
        ProductType productType = (ProductType) CollectionsKt.firstOrNull(mutableSet);
        Unit unit = null;
        if (productType != null) {
            mutableSet.remove(productType);
        } else {
            productType = null;
        }
        if (productType != null) {
            this.billing.queryProductDetailsAsync(productType, set, new PurchasesOrchestrator$getProductsOfTypes$1$1(this, set, mutableSet, list, getStoreProductsCallback), new PurchasesOrchestrator$getProductsOfTypes$1$2(this, getStoreProductsCallback));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            PurchasesOrchestrator purchasesOrchestrator = this;
            getStoreProductsCallback.onReceived(list);
        }
    }

    static /* synthetic */ void updateAllCaches$default(PurchasesOrchestrator purchasesOrchestrator, String str, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchasesOrchestrator.updateAllCaches(str, receiveCustomerInfoCallback);
    }

    /* access modifiers changed from: private */
    public final void updateAllCaches(String str, ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        boolean appInBackground = getState$purchases_defaultsRelease().getAppInBackground();
        String str2 = str;
        this.customerInfoHelper.retrieveCustomerInfo(str2, CacheFetchPolicy.FETCH_CURRENT, appInBackground, getAllowSharingPlayStoreAccount(), receiveCustomerInfoCallback);
        OfferingsManager.fetchAndCacheOfferings$default(this.offeringsManager, str2, appInBackground, (Function1) null, (Function1) null, 12, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void dispatch(Function0<Unit> function0) {
        if (!Intrinsics.areEqual((Object) Thread.currentThread(), (Object) Looper.getMainLooper().getThread())) {
            Handler handler = this.mainHandler;
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new PurchasesOrchestrator$$ExternalSyntheticLambda0(function0));
            return;
        }
        function0.invoke();
    }

    /* access modifiers changed from: private */
    public static final void dispatch$lambda$16(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    public final PurchaseCallback getPurchaseCallback(String str) {
        PurchaseCallback purchaseCallback = getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId().get(str);
        PurchasesState state$purchases_defaultsRelease = getState$purchases_defaultsRelease();
        Map<String, PurchaseCallback> purchaseCallbacksByProductId = getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId();
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : purchaseCallbacksByProductId.entrySet()) {
            if (!Intrinsics.areEqual(next.getKey(), (Object) str)) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, (Boolean) null, linkedHashMap, (ProductChangeCallback) null, false, false, 29, (Object) null));
        return purchaseCallback;
    }

    /* access modifiers changed from: private */
    public final ProductChangeCallback getAndClearProductChangeCallback() {
        ProductChangeCallback deprecatedProductChangeCallback = getState$purchases_defaultsRelease().getDeprecatedProductChangeCallback();
        setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), (Boolean) null, (Map) null, (ProductChangeCallback) null, false, false, 27, (Object) null));
        return deprecatedProductChangeCallback;
    }

    private final BillingAbstract.PurchasesUpdatedListener getPurchasesUpdatedListener() {
        return new PurchasesOrchestrator$getPurchasesUpdatedListener$1(this);
    }

    /* access modifiers changed from: private */
    public final List<PurchaseCallback> getAndClearAllPurchaseCallbacks() {
        List<PurchaseCallback> list;
        synchronized (this) {
            Map<String, PurchaseCallback> purchaseCallbacksByProductId = getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId();
            PurchasesState state$purchases_defaultsRelease = getState$purchases_defaultsRelease();
            Map emptyMap = Collections.emptyMap();
            Intrinsics.checkNotNullExpressionValue(emptyMap, "emptyMap()");
            setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, (Boolean) null, emptyMap, (ProductChangeCallback) null, false, false, 29, (Object) null));
            list = CollectionsKt.toList(purchaseCallbacksByProductId.values());
        }
        return list;
    }

    /* access modifiers changed from: private */
    public final Pair<Function2<StoreTransaction, CustomerInfo, Unit>, Function2<StoreTransaction, PurchasesError, Unit>> getPurchaseCompletedCallbacks() {
        return new Pair<>(new PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1(this), new PurchasesOrchestrator$getPurchaseCompletedCallbacks$onError$1(this));
    }

    /* access modifiers changed from: private */
    public final Pair<Function2<StoreTransaction, CustomerInfo, Unit>, Function2<StoreTransaction, PurchasesError, Unit>> getProductChangeCompletedCallbacks(ProductChangeCallback productChangeCallback) {
        return new Pair<>(new PurchasesOrchestrator$getProductChangeCompletedCallbacks$onSuccess$1(productChangeCallback, this), new PurchasesOrchestrator$getProductChangeCompletedCallbacks$onError$1(productChangeCallback, this));
    }

    /* access modifiers changed from: private */
    public final void dispatch(PurchaseErrorCallback purchaseErrorCallback, PurchasesError purchasesError) {
        dispatch(new PurchasesOrchestrator$dispatch$1(purchaseErrorCallback, purchasesError));
    }

    public final void startPurchase(Activity activity, PurchasingData purchasingData, PresentedOfferingContext presentedOfferingContext, Boolean bool, PurchaseCallback purchaseCallback) {
        String str;
        String str2;
        Unit unit;
        String offeringIdentifier;
        PurchasingData purchasingData2 = purchasingData;
        PurchaseCallback purchaseCallback2 = purchaseCallback;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(purchasingData2, "purchasingData");
        Intrinsics.checkNotNullParameter(purchaseCallback2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        LogIntent logIntent = LogIntent.PURCHASE;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(purchasingData2);
        sb.append(' ');
        if (presentedOfferingContext == null || (offeringIdentifier = presentedOfferingContext.getOfferingIdentifier()) == null) {
            str = null;
        } else {
            str = PurchaseStrings.OFFERING + offeringIdentifier;
        }
        sb.append(str);
        objArr[0] = sb.toString();
        String format = String.format(PurchaseStrings.PURCHASE_STARTED, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        synchronized (this) {
            if (!this.appConfig.getFinishTransactions()) {
                LogWrapperKt.log(LogIntent.WARNING, PurchaseStrings.PURCHASE_FINISH_TRANSACTION_FALSE);
            }
            if (!getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId().containsKey(purchasingData.getProductId())) {
                setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), (Boolean) null, MapsKt.plus(getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId(), (Map<String, PurchaseCallback>) MapsKt.mapOf(TuplesKt.to(purchasingData.getProductId(), purchaseCallback2))), (ProductChangeCallback) null, false, false, 29, (Object) null));
                str2 = this.identityManager.getCurrentAppUserID();
            } else {
                str2 = null;
            }
            Unit unit2 = Unit.INSTANCE;
        }
        if (str2 != null) {
            this.billing.makePurchaseAsync(activity, str2, purchasingData, (ReplaceProductInfo) null, presentedOfferingContext, bool);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.OperationAlreadyInProgressError, (String) null, 2, (DefaultConstructorMarker) null);
            LogUtilsKt.errorLog(purchasesError);
            Unit unit3 = Unit.INSTANCE;
            dispatch(purchaseCallback2, purchasesError);
        }
    }

    public final void startProductChange(Activity activity, PurchasingData purchasingData, PresentedOfferingContext presentedOfferingContext, String str, GoogleReplacementMode googleReplacementMode, Boolean bool, PurchaseCallback purchaseCallback) {
        String str2;
        String str3;
        Unit unit;
        String offeringIdentifier;
        PurchasingData purchasingData2 = purchasingData;
        String str4 = str;
        GoogleReplacementMode googleReplacementMode2 = googleReplacementMode;
        PurchaseCallback purchaseCallback2 = purchaseCallback;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(purchasingData2, "purchasingData");
        Intrinsics.checkNotNullParameter(str4, "oldProductId");
        Intrinsics.checkNotNullParameter(googleReplacementMode2, "googleReplacementMode");
        Intrinsics.checkNotNullParameter(purchaseCallback2, "purchaseCallback");
        if (purchasingData.getProductType() != ProductType.SUBS) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PurchaseNotAllowedError, PurchaseStrings.UPGRADING_INVALID_TYPE);
            LogUtilsKt.errorLog(purchasesError);
            Unit unit2 = Unit.INSTANCE;
            dispatch(purchaseCallback2, purchasesError);
            return;
        }
        LogIntent logIntent = LogIntent.PURCHASE;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(purchasingData2);
        sb.append(' ');
        if (presentedOfferingContext == null || (offeringIdentifier = presentedOfferingContext.getOfferingIdentifier()) == null) {
            str2 = null;
        } else {
            str2 = PurchaseStrings.OFFERING + offeringIdentifier;
        }
        sb.append(str2);
        sb.append(" oldProductId: ");
        sb.append(str4);
        sb.append(" googleReplacementMode ");
        sb.append(googleReplacementMode2);
        objArr[0] = sb.toString();
        String format = String.format(PurchaseStrings.PRODUCT_CHANGE_STARTED, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        synchronized (this) {
            if (!this.appConfig.getFinishTransactions()) {
                LogWrapperKt.log(LogIntent.WARNING, PurchaseStrings.PURCHASE_FINISH_TRANSACTION_FALSE);
            }
            if (!getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId().containsKey(purchasingData.getProductId())) {
                setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), (Boolean) null, MapsKt.plus(getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId(), (Map<String, PurchaseCallback>) MapsKt.mapOf(TuplesKt.to(purchasingData.getProductId(), purchaseCallback2))), (ProductChangeCallback) null, false, false, 29, (Object) null));
                str3 = this.identityManager.getCurrentAppUserID();
            } else {
                str3 = null;
            }
            Unit unit3 = Unit.INSTANCE;
        }
        if (str3 != null) {
            replaceOldPurchaseWithNewProduct(purchasingData, str, googleReplacementMode, activity, str3, presentedOfferingContext, bool, purchaseCallback2);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            PurchasesOrchestrator purchasesOrchestrator = this;
            PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.OperationAlreadyInProgressError, (String) null, 2, (DefaultConstructorMarker) null);
            LogUtilsKt.errorLog(purchasesError2);
            for (PurchaseCallback dispatch : getAndClearAllPurchaseCallbacks()) {
                dispatch(dispatch, purchasesError2);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    public final void startDeprecatedProductChange(Activity activity, PurchasingData purchasingData, PresentedOfferingContext presentedOfferingContext, String str, GoogleReplacementMode googleReplacementMode, ProductChangeCallback productChangeCallback) {
        String str2;
        String str3;
        ? r0;
        String offeringIdentifier;
        PurchasingData purchasingData2 = purchasingData;
        String str4 = str;
        PurchaseErrorCallback purchaseErrorCallback = productChangeCallback;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(purchasingData2, "purchasingData");
        Intrinsics.checkNotNullParameter(str4, "oldProductId");
        Intrinsics.checkNotNullParameter(purchaseErrorCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (purchasingData.getProductType() != ProductType.SUBS) {
            getAndClearProductChangeCallback();
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PurchaseNotAllowedError, PurchaseStrings.UPGRADING_INVALID_TYPE);
            LogUtilsKt.errorLog(purchasesError);
            Unit unit = Unit.INSTANCE;
            dispatch(purchaseErrorCallback, purchasesError);
            return;
        }
        LogIntent logIntent = LogIntent.PURCHASE;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(purchasingData2);
        sb.append(' ');
        Unit unit2 = null;
        if (presentedOfferingContext == null || (offeringIdentifier = presentedOfferingContext.getOfferingIdentifier()) == null) {
            str2 = null;
        } else {
            str2 = PurchaseStrings.OFFERING + offeringIdentifier;
        }
        sb.append(str2);
        sb.append(" oldProductId: ");
        sb.append(str4);
        sb.append(" googleReplacementMode ");
        sb.append(googleReplacementMode);
        objArr[0] = sb.toString();
        String format = String.format(PurchaseStrings.PRODUCT_CHANGE_STARTED, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        synchronized (this) {
            if (!this.appConfig.getFinishTransactions()) {
                LogWrapperKt.log(LogIntent.WARNING, PurchaseStrings.PURCHASE_FINISH_TRANSACTION_FALSE);
            }
            if (getState$purchases_defaultsRelease().getDeprecatedProductChangeCallback() == null) {
                setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), (Boolean) null, (Map) null, productChangeCallback, false, false, 27, (Object) null));
                str3 = this.identityManager.getCurrentAppUserID();
            } else {
                str3 = null;
            }
            Unit unit3 = Unit.INSTANCE;
        }
        if (str3 != null) {
            r0 = 0;
            replaceOldPurchaseWithNewProduct(purchasingData, str, googleReplacementMode, activity, str3, presentedOfferingContext, (Boolean) null, purchaseErrorCallback);
            unit2 = Unit.INSTANCE;
        } else {
            r0 = 0;
        }
        if (unit2 == null) {
            PurchasesOrchestrator purchasesOrchestrator = this;
            getAndClearProductChangeCallback();
            PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.OperationAlreadyInProgressError, r0, 2, r0);
            LogUtilsKt.errorLog(purchasesError2);
            Unit unit4 = Unit.INSTANCE;
            dispatch(productChangeCallback, purchasesError2);
        }
    }

    private final void replaceOldPurchaseWithNewProduct(PurchasingData purchasingData, String str, GoogleReplacementMode googleReplacementMode, Activity activity, String str2, PresentedOfferingContext presentedOfferingContext, Boolean bool, PurchaseErrorCallback purchaseErrorCallback) {
        String str3 = str;
        if (purchasingData.getProductType() != ProductType.SUBS) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PurchaseNotAllowedError, PurchaseStrings.UPGRADING_INVALID_TYPE);
            LogUtilsKt.errorLog(purchasesError);
            ProductChangeCallback andClearProductChangeCallback = getAndClearProductChangeCallback();
            if (andClearProductChangeCallback != null) {
                dispatch(andClearProductChangeCallback, purchasesError);
            }
            for (PurchaseCallback dispatch : getAndClearAllPurchaseCallbacks()) {
                dispatch(dispatch, purchasesError);
            }
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = str3;
        if (StringsKt.contains$default((CharSequence) str3, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
            objectRef.element = StringsKt.substringBefore$default(str3, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, (String) null, 2, (Object) null);
            LogUtilsKt.warnLog("Using incorrect oldProductId: " + str3 + ". The productId should not contain the basePlanId. Using productId: " + ((String) objectRef.element) + '.');
        }
        BillingAbstract billingAbstract = this.billing;
        billingAbstract.findPurchaseInPurchaseHistory(str2, ProductType.SUBS, (String) objectRef.element, new PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$2(objectRef, this, activity, str2, purchasingData, googleReplacementMode, presentedOfferingContext, bool), new PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$3(this, purchaseErrorCallback));
    }

    private final void synchronizeSubscriberAttributesIfNeeded() {
        SubscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers$default(this.subscriberAttributesManager, getAppUserID(), (Function0) null, 2, (Object) null);
    }

    private final void flushPaywallEvents() {
        PaywallEventsManager paywallEventsManager2;
        if (AndroidVersionUtilsKt.isAndroidNOrNewer() && (paywallEventsManager2 = this.paywallEventsManager) != null) {
            paywallEventsManager2.flushEvents();
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040,R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006-"}, d2 = {"Lcom/revenuecat/purchases/PurchasesOrchestrator$Companion;", "", "()V", "value", "", "debugLogsEnabled", "getDebugLogsEnabled", "()Z", "setDebugLogsEnabled", "(Z)V", "frameworkVersion", "", "Lcom/revenuecat/purchases/LogHandler;", "logHandler", "getLogHandler", "()Lcom/revenuecat/purchases/LogHandler;", "setLogHandler", "(Lcom/revenuecat/purchases/LogHandler;)V", "Lcom/revenuecat/purchases/LogLevel;", "logLevel", "getLogLevel", "()Lcom/revenuecat/purchases/LogLevel;", "setLogLevel", "(Lcom/revenuecat/purchases/LogLevel;)V", "platformInfo", "Lcom/revenuecat/purchases/common/PlatformInfo;", "getPlatformInfo", "()Lcom/revenuecat/purchases/common/PlatformInfo;", "setPlatformInfo", "(Lcom/revenuecat/purchases/common/PlatformInfo;)V", "proxyURL", "Ljava/net/URL;", "getProxyURL", "()Ljava/net/URL;", "setProxyURL", "(Ljava/net/URL;)V", "canMakePayments", "", "context", "Landroid/content/Context;", "features", "", "Lcom/revenuecat/purchases/models/BillingFeature;", "callback", "Lcom/revenuecat/purchases/interfaces/Callback;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PurchasesOrchestrator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public static final void canMakePayments$lambda$0(BillingResult billingResult, List list) {
            Intrinsics.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
        }

        private Companion() {
        }

        public final PlatformInfo getPlatformInfo() {
            return PurchasesOrchestrator.platformInfo;
        }

        public final void setPlatformInfo(PlatformInfo platformInfo) {
            Intrinsics.checkNotNullParameter(platformInfo, "<set-?>");
            PurchasesOrchestrator.platformInfo = platformInfo;
        }

        public final boolean getDebugLogsEnabled() {
            return LogUtilsKt.getDebugLogsEnabled(getLogLevel());
        }

        public final void setDebugLogsEnabled(boolean z) {
            setLogLevel(LogUtilsKt.debugLogsEnabled(LogLevel.Companion, z));
        }

        public final LogLevel getLogLevel() {
            return Config.INSTANCE.getLogLevel();
        }

        public final void setLogLevel(LogLevel logLevel) {
            Intrinsics.checkNotNullParameter(logLevel, "value");
            Config.INSTANCE.setLogLevel(logLevel);
        }

        public final synchronized LogHandler getLogHandler() {
            return LogWrapperKt.getCurrentLogHandler();
        }

        public final synchronized void setLogHandler(LogHandler logHandler) {
            Intrinsics.checkNotNullParameter(logHandler, "value");
            LogWrapperKt.setCurrentLogHandler(logHandler);
        }

        public final URL getProxyURL() {
            return PurchasesOrchestrator.proxyURL;
        }

        public final void setProxyURL(URL url) {
            PurchasesOrchestrator.proxyURL = url;
        }

        public static /* synthetic */ void canMakePayments$default(Companion companion, Context context, List list, Callback callback, int i, Object obj) {
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            companion.canMakePayments(context, list, callback);
        }

        public final void canMakePayments(Context context, List<? extends BillingFeature> list, Callback<Boolean> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(list, "features");
            Intrinsics.checkNotNullParameter(callback, "callback");
            BillingClient build = BillingClient.newBuilder(context).enablePendingPurchases().setListener(new PurchasesOrchestrator$Companion$$ExternalSyntheticLambda0()).build();
            build.startConnection(new PurchasesOrchestrator$Companion$canMakePayments$2$1(new Handler(context.getMainLooper()), callback, build, list));
        }
    }
}
