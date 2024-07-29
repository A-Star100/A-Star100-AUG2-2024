package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbdg;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbcx {
    private final zzbdf zza;
    private final zzbdg.zzt.zza zzb;
    private final boolean zzc;

    private zzbcx() {
        this.zzb = zzbdg.zzt.zzj();
        this.zzc = false;
        this.zza = new zzbdf();
    }

    public static zzbcx zza() {
        return new zzbcx();
    }

    private final synchronized String zzd(zzbcz zzbcz) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", new Object[]{this.zzb.zzah(), Long.valueOf(zzu.zzB().elapsedRealtime()), Integer.valueOf(zzbcz.zza()), Base64.encodeToString(((zzbdg.zzt) this.zzb.zzbr()).zzaV(), 3)});
    }

    private final synchronized void zze(zzbcz zzbcz) {
        FileOutputStream fileOutputStream;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                fileOutputStream = new FileOutputStream(new File(zzfsg.zza(zzfsf.zza(), externalStorageDirectory, "clearcut_events.txt", zzfsk.zza)), true);
                try {
                    fileOutputStream.write(zzd(zzbcz).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zze.zza("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zze.zza("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zze.zza("Could not close Clearcut output stream.");
                    }
                }
            } catch (FileNotFoundException unused4) {
                zze.zza("Could not find file for Clearcut");
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused5) {
                    zze.zza("Could not close Clearcut output stream.");
                }
                throw th;
            }
        }
    }

    private final synchronized void zzf(zzbcz zzbcz) {
        zzbdg.zzt.zza zza2 = this.zzb;
        zza2.zzq();
        zza2.zzj(zzt.zzd());
        zzbde zzbde = new zzbde(this.zza, ((zzbdg.zzt) this.zzb.zzbr()).zzaV(), (zzbdd) null);
        zzbde.zza(zzbcz.zza());
        zzbde.zzc();
        zze.zza("Logging Event with event code : ".concat(String.valueOf(Integer.toString(zzbcz.zza(), 10))));
    }

    public final synchronized void zzb(zzbcz zzbcz) {
        if (this.zzc) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzeR)).booleanValue()) {
                zze(zzbcz);
            } else {
                zzf(zzbcz);
            }
        }
    }

    public final synchronized void zzc(zzbcw zzbcw) {
        if (this.zzc) {
            try {
                zzbcw.zza(this.zzb);
            } catch (NullPointerException e) {
                zzu.zzo().zzw(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    public zzbcx(zzbdf zzbdf) {
        this.zzb = zzbdg.zzt.zzj();
        this.zza = zzbdf;
        this.zzc = ((Boolean) zzba.zzc().zza(zzbdz.zzeQ)).booleanValue();
    }
}
