package io.jsonwebtoken;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public interface JwtBuilder extends ClaimsMutator<JwtBuilder> {
    JwtBuilder addClaims(Map<String, Object> map);

    JwtBuilder claim(String str, Object obj);

    String compact();

    JwtBuilder compressWith(CompressionCodec compressionCodec);

    JwtBuilder setAudience(String str);

    JwtBuilder setClaims(Claims claims);

    JwtBuilder setClaims(Map<String, Object> map);

    JwtBuilder setExpiration(Date date);

    JwtBuilder setHeader(Header header);

    JwtBuilder setHeader(Map<String, Object> map);

    JwtBuilder setHeaderParam(String str, Object obj);

    JwtBuilder setHeaderParams(Map<String, Object> map);

    JwtBuilder setId(String str);

    JwtBuilder setIssuedAt(Date date);

    JwtBuilder setIssuer(String str);

    JwtBuilder setNotBefore(Date date);

    JwtBuilder setPayload(String str);

    JwtBuilder setSubject(String str);

    JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, String str);

    JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, Key key);

    JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, byte[] bArr);
}
