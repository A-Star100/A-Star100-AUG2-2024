package com.rnmaps.maps;

import android.graphics.Bitmap;
import com.google.android.gms.maps.model.BitmapDescriptor;

public interface ImageReadable {
    void setIconBitmap(Bitmap bitmap);

    void setIconBitmapDescriptor(BitmapDescriptor bitmapDescriptor);

    void update();
}
