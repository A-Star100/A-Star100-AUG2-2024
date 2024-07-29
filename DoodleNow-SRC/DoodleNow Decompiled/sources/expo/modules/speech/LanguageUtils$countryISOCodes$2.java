package expo.modules.speech;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "Ljava/util/Locale;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LanguageUtils.kt */
final class LanguageUtils$countryISOCodes$2 extends Lambda implements Function0<Map<String, ? extends Locale>> {
    public static final LanguageUtils$countryISOCodes$2 INSTANCE = new LanguageUtils$countryISOCodes$2();

    LanguageUtils$countryISOCodes$2() {
        super(0);
    }

    public final Map<String, Locale> invoke() {
        String[] iSOCountries = Locale.getISOCountries();
        Intrinsics.checkNotNullExpressionValue(iSOCountries, "getISOCountries(...)");
        Object[] objArr = (Object[]) iSOCountries;
        Map<String, Locale> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(objArr.length), 16));
        for (Object obj : objArr) {
            Locale locale = new Locale("", (String) obj);
            String iSO3Country = locale.getISO3Country();
            Intrinsics.checkNotNullExpressionValue(iSO3Country, "getISO3Country(...)");
            String upperCase = iSO3Country.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            Pair pair = TuplesKt.to(upperCase, locale);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
