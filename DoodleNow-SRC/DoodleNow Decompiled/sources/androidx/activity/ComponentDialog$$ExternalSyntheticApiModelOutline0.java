package androidx.activity;

import android.app.NotificationChannel;
import android.app.job.JobWorkItem;
import android.app.slice.Slice;
import android.app.slice.SliceSpec;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.hardware.camera2.params.OutputConfiguration;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.util.Size;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ComponentDialog$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ NotificationChannel m(String str, CharSequence charSequence, int i) {
        return new NotificationChannel(str, charSequence, i);
    }

    public static /* synthetic */ JobWorkItem m(Intent intent) {
        return new JobWorkItem(intent);
    }

    public static /* synthetic */ Slice.Builder m(Uri uri, SliceSpec sliceSpec) {
        return new Slice.Builder(uri, sliceSpec);
    }

    public static /* synthetic */ SliceSpec m(String str, int i) {
        return new SliceSpec(str, i);
    }

    public static /* synthetic */ ShortcutInfo.Builder m(Context context, String str) {
        return new ShortcutInfo.Builder(context, str);
    }

    public static /* synthetic */ OutputConfiguration m(Size size, Class cls) {
        return new OutputConfiguration(size, cls);
    }

    public static /* synthetic */ MediaSession m(Context context, String str, Bundle bundle) {
        return new MediaSession(context, str, bundle);
    }
}
