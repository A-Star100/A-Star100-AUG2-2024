package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.utils.serializers.UUIDSerializer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/events/PaywallEvent.Data.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: PaywallEvent.kt */
public final class PaywallEvent$Data$$serializer implements GeneratedSerializer<PaywallEvent.Data> {
    public static final PaywallEvent$Data$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PaywallEvent$Data$$serializer paywallEvent$Data$$serializer = new PaywallEvent$Data$$serializer();
        INSTANCE = paywallEvent$Data$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.events.PaywallEvent.Data", paywallEvent$Data$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("offeringIdentifier", false);
        pluginGeneratedSerialDescriptor.addElement("paywallRevision", false);
        pluginGeneratedSerialDescriptor.addElement("sessionIdentifier", false);
        pluginGeneratedSerialDescriptor.addElement("displayMode", false);
        pluginGeneratedSerialDescriptor.addElement("localeIdentifier", false);
        pluginGeneratedSerialDescriptor.addElement("darkMode", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallEvent$Data$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, IntSerializer.INSTANCE, UUIDSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.revenuecat.purchases.paywalls.events.PaywallEvent.Data deserialize(kotlinx.serialization.encoding.Decoder r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r18.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 5
            r4 = 3
            r5 = 4
            r6 = 2
            r7 = 1
            r8 = 0
            r9 = 0
            if (r2 == 0) goto L_0x0042
            java.lang.String r2 = r0.decodeStringElement(r1, r8)
            int r7 = r0.decodeIntElement(r1, r7)
            com.revenuecat.purchases.utils.serializers.UUIDSerializer r8 = com.revenuecat.purchases.utils.serializers.UUIDSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            java.lang.Object r6 = r0.decodeSerializableElement(r1, r6, r8, r9)
            java.lang.String r4 = r0.decodeStringElement(r1, r4)
            java.lang.String r5 = r0.decodeStringElement(r1, r5)
            boolean r3 = r0.decodeBooleanElement(r1, r3)
            r8 = 63
            r11 = r2
            r16 = r3
            r14 = r4
            r15 = r5
            r12 = r7
            r10 = r8
            goto L_0x0092
        L_0x0042:
            r15 = r7
            r2 = r8
            r10 = r2
            r11 = r9
            r12 = r11
            r13 = r12
            r14 = r13
            r9 = r10
        L_0x004a:
            if (r15 == 0) goto L_0x008c
            int r8 = r0.decodeElementIndex(r1)
            switch(r8) {
                case -1: goto L_0x0089;
                case 0: goto L_0x0081;
                case 1: goto L_0x0079;
                case 2: goto L_0x006e;
                case 3: goto L_0x0067;
                case 4: goto L_0x0060;
                case 5: goto L_0x0059;
                default: goto L_0x0053;
            }
        L_0x0053:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r8)
            throw r0
        L_0x0059:
            boolean r2 = r0.decodeBooleanElement(r1, r3)
            r10 = r10 | 32
            goto L_0x007f
        L_0x0060:
            java.lang.String r14 = r0.decodeStringElement(r1, r5)
            r10 = r10 | 16
            goto L_0x007f
        L_0x0067:
            java.lang.String r13 = r0.decodeStringElement(r1, r4)
            r10 = r10 | 8
            goto L_0x007f
        L_0x006e:
            com.revenuecat.purchases.utils.serializers.UUIDSerializer r8 = com.revenuecat.purchases.utils.serializers.UUIDSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            java.lang.Object r12 = r0.decodeSerializableElement(r1, r6, r8, r12)
            r10 = r10 | 4
            goto L_0x007f
        L_0x0079:
            int r9 = r0.decodeIntElement(r1, r7)
            r10 = r10 | 2
        L_0x007f:
            r8 = 0
            goto L_0x004a
        L_0x0081:
            r8 = 0
            java.lang.String r11 = r0.decodeStringElement(r1, r8)
            r10 = r10 | 1
            goto L_0x004a
        L_0x0089:
            r8 = 0
            r15 = r8
            goto L_0x004a
        L_0x008c:
            r16 = r2
            r6 = r12
            r15 = r14
            r12 = r9
            r14 = r13
        L_0x0092:
            r0.endStructure(r1)
            com.revenuecat.purchases.paywalls.events.PaywallEvent$Data r0 = new com.revenuecat.purchases.paywalls.events.PaywallEvent$Data
            r13 = r6
            java.util.UUID r13 = (java.util.UUID) r13
            r17 = 0
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.events.PaywallEvent$Data$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.revenuecat.purchases.paywalls.events.PaywallEvent$Data");
    }

    public void serialize(Encoder encoder, PaywallEvent.Data data) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(data, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PaywallEvent.Data.write$Self(data, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
