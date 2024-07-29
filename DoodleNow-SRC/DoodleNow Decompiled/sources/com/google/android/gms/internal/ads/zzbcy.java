package com.google.android.gms.internal.ads;

import io.nlopez.smartlocation.geofencing.providers.GeofencingGooglePlayServicesProvider;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbcy implements zzhaa {
    zzbcy() {
    }

    public final /* synthetic */ zzgzz zza(int i) {
        zzbcz zzbcz = zzbcz.UNKNOWN_EVENT_TYPE;
        switch (i) {
            case 0:
                return zzbcz.UNKNOWN_EVENT_TYPE;
            case 1:
                return zzbcz.AD_REQUEST;
            case 2:
                return zzbcz.AD_LOADED;
            case 3:
                return zzbcz.AD_FAILED_TO_LOAD;
            case 4:
                return zzbcz.AD_FAILED_TO_LOAD_NO_FILL;
            case 5:
                return zzbcz.AD_IMPRESSION;
            case 6:
                return zzbcz.AD_FIRST_CLICK;
            case 7:
                return zzbcz.AD_SUBSEQUENT_CLICK;
            case 8:
                return zzbcz.REQUEST_WILL_START;
            case 9:
                return zzbcz.REQUEST_DID_END;
            case 10:
                return zzbcz.REQUEST_WILL_UPDATE_SIGNALS;
            case 11:
                return zzbcz.REQUEST_DID_UPDATE_SIGNALS;
            case 12:
                return zzbcz.REQUEST_WILL_BUILD_URL;
            case 13:
                return zzbcz.REQUEST_DID_BUILD_URL;
            case 14:
                return zzbcz.REQUEST_WILL_MAKE_NETWORK_REQUEST;
            case 15:
                return zzbcz.REQUEST_DID_RECEIVE_NETWORK_RESPONSE;
            case 16:
                return zzbcz.REQUEST_WILL_PROCESS_RESPONSE;
            case 17:
                return zzbcz.REQUEST_DID_PROCESS_RESPONSE;
            case 18:
                return zzbcz.REQUEST_WILL_RENDER;
            case 19:
                return zzbcz.REQUEST_DID_RENDER;
            default:
                switch (i) {
                    case 100:
                        return zzbcz.AD_FAILED_TO_LOAD_INVALID_REQUEST;
                    case 101:
                        return zzbcz.AD_FAILED_TO_LOAD_NETWORK_ERROR;
                    case 102:
                        return zzbcz.AD_FAILED_TO_LOAD_TIMEOUT;
                    case 103:
                        return zzbcz.AD_FAILED_TO_LOAD_CANCELLED;
                    case 104:
                        return zzbcz.AD_FAILED_TO_LOAD_NO_ERROR;
                    case 105:
                        return zzbcz.AD_FAILED_TO_LOAD_NOT_FOUND;
                    default:
                        switch (i) {
                            case 1000:
                                return zzbcz.REQUEST_WILL_UPDATE_GMS_SIGNALS;
                            case 1001:
                                return zzbcz.REQUEST_DID_UPDATE_GMS_SIGNALS;
                            case 1002:
                                return zzbcz.REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS;
                            case 1003:
                                return zzbcz.REQUEST_FAILED_TO_BUILD_URL;
                            case 1004:
                                return zzbcz.REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST;
                            case 1005:
                                return zzbcz.REQUEST_FAILED_TO_PROCESS_RESPONSE;
                            case 1006:
                                return zzbcz.REQUEST_FAILED_TO_UPDATE_SIGNALS;
                            case 1007:
                                return zzbcz.REQUEST_FAILED_TO_RENDER;
                            default:
                                switch (i) {
                                    case 1100:
                                        return zzbcz.REQUEST_IS_PREFETCH;
                                    case 1101:
                                        return zzbcz.REQUEST_SAVED_TO_CACHE;
                                    case 1102:
                                        return zzbcz.REQUEST_LOADED_FROM_CACHE;
                                    case 1103:
                                        return zzbcz.REQUEST_PREFETCH_INTERCEPTED;
                                    case 1104:
                                        return zzbcz.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED;
                                    case 1105:
                                        return zzbcz.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED;
                                    case 1106:
                                        return zzbcz.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED;
                                    case 1107:
                                        return zzbcz.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED;
                                    case 1108:
                                        return zzbcz.REQUEST_FAILED_TO_LOAD_FROM_CACHE;
                                    default:
                                        switch (i) {
                                            case 10000:
                                                return zzbcz.BANNER_SIZE_INVALID;
                                            case 10001:
                                                return zzbcz.BANNER_SIZE_VALID;
                                            case 10002:
                                                return zzbcz.ANDROID_WEBVIEW_CRASH;
                                            case GeofencingGooglePlayServicesProvider.RESULT_CODE /*10003*/:
                                                return zzbcz.OFFLINE_UPLOAD;
                                            case 10004:
                                                return zzbcz.DELAY_PAGE_LOAD_CANCELLED_AD;
                                            default:
                                                return null;
                                        }
                                }
                        }
                }
        }
    }
}
