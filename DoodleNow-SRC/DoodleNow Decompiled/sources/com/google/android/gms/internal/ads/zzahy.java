package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzahy implements zzbx {
    public static final Parcelable.Creator<zzahy> CREATOR = new zzahw();
    public final float zza;
    public final int zzb;

    public zzahy(float f, int i) {
        this.zza = f;
        this.zzb = i;
    }

    /* synthetic */ zzahy(Parcel parcel, zzahx zzahx) {
        this.zza = parcel.readFloat();
        this.zzb = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzahy zzahy = (zzahy) obj;
            return this.zza == zzahy.zza && this.zzb == zzahy.zzb;
        }
    }

    public final int hashCode() {
        return ((Float.valueOf(this.zza).hashCode() + 527) * 31) + this.zzb;
    }

    public final String toString() {
        return "smta: captureFrameRate=" + this.zza + ", svcTemporalLayerCount=" + this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.zza);
        parcel.writeInt(this.zzb);
    }

    public final /* synthetic */ void zza(zzbt zzbt) {
    }
}
