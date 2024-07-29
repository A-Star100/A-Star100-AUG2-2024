package com.fasterxml.jackson.databind.deser.std;

import com.facebook.react.util.JSStackTrace;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.io.IOException;

public class StackTraceElementDeserializer extends StdScalarDeserializer<StackTraceElement> {
    private static final long serialVersionUID = 1;

    public StackTraceElementDeserializer() {
        super((Class<?>) StackTraceElement.class);
    }

    public StackTraceElement deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.START_OBJECT) {
            String str = "";
            String str2 = null;
            String str3 = null;
            String str4 = str;
            int i = -1;
            String str5 = str4;
            while (true) {
                JsonToken nextValue = jsonParser.nextValue();
                if (nextValue == JsonToken.END_OBJECT) {
                    return constructValue(deserializationContext, str, str5, str4, i, str2, str3);
                }
                String currentName = jsonParser.getCurrentName();
                if ("className".equals(currentName)) {
                    str = jsonParser.getText();
                } else if ("fileName".equals(currentName)) {
                    str4 = jsonParser.getText();
                } else if ("lineNumber".equals(currentName)) {
                    if (nextValue.isNumeric()) {
                        i = jsonParser.getIntValue();
                    } else {
                        return (StackTraceElement) deserializationContext.handleUnexpectedToken(handledType(), nextValue, jsonParser, "Non-numeric token (%s) for property 'lineNumber'", nextValue);
                    }
                } else if (JSStackTrace.METHOD_NAME_KEY.equals(currentName)) {
                    str5 = jsonParser.getText();
                } else if (!"nativeMethod".equals(currentName)) {
                    if ("moduleName".equals(currentName)) {
                        str2 = jsonParser.getText();
                    } else if ("moduleVersion".equals(currentName)) {
                        str3 = jsonParser.getText();
                    } else {
                        handleUnknownProperty(jsonParser, deserializationContext, this._valueClass, currentName);
                    }
                }
            }
        } else if (currentToken != JsonToken.START_ARRAY || !deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            return (StackTraceElement) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser);
        } else {
            jsonParser.nextToken();
            StackTraceElement deserialize = deserialize(jsonParser, deserializationContext);
            if (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                handleMissingEndArrayForSingle(jsonParser, deserializationContext);
            }
            return deserialize;
        }
    }

    /* access modifiers changed from: protected */
    public StackTraceElement constructValue(DeserializationContext deserializationContext, String str, String str2, String str3, int i, String str4, String str5) {
        return new StackTraceElement(str, str2, str3, i);
    }
}
