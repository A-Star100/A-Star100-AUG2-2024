package com.polidea.rxandroidble2.internal.util;

import bleshadow.dagger.internal.Factory;

public final class ScanRecordParser_Factory implements Factory<ScanRecordParser> {
    public ScanRecordParser get() {
        return newInstance();
    }

    public static ScanRecordParser_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ScanRecordParser newInstance() {
        return new ScanRecordParser();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ScanRecordParser_Factory INSTANCE = new ScanRecordParser_Factory();

        private InstanceHolder() {
        }
    }
}
