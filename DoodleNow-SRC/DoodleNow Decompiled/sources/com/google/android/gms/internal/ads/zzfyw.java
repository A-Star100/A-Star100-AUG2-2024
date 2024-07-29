package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfyw extends AbstractMap implements Serializable {
    /* access modifiers changed from: private */
    public static final Object zzd = new Object();
    @CheckForNull
    transient int[] zza;
    @CheckForNull
    transient Object[] zzb;
    @CheckForNull
    transient Object[] zzc;
    @CheckForNull
    private transient Object zze;
    /* access modifiers changed from: private */
    public transient int zzf;
    /* access modifiers changed from: private */
    public transient int zzg;
    @CheckForNull
    private transient Set zzh;
    @CheckForNull
    private transient Set zzi;
    @CheckForNull
    private transient Collection zzj;

    zzfyw() {
        zzp(3);
    }

    /* access modifiers changed from: private */
    public final int[] zzA() {
        return (int[]) Objects.requireNonNull(this.zza);
    }

    /* access modifiers changed from: private */
    public final Object[] zzB() {
        return (Object[]) Objects.requireNonNull(this.zzb);
    }

    /* access modifiers changed from: private */
    public final Object[] zzC() {
        return (Object[]) Objects.requireNonNull(this.zzc);
    }

    static /* synthetic */ Object zzg(zzfyw zzfyw, int i) {
        return zzfyw.zzB()[i];
    }

    static /* synthetic */ Object zzj(zzfyw zzfyw, int i) {
        return zzfyw.zzC()[i];
    }

    static /* synthetic */ void zzn(zzfyw zzfyw, int i, Object obj) {
        zzfyw.zzC()[i] = obj;
    }

    /* access modifiers changed from: private */
    public final int zzv() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* access modifiers changed from: private */
    public final int zzw(@CheckForNull Object obj) {
        if (zzr()) {
            return -1;
        }
        int zzb2 = zzfzf.zzb(obj);
        int zzv = zzv();
        int zzc2 = zzfyx.zzc(Objects.requireNonNull(this.zze), zzb2 & zzv);
        if (zzc2 != 0) {
            int i = ~zzv;
            int i2 = zzb2 & i;
            do {
                int i3 = zzc2 - 1;
                int i4 = zzA()[i3];
                if ((i4 & i) == i2 && zzfwl.zza(obj, zzB()[i3])) {
                    return i3;
                }
                zzc2 = i4 & zzv;
            } while (zzc2 != 0);
        }
        return -1;
    }

    private final int zzx(int i, int i2, int i3, int i4) {
        int i5 = i2 - 1;
        Object zzd2 = zzfyx.zzd(i2);
        if (i4 != 0) {
            zzfyx.zze(zzd2, i3 & i5, i4 + 1);
        }
        Object requireNonNull = Objects.requireNonNull(this.zze);
        int[] zzA = zzA();
        for (int i6 = 0; i6 <= i; i6++) {
            int zzc2 = zzfyx.zzc(requireNonNull, i6);
            while (zzc2 != 0) {
                int i7 = zzc2 - 1;
                int i8 = zzA[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int zzc3 = zzfyx.zzc(zzd2, i10);
                zzfyx.zze(zzd2, i10, zzc2);
                zzA[i7] = ((~i5) & i9) | (zzc3 & i5);
                zzc2 = i8 & i;
            }
        }
        this.zze = zzd2;
        zzz(i5);
        return i5;
    }

    /* access modifiers changed from: private */
    public final Object zzy(@CheckForNull Object obj) {
        int zzv;
        int zzb2;
        if (zzr() || (zzb2 = zzfyx.zzb(obj, (Object) null, zzv, Objects.requireNonNull(this.zze), zzA(), zzB(), (Object[]) null)) == -1) {
            return zzd;
        }
        Object obj2 = zzC()[zzb2];
        zzq(zzb2, (zzv = zzv()));
        this.zzg--;
        zzo();
        return obj2;
    }

    private final void zzz(int i) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i)) & 31) | (this.zzf & -32);
    }

    public final void clear() {
        if (!zzr()) {
            zzo();
            Map zzl = zzl();
            if (zzl != null) {
                this.zzf = zzgcl.zzc(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
                zzl.clear();
                this.zze = null;
                this.zzg = 0;
                return;
            }
            Arrays.fill(zzB(), 0, this.zzg, (Object) null);
            Arrays.fill(zzC(), 0, this.zzg, (Object) null);
            Object requireNonNull = Objects.requireNonNull(this.zze);
            if (requireNonNull instanceof byte[]) {
                Arrays.fill((byte[]) requireNonNull, (byte) 0);
            } else if (requireNonNull instanceof short[]) {
                Arrays.fill((short[]) requireNonNull, 0);
            } else {
                Arrays.fill((int[]) requireNonNull, 0);
            }
            Arrays.fill(zzA(), 0, this.zzg, 0);
            this.zzg = 0;
        }
    }

    public final boolean containsKey(@CheckForNull Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.containsKey(obj);
        }
        return zzw(obj) != -1;
    }

    public final boolean containsValue(@CheckForNull Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.containsValue(obj);
        }
        for (int i = 0; i < this.zzg; i++) {
            if (zzfwl.zza(obj, zzC()[i])) {
                return true;
            }
        }
        return false;
    }

    public final Set entrySet() {
        Set set = this.zzi;
        if (set != null) {
            return set;
        }
        zzfyq zzfyq = new zzfyq(this);
        this.zzi = zzfyq;
        return zzfyq;
    }

    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.get(obj);
        }
        int zzw = zzw(obj);
        if (zzw == -1) {
            return null;
        }
        return zzC()[zzw];
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Set keySet() {
        Set set = this.zzh;
        if (set != null) {
            return set;
        }
        zzfyt zzfyt = new zzfyt(this);
        this.zzh = zzfyt;
        return zzfyt;
    }

    @CheckForNull
    public final Object put(Object obj, Object obj2) {
        int min;
        Object obj3 = obj;
        Object obj4 = obj2;
        if (zzr()) {
            zzfwr.zzk(zzr(), "Arrays already allocated");
            int i = this.zzf;
            int max = Math.max(i + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max > ((int) ((double) highestOneBit)) && (highestOneBit = highestOneBit + highestOneBit) <= 0) {
                highestOneBit = 1073741824;
            }
            int max2 = Math.max(4, highestOneBit);
            this.zze = zzfyx.zzd(max2);
            zzz(max2 - 1);
            this.zza = new int[i];
            this.zzb = new Object[i];
            this.zzc = new Object[i];
        }
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.put(obj3, obj4);
        }
        int[] zzA = zzA();
        Object[] zzB = zzB();
        Object[] zzC = zzC();
        int i2 = this.zzg;
        int i3 = i2 + 1;
        int zzb2 = zzfzf.zzb(obj);
        int zzv = zzv();
        int i4 = zzb2 & zzv;
        int zzc2 = zzfyx.zzc(Objects.requireNonNull(this.zze), i4);
        if (zzc2 != 0) {
            int i5 = ~zzv;
            int i6 = zzb2 & i5;
            int i7 = 0;
            while (true) {
                int i8 = zzc2 - 1;
                int i9 = zzA[i8];
                int i10 = i9 & i5;
                if (i10 != i6 || !zzfwl.zza(obj3, zzB[i8])) {
                    int i11 = i9 & zzv;
                    i7++;
                    if (i11 != 0) {
                        zzc2 = i11;
                    } else if (i7 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzv() + 1, 1.0f);
                        for (int zze2 = zze(); zze2 >= 0; zze2 = zzf(zze2)) {
                            linkedHashMap.put(zzB()[zze2], zzC()[zze2]);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzo();
                        return linkedHashMap.put(obj3, obj4);
                    } else if (i3 > zzv) {
                        zzv = zzx(zzv, zzfyx.zza(zzv), zzb2, i2);
                    } else {
                        zzA[i8] = (i3 & zzv) | i10;
                    }
                } else {
                    Object obj5 = zzC[i8];
                    zzC[i8] = obj4;
                    return obj5;
                }
            }
        } else if (i3 > zzv) {
            zzv = zzx(zzv, zzfyx.zza(zzv), zzb2, i2);
        } else {
            zzfyx.zze(Objects.requireNonNull(this.zze), i4, i3);
        }
        int length = zzA().length;
        if (i3 > length && (min = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.zza = Arrays.copyOf(zzA(), min);
            this.zzb = Arrays.copyOf(zzB(), min);
            this.zzc = Arrays.copyOf(zzC(), min);
        }
        zzA()[i2] = (~zzv) & zzb2;
        zzB()[i2] = obj3;
        zzC()[i2] = obj4;
        this.zzg = i3;
        zzo();
        return null;
    }

    @CheckForNull
    public final Object remove(@CheckForNull Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.remove(obj);
        }
        Object zzy = zzy(obj);
        if (zzy == zzd) {
            return null;
        }
        return zzy;
    }

    public final int size() {
        Map zzl = zzl();
        return zzl != null ? zzl.size() : this.zzg;
    }

    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzfyv zzfyv = new zzfyv(this);
        this.zzj = zzfyv;
        return zzfyv;
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return isEmpty() ? -1 : 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzf(int i) {
        int i2 = i + 1;
        if (i2 < this.zzg) {
            return i2;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final Map zzl() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zzo() {
        this.zzf += 32;
    }

    /* access modifiers changed from: package-private */
    public final void zzp(int i) {
        this.zzf = zzgcl.zzc(i, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    /* access modifiers changed from: package-private */
    public final void zzq(int i, int i2) {
        Object requireNonNull = Objects.requireNonNull(this.zze);
        int[] zzA = zzA();
        Object[] zzB = zzB();
        Object[] zzC = zzC();
        int size = size();
        int i3 = size - 1;
        if (i < i3) {
            int i4 = i + 1;
            Object obj = zzB[i3];
            zzB[i] = obj;
            zzC[i] = zzC[i3];
            zzB[i3] = null;
            zzC[i3] = null;
            zzA[i] = zzA[i3];
            zzA[i3] = 0;
            int zzb2 = zzfzf.zzb(obj) & i2;
            int zzc2 = zzfyx.zzc(requireNonNull, zzb2);
            if (zzc2 != size) {
                while (true) {
                    int i5 = zzc2 - 1;
                    int i6 = zzA[i5];
                    int i7 = i6 & i2;
                    if (i7 != size) {
                        zzc2 = i7;
                    } else {
                        zzA[i5] = (i6 & (~i2)) | (i2 & i4);
                        return;
                    }
                }
            } else {
                zzfyx.zze(requireNonNull, zzb2, i4);
            }
        } else {
            zzB[i] = null;
            zzC[i] = null;
            zzA[i] = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzr() {
        return this.zze == null;
    }

    zzfyw(int i) {
        zzp(8);
    }
}
