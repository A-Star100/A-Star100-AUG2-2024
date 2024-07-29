package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.RequiredTypeException;
import java.util.Date;
import java.util.Map;

public class DefaultClaims extends JwtMap implements Claims {
    public DefaultClaims() {
    }

    public DefaultClaims(Map<String, Object> map) {
        super(map);
    }

    public String getIssuer() {
        return getString(Claims.ISSUER);
    }

    public Claims setIssuer(String str) {
        setValue(Claims.ISSUER, str);
        return this;
    }

    public String getSubject() {
        return getString(Claims.SUBJECT);
    }

    public Claims setSubject(String str) {
        setValue(Claims.SUBJECT, str);
        return this;
    }

    public String getAudience() {
        return getString(Claims.AUDIENCE);
    }

    public Claims setAudience(String str) {
        setValue(Claims.AUDIENCE, str);
        return this;
    }

    public Date getExpiration() {
        return (Date) get(Claims.EXPIRATION, Date.class);
    }

    public Claims setExpiration(Date date) {
        setDate(Claims.EXPIRATION, date);
        return this;
    }

    public Date getNotBefore() {
        return (Date) get(Claims.NOT_BEFORE, Date.class);
    }

    public Claims setNotBefore(Date date) {
        setDate(Claims.NOT_BEFORE, date);
        return this;
    }

    public Date getIssuedAt() {
        return (Date) get(Claims.ISSUED_AT, Date.class);
    }

    public Claims setIssuedAt(Date date) {
        setDate(Claims.ISSUED_AT, date);
        return this;
    }

    public String getId() {
        return getString(Claims.ID);
    }

    public Claims setId(String str) {
        setValue(Claims.ID, str);
        return this;
    }

    public <T> T get(String str, Class<T> cls) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        if (Claims.EXPIRATION.equals(str) || Claims.ISSUED_AT.equals(str) || Claims.NOT_BEFORE.equals(str)) {
            obj = getDate(str);
        }
        return castClaimValue(obj, cls);
    }

    private <T> T castClaimValue(Object obj, Class<T> cls) {
        if (cls == Date.class && (obj instanceof Long)) {
            obj = new Date(((Long) obj).longValue());
        }
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (cls == Long.class) {
                obj = Long.valueOf((long) intValue);
            } else if (cls == Short.class && -32768 <= intValue && intValue <= 32767) {
                obj = Short.valueOf((short) intValue);
            } else if (cls == Byte.class && -128 <= intValue && intValue <= 127) {
                obj = Byte.valueOf((byte) intValue);
            }
        }
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        throw new RequiredTypeException("Expected value to be of type: " + cls + ", but was " + obj.getClass());
    }
}
