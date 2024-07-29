package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzazc {
    protected static final String zza = "zzazc";
    private final zzaxp zzb;
    private final String zzc;
    private final String zzd;
    private volatile Method zze = null;
    private final Class[] zzf;
    private final CountDownLatch zzg = new CountDownLatch(1);

    public zzazc(zzaxp zzaxp, String str, String str2, Class... clsArr) {
        this.zzb = zzaxp;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = clsArr;
        zzaxp.zzk().submit(new zzazb(this));
    }

    static /* bridge */ /* synthetic */ void zzb(zzazc zzazc) {
        try {
            zzaxp zzaxp = zzazc.zzb;
            Class loadClass = zzaxp.zzi().loadClass(zzazc.zzc(zzaxp.zzu(), zzazc.zzc));
            if (loadClass != null) {
                zzazc.zze = loadClass.getMethod(zzazc.zzc(zzazc.zzb.zzu(), zzazc.zzd), zzazc.zzf);
                Method method = zzazc.zze;
            }
        } catch (zzawt | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException unused) {
        } catch (Throwable th) {
            zzazc.zzg.countDown();
            throw th;
        }
        zzazc.zzg.countDown();
    }

    private final String zzc(byte[] bArr, String str) throws zzawt, UnsupportedEncodingException {
        return new String(this.zzb.zze().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zze != null) {
            return this.zze;
        }
        try {
            if (!this.zzg.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zze;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
