package com.rnmaps.maps;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.react.bridge.ReadableArray;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.collections.GroundOverlayManager;

public class MapOverlay extends MapFeature implements ImageReadable {
    private float bearing;
    private LatLngBounds bounds;
    private GroundOverlay groundOverlay;
    private GroundOverlayManager.Collection groundOverlayCollection;
    private GroundOverlayOptions groundOverlayOptions;
    private BitmapDescriptor iconBitmapDescriptor;
    private final ImageReader mImageReader;
    private boolean tappable;
    private float transparency;
    private float zIndex;

    public Object getFeature() {
        return this.groundOverlay;
    }

    public void setIconBitmap(Bitmap bitmap) {
    }

    public void setIconBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        this.iconBitmapDescriptor = bitmapDescriptor;
    }

    public MapOverlay(Context context) {
        super(context);
        this.mImageReader = new ImageReader(context, getResources(), this);
    }

    public void setBounds(ReadableArray readableArray) {
        LatLngBounds latLngBounds = new LatLngBounds(new LatLng(readableArray.getArray(0).getDouble(0), readableArray.getArray(0).getDouble(1)), new LatLng(readableArray.getArray(1).getDouble(0), readableArray.getArray(1).getDouble(1)));
        this.bounds = latLngBounds;
        GroundOverlay groundOverlay2 = this.groundOverlay;
        if (groundOverlay2 != null) {
            groundOverlay2.setPositionFromBounds(latLngBounds);
        }
    }

    public void setBearing(float f) {
        this.bearing = f;
        GroundOverlay groundOverlay2 = this.groundOverlay;
        if (groundOverlay2 != null) {
            groundOverlay2.setBearing(f);
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        GroundOverlay groundOverlay2 = this.groundOverlay;
        if (groundOverlay2 != null) {
            groundOverlay2.setZIndex(f);
        }
    }

    public void setTransparency(float f) {
        this.transparency = f;
        GroundOverlay groundOverlay2 = this.groundOverlay;
        if (groundOverlay2 != null) {
            groundOverlay2.setTransparency(f);
        }
    }

    public void setImage(String str) {
        this.mImageReader.setImage(str);
    }

    public void setTappable(boolean z) {
        this.tappable = z;
        GroundOverlay groundOverlay2 = this.groundOverlay;
        if (groundOverlay2 != null) {
            groundOverlay2.setClickable(z);
        }
    }

    public GroundOverlayOptions getGroundOverlayOptions() {
        if (this.groundOverlayOptions == null) {
            this.groundOverlayOptions = createGroundOverlayOptions();
        }
        return this.groundOverlayOptions;
    }

    private GroundOverlayOptions createGroundOverlayOptions() {
        GroundOverlayOptions groundOverlayOptions2 = this.groundOverlayOptions;
        if (groundOverlayOptions2 != null) {
            return groundOverlayOptions2;
        }
        GroundOverlayOptions groundOverlayOptions3 = new GroundOverlayOptions();
        BitmapDescriptor bitmapDescriptor = this.iconBitmapDescriptor;
        if (bitmapDescriptor != null) {
            groundOverlayOptions3.image(bitmapDescriptor);
        } else {
            groundOverlayOptions3.image(BitmapDescriptorFactory.defaultMarker());
            groundOverlayOptions3.visible(false);
        }
        groundOverlayOptions3.positionFromBounds(this.bounds);
        groundOverlayOptions3.zIndex(this.zIndex);
        groundOverlayOptions3.bearing(this.bearing);
        groundOverlayOptions3.transparency(this.transparency);
        return groundOverlayOptions3;
    }

    public void addToMap(Object obj) {
        GroundOverlayManager.Collection collection = (GroundOverlayManager.Collection) obj;
        GroundOverlayOptions groundOverlayOptions2 = getGroundOverlayOptions();
        if (groundOverlayOptions2 != null) {
            GroundOverlay addGroundOverlay = collection.addGroundOverlay(groundOverlayOptions2);
            this.groundOverlay = addGroundOverlay;
            addGroundOverlay.setClickable(this.tappable);
            return;
        }
        this.groundOverlayCollection = collection;
    }

    public void removeFromMap(Object obj) {
        GroundOverlay groundOverlay2 = this.groundOverlay;
        if (groundOverlay2 != null) {
            ((GroundOverlayManager.Collection) obj).remove(groundOverlay2);
            this.groundOverlay = null;
            this.groundOverlayOptions = null;
        }
        this.groundOverlayCollection = null;
    }

    public void update() {
        GroundOverlay groundOverlay2 = getGroundOverlay();
        this.groundOverlay = groundOverlay2;
        if (groundOverlay2 != null) {
            groundOverlay2.setVisible(true);
            this.groundOverlay.setImage(this.iconBitmapDescriptor);
            this.groundOverlay.setTransparency(this.transparency);
            this.groundOverlay.setClickable(this.tappable);
        }
    }

    private GroundOverlay getGroundOverlay() {
        GroundOverlayOptions groundOverlayOptions2;
        GroundOverlay groundOverlay2 = this.groundOverlay;
        if (groundOverlay2 != null) {
            return groundOverlay2;
        }
        if (this.groundOverlayCollection == null || (groundOverlayOptions2 = getGroundOverlayOptions()) == null) {
            return null;
        }
        return this.groundOverlayCollection.addGroundOverlay(groundOverlayOptions2);
    }
}
