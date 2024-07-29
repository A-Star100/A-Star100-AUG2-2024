package com.revenuecat.purchases.hybridcommon.mappers;

import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PurchasesPeriod {
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    private static final PurchasesPeriod ZERO = new PurchasesPeriod(0, 0, 0);
    final int days;
    final int months;
    final int years;

    private PurchasesPeriod(int i, int i2, int i3) {
        this.years = i;
        this.months = i2;
        this.days = i3;
    }

    private static PurchasesPeriod create(int i, int i2, int i3) {
        return ((i | i2) | i3) == 0 ? ZERO : new PurchasesPeriod(i, i2, i3);
    }

    public static PurchasesPeriod parse(CharSequence charSequence) {
        Matcher matcher = PATTERN.matcher(charSequence);
        if (matcher.matches()) {
            int i = 1;
            if ("-".equals(matcher.group(1))) {
                i = -1;
            }
            String group = matcher.group(2);
            String group2 = matcher.group(3);
            String group3 = matcher.group(4);
            String group4 = matcher.group(5);
            if (!(group == null && group2 == null && group4 == null && group3 == null)) {
                try {
                    return create(parseNumber(charSequence, group, i), parseNumber(charSequence, group2, i), PurchasesMath.addExact(parseNumber(charSequence, group4, i), PurchasesMath.multiplyExact(parseNumber(charSequence, group3, i), 7)));
                } catch (ArithmeticException | NumberFormatException unused) {
                    Log.e("PURCHASES", "Text cannot be parsed to a Period: " + charSequence);
                    return null;
                }
            }
        }
        Log.e("PURCHASES", "Text cannot be parsed to a Period: " + charSequence);
        return null;
    }

    private static int parseNumber(CharSequence charSequence, String str, int i) {
        if (str == null) {
            return 0;
        }
        return PurchasesMath.multiplyExact(Integer.parseInt(str), i);
    }
}
