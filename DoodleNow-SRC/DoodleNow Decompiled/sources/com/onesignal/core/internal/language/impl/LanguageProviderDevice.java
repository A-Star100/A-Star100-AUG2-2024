package com.onesignal.core.internal.language.impl;

import com.amplitude.api.Constants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/onesignal/core/internal/language/impl/LanguageProviderDevice;", "", "()V", "language", "", "getLanguage", "()Ljava/lang/String;", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LanguageProviderDevice.kt */
public final class LanguageProviderDevice {
    private static final String CHINESE = "zh";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String HEBREW_CORRECTED = "he";
    private static final String HEBREW_INCORRECT = "iw";
    private static final String INDONESIAN_CORRECTED = "id";
    private static final String INDONESIAN_INCORRECT = "in";
    private static final String YIDDISH_CORRECTED = "yi";
    private static final String YIDDISH_INCORRECT = "ji";

    public final String getLanguage() {
        String language = Locale.getDefault().getLanguage();
        if (language != null) {
            int hashCode = language.hashCode();
            if (hashCode != 3365) {
                if (hashCode != 3374) {
                    if (hashCode != 3391) {
                        if (hashCode == 3886 && language.equals(CHINESE)) {
                            return language + '-' + Locale.getDefault().getCountry();
                        }
                    } else if (language.equals(YIDDISH_INCORRECT)) {
                        return YIDDISH_CORRECTED;
                    }
                } else if (language.equals(HEBREW_INCORRECT)) {
                    return HEBREW_CORRECTED;
                }
            } else if (language.equals(INDONESIAN_INCORRECT)) {
                return "id";
            }
        }
        Intrinsics.checkNotNullExpressionValue(language, Constants.AMP_TRACKING_OPTION_LANGUAGE);
        return language;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/onesignal/core/internal/language/impl/LanguageProviderDevice$Companion;", "", "()V", "CHINESE", "", "HEBREW_CORRECTED", "HEBREW_INCORRECT", "INDONESIAN_CORRECTED", "INDONESIAN_INCORRECT", "YIDDISH_CORRECTED", "YIDDISH_INCORRECT", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: LanguageProviderDevice.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
