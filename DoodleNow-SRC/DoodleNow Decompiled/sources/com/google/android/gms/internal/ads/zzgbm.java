package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
abstract class zzgbm extends AbstractSet {
    zzgbm() {
    }

    public boolean removeAll(Collection collection) {
        return zzgbp.zze(this, collection);
    }

    public boolean retainAll(Collection collection) {
        collection.getClass();
        return super.retainAll(collection);
    }
}
