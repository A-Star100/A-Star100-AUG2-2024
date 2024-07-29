package com.google.mlkit.common.sdkinternal.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.mlkit:common@@18.9.0 */
public class URLWrapper {
    private final URL zza;

    public URLWrapper(String str) throws MalformedURLException {
        this.zza = new URL(str);
    }

    public URLConnection openConnection() throws IOException {
        return this.zza.openConnection();
    }
}
