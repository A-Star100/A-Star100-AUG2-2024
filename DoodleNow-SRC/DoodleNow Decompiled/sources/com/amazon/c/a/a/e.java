package com.amazon.c.a.a;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/* compiled from: SignatureInfo */
public class e {
    private static final String a = String.format("A valid instance of %s is required to have at least one non-blank ID, either developerId or certificateId, and at least one non-blank name, either developerName or commonName.", new Object[]{"e"});
    private static final String b = String.format("A valid instance of %s is required to have a certificate ID.", new Object[]{"e"});
    private String c;
    private String d;
    private String e;
    private String f;

    public static String a() {
        return a;
    }

    public static String b() {
        return b;
    }

    public e a(String str) {
        this.c = str;
        return this;
    }

    public void b(String str) {
        this.c = str;
    }

    public e c(String str) {
        this.d = str;
        return this;
    }

    public void d(String str) {
        this.d = str;
    }

    public e e(String str) {
        this.e = str;
        return this;
    }

    public void f(String str) {
        this.e = str;
    }

    public e g(String str) {
        this.f = str;
        return this;
    }

    public String g() {
        return this.c;
    }

    public String h() {
        return this.d;
    }

    public void h(String str) {
        this.f = str;
    }

    public String i() {
        return this.e;
    }

    public String j() {
        return this.f;
    }

    public boolean c() {
        return !StringUtils.isBlank(e()) && !StringUtils.isBlank(f());
    }

    public boolean d() {
        return !StringUtils.isBlank(e());
    }

    public String e() {
        return StringUtils.isBlank(this.e) ? this.c : this.e;
    }

    public String f() {
        return StringUtils.isBlank(this.f) ? this.d : this.f;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return new EqualsBuilder().append((Object) this.e, (Object) eVar.e).append((Object) this.f, (Object) eVar.f).append((Object) this.c, (Object) eVar.c).append((Object) this.d, (Object) eVar.d).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append((Object) this.e).append((Object) this.f).append((Object) this.c).append((Object) this.d).toHashCode();
    }
}
