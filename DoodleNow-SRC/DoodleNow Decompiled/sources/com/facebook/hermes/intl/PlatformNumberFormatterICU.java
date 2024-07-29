package com.facebook.hermes.intl;

import android.icu.text.CompactDecimalFormat;
import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;
import android.icu.text.MeasureFormat;
import android.icu.text.NumberFormat;
import android.icu.util.Currency;
import android.icu.util.MeasureUnit;
import android.icu.util.ULocale;
import androidx.camera.video.AudioStats;
import com.amazon.a.a.o.b;
import com.facebook.hermes.intl.IPlatformNumberFormatter;
import com.facebook.react.views.text.ReactTextView$$ExternalSyntheticApiModelOutline0;
import java.text.AttributedCharacterIterator;
import java.text.Format;
import java.util.ArrayList;

public class PlatformNumberFormatterICU implements IPlatformNumberFormatter {
    private Format mFinalFormat;
    private LocaleObjectICU mLocaleObject;
    private MeasureUnit mMeasureUnit;
    private NumberFormat mNumberFormat;
    private IPlatformNumberFormatter.Style mStyle;

    PlatformNumberFormatterICU() {
    }

    private void initialize(NumberFormat numberFormat, ILocaleObject<?> iLocaleObject, IPlatformNumberFormatter.Style style) {
        this.mNumberFormat = numberFormat;
        this.mFinalFormat = numberFormat;
        this.mLocaleObject = (LocaleObjectICU) iLocaleObject;
        this.mStyle = style;
        numberFormat.setRoundingMode(4);
    }

    public PlatformNumberFormatterICU setCurrency(String str, IPlatformNumberFormatter.CurrencyDisplay currencyDisplay) throws JSRangeErrorException {
        if (this.mStyle == IPlatformNumberFormatter.Style.CURRENCY) {
            Currency m = ReactTextView$$ExternalSyntheticApiModelOutline0.m(str);
            this.mNumberFormat.setCurrency(m);
            if (currencyDisplay != IPlatformNumberFormatter.CurrencyDisplay.CODE) {
                str = m.getName(this.mLocaleObject.getLocale(), currencyDisplay.getNameStyle(), (boolean[]) null);
            }
            if (Intl$$ExternalSyntheticApiModelOutline0.m((Object) this.mNumberFormat)) {
                DecimalFormat m2 = Intl$$ExternalSyntheticApiModelOutline0.m((Object) this.mNumberFormat);
                DecimalFormatSymbols m3 = Intl$$ExternalSyntheticApiModelOutline0.m(m2);
                m3.setCurrencySymbol(str);
                m2.setDecimalFormatSymbols(m3);
            }
        }
        return this;
    }

    public PlatformNumberFormatterICU setGrouping(boolean z) {
        this.mNumberFormat.setGroupingUsed(z);
        return this;
    }

    public PlatformNumberFormatterICU setMinIntergerDigits(int i) {
        if (i != -1) {
            this.mNumberFormat.setMinimumIntegerDigits(i);
        }
        return this;
    }

    public PlatformNumberFormatterICU setSignificantDigits(IPlatformNumberFormatter.RoundingType roundingType, int i, int i2) throws JSRangeErrorException {
        if (Intl$$ExternalSyntheticApiModelOutline0.m((Object) this.mNumberFormat) && roundingType == IPlatformNumberFormatter.RoundingType.SIGNIFICANT_DIGITS) {
            DecimalFormat m = Intl$$ExternalSyntheticApiModelOutline0.m((Object) this.mNumberFormat);
            if (i >= 0) {
                m.setMinimumSignificantDigits(i);
            }
            if (i2 >= 0) {
                if (i2 >= Intl$$ExternalSyntheticApiModelOutline0.m(m)) {
                    m.setMaximumSignificantDigits(i2);
                } else {
                    throw new JSRangeErrorException("maximumSignificantDigits should be at least equal to minimumSignificantDigits");
                }
            }
            m.setSignificantDigitsUsed(true);
        }
        return this;
    }

    public PlatformNumberFormatterICU setFractionDigits(IPlatformNumberFormatter.RoundingType roundingType, int i, int i2) {
        if (roundingType == IPlatformNumberFormatter.RoundingType.FRACTION_DIGITS) {
            if (i >= 0) {
                this.mNumberFormat.setMinimumFractionDigits(i);
            }
            if (i2 >= 0) {
                this.mNumberFormat.setMaximumFractionDigits(i2);
            }
            if (Intl$$ExternalSyntheticApiModelOutline0.m((Object) this.mNumberFormat)) {
                Intl$$ExternalSyntheticApiModelOutline0.m((Object) this.mNumberFormat).setSignificantDigitsUsed(false);
            }
        }
        return this;
    }

    public PlatformNumberFormatterICU setSignDisplay(IPlatformNumberFormatter.SignDisplay signDisplay) {
        if (Intl$$ExternalSyntheticApiModelOutline0.m((Object) this.mNumberFormat)) {
            DecimalFormat m = Intl$$ExternalSyntheticApiModelOutline0.m((Object) this.mNumberFormat);
            DecimalFormatSymbols m2 = Intl$$ExternalSyntheticApiModelOutline0.m(m);
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformNumberFormatter$SignDisplay[signDisplay.ordinal()];
            if (i == 1) {
                m.setPositivePrefix("");
                m.setPositiveSuffix("");
                m.setNegativePrefix("");
                m.setNegativeSuffix("");
            } else if (i == 2 || i == 3) {
                if (!m.getNegativePrefix().isEmpty()) {
                    m.setPositivePrefix(new String(new char[]{m2.getPlusSign()}));
                }
                if (!m.getNegativeSuffix().isEmpty()) {
                    m.setPositiveSuffix(new String(new char[]{m2.getPlusSign()}));
                }
            }
        }
        return this;
    }

    /* renamed from: com.facebook.hermes.intl.PlatformNumberFormatterICU$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$hermes$intl$IPlatformNumberFormatter$SignDisplay;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.hermes.intl.IPlatformNumberFormatter$SignDisplay[] r0 = com.facebook.hermes.intl.IPlatformNumberFormatter.SignDisplay.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$hermes$intl$IPlatformNumberFormatter$SignDisplay = r0
                com.facebook.hermes.intl.IPlatformNumberFormatter$SignDisplay r1 = com.facebook.hermes.intl.IPlatformNumberFormatter.SignDisplay.NEVER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$hermes$intl$IPlatformNumberFormatter$SignDisplay     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.hermes.intl.IPlatformNumberFormatter$SignDisplay r1 = com.facebook.hermes.intl.IPlatformNumberFormatter.SignDisplay.ALWAYS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$hermes$intl$IPlatformNumberFormatter$SignDisplay     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.hermes.intl.IPlatformNumberFormatter$SignDisplay r1 = com.facebook.hermes.intl.IPlatformNumberFormatter.SignDisplay.EXCEPTZERO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.PlatformNumberFormatterICU.AnonymousClass1.<clinit>():void");
        }
    }

    private static MeasureUnit parseUnit(String str) throws JSRangeErrorException {
        for (Object m : ReactTextView$$ExternalSyntheticApiModelOutline0.m()) {
            MeasureUnit m2 = ReactTextView$$ExternalSyntheticApiModelOutline0.m(m);
            if (!m2.getSubtype().equals(str)) {
                String m3 = m2.getSubtype();
                if (m3.equals(m2.getType() + "-" + str)) {
                }
            }
            return m2;
        }
        throw new JSRangeErrorException("Unknown unit: " + str);
    }

    public PlatformNumberFormatterICU setUnits(String str, IPlatformNumberFormatter.UnitDisplay unitDisplay) throws JSRangeErrorException {
        if (this.mStyle == IPlatformNumberFormatter.Style.UNIT) {
            this.mMeasureUnit = parseUnit(str);
            this.mFinalFormat = MeasureFormat.getInstance(this.mLocaleObject.getLocale(), unitDisplay.getFormatWidth(), this.mNumberFormat);
        }
        return this;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
        return com.facebook.react.views.text.ReactTextView$$ExternalSyntheticApiModelOutline0.m(com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m(com.facebook.react.views.text.ReactTextView$$ExternalSyntheticApiModelOutline0.m("en")), r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
        return com.facebook.react.views.text.ReactTextView$$ExternalSyntheticApiModelOutline0.m(com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m(com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m()), r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String format(double r4) {
        /*
            r3 = this;
            java.text.Format r0 = r3.mFinalFormat     // Catch:{ NumberFormatException -> 0x002b }
            boolean r0 = com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m$1((java.lang.Object) r0)     // Catch:{ NumberFormatException -> 0x002b }
            if (r0 == 0) goto L_0x0020
            android.icu.util.MeasureUnit r0 = r3.mMeasureUnit     // Catch:{ NumberFormatException -> 0x002b }
            if (r0 == 0) goto L_0x0020
            java.text.Format r0 = r3.mFinalFormat     // Catch:{ NumberFormatException -> 0x002b }
            com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m()     // Catch:{ NumberFormatException -> 0x002b }
            java.lang.Double r1 = java.lang.Double.valueOf(r4)     // Catch:{ NumberFormatException -> 0x002b }
            android.icu.util.MeasureUnit r2 = r3.mMeasureUnit     // Catch:{ NumberFormatException -> 0x002b }
            android.icu.util.Measure r1 = com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m((java.lang.Number) r1, (android.icu.util.MeasureUnit) r2)     // Catch:{ NumberFormatException -> 0x002b }
            java.lang.String r4 = r0.format(r1)     // Catch:{ NumberFormatException -> 0x002b }
            goto L_0x002a
        L_0x0020:
            java.text.Format r0 = r3.mFinalFormat     // Catch:{ NumberFormatException -> 0x002b }
            java.lang.Double r1 = java.lang.Double.valueOf(r4)     // Catch:{ NumberFormatException -> 0x002b }
            java.lang.String r4 = r0.format(r1)     // Catch:{ NumberFormatException -> 0x002b }
        L_0x002a:
            return r4
        L_0x002b:
            android.icu.util.ULocale r0 = com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m()     // Catch:{ RuntimeException -> 0x0038 }
            android.icu.text.NumberFormat r0 = com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m((android.icu.util.ULocale) r0)     // Catch:{ RuntimeException -> 0x0038 }
            java.lang.String r4 = r0.format(r4)     // Catch:{ RuntimeException -> 0x0038 }
            return r4
        L_0x0038:
            java.lang.String r0 = "en"
            android.icu.util.ULocale r0 = com.facebook.react.views.text.ReactTextView$$ExternalSyntheticApiModelOutline0.m((java.lang.String) r0)
            android.icu.text.NumberFormat r0 = com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m((android.icu.util.ULocale) r0)
            java.lang.String r4 = r0.format(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.PlatformNumberFormatterICU.format(double):java.lang.String");
    }

    public String fieldToString(AttributedCharacterIterator.Attribute attribute, double d) {
        if (attribute == Intl$$ExternalSyntheticApiModelOutline0.m()) {
            return Double.compare(d, AudioStats.AUDIO_AMPLITUDE_NONE) >= 0 ? "plusSign" : "minusSign";
        }
        if (attribute == Intl$$ExternalSyntheticApiModelOutline0.m$2()) {
            if (Double.isNaN(d)) {
                return "nan";
            }
            return Double.isInfinite(d) ? "infinity" : "integer";
        } else if (attribute == Intl$$ExternalSyntheticApiModelOutline0.m$3()) {
            return "fraction";
        } else {
            if (attribute == Intl$$ExternalSyntheticApiModelOutline0.m$4()) {
                return "exponentInteger";
            }
            if (attribute == Intl$$ExternalSyntheticApiModelOutline0.m$5()) {
                return "exponentMinusSign";
            }
            if (attribute == Intl$$ExternalSyntheticApiModelOutline0.m$6()) {
                return "exponentSeparator";
            }
            if (attribute == Intl$$ExternalSyntheticApiModelOutline0.m$7()) {
                return "decimal";
            }
            if (attribute == Intl$$ExternalSyntheticApiModelOutline0.m$8()) {
                return "group";
            }
            if (attribute == Intl$$ExternalSyntheticApiModelOutline0.m$9()) {
                return "percentSign";
            }
            if (attribute == Intl$$ExternalSyntheticApiModelOutline0.m$10()) {
                return "permilleSign";
            }
            if (attribute == Intl$$ExternalSyntheticApiModelOutline0.m$1()) {
                return b.a;
            }
            return attribute.toString().equals("android.icu.text.NumberFormat$Field(compact)") ? "compact" : "literal";
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.text.AttributedCharacterIterator formatToParts(double r5) {
        /*
            r4 = this;
            java.lang.String r0 = "en"
            java.text.Format r1 = r4.mFinalFormat     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            boolean r1 = com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m$1((java.lang.Object) r1)     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            if (r1 == 0) goto L_0x0022
            android.icu.util.MeasureUnit r1 = r4.mMeasureUnit     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            if (r1 == 0) goto L_0x0022
            java.text.Format r1 = r4.mFinalFormat     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m()     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            java.lang.Double r2 = java.lang.Double.valueOf(r5)     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            android.icu.util.MeasureUnit r3 = r4.mMeasureUnit     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            android.icu.util.Measure r2 = com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m((java.lang.Number) r2, (android.icu.util.MeasureUnit) r3)     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            java.text.AttributedCharacterIterator r5 = r1.formatToCharacterIterator(r2)     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            goto L_0x002c
        L_0x0022:
            java.text.Format r1 = r4.mFinalFormat     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            java.lang.Double r2 = java.lang.Double.valueOf(r5)     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            java.text.AttributedCharacterIterator r5 = r1.formatToCharacterIterator(r2)     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
        L_0x002c:
            return r5
        L_0x002d:
            android.icu.util.ULocale r0 = com.facebook.react.views.text.ReactTextView$$ExternalSyntheticApiModelOutline0.m((java.lang.String) r0)
            android.icu.text.NumberFormat r0 = com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m((android.icu.util.ULocale) r0)
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            java.text.AttributedCharacterIterator r5 = r0.formatToCharacterIterator(r5)
            return r5
        L_0x003e:
            android.icu.util.ULocale r1 = com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m()     // Catch:{ RuntimeException -> 0x004f }
            android.icu.text.NumberFormat r1 = com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m((android.icu.util.ULocale) r1)     // Catch:{ RuntimeException -> 0x004f }
            java.lang.Double r2 = java.lang.Double.valueOf(r5)     // Catch:{ RuntimeException -> 0x004f }
            java.text.AttributedCharacterIterator r5 = r1.formatToCharacterIterator(r2)     // Catch:{ RuntimeException -> 0x004f }
            return r5
        L_0x004f:
            android.icu.util.ULocale r0 = com.facebook.react.views.text.ReactTextView$$ExternalSyntheticApiModelOutline0.m((java.lang.String) r0)
            android.icu.text.NumberFormat r0 = com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0.m((android.icu.util.ULocale) r0)
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            java.text.AttributedCharacterIterator r5 = r0.formatToCharacterIterator(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.PlatformNumberFormatterICU.formatToParts(double):java.text.AttributedCharacterIterator");
    }

    public static int getCurrencyDigits(String str) throws JSRangeErrorException {
        try {
            return ReactTextView$$ExternalSyntheticApiModelOutline0.m(str).getDefaultFractionDigits();
        } catch (IllegalArgumentException unused) {
            throw new JSRangeErrorException("Invalid currency code !");
        }
    }

    public PlatformNumberFormatterICU configure(ILocaleObject<?> iLocaleObject, String str, IPlatformNumberFormatter.Style style, IPlatformNumberFormatter.CurrencySign currencySign, IPlatformNumberFormatter.Notation notation, IPlatformNumberFormatter.CompactDisplay compactDisplay) throws JSRangeErrorException {
        CompactDecimalFormat.CompactStyle compactStyle;
        if (!str.isEmpty()) {
            try {
                if (Intl$$ExternalSyntheticApiModelOutline0.m(JSObjects.getJavaString(str)) != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(JSObjects.getJavaString(str));
                    iLocaleObject.setUnicodeExtensions("nu", arrayList);
                } else {
                    throw new JSRangeErrorException("Invalid numbering system: " + str);
                }
            } catch (RuntimeException unused) {
                throw new JSRangeErrorException("Invalid numbering system: " + str);
            }
        }
        if (notation == IPlatformNumberFormatter.Notation.COMPACT && (style == IPlatformNumberFormatter.Style.DECIMAL || style == IPlatformNumberFormatter.Style.UNIT)) {
            if (compactDisplay == IPlatformNumberFormatter.CompactDisplay.SHORT) {
                compactStyle = Intl$$ExternalSyntheticApiModelOutline0.m();
            } else {
                compactStyle = ReactTextView$$ExternalSyntheticApiModelOutline0.m();
            }
            initialize(CompactDecimalFormat.getInstance(Intl$$ExternalSyntheticApiModelOutline0.m((Object) iLocaleObject.getLocale()), compactStyle), iLocaleObject, style);
        } else {
            NumberFormat m = NumberFormat.getInstance(Intl$$ExternalSyntheticApiModelOutline0.m((Object) iLocaleObject.getLocale()), style.getInitialNumberFormatStyle(notation, currencySign));
            if (notation == IPlatformNumberFormatter.Notation.ENGINEERING) {
                m.setMaximumIntegerDigits(3);
            }
            initialize(m, iLocaleObject, style);
        }
        return this;
    }

    public String[] getAvailableLocales() {
        ArrayList arrayList = new ArrayList();
        for (ULocale m : Intl$$ExternalSyntheticApiModelOutline0.m()) {
            arrayList.add(Intl$$ExternalSyntheticApiModelOutline0.m(m));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public String getDefaultNumberingSystem(ILocaleObject<?> iLocaleObject) throws JSRangeErrorException {
        return Intl$$ExternalSyntheticApiModelOutline0.m(Intl$$ExternalSyntheticApiModelOutline0.m((Object) iLocaleObject.getLocale())).getName();
    }
}
