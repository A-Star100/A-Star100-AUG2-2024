package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzmd extends zzii {
    public static final /* synthetic */ int zzc = 0;
    private final int zzd;
    private final int zze;
    private final int[] zzf;
    private final int[] zzg;
    private final zzcx[] zzh;
    private final Object[] zzi;
    private final HashMap zzj;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzmd(java.util.Collection r7, com.google.android.gms.internal.ads.zzxb r8) {
        /*
            r6 = this;
            int r0 = r7.size()
            com.google.android.gms.internal.ads.zzcx[] r0 = new com.google.android.gms.internal.ads.zzcx[r0]
            java.util.Iterator r1 = r7.iterator()
            r2 = 0
            r3 = r2
        L_0x000c:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0022
            java.lang.Object r4 = r1.next()
            com.google.android.gms.internal.ads.zzlm r4 = (com.google.android.gms.internal.ads.zzlm) r4
            int r5 = r3 + 1
            com.google.android.gms.internal.ads.zzcx r4 = r4.zza()
            r0[r3] = r4
            r3 = r5
            goto L_0x000c
        L_0x0022:
            int r1 = r7.size()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.util.Iterator r7 = r7.iterator()
        L_0x002c:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x0042
            java.lang.Object r3 = r7.next()
            com.google.android.gms.internal.ads.zzlm r3 = (com.google.android.gms.internal.ads.zzlm) r3
            int r4 = r2 + 1
            java.lang.Object r3 = r3.zzb()
            r1[r2] = r3
            r2 = r4
            goto L_0x002c
        L_0x0042:
            r6.<init>(r0, r1, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmd.<init>(java.util.Collection, com.google.android.gms.internal.ads.zzxb):void");
    }

    public final int zzb() {
        return this.zze;
    }

    public final int zzc() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final int zzp(Object obj) {
        Integer num = (Integer) this.zzj.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: protected */
    public final int zzq(int i) {
        return zzfx.zzb(this.zzf, i + 1, false, false);
    }

    /* access modifiers changed from: protected */
    public final int zzr(int i) {
        return zzfx.zzb(this.zzg, i + 1, false, false);
    }

    /* access modifiers changed from: protected */
    public final int zzs(int i) {
        return this.zzf[i];
    }

    /* access modifiers changed from: protected */
    public final int zzt(int i) {
        return this.zzg[i];
    }

    /* access modifiers changed from: protected */
    public final zzcx zzu(int i) {
        return this.zzh[i];
    }

    /* access modifiers changed from: protected */
    public final Object zzv(int i) {
        return this.zzi[i];
    }

    /* access modifiers changed from: package-private */
    public final List zzw() {
        return Arrays.asList(this.zzh);
    }

    public final zzmd zzx(zzxb zzxb) {
        zzcx[] zzcxArr = new zzcx[this.zzh.length];
        int i = 0;
        while (true) {
            zzcx[] zzcxArr2 = this.zzh;
            if (i >= zzcxArr2.length) {
                return new zzmd(zzcxArr, this.zzi, zzxb);
            }
            zzcxArr[i] = new zzmc(this, zzcxArr2[i]);
            i++;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzmd(zzcx[] zzcxArr, Object[] objArr, zzxb zzxb) {
        super(false, zzxb);
        int i = 0;
        this.zzh = zzcxArr;
        int length = zzcxArr.length;
        this.zzf = new int[length];
        this.zzg = new int[length];
        this.zzi = objArr;
        this.zzj = new HashMap();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < zzcxArr.length) {
            zzcx zzcx = zzcxArr[i];
            this.zzh[i4] = zzcx;
            this.zzg[i4] = i2;
            this.zzf[i4] = i3;
            i2 += zzcx.zzc();
            i3 += this.zzh[i4].zzb();
            this.zzj.put(objArr[i4], Integer.valueOf(i4));
            i++;
            i4++;
        }
        this.zzd = i2;
        this.zze = i3;
    }
}
