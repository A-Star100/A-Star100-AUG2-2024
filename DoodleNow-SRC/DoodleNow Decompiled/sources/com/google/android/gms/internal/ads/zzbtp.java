package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbtp extends zzbts {
    private final Map zza;
    /* access modifiers changed from: private */
    public final Context zzb;

    public zzbtp(zzcgm zzcgm, Map map) {
        super(zzcgm, "storePicture");
        this.zza = map;
        this.zzb = zzcgm.zzi();
    }

    public final void zzb() {
        if (this.zzb == null) {
            zzh("Activity context is not available");
            return;
        }
        zzu.zzp();
        if (!new zzbdi(this.zzb).zzc()) {
            zzh("Feature is not supported by the device.");
            return;
        }
        String str = (String) this.zza.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzh("Image url cannot be empty.");
        } else if (URLUtil.isValidUrl(str)) {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            zzu.zzp();
            if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
                Resources zze = zzu.zzo().zze();
                zzu.zzp();
                AlertDialog.Builder zzK = zzt.zzK(this.zzb);
                zzK.setTitle(zze != null ? zze.getString(R.string.s1) : "Save image");
                zzK.setMessage(zze != null ? zze.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
                zzK.setPositiveButton(zze != null ? zze.getString(R.string.s3) : "Accept", new zzbtn(this, str, lastPathSegment));
                zzK.setNegativeButton(zze != null ? zze.getString(R.string.s4) : "Decline", new zzbto(this));
                zzK.create().show();
                return;
            }
            zzh("Image type not recognized: ".concat(String.valueOf(lastPathSegment)));
        } else {
            zzh("Invalid image url: ".concat(String.valueOf(str)));
        }
    }
}
