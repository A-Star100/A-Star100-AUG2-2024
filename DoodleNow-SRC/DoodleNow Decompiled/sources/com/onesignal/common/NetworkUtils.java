package com.onesignal.common;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/onesignal/common/NetworkUtils;", "", "()V", "maxNetworkRequestAttemptCount", "", "getMaxNetworkRequestAttemptCount", "()I", "setMaxNetworkRequestAttemptCount", "(I)V", "getResponseStatusType", "Lcom/onesignal/common/NetworkUtils$ResponseStatusType;", "statusCode", "ResponseStatusType", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NetworkUtils.kt */
public final class NetworkUtils {
    public static final NetworkUtils INSTANCE = new NetworkUtils();
    private static int maxNetworkRequestAttemptCount = 3;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/onesignal/common/NetworkUtils$ResponseStatusType;", "", "(Ljava/lang/String;I)V", "INVALID", "RETRYABLE", "UNAUTHORIZED", "MISSING", "CONFLICT", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NetworkUtils.kt */
    public enum ResponseStatusType {
        INVALID,
        RETRYABLE,
        UNAUTHORIZED,
        MISSING,
        CONFLICT
    }

    public final int getMaxNetworkRequestAttemptCount() {
        return maxNetworkRequestAttemptCount;
    }

    public final void setMaxNetworkRequestAttemptCount(int i) {
        maxNetworkRequestAttemptCount = i;
    }

    private NetworkUtils() {
    }

    public final ResponseStatusType getResponseStatusType(int i) {
        if (i == 409) {
            return ResponseStatusType.CONFLICT;
        }
        if (i != 410) {
            if (i == 429) {
                return ResponseStatusType.RETRYABLE;
            }
            switch (i) {
                case 400:
                case 402:
                    return ResponseStatusType.INVALID;
                case 401:
                case 403:
                    return ResponseStatusType.UNAUTHORIZED;
                case RCHTTPStatusCodes.NOT_FOUND /*404*/:
                    break;
                default:
                    return ResponseStatusType.RETRYABLE;
            }
        }
        return ResponseStatusType.MISSING;
    }
}
