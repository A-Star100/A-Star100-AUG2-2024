package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
class zzbt extends zzbr implements List {
    final /* synthetic */ zzbu zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbt(zzbu zzbu, Object obj, @CheckForNull List list, zzbr zzbr) {
        super(zzbu, obj, list, zzbr);
        this.zzf = zzbu;
    }

    public final void add(int i, Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i, obj);
        zzbu zzbu = this.zzf;
        zzbu.zzb = zzbu.zzb + 1;
        if (isEmpty) {
            zza();
        }
    }

    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.zzb).addAll(i, collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.zzb.size();
        zzbu zzbu = this.zzf;
        zzbu.zzb = zzbu.zzb + (size2 - size);
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    public final Object get(int i) {
        zzb();
        return ((List) this.zzb).get(i);
    }

    public final int indexOf(@CheckForNull Object obj) {
        zzb();
        return ((List) this.zzb).indexOf(obj);
    }

    public final int lastIndexOf(@CheckForNull Object obj) {
        zzb();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    public final ListIterator listIterator() {
        zzb();
        return new zzbs(this);
    }

    public final Object remove(int i) {
        zzb();
        Object remove = ((List) this.zzb).remove(i);
        zzbu zzbu = this.zzf;
        zzbu.zzb = zzbu.zzb - 1;
        zzc();
        return remove;
    }

    public final Object set(int i, Object obj) {
        zzb();
        return ((List) this.zzb).set(i, obj);
    }

    public final List subList(int i, int i2) {
        zzb();
        zzbu zzbu = this.zzf;
        Object obj = this.zza;
        List subList = ((List) this.zzb).subList(i, i2);
        zzbr zzbr = this.zzc;
        if (zzbr == null) {
            zzbr = this;
        }
        return zzbu.zzm(obj, subList, zzbr);
    }

    public final ListIterator listIterator(int i) {
        zzb();
        return new zzbs(this, i);
    }
}
