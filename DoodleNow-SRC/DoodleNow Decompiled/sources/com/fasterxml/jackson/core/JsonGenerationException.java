package com.fasterxml.jackson.core;

public class JsonGenerationException extends JsonProcessingException {
    private static final long serialVersionUID = 123;
    protected transient JsonGenerator _processor;

    public JsonGenerator getProcessor() {
        return this._processor;
    }

    public JsonGenerationException withGenerator(JsonGenerator jsonGenerator) {
        this._processor = jsonGenerator;
        return this;
    }

    @Deprecated
    public JsonGenerationException(Throwable th) {
        super(th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated
    public JsonGenerationException(String str) {
        super(str, (JsonLocation) null);
        JsonLocation jsonLocation = null;
    }

    @Deprecated
    public JsonGenerationException(String str, Throwable th) {
        super(str, (JsonLocation) null, th);
    }

    public JsonGenerationException(Throwable th, JsonGenerator jsonGenerator) {
        super(th);
        this._processor = jsonGenerator;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonGenerationException(String str, JsonGenerator jsonGenerator) {
        super(str, (JsonLocation) null);
        JsonLocation jsonLocation = null;
        this._processor = jsonGenerator;
    }

    public JsonGenerationException(String str, Throwable th, JsonGenerator jsonGenerator) {
        super(str, (JsonLocation) null, th);
        this._processor = jsonGenerator;
    }
}
