package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public enum zzgzl {
    DOUBLE(0, 1, zzham.DOUBLE),
    FLOAT(1, 1, zzham.FLOAT),
    INT64(2, 1, zzham.LONG),
    UINT64(3, 1, zzham.LONG),
    INT32(4, 1, zzham.INT),
    FIXED64(5, 1, zzham.LONG),
    FIXED32(6, 1, zzham.INT),
    BOOL(7, 1, zzham.BOOLEAN),
    STRING(8, 1, zzham.STRING),
    MESSAGE(9, 1, zzham.MESSAGE),
    BYTES(10, 1, zzham.BYTE_STRING),
    UINT32(11, 1, zzham.INT),
    ENUM(12, 1, zzham.ENUM),
    SFIXED32(13, 1, zzham.INT),
    SFIXED64(14, 1, zzham.LONG),
    SINT32(15, 1, zzham.INT),
    SINT64(16, 1, zzham.LONG),
    GROUP(17, 1, zzham.MESSAGE),
    DOUBLE_LIST(18, 2, zzham.DOUBLE),
    FLOAT_LIST(19, 2, zzham.FLOAT),
    INT64_LIST(20, 2, zzham.LONG),
    UINT64_LIST(21, 2, zzham.LONG),
    INT32_LIST(22, 2, zzham.INT),
    FIXED64_LIST(23, 2, zzham.LONG),
    FIXED32_LIST(24, 2, zzham.INT),
    BOOL_LIST(25, 2, zzham.BOOLEAN),
    STRING_LIST(26, 2, zzham.STRING),
    MESSAGE_LIST(27, 2, zzham.MESSAGE),
    BYTES_LIST(28, 2, zzham.BYTE_STRING),
    UINT32_LIST(29, 2, zzham.INT),
    ENUM_LIST(30, 2, zzham.ENUM),
    SFIXED32_LIST(31, 2, zzham.INT),
    SFIXED64_LIST(32, 2, zzham.LONG),
    SINT32_LIST(33, 2, zzham.INT),
    SINT64_LIST(34, 2, zzham.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzham.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzham.FLOAT),
    INT64_LIST_PACKED(37, 3, zzham.LONG),
    UINT64_LIST_PACKED(38, 3, zzham.LONG),
    INT32_LIST_PACKED(39, 3, zzham.INT),
    FIXED64_LIST_PACKED(40, 3, zzham.LONG),
    FIXED32_LIST_PACKED(41, 3, zzham.INT),
    BOOL_LIST_PACKED(42, 3, zzham.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzham.INT),
    ENUM_LIST_PACKED(44, 3, zzham.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzham.INT),
    SFIXED64_LIST_PACKED(46, 3, zzham.LONG),
    SINT32_LIST_PACKED(47, 3, zzham.INT),
    SINT64_LIST_PACKED(48, 3, zzham.LONG),
    GROUP_LIST(49, 2, zzham.MESSAGE),
    MAP(50, 4, zzham.VOID);
    
    private static final zzgzl[] zzZ = null;
    private final zzham zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzZ = new zzgzl[r1];
        for (zzgzl zzgzl : values()) {
            zzZ[zzgzl.zzac] = zzgzl;
        }
    }

    private zzgzl(int i, int i2, zzham zzham) {
        this.zzac = i;
        this.zzab = zzham;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzad = zzham.zza();
        } else if (i3 != 3) {
            this.zzad = null;
        } else {
            this.zzad = zzham.zza();
        }
        if (i2 == 1) {
            zzham zzham2 = zzham.VOID;
            zzham.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
