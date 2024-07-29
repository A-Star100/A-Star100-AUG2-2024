package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: JsonElement.kt */
final class JsonNull$$cachedSerializer$delegate$1 extends Lambda implements Function0<KSerializer<Object>> {
    public static final JsonNull$$cachedSerializer$delegate$1 INSTANCE = new JsonNull$$cachedSerializer$delegate$1();

    JsonNull$$cachedSerializer$delegate$1() {
        super(0);
    }

    public final KSerializer<Object> invoke() {
        return JsonNullSerializer.INSTANCE;
    }
}
