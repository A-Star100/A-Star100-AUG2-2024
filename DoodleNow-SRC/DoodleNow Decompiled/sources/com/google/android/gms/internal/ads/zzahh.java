package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzahh extends zzahd {
    public static final Parcelable.Creator<zzahh> CREATOR = new zzahg();
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int[] zzd;
    public final int[] zze;

    public zzahh(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        super(MlltFrame.ID);
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = iArr;
        this.zze = iArr2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzahh zzahh = (zzahh) obj;
            return this.zza == zzahh.zza && this.zzb == zzahh.zzb && this.zzc == zzahh.zzc && Arrays.equals(this.zzd, zzahh.zzd) && Arrays.equals(this.zze, zzahh.zze);
        }
    }

    public final int hashCode() {
        return ((((((((this.zza + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + Arrays.hashCode(this.zzd)) * 31) + Arrays.hashCode(this.zze);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeIntArray(this.zzd);
        parcel.writeIntArray(this.zze);
    }

    zzahh(Parcel parcel) {
        super(MlltFrame.ID);
        this.zza = parcel.readInt();
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        int[] createIntArray = parcel.createIntArray();
        int i = zzfx.zza;
        this.zzd = createIntArray;
        this.zze = parcel.createIntArray();
    }
}
