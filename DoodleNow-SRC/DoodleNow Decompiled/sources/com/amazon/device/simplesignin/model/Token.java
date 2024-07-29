package com.amazon.device.simplesignin.model;

public class Token {
    private String schema;
    private String token;

    public String getSchema() {
        return this.schema;
    }

    public String getToken() {
        return this.token;
    }

    public void setSchema(String str) {
        this.schema = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof Token;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Token)) {
            return false;
        }
        Token token2 = (Token) obj;
        if (!token2.canEqual(this)) {
            return false;
        }
        String token3 = getToken();
        String token4 = token2.getToken();
        if (token3 != null ? !token3.equals(token4) : token4 != null) {
            return false;
        }
        String schema2 = getSchema();
        String schema3 = token2.getSchema();
        return schema2 != null ? schema2.equals(schema3) : schema3 == null;
    }

    public int hashCode() {
        String token2 = getToken();
        int i = 43;
        int hashCode = token2 == null ? 43 : token2.hashCode();
        String schema2 = getSchema();
        int i2 = (hashCode + 59) * 59;
        if (schema2 != null) {
            i = schema2.hashCode();
        }
        return i2 + i;
    }
}
