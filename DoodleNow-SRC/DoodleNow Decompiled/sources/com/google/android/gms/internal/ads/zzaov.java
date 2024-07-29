package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaov implements zzaon {
    final /* synthetic */ zzaow zza;
    private final zzfn zzb = new zzfn(new byte[5], 5);
    private final SparseArray zzc = new SparseArray();
    private final SparseIntArray zzd = new SparseIntArray();
    private final int zze;

    public zzaov(zzaow zzaow, int i) {
        this.zza = zzaow;
        this.zze = i;
    }

    public final void zza(zzfo zzfo) {
        zzfv zzfv;
        zzfv zzfv2;
        int i;
        zzfo zzfo2 = zzfo;
        if (zzfo.zzm() == 2) {
            zzfv zzfv3 = (zzfv) this.zza.zzb.get(0);
            if ((zzfo.zzm() & 128) != 0) {
                zzfo2.zzL(1);
                int zzq = zzfo.zzq();
                int i2 = 3;
                zzfo2.zzL(3);
                zzfo2.zzF(this.zzb, 2);
                this.zzb.zzm(3);
                int i3 = 13;
                this.zza.zzr = this.zzb.zzd(13);
                zzfo2.zzF(this.zzb, 2);
                int i4 = 4;
                this.zzb.zzm(4);
                int i5 = 12;
                zzfo2.zzL(this.zzb.zzd(12));
                this.zzc.clear();
                this.zzd.clear();
                int zzb2 = zzfo.zzb();
                while (zzb2 > 0) {
                    int i6 = 5;
                    zzfo2.zzF(this.zzb, 5);
                    zzfn zzfn = this.zzb;
                    int zzd2 = zzfn.zzd(8);
                    zzfn.zzm(i2);
                    int zzd3 = this.zzb.zzd(i3);
                    this.zzb.zzm(i4);
                    int zzd4 = this.zzb.zzd(i5);
                    int zzd5 = zzfo.zzd();
                    int i7 = zzd5 + zzd4;
                    int i8 = 0;
                    String str = null;
                    ArrayList arrayList = null;
                    int i9 = -1;
                    while (zzfo.zzd() < i7) {
                        int zzm = zzfo.zzm();
                        int zzd6 = zzfo.zzd() + zzfo.zzm();
                        if (zzd6 > i7) {
                            break;
                        }
                        if (zzm == i6) {
                            long zzu = zzfo.zzu();
                            if (zzu != 1094921523) {
                                if (zzu != 1161904947) {
                                    if (zzu != 1094921524) {
                                        if (zzu == 1212503619) {
                                            i = 36;
                                            zzfv2 = zzfv3;
                                            i9 = i;
                                            zzfo2.zzL(zzd6 - zzfo.zzd());
                                            zzfv3 = zzfv2;
                                            i2 = 3;
                                            i4 = 4;
                                            i6 = 5;
                                        }
                                        zzfv2 = zzfv3;
                                        zzfo2.zzL(zzd6 - zzfo.zzd());
                                        zzfv3 = zzfv2;
                                        i2 = 3;
                                        i4 = 4;
                                        i6 = 5;
                                    }
                                }
                                zzfv2 = zzfv3;
                                i9 = 135;
                                zzfo2.zzL(zzd6 - zzfo.zzd());
                                zzfv3 = zzfv2;
                                i2 = 3;
                                i4 = 4;
                                i6 = 5;
                            }
                            zzfv2 = zzfv3;
                            i9 = 129;
                            zzfo2.zzL(zzd6 - zzfo.zzd());
                            zzfv3 = zzfv2;
                            i2 = 3;
                            i4 = 4;
                            i6 = 5;
                        } else {
                            if (zzm != 106) {
                                if (zzm != 122) {
                                    if (zzm == 127) {
                                        int zzm2 = zzfo.zzm();
                                        if (zzm2 != 21) {
                                            if (zzm2 == 14) {
                                                i = 136;
                                            } else {
                                                if (zzm2 == 33) {
                                                    i = 139;
                                                }
                                                zzfv2 = zzfv3;
                                                zzfo2.zzL(zzd6 - zzfo.zzd());
                                                zzfv3 = zzfv2;
                                                i2 = 3;
                                                i4 = 4;
                                                i6 = 5;
                                            }
                                        }
                                    } else if (zzm == 123) {
                                        i = TsExtractor.TS_STREAM_TYPE_DTS;
                                    } else {
                                        if (zzm == 10) {
                                            String trim = zzfo2.zzA(i2, zzfwd.zzc).trim();
                                            i8 = zzfo.zzm();
                                            zzfv2 = zzfv3;
                                            str = trim;
                                        } else if (zzm == 89) {
                                            ArrayList arrayList2 = new ArrayList();
                                            while (zzfo.zzd() < zzd6) {
                                                String trim2 = zzfo2.zzA(i2, zzfwd.zzc).trim();
                                                int zzm3 = zzfo.zzm();
                                                zzfv zzfv4 = zzfv3;
                                                byte[] bArr = new byte[i4];
                                                zzfo2.zzG(bArr, 0, i4);
                                                arrayList2.add(new zzaox(trim2, zzm3, bArr));
                                                zzfv3 = zzfv4;
                                                i2 = 3;
                                                i4 = 4;
                                            }
                                            zzfv2 = zzfv3;
                                            arrayList = arrayList2;
                                            i9 = 89;
                                        } else {
                                            zzfv2 = zzfv3;
                                            if (zzm == 111) {
                                                i9 = 257;
                                            }
                                        }
                                        zzfo2.zzL(zzd6 - zzfo.zzd());
                                        zzfv3 = zzfv2;
                                        i2 = 3;
                                        i4 = 4;
                                        i6 = 5;
                                    }
                                    zzfv2 = zzfv3;
                                    i9 = i;
                                    zzfo2.zzL(zzd6 - zzfo.zzd());
                                    zzfv3 = zzfv2;
                                    i2 = 3;
                                    i4 = 4;
                                    i6 = 5;
                                }
                                zzfv2 = zzfv3;
                                i9 = 135;
                                zzfo2.zzL(zzd6 - zzfo.zzd());
                                zzfv3 = zzfv2;
                                i2 = 3;
                                i4 = 4;
                                i6 = 5;
                            }
                            zzfv2 = zzfv3;
                            i9 = 129;
                            zzfo2.zzL(zzd6 - zzfo.zzd());
                            zzfv3 = zzfv2;
                            i2 = 3;
                            i4 = 4;
                            i6 = 5;
                        }
                        zzfv2 = zzfv3;
                        i9 = 172;
                        zzfo2.zzL(zzd6 - zzfo.zzd());
                        zzfv3 = zzfv2;
                        i2 = 3;
                        i4 = 4;
                        i6 = 5;
                    }
                    zzfv zzfv5 = zzfv3;
                    zzfo2.zzK(i7);
                    zzaoy zzaoy = new zzaoy(i9, str, i8, arrayList, Arrays.copyOfRange(zzfo.zzM(), zzd5, i7));
                    if (zzd2 == 6 || zzd2 == 5) {
                        zzd2 = zzaoy.zza;
                    }
                    zzb2 -= zzd4 + 5;
                    if (!this.zza.zzh.get(zzd3)) {
                        zzapb zza2 = this.zza.zze.zza(zzd2, zzaoy);
                        this.zzd.put(zzd3, zzd3);
                        this.zzc.put(zzd3, zza2);
                    }
                    zzfv3 = zzfv5;
                    i2 = 3;
                    i4 = 4;
                    i5 = 12;
                    i3 = 13;
                }
                zzfv zzfv6 = zzfv3;
                int size = this.zzd.size();
                int i10 = 0;
                while (i10 < size) {
                    SparseIntArray sparseIntArray = this.zzd;
                    zzaow zzaow = this.zza;
                    int keyAt = sparseIntArray.keyAt(i10);
                    int valueAt = sparseIntArray.valueAt(i10);
                    zzaow.zzh.put(keyAt, true);
                    this.zza.zzi.put(valueAt, true);
                    zzapb zzapb = (zzapb) this.zzc.valueAt(i10);
                    if (zzapb != null) {
                        zzadi zzj = this.zza.zzl;
                        zzapa zzapa = new zzapa(zzq, keyAt, 8192);
                        zzfv = zzfv6;
                        zzapb.zzb(zzfv, zzj, zzapa);
                        this.zza.zzg.put(valueAt, zzapb);
                    } else {
                        zzfv = zzfv6;
                    }
                    i10++;
                    zzfv6 = zzfv;
                }
                this.zza.zzg.remove(this.zze);
                this.zza.zzm = 0;
                zzaow zzaow2 = this.zza;
                if (zzaow2.zzm == 0) {
                    zzaow2.zzl.zzD();
                    this.zza.zzn = true;
                }
            }
        }
    }

    public final void zzb(zzfv zzfv, zzadi zzadi, zzapa zzapa) {
    }
}
