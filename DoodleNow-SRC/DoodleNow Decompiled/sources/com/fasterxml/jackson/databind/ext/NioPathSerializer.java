package com.fasterxml.jackson.databind.ext;

import com.facebook.react.views.text.ReactTextView$$ExternalSyntheticApiModelOutline0;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import java.io.IOException;
import java.nio.file.Path;

public class NioPathSerializer extends StdScalarSerializer<Path> {
    private static final long serialVersionUID = 1;

    public /* bridge */ /* synthetic */ void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        serialize(ReactTextView$$ExternalSyntheticApiModelOutline0.m(obj), jsonGenerator, serializerProvider);
    }

    public NioPathSerializer() {
        super(ReactTextView$$ExternalSyntheticApiModelOutline0.m());
    }

    public void serialize(Path path, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(path.toUri().toString());
    }
}
