package redis.clients.jedis;

public class Module {
    private String name;
    private int version;

    public Module(String name2, int version2) {
        this.name = name2;
        this.version = version2;
    }

    public String getName() {
        return this.name;
    }

    public int getVersion() {
        return this.version;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r5 != r6) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r6 == 0) goto L_0x002f
            java.lang.Class r2 = r5.getClass()
            java.lang.Class r3 = r6.getClass()
            if (r2 == r3) goto L_0x0012
            goto L_0x002f
        L_0x0012:
            r2 = r6
            redis.clients.jedis.Module r2 = (redis.clients.jedis.Module) r2
            int r3 = r5.version
            int r4 = r2.version
            if (r3 == r4) goto L_0x001c
            return r1
        L_0x001c:
            java.lang.String r3 = r5.name
            if (r3 == 0) goto L_0x0029
            java.lang.String r4 = r2.name
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0029:
            java.lang.String r3 = r2.name
            if (r3 == 0) goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            return r0
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: redis.clients.jedis.Module.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.name;
        return ((str != null ? str.hashCode() : 0) * 31) + this.version;
    }
}
