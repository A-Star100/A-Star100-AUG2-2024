package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdq {
    private final zzfzn zza;
    private final List zzb = new ArrayList();
    private ByteBuffer[] zzc = new ByteBuffer[0];
    private zzdr zzd = zzdr.zza;
    private zzdr zze = zzdr.zza;
    private boolean zzf = false;

    public zzdq(zzfzn zzfzn) {
        this.zza = zzfzn;
    }

    private final int zzi() {
        return this.zzc.length - 1;
    }

    private final void zzj(ByteBuffer byteBuffer) {
        boolean z;
        ByteBuffer byteBuffer2;
        do {
            int i = 0;
            z = false;
            while (i <= zzi()) {
                int i2 = i + 1;
                if (!this.zzc[i].hasRemaining()) {
                    zzdt zzdt = (zzdt) this.zzb.get(i);
                    if (!zzdt.zzh()) {
                        if (i > 0) {
                            byteBuffer2 = this.zzc[i - 1];
                        } else {
                            byteBuffer2 = byteBuffer.hasRemaining() ? byteBuffer : zzdt.zza;
                        }
                        zzdt.zze(byteBuffer2);
                        this.zzc[i] = zzdt.zzb();
                        int i3 = ((((long) byteBuffer2.remaining()) - ((long) byteBuffer2.remaining())) > 0 ? 1 : ((((long) byteBuffer2.remaining()) - ((long) byteBuffer2.remaining())) == 0 ? 0 : -1));
                        boolean z2 = true;
                        if (i3 <= 0 && !this.zzc[i].hasRemaining()) {
                            z2 = false;
                        }
                        z |= z2;
                    } else if (!this.zzc[i].hasRemaining() && i < zzi()) {
                        ((zzdt) this.zzb.get(i2)).zzd();
                    }
                }
                i = i2;
            }
        } while (z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdq)) {
            return false;
        }
        zzdq zzdq = (zzdq) obj;
        if (this.zza.size() != zzdq.zza.size()) {
            return false;
        }
        for (int i = 0; i < this.zza.size(); i++) {
            if (this.zza.get(i) != zzdq.zza.get(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzdr zza(zzdr zzdr) throws zzds {
        if (!zzdr.equals(zzdr.zza)) {
            for (int i = 0; i < this.zza.size(); i++) {
                zzdt zzdt = (zzdt) this.zza.get(i);
                zzdr zza2 = zzdt.zza(zzdr);
                if (zzdt.zzg()) {
                    zzek.zzf(!zza2.equals(zzdr.zza));
                    zzdr = zza2;
                }
            }
            this.zze = zzdr;
            return zzdr;
        }
        throw new zzds("Unhandled input format:", zzdr);
    }

    public final ByteBuffer zzb() {
        if (!zzh()) {
            return zzdt.zza;
        }
        ByteBuffer byteBuffer = this.zzc[zzi()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        zzj(zzdt.zza);
        return this.zzc[zzi()];
    }

    public final void zzc() {
        this.zzb.clear();
        this.zzd = this.zze;
        this.zzf = false;
        for (int i = 0; i < this.zza.size(); i++) {
            zzdt zzdt = (zzdt) this.zza.get(i);
            zzdt.zzc();
            if (zzdt.zzg()) {
                this.zzb.add(zzdt);
            }
        }
        this.zzc = new ByteBuffer[this.zzb.size()];
        for (int i2 = 0; i2 <= zzi(); i2++) {
            this.zzc[i2] = ((zzdt) this.zzb.get(i2)).zzb();
        }
    }

    public final void zzd() {
        if (zzh() && !this.zzf) {
            this.zzf = true;
            ((zzdt) this.zzb.get(0)).zzd();
        }
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (zzh() && !this.zzf) {
            zzj(byteBuffer);
        }
    }

    public final void zzf() {
        for (int i = 0; i < this.zza.size(); i++) {
            zzdt zzdt = (zzdt) this.zza.get(i);
            zzdt.zzc();
            zzdt.zzf();
        }
        this.zzc = new ByteBuffer[0];
        this.zzd = zzdr.zza;
        this.zze = zzdr.zza;
        this.zzf = false;
    }

    public final boolean zzg() {
        return this.zzf && ((zzdt) this.zzb.get(zzi())).zzh() && !this.zzc[zzi()].hasRemaining();
    }

    public final boolean zzh() {
        return !this.zzb.isEmpty();
    }
}
