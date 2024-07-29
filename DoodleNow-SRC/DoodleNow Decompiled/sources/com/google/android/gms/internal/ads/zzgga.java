package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgga {
    private final List zza = new ArrayList();
    private final zzgrs zzb = zzgrs.zza;
    private boolean zzc = false;

    /* access modifiers changed from: private */
    public final void zzd() {
        for (zzgfy zzi : this.zza) {
            zzi.zza = false;
        }
    }

    public final zzgga zza(zzgfy zzgfy) {
        if (zzgfy.zzf == null) {
            if (zzgfy.zza) {
                zzd();
            }
            zzgfy.zzf = this;
            this.zza.add(zzgfy);
            return this;
        }
        throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
    }

    public final zzgge zzb() throws GeneralSecurityException {
        byte b;
        zzgur zzgur;
        if (!this.zzc) {
            char c = 1;
            this.zzc = true;
            List list = this.zza;
            zzguz zzd = zzgvc.zzd();
            ArrayList arrayList = new ArrayList(list.size());
            List list2 = this.zza;
            byte b2 = 0;
            int i = 0;
            while (i < list2.size() - 1) {
                int i2 = i + 1;
                if (((zzgfy) list2.get(i)).zze != zzgfz.zza || ((zzgfy) list2.get(i2)).zze == zzgfz.zza) {
                    i = i2;
                } else {
                    throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                }
            }
            HashSet hashSet = new HashSet();
            Integer num = null;
            for (zzgfy zzgfy : this.zza) {
                zzgfv unused = zzgfy.zzb;
                if (zzgfy.zze != null) {
                    if (zzgfy.zze == zzgfz.zza) {
                        b = b2;
                        while (true) {
                            if (b != 0 && !hashSet.contains(Integer.valueOf(b))) {
                                break;
                            }
                            SecureRandom secureRandom = new SecureRandom();
                            byte[] bArr = new byte[4];
                            byte b3 = b2;
                            while (b3 == 0) {
                                secureRandom.nextBytes(bArr);
                                b3 = ((bArr[b2] & 255) << Ascii.CAN) | ((bArr[c] & 255) << Ascii.DLE) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                            }
                            b = b3;
                        }
                    } else {
                        zzgfz unused2 = zzgfy.zze;
                        b = b2;
                    }
                    Integer valueOf = Integer.valueOf(b);
                    if (!hashSet.contains(valueOf)) {
                        hashSet.add(valueOf);
                        zzgft unused3 = zzgfy.zzc;
                        zzgft zza2 = zzgnk.zzb().zza(zzgfy.zzd, c != zzgfy.zzd.zza() ? null : valueOf);
                        zzggc zzggc = r13;
                        zzggc zzggc2 = new zzggc(zza2, zzgfy.zzb, b, zzgfy.zza, (zzggb) null);
                        zzgfv zzb2 = zzgfy.zzb;
                        zzgot zzgot = (zzgot) zzgnu.zzc().zzd(zza2, zzgot.class, zzggn.zza());
                        Integer zzf = zzgot.zzf();
                        if (zzf == null || zzf.intValue() == b) {
                            if (zzgfv.zza.equals(zzb2)) {
                                zzgur = zzgur.ENABLED;
                            } else if (zzgfv.zzb.equals(zzb2)) {
                                zzgur = zzgur.DISABLED;
                            } else if (zzgfv.zzc.equals(zzb2)) {
                                zzgur = zzgur.DESTROYED;
                            } else {
                                throw new IllegalStateException("Unknown key status");
                            }
                            zzgva zze = zzgvb.zze();
                            zzgum zza3 = zzgup.zza();
                            zza3.zzb(zzgot.zzg());
                            zza3.zzc(zzgot.zze());
                            zza3.zza(zzgot.zzb());
                            zze.zza(zza3);
                            zze.zzd(zzgur);
                            zze.zzb(b);
                            zze.zzc(zzgot.zzc());
                            zzd.zza((zzgvb) zze.zzbr());
                            if (zzgfy.zza) {
                                if (num != null) {
                                    throw new GeneralSecurityException("Two primaries were set");
                                } else if (zzgfy.zzb == zzgfv.zza) {
                                    num = valueOf;
                                } else {
                                    throw new GeneralSecurityException("Primary key is not enabled");
                                }
                            }
                            arrayList.add(zzggc);
                            c = 1;
                            b2 = 0;
                        } else {
                            throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
                        }
                    } else {
                        throw new GeneralSecurityException("Id " + b + " is used twice in the keyset");
                    }
                } else {
                    throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
                }
            }
            if (num != null) {
                zzd.zzb(num.intValue());
                zzgvc zzgvc = (zzgvc) zzd.zzbr();
                zzgge.zzh(zzgvc);
                return new zzgge(zzgvc, arrayList, this.zzb, (zzggd) null);
            }
            throw new GeneralSecurityException("No primary was set");
        }
        throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
    }
}
