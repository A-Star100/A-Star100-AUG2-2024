package com.rnfs;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.media.EncoderProfiles;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Downloader$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ Notification.Builder m(Context context, String str) {
        return new Notification.Builder(context, str);
    }

    public static /* synthetic */ NotificationChannel m(String str, CharSequence charSequence, int i) {
        return new NotificationChannel(str, charSequence, i);
    }

    public static /* synthetic */ Typeface.Builder m(AssetManager assetManager, String str) {
        return new Typeface.Builder(assetManager, str);
    }

    public static /* bridge */ /* synthetic */ EncoderProfiles.VideoProfile m(Object obj) {
        return (EncoderProfiles.VideoProfile) obj;
    }
}
