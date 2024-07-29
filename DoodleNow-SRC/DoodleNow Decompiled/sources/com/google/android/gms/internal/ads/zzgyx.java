package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzgyx extends IOException {
    zzgyx() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzgyx(String str, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th);
    }

    zzgyx(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
