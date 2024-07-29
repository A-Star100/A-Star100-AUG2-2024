package com.revenuecat.purchases.paywalls;

import com.facebook.react.modules.appstate.AppStateModule;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.Configuration.Images.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: PaywallData.kt */
public final class PaywallData$Configuration$Images$$serializer implements GeneratedSerializer<PaywallData.Configuration.Images> {
    public static final PaywallData$Configuration$Images$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PaywallData$Configuration$Images$$serializer paywallData$Configuration$Images$$serializer = new PaywallData$Configuration$Images$$serializer();
        INSTANCE = paywallData$Configuration$Images$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images", paywallData$Configuration$Images$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("header", true);
        pluginGeneratedSerialDescriptor.addElement(AppStateModule.APP_STATE_BACKGROUND, true);
        pluginGeneratedSerialDescriptor.addElement("icon", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$Configuration$Images$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images deserialize(kotlinx.serialization.encoding.Decoder r13) {
        /*
            r12 = this;
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r12.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r13 = r13.beginStructure(r0)
            boolean r1 = r13.decodeSequentially()
            r2 = 2
            r3 = 1
            r4 = 0
            r5 = 0
            if (r1 == 0) goto L_0x0032
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r1 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r1 = (kotlinx.serialization.DeserializationStrategy) r1
            java.lang.Object r1 = r13.decodeNullableSerializableElement(r0, r4, r1, r5)
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r4 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            java.lang.Object r3 = r13.decodeNullableSerializableElement(r0, r3, r4, r5)
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r4 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            java.lang.Object r2 = r13.decodeNullableSerializableElement(r0, r2, r4, r5)
            r4 = 7
            r5 = r4
            goto L_0x0073
        L_0x0032:
            r8 = r3
            r1 = r4
            r6 = r5
            r7 = r6
        L_0x0036:
            if (r8 == 0) goto L_0x006e
            int r9 = r13.decodeElementIndex(r0)
            r10 = -1
            if (r9 == r10) goto L_0x006c
            if (r9 == 0) goto L_0x0061
            if (r9 == r3) goto L_0x0056
            if (r9 != r2) goto L_0x0050
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r9 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r7 = r13.decodeNullableSerializableElement(r0, r2, r9, r7)
            r1 = r1 | 4
            goto L_0x0036
        L_0x0050:
            kotlinx.serialization.UnknownFieldException r13 = new kotlinx.serialization.UnknownFieldException
            r13.<init>((int) r9)
            throw r13
        L_0x0056:
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r9 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r6 = r13.decodeNullableSerializableElement(r0, r3, r9, r6)
            r1 = r1 | 2
            goto L_0x0036
        L_0x0061:
            com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer r9 = com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r5 = r13.decodeNullableSerializableElement(r0, r4, r9, r5)
            r1 = r1 | 1
            goto L_0x0036
        L_0x006c:
            r8 = r4
            goto L_0x0036
        L_0x006e:
            r3 = r6
            r2 = r7
            r11 = r5
            r5 = r1
            r1 = r11
        L_0x0073:
            r13.endStructure(r0)
            com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images r13 = new com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
            r7 = r3
            java.lang.String r7 = (java.lang.String) r7
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            r9 = 0
            r4 = r13
            r4.<init>((int) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (kotlinx.serialization.internal.SerializationConstructorMarker) r9)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images");
    }

    public void serialize(Encoder encoder, PaywallData.Configuration.Images images) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(images, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PaywallData.Configuration.Images.write$Self(images, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
