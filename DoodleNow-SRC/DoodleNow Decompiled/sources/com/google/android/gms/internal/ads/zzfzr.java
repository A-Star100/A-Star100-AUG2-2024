package com.google.android.gms.internal.ads;

import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfzr extends zzfzg {
    @CheckForNull
    Object[] zzd;
    private int zze;

    public zzfzr() {
        super(4);
    }

    public final /* bridge */ /* synthetic */ zzfzh zzb(Object obj) {
        zzf(obj);
        return this;
    }

    public final zzfzr zzg(Object... objArr) {
        if (this.zzd != null) {
            for (int i = 0; i < 2; i++) {
                zzf(objArr[i]);
            }
        } else {
            zzd(objArr, 2);
        }
        return this;
    }

    zzfzr(int i) {
        super(i);
        this.zzd = new Object[zzfzs.zzh(i)];
    }

    public final zzfzr zzh(Iterable iterable) {
        iterable.getClass();
        if (this.zzd != null) {
            for (Object zzf : iterable) {
                zzf(zzf);
            }
        } else {
            super.zzc(iterable);
        }
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.internal.ads.zzgbf} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.google.android.gms.internal.ads.zzfzs} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: com.google.android.gms.internal.ads.zzgbf} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.google.android.gms.internal.ads.zzgbf} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzfzs zzi() {
        /*
            r9 = this;
            int r0 = r9.zzb
            if (r0 == 0) goto L_0x0057
            r1 = 1
            if (r0 == r1) goto L_0x0048
            java.lang.Object[] r2 = r9.zzd
            if (r2 == 0) goto L_0x0034
            int r0 = com.google.android.gms.internal.ads.zzfzs.zzh(r0)
            java.lang.Object[] r2 = r9.zzd
            int r2 = r2.length
            if (r0 != r2) goto L_0x0034
            int r0 = r9.zzb
            java.lang.Object[] r2 = r9.zza
            int r3 = r2.length
            boolean r3 = com.google.android.gms.internal.ads.zzfzs.zzw(r0, r3)
            if (r3 == 0) goto L_0x0023
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r0)
        L_0x0023:
            r4 = r2
            com.google.android.gms.internal.ads.zzgbf r0 = new com.google.android.gms.internal.ads.zzgbf
            int r5 = r9.zze
            java.lang.Object[] r6 = r9.zzd
            int r2 = r6.length
            int r7 = r2 + -1
            int r8 = r9.zzb
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            goto L_0x0042
        L_0x0034:
            int r0 = r9.zzb
            java.lang.Object[] r2 = r9.zza
            com.google.android.gms.internal.ads.zzfzs r0 = com.google.android.gms.internal.ads.zzfzs.zzv(r0, r2)
            int r2 = r0.size()
            r9.zzb = r2
        L_0x0042:
            r9.zzc = r1
            r1 = 0
            r9.zzd = r1
            return r0
        L_0x0048:
            java.lang.Object[] r0 = r9.zza
            r1 = 0
            r0 = r0[r1]
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)
            com.google.android.gms.internal.ads.zzgbq r1 = new com.google.android.gms.internal.ads.zzgbq
            r1.<init>(r0)
            return r1
        L_0x0057:
            com.google.android.gms.internal.ads.zzgbf r0 = com.google.android.gms.internal.ads.zzgbf.zza
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfzr.zzi():com.google.android.gms.internal.ads.zzfzs");
    }

    public final zzfzr zzf(Object obj) {
        obj.getClass();
        if (this.zzd != null) {
            int zzh = zzfzs.zzh(this.zzb);
            Object[] objArr = this.zzd;
            if (zzh <= objArr.length) {
                Objects.requireNonNull(objArr);
                int length = this.zzd.length - 1;
                int hashCode = obj.hashCode();
                int zza = zzfzf.zza(hashCode);
                while (true) {
                    int i = zza & length;
                    Object[] objArr2 = this.zzd;
                    Object obj2 = objArr2[i];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        zza = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.zze += hashCode;
                        super.zza(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzd = null;
        super.zza(obj);
        return this;
    }
}
