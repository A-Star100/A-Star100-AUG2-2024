package com.revenuecat.purchases.utils.serializers;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/utils/serializers/UUIDSerializer;", "Lkotlinx/serialization/KSerializer;", "Ljava/util/UUID;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: UUIDSerializer.kt */
public final class UUIDSerializer implements KSerializer<UUID> {
    public static final UUIDSerializer INSTANCE = new UUIDSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING.INSTANCE);

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    private UUIDSerializer() {
    }

    public UUID deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        UUID fromString = UUID.fromString(decoder.decodeString());
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(decoder.decodeString())");
        return fromString;
    }

    public void serialize(Encoder encoder, UUID uuid) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(uuid, "value");
        String uuid2 = uuid.toString();
        Intrinsics.checkNotNullExpressionValue(uuid2, "value.toString()");
        encoder.encodeString(uuid2);
    }
}
