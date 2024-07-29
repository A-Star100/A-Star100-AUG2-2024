package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzhbd implements zzhch {
    private static final zzhbj zza = new zzhbb();
    private final zzhbj zzb;

    public zzhbd() {
        zzhbj zzhbj;
        zzhbj[] zzhbjArr = new zzhbj[2];
        zzhbjArr[0] = zzgzo.zza();
        try {
            zzhbj = (zzhbj) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzhbj = zza;
        }
        zzhbjArr[1] = zzhbj;
        zzhbc zzhbc = new zzhbc(zzhbjArr);
        byte[] bArr = zzhai.zzd;
        this.zzb = zzhbc;
    }

    private static boolean zzb(zzhbi zzhbi) {
        return zzhbi.zzc() + -1 != 1;
    }

    public final zzhcg zza(Class cls) {
        zzhci.zzs(cls);
        zzhbi zzb2 = this.zzb.zzb(cls);
        if (zzb2.zzb()) {
            if (zzgzv.class.isAssignableFrom(cls)) {
                return zzhbp.zzc(zzhci.zzn(), zzgzi.zzb(), zzb2.zza());
            }
            return zzhbp.zzc(zzhci.zzm(), zzgzi.zza(), zzb2.zza());
        } else if (zzgzv.class.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzhbo.zzl(cls, zzb2, zzhbs.zzb(), zzhaz.zze(), zzhci.zzn(), zzgzi.zzb(), zzhbh.zzb());
            }
            return zzhbo.zzl(cls, zzb2, zzhbs.zzb(), zzhaz.zze(), zzhci.zzn(), (zzgzg) null, zzhbh.zzb());
        } else if (zzb(zzb2)) {
            return zzhbo.zzl(cls, zzb2, zzhbs.zza(), zzhaz.zzd(), zzhci.zzm(), zzgzi.zza(), zzhbh.zza());
        } else {
            return zzhbo.zzl(cls, zzb2, zzhbs.zza(), zzhaz.zzd(), zzhci.zzm(), (zzgzg) null, zzhbh.zza());
        }
    }
}
