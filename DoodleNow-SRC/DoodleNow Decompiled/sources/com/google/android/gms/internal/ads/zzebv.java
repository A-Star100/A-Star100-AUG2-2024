package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzebv {
    public ListenableFuture zza;
    /* access modifiers changed from: private */
    public final zzdbj zzb;
    private final zzebd zzc;
    private final zzfkn zzd;
    private final zzfgi zze;
    private final VersionInfoParcel zzf;
    private final zzflk zzg;
    private final zzflh zzh;
    private final Context zzi;
    private final zzgep zzj;

    zzebv(zzdbj zzdbj, zzebd zzebd, zzfkn zzfkn, zzfgi zzfgi, VersionInfoParcel versionInfoParcel, zzflk zzflk, zzflh zzflh, Context context, zzgep zzgep) {
        this.zzb = zzdbj;
        this.zzc = zzebd;
        this.zzd = zzfkn;
        this.zze = zzfgi;
        this.zzf = versionInfoParcel;
        this.zzg = zzflk;
        this.zzh = zzflh;
        this.zzi = context;
        this.zzj = zzgep;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbwi zza(zzbxd zzbxd, zzedg zzedg) {
        zzedg.zzc.put("Content-Type", zzedg.zze);
        zzedg.zzc.put("User-Agent", zzu.zzp().zzc(this.zzi, zzbxd.zzb.afmaVersion));
        Bundle bundle = new Bundle();
        for (Map.Entry entry : zzedg.zzc.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return new zzbwi(zzedg.zza, zzedg.zzb, bundle, zzedg.zzd, zzedg.zzf, zzbxd.zzd, zzbxd.zzh);
    }

    public final ListenableFuture zzc(zzbxd zzbxd, JSONObject jSONObject, zzbxg zzbxg) {
        this.zzb.zzdn(zzbxd);
        zzfke zzb2 = this.zzd.zzb(zzfkh.PROXY, zzgee.zzm(this.zzd.zzb(zzfkh.PREPARE_HTTP_REQUEST, zzgee.zzh(new zzedk(jSONObject, zzbxg))).zze(new zzedl(zzbxd.zzg, this.zzh, zzfkv.zza(this.zzi, zzflo.CUI_NAME_ADREQUEST_BUILDURL))).zza(), new zzebr(this, zzbxd), this.zzj));
        zzebd zzebd = this.zzc;
        Objects.requireNonNull(zzebd);
        zzfjs zza2 = zzb2.zzf(new zzebs(zzebd)).zza();
        this.zza = zza2;
        ListenableFuture zzn = zzgee.zzn(this.zzd.zzb(zzfkh.PRE_PROCESS, zza2).zze(new zzebq(jSONObject, zzbxg)).zzf(zzu.zzf().zza(this.zzi, this.zzf, this.zzg).zza("google.afma.response.normalize", zzect.zza, zzbpn.zzb)).zza(), new zzebt(this, zzbxd), this.zzj);
        zzgee.zzr(zzn, new zzebu(this), this.zzj);
        return zzn;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(zzbxd zzbxd, InputStream inputStream) throws Exception {
        return zzgee.zzh(new zzffz(new zzffw(this.zze), zzffy.zza(new InputStreamReader(inputStream), zzbxd)));
    }
}
