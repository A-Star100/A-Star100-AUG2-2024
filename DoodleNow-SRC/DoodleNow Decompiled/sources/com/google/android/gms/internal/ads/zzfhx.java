package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbdg;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfhx implements zzfhw {
    private final ConcurrentHashMap zza;
    private final zzfid zzb;
    private final zzfhz zzc = new zzfhz();

    public zzfhx(zzfid zzfid) {
        this.zza = new ConcurrentHashMap(zzfid.zzd);
        this.zzb = zzfid;
    }

    private final void zzf() {
        Parcelable.Creator<zzfid> creator = zzfid.CREATOR;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzgv)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzb.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzb());
            int i = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfig) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzfhv) entry.getValue()).zzb(); i2++) {
                    sb.append("[O]");
                }
                for (int zzb2 = ((zzfhv) entry.getValue()).zzb(); zzb2 < this.zzb.zzd; zzb2++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfhv) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i < this.zzb.zzc) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzm.zze(sb.toString());
        }
    }

    public final zzfid zza() {
        return this.zzb;
    }

    public final synchronized zzfif zzb(zzfig zzfig) {
        zzfif zzfif;
        zzfhv zzfhv = (zzfhv) this.zza.get(zzfig);
        if (zzfhv != null) {
            zzfif = zzfhv.zze();
            if (zzfif == null) {
                this.zzc.zze();
            }
            zzfit zzf = zzfhv.zzf();
            if (zzfif != null) {
                zzbdg.zzb.zzc zzd = zzbdg.zzb.zzd();
                zzbdg.zzb.zza.C0016zza zza2 = zzbdg.zzb.zza.zza();
                zza2.zzf(zzbdg.zzb.zzd.IN_MEMORY);
                zzbdg.zzb.zze.zza zzc2 = zzbdg.zzb.zze.zzc();
                zzc2.zzd(zzf.zza);
                zzc2.zze(zzf.zzb);
                zza2.zzg(zzc2);
                zzd.zzd(zza2);
                zzfif.zza.zzb().zzc().zzi((zzbdg.zzb) zzd.zzbr());
            }
            zzf();
        } else {
            this.zzc.zzf();
            zzf();
            zzfif = null;
        }
        return zzfif;
    }

    @Deprecated
    public final zzfig zzc(zzl zzl, String str, zzw zzw) {
        return new zzfih(zzl, str, new zzbxh(this.zzb.zza).zza().zzk, this.zzb.zzf, zzw);
    }

    public final synchronized boolean zzd(zzfig zzfig, zzfif zzfif) {
        boolean zzh;
        zzfhv zzfhv = (zzfhv) this.zza.get(zzfig);
        zzfif.zzd = zzu.zzB().currentTimeMillis();
        if (zzfhv == null) {
            zzfid zzfid = this.zzb;
            zzfhv zzfhv2 = new zzfhv(zzfid.zzd, zzfid.zze * 1000);
            if (this.zza.size() == this.zzb.zzc) {
                int i = this.zzb.zzg;
                int i2 = i - 1;
                zzfig zzfig2 = null;
                if (i != 0) {
                    long j = Long.MAX_VALUE;
                    if (i2 == 0) {
                        for (Map.Entry entry : this.zza.entrySet()) {
                            if (((zzfhv) entry.getValue()).zzc() < j) {
                                j = ((zzfhv) entry.getValue()).zzc();
                                zzfig2 = (zzfig) entry.getKey();
                            }
                        }
                        if (zzfig2 != null) {
                            this.zza.remove(zzfig2);
                        }
                    } else if (i2 == 1) {
                        for (Map.Entry entry2 : this.zza.entrySet()) {
                            if (((zzfhv) entry2.getValue()).zzd() < j) {
                                j = ((zzfhv) entry2.getValue()).zzd();
                                zzfig2 = (zzfig) entry2.getKey();
                            }
                        }
                        if (zzfig2 != null) {
                            this.zza.remove(zzfig2);
                        }
                    } else if (i2 == 2) {
                        int i3 = Integer.MAX_VALUE;
                        for (Map.Entry entry3 : this.zza.entrySet()) {
                            if (((zzfhv) entry3.getValue()).zza() < i3) {
                                i3 = ((zzfhv) entry3.getValue()).zza();
                                zzfig2 = (zzfig) entry3.getKey();
                            }
                        }
                        if (zzfig2 != null) {
                            this.zza.remove(zzfig2);
                        }
                    }
                    this.zzc.zzg();
                } else {
                    throw null;
                }
            }
            this.zza.put(zzfig, zzfhv2);
            this.zzc.zzd();
            zzfhv = zzfhv2;
        }
        zzh = zzfhv.zzh(zzfif);
        this.zzc.zzc();
        zzfhy zza2 = this.zzc.zza();
        zzfit zzf = zzfhv.zzf();
        if (zzfif != null) {
            zzbdg.zzb.zzc zzd = zzbdg.zzb.zzd();
            zzbdg.zzb.zza.C0016zza zza3 = zzbdg.zzb.zza.zza();
            zza3.zzf(zzbdg.zzb.zzd.IN_MEMORY);
            zzbdg.zzb.zzg.zza zzc2 = zzbdg.zzb.zzg.zzc();
            zzc2.zze(zza2.zza);
            zzc2.zzf(zza2.zzb);
            zzc2.zzg(zzf.zzb);
            zza3.zzi(zzc2);
            zzd.zzd(zza3);
            zzfif.zza.zzb().zzc().zzj((zzbdg.zzb) zzd.zzbr());
        }
        zzf();
        return zzh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r3.zzb() >= r1.zzd) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zze(com.google.android.gms.internal.ads.zzfig r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.concurrent.ConcurrentHashMap r0 = r2.zza     // Catch:{ all -> 0x001c }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x001c }
            com.google.android.gms.internal.ads.zzfhv r3 = (com.google.android.gms.internal.ads.zzfhv) r3     // Catch:{ all -> 0x001c }
            r0 = 1
            if (r3 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzfid r1 = r2.zzb     // Catch:{ all -> 0x001c }
            int r3 = r3.zzb()     // Catch:{ all -> 0x001c }
            int r1 = r1.zzd     // Catch:{ all -> 0x001c }
            monitor-exit(r2)
            if (r3 >= r1) goto L_0x0018
            return r0
        L_0x0018:
            r3 = 0
            return r3
        L_0x001a:
            monitor-exit(r2)
            return r0
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfhx.zze(com.google.android.gms.internal.ads.zzfig):boolean");
    }
}
