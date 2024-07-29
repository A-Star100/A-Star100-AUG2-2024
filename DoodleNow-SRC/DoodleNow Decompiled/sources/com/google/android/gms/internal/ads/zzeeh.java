package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import androidx.autofill.HintConstants;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbdg;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeeh extends zzeei {
    private static final SparseArray zzb;
    private final Context zzc;
    private final zzcxu zzd;
    private final TelephonyManager zze;
    /* access modifiers changed from: private */
    public final zzedz zzf;
    private zzbdg.zzq zzg;

    static {
        SparseArray sparseArray = new SparseArray();
        zzb = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbdg.zzaf.zzd.CONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzbdg.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzbdg.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzbdg.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbdg.zzaf.zzd.DISCONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzbdg.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzbdg.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzbdg.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzbdg.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzbdg.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbdg.zzaf.zzd.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzbdg.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzbdg.zzaf.zzd.CONNECTING);
    }

    zzeeh(Context context, zzcxu zzcxu, zzedz zzedz, zzedv zzedv, zzg zzg2) {
        super(zzedv, zzg2);
        this.zzc = context;
        this.zzd = zzcxu;
        this.zzf = zzedz;
        this.zze = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
    }

    static /* bridge */ /* synthetic */ zzbdg.zzab zza(zzeeh zzeeh, Bundle bundle) {
        zzbdg.zzab.zzb zzb2;
        zzbdg.zzab.zza zza = zzbdg.zzab.zza();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            zzeeh.zzg = zzbdg.zzq.ENUM_TRUE;
        } else {
            zzeeh.zzg = zzbdg.zzq.ENUM_FALSE;
            if (i == 0) {
                zza.zzd(zzbdg.zzab.zzc.CELL);
            } else if (i != 1) {
                zza.zzd(zzbdg.zzab.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zza.zzd(zzbdg.zzab.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzb2 = zzbdg.zzab.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzb2 = zzbdg.zzab.zzb.THREE_G;
                    break;
                case 13:
                    zzb2 = zzbdg.zzab.zzb.LTE;
                    break;
                default:
                    zzb2 = zzbdg.zzab.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zza.zzc(zzb2);
        }
        return (zzbdg.zzab) zza.zzbr();
    }

    static /* bridge */ /* synthetic */ zzbdg.zzaf.zzd zzb(zzeeh zzeeh, Bundle bundle) {
        return (zzbdg.zzaf.zzd) zzb.get(zzfgw.zza(zzfgw.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzbdg.zzaf.zzd.UNSPECIFIED);
    }

    static /* bridge */ /* synthetic */ byte[] zze(zzeeh zzeeh, boolean z, ArrayList arrayList, zzbdg.zzab zzab, zzbdg.zzaf.zzd zzd2) {
        zzbdg.zzaf.zza.C0015zza zzn = zzbdg.zzaf.zza.zzn();
        zzn.zzn(arrayList);
        boolean z2 = false;
        zzn.zzD(zzg(Settings.Global.getInt(zzeeh.zzc.getContentResolver(), "airplane_mode_on", 0) != 0));
        zzn.zzE(zzu.zzq().zzg(zzeeh.zzc, zzeeh.zze));
        zzn.zzM(zzeeh.zzf.zze());
        zzn.zzL(zzeeh.zzf.zzb());
        zzn.zzG(zzeeh.zzf.zza());
        zzn.zzH(zzd2);
        zzn.zzJ(zzab);
        zzn.zzK(zzeeh.zzg);
        zzn.zzN(zzg(z));
        zzn.zzP(zzeeh.zzf.zzd());
        zzn.zzO(zzu.zzB().currentTimeMillis());
        if (Settings.Global.getInt(zzeeh.zzc.getContentResolver(), "wifi_on", 0) != 0) {
            z2 = true;
        }
        zzn.zzQ(zzg(z2));
        return ((zzbdg.zzaf.zza) zzn.zzbr()).zzaV();
    }

    private static final zzbdg.zzq zzg(boolean z) {
        return z ? zzbdg.zzq.ENUM_TRUE : zzbdg.zzq.ENUM_FALSE;
    }

    public final void zzd(boolean z) {
        zzgee.zzr(this.zzd.zzb(new Bundle()), new zzeeg(this, z), zzcbr.zzf);
    }
}
