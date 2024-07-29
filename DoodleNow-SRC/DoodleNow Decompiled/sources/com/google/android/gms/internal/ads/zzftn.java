package com.google.android.gms.internal.ads;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzftn implements SensorEventListener {
    @Nullable
    final zzfth zza = zzftj.zza;

    protected zzftn(String str, String str2) {
        zzftm.zza();
        zzfpk zzfpk = zzfpk.UNKNOWN;
        zzftj.zza();
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        zza(sensorEvent);
    }

    public abstract void zza(SensorEvent sensorEvent);
}
