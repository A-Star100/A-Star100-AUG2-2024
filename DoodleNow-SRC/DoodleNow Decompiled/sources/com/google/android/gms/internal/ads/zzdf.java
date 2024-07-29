package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzdf {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public boolean zzg;
    /* access modifiers changed from: private */
    public final zzfzn zzh;
    /* access modifiers changed from: private */
    public final zzfzn zzi;
    private final int zzj;
    private final int zzk;
    /* access modifiers changed from: private */
    public final zzfzn zzl;
    /* access modifiers changed from: private */
    public final zzde zzm;
    /* access modifiers changed from: private */
    public zzfzn zzn;
    /* access modifiers changed from: private */
    public int zzo;
    /* access modifiers changed from: private */
    public final HashMap zzp;
    /* access modifiers changed from: private */
    public final HashSet zzq;

    @Deprecated
    public zzdf() {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = Integer.MAX_VALUE;
        this.zzf = Integer.MAX_VALUE;
        this.zzg = true;
        this.zzh = zzfzn.zzm();
        this.zzi = zzfzn.zzm();
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzfzn.zzm();
        this.zzm = zzde.zza;
        this.zzn = zzfzn.zzm();
        this.zzo = 0;
        this.zzp = new HashMap();
        this.zzq = new HashSet();
    }

    public final zzdf zze(Context context) {
        CaptioningManager captioningManager;
        if ((zzfx.zza >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
            this.zzo = 1088;
            Locale locale = captioningManager.getLocale();
            if (locale != null) {
                this.zzn = zzfzn.zzn(locale.toLanguageTag());
            }
        }
        return this;
    }

    public zzdf zzf(int i, int i2, boolean z) {
        this.zze = i;
        this.zzf = i2;
        this.zzg = true;
        return this;
    }

    protected zzdf(zzdg zzdg) {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = zzdg.zzl;
        this.zzf = zzdg.zzm;
        this.zzg = zzdg.zzn;
        this.zzh = zzdg.zzo;
        this.zzi = zzdg.zzq;
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzdg.zzu;
        this.zzm = zzdg.zzv;
        this.zzn = zzdg.zzw;
        this.zzo = zzdg.zzx;
        this.zzq = new HashSet(zzdg.zzE);
        this.zzp = new HashMap(zzdg.zzD);
    }
}
