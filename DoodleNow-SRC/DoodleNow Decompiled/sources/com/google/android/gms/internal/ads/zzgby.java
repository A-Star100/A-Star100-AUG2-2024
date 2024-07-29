package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgby implements FilenameFilter {
    private final Pattern zza;

    public zzgby(Pattern pattern) {
        pattern.getClass();
        this.zza = pattern;
    }

    public final boolean accept(File file, String str) {
        return this.zza.matcher(str).matches();
    }
}
