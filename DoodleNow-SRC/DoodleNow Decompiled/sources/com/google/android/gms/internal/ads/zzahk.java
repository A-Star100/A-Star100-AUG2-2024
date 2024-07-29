package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzahk implements Parcelable.Creator {
    zzahk() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        readString.getClass();
        String readString2 = parcel.readString();
        String[] createStringArray = parcel.createStringArray();
        createStringArray.getClass();
        return new zzahl(readString, readString2, zzfzn.zzl(createStringArray));
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzahl[i];
    }
}
