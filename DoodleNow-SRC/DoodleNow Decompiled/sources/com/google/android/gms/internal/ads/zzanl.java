package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzanl implements zzaoz {
    private final List zza;

    public zzanl() {
        this(0);
    }

    public zzanl(int i, List list) {
        this.zza = list;
    }

    private final zzaop zzb(zzaoy zzaoy) {
        return new zzaop(zzd(zzaoy));
    }

    private final zzapd zzc(zzaoy zzaoy) {
        return new zzapd(zzd(zzaoy));
    }

    private final List zzd(zzaoy zzaoy) {
        String str;
        int i;
        List list;
        zzfo zzfo = new zzfo(zzaoy.zze);
        List list2 = this.zza;
        while (zzfo.zzb() > 0) {
            int zzm = zzfo.zzm();
            int zzd = zzfo.zzd() + zzfo.zzm();
            if (zzm == 134) {
                list2 = new ArrayList();
                int zzm2 = zzfo.zzm() & 31;
                for (int i2 = 0; i2 < zzm2; i2++) {
                    String zzA = zzfo.zzA(3, zzfwd.zzc);
                    int zzm3 = zzfo.zzm();
                    boolean z = (zzm3 & 128) != 0;
                    if (z) {
                        i = zzm3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i = 1;
                    }
                    byte zzm4 = (byte) zzfo.zzm();
                    zzfo.zzL(1);
                    if (z) {
                        byte b = zzm4 & SignedBytes.MAX_POWER_OF_TWO;
                        int i3 = zzem.zza;
                        list = Collections.singletonList(b != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        list = null;
                    }
                    zzak zzak = new zzak();
                    zzak.zzW(str);
                    zzak.zzN(zzA);
                    zzak.zzw(i);
                    zzak.zzL(list);
                    list2.add(zzak.zzac());
                }
            }
            zzfo.zzK(zzd);
        }
        return list2;
    }

    public zzanl(int i) {
        this.zza = zzfzn.zzm();
    }

    public final zzapb zza(int i, zzaoy zzaoy) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new zzaof(new zzaoc(zzaoy.zzb, zzaoy.zza()));
            }
            if (i == 21) {
                return new zzaof(new zzaoa());
            }
            if (i == 27) {
                return new zzaof(new zzanx(zzb(zzaoy), false, false));
            }
            if (i == 36) {
                return new zzaof(new zzanz(zzb(zzaoy)));
            }
            if (i == 89) {
                return new zzaof(new zzann(zzaoy.zzd));
            }
            if (i == 172) {
                return new zzaof(new zzanh(zzaoy.zzb, zzaoy.zza()));
            }
            if (i == 257) {
                return new zzaoo(new zzaoe(MimeTypes.APPLICATION_AIT));
            }
            if (i != 128) {
                if (i != 129) {
                    if (i != 138) {
                        if (i == 139) {
                            return new zzaof(new zzanm(zzaoy.zzb, zzaoy.zza(), 5408));
                        }
                        switch (i) {
                            case 15:
                                return new zzaof(new zzank(false, zzaoy.zzb, zzaoy.zza()));
                            case 16:
                                return new zzaof(new zzant(zzc(zzaoy)));
                            case 17:
                                return new zzaof(new zzaob(zzaoy.zzb, zzaoy.zza()));
                            default:
                                switch (i) {
                                    case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO:
                                        return new zzaoo(new zzaoe(MimeTypes.APPLICATION_SCTE35));
                                    case TsExtractor.TS_STREAM_TYPE_E_AC3:
                                        break;
                                    case 136:
                                        break;
                                    default:
                                        return null;
                                }
                        }
                    }
                    return new zzaof(new zzanm(zzaoy.zzb, zzaoy.zza(), 4096));
                }
                return new zzaof(new zzane(zzaoy.zzb, zzaoy.zza()));
            }
        }
        return new zzaof(new zzanq(zzc(zzaoy)));
    }
}
