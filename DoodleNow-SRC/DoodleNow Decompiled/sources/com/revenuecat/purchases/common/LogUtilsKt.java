package com.revenuecat.purchases.common;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u001c\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000\u001a\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001aP\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000426\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\t\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0002\u001a\u00020\u0004*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"PURCHASES_LOG_TAG", "", "debugLogsEnabled", "", "Lcom/revenuecat/purchases/LogLevel;", "getDebugLogsEnabled", "(Lcom/revenuecat/purchases/LogLevel;)Z", "debugLog", "", "message", "errorLog", "error", "Lcom/revenuecat/purchases/PurchasesError;", "throwable", "", "infoLog", "logIfEnabled", "level", "logger", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "tag", "verboseLog", "warnLog", "Lcom/revenuecat/purchases/LogLevel$Companion;", "enabled", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: logUtils.kt */
public final class LogUtilsKt {
    private static final String PURCHASES_LOG_TAG = "[Purchases]";

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: logUtils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|(2:53|54)|55|57) */
        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00dc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0104 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.revenuecat.purchases.PurchasesErrorCode[] r0 = com.revenuecat.purchases.PurchasesErrorCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.UnknownError     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.NetworkError     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.ReceiptAlreadyInUseError     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.UnexpectedBackendResponseError     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.InvalidAppUserIdError     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.OperationAlreadyInProgressError     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.UnknownBackendError     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.LogOutWithAnonymousUserError     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.ConfigurationError     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.UnsupportedError     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.EmptySubscriberAttributesError     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.CustomerInfoError     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.SignatureVerificationError     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.InvalidSubscriberAttributesError     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.PurchaseCancelledError     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.StoreProblemError     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.PurchaseNotAllowedError     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.PurchaseInvalidError     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.ProductNotAvailableForPurchaseError     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.ProductAlreadyPurchasedError     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.InvalidReceiptError     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.MissingReceiptFileError     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.InvalidAppleSubscriptionKeyError     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.IneligibleError     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.InsufficientPermissionsError     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.PaymentPendingError     // Catch:{ NoSuchFieldError -> 0x0104 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0104 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0104 }
            L_0x0104:
                com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.InvalidCredentialsError     // Catch:{ NoSuchFieldError -> 0x010e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010e }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x010e }
            L_0x010e:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.LogUtilsKt.WhenMappings.<clinit>():void");
        }
    }

    public static final boolean getDebugLogsEnabled(LogLevel logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "<this>");
        return logLevel.compareTo(LogLevel.DEBUG) <= 0;
    }

    public static final LogLevel debugLogsEnabled(LogLevel.Companion companion, boolean z) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        if (z) {
            return LogLevel.DEBUG;
        }
        return LogLevel.INFO;
    }

    public static final void verboseLog(String str) {
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        logIfEnabled(LogLevel.VERBOSE, new LogUtilsKt$verboseLog$1(LogWrapperKt.getCurrentLogHandler()), str);
    }

    public static final void debugLog(String str) {
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        logIfEnabled(LogLevel.DEBUG, new LogUtilsKt$debugLog$1(LogWrapperKt.getCurrentLogHandler()), str);
    }

    public static final void infoLog(String str) {
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        logIfEnabled(LogLevel.INFO, new LogUtilsKt$infoLog$1(LogWrapperKt.getCurrentLogHandler()), str);
    }

    public static final void warnLog(String str) {
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        logIfEnabled(LogLevel.WARN, new LogUtilsKt$warnLog$1(LogWrapperKt.getCurrentLogHandler()), str);
    }

    public static /* synthetic */ void errorLog$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        errorLog(str, th);
    }

    public static final void errorLog(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", str, th);
    }

    private static final void logIfEnabled(LogLevel logLevel, Function2<? super String, ? super String, Unit> function2, String str) {
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            function2.invoke("[Purchases] - " + logLevel.name(), str);
        }
    }

    public static final void errorLog(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        switch (WhenMappings.$EnumSwitchMapping$0[purchasesError.getCode().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                LogWrapperKt.log(LogIntent.RC_ERROR, purchasesError.toString());
                return;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                LogWrapperKt.log(LogIntent.GOOGLE_ERROR, purchasesError.toString());
                return;
            default:
                return;
        }
    }
}
