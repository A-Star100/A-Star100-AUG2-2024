package com.zaguiini.RNPureJwt;

import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.DefaultClaims;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

public class RNPureJwtModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "RNPureJwt";
    }

    public RNPureJwtModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private String toBase64(String str) {
        return Base64.encodeToString(str.getBytes(Charset.forName("UTF-8")), 0);
    }

    private String base64toString(String str) {
        return new String(Base64.decode(str, 0));
    }

    private void getResponse(String str, Promise promise) {
        ObjectMapper objectMapper = new ObjectMapper();
        WritableMap createMap = Arguments.createMap();
        String[] split = str.split(Pattern.quote("."));
        try {
            createMap.putMap("headers", Arguments.makeNativeMap((Map<String, Object>) (Map) objectMapper.readValue(base64toString(split[0]), (TypeReference) new TypeReference<Map<String, Object>>() {
            })));
        } catch (IOException unused) {
            promise.reject("7", "Invalid header");
        }
        try {
            createMap.putMap("payload", Arguments.makeNativeMap((Map<String, Object>) (Map) objectMapper.readValue(base64toString(split[1]), (TypeReference) new TypeReference<Map<String, Object>>() {
            })));
        } catch (IOException unused2) {
            promise.reject("8", "Invalid payload");
        }
        promise.resolve(createMap);
    }

    private void getResponse(Jwt jwt, Promise promise) {
        ObjectMapper objectMapper = new ObjectMapper();
        WritableMap createMap = Arguments.createMap();
        createMap.putMap("headers", Arguments.makeNativeMap((Map<String, Object>) (Map) objectMapper.convertValue((Object) jwt.getHeader(), DefaultClaims.class)));
        createMap.putMap("payload", Arguments.makeNativeMap((Map<String, Object>) (Map) objectMapper.convertValue(jwt.getBody(), DefaultClaims.class)));
        promise.resolve(createMap);
    }

    @ReactMethod
    public void decode(String str, String str2, ReadableMap readableMap, Promise promise) {
        JwtParser signingKey = Jwts.parser().setSigningKey(toBase64(str2));
        Boolean bool = false;
        for (Map.Entry next : readableMap.toHashMap().entrySet()) {
            String str3 = (String) next.getKey();
            Object value = next.getValue();
            str3.hashCode();
            if (str3.equals("skipValidation")) {
                bool = Boolean.valueOf(((Boolean) value).booleanValue());
            }
        }
        try {
            getResponse(signingKey.parse(str), promise);
        } catch (MalformedJwtException unused) {
            if (bool.booleanValue()) {
                getResponse(str, promise);
            } else {
                promise.reject(ExifInterface.GPS_MEASUREMENT_2D, "The JWT is invalid.");
            }
        } catch (ExpiredJwtException unused2) {
            if (bool.booleanValue()) {
                getResponse(str, promise);
            } else {
                promise.reject(ExifInterface.GPS_MEASUREMENT_3D, "The JWT is expired.");
            }
        } catch (SignatureException unused3) {
            if (bool.booleanValue()) {
                getResponse(str, promise);
            } else {
                promise.reject("6", "Invalid signature.");
            }
        } catch (Exception e) {
            promise.reject(SessionDescription.SUPPORTED_SDP_VERSION, (Throwable) e);
        }
    }

    @ReactMethod
    public void sign(ReadableMap readableMap, String str, ReadableMap readableMap2, Promise promise) {
        String string = readableMap2.hasKey(JwsHeader.ALGORITHM) ? readableMap2.getString(JwsHeader.ALGORITHM) : "HS256";
        JwtBuilder headerParam = Jwts.builder().signWith(SignatureAlgorithm.forName(string), toBase64(str)).setHeaderParam(JwsHeader.ALGORITHM, string).setHeaderParam("typ", Header.JWT_TYPE);
        for (Map.Entry next : readableMap.toHashMap().entrySet()) {
            String str2 = (String) next.getKey();
            Object value = next.getValue();
            str2.hashCode();
            char c = 65535;
            switch (str2.hashCode()) {
                case 96668:
                    if (str2.equals(JwsHeader.ALGORITHM)) {
                        c = 0;
                        break;
                    }
                    break;
                case 96944:
                    if (str2.equals(Claims.AUDIENCE)) {
                        c = 1;
                        break;
                    }
                    break;
                case 100893:
                    if (str2.equals(Claims.EXPIRATION)) {
                        c = 2;
                        break;
                    }
                    break;
                case 104028:
                    if (str2.equals(Claims.ISSUED_AT)) {
                        c = 3;
                        break;
                    }
                    break;
                case 104585:
                    if (str2.equals(Claims.ISSUER)) {
                        c = 4;
                        break;
                    }
                    break;
                case 105567:
                    if (str2.equals(Claims.ID)) {
                        c = 5;
                        break;
                    }
                    break;
                case 108850:
                    if (str2.equals(Claims.NOT_BEFORE)) {
                        c = 6;
                        break;
                    }
                    break;
                case 114240:
                    if (str2.equals(Claims.SUBJECT)) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    break;
                case 1:
                    headerParam.setAudience(value.toString());
                    break;
                case 2:
                    headerParam.setExpiration(new Date(Double.valueOf(((Double) value).doubleValue()).longValue()));
                    break;
                case 3:
                    headerParam.setIssuedAt(new Date(Double.valueOf(((Double) value).doubleValue()).longValue()));
                    break;
                case 4:
                    headerParam.setIssuer(value.toString());
                    break;
                case 5:
                    headerParam.setId(value.toString());
                    break;
                case 6:
                    headerParam.setNotBefore(new Date(Double.valueOf(((Double) value).doubleValue()).longValue()));
                    break;
                case 7:
                    headerParam.setSubject(value.toString());
                    break;
                default:
                    headerParam.claim(str2, value);
                    break;
            }
        }
        promise.resolve(headerParam.compact());
    }
}
