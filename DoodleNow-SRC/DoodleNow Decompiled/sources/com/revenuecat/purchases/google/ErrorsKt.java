package com.revenuecat.purchases.google;

import com.android.billingclient.api.BillingClient;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"IN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE", "", "billingResponseToPurchasesError", "Lcom/revenuecat/purchases/PurchasesError;", "", "underlyingErrorMessage", "getBillingResponseCodeName", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: errors.kt */
public final class ErrorsKt {
    public static final String IN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE = "Google Play In-app Billing API version is less than 3";

    public static final String getBillingResponseCodeName(int i) {
        String str;
        Field field;
        Field[] declaredFields = BillingClient.BillingResponseCode.class.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "allPossibleBillingResponseCodes");
        int length = declaredFields.length;
        int i2 = 0;
        while (true) {
            str = null;
            if (i2 >= length) {
                field = null;
                break;
            }
            field = declaredFields[i2];
            if (field.getInt(field) == i) {
                break;
            }
            i2++;
        }
        if (field != null) {
            str = field.getName();
        }
        return str == null ? String.valueOf(i) : str;
    }

    public static final PurchasesError billingResponseToPurchasesError(int i, String str) {
        PurchasesErrorCode purchasesErrorCode;
        Intrinsics.checkNotNullParameter(str, "underlyingErrorMessage");
        if (i != 12) {
            switch (i) {
                case -3:
                case -1:
                case 2:
                case 6:
                    purchasesErrorCode = PurchasesErrorCode.StoreProblemError;
                    break;
                case -2:
                case 3:
                case 8:
                    purchasesErrorCode = PurchasesErrorCode.PurchaseNotAllowedError;
                    break;
                case 0:
                    purchasesErrorCode = PurchasesErrorCode.UnknownError;
                    break;
                case 1:
                    purchasesErrorCode = PurchasesErrorCode.PurchaseCancelledError;
                    break;
                case 4:
                    purchasesErrorCode = PurchasesErrorCode.ProductNotAvailableForPurchaseError;
                    break;
                case 5:
                    purchasesErrorCode = PurchasesErrorCode.PurchaseInvalidError;
                    break;
                case 7:
                    purchasesErrorCode = PurchasesErrorCode.ProductAlreadyPurchasedError;
                    break;
                default:
                    purchasesErrorCode = PurchasesErrorCode.UnknownError;
                    break;
            }
        } else {
            purchasesErrorCode = PurchasesErrorCode.NetworkError;
        }
        return new PurchasesError(purchasesErrorCode, str);
    }
}
