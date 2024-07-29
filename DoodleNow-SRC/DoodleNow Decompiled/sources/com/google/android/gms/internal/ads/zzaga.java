package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaga extends zzadu {
    final /* synthetic */ zzaef zza;
    final /* synthetic */ zzagb zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaga(zzagb zzagb, zzaef zzaef, zzaef zzaef2) {
        super(zzaef);
        this.zza = zzaef2;
        this.zzb = zzagb;
    }

    public final zzaed zzg(long j) {
        zzaed zzg = this.zza.zzg(j);
        zzaeg zzaeg = zzg.zza;
        zzaeg zzaeg2 = new zzaeg(zzaeg.zzb, zzaeg.zzc + this.zzb.zzb);
        zzaeg zzaeg3 = zzg.zzb;
        return new zzaed(zzaeg2, new zzaeg(zzaeg3.zzb, zzaeg3.zzc + this.zzb.zzb));
    }
}
