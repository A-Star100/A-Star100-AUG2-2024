package com.google.crypto.tink;

import com.google.crypto.tink.internal.JsonParser;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;

public final class JsonKeysetReader implements KeysetReader {
    private static final long MAX_KEY_ID = 4294967295L;
    private static final long MIN_KEY_ID = -2147483648L;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final InputStream inputStream;
    private boolean urlSafeBase64 = false;

    public JsonKeysetReader withUrlSafeBase64() {
        this.urlSafeBase64 = true;
        return this;
    }

    private JsonKeysetReader(InputStream inputStream2) {
        this.inputStream = inputStream2;
    }

    public static JsonKeysetReader withInputStream(InputStream inputStream2) throws IOException {
        return new JsonKeysetReader(inputStream2);
    }

    @Deprecated
    public static JsonKeysetReader withJsonObject(Object obj) {
        return withString(obj.toString());
    }

    public static JsonKeysetReader withString(String str) {
        return new JsonKeysetReader(new ByteArrayInputStream(str.getBytes(UTF_8)));
    }

    public static JsonKeysetReader withBytes(byte[] bArr) {
        return new JsonKeysetReader(new ByteArrayInputStream(bArr));
    }

    @Deprecated
    public static JsonKeysetReader withFile(File file) throws IOException {
        return withInputStream(new FileInputStream(file));
    }

    @Deprecated
    public static JsonKeysetReader withPath(String str) throws IOException {
        return withInputStream(new FileInputStream(new File(str)));
    }

    @Deprecated
    public static JsonKeysetReader withPath(Path path) throws IOException {
        return withInputStream(new FileInputStream(path.toFile()));
    }

    public Keyset read() throws IOException {
        try {
            Keyset keysetFromJson = keysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).getAsJsonObject());
            InputStream inputStream2 = this.inputStream;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            return keysetFromJson;
        } catch (JsonParseException | IllegalStateException e) {
            throw new IOException(e);
        } catch (Throwable th) {
            InputStream inputStream3 = this.inputStream;
            if (inputStream3 != null) {
                inputStream3.close();
            }
            throw th;
        }
    }

    public EncryptedKeyset readEncrypted() throws IOException {
        try {
            EncryptedKeyset encryptedKeysetFromJson = encryptedKeysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).getAsJsonObject());
            InputStream inputStream2 = this.inputStream;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            return encryptedKeysetFromJson;
        } catch (JsonParseException | IllegalStateException e) {
            throw new IOException(e);
        } catch (Throwable th) {
            InputStream inputStream3 = this.inputStream;
            if (inputStream3 != null) {
                inputStream3.close();
            }
            throw th;
        }
    }

    private static int getKeyId(JsonElement jsonElement) throws IOException {
        try {
            long parsedNumberAsLongOrThrow = JsonParser.getParsedNumberAsLongOrThrow(jsonElement);
            if (parsedNumberAsLongOrThrow <= MAX_KEY_ID && parsedNumberAsLongOrThrow >= MIN_KEY_ID) {
                return (int) jsonElement.getAsLong();
            }
            throw new IOException("invalid key id");
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
    }

    private Keyset keysetFromJson(JsonObject jsonObject) throws IOException {
        validateKeyset(jsonObject);
        Keyset.Builder newBuilder = Keyset.newBuilder();
        if (jsonObject.has("primaryKeyId")) {
            newBuilder.setPrimaryKeyId(getKeyId(jsonObject.get("primaryKeyId")));
        }
        JsonArray asJsonArray = jsonObject.getAsJsonArray(SubscriberAttributeKt.JSON_NAME_KEY);
        for (int i = 0; i < asJsonArray.size(); i++) {
            newBuilder.addKey(keyFromJson(asJsonArray.get(i).getAsJsonObject()));
        }
        return (Keyset) newBuilder.build();
    }

    private EncryptedKeyset encryptedKeysetFromJson(JsonObject jsonObject) throws IOException {
        byte[] bArr;
        validateEncryptedKeyset(jsonObject);
        if (this.urlSafeBase64) {
            bArr = Base64.urlSafeDecode(jsonObject.get("encryptedKeyset").getAsString());
        } else {
            bArr = Base64.decode(jsonObject.get("encryptedKeyset").getAsString());
        }
        if (jsonObject.has("keysetInfo")) {
            return (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArr)).setKeysetInfo(keysetInfoFromJson(jsonObject.getAsJsonObject("keysetInfo"))).build();
        }
        return (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArr)).build();
    }

    private Keyset.Key keyFromJson(JsonObject jsonObject) throws IOException {
        validateKey(jsonObject);
        return (Keyset.Key) Keyset.Key.newBuilder().setStatus(getStatus(jsonObject.get("status").getAsString())).setKeyId(getKeyId(jsonObject.get("keyId"))).setOutputPrefixType(getOutputPrefixType(jsonObject.get("outputPrefixType").getAsString())).setKeyData(keyDataFromJson(jsonObject.getAsJsonObject("keyData"))).build();
    }

    private static KeysetInfo keysetInfoFromJson(JsonObject jsonObject) throws IOException {
        KeysetInfo.Builder newBuilder = KeysetInfo.newBuilder();
        if (jsonObject.has("primaryKeyId")) {
            newBuilder.setPrimaryKeyId(getKeyId(jsonObject.get("primaryKeyId")));
        }
        if (jsonObject.has("keyInfo")) {
            JsonArray asJsonArray = jsonObject.getAsJsonArray("keyInfo");
            for (int i = 0; i < asJsonArray.size(); i++) {
                newBuilder.addKeyInfo(keyInfoFromJson(asJsonArray.get(i).getAsJsonObject()));
            }
        }
        return (KeysetInfo) newBuilder.build();
    }

    private static KeysetInfo.KeyInfo keyInfoFromJson(JsonObject jsonObject) throws IOException {
        return (KeysetInfo.KeyInfo) KeysetInfo.KeyInfo.newBuilder().setStatus(getStatus(jsonObject.get("status").getAsString())).setKeyId(getKeyId(jsonObject.get("keyId"))).setOutputPrefixType(getOutputPrefixType(jsonObject.get("outputPrefixType").getAsString())).setTypeUrl(jsonObject.get("typeUrl").getAsString()).build();
    }

    private KeyData keyDataFromJson(JsonObject jsonObject) {
        byte[] bArr;
        validateKeyData(jsonObject);
        if (this.urlSafeBase64) {
            bArr = Base64.urlSafeDecode(jsonObject.get("value").getAsString());
        } else {
            bArr = Base64.decode(jsonObject.get("value").getAsString());
        }
        return (KeyData) KeyData.newBuilder().setTypeUrl(jsonObject.get("typeUrl").getAsString()).setValue(ByteString.copyFrom(bArr)).setKeyMaterialType(getKeyMaterialType(jsonObject.get("keyMaterialType").getAsString())).build();
    }

    private static KeyStatusType getStatus(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -891611359:
                if (str.equals("ENABLED")) {
                    c = 0;
                    break;
                }
                break;
            case 478389753:
                if (str.equals("DESTROYED")) {
                    c = 1;
                    break;
                }
                break;
            case 1053567612:
                if (str.equals("DISABLED")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return KeyStatusType.ENABLED;
            case 1:
                return KeyStatusType.DESTROYED;
            case 2:
                return KeyStatusType.DISABLED;
            default:
                throw new JsonParseException("unknown status: " + str);
        }
    }

    private static OutputPrefixType getOutputPrefixType(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2053249079:
                if (str.equals("LEGACY")) {
                    c = 0;
                    break;
                }
                break;
            case 80904:
                if (str.equals("RAW")) {
                    c = 1;
                    break;
                }
                break;
            case 2575090:
                if (str.equals("TINK")) {
                    c = 2;
                    break;
                }
                break;
            case 1761684556:
                if (str.equals("CRUNCHY")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return OutputPrefixType.LEGACY;
            case 1:
                return OutputPrefixType.RAW;
            case 2:
                return OutputPrefixType.TINK;
            case 3:
                return OutputPrefixType.CRUNCHY;
            default:
                throw new JsonParseException("unknown output prefix type: " + str);
        }
    }

    private static KeyData.KeyMaterialType getKeyMaterialType(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1881281466:
                if (str.equals("REMOTE")) {
                    c = 0;
                    break;
                }
                break;
            case -1609477353:
                if (str.equals("SYMMETRIC")) {
                    c = 1;
                    break;
                }
                break;
            case 249237018:
                if (str.equals("ASYMMETRIC_PRIVATE")) {
                    c = 2;
                    break;
                }
                break;
            case 1534613202:
                if (str.equals("ASYMMETRIC_PUBLIC")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return KeyData.KeyMaterialType.REMOTE;
            case 1:
                return KeyData.KeyMaterialType.SYMMETRIC;
            case 2:
                return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
            case 3:
                return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
            default:
                throw new JsonParseException("unknown key material type: " + str);
        }
    }

    private static void validateKeyset(JsonObject jsonObject) {
        if (!jsonObject.has(SubscriberAttributeKt.JSON_NAME_KEY) || jsonObject.getAsJsonArray(SubscriberAttributeKt.JSON_NAME_KEY).size() == 0) {
            throw new JsonParseException("invalid keyset");
        }
    }

    private static void validateEncryptedKeyset(JsonObject jsonObject) {
        if (!jsonObject.has("encryptedKeyset")) {
            throw new JsonParseException("invalid encrypted keyset");
        }
    }

    private static void validateKey(JsonObject jsonObject) {
        if (!jsonObject.has("keyData") || !jsonObject.has("status") || !jsonObject.has("keyId") || !jsonObject.has("outputPrefixType")) {
            throw new JsonParseException("invalid key");
        }
    }

    private static void validateKeyData(JsonObject jsonObject) {
        if (!jsonObject.has("typeUrl") || !jsonObject.has("value") || !jsonObject.has("keyMaterialType")) {
            throw new JsonParseException("invalid keyData");
        }
    }
}
