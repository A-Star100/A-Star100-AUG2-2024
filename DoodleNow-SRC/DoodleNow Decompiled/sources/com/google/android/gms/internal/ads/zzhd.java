package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhd implements zzgv {
    private final Context zza;
    private final List zzb = new ArrayList();
    private final zzgv zzc;
    private zzgv zzd;
    private zzgv zze;
    private zzgv zzf;
    private zzgv zzg;
    private zzgv zzh;
    private zzgv zzi;
    private zzgv zzj;
    private zzgv zzk;

    public zzhd(Context context, zzgv zzgv) {
        this.zza = context.getApplicationContext();
        this.zzc = zzgv;
    }

    private final zzgv zzg() {
        if (this.zze == null) {
            zzgo zzgo = new zzgo(this.zza);
            this.zze = zzgo;
            zzh(zzgo);
        }
        return this.zze;
    }

    private final void zzh(zzgv zzgv) {
        for (int i = 0; i < this.zzb.size(); i++) {
            zzgv.zzf((zzhy) this.zzb.get(i));
        }
    }

    private static final void zzi(zzgv zzgv, zzhy zzhy) {
        if (zzgv != null) {
            zzgv.zzf(zzhy);
        }
    }

    public final long zzb(zzhb zzhb) throws IOException {
        zzgv zzgv;
        zzek.zzf(this.zzk == null);
        String scheme = zzhb.zza.getScheme();
        Uri uri = zzhb.zza;
        int i = zzfx.zza;
        String scheme2 = uri.getScheme();
        if (TextUtils.isEmpty(scheme2) || "file".equals(scheme2)) {
            String path = zzhb.zza.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.zzd == null) {
                    zzhm zzhm = new zzhm();
                    this.zzd = zzhm;
                    zzh(zzhm);
                }
                this.zzk = this.zzd;
            } else {
                this.zzk = zzg();
            }
        } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
            this.zzk = zzg();
        } else if (UriUtil.LOCAL_CONTENT_SCHEME.equals(scheme)) {
            if (this.zzf == null) {
                zzgs zzgs = new zzgs(this.zza);
                this.zzf = zzgs;
                zzh(zzgs);
            }
            this.zzk = this.zzf;
        } else if ("rtmp".equals(scheme)) {
            if (this.zzg == null) {
                try {
                    zzgv zzgv2 = (zzgv) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.zzg = zzgv2;
                    zzh(zzgv2);
                } catch (ClassNotFoundException unused) {
                    zzfe.zzf("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating RTMP extension", e);
                }
                if (this.zzg == null) {
                    this.zzg = this.zzc;
                }
            }
            this.zzk = this.zzg;
        } else if ("udp".equals(scheme)) {
            if (this.zzh == null) {
                zzia zzia = new zzia(2000);
                this.zzh = zzia;
                zzh(zzia);
            }
            this.zzk = this.zzh;
        } else if ("data".equals(scheme)) {
            if (this.zzi == null) {
                zzgt zzgt = new zzgt();
                this.zzi = zzgt;
                zzh(zzgt);
            }
            this.zzk = this.zzi;
        } else {
            if (RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(scheme) || UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(scheme)) {
                if (this.zzj == null) {
                    zzhw zzhw = new zzhw(this.zza);
                    this.zzj = zzhw;
                    zzh(zzhw);
                }
                zzgv = this.zzj;
            } else {
                zzgv = this.zzc;
            }
            this.zzk = zzgv;
        }
        return this.zzk.zzb(zzhb);
    }

    public final Uri zzc() {
        zzgv zzgv = this.zzk;
        if (zzgv == null) {
            return null;
        }
        return zzgv.zzc();
    }

    public final void zzd() throws IOException {
        zzgv zzgv = this.zzk;
        if (zzgv != null) {
            try {
                zzgv.zzd();
            } finally {
                this.zzk = null;
            }
        }
    }

    public final Map zze() {
        zzgv zzgv = this.zzk;
        return zzgv == null ? Collections.emptyMap() : zzgv.zze();
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        zzgv zzgv = this.zzk;
        zzgv.getClass();
        return zzgv.zza(bArr, i, i2);
    }

    public final void zzf(zzhy zzhy) {
        zzhy.getClass();
        this.zzc.zzf(zzhy);
        this.zzb.add(zzhy);
        zzi(this.zzd, zzhy);
        zzi(this.zze, zzhy);
        zzi(this.zzf, zzhy);
        zzi(this.zzg, zzhy);
        zzi(this.zzh, zzhy);
        zzi(this.zzi, zzhy);
        zzi(this.zzj, zzhy);
    }
}
