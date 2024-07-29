package io.jsonwebtoken.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.DefaultJwtSigner;
import io.jsonwebtoken.impl.crypto.JwtSigner;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Strings;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

public class DefaultJwtBuilder implements JwtBuilder {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private SignatureAlgorithm algorithm;
    private Claims claims;
    private CompressionCodec compressionCodec;
    private Header header;
    private Key key;
    private byte[] keyBytes;
    private String payload;

    public JwtBuilder setClaims(Claims claims2) {
        this.claims = claims2;
        return this;
    }

    public JwtBuilder setHeader(Header header2) {
        this.header = header2;
        return this;
    }

    public JwtBuilder setPayload(String str) {
        this.payload = str;
        return this;
    }

    public JwtBuilder setHeader(Map<String, Object> map) {
        this.header = new DefaultHeader(map);
        return this;
    }

    public JwtBuilder setHeaderParams(Map<String, Object> map) {
        if (!Collections.isEmpty((Map) map)) {
            Header ensureHeader = ensureHeader();
            for (Map.Entry next : map.entrySet()) {
                ensureHeader.put(next.getKey(), next.getValue());
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public Header ensureHeader() {
        if (this.header == null) {
            this.header = new DefaultHeader();
        }
        return this.header;
    }

    public JwtBuilder setHeaderParam(String str, Object obj) {
        ensureHeader().put(str, obj);
        return this;
    }

    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, byte[] bArr) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        Assert.notEmpty(bArr, "secret key byte array cannot be null or empty.");
        Assert.isTrue(signatureAlgorithm.isHmac(), "Key bytes may only be specified for HMAC signatures.  If using RSA or Elliptic Curve, use the signWith(SignatureAlgorithm, Key) method instead.");
        this.algorithm = signatureAlgorithm;
        this.keyBytes = bArr;
        return this;
    }

    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, String str) {
        Assert.hasText(str, "base64-encoded secret key cannot be null or empty.");
        Assert.isTrue(signatureAlgorithm.isHmac(), "Base64-encoded key bytes may only be specified for HMAC signatures.  If using RSA or Elliptic Curve, use the signWith(SignatureAlgorithm, Key) method instead.");
        return signWith(signatureAlgorithm, TextCodec.BASE64.decode(str));
    }

    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, Key key2) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        Assert.notNull(key2, "Key argument cannot be null.");
        this.algorithm = signatureAlgorithm;
        this.key = key2;
        return this;
    }

    public JwtBuilder compressWith(CompressionCodec compressionCodec2) {
        Assert.notNull(compressionCodec2, "compressionCodec cannot be null");
        this.compressionCodec = compressionCodec2;
        return this;
    }

    /* access modifiers changed from: protected */
    public Claims ensureClaims() {
        if (this.claims == null) {
            this.claims = new DefaultClaims();
        }
        return this.claims;
    }

    public JwtBuilder setClaims(Map<String, Object> map) {
        this.claims = Jwts.claims(map);
        return this;
    }

    public JwtBuilder addClaims(Map<String, Object> map) {
        ensureClaims().putAll(map);
        return this;
    }

    public JwtBuilder setIssuer(String str) {
        if (Strings.hasText(str)) {
            ensureClaims().setIssuer(str);
        } else {
            Claims claims2 = this.claims;
            if (claims2 != null) {
                claims2.setIssuer(str);
            }
        }
        return this;
    }

    public JwtBuilder setSubject(String str) {
        if (Strings.hasText(str)) {
            ensureClaims().setSubject(str);
        } else {
            Claims claims2 = this.claims;
            if (claims2 != null) {
                claims2.setSubject(str);
            }
        }
        return this;
    }

    public JwtBuilder setAudience(String str) {
        if (Strings.hasText(str)) {
            ensureClaims().setAudience(str);
        } else {
            Claims claims2 = this.claims;
            if (claims2 != null) {
                claims2.setAudience(str);
            }
        }
        return this;
    }

    public JwtBuilder setExpiration(Date date) {
        if (date != null) {
            ensureClaims().setExpiration(date);
        } else {
            Claims claims2 = this.claims;
            if (claims2 != null) {
                claims2.setExpiration(date);
            }
        }
        return this;
    }

    public JwtBuilder setNotBefore(Date date) {
        if (date != null) {
            ensureClaims().setNotBefore(date);
        } else {
            Claims claims2 = this.claims;
            if (claims2 != null) {
                claims2.setNotBefore(date);
            }
        }
        return this;
    }

    public JwtBuilder setIssuedAt(Date date) {
        if (date != null) {
            ensureClaims().setIssuedAt(date);
        } else {
            Claims claims2 = this.claims;
            if (claims2 != null) {
                claims2.setIssuedAt(date);
            }
        }
        return this;
    }

    public JwtBuilder setId(String str) {
        if (Strings.hasText(str)) {
            ensureClaims().setId(str);
        } else {
            Claims claims2 = this.claims;
            if (claims2 != null) {
                claims2.setId(str);
            }
        }
        return this;
    }

    public JwtBuilder claim(String str, Object obj) {
        Assert.hasText(str, "Claim property name cannot be null or empty.");
        Claims claims2 = this.claims;
        if (claims2 == null) {
            if (obj != null) {
                ensureClaims().put(str, obj);
            }
        } else if (obj == null) {
            claims2.remove(str);
        } else {
            claims2.put(str, obj);
        }
        return this;
    }

    public String compact() {
        JwsHeader jwsHeader;
        String str;
        if (this.payload == null && Collections.isEmpty((Map) this.claims)) {
            throw new IllegalStateException("Either 'payload' or 'claims' must be specified.");
        } else if (this.payload != null && !Collections.isEmpty((Map) this.claims)) {
            throw new IllegalStateException("Both 'payload' and 'claims' cannot both be specified. Choose either one.");
        } else if (this.key == null || this.keyBytes == null) {
            Header ensureHeader = ensureHeader();
            Key key2 = this.key;
            if (key2 == null && !Objects.isEmpty(this.keyBytes)) {
                key2 = new SecretKeySpec(this.keyBytes, this.algorithm.getJcaName());
            }
            if (ensureHeader instanceof JwsHeader) {
                jwsHeader = (JwsHeader) ensureHeader;
            } else {
                jwsHeader = new DefaultJwsHeader(ensureHeader);
            }
            if (key2 != null) {
                jwsHeader.setAlgorithm(this.algorithm.getValue());
            } else {
                jwsHeader.setAlgorithm(SignatureAlgorithm.NONE.getValue());
            }
            CompressionCodec compressionCodec2 = this.compressionCodec;
            if (compressionCodec2 != null) {
                jwsHeader.setCompressionAlgorithm(compressionCodec2.getAlgorithmName());
            }
            String base64UrlEncode = base64UrlEncode(jwsHeader, "Unable to serialize header to json.");
            if (this.compressionCodec != null) {
                try {
                    String str2 = this.payload;
                    str = TextCodec.BASE64URL.encode(this.compressionCodec.compress(str2 != null ? str2.getBytes(Strings.UTF_8) : toJson(this.claims)));
                } catch (JsonProcessingException unused) {
                    throw new IllegalArgumentException("Unable to serialize claims object to json.");
                }
            } else if (this.payload != null) {
                str = TextCodec.BASE64URL.encode(this.payload);
            } else {
                str = base64UrlEncode(this.claims, "Unable to serialize claims object to json.");
            }
            String str3 = base64UrlEncode + '.' + str;
            if (key2 != null) {
                return str3 + '.' + createSigner(this.algorithm, key2).sign(str3);
            }
            return str3 + '.';
        } else {
            throw new IllegalStateException("A key object and key bytes cannot both be specified. Choose either one.");
        }
    }

    /* access modifiers changed from: protected */
    public JwtSigner createSigner(SignatureAlgorithm signatureAlgorithm, Key key2) {
        return new DefaultJwtSigner(signatureAlgorithm, key2);
    }

    /* access modifiers changed from: protected */
    public String base64UrlEncode(Object obj, String str) {
        try {
            return TextCodec.BASE64URL.encode(toJson(obj));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(str, e);
        }
    }

    /* access modifiers changed from: protected */
    public byte[] toJson(Object obj) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsBytes(obj);
    }
}
