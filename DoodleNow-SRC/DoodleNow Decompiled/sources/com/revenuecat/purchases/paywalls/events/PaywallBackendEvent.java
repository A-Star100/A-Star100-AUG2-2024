package com.revenuecat.purchases.paywalls.events;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 E2\u00020\u0001:\u0002DEB\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014B]\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0015J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\rHÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003Jw\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0005HÆ\u0001J\u0013\u00109\u001a\u00020\u00102\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001J!\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CHÇ\u0001R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000f\u001a\u00020\u00108\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u001c\u0010\u0011\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\u0019R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019R\u001c\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010&R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&¨\u0006F"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallBackendEvent;", "", "seen1", "", "id", "", "version", "type", "appUserID", "sessionID", "offeringID", "paywallRevision", "timestamp", "", "displayMode", "darkMode", "", "localeIdentifier", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;)V", "getAppUserID$annotations", "()V", "getAppUserID", "()Ljava/lang/String;", "getDarkMode$annotations", "getDarkMode", "()Z", "getDisplayMode$annotations", "getDisplayMode", "getId", "getLocaleIdentifier$annotations", "getLocaleIdentifier", "getOfferingID$annotations", "getOfferingID", "getPaywallRevision$annotations", "getPaywallRevision", "()I", "getSessionID$annotations", "getSessionID", "getTimestamp", "()J", "getType", "getVersion", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: PaywallBackendEvent.kt */
public final class PaywallBackendEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PAYWALL_EVENT_SCHEMA_VERSION = 1;
    private final String appUserID;
    private final boolean darkMode;
    private final String displayMode;
    private final String id;
    private final String localeIdentifier;
    private final String offeringID;
    private final int paywallRevision;
    private final String sessionID;
    private final long timestamp;
    private final String type;
    private final int version;

    public static /* synthetic */ PaywallBackendEvent copy$default(PaywallBackendEvent paywallBackendEvent, String str, int i, String str2, String str3, String str4, String str5, int i2, long j, String str6, boolean z, String str7, int i3, Object obj) {
        PaywallBackendEvent paywallBackendEvent2 = paywallBackendEvent;
        int i4 = i3;
        return paywallBackendEvent.copy((i4 & 1) != 0 ? paywallBackendEvent2.id : str, (i4 & 2) != 0 ? paywallBackendEvent2.version : i, (i4 & 4) != 0 ? paywallBackendEvent2.type : str2, (i4 & 8) != 0 ? paywallBackendEvent2.appUserID : str3, (i4 & 16) != 0 ? paywallBackendEvent2.sessionID : str4, (i4 & 32) != 0 ? paywallBackendEvent2.offeringID : str5, (i4 & 64) != 0 ? paywallBackendEvent2.paywallRevision : i2, (i4 & 128) != 0 ? paywallBackendEvent2.timestamp : j, (i4 & 256) != 0 ? paywallBackendEvent2.displayMode : str6, (i4 & 512) != 0 ? paywallBackendEvent2.darkMode : z, (i4 & 1024) != 0 ? paywallBackendEvent2.localeIdentifier : str7);
    }

    @SerialName("app_user_id")
    public static /* synthetic */ void getAppUserID$annotations() {
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
    public static /* synthetic */ void getOfferingID$annotations() {
    }

    @SerialName("paywall_revision")
    public static /* synthetic */ void getPaywallRevision$annotations() {
    }

    @SerialName("session_id")
    public static /* synthetic */ void getSessionID$annotations() {
    }

    public final String component1() {
        return this.id;
    }

    public final boolean component10() {
        return this.darkMode;
    }

    public final String component11() {
        return this.localeIdentifier;
    }

    public final int component2() {
        return this.version;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.appUserID;
    }

    public final String component5() {
        return this.sessionID;
    }

    public final String component6() {
        return this.offeringID;
    }

    public final int component7() {
        return this.paywallRevision;
    }

    public final long component8() {
        return this.timestamp;
    }

    public final String component9() {
        return this.displayMode;
    }

    public final PaywallBackendEvent copy(String str, int i, String str2, String str3, String str4, String str5, int i2, long j, String str6, boolean z, String str7) {
        Intrinsics.checkNotNullParameter(str, "id");
        String str8 = str2;
        Intrinsics.checkNotNullParameter(str8, "type");
        String str9 = str3;
        Intrinsics.checkNotNullParameter(str9, "appUserID");
        String str10 = str4;
        Intrinsics.checkNotNullParameter(str10, "sessionID");
        String str11 = str5;
        Intrinsics.checkNotNullParameter(str11, "offeringID");
        String str12 = str6;
        Intrinsics.checkNotNullParameter(str12, "displayMode");
        String str13 = str7;
        Intrinsics.checkNotNullParameter(str13, "localeIdentifier");
        return new PaywallBackendEvent(str, i, str8, str9, str10, str11, i2, j, str12, z, str13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallBackendEvent)) {
            return false;
        }
        PaywallBackendEvent paywallBackendEvent = (PaywallBackendEvent) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) paywallBackendEvent.id) && this.version == paywallBackendEvent.version && Intrinsics.areEqual((Object) this.type, (Object) paywallBackendEvent.type) && Intrinsics.areEqual((Object) this.appUserID, (Object) paywallBackendEvent.appUserID) && Intrinsics.areEqual((Object) this.sessionID, (Object) paywallBackendEvent.sessionID) && Intrinsics.areEqual((Object) this.offeringID, (Object) paywallBackendEvent.offeringID) && this.paywallRevision == paywallBackendEvent.paywallRevision && this.timestamp == paywallBackendEvent.timestamp && Intrinsics.areEqual((Object) this.displayMode, (Object) paywallBackendEvent.displayMode) && this.darkMode == paywallBackendEvent.darkMode && Intrinsics.areEqual((Object) this.localeIdentifier, (Object) paywallBackendEvent.localeIdentifier);
    }

    public final String getAppUserID() {
        return this.appUserID;
    }

    public final boolean getDarkMode() {
        return this.darkMode;
    }

    public final String getDisplayMode() {
        return this.displayMode;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLocaleIdentifier() {
        return this.localeIdentifier;
    }

    public final String getOfferingID() {
        return this.offeringID;
    }

    public final int getPaywallRevision() {
        return this.paywallRevision;
    }

    public final String getSessionID() {
        return this.sessionID;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getType() {
        return this.type;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.id.hashCode() * 31) + this.version) * 31) + this.type.hashCode()) * 31) + this.appUserID.hashCode()) * 31) + this.sessionID.hashCode()) * 31) + this.offeringID.hashCode()) * 31) + this.paywallRevision) * 31) + UByte$$ExternalSyntheticBackport0.m(this.timestamp)) * 31) + this.displayMode.hashCode()) * 31;
        boolean z = this.darkMode;
        if (z) {
            z = true;
        }
        return ((hashCode + (z ? 1 : 0)) * 31) + this.localeIdentifier.hashCode();
    }

    public String toString() {
        return "PaywallBackendEvent(id=" + this.id + ", version=" + this.version + ", type=" + this.type + ", appUserID=" + this.appUserID + ", sessionID=" + this.sessionID + ", offeringID=" + this.offeringID + ", paywallRevision=" + this.paywallRevision + ", timestamp=" + this.timestamp + ", displayMode=" + this.displayMode + ", darkMode=" + this.darkMode + ", localeIdentifier=" + this.localeIdentifier + ')';
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PaywallBackendEvent(int i, String str, int i2, String str2, @SerialName("app_user_id") String str3, @SerialName("session_id") String str4, @SerialName("offering_id") String str5, @SerialName("paywall_revision") int i3, long j, @SerialName("display_mode") String str6, @SerialName("dark_mode") boolean z, @SerialName("locale") String str7, SerializationConstructorMarker serializationConstructorMarker) {
        if (2047 != (i & 2047)) {
            PluginExceptionsKt.throwMissingFieldException(i, 2047, PaywallBackendEvent$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.version = i2;
        this.type = str2;
        this.appUserID = str3;
        this.sessionID = str4;
        this.offeringID = str5;
        this.paywallRevision = i3;
        this.timestamp = j;
        this.displayMode = str6;
        this.darkMode = z;
        this.localeIdentifier = str7;
    }

    public PaywallBackendEvent(String str, int i, String str2, String str3, String str4, String str5, int i2, long j, String str6, boolean z, String str7) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(str3, "appUserID");
        Intrinsics.checkNotNullParameter(str4, "sessionID");
        Intrinsics.checkNotNullParameter(str5, "offeringID");
        Intrinsics.checkNotNullParameter(str6, "displayMode");
        Intrinsics.checkNotNullParameter(str7, "localeIdentifier");
        this.id = str;
        this.version = i;
        this.type = str2;
        this.appUserID = str3;
        this.sessionID = str4;
        this.offeringID = str5;
        this.paywallRevision = i2;
        this.timestamp = j;
        this.displayMode = str6;
        this.darkMode = z;
        this.localeIdentifier = str7;
    }

    @JvmStatic
    public static final void write$Self(PaywallBackendEvent paywallBackendEvent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(paywallBackendEvent, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        compositeEncoder.encodeStringElement(serialDescriptor, 0, paywallBackendEvent.id);
        compositeEncoder.encodeIntElement(serialDescriptor, 1, paywallBackendEvent.version);
        compositeEncoder.encodeStringElement(serialDescriptor, 2, paywallBackendEvent.type);
        compositeEncoder.encodeStringElement(serialDescriptor, 3, paywallBackendEvent.appUserID);
        compositeEncoder.encodeStringElement(serialDescriptor, 4, paywallBackendEvent.sessionID);
        compositeEncoder.encodeStringElement(serialDescriptor, 5, paywallBackendEvent.offeringID);
        compositeEncoder.encodeIntElement(serialDescriptor, 6, paywallBackendEvent.paywallRevision);
        compositeEncoder.encodeLongElement(serialDescriptor, 7, paywallBackendEvent.timestamp);
        compositeEncoder.encodeStringElement(serialDescriptor, 8, paywallBackendEvent.displayMode);
        compositeEncoder.encodeBooleanElement(serialDescriptor, 9, paywallBackendEvent.darkMode);
        compositeEncoder.encodeStringElement(serialDescriptor, 10, paywallBackendEvent.localeIdentifier);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallBackendEvent$Companion;", "", "()V", "PAYWALL_EVENT_SCHEMA_VERSION", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallBackendEvent;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PaywallBackendEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PaywallBackendEvent> serializer() {
            return PaywallBackendEvent$$serializer.INSTANCE;
        }
    }
}
