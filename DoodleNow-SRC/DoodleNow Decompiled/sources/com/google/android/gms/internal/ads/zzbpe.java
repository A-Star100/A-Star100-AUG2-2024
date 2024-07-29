package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbpe implements zzbnv, zzbpd {
    private final zzbpd zza;
    private final HashSet zzb = new HashSet();

    public zzbpe(zzbpd zzbpd) {
        this.zza = zzbpd;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zzb(String str, String str2) {
        zzbnu.zzc(this, str, str2);
    }

    public final void zzc() {
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry simpleEntry = (AbstractMap.SimpleEntry) it.next();
            zze.zza("Unregistering eventhandler: ".concat(String.valueOf(((zzbky) simpleEntry.getValue()).toString())));
            this.zza.zzr((String) simpleEntry.getKey(), (zzbky) simpleEntry.getValue());
        }
        this.zzb.clear();
    }

    public final /* synthetic */ void zzd(String str, Map map) {
        zzbnu.zza(this, str, map);
    }

    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbnu.zzb(this, str, jSONObject);
    }

    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzbnu.zzd(this, str, jSONObject);
    }

    public final void zzq(String str, zzbky zzbky) {
        this.zza.zzq(str, zzbky);
        this.zzb.add(new AbstractMap.SimpleEntry(str, zzbky));
    }

    public final void zzr(String str, zzbky zzbky) {
        this.zza.zzr(str, zzbky);
        this.zzb.remove(new AbstractMap.SimpleEntry(str, zzbky));
    }
}
