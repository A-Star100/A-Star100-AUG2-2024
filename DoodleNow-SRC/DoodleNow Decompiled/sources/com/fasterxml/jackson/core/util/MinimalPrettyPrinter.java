package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.PrettyPrinter;
import java.io.IOException;
import java.io.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class MinimalPrettyPrinter implements PrettyPrinter, Serializable {
    public static final String DEFAULT_ROOT_VALUE_SEPARATOR = " ";
    private static final long serialVersionUID = 1;
    protected String _rootValueSeparator;

    public void beforeArrayValues(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
    }

    public void beforeObjectEntries(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
    }

    public void setRootValueSeparator(String str) {
        this._rootValueSeparator = str;
    }

    public MinimalPrettyPrinter() {
        this(DEFAULT_ROOT_VALUE_SEPARATOR);
    }

    public MinimalPrettyPrinter(String str) {
        this._rootValueSeparator = str;
    }

    public void writeRootValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        String str = this._rootValueSeparator;
        if (str != null) {
            jsonGenerator.writeRaw(str);
        }
    }

    public void writeStartObject(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw((char) AbstractJsonLexerKt.BEGIN_OBJ);
    }

    public void writeObjectFieldValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw((char) AbstractJsonLexerKt.COLON);
    }

    public void writeObjectEntrySeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw((char) AbstractJsonLexerKt.COMMA);
    }

    public void writeEndObject(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw((char) AbstractJsonLexerKt.END_OBJ);
    }

    public void writeStartArray(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw((char) AbstractJsonLexerKt.BEGIN_LIST);
    }

    public void writeArrayValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw((char) AbstractJsonLexerKt.COMMA);
    }

    public void writeEndArray(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw((char) AbstractJsonLexerKt.END_LIST);
    }
}
