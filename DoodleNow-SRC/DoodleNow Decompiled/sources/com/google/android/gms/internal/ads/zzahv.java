package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzahv implements zzbx {
    public static final Parcelable.Creator<zzahv> CREATOR = new zzahr();
    public final List zza;

    public zzahv(List list) {
        this.zza = list;
        boolean z = false;
        if (!list.isEmpty()) {
            long j = ((zzahu) list.get(0)).zzc;
            int i = 1;
            while (true) {
                if (i >= list.size()) {
                    break;
                } else if (((zzahu) list.get(i)).zzb < j) {
                    z = true;
                    break;
                } else {
                    j = ((zzahu) list.get(i)).zzc;
                    i++;
                }
            }
        }
        zzek.zzd(!z);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzahv) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=".concat(this.zza.toString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.zza);
    }

    public final /* synthetic */ void zza(zzbt zzbt) {
    }
}
