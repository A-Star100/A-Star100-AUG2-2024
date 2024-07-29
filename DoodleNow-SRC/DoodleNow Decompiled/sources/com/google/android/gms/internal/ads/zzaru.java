package com.google.android.gms.internal.ads;

import com.amazon.a.a.o.b.f;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzaru extends zzaqq {
    private final Object zza = new Object();
    private final zzaqv zzb;

    public zzaru(int i, String str, zzaqv zzaqv, zzaqu zzaqu) {
        super(i, str, zzaqu);
        this.zzb = zzaqv;
    }

    /* access modifiers changed from: protected */
    public final zzaqw zzh(zzaqm zzaqm) {
        String str;
        try {
            byte[] bArr = zzaqm.zzb;
            Map map = zzaqm.zzc;
            String str2 = "ISO-8859-1";
            if (map != null) {
                String str3 = (String) map.get("Content-Type");
                if (str3 != null) {
                    String[] split = str3.split(";", 0);
                    int i = 1;
                    while (true) {
                        if (i >= split.length) {
                            break;
                        }
                        String[] split2 = split[i].trim().split(f.b, 0);
                        if (split2.length == 2 && split2[0].equals("charset")) {
                            str2 = split2[1];
                            break;
                        }
                        i++;
                    }
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzaqm.zzb);
        }
        return zzaqw.zzb(str, zzarn.zzb(zzaqm));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzz */
    public void zzo(String str) {
        zzaqv zzaqv;
        synchronized (this.zza) {
            zzaqv = this.zzb;
        }
        zzaqv.zza(str);
    }
}
