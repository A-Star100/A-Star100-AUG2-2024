package com.revenuecat.purchases.paywalls;

import com.facebook.react.modules.appstate.AppStateModule;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.utils.LocaleExtensionsKt;
import com.revenuecat.purchases.utils.serializers.OptionalURLSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 ?2\u00020\u0001:\u0004>?@AB[\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010B;\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u0011J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fHÀ\u0003¢\u0006\u0002\b,J\u0012\u0010-\u001a\u0004\u0018\u00010\r2\u0006\u0010.\u001a\u00020\u001aH\u0007JG\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r0\u00192\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001a05H\u0007J\t\u00106\u001a\u00020\u0005HÖ\u0001J!\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=HÇ\u0001R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r0\u00198CX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r0\u00198G¢\u0006\u0006\u001a\u0004\b!\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010&¨\u0006B"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData;", "", "seen1", "", "templateName", "", "config", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "assetBaseURL", "Ljava/net/URL;", "revision", "localization", "", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;Ljava/net/URL;ILjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;Ljava/net/URL;ILjava/util/Map;)V", "getAssetBaseURL$annotations", "()V", "getAssetBaseURL", "()Ljava/net/URL;", "getConfig", "()Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "fallbackLocalizedConfiguration", "Lkotlin/Pair;", "Ljava/util/Locale;", "getFallbackLocalizedConfiguration", "()Lkotlin/Pair;", "getLocalization$purchases_defaultsRelease$annotations", "getLocalization$purchases_defaultsRelease", "()Ljava/util/Map;", "localizedConfiguration", "getLocalizedConfiguration", "getRevision", "()I", "getTemplateName$annotations", "getTemplateName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component5$purchases_defaultsRelease", "configForLocale", "requiredLocale", "copy", "equals", "", "other", "hashCode", "locales", "", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "Configuration", "LocalizedConfiguration", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: PaywallData.kt */
public final class PaywallData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final URL assetBaseURL;
    private final Configuration config;
    private final Map<String, LocalizedConfiguration> localization;
    private final int revision;
    private final String templateName;

    public static /* synthetic */ PaywallData copy$default(PaywallData paywallData, String str, Configuration configuration, URL url, int i, Map<String, LocalizedConfiguration> map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paywallData.templateName;
        }
        if ((i2 & 2) != 0) {
            configuration = paywallData.config;
        }
        Configuration configuration2 = configuration;
        if ((i2 & 4) != 0) {
            url = paywallData.assetBaseURL;
        }
        URL url2 = url;
        if ((i2 & 8) != 0) {
            i = paywallData.revision;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            map = paywallData.localization;
        }
        return paywallData.copy(str, configuration2, url2, i3, map);
    }

    @Serializable(with = URLSerializer.class)
    @SerialName("asset_base_url")
    public static /* synthetic */ void getAssetBaseURL$annotations() {
    }

    @SerialName("localized_strings")
    public static /* synthetic */ void getLocalization$purchases_defaultsRelease$annotations() {
    }

    @SerialName("template_name")
    public static /* synthetic */ void getTemplateName$annotations() {
    }

    public final String component1() {
        return this.templateName;
    }

    public final Configuration component2() {
        return this.config;
    }

    public final URL component3() {
        return this.assetBaseURL;
    }

    public final int component4() {
        return this.revision;
    }

    public final Map<String, LocalizedConfiguration> component5$purchases_defaultsRelease() {
        return this.localization;
    }

    public final PaywallData copy(String str, Configuration configuration, URL url, int i, Map<String, LocalizedConfiguration> map) {
        Intrinsics.checkNotNullParameter(str, "templateName");
        Intrinsics.checkNotNullParameter(configuration, "config");
        Intrinsics.checkNotNullParameter(url, "assetBaseURL");
        Intrinsics.checkNotNullParameter(map, "localization");
        return new PaywallData(str, configuration, url, i, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallData)) {
            return false;
        }
        PaywallData paywallData = (PaywallData) obj;
        return Intrinsics.areEqual((Object) this.templateName, (Object) paywallData.templateName) && Intrinsics.areEqual((Object) this.config, (Object) paywallData.config) && Intrinsics.areEqual((Object) this.assetBaseURL, (Object) paywallData.assetBaseURL) && this.revision == paywallData.revision && Intrinsics.areEqual((Object) this.localization, (Object) paywallData.localization);
    }

    public final URL getAssetBaseURL() {
        return this.assetBaseURL;
    }

    public final Configuration getConfig() {
        return this.config;
    }

    public final Map<String, LocalizedConfiguration> getLocalization$purchases_defaultsRelease() {
        return this.localization;
    }

    public final int getRevision() {
        return this.revision;
    }

    public final String getTemplateName() {
        return this.templateName;
    }

    public int hashCode() {
        return (((((((this.templateName.hashCode() * 31) + this.config.hashCode()) * 31) + this.assetBaseURL.hashCode()) * 31) + this.revision) * 31) + this.localization.hashCode();
    }

    public String toString() {
        return "PaywallData(templateName=" + this.templateName + ", config=" + this.config + ", assetBaseURL=" + this.assetBaseURL + ", revision=" + this.revision + ", localization=" + this.localization + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PaywallData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PaywallData> serializer() {
            return PaywallData$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PaywallData(int i, @SerialName("template_name") String str, Configuration configuration, @Serializable(with = URLSerializer.class) @SerialName("asset_base_url") URL url, int i2, @SerialName("localized_strings") Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (23 != (i & 23)) {
            PluginExceptionsKt.throwMissingFieldException(i, 23, PaywallData$$serializer.INSTANCE.getDescriptor());
        }
        this.templateName = str;
        this.config = configuration;
        this.assetBaseURL = url;
        if ((i & 8) == 0) {
            this.revision = 0;
        } else {
            this.revision = i2;
        }
        this.localization = map;
    }

    public PaywallData(String str, Configuration configuration, URL url, int i, Map<String, LocalizedConfiguration> map) {
        Intrinsics.checkNotNullParameter(str, "templateName");
        Intrinsics.checkNotNullParameter(configuration, "config");
        Intrinsics.checkNotNullParameter(url, "assetBaseURL");
        Intrinsics.checkNotNullParameter(map, "localization");
        this.templateName = str;
        this.config = configuration;
        this.assetBaseURL = url;
        this.revision = i;
        this.localization = map;
    }

    @JvmStatic
    public static final void write$Self(PaywallData paywallData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(paywallData, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        compositeEncoder.encodeStringElement(serialDescriptor, 0, paywallData.templateName);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, PaywallData$Configuration$$serializer.INSTANCE, paywallData.config);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, URLSerializer.INSTANCE, paywallData.assetBaseURL);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || paywallData.revision != 0) {
            compositeEncoder.encodeIntElement(serialDescriptor, 3, paywallData.revision);
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 4, new LinkedHashMapSerializer(StringSerializer.INSTANCE, PaywallData$LocalizedConfiguration$$serializer.INSTANCE), paywallData.localization);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaywallData(String str, Configuration configuration, URL url, int i, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, configuration, url, (i2 & 8) != 0 ? 0 : i, map);
    }

    public final Pair<Locale, LocalizedConfiguration> getLocalizedConfiguration() {
        return localizedConfiguration(LocaleExtensionsKt.getDefaultLocales());
    }

    public final Pair<Locale, LocalizedConfiguration> localizedConfiguration(List<Locale> list) {
        Intrinsics.checkNotNullParameter(list, "locales");
        for (Locale convertToCorrectlyFormattedLocale : list) {
            Locale convertToCorrectlyFormattedLocale2 = LocaleExtensionsKt.convertToCorrectlyFormattedLocale(convertToCorrectlyFormattedLocale);
            LocalizedConfiguration configForLocale = configForLocale(convertToCorrectlyFormattedLocale2);
            if (configForLocale != null) {
                return TuplesKt.to(convertToCorrectlyFormattedLocale2, configForLocale);
            }
        }
        return getFallbackLocalizedConfiguration();
    }

    private final Pair<Locale, LocalizedConfiguration> getFallbackLocalizedConfiguration() {
        Map.Entry entry = (Map.Entry) CollectionsKt.first(this.localization.entrySet());
        return TuplesKt.to(LocaleExtensionsKt.toLocale((String) entry.getKey()), entry.getValue());
    }

    public final LocalizedConfiguration configForLocale(Locale locale) {
        Object obj;
        Intrinsics.checkNotNullParameter(locale, "requiredLocale");
        LocalizedConfiguration localizedConfiguration = this.localization.get(locale.toString());
        if (localizedConfiguration != null) {
            return localizedConfiguration;
        }
        Iterator it = this.localization.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (LocaleExtensionsKt.sharedLanguageCodeWith(locale, LocaleExtensionsKt.toLocale((String) ((Map.Entry) obj).getKey()))) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            return (LocalizedConfiguration) entry.getValue();
        }
        return null;
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u0000 L2\u00020\u0001:\u0005IJKLMB]\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010B\u0001\b\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017Bk\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0018J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b5J\u0010\u00106\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b7J\t\u00108\u001a\u00020\u000bHÆ\u0003J\t\u00109\u001a\u00020\u000bHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003Js\u0010=\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010>\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0012HÖ\u0001J\t\u0010A\u001a\u00020\u0004HÖ\u0001J!\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HHÇ\u0001R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u001c\u0010\f\u001a\u00020\u000b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010%R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010%R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001a\u001a\u0004\b+\u0010,R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u001a\u001a\u0004\b.\u0010/R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001a\u001a\u0004\b1\u0010/¨\u0006N"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "", "packageIds", "", "", "defaultPackage", "images", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;", "colors", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "blurredBackgroundImage", "", "displayRestorePurchases", "termsOfServiceURL", "Ljava/net/URL;", "privacyURL", "(Ljava/util/List;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;ZZLjava/net/URL;Ljava/net/URL;)V", "seen1", "", "imagesWebp", "legacyImages", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;ZZLjava/net/URL;Ljava/net/URL;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;ZZLjava/net/URL;Ljava/net/URL;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;)V", "getBlurredBackgroundImage$annotations", "()V", "getBlurredBackgroundImage", "()Z", "getColors", "()Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "getDefaultPackage$annotations", "getDefaultPackage", "()Ljava/lang/String;", "getDisplayRestorePurchases$annotations", "getDisplayRestorePurchases", "getImages", "()Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;", "getImagesWebp$purchases_defaultsRelease$annotations", "getImagesWebp$purchases_defaultsRelease", "getLegacyImages$purchases_defaultsRelease$annotations", "getLegacyImages$purchases_defaultsRelease", "getPackageIds$annotations", "getPackageIds", "()Ljava/util/List;", "getPrivacyURL$annotations", "getPrivacyURL", "()Ljava/net/URL;", "getTermsOfServiceURL$annotations", "getTermsOfServiceURL", "component1", "component2", "component3", "component3$purchases_defaultsRelease", "component4", "component4$purchases_defaultsRelease", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "ColorInformation", "Colors", "Companion", "Images", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: PaywallData.kt */
    public static final class Configuration {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final boolean blurredBackgroundImage;
        private final ColorInformation colors;
        private final String defaultPackage;
        private final boolean displayRestorePurchases;
        private final Images imagesWebp;
        private final Images legacyImages;
        private final List<String> packageIds;
        private final URL privacyURL;
        private final URL termsOfServiceURL;

        public static /* synthetic */ Configuration copy$default(Configuration configuration, List list, String str, Images images, Images images2, boolean z, boolean z2, URL url, URL url2, ColorInformation colorInformation, int i, Object obj) {
            Configuration configuration2 = configuration;
            int i2 = i;
            return configuration.copy((i2 & 1) != 0 ? configuration2.packageIds : list, (i2 & 2) != 0 ? configuration2.defaultPackage : str, (i2 & 4) != 0 ? configuration2.imagesWebp : images, (i2 & 8) != 0 ? configuration2.legacyImages : images2, (i2 & 16) != 0 ? configuration2.blurredBackgroundImage : z, (i2 & 32) != 0 ? configuration2.displayRestorePurchases : z2, (i2 & 64) != 0 ? configuration2.termsOfServiceURL : url, (i2 & 128) != 0 ? configuration2.privacyURL : url2, (i2 & 256) != 0 ? configuration2.colors : colorInformation);
        }

        @SerialName("blurred_background_image")
        public static /* synthetic */ void getBlurredBackgroundImage$annotations() {
        }

        @SerialName("default_package")
        public static /* synthetic */ void getDefaultPackage$annotations() {
        }

        @SerialName("display_restore_purchases")
        public static /* synthetic */ void getDisplayRestorePurchases$annotations() {
        }

        @SerialName("images_webp")
        public static /* synthetic */ void getImagesWebp$purchases_defaultsRelease$annotations() {
        }

        @SerialName("images")
        public static /* synthetic */ void getLegacyImages$purchases_defaultsRelease$annotations() {
        }

        @SerialName("packages")
        public static /* synthetic */ void getPackageIds$annotations() {
        }

        @Serializable(with = OptionalURLSerializer.class)
        @SerialName("privacy_url")
        public static /* synthetic */ void getPrivacyURL$annotations() {
        }

        @Serializable(with = OptionalURLSerializer.class)
        @SerialName("tos_url")
        public static /* synthetic */ void getTermsOfServiceURL$annotations() {
        }

        public final List<String> component1() {
            return this.packageIds;
        }

        public final String component2() {
            return this.defaultPackage;
        }

        public final Images component3$purchases_defaultsRelease() {
            return this.imagesWebp;
        }

        public final Images component4$purchases_defaultsRelease() {
            return this.legacyImages;
        }

        public final boolean component5() {
            return this.blurredBackgroundImage;
        }

        public final boolean component6() {
            return this.displayRestorePurchases;
        }

        public final URL component7() {
            return this.termsOfServiceURL;
        }

        public final URL component8() {
            return this.privacyURL;
        }

        public final ColorInformation component9() {
            return this.colors;
        }

        public final Configuration copy(List<String> list, String str, Images images, Images images2, boolean z, boolean z2, URL url, URL url2, ColorInformation colorInformation) {
            Intrinsics.checkNotNullParameter(list, "packageIds");
            ColorInformation colorInformation2 = colorInformation;
            Intrinsics.checkNotNullParameter(colorInformation2, "colors");
            return new Configuration(list, str, images, images2, z, z2, url, url2, colorInformation2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) obj;
            return Intrinsics.areEqual((Object) this.packageIds, (Object) configuration.packageIds) && Intrinsics.areEqual((Object) this.defaultPackage, (Object) configuration.defaultPackage) && Intrinsics.areEqual((Object) this.imagesWebp, (Object) configuration.imagesWebp) && Intrinsics.areEqual((Object) this.legacyImages, (Object) configuration.legacyImages) && this.blurredBackgroundImage == configuration.blurredBackgroundImage && this.displayRestorePurchases == configuration.displayRestorePurchases && Intrinsics.areEqual((Object) this.termsOfServiceURL, (Object) configuration.termsOfServiceURL) && Intrinsics.areEqual((Object) this.privacyURL, (Object) configuration.privacyURL) && Intrinsics.areEqual((Object) this.colors, (Object) configuration.colors);
        }

        public final boolean getBlurredBackgroundImage() {
            return this.blurredBackgroundImage;
        }

        public final ColorInformation getColors() {
            return this.colors;
        }

        public final String getDefaultPackage() {
            return this.defaultPackage;
        }

        public final boolean getDisplayRestorePurchases() {
            return this.displayRestorePurchases;
        }

        public final Images getImagesWebp$purchases_defaultsRelease() {
            return this.imagesWebp;
        }

        public final Images getLegacyImages$purchases_defaultsRelease() {
            return this.legacyImages;
        }

        public final List<String> getPackageIds() {
            return this.packageIds;
        }

        public final URL getPrivacyURL() {
            return this.privacyURL;
        }

        public final URL getTermsOfServiceURL() {
            return this.termsOfServiceURL;
        }

        public int hashCode() {
            int hashCode = this.packageIds.hashCode() * 31;
            String str = this.defaultPackage;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Images images = this.imagesWebp;
            int hashCode3 = (hashCode2 + (images == null ? 0 : images.hashCode())) * 31;
            Images images2 = this.legacyImages;
            int hashCode4 = (hashCode3 + (images2 == null ? 0 : images2.hashCode())) * 31;
            boolean z = this.blurredBackgroundImage;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i2 = (hashCode4 + (z ? 1 : 0)) * 31;
            boolean z3 = this.displayRestorePurchases;
            if (!z3) {
                z2 = z3;
            }
            int i3 = (i2 + (z2 ? 1 : 0)) * 31;
            URL url = this.termsOfServiceURL;
            int hashCode5 = (i3 + (url == null ? 0 : url.hashCode())) * 31;
            URL url2 = this.privacyURL;
            if (url2 != null) {
                i = url2.hashCode();
            }
            return ((hashCode5 + i) * 31) + this.colors.hashCode();
        }

        public String toString() {
            return "Configuration(packageIds=" + this.packageIds + ", defaultPackage=" + this.defaultPackage + ", imagesWebp=" + this.imagesWebp + ", legacyImages=" + this.legacyImages + ", blurredBackgroundImage=" + this.blurredBackgroundImage + ", displayRestorePurchases=" + this.displayRestorePurchases + ", termsOfServiceURL=" + this.termsOfServiceURL + ", privacyURL=" + this.privacyURL + ", colors=" + this.colors + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: PaywallData.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Configuration> serializer() {
                return PaywallData$Configuration$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Configuration(int i, @SerialName("packages") List list, @SerialName("default_package") String str, @SerialName("images_webp") Images images, @SerialName("images") Images images2, @SerialName("blurred_background_image") boolean z, @SerialName("display_restore_purchases") boolean z2, @Serializable(with = OptionalURLSerializer.class) @SerialName("tos_url") URL url, @Serializable(with = OptionalURLSerializer.class) @SerialName("privacy_url") URL url2, ColorInformation colorInformation, SerializationConstructorMarker serializationConstructorMarker) {
            if (257 != (i & 257)) {
                PluginExceptionsKt.throwMissingFieldException(i, 257, PaywallData$Configuration$$serializer.INSTANCE.getDescriptor());
            }
            this.packageIds = list;
            if ((i & 2) == 0) {
                this.defaultPackage = null;
            } else {
                this.defaultPackage = str;
            }
            if ((i & 4) == 0) {
                this.imagesWebp = null;
            } else {
                this.imagesWebp = images;
            }
            if ((i & 8) == 0) {
                this.legacyImages = null;
            } else {
                this.legacyImages = images2;
            }
            if ((i & 16) == 0) {
                this.blurredBackgroundImage = false;
            } else {
                this.blurredBackgroundImage = z;
            }
            if ((i & 32) == 0) {
                this.displayRestorePurchases = true;
            } else {
                this.displayRestorePurchases = z2;
            }
            if ((i & 64) == 0) {
                this.termsOfServiceURL = null;
            } else {
                this.termsOfServiceURL = url;
            }
            if ((i & 128) == 0) {
                this.privacyURL = null;
            } else {
                this.privacyURL = url2;
            }
            this.colors = colorInformation;
        }

        public Configuration(List<String> list, String str, Images images, Images images2, boolean z, boolean z2, URL url, URL url2, ColorInformation colorInformation) {
            Intrinsics.checkNotNullParameter(list, "packageIds");
            Intrinsics.checkNotNullParameter(colorInformation, "colors");
            this.packageIds = list;
            this.defaultPackage = str;
            this.imagesWebp = images;
            this.legacyImages = images2;
            this.blurredBackgroundImage = z;
            this.displayRestorePurchases = z2;
            this.termsOfServiceURL = url;
            this.privacyURL = url2;
            this.colors = colorInformation;
        }

        @JvmStatic
        public static final void write$Self(Configuration configuration, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(configuration, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            compositeEncoder.encodeSerializableElement(serialDescriptor, 0, new ArrayListSerializer(StringSerializer.INSTANCE), configuration.packageIds);
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || configuration.defaultPackage != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, configuration.defaultPackage);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || configuration.imagesWebp != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, PaywallData$Configuration$Images$$serializer.INSTANCE, configuration.imagesWebp);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || configuration.legacyImages != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, PaywallData$Configuration$Images$$serializer.INSTANCE, configuration.legacyImages);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || configuration.blurredBackgroundImage) {
                compositeEncoder.encodeBooleanElement(serialDescriptor, 4, configuration.blurredBackgroundImage);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || !configuration.displayRestorePurchases) {
                compositeEncoder.encodeBooleanElement(serialDescriptor, 5, configuration.displayRestorePurchases);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || configuration.termsOfServiceURL != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, OptionalURLSerializer.INSTANCE, configuration.termsOfServiceURL);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || configuration.privacyURL != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, OptionalURLSerializer.INSTANCE, configuration.privacyURL);
            }
            compositeEncoder.encodeSerializableElement(serialDescriptor, 8, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, configuration.colors);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Configuration(java.util.List r14, java.lang.String r15, com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images r16, com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images r17, boolean r18, boolean r19, java.net.URL r20, java.net.URL r21, com.revenuecat.purchases.paywalls.PaywallData.Configuration.ColorInformation r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
            /*
                r13 = this;
                r0 = r23
                r1 = r0 & 2
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r5 = r2
                goto L_0x000a
            L_0x0009:
                r5 = r15
            L_0x000a:
                r1 = r0 & 4
                if (r1 == 0) goto L_0x0010
                r6 = r2
                goto L_0x0012
            L_0x0010:
                r6 = r16
            L_0x0012:
                r1 = r0 & 8
                if (r1 == 0) goto L_0x0018
                r7 = r2
                goto L_0x001a
            L_0x0018:
                r7 = r17
            L_0x001a:
                r1 = r0 & 16
                if (r1 == 0) goto L_0x0021
                r1 = 0
                r8 = r1
                goto L_0x0023
            L_0x0021:
                r8 = r18
            L_0x0023:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x002a
                r1 = 1
                r9 = r1
                goto L_0x002c
            L_0x002a:
                r9 = r19
            L_0x002c:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0032
                r10 = r2
                goto L_0x0034
            L_0x0032:
                r10 = r20
            L_0x0034:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x003a
                r11 = r2
                goto L_0x003c
            L_0x003a:
                r11 = r21
            L_0x003c:
                r3 = r13
                r4 = r14
                r12 = r22
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.PaywallData.Configuration.<init>(java.util.List, java.lang.String, com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images, com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images, boolean, boolean, java.net.URL, java.net.URL, com.revenuecat.purchases.paywalls.PaywallData$Configuration$ColorInformation, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Configuration(java.util.List r13, java.lang.String r14, com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images r15, com.revenuecat.purchases.paywalls.PaywallData.Configuration.ColorInformation r16, boolean r17, boolean r18, java.net.URL r19, java.net.URL r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
            /*
                r12 = this;
                r0 = r21
                r1 = r0 & 2
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r5 = r2
                goto L_0x000a
            L_0x0009:
                r5 = r14
            L_0x000a:
                r1 = r0 & 16
                if (r1 == 0) goto L_0x0011
                r1 = 0
                r8 = r1
                goto L_0x0013
            L_0x0011:
                r8 = r17
            L_0x0013:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x001a
                r1 = 1
                r9 = r1
                goto L_0x001c
            L_0x001a:
                r9 = r18
            L_0x001c:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0022
                r10 = r2
                goto L_0x0024
            L_0x0022:
                r10 = r19
            L_0x0024:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x002a
                r11 = r2
                goto L_0x002c
            L_0x002a:
                r11 = r20
            L_0x002c:
                r3 = r12
                r4 = r13
                r6 = r15
                r7 = r16
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.PaywallData.Configuration.<init>(java.util.List, java.lang.String, com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images, com.revenuecat.purchases.paywalls.PaywallData$Configuration$ColorInformation, boolean, boolean, java.net.URL, java.net.URL, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Configuration(java.util.List<java.lang.String> r14, java.lang.String r15, com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images r16, com.revenuecat.purchases.paywalls.PaywallData.Configuration.ColorInformation r17, boolean r18, boolean r19, java.net.URL r20, java.net.URL r21) {
            /*
                r13 = this;
                java.lang.String r0 = "packageIds"
                r2 = r14
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
                java.lang.String r0 = "images"
                r4 = r16
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "colors"
                r10 = r17
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                r5 = 0
                r11 = 8
                r12 = 0
                r1 = r13
                r3 = r15
                r6 = r18
                r7 = r19
                r8 = r20
                r9 = r21
                r1.<init>((java.util.List) r2, (java.lang.String) r3, (com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images) r4, (com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images) r5, (boolean) r6, (boolean) r7, (java.net.URL) r8, (java.net.URL) r9, (com.revenuecat.purchases.paywalls.PaywallData.Configuration.ColorInformation) r10, (int) r11, (kotlin.jvm.internal.DefaultConstructorMarker) r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.PaywallData.Configuration.<init>(java.util.List, java.lang.String, com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images, com.revenuecat.purchases.paywalls.PaywallData$Configuration$ColorInformation, boolean, boolean, java.net.URL, java.net.URL):void");
        }

        public final Images getImages() {
            String str;
            String str2;
            String icon;
            Images images = this.imagesWebp;
            String str3 = null;
            if (images == null || (str = images.getHeader()) == null) {
                Images images2 = this.legacyImages;
                str = images2 != null ? images2.getHeader() : null;
            }
            Images images3 = this.imagesWebp;
            if (images3 == null || (str2 = images3.getBackground()) == null) {
                Images images4 = this.legacyImages;
                str2 = images4 != null ? images4.getBackground() : null;
            }
            Images images5 = this.imagesWebp;
            if (images5 == null || (icon = images5.getIcon()) == null) {
                Images images6 = this.legacyImages;
                if (images6 != null) {
                    str3 = images6.getIcon();
                }
            } else {
                str3 = icon;
            }
            return new Images(str, str2, str3);
        }

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 )2\u00020\u0001:\u0002()B=\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J!\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'HÇ\u0001R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013¨\u0006*"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;", "", "seen1", "", "header", "", "background", "icon", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "all", "", "getAll$purchases_defaultsRelease", "()Ljava/util/List;", "getBackground$annotations", "()V", "getBackground", "()Ljava/lang/String;", "getHeader$annotations", "getHeader", "getIcon$annotations", "getIcon", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @Serializable
        /* compiled from: PaywallData.kt */
        public static final class Images {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String background;
            private final String header;
            private final String icon;

            public Images() {
                this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Images copy$default(Images images, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = images.header;
                }
                if ((i & 2) != 0) {
                    str2 = images.background;
                }
                if ((i & 4) != 0) {
                    str3 = images.icon;
                }
                return images.copy(str, str2, str3);
            }

            @Serializable(with = EmptyStringToNullSerializer.class)
            public static /* synthetic */ void getBackground$annotations() {
            }

            @Serializable(with = EmptyStringToNullSerializer.class)
            public static /* synthetic */ void getHeader$annotations() {
            }

            @Serializable(with = EmptyStringToNullSerializer.class)
            public static /* synthetic */ void getIcon$annotations() {
            }

            public final String component1() {
                return this.header;
            }

            public final String component2() {
                return this.background;
            }

            public final String component3() {
                return this.icon;
            }

            public final Images copy(String str, String str2, String str3) {
                return new Images(str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Images)) {
                    return false;
                }
                Images images = (Images) obj;
                return Intrinsics.areEqual((Object) this.header, (Object) images.header) && Intrinsics.areEqual((Object) this.background, (Object) images.background) && Intrinsics.areEqual((Object) this.icon, (Object) images.icon);
            }

            public final String getBackground() {
                return this.background;
            }

            public final String getHeader() {
                return this.header;
            }

            public final String getIcon() {
                return this.icon;
            }

            public int hashCode() {
                String str = this.header;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.background;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.icon;
                if (str3 != null) {
                    i = str3.hashCode();
                }
                return hashCode2 + i;
            }

            public String toString() {
                return "Images(header=" + this.header + ", background=" + this.background + ", icon=" + this.icon + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: PaywallData.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Images> serializer() {
                    return PaywallData$Configuration$Images$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ Images(int i, @Serializable(with = EmptyStringToNullSerializer.class) String str, @Serializable(with = EmptyStringToNullSerializer.class) String str2, @Serializable(with = EmptyStringToNullSerializer.class) String str3, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.header = null;
                } else {
                    this.header = str;
                }
                if ((i & 2) == 0) {
                    this.background = null;
                } else {
                    this.background = str2;
                }
                if ((i & 4) == 0) {
                    this.icon = null;
                } else {
                    this.icon = str3;
                }
            }

            public Images(String str, String str2, String str3) {
                this.header = str;
                this.background = str2;
                this.icon = str3;
            }

            @JvmStatic
            public static final void write$Self(Images images, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                Intrinsics.checkNotNullParameter(images, "self");
                Intrinsics.checkNotNullParameter(compositeEncoder, "output");
                Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
                if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || images.header != null) {
                    compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, EmptyStringToNullSerializer.INSTANCE, images.header);
                }
                if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || images.background != null) {
                    compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, EmptyStringToNullSerializer.INSTANCE, images.background);
                }
                if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || images.icon != null) {
                    compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, EmptyStringToNullSerializer.INSTANCE, images.icon);
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Images(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            public final List<String> getAll$purchases_defaultsRelease() {
                return CollectionsKt.listOfNotNull((T[]) new String[]{this.header, this.background, this.icon});
            }
        }

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J!\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dHÇ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006 "}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "", "seen1", "", "light", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "dark", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;)V", "getDark", "()Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "getLight", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @Serializable
        /* compiled from: PaywallData.kt */
        public static final class ColorInformation {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final Colors dark;
            private final Colors light;

            public static /* synthetic */ ColorInformation copy$default(ColorInformation colorInformation, Colors colors, Colors colors2, int i, Object obj) {
                if ((i & 1) != 0) {
                    colors = colorInformation.light;
                }
                if ((i & 2) != 0) {
                    colors2 = colorInformation.dark;
                }
                return colorInformation.copy(colors, colors2);
            }

            public final Colors component1() {
                return this.light;
            }

            public final Colors component2() {
                return this.dark;
            }

            public final ColorInformation copy(Colors colors, Colors colors2) {
                Intrinsics.checkNotNullParameter(colors, "light");
                return new ColorInformation(colors, colors2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ColorInformation)) {
                    return false;
                }
                ColorInformation colorInformation = (ColorInformation) obj;
                return Intrinsics.areEqual((Object) this.light, (Object) colorInformation.light) && Intrinsics.areEqual((Object) this.dark, (Object) colorInformation.dark);
            }

            public final Colors getDark() {
                return this.dark;
            }

            public final Colors getLight() {
                return this.light;
            }

            public int hashCode() {
                int hashCode = this.light.hashCode() * 31;
                Colors colors = this.dark;
                return hashCode + (colors == null ? 0 : colors.hashCode());
            }

            public String toString() {
                return "ColorInformation(light=" + this.light + ", dark=" + this.dark + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: PaywallData.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<ColorInformation> serializer() {
                    return PaywallData$Configuration$ColorInformation$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ ColorInformation(int i, Colors colors, Colors colors2, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE.getDescriptor());
                }
                this.light = colors;
                if ((i & 2) == 0) {
                    this.dark = null;
                } else {
                    this.dark = colors2;
                }
            }

            public ColorInformation(Colors colors, Colors colors2) {
                Intrinsics.checkNotNullParameter(colors, "light");
                this.light = colors;
                this.dark = colors2;
            }

            @JvmStatic
            public static final void write$Self(ColorInformation colorInformation, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                Intrinsics.checkNotNullParameter(colorInformation, "self");
                Intrinsics.checkNotNullParameter(compositeEncoder, "output");
                Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
                compositeEncoder.encodeSerializableElement(serialDescriptor, 0, PaywallData$Configuration$Colors$$serializer.INSTANCE, colorInformation.light);
                if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || colorInformation.dark != null) {
                    compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, PaywallData$Configuration$Colors$$serializer.INSTANCE, colorInformation.dark);
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ ColorInformation(Colors colors, Colors colors2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(colors, (i & 2) != 0 ? null : colors2);
            }
        }

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 B2\u00020\u0001:\u0002ABB\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011Bm\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0012J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jy\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001J!\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@HÇ\u0001R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0014\u001a\u0004\b(\u0010\u0016¨\u0006C"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "", "seen1", "", "background", "Lcom/revenuecat/purchases/paywalls/PaywallColor;", "text1", "text2", "text3", "callToActionBackground", "callToActionForeground", "callToActionSecondaryBackground", "accent1", "accent2", "accent3", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;)V", "getAccent1$annotations", "()V", "getAccent1", "()Lcom/revenuecat/purchases/paywalls/PaywallColor;", "getAccent2$annotations", "getAccent2", "getAccent3$annotations", "getAccent3", "getBackground$annotations", "getBackground", "getCallToActionBackground$annotations", "getCallToActionBackground", "getCallToActionForeground$annotations", "getCallToActionForeground", "getCallToActionSecondaryBackground$annotations", "getCallToActionSecondaryBackground", "getText1$annotations", "getText1", "getText2$annotations", "getText2", "getText3$annotations", "getText3", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @Serializable
        /* compiled from: PaywallData.kt */
        public static final class Colors {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final PaywallColor accent1;
            private final PaywallColor accent2;
            private final PaywallColor accent3;
            private final PaywallColor background;
            private final PaywallColor callToActionBackground;
            private final PaywallColor callToActionForeground;
            private final PaywallColor callToActionSecondaryBackground;
            private final PaywallColor text1;
            private final PaywallColor text2;
            private final PaywallColor text3;

            public static /* synthetic */ Colors copy$default(Colors colors, PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, PaywallColor paywallColor6, PaywallColor paywallColor7, PaywallColor paywallColor8, PaywallColor paywallColor9, PaywallColor paywallColor10, int i, Object obj) {
                Colors colors2 = colors;
                int i2 = i;
                return colors.copy((i2 & 1) != 0 ? colors2.background : paywallColor, (i2 & 2) != 0 ? colors2.text1 : paywallColor2, (i2 & 4) != 0 ? colors2.text2 : paywallColor3, (i2 & 8) != 0 ? colors2.text3 : paywallColor4, (i2 & 16) != 0 ? colors2.callToActionBackground : paywallColor5, (i2 & 32) != 0 ? colors2.callToActionForeground : paywallColor6, (i2 & 64) != 0 ? colors2.callToActionSecondaryBackground : paywallColor7, (i2 & 128) != 0 ? colors2.accent1 : paywallColor8, (i2 & 256) != 0 ? colors2.accent2 : paywallColor9, (i2 & 512) != 0 ? colors2.accent3 : paywallColor10);
            }

            @Serializable(with = PaywallColor.Serializer.class)
            @SerialName("accent_1")
            public static /* synthetic */ void getAccent1$annotations() {
            }

            @Serializable(with = PaywallColor.Serializer.class)
            @SerialName("accent_2")
            public static /* synthetic */ void getAccent2$annotations() {
            }

            @Serializable(with = PaywallColor.Serializer.class)
            @SerialName("accent_3")
            public static /* synthetic */ void getAccent3$annotations() {
            }

            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getBackground$annotations() {
            }

            @Serializable(with = PaywallColor.Serializer.class)
            @SerialName("call_to_action_background")
            public static /* synthetic */ void getCallToActionBackground$annotations() {
            }

            @Serializable(with = PaywallColor.Serializer.class)
            @SerialName("call_to_action_foreground")
            public static /* synthetic */ void getCallToActionForeground$annotations() {
            }

            @Serializable(with = PaywallColor.Serializer.class)
            @SerialName("call_to_action_secondary_background")
            public static /* synthetic */ void getCallToActionSecondaryBackground$annotations() {
            }

            @Serializable(with = PaywallColor.Serializer.class)
            @SerialName("text_1")
            public static /* synthetic */ void getText1$annotations() {
            }

            @Serializable(with = PaywallColor.Serializer.class)
            @SerialName("text_2")
            public static /* synthetic */ void getText2$annotations() {
            }

            @Serializable(with = PaywallColor.Serializer.class)
            @SerialName("text_3")
            public static /* synthetic */ void getText3$annotations() {
            }

            public final PaywallColor component1() {
                return this.background;
            }

            public final PaywallColor component10() {
                return this.accent3;
            }

            public final PaywallColor component2() {
                return this.text1;
            }

            public final PaywallColor component3() {
                return this.text2;
            }

            public final PaywallColor component4() {
                return this.text3;
            }

            public final PaywallColor component5() {
                return this.callToActionBackground;
            }

            public final PaywallColor component6() {
                return this.callToActionForeground;
            }

            public final PaywallColor component7() {
                return this.callToActionSecondaryBackground;
            }

            public final PaywallColor component8() {
                return this.accent1;
            }

            public final PaywallColor component9() {
                return this.accent2;
            }

            public final Colors copy(PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, PaywallColor paywallColor6, PaywallColor paywallColor7, PaywallColor paywallColor8, PaywallColor paywallColor9, PaywallColor paywallColor10) {
                Intrinsics.checkNotNullParameter(paywallColor, AppStateModule.APP_STATE_BACKGROUND);
                Intrinsics.checkNotNullParameter(paywallColor2, "text1");
                PaywallColor paywallColor11 = paywallColor5;
                Intrinsics.checkNotNullParameter(paywallColor11, "callToActionBackground");
                PaywallColor paywallColor12 = paywallColor6;
                Intrinsics.checkNotNullParameter(paywallColor12, "callToActionForeground");
                return new Colors(paywallColor, paywallColor2, paywallColor3, paywallColor4, paywallColor11, paywallColor12, paywallColor7, paywallColor8, paywallColor9, paywallColor10);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Colors)) {
                    return false;
                }
                Colors colors = (Colors) obj;
                return Intrinsics.areEqual((Object) this.background, (Object) colors.background) && Intrinsics.areEqual((Object) this.text1, (Object) colors.text1) && Intrinsics.areEqual((Object) this.text2, (Object) colors.text2) && Intrinsics.areEqual((Object) this.text3, (Object) colors.text3) && Intrinsics.areEqual((Object) this.callToActionBackground, (Object) colors.callToActionBackground) && Intrinsics.areEqual((Object) this.callToActionForeground, (Object) colors.callToActionForeground) && Intrinsics.areEqual((Object) this.callToActionSecondaryBackground, (Object) colors.callToActionSecondaryBackground) && Intrinsics.areEqual((Object) this.accent1, (Object) colors.accent1) && Intrinsics.areEqual((Object) this.accent2, (Object) colors.accent2) && Intrinsics.areEqual((Object) this.accent3, (Object) colors.accent3);
            }

            public final PaywallColor getAccent1() {
                return this.accent1;
            }

            public final PaywallColor getAccent2() {
                return this.accent2;
            }

            public final PaywallColor getAccent3() {
                return this.accent3;
            }

            public final PaywallColor getBackground() {
                return this.background;
            }

            public final PaywallColor getCallToActionBackground() {
                return this.callToActionBackground;
            }

            public final PaywallColor getCallToActionForeground() {
                return this.callToActionForeground;
            }

            public final PaywallColor getCallToActionSecondaryBackground() {
                return this.callToActionSecondaryBackground;
            }

            public final PaywallColor getText1() {
                return this.text1;
            }

            public final PaywallColor getText2() {
                return this.text2;
            }

            public final PaywallColor getText3() {
                return this.text3;
            }

            public int hashCode() {
                int hashCode = ((this.background.hashCode() * 31) + this.text1.hashCode()) * 31;
                PaywallColor paywallColor = this.text2;
                int i = 0;
                int hashCode2 = (hashCode + (paywallColor == null ? 0 : paywallColor.hashCode())) * 31;
                PaywallColor paywallColor2 = this.text3;
                int hashCode3 = (((((hashCode2 + (paywallColor2 == null ? 0 : paywallColor2.hashCode())) * 31) + this.callToActionBackground.hashCode()) * 31) + this.callToActionForeground.hashCode()) * 31;
                PaywallColor paywallColor3 = this.callToActionSecondaryBackground;
                int hashCode4 = (hashCode3 + (paywallColor3 == null ? 0 : paywallColor3.hashCode())) * 31;
                PaywallColor paywallColor4 = this.accent1;
                int hashCode5 = (hashCode4 + (paywallColor4 == null ? 0 : paywallColor4.hashCode())) * 31;
                PaywallColor paywallColor5 = this.accent2;
                int hashCode6 = (hashCode5 + (paywallColor5 == null ? 0 : paywallColor5.hashCode())) * 31;
                PaywallColor paywallColor6 = this.accent3;
                if (paywallColor6 != null) {
                    i = paywallColor6.hashCode();
                }
                return hashCode6 + i;
            }

            public String toString() {
                return "Colors(background=" + this.background + ", text1=" + this.text1 + ", text2=" + this.text2 + ", text3=" + this.text3 + ", callToActionBackground=" + this.callToActionBackground + ", callToActionForeground=" + this.callToActionForeground + ", callToActionSecondaryBackground=" + this.callToActionSecondaryBackground + ", accent1=" + this.accent1 + ", accent2=" + this.accent2 + ", accent3=" + this.accent3 + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: PaywallData.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Colors> serializer() {
                    return PaywallData$Configuration$Colors$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ Colors(int i, @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor, @Serializable(with = PaywallColor.Serializer.class) @SerialName("text_1") PaywallColor paywallColor2, @Serializable(with = PaywallColor.Serializer.class) @SerialName("text_2") PaywallColor paywallColor3, @Serializable(with = PaywallColor.Serializer.class) @SerialName("text_3") PaywallColor paywallColor4, @Serializable(with = PaywallColor.Serializer.class) @SerialName("call_to_action_background") PaywallColor paywallColor5, @Serializable(with = PaywallColor.Serializer.class) @SerialName("call_to_action_foreground") PaywallColor paywallColor6, @Serializable(with = PaywallColor.Serializer.class) @SerialName("call_to_action_secondary_background") PaywallColor paywallColor7, @Serializable(with = PaywallColor.Serializer.class) @SerialName("accent_1") PaywallColor paywallColor8, @Serializable(with = PaywallColor.Serializer.class) @SerialName("accent_2") PaywallColor paywallColor9, @Serializable(with = PaywallColor.Serializer.class) @SerialName("accent_3") PaywallColor paywallColor10, SerializationConstructorMarker serializationConstructorMarker) {
                if (51 != (i & 51)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 51, PaywallData$Configuration$Colors$$serializer.INSTANCE.getDescriptor());
                }
                this.background = paywallColor;
                this.text1 = paywallColor2;
                if ((i & 4) == 0) {
                    this.text2 = null;
                } else {
                    this.text2 = paywallColor3;
                }
                if ((i & 8) == 0) {
                    this.text3 = null;
                } else {
                    this.text3 = paywallColor4;
                }
                this.callToActionBackground = paywallColor5;
                this.callToActionForeground = paywallColor6;
                if ((i & 64) == 0) {
                    this.callToActionSecondaryBackground = null;
                } else {
                    this.callToActionSecondaryBackground = paywallColor7;
                }
                if ((i & 128) == 0) {
                    this.accent1 = null;
                } else {
                    this.accent1 = paywallColor8;
                }
                if ((i & 256) == 0) {
                    this.accent2 = null;
                } else {
                    this.accent2 = paywallColor9;
                }
                if ((i & 512) == 0) {
                    this.accent3 = null;
                } else {
                    this.accent3 = paywallColor10;
                }
            }

            public Colors(PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, PaywallColor paywallColor6, PaywallColor paywallColor7, PaywallColor paywallColor8, PaywallColor paywallColor9, PaywallColor paywallColor10) {
                Intrinsics.checkNotNullParameter(paywallColor, AppStateModule.APP_STATE_BACKGROUND);
                Intrinsics.checkNotNullParameter(paywallColor2, "text1");
                Intrinsics.checkNotNullParameter(paywallColor5, "callToActionBackground");
                Intrinsics.checkNotNullParameter(paywallColor6, "callToActionForeground");
                this.background = paywallColor;
                this.text1 = paywallColor2;
                this.text2 = paywallColor3;
                this.text3 = paywallColor4;
                this.callToActionBackground = paywallColor5;
                this.callToActionForeground = paywallColor6;
                this.callToActionSecondaryBackground = paywallColor7;
                this.accent1 = paywallColor8;
                this.accent2 = paywallColor9;
                this.accent3 = paywallColor10;
            }

            @JvmStatic
            public static final void write$Self(Colors colors, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                Intrinsics.checkNotNullParameter(colors, "self");
                Intrinsics.checkNotNullParameter(compositeEncoder, "output");
                Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
                compositeEncoder.encodeSerializableElement(serialDescriptor, 0, PaywallColor.Serializer.INSTANCE, colors.background);
                compositeEncoder.encodeSerializableElement(serialDescriptor, 1, PaywallColor.Serializer.INSTANCE, colors.text1);
                if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || colors.text2 != null) {
                    compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, PaywallColor.Serializer.INSTANCE, colors.text2);
                }
                if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || colors.text3 != null) {
                    compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, PaywallColor.Serializer.INSTANCE, colors.text3);
                }
                compositeEncoder.encodeSerializableElement(serialDescriptor, 4, PaywallColor.Serializer.INSTANCE, colors.callToActionBackground);
                compositeEncoder.encodeSerializableElement(serialDescriptor, 5, PaywallColor.Serializer.INSTANCE, colors.callToActionForeground);
                if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || colors.callToActionSecondaryBackground != null) {
                    compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, PaywallColor.Serializer.INSTANCE, colors.callToActionSecondaryBackground);
                }
                if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || colors.accent1 != null) {
                    compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, PaywallColor.Serializer.INSTANCE, colors.accent1);
                }
                if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) || colors.accent2 != null) {
                    compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, PaywallColor.Serializer.INSTANCE, colors.accent2);
                }
                if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) || colors.accent3 != null) {
                    compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 9, PaywallColor.Serializer.INSTANCE, colors.accent3);
                }
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ Colors(com.revenuecat.purchases.paywalls.PaywallColor r15, com.revenuecat.purchases.paywalls.PaywallColor r16, com.revenuecat.purchases.paywalls.PaywallColor r17, com.revenuecat.purchases.paywalls.PaywallColor r18, com.revenuecat.purchases.paywalls.PaywallColor r19, com.revenuecat.purchases.paywalls.PaywallColor r20, com.revenuecat.purchases.paywalls.PaywallColor r21, com.revenuecat.purchases.paywalls.PaywallColor r22, com.revenuecat.purchases.paywalls.PaywallColor r23, com.revenuecat.purchases.paywalls.PaywallColor r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
                /*
                    r14 = this;
                    r0 = r25
                    r1 = r0 & 4
                    r2 = 0
                    if (r1 == 0) goto L_0x0009
                    r6 = r2
                    goto L_0x000b
                L_0x0009:
                    r6 = r17
                L_0x000b:
                    r1 = r0 & 8
                    if (r1 == 0) goto L_0x0011
                    r7 = r2
                    goto L_0x0013
                L_0x0011:
                    r7 = r18
                L_0x0013:
                    r1 = r0 & 64
                    if (r1 == 0) goto L_0x0019
                    r10 = r2
                    goto L_0x001b
                L_0x0019:
                    r10 = r21
                L_0x001b:
                    r1 = r0 & 128(0x80, float:1.794E-43)
                    if (r1 == 0) goto L_0x0021
                    r11 = r2
                    goto L_0x0023
                L_0x0021:
                    r11 = r22
                L_0x0023:
                    r1 = r0 & 256(0x100, float:3.59E-43)
                    if (r1 == 0) goto L_0x0029
                    r12 = r2
                    goto L_0x002b
                L_0x0029:
                    r12 = r23
                L_0x002b:
                    r0 = r0 & 512(0x200, float:7.175E-43)
                    if (r0 == 0) goto L_0x0031
                    r13 = r2
                    goto L_0x0033
                L_0x0031:
                    r13 = r24
                L_0x0033:
                    r3 = r14
                    r4 = r15
                    r5 = r16
                    r8 = r19
                    r9 = r20
                    r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.PaywallData.Configuration.Colors.<init>(com.revenuecat.purchases.paywalls.PaywallColor, com.revenuecat.purchases.paywalls.PaywallColor, com.revenuecat.purchases.paywalls.PaywallColor, com.revenuecat.purchases.paywalls.PaywallColor, com.revenuecat.purchases.paywalls.PaywallColor, com.revenuecat.purchases.paywalls.PaywallColor, com.revenuecat.purchases.paywalls.PaywallColor, com.revenuecat.purchases.paywalls.PaywallColor, com.revenuecat.purchases.paywalls.PaywallColor, com.revenuecat.purchases.paywalls.PaywallColor, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 B2\u00020\u0001:\u0003ABCB\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013By\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\u0010\u0014J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001J!\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@HÇ\u0001R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018¨\u0006D"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "", "seen1", "", "title", "", "subtitle", "callToAction", "callToActionWithIntroOffer", "callToActionWithMultipleIntroOffers", "offerDetails", "offerDetailsWithIntroOffer", "offerDetailsWithMultipleIntroOffers", "offerName", "features", "", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCallToAction$annotations", "()V", "getCallToAction", "()Ljava/lang/String;", "getCallToActionWithIntroOffer$annotations", "getCallToActionWithIntroOffer", "getCallToActionWithMultipleIntroOffers$annotations", "getCallToActionWithMultipleIntroOffers", "getFeatures", "()Ljava/util/List;", "getOfferDetails$annotations", "getOfferDetails", "getOfferDetailsWithIntroOffer$annotations", "getOfferDetailsWithIntroOffer", "getOfferDetailsWithMultipleIntroOffers$annotations", "getOfferDetailsWithMultipleIntroOffers", "getOfferName$annotations", "getOfferName", "getSubtitle$annotations", "getSubtitle", "getTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "Feature", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: PaywallData.kt */
    public static final class LocalizedConfiguration {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String callToAction;
        private final String callToActionWithIntroOffer;
        private final String callToActionWithMultipleIntroOffers;
        private final List<Feature> features;
        private final String offerDetails;
        private final String offerDetailsWithIntroOffer;
        private final String offerDetailsWithMultipleIntroOffers;
        private final String offerName;
        private final String subtitle;
        private final String title;

        public static /* synthetic */ LocalizedConfiguration copy$default(LocalizedConfiguration localizedConfiguration, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, int i, Object obj) {
            LocalizedConfiguration localizedConfiguration2 = localizedConfiguration;
            int i2 = i;
            return localizedConfiguration.copy((i2 & 1) != 0 ? localizedConfiguration2.title : str, (i2 & 2) != 0 ? localizedConfiguration2.subtitle : str2, (i2 & 4) != 0 ? localizedConfiguration2.callToAction : str3, (i2 & 8) != 0 ? localizedConfiguration2.callToActionWithIntroOffer : str4, (i2 & 16) != 0 ? localizedConfiguration2.callToActionWithMultipleIntroOffers : str5, (i2 & 32) != 0 ? localizedConfiguration2.offerDetails : str6, (i2 & 64) != 0 ? localizedConfiguration2.offerDetailsWithIntroOffer : str7, (i2 & 128) != 0 ? localizedConfiguration2.offerDetailsWithMultipleIntroOffers : str8, (i2 & 256) != 0 ? localizedConfiguration2.offerName : str9, (i2 & 512) != 0 ? localizedConfiguration2.features : list);
        }

        @SerialName("call_to_action")
        public static /* synthetic */ void getCallToAction$annotations() {
        }

        @Serializable(with = EmptyStringToNullSerializer.class)
        @SerialName("call_to_action_with_intro_offer")
        public static /* synthetic */ void getCallToActionWithIntroOffer$annotations() {
        }

        @Serializable(with = EmptyStringToNullSerializer.class)
        @SerialName("call_to_action_with_multiple_intro_offers")
        public static /* synthetic */ void getCallToActionWithMultipleIntroOffers$annotations() {
        }

        @Serializable(with = EmptyStringToNullSerializer.class)
        @SerialName("offer_details")
        public static /* synthetic */ void getOfferDetails$annotations() {
        }

        @Serializable(with = EmptyStringToNullSerializer.class)
        @SerialName("offer_details_with_intro_offer")
        public static /* synthetic */ void getOfferDetailsWithIntroOffer$annotations() {
        }

        @Serializable(with = EmptyStringToNullSerializer.class)
        @SerialName("offer_details_with_multiple_intro_offers")
        public static /* synthetic */ void getOfferDetailsWithMultipleIntroOffers$annotations() {
        }

        @Serializable(with = EmptyStringToNullSerializer.class)
        @SerialName("offer_name")
        public static /* synthetic */ void getOfferName$annotations() {
        }

        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getSubtitle$annotations() {
        }

        public final String component1() {
            return this.title;
        }

        public final List<Feature> component10() {
            return this.features;
        }

        public final String component2() {
            return this.subtitle;
        }

        public final String component3() {
            return this.callToAction;
        }

        public final String component4() {
            return this.callToActionWithIntroOffer;
        }

        public final String component5() {
            return this.callToActionWithMultipleIntroOffers;
        }

        public final String component6() {
            return this.offerDetails;
        }

        public final String component7() {
            return this.offerDetailsWithIntroOffer;
        }

        public final String component8() {
            return this.offerDetailsWithMultipleIntroOffers;
        }

        public final String component9() {
            return this.offerName;
        }

        public final LocalizedConfiguration copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<Feature> list) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str3, "callToAction");
            List<Feature> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "features");
            return new LocalizedConfiguration(str, str2, str3, str4, str5, str6, str7, str8, str9, list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalizedConfiguration)) {
                return false;
            }
            LocalizedConfiguration localizedConfiguration = (LocalizedConfiguration) obj;
            return Intrinsics.areEqual((Object) this.title, (Object) localizedConfiguration.title) && Intrinsics.areEqual((Object) this.subtitle, (Object) localizedConfiguration.subtitle) && Intrinsics.areEqual((Object) this.callToAction, (Object) localizedConfiguration.callToAction) && Intrinsics.areEqual((Object) this.callToActionWithIntroOffer, (Object) localizedConfiguration.callToActionWithIntroOffer) && Intrinsics.areEqual((Object) this.callToActionWithMultipleIntroOffers, (Object) localizedConfiguration.callToActionWithMultipleIntroOffers) && Intrinsics.areEqual((Object) this.offerDetails, (Object) localizedConfiguration.offerDetails) && Intrinsics.areEqual((Object) this.offerDetailsWithIntroOffer, (Object) localizedConfiguration.offerDetailsWithIntroOffer) && Intrinsics.areEqual((Object) this.offerDetailsWithMultipleIntroOffers, (Object) localizedConfiguration.offerDetailsWithMultipleIntroOffers) && Intrinsics.areEqual((Object) this.offerName, (Object) localizedConfiguration.offerName) && Intrinsics.areEqual((Object) this.features, (Object) localizedConfiguration.features);
        }

        public final String getCallToAction() {
            return this.callToAction;
        }

        public final String getCallToActionWithIntroOffer() {
            return this.callToActionWithIntroOffer;
        }

        public final String getCallToActionWithMultipleIntroOffers() {
            return this.callToActionWithMultipleIntroOffers;
        }

        public final List<Feature> getFeatures() {
            return this.features;
        }

        public final String getOfferDetails() {
            return this.offerDetails;
        }

        public final String getOfferDetailsWithIntroOffer() {
            return this.offerDetailsWithIntroOffer;
        }

        public final String getOfferDetailsWithMultipleIntroOffers() {
            return this.offerDetailsWithMultipleIntroOffers;
        }

        public final String getOfferName() {
            return this.offerName;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int hashCode = this.title.hashCode() * 31;
            String str = this.subtitle;
            int i = 0;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.callToAction.hashCode()) * 31;
            String str2 = this.callToActionWithIntroOffer;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.callToActionWithMultipleIntroOffers;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.offerDetails;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.offerDetailsWithIntroOffer;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.offerDetailsWithMultipleIntroOffers;
            int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.offerName;
            if (str7 != null) {
                i = str7.hashCode();
            }
            return ((hashCode7 + i) * 31) + this.features.hashCode();
        }

        public String toString() {
            return "LocalizedConfiguration(title=" + this.title + ", subtitle=" + this.subtitle + ", callToAction=" + this.callToAction + ", callToActionWithIntroOffer=" + this.callToActionWithIntroOffer + ", callToActionWithMultipleIntroOffers=" + this.callToActionWithMultipleIntroOffers + ", offerDetails=" + this.offerDetails + ", offerDetailsWithIntroOffer=" + this.offerDetailsWithIntroOffer + ", offerDetailsWithMultipleIntroOffers=" + this.offerDetailsWithMultipleIntroOffers + ", offerName=" + this.offerName + ", features=" + this.features + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: PaywallData.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<LocalizedConfiguration> serializer() {
                return PaywallData$LocalizedConfiguration$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ LocalizedConfiguration(int i, String str, @Serializable(with = EmptyStringToNullSerializer.class) String str2, @SerialName("call_to_action") String str3, @Serializable(with = EmptyStringToNullSerializer.class) @SerialName("call_to_action_with_intro_offer") String str4, @Serializable(with = EmptyStringToNullSerializer.class) @SerialName("call_to_action_with_multiple_intro_offers") String str5, @Serializable(with = EmptyStringToNullSerializer.class) @SerialName("offer_details") String str6, @Serializable(with = EmptyStringToNullSerializer.class) @SerialName("offer_details_with_intro_offer") String str7, @Serializable(with = EmptyStringToNullSerializer.class) @SerialName("offer_details_with_multiple_intro_offers") String str8, @Serializable(with = EmptyStringToNullSerializer.class) @SerialName("offer_name") String str9, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (5 != (i & 5)) {
                PluginExceptionsKt.throwMissingFieldException(i, 5, PaywallData$LocalizedConfiguration$$serializer.INSTANCE.getDescriptor());
            }
            this.title = str;
            if ((i & 2) == 0) {
                this.subtitle = null;
            } else {
                this.subtitle = str2;
            }
            this.callToAction = str3;
            if ((i & 8) == 0) {
                this.callToActionWithIntroOffer = null;
            } else {
                this.callToActionWithIntroOffer = str4;
            }
            if ((i & 16) == 0) {
                this.callToActionWithMultipleIntroOffers = null;
            } else {
                this.callToActionWithMultipleIntroOffers = str5;
            }
            if ((i & 32) == 0) {
                this.offerDetails = null;
            } else {
                this.offerDetails = str6;
            }
            if ((i & 64) == 0) {
                this.offerDetailsWithIntroOffer = null;
            } else {
                this.offerDetailsWithIntroOffer = str7;
            }
            if ((i & 128) == 0) {
                this.offerDetailsWithMultipleIntroOffers = null;
            } else {
                this.offerDetailsWithMultipleIntroOffers = str8;
            }
            if ((i & 256) == 0) {
                this.offerName = null;
            } else {
                this.offerName = str9;
            }
            if ((i & 512) == 0) {
                this.features = CollectionsKt.emptyList();
            } else {
                this.features = list;
            }
        }

        public LocalizedConfiguration(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<Feature> list) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str3, "callToAction");
            Intrinsics.checkNotNullParameter(list, "features");
            this.title = str;
            this.subtitle = str2;
            this.callToAction = str3;
            this.callToActionWithIntroOffer = str4;
            this.callToActionWithMultipleIntroOffers = str5;
            this.offerDetails = str6;
            this.offerDetailsWithIntroOffer = str7;
            this.offerDetailsWithMultipleIntroOffers = str8;
            this.offerName = str9;
            this.features = list;
        }

        @JvmStatic
        public static final void write$Self(LocalizedConfiguration localizedConfiguration, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(localizedConfiguration, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            compositeEncoder.encodeStringElement(serialDescriptor, 0, localizedConfiguration.title);
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || localizedConfiguration.subtitle != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.subtitle);
            }
            compositeEncoder.encodeStringElement(serialDescriptor, 2, localizedConfiguration.callToAction);
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || localizedConfiguration.callToActionWithIntroOffer != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.callToActionWithIntroOffer);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || localizedConfiguration.callToActionWithMultipleIntroOffers != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.callToActionWithMultipleIntroOffers);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || localizedConfiguration.offerDetails != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.offerDetails);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || localizedConfiguration.offerDetailsWithIntroOffer != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.offerDetailsWithIntroOffer);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || localizedConfiguration.offerDetailsWithMultipleIntroOffers != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.offerDetailsWithMultipleIntroOffers);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) || localizedConfiguration.offerName != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.offerName);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) || !Intrinsics.areEqual((Object) localizedConfiguration.features, (Object) CollectionsKt.emptyList())) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 9, new ArrayListSerializer(PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE), localizedConfiguration.features);
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ LocalizedConfiguration(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.util.List r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
            /*
                r14 = this;
                r0 = r25
                r1 = r0 & 2
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r5 = r2
                goto L_0x000b
            L_0x0009:
                r5 = r16
            L_0x000b:
                r1 = r0 & 8
                if (r1 == 0) goto L_0x0011
                r7 = r2
                goto L_0x0013
            L_0x0011:
                r7 = r18
            L_0x0013:
                r1 = r0 & 16
                if (r1 == 0) goto L_0x0019
                r8 = r2
                goto L_0x001b
            L_0x0019:
                r8 = r19
            L_0x001b:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x0021
                r9 = r2
                goto L_0x0023
            L_0x0021:
                r9 = r20
            L_0x0023:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0029
                r10 = r2
                goto L_0x002b
            L_0x0029:
                r10 = r21
            L_0x002b:
                r1 = r0 & 128(0x80, float:1.794E-43)
                if (r1 == 0) goto L_0x0031
                r11 = r2
                goto L_0x0033
            L_0x0031:
                r11 = r22
            L_0x0033:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L_0x0039
                r12 = r2
                goto L_0x003b
            L_0x0039:
                r12 = r23
            L_0x003b:
                r0 = r0 & 512(0x200, float:7.175E-43)
                if (r0 == 0) goto L_0x0045
                java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
                r13 = r0
                goto L_0x0047
            L_0x0045:
                r13 = r24
            L_0x0047:
                r3 = r14
                r4 = r15
                r6 = r17
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.PaywallData.LocalizedConfiguration.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B9\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÇ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006$"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature;", "", "seen1", "", "title", "", "content", "iconID", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getIconID$annotations", "()V", "getIconID", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @Serializable
        /* compiled from: PaywallData.kt */
        public static final class Feature {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String content;
            private final String iconID;
            private final String title;

            public static /* synthetic */ Feature copy$default(Feature feature, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = feature.title;
                }
                if ((i & 2) != 0) {
                    str2 = feature.content;
                }
                if ((i & 4) != 0) {
                    str3 = feature.iconID;
                }
                return feature.copy(str, str2, str3);
            }

            @SerialName("icon_id")
            public static /* synthetic */ void getIconID$annotations() {
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.content;
            }

            public final String component3() {
                return this.iconID;
            }

            public final Feature copy(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "title");
                return new Feature(str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Feature)) {
                    return false;
                }
                Feature feature = (Feature) obj;
                return Intrinsics.areEqual((Object) this.title, (Object) feature.title) && Intrinsics.areEqual((Object) this.content, (Object) feature.content) && Intrinsics.areEqual((Object) this.iconID, (Object) feature.iconID);
            }

            public final String getContent() {
                return this.content;
            }

            public final String getIconID() {
                return this.iconID;
            }

            public final String getTitle() {
                return this.title;
            }

            public int hashCode() {
                int hashCode = this.title.hashCode() * 31;
                String str = this.content;
                int i = 0;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.iconID;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode2 + i;
            }

            public String toString() {
                return "Feature(title=" + this.title + ", content=" + this.content + ", iconID=" + this.iconID + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: PaywallData.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Feature> serializer() {
                    return PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ Feature(int i, String str, String str2, @SerialName("icon_id") String str3, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE.getDescriptor());
                }
                this.title = str;
                if ((i & 2) == 0) {
                    this.content = null;
                } else {
                    this.content = str2;
                }
                if ((i & 4) == 0) {
                    this.iconID = null;
                } else {
                    this.iconID = str3;
                }
            }

            public Feature(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "title");
                this.title = str;
                this.content = str2;
                this.iconID = str3;
            }

            @JvmStatic
            public static final void write$Self(Feature feature, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                Intrinsics.checkNotNullParameter(feature, "self");
                Intrinsics.checkNotNullParameter(compositeEncoder, "output");
                Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
                compositeEncoder.encodeStringElement(serialDescriptor, 0, feature.title);
                if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || feature.content != null) {
                    compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, feature.content);
                }
                if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || feature.iconID != null) {
                    compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, feature.iconID);
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Feature(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }
        }
    }
}
