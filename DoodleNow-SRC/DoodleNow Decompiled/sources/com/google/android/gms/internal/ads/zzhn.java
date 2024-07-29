package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.onesignal.inAppMessages.internal.InAppMessageContent;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzhn implements zzfws {
    public static final /* synthetic */ zzhn zza = new zzhn();

    private /* synthetic */ zzhn() {
    }

    public final boolean zza(Object obj) {
        String str = (String) obj;
        if (str == null) {
            return false;
        }
        String zza2 = zzfvx.zza(str);
        if (!TextUtils.isEmpty(zza2)) {
            return (!zza2.contains("text") || zza2.contains(MimeTypes.TEXT_VTT)) && !zza2.contains(InAppMessageContent.HTML) && !zza2.contains("xml");
        }
        return false;
    }
}
