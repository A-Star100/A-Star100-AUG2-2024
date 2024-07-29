package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
class zzfyf extends zzfyd implements List {
    final /* synthetic */ zzfyg zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfyf(zzfyg zzfyg, Object obj, @CheckForNull List list, zzfyd zzfyd) {
        super(zzfyg, obj, list, zzfyd);
        this.zzf = zzfyg;
    }

    public final void add(int i, Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i, obj);
        zzfyg zzfyg = this.zzf;
        zzfyg.zzb = zzfyg.zzb + 1;
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
        zzfyg zzfyg = this.zzf;
        zzfyg.zzb = zzfyg.zzb + (size2 - size);
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
        return new zzfye(this);
    }

    public final Object remove(int i) {
        zzb();
        Object remove = ((List) this.zzb).remove(i);
        zzfyg zzfyg = this.zzf;
        zzfyg.zzb = zzfyg.zzb - 1;
        zzc();
        return remove;
    }

    public final Object set(int i, Object obj) {
        zzb();
        return ((List) this.zzb).set(i, obj);
    }

    public final List subList(int i, int i2) {
        zzb();
        List subList = ((List) this.zzb).subList(i, i2);
        zzfyd zzfyd = this.zzc;
        if (zzfyd == null) {
            zzfyd = this;
        }
        return this.zzf.zzh(this.zza, subList, zzfyd);
    }

    public final ListIterator listIterator(int i) {
        zzb();
        return new zzfye(this, i);
    }
}
