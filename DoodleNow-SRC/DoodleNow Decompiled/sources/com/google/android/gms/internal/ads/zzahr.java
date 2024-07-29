package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzahr implements Parcelable.Creator {
    zzahr() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, zzahu.class.getClassLoader());
        return new zzahv(arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzahv[i];
    }
}
