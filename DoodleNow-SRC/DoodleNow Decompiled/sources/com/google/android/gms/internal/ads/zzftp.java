package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
class zzftp {
    static final String zza = new UUID(0, 0).toString();
    final zzftq zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    zzftp(Context context, String str, String str2, String str3) {
        this.zzb = zzftq.zzb(context);
        this.zzc = str;
        this.zzd = str.concat("_3p");
        this.zze = str2;
        this.zzf = str2.concat("_3p");
        this.zzg = str3;
    }

    private final String zzh(String str, String str2, String str3) {
        if (str2 == null || str3 == null) {
            String str4 = this.zzg;
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(": Invalid argument to generate PAIDv1 on 3p traffic, Ad ID is not null, package name is ");
            String str5 = "null";
            sb.append(str2 == null ? str5 : "not null");
            sb.append(", hashKey is ");
            if (str3 != null) {
                str5 = "not null";
            }
            sb.append(str5);
            throw new IllegalArgumentException(sb.toString());
        }
        return UUID.nameUUIDFromBytes((str + str2 + str3).getBytes(StandardCharsets.UTF_8)).toString();
    }

    /* access modifiers changed from: package-private */
    public final long zza(boolean z) {
        return this.zzb.zza(z ? this.zzf : this.zze, -1);
    }

    /* access modifiers changed from: package-private */
    public final zzfto zzb(String str, String str2, long j, boolean z) throws IOException {
        boolean z2 = true;
        if (str != null) {
            try {
                UUID.fromString(str);
                if (!str.equals(zza)) {
                    String zze2 = zze(true);
                    String zzc2 = this.zzb.zzc("paid_3p_hash_key", (String) null);
                    if (!(zze2 == null || zzc2 == null || zze2.equals(zzh(str, str2, zzc2)))) {
                        return zzc(str, str2);
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
            return new zzfto();
        }
        if (str == null) {
            z2 = false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            long zza2 = zza(z2);
            if (zza2 != -1) {
                if (currentTimeMillis < zza2) {
                    this.zzb.zzd(z2 ? this.zzf : this.zze, Long.valueOf(currentTimeMillis));
                } else if (currentTimeMillis >= zza2 + j) {
                    return zzc(str, str2);
                }
            }
            String zze3 = zze(z2);
            if (zze3 != null || z) {
                return new zzfto(zze3, zza(z2));
            }
            return zzc(str, str2);
        }
        throw new IllegalStateException(this.zzg.concat(": Invalid negative current timestamp. Updating PAID failed"));
    }

    /* access modifiers changed from: package-private */
    public final zzfto zzc(String str, String str2) throws IOException {
        if (str == null) {
            return zzd(UUID.randomUUID().toString(), false);
        }
        String uuid = UUID.randomUUID().toString();
        this.zzb.zzd("paid_3p_hash_key", uuid);
        return zzd(zzh(str, str2, uuid), true);
    }

    /* access modifiers changed from: package-private */
    public final zzfto zzd(String str, boolean z) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            this.zzb.zzd(z ? this.zzf : this.zze, Long.valueOf(currentTimeMillis));
            this.zzb.zzd(z ? this.zzd : this.zzc, str);
            return new zzfto(str, currentTimeMillis);
        }
        throw new IllegalStateException(this.zzg.concat(": Invalid negative current timestamp. Updating PAID failed"));
    }

    /* access modifiers changed from: package-private */
    public final String zze(boolean z) {
        return this.zzb.zzc(z ? this.zzd : this.zzc, (String) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzf(boolean z) throws IOException {
        this.zzb.zze(z ? this.zzf : this.zze);
        this.zzb.zze(z ? this.zzd : this.zzc);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg(boolean z) {
        return this.zzb.zzg(this.zzc);
    }
}
