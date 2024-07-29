package com.google.android.gms.ads.internal.util.client;

import android.util.JsonWriter;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final /* synthetic */ class zzi implements zzk {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzi(String str) {
        this.zza = str;
    }

    public final void zza(JsonWriter jsonWriter) {
        int i = zzl.zza;
        jsonWriter.name(OutcomeEventsTable.COLUMN_NAME_PARAMS).beginObject();
        String str = this.zza;
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }
}
