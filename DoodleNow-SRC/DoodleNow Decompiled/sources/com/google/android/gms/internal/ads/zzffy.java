package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzffy {
    public final List zza;
    public final zzffq zzb;
    public final List zzc;
    public final zzbxd zzd;

    zzffy(JsonReader jsonReader, zzbxd zzbxd) throws IllegalStateException, IOException, JSONException, NumberFormatException, AssertionError {
        Bundle bundle;
        this.zzd = zzbxd;
        if (!(!((Boolean) zzba.zzc().zza(zzbdz.zzcc)).booleanValue() || zzbxd == null || (bundle = zzbxd.zzm) == null)) {
            bundle.putLong(zzdtq.SERVER_RESPONSE_PARSE_START.zza(), zzu.zzB().currentTimeMillis());
        }
        List emptyList = Collections.emptyList();
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        zzffq zzffq = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("responses".equals(nextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(nextName2)) {
                        emptyList = new ArrayList();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            emptyList.add(new zzffn(jsonReader));
                        }
                        jsonReader.endArray();
                    } else if (nextName2.equals("common")) {
                        zzffq = new zzffq(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                jsonReader.endArray();
            } else if (nextName.equals("actions")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String str = null;
                    JSONObject jSONObject = null;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        if ("name".equals(nextName3)) {
                            str = jsonReader.nextString();
                        } else if ("info".equals(nextName3)) {
                            jSONObject = zzbw.zzh(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (str != null) {
                        arrayList.add(new zzffx(str, jSONObject));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
            }
        }
        this.zzc = arrayList;
        this.zza = emptyList;
        this.zzb = zzffq == null ? new zzffq(new JsonReader(new StringReader("{}"))) : zzffq;
    }

    public static zzffy zza(Reader reader, zzbxd zzbxd) throws zzffr {
        try {
            zzffy zzffy = new zzffy(new JsonReader(reader), zzbxd);
            IOUtils.closeQuietly((Closeable) reader);
            return zzffy;
        } catch (IOException | AssertionError | IllegalStateException | NumberFormatException | JSONException e) {
            throw new zzffr("unable to parse ServerResponse", e);
        } catch (Throwable th) {
            IOUtils.closeQuietly((Closeable) reader);
            throw th;
        }
    }
}
