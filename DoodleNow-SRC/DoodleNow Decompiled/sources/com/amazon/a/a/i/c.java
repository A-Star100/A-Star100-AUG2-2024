package com.amazon.a.a.i;

/* compiled from: PromptContent */
public class c {
    private final String a;
    private final String b;
    private final String c;
    private final String[] d;
    private final a[] e;
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;

    /* compiled from: PromptContent */
    public enum a {
        DEFAULT,
        HELP,
        DEEPLINK
    }

    public String[] b() {
        return this.d;
    }

    public a[] c() {
        return this.e;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.b;
    }

    public String f() {
        return this.a;
    }

    public int g() {
        return this.i;
    }

    public boolean h() {
        return this.f;
    }

    public boolean i() {
        return this.g;
    }

    public c(String str, String str2, String str3, boolean z) {
        this(str, str2, str3, z, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(java.lang.String r9, java.lang.String r10, java.lang.String r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            java.lang.String[] r3 = new java.lang.String[]{r11}
            r11 = 1
            com.amazon.a.a.i.c$a[] r4 = new com.amazon.a.a.i.c.a[r11]
            r11 = 0
            com.amazon.a.a.i.c$a r0 = com.amazon.a.a.i.c.a.DEFAULT
            r4[r11] = r0
            r7 = 0
            r0 = r8
            r1 = r9
            r2 = r10
            r5 = r12
            r6 = r13
            r0.<init>((java.lang.String) r1, (java.lang.String) r2, (java.lang.String[]) r3, (com.amazon.a.a.i.c.a[]) r4, (boolean) r5, (boolean) r6, (int) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.a.a.i.c.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    public c(String str, String str2, String[] strArr, a[] aVarArr, boolean z, boolean z2, int i2) {
        this(new String[]{str}, str2, strArr, aVarArr, z, z2, i2);
    }

    public c(String[] strArr, String str, String[] strArr2, a[] aVarArr, boolean z, boolean z2, int i2) {
        this(strArr, str, strArr2, aVarArr, z, z2, i2, -1);
    }

    public c(String[] strArr, String str, String[] strArr2, a[] aVarArr, boolean z, boolean z2, int i2, int i3) {
        String str2 = strArr[0];
        this.a = str2;
        if (strArr.length > 1) {
            this.b = strArr[1];
        } else {
            this.b = str2;
        }
        this.c = str;
        this.d = strArr2;
        this.e = aVarArr;
        this.f = z;
        this.g = z2;
        this.h = i2;
        this.i = i3;
    }

    public String a() {
        return this.d[this.h];
    }

    public String toString() {
        return "PromptContent: [ title:" + this.a + ", message: " + this.c + ", label: " + this.d[0] + ", visible: " + this.f + ", shouldShowFixup: " + this.g + "]";
    }
}
