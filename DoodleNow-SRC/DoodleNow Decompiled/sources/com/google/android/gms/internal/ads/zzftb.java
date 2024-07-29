package com.google.android.gms.internal.ads;

import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzftb extends zzfsp {
    private zzfxh<Integer> zza;
    private zzfxh<Integer> zzb;
    private zzfta zzc;
    private HttpURLConnection zzd;

    zzftb() {
        this(zzfsr.zza, zzfss.zza, (zzfta) null);
    }

    zzftb(zzfxh<Integer> zzfxh, zzfxh<Integer> zzfxh2, zzfta zzfta) {
        this.zza = zzfxh;
        this.zzb = zzfxh2;
        this.zzc = zzfta;
    }

    static /* synthetic */ Integer zzf() {
        return -1;
    }

    static /* synthetic */ Integer zzg() {
        return -1;
    }

    public static void zzs(HttpURLConnection httpURLConnection) {
        zzfsq.zza();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public void close() {
        zzs(this.zzd);
    }

    public HttpURLConnection zzm() throws IOException {
        zzfsq.zzb(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzfta zzfta = this.zzc;
        zzfta.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzfta.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    public HttpURLConnection zzn(zzfta zzfta, int i, int i2) throws IOException {
        this.zza = new zzfst(i);
        this.zzb = new zzfsu(i2);
        this.zzc = zzfta;
        return zzm();
    }

    public HttpURLConnection zzo(Network network, URL url, int i, int i2) throws IOException {
        this.zza = new zzfsv(i);
        this.zzb = new zzfsw(i2);
        this.zzc = new zzfsx(network, url);
        return zzm();
    }

    public URLConnection zzr(URL url, int i) throws IOException {
        this.zza = new zzfsy(i);
        this.zzc = new zzfsz(url);
        return zzm();
    }
}
