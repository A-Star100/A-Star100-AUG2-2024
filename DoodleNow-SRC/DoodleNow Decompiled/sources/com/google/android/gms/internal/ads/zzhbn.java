package com.google.android.gms.internal.ads;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzhbn {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zzhbl zzhbl, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzhbl, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb, i, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb, i, str, zzb2);
            }
        } else {
            sb.append(10);
            zzc(i, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i2 = 1; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzhcv.zza(zzgyj.zzw((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzgyj) {
                sb.append(": \"");
                sb.append(zzhcv.zza((zzgyj) obj));
                sb.append('\"');
            } else if (obj instanceof zzgzv) {
                sb.append(" {");
                zzd((zzgzv) obj, sb, i + 2);
                sb.append("\n");
                zzc(i, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                int i3 = i + 2;
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                zzb(sb, i3, SubscriberAttributeKt.JSON_NAME_KEY, entry.getKey());
                zzb(sb, i3, "value", entry.getValue());
                sb.append("\n");
                zzc(i, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    private static void zzd(zzhbl zzhbl, StringBuilder sb, int i) {
        int i2;
        boolean z;
        Method method;
        Method method2;
        zzhbl zzhbl2 = zzhbl;
        StringBuilder sb2 = sb;
        int i3 = i;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzhbl.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i4 = 0;
        while (true) {
            i2 = 3;
            if (i4 >= length) {
                break;
            }
            Method method3 = declaredMethods[i4];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith(b.ar)) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i4++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i2);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb2, i3, substring.substring(0, substring.length() - 4), zzgzv.zzbQ(method2, zzhbl2, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb2, i3, substring.substring(0, substring.length() - 3), zzgzv.zzbQ(method, zzhbl2, new Object[0]));
            } else if (hashSet.contains("set".concat(String.valueOf(substring))) && (!substring.endsWith("Bytes") || !treeMap.containsKey(b.ar.concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring)));
                if (method4 != null) {
                    Object zzbQ = zzgzv.zzbQ(method4, zzhbl2, new Object[0]);
                    if (method5 == null) {
                        if (zzbQ instanceof Boolean) {
                            if (!((Boolean) zzbQ).booleanValue()) {
                            }
                        } else if (zzbQ instanceof Integer) {
                            if (((Integer) zzbQ).intValue() == 0) {
                            }
                        } else if (zzbQ instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzbQ).floatValue()) == 0) {
                            }
                        } else if (!(zzbQ instanceof Double)) {
                            if (zzbQ instanceof String) {
                                z = zzbQ.equals("");
                            } else if (zzbQ instanceof zzgyj) {
                                z = zzbQ.equals(zzgyj.zzb);
                            } else if (zzbQ instanceof zzhbl) {
                                if (zzbQ == ((zzhbl) zzbQ).zzbt()) {
                                }
                            } else if ((zzbQ instanceof Enum) && ((Enum) zzbQ).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzbQ).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzgzv.zzbQ(method5, zzhbl2, new Object[0])).booleanValue()) {
                    }
                    zzb(sb2, i3, substring, zzbQ);
                }
            }
            i2 = 3;
        }
        if (zzhbl2 instanceof zzgzr) {
            Iterator zzg = ((zzgzr) zzhbl2).zza.zzg();
            while (zzg.hasNext()) {
                Map.Entry entry2 = (Map.Entry) zzg.next();
                zzb(sb2, i3, "[" + ((zzgzs) entry2.getKey()).zzb + "]", entry2.getValue());
            }
        }
        zzhcy zzhcy = ((zzgzv) zzhbl2).zzt;
        if (zzhcy != null) {
            zzhcy.zzi(sb2, i3);
        }
    }
}
