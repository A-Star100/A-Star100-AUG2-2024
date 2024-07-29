package com.revenuecat.purchases.google.attribution;

import android.app.Application;
import android.provider.Settings;
import com.amazon.a.a.o.b;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\b\u001a\u00020\tH\u0003J?\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2-\u0010\u000e\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/google/attribution/GoogleDeviceIdentifiersFetcher;", "Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "(Lcom/revenuecat/purchases/common/Dispatcher;)V", "noPermissionAdvertisingIdValue", "", "getAdvertisingID", "applicationContext", "Landroid/app/Application;", "getAndroidID", "kotlin.jvm.PlatformType", "getDeviceIdentifiers", "", "completion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "deviceIdentifiers", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GoogleDeviceIdentifiersFetcher.kt */
public final class GoogleDeviceIdentifiersFetcher implements DeviceIdentifiersFetcher {
    private final Dispatcher dispatcher;
    private final String noPermissionAdvertisingIdValue = "00000000-0000-0000-0000-000000000000";

    public GoogleDeviceIdentifiersFetcher(Dispatcher dispatcher2) {
        Intrinsics.checkNotNullParameter(dispatcher2, "dispatcher");
        this.dispatcher = dispatcher2;
    }

    public void getDeviceIdentifiers(Application application, Function1<? super Map<String, String>, Unit> function1) {
        Intrinsics.checkNotNullParameter(application, "applicationContext");
        Intrinsics.checkNotNullParameter(function1, "completion");
        Dispatcher.enqueue$default(this.dispatcher, new GoogleDeviceIdentifiersFetcher$$ExternalSyntheticLambda0(this, application, function1), (Delay) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void getDeviceIdentifiers$lambda$0(GoogleDeviceIdentifiersFetcher googleDeviceIdentifiersFetcher, Application application, Function1 function1) {
        Intrinsics.checkNotNullParameter(googleDeviceIdentifiersFetcher, "this$0");
        Intrinsics.checkNotNullParameter(application, "$applicationContext");
        Intrinsics.checkNotNullParameter(function1, "$completion");
        function1.invoke(MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to(SubscriberAttributeKey.DeviceIdentifiers.GPSAdID.INSTANCE.getBackendKey(), googleDeviceIdentifiersFetcher.getAdvertisingID(application)), TuplesKt.to(SubscriberAttributeKey.DeviceIdentifiers.AndroidID.INSTANCE.getBackendKey(), googleDeviceIdentifiersFetcher.getAndroidID(application)), TuplesKt.to(SubscriberAttributeKey.DeviceIdentifiers.IP.INSTANCE.getBackendKey(), b.ac))));
    }

    private final String getAndroidID(Application application) {
        return Settings.Secure.getString(application.getContentResolver(), "android_id");
    }

    private final String getAdvertisingID(Application application) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(application);
            if (!advertisingIdInfo.isLimitAdTrackingEnabled()) {
                if (!Intrinsics.areEqual((Object) advertisingIdInfo.getId(), (Object) this.noPermissionAdvertisingIdValue)) {
                    return advertisingIdInfo.getId();
                }
                LogWrapperKt.log(LogIntent.WARNING, AttributionStrings.GOOGLE_PLAY_ADVERTISING_ID_NOT_AVAILABLE);
            }
        } catch (GooglePlayServicesNotAvailableException e) {
            LogIntent logIntent = LogIntent.GOOGLE_ERROR;
            String format = String.format(AttributionStrings.GOOGLE_PLAY_SERVICES_NOT_INSTALLED_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e.getLocalizedMessage()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
        } catch (GooglePlayServicesRepairableException e2) {
            LogIntent logIntent2 = LogIntent.GOOGLE_ERROR;
            String format2 = String.format(AttributionStrings.GOOGLE_PLAY_SERVICES_REPAIRABLE_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e2.getLocalizedMessage()}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
            LogWrapperKt.log(logIntent2, format2);
        } catch (TimeoutException e3) {
            LogIntent logIntent3 = LogIntent.GOOGLE_ERROR;
            String format3 = String.format(AttributionStrings.TIMEOUT_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e3.getLocalizedMessage()}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
            LogWrapperKt.log(logIntent3, format3);
        } catch (IOException e4) {
            LogIntent logIntent4 = LogIntent.GOOGLE_ERROR;
            String format4 = String.format(AttributionStrings.IO_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e4.getLocalizedMessage()}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "format(this, *args)");
            LogWrapperKt.log(logIntent4, format4);
        } catch (NullPointerException e5) {
            LogIntent logIntent5 = LogIntent.GOOGLE_ERROR;
            String format5 = String.format(AttributionStrings.NULL_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e5.getLocalizedMessage()}, 1));
            Intrinsics.checkNotNullExpressionValue(format5, "format(this, *args)");
            LogWrapperKt.log(logIntent5, format5);
        }
        return null;
    }
}
