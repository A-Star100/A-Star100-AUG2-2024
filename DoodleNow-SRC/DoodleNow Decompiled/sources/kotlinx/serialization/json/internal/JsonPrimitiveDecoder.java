package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonPrimitive;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/json/internal/JsonPrimitiveDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonPrimitive;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonPrimitive;)V", "getValue", "()Lkotlinx/serialization/json/JsonPrimitive;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "", "decodeElementIndex", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TreeJsonDecoder.kt */
final class JsonPrimitiveDecoder extends AbstractJsonTreeDecoder {
    private final JsonPrimitive value;

    public int decodeElementIndex(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return 0;
    }

    public JsonPrimitive getValue() {
        return this.value;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonPrimitiveDecoder(Json json, JsonPrimitive jsonPrimitive) {
        super(json, jsonPrimitive, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(jsonPrimitive, "value");
        this.value = jsonPrimitive;
        pushTag(TreeJsonEncoderKt.PRIMITIVE_TAG);
    }

    /* access modifiers changed from: protected */
    public JsonElement currentElement(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        if (str == TreeJsonEncoderKt.PRIMITIVE_TAG) {
            return getValue();
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag".toString());
    }
}
