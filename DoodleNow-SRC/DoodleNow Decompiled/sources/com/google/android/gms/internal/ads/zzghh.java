package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzghh {
    @Nullable
    private Integer zza = null;
    @Nullable
    private Integer zzb = null;
    @Nullable
    private Integer zzc = null;
    @Nullable
    private Integer zzd = null;
    private zzghi zze = null;
    private zzghj zzf = zzghj.zzc;

    private zzghh() {
    }

    /* synthetic */ zzghh(zzghg zzghg) {
    }

    public final zzghh zzb(zzghi zzghi) {
        this.zze = zzghi;
        return this;
    }

    public final zzghh zzf(zzghj zzghj) {
        this.zzf = zzghj;
        return this;
    }

    public final zzghh zza(int i) throws GeneralSecurityException {
        if (i == 16 || i == 24 || i == 32) {
            this.zza = Integer.valueOf(i);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
    }

    public final zzghh zze(int i) throws GeneralSecurityException {
        if (i >= 10) {
            this.zzd = Integer.valueOf(i);
            return this;
        }
        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", new Object[]{Integer.valueOf(i)}));
    }

    public final zzghh zzc(int i) throws GeneralSecurityException {
        if (i >= 16) {
            this.zzb = Integer.valueOf(i);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", new Object[]{Integer.valueOf(i)}));
    }

    public final zzghh zzd(int i) throws GeneralSecurityException {
        if (i < 12 || i > 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", new Object[]{Integer.valueOf(i)}));
        }
        this.zzc = Integer.valueOf(i);
        return this;
    }

    public final zzghl zzg() throws GeneralSecurityException {
        if (this.zza == null) {
            throw new GeneralSecurityException("AES key size is not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("HMAC key size is not set");
        } else if (this.zzc != null) {
            Integer num = this.zzd;
            if (num == null) {
                throw new GeneralSecurityException("tag size is not set");
            } else if (this.zze == null) {
                throw new GeneralSecurityException("hash type is not set");
            } else if (this.zzf != null) {
                int intValue = num.intValue();
                zzghi zzghi = this.zze;
                if (zzghi == zzghi.zza) {
                    if (intValue > 20) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zzghi == zzghi.zzb) {
                    if (intValue > 28) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zzghi == zzghi.zzc) {
                    if (intValue > 32) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zzghi == zzghi.zzd) {
                    if (intValue > 48) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zzghi != zzghi.zze) {
                    throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
                } else if (intValue > 64) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", new Object[]{Integer.valueOf(intValue)}));
                }
                return new zzghl(this.zza.intValue(), this.zzb.intValue(), this.zzc.intValue(), this.zzd.intValue(), this.zzf, this.zze, (zzghk) null);
            } else {
                throw new GeneralSecurityException("variant is not set");
            }
        } else {
            throw new GeneralSecurityException("iv size is not set");
        }
    }
}
