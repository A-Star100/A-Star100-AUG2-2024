package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfqv {
    public static boolean zza(zzazh zzazh) {
        zzazh zzazh2 = zzazh.UNSUPPORTED;
        int ordinal = zzazh.ordinal();
        return ordinal == 1 || ordinal == 2 || ordinal == 3 || ordinal == 4 || ordinal == 5;
    }

    public static final zzazh zzb(Context context, zzfpp zzfpp) {
        zzazh zzazh;
        FileInputStream fileInputStream;
        File file = new File(new File(context.getApplicationInfo().dataDir), "lib");
        if (!file.exists()) {
            zzfpp.zzb(5017, "No lib/");
            zzazh = zzazh.UNKNOWN;
        } else {
            File[] listFiles = file.listFiles(new zzgby(Pattern.compile(".*\\.so$", 2)));
            if (listFiles == null || listFiles.length == 0) {
                zzfpp.zzb(5017, "No .so");
                zzazh = zzazh.UNKNOWN;
            } else {
                try {
                    fileInputStream = new FileInputStream(listFiles[0]);
                    byte[] bArr = new byte[20];
                    if (fileInputStream.read(bArr) == 20) {
                        byte[] bArr2 = {0, 0};
                        if (bArr[5] == 2) {
                            zzd(bArr, (String) null, context, zzfpp);
                            zzazh = zzazh.UNSUPPORTED;
                        } else {
                            bArr2[0] = bArr[19];
                            bArr2[1] = bArr[18];
                            short s = ByteBuffer.wrap(bArr2).getShort();
                            if (s == 3) {
                                zzazh = zzazh.X86;
                            } else if (s == 40) {
                                zzazh = zzazh.ARM7;
                            } else if (s == 62) {
                                zzazh = zzazh.X86_64;
                            } else if (s == 183) {
                                zzazh = zzazh.ARM64;
                            } else if (s != 243) {
                                zzd(bArr, (String) null, context, zzfpp);
                                zzazh = zzazh.UNSUPPORTED;
                            } else {
                                zzazh = zzazh.RISCV64;
                            }
                        }
                        fileInputStream.close();
                    } else {
                        fileInputStream.close();
                        zzazh = zzazh.UNSUPPORTED;
                    }
                } catch (IOException e) {
                    zzd((byte[]) null, e.toString(), context, zzfpp);
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
        }
        if (zzazh == zzazh.UNKNOWN) {
            String zzc = zzc(context, zzfpp);
            if (TextUtils.isEmpty(zzc)) {
                zzd((byte[]) null, "Empty dev arch", context, zzfpp);
                zzazh = zzazh.UNSUPPORTED;
            } else if (zzc.equalsIgnoreCase("i686") || zzc.equalsIgnoreCase("x86")) {
                zzazh = zzazh.X86;
            } else if (zzc.equalsIgnoreCase("x86_64")) {
                zzazh = zzazh.X86_64;
            } else if (zzc.equalsIgnoreCase("arm64-v8a")) {
                zzazh = zzazh.ARM64;
            } else if (zzc.equalsIgnoreCase("armeabi-v7a") || zzc.equalsIgnoreCase("armv71")) {
                zzazh = zzazh.ARM7;
            } else if (zzc.equalsIgnoreCase("riscv64")) {
                zzazh = zzazh.RISCV64;
            } else {
                zzd((byte[]) null, zzc, context, zzfpp);
                zzazh = zzazh.UNSUPPORTED;
            }
        }
        zzfpp.zzb(5018, zzazh.name());
        return zzazh;
        throw th;
    }

    private static final String zzc(Context context, zzfpp zzfpp) {
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"i686", "armv71"}));
        String zza = zzfxf.OS_ARCH.zza();
        if (!TextUtils.isEmpty(zza) && hashSet.contains(zza)) {
            return zza;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (NoSuchFieldException e) {
            zzfpp.zzc(2024, 0, e);
        } catch (IllegalAccessException e2) {
            zzfpp.zzc(2024, 0, e2);
        }
        return Build.CPU_ABI != null ? Build.CPU_ABI : Build.CPU_ABI2;
    }

    private static final void zzd(byte[] bArr, String str, Context context, zzfpp zzfpp) {
        StringBuilder sb = new StringBuilder("os.arch:");
        sb.append(zzfxf.OS_ARCH.zza());
        sb.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null) {
                sb.append("supported_abis:");
                sb.append(Arrays.toString(strArr));
                sb.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(";CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(";");
        if (bArr != null) {
            sb.append("ELF:");
            sb.append(Arrays.toString(bArr));
            sb.append(";");
        }
        if (str != null) {
            sb.append("dbg:");
            sb.append(str);
            sb.append(";");
        }
        zzfpp.zzb(4007, sb.toString());
    }
}
