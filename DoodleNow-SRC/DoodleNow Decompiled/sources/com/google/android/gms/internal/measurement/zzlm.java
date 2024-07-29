package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzlm<T> implements zzlu<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmv.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlj zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzkx zzm;
    private final zzml zzn;
    private final zzjp zzo;
    private final zzlo zzp;
    private final zzle zzq;

    private zzlm(int[] iArr, Object[] objArr, int i, int i2, zzlj zzlj, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzlo zzlo, zzkx zzkx, zzml zzml, zzjp zzjp, zzle zzle, byte[] bArr) {
        zzlj zzlj2 = zzlj;
        zzjp zzjp2 = zzjp;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = z;
        boolean z3 = false;
        if (zzjp2 != null && zzjp2.zzc(zzlj)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzp = zzlo;
        this.zzm = zzkx;
        this.zzn = zzml;
        this.zzo = zzjp2;
        this.zzg = zzlj2;
        this.zzq = zzle;
    }

    private static int zzA(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzB(int i) {
        return this.zzc[i + 1];
    }

    private static long zzC(Object obj, long j) {
        return ((Long) zzmv.zzf(obj, j)).longValue();
    }

    private final zzkg zzD(int i) {
        int i2 = i / 3;
        return (zzkg) this.zzd[i2 + i2 + 1];
    }

    private final zzlu zzE(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzlu zzlu = (zzlu) this.zzd[i3];
        if (zzlu != null) {
            return zzlu;
        }
        zzlu zzb2 = zzlr.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzF(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzG(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private final void zzH(Object obj, Object obj2, int i) {
        long zzB = (long) (zzB(i) & 1048575);
        if (zzO(obj2, i)) {
            Object zzf2 = zzmv.zzf(obj, zzB);
            Object zzf3 = zzmv.zzf(obj2, zzB);
            if (zzf2 != null && zzf3 != null) {
                zzmv.zzs(obj, zzB, zzkk.zzg(zzf2, zzf3));
                zzJ(obj, i);
            } else if (zzf3 != null) {
                zzmv.zzs(obj, zzB, zzf3);
                zzJ(obj, i);
            }
        }
    }

    private final void zzI(Object obj, Object obj2, int i) {
        int zzB = zzB(i);
        int i2 = this.zzc[i];
        long j = (long) (zzB & 1048575);
        if (zzR(obj2, i2, i)) {
            Object zzf2 = zzR(obj, i2, i) ? zzmv.zzf(obj, j) : null;
            Object zzf3 = zzmv.zzf(obj2, j);
            if (zzf2 != null && zzf3 != null) {
                zzmv.zzs(obj, j, zzkk.zzg(zzf2, zzf3));
                zzK(obj, i2, i);
            } else if (zzf3 != null) {
                zzmv.zzs(obj, j, zzf3);
                zzK(obj, i2, i);
            }
        }
    }

    private final void zzJ(Object obj, int i) {
        int zzy = zzy(i);
        long j = (long) (1048575 & zzy);
        if (j != 1048575) {
            zzmv.zzq(obj, j, (1 << (zzy >>> 20)) | zzmv.zzc(obj, j));
        }
    }

    private final void zzK(Object obj, int i, int i2) {
        zzmv.zzq(obj, (long) (zzy(i2) & 1048575), i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:156:0x044c, code lost:
        r7 = r7 + 3;
        r5 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x029b, code lost:
        r13 = r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzL(java.lang.Object r17, com.google.android.gms.internal.measurement.zznd r18) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r0.zzh
            if (r3 != 0) goto L_0x045d
            int[] r3 = r0.zzc
            int r3 = r3.length
            sun.misc.Unsafe r4 = zzb
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r5
            r7 = 0
            r8 = 0
        L_0x0015:
            if (r7 >= r3) goto L_0x0453
            int r10 = r0.zzB(r7)
            int[] r11 = r0.zzc
            r12 = r11[r7]
            int r13 = zzA(r10)
            r14 = 17
            r15 = 1
            if (r13 > r14) goto L_0x003b
            int r14 = r7 + 2
            r11 = r11[r14]
            r14 = r11 & r5
            if (r14 == r9) goto L_0x0036
            long r8 = (long) r14
            int r8 = r4.getInt(r1, r8)
            r9 = r14
        L_0x0036:
            int r11 = r11 >>> 20
            int r11 = r15 << r11
            goto L_0x003c
        L_0x003b:
            r11 = 0
        L_0x003c:
            r10 = r10 & r5
            long r5 = (long) r10
            switch(r13) {
                case 0: goto L_0x0440;
                case 1: goto L_0x0433;
                case 2: goto L_0x0426;
                case 3: goto L_0x0419;
                case 4: goto L_0x040c;
                case 5: goto L_0x03ff;
                case 6: goto L_0x03f2;
                case 7: goto L_0x03e5;
                case 8: goto L_0x03d7;
                case 9: goto L_0x03c5;
                case 10: goto L_0x03b5;
                case 11: goto L_0x03a7;
                case 12: goto L_0x0399;
                case 13: goto L_0x038b;
                case 14: goto L_0x037d;
                case 15: goto L_0x036f;
                case 16: goto L_0x0361;
                case 17: goto L_0x034f;
                case 18: goto L_0x033f;
                case 19: goto L_0x032f;
                case 20: goto L_0x031f;
                case 21: goto L_0x030f;
                case 22: goto L_0x02ff;
                case 23: goto L_0x02ef;
                case 24: goto L_0x02df;
                case 25: goto L_0x02cf;
                case 26: goto L_0x02c0;
                case 27: goto L_0x02ad;
                case 28: goto L_0x029e;
                case 29: goto L_0x028d;
                case 30: goto L_0x027e;
                case 31: goto L_0x026f;
                case 32: goto L_0x0260;
                case 33: goto L_0x0251;
                case 34: goto L_0x0242;
                case 35: goto L_0x0233;
                case 36: goto L_0x0224;
                case 37: goto L_0x0215;
                case 38: goto L_0x0206;
                case 39: goto L_0x01f7;
                case 40: goto L_0x01e8;
                case 41: goto L_0x01d9;
                case 42: goto L_0x01ca;
                case 43: goto L_0x01bb;
                case 44: goto L_0x01ac;
                case 45: goto L_0x019d;
                case 46: goto L_0x018e;
                case 47: goto L_0x017f;
                case 48: goto L_0x0170;
                case 49: goto L_0x015d;
                case 50: goto L_0x0154;
                case 51: goto L_0x0145;
                case 52: goto L_0x0136;
                case 53: goto L_0x0127;
                case 54: goto L_0x0118;
                case 55: goto L_0x0109;
                case 56: goto L_0x00fa;
                case 57: goto L_0x00eb;
                case 58: goto L_0x00dc;
                case 59: goto L_0x00cd;
                case 60: goto L_0x00ba;
                case 61: goto L_0x00aa;
                case 62: goto L_0x009c;
                case 63: goto L_0x008e;
                case 64: goto L_0x0080;
                case 65: goto L_0x0072;
                case 66: goto L_0x0064;
                case 67: goto L_0x0056;
                case 68: goto L_0x0044;
                default: goto L_0x0041;
            }
        L_0x0041:
            r13 = 0
            goto L_0x044c
        L_0x0044:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzlu r6 = r0.zzE(r7)
            r2.zzq(r12, r5, r6)
            goto L_0x0041
        L_0x0056:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = zzC(r1, r5)
            r2.zzC(r12, r5)
            goto L_0x0041
        L_0x0064:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzA(r12, r5)
            goto L_0x0041
        L_0x0072:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = zzC(r1, r5)
            r2.zzy(r12, r5)
            goto L_0x0041
        L_0x0080:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzw(r12, r5)
            goto L_0x0041
        L_0x008e:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzi(r12, r5)
            goto L_0x0041
        L_0x009c:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzH(r12, r5)
            goto L_0x0041
        L_0x00aa:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzjb r5 = (com.google.android.gms.internal.measurement.zzjb) r5
            r2.zzd(r12, r5)
            goto L_0x0041
        L_0x00ba:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzlu r6 = r0.zzE(r7)
            r2.zzv(r12, r5, r6)
            goto L_0x0041
        L_0x00cd:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzT(r12, r5, r2)
            goto L_0x0041
        L_0x00dc:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            boolean r5 = zzS(r1, r5)
            r2.zzb(r12, r5)
            goto L_0x0041
        L_0x00eb:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzk(r12, r5)
            goto L_0x0041
        L_0x00fa:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = zzC(r1, r5)
            r2.zzm(r12, r5)
            goto L_0x0041
        L_0x0109:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzr(r12, r5)
            goto L_0x0041
        L_0x0118:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = zzC(r1, r5)
            r2.zzJ(r12, r5)
            goto L_0x0041
        L_0x0127:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = zzC(r1, r5)
            r2.zzt(r12, r5)
            goto L_0x0041
        L_0x0136:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            float r5 = zzo(r1, r5)
            r2.zzo(r12, r5)
            goto L_0x0041
        L_0x0145:
            boolean r10 = r0.zzR(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            double r5 = zzn(r1, r5)
            r2.zzf(r12, r5)
            goto L_0x0041
        L_0x0154:
            java.lang.Object r5 = r4.getObject(r1, r5)
            r0.zzM(r2, r12, r5, r7)
            goto L_0x0041
        L_0x015d:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlu r6 = r0.zzE(r7)
            com.google.android.gms.internal.measurement.zzlw.zzO(r10, r5, r2, r6)
            goto L_0x0041
        L_0x0170:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzV(r10, r5, r2, r15)
            goto L_0x0041
        L_0x017f:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzU(r10, r5, r2, r15)
            goto L_0x0041
        L_0x018e:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzT(r10, r5, r2, r15)
            goto L_0x0041
        L_0x019d:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzS(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01ac:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzK(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01bb:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzX(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01ca:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzH(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01d9:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzL(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01e8:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzM(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01f7:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzP(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0206:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzY(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0215:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzQ(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0224:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzN(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0233:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzJ(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0242:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r11 = 0
            com.google.android.gms.internal.measurement.zzlw.zzV(r10, r5, r2, r11)
            goto L_0x029b
        L_0x0251:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzU(r10, r5, r2, r11)
            goto L_0x029b
        L_0x0260:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzT(r10, r5, r2, r11)
            goto L_0x029b
        L_0x026f:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzS(r10, r5, r2, r11)
            goto L_0x029b
        L_0x027e:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzK(r10, r5, r2, r11)
            goto L_0x029b
        L_0x028d:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzX(r10, r5, r2, r11)
        L_0x029b:
            r13 = r11
            goto L_0x044c
        L_0x029e:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzI(r10, r5, r2)
            goto L_0x0041
        L_0x02ad:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlu r6 = r0.zzE(r7)
            com.google.android.gms.internal.measurement.zzlw.zzR(r10, r5, r2, r6)
            goto L_0x0041
        L_0x02c0:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzW(r10, r5, r2)
            goto L_0x0041
        L_0x02cf:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r13 = 0
            com.google.android.gms.internal.measurement.zzlw.zzH(r10, r5, r2, r13)
            goto L_0x044c
        L_0x02df:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzL(r10, r5, r2, r13)
            goto L_0x044c
        L_0x02ef:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzM(r10, r5, r2, r13)
            goto L_0x044c
        L_0x02ff:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzP(r10, r5, r2, r13)
            goto L_0x044c
        L_0x030f:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzY(r10, r5, r2, r13)
            goto L_0x044c
        L_0x031f:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzQ(r10, r5, r2, r13)
            goto L_0x044c
        L_0x032f:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzN(r10, r5, r2, r13)
            goto L_0x044c
        L_0x033f:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlw.zzJ(r10, r5, r2, r13)
            goto L_0x044c
        L_0x034f:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzlu r6 = r0.zzE(r7)
            r2.zzq(r12, r5, r6)
            goto L_0x044c
        L_0x0361:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.zzC(r12, r5)
            goto L_0x044c
        L_0x036f:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzA(r12, r5)
            goto L_0x044c
        L_0x037d:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.zzy(r12, r5)
            goto L_0x044c
        L_0x038b:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzw(r12, r5)
            goto L_0x044c
        L_0x0399:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzi(r12, r5)
            goto L_0x044c
        L_0x03a7:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzH(r12, r5)
            goto L_0x044c
        L_0x03b5:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzjb r5 = (com.google.android.gms.internal.measurement.zzjb) r5
            r2.zzd(r12, r5)
            goto L_0x044c
        L_0x03c5:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzlu r6 = r0.zzE(r7)
            r2.zzv(r12, r5, r6)
            goto L_0x044c
        L_0x03d7:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzT(r12, r5, r2)
            goto L_0x044c
        L_0x03e5:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            boolean r5 = com.google.android.gms.internal.measurement.zzmv.zzw(r1, r5)
            r2.zzb(r12, r5)
            goto L_0x044c
        L_0x03f2:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzk(r12, r5)
            goto L_0x044c
        L_0x03ff:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.zzm(r12, r5)
            goto L_0x044c
        L_0x040c:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzr(r12, r5)
            goto L_0x044c
        L_0x0419:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.zzJ(r12, r5)
            goto L_0x044c
        L_0x0426:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.zzt(r12, r5)
            goto L_0x044c
        L_0x0433:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            float r5 = com.google.android.gms.internal.measurement.zzmv.zzb(r1, r5)
            r2.zzo(r12, r5)
            goto L_0x044c
        L_0x0440:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            double r5 = com.google.android.gms.internal.measurement.zzmv.zza(r1, r5)
            r2.zzf(r12, r5)
        L_0x044c:
            int r7 = r7 + 3
            r5 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0015
        L_0x0453:
            com.google.android.gms.internal.measurement.zzml r3 = r0.zzn
            java.lang.Object r1 = r3.zzc(r1)
            r3.zzi(r1, r2)
            return
        L_0x045d:
            com.google.android.gms.internal.measurement.zzjp r2 = r0.zzo
            r2.zza(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlm.zzL(java.lang.Object, com.google.android.gms.internal.measurement.zznd):void");
    }

    private final void zzM(zznd zznd, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzlc zzlc = (zzlc) zzF(i2);
            throw null;
        }
    }

    private final boolean zzN(Object obj, Object obj2, int i) {
        return zzO(obj, i) == zzO(obj2, i);
    }

    private final boolean zzO(Object obj, int i) {
        int zzy = zzy(i);
        long j = (long) (zzy & 1048575);
        if (j != 1048575) {
            return (zzmv.zzc(obj, j) & (1 << (zzy >>> 20))) != 0;
        }
        int zzB = zzB(i);
        long j2 = (long) (zzB & 1048575);
        switch (zzA(zzB)) {
            case 0:
                return Double.doubleToRawLongBits(zzmv.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmv.zzb(obj, j2)) != 0;
            case 2:
                return zzmv.zzd(obj, j2) != 0;
            case 3:
                return zzmv.zzd(obj, j2) != 0;
            case 4:
                return zzmv.zzc(obj, j2) != 0;
            case 5:
                return zzmv.zzd(obj, j2) != 0;
            case 6:
                return zzmv.zzc(obj, j2) != 0;
            case 7:
                return zzmv.zzw(obj, j2);
            case 8:
                Object zzf2 = zzmv.zzf(obj, j2);
                if (zzf2 instanceof String) {
                    return !((String) zzf2).isEmpty();
                }
                if (zzf2 instanceof zzjb) {
                    return !zzjb.zzb.equals(zzf2);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzmv.zzf(obj, j2) != null;
            case 10:
                return !zzjb.zzb.equals(zzmv.zzf(obj, j2));
            case 11:
                return zzmv.zzc(obj, j2) != 0;
            case 12:
                return zzmv.zzc(obj, j2) != 0;
            case 13:
                return zzmv.zzc(obj, j2) != 0;
            case 14:
                return zzmv.zzd(obj, j2) != 0;
            case 15:
                return zzmv.zzc(obj, j2) != 0;
            case 16:
                return zzmv.zzd(obj, j2) != 0;
            case 17:
                return zzmv.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzP(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzO(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzQ(Object obj, int i, zzlu zzlu) {
        return zzlu.zzk(zzmv.zzf(obj, (long) (i & 1048575)));
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzmv.zzc(obj, (long) (zzy(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzmv.zzf(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zznd zznd) throws IOException {
        if (obj instanceof String) {
            zznd.zzF(i, (String) obj);
        } else {
            zznd.zzd(i, (zzjb) obj);
        }
    }

    static zzmm zzd(Object obj) {
        zzkc zzkc = (zzkc) obj;
        zzmm zzmm = zzkc.zzc;
        if (zzmm != zzmm.zzc()) {
            return zzmm;
        }
        zzmm zze2 = zzmm.zze();
        zzkc.zzc = zze2;
        return zze2;
    }

    static zzlm zzl(Class cls, zzlg zzlg, zzlo zzlo, zzkx zzkx, zzml zzml, zzjp zzjp, zzle zzle) {
        if (zzlg instanceof zzlt) {
            return zzm((zzlt) zzlg, zzlo, zzkx, zzml, zzjp, zzle);
        }
        zzmi zzmi = (zzmi) zzlg;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x037f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.measurement.zzlm zzm(com.google.android.gms.internal.measurement.zzlt r34, com.google.android.gms.internal.measurement.zzlo r35, com.google.android.gms.internal.measurement.zzkx r36, com.google.android.gms.internal.measurement.zzml r37, com.google.android.gms.internal.measurement.zzjp r38, com.google.android.gms.internal.measurement.zzle r39) {
        /*
            int r0 = r34.zzc()
            r1 = 2
            r2 = 0
            if (r0 != r1) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = r2
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0057
            int[] r6 = zza
            r8 = r2
            r9 = r8
            r11 = r9
            r12 = r11
            r14 = r12
            r16 = r14
            r13 = r6
            r6 = r16
            goto L_0x0166
        L_0x0057:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0076
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0063:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0073
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0063
        L_0x0073:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0076:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0095
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0082:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0092
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0082
        L_0x0092:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0095:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b4
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a1:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b1
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a1
        L_0x00b1:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b4:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c0:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00d0
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c0
        L_0x00d0:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d3:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00df:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ef
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00df
        L_0x00ef:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f2:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0111
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fe:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fe
        L_0x010e:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0111:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0132
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011d:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011d
        L_0x012e:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0132:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0155
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013e:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x0150
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013e
        L_0x0150:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0155:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0166:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r34.zze()
            com.google.android.gms.internal.measurement.zzlj r18 = r34.zza()
            java.lang.Class r2 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0184:
            if (r4 >= r1) goto L_0x03ce
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ac
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0194:
            int r26 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01a6
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r26
            goto L_0x0194
        L_0x01a6:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r26
            goto L_0x01ae
        L_0x01ac:
            r3 = r24
        L_0x01ae:
            int r24 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01db
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bc:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r1) goto L_0x01d5
            r1 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r3 = r3 | r1
            int r24 = r24 + 13
            r5 = r27
            r1 = r28
            goto L_0x01bc
        L_0x01d5:
            int r1 = r5 << r24
            r3 = r3 | r1
            r1 = r27
            goto L_0x01df
        L_0x01db:
            r28 = r1
            r1 = r24
        L_0x01df:
            r5 = r3 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r3 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ed
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ed:
            r14 = 51
            if (r5 < r14) goto L_0x029a
            int r14 = r1 + 1
            char r1 = r0.charAt(r1)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r14) goto L_0x0223
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0204:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021d
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r1 = r1 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0204
        L_0x021d:
            int r12 = r14 << r27
            r1 = r1 | r12
            r14 = r31
            goto L_0x0227
        L_0x0223:
            r32 = r12
            r14 = r27
        L_0x0227:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0248
            r14 = 17
            if (r12 != r14) goto L_0x0234
            goto L_0x0248
        L_0x0234:
            r14 = 12
            if (r12 != r14) goto L_0x0257
            if (r10 != 0) goto L_0x0257
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0255
        L_0x0248:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0255:
            r16 = r14
        L_0x0257:
            int r1 = r1 + r1
            r12 = r17[r1]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0261
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0269
        L_0x0261:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzG(r2, r12)
            r17[r1] = r12
        L_0x0269:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r7 = (int) r7
            int r1 = r1 + 1
            r8 = r17[r1]
            boolean r12 = r8 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027c
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x0284
        L_0x027c:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzG(r2, r8)
            r17[r1] = r8
        L_0x0284:
            r1 = r7
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r30 = r0
            r29 = r11
            r0 = r16
            r26 = r27
            r25 = 1
            r16 = r7
            r7 = r1
            r1 = 0
            goto L_0x0393
        L_0x029a:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzG(r2, r8)
            r12 = 9
            if (r5 == r12) goto L_0x0312
            r12 = 17
            if (r5 != r12) goto L_0x02b2
            goto L_0x0312
        L_0x02b2:
            r12 = 27
            if (r5 == r12) goto L_0x0302
            r12 = 49
            if (r5 != r12) goto L_0x02bb
            goto L_0x0302
        L_0x02bb:
            r12 = 12
            if (r5 == r12) goto L_0x02f2
            r12 = 30
            if (r5 == r12) goto L_0x02f2
            r12 = 44
            if (r5 != r12) goto L_0x02c8
            goto L_0x02f2
        L_0x02c8:
            r12 = 50
            if (r5 != r12) goto L_0x02e8
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r29 = r16 + 2
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r3 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02eb
            int r7 = r16 + 3
            int r22 = r22 + 1
            r16 = r17[r29]
            r11[r22] = r16
            r22 = r12
        L_0x02e8:
            r25 = 1
            goto L_0x031f
        L_0x02eb:
            r22 = r12
            r12 = r29
            r25 = 1
            goto L_0x0320
        L_0x02f2:
            if (r10 != 0) goto L_0x02e8
            int r12 = r9 / 3
            int r16 = r16 + 2
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030f
        L_0x0302:
            r25 = 1
            int r12 = r9 / 3
            int r16 = r16 + 2
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030f:
            r12 = r16
            goto L_0x0320
        L_0x0312:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r16 = r8.getType()
            r11[r12] = r16
        L_0x031f:
            r12 = r7
        L_0x0320:
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r8 = r3 & 4096(0x1000, float:5.74E-42)
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r8 != r11) goto L_0x037f
            r8 = 17
            if (r5 > r8) goto L_0x037f
            int r8 = r1 + 1
            char r1 = r0.charAt(r1)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r11) goto L_0x0359
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0343:
            int r26 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r11) goto L_0x0355
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r16
            r1 = r1 | r8
            int r16 = r16 + 13
            r8 = r26
            goto L_0x0343
        L_0x0355:
            int r8 = r8 << r16
            r1 = r1 | r8
            goto L_0x035b
        L_0x0359:
            r26 = r8
        L_0x035b:
            int r8 = r6 + r6
            int r16 = r1 / 32
            int r8 = r8 + r16
            r11 = r17[r8]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x036c
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x0374
        L_0x036c:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zzG(r2, r11)
            r17[r8] = r11
        L_0x0374:
            r0 = r12
            long r11 = r15.objectFieldOffset(r11)
            int r8 = (int) r11
            int r1 = r1 % 32
            r16 = r8
            goto L_0x0385
        L_0x037f:
            r30 = r0
            r0 = r12
            r26 = r1
            r1 = 0
        L_0x0385:
            r8 = 18
            if (r5 < r8) goto L_0x0393
            r8 = 49
            if (r5 > r8) goto L_0x0393
            int r8 = r23 + 1
            r13[r23] = r7
            r23 = r8
        L_0x0393:
            int r8 = r9 + 1
            r31[r9] = r4
            int r4 = r9 + 2
            r11 = r3 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x03a0
            r11 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03a1
        L_0x03a0:
            r11 = 0
        L_0x03a1:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x03a8
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a9
        L_0x03a8:
            r3 = 0
        L_0x03a9:
            r3 = r3 | r11
            int r5 = r5 << 20
            r3 = r3 | r5
            r3 = r3 | r7
            r31[r8] = r3
            int r9 = r9 + 3
            int r1 = r1 << 20
            r1 = r1 | r16
            r31[r4] = r1
            r16 = r0
            r8 = r14
            r14 = r24
            r4 = r26
            r1 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0184
        L_0x03ce:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.measurement.zzlm r0 = new com.google.android.gms.internal.measurement.zzlm
            r4 = r0
            com.google.android.gms.internal.measurement.zzlj r9 = r34.zza()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlm.zzm(com.google.android.gms.internal.measurement.zzlt, com.google.android.gms.internal.measurement.zzlo, com.google.android.gms.internal.measurement.zzkx, com.google.android.gms.internal.measurement.zzml, com.google.android.gms.internal.measurement.zzjp, com.google.android.gms.internal.measurement.zzle):com.google.android.gms.internal.measurement.zzlm");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzmv.zzf(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzmv.zzf(obj, j)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0309, code lost:
        r4 = r4 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x030a, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x030b, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0349, code lost:
        r6 = r6 + r3;
        r12 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x037d, code lost:
        r6 = r6 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0488, code lost:
        r4 = r4 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0503, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0504, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x052d, code lost:
        r6 = r6 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x053b, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x054a, code lost:
        r3 = r3 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x054e, code lost:
        r5 = r5 + 3;
        r4 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ee, code lost:
        r4 = r4 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x019b, code lost:
        r6 = r6 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01ab, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01bb, code lost:
        r3 = r3 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzp(java.lang.Object r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = zzb
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r4
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x000c:
            int[] r9 = r0.zzc
            int r9 = r9.length
            if (r5 >= r9) goto L_0x0555
            int r9 = r15.zzB(r5)
            int[] r10 = r0.zzc
            r11 = r10[r5]
            int r12 = zzA(r9)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x0035
            int r13 = r5 + 2
            r10 = r10[r13]
            r13 = r10 & r4
            int r10 = r10 >>> 20
            int r10 = r14 << r10
            if (r13 == r8) goto L_0x0036
            long r7 = (long) r13
            int r7 = r2.getInt(r1, r7)
            r8 = r13
            goto L_0x0036
        L_0x0035:
            r10 = 0
        L_0x0036:
            r9 = r9 & r4
            long r3 = (long) r9
            r9 = 63
            switch(r12) {
                case 0: goto L_0x053f;
                case 1: goto L_0x0530;
                case 2: goto L_0x051a;
                case 3: goto L_0x0506;
                case 4: goto L_0x04f0;
                case 5: goto L_0x04e4;
                case 6: goto L_0x04d8;
                case 7: goto L_0x04ca;
                case 8: goto L_0x049f;
                case 9: goto L_0x048c;
                case 10: goto L_0x046f;
                case 11: goto L_0x045a;
                case 12: goto L_0x0445;
                case 13: goto L_0x0438;
                case 14: goto L_0x042b;
                case 15: goto L_0x0411;
                case 16: goto L_0x03f7;
                case 17: goto L_0x03e3;
                case 18: goto L_0x03d5;
                case 19: goto L_0x03c9;
                case 20: goto L_0x03bd;
                case 21: goto L_0x03b1;
                case 22: goto L_0x03a5;
                case 23: goto L_0x0399;
                case 24: goto L_0x038d;
                case 25: goto L_0x0381;
                case 26: goto L_0x0373;
                case 27: goto L_0x0364;
                case 28: goto L_0x0359;
                case 29: goto L_0x034d;
                case 30: goto L_0x033e;
                case 31: goto L_0x0332;
                case 32: goto L_0x0326;
                case 33: goto L_0x031a;
                case 34: goto L_0x030e;
                case 35: goto L_0x02f5;
                case 36: goto L_0x02e0;
                case 37: goto L_0x02cb;
                case 38: goto L_0x02b6;
                case 39: goto L_0x02a1;
                case 40: goto L_0x028c;
                case 41: goto L_0x0276;
                case 42: goto L_0x0260;
                case 43: goto L_0x024a;
                case 44: goto L_0x0234;
                case 45: goto L_0x021e;
                case 46: goto L_0x0208;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01dc;
                case 49: goto L_0x01cc;
                case 50: goto L_0x01bf;
                case 51: goto L_0x01af;
                case 52: goto L_0x019f;
                case 53: goto L_0x0187;
                case 54: goto L_0x0172;
                case 55: goto L_0x015c;
                case 56: goto L_0x014f;
                case 57: goto L_0x0142;
                case 58: goto L_0x0133;
                case 59: goto L_0x0106;
                case 60: goto L_0x00f2;
                case 61: goto L_0x00d4;
                case 62: goto L_0x00be;
                case 63: goto L_0x00a8;
                case 64: goto L_0x009a;
                case 65: goto L_0x008c;
                case 66: goto L_0x0071;
                case 67: goto L_0x0055;
                case 68: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x037e
        L_0x003f:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlj r3 = (com.google.android.gms.internal.measurement.zzlj) r3
            com.google.android.gms.internal.measurement.zzlu r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzu(r11, r3, r4)
            goto L_0x037d
        L_0x0055:
            boolean r10 = r15.zzR(r1, r11, r5)
            if (r10 == 0) goto L_0x037e
            long r3 = zzC(r1, r3)
            int r10 = r11 << 3
            int r10 = com.google.android.gms.internal.measurement.zzjj.zzA(r10)
            long r11 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r11
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzB(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x037e
        L_0x0071:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030a
        L_0x008c:
            boolean r3 = r15.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x01bb
        L_0x009a:
            boolean r3 = r15.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x01ab
        L_0x00a8:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzv(r3)
            goto L_0x030a
        L_0x00be:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030a
        L_0x00d4:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzjb r3 = (com.google.android.gms.internal.measurement.zzjb) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
        L_0x00ee:
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x030b
        L_0x00f2:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlu r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzo(r11, r3, r4)
            goto L_0x037d
        L_0x0106:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzjb
            if (r4 == 0) goto L_0x0125
            com.google.android.gms.internal.measurement.zzjb r3 = (com.google.android.gms.internal.measurement.zzjb) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x00ee
        L_0x0125:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzy(r3)
            goto L_0x030a
        L_0x0133:
            boolean r3 = r15.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            int r3 = r3 + r14
            goto L_0x037d
        L_0x0142:
            boolean r3 = r15.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x01ab
        L_0x014f:
            boolean r3 = r15.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x01bb
        L_0x015c:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzv(r3)
            goto L_0x030a
        L_0x0172:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            long r3 = zzC(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzB(r3)
            goto L_0x019b
        L_0x0187:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            long r3 = zzC(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzB(r3)
        L_0x019b:
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x037e
        L_0x019f:
            boolean r3 = r15.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
        L_0x01ab:
            int r3 = r3 + 4
            goto L_0x037d
        L_0x01af:
            boolean r3 = r15.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
        L_0x01bb:
            int r3 = r3 + 8
            goto L_0x037d
        L_0x01bf:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r15.zzF(r5)
            com.google.android.gms.internal.measurement.zzle.zza(r11, r3, r4)
            goto L_0x037e
        L_0x01cc:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.zzlu r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzj(r11, r3, r4)
            goto L_0x037d
        L_0x01dc:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzt(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0309
        L_0x01f2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzr(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0309
        L_0x0208:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzi(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0309
        L_0x021e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzg(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0309
        L_0x0234:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zze(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0309
        L_0x024a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzw(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0309
        L_0x0260:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzb(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0309
        L_0x0276:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzg(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0309
        L_0x028c:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzi(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0309
        L_0x02a1:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzl(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0309
        L_0x02b6:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzy(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0309
        L_0x02cb:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzn(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0309
        L_0x02e0:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzg(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0309
        L_0x02f5:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzi(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
        L_0x0309:
            int r4 = r4 + r9
        L_0x030a:
            int r4 = r4 + r3
        L_0x030b:
            int r6 = r6 + r4
            goto L_0x037e
        L_0x030e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r9 = 0
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzs(r11, r3, r9)
            goto L_0x0349
        L_0x031a:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzq(r11, r3, r9)
            goto L_0x0349
        L_0x0326:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzh(r11, r3, r9)
            goto L_0x0349
        L_0x0332:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzf(r11, r3, r9)
            goto L_0x0349
        L_0x033e:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzd(r11, r3, r9)
        L_0x0349:
            int r6 = r6 + r3
            r12 = r9
            goto L_0x054e
        L_0x034d:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzv(r11, r3, r9)
            goto L_0x037d
        L_0x0359:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzc(r11, r3)
            goto L_0x037d
        L_0x0364:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.zzlu r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzp(r11, r3, r4)
            goto L_0x037d
        L_0x0373:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzu(r11, r3)
        L_0x037d:
            int r6 = r6 + r3
        L_0x037e:
            r12 = 0
            goto L_0x054e
        L_0x0381:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r12 = 0
            int r3 = com.google.android.gms.internal.measurement.zzlw.zza(r11, r3, r12)
            goto L_0x03e0
        L_0x038d:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzf(r11, r3, r12)
            goto L_0x03e0
        L_0x0399:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzh(r11, r3, r12)
            goto L_0x03e0
        L_0x03a5:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzk(r11, r3, r12)
            goto L_0x03e0
        L_0x03b1:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzx(r11, r3, r12)
            goto L_0x03e0
        L_0x03bd:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzm(r11, r3, r12)
            goto L_0x03e0
        L_0x03c9:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzf(r11, r3, r12)
            goto L_0x03e0
        L_0x03d5:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzh(r11, r3, r12)
        L_0x03e0:
            int r6 = r6 + r3
            goto L_0x054e
        L_0x03e3:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlj r3 = (com.google.android.gms.internal.measurement.zzlj) r3
            com.google.android.gms.internal.measurement.zzlu r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzu(r11, r3, r4)
            goto L_0x03e0
        L_0x03f7:
            r12 = 0
            r10 = r10 & r7
            if (r10 == 0) goto L_0x054e
            long r3 = r2.getLong(r1, r3)
            int r10 = r11 << 3
            int r10 = com.google.android.gms.internal.measurement.zzjj.zzA(r10)
            long r13 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r13
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzB(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x054e
        L_0x0411:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0503
        L_0x042b:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x054a
        L_0x0438:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x053b
        L_0x0445:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzv(r3)
            goto L_0x0503
        L_0x045a:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0503
        L_0x046f:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzjb r3 = (com.google.android.gms.internal.measurement.zzjb) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
        L_0x0488:
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x0504
        L_0x048c:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlu r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzo(r11, r3, r4)
            goto L_0x03e0
        L_0x049f:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzjb
            if (r4 == 0) goto L_0x04bd
            com.google.android.gms.internal.measurement.zzjb r3 = (com.google.android.gms.internal.measurement.zzjb) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0488
        L_0x04bd:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzy(r3)
            goto L_0x0503
        L_0x04ca:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            int r3 = r3 + r14
            goto L_0x03e0
        L_0x04d8:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x053b
        L_0x04e4:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x054a
        L_0x04f0:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzv(r3)
        L_0x0503:
            int r4 = r4 + r3
        L_0x0504:
            int r6 = r6 + r4
            goto L_0x054e
        L_0x0506:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzB(r3)
            goto L_0x052d
        L_0x051a:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzB(r3)
        L_0x052d:
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x054e
        L_0x0530:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
        L_0x053b:
            int r3 = r3 + 4
            goto L_0x03e0
        L_0x053f:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
        L_0x054a:
            int r3 = r3 + 8
            goto L_0x03e0
        L_0x054e:
            int r5 = r5 + 3
            r4 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000c
        L_0x0555:
            com.google.android.gms.internal.measurement.zzml r2 = r0.zzn
            java.lang.Object r3 = r2.zzc(r1)
            int r2 = r2.zza(r3)
            int r6 = r6 + r2
            boolean r2 = r0.zzh
            if (r2 != 0) goto L_0x0565
            return r6
        L_0x0565:
            com.google.android.gms.internal.measurement.zzjp r2 = r0.zzo
            r2.zza(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlm.zzp(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02fc, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0474, code lost:
        r5 = r5 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04c4, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04f6, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04f7, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0522, code lost:
        r3 = r3 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0531, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0541, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0545, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzq(java.lang.Object r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0005:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0549
            int r4 = r11.zzB(r2)
            int r5 = zzA(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.measurement.zzju r4 = com.google.android.gms.internal.measurement.zzju.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.measurement.zzju r4 = com.google.android.gms.internal.measurement.zzju.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.zzc
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0535;
                case 1: goto L_0x0525;
                case 2: goto L_0x050e;
                case 3: goto L_0x04f9;
                case 4: goto L_0x04e2;
                case 5: goto L_0x04d5;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04b8;
                case 8: goto L_0x048c;
                case 9: goto L_0x0478;
                case 10: goto L_0x045a;
                case 11: goto L_0x0444;
                case 12: goto L_0x042e;
                case 13: goto L_0x0420;
                case 14: goto L_0x0412;
                case 15: goto L_0x03f7;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03ba;
                case 19: goto L_0x03af;
                case 20: goto L_0x03a4;
                case 21: goto L_0x0399;
                case 22: goto L_0x038e;
                case 23: goto L_0x0383;
                case 24: goto L_0x0378;
                case 25: goto L_0x036d;
                case 26: goto L_0x0362;
                case 27: goto L_0x0353;
                case 28: goto L_0x0347;
                case 29: goto L_0x033b;
                case 30: goto L_0x032f;
                case 31: goto L_0x0323;
                case 32: goto L_0x0317;
                case 33: goto L_0x030b;
                case 34: goto L_0x02ff;
                case 35: goto L_0x02e8;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02be;
                case 38: goto L_0x02a9;
                case 39: goto L_0x0294;
                case 40: goto L_0x027f;
                case 41: goto L_0x0269;
                case 42: goto L_0x0253;
                case 43: goto L_0x023d;
                case 44: goto L_0x0227;
                case 45: goto L_0x0211;
                case 46: goto L_0x01fb;
                case 47: goto L_0x01e5;
                case 48: goto L_0x01cf;
                case 49: goto L_0x01bf;
                case 50: goto L_0x01b2;
                case 51: goto L_0x01a4;
                case 52: goto L_0x0196;
                case 53: goto L_0x0180;
                case 54: goto L_0x016a;
                case 55: goto L_0x0154;
                case 56: goto L_0x0146;
                case 57: goto L_0x0138;
                case 58: goto L_0x012a;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e8;
                case 61: goto L_0x00cc;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a0;
                case 64: goto L_0x0092;
                case 65: goto L_0x0084;
                case 66: goto L_0x0069;
                case 67: goto L_0x004e;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0545
        L_0x0038:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlj r4 = (com.google.android.gms.internal.measurement.zzlj) r4
            com.google.android.gms.internal.measurement.zzlu r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x004e:
            boolean r5 = r11.zzR(r12, r6, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = zzC(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzB(r6)
            goto L_0x04f6
        L_0x0069:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x04f6
        L_0x0084:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0541
        L_0x0092:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0531
        L_0x00a0:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzv(r4)
            goto L_0x04f6
        L_0x00b6:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x04f6
        L_0x00cc:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzjb r4 = (com.google.android.gms.internal.measurement.zzjb) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0474
        L_0x00e8:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlu r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x00fc:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzjb
            if (r5 == 0) goto L_0x011c
            com.google.android.gms.internal.measurement.zzjb r4 = (com.google.android.gms.internal.measurement.zzjb) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0474
        L_0x011c:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzy(r4)
            goto L_0x04f6
        L_0x012a:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x04c4
        L_0x0138:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0531
        L_0x0146:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0541
        L_0x0154:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzv(r4)
            goto L_0x04f6
        L_0x016a:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzC(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzB(r4)
            goto L_0x0522
        L_0x0180:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzC(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzB(r4)
            goto L_0x0522
        L_0x0196:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0531
        L_0x01a4:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0541
        L_0x01b2:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.lang.Object r5 = r11.zzF(r2)
            com.google.android.gms.internal.measurement.zzle.zza(r6, r4, r5)
            goto L_0x0545
        L_0x01bf:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzlu r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzj(r6, r4, r5)
            goto L_0x03c4
        L_0x01cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzt(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x01e5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x01fb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x0211:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x0227:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zze(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x023d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzw(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x0253:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzb(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x027f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x0294:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzl(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x02a9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzy(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x02be:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzn(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x02d3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x02e8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
        L_0x02fc:
            int r5 = r5 + r6
            goto L_0x04f6
        L_0x02ff:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x030b:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x0317:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x0323:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x032f:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzd(r6, r4, r1)
            goto L_0x03c4
        L_0x033b:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzv(r6, r4, r1)
            goto L_0x03c4
        L_0x0347:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzc(r6, r4)
            goto L_0x03c4
        L_0x0353:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzlu r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzp(r6, r4, r5)
            goto L_0x03c4
        L_0x0362:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzu(r6, r4)
            goto L_0x03c4
        L_0x036d:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zza(r6, r4, r1)
            goto L_0x03c4
        L_0x0378:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x0383:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x038e:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzk(r6, r4, r1)
            goto L_0x03c4
        L_0x0399:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzx(r6, r4, r1)
            goto L_0x03c4
        L_0x03a4:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzm(r6, r4, r1)
            goto L_0x03c4
        L_0x03af:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x03ba:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzh(r6, r4, r1)
        L_0x03c4:
            int r3 = r3 + r4
            goto L_0x0545
        L_0x03c7:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlj r4 = (com.google.android.gms.internal.measurement.zzlj) r4
            com.google.android.gms.internal.measurement.zzlu r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x03dc:
            boolean r5 = r11.zzO(r12, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = com.google.android.gms.internal.measurement.zzmv.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzB(r6)
            goto L_0x04f6
        L_0x03f7:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x04f6
        L_0x0412:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0541
        L_0x0420:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0531
        L_0x042e:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzv(r4)
            goto L_0x04f6
        L_0x0444:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x04f6
        L_0x045a:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzjb r4 = (com.google.android.gms.internal.measurement.zzjb) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
        L_0x0474:
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x04f7
        L_0x0478:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlu r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x048c:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzjb
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.measurement.zzjb r4 = (com.google.android.gms.internal.measurement.zzjb) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0474
        L_0x04ab:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzy(r4)
            goto L_0x04f6
        L_0x04b8:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
        L_0x04c4:
            int r4 = r4 + 1
            goto L_0x03c4
        L_0x04c8:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0531
        L_0x04d5:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0541
        L_0x04e2:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzv(r4)
        L_0x04f6:
            int r5 = r5 + r4
        L_0x04f7:
            int r3 = r3 + r5
            goto L_0x0545
        L_0x04f9:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.measurement.zzmv.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzB(r4)
            goto L_0x0522
        L_0x050e:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.measurement.zzmv.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzB(r4)
        L_0x0522:
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0545
        L_0x0525:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
        L_0x0531:
            int r4 = r4 + 4
            goto L_0x03c4
        L_0x0535:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
        L_0x0541:
            int r4 = r4 + 8
            goto L_0x03c4
        L_0x0545:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0549:
            com.google.android.gms.internal.measurement.zzml r0 = r11.zzn
            java.lang.Object r12 = r0.zzc(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlm.zzq(java.lang.Object):int");
    }

    private static int zzr(Object obj, long j) {
        return ((Integer) zzmv.zzf(obj, j)).intValue();
    }

    private final int zzs(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzio zzio) throws IOException {
        Unsafe unsafe = zzb;
        Object zzF = zzF(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzld) object).zze()) {
            zzld zzb2 = zzld.zza().zzb();
            zzle.zzb(zzb2, object);
            unsafe.putObject(obj, j, zzb2);
        }
        zzlc zzlc = (zzlc) zzF;
        throw null;
    }

    private final int zzt(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzio zzio) throws IOException {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        zzio zzio2 = zzio;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i13 + 2] & 1048575);
        switch (i7) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Double.valueOf(Double.longBitsToDouble(zzip.zzn(bArr, i))));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Float.valueOf(Float.intBitsToFloat(zzip.zzb(bArr, i))));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 53:
            case Elf64_Ehdr.e_phentsize:
                if (i12 == 0) {
                    int zzm2 = zzip.zzm(bArr2, i9, zzio2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zzio2.zzb));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm2;
                }
                break;
            case 55:
            case Elf64_Ehdr.e_shstrndx:
                if (i12 == 0) {
                    int zzj2 = zzip.zzj(bArr2, i9, zzio2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzio2.zza));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj2;
                }
                break;
            case 56:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Long.valueOf(zzip.zzn(bArr, i)));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzip.zzb(bArr, i)));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 4;
                }
                break;
            case Elf64_Ehdr.e_shentsize:
                if (i12 == 0) {
                    int zzm3 = zzip.zzm(bArr2, i9, zzio2);
                    unsafe.putObject(obj2, j2, Boolean.valueOf(zzio2.zzb != 0));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm3;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zzj3 = zzip.zzj(bArr2, i9, zzio2);
                    int i14 = zzio2.zza;
                    if (i14 == 0) {
                        unsafe.putObject(obj2, j2, "");
                    } else if ((i6 & 536870912) == 0 || zzna.zzf(bArr2, zzj3, zzj3 + i14)) {
                        unsafe.putObject(obj2, j2, new String(bArr2, zzj3, i14, zzkk.zzb));
                        zzj3 += i14;
                    } else {
                        throw zzkm.zzc();
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzj3;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int zzd2 = zzip.zzd(zzE(i13), bArr2, i9, i2, zzio2);
                    Object object = unsafe.getInt(obj2, j3) == i11 ? unsafe.getObject(obj2, j2) : null;
                    if (object == null) {
                        unsafe.putObject(obj2, j2, zzio2.zzc);
                    } else {
                        unsafe.putObject(obj2, j2, zzkk.zzg(object, zzio2.zzc));
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzd2;
                }
                break;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                if (i12 == 2) {
                    int zza2 = zzip.zza(bArr2, i9, zzio2);
                    unsafe.putObject(obj2, j2, zzio2.zzc);
                    unsafe.putInt(obj2, j3, i11);
                    return zza2;
                }
                break;
            case HtmlCompat.FROM_HTML_MODE_COMPACT:
                if (i12 == 0) {
                    int zzj4 = zzip.zzj(bArr2, i9, zzio2);
                    int i15 = zzio2.zza;
                    zzkg zzD = zzD(i13);
                    if (zzD == null || zzD.zza(i15)) {
                        unsafe.putObject(obj2, j2, Integer.valueOf(i15));
                        unsafe.putInt(obj2, j3, i11);
                    } else {
                        zzd(obj).zzh(i10, Long.valueOf((long) i15));
                    }
                    return zzj4;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int zzj5 = zzip.zzj(bArr2, i9, zzio2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzjf.zzb(zzio2.zza)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj5;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int zzm4 = zzip.zzm(bArr2, i9, zzio2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zzjf.zzc(zzio2.zzb)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm4;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int zzc2 = zzip.zzc(zzE(i13), bArr, i, i2, (i10 & -8) | 4, zzio);
                    Object object2 = unsafe.getInt(obj2, j3) == i11 ? unsafe.getObject(obj2, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj2, j2, zzio2.zzc);
                    } else {
                        unsafe.putObject(obj2, j2, zzkk.zzg(object2, zzio2.zzc));
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzc2;
                }
                break;
        }
        return i9;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02c5, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02f5, code lost:
        if (r0 != r14) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0317, code lost:
        if (r0 != r14) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00fa, code lost:
        r6 = r6 | r22;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x019e, code lost:
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01d5, code lost:
        r6 = r6 | r22;
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x020c, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x020e, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0211, code lost:
        r2 = r8;
        r28 = r9;
        r24 = r10;
        r18 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02a9, code lost:
        if (r0 != r32) goto L_0x02ab;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzu(java.lang.Object r30, byte[] r31, int r32, int r33, com.google.android.gms.internal.measurement.zzio r34) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            sun.misc.Unsafe r9 = zzb
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r16 = 0
            r8 = -1
            r0 = r32
            r1 = r8
            r7 = r10
            r2 = r16
            r6 = r2
        L_0x0019:
            if (r0 >= r13) goto L_0x0341
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.measurement.zzip.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002e
        L_0x002b:
            r17 = r0
            r4 = r3
        L_0x002e:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003b
            int r2 = r2 / 3
            int r0 = r15.zzx(r5, r2)
            goto L_0x003f
        L_0x003b:
            int r0 = r15.zzw(r5)
        L_0x003f:
            r2 = r0
            if (r2 != r8) goto L_0x004d
            r2 = r4
            r21 = r5
            r18 = r8
            r28 = r9
            r24 = r16
            goto L_0x031a
        L_0x004d:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r8 = zzA(r1)
            r32 = r5
            r5 = r1 & r10
            long r10 = (long) r5
            r5 = 17
            r20 = r10
            if (r8 > r5) goto L_0x021a
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r11 = 1
            int r22 = r11 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            if (r0 == r7) goto L_0x007f
            if (r7 == r5) goto L_0x0077
            long r10 = (long) r7
            r9.putInt(r14, r10, r6)
        L_0x0077:
            if (r0 == r5) goto L_0x007e
            long r6 = (long) r0
            int r6 = r9.getInt(r14, r6)
        L_0x007e:
            r7 = r0
        L_0x007f:
            r0 = 5
            switch(r8) {
                case 0: goto L_0x01f4;
                case 1: goto L_0x01da;
                case 2: goto L_0x01b8;
                case 3: goto L_0x01b8;
                case 4: goto L_0x01a1;
                case 5: goto L_0x0182;
                case 6: goto L_0x016c;
                case 7: goto L_0x014c;
                case 8: goto L_0x0129;
                case 9: goto L_0x00ff;
                case 10: goto L_0x00e5;
                case 11: goto L_0x01a1;
                case 12: goto L_0x00d0;
                case 13: goto L_0x016c;
                case 14: goto L_0x0182;
                case 15: goto L_0x00b7;
                case 16: goto L_0x008d;
                default: goto L_0x0083;
            }
        L_0x0083:
            r21 = r32
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = r5
            goto L_0x0211
        L_0x008d:
            if (r3 != 0) goto L_0x00ae
            r11 = r34
            r0 = r20
            int r8 = com.google.android.gms.internal.measurement.zzip.zzm(r12, r4, r11)
            long r3 = r11.zzb
            long r19 = com.google.android.gms.internal.measurement.zzjf.zzc(r3)
            r3 = r0
            r0 = r9
            r1 = r30
            r10 = r2
            r2 = r3
            r21 = r32
            r24 = r5
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x01d5
        L_0x00ae:
            r21 = r32
            r11 = r34
            r10 = r2
            r24 = r5
            goto L_0x019e
        L_0x00b7:
            r11 = r34
            r10 = r2
            r24 = r5
            r0 = r20
            r21 = r32
            if (r3 != 0) goto L_0x019e
            int r2 = com.google.android.gms.internal.measurement.zzip.zzj(r12, r4, r11)
            int r3 = r11.zza
            int r3 = com.google.android.gms.internal.measurement.zzjf.zzb(r3)
            r9.putInt(r14, r0, r3)
            goto L_0x00fa
        L_0x00d0:
            r11 = r34
            r10 = r2
            r24 = r5
            r0 = r20
            r21 = r32
            if (r3 != 0) goto L_0x019e
            int r2 = com.google.android.gms.internal.measurement.zzip.zzj(r12, r4, r11)
            int r3 = r11.zza
            r9.putInt(r14, r0, r3)
            goto L_0x00fa
        L_0x00e5:
            r11 = r34
            r10 = r2
            r24 = r5
            r0 = r20
            r2 = 2
            r21 = r32
            if (r3 != r2) goto L_0x019e
            int r2 = com.google.android.gms.internal.measurement.zzip.zza(r12, r4, r11)
            java.lang.Object r3 = r11.zzc
            r9.putObject(r14, r0, r3)
        L_0x00fa:
            r6 = r6 | r22
            r0 = r2
            goto L_0x025d
        L_0x00ff:
            r11 = r34
            r10 = r2
            r24 = r5
            r0 = r20
            r2 = 2
            r21 = r32
            if (r3 != r2) goto L_0x019e
            com.google.android.gms.internal.measurement.zzlu r2 = r15.zzE(r10)
            int r2 = com.google.android.gms.internal.measurement.zzip.zzd(r2, r12, r4, r13, r11)
            java.lang.Object r3 = r9.getObject(r14, r0)
            if (r3 != 0) goto L_0x011f
            java.lang.Object r3 = r11.zzc
            r9.putObject(r14, r0, r3)
            goto L_0x00fa
        L_0x011f:
            java.lang.Object r4 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkk.zzg(r3, r4)
            r9.putObject(r14, r0, r3)
            goto L_0x00fa
        L_0x0129:
            r11 = r34
            r10 = r2
            r24 = r5
            r25 = r20
            r0 = 2
            r21 = r32
            if (r3 != r0) goto L_0x019e
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x013f
            int r0 = com.google.android.gms.internal.measurement.zzip.zzg(r12, r4, r11)
            goto L_0x0143
        L_0x013f:
            int r0 = com.google.android.gms.internal.measurement.zzip.zzh(r12, r4, r11)
        L_0x0143:
            java.lang.Object r1 = r11.zzc
            r2 = r25
            r9.putObject(r14, r2, r1)
            goto L_0x020e
        L_0x014c:
            r11 = r34
            r10 = r2
            r24 = r5
            r1 = r20
            r21 = r32
            if (r3 != 0) goto L_0x019e
            int r0 = com.google.android.gms.internal.measurement.zzip.zzm(r12, r4, r11)
            long r3 = r11.zzb
            r19 = 0
            int r3 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r3 == 0) goto L_0x0165
            r3 = 1
            goto L_0x0167
        L_0x0165:
            r3 = r16
        L_0x0167:
            com.google.android.gms.internal.measurement.zzmv.zzm(r14, r1, r3)
            goto L_0x020e
        L_0x016c:
            r11 = r34
            r10 = r2
            r24 = r5
            r1 = r20
            r21 = r32
            if (r3 != r0) goto L_0x019e
            int r0 = com.google.android.gms.internal.measurement.zzip.zzb(r12, r4)
            r9.putInt(r14, r1, r0)
            int r0 = r4 + 4
            goto L_0x020e
        L_0x0182:
            r11 = r34
            r10 = r2
            r24 = r5
            r1 = r20
            r0 = 1
            r21 = r32
            if (r3 != r0) goto L_0x019e
            long r19 = com.google.android.gms.internal.measurement.zzip.zzn(r12, r4)
            r0 = r9
            r2 = r1
            r1 = r30
            r8 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x020c
        L_0x019e:
            r8 = r4
            goto L_0x0211
        L_0x01a1:
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = r5
            r4 = r20
            r21 = r32
            if (r3 != 0) goto L_0x0211
            int r0 = com.google.android.gms.internal.measurement.zzip.zzj(r12, r8, r11)
            int r1 = r11.zza
            r9.putInt(r14, r4, r1)
            goto L_0x020e
        L_0x01b8:
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = r5
            r4 = r20
            r21 = r32
            if (r3 != 0) goto L_0x0211
            int r8 = com.google.android.gms.internal.measurement.zzip.zzm(r12, r8, r11)
            long r2 = r11.zzb
            r0 = r9
            r1 = r30
            r19 = r2
            r2 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
        L_0x01d5:
            r6 = r6 | r22
            r0 = r8
            goto L_0x025d
        L_0x01da:
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = r5
            r4 = r20
            r21 = r32
            if (r3 != r0) goto L_0x0211
            int r0 = com.google.android.gms.internal.measurement.zzip.zzb(r12, r8)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zzmv.zzp(r14, r4, r0)
            int r0 = r8 + 4
            goto L_0x020e
        L_0x01f4:
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = r5
            r4 = r20
            r0 = 1
            r21 = r32
            if (r3 != r0) goto L_0x0211
            long r0 = com.google.android.gms.internal.measurement.zzip.zzn(r12, r8)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zzmv.zzo(r14, r4, r0)
        L_0x020c:
            int r0 = r8 + 8
        L_0x020e:
            r6 = r6 | r22
            goto L_0x025d
        L_0x0211:
            r2 = r8
            r28 = r9
            r24 = r10
            r18 = -1
            goto L_0x031a
        L_0x021a:
            r11 = r34
            r10 = r2
            r2 = r4
            r4 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            r0 = 27
            if (r8 != r0) goto L_0x0271
            r0 = 2
            if (r3 != r0) goto L_0x0265
            java.lang.Object r0 = r9.getObject(r14, r4)
            com.google.android.gms.internal.measurement.zzkj r0 = (com.google.android.gms.internal.measurement.zzkj) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0249
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0241
            r1 = 10
            goto L_0x0242
        L_0x0241:
            int r1 = r1 + r1
        L_0x0242:
            com.google.android.gms.internal.measurement.zzkj r0 = r0.zzd(r1)
            r9.putObject(r14, r4, r0)
        L_0x0249:
            r5 = r0
            com.google.android.gms.internal.measurement.zzlu r0 = r15.zzE(r10)
            r1 = r17
            r3 = r2
            r2 = r31
            r4 = r33
            r8 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.measurement.zzip.zze(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
        L_0x025d:
            r2 = r10
            r1 = r21
            r10 = r24
            r8 = -1
            goto L_0x0019
        L_0x0265:
            r14 = r2
            r23 = r6
            r15 = r7
            r28 = r9
            r24 = r10
            r18 = -1
            goto L_0x02f8
        L_0x0271:
            r0 = 49
            if (r8 > r0) goto L_0x02c7
            long r0 = (long) r1
            r19 = r0
            r0 = r29
            r1 = r30
            r32 = r2
            r2 = r31
            r22 = r3
            r3 = r32
            r25 = r4
            r4 = r33
            r5 = r17
            r15 = r6
            r6 = r21
            r23 = r15
            r15 = r7
            r7 = r22
            r27 = r8
            r18 = -1
            r8 = r10
            r28 = r9
            r24 = r10
            r9 = r19
            r11 = r27
            r12 = r25
            r14 = r34
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            r14 = r32
            if (r0 == r14) goto L_0x02c5
        L_0x02ab:
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r7 = r15
            r8 = r18
            r1 = r21
            r6 = r23
            r2 = r24
            r9 = r28
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r15 = r29
            goto L_0x0019
        L_0x02c5:
            r2 = r0
            goto L_0x02f9
        L_0x02c7:
            r14 = r2
            r22 = r3
            r25 = r4
            r23 = r6
            r15 = r7
            r27 = r8
            r28 = r9
            r24 = r10
            r18 = -1
            r0 = 50
            r9 = r27
            if (r9 != r0) goto L_0x02fd
            r7 = r22
            r0 = 2
            if (r7 != r0) goto L_0x02f8
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r14
            r4 = r33
            r5 = r24
            r6 = r25
            r8 = r34
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r14) goto L_0x02c5
            goto L_0x02ab
        L_0x02f8:
            r2 = r14
        L_0x02f9:
            r7 = r15
            r6 = r23
            goto L_0x031a
        L_0x02fd:
            r7 = r22
            r0 = r29
            r8 = r1
            r1 = r30
            r2 = r31
            r3 = r14
            r4 = r33
            r5 = r17
            r6 = r21
            r10 = r25
            r12 = r24
            r13 = r34
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r14) goto L_0x02c5
            goto L_0x02ab
        L_0x031a:
            com.google.android.gms.internal.measurement.zzmm r4 = zzd(r30)
            r0 = r17
            r1 = r31
            r3 = r33
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzip.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r8 = r18
            r1 = r21
            r2 = r24
            r9 = r28
            r10 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0019
        L_0x0341:
            r23 = r6
            r15 = r7
            r28 = r9
            r1 = r10
            if (r15 == r1) goto L_0x0353
            long r1 = (long) r15
            r3 = r30
            r6 = r23
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x0353:
            r1 = r33
            if (r0 != r1) goto L_0x0358
            return r0
        L_0x0358:
            com.google.android.gms.internal.measurement.zzkm r0 = com.google.android.gms.internal.measurement.zzkm.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlm.zzu(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzio):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0450 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01cf  */
    private final int zzv(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.measurement.zzio r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzkj r12 = (com.google.android.gms.internal.measurement.zzkj) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.gms.internal.measurement.zzkj r12 = r12.zzd(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03e1;
                case 19: goto L_0x0394;
                case 20: goto L_0x0351;
                case 21: goto L_0x0351;
                case 22: goto L_0x0336;
                case 23: goto L_0x02f5;
                case 24: goto L_0x02b4;
                case 25: goto L_0x025a;
                case 26: goto L_0x01a7;
                case 27: goto L_0x018c;
                case 28: goto L_0x0132;
                case 29: goto L_0x0336;
                case 30: goto L_0x00fa;
                case 31: goto L_0x02b4;
                case 32: goto L_0x02f5;
                case 33: goto L_0x00ab;
                case 34: goto L_0x005c;
                case 35: goto L_0x03e1;
                case 36: goto L_0x0394;
                case 37: goto L_0x0351;
                case 38: goto L_0x0351;
                case 39: goto L_0x0336;
                case 40: goto L_0x02f5;
                case 41: goto L_0x02b4;
                case 42: goto L_0x025a;
                case 43: goto L_0x0336;
                case 44: goto L_0x00fa;
                case 45: goto L_0x02b4;
                case 46: goto L_0x02f5;
                case 47: goto L_0x00ab;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x044f
            com.google.android.gms.internal.measurement.zzlu r1 = r15.zzE(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.measurement.zzip.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.gms.internal.measurement.zzky r12 = (com.google.android.gms.internal.measurement.zzky) r12
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.measurement.zzjf.zzc(r4)
            r12.zzg(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x0450
        L_0x007b:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzky r12 = (com.google.android.gms.internal.measurement.zzky) r12
            int r1 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzjf.zzc(r8)
            r12.zzg(r8)
        L_0x0091:
            if (r1 >= r5) goto L_0x00aa
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            int r1 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzjf.zzc(r8)
            r12.zzg(r8)
            goto L_0x0091
        L_0x00aa:
            return r1
        L_0x00ab:
            if (r6 != r14) goto L_0x00cf
            com.google.android.gms.internal.measurement.zzkd r12 = (com.google.android.gms.internal.measurement.zzkd) r12
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b6:
            if (r1 >= r2) goto L_0x00c6
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzjf.zzb(r4)
            r12.zzh(r4)
            goto L_0x00b6
        L_0x00c6:
            if (r1 != r2) goto L_0x00ca
            goto L_0x0450
        L_0x00ca:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x00cf:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzkd r12 = (com.google.android.gms.internal.measurement.zzkd) r12
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzjf.zzb(r4)
            r12.zzh(r4)
        L_0x00e0:
            if (r1 >= r5) goto L_0x00f9
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzjf.zzb(r4)
            r12.zzh(r4)
            goto L_0x00e0
        L_0x00f9:
            return r1
        L_0x00fa:
            if (r6 != r14) goto L_0x0101
            int r2 = com.google.android.gms.internal.measurement.zzip.zzf(r3, r4, r12, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x044f
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.measurement.zzip.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.gms.internal.measurement.zzkc r1 = (com.google.android.gms.internal.measurement.zzkc) r1
            com.google.android.gms.internal.measurement.zzmm r3 = r1.zzc
            com.google.android.gms.internal.measurement.zzmm r4 = com.google.android.gms.internal.measurement.zzmm.zzc()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.measurement.zzkg r4 = r15.zzD(r8)
            com.google.android.gms.internal.measurement.zzml r5 = r0.zzn
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzlw.zzC(r6, r12, r4, r3, r5)
            if (r3 != 0) goto L_0x012d
            goto L_0x027b
        L_0x012d:
            com.google.android.gms.internal.measurement.zzmm r3 = (com.google.android.gms.internal.measurement.zzmm) r3
            r1.zzc = r3
            return r2
        L_0x0132:
            if (r6 != r14) goto L_0x044f
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0187
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0182
            if (r4 != 0) goto L_0x0148
            com.google.android.gms.internal.measurement.zzjb r4 = com.google.android.gms.internal.measurement.zzjb.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x0148:
            com.google.android.gms.internal.measurement.zzjb r6 = com.google.android.gms.internal.measurement.zzjb.zzl(r3, r1, r4)
            r12.add(r6)
        L_0x014f:
            int r1 = r1 + r4
        L_0x0150:
            if (r1 >= r5) goto L_0x0181
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x015b
            goto L_0x0181
        L_0x015b:
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x017c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0177
            if (r4 != 0) goto L_0x016f
            com.google.android.gms.internal.measurement.zzjb r4 = com.google.android.gms.internal.measurement.zzjb.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x016f:
            com.google.android.gms.internal.measurement.zzjb r6 = com.google.android.gms.internal.measurement.zzjb.zzl(r3, r1, r4)
            r12.add(r6)
            goto L_0x014f
        L_0x0177:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x017c:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzd()
            throw r1
        L_0x0181:
            return r1
        L_0x0182:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x0187:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzd()
            throw r1
        L_0x018c:
            if (r6 == r14) goto L_0x0190
            goto L_0x044f
        L_0x0190:
            com.google.android.gms.internal.measurement.zzlu r1 = r15.zzE(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.measurement.zzip.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x01a7:
            if (r6 != r14) goto L_0x044f
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x01fa
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f5
            if (r4 != 0) goto L_0x01c2
            r12.add(r6)
            goto L_0x01cd
        L_0x01c2:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkk.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
        L_0x01cc:
            int r1 = r1 + r4
        L_0x01cd:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f0
            if (r4 != 0) goto L_0x01e5
            r12.add(r6)
            goto L_0x01cd
        L_0x01e5:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkk.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
            goto L_0x01cc
        L_0x01f0:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzd()
            throw r1
        L_0x01f5:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzd()
            throw r1
        L_0x01fa:
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0255
            if (r4 != 0) goto L_0x0208
            r12.add(r6)
            goto L_0x021b
        L_0x0208:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.zzna.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0250
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzkk.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
        L_0x021a:
            r1 = r8
        L_0x021b:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x024b
            if (r4 != 0) goto L_0x0233
            r12.add(r6)
            goto L_0x021b
        L_0x0233:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.zzna.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0246
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzkk.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
            goto L_0x021a
        L_0x0246:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzc()
            throw r1
        L_0x024b:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzd()
            throw r1
        L_0x0250:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzc()
            throw r1
        L_0x0255:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzd()
            throw r1
        L_0x025a:
            r1 = 0
            if (r6 != r14) goto L_0x0283
            com.google.android.gms.internal.measurement.zziq r12 = (com.google.android.gms.internal.measurement.zziq) r12
            int r2 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0266:
            if (r2 >= r4) goto L_0x0279
            int r2 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r2, r7)
            long r5 = r7.zzb
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x0274
            r5 = r13
            goto L_0x0275
        L_0x0274:
            r5 = r1
        L_0x0275:
            r12.zze(r5)
            goto L_0x0266
        L_0x0279:
            if (r2 != r4) goto L_0x027e
        L_0x027b:
            r1 = r2
            goto L_0x0450
        L_0x027e:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x0283:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zziq r12 = (com.google.android.gms.internal.measurement.zziq) r12
            int r4 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0293
            r6 = r13
            goto L_0x0294
        L_0x0293:
            r6 = r1
        L_0x0294:
            r12.zze(r6)
        L_0x0297:
            if (r4 >= r5) goto L_0x02b3
            int r6 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x02a2
            goto L_0x02b3
        L_0x02a2:
            int r4 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = r13
            goto L_0x02af
        L_0x02ae:
            r6 = r1
        L_0x02af:
            r12.zze(r6)
            goto L_0x0297
        L_0x02b3:
            return r4
        L_0x02b4:
            if (r6 != r14) goto L_0x02d4
            com.google.android.gms.internal.measurement.zzkd r12 = (com.google.android.gms.internal.measurement.zzkd) r12
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02bf:
            if (r1 >= r2) goto L_0x02cb
            int r4 = com.google.android.gms.internal.measurement.zzip.zzb(r3, r1)
            r12.zzh(r4)
            int r1 = r1 + 4
            goto L_0x02bf
        L_0x02cb:
            if (r1 != r2) goto L_0x02cf
            goto L_0x0450
        L_0x02cf:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x02d4:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.measurement.zzkd r12 = (com.google.android.gms.internal.measurement.zzkd) r12
            int r1 = com.google.android.gms.internal.measurement.zzip.zzb(r17, r18)
            r12.zzh(r1)
        L_0x02df:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02f4
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ec
            goto L_0x02f4
        L_0x02ec:
            int r1 = com.google.android.gms.internal.measurement.zzip.zzb(r3, r4)
            r12.zzh(r1)
            goto L_0x02df
        L_0x02f4:
            return r1
        L_0x02f5:
            if (r6 != r14) goto L_0x0315
            com.google.android.gms.internal.measurement.zzky r12 = (com.google.android.gms.internal.measurement.zzky) r12
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0300:
            if (r1 >= r2) goto L_0x030c
            long r4 = com.google.android.gms.internal.measurement.zzip.zzn(r3, r1)
            r12.zzg(r4)
            int r1 = r1 + 8
            goto L_0x0300
        L_0x030c:
            if (r1 != r2) goto L_0x0310
            goto L_0x0450
        L_0x0310:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x0315:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.measurement.zzky r12 = (com.google.android.gms.internal.measurement.zzky) r12
            long r8 = com.google.android.gms.internal.measurement.zzip.zzn(r17, r18)
            r12.zzg(r8)
        L_0x0320:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0335
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032d
            goto L_0x0335
        L_0x032d:
            long r8 = com.google.android.gms.internal.measurement.zzip.zzn(r3, r4)
            r12.zzg(r8)
            goto L_0x0320
        L_0x0335:
            return r1
        L_0x0336:
            if (r6 != r14) goto L_0x033e
            int r1 = com.google.android.gms.internal.measurement.zzip.zzf(r3, r4, r12, r7)
            goto L_0x0450
        L_0x033e:
            if (r6 == 0) goto L_0x0342
            goto L_0x044f
        L_0x0342:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.measurement.zzip.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0351:
            if (r6 != r14) goto L_0x0371
            com.google.android.gms.internal.measurement.zzky r12 = (com.google.android.gms.internal.measurement.zzky) r12
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x035c:
            if (r1 >= r2) goto L_0x0368
            int r1 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r12.zzg(r4)
            goto L_0x035c
        L_0x0368:
            if (r1 != r2) goto L_0x036c
            goto L_0x0450
        L_0x036c:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x0371:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzky r12 = (com.google.android.gms.internal.measurement.zzky) r12
            int r1 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
        L_0x037e:
            if (r1 >= r5) goto L_0x0393
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0389
            goto L_0x0393
        L_0x0389:
            int r1 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
            goto L_0x037e
        L_0x0393:
            return r1
        L_0x0394:
            if (r6 != r14) goto L_0x03b8
            com.google.android.gms.internal.measurement.zzjv r12 = (com.google.android.gms.internal.measurement.zzjv) r12
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x039f:
            if (r1 >= r2) goto L_0x03af
            int r4 = com.google.android.gms.internal.measurement.zzip.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.zze(r4)
            int r1 = r1 + 4
            goto L_0x039f
        L_0x03af:
            if (r1 != r2) goto L_0x03b3
            goto L_0x0450
        L_0x03b3:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x03b8:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.measurement.zzjv r12 = (com.google.android.gms.internal.measurement.zzjv) r12
            int r1 = com.google.android.gms.internal.measurement.zzip.zzb(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
        L_0x03c7:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03e0
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03d4
            goto L_0x03e0
        L_0x03d4:
            int r1 = com.google.android.gms.internal.measurement.zzip.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
            goto L_0x03c7
        L_0x03e0:
            return r1
        L_0x03e1:
            if (r6 != r14) goto L_0x0404
            com.google.android.gms.internal.measurement.zzjl r12 = (com.google.android.gms.internal.measurement.zzjl) r12
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ec:
            if (r1 >= r2) goto L_0x03fc
            long r4 = com.google.android.gms.internal.measurement.zzip.zzn(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zze(r4)
            int r1 = r1 + 8
            goto L_0x03ec
        L_0x03fc:
            if (r1 != r2) goto L_0x03ff
            goto L_0x0450
        L_0x03ff:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x0404:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.measurement.zzjl r12 = (com.google.android.gms.internal.measurement.zzjl) r12
            long r8 = com.google.android.gms.internal.measurement.zzip.zzn(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
        L_0x0413:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x042c
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0420
            goto L_0x042c
        L_0x0420:
            long r8 = com.google.android.gms.internal.measurement.zzip.zzn(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
            goto L_0x0413
        L_0x042c:
            return r1
        L_0x042d:
            if (r4 >= r5) goto L_0x044e
            int r8 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x0438
            goto L_0x044e
        L_0x0438:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.measurement.zzip.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x044e:
            return r4
        L_0x044f:
            r1 = r4
        L_0x0450:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlm.zzv(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzio):int");
    }

    private final int zzw(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, 0);
    }

    private final int zzx(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, i2);
    }

    private final int zzy(int i) {
        return this.zzc[i + 2];
    }

    private final int zzz(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final int zza(Object obj) {
        return this.zzi ? zzq(obj) : zzp(obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0226, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0227, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022b
            int r3 = r8.zzB(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzA(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020d;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01e5;
                case 6: goto L_0x01de;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01ac;
                case 11: goto L_0x01a4;
                case 12: goto L_0x019c;
                case 13: goto L_0x0194;
                case 14: goto L_0x0188;
                case 15: goto L_0x0180;
                case 16: goto L_0x0174;
                case 17: goto L_0x0169;
                case 18: goto L_0x015d;
                case 19: goto L_0x015d;
                case 20: goto L_0x015d;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                case 23: goto L_0x015d;
                case 24: goto L_0x015d;
                case 25: goto L_0x015d;
                case 26: goto L_0x015d;
                case 27: goto L_0x015d;
                case 28: goto L_0x015d;
                case 29: goto L_0x015d;
                case 30: goto L_0x015d;
                case 31: goto L_0x015d;
                case 32: goto L_0x015d;
                case 33: goto L_0x015d;
                case 34: goto L_0x015d;
                case 35: goto L_0x015d;
                case 36: goto L_0x015d;
                case 37: goto L_0x015d;
                case 38: goto L_0x015d;
                case 39: goto L_0x015d;
                case 40: goto L_0x015d;
                case 41: goto L_0x015d;
                case 42: goto L_0x015d;
                case 43: goto L_0x015d;
                case 44: goto L_0x015d;
                case 45: goto L_0x015d;
                case 46: goto L_0x015d;
                case 47: goto L_0x015d;
                case 48: goto L_0x015d;
                case 49: goto L_0x015d;
                case 50: goto L_0x0151;
                case 51: goto L_0x013b;
                case 52: goto L_0x0129;
                case 53: goto L_0x0117;
                case 54: goto L_0x0105;
                case 55: goto L_0x00f7;
                case 56: goto L_0x00e5;
                case 57: goto L_0x00d7;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0227
        L_0x001f:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            boolean r3 = zzS(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zza(r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            float r3 = zzo(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            double r3 = zzn(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmv.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzc(r9, r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmv.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzc(r9, r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzc(r9, r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzc(r9, r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.zzmv.zzw(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zza(r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzc(r9, r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmv.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzc(r9, r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmv.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmv.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.zzmv.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.zzmv.zza(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzml r0 = r8.zzn
            java.lang.Object r0 = r0.zzc(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 != 0) goto L_0x023d
            return r2
        L_0x023d:
            com.google.android.gms.internal.measurement.zzjp r0 = r8.zzo
            r0.zza(r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlm.zzb(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v90, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x036a, code lost:
        if (r0 != r15) goto L_0x036c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0386, code lost:
        r2 = r0;
        r7 = r18;
        r6 = r25;
        r0 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x03b6, code lost:
        if (r0 != r15) goto L_0x036c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x03db, code lost:
        if (r0 != r15) goto L_0x036c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0167, code lost:
        r5 = r6 | r24;
        r0 = r2;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x016b, code lost:
        r1 = r11;
        r6 = r25;
        r2 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0205, code lost:
        r5 = r6 | r24;
        r2 = r32;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x020a, code lost:
        r1 = r11;
        r6 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x020d, code lost:
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0235, code lost:
        r13 = r4;
        r18 = r11;
        r11 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02ab, code lost:
        r0 = r11 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02ad, code lost:
        r5 = r6 | r24;
        r2 = r32;
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02b3, code lost:
        r3 = r13;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02c6, code lost:
        r24 = r32;
        r0 = r34;
        r21 = r6;
        r28 = r10;
        r2 = r11;
        r19 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0425  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.measurement.zzio r35) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r32
            r1 = r16
            r3 = r1
            r5 = r3
            r2 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            r17 = 0
            if (r0 >= r13) goto L_0x044a
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002d
            int r0 = com.google.android.gms.internal.measurement.zzip.zzk(r0, r12, r1, r9)
            int r1 = r9.zza
            r4 = r1
            r1 = r0
            goto L_0x002e
        L_0x002d:
            r4 = r0
        L_0x002e:
            int r0 = r4 >>> 3
            r8 = r4 & 7
            r7 = 3
            if (r0 <= r2) goto L_0x003b
            int r3 = r3 / r7
            int r2 = r15.zzx(r0, r3)
            goto L_0x003f
        L_0x003b:
            int r2 = r15.zzw(r0)
        L_0x003f:
            r3 = -1
            if (r2 != r3) goto L_0x0051
            r24 = r0
            r2 = r1
            r20 = r3
            r7 = r4
            r21 = r5
            r28 = r10
            r0 = r11
            r19 = r16
            goto L_0x03de
        L_0x0051:
            int[] r3 = r15.zzc
            int r20 = r2 + 1
            r7 = r3[r20]
            int r11 = zzA(r7)
            r20 = r0
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r7 & r18
            r21 = r1
            long r0 = (long) r0
            r22 = r0
            r0 = 17
            if (r11 > r0) goto L_0x02d3
            int r0 = r2 + 2
            r0 = r3[r0]
            int r3 = r0 >>> 20
            r1 = 1
            int r24 = r1 << r3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r3
            if (r0 == r6) goto L_0x008a
            r18 = r4
            if (r6 == r3) goto L_0x0082
            long r3 = (long) r6
            r10.putInt(r14, r3, r5)
        L_0x0082:
            long r3 = (long) r0
            int r5 = r10.getInt(r14, r3)
            r25 = r0
            goto L_0x008e
        L_0x008a:
            r18 = r4
            r25 = r6
        L_0x008e:
            r6 = r5
            r0 = 5
            switch(r11) {
                case 0: goto L_0x0291;
                case 1: goto L_0x0275;
                case 2: goto L_0x0253;
                case 3: goto L_0x0253;
                case 4: goto L_0x023b;
                case 5: goto L_0x0211;
                case 6: goto L_0x01ec;
                case 7: goto L_0x01c8;
                case 8: goto L_0x01a3;
                case 9: goto L_0x0172;
                case 10: goto L_0x014d;
                case 11: goto L_0x023b;
                case 12: goto L_0x0116;
                case 13: goto L_0x01ec;
                case 14: goto L_0x0211;
                case 15: goto L_0x00f7;
                case 16: goto L_0x00c1;
                default: goto L_0x0093;
            }
        L_0x0093:
            r13 = r2
            r32 = r20
            r11 = r21
            r2 = r22
            r0 = 3
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x02c6
            com.google.android.gms.internal.measurement.zzlu r0 = r15.zzE(r13)
            int r1 = r32 << 3
            r4 = r1 | 4
            r1 = r31
            r7 = r2
            r2 = r11
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzip.zzc(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x02b8
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r7, r1)
            goto L_0x02ad
        L_0x00c1:
            if (r8 != 0) goto L_0x00eb
            r3 = r21
            int r7 = com.google.android.gms.internal.measurement.zzip.zzm(r12, r3, r9)
            long r0 = r9.zzb
            long r4 = com.google.android.gms.internal.measurement.zzjf.zzc(r0)
            r11 = r20
            r0 = r10
            r1 = r30
            r8 = r2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r2 = r22
            r32 = r11
            r11 = r18
            r0.putLong(r1, r2, r4)
            r5 = r6 | r24
            r2 = r32
            r0 = r7
            r3 = r8
            goto L_0x020a
        L_0x00eb:
            r32 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r13 = r2
            r11 = r21
            goto L_0x02c6
        L_0x00f7:
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x0235
            int r0 = com.google.android.gms.internal.measurement.zzip.zzj(r12, r3, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.measurement.zzjf.zzb(r1)
            r7 = r22
            r10.putInt(r14, r7, r1)
            goto L_0x0205
        L_0x0116:
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r0 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x0235
            int r2 = com.google.android.gms.internal.measurement.zzip.zzj(r12, r3, r9)
            int r3 = r9.zza
            com.google.android.gms.internal.measurement.zzkg r5 = r15.zzD(r4)
            if (r5 == 0) goto L_0x0149
            boolean r5 = r5.zza(r3)
            if (r5 == 0) goto L_0x0139
            goto L_0x0149
        L_0x0139:
            com.google.android.gms.internal.measurement.zzmm r0 = zzd(r30)
            long r7 = (long) r3
            java.lang.Long r1 = java.lang.Long.valueOf(r7)
            r0.zzh(r11, r1)
            r0 = r2
            r3 = r4
            r5 = r6
            goto L_0x016b
        L_0x0149:
            r10.putInt(r14, r0, r3)
            goto L_0x0167
        L_0x014d:
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r0 = r22
            r2 = 2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r2) goto L_0x0235
            int r2 = com.google.android.gms.internal.measurement.zzip.zza(r12, r3, r9)
            java.lang.Object r3 = r9.zzc
            r10.putObject(r14, r0, r3)
        L_0x0167:
            r5 = r6 | r24
            r0 = r2
            r3 = r4
        L_0x016b:
            r1 = r11
            r6 = r25
            r2 = r32
            goto L_0x020d
        L_0x0172:
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r0 = r22
            r2 = 2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r2) goto L_0x0235
            com.google.android.gms.internal.measurement.zzlu r2 = r15.zzE(r4)
            int r2 = com.google.android.gms.internal.measurement.zzip.zzd(r2, r12, r3, r13, r9)
            r3 = r6 & r24
            if (r3 != 0) goto L_0x0195
            java.lang.Object r3 = r9.zzc
            r10.putObject(r14, r0, r3)
            goto L_0x0167
        L_0x0195:
            java.lang.Object r3 = r10.getObject(r14, r0)
            java.lang.Object r5 = r9.zzc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkk.zzg(r3, r5)
            r10.putObject(r14, r0, r3)
            goto L_0x0167
        L_0x01a3:
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r0 = r22
            r2 = 2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r2) goto L_0x0235
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            r2 = r2 & r7
            if (r2 != 0) goto L_0x01be
            int r2 = com.google.android.gms.internal.measurement.zzip.zzg(r12, r3, r9)
            goto L_0x01c2
        L_0x01be:
            int r2 = com.google.android.gms.internal.measurement.zzip.zzh(r12, r3, r9)
        L_0x01c2:
            java.lang.Object r3 = r9.zzc
            r10.putObject(r14, r0, r3)
            goto L_0x0167
        L_0x01c8:
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r1 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x0235
            int r0 = com.google.android.gms.internal.measurement.zzip.zzm(r12, r3, r9)
            long r7 = r9.zzb
            r21 = 0
            int r3 = (r7 > r21 ? 1 : (r7 == r21 ? 0 : -1))
            if (r3 == 0) goto L_0x01e6
            r3 = 1
            goto L_0x01e8
        L_0x01e6:
            r3 = r16
        L_0x01e8:
            com.google.android.gms.internal.measurement.zzmv.zzm(r14, r1, r3)
            goto L_0x0205
        L_0x01ec:
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r1 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x0235
            int r0 = com.google.android.gms.internal.measurement.zzip.zzb(r12, r3)
            r10.putInt(r14, r1, r0)
            int r0 = r3 + 4
        L_0x0205:
            r5 = r6 | r24
            r2 = r32
            r3 = r4
        L_0x020a:
            r1 = r11
            r6 = r25
        L_0x020d:
            r11 = r34
            goto L_0x001a
        L_0x0211:
            r0 = r1
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r1 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x0235
            long r7 = com.google.android.gms.internal.measurement.zzip.zzn(r12, r3)
            r0 = r10
            r5 = r3
            r2 = r1
            r1 = r30
            r13 = r4
            r18 = r11
            r11 = r5
            r4 = r7
            r0.putLong(r1, r2, r4)
            goto L_0x02ab
        L_0x0235:
            r13 = r4
            r18 = r11
            r11 = r3
            goto L_0x02c6
        L_0x023b:
            r13 = r2
            r32 = r20
            r11 = r21
            r2 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x02c6
            int r0 = com.google.android.gms.internal.measurement.zzip.zzj(r12, r11, r9)
            int r1 = r9.zza
            r10.putInt(r14, r2, r1)
            goto L_0x02ad
        L_0x0253:
            r13 = r2
            r32 = r20
            r11 = r21
            r2 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x02c6
            int r7 = com.google.android.gms.internal.measurement.zzip.zzm(r12, r11, r9)
            long r4 = r9.zzb
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
            r5 = r6 | r24
            r2 = r32
            r11 = r34
            r0 = r7
            goto L_0x02b3
        L_0x0275:
            r13 = r2
            r32 = r20
            r11 = r21
            r2 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x02c6
            int r0 = com.google.android.gms.internal.measurement.zzip.zzb(r12, r11)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zzmv.zzp(r14, r2, r0)
            int r0 = r11 + 4
            goto L_0x02ad
        L_0x0291:
            r0 = r1
            r13 = r2
            r32 = r20
            r11 = r21
            r2 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x02c6
            long r0 = com.google.android.gms.internal.measurement.zzip.zzn(r12, r11)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zzmv.zzo(r14, r2, r0)
        L_0x02ab:
            int r0 = r11 + 8
        L_0x02ad:
            r5 = r6 | r24
            r2 = r32
            r11 = r34
        L_0x02b3:
            r3 = r13
            r1 = r18
            goto L_0x0324
        L_0x02b8:
            java.lang.Object r1 = r10.getObject(r14, r7)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkk.zzg(r1, r2)
            r10.putObject(r14, r7, r1)
            goto L_0x02ad
        L_0x02c6:
            r24 = r32
            r0 = r34
            r21 = r6
            r28 = r10
            r2 = r11
            r19 = r13
            goto L_0x03bc
        L_0x02d3:
            r13 = r2
            r18 = r4
            r3 = r11
            r4 = r20
            r11 = r21
            r1 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r0 = 27
            if (r3 != r0) goto L_0x0337
            r0 = 2
            if (r8 != r0) goto L_0x032a
            java.lang.Object r0 = r10.getObject(r14, r1)
            com.google.android.gms.internal.measurement.zzkj r0 = (com.google.android.gms.internal.measurement.zzkj) r0
            boolean r3 = r0.zzc()
            if (r3 != 0) goto L_0x0306
            int r3 = r0.size()
            if (r3 != 0) goto L_0x02fe
            r3 = 10
            goto L_0x02ff
        L_0x02fe:
            int r3 = r3 + r3
        L_0x02ff:
            com.google.android.gms.internal.measurement.zzkj r0 = r0.zzd(r3)
            r10.putObject(r14, r1, r0)
        L_0x0306:
            r7 = r0
            com.google.android.gms.internal.measurement.zzlu r0 = r15.zzE(r13)
            r1 = r18
            r2 = r31
            r3 = r11
            r8 = r4
            r4 = r33
            r21 = r5
            r5 = r7
            r25 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.measurement.zzip.zze(r0, r1, r2, r3, r4, r5, r6)
            r11 = r34
            r2 = r8
            r3 = r13
            r5 = r21
        L_0x0324:
            r6 = r25
            r13 = r33
            goto L_0x001a
        L_0x032a:
            r21 = r5
            r25 = r6
            r24 = r4
            r28 = r10
            r15 = r11
            r19 = r13
            goto L_0x03b9
        L_0x0337:
            r21 = r5
            r25 = r6
            r5 = r4
            r0 = 49
            if (r3 > r0) goto L_0x038f
            long r6 = (long) r7
            r0 = r29
            r22 = r1
            r1 = r30
            r2 = r31
            r4 = r3
            r3 = r11
            r32 = r4
            r4 = r33
            r24 = r5
            r5 = r18
            r26 = r6
            r6 = r24
            r7 = r8
            r8 = r13
            r28 = r10
            r9 = r26
            r15 = r11
            r11 = r32
            r19 = r13
            r12 = r22
            r14 = r35
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0386
        L_0x036c:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r1 = r18
            r3 = r19
            r5 = r21
            r2 = r24
            r6 = r25
        L_0x0382:
            r10 = r28
            goto L_0x001a
        L_0x0386:
            r2 = r0
            r7 = r18
            r6 = r25
            r0 = r34
            goto L_0x03de
        L_0x038f:
            r22 = r1
            r32 = r3
            r24 = r5
            r28 = r10
            r15 = r11
            r19 = r13
            r0 = 50
            r9 = r32
            if (r9 != r0) goto L_0x03c1
            r0 = 2
            if (r8 != r0) goto L_0x03b9
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r19
            r6 = r22
            r8 = r35
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x0386
            goto L_0x036c
        L_0x03b9:
            r0 = r34
            r2 = r15
        L_0x03bc:
            r7 = r18
            r6 = r25
            goto L_0x03de
        L_0x03c1:
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r24
            r10 = r7
            r7 = r8
            r8 = r10
            r10 = r22
            r12 = r19
            r13 = r35
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0386
            goto L_0x036c
        L_0x03de:
            if (r7 != r0) goto L_0x03ed
            if (r0 == 0) goto L_0x03ed
            r8 = r29
            r12 = r30
            r9 = r0
            r0 = r2
            r1 = r7
            r5 = r21
            goto L_0x0453
        L_0x03ed:
            r8 = r29
            r9 = r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x0425
            r10 = r35
            com.google.android.gms.internal.measurement.zzjo r0 = r10.zzd
            com.google.android.gms.internal.measurement.zzjo r1 = com.google.android.gms.internal.measurement.zzjo.zza()
            if (r0 == r1) goto L_0x0422
            com.google.android.gms.internal.measurement.zzlj r0 = r8.zzg
            com.google.android.gms.internal.measurement.zzjo r1 = r10.zzd
            r11 = r24
            com.google.android.gms.internal.measurement.zzka r0 = r1.zzc(r0, r11)
            if (r0 != 0) goto L_0x041c
            com.google.android.gms.internal.measurement.zzmm r4 = zzd(r30)
            r0 = r7
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzip.zzi(r0, r1, r2, r3, r4, r5)
            r12 = r30
            goto L_0x043a
        L_0x041c:
            r12 = r30
            r0 = r12
            com.google.android.gms.internal.measurement.zzjz r0 = (com.google.android.gms.internal.measurement.zzjz) r0
            throw r17
        L_0x0422:
            r12 = r30
            goto L_0x0429
        L_0x0425:
            r12 = r30
            r10 = r35
        L_0x0429:
            r11 = r24
            com.google.android.gms.internal.measurement.zzmm r4 = zzd(r30)
            r0 = r7
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzip.zzi(r0, r1, r2, r3, r4, r5)
        L_0x043a:
            r13 = r33
            r1 = r7
            r15 = r8
            r2 = r11
            r14 = r12
            r3 = r19
            r5 = r21
            r12 = r31
            r11 = r9
            r9 = r10
            goto L_0x0382
        L_0x044a:
            r21 = r5
            r25 = r6
            r28 = r10
            r9 = r11
            r12 = r14
            r8 = r15
        L_0x0453:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r2) goto L_0x045e
            long r3 = (long) r6
            r6 = r28
            r6.putInt(r12, r3, r5)
        L_0x045e:
            int r3 = r8.zzk
        L_0x0460:
            int r4 = r8.zzl
            if (r3 >= r4) goto L_0x048b
            int[] r4 = r8.zzj
            r4 = r4[r3]
            int[] r5 = r8.zzc
            r5 = r5[r4]
            int r5 = r8.zzB(r4)
            r5 = r5 & r2
            long r5 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r5)
            if (r5 != 0) goto L_0x0479
            goto L_0x047f
        L_0x0479:
            com.google.android.gms.internal.measurement.zzkg r6 = r8.zzD(r4)
            if (r6 != 0) goto L_0x0482
        L_0x047f:
            int r3 = r3 + 1
            goto L_0x0460
        L_0x0482:
            com.google.android.gms.internal.measurement.zzld r5 = (com.google.android.gms.internal.measurement.zzld) r5
            java.lang.Object r0 = r8.zzF(r4)
            com.google.android.gms.internal.measurement.zzlc r0 = (com.google.android.gms.internal.measurement.zzlc) r0
            throw r17
        L_0x048b:
            if (r9 != 0) goto L_0x0497
            r2 = r33
            if (r0 != r2) goto L_0x0492
            goto L_0x049d
        L_0x0492:
            com.google.android.gms.internal.measurement.zzkm r0 = com.google.android.gms.internal.measurement.zzkm.zze()
            throw r0
        L_0x0497:
            r2 = r33
            if (r0 > r2) goto L_0x049e
            if (r1 != r9) goto L_0x049e
        L_0x049d:
            return r0
        L_0x049e:
            com.google.android.gms.internal.measurement.zzkm r0 = com.google.android.gms.internal.measurement.zzkm.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlm.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzio):int");
    }

    public final Object zze() {
        return ((zzkc) this.zzg).zzl(4, (Object) null, (Object) null);
    }

    public final void zzf(Object obj) {
        int i;
        int i2 = this.zzk;
        while (true) {
            i = this.zzl;
            if (i2 >= i) {
                break;
            }
            long zzB = (long) (zzB(this.zzj[i2]) & 1048575);
            Object zzf2 = zzmv.zzf(obj, zzB);
            if (zzf2 != null) {
                ((zzld) zzf2).zzc();
                zzmv.zzs(obj, zzB, zzf2);
            }
            i2++;
        }
        int length = this.zzj.length;
        while (i < length) {
            this.zzm.zza(obj, (long) this.zzj[i]);
            i++;
        }
        this.zzn.zzg(obj);
        if (this.zzh) {
            this.zzo.zzb(obj);
        }
    }

    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzio zzio) throws IOException {
        if (this.zzi) {
            zzu(obj, bArr, i, i2, zzio);
        } else {
            zzc(obj, bArr, i, i2, 0, zzio);
        }
    }

    public final void zzi(Object obj, zznd zznd) throws IOException {
        if (!this.zzi) {
            zzL(obj, zznd);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzB = zzB(i);
                int i2 = this.zzc[i];
                switch (zzA(zzB)) {
                    case 0:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzf(i2, zzmv.zza(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 1:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzo(i2, zzmv.zzb(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 2:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzt(i2, zzmv.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 3:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzJ(i2, zzmv.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 4:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzr(i2, zzmv.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 5:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzm(i2, zzmv.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 6:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzk(i2, zzmv.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 7:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzb(i2, zzmv.zzw(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 8:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zzT(i2, zzmv.zzf(obj, (long) (zzB & 1048575)), zznd);
                            break;
                        }
                    case 9:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzv(i2, zzmv.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 10:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzd(i2, (zzjb) zzmv.zzf(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 11:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzH(i2, zzmv.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 12:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzi(i2, zzmv.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 13:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzw(i2, zzmv.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 14:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzy(i2, zzmv.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 15:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzA(i2, zzmv.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 16:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzC(i2, zzmv.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 17:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzq(i2, zzmv.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 18:
                        zzlw.zzJ(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 19:
                        zzlw.zzN(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 20:
                        zzlw.zzQ(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 21:
                        zzlw.zzY(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 22:
                        zzlw.zzP(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 23:
                        zzlw.zzM(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 24:
                        zzlw.zzL(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 25:
                        zzlw.zzH(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 26:
                        zzlw.zzW(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd);
                        break;
                    case 27:
                        zzlw.zzR(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, zzE(i));
                        break;
                    case 28:
                        zzlw.zzI(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd);
                        break;
                    case 29:
                        zzlw.zzX(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 30:
                        zzlw.zzK(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 31:
                        zzlw.zzS(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 32:
                        zzlw.zzT(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 33:
                        zzlw.zzU(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 34:
                        zzlw.zzV(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 35:
                        zzlw.zzJ(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 36:
                        zzlw.zzN(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 37:
                        zzlw.zzQ(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 38:
                        zzlw.zzY(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 39:
                        zzlw.zzP(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 40:
                        zzlw.zzM(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 41:
                        zzlw.zzL(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 42:
                        zzlw.zzH(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 43:
                        zzlw.zzX(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 44:
                        zzlw.zzK(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 45:
                        zzlw.zzS(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 46:
                        zzlw.zzT(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 47:
                        zzlw.zzU(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 48:
                        zzlw.zzV(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                        zzlw.zzO(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, zzE(i));
                        break;
                    case 50:
                        zzM(zznd, i2, zzmv.zzf(obj, (long) (zzB & 1048575)), i);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzf(i2, zzn(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 52:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzo(i2, zzo(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 53:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzt(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case Elf64_Ehdr.e_phentsize:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzJ(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 55:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzr(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 56:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzm(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 57:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzk(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case Elf64_Ehdr.e_shentsize:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzb(i2, zzS(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 59:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zzT(i2, zzmv.zzf(obj, (long) (zzB & 1048575)), zznd);
                            break;
                        }
                    case 60:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzv(i2, zzmv.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzd(i2, (zzjb) zzmv.zzf(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case Elf64_Ehdr.e_shstrndx:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzH(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case HtmlCompat.FROM_HTML_MODE_COMPACT:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzi(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 64:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzw(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzy(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 66:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzA(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 67:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzC(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 68:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzq(i2, zzmv.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                }
            }
            zzml zzml = this.zzn;
            zzml.zzi(zzml.zzc(obj), zznd);
        } else {
            this.zzo.zza(obj);
            throw null;
        }
    }

    public final boolean zzj(Object obj, Object obj2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzB = zzB(i);
            long j = (long) (zzB & 1048575);
            switch (zzA(zzB)) {
                case 0:
                    if (zzN(obj, obj2, i) && Double.doubleToLongBits(zzmv.zza(obj, j)) == Double.doubleToLongBits(zzmv.zza(obj2, j))) {
                        continue;
                    }
                case 1:
                    if (zzN(obj, obj2, i) && Float.floatToIntBits(zzmv.zzb(obj, j)) == Float.floatToIntBits(zzmv.zzb(obj2, j))) {
                        continue;
                    }
                case 2:
                    if (zzN(obj, obj2, i) && zzmv.zzd(obj, j) == zzmv.zzd(obj2, j)) {
                        continue;
                    }
                case 3:
                    if (zzN(obj, obj2, i) && zzmv.zzd(obj, j) == zzmv.zzd(obj2, j)) {
                        continue;
                    }
                case 4:
                    if (zzN(obj, obj2, i) && zzmv.zzc(obj, j) == zzmv.zzc(obj2, j)) {
                        continue;
                    }
                case 5:
                    if (zzN(obj, obj2, i) && zzmv.zzd(obj, j) == zzmv.zzd(obj2, j)) {
                        continue;
                    }
                case 6:
                    if (zzN(obj, obj2, i) && zzmv.zzc(obj, j) == zzmv.zzc(obj2, j)) {
                        continue;
                    }
                case 7:
                    if (zzN(obj, obj2, i) && zzmv.zzw(obj, j) == zzmv.zzw(obj2, j)) {
                        continue;
                    }
                case 8:
                    if (zzN(obj, obj2, i) && zzlw.zzZ(zzmv.zzf(obj, j), zzmv.zzf(obj2, j))) {
                        continue;
                    }
                case 9:
                    if (zzN(obj, obj2, i) && zzlw.zzZ(zzmv.zzf(obj, j), zzmv.zzf(obj2, j))) {
                        continue;
                    }
                case 10:
                    if (zzN(obj, obj2, i) && zzlw.zzZ(zzmv.zzf(obj, j), zzmv.zzf(obj2, j))) {
                        continue;
                    }
                case 11:
                    if (zzN(obj, obj2, i) && zzmv.zzc(obj, j) == zzmv.zzc(obj2, j)) {
                        continue;
                    }
                case 12:
                    if (zzN(obj, obj2, i) && zzmv.zzc(obj, j) == zzmv.zzc(obj2, j)) {
                        continue;
                    }
                case 13:
                    if (zzN(obj, obj2, i) && zzmv.zzc(obj, j) == zzmv.zzc(obj2, j)) {
                        continue;
                    }
                case 14:
                    if (zzN(obj, obj2, i) && zzmv.zzd(obj, j) == zzmv.zzd(obj2, j)) {
                        continue;
                    }
                case 15:
                    if (zzN(obj, obj2, i) && zzmv.zzc(obj, j) == zzmv.zzc(obj2, j)) {
                        continue;
                    }
                case 16:
                    if (zzN(obj, obj2, i) && zzmv.zzd(obj, j) == zzmv.zzd(obj2, j)) {
                        continue;
                    }
                case 17:
                    if (zzN(obj, obj2, i) && zzlw.zzZ(zzmv.zzf(obj, j), zzmv.zzf(obj2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                    z = zzlw.zzZ(zzmv.zzf(obj, j), zzmv.zzf(obj2, j));
                    break;
                case 50:
                    z = zzlw.zzZ(zzmv.zzf(obj, j), zzmv.zzf(obj2, j));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                case 52:
                case 53:
                case Elf64_Ehdr.e_phentsize:
                case 55:
                case 56:
                case 57:
                case Elf64_Ehdr.e_shentsize:
                case 59:
                case 60:
                case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                case Elf64_Ehdr.e_shstrndx:
                case HtmlCompat.FROM_HTML_MODE_COMPACT:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH:
                case 66:
                case 67:
                case 68:
                    long zzy = (long) (zzy(i) & 1048575);
                    if (zzmv.zzc(obj, zzy) == zzmv.zzc(obj2, zzy) && zzlw.zzZ(zzmv.zzf(obj, j), zzmv.zzf(obj2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzn.zzc(obj).equals(this.zzn.zzc(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        int i;
        int i2;
        Object obj2 = obj;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzk) {
            int i6 = this.zzj[i5];
            int i7 = this.zzc[i6];
            int zzB = zzB(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(obj2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzB) != 0 && !zzP(obj, i6, i2, i, i10)) {
                return false;
            }
            int zzA = zzA(zzB);
            if (zzA != 9 && zzA != 17) {
                if (zzA != 27) {
                    if (zzA == 60 || zzA == 68) {
                        if (zzR(obj2, i7, i6) && !zzQ(obj2, zzB, zzE(i6))) {
                            return false;
                        }
                    } else if (zzA != 49) {
                        if (zzA == 50 && !((zzld) zzmv.zzf(obj2, (long) (zzB & 1048575))).isEmpty()) {
                            zzlc zzlc = (zzlc) zzF(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzmv.zzf(obj2, (long) (zzB & 1048575));
                if (!list.isEmpty()) {
                    zzlu zzE = zzE(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzE.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzP(obj, i6, i2, i, i10) && !zzQ(obj2, zzB, zzE(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj2);
        throw null;
    }

    public final void zzg(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzB = zzB(i);
            long j = (long) (1048575 & zzB);
            int i2 = this.zzc[i];
            switch (zzA(zzB)) {
                case 0:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzo(obj, j, zzmv.zza(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 1:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzp(obj, j, zzmv.zzb(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 2:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzr(obj, j, zzmv.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 3:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzr(obj, j, zzmv.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 4:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzq(obj, j, zzmv.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 5:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzr(obj, j, zzmv.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 6:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzq(obj, j, zzmv.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 7:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzm(obj, j, zzmv.zzw(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 8:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzs(obj, j, zzmv.zzf(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 9:
                    zzH(obj, obj2, i);
                    break;
                case 10:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzs(obj, j, zzmv.zzf(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 11:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzq(obj, j, zzmv.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 12:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzq(obj, j, zzmv.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 13:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzq(obj, j, zzmv.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 14:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzr(obj, j, zzmv.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 15:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzq(obj, j, zzmv.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 16:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmv.zzr(obj, j, zzmv.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 17:
                    zzH(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                    this.zzm.zzb(obj, obj2, j);
                    break;
                case 50:
                    zzlw.zzaa(this.zzq, obj, obj2, j);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                case 52:
                case 53:
                case Elf64_Ehdr.e_phentsize:
                case 55:
                case 56:
                case 57:
                case Elf64_Ehdr.e_shentsize:
                case 59:
                    if (!zzR(obj2, i2, i)) {
                        break;
                    } else {
                        zzmv.zzs(obj, j, zzmv.zzf(obj2, j));
                        zzK(obj, i2, i);
                        break;
                    }
                case 60:
                    zzI(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                case Elf64_Ehdr.e_shstrndx:
                case HtmlCompat.FROM_HTML_MODE_COMPACT:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH:
                case 66:
                case 67:
                    if (!zzR(obj2, i2, i)) {
                        break;
                    } else {
                        zzmv.zzs(obj, j, zzmv.zzf(obj2, j));
                        zzK(obj, i2, i);
                        break;
                    }
                case 68:
                    zzI(obj, obj2, i);
                    break;
            }
        }
        zzlw.zzF(this.zzn, obj, obj2);
        if (this.zzh) {
            zzlw.zzE(this.zzo, obj, obj2);
        }
    }
}
