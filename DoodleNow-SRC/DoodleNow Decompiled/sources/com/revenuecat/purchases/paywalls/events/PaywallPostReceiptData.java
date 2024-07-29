package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.utils.JsonElementExtensionsKt;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 52\u00020\u0001:\u000245B]\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fJ\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003JE\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010+J\t\u0010,\u001a\u00020\u0005HÖ\u0001J!\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203HÇ\u0001R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0016R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0016¨\u00066"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "", "seen1", "", "sessionID", "", "revision", "displayMode", "darkMode", "", "localeIdentifier", "offeringId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getDarkMode$annotations", "()V", "getDarkMode", "()Z", "getDisplayMode$annotations", "getDisplayMode", "()Ljava/lang/String;", "getLocaleIdentifier$annotations", "getLocaleIdentifier", "getOfferingId$annotations", "getOfferingId", "getRevision$annotations", "getRevision", "()I", "getSessionID$annotations", "getSessionID", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toMap", "", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: PaywallPostReceiptData.kt */
public final class PaywallPostReceiptData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Json.Default json = Json.Default;
    private final boolean darkMode;
    private final String displayMode;
    private final String localeIdentifier;
    private final String offeringId;
    private final int revision;
    private final String sessionID;

    public static /* synthetic */ PaywallPostReceiptData copy$default(PaywallPostReceiptData paywallPostReceiptData, String str, int i, String str2, boolean z, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paywallPostReceiptData.sessionID;
        }
        if ((i2 & 2) != 0) {
            i = paywallPostReceiptData.revision;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = paywallPostReceiptData.displayMode;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            z = paywallPostReceiptData.darkMode;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            str3 = paywallPostReceiptData.localeIdentifier;
        }
        String str6 = str3;
        if ((i2 & 32) != 0) {
            str4 = paywallPostReceiptData.offeringId;
        }
        return paywallPostReceiptData.copy(str, i3, str5, z2, str6, str4);
    }

    @SerialName("dark_mode")
    public static /* synthetic */ void getDarkMode$annotations() {
    }

    @SerialName("display_mode")
    public static /* synthetic */ void getDisplayMode$annotations() {
    }

    @SerialName("locale")
    public static /* synthetic */ void getLocaleIdentifier$annotations() {
    }

    @SerialName("offering_id")
    public static /* synthetic */ void getOfferingId$annotations() {
    }

    @SerialName("revision")
    public static /* synthetic */ void getRevision$annotations() {
    }

    @SerialName("session_id")
    public static /* synthetic */ void getSessionID$annotations() {
    }

    public final String component1() {
        return this.sessionID;
    }

    public final int component2() {
        return this.revision;
    }

    public final String component3() {
        return this.displayMode;
    }

    public final boolean component4() {
        return this.darkMode;
    }

    public final String component5() {
        return this.localeIdentifier;
    }

    public final String component6() {
        return this.offeringId;
    }

    public final PaywallPostReceiptData copy(String str, int i, String str2, boolean z, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "sessionID");
        Intrinsics.checkNotNullParameter(str2, "displayMode");
        Intrinsics.checkNotNullParameter(str3, "localeIdentifier");
        Intrinsics.checkNotNullParameter(str4, "offeringId");
        return new PaywallPostReceiptData(str, i, str2, z, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallPostReceiptData)) {
            return false;
        }
        PaywallPostReceiptData paywallPostReceiptData = (PaywallPostReceiptData) obj;
        return Intrinsics.areEqual((Object) this.sessionID, (Object) paywallPostReceiptData.sessionID) && this.revision == paywallPostReceiptData.revision && Intrinsics.areEqual((Object) this.displayMode, (Object) paywallPostReceiptData.displayMode) && this.darkMode == paywallPostReceiptData.darkMode && Intrinsics.areEqual((Object) this.localeIdentifier, (Object) paywallPostReceiptData.localeIdentifier) && Intrinsics.areEqual((Object) this.offeringId, (Object) paywallPostReceiptData.offeringId);
    }

    public final boolean getDarkMode() {
        return this.darkMode;
    }

    public final String getDisplayMode() {
        return this.displayMode;
    }

    public final String getLocaleIdentifier() {
        return this.localeIdentifier;
    }

    public final String getOfferingId() {
        return this.offeringId;
    }

    public final int getRevision() {
        return this.revision;
    }

    public final String getSessionID() {
        return this.sessionID;
    }

    public int hashCode() {
        int hashCode = ((((this.sessionID.hashCode() * 31) + this.revision) * 31) + this.displayMode.hashCode()) * 31;
        boolean z = this.darkMode;
        if (z) {
            z = true;
        }
        return ((((hashCode + (z ? 1 : 0)) * 31) + this.localeIdentifier.hashCode()) * 31) + this.offeringId.hashCode();
    }

    public String toString() {
        return "PaywallPostReceiptData(sessionID=" + this.sessionID + ", revision=" + this.revision + ", displayMode=" + this.displayMode + ", darkMode=" + this.darkMode + ", localeIdentifier=" + this.localeIdentifier + ", offeringId=" + this.offeringId + ')';
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PaywallPostReceiptData(int i, @SerialName("session_id") String str, @SerialName("revision") int i2, @SerialName("display_mode") String str2, @SerialName("dark_mode") boolean z, @SerialName("locale") String str3, @SerialName("offering_id") String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, PaywallPostReceiptData$$serializer.INSTANCE.getDescriptor());
        }
        this.sessionID = str;
        this.revision = i2;
        this.displayMode = str2;
        this.darkMode = z;
        this.localeIdentifier = str3;
        this.offeringId = str4;
    }

    public PaywallPostReceiptData(String str, int i, String str2, boolean z, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "sessionID");
        Intrinsics.checkNotNullParameter(str2, "displayMode");
        Intrinsics.checkNotNullParameter(str3, "localeIdentifier");
        Intrinsics.checkNotNullParameter(str4, "offeringId");
        this.sessionID = str;
        this.revision = i;
        this.displayMode = str2;
        this.darkMode = z;
        this.localeIdentifier = str3;
        this.offeringId = str4;
    }

    @JvmStatic
    public static final void write$Self(PaywallPostReceiptData paywallPostReceiptData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(paywallPostReceiptData, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        compositeEncoder.encodeStringElement(serialDescriptor, 0, paywallPostReceiptData.sessionID);
        compositeEncoder.encodeIntElement(serialDescriptor, 1, paywallPostReceiptData.revision);
        compositeEncoder.encodeStringElement(serialDescriptor, 2, paywallPostReceiptData.displayMode);
        compositeEncoder.encodeBooleanElement(serialDescriptor, 3, paywallPostReceiptData.darkMode);
        compositeEncoder.encodeStringElement(serialDescriptor, 4, paywallPostReceiptData.localeIdentifier);
        compositeEncoder.encodeStringElement(serialDescriptor, 5, paywallPostReceiptData.offeringId);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData$Companion;", "", "()V", "json", "Lkotlinx/serialization/json/Json$Default;", "getJson", "()Lkotlinx/serialization/json/Json$Default;", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PaywallPostReceiptData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PaywallPostReceiptData> serializer() {
            return PaywallPostReceiptData$$serializer.INSTANCE;
        }

        public final Json.Default getJson() {
            return PaywallPostReceiptData.json;
        }
    }

    public final Map<String, Object> toMap() {
        Json json2 = json;
        KSerializer<Object> serializer = SerializersKt.serializer(json2.getSerializersModule(), Reflection.typeOf(PaywallPostReceiptData.class));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        Map<String, Object> asMap = JsonElementExtensionsKt.asMap(json2.encodeToJsonElement(serializer, this));
        if (asMap == null) {
            return null;
        }
        return MapExtensionsKt.filterNotNullValues(asMap);
    }
}
