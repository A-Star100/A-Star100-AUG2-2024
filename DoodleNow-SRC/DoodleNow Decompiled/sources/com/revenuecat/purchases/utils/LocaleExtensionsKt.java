package com.revenuecat.purchases.utils;

import androidx.core.os.LocaleListCompat;
import com.facebook.hermes.intl.Constants;
import com.revenuecat.purchases.common.LogUtilsKt;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0001\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0002H\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0000\u001a\u0012\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\nH\u0002\u001a\f\u0010\u000b\u001a\u00020\u0002*\u00020\u0005H\u0001¨\u0006\f"}, d2 = {"getDefaultLocales", "", "Ljava/util/Locale;", "convertToCorrectlyFormattedLocale", "inferScript", "", "sharedLanguageCodeWith", "", "locale", "toList", "Landroidx/core/os/LocaleListCompat;", "toLocale", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocaleExtensions.kt */
public final class LocaleExtensionsKt {
    public static final Locale convertToCorrectlyFormattedLocale(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        String locale2 = locale.toString();
        Intrinsics.checkNotNullExpressionValue(locale2, "toString()");
        return toLocale(locale2);
    }

    public static final Locale toLocale(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Locale forLanguageTag = Locale.forLanguageTag(StringsKt.replace$default(str, "_", "-", false, 4, (Object) null));
        Intrinsics.checkNotNullExpressionValue(forLanguageTag, "forLanguageTag(replace(\"_\", \"-\"))");
        return forLanguageTag;
    }

    public static final boolean sharedLanguageCodeWith(Locale locale, Locale locale2) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        Intrinsics.checkNotNullParameter(locale2, Constants.LOCALE);
        try {
            return Intrinsics.areEqual((Object) locale.getISO3Language(), (Object) locale2.getISO3Language()) && Intrinsics.areEqual((Object) inferScript(locale), (Object) inferScript(locale2));
        } catch (MissingResourceException e) {
            LogUtilsKt.errorLog$default("Locale " + locale + " or " + locale2 + " can't obtain ISO3 language code (" + e + "). Falling back to language.", (Throwable) null, 2, (Object) null);
            return Intrinsics.areEqual((Object) locale.getLanguage(), (Object) locale2.getLanguage());
        }
    }

    public static final List<Locale> getDefaultLocales() {
        LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
        Intrinsics.checkNotNullExpressionValue(localeListCompat, "getDefault()");
        return toList(localeListCompat);
    }

    private static final String inferScript(Locale locale) {
        String country;
        CharSequence script = locale.getScript();
        if (script != null && script.length() != 0) {
            String script2 = locale.getScript();
            Intrinsics.checkNotNullExpressionValue(script2, "script");
            return script2;
        } else if (!Intrinsics.areEqual((Object) locale.getLanguage(), (Object) "zh") || (country = locale.getCountry()) == null) {
            return "";
        } else {
            int hashCode = country.hashCode();
            if (hashCode != 2155) {
                if (hashCode != 2307) {
                    if (hashCode != 2466) {
                        if (hashCode != 2644) {
                            return (hashCode == 2691 && country.equals("TW")) ? "Hant" : "";
                        }
                        if (!country.equals("SG")) {
                            return "";
                        }
                    } else if (!country.equals("MO")) {
                        return "";
                    }
                } else if (!country.equals("HK")) {
                    return "";
                }
            } else if (!country.equals("CN")) {
                return "";
            }
            return "Hans";
        }
    }

    private static final List<Locale> toList(LocaleListCompat localeListCompat) {
        int size = localeListCompat.size();
        Locale[] localeArr = new Locale[size];
        for (int i = 0; i < size; i++) {
            localeArr[i] = localeListCompat.get(i);
        }
        return ArraysKt.filterNotNull(localeArr);
    }
}
