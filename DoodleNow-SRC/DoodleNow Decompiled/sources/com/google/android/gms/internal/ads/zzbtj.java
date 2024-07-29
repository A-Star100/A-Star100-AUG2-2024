package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.amazon.a.a.o.b;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbtj extends zzbts {
    private final Map zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    private final String zzc = zze(b.c);
    private final long zzd = zzd("start_ticks");
    private final long zze = zzd("end_ticks");
    private final String zzf = zze("summary");
    private final String zzg = zze("location");

    public zzbtj(zzcgm zzcgm, Map map) {
        super(zzcgm, "createCalendarEvent");
        this.zza = map;
        this.zzb = zzcgm.zzi();
    }

    private final long zzd(String str) {
        String str2 = (String) this.zza.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private final String zze(String str) {
        return TextUtils.isEmpty((CharSequence) this.zza.get(str)) ? "" : (String) this.zza.get(str);
    }

    /* access modifiers changed from: package-private */
    public final Intent zzb() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzc);
        data.putExtra("eventLocation", this.zzg);
        data.putExtra(b.c, this.zzf);
        long j = this.zzd;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zze;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void zzc() {
        if (this.zzb == null) {
            zzh("Activity context is not available.");
            return;
        }
        zzu.zzp();
        if (!new zzbdi(this.zzb).zzb()) {
            zzh("This feature is not available on the device.");
            return;
        }
        zzu.zzp();
        AlertDialog.Builder zzK = zzt.zzK(this.zzb);
        Resources zze2 = zzu.zzo().zze();
        zzK.setTitle(zze2 != null ? zze2.getString(R.string.s5) : "Create calendar event");
        zzK.setMessage(zze2 != null ? zze2.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        zzK.setPositiveButton(zze2 != null ? zze2.getString(R.string.s3) : "Accept", new zzbth(this));
        zzK.setNegativeButton(zze2 != null ? zze2.getString(R.string.s4) : "Decline", new zzbti(this));
        zzK.create().show();
    }
}
