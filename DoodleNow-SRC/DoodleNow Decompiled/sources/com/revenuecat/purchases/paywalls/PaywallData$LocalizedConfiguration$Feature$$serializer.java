package com.revenuecat.purchases.paywalls;

import com.facebook.common.util.UriUtil;
import com.revenuecat.purchases.paywalls.PaywallData;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.LocalizedConfiguration.Feature.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: PaywallData.kt */
public final class PaywallData$LocalizedConfiguration$Feature$$serializer implements GeneratedSerializer<PaywallData.LocalizedConfiguration.Feature> {
    public static final PaywallData$LocalizedConfiguration$Feature$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PaywallData$LocalizedConfiguration$Feature$$serializer paywallData$LocalizedConfiguration$Feature$$serializer = new PaywallData$LocalizedConfiguration$Feature$$serializer();
        INSTANCE = paywallData$LocalizedConfiguration$Feature$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.LocalizedConfiguration.Feature", paywallData$LocalizedConfiguration$Feature$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("title", false);
        pluginGeneratedSerialDescriptor.addElement(UriUtil.LOCAL_CONTENT_SCHEME, true);
        pluginGeneratedSerialDescriptor.addElement("icon_id", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$LocalizedConfiguration$Feature$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.revenuecat.purchases.paywalls.PaywallData.LocalizedConfiguration.Feature deserialize(kotlinx.serialization.encoding.Decoder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r16.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = 0
            if (r2 == 0) goto L_0x0031
            java.lang.String r2 = r0.decodeStringElement(r1, r5)
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r5, r6)
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r5, r6)
            r5 = 7
            r12 = r2
            r11 = r5
            goto L_0x006d
        L_0x0031:
            r9 = r4
            r2 = r5
            r7 = r6
            r8 = r7
        L_0x0035:
            if (r9 == 0) goto L_0x0069
            int r10 = r0.decodeElementIndex(r1)
            r11 = -1
            if (r10 == r11) goto L_0x0067
            if (r10 == 0) goto L_0x0060
            if (r10 == r4) goto L_0x0055
            if (r10 != r3) goto L_0x004f
            kotlinx.serialization.internal.StringSerializer r10 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r10 = (kotlinx.serialization.DeserializationStrategy) r10
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r3, r10, r8)
            r2 = r2 | 4
            goto L_0x0035
        L_0x004f:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r10)
            throw r0
        L_0x0055:
            kotlinx.serialization.internal.StringSerializer r10 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r10 = (kotlinx.serialization.DeserializationStrategy) r10
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r4, r10, r7)
            r2 = r2 | 2
            goto L_0x0035
        L_0x0060:
            java.lang.String r6 = r0.decodeStringElement(r1, r5)
            r2 = r2 | 1
            goto L_0x0035
        L_0x0067:
            r9 = r5
            goto L_0x0035
        L_0x0069:
            r11 = r2
            r12 = r6
            r4 = r7
            r3 = r8
        L_0x006d:
            r0.endStructure(r1)
            com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration$Feature r0 = new com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration$Feature
            r13 = r4
            java.lang.String r13 = (java.lang.String) r13
            r14 = r3
            java.lang.String r14 = (java.lang.String) r14
            r15 = 0
            r10 = r0
            r10.<init>((int) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (kotlinx.serialization.internal.SerializationConstructorMarker) r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration$Feature$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration$Feature");
    }

    public void serialize(Encoder encoder, PaywallData.LocalizedConfiguration.Feature feature) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(feature, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PaywallData.LocalizedConfiguration.Feature.write$Self(feature, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
