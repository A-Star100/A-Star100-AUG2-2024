package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class PointOfInterest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PointOfInterest> CREATOR = new zzp();
    public final LatLng latLng;
    public final String name;
    public final String placeId;

    public PointOfInterest(LatLng latLng2, String str, String str2) {
        this.latLng = latLng2;
        this.placeId = str;
        this.name = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        LatLng latLng2 = this.latLng;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, latLng2, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.placeId, false);
        SafeParcelWriter.writeString(parcel, 4, this.name, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
