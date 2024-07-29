package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzhdc extends AbstractList implements RandomAccess, zzhat {
    /* access modifiers changed from: private */
    public final zzhat zza;

    public zzhdc(zzhat zzhat) {
        this.zza = zzhat;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzhas) this.zza).get(i);
    }

    public final Iterator iterator() {
        return new zzhdb(this);
    }

    public final ListIterator listIterator(int i) {
        return new zzhda(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzhat zzd() {
        return this;
    }

    public final Object zze(int i) {
        return this.zza.zze(i);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzgyj zzgyj) {
        throw new UnsupportedOperationException();
    }
}
