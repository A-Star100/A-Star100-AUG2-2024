package com.google.crypto.tink.jwt;

import com.google.android.material.chip.Chip$$ExternalSyntheticApiModelOutline0;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.proto.JwtEcdsaAlgorithm;
import com.google.crypto.tink.proto.JwtEcdsaPublicKey;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey;
import com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Base64;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.onesignal.notifications.internal.bundle.impl.NotificationBundleProcessor;
import io.jsonwebtoken.JwsHeader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Optional;
import javax.annotation.Nullable;

public final class JwkSetConverter {
    private static final String JWT_ECDSA_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey";
    private static final String JWT_RSA_SSA_PKCS1_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey";
    private static final String JWT_RSA_SSA_PSS_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey";

    public static String fromPublicKeysetHandle(KeysetHandle keysetHandle) throws IOException, GeneralSecurityException {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < keysetHandle.size(); i++) {
            KeysetHandle.Entry at = keysetHandle.getAt(i);
            if (at.getStatus() == KeyStatus.ENABLED) {
                Key key = at.getKey();
                if (key instanceof LegacyProtoKey) {
                    ProtoKeySerialization serialization = ((LegacyProtoKey) key).getSerialization((SecretKeyAccess) null);
                    if (serialization.getOutputPrefixType() != OutputPrefixType.RAW && serialization.getOutputPrefixType() != OutputPrefixType.TINK) {
                        throw new GeneralSecurityException("only OutputPrefixType RAW and TINK are supported");
                    } else if (serialization.getKeyMaterialType() == KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
                        String typeUrl = serialization.getTypeUrl();
                        typeUrl.hashCode();
                        char c = 65535;
                        switch (typeUrl.hashCode()) {
                            case -1204668709:
                                if (typeUrl.equals(JWT_ECDSA_PUBLIC_KEY_URL)) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 516334794:
                                if (typeUrl.equals(JWT_RSA_SSA_PKCS1_PUBLIC_KEY_URL)) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 1174255008:
                                if (typeUrl.equals(JWT_RSA_SSA_PSS_PUBLIC_KEY_URL)) {
                                    c = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                jsonArray.add((JsonElement) convertJwtEcdsaKey(serialization));
                                break;
                            case 1:
                                jsonArray.add((JsonElement) convertJwtRsaSsaPkcs1(serialization));
                                break;
                            case 2:
                                jsonArray.add((JsonElement) convertJwtRsaSsaPss(serialization));
                                break;
                            default:
                                throw new GeneralSecurityException(String.format("key type %s is not supported", new Object[]{serialization.getTypeUrl()}));
                        }
                    } else {
                        throw new GeneralSecurityException("only public keys can be converted");
                    }
                } else {
                    throw new GeneralSecurityException("only LegacyProtoKey is currently supported");
                }
            }
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("keys", jsonArray);
        return jsonObject.toString();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0056, code lost:
        if (r4.equals("RS") == false) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.crypto.tink.KeysetHandle toPublicKeysetHandle(java.lang.String r8) throws java.io.IOException, java.security.GeneralSecurityException {
        /*
            com.google.gson.stream.JsonReader r0 = new com.google.gson.stream.JsonReader     // Catch:{ IllegalStateException -> 0x00c8, JsonParseException -> 0x00c6, StackOverflowError -> 0x00c4 }
            java.io.StringReader r1 = new java.io.StringReader     // Catch:{ IllegalStateException -> 0x00c8, JsonParseException -> 0x00c6, StackOverflowError -> 0x00c4 }
            r1.<init>(r8)     // Catch:{ IllegalStateException -> 0x00c8, JsonParseException -> 0x00c6, StackOverflowError -> 0x00c4 }
            r0.<init>(r1)     // Catch:{ IllegalStateException -> 0x00c8, JsonParseException -> 0x00c6, StackOverflowError -> 0x00c4 }
            r8 = 0
            r0.setLenient(r8)     // Catch:{ IllegalStateException -> 0x00c8, JsonParseException -> 0x00c6, StackOverflowError -> 0x00c4 }
            com.google.gson.JsonElement r0 = com.google.gson.internal.Streams.parse(r0)     // Catch:{ IllegalStateException -> 0x00c8, JsonParseException -> 0x00c6, StackOverflowError -> 0x00c4 }
            com.google.gson.JsonObject r0 = r0.getAsJsonObject()     // Catch:{ IllegalStateException -> 0x00c8, JsonParseException -> 0x00c6, StackOverflowError -> 0x00c4 }
            com.google.crypto.tink.KeysetHandle$Builder r1 = com.google.crypto.tink.KeysetHandle.newBuilder()
            java.lang.String r2 = "keys"
            com.google.gson.JsonElement r0 = r0.get(r2)
            com.google.gson.JsonArray r0 = r0.getAsJsonArray()
            java.util.Iterator r0 = r0.iterator()
        L_0x0028:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00aa
            java.lang.Object r2 = r0.next()
            com.google.gson.JsonElement r2 = (com.google.gson.JsonElement) r2
            com.google.gson.JsonObject r2 = r2.getAsJsonObject()
            java.lang.String r3 = "alg"
            java.lang.String r4 = getStringItem(r2, r3)
            r5 = 2
            java.lang.String r4 = r4.substring(r8, r5)
            r4.hashCode()
            int r6 = r4.hashCode()
            r7 = -1
            switch(r6) {
                case 2222: goto L_0x0064;
                case 2563: goto L_0x0059;
                case 2625: goto L_0x0050;
                default: goto L_0x004e;
            }
        L_0x004e:
            r5 = r7
            goto L_0x006e
        L_0x0050:
            java.lang.String r6 = "RS"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x006e
            goto L_0x004e
        L_0x0059:
            java.lang.String r5 = "PS"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0062
            goto L_0x004e
        L_0x0062:
            r5 = 1
            goto L_0x006e
        L_0x0064:
            java.lang.String r5 = "ES"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x006d
            goto L_0x004e
        L_0x006d:
            r5 = r8
        L_0x006e:
            switch(r5) {
                case 0: goto L_0x0093;
                case 1: goto L_0x008e;
                case 2: goto L_0x0089;
                default: goto L_0x0071;
            }
        L_0x0071:
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "unexpected alg value: "
            r0.<init>(r1)
            java.lang.String r1 = getStringItem(r2, r3)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L_0x0089:
            com.google.crypto.tink.internal.ProtoKeySerialization r2 = convertToRsaSsaPkcs1Key(r2)
            goto L_0x0097
        L_0x008e:
            com.google.crypto.tink.internal.ProtoKeySerialization r2 = convertToRsaSsaPssKey(r2)
            goto L_0x0097
        L_0x0093:
            com.google.crypto.tink.internal.ProtoKeySerialization r2 = convertToEcdsaKey(r2)
        L_0x0097:
            com.google.crypto.tink.internal.LegacyProtoKey r3 = new com.google.crypto.tink.internal.LegacyProtoKey
            r4 = 0
            r3.<init>(r2, r4)
            com.google.crypto.tink.KeysetHandle$Builder$Entry r2 = com.google.crypto.tink.KeysetHandle.importKey(r3)
            com.google.crypto.tink.KeysetHandle$Builder$Entry r2 = r2.withRandomId()
            r1.addEntry(r2)
            goto L_0x0028
        L_0x00aa:
            int r0 = r1.size()
            if (r0 <= 0) goto L_0x00bc
            com.google.crypto.tink.KeysetHandle$Builder$Entry r8 = r1.getAt(r8)
            r8.makePrimary()
            com.google.crypto.tink.KeysetHandle r8 = r1.build()
            return r8
        L_0x00bc:
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException
            java.lang.String r0 = "empty keyset"
            r8.<init>(r0)
            throw r8
        L_0x00c4:
            r8 = move-exception
            goto L_0x00c9
        L_0x00c6:
            r8 = move-exception
            goto L_0x00c9
        L_0x00c8:
            r8 = move-exception
        L_0x00c9:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.String r1 = "JWK set is invalid JSON"
            r0.<init>(r1, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.jwt.JwkSetConverter.toPublicKeysetHandle(java.lang.String):com.google.crypto.tink.KeysetHandle");
    }

    private static Optional<String> getKid(@Nullable Integer num) {
        if (num == null) {
            return Chip$$ExternalSyntheticApiModelOutline0.m();
        }
        return Chip$$ExternalSyntheticApiModelOutline0.m((Object) Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(num.intValue()).array()));
    }

    private static JsonObject convertJwtEcdsaKey(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        String str;
        String str2;
        try {
            JwtEcdsaPublicKey parseFrom = JwtEcdsaPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[parseFrom.getAlgorithm().ordinal()];
            if (i == 1) {
                str2 = "ES256";
                str = "P-256";
            } else if (i == 2) {
                str2 = "ES384";
                str = "P-384";
            } else if (i == 3) {
                str2 = "ES512";
                str = "P-521";
            } else {
                throw new GeneralSecurityException("unknown algorithm");
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("kty", "EC");
            jsonObject.addProperty("crv", str);
            jsonObject.addProperty("x", Base64.urlSafeEncode(parseFrom.getX().toByteArray()));
            jsonObject.addProperty("y", Base64.urlSafeEncode(parseFrom.getY().toByteArray()));
            jsonObject.addProperty("use", "sig");
            jsonObject.addProperty(JwsHeader.ALGORITHM, str2);
            JsonArray jsonArray = new JsonArray();
            jsonArray.add("verify");
            jsonObject.add("key_ops", jsonArray);
            Optional<String> kid = getKid(protoKeySerialization.getIdRequirementOrNull());
            if (Chip$$ExternalSyntheticApiModelOutline0.m((Optional) kid)) {
                jsonObject.addProperty(JwsHeader.KEY_ID, (String) Chip$$ExternalSyntheticApiModelOutline0.m((Optional) kid));
            } else if (parseFrom.hasCustomKid()) {
                jsonObject.addProperty(JwsHeader.KEY_ID, parseFrom.getCustomKid().getValue());
            }
            return jsonObject;
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("failed to parse value as JwtEcdsaPublicKey proto", e);
        }
    }

    private static JsonObject convertJwtRsaSsaPkcs1(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        String str;
        try {
            JwtRsaSsaPkcs1PublicKey parseFrom = JwtRsaSsaPkcs1PublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[parseFrom.getAlgorithm().ordinal()];
            if (i == 1) {
                str = "RS256";
            } else if (i == 2) {
                str = "RS384";
            } else if (i == 3) {
                str = "RS512";
            } else {
                throw new GeneralSecurityException("unknown algorithm");
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("kty", "RSA");
            jsonObject.addProperty(NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_TEXT, Base64.urlSafeEncode(parseFrom.getN().toByteArray()));
            jsonObject.addProperty("e", Base64.urlSafeEncode(parseFrom.getE().toByteArray()));
            jsonObject.addProperty("use", "sig");
            jsonObject.addProperty(JwsHeader.ALGORITHM, str);
            JsonArray jsonArray = new JsonArray();
            jsonArray.add("verify");
            jsonObject.add("key_ops", jsonArray);
            Optional<String> kid = getKid(protoKeySerialization.getIdRequirementOrNull());
            if (Chip$$ExternalSyntheticApiModelOutline0.m((Optional) kid)) {
                jsonObject.addProperty(JwsHeader.KEY_ID, (String) Chip$$ExternalSyntheticApiModelOutline0.m((Optional) kid));
            } else if (parseFrom.hasCustomKid()) {
                jsonObject.addProperty(JwsHeader.KEY_ID, parseFrom.getCustomKid().getValue());
            }
            return jsonObject;
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("failed to parse value as JwtRsaSsaPkcs1PublicKey proto", e);
        }
    }

    private static JsonObject convertJwtRsaSsaPss(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        String str;
        try {
            JwtRsaSsaPssPublicKey parseFrom = JwtRsaSsaPssPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[parseFrom.getAlgorithm().ordinal()];
            if (i == 1) {
                str = "PS256";
            } else if (i == 2) {
                str = "PS384";
            } else if (i == 3) {
                str = "PS512";
            } else {
                throw new GeneralSecurityException("unknown algorithm");
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("kty", "RSA");
            jsonObject.addProperty(NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_TEXT, Base64.urlSafeEncode(parseFrom.getN().toByteArray()));
            jsonObject.addProperty("e", Base64.urlSafeEncode(parseFrom.getE().toByteArray()));
            jsonObject.addProperty("use", "sig");
            jsonObject.addProperty(JwsHeader.ALGORITHM, str);
            JsonArray jsonArray = new JsonArray();
            jsonArray.add("verify");
            jsonObject.add("key_ops", jsonArray);
            Optional<String> kid = getKid(protoKeySerialization.getIdRequirementOrNull());
            if (Chip$$ExternalSyntheticApiModelOutline0.m((Optional) kid)) {
                jsonObject.addProperty(JwsHeader.KEY_ID, (String) Chip$$ExternalSyntheticApiModelOutline0.m((Optional) kid));
            } else if (parseFrom.hasCustomKid()) {
                jsonObject.addProperty(JwsHeader.KEY_ID, parseFrom.getCustomKid().getValue());
            }
            return jsonObject;
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("failed to parse value as JwtRsaSsaPssPublicKey proto", e);
        }
    }

    /* renamed from: com.google.crypto.tink.jwt.JwkSetConverter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|28) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0068 */
        static {
            /*
                com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm[] r0 = com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm = r0
                r1 = 1
                com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm r2 = com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm.PS256     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm r3 = com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm.PS384     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm r4 = com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm.PS512     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm[] r3 = com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm = r3
                com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm r4 = com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm.RS256     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r3 = $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm r4 = com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm.RS384     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm     // Catch:{ NoSuchFieldError -> 0x004d }
                com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm r4 = com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm.RS512     // Catch:{ NoSuchFieldError -> 0x004d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                com.google.crypto.tink.proto.JwtEcdsaAlgorithm[] r3 = com.google.crypto.tink.proto.JwtEcdsaAlgorithm.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm = r3
                com.google.crypto.tink.proto.JwtEcdsaAlgorithm r4 = com.google.crypto.tink.proto.JwtEcdsaAlgorithm.ES256     // Catch:{ NoSuchFieldError -> 0x005e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r1 = $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm     // Catch:{ NoSuchFieldError -> 0x0068 }
                com.google.crypto.tink.proto.JwtEcdsaAlgorithm r3 = com.google.crypto.tink.proto.JwtEcdsaAlgorithm.ES384     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm     // Catch:{ NoSuchFieldError -> 0x0072 }
                com.google.crypto.tink.proto.JwtEcdsaAlgorithm r1 = com.google.crypto.tink.proto.JwtEcdsaAlgorithm.ES512     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.jwt.JwkSetConverter.AnonymousClass1.<clinit>():void");
        }
    }

    private static String getStringItem(JsonObject jsonObject, String str) throws GeneralSecurityException {
        if (!jsonObject.has(str)) {
            throw new GeneralSecurityException(str + " not found");
        } else if (jsonObject.get(str).isJsonPrimitive() && jsonObject.get(str).getAsJsonPrimitive().isString()) {
            return jsonObject.get(str).getAsString();
        } else {
            throw new GeneralSecurityException(str + " is not a string");
        }
    }

    private static void expectStringItem(JsonObject jsonObject, String str, String str2) throws GeneralSecurityException {
        String stringItem = getStringItem(jsonObject, str);
        if (!stringItem.equals(str2)) {
            throw new GeneralSecurityException("unexpected " + str + " value: " + stringItem);
        }
    }

    private static void validateUseIsSig(JsonObject jsonObject) throws GeneralSecurityException {
        if (jsonObject.has("use")) {
            expectStringItem(jsonObject, "use", "sig");
        }
    }

    private static void validateKeyOpsIsVerify(JsonObject jsonObject) throws GeneralSecurityException {
        if (jsonObject.has("key_ops")) {
            if (jsonObject.get("key_ops").isJsonArray()) {
                JsonArray asJsonArray = jsonObject.get("key_ops").getAsJsonArray();
                if (asJsonArray.size() != 1) {
                    throw new GeneralSecurityException("key_ops must contain exactly one element");
                } else if (!asJsonArray.get(0).isJsonPrimitive() || !asJsonArray.get(0).getAsJsonPrimitive().isString()) {
                    throw new GeneralSecurityException("key_ops is not a string");
                } else if (!asJsonArray.get(0).getAsString().equals("verify")) {
                    throw new GeneralSecurityException("unexpected keyOps value: " + asJsonArray.get(0).getAsString());
                }
            } else {
                throw new GeneralSecurityException("key_ops is not an array");
            }
        }
    }

    private static ProtoKeySerialization convertToRsaSsaPkcs1Key(JsonObject jsonObject) throws GeneralSecurityException {
        JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm;
        String stringItem = getStringItem(jsonObject, JwsHeader.ALGORITHM);
        stringItem.hashCode();
        char c = 65535;
        switch (stringItem.hashCode()) {
            case 78251122:
                if (stringItem.equals("RS256")) {
                    c = 0;
                    break;
                }
                break;
            case 78252174:
                if (stringItem.equals("RS384")) {
                    c = 1;
                    break;
                }
                break;
            case 78253877:
                if (stringItem.equals("RS512")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS256;
                break;
            case 1:
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS384;
                break;
            case 2:
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jsonObject, JwsHeader.ALGORITHM));
        }
        if (jsonObject.has("p") || jsonObject.has("q") || jsonObject.has("dp") || jsonObject.has("dq") || jsonObject.has("d") || jsonObject.has("qi")) {
            throw new UnsupportedOperationException("importing RSA private keys is not implemented");
        }
        expectStringItem(jsonObject, "kty", "RSA");
        validateUseIsSig(jsonObject);
        validateKeyOpsIsVerify(jsonObject);
        JwtRsaSsaPkcs1PublicKey.Builder n = JwtRsaSsaPkcs1PublicKey.newBuilder().setVersion(0).setAlgorithm(jwtRsaSsaPkcs1Algorithm).setE(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonObject, "e")))).setN(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonObject, NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_TEXT))));
        if (jsonObject.has(JwsHeader.KEY_ID)) {
            n.setCustomKid((JwtRsaSsaPkcs1PublicKey.CustomKid) JwtRsaSsaPkcs1PublicKey.CustomKid.newBuilder().setValue(getStringItem(jsonObject, JwsHeader.KEY_ID)).build());
        }
        return ProtoKeySerialization.create(JWT_RSA_SSA_PKCS1_PUBLIC_KEY_URL, ((JwtRsaSsaPkcs1PublicKey) n.build()).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, (Integer) null);
    }

    private static ProtoKeySerialization convertToRsaSsaPssKey(JsonObject jsonObject) throws GeneralSecurityException {
        JwtRsaSsaPssAlgorithm jwtRsaSsaPssAlgorithm;
        String stringItem = getStringItem(jsonObject, JwsHeader.ALGORITHM);
        stringItem.hashCode();
        char c = 65535;
        switch (stringItem.hashCode()) {
            case 76404080:
                if (stringItem.equals("PS256")) {
                    c = 0;
                    break;
                }
                break;
            case 76405132:
                if (stringItem.equals("PS384")) {
                    c = 1;
                    break;
                }
                break;
            case 76406835:
                if (stringItem.equals("PS512")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS256;
                break;
            case 1:
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS384;
                break;
            case 2:
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jsonObject, JwsHeader.ALGORITHM));
        }
        if (jsonObject.has("p") || jsonObject.has("q") || jsonObject.has("dq") || jsonObject.has("dq") || jsonObject.has("d") || jsonObject.has("qi")) {
            throw new UnsupportedOperationException("importing RSA private keys is not implemented");
        }
        expectStringItem(jsonObject, "kty", "RSA");
        validateUseIsSig(jsonObject);
        validateKeyOpsIsVerify(jsonObject);
        JwtRsaSsaPssPublicKey.Builder n = JwtRsaSsaPssPublicKey.newBuilder().setVersion(0).setAlgorithm(jwtRsaSsaPssAlgorithm).setE(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonObject, "e")))).setN(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonObject, NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_TEXT))));
        if (jsonObject.has(JwsHeader.KEY_ID)) {
            n.setCustomKid((JwtRsaSsaPssPublicKey.CustomKid) JwtRsaSsaPssPublicKey.CustomKid.newBuilder().setValue(getStringItem(jsonObject, JwsHeader.KEY_ID)).build());
        }
        return ProtoKeySerialization.create(JWT_RSA_SSA_PSS_PUBLIC_KEY_URL, ((JwtRsaSsaPssPublicKey) n.build()).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, (Integer) null);
    }

    private static ProtoKeySerialization convertToEcdsaKey(JsonObject jsonObject) throws GeneralSecurityException {
        JwtEcdsaAlgorithm jwtEcdsaAlgorithm;
        String stringItem = getStringItem(jsonObject, JwsHeader.ALGORITHM);
        stringItem.hashCode();
        char c = 65535;
        switch (stringItem.hashCode()) {
            case 66245349:
                if (stringItem.equals("ES256")) {
                    c = 0;
                    break;
                }
                break;
            case 66246401:
                if (stringItem.equals("ES384")) {
                    c = 1;
                    break;
                }
                break;
            case 66248104:
                if (stringItem.equals("ES512")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                expectStringItem(jsonObject, "crv", "P-256");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES256;
                break;
            case 1:
                expectStringItem(jsonObject, "crv", "P-384");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES384;
                break;
            case 2:
                expectStringItem(jsonObject, "crv", "P-521");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Ecdsa Algorithm: " + getStringItem(jsonObject, JwsHeader.ALGORITHM));
        }
        if (!jsonObject.has("d")) {
            expectStringItem(jsonObject, "kty", "EC");
            validateUseIsSig(jsonObject);
            validateKeyOpsIsVerify(jsonObject);
            JwtEcdsaPublicKey.Builder y = JwtEcdsaPublicKey.newBuilder().setVersion(0).setAlgorithm(jwtEcdsaAlgorithm).setX(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonObject, "x")))).setY(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonObject, "y"))));
            if (jsonObject.has(JwsHeader.KEY_ID)) {
                y.setCustomKid((JwtEcdsaPublicKey.CustomKid) JwtEcdsaPublicKey.CustomKid.newBuilder().setValue(getStringItem(jsonObject, JwsHeader.KEY_ID)).build());
            }
            return ProtoKeySerialization.create(JWT_ECDSA_PUBLIC_KEY_URL, ((JwtEcdsaPublicKey) y.build()).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, (Integer) null);
        }
        throw new UnsupportedOperationException("importing ECDSA private keys is not implemented");
    }

    @Deprecated
    public static String fromKeysetHandle(KeysetHandle keysetHandle, KeyAccess keyAccess) throws IOException, GeneralSecurityException {
        return fromPublicKeysetHandle(keysetHandle);
    }

    @Deprecated
    public static KeysetHandle toKeysetHandle(String str, KeyAccess keyAccess) throws IOException, GeneralSecurityException {
        return toPublicKeysetHandle(str);
    }

    private JwkSetConverter() {
    }
}
