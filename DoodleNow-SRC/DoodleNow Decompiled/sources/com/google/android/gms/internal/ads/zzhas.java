package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzhas extends zzgxt implements RandomAccess, zzhat {
    @Deprecated
    public static final zzhat zza;
    private static final zzhas zzb;
    private final List zzc;

    static {
        zzhas zzhas = new zzhas(false);
        zzb = zzhas;
        zza = zzhas;
    }

    public zzhas() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgyj) {
            return ((zzgyj) obj).zzx(zzhai.zzb);
        }
        return zzhai.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zzdJ();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection collection) {
        zzdJ();
        if (collection instanceof zzhat) {
            collection = ((zzhat) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzdJ();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzdJ();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zzdJ();
        return zzj(this.zzc.set(i, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final zzhat zzd() {
        return zzc() ? new zzhdc(this) : this;
    }

    public final Object zze(int i) {
        return this.zzc.get(i);
    }

    public final /* bridge */ /* synthetic */ zzhah zzf(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzhas(arrayList);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: zzg */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgyj) {
            zzgyj zzgyj = (zzgyj) obj;
            String zzx = zzgyj.zzx(zzhai.zzb);
            if (zzgyj.zzp()) {
                this.zzc.set(i, zzx);
            }
            return zzx;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzhai.zzd(bArr);
        if (zzhdm.zzi(bArr)) {
            this.zzc.set(i, zzd);
        }
        return zzd;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzgyj zzgyj) {
        zzdJ();
        this.zzc.add(zzgyj);
        this.modCount++;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzhas(int i) {
        super(true);
        ArrayList arrayList = new ArrayList(i);
        this.zzc = arrayList;
    }

    private zzhas(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzhas(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
