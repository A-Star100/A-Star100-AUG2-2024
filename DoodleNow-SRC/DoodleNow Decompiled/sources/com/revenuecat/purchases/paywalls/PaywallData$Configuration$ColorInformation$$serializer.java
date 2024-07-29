package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.paywalls.PaywallData;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.Configuration.ColorInformation.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: PaywallData.kt */
public final class PaywallData$Configuration$ColorInformation$$serializer implements GeneratedSerializer<PaywallData.Configuration.ColorInformation> {
    public static final PaywallData$Configuration$ColorInformation$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PaywallData$Configuration$ColorInformation$$serializer paywallData$Configuration$ColorInformation$$serializer = new PaywallData$Configuration$ColorInformation$$serializer();
        INSTANCE = paywallData$Configuration$ColorInformation$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.Configuration.ColorInformation", paywallData$Configuration$ColorInformation$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("light", false);
        pluginGeneratedSerialDescriptor.addElement("dark", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$Configuration$ColorInformation$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{PaywallData$Configuration$Colors$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(PaywallData$Configuration$Colors$$serializer.INSTANCE)};
    }

    public PaywallData.Configuration.ColorInformation deserialize(Decoder decoder) {
        int i;
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        if (beginStructure.decodeSequentially()) {
            obj2 = beginStructure.decodeSerializableElement(descriptor2, 0, PaywallData$Configuration$Colors$$serializer.INSTANCE, null);
            obj = beginStructure.decodeNullableSerializableElement(descriptor2, 1, PaywallData$Configuration$Colors$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            obj2 = null;
            Object obj3 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    obj2 = beginStructure.decodeSerializableElement(descriptor2, 0, PaywallData$Configuration$Colors$$serializer.INSTANCE, obj2);
                    i2 |= 1;
                } else if (decodeElementIndex == 1) {
                    obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, PaywallData$Configuration$Colors$$serializer.INSTANCE, obj3);
                    i2 |= 2;
                } else {
                    throw new UnknownFieldException(decodeElementIndex);
                }
            }
            obj = obj3;
            i = i2;
        }
        beginStructure.endStructure(descriptor2);
        return new PaywallData.Configuration.ColorInformation(i, (PaywallData.Configuration.Colors) obj2, (PaywallData.Configuration.Colors) obj, (SerializationConstructorMarker) null);
    }

    public void serialize(Encoder encoder, PaywallData.Configuration.ColorInformation colorInformation) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(colorInformation, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PaywallData.Configuration.ColorInformation.write$Self(colorInformation, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
