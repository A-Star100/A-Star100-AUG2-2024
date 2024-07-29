package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdtr {
    public static final zzfzn zza;
    public static final zzfzn zzb;
    private final String zzc;
    private final zzdtq zzd;
    private final zzdtq zze;

    static {
        zzdtq zzdtq = zzdtq.PUBLIC_API_CALL;
        zzdtq zzdtq2 = zzdtq.PUBLIC_API_CALLBACK;
        zzdtr zzdtr = new zzdtr("tqgt", zzdtq, zzdtq2);
        zzdtq zzdtq3 = zzdtq.PUBLIC_API_CALL;
        zzdtq zzdtq4 = zzdtq.DYNAMITE_ENTER;
        zzdtr zzdtr2 = new zzdtr("l.dl", zzdtq3, zzdtq4);
        zzdtq zzdtq5 = zzdtq.CLIENT_SIGNALS_START;
        zzdtr zzdtr3 = new zzdtr("l.rcc", zzdtq4, zzdtq5);
        zzdtq zzdtq6 = zzdtq.CLIENT_SIGNALS_END;
        zzdtr zzdtr4 = new zzdtr("l.cs", zzdtq5, zzdtq6);
        zzdtr zzdtr5 = new zzdtr("l.cts", zzdtq6, zzdtq.SERVICE_CONNECTED);
        zzdtq zzdtq7 = zzdtq.GMS_SIGNALS_START;
        zzdtq zzdtq8 = zzdtq.GMS_SIGNALS_END;
        zzdtr zzdtr6 = new zzdtr("l.gs", zzdtq7, zzdtq8);
        zzdtq zzdtq9 = zzdtq.GET_SIGNALS_SDKCORE_START;
        zzdtr zzdtr7 = new zzdtr("l.jse", zzdtq8, zzdtq9);
        zzdtq zzdtq10 = zzdtq.GET_SIGNALS_SDKCORE_END;
        zza = zzfzn.zzs(zzdtr, zzdtr2, zzdtr3, zzdtr4, zzdtr5, zzdtr6, zzdtr7, new zzdtr("l.gs-sdkcore", zzdtq9, zzdtq10), new zzdtr("l.gs-pp", zzdtq10, zzdtq2));
        zzdtq zzdtq11 = zzdtq.PUBLIC_API_CALL;
        zzdtr zzdtr8 = new zzdtr("l.al", zzdtq11, zzdtq.PUBLIC_API_CALLBACK);
        zzdtq zzdtq12 = zzdtq.DYNAMITE_ENTER;
        zzdtr zzdtr9 = new zzdtr("l.dl", zzdtq11, zzdtq12);
        zzdtq zzdtq13 = zzdtq.CLIENT_SIGNALS_START;
        zzdtr zzdtr10 = new zzdtr("l.rcc", zzdtq12, zzdtq13);
        zzdtq zzdtq14 = zzdtq.CLIENT_SIGNALS_END;
        zzdtr zzdtr11 = new zzdtr("l.cs", zzdtq13, zzdtq14);
        zzdtr zzdtr12 = new zzdtr("l.cts", zzdtq14, zzdtq.SERVICE_CONNECTED);
        zzdtq zzdtq15 = zzdtq.GMS_SIGNALS_START;
        zzdtq zzdtq16 = zzdtq.GMS_SIGNALS_END;
        zzdtr zzdtr13 = new zzdtr("l.gs", zzdtq15, zzdtq16);
        zzdtq zzdtq17 = zzdtq.GET_AD_DICTIONARY_SDKCORE_START;
        zzdtr zzdtr14 = new zzdtr("l.jse", zzdtq16, zzdtq17);
        zzdtq zzdtq18 = zzdtq.GET_AD_DICTIONARY_SDKCORE_END;
        zzdtr zzdtr15 = new zzdtr("l.gad-js", zzdtq17, zzdtq18);
        zzdtq zzdtq19 = zzdtq.HTTP_RESPONSE_READY;
        zzb = zzfzn.zzt(zzdtr8, zzdtr9, zzdtr10, zzdtr11, zzdtr12, zzdtr13, zzdtr14, zzdtr15, new zzdtr("l.http", zzdtq18, zzdtq19), new zzdtr("l.nml-js", zzdtq19, zzdtq.SERVER_RESPONSE_PARSE_START));
    }

    public zzdtr(String str, zzdtq zzdtq, zzdtq zzdtq2) {
        this.zzc = str;
        this.zzd = zzdtq;
        this.zze = zzdtq2;
    }

    public final zzdtq zza() {
        return this.zzd;
    }

    public final zzdtq zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzc;
    }
}
