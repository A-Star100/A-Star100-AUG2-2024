package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfnu {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final List zzb = new ArrayList();

    public final List zza() {
        return this.zzb;
    }

    public final void zzb(View view, zzfnf zzfnf, String str) {
        zzfnt zzfnt;
        if (zza.matcher("Ad overlay").matches()) {
            Iterator it = this.zzb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    zzfnt = null;
                    break;
                }
                zzfnt = (zzfnt) it.next();
                if (zzfnt.zzb().get() == view) {
                    break;
                }
            }
            if (zzfnt == null) {
                this.zzb.add(new zzfnt(view, zzfnf, "Ad overlay"));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
    }

    public final void zzc() {
        this.zzb.clear();
    }
}
