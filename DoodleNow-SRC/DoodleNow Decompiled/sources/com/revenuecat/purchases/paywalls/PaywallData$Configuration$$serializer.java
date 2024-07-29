package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.utils.serializers.OptionalURLSerializer;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.Configuration.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: PaywallData.kt */
public final class PaywallData$Configuration$$serializer implements GeneratedSerializer<PaywallData.Configuration> {
    public static final PaywallData$Configuration$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PaywallData$Configuration$$serializer paywallData$Configuration$$serializer = new PaywallData$Configuration$$serializer();
        INSTANCE = paywallData$Configuration$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.Configuration", paywallData$Configuration$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("packages", false);
        pluginGeneratedSerialDescriptor.addElement("default_package", true);
        pluginGeneratedSerialDescriptor.addElement("images_webp", true);
        pluginGeneratedSerialDescriptor.addElement("images", true);
        pluginGeneratedSerialDescriptor.addElement("blurred_background_image", true);
        pluginGeneratedSerialDescriptor.addElement("display_restore_purchases", true);
        pluginGeneratedSerialDescriptor.addElement("tos_url", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_url", true);
        pluginGeneratedSerialDescriptor.addElement("colors", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$Configuration$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{new ArrayListSerializer(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallData$Configuration$Images$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallData$Configuration$Images$$serializer.INSTANCE), BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(OptionalURLSerializer.INSTANCE), BuiltinSerializersKt.getNullable(OptionalURLSerializer.INSTANCE), PaywallData$Configuration$ColorInformation$$serializer.INSTANCE};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0109, code lost:
        r3 = 7;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0111, code lost:
        r4 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007c, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007c, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007c, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.revenuecat.purchases.paywalls.PaywallData.Configuration deserialize(kotlinx.serialization.encoding.Decoder r21) {
        /*
            r20 = this;
            r0 = r21
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r20.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 7
            r4 = 6
            r5 = 5
            r6 = 3
            r7 = 8
            r8 = 4
            r9 = 2
            r10 = 1
            r11 = 0
            r12 = 0
            if (r2 == 0) goto L_0x0070
            kotlinx.serialization.internal.ArrayListSerializer r2 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r13 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r13 = (kotlinx.serialization.KSerializer) r13
            r2.<init>(r13)
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2
            java.lang.Object r2 = r0.decodeSerializableElement(r1, r11, r2, r12)
            kotlinx.serialization.internal.StringSerializer r11 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r11 = (kotlinx.serialization.DeserializationStrategy) r11
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r10, r11, r12)
            com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images$$serializer r11 = com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r11 = (kotlinx.serialization.DeserializationStrategy) r11
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r9, r11, r12)
            com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images$$serializer r11 = com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r11 = (kotlinx.serialization.DeserializationStrategy) r11
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r6, r11, r12)
            boolean r8 = r0.decodeBooleanElement(r1, r8)
            boolean r5 = r0.decodeBooleanElement(r1, r5)
            com.revenuecat.purchases.utils.serializers.OptionalURLSerializer r11 = com.revenuecat.purchases.utils.serializers.OptionalURLSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r11 = (kotlinx.serialization.DeserializationStrategy) r11
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r11, r12)
            com.revenuecat.purchases.utils.serializers.OptionalURLSerializer r11 = com.revenuecat.purchases.utils.serializers.OptionalURLSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r11 = (kotlinx.serialization.DeserializationStrategy) r11
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r11, r12)
            com.revenuecat.purchases.paywalls.PaywallData$Configuration$ColorInformation$$serializer r11 = com.revenuecat.purchases.paywalls.PaywallData$Configuration$ColorInformation$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r11 = (kotlinx.serialization.DeserializationStrategy) r11
            java.lang.Object r7 = r0.decodeSerializableElement(r1, r7, r11, r12)
            r11 = 511(0x1ff, float:7.16E-43)
            r12 = r5
            r15 = r10
            r10 = r6
            r6 = r11
            r11 = r8
            goto L_0x011c
        L_0x0070:
            r18 = r10
            r2 = r11
            r13 = r2
            r6 = r12
            r8 = r6
            r9 = r8
            r10 = r9
            r14 = r10
            r15 = r14
            r11 = r15
            r12 = r13
        L_0x007c:
            if (r18 == 0) goto L_0x0114
            int r5 = r0.decodeElementIndex(r1)
            switch(r5) {
                case -1: goto L_0x010b;
                case 0: goto L_0x00f1;
                case 1: goto L_0x00e1;
                case 2: goto L_0x00d1;
                case 3: goto L_0x00c0;
                case 4: goto L_0x00b5;
                case 5: goto L_0x00ad;
                case 6: goto L_0x00a1;
                case 7: goto L_0x0096;
                case 8: goto L_0x008b;
                default: goto L_0x0085;
            }
        L_0x0085:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r5)
            throw r0
        L_0x008b:
            com.revenuecat.purchases.paywalls.PaywallData$Configuration$ColorInformation$$serializer r5 = com.revenuecat.purchases.paywalls.PaywallData$Configuration$ColorInformation$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            java.lang.Object r8 = r0.decodeSerializableElement(r1, r7, r5, r8)
            r13 = r13 | 256(0x100, float:3.59E-43)
            goto L_0x00ab
        L_0x0096:
            com.revenuecat.purchases.utils.serializers.OptionalURLSerializer r5 = com.revenuecat.purchases.utils.serializers.OptionalURLSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r3, r5, r6)
            r13 = r13 | 128(0x80, float:1.794E-43)
            goto L_0x00ab
        L_0x00a1:
            com.revenuecat.purchases.utils.serializers.OptionalURLSerializer r5 = com.revenuecat.purchases.utils.serializers.OptionalURLSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r4, r5, r9)
            r13 = r13 | 64
        L_0x00ab:
            r5 = 5
            goto L_0x007c
        L_0x00ad:
            r5 = 5
            boolean r2 = r0.decodeBooleanElement(r1, r5)
            r13 = r13 | 32
            goto L_0x007c
        L_0x00b5:
            r5 = 5
            r12 = 4
            boolean r17 = r0.decodeBooleanElement(r1, r12)
            r13 = r13 | 16
            r12 = r17
            goto L_0x007c
        L_0x00c0:
            r5 = 5
            r17 = 4
            com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images$$serializer r19 = com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images$$serializer.INSTANCE
            r3 = r19
            kotlinx.serialization.DeserializationStrategy r3 = (kotlinx.serialization.DeserializationStrategy) r3
            r4 = 3
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r4, r3, r10)
            r13 = r13 | 8
            goto L_0x0109
        L_0x00d1:
            r4 = 3
            r5 = 5
            r17 = 4
            com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images$$serializer r3 = com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r3 = (kotlinx.serialization.DeserializationStrategy) r3
            r4 = 2
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r4, r3, r11)
            r13 = r13 | 4
            goto L_0x0109
        L_0x00e1:
            r4 = 2
            r5 = 5
            r17 = 4
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r3 = (kotlinx.serialization.DeserializationStrategy) r3
            r4 = 1
            java.lang.Object r15 = r0.decodeNullableSerializableElement(r1, r4, r3, r15)
            r13 = r13 | 2
            goto L_0x0109
        L_0x00f1:
            r4 = 1
            r5 = 5
            r17 = 4
            kotlinx.serialization.internal.ArrayListSerializer r3 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r16 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r4 = r16
            kotlinx.serialization.KSerializer r4 = (kotlinx.serialization.KSerializer) r4
            r3.<init>(r4)
            kotlinx.serialization.DeserializationStrategy r3 = (kotlinx.serialization.DeserializationStrategy) r3
            r4 = 0
            java.lang.Object r14 = r0.decodeSerializableElement(r1, r4, r3, r14)
            r13 = r13 | 1
        L_0x0109:
            r3 = 7
            goto L_0x0111
        L_0x010b:
            r4 = 0
            r5 = 5
            r17 = 4
            r18 = r4
        L_0x0111:
            r4 = 6
            goto L_0x007c
        L_0x0114:
            r3 = r6
            r7 = r8
            r4 = r9
            r9 = r11
            r11 = r12
            r6 = r13
            r12 = r2
            r2 = r14
        L_0x011c:
            r0.endStructure(r1)
            com.revenuecat.purchases.paywalls.PaywallData$Configuration r0 = new com.revenuecat.purchases.paywalls.PaywallData$Configuration
            r1 = r2
            java.util.List r1 = (java.util.List) r1
            r8 = r15
            java.lang.String r8 = (java.lang.String) r8
            com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images r9 = (com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images) r9
            com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images r10 = (com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images) r10
            r13 = r4
            java.net.URL r13 = (java.net.URL) r13
            r14 = r3
            java.net.URL r14 = (java.net.URL) r14
            r15 = r7
            com.revenuecat.purchases.paywalls.PaywallData$Configuration$ColorInformation r15 = (com.revenuecat.purchases.paywalls.PaywallData.Configuration.ColorInformation) r15
            r16 = 0
            r5 = r0
            r7 = r1
            r5.<init>((int) r6, (java.util.List) r7, (java.lang.String) r8, (com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images) r9, (com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images) r10, (boolean) r11, (boolean) r12, (java.net.URL) r13, (java.net.URL) r14, (com.revenuecat.purchases.paywalls.PaywallData.Configuration.ColorInformation) r15, (kotlinx.serialization.internal.SerializationConstructorMarker) r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.PaywallData$Configuration$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.revenuecat.purchases.paywalls.PaywallData$Configuration");
    }

    public void serialize(Encoder encoder, PaywallData.Configuration configuration) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(configuration, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PaywallData.Configuration.write$Self(configuration, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
