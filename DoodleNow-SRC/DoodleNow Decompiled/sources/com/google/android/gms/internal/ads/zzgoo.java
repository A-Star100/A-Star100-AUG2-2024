package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgoo {
    private final Class zza;
    private Map zzb = new HashMap();
    private final List zzc = new ArrayList();
    private zzgoq zzd;
    private zzgrs zze;

    /* synthetic */ zzgoo(Class cls, zzgon zzgon) {
        this.zza = cls;
        this.zze = zzgrs.zza;
    }

    public final zzgoo zza(Object obj, zzgft zzgft, zzgvb zzgvb) throws GeneralSecurityException {
        zze(obj, zzgft, zzgvb, false);
        return this;
    }

    public final zzgoo zzb(Object obj, zzgft zzgft, zzgvb zzgvb) throws GeneralSecurityException {
        zze(obj, zzgft, zzgvb, true);
        return this;
    }

    public final zzgoo zzc(zzgrs zzgrs) {
        if (this.zzb != null) {
            this.zze = zzgrs;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build");
    }

    public final zzgos zzd() throws GeneralSecurityException {
        Map map = this.zzb;
        if (map != null) {
            zzgos zzgos = new zzgos(map, this.zzc, this.zzd, this.zze, this.zza, (zzgor) null);
            this.zzb = null;
            return zzgos;
        }
        throw new IllegalStateException("build cannot be called twice");
    }

    private final zzgoo zze(Object obj, zzgft zzgft, zzgvb zzgvb, boolean z) throws GeneralSecurityException {
        byte[] bArr;
        if (this.zzb == null) {
            throw new IllegalStateException("addEntry cannot be called after build");
        } else if (zzgvb.zzd() == zzgur.ENABLED) {
            zzgvv zzgvv = zzgvv.UNKNOWN_PREFIX;
            int ordinal = zzgvb.zzg().ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        bArr = zzgfo.zza;
                    } else if (ordinal != 4) {
                        throw new GeneralSecurityException("unknown output prefix type");
                    }
                }
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzgvb.zza()).array();
            } else {
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzgvb.zza()).array();
            }
            zzgoq zzgoq = new zzgoq(obj, zzgxm.zzb(bArr), zzgvb.zzd(), zzgvb.zzg(), zzgvb.zza(), zzgvb.zzc().zzg(), zzgft, (zzgop) null);
            Map map = this.zzb;
            List list = this.zzc;
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzgoq);
            List list2 = (List) map.put(zzgoq.zzb, Collections.unmodifiableList(arrayList));
            if (list2 != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list2);
                arrayList2.add(zzgoq);
                map.put(zzgoq.zzb, Collections.unmodifiableList(arrayList2));
            }
            list.add(zzgoq);
            if (z) {
                if (this.zzd == null) {
                    this.zzd = zzgoq;
                } else {
                    throw new IllegalStateException("you cannot set two primary primitives");
                }
            }
            return this;
        } else {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
    }
}
