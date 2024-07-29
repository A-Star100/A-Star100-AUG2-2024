package com.google.maps.android.ui;

import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

public class AnimationUtil {
    public static void animateMarkerTo(Marker marker, LatLng latLng) {
        final LatLngInterpolator.Linear linear = new LatLngInterpolator.Linear();
        final LatLng position = marker.getPosition();
        Handler handler = new Handler();
        final long uptimeMillis = SystemClock.uptimeMillis();
        final AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        final Marker marker2 = marker;
        final LatLng latLng2 = latLng;
        final Handler handler2 = handler;
        handler.post(new Runnable() {
            long elapsed;
            float t;
            float v;

            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis;
                this.elapsed = uptimeMillis;
                float f = ((float) uptimeMillis) / 2000.0f;
                this.t = f;
                float interpolation = accelerateDecelerateInterpolator.getInterpolation(f);
                this.v = interpolation;
                marker2.setPosition(linear.interpolate(interpolation, position, latLng2));
                if (this.t < 1.0f) {
                    handler2.postDelayed(this, 16);
                }
            }
        });
    }

    interface LatLngInterpolator {
        LatLng interpolate(float f, LatLng latLng, LatLng latLng2);

        public static class Linear implements LatLngInterpolator {
            public LatLng interpolate(float f, LatLng latLng, LatLng latLng2) {
                double d = (double) f;
                double d2 = ((latLng2.latitude - latLng.latitude) * d) + latLng.latitude;
                double d3 = latLng2.longitude - latLng.longitude;
                if (Math.abs(d3) > 180.0d) {
                    d3 -= Math.signum(d3) * 360.0d;
                }
                return new LatLng(d2, (d3 * d) + latLng.longitude);
            }
        }
    }
}
