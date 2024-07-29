package com.fasterxml.jackson.databind.jsonschema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.codec.language.bm.Languages;

@Deprecated
public class JsonSchema {
    private final ObjectNode schema;

    @JsonValue
    public ObjectNode getSchemaNode() {
        return this.schema;
    }

    @JsonCreator
    public JsonSchema(ObjectNode objectNode) {
        this.schema = objectNode;
    }

    public String toString() {
        return this.schema.toString();
    }

    public int hashCode() {
        return this.schema.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JsonSchema)) {
            return false;
        }
        JsonSchema jsonSchema = (JsonSchema) obj;
        ObjectNode objectNode = this.schema;
        if (objectNode != null) {
            return objectNode.equals(jsonSchema.schema);
        }
        if (jsonSchema.schema == null) {
            return true;
        }
        return false;
    }

    public static JsonNode getDefaultSchemaNode() {
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        objectNode.put("type", Languages.ANY);
        return objectNode;
    }
}
