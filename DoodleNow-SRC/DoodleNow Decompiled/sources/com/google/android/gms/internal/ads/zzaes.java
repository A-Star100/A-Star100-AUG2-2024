package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.amazon.a.a.o.b.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaes {
    public static int zza(int i) {
        int i2 = 0;
        while (i > 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    public static zzby zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            int i2 = zzfx.zza;
            String[] split = str.split(f.b, 2);
            if (split.length != 2) {
                zzfe.zzf("VorbisUtil", "Failed to parse Vorbis comment: ".concat(String.valueOf(str)));
            } else if (split[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzagi.zzb(new zzfo(Base64.decode(split[1], 0))));
                } catch (RuntimeException e) {
                    zzfe.zzg("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new zzaia(split[0], split[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzby((List) arrayList);
    }

    public static zzaep zzc(zzfo zzfo, boolean z, boolean z2) throws zzcc {
        if (z) {
            zzd(3, zzfo, false);
        }
        String zzA = zzfo.zzA((int) zzfo.zzs(), zzfwd.zzc);
        int length = zzA.length();
        long zzs = zzfo.zzs();
        String[] strArr = new String[((int) zzs)];
        int i = length + 15;
        for (int i2 = 0; ((long) i2) < zzs; i2++) {
            String zzA2 = zzfo.zzA((int) zzfo.zzs(), zzfwd.zzc);
            strArr[i2] = zzA2;
            i = i + 4 + zzA2.length();
        }
        if (!z2 || (zzfo.zzm() & 1) != 0) {
            return new zzaep(zzA, strArr, i + 1);
        }
        throw zzcc.zza("framing bit expected to be set", (Throwable) null);
    }

    public static boolean zzd(int i, zzfo zzfo, boolean z) throws zzcc {
        if (zzfo.zzb() < 7) {
            if (z) {
                return false;
            }
            int zzb = zzfo.zzb();
            throw zzcc.zza("too short header: " + zzb, (Throwable) null);
        } else if (zzfo.zzm() != i) {
            if (z) {
                return false;
            }
            throw zzcc.zza("expected header type ".concat(String.valueOf(Integer.toHexString(i))), (Throwable) null);
        } else if (zzfo.zzm() == 118 && zzfo.zzm() == 111 && zzfo.zzm() == 114 && zzfo.zzm() == 98 && zzfo.zzm() == 105 && zzfo.zzm() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw zzcc.zza("expected characters 'vorbis'", (Throwable) null);
        }
    }
}
