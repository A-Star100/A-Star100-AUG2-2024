package com.google.android.gms.internal.ads;

import java.util.Arrays;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzfwj {
    private final String zza;
    private final zzfwh zzb;
    private zzfwh zzc;

    /* synthetic */ zzfwj(String str, zzfwi zzfwi) {
        zzfwh zzfwh = new zzfwh();
        this.zzb = zzfwh;
        this.zzc = zzfwh;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        zzfwh zzfwh = this.zzb.zzb;
        String str = "";
        while (zzfwh != null) {
            Object obj = zzfwh.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append(deepToString, 1, deepToString.length() - 1);
            }
            zzfwh = zzfwh.zzb;
            str = ", ";
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    public final zzfwj zza(@CheckForNull Object obj) {
        zzfwh zzfwh = new zzfwh();
        this.zzc.zzb = zzfwh;
        this.zzc = zzfwh;
        zzfwh.zza = obj;
        return this;
    }
}
