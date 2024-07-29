package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public final class MissingNode extends ValueNode {
    private static final MissingNode instance = new MissingNode();

    public static MissingNode getInstance() {
        return instance;
    }

    public String asText() {
        return "";
    }

    public String asText(String str) {
        return str;
    }

    public <T extends JsonNode> T deepCopy() {
        return this;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public String toString() {
        return "";
    }

    private MissingNode() {
    }

    public JsonNodeType getNodeType() {
        return JsonNodeType.MISSING;
    }

    public JsonToken asToken() {
        return JsonToken.NOT_AVAILABLE;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeNull();
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonProcessingException {
        jsonGenerator.writeNull();
    }

    public int hashCode() {
        return JsonNodeType.MISSING.ordinal();
    }
}
