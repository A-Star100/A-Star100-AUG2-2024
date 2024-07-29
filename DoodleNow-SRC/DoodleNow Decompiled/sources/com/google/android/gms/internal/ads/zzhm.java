package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.PlaybackException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhm extends zzgp {
    private RandomAccessFile zza;
    private Uri zzb;
    private long zzc;
    private boolean zzd;

    public zzhm() {
        super(false);
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzhl {
        if (i2 == 0) {
            return 0;
        }
        if (this.zzc == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.zza;
            int i3 = zzfx.zza;
            int read = randomAccessFile.read(bArr, i, (int) Math.min(this.zzc, (long) i2));
            if (read > 0) {
                this.zzc -= (long) read;
                zzg(read);
            }
            return read;
        } catch (IOException e) {
            throw new zzhl(e, 2000);
        }
    }

    public final long zzb(zzhb zzhb) throws zzhl {
        Uri uri = zzhb.zza;
        this.zzb = uri;
        zzi(zzhb);
        int i = PlaybackException.ERROR_CODE_IO_NO_PERMISSION;
        try {
            String path = uri.getPath();
            path.getClass();
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.zza = randomAccessFile;
            try {
                randomAccessFile.seek(zzhb.zze);
                long j = zzhb.zzf;
                if (j == -1) {
                    j = this.zza.length() - zzhb.zze;
                }
                this.zzc = j;
                if (j >= 0) {
                    this.zzd = true;
                    zzj(zzhb);
                    return this.zzc;
                }
                throw new zzhl((String) null, (Throwable) null, 2008);
            } catch (IOException e) {
                throw new zzhl(e, 2000);
            }
        } catch (FileNotFoundException e2) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new zzhl(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", new Object[]{uri.getPath(), uri.getQuery(), uri.getFragment()}), e2, 1004);
            }
            int i2 = zzfx.zza;
            if (true != zzhk.zzb(e2.getCause())) {
                i = PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND;
            }
            throw new zzhl(e2, i);
        } catch (SecurityException e3) {
            throw new zzhl(e3, PlaybackException.ERROR_CODE_IO_NO_PERMISSION);
        } catch (RuntimeException e4) {
            throw new zzhl(e4, 2000);
        }
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() throws zzhl {
        this.zzb = null;
        try {
            RandomAccessFile randomAccessFile = this.zza;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.zza = null;
            if (this.zzd) {
                this.zzd = false;
                zzh();
            }
        } catch (IOException e) {
            throw new zzhl(e, 2000);
        } catch (Throwable th) {
            this.zza = null;
            if (this.zzd) {
                this.zzd = false;
                zzh();
            }
            throw th;
        }
    }
}
