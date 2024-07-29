package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.react.devsupport.DevInternalSettings;

public final class PerftestDevSupportManager extends DisabledDevSupportManager {
    private final DevServerHelper mDevServerHelper;
    private final DevInternalSettings mDevSettings;

    public DevInternalSettings getDevSettings() {
        return this.mDevSettings;
    }

    public PerftestDevSupportManager(Context context) {
        DevInternalSettings devInternalSettings = new DevInternalSettings(context, new DevInternalSettings.Listener() {
            public void onInternalSettingsChanged() {
            }
        });
        this.mDevSettings = devInternalSettings;
        this.mDevServerHelper = new DevServerHelper(devInternalSettings, context.getPackageName(), devInternalSettings.getPackagerConnectionSettings());
    }

    public void startInspector() {
        this.mDevServerHelper.openInspectorConnection();
    }

    public void stopInspector() {
        this.mDevServerHelper.closeInspectorConnection();
    }
}
