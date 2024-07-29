package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class StyleSpan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StyleSpan> CREATOR = new zzab();
    private final StrokeStyle zza;
    private final double zzb;

    public StyleSpan(int i) {
        this.zza = StrokeStyle.colorBuilder(i).build();
        this.zzb = 1.0d;
    }

    public double getSegments() {
        return this.zzb;
    }

    public StrokeStyle getStyle() {
        return this.zza;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getStyle(), i, false);
        SafeParcelWriter.writeDouble(parcel, 3, getSegments());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public StyleSpan(int i, double d) {
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
            this.zza = StrokeStyle.colorBuilder(i).build();
            this.zzb = d;
            return;
        }
        throw new IllegalArgumentException("A style must be applied to some segments on a polyline.");
    }

    public StyleSpan(StrokeStyle strokeStyle) {
        this.zza = strokeStyle;
        this.zzb = 1.0d;
    }

    public StyleSpan(StrokeStyle strokeStyle, double d) {
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
            this.zza = strokeStyle;
            this.zzb = d;
            return;
        }
        throw new IllegalArgumentException("A style must be applied to some segments on a polyline.");
    }
}
