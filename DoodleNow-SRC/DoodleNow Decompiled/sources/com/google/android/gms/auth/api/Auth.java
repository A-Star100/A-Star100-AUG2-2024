package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zbd;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
public final class Auth {
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API;
    public static final GoogleSignInApi GoogleSignInApi = new zbd();
    @Deprecated
    public static final Api<AuthProxyOptions> PROXY_API = AuthProxy.API;
    @Deprecated
    public static final ProxyApi ProxyApi = AuthProxy.ProxyApi;
    public static final Api.ClientKey zba;
    public static final Api.ClientKey zbb;
    public static final Api zbc;
    public static final com.google.android.gms.internal.p001authapi.zbd zbd = new com.google.android.gms.internal.p001authapi.zbd();
    private static final Api.AbstractClientBuilder zbe;
    private static final Api.AbstractClientBuilder zbf;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zba = clientKey;
        Api.ClientKey clientKey2 = new Api.ClientKey();
        zbb = clientKey2;
        zba zba2 = new zba();
        zbe = zba2;
        zbb zbb2 = new zbb();
        zbf = zbb2;
        zbc = new Api("Auth.CREDENTIALS_API", zba2, clientKey);
        GOOGLE_SIGN_IN_API = new Api<>("Auth.GOOGLE_SIGN_IN_API", zbb2, clientKey2);
    }

    private Auth() {
    }
}
