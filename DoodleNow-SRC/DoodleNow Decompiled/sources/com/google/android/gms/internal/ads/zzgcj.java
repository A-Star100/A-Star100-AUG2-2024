package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.HttpUrl;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgcj implements Serializable {
    private static final zzgcj zza = new zzgcj(new int[0], 0, 0);
    private final int[] zzb;
    private final int zzc;

    private zzgcj(int[] iArr, int i, int i2) {
        this.zzb = iArr;
        this.zzc = i2;
    }

    public static zzgcj zzb(int[] iArr) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        return new zzgcj(copyOf, 0, copyOf.length);
    }

    public static zzgcj zzc() {
        return zza;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgcj)) {
            return false;
        }
        zzgcj zzgcj = (zzgcj) obj;
        if (this.zzc != zzgcj.zzc) {
            return false;
        }
        for (int i = 0; i < this.zzc; i++) {
            if (zza(i) != zzgcj.zza(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            i = (i * 31) + this.zzb[i2];
        }
        return i;
    }

    public final String toString() {
        int i = this.zzc;
        if (i == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(i * 5);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb.append(this.zzb[0]);
        for (int i2 = 1; i2 < this.zzc; i2++) {
            sb.append(", ");
            sb.append(this.zzb[i2]);
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public final int zza(int i) {
        zzfwr.zza(i, this.zzc, "index");
        return this.zzb[i];
    }
}
