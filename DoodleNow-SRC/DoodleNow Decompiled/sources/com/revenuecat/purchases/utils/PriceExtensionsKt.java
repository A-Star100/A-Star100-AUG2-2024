package com.revenuecat.purchases.utils;

import com.facebook.hermes.intl.Constants;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001c\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u001c\u0010\n\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001c\u0010\u000b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"MICRO_MULTIPLIER", "", "pricePerMonth", "Lcom/revenuecat/purchases/models/Price;", "billingPeriod", "Lcom/revenuecat/purchases/models/Period;", "locale", "Ljava/util/Locale;", "pricePerPeriod", "units", "pricePerWeek", "pricePerYear", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: PriceExtensions.kt */
public final class PriceExtensionsKt {
    private static final double MICRO_MULTIPLIER = 1000000.0d;

    public static final Price pricePerWeek(Price price, Period period, Locale locale) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(period, "billingPeriod");
        Intrinsics.checkNotNullParameter(locale, Constants.LOCALE);
        return pricePerPeriod(price, period.getValueInWeeks$purchases_defaultsRelease(), locale);
    }

    public static final Price pricePerMonth(Price price, Period period, Locale locale) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(period, "billingPeriod");
        Intrinsics.checkNotNullParameter(locale, Constants.LOCALE);
        return pricePerPeriod(price, period.getValueInMonths(), locale);
    }

    public static final Price pricePerYear(Price price, Period period, Locale locale) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(period, "billingPeriod");
        Intrinsics.checkNotNullParameter(locale, Constants.LOCALE);
        return pricePerPeriod(price, period.getValueInYears$purchases_defaultsRelease(), locale);
    }

    private static final Price pricePerPeriod(Price price, double d, Locale locale) {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
        currencyInstance.setCurrency(Currency.getInstance(price.getCurrencyCode()));
        double amountMicros = ((double) price.getAmountMicros()) / d;
        String format = currencyInstance.format(amountMicros / MICRO_MULTIPLIER);
        Intrinsics.checkNotNullExpressionValue(format, "formatted");
        return new Price(format, (long) amountMicros, price.getCurrencyCode());
    }
}
