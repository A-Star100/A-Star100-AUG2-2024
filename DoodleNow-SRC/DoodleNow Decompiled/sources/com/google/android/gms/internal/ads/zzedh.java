package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzedh {
    public int zza = 0;
    public Map zzb = new HashMap();
    public String zzc = "";
    public long zzd = -1;

    public static zzedh zza(Reader reader) throws zzffr {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            HashMap hashMap = new HashMap();
            String str = "";
            jsonReader.beginObject();
            long j = -1;
            int i = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("response".equals(nextName)) {
                    i = jsonReader.nextInt();
                } else if (TtmlNode.TAG_BODY.equals(nextName)) {
                    str = jsonReader.nextString();
                } else if ("latency".equals(nextName)) {
                    j = jsonReader.nextLong();
                } else if ("headers".equals(nextName)) {
                    hashMap = new HashMap();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        hashMap.put(jsonReader.nextName(), zzbw.zzd(jsonReader));
                    }
                    jsonReader.endObject();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            zzedh zzedh = new zzedh();
            zzedh.zza = i;
            if (str != null) {
                zzedh.zzc = str;
            }
            zzedh.zzd = j;
            zzedh.zzb = hashMap;
            IOUtils.closeQuietly((Closeable) reader);
            return zzedh;
        } catch (IOException | AssertionError | IllegalStateException | NumberFormatException e) {
            throw new zzffr("Unable to parse Response", e);
        } catch (Throwable th) {
            IOUtils.closeQuietly((Closeable) reader);
            throw th;
        }
    }
}
