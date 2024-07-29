package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
class zzfyb extends zzfxw implements SortedSet {
    final /* synthetic */ zzfyg zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfyb(zzfyg zzfyg, SortedMap sortedMap) {
        super(zzfyg, sortedMap);
        this.zzc = zzfyg;
    }

    @CheckForNull
    public final Comparator comparator() {
        return zza().comparator();
    }

    public final Object first() {
        return zza().firstKey();
    }

    public SortedSet headSet(Object obj) {
        return new zzfyb(this.zzc, zza().headMap(obj));
    }

    public final Object last() {
        return zza().lastKey();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new zzfyb(this.zzc, zza().subMap(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new zzfyb(this.zzc, zza().tailMap(obj));
    }

    /* access modifiers changed from: package-private */
    public SortedMap zza() {
        return (SortedMap) this.zzd;
    }
}
