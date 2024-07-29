package com.bleplx.converter;

import com.bleplx.adapter.Service;
import com.bleplx.adapter.utils.UUIDConverter;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

public class ServiceToJsObjectConverter extends JSObjectConverter<Service> {

    private interface Metadata {
        public static final String DEVICE_ID = "deviceID";
        public static final String ID = "id";
        public static final String IS_PRIMARY = "isPrimary";
        public static final String UUID = "uuid";
    }

    public /* bridge */ /* synthetic */ WritableArray toJSCallback(Object obj) {
        return super.toJSCallback(obj);
    }

    public WritableMap toJSObject(Service service) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", service.getId());
        createMap.putString("uuid", UUIDConverter.fromUUID(service.getUuid()));
        createMap.putString("deviceID", service.getDeviceID());
        createMap.putBoolean(Metadata.IS_PRIMARY, service.isPrimary());
        return createMap;
    }
}
