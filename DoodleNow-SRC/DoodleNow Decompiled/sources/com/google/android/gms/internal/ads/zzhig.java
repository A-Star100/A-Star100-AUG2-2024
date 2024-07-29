package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzhig implements Iterator, Closeable, zzasd {
    private static final zzasc zza = new zzhif("eof ");
    private static final zzhin zzb = zzhin.zzb(zzhig.class);
    protected zzarz zzc;
    protected zzhih zzd;
    zzasc zze = null;
    long zzf = 0;
    long zzg = 0;
    private final List zzh = new ArrayList();

    public void close() throws IOException {
    }

    public final boolean hasNext() {
        zzasc zzasc = this.zze;
        if (zzasc == zza) {
            return false;
        }
        if (zzasc != null) {
            return true;
        }
        try {
            this.zze = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zze = zza;
            return false;
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zzh.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(((zzasc) this.zzh.get(i)).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: zzd */
    public final zzasc next() {
        zzasc zzb2;
        zzasc zzasc = this.zze;
        if (zzasc == null || zzasc == zza) {
            zzhih zzhih = this.zzd;
            if (zzhih == null || this.zzf >= this.zzg) {
                this.zze = zza;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzhih) {
                    this.zzd.zze(this.zzf);
                    zzb2 = this.zzc.zzb(this.zzd, this);
                    this.zzf = this.zzd.zzb();
                }
                return zzb2;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.zze = null;
            return zzasc;
        }
    }

    public final List zze() {
        return (this.zzd == null || this.zze == zza) ? this.zzh : new zzhim(this.zzh, this);
    }

    public final void zzf(zzhih zzhih, long j, zzarz zzarz) throws IOException {
        this.zzd = zzhih;
        this.zzf = zzhih.zzb();
        zzhih.zze(zzhih.zzb() + j);
        this.zzg = zzhih.zzb();
        this.zzc = zzarz;
    }
}
