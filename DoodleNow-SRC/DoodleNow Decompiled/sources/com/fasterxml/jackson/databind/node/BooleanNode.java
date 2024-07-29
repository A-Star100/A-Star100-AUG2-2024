package com.fasterxml.jackson.databind.node;

import androidx.camera.video.AudioStats;
import com.amazon.a.a.o.b;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class BooleanNode extends ValueNode {
    public static final BooleanNode FALSE = new BooleanNode(false);
    public static final BooleanNode TRUE = new BooleanNode(true);
    private final boolean _value;

    public static BooleanNode getFalse() {
        return FALSE;
    }

    public static BooleanNode getTrue() {
        return TRUE;
    }

    public static BooleanNode valueOf(boolean z) {
        return z ? TRUE : FALSE;
    }

    public boolean asBoolean() {
        return this._value;
    }

    public boolean asBoolean(boolean z) {
        return this._value;
    }

    public double asDouble(double d) {
        if (this._value) {
            return 1.0d;
        }
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public int asInt(int i) {
        return this._value ? 1 : 0;
    }

    public long asLong(long j) {
        return this._value ? 1 : 0;
    }

    public String asText() {
        return this._value ? b.ac : "false";
    }

    public boolean booleanValue() {
        return this._value;
    }

    public int hashCode() {
        return this._value ? 3 : 1;
    }

    private BooleanNode(boolean z) {
        this._value = z;
    }

    public JsonNodeType getNodeType() {
        return JsonNodeType.BOOLEAN;
    }

    public JsonToken asToken() {
        return this._value ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeBoolean(this._value);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof BooleanNode)) {
            return false;
        }
        if (this._value == ((BooleanNode) obj)._value) {
            return true;
        }
        return false;
    }
}
