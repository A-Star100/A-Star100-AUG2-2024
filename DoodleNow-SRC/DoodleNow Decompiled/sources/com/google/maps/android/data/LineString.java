package com.google.maps.android.data;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class LineString implements Geometry<List<LatLng>> {
    private static final String GEOMETRY_TYPE = "LineString";
    private final List<LatLng> mCoordinates;

    public List<LatLng> getGeometryObject() {
        return this.mCoordinates;
    }

    public String getGeometryType() {
        return GEOMETRY_TYPE;
    }

    public LineString(List<LatLng> list) {
        if (list != null) {
            this.mCoordinates = list;
            return;
        }
        throw new IllegalArgumentException("Coordinates cannot be null");
    }

    public String toString() {
        return "LineString{\n coordinates=" + this.mCoordinates + "\n}\n";
    }
}
