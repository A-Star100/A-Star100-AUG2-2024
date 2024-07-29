package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.graphics.Rect;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.util.HalfKt$$ExternalSyntheticApiModelOutline0;
import com.amazon.a.a.o.b.f;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.material.chip.Chip$$ExternalSyntheticApiModelOutline0;
import java.util.Locale;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzy extends zzw {
    static final /* synthetic */ WindowInsets zzl(Activity activity, View view, WindowInsets windowInsets) {
        if (zzu.zzo().zzi().zzl() == null) {
            DisplayCutout m = HalfKt$$ExternalSyntheticApiModelOutline0.m(windowInsets);
            String str = "";
            if (m != null) {
                zzg zzi = zzu.zzo().zzi();
                for (Rect rect : Chip$$ExternalSyntheticApiModelOutline0.m(m)) {
                    String format = String.format(Locale.US, "%d,%d,%d,%d", new Object[]{Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom)});
                    if (!TextUtils.isEmpty(str)) {
                        str = str.concat(f.c);
                    }
                    str = str.concat(String.valueOf(format));
                }
                zzi.zzB(str);
            } else {
                zzu.zzo().zzi().zzB(str);
            }
        }
        zzn(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }

    private static final void zzn(boolean z, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int m = attributes.layoutInDisplayCutoutMode;
        int i = 1;
        if (true != z) {
            i = 2;
        }
        if (i != m) {
            attributes.layoutInDisplayCutoutMode = i;
            window.setAttributes(attributes);
        }
    }

    public final int zzj(AudioManager audioManager) {
        return audioManager.getStreamMinVolume(3);
    }

    public final void zzk(Activity activity) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzbf)).booleanValue() && zzu.zzo().zzi().zzl() == null && !activity.isInMultiWindowMode()) {
            zzn(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new zzx(this, activity));
        }
    }
}
