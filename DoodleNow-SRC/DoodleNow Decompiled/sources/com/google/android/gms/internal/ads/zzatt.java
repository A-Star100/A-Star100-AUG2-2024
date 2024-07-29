package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzatt implements zzhaa {
    zzatt() {
    }

    public final /* synthetic */ zzgzz zza(int i) {
        zzatu zzatu = zzatu.ERROR_ENCODE_SIZE_FAIL;
        if (i == 1) {
            return zzatu.ERROR_ENCODE_SIZE_FAIL;
        }
        if (i == 2) {
            return zzatu.PSN_WEB64_FAIL;
        }
        if (i == 3) {
            return zzatu.ERROR_UNKNOWN;
        }
        if (i == 4) {
            return zzatu.PSN_DECRYPT_SIZE_FAIL;
        }
        if (i == 5) {
            return zzatu.ERROR_NO_SIGNALS;
        }
        if (i == 7) {
            return zzatu.ERROR_ENCRYPTION;
        }
        if (i == 8) {
            return zzatu.PSN_MD5_CHECK_FAIL;
        }
        if (i == 9) {
            return zzatu.ERROR_MEMORY;
        }
        switch (i) {
            case 11:
                return zzatu.ERROR_SIMULATOR;
            case 13:
                return zzatu.ERROR_SERVICE;
            case 32:
                return zzatu.PSN_MD5_FAIL;
            case 64:
                return zzatu.PSN_DECODE_FAIL;
            case 128:
                return zzatu.PSN_SALT_FAIL;
            case 256:
                return zzatu.PSN_BITSLICER_FAIL;
            case 512:
                return zzatu.PSN_REQUEST_TYPE_FAIL;
            case 1024:
                return zzatu.PSN_INVALID_ERROR_CODE;
            case 2048:
                return zzatu.PSN_TIMESTAMP_EXPIRED;
            case 4096:
                return zzatu.PSN_ENCODE_SIZE_FAIL;
            case 8192:
                return zzatu.PSN_BLANK_VALUE;
            case 16384:
                return zzatu.PSN_INITIALIZATION_FAIL;
            case 32768:
                return zzatu.PSN_GASS_CLIENT_FAIL;
            case 65536:
                return zzatu.PSN_SIGNALS_TIMEOUT;
            case 131072:
                return zzatu.PSN_TINK_FAIL;
            default:
                switch (i) {
                    case 15:
                        return zzatu.ERROR_THREAD;
                    case 16:
                        return zzatu.PSN_MD5_SIZE_FAIL;
                    case 17:
                        return zzatu.ERROR_COLLECTION_TIMEOUT;
                    default:
                        return null;
                }
        }
    }
}
