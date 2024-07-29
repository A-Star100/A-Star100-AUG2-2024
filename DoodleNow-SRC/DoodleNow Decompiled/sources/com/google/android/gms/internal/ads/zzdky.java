package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.amazon.a.a.o.b;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdky {
    private int zza;
    private zzdq zzb;
    private zzbgx zzc;
    private View zzd;
    private List zze;
    private List zzf = Collections.emptyList();
    private zzel zzg;
    private Bundle zzh;
    private zzcgm zzi;
    private zzcgm zzj;
    private zzcgm zzk;
    private zzfmy zzl;
    private ListenableFuture zzm;
    private zzcbw zzn;
    private View zzo;
    private View zzp;
    private IObjectWrapper zzq;
    private double zzr;
    private zzbhe zzs;
    private zzbhe zzt;
    private String zzu;
    private final SimpleArrayMap zzv = new SimpleArrayMap();
    private final SimpleArrayMap zzw = new SimpleArrayMap();
    private float zzx;
    private String zzy;

    public static zzdky zzag(zzbqz zzbqz) {
        try {
            zzdkx zzak = zzak(zzbqz.zzg(), (zzbrd) null);
            zzbgx zzh2 = zzbqz.zzh();
            String zzo2 = zzbqz.zzo();
            List zzr2 = zzbqz.zzr();
            String zzm2 = zzbqz.zzm();
            Bundle zzf2 = zzbqz.zzf();
            String zzn2 = zzbqz.zzn();
            IObjectWrapper zzl2 = zzbqz.zzl();
            String zzq2 = zzbqz.zzq();
            String zzp2 = zzbqz.zzp();
            double zze2 = zzbqz.zze();
            zzbhe zzi2 = zzbqz.zzi();
            zzdky zzdky = new zzdky();
            zzdky.zza = 2;
            zzdky.zzb = zzak;
            zzdky.zzc = zzh2;
            zzdky.zzd = (View) zzam(zzbqz.zzj());
            zzdky.zzZ("headline", zzo2);
            zzdky.zze = zzr2;
            zzdky.zzZ(TtmlNode.TAG_BODY, zzm2);
            zzdky.zzh = zzf2;
            zzdky.zzZ("call_to_action", zzn2);
            zzdky.zzo = (View) zzam(zzbqz.zzk());
            zzdky.zzq = zzl2;
            zzdky.zzZ(ProductResponseJsonKeys.STORE, zzq2);
            zzdky.zzZ(b.x, zzp2);
            zzdky.zzr = zze2;
            zzdky.zzs = zzi2;
            return zzdky;
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzdky zzah(zzbra zzbra) {
        try {
            zzdkx zzak = zzak(zzbra.zzf(), (zzbrd) null);
            zzbgx zzg2 = zzbra.zzg();
            String zzo2 = zzbra.zzo();
            List zzp2 = zzbra.zzp();
            String zzm2 = zzbra.zzm();
            Bundle zze2 = zzbra.zze();
            String zzn2 = zzbra.zzn();
            IObjectWrapper zzk2 = zzbra.zzk();
            String zzl2 = zzbra.zzl();
            zzbhe zzh2 = zzbra.zzh();
            zzdky zzdky = new zzdky();
            zzdky.zza = 1;
            zzdky.zzb = zzak;
            zzdky.zzc = zzg2;
            zzdky.zzd = (View) zzam(zzbra.zzi());
            zzdky.zzZ("headline", zzo2);
            zzdky.zze = zzp2;
            zzdky.zzZ(TtmlNode.TAG_BODY, zzm2);
            zzdky.zzh = zze2;
            zzdky.zzZ("call_to_action", zzn2);
            zzdky.zzo = (View) zzam(zzbra.zzj());
            zzdky.zzq = zzk2;
            zzdky.zzZ("advertiser", zzl2);
            zzdky.zzt = zzh2;
            return zzdky;
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzdky zzai(zzbqz zzbqz) {
        try {
            return zzal(zzak(zzbqz.zzg(), (zzbrd) null), zzbqz.zzh(), (View) zzam(zzbqz.zzj()), zzbqz.zzo(), zzbqz.zzr(), zzbqz.zzm(), zzbqz.zzf(), zzbqz.zzn(), (View) zzam(zzbqz.zzk()), zzbqz.zzl(), zzbqz.zzq(), zzbqz.zzp(), zzbqz.zze(), zzbqz.zzi(), (String) null, 0.0f);
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzdky zzaj(zzbra zzbra) {
        try {
            return zzal(zzak(zzbra.zzf(), (zzbrd) null), zzbra.zzg(), (View) zzam(zzbra.zzi()), zzbra.zzo(), zzbra.zzp(), zzbra.zzm(), zzbra.zze(), zzbra.zzn(), (View) zzam(zzbra.zzj()), zzbra.zzk(), (String) null, (String) null, -1.0d, zzbra.zzh(), zzbra.zzl(), 0.0f);
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzdkx zzak(zzdq zzdq, zzbrd zzbrd) {
        if (zzdq == null) {
            return null;
        }
        return new zzdkx(zzdq, zzbrd);
    }

    private static zzdky zzal(zzdq zzdq, zzbgx zzbgx, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzbhe zzbhe, String str6, float f) {
        zzdky zzdky = new zzdky();
        zzdky.zza = 6;
        zzdky.zzb = zzdq;
        zzdky.zzc = zzbgx;
        zzdky.zzd = view;
        String str7 = str;
        zzdky.zzZ("headline", str);
        zzdky.zze = list;
        String str8 = str2;
        zzdky.zzZ(TtmlNode.TAG_BODY, str2);
        zzdky.zzh = bundle;
        String str9 = str3;
        zzdky.zzZ("call_to_action", str3);
        zzdky.zzo = view2;
        zzdky.zzq = iObjectWrapper;
        String str10 = str4;
        zzdky.zzZ(ProductResponseJsonKeys.STORE, str4);
        String str11 = str5;
        zzdky.zzZ(b.x, str5);
        zzdky.zzr = d;
        zzdky.zzs = zzbhe;
        zzdky.zzZ("advertiser", str6);
        zzdky.zzR(f);
        return zzdky;
    }

    private static Object zzam(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    public static zzdky zzt(zzbrd zzbrd) {
        try {
            return zzal(zzak(zzbrd.zzj(), zzbrd), zzbrd.zzk(), (View) zzam(zzbrd.zzm()), zzbrd.zzs(), zzbrd.zzv(), zzbrd.zzq(), zzbrd.zzi(), zzbrd.zzr(), (View) zzam(zzbrd.zzn()), zzbrd.zzo(), zzbrd.zzu(), zzbrd.zzt(), zzbrd.zze(), zzbrd.zzl(), zzbrd.zzp(), zzbrd.zzf());
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public final synchronized String zzA() {
        return this.zzu;
    }

    public final synchronized String zzB() {
        return zzF("headline");
    }

    public final synchronized String zzC() {
        return this.zzy;
    }

    public final synchronized String zzD() {
        return zzF(b.x);
    }

    public final synchronized String zzE() {
        return zzF(ProductResponseJsonKeys.STORE);
    }

    public final synchronized String zzF(String str) {
        return (String) this.zzw.get(str);
    }

    public final synchronized List zzG() {
        return this.zze;
    }

    public final synchronized List zzH() {
        return this.zzf;
    }

    public final synchronized void zzI() {
        zzcgm zzcgm = this.zzi;
        if (zzcgm != null) {
            zzcgm.destroy();
            this.zzi = null;
        }
        zzcgm zzcgm2 = this.zzj;
        if (zzcgm2 != null) {
            zzcgm2.destroy();
            this.zzj = null;
        }
        zzcgm zzcgm3 = this.zzk;
        if (zzcgm3 != null) {
            zzcgm3.destroy();
            this.zzk = null;
        }
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            this.zzm = null;
        }
        zzcbw zzcbw = this.zzn;
        if (zzcbw != null) {
            zzcbw.cancel(false);
            this.zzn = null;
        }
        this.zzl = null;
        this.zzv.clear();
        this.zzw.clear();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzh = null;
        this.zzo = null;
        this.zzp = null;
        this.zzq = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
    }

    public final synchronized void zzJ(zzbgx zzbgx) {
        this.zzc = zzbgx;
    }

    public final synchronized void zzK(String str) {
        this.zzu = str;
    }

    public final synchronized void zzL(zzel zzel) {
        this.zzg = zzel;
    }

    public final synchronized void zzM(zzbhe zzbhe) {
        this.zzs = zzbhe;
    }

    public final synchronized void zzN(String str, zzbgr zzbgr) {
        if (zzbgr == null) {
            this.zzv.remove(str);
        } else {
            this.zzv.put(str, zzbgr);
        }
    }

    public final synchronized void zzO(zzcgm zzcgm) {
        this.zzj = zzcgm;
    }

    public final synchronized void zzP(List list) {
        this.zze = list;
    }

    public final synchronized void zzQ(zzbhe zzbhe) {
        this.zzt = zzbhe;
    }

    public final synchronized void zzR(float f) {
        this.zzx = f;
    }

    public final synchronized void zzS(List list) {
        this.zzf = list;
    }

    public final synchronized void zzT(zzcgm zzcgm) {
        this.zzk = zzcgm;
    }

    public final synchronized void zzU(ListenableFuture listenableFuture) {
        this.zzm = listenableFuture;
    }

    public final synchronized void zzV(String str) {
        this.zzy = str;
    }

    public final synchronized void zzW(zzfmy zzfmy) {
        this.zzl = zzfmy;
    }

    public final synchronized void zzX(zzcbw zzcbw) {
        this.zzn = zzcbw;
    }

    public final synchronized void zzY(double d) {
        this.zzr = d;
    }

    public final synchronized void zzZ(String str, String str2) {
        if (str2 == null) {
            this.zzw.remove(str);
        } else {
            this.zzw.put(str, str2);
        }
    }

    public final synchronized double zza() {
        return this.zzr;
    }

    public final synchronized void zzaa(int i) {
        this.zza = i;
    }

    public final synchronized void zzab(zzdq zzdq) {
        this.zzb = zzdq;
    }

    public final synchronized void zzac(View view) {
        this.zzo = view;
    }

    public final synchronized void zzad(zzcgm zzcgm) {
        this.zzi = zzcgm;
    }

    public final synchronized void zzae(View view) {
        this.zzp = view;
    }

    public final synchronized boolean zzaf() {
        return this.zzj != null;
    }

    public final synchronized float zzb() {
        return this.zzx;
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized Bundle zzd() {
        if (this.zzh == null) {
            this.zzh = new Bundle();
        }
        return this.zzh;
    }

    public final synchronized View zze() {
        return this.zzd;
    }

    public final synchronized View zzf() {
        return this.zzo;
    }

    public final synchronized View zzg() {
        return this.zzp;
    }

    public final synchronized SimpleArrayMap zzh() {
        return this.zzv;
    }

    public final synchronized SimpleArrayMap zzi() {
        return this.zzw;
    }

    public final synchronized zzdq zzj() {
        return this.zzb;
    }

    public final synchronized zzel zzk() {
        return this.zzg;
    }

    public final synchronized zzbgx zzl() {
        return this.zzc;
    }

    public final zzbhe zzm() {
        List list = this.zze;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object obj = this.zze.get(0);
        if (obj instanceof IBinder) {
            return zzbhd.zzg((IBinder) obj);
        }
        return null;
    }

    public final synchronized zzbhe zzn() {
        return this.zzs;
    }

    public final synchronized zzbhe zzo() {
        return this.zzt;
    }

    public final synchronized zzcbw zzp() {
        return this.zzn;
    }

    public final synchronized zzcgm zzq() {
        return this.zzj;
    }

    public final synchronized zzcgm zzr() {
        return this.zzk;
    }

    public final synchronized zzcgm zzs() {
        return this.zzi;
    }

    public final synchronized zzfmy zzu() {
        return this.zzl;
    }

    public final synchronized IObjectWrapper zzv() {
        return this.zzq;
    }

    public final synchronized ListenableFuture zzw() {
        return this.zzm;
    }

    public final synchronized String zzx() {
        return zzF("advertiser");
    }

    public final synchronized String zzy() {
        return zzF(TtmlNode.TAG_BODY);
    }

    public final synchronized String zzz() {
        return zzF("call_to_action");
    }
}
