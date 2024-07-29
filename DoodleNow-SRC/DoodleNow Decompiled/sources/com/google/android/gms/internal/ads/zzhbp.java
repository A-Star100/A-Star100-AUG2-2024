package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzhbp implements zzhcg {
    private final zzhbl zza;
    private final zzhcx zzb;
    private final boolean zzc;
    private final zzgzg zzd;

    private zzhbp(zzhcx zzhcx, zzgzg zzgzg, zzhbl zzhbl) {
        this.zzb = zzhcx;
        this.zzc = zzgzg.zzi(zzhbl);
        this.zzd = zzgzg;
        this.zza = zzhbl;
    }

    static zzhbp zzc(zzhcx zzhcx, zzgzg zzgzg, zzhbl zzhbl) {
        return new zzhbp(zzhcx, zzgzg, zzhbl);
    }

    public final int zza(Object obj) {
        zzhcx zzhcx = this.zzb;
        int zzb2 = zzhcx.zzb(zzhcx.zzd(obj));
        return this.zzc ? zzb2 + this.zzd.zzb(obj).zzd() : zzb2;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zzb(obj).zza.hashCode() : hashCode;
    }

    public final Object zze() {
        zzhbl zzhbl = this.zza;
        if (zzhbl instanceof zzgzv) {
            return ((zzgzv) zzhbl).zzbj();
        }
        return zzhbl.zzcY().zzbs();
    }

    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zzf(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzhci.zzr(this.zzb, obj, obj2);
        if (this.zzc) {
            zzhci.zzq(this.zzd, obj, obj2);
        }
    }

    public final void zzh(Object obj, zzhby zzhby, zzgzf zzgzf) throws IOException {
        boolean z;
        zzhcx zzhcx = this.zzb;
        Object zzc2 = zzhcx.zzc(obj);
        zzgzg zzgzg = this.zzd;
        zzgzk zzc3 = zzgzg.zzc(obj);
        while (true) {
            if (zzhby.zzc() == Integer.MAX_VALUE) {
                break;
            }
            int zzd2 = zzhby.zzd();
            if (zzd2 != 11) {
                if ((zzd2 & 7) == 2) {
                    Object zzd3 = zzgzg.zzd(zzgzf, this.zza, zzd2 >>> 3);
                    if (zzd3 != null) {
                        zzgzg.zzg(zzhby, zzd3, zzgzf, zzc3);
                    } else {
                        z = zzhcx.zzp(zzc2, zzhby);
                    }
                } else {
                    z = zzhby.zzQ();
                }
                if (!z) {
                    break;
                }
            } else {
                Object obj2 = null;
                int i = 0;
                zzgyj zzgyj = null;
                while (true) {
                    try {
                        if (zzhby.zzc() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzd4 = zzhby.zzd();
                        if (zzd4 == 16) {
                            i = zzhby.zzj();
                            obj2 = zzgzg.zzd(zzgzf, this.zza, i);
                        } else if (zzd4 == 26) {
                            if (obj2 != null) {
                                zzgzg.zzg(zzhby, obj2, zzgzf, zzc3);
                            } else {
                                zzgyj = zzhby.zzp();
                            }
                        } else if (!zzhby.zzQ()) {
                            break;
                        }
                    } catch (Throwable th) {
                        zzhcx.zzn(obj, zzc2);
                        throw th;
                    }
                }
                if (zzhby.zzd() != 12) {
                    throw zzhak.zzb();
                } else if (zzgyj != null) {
                    if (obj2 != null) {
                        zzgzg.zzh(zzgyj, obj2, zzgzf, zzc3);
                    } else {
                        zzhcx.zzk(zzc2, i, zzgyj);
                    }
                }
            }
        }
        zzhcx.zzn(obj, zzc2);
    }

    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgxv zzgxv) throws IOException {
        zzgzv zzgzv = (zzgzv) obj;
        if (zzgzv.zzt == zzhcy.zzc()) {
            zzgzv.zzt = zzhcy.zzf();
        }
        zzgzr zzgzr = (zzgzr) obj;
        throw null;
    }

    public final boolean zzj(Object obj, Object obj2) {
        zzhcx zzhcx = this.zzb;
        if (!zzhcx.zzd(obj).equals(zzhcx.zzd(obj2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zzb(obj).equals(this.zzd.zzb(obj2));
        }
        return true;
    }

    public final boolean zzk(Object obj) {
        return this.zzd.zzb(obj).zzl();
    }

    public final void zzm(Object obj, zzgzb zzgzb) throws IOException {
        Iterator zzg = this.zzd.zzb(obj).zzg();
        while (zzg.hasNext()) {
            Map.Entry entry = (Map.Entry) zzg.next();
            zzgzj zzgzj = (zzgzj) entry.getKey();
            if (zzgzj.zze() != zzhdo.MESSAGE || zzgzj.zzg() || zzgzj.zzf()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof zzhao) {
                zzgzb.zzw(zzgzj.zza(), ((zzhao) entry).zza().zzb());
            } else {
                zzgzb.zzw(zzgzj.zza(), entry.getValue());
            }
        }
        zzhcx zzhcx = this.zzb;
        zzhcx.zzr(zzhcx.zzd(obj), zzgzb);
    }
}
