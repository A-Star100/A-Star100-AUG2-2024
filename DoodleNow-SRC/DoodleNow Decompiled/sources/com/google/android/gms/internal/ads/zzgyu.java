package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzgyu implements zzhby {
    private final zzgyt zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzgyu(zzgyt zzgyt) {
        zzhai.zzc(zzgyt, "input");
        this.zza = zzgyt;
        zzgyt.zzc = this;
    }

    private final Object zzR(zzhcg zzhcg, zzgzf zzgzf) throws IOException {
        Object zze = zzhcg.zze();
        zzT(zze, zzhcg, zzgzf);
        zzhcg.zzf(zze);
        return zze;
    }

    private final Object zzS(zzhcg zzhcg, zzgzf zzgzf) throws IOException {
        Object zze = zzhcg.zze();
        zzU(zze, zzhcg, zzgzf);
        zzhcg.zzf(zze);
        return zze;
    }

    private final void zzT(Object obj, zzhcg zzhcg, zzgzf zzgzf) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzhcg.zzh(obj, this, zzgzf);
            if (this.zzb != this.zzc) {
                throw zzhak.zzg();
            }
        } finally {
            this.zzc = i;
        }
    }

    private final void zzU(Object obj, zzhcg zzhcg, zzgzf zzgzf) throws IOException {
        zzgyt zzgyt = this.zza;
        int zzn = zzgyt.zzn();
        if (zzgyt.zza < zzgyt.zzb) {
            int zze = this.zza.zze(zzn);
            this.zza.zza++;
            zzhcg.zzh(obj, this, zzgzf);
            this.zza.zzz(0);
            zzgyt zzgyt2 = this.zza;
            zzgyt2.zza--;
            zzgyt2.zzA(zze);
            return;
        }
        throw new zzhak("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final void zzV(int i) throws IOException {
        if (this.zza.zzd() != i) {
            throw zzhak.zzj();
        }
    }

    private final void zzW(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzhak.zza();
        }
    }

    private static final void zzX(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzhak.zzg();
        }
    }

    private static final void zzY(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzhak.zzg();
        }
    }

    public static zzgyu zzq(zzgyt zzgyt) {
        zzgyu zzgyu = zzgyt.zzc;
        if (zzgyu != null) {
            return zzgyu;
        }
        return new zzgyu(zzgyt);
    }

    public final void zzA(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzgzw) {
            zzgzw zzgzw = (zzgzw) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgzw.zzi(this.zza.zzf());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgyt zzgyt = this.zza;
                int zzd2 = zzgyt.zzd() + zzgyt.zzn();
                do {
                    zzgzw.zzi(this.zza.zzf());
                } while (this.zza.zzd() < zzd2);
                zzV(zzd2);
                return;
            } else {
                throw zzhak.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzgyt zzgyt2 = this.zza;
                int zzd3 = zzgyt2.zzd() + zzgyt2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzd() < zzd3);
                zzV(zzd3);
                return;
            } else {
                throw zzhak.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzB(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzgzw) {
            zzgzw zzgzw = (zzgzw) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzX(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzgzw.zzi(this.zza.zzg());
                } while (this.zza.zzd() < zzd2);
                return;
            } else if (i2 == 5) {
                do {
                    zzgzw.zzi(this.zza.zzg());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                throw zzhak.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzX(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzd() < zzd3);
                return;
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else {
                throw zzhak.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzC(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzhba) {
            zzhba zzhba = (zzhba) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzhba.zzg(this.zza.zzo());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzY(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzhba.zzg(this.zza.zzo());
                } while (this.zza.zzd() < zzd2);
                return;
            } else {
                throw zzhak.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzY(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzd() < zzd3);
                return;
            } else {
                throw zzhak.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzD(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzgzm) {
            zzgzm zzgzm = (zzgzm) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzX(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzgzm.zzg(this.zza.zzc());
                } while (this.zza.zzd() < zzd2);
                return;
            } else if (i2 == 5) {
                do {
                    zzgzm.zzg(this.zza.zzc());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                throw zzhak.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzX(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzd() < zzd3);
                return;
            } else if (i3 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else {
                throw zzhak.zza();
            }
        }
        this.zzd = i;
    }

    @Deprecated
    public final void zzE(List list, zzhcg zzhcg, zzgzf zzgzf) throws IOException {
        int zzm;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                list.add(zzR(zzhcg, zzgzf));
                if (!this.zza.zzC() && this.zzd == 0) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == i);
            this.zzd = zzm;
            return;
        }
        throw zzhak.zza();
    }

    public final void zzF(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzgzw) {
            zzgzw zzgzw = (zzgzw) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgzw.zzi(this.zza.zzh());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgyt zzgyt = this.zza;
                int zzd2 = zzgyt.zzd() + zzgyt.zzn();
                do {
                    zzgzw.zzi(this.zza.zzh());
                } while (this.zza.zzd() < zzd2);
                zzV(zzd2);
                return;
            } else {
                throw zzhak.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzgyt zzgyt2 = this.zza;
                int zzd3 = zzgyt2.zzd() + zzgyt2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzd() < zzd3);
                zzV(zzd3);
                return;
            } else {
                throw zzhak.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzG(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzhba) {
            zzhba zzhba = (zzhba) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzhba.zzg(this.zza.zzp());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgyt zzgyt = this.zza;
                int zzd2 = zzgyt.zzd() + zzgyt.zzn();
                do {
                    zzhba.zzg(this.zza.zzp());
                } while (this.zza.zzd() < zzd2);
                zzV(zzd2);
                return;
            } else {
                throw zzhak.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzgyt zzgyt2 = this.zza;
                int zzd3 = zzgyt2.zzd() + zzgyt2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzd() < zzd3);
                zzV(zzd3);
                return;
            } else {
                throw zzhak.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzH(List list, zzhcg zzhcg, zzgzf zzgzf) throws IOException {
        int zzm;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                list.add(zzS(zzhcg, zzgzf));
                if (!this.zza.zzC() && this.zzd == 0) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == i);
            this.zzd = zzm;
            return;
        }
        throw zzhak.zza();
    }

    public final void zzI(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzgzw) {
            zzgzw zzgzw = (zzgzw) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzX(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzgzw.zzi(this.zza.zzk());
                } while (this.zza.zzd() < zzd2);
                return;
            } else if (i2 == 5) {
                do {
                    zzgzw.zzi(this.zza.zzk());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                throw zzhak.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzX(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzd() < zzd3);
                return;
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else {
                throw zzhak.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzJ(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzhba) {
            zzhba zzhba = (zzhba) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzhba.zzg(this.zza.zzt());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzY(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzhba.zzg(this.zza.zzt());
                } while (this.zza.zzd() < zzd2);
                return;
            } else {
                throw zzhak.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzY(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzd() < zzd3);
                return;
            } else {
                throw zzhak.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzK(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzgzw) {
            zzgzw zzgzw = (zzgzw) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgzw.zzi(this.zza.zzl());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgyt zzgyt = this.zza;
                int zzd2 = zzgyt.zzd() + zzgyt.zzn();
                do {
                    zzgzw.zzi(this.zza.zzl());
                } while (this.zza.zzd() < zzd2);
                zzV(zzd2);
                return;
            } else {
                throw zzhak.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzgyt zzgyt2 = this.zza;
                int zzd3 = zzgyt2.zzd() + zzgyt2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                } while (this.zza.zzd() < zzd3);
                zzV(zzd3);
                return;
            } else {
                throw zzhak.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzL(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzhba) {
            zzhba zzhba = (zzhba) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzhba.zzg(this.zza.zzu());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgyt zzgyt = this.zza;
                int zzd2 = zzgyt.zzd() + zzgyt.zzn();
                do {
                    zzhba.zzg(this.zza.zzu());
                } while (this.zza.zzd() < zzd2);
                zzV(zzd2);
                return;
            } else {
                throw zzhak.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzgyt zzgyt2 = this.zza;
                int zzd3 = zzgyt2.zzd() + zzgyt2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzd() < zzd3);
                zzV(zzd3);
                return;
            } else {
                throw zzhak.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzM(List list, boolean z) throws IOException {
        int zzm;
        int i;
        if ((this.zzb & 7) == 2) {
            if ((list instanceof zzhat) && !z) {
                zzhat zzhat = (zzhat) list;
                do {
                    zzhat.zzi(zzp());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                do {
                    list.add(z ? zzu() : zzt());
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            }
            this.zzd = i;
            return;
        }
        throw zzhak.zza();
    }

    public final void zzN(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzgzw) {
            zzgzw zzgzw = (zzgzw) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgzw.zzi(this.zza.zzn());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgyt zzgyt = this.zza;
                int zzd2 = zzgyt.zzd() + zzgyt.zzn();
                do {
                    zzgzw.zzi(this.zza.zzn());
                } while (this.zza.zzd() < zzd2);
                zzV(zzd2);
                return;
            } else {
                throw zzhak.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzgyt zzgyt2 = this.zza;
                int zzd3 = zzgyt2.zzd() + zzgyt2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzd() < zzd3);
                zzV(zzd3);
                return;
            } else {
                throw zzhak.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzO(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzhba) {
            zzhba zzhba = (zzhba) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzhba.zzg(this.zza.zzv());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgyt zzgyt = this.zza;
                int zzd2 = zzgyt.zzd() + zzgyt.zzn();
                do {
                    zzhba.zzg(this.zza.zzv());
                } while (this.zza.zzd() < zzd2);
                zzV(zzd2);
                return;
            } else {
                throw zzhak.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzgyt zzgyt2 = this.zza;
                int zzd3 = zzgyt2.zzd() + zzgyt2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                } while (this.zza.zzd() < zzd3);
                zzV(zzd3);
                return;
            } else {
                throw zzhak.zza();
            }
        }
        this.zzd = i;
    }

    public final boolean zzP() throws IOException {
        zzW(0);
        return this.zza.zzD();
    }

    public final boolean zzQ() throws IOException {
        int i;
        if (this.zza.zzC() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzE(i);
    }

    public final double zza() throws IOException {
        zzW(1);
        return this.zza.zzb();
    }

    public final float zzb() throws IOException {
        zzW(5);
        return this.zza.zzc();
    }

    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zzm();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() throws IOException {
        zzW(0);
        return this.zza.zzf();
    }

    public final int zzf() throws IOException {
        zzW(5);
        return this.zza.zzg();
    }

    public final int zzg() throws IOException {
        zzW(0);
        return this.zza.zzh();
    }

    public final int zzh() throws IOException {
        zzW(5);
        return this.zza.zzk();
    }

    public final int zzi() throws IOException {
        zzW(0);
        return this.zza.zzl();
    }

    public final int zzj() throws IOException {
        zzW(0);
        return this.zza.zzn();
    }

    public final long zzk() throws IOException {
        zzW(1);
        return this.zza.zzo();
    }

    public final long zzl() throws IOException {
        zzW(0);
        return this.zza.zzp();
    }

    public final long zzm() throws IOException {
        zzW(1);
        return this.zza.zzt();
    }

    public final long zzn() throws IOException {
        zzW(0);
        return this.zza.zzu();
    }

    public final long zzo() throws IOException {
        zzW(0);
        return this.zza.zzv();
    }

    public final zzgyj zzp() throws IOException {
        zzW(2);
        return this.zza.zzw();
    }

    @Deprecated
    public final Object zzr(Class cls, zzgzf zzgzf) throws IOException {
        zzW(3);
        return zzR(zzhbv.zza().zzb(cls), zzgzf);
    }

    public final Object zzs(Class cls, zzgzf zzgzf) throws IOException {
        zzW(2);
        return zzS(zzhbv.zza().zzb(cls), zzgzf);
    }

    public final String zzt() throws IOException {
        zzW(2);
        return this.zza.zzx();
    }

    public final String zzu() throws IOException {
        zzW(2);
        return this.zza.zzy();
    }

    public final void zzv(Object obj, zzhcg zzhcg, zzgzf zzgzf) throws IOException {
        zzW(3);
        zzT(obj, zzhcg, zzgzf);
    }

    public final void zzw(Object obj, zzhcg zzhcg, zzgzf zzgzf) throws IOException {
        zzW(2);
        zzU(obj, zzhcg, zzgzf);
    }

    public final void zzx(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzgxx) {
            zzgxx zzgxx = (zzgxx) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgxx.zzg(this.zza.zzD());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgyt zzgyt = this.zza;
                int zzd2 = zzgyt.zzd() + zzgyt.zzn();
                do {
                    zzgxx.zzg(this.zza.zzD());
                } while (this.zza.zzd() < zzd2);
                zzV(zzd2);
                return;
            } else {
                throw zzhak.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzgyt zzgyt2 = this.zza;
                int zzd3 = zzgyt2.zzd() + zzgyt2.zzn();
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                } while (this.zza.zzd() < zzd3);
                zzV(zzd3);
                return;
            } else {
                throw zzhak.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzy(List list) throws IOException {
        int zzm;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzp());
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            this.zzd = zzm;
            return;
        }
        throw zzhak.zza();
    }

    public final void zzz(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzgzc) {
            zzgzc zzgzc = (zzgzc) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzgzc.zzg(this.zza.zzb());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzY(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzgzc.zzg(this.zza.zzb());
                } while (this.zza.zzd() < zzd2);
                return;
            } else {
                throw zzhak.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzY(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzd() < zzd3);
                return;
            } else {
                throw zzhak.zza();
            }
        }
        this.zzd = i;
    }
}
