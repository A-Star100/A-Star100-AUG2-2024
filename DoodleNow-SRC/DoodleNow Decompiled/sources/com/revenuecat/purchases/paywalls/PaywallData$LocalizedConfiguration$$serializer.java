package com.revenuecat.purchases.paywalls;

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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.LocalizedConfiguration.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: PaywallData.kt */
public final class PaywallData$LocalizedConfiguration$$serializer implements GeneratedSerializer<PaywallData.LocalizedConfiguration> {
    public static final PaywallData$LocalizedConfiguration$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PaywallData$LocalizedConfiguration$$serializer paywallData$LocalizedConfiguration$$serializer = new PaywallData$LocalizedConfiguration$$serializer();
        INSTANCE = paywallData$LocalizedConfiguration$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.LocalizedConfiguration", paywallData$LocalizedConfiguration$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("title", false);
        pluginGeneratedSerialDescriptor.addElement("subtitle", true);
        pluginGeneratedSerialDescriptor.addElement("call_to_action", false);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_with_intro_offer", true);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_with_multiple_intro_offers", true);
        pluginGeneratedSerialDescriptor.addElement("offer_details", true);
        pluginGeneratedSerialDescriptor.addElement("offer_details_with_intro_offer", true);
        pluginGeneratedSerialDescriptor.addElement("offer_details_with_multiple_intro_offers", true);
        pluginGeneratedSerialDescriptor.addElement("offer_name", true);
        pluginGeneratedSerialDescriptor.addElement("features", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$LocalizedConfiguration$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), new ArrayListSerializer(PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE)};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x011f, code lost:
        r3 = 9;
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0129, code lost:
        r3 = 9;
        r12 = r12;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0088, code lost:
        r14 = r14;
        r12 = r12;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0088, code lost:
        r12 = r12;
        r10 = r10;
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0088, code lost:
        r14 = r14;
        r12 = r12;
        r10 = r10;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.revenuecat.purchases.paywalls.PaywallData.LocalizedConfiguration deserialize(kotlinx.serialization.encoding.Decoder r21) {
        /*
            r20 = this;
            r0 = r21
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r20.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 9
            r4 = 7
            r5 = 6
            r6 = 5
            r7 = 3
            r8 = 8
            r9 = 4
            r10 = 2
            r11 = 1
            r12 = 0
            r13 = 0
            if (r2 == 0) goto L_0x007c
            java.lang.String r2 = r0.decodeStringElement(r1, r12)
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r12 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r11, r12, r13)
            java.lang.String r10 = r0.decodeStringElement(r1, r10)
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r12 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r7, r12, r13)
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r12 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r9, r12, r13)
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r12 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r6, r12, r13)
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r12 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r5, r12, r13)
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r12 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r12, r13)
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r12 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r8, r12, r13)
            kotlinx.serialization.internal.ArrayListSerializer r12 = new kotlinx.serialization.internal.ArrayListSerializer
            com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration$Feature$$serializer r14 = com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE
            kotlinx.serialization.KSerializer r14 = (kotlinx.serialization.KSerializer) r14
            r12.<init>(r14)
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r3 = r0.decodeSerializableElement(r1, r3, r12, r13)
            r12 = 1023(0x3ff, float:1.434E-42)
            r14 = r11
            r11 = r9
            r9 = r10
            r10 = r6
            r6 = r12
            r12 = r7
            r7 = r2
            goto L_0x0135
        L_0x007c:
            r18 = r11
            r2 = r12
            r5 = r13
            r6 = r5
            r7 = r6
            r9 = r7
            r10 = r9
            r11 = r10
            r12 = r11
            r14 = r12
            r15 = r14
        L_0x0088:
            if (r18 == 0) goto L_0x012e
            int r4 = r0.decodeElementIndex(r1)
            switch(r4) {
                case -1: goto L_0x0126;
                case 0: goto L_0x0116;
                case 1: goto L_0x0106;
                case 2: goto L_0x00fd;
                case 3: goto L_0x00f0;
                case 4: goto L_0x00e3;
                case 5: goto L_0x00d6;
                case 6: goto L_0x00c9;
                case 7: goto L_0x00ba;
                case 8: goto L_0x00ac;
                case 9: goto L_0x0097;
                default: goto L_0x0091;
            }
        L_0x0091:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r4)
            throw r0
        L_0x0097:
            kotlinx.serialization.internal.ArrayListSerializer r4 = new kotlinx.serialization.internal.ArrayListSerializer
            com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration$Feature$$serializer r19 = com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE
            r8 = r19
            kotlinx.serialization.KSerializer r8 = (kotlinx.serialization.KSerializer) r8
            r4.<init>(r8)
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            java.lang.Object r5 = r0.decodeSerializableElement(r1, r3, r4, r5)
            r2 = r2 | 512(0x200, float:7.175E-43)
            goto L_0x0121
        L_0x00ac:
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r4 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r8 = 8
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r8, r4, r6)
            r2 = r2 | 256(0x100, float:3.59E-43)
            goto L_0x012b
        L_0x00ba:
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r4 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r3 = 7
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r3, r4, r9)
            r2 = r2 | 128(0x80, float:1.794E-43)
            r4 = r3
            r3 = 9
            goto L_0x0088
        L_0x00c9:
            r3 = 7
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r4 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r3 = 6
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r3, r4, r7)
            r2 = r2 | 64
            goto L_0x0129
        L_0x00d6:
            r3 = 6
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r4 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r3 = 5
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r3, r4, r10)
            r2 = r2 | 32
            goto L_0x0129
        L_0x00e3:
            r3 = 5
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r4 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r3 = 4
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r3, r4, r11)
            r2 = r2 | 16
            goto L_0x0129
        L_0x00f0:
            r3 = 4
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r4 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r3 = 3
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r3, r4, r12)
            r2 = r2 | 8
            goto L_0x0129
        L_0x00fd:
            r3 = 3
            r4 = 2
            java.lang.String r15 = r0.decodeStringElement(r1, r4)
            r2 = r2 | 4
            goto L_0x0129
        L_0x0106:
            r3 = 3
            r4 = 2
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r17 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            r3 = r17
            kotlinx.serialization.DeserializationStrategy r3 = (kotlinx.serialization.DeserializationStrategy) r3
            r8 = 1
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r8, r3, r14)
            r2 = r2 | 2
            goto L_0x011f
        L_0x0116:
            r3 = 0
            r4 = 2
            r8 = 1
            java.lang.String r13 = r0.decodeStringElement(r1, r3)
            r2 = r2 | 1
        L_0x011f:
            r3 = 9
        L_0x0121:
            r4 = 7
            r8 = 8
            goto L_0x0088
        L_0x0126:
            r3 = 0
            r18 = r3
        L_0x0129:
            r3 = 9
        L_0x012b:
            r4 = 7
            goto L_0x0088
        L_0x012e:
            r3 = r5
            r8 = r6
            r5 = r7
            r4 = r9
            r7 = r13
            r9 = r15
            r6 = r2
        L_0x0135:
            r0.endStructure(r1)
            com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration r0 = new com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration
            r1 = r14
            java.lang.String r1 = (java.lang.String) r1
            r2 = r12
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r11 = (java.lang.String) r11
            r12 = r10
            java.lang.String r12 = (java.lang.String) r12
            r13 = r5
            java.lang.String r13 = (java.lang.String) r13
            r14 = r4
            java.lang.String r14 = (java.lang.String) r14
            r15 = r8
            java.lang.String r15 = (java.lang.String) r15
            r16 = r3
            java.util.List r16 = (java.util.List) r16
            r17 = 0
            r5 = r0
            r8 = r1
            r10 = r2
            r5.<init>((int) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.util.List) r16, (kotlinx.serialization.internal.SerializationConstructorMarker) r17)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.revenuecat.purchases.paywalls.PaywallData$LocalizedConfiguration");
    }

    public void serialize(Encoder encoder, PaywallData.LocalizedConfiguration localizedConfiguration) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(localizedConfiguration, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PaywallData.LocalizedConfiguration.write$Self(localizedConfiguration, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
