package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.utils.serializers.URLSerializer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: PaywallData.kt */
public final class PaywallData$$serializer implements GeneratedSerializer<PaywallData> {
    public static final PaywallData$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PaywallData$$serializer paywallData$$serializer = new PaywallData$$serializer();
        INSTANCE = paywallData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData", paywallData$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("template_name", false);
        pluginGeneratedSerialDescriptor.addElement("config", false);
        pluginGeneratedSerialDescriptor.addElement("asset_base_url", false);
        pluginGeneratedSerialDescriptor.addElement("revision", true);
        pluginGeneratedSerialDescriptor.addElement("localized_strings", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, PaywallData$Configuration$$serializer.INSTANCE, URLSerializer.INSTANCE, IntSerializer.INSTANCE, new LinkedHashMapSerializer(StringSerializer.INSTANCE, PaywallData$LocalizedConfiguration$$serializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.revenuecat.purchases.paywalls.PaywallData deserialize(kotlinx.serialization.encoding.Decoder r23) {
        /*
            r22 = this;
            r0 = r23
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r22.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 3
            r4 = 4
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 0
            if (r2 == 0) goto L_0x004f
            java.lang.String r2 = r0.decodeStringElement(r1, r7)
            com.revenuecat.purchases.paywalls.PaywallData$Configuration$$serializer r7 = com.revenuecat.purchases.paywalls.PaywallData$Configuration$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r6 = r0.decodeSerializableElement(r1, r6, r7, r8)
            com.revenuecat.purchases.utils.serializers.URLSerializer r7 = com.revenuecat.purchases.utils.serializers.URLSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r5 = r0.decodeSerializableElement(r1, r5, r7, r8)
            int r3 = r0.decodeIntElement(r1, r3)
            kotlinx.serialization.internal.LinkedHashMapSerializer r7 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r9 = (kotlinx.serialization.KSerializer) r9
            com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration$$serializer r10 = com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration$$serializer.INSTANCE
            kotlinx.serialization.KSerializer r10 = (kotlinx.serialization.KSerializer) r10
            r7.<init>(r9, r10)
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r4 = r0.decodeSerializableElement(r1, r4, r7, r8)
            r7 = 31
            r16 = r2
            r19 = r3
            r15 = r7
            goto L_0x00b6
        L_0x004f:
            r13 = r6
            r2 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r8 = r2
        L_0x0056:
            if (r13 == 0) goto L_0x00ae
            int r14 = r0.decodeElementIndex(r1)
            r15 = -1
            if (r14 == r15) goto L_0x00ac
            if (r14 == 0) goto L_0x00a5
            if (r14 == r6) goto L_0x0099
            if (r14 == r5) goto L_0x008e
            if (r14 == r3) goto L_0x0087
            if (r14 != r4) goto L_0x0081
            kotlinx.serialization.internal.LinkedHashMapSerializer r14 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r15 = (kotlinx.serialization.KSerializer) r15
            com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration$$serializer r16 = com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration$$serializer.INSTANCE
            r7 = r16
            kotlinx.serialization.KSerializer r7 = (kotlinx.serialization.KSerializer) r7
            r14.<init>(r15, r7)
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r12 = r0.decodeSerializableElement(r1, r4, r14, r12)
            r8 = r8 | 16
            goto L_0x00a3
        L_0x0081:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r14)
            throw r0
        L_0x0087:
            int r2 = r0.decodeIntElement(r1, r3)
            r8 = r8 | 8
            goto L_0x00a3
        L_0x008e:
            com.revenuecat.purchases.utils.serializers.URLSerializer r7 = com.revenuecat.purchases.utils.serializers.URLSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r11 = r0.decodeSerializableElement(r1, r5, r7, r11)
            r8 = r8 | 4
            goto L_0x00a3
        L_0x0099:
            com.revenuecat.purchases.paywalls.PaywallData$Configuration$$serializer r7 = com.revenuecat.purchases.paywalls.PaywallData$Configuration$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r10 = r0.decodeSerializableElement(r1, r6, r7, r10)
            r8 = r8 | 2
        L_0x00a3:
            r7 = 0
            goto L_0x0056
        L_0x00a5:
            java.lang.String r9 = r0.decodeStringElement(r1, r7)
            r8 = r8 | 1
            goto L_0x0056
        L_0x00ac:
            r13 = r7
            goto L_0x0056
        L_0x00ae:
            r19 = r2
            r15 = r8
            r16 = r9
            r6 = r10
            r5 = r11
            r4 = r12
        L_0x00b6:
            r0.endStructure(r1)
            com.revenuecat.purchases.paywalls.PaywallData r0 = new com.revenuecat.purchases.paywalls.PaywallData
            r17 = r6
            com.revenuecat.purchases.paywalls.PaywallData$Configuration r17 = (com.revenuecat.purchases.paywalls.PaywallData.Configuration) r17
            r18 = r5
            java.net.URL r18 = (java.net.URL) r18
            r20 = r4
            java.util.Map r20 = (java.util.Map) r20
            r21 = 0
            r14 = r0
            r14.<init>((int) r15, (java.lang.String) r16, (com.revenuecat.purchases.paywalls.PaywallData.Configuration) r17, (java.net.URL) r18, (int) r19, (java.util.Map) r20, (kotlinx.serialization.internal.SerializationConstructorMarker) r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.PaywallData$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.revenuecat.purchases.paywalls.PaywallData");
    }

    public void serialize(Encoder encoder, PaywallData paywallData) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(paywallData, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PaywallData.write$Self(paywallData, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
