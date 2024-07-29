package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaiy extends zzaja {
    public final long zza;
    public final List zzb = new ArrayList();
    public final List zzc = new ArrayList();

    public zzaiy(int i, long j) {
        super(i);
        this.zza = j;
    }

    public final String toString() {
        List list = this.zzb;
        String zzf = zzf(this.zzd);
        String arrays = Arrays.toString(list.toArray());
        String arrays2 = Arrays.toString(this.zzc.toArray());
        return zzf + " leaves: " + arrays + " containers: " + arrays2;
    }

    public final zzaiy zza(int i) {
        int size = this.zzc.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzaiy zzaiy = (zzaiy) this.zzc.get(i2);
            if (zzaiy.zzd == i) {
                return zzaiy;
            }
        }
        return null;
    }

    public final zzaiz zzb(int i) {
        int size = this.zzb.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzaiz zzaiz = (zzaiz) this.zzb.get(i2);
            if (zzaiz.zzd == i) {
                return zzaiz;
            }
        }
        return null;
    }

    public final void zzc(zzaiy zzaiy) {
        this.zzc.add(zzaiy);
    }

    public final void zzd(zzaiz zzaiz) {
        this.zzb.add(zzaiz);
    }
}
