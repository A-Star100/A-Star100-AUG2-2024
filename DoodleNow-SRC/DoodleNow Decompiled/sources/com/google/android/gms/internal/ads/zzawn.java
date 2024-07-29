package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzawn extends zzawm {
    protected zzawn(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzawn zzt(String str, Context context, boolean z) {
        zzr(context, false);
        return new zzawn(context, str, false);
    }

    @Deprecated
    public static zzawn zzu(String str, Context context, boolean z, int i) {
        zzr(context, z);
        return new zzawn(context, str, z);
    }

    /* access modifiers changed from: protected */
    public final List zzp(zzaxp zzaxp, Context context, zzata zzata, zzasr zzasr) {
        if (zzaxp.zzk() == null || !this.zzu) {
            return super.zzp(zzaxp, context, zzata, (zzasr) null);
        }
        int zza = zzaxp.zza();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzp(zzaxp, context, zzata, (zzasr) null));
        arrayList.add(new zzayh(zzaxp, "FLgp79R6LGLnWDio6G1XBjsjORgKSjLkdakyn5bigQludVyQtVZMhDAlppvakfKf", "oPDFFWKd1EuWWR8iem/Fb2LK/5grpy+LhaDBlMcgIHs=", zzata, zza, 24));
        return arrayList;
    }
}
