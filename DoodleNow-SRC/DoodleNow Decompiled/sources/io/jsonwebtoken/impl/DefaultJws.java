package io.jsonwebtoken.impl;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;

public class DefaultJws<B> implements Jws<B> {
    private final B body;
    private final JwsHeader header;
    private final String signature;

    public B getBody() {
        return this.body;
    }

    public JwsHeader getHeader() {
        return this.header;
    }

    public String getSignature() {
        return this.signature;
    }

    public DefaultJws(JwsHeader jwsHeader, B b, String str) {
        this.header = jwsHeader;
        this.body = b;
        this.signature = str;
    }

    public String toString() {
        return "header=" + this.header + ",body=" + this.body + ",signature=" + this.signature;
    }
}
