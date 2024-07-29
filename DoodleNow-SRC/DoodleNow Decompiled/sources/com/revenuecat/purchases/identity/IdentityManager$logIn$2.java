package com.revenuecat.purchases.identity;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.IdentityStrings;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IdentityManager.kt */
final class IdentityManager$logIn$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $newAppUserID;
    final /* synthetic */ String $oldAppUserID;
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function2<CustomerInfo, Boolean, Unit> $onSuccess;
    final /* synthetic */ IdentityManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IdentityManager$logIn$2(IdentityManager identityManager, String str, String str2, Function1<? super PurchasesError, Unit> function1, Function2<? super CustomerInfo, ? super Boolean, Unit> function2) {
        super(0);
        this.this$0 = identityManager;
        this.$oldAppUserID = str;
        this.$newAppUserID = str2;
        this.$onError = function1;
        this.$onSuccess = function2;
    }

    public final void invoke() {
        Backend access$getBackend$p = this.this$0.backend;
        String str = this.$oldAppUserID;
        String str2 = this.$newAppUserID;
        final IdentityManager identityManager = this.this$0;
        final Function2<CustomerInfo, Boolean, Unit> function2 = this.$onSuccess;
        final String str3 = this.$newAppUserID;
        final String str4 = this.$oldAppUserID;
        access$getBackend$p.logIn(str, str2, new Function2<CustomerInfo, Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((CustomerInfo) obj, ((Boolean) obj2).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(CustomerInfo customerInfo, boolean z) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                IdentityManager identityManager = identityManager;
                String str = str3;
                String str2 = str4;
                synchronized (identityManager) {
                    LogIntent logIntent = LogIntent.USER;
                    String format = String.format(IdentityStrings.LOG_IN_SUCCESSFUL, Arrays.copyOf(new Object[]{str, Boolean.valueOf(z)}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    LogWrapperKt.log(logIntent, format);
                    identityManager.deviceCache.clearCachesForAppUserID(str2);
                    identityManager.offeringsCache.clearCache();
                    identityManager.subscriberAttributesCache.clearSubscriberAttributesIfSyncedForSubscriber(str2);
                    identityManager.deviceCache.cacheAppUserID(str);
                    identityManager.deviceCache.cacheCustomerInfo(str, customerInfo);
                    identityManager.copySubscriberAttributesToNewUserIfOldIsAnonymous(str2, str);
                    identityManager.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                    Unit unit = Unit.INSTANCE;
                }
                function2.invoke(customerInfo, Boolean.valueOf(z));
            }
        }, this.$onError);
    }
}
