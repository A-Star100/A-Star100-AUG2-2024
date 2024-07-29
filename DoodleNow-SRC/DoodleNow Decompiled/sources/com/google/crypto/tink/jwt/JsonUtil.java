package com.google.crypto.tink.jwt;

import com.google.crypto.tink.internal.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.IOException;

final class JsonUtil {
    static boolean isValidString(String str) {
        return JsonParser.isValidString(str);
    }

    static JsonObject parseJson(String str) throws JwtInvalidException {
        try {
            return JsonParser.parse(str).getAsJsonObject();
        } catch (JsonParseException | IOException | IllegalStateException e) {
            throw new JwtInvalidException("invalid JSON: " + e);
        }
    }

    static JsonArray parseJsonArray(String str) throws JwtInvalidException {
        try {
            return JsonParser.parse(str).getAsJsonArray();
        } catch (JsonParseException | IOException | IllegalStateException e) {
            throw new JwtInvalidException("invalid JSON: " + e);
        }
    }

    private JsonUtil() {
    }
}
