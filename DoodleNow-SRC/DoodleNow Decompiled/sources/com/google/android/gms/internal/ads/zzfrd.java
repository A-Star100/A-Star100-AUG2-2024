package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfrd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfrd> CREATOR = new zzfre();
    public final int zza;
    private zzaud zzb = null;
    private byte[] zzc;

    zzfrd(int i, byte[] bArr) {
        this.zza = i;
        this.zzc = bArr;
        zzb();
    }

    private final void zzb() {
        zzaud zzaud = this.zzb;
        if (zzaud == null && this.zzc != null) {
            return;
        }
        if (zzaud != null && this.zzc == null) {
            return;
        }
        if (zzaud != null && this.zzc != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (zzaud == null && this.zzc == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        byte[] bArr = this.zzc;
        if (bArr == null) {
            bArr = this.zzb.zzaV();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzaud zza() {
        if (this.zzb == null) {
            try {
                this.zzb = zzaud.zzf(this.zzc, zzgzf.zza());
                this.zzc = null;
            } catch (zzhak | NullPointerException e) {
                throw new IllegalStateException(e);
            }
        }
        zzb();
        return this.zzb;
    }
}
