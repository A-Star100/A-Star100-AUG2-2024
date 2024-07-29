package com.google.android.gms.maps.model;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public class AdvancedMarkerOptions extends MarkerOptions {

    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
    public @interface CollisionBehavior {
        public static final int OPTIONAL_AND_HIDES_LOWER_PRIORITY = 2;
        public static final int REQUIRED = 0;
        public static final int REQUIRED_AND_HIDES_OPTIONAL = 1;
    }

    public AdvancedMarkerOptions alpha(float f) {
        super.alpha(f);
        return this;
    }

    public AdvancedMarkerOptions anchor(float f, float f2) {
        super.anchor(f, f2);
        return this;
    }

    public AdvancedMarkerOptions collisionBehavior(@CollisionBehavior int i) {
        super.zzd(i);
        return this;
    }

    public AdvancedMarkerOptions contentDescription(String str) {
        super.contentDescription(str);
        return this;
    }

    public AdvancedMarkerOptions draggable(boolean z) {
        super.draggable(z);
        return this;
    }

    public AdvancedMarkerOptions flat(boolean z) {
        super.flat(z);
        return this;
    }

    public int getCollisionBehavior() {
        return super.zza();
    }

    public View getIconView() {
        return super.zzc();
    }

    public AdvancedMarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        super.icon(bitmapDescriptor);
        return this;
    }

    public AdvancedMarkerOptions iconView(View view) {
        zze(view);
        return this;
    }

    public AdvancedMarkerOptions infoWindowAnchor(float f, float f2) {
        super.infoWindowAnchor(f, f2);
        return this;
    }

    public AdvancedMarkerOptions position(LatLng latLng) {
        super.position(latLng);
        return this;
    }

    public AdvancedMarkerOptions rotation(float f) {
        super.rotation(f);
        return this;
    }

    public AdvancedMarkerOptions snippet(String str) {
        super.snippet(str);
        return this;
    }

    public AdvancedMarkerOptions title(String str) {
        super.title(str);
        return this;
    }

    public AdvancedMarkerOptions visible(boolean z) {
        super.visible(z);
        return this;
    }

    public AdvancedMarkerOptions zIndex(float f) {
        super.zIndex(f);
        return this;
    }
}
