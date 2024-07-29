package com.revenuecat.purchases.common;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.models.GoogleProrationMode;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.events.PaywallEventRequest;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.utils.JsonElementExtensionsKt;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 z2\u00020\u0001:\u0001zB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010H\u001a\u00020\u0013J\u0006\u0010I\u001a\u00020\u0013J\u0018\u0010J\u001a\u0002082\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u0015H\u0002JS\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020!2\u0006\u0010P\u001a\u00020\u00162\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112'\u0010R\u001a#\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u0014JS\u0010S\u001a\u00020\u00132\u0006\u0010O\u001a\u00020!2\u0006\u0010P\u001a\u00020\u00162\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00130\u00112'\u0010R\u001a#\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u0014J.\u0010T\u001a\u00020\u00132\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u00130\u00112\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u0011JD\u0010W\u001a\u00020\u00132\u0006\u0010O\u001a\u00020!2\u0006\u0010X\u001a\u00020!2\u0018\u0010U\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u00142\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u0011JB\u0010Y\u001a\u00020\u00132\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020#0 2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00130\u00112\u0018\u0010V\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u0014JV\u0010[\u001a\u00020\u00132\u0006\u0010\\\u001a\u00020]2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00130026\u0010V\u001a2\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(^\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u00130\u0014H\u0007Jé\u0001\u0010`\u001a\u00020\u00132\u0006\u0010a\u001a\u00020!2\u0006\u0010O\u001a\u00020!2\u0006\u0010b\u001a\u00020\u00162\u0006\u0010c\u001a\u00020\u00162 \u0010d\u001a\u001c\u0012\u0004\u0012\u00020!\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\u00010e0e2\u0006\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010!2\u0006\u0010j\u001a\u00020k2\b\u0010l\u001a\u0004\u0018\u00010m2+\u0010Q\u001a'\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u00130\u0014j\u0002`62B\u0010R\u001a>\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u001108¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(9\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u001307j\u0002`:Jl\u0010n\u001a\u00020\u0013\"\u0004\b\u0000\u0010o\"\u0004\b\u0001\u0010p* \u0012\u0004\u0012\u00020\u000e\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002Ho\u0012\u0004\u0012\u0002Hp0\u00100\u000f0\r2\u0006\u0010q\u001a\u00020r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010s\u001a\u00020\u000e2\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u0002Ho\u0012\u0004\u0012\u0002Hp0\u00102\b\b\u0002\u0010u\u001a\u00020vH\u0002Jw\u0010w\u001a\u00020\u0013\"\u0004\b\u0000\u0010x\"\u0004\b\u0001\u0010o\"\u0004\b\u0002\u0010p* \u0012\u0004\u0012\u0002Hx\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002Ho\u0012\u0004\u0012\u0002Hp0\u00100\u000f0\r2\u0006\u0010q\u001a\u00020r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010s\u001a\u0002Hx2\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u0002Ho\u0012\u0004\u0012\u0002Hp0\u00102\b\b\u0002\u0010u\u001a\u00020vH\u0002¢\u0006\u0002\u0010yR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000RÄ\u0001\u0010\u001b\u001aQ\u0012\u0004\u0012\u00020\u000e\u0012G\u0012E\u0012A\u0012?\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011\u0012%\u0012#\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`\u001a0\u000f0\r2U\u0010\f\u001aQ\u0012\u0004\u0012\u00020\u000e\u0012G\u0012E\u0012A\u0012?\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011\u0012%\u0012#\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`\u001a0\u000f0\r8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fRº\u0001\u0010%\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u00128\u00126\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`$0\u000f0\r2P\u0010\f\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u00128\u00126\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`$0\u000f0\r8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000Rº\u0001\u0010)\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u00128\u00126\u00122\u00120\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u00110\u0010j\u0002`(0\u000f0\r2P\u0010\f\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u00128\u00126\u00122\u00120\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u00110\u0010j\u0002`(0\u000f0\r8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fRÄ\u0001\u0010-\u001aQ\u0012\u0004\u0012\u00020\u000e\u0012G\u0012E\u0012A\u0012?\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00130\u0011\u0012%\u0012#\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`,0\u000f0\r2U\u0010\f\u001aQ\u0012\u0004\u0012\u00020\u000e\u0012G\u0012E\u0012A\u0012?\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00130\u0011\u0012%\u0012#\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`,0\u000f0\r8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR®\u0001\u00102\u001aF\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u00122\u00120\u0012,\u0012*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001300\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`10\u000f0\r2J\u0010\f\u001aF\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u00122\u00120\u0012,\u0012*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001300\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`10\u000f0\r8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010\u001fRÃ\u0002\u0010<\u001a\u0001\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u0012{\u0012y\u0012u\u0012s\u0012)\u0012'\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u00130\u0014j\u0002`6\u0012@\u0012>\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u001108¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(9\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u001307j\u0002`:0\u0010j\u0002`;0\u000f0\r2\u0001\u0010\f\u001a\u0001\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u0012{\u0012y\u0012u\u0012s\u0012)\u0012'\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u00130\u0014j\u0002`6\u0012@\u0012>\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u001108¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(9\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u001307j\u0002`:0\u0010j\u0002`;0\u000f0\r8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001d\"\u0004\b>\u0010\u001fR\u0001\u0010A\u001a<\u0012\u0004\u0012\u00020!\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u00110\u0010j\u0002`@0\u000f0\r2@\u0010\f\u001a<\u0012\u0004\u0012\u00020!\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u00110\u0010j\u0002`@0\u000f0\r8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001d\"\u0004\bC\u0010\u001fR\u0011\u0010D\u001a\u00020E8F¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006{"}, d2 = {"Lcom/revenuecat/purchases/common/Backend;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "eventsDispatcher", "httpClient", "Lcom/revenuecat/purchases/common/HTTPClient;", "backendHelper", "Lcom/revenuecat/purchases/common/BackendHelper;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/HTTPClient;Lcom/revenuecat/purchases/common/BackendHelper;)V", "<set-?>", "", "Lcom/revenuecat/purchases/common/BackgroundAwareCallbackCacheKey;", "", "Lkotlin/Pair;", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/PurchasesError;", "", "Lkotlin/ParameterName;", "name", "isServerError", "Lcom/revenuecat/purchases/common/CustomerInfoCallback;", "callbacks", "getCallbacks", "()Ljava/util/Map;", "setCallbacks", "(Ljava/util/Map;)V", "", "", "Lcom/revenuecat/purchases/common/CallbackCacheKey;", "Lorg/json/JSONObject;", "Lcom/revenuecat/purchases/common/DiagnosticsCallback;", "diagnosticsCallbacks", "getDiagnosticsCallbacks", "setDiagnosticsCallbacks", "Lcom/revenuecat/purchases/common/IdentifyCallback;", "identifyCallbacks", "getIdentifyCallbacks", "setIdentifyCallbacks", "Lcom/revenuecat/purchases/common/OfferingsCallback;", "offeringsCallbacks", "getOfferingsCallbacks", "setOfferingsCallbacks", "Lkotlin/Function0;", "Lcom/revenuecat/purchases/common/PaywallEventsCallback;", "paywallEventsCallbacks", "getPaywallEventsCallbacks", "setPaywallEventsCallbacks", "body", "Lcom/revenuecat/purchases/common/PostReceiptDataSuccessCallback;", "Lkotlin/Function3;", "Lcom/revenuecat/purchases/common/PostReceiptErrorHandlingBehavior;", "postReceiptErrorHandlingBehavior", "Lcom/revenuecat/purchases/common/PostReceiptDataErrorCallback;", "Lcom/revenuecat/purchases/common/PostReceiptCallback;", "postReceiptCallbacks", "getPostReceiptCallbacks", "setPostReceiptCallbacks", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "Lcom/revenuecat/purchases/common/ProductEntitlementCallback;", "productEntitlementCallbacks", "getProductEntitlementCallbacks", "setProductEntitlementCallbacks", "verificationMode", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "getVerificationMode", "()Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "clearCaches", "close", "determinePostReceiptErrorHandlingBehavior", "responseCode", "", "purchasesError", "getCustomerInfo", "appUserID", "appInBackground", "onSuccess", "onError", "getOfferings", "getProductEntitlementMapping", "onSuccessHandler", "onErrorHandler", "logIn", "newAppUserID", "postDiagnostics", "diagnosticsList", "postPaywallEvents", "paywallEventRequest", "Lcom/revenuecat/purchases/paywalls/events/PaywallEventRequest;", "error", "shouldMarkAsSynced", "postReceiptData", "purchaseToken", "isRestore", "observerMode", "subscriberAttributes", "", "receiptInfo", "Lcom/revenuecat/purchases/common/ReceiptInfo;", "storeAppUserID", "marketplace", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "paywallPostReceiptData", "Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "addBackgroundAwareCallback", "S", "E", "call", "Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "cacheKey", "functions", "delay", "Lcom/revenuecat/purchases/common/Delay;", "addCallback", "K", "(Ljava/util/Map;Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;Lcom/revenuecat/purchases/common/Dispatcher;Ljava/lang/Object;Lkotlin/Pair;Lcom/revenuecat/purchases/common/Delay;)V", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Backend.kt */
public final class Backend {
    @Deprecated
    public static final String APP_USER_ID = "app_user_id";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String FETCH_TOKEN = "fetch_token";
    @Deprecated
    public static final String NEW_APP_USER_ID = "new_app_user_id";
    /* access modifiers changed from: private */
    public final AppConfig appConfig;
    /* access modifiers changed from: private */
    public final BackendHelper backendHelper;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>>> callbacks = new LinkedHashMap();
    private volatile Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> diagnosticsCallbacks = new LinkedHashMap();
    private final Dispatcher dispatcher;
    private final Dispatcher eventsDispatcher;
    /* access modifiers changed from: private */
    public final HTTPClient httpClient;
    private volatile Map<List<String>, List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>>> identifyCallbacks = new LinkedHashMap();
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> offeringsCallbacks = new LinkedHashMap();
    private volatile Map<List<String>, List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>>> paywallEventsCallbacks = new LinkedHashMap();
    private volatile Map<List<String>, List<Pair<Function2<CustomerInfo, JSONObject, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>>> postReceiptCallbacks = new LinkedHashMap();
    private volatile Map<String, List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>>> productEntitlementCallbacks = new LinkedHashMap();

    public Backend(AppConfig appConfig2, Dispatcher dispatcher2, Dispatcher dispatcher3, HTTPClient hTTPClient, BackendHelper backendHelper2) {
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        Intrinsics.checkNotNullParameter(dispatcher2, "dispatcher");
        Intrinsics.checkNotNullParameter(dispatcher3, "eventsDispatcher");
        Intrinsics.checkNotNullParameter(hTTPClient, "httpClient");
        Intrinsics.checkNotNullParameter(backendHelper2, "backendHelper");
        this.appConfig = appConfig2;
        this.dispatcher = dispatcher2;
        this.eventsDispatcher = dispatcher3;
        this.httpClient = hTTPClient;
        this.backendHelper = backendHelper2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/Backend$Companion;", "", "()V", "APP_USER_ID", "", "FETCH_TOKEN", "NEW_APP_USER_ID", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Backend.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final SignatureVerificationMode getVerificationMode() {
        return this.httpClient.getSigningManager().getSignatureVerificationMode();
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>>> getCallbacks() {
        return this.callbacks;
    }

    public final synchronized void setCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.callbacks = map;
    }

    public final synchronized Map<List<String>, List<Pair<Function2<CustomerInfo, JSONObject, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>>> getPostReceiptCallbacks() {
        return this.postReceiptCallbacks;
    }

    public final synchronized void setPostReceiptCallbacks(Map<List<String>, List<Pair<Function2<CustomerInfo, JSONObject, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.postReceiptCallbacks = map;
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> getOfferingsCallbacks() {
        return this.offeringsCallbacks;
    }

    public final synchronized void setOfferingsCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.offeringsCallbacks = map;
    }

    public final synchronized Map<List<String>, List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>>> getIdentifyCallbacks() {
        return this.identifyCallbacks;
    }

    public final synchronized void setIdentifyCallbacks(Map<List<String>, List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.identifyCallbacks = map;
    }

    public final synchronized Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> getDiagnosticsCallbacks() {
        return this.diagnosticsCallbacks;
    }

    public final synchronized void setDiagnosticsCallbacks(Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.diagnosticsCallbacks = map;
    }

    public final synchronized Map<List<String>, List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>>> getPaywallEventsCallbacks() {
        return this.paywallEventsCallbacks;
    }

    public final synchronized void setPaywallEventsCallbacks(Map<List<String>, List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.paywallEventsCallbacks = map;
    }

    public final synchronized Map<String, List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>>> getProductEntitlementCallbacks() {
        return this.productEntitlementCallbacks;
    }

    public final synchronized void setProductEntitlementCallbacks(Map<String, List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.productEntitlementCallbacks = map;
    }

    public final void close() {
        this.dispatcher.close();
    }

    public final void getCustomerInfo(String str, boolean z, Function1<? super CustomerInfo, Unit> function1, Function2<? super PurchasesError, ? super Boolean, Unit> function2) {
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey;
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2;
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function2, "onError");
        Endpoint.GetCustomerInfo getCustomerInfo = new Endpoint.GetCustomerInfo(str);
        String path = getCustomerInfo.getPath();
        synchronized (this) {
            if (this.postReceiptCallbacks.isEmpty()) {
                backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(path), z);
            } else {
                backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.plus(CollectionsKt.listOf(path), String.valueOf(this.callbacks.size())), z);
            }
            backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
        }
        Backend$getCustomerInfo$call$1 backend$getCustomerInfo$call$1 = new Backend$getCustomerInfo$call$1(this, getCustomerInfo, backgroundAwareCallbackCacheKey2);
        synchronized (this) {
            addBackgroundAwareCallback(this.callbacks, backend$getCustomerInfo$call$1, this.dispatcher, backgroundAwareCallbackCacheKey2, TuplesKt.to(function1, function2), z ? Delay.DEFAULT : Delay.NONE);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void postReceiptData$default(Backend backend, String str, String str2, boolean z, boolean z2, Map map, ReceiptInfo receiptInfo, String str3, String str4, PostReceiptInitiationSource postReceiptInitiationSource, PaywallPostReceiptData paywallPostReceiptData, Function2 function2, Function3 function3, int i, Object obj) {
        backend.postReceiptData(str, str2, z, z2, map, receiptInfo, str3, (i & 128) != 0 ? null : str4, postReceiptInitiationSource, paywallPostReceiptData, function2, function3);
    }

    public final void postReceiptData(String str, String str2, boolean z, boolean z2, Map<String, ? extends Map<String, ? extends Object>> map, ReceiptInfo receiptInfo, String str3, String str4, PostReceiptInitiationSource postReceiptInitiationSource, PaywallPostReceiptData paywallPostReceiptData, Function2<? super CustomerInfo, ? super JSONObject, Unit> function2, Function3<? super PurchasesError, ? super PostReceiptErrorHandlingBehavior, ? super JSONObject, Unit> function3) {
        List list;
        List list2;
        Map<String, Object> map2;
        Price price;
        GoogleProrationMode asGoogleProrationMode$purchases_defaultsRelease;
        String str5 = str;
        String str6 = str2;
        Intrinsics.checkNotNullParameter(str5, "purchaseToken");
        Intrinsics.checkNotNullParameter(str6, "appUserID");
        Map<String, ? extends Map<String, ? extends Object>> map3 = map;
        Intrinsics.checkNotNullParameter(map3, "subscriberAttributes");
        Intrinsics.checkNotNullParameter(receiptInfo, "receiptInfo");
        Intrinsics.checkNotNullParameter(postReceiptInitiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(function2, "onSuccess");
        Intrinsics.checkNotNullParameter(function3, "onError");
        List listOfNotNull = CollectionsKt.listOfNotNull((T[]) new String[]{str, str2, String.valueOf(z), String.valueOf(z2), map.toString(), receiptInfo.toString(), str3});
        Pair[] pairArr = new Pair[16];
        pairArr[0] = TuplesKt.to(FETCH_TOKEN, str5);
        pairArr[1] = TuplesKt.to("product_ids", receiptInfo.getProductIDs());
        List<PlatformProductId> platformProductIds$purchases_defaultsRelease = receiptInfo.getPlatformProductIds$purchases_defaultsRelease();
        if (platformProductIds$purchases_defaultsRelease != null) {
            Iterable<PlatformProductId> iterable = platformProductIds$purchases_defaultsRelease;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (PlatformProductId asMap : iterable) {
                arrayList.add(asMap.getAsMap());
            }
            list = (List) arrayList;
        } else {
            list = null;
        }
        pairArr[2] = TuplesKt.to("platform_product_ids", list);
        pairArr[3] = TuplesKt.to(APP_USER_ID, str6);
        pairArr[4] = TuplesKt.to("is_restore", Boolean.valueOf(z));
        PresentedOfferingContext presentedOfferingContext = receiptInfo.getPresentedOfferingContext();
        pairArr[5] = TuplesKt.to("presented_offering_identifier", presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null);
        pairArr[6] = TuplesKt.to("observer_mode", Boolean.valueOf(z2));
        pairArr[7] = TuplesKt.to(b.x, receiptInfo.getPrice());
        pairArr[8] = TuplesKt.to(b.a, receiptInfo.getCurrency());
        if (map.isEmpty() || this.appConfig.getCustomEntitlementComputation()) {
            map3 = null;
        }
        pairArr[9] = TuplesKt.to("attributes", map3);
        pairArr[10] = TuplesKt.to("normal_duration", receiptInfo.getDuration());
        pairArr[11] = TuplesKt.to("store_user_id", str3);
        List<PricingPhase> pricingPhases = receiptInfo.getPricingPhases();
        if (pricingPhases != null) {
            Iterable<PricingPhase> iterable2 = pricingPhases;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
            for (PricingPhase map4 : iterable2) {
                arrayList2.add(BackendKt.toMap(map4));
            }
            list2 = (List) arrayList2;
        } else {
            list2 = null;
        }
        pairArr[12] = TuplesKt.to("pricing_phases", list2);
        ReplacementMode replacementMode = receiptInfo.getReplacementMode();
        GoogleReplacementMode googleReplacementMode = replacementMode instanceof GoogleReplacementMode ? (GoogleReplacementMode) replacementMode : null;
        pairArr[13] = TuplesKt.to("proration_mode", (googleReplacementMode == null || (asGoogleProrationMode$purchases_defaultsRelease = googleReplacementMode.getAsGoogleProrationMode$purchases_defaultsRelease()) == null) ? null : asGoogleProrationMode$purchases_defaultsRelease.name());
        pairArr[14] = TuplesKt.to("initiation_source", postReceiptInitiationSource.getPostReceiptFieldValue());
        if (paywallPostReceiptData != null) {
            map2 = paywallPostReceiptData.toMap();
        } else {
            map2 = null;
        }
        pairArr[15] = TuplesKt.to("paywall", map2);
        Map filterNotNullValues = MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(pairArr));
        List listOf = CollectionsKt.listOf(TuplesKt.to(APP_USER_ID, str6), TuplesKt.to(FETCH_TOKEN, str5));
        Pair[] pairArr2 = new Pair[2];
        StoreProduct storeProduct = receiptInfo.getStoreProduct();
        pairArr2[0] = TuplesKt.to("price_string", (storeProduct == null || (price = storeProduct.getPrice()) == null) ? null : price.getFormatted());
        pairArr2[1] = TuplesKt.to(b.m, str4);
        Backend$postReceiptData$call$1 backend$postReceiptData$call$1 = new Backend$postReceiptData$call$1(this, filterNotNullValues, listOf, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(pairArr2)), listOfNotNull);
        synchronized (this) {
            addCallback$default(this, this.postReceiptCallbacks, backend$postReceiptData$call$1, this.dispatcher, listOfNotNull, TuplesKt.to(function2, function3), (Delay) null, 16, (Object) null);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void getOfferings(String str, boolean z, Function1<? super JSONObject, Unit> function1, Function2<? super PurchasesError, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function2, "onError");
        Endpoint.GetOfferings getOfferings = new Endpoint.GetOfferings(str);
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(getOfferings.getPath()), z);
        Backend$getOfferings$call$1 backend$getOfferings$call$1 = new Backend$getOfferings$call$1(this, getOfferings, backgroundAwareCallbackCacheKey);
        synchronized (this) {
            addBackgroundAwareCallback(this.offeringsCallbacks, backend$getOfferings$call$1, this.dispatcher, backgroundAwareCallbackCacheKey, TuplesKt.to(function1, function2), z ? Delay.DEFAULT : Delay.NONE);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void logIn(String str, String str2, Function2<? super CustomerInfo, ? super Boolean, Unit> function2, Function1<? super PurchasesError, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(str2, "newAppUserID");
        Intrinsics.checkNotNullParameter(function2, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(function1, "onErrorHandler");
        List listOfNotNull = CollectionsKt.listOfNotNull((T[]) new String[]{str, str2});
        Backend$logIn$call$1 backend$logIn$call$1 = new Backend$logIn$call$1(str, str2, this, listOfNotNull);
        synchronized (this) {
            addCallback$default(this, this.identifyCallbacks, backend$logIn$call$1, this.dispatcher, listOfNotNull, TuplesKt.to(function2, function1), (Delay) null, 16, (Object) null);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void postDiagnostics(List<? extends JSONObject> list, Function1<? super JSONObject, Unit> function1, Function2<? super PurchasesError, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(list, "diagnosticsList");
        Intrinsics.checkNotNullParameter(function1, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(function2, "onErrorHandler");
        Iterable<JSONObject> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (JSONObject hashCode : iterable) {
            arrayList.add(String.valueOf(hashCode.hashCode()));
        }
        List list2 = (List) arrayList;
        Backend$postDiagnostics$call$1 backend$postDiagnostics$call$1 = new Backend$postDiagnostics$call$1(this, MapsKt.mapOf(TuplesKt.to("entries", new JSONArray(list))), list2);
        synchronized (this) {
            addCallback(this.diagnosticsCallbacks, backend$postDiagnostics$call$1, this.eventsDispatcher, list2, TuplesKt.to(function1, function2), Delay.LONG);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void postPaywallEvents(PaywallEventRequest paywallEventRequest, Function0<Unit> function0, Function2<? super PurchasesError, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(paywallEventRequest, "paywallEventRequest");
        Intrinsics.checkNotNullParameter(function0, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(function2, "onErrorHandler");
        Json json = PaywallEventRequest.Companion.getJson();
        KSerializer<Object> serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(PaywallEventRequest.class));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        Map<String, Object> asMap = JsonElementExtensionsKt.asMap(json.encodeToJsonElement(serializer, paywallEventRequest));
        if (asMap == null) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnknownError, "Error encoding paywall event request");
            LogUtilsKt.errorLog(purchasesError);
            function2.invoke(purchasesError, true);
            return;
        }
        Backend$postPaywallEvents$call$1 backend$postPaywallEvents$call$1 = new Backend$postPaywallEvents$call$1(this, asMap, paywallEventRequest);
        synchronized (this) {
            addCallback(this.paywallEventsCallbacks, backend$postPaywallEvents$call$1, this.eventsDispatcher, paywallEventRequest.getCacheKey(), TuplesKt.to(function0, function2), Delay.LONG);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void getProductEntitlementMapping(Function1<? super ProductEntitlementMapping, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(function12, "onErrorHandler");
        Endpoint.GetProductEntitlementMapping getProductEntitlementMapping = Endpoint.GetProductEntitlementMapping.INSTANCE;
        String path = getProductEntitlementMapping.getPath();
        Backend$getProductEntitlementMapping$call$1 backend$getProductEntitlementMapping$call$1 = new Backend$getProductEntitlementMapping$call$1(this, getProductEntitlementMapping, path);
        synchronized (this) {
            addCallback(this.productEntitlementCallbacks, backend$getProductEntitlementMapping$call$1, this.dispatcher, path, TuplesKt.to(function1, function12), Delay.LONG);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearCaches() {
        this.httpClient.clearCaches();
    }

    /* access modifiers changed from: private */
    public final PostReceiptErrorHandlingBehavior determinePostReceiptErrorHandlingBehavior(int i, PurchasesError purchasesError) {
        if (RCHTTPStatusCodes.INSTANCE.isServerError(i)) {
            return PostReceiptErrorHandlingBehavior.SHOULD_USE_OFFLINE_ENTITLEMENTS_AND_NOT_CONSUME;
        }
        if (purchasesError.getCode() == PurchasesErrorCode.UnsupportedError) {
            return PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME;
        }
        return PostReceiptErrorHandlingBehavior.SHOULD_BE_CONSUMED;
    }

    static /* synthetic */ void addBackgroundAwareCallback$default(Backend backend, Map map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher2, BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, Pair pair, Delay delay, int i, Object obj) {
        if ((i & 16) != 0) {
            delay = Delay.NONE;
        }
        backend.addBackgroundAwareCallback(map, asyncCall, dispatcher2, backgroundAwareCallbackCacheKey, pair, delay);
    }

    private final synchronized <S, E> void addBackgroundAwareCallback(Map<BackgroundAwareCallbackCacheKey, List<Pair<S, E>>> map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher2, BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, Pair<? extends S, ? extends E> pair, Delay delay) {
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2;
        Map<BackgroundAwareCallbackCacheKey, List<Pair<S, E>>> map2 = map;
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey3 = backgroundAwareCallbackCacheKey;
        synchronized (this) {
            List list = null;
            BackgroundAwareCallbackCacheKey copy$default = BackgroundAwareCallbackCacheKey.copy$default(backgroundAwareCallbackCacheKey3, (List) null, false, 1, (Object) null);
            boolean containsKey = map.containsKey(copy$default);
            if (!backgroundAwareCallbackCacheKey.getAppInBackground() || !containsKey) {
                backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey3;
            } else {
                String format = String.format(NetworkStrings.SAME_CALL_SCHEDULED_WITHOUT_JITTER, Arrays.copyOf(new Object[]{copy$default}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogUtilsKt.debugLog(format);
                backgroundAwareCallbackCacheKey2 = copy$default;
            }
            addCallback(map, asyncCall, dispatcher2, backgroundAwareCallbackCacheKey2, pair, delay);
            BackgroundAwareCallbackCacheKey copy$default2 = BackgroundAwareCallbackCacheKey.copy$default(backgroundAwareCallbackCacheKey3, (List) null, true, 1, (Object) null);
            boolean containsKey2 = map.containsKey(copy$default);
            if (!backgroundAwareCallbackCacheKey.getAppInBackground() && containsKey2) {
                String format2 = String.format(NetworkStrings.SAME_CALL_SCHEDULED_WITH_JITTER, Arrays.copyOf(new Object[]{copy$default}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                LogUtilsKt.debugLog(format2);
                List remove = map.remove(copy$default2);
                if (remove != null) {
                    if (!remove.isEmpty()) {
                        list = remove;
                    }
                    if (list != null) {
                        if (map.containsKey(backgroundAwareCallbackCacheKey3)) {
                            List list2 = map.get(backgroundAwareCallbackCacheKey3);
                            if (list2 != null) {
                                list2.addAll(list);
                            }
                        } else {
                            map.put(backgroundAwareCallbackCacheKey3, list);
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void addCallback$default(Backend backend, Map map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher2, Object obj, Pair pair, Delay delay, int i, Object obj2) {
        if ((i & 16) != 0) {
            delay = Delay.NONE;
        }
        backend.addCallback(map, asyncCall, dispatcher2, obj, pair, delay);
    }

    private final <K, S, E> void addCallback(Map<K, List<Pair<S, E>>> map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher2, K k, Pair<? extends S, ? extends E> pair, Delay delay) {
        if (!map.containsKey(k)) {
            map.put(k, CollectionsKt.mutableListOf(pair));
            this.backendHelper.enqueue(asyncCall, dispatcher2, delay);
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(NetworkStrings.SAME_CALL_ALREADY_IN_PROGRESS, Arrays.copyOf(new Object[]{k}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        LogUtilsKt.debugLog(format);
        List<Pair<S, E>> list = map.get(k);
        Intrinsics.checkNotNull(list);
        list.add(pair);
    }
}
