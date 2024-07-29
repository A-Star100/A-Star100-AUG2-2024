package com.ReactNativeBlobUtil;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.polidea.rxandroidble2.ClientComponent;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Locale;

class ReactNativeBlobUtilConfig {
    public ReadableMap addAndroidDownloads;
    public String appendExt;
    public Boolean auto;
    public ReadableArray binaryContentTypes;
    public Boolean fileCache;
    public Boolean followRedirect = true;
    public Boolean increment = false;
    public String key;
    public String mime;
    public Boolean overwrite = true;
    public String path;
    public long timeout = 60000;
    public Boolean transformFile;
    public Boolean trusty;
    public Boolean wifiOnly = false;

    ReactNativeBlobUtilConfig(ReadableMap readableMap) {
        boolean z = false;
        String str = null;
        this.binaryContentTypes = null;
        if (readableMap != null) {
            this.fileCache = Boolean.valueOf(readableMap.hasKey("fileCache") && readableMap.getBoolean("fileCache"));
            this.transformFile = Boolean.valueOf(readableMap.hasKey("transformFile") ? readableMap.getBoolean("transformFile") : false);
            this.path = readableMap.hasKey(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH) ? readableMap.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH) : null;
            this.appendExt = readableMap.hasKey("appendExt") ? readableMap.getString("appendExt") : "";
            this.trusty = Boolean.valueOf(readableMap.hasKey("trusty") && readableMap.getBoolean("trusty"));
            this.wifiOnly = Boolean.valueOf(readableMap.hasKey("wifiOnly") && readableMap.getBoolean("wifiOnly"));
            if (readableMap.hasKey("addAndroidDownloads")) {
                this.addAndroidDownloads = readableMap.getMap("addAndroidDownloads");
            }
            if (readableMap.hasKey("binaryContentTypes")) {
                this.binaryContentTypes = readableMap.getArray("binaryContentTypes");
            }
            String str2 = this.path;
            if (str2 != null && str2.toLowerCase(Locale.ROOT).contains("?append=true")) {
                this.overwrite = false;
            }
            if (readableMap.hasKey("overwrite")) {
                this.overwrite = Boolean.valueOf(readableMap.getBoolean("overwrite"));
            }
            if (readableMap.hasKey("followRedirect")) {
                this.followRedirect = Boolean.valueOf(readableMap.getBoolean("followRedirect"));
            }
            this.key = readableMap.hasKey(SubscriberAttributeKt.JSON_NAME_KEY) ? readableMap.getString(SubscriberAttributeKt.JSON_NAME_KEY) : null;
            this.mime = readableMap.hasKey("contentType") ? readableMap.getString("contentType") : str;
            this.increment = Boolean.valueOf(readableMap.hasKey("increment") && readableMap.getBoolean("increment"));
            if (readableMap.hasKey("auto") && readableMap.getBoolean("auto")) {
                z = true;
            }
            this.auto = Boolean.valueOf(z);
            if (readableMap.hasKey(ClientComponent.NamedSchedulers.TIMEOUT)) {
                this.timeout = (long) readableMap.getInt(ClientComponent.NamedSchedulers.TIMEOUT);
            }
        }
    }
}
