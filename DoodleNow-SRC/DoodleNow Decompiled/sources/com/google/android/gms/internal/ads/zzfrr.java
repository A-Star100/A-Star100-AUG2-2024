package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.exoplayer2.PlaybackException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfrr {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzfrs zzc;
    private final zzfpp zzd;
    private final zzfpi zze;
    private zzfrg zzf;
    private final Object zzg = new Object();

    public zzfrr(Context context, zzfrs zzfrs, zzfpp zzfpp, zzfpi zzfpi) {
        this.zzb = context;
        this.zzc = zzfrs;
        this.zzd = zzfpp;
        this.zze = zzfpi;
    }

    private final synchronized Class zzd(zzfrh zzfrh) throws zzfrq {
        String zzk = zzfrh.zza().zzk();
        HashMap hashMap = zza;
        Class cls = (Class) hashMap.get(zzk);
        if (cls != null) {
            return cls;
        }
        try {
            if (this.zze.zza(zzfrh.zzc())) {
                File zzb2 = zzfrh.zzb();
                if (!zzb2.exists()) {
                    zzb2.mkdirs();
                }
                Class loadClass = new DexClassLoader(zzfrh.zzc().getAbsolutePath(), zzb2.getAbsolutePath(), (String) null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                hashMap.put(zzk, loadClass);
                return loadClass;
            }
            throw new zzfrq(2026, "VM did not pass signature verification");
        } catch (GeneralSecurityException e) {
            throw new zzfrq(2026, (Throwable) e);
        } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e2) {
            throw new zzfrq(2008, e2);
        }
    }

    public final zzfps zza() {
        zzfrg zzfrg;
        synchronized (this.zzg) {
            zzfrg = this.zzf;
        }
        return zzfrg;
    }

    public final zzfrh zzb() {
        synchronized (this.zzg) {
            zzfrg zzfrg = this.zzf;
            if (zzfrg == null) {
                return null;
            }
            zzfrh zzf2 = zzfrg.zzf();
            return zzf2;
        }
    }

    public final boolean zzc(zzfrh zzfrh) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Class zzd2 = zzd(zzfrh);
            zzfrg zzfrg = new zzfrg(zzd2.getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE}).newInstance(new Object[]{this.zzb, "msa-r", zzfrh.zze(), null, new Bundle(), 2}), zzfrh, this.zzc, this.zzd);
            if (zzfrg.zzh()) {
                int zze2 = zzfrg.zze();
                if (zze2 == 0) {
                    synchronized (this.zzg) {
                        zzfrg zzfrg2 = this.zzf;
                        if (zzfrg2 != null) {
                            try {
                                zzfrg2.zzg();
                            } catch (zzfrq e) {
                                this.zzd.zzc(e.zza(), -1, e);
                            }
                        }
                        this.zzf = zzfrg;
                    }
                    this.zzd.zzd(3000, System.currentTimeMillis() - currentTimeMillis);
                    return true;
                }
                throw new zzfrq((int) PlaybackException.ERROR_CODE_DECODER_INIT_FAILED, "ci: " + zze2);
            }
            throw new zzfrq(4000, "init failed");
        } catch (Exception e2) {
            throw new zzfrq((int) PlaybackException.ERROR_CODE_IO_BAD_HTTP_STATUS, (Throwable) e2);
        } catch (zzfrq e3) {
            this.zzd.zzc(e3.zza(), System.currentTimeMillis() - currentTimeMillis, e3);
            return false;
        } catch (Exception e4) {
            this.zzd.zzc(4010, System.currentTimeMillis() - currentTimeMillis, e4);
            return false;
        }
    }
}
