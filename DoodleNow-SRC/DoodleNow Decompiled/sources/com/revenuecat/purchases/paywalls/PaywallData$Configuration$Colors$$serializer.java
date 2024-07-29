package com.revenuecat.purchases.paywalls;

import com.facebook.react.modules.appstate.AppStateModule;
import com.revenuecat.purchases.paywalls.PaywallColor;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.Configuration.Colors.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: PaywallData.kt */
public final class PaywallData$Configuration$Colors$$serializer implements GeneratedSerializer<PaywallData.Configuration.Colors> {
    public static final PaywallData$Configuration$Colors$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PaywallData$Configuration$Colors$$serializer paywallData$Configuration$Colors$$serializer = new PaywallData$Configuration$Colors$$serializer();
        INSTANCE = paywallData$Configuration$Colors$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.Configuration.Colors", paywallData$Configuration$Colors$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement(AppStateModule.APP_STATE_BACKGROUND, false);
        pluginGeneratedSerialDescriptor.addElement("text_1", false);
        pluginGeneratedSerialDescriptor.addElement("text_2", true);
        pluginGeneratedSerialDescriptor.addElement("text_3", true);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_background", false);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_foreground", false);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_secondary_background", true);
        pluginGeneratedSerialDescriptor.addElement("accent_1", true);
        pluginGeneratedSerialDescriptor.addElement("accent_2", true);
        pluginGeneratedSerialDescriptor.addElement("accent_3", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$Configuration$Colors$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{PaywallColor.Serializer.INSTANCE, PaywallColor.Serializer.INSTANCE, BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), PaywallColor.Serializer.INSTANCE, PaywallColor.Serializer.INSTANCE, BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.revenuecat.purchases.paywalls.PaywallData.Configuration.Colors deserialize(kotlinx.serialization.encoding.Decoder r27) {
        /*
            r26 = this;
            r0 = r27
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r26.getDescriptor()
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
            if (r2 == 0) goto L_0x0077
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r2 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2
            java.lang.Object r2 = r0.decodeSerializableElement(r1, r12, r2, r13)
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r12 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r11 = r0.decodeSerializableElement(r1, r11, r12, r13)
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r12 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r10, r12, r13)
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r12 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r7, r12, r13)
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r12 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r9 = r0.decodeSerializableElement(r1, r9, r12, r13)
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r12 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r6 = r0.decodeSerializableElement(r1, r6, r12, r13)
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r12 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r5, r12, r13)
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r12 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r12, r13)
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r12 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r8, r12, r13)
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r12 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r12, r13)
            r12 = 1023(0x3ff, float:1.434E-42)
            r13 = r12
            goto L_0x012a
        L_0x0077:
            r22 = r11
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
        L_0x0083:
            if (r22 == 0) goto L_0x011c
            int r4 = r0.decodeElementIndex(r1)
            switch(r4) {
                case -1: goto L_0x0114;
                case 0: goto L_0x0107;
                case 1: goto L_0x00fa;
                case 2: goto L_0x00ed;
                case 3: goto L_0x00e0;
                case 4: goto L_0x00d3;
                case 5: goto L_0x00c6;
                case 6: goto L_0x00b9;
                case 7: goto L_0x00aa;
                case 8: goto L_0x009e;
                case 9: goto L_0x0092;
                default: goto L_0x008c;
            }
        L_0x008c:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r4)
            throw r0
        L_0x0092:
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r4 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r3, r4, r5)
            r2 = r2 | 512(0x200, float:7.175E-43)
            goto L_0x0119
        L_0x009e:
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r4 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r8, r4, r6)
            r2 = r2 | 256(0x100, float:3.59E-43)
            goto L_0x0119
        L_0x00aa:
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r4 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r3 = 7
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r3, r4, r9)
            r2 = r2 | 128(0x80, float:1.794E-43)
            r4 = r3
            r3 = 9
            goto L_0x0083
        L_0x00b9:
            r3 = 7
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r4 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r3 = 6
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r3, r4, r7)
            r2 = r2 | 64
            goto L_0x0117
        L_0x00c6:
            r3 = 6
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r4 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r3 = 5
            java.lang.Object r10 = r0.decodeSerializableElement(r1, r3, r4, r10)
            r2 = r2 | 32
            goto L_0x0117
        L_0x00d3:
            r3 = 5
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r4 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r3 = 4
            java.lang.Object r11 = r0.decodeSerializableElement(r1, r3, r4, r11)
            r2 = r2 | 16
            goto L_0x0117
        L_0x00e0:
            r3 = 4
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r4 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r3 = 3
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r3, r4, r12)
            r2 = r2 | 8
            goto L_0x0117
        L_0x00ed:
            r3 = 3
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r4 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r3 = 2
            java.lang.Object r15 = r0.decodeNullableSerializableElement(r1, r3, r4, r15)
            r2 = r2 | 4
            goto L_0x0117
        L_0x00fa:
            r3 = 2
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r4 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r3 = 1
            java.lang.Object r14 = r0.decodeSerializableElement(r1, r3, r4, r14)
            r2 = r2 | 2
            goto L_0x0117
        L_0x0107:
            r3 = 1
            com.revenuecat.purchases.paywalls.PaywallColor$Serializer r4 = com.revenuecat.purchases.paywalls.PaywallColor.Serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r3 = 0
            java.lang.Object r13 = r0.decodeSerializableElement(r1, r3, r4, r13)
            r2 = r2 | 1
            goto L_0x0117
        L_0x0114:
            r3 = 0
            r22 = r3
        L_0x0117:
            r3 = 9
        L_0x0119:
            r4 = 7
            goto L_0x0083
        L_0x011c:
            r3 = r5
            r8 = r6
            r5 = r7
            r4 = r9
            r6 = r10
            r9 = r11
            r7 = r12
            r11 = r14
            r10 = r15
            r25 = r13
            r13 = r2
            r2 = r25
        L_0x012a:
            r0.endStructure(r1)
            com.revenuecat.purchases.paywalls.PaywallData$Configuration$Colors r0 = new com.revenuecat.purchases.paywalls.PaywallData$Configuration$Colors
            r14 = r2
            com.revenuecat.purchases.paywalls.PaywallColor r14 = (com.revenuecat.purchases.paywalls.PaywallColor) r14
            r15 = r11
            com.revenuecat.purchases.paywalls.PaywallColor r15 = (com.revenuecat.purchases.paywalls.PaywallColor) r15
            r16 = r10
            com.revenuecat.purchases.paywalls.PaywallColor r16 = (com.revenuecat.purchases.paywalls.PaywallColor) r16
            r17 = r7
            com.revenuecat.purchases.paywalls.PaywallColor r17 = (com.revenuecat.purchases.paywalls.PaywallColor) r17
            r18 = r9
            com.revenuecat.purchases.paywalls.PaywallColor r18 = (com.revenuecat.purchases.paywalls.PaywallColor) r18
            r19 = r6
            com.revenuecat.purchases.paywalls.PaywallColor r19 = (com.revenuecat.purchases.paywalls.PaywallColor) r19
            r20 = r5
            com.revenuecat.purchases.paywalls.PaywallColor r20 = (com.revenuecat.purchases.paywalls.PaywallColor) r20
            r21 = r4
            com.revenuecat.purchases.paywalls.PaywallColor r21 = (com.revenuecat.purchases.paywalls.PaywallColor) r21
            r22 = r8
            com.revenuecat.purchases.paywalls.PaywallColor r22 = (com.revenuecat.purchases.paywalls.PaywallColor) r22
            r23 = r3
            com.revenuecat.purchases.paywalls.PaywallColor r23 = (com.revenuecat.purchases.paywalls.PaywallColor) r23
            r24 = 0
            r12 = r0
            r12.<init>((int) r13, (com.revenuecat.purchases.paywalls.PaywallColor) r14, (com.revenuecat.purchases.paywalls.PaywallColor) r15, (com.revenuecat.purchases.paywalls.PaywallColor) r16, (com.revenuecat.purchases.paywalls.PaywallColor) r17, (com.revenuecat.purchases.paywalls.PaywallColor) r18, (com.revenuecat.purchases.paywalls.PaywallColor) r19, (com.revenuecat.purchases.paywalls.PaywallColor) r20, (com.revenuecat.purchases.paywalls.PaywallColor) r21, (com.revenuecat.purchases.paywalls.PaywallColor) r22, (com.revenuecat.purchases.paywalls.PaywallColor) r23, (kotlinx.serialization.internal.SerializationConstructorMarker) r24)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.PaywallData$Configuration$Colors$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.revenuecat.purchases.paywalls.PaywallData$Configuration$Colors");
    }

    public void serialize(Encoder encoder, PaywallData.Configuration.Colors colors) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(colors, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PaywallData.Configuration.Colors.write$Self(colors, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
