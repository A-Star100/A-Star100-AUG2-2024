package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaht implements Parcelable.Creator {
    zzaht() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzahu(parcel.readLong(), parcel.readLong(), parcel.readInt());
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzahu[i];
    }
}
